package com.bytedance.android.shopping.commentv3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.legacy.AbsFragment;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcDefaultTemplateProvider;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.c;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.audio.StopReason;
import com.bytedance.android.shopping.commentv3.audio.b0;
import com.bytedance.android.shopping.commentv3.audio.f;
import com.bytedance.android.shopping.commentv3.audio.h;
import com.bytedance.android.shopping.commentv3.audio.p;
import com.bytedance.android.shopping.commentv3.audio.q;
import com.bytedance.android.shopping.commentv3.audio.z;
import com.bytedance.android.shopping.commentv3.base.BaseCommentLogic;
import com.bytedance.android.shopping.commentv3.base.CommentApiCenter;
import com.bytedance.android.shopping.commentv3.data.CommentCachePool;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.bytedance.android.shopping.commentv3.data.MultiPicMode;
import com.bytedance.android.shopping.commentv3.data.b;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentPageEvents;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.AlertActionEvent;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.AudioControlEvent;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.EnterBigPicEvent;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.SliceUpdateEvent;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.e;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.g;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.k;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.l;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.m;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.n;
import com.bytedance.android.shopping.commentv3.uitree.root.CommentRootUI;
import com.bytedance.android.shopping.commentv3.utils.CommentPreloadHelper;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import mc3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/CommentFragment;", "Lcom/bytedance/android/ec/core/legacy/AbsFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentFragment extends AbsFragment {
    public final b f;
    public CommentParams g;
    public SlcRenderContext h;
    public c i;
    public CommentCachePool j;
    public h k;
    public Function1<? super Number, Integer> l;
    public Function1<? super Number, Float> m;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        dm.a.a("CommentFragment_v3").i("onDestroyView");
        f r0 = this.f.c;
        if (r0 == null) goto L5;
        r0.c(StopReason.PAGE_DESTROY);
    L5:
        this.f.c = null;
        h r1 = this.k;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.k = null;
        super.onDestroyView();
    }

    public final void onPause() {
        gc3.a r0 = this.f.d;
        if (r0 == null) goto L12;
        r0.b = false;
        if (r0.d == false) goto L12;
        r0.d = false;
        CommentPageEvents r1 = r0.a;
        if (r1 == null) goto L10;
        List<Map<String, Object>> r2 = r1.getOnDisappear();
    L11:
        r0.a(r2, null);
        goto L12
    L10:
        r2 = null;
    L12:
        super.onPause();
    }

    public CommentFragment() {
        this.f = new b();
    }

    public final void onDestroy() {
        super.onDestroy();
        dm.a.a("CommentFragment_v3").i("onDestroy");
        f r0 = this.f.c;
        if (r0 == null) goto L5;
        r0.c(StopReason.PAGE_DESTROY);
    L5:
        this.f.c = null;
        h r1 = this.k;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.k = null;
        SlcRenderContext r2 = this.h;
        if (r2 == null) goto L11;
        r2.d();
    L11:
        fc3.a r3 = this.f.b;
        if (r3 == null) goto L16;
        EventChain r4 = r3.c;
        if (r4 == null) goto L16;
        r4.b();
    L16:
        c r5 = this.i;
        if (r5 == null) goto L19;
        r5.release();
    L19:
        SliceUpdateEvent.e.getClass();
        ((LinkedHashMap) SliceUpdateEvent.d).clear();
        Lazy r6 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L23;
        TrackCatcher.b("watch_comment");
        return;
    }

    public final void onResume() {
        super.onResume();
        gc3.a r0 = this.f.d;
        if (r0 == null) goto L6;
        r0.b = true;
        r0.b();
        return;
    }

    public final void S90(SlcRenderContext r5) {
        j r0 = (j) CollectionsKt.getOrNull(ec3.b.b, 0);
        if (r0 == null) goto L6;
        String r2 = r0.c();
        if (r2 == null) goto L6;
    L7:
        if (r0 == null) goto L10;
        String r1 = r0.a();
        if (r1 == null) goto L10;
    L11:
        i r3 = new i(r2, r1, "");
        KProperty[] r4 = SlcRenderContext.n0;
        final r r6 = r5.c(r3, null);
        this.l = new CommentFragment$initSlcDimension$1(r6);
        this.m = new CommentFragment$initSlcDimension$2(this);
        return;
    L10:
        r1 = "";
    L6:
        r2 = "";
        goto L7
    }

    public final void onViewCreated(View r16, Bundle r17) {
        Intrinsics.checkNotNullParameter(r16, FreqActions.ACTION_VIEW);
        super.onViewCreated(r16, r17);
        dm.a.a("CommentFragment_v3").i("onViewCreated");
        CommentPreloadHelper.a();
        Bundle r0 = getArguments();
        Object r11 = null;
        if (r0 == null) goto L5;
        Object r1 = r0.get("param_key");
    L7:
        if ((r1 instanceof CommentParams) == true) goto L9;
        r1 = null;
    L9:
        CommentParams r2 = (CommentParams) r1;
        this.g = r2;
        if (r2 == null) goto L12;
        TrackerProvider.a r3 = TrackerProvider.Companion;
        Context r4 = requireContext();
        int r5 = t53.a.b;
        t53.a r6 = t53.a.a.a(r2);
        r3.getClass();
        TrackerProvider.a.a(r4, r6);
    L12:
        b r7 = this.f;
        CommentParams r8 = this.g;
        r7.a = r8;
        int r9 = 0;
        if (r8 == null) goto L19;
        Map r10 = r8.getExtraParams();
        if (r10 == null) goto L19;
        if (nc3.a.b(r10, "is_pic_mode", 0) != MultiPicMode.PIC.getMode()) goto L19;
        boolean r12 = true;
    L20:
        d r13 = r7.e;
        if (r12 == false) goto L23;
        MultiPicMode r14 = MultiPicMode.PIC;
    L24:
        r13.a(r14);
        b r15 = this.f;
        CommentCachePool r18 = this.j;
        CommentDataCenter r19 = r15.h;
        if (r18 == null) goto L27;
        r19.q = r18;
    L28:
        CommentParams r20 = this.g;
        if (r20 != null) goto L31;
    L32:
        FragmentActivity r21 = getActivity();
        if (r21 == null) goto L119;
        BtmSDK r22 = BtmSDK.INSTANCE;
        CommentParams r23 = this.g;
        if (r23 == null) goto L37;
        String r24 = r23.getSourceBtmToken();
    L38:
        r22.registerBtmPageOnCreate(r21, "a1.b43005", r24);
        goto L119
    L37:
        r24 = null;
    L119:
        CommentPreloadHelper.b(requireContext());     // Catch: Exception -> L45
        String r25 = "CommentFragment_v3_" + hashCode();     // Catch: Exception -> L45
        SlcGeckoTemplateMgr.l.getClass();     // Catch: Exception -> L45
        c r26 = SlcGeckoTemplateMgr.e(r25, "ec_comment");     // Catch: Exception -> L45
        Context r27 = requireContext();     // Catch: Exception -> L45
        com.bytedance.android.ecom.arch.slice.expr.b r28 = r26.c();     // Catch: Exception -> L45
        if (r28 != null) goto L43;
        r28 = new com.bytedance.android.ecom.arch.slice.expr.b(null);     // Catch: Exception -> L45
    L43:
        SlcRenderContext r29 = new SlcRenderContext(r27, "ec_comment", new SlcExprContext(r28));     // Catch: Exception -> L45
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();     // Catch: Exception -> L45
        r29.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(390.0f, 1.0f, 1.0f);     // Catch: Exception -> L45
        r29.a0 = new SlcDefaultTemplateProvider(r26);     // Catch: Exception -> L45
        r29.g = false;     // Catch: Exception -> L45
        r29.j = true;     // Catch: Exception -> L45
        r26.b(r29);     // Catch: Exception -> L45
        this.i = r26;     // Catch: Exception -> L45
        this.h = r29;     // Catch: Exception -> L45
        S90(r29);     // Catch: Exception -> L45
    L47:
        ViewGroup.LayoutParams r30 = r16.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L50;
        r30 = null;
    L50:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L56;
        CommentParams r32 = this.g;
        if (r32 == null) goto L55;
        r9 = r32.getMarginBottom();
    L55:
        r31.bottomMargin = r9;
        r16.setLayoutParams(r31);
    L56:
        CommentApiCenter r33 = new CommentApiCenter();
        CommentParams r34 = this.g;
        if (r34 == null) goto L59;
        ic3.d r35 = new ic3.d(r34, this.f);
    L60:
        EventChain r110 = qg3.a.a(requireContext(), "CommentFragment_v3", new com.bytedance.android.shopping.commentv3.event_chain.b(requireContext(), PageFinder.via(this), null), new com.bytedance.kmp.ec.yata.common.init.c());
        r110.g(new AlertActionEvent(requireContext()));
        r110.g(new AudioControlEvent(this.f));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.b(this.f));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.c(requireContext(), this.f));
        r110.g(new EnterBigPicEvent(requireContext(), this.f, this));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.d(requireContext(), this.f));
        r110.g(new e(requireContext(), this.f));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.f(requireContext(), this.f));
        r110.g(new g(requireContext(), this.f));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.h(requireContext(), this.f));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.i(requireContext(), this.f));
        r110.g(new com.bytedance.android.shopping.commentv3.event_chain.costom_event.j(requireContext(), this.f));
        r110.g(new k(requireContext(), this.f));
        r110.g(new SliceUpdateEvent(requireContext(), this.f));
        r110.g(new l(requireContext(), this.f));
        r110.g(new m(requireContext(), this.f));
        r110.g(new n(requireContext(), this.f, r35));
        Context r36 = requireContext();
        CommentParams r37 = this.g;
        b r38 = this.f;
        Function1<? super Number, Integer> r39 = this.l;
        if (r39 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("slcDp");
    L63:
        Function1<? super Number, Float> r40 = this.m;
        if (r40 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("slcSp");
    L66:
        fc3.a r111 = new fc3.a(new fc3.a.C0195a(r36, r37, r38, this, r39, r40, r35), r110);
        b r41 = this.f;
        r41.b = r111;
        r41.d = new gc3.a(new CommentFragment$bindRootUI$1(this));
        f r42 = this.f.c;
        if (r42 == null) goto L69;
        r42.c(StopReason.PAGE_DESTROY);
    L69:
        h r43 = this.k;
        if (r43 == null) goto L72;
        r43.release();
    L72:
        this.k = null;
        b r44 = this.f;
        b0 r45 = new b0(requireContext());
        q r46 = new q();
        z r47 = new z(requireContext());
        p r48 = new p(new CommentFragment$bindRootUI$2(this));
        Map<String, WeakReference<com.bytedance.android.shopping.commentv3.audio.i>> r49 = com.bytedance.android.shopping.commentv3.audio.j.a;
        CommentParams r50 = this.g;
        if (r50 == null) goto L75;
        String r51 = r50.getPdpSessionId();
    L76:
        if (r51 != null) goto L78;
        com.bytedance.android.shopping.commentv3.audio.i r112 = null;
    L84:
        if (r112 != null) goto L86;
        h r52 = null;
    L87:
        r44.c = new com.bytedance.android.shopping.commentv3.audio.n(r45, r46, r47, r48, r52);
        b r53 = this.f;
        CommentDataCenter r54 = r53.h;
        CommentCachePool r55 = r54.q;
        if (r55 == null) goto L90;
        r55.g = r54.w.b;
    L90:
        com.bytedance.android.shopping.commentv3.base.c r56 = new com.bytedance.android.shopping.commentv3.base.c(r33, this, this.h, r111, r53);
        CommentRootUI r57 = new CommentRootUI();
        Lifecycle r58 = getLifecycle();
        Intrinsics.checkNotNullParameter(r58, "lifecycle");
        r57.i = r58;
        r57.c = r16;
        r57.g = r56;
        Fragment r59 = r56.b;
        if (r59 == null) goto L93;
        Context r60 = r59.getContext();
    L94:
        r57.d = r60;
        com.bytedance.android.shopping.commentv3.base.c r61 = r57.g;
        if (r61 == null) goto L97;
        b r62 = r61.e;
    L98:
        r57.e = r62;
        Object r63 = r57.a;
        if ((r63 instanceof BaseCommentLogic) == false) goto L102;
        r11 = r63;
    L102:
        BaseCommentLogic r113 = (BaseCommentLogic) r11;
        if (r113 == null) goto L105;
        r113.c = r56;
        r113.d = r56.e;
    L105:
        if (r61 == null) goto L112;
        CommentApiCenter r64 = r61.a;
        if (r64 == null) goto L112;
        Intrinsics.checkNotNullParameter(r57, "api");
        if (r64.a().contains(r57) == true) goto L112;
        r64.a().add(r57);
    L112:
        getLifecycle().addObserver(r57);
        int r65 = ECSdk.a;
        IECFeedbackService r66 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r66 == null) goto L115;
        r66.registerScreenCapture(getContext(), this);
    L115:
        Lazy r67 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L121;
        TrackCatcher.a("watch_comment");
        return;
    L121:
        return;
    L97:
        r62 = null;
        goto L98
    L93:
        r60 = null;
        goto L94
    L86:
        h r68 = r112.p1(new CommentFragment$initAudioPlaybackStateObserver$1(this));
        this.k = r68;
        r52 = r68;
        goto L87
    L78:
        Map<String, WeakReference<com.bytedance.android.shopping.commentv3.audio.i>> r69 = com.bytedance.android.shopping.commentv3.audio.j.a;
        WeakReference r114 = (WeakReference) ((LinkedHashMap) r69).get(r51);
        if (r114 == null) goto L81;
        r112 = (com.bytedance.android.shopping.commentv3.audio.i) r114.get();
    L82:
        if (r112 != null) goto L84;
        r69.remove(r51);
        goto L84
    L81:
        r112 = null;
        goto L82
    L75:
        r51 = null;
        goto L76
    L59:
        r35 = null;
    L45:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("CommentFragment_v3").b("initSlcContext", e);
        goto L47
    L31:
        if (r20.isFromProductDetail() == true) goto L119;
    L27:
        r19.getClass();
        r19.q = new CommentCachePool();
        goto L28
    L23:
        r14 = MultiPicMode.LIST;
    L19:
        r12 = false;
        goto L20
    L5:
        r1 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        dm.a.a("CommentFragment_v3").i("onCreateView");
        return th.a.d(requireContext(), 2131560405, r3, 4);
    }
}
