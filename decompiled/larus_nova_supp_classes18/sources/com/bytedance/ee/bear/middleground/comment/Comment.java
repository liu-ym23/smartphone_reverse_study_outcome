package com.bytedance.ee.bear.middleground.comment;

import android.app.Dialog;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.card.FloatCardComment;
import com.bytedance.ee.bear.middleground.comment.card.HalfScreenCardComment;
import com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.control.CommentFunction;
import com.bytedance.ee.bear.middleground.comment.control.r;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.u;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentBuilder;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentArea;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.SyncReactionResultJsData;
import com.bytedance.ee.bear.middleground.comment.export.v;
import com.bytedance.ee.bear.middleground.comment.extension.addins.CardAdapterAddin;
import com.bytedance.ee.bear.middleground.comment.extension.addins.a0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.c0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.d0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.e0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.i0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.j0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.l0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.p0;
import com.bytedance.ee.bear.middleground.comment.extension.events.ReactionCacheActionType;
import com.bytedance.ee.bear.middleground.comment.input.t1;
import com.bytedance.ee.bear.middleground.comment.performance.PerfProvider;
import com.bytedance.ee.bear.middleground.comment.permission.AskOwnerViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.CommentRootView;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.vfs.VFSPath;
import ef5.b0;
import ef5.w;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Comment implements z, com.bytedance.ee.bear.middleground.comment.export.h {
    public static final /* synthetic */ int z0 = 0;
    public final Function1<? super bo4.a, Unit> A;
    public Function3<? super String, ? super String, ? super MentionUserState, Boolean> B;
    public cf5.a C;
    public int D;
    public final sa5.b E;
    public com.bytedance.ee.bear.middleground.comment.export.bean.a F;
    public com.bytedance.ee.bear.middleground.comment.export.bean.a G;
    public final Function1<String, Unit> H;
    public final Function1<ScrollCommentBean, Unit> I;
    public Function0<Boolean> J;
    public Function1<? super CommentInputRequest, Unit> K;
    public Function2<? super String, ? super Action, Unit> L;
    public final Function1<? super String, Unit> M;
    public final Function1<? super CommentInputRequest, Unit> N;
    public List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> O;
    public final Function1<? super Integer, Unit> P;
    public final Function0<Unit> Q;
    public List<Function2<Integer, Boolean, Unit>> R;
    public List<Function2<Integer, Boolean, Unit>> S;
    public Function1<? super String, Boolean> T;
    public Function1<? super String, Unit> U;
    public Function1<? super String, Unit> V;
    public Function2<? super CharSequence, ? super CommentInputRequest, Unit> W;
    public Function3<? super String, ? super CommentInputRequest, ? super Boolean, Unit> X;
    public Function1<? super Boolean, Unit> Y;
    public Function1<? super Boolean, Unit> Z;
    public final FragmentActivity a;
    public Function1<? super Integer, Unit> a0;
    public final FrameLayout b;
    public final Function2<? super String, ? super String, Unit> b0;
    public final FrameLayout c;
    public Function1<? super Integer, Unit> c0;
    public final FrameLayout d;
    public Function1<? super String, Boolean> d0;
    public final FrameLayout e;
    public Function4<? super String, ? super String, ? super Integer, ? super Integer, Unit> e0;
    public String f;
    public final Function0<Unit> f0;
    public final String g;
    public Function1<? super String, Unit> g0;
    public sbb.e h;
    public Function1<? super String, Unit> h0;
    public final pcb.a i;
    public Function1<? super Boolean, Unit> i0;
    public final CommentStyle j;
    public Function1<? super Boolean, Unit> j0;
    public final Function1<? super List<String>, Unit> k;
    public Function1<? super String, Unit> k0;
    public final com.bytedance.ee.bear.middleground.comment.export.m l;
    public Function0<Unit> l0;
    public final Function0<Boolean> m;
    public Function1<? super Boolean, Unit> m0;
    public Function0<Pair<String, String>> n;
    public Function1<? super Boolean, Unit> n0;
    public p1 o;
    public Function2<? super String, ? super String, Unit> o0;
    public kf5.b p;
    public final Function2<? super CommentBottomPopupData, ? super bf5.b, Unit> p0;
    public final CompositeDisposable q;
    public final Function1<? super String, Unit> q0;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p r;
    public final Function1<? super View, Unit> r0;
    public final Comment$inputCommentFunction$1 s;
    public Function1<? super CommentInputRequest, Unit> s0;
    public final com.bytedance.ee.bear.rn.g t;
    public Function0<Unit> t0;
    public final com.bytedance.ee.bear.rn.k u;
    public Function4<? super String, ? super Integer, ? super String, ? super Integer, Unit> u0;
    public final com.bytedance.ee.bear.middleground.comment.control.s v;
    public final Function6<? super String, ? super Integer, ? super String, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, ? super Integer, ? super CommentBean, Unit> v0;
    public final t w;
    public Function2<? super String, ? super Map<String, ? extends Object>, Unit> w0;
    public final Comment x;
    public Function1<? super String, Unit> x0;
    public final y y;
    public Function3<? super String, ? super float[], ? super Matrix, Unit> y0;
    public Function1<? super Boolean, Unit> z;

    public static final class a {
        @JvmStatic
        public static Comment a(CommentBuilder r59) {
            Intrinsics.checkNotNullParameter(r59, "builder");
            FragmentActivity r3 = r59.getActivity();
            FrameLayout r2 = r59.b;
            pcb.a r22 = pcb.a.a.b(r3);
            FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout r7 = (FrameLayout) r2.findViewById(2131367421);
            if (r7 != null) goto L5;
            r7 = new FrameLayout(r3);
            r7.setId(2131367421);
            r2.addView(r7, r4);
        L6:
            FrameLayout r9 = (FrameLayout) r2.findViewById(2131367318);
            if (r9 != null) goto L9;
            CommentRootView r10 = new CommentRootView(r3, null);
            r10.setLogTag("Comment#CommentCardContainer");
            r10.setId(2131367318);
            r2.addView(r10, r4);
            FrameLayout r11 = r10;
        L10:
            FrameLayout r6 = r59.E;
            if (r6 == null) goto L19;
            FrameLayout r8 = (FrameLayout) r6.findViewById(2131367308);
            if (r8 != null) goto L17;
            CommentRootView r12 = new CommentRootView(r3, null);
            r12.setLogTag("Comment#CommentAsideContainer");
            r12.setId(2131367308);
            FrameLayout r13 = r59.E;
            FrameLayout r14 = r12;
            if (r13 == null) goto L18;
            r13.addView(r12, new ViewGroup.LayoutParams(-2, -1));
            r14 = r12;
        L18:
            FrameLayout r5 = r14;
        L21:
            if (r2.getParent() != null) goto L23;
            iu5.d.a("Comment#Comment", new IllegalStateException("viewParent " + r2.isAttachedToWindow() + ' ' + r2.getParent()));
        L24:
            FrameLayout r15 = (FrameLayout) r2.findViewById(2131367367);
            if (r15 != null) goto L27;
            r15 = new FrameLayout(r3);
            r15.setId(2131367367);
            r2.addView(r15, r4);
        L27:
            sbb.e r16 = r59.f;
            if (r16 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("mPageType");
            r16 = null;
        L32:
            if (Intrinsics.areEqual(r16, sbb.e.i) == false) goto L57;
            int r17 = com.bytedance.ee.bear.middleground.comment.bitablediscuss.h.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("base.record.comment.enable") == false) goto L57;
            int r18 = BitableComment.B0;
            Intrinsics.checkNotNullParameter(r59, "builder");
            Intrinsics.checkNotNullParameter(r11, "commentContainer");
            Intrinsics.checkNotNullParameter(r15, "commentImageViewerContainer");
            Intrinsics.checkNotNullParameter(r7, "reactionAnimationContainer");
            FragmentActivity r24 = r59.getActivity();
            pcb.a r42 = pcb.a.a.b(r24);
            boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.bitable.comment_memory_leak_fix_enable");
            FragmentManager r19 = r59.c;
            String r20 = r59.d;
            if (r20 == null) goto L38;
            String r29 = r20;
        L39:
            String r21 = r59.e;
            if (r21 == null) goto L42;
            String r30 = r21;
        L43:
            sbb.e r23 = r59.f;
            if (r23 == null) goto L46;
            sbb.e r31 = r23;
        L47:
            boolean r25 = r59.g;
            String r26 = r59.h;
            long r110 = r59.i;
            long r111 = r59.j;
            com.bytedance.ee.bear.middleground.comment.export.o r112 = r59.k;
            if (r112 == null) goto L50;
            com.bytedance.ee.bear.middleground.comment.export.o r38 = r112;
        L51:
            boolean r27 = r59.l;
            boolean r113 = r59.m;
            boolean r114 = r59.n;
            Intrinsics.checkNotNull(r42);
            CommentStyle r115 = r59.o;
            boolean r116 = r59.p;
            boolean r117 = r59.q;
            v r118 = r59.r;
            boolean r119 = r59.s;
            com.bytedance.ee.bear.middleground.comment.export.g r120 = r59.t;
            Function1<? super List<String>, Unit> r121 = r59.u;
            com.bytedance.ee.bear.middleground.comment.export.m r122 = r59.v;
            boolean r123 = r59.w;
            com.bytedance.ee.bear.middleground.comment.export.t r124 = r59.x;
            bf5.a r125 = r59.y;
            boolean r126 = r59.z;
            if (r1 == false) goto L54;
            Fragment r55 = r59.D;
        L56:
            return new BitableComment(r24, r11, r15, r7, r19, r29, r30, r31, r25, r26, r110, r111, r38, r27, r113, r114, r42, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r55, r59.A, r59.F, r59.B);
        L54:
            r55 = null;
            goto L56
        L50:
            Intrinsics.throwUninitializedPropertyAccessException("mPermission");
            r38 = null;
            goto L51
        L46:
            Intrinsics.throwUninitializedPropertyAccessException("mPageType");
            r31 = null;
            goto L47
        L42:
            Intrinsics.throwUninitializedPropertyAccessException("mDocUrl");
            r30 = null;
            goto L43
        L38:
            Intrinsics.throwUninitializedPropertyAccessException("mToken");
            r29 = null;
        L57:
            FragmentManager r127 = r59.c;
            String r28 = r59.d;
            if (r28 == null) goto L60;
            String r128 = r28;
        L61:
            String r32 = r59.e;
            if (r32 == null) goto L64;
            String r129 = r32;
        L65:
            sbb.e r33 = r59.f;
            if (r33 == null) goto L68;
            sbb.e r130 = r33;
        L69:
            boolean r131 = r59.g;
            String r132 = r59.h;
            long r133 = r59.i;
            long r134 = r59.j;
            com.bytedance.ee.bear.middleground.comment.export.o r34 = r59.k;
            if (r34 == null) goto L72;
            com.bytedance.ee.bear.middleground.comment.export.o r43 = r34;
        L73:
            boolean r35 = r59.l;
            boolean r36 = r59.m;
            boolean r37 = r59.n;
            Intrinsics.checkNotNull(r22);
            Comment r39 = new Comment(r3, r11, r5, r15, r7, r127, r128, r129, r130, r131, r132, r133, r134, r43, r35, r36, r37, r22, r59.o, r59.p, r59.q, r59.r, r59.s, r59.t, r59.u, r59.v, r59.w, r59.x, r59.y, r59.z, false, r59.D, r59.A, r59.F, r59.G);
            r39.n = null;
            r39.y0 = r59.C;
            return r39;
        L72:
            Intrinsics.throwUninitializedPropertyAccessException("mPermission");
            r43 = null;
            goto L73
        L68:
            Intrinsics.throwUninitializedPropertyAccessException("mPageType");
            r130 = null;
            goto L69
        L64:
            Intrinsics.throwUninitializedPropertyAccessException("mDocUrl");
            r129 = null;
            goto L65
        L60:
            Intrinsics.throwUninitializedPropertyAccessException("mToken");
            r128 = null;
            goto L61
        L23:
            tt5.a.h("Comment#Comment", "viewParent is AttachedToWindow ");
            goto L24
        L17:
            tt5.a.h("Comment#Comment", "CommentAsideContainer has be added");
            r14 = r8;
            goto L18
        L19:
            r5 = null;
            goto L21
        L9:
            tt5.a.h("Comment#Comment", "CommentCardContainer has be added");
            r11 = r9;
            goto L10
        L5:
            tt5.a.h("Comment#Comment", "ReactionAnimationContainer has be added");
            goto L6
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommentStyle.values().length];
            r0[CommentStyle.HALF_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CommentStyle.ASIDE_IN_PICTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CommentStyle.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CommentStyle.ASIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements gf5.d {
        public final /* synthetic */ Comment a;

        public c(Comment r1) {
            this.a = r1;
        }

        @Override // gf5.d
        public final void a(gf5.c r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            cf5.a r1 = this.a.C;
            if (r1 == null) goto L9;
            Intrinsics.checkNotNullParameter(r3, "action");
            if (r1.d == false) goto L7;
            tt5.a.k("Comment#CommentAddinHost", "can not dispatch action after host is destroyed!");
            return;
        L7:
            r1.b.a(r3);
            return;
        }
    }

    public static final class d extends bb5.i {
        public final /* synthetic */ Comment a;

        public d(Comment r1) {
            this.a = r1;
        }

        public final void a(Dialog r4) {
            Intrinsics.checkNotNullParameter(r4, "dialog");
            Comment r0 = this.a;
            if (r0.r.V == false) goto L14;
            p1 r1 = r0.o;
            boolean r2 = false;
            if (r1 != null) goto L7;
        L9:
            if (r2 == false) goto L15;
            Window r5 = r4.getWindow();
            if (r5 == null) goto L16;
            WindowManager.LayoutParams r3 = r5.getAttributes();
            r3.type = 2;
            r5.setAttributes(r3);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            if (r1.isShowing() != true) goto L9;
            r2 = true;
            goto L9
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CommentBean.CommentDetail.ExtraEntity.CommentImageEntity a;
        public final /* synthetic */ CommentBean b;
        public final /* synthetic */ Comment c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ CommentBean.CommentDetail g;

        public e(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r1, CommentBean r2, Comment r3, boolean r4, String r5, String r6, CommentBean.CommentDetail r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void accept(Object r11) {
            Boolean r12 = (Boolean) r11;
            tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: copyImgFile success, imageEntity = " + this.a);
            final CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r13 = this.a;
            if (this.b.getIs_whole() != 1) goto L5;
            tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: whole + web, forward to web");
            Comment.v1(this.d, this.c, this.e, this.f, this.b, r13);
            return;
        L5:
            CommentInputRequest r0 = new CommentInputRequest();
            r0.comment_id = this.e;
            r0.is_whole = false;
            r0.isDrive = false;
            CommentBean.CommentDetail.ExtraEntity r1 = new CommentBean.CommentDetail.ExtraEntity();
            r1.setImage_list(CollectionsKt.listOf(r13));
            r0.extra = r1;
            final Comment r2 = this.c;
            final String r3 = this.e;
            final CommentBean.CommentDetail r4 = this.g;
            final boolean r6 = this.d;
            final String r7 = this.f;
            final CommentBean r8 = this.b;
            Function0<Unit> r9 = new Comment$insertReplyFromAreaMark$disposable$1$callback$1(r2, r3, r4, r13, r6, r7, r8);
            Comment r14 = this.c;
            r14.E(r0, new com.bytedance.ee.bear.middleground.comment.b(r9, r14));
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#Comment", "insertReplyFromAreaMark: copyImgFile failed", (Throwable) r4, false);
        }
    }

    public static final class g implements com.bytedance.ee.bear.rn.k.a {
        public final /* synthetic */ Comment a;

        public g(Comment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.rn.k.a
        public final void e(String r2) {
            this.a.y.e(r2);
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ Comment a;
        public final /* synthetic */ List<CommentBean> b;

        public h(Comment r1, List<CommentBean> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.w.L(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ Comment a;
        public final /* synthetic */ List<CommentBean> b;

        public i(Comment r1, List<CommentBean> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.w.J(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final void I0() {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.jN();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void J() {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.qN(true);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean a1() {
        kf5.b r0 = this.p;
        if (r0 == null) goto L7;
        CommentInputRequest r1 = r0.i();
        if (r1 == null) goto L7;
        return r1.isReply();
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void detach() {
        tt5.a.h("Comment#Comment", "detach, self: " + hashCode());
        Q0(false, true);
        this.w.K();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void f0() {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.LM();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h() {
        this.y.h();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean i() {
        p1 r0 = this.o;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.j p0() {
        return new com.bytedance.ee.bear.middleground.comment.uitls.i(this.r);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Flowable<String> r() {
        return this.w.getComment().subscribeOn(fo5.d.b()).observeOn(fo5.d.d());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t2() {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.t2();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void v2() {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.v2();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void v4() {
        IImageViewer r0 = this.a.getSupportFragmentManager().findFragmentByTag(CardAdapter2.TAG);
        if ((r0 instanceof IImageViewer) == false) goto L5;
        IImageViewer r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.close();
    L8:
        p1 r2 = this.o;
        if (r2 == null) goto L12;
        r2.v4();
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.s w0() {
        return new lf5.a(this.r.f);
    }

    public y w1() {
        return new com.bytedance.ee.bear.middleground.comment.control.a(this.r, this.x, this.w);
    }

    public p1 x1() {
        if (this.o != null) goto L20;
        tt5.a.h("Comment#Comment", "create cardComment");
        CommentStyle r0 = this.j;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L7;
    L16:
        p1 r2 = new HalfScreenCardComment(this.r, this.x, this.w, this.y);
    L17:
        this.o = r2;
        r2.eX(this.F);
        p1 r3 = this.o;
        if (r3 == null) goto L20;
        r3.RL(this.G);
        goto L20
    L7:
        if (r1 == 2) goto L16;
        if (r1 != 3) goto L11;
        r2 = new FloatCardComment(this.r, this.x, this.w, this.y, new Comment$ensureCardComment$1(this), new Comment$ensureCardComment$2(this));
        goto L17
    L11:
        if (r1 != 4) goto L14;
        r2 = new AsideComment(this.r, this.x, this.w, this.y);
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    L20:
        p1 r4 = this.o;
        Intrinsics.checkNotNull(r4);
        return r4;
    }

    public boolean z1() {
        if (this.j == CommentStyle.HALF_SCREEN) goto L14;
        p1 r0 = this.o;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
        goto L10
    L14:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void A() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L7;
        kf5.b r0 = this.p;
        if (r0 == null) goto L19;
        r0.b();
        return;
    L19:
        return;
    L7:
        kf5.b r1 = this.p;
        if (r1 != null) goto L10;
    L15:
        p1 r2 = this.o;
        if (r2 == null) goto L21;
        r2.IX();
        return;
    L21:
        return;
    L10:
        if (r1.isShowing() == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        kf5.a.a(r1, false, false, 3);
        goto L15
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final int B() {
        return this.D;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function0<Unit> B0() {
        return this.t0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Boolean, Unit> D0() {
        return this.Y;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function4<String, String, Integer, Integer, Unit> E0() {
        return this.e0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.i F0() {
        return this.r;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function3<String, CommentInputRequest, Boolean, Unit> H() {
        return this.X;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<CommentInputRequest, Unit> I() {
        return this.K;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> J0() {
        return this.V;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function0<Pair<String, String>> N() {
        return this.n;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> N0() {
        return this.M;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function6<String, Integer, String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Integer, CommentBean, Unit> O0() {
        return this.v0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function0<Unit> P() {
        return this.l0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function3<String, String, MentionUserState, Boolean> P0() {
        return this.B;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Comment$inputCommentFunction$1 T() {
        return this.s;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<CommentInputRequest, Unit> U0() {
        return this.N;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function2<String, Map<String, ? extends Object>, Unit> V0() {
        return this.w0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Integer, Unit> W() {
        return this.a0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<List<String>, Unit> Y0() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Boolean, Unit> Z() {
        return this.i0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z, com.bytedance.ee.bear.middleground.comment.export.h
    public final List<Function2<Integer, Boolean, Unit>> a() {
        return this.R;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.p b() {
        return this.w;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> b0() {
        return this.U;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z, com.bytedance.ee.bear.middleground.comment.export.h
    public final List<Function2<Integer, Boolean, Unit>> c() {
        return this.S;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function3<String, float[], Matrix, Unit> c0() {
        return this.y0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<View, Unit> d0() {
        return this.r0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function1<String, Unit> d1() {
        return this.H;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function2<String, String, Unit> e0() {
        return this.o0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z, com.bytedance.ee.bear.middleground.comment.export.h
    public final List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> f() {
        return this.O;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> f1() {
        return this.h0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function4<String, Integer, String, Integer, Unit> g1() {
        return this.u0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function2<String, Action, Unit> getFilterData() {
        return this.L;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<bo4.a, Unit> i0() {
        return this.A;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function0<Boolean> j0() {
        return this.J;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function0<Unit> k0() {
        return this.f0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Boolean, Unit> k1() {
        return this.n0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z, com.bytedance.ee.bear.middleground.comment.export.h
    public final Function1<String, Unit> l() {
        return this.q0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> l1() {
        return this.x0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> m0() {
        return this.g0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Boolean, Unit> n() {
        return this.j0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final CommentStyle n0() {
        return this.j;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Boolean, Unit> n1() {
        return this.m0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function0<Unit> o0() {
        return this.Q;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function2<String, String, Unit> p() {
        return this.b0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Integer, Unit> p1() {
        return this.c0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function1<ScrollCommentBean, Unit> q() {
        return this.I;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Integer, Unit> q1() {
        return this.P;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Unit> s0() {
        return this.k0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final sa5.b s1() {
        return this.E;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.m u0() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function2<CharSequence, CommentInputRequest, Unit> v() {
        return this.W;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Boolean> v0() {
        return this.T;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<String, Boolean> x() {
        return this.d0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function2<CommentBottomPopupData, bf5.b, Unit> x0() {
        return this.p0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final Function1<Boolean, Unit> z0() {
        return this.Z;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void A0(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.Z = r2;
    }

    public final void A1(boolean r3) {
        tt5.a.h("Comment#Comment", "registerReactionObserver, self: " + hashCode() + ", init: " + r3);
        this.w.y(new g(this), r3);
        CommentStyle r4 = this.j;
        int r0 = com.bytedance.ee.bear.middleground.comment.card.a.a;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        com.bytedance.ee.bear.middleground.comment.card.a.c = r4;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void C(boolean r3) {
        tt5.a.h("Comment#Comment", "updateFollowMaskEnable, isChangedToFollow: " + r3 + ", commentStyle: " + this.r.n);
        this.r.N.a(new ef5.n(r3));
        if (this.r.n != CommentStyle.ASIDE) goto L6;
        if (r3 == false) goto L6;
        t2();
    L6:
        x1().Hg();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void C0(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.w0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void D(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void F(List<CommentBean> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        com.bytedance.ee.util.ui.j.f(new i(this, r2));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Fa(CardCommentHeight r2) {
        Intrinsics.checkNotNullParameter(r2, "height");
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.Fa(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void G(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void G0(tb5.m r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.ee.bear.middleground.comment.control.s r0 = this.v;
        if (r0 == null) goto L6;
        r r1 = new r(r4);
        Intrinsics.checkNotNullParameter(r1, "impl");
        tt5.a.h("Comment#CommentWebSdkWrapper", "set impl");
        r0.a = r1;
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void H0(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.U = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final CommentBean K(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return this.w.O(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void L(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.x0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void L0(Function2<? super String, ? super Action, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.L = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void M(Function1<? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.T = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean O(boolean r3) {
        if (r3 == true) goto L11;
        p1 r4 = this.o;
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L11;
        return true;
    L7:
        if (r4.isShowing() != true) goto L9;
        r5 = true;
    L11:
        kf5.b r6 = this.p;
        if (r6 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == true) goto L29;
        p1 r8 = this.o;
        if (r8 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == true) goto L30;
        return false;
    L30:
        return true;
    L21:
        if (r8.wB() != true) goto L23;
        r9 = true;
        goto L24
    L29:
        return true;
    L14:
        if (r6.isShowing() != true) goto L16;
        r7 = true;
        goto L17
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Qa(FocusInputBean r2) {
        Intrinsics.checkNotNullParameter(r2, "focusInputBean");
        if (TextUtils.isEmpty(r2.getCommentId()) == false) goto L7;
        tt5.a.h("Comment#Comment", "focusInput, commentId is empty");
        return;
    L7:
        if (r2.getCommentId() == null) goto L12;
        p1 r0 = this.o;
        if (r0 == null) goto L13;
        r0.Qa(r2);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void R(Function1<? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void R0(SmartReplyDataForInsert r6) {
        Intrinsics.checkNotNullParameter(r6, "dataForInsert");
        p1 r0 = this.o;
        if (r0 == null) goto L5;
        String r1 = r0.UT();
    L7:
        if (StringsKt.equals$default(r1, r6.getCommentId(), false, 2, null) == false) goto L9;
    L12:
        tt5.a.h("Comment#Comment", "insert to reply: comment " + r6.getCommentId() + " is showing");
        p1 r2 = this.o;
        if (r2 == null) goto L17;
        r2.XC(r6.getText(), r6.getCommentId(), r6.getReplyId(), r6.getAiReplyId());
        return;
    L17:
        return;
    L9:
        if (this.r.n == CommentStyle.ASIDE) goto L12;
        tt5.a.h("Comment#Comment", "insert to reply: comment " + r6.getCommentId() + " is not showing");
        this.r.N.a(new w(r6));
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void S(CommentInputRequest r8) {
        if (this.p != null) goto L8;
        if (r8 != null) goto L6;
        CommentInputRequest r0 = new CommentInputRequest();
    L7:
        this.p = y1(r0);
        goto L8
    L6:
        r0 = r8;
    L8:
        if (r8 == null) goto L12;
        r8.doc_url = this.g;
        kf5.b r1 = this.p;
        if (r1 == null) goto L15;
        r1.p(r8);
    L15:
        Function1<? super CommentInputRequest, Unit> r2 = this.x.s0;
        kf5.b r3 = this.p;
        if (r3 == null) goto L18;
        CommentInputRequest r4 = r3.i();
    L19:
        r2.invoke(r4);
        if (r8 == null) goto L22;
        boolean r5 = r8.keyboard_pop;
    L23:
        kf5.b r6 = this.p;
        if (r6 == null) goto L27;
        kf5.a.b(r6, false, false, r5, false, false, 26);
        return;
    L27:
        return;
    L22:
        r5 = true;
        goto L23
    L18:
        r4 = null;
        goto L19
    L12:
        kf5.b r7 = this.p;
        if (r7 == null) goto L15;
        r7.p(new CommentInputRequest());
        goto L15
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void T0(com.bytedance.ee.bear.middleground.comment.export.bean.a r2) {
        p1 r0 = this.o;
        if (r0 == null) goto L5;
        r0.RL(r2);
    L5:
        this.G = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void U(Function1<? super CommentInputRequest, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.K = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final CommentBean V(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return this.w.N(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void W0(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.V = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void X(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Y(Function2<? super CharSequence, ? super CommentInputRequest, Unit> r1) {
        this.W = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean Z0(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.q.add(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void a0(SyncReactionResultJsData r12) {
        Intrinsics.checkNotNullParameter(r12, WikiFolderPushPlugin.DATA);
        gf5.d r0 = this.r.N;
        ReactionCacheActionType r2 = ReactionCacheActionType.REMOVE_CACHE;
        String r1 = r12.getCommentId();
        if (r1 != null) goto L5;
        String r4 = "";
    L6:
        String r3 = r12.getReplyId();
        if (r3 != null) goto L9;
        String r5 = "";
    L10:
        String r6 = r12.getReactionKey();
        if (r6 != null) goto L13;
        String r7 = "";
    L14:
        String r13 = r12.getActionId();
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        r0.a(new b0(r2, r4, r5, r7, r13, null, null, null));
        return;
    L13:
        r7 = r6;
        goto L14
    L9:
        r5 = r3;
        goto L10
    L5:
        r4 = r1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void b1(Function4<? super String, ? super String, ? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void c1(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void d(List<CommentBean> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        com.bytedance.ee.util.ui.j.f(new h(this, r2));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void destroy(boolean r5) {
        tt5.a.h("Comment#Comment", "destroy, self: " + hashCode());
        af5.b r0 = this.r.Q;
        if (r0 == null) goto L7;
        com.bytedance.ee.bear.middleground.comment.performance.d r1 = r0.b();
        if (r1 == null) goto L7;
        r1.c();
    L7:
        ((com.bytedance.ee.bear.middleground_permission_export.model.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.h.class, null, null, 6)).clear();
        tt5.a.h("Comment#Comment", "comment destroy， isRemoveReaction: " + r5);
        Q0(false, false);
        this.q.dispose();
        this.q.clear();
        this.w.Q(C03491.INSTANCE);
        if (r5 == false) goto L10;
    L12:
        tt5.a.h("Comment#Comment", "removeReactionObserver");
        this.w.K();
    L13:
        ((LinkedHashMap) nf5.a.a).clear();
        kf5.b r6 = this.p;
        if (r6 == null) goto L16;
        r6.destroy();
    L16:
        this.o = null;
        this.p = null;
        cf5.a r7 = this.C;
        if (r7 == null) goto L25;
        Iterator r2 = ((ArrayList) r7.a).iterator();
    L20:
        if (r2.hasNext() == false) goto L22;
        ((gf5.b) r2.next()).onDestroy();
        goto L20
    L22:
        r7.d = true;
        return;
    L25:
        return;
    L10:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docx.pc.image_viewer_v2_enable") == false) goto L12;
        tt5.a.h("Comment#Comment", "keepReactionObserver");
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void e(String r2) {
        this.y.e(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void e1(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.J = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void g0(Function2<? super String, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h0(boolean r2) {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.Ni(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h1(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h5(Function0<Boolean> r2) {
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.h5(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void i1(com.bytedance.ee.bear.middleground.comment.export.bean.a r2) {
        p1 r0 = this.o;
        if (r0 == null) goto L5;
        r0.eX(r2);
    L5:
        this.F = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void j(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "userIds");
        tt5.a.h("Comment#Comment", "updateUserPermission, userIds: " + r4);
        this.q0.invoke("");
        kf5.b r0 = this.p;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        kf5.b r2 = this.p;
        if (r2 == null) goto L13;
        r2.j(r4);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void j1(Function3<? super String, ? super CommentInputRequest, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.X = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void m1(String r2) {
        this.r.O = r2;
        J();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void o(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        this.f = r3;
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.i = r3;
        this.w.o(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void o1(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.z = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void q0(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void r0(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.t0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void r1(Function3<? super String, ? super String, ? super MentionUserState, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.B = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void s(sbb.e r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        this.h = r3;
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.k = r3;
        this.w.s(r3);
        A1(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t0(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t1(Function1<? super CommentInputRequest, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.s0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void u(boolean r2) {
        kf5.b r0 = this.p;
        if (r0 == null) goto L6;
        r0.q(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void u1(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.Y = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Flowable<AskOwnerModel$SendResult> w(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "userIds");
        AskOwnerViewModel r0 = new AskOwnerViewModel();
        r0.init((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        return r0.askDocumentOwnerFlow(this.f, this.h.b, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void y(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void y0(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c0 = r2;
    }

    public kf5.b y1(CommentInputRequest r14) {
        Intrinsics.checkNotNullParameter(r14, "arg");
        return t1.a(this.r, this.x, this.w, new Comment$initInputComment$1(this), r14, new Comment$initInputComment$2(this), new Comment$initInputComment$3(this), z1(), new Comment$initInputComment$4(this), new d(this), null, 5120);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void z(Function4<? super String, ? super Integer, ? super String, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.u0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void E(CommentInputRequest r9, ze5.c r10) {
        Intrinsics.checkNotNullParameter(r10, "callBack");
        if (r9 == null) goto L24;
        CommentBean.CommentDetail.ExtraEntity r0 = r9.extra;
        if (r0 == null) goto L7;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = r0.getImage_list();
    L8:
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2 = r1;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L24;
        gf5.d r4 = this.r.N;
        CommentBean.CommentDetail.ExtraEntity r5 = r9.extra;
        if (r5 == null) goto L21;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r6 = r5.getImage_list();
        if (r6 == null) goto L21;
    L22:
        r4.a(new ef5.s(0, r6, null, r9, r10));
        return;
    L21:
        r6 = new ArrayList();
        goto L22
    L11:
        if (r2.isEmpty() == true) goto L14;
        r3 = false;
        goto L15
    L7:
        r1 = null;
    L24:
        tt5.a.h("Comment#Comment", "insertImage, no image for insert");
        r10.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void K0(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "createId");
        tt5.a.h("Comment#Comment", "showComment");
        x1();
        J();
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.fj(r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Q0(boolean r2, boolean r3) {
        if (r2 == true) goto L6;
        p1 r4 = this.o;
        if (r4 == null) goto L6;
        r4.Ni(r3);
    L6:
        tt5.a.h("Comment#Comment", "closeComment, so dismiss inputComment");
        kf5.b r5 = this.p;
        if (r5 == null) goto L10;
        kf5.a.a(r5, false, false, 3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Q6(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        p1 r0 = this.o;
        if (r0 == null) goto L6;
        r0.Q6(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void g(String r2, DriveCommentWrapper.7 r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        kf5.b r0 = this.p;
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void l0(boolean r3, boolean r4) {
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.r;
        CommentArea r1 = r0.g0;
        r1.a = r3;
        r1.b = r4;
        if (r3 == false) goto L6;
        r0.d0.c = !r4;
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void m(List r2, e1 r3) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        kf5.b r0 = this.p;
        if (r0 == null) goto L6;
        r0.m(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void X0(String r3, String r4, Boolean r5) {
        tt5.a.h("Comment#Comment", "insertContentToDraft, content = " + r3 + ", commentId = " + r4 + ", replyId = null, isWhole = " + r5);
        boolean r0 = false;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        gf5.d r2 = this.r.N;
        if (r5 == null) goto L14;
        r0 = r5.booleanValue();
    L14:
        r2.a(new ef5.v(r4, r0, r3));
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void k(String r2, boolean r3, ArrayList<String> r4) {
        kf5.b r0 = this.p;
        if (r0 != null) goto L5;
        r0 = y1(new CommentInputRequest());
        this.p = r0;
    L5:
        r0.k(r2, r3, r4);
    }

    public static final void v1(boolean r7, Comment r8, String r9, String r10, CommentBean r11, CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r12) {
        if (r7 == false) goto L6;
        tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: dispatchToWeb");
        r8.w.k(r9, r10, r11.getCommentType(), r11.getIs_whole(), CollectionsKt.listOf(r12));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.z
    public final void Q(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r21, VFSPath r22, String r23, String r24, CommentBean r25, CommentImageShowSource r26) {
        Intrinsics.checkNotNullParameter(r21, "imageEntity");
        tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: imageEntity = " + r21 + ", path = " + r22 + ", commentId = " + r23 + ", replyId = " + r24 + ", source = " + r26);
        if (r22 == null) goto L46;
        if (r23 == null) goto L46;
        if (r24 == null) goto L46;
        if (r26 == null) goto L46;
        if (this.r.q.getComment() == true) goto L12;
        tt5.a.k("Comment#Comment", "insertReplyFromAreaMark: no comment permission");
        return;
    L12:
        if (r25 == null) goto L44;
        List<CommentBean.CommentDetail> r4 = r25.getComment_list();
        if (r4 == null) goto L44;
        Iterator<T> r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        Object r11 = r5.next();
        if (Intrinsics.areEqual(((CommentBean.CommentDetail) r11).getReply_id(), r24) == false) goto L17;
    L22:
        CommentBean.CommentDetail r12 = (CommentBean.CommentDetail) r11;
        if (r12 == null) goto L44;
        tt5.a.h("Comment#Comment", "insertReplyFromAreaMark: commentDetail = " + r12);
        if (r26 != CommentImageShowSource.WEB) goto L28;
        boolean r6 = true;
    L29:
        int r2 = com.bytedance.ee.bear.middleground.comment.uitls.k.a;
        String r3 = this.g;
        if (r3 != null) goto L32;
        r3 = "";
    L32:
        String r10 = this.r.i;
        Intrinsics.checkNotNullParameter(r21, "imageEntity");
        Intrinsics.checkNotNullParameter(r22, "path");
        Intrinsics.checkNotNullParameter(r3, "docUrl");
        tt5.a.h("CommentImageUtils", "copyImgFile: imageEntity = " + r21 + ", path = " + r22 + ", docToken = " + du5.b.h(r10));
        LinkedHashMap r7 = new LinkedHashMap();
        String r15 = r22.getRealPath();
        StringBuilder r14 = new StringBuilder("0");
        r14.append(System.currentTimeMillis());
        String r8 = r14.toString();
        StringBuilder r9 = new StringBuilder("docsource://com.bytedance.net/file/f/");
        ((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).c();
        r9.append(r8);
        r9.append(r15.substring(StringsKt.lastIndexOf$default(r15, ".", 0, false, 6, null)));
        String r13 = r9.toString();
        r7.put(r13, r15);
        r21.setUuid(r8);
        r21.setSrc(r13);
        r21.setToken(null);
        r21.setOriginalSrc(null);
        tt5.a.h("CommentImageUtils", "insertReplyFromAreaMark: imageEntity = " + r21 + ", path = " + r22);
        Flowable r0 = ((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).i(r3, r10, r7);
        if (r0 == null) goto L39;
        Flowable r1 = r0.subscribeOn(fo5.d.a());
        if (r1 == null) goto L39;
        Flowable r16 = r1.observeOn(fo5.d.d());
        if (r16 == null) goto L39;
        Disposable r17 = r16.subscribe(new e(r21, r25, this, r6, r23, r24, r12), f.a);
    L41:
        if (r17 == null) goto L51;
        Z0(r17);
        return;
    L51:
        return;
    L39:
        r17 = null;
        goto L41
    L28:
        r6 = false;
        goto L29
    L21:
        r11 = null;
    L44:
        tt5.a.k("Comment#Comment", "insertReplyFromAreaMark: cannot find commentDetail in commentBean");
        return;
    L46:
        tt5.a.k("Comment#Comment", "insertReplyFromAreaMark: param is null");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void i8(String r9, String r10, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11, int r12, CommentBean r13, CommentImageShowSource r14) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "source");
        x1().i8(r9, r10, r11, r12, r13, r14);
    }

    public Comment(FragmentActivity r44, FrameLayout r45, FrameLayout r46, FrameLayout r47, FrameLayout r48, FragmentManager r49, String r50, String r51, sbb.e r52, boolean r53, String r54, long r55, long r57, com.bytedance.ee.bear.middleground.comment.export.o r59, boolean r60, boolean r61, boolean r62, pcb.a r63, CommentStyle r64, boolean r65, boolean r66, v r67, boolean r68, com.bytedance.ee.bear.middleground.comment.export.g r69, Function1<? super List<String>, Unit> r70, com.bytedance.ee.bear.middleground.comment.export.m r71, boolean r72, com.bytedance.ee.bear.middleground.comment.export.t r73, bf5.a r74, boolean r75, boolean r76, Fragment r77, boolean r78, com.bytedance.ee.bear.middleground.comment.export.k r79, Function0<Boolean> r80) {
        Intrinsics.checkNotNullParameter(r44, "activity");
        Intrinsics.checkNotNullParameter(r45, "viewParent");
        Intrinsics.checkNotNullParameter(r47, "imageViewerParent");
        Intrinsics.checkNotNullParameter(r48, "reactionAnimationParent");
        Intrinsics.checkNotNullParameter(r49, "fragmentManager");
        Intrinsics.checkNotNullParameter(r50, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r51, "docUrl");
        Intrinsics.checkNotNullParameter(r52, "pageType");
        Intrinsics.checkNotNullParameter(r54, "subFileType");
        Intrinsics.checkNotNullParameter(r59, "per");
        Intrinsics.checkNotNullParameter(r63, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r64, "commentStyle");
        Intrinsics.checkNotNullParameter(r70, "readMessage");
        Intrinsics.checkNotNullParameter(r79, "commentHostDelegate");
        this.a = r44;
        this.b = r45;
        this.c = r46;
        this.d = r47;
        this.e = r48;
        this.f = r50;
        this.g = r51;
        this.h = r52;
        this.i = r63;
        this.j = r64;
        this.k = r70;
        this.l = r71;
        this.m = r80;
        this.q = new CompositeDisposable();
        p r16 = new p();
        String r1 = this.f;
        sbb.e r12 = this.h;
        if (r73 != null) goto L5;
    L7:
        boolean r22 = false;
    L8:
        c r2 = new c(this);
        if (r74 != null) goto L11;
        bf5.a r35 = new com.bytedance.ee.bear.middleground.comment.uitls.q();
    L12:
        com.bytedance.ee.bear.middleground.comment.uitls.p r3 = new com.bytedance.ee.bear.middleground.comment.uitls.p(r44, r77, r45, r46, r47, r48, r49, r16, r1, r51, r12, r53, r54, r64, r55, r57, r59, r63, r22, r65, r60, r65, r61, r62, r66, r67, r68, r69, r71, r2, r73, r35, r75, r78, this instanceof BitableComment, r76, r79, r80);
        this.r = r3;
        this.s = new Comment$inputCommentFunction$1(this);
        this.x = this;
        this.A = Comment$onMentionSelect$1.INSTANCE;
        this.B = Comment$onMentionClicked$1.INSTANCE;
        boolean r4 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.image_region_comment_view");
        com.bytedance.ee.bear.rn.k r5 = (com.bytedance.ee.bear.rn.k) org.koin.java.a.b(com.bytedance.ee.bear.rn.k.class, null, new AnonymousClass1(this));
        this.u = r5;
        if (r68 == false) goto L15;
        com.bytedance.ee.bear.middleground.comment.control.s r6 = new com.bytedance.ee.bear.middleground.comment.control.s();
        this.v = r6;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r5);
        this.w = new com.bytedance.ee.bear.middleground.comment.control.w(r6, r5);
    L16:
        A1(true);
        if (r4 == false) goto L19;
    L22:
        y r7 = w1();
    L23:
        this.y = r7;
        if (r72 == false) goto L26;
        r3.Q = new PerfProvider(r3);
    L26:
        cf5.a r8 = new cf5.a();
        this.C = r8;
        int r9 = df5.a.a;
        Intrinsics.checkNotNullParameter(r3, "config");
        String r10 = r3.k.getType();
        if (Intrinsics.areEqual(r10, sbb.e.l.getType()) == false) goto L30;
        List r11 = CollectionsKt.listOf(new com.bytedance.ee.bear.middleground.comment.extension.addins.b[]{new e0(), new i0(), new a0()});
    L36:
        List r13 = r11;
        com.bytedance.ee.bear.middleground.comment.extension.addins.b[] r14 = new com.bytedance.ee.bear.middleground.comment.extension.addins.b[10];
        r14[0] = new d0();
        r14[1] = new com.bytedance.ee.bear.middleground.comment.extension.addins.q();
        r14[2] = new p0();
        r14[3] = new c0();
        r14[4] = new com.bytedance.ee.bear.middleground.comment.extension.addins.r();
        r14[5] = new j0();
        r14[6] = new com.bytedance.ee.bear.middleground.comment.extension.addins.v();
        r14[7] = new l0();
        r14[8] = new com.bytedance.ee.bear.middleground.comment.extension.addins.s();
        if (r3.V == false) goto L39;
        com.bytedance.ee.bear.middleground.comment.extension.addins.b r15 = new com.bytedance.ee.bear.middleground.comment.extension.addins.e();
    L40:
        r14[9] = r15;
        List r17 = CollectionsKt.plus(r13, CollectionsKt.listOf(r14));
        Intrinsics.checkNotNullParameter(r17, "list");
        ((ArrayList) r8.a).addAll(r17);
        cf5.a r18 = this.C;
        if (r18 == null) goto L43;
        com.bytedance.ee.bear.middleground.comment.a r19 = new com.bytedance.ee.bear.middleground.comment.a(this);
        Intrinsics.checkNotNullParameter(r19, "contextForPlugin");
        r18.c = r19;
    L43:
        cf5.a r20 = this.C;
        if (r20 == null) goto L49;
        Iterator r21 = ((ArrayList) r20.a).iterator();
    L47:
        if (r21.hasNext() == false) goto L49;
        ((gf5.b) r21.next()).a(r20);
    L49:
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r23 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r24 = this.a;
        Fragment r25 = this.r.b;
        r23.getClass();
        this.E = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r24, r25);
        this.H = new Comment$switchCard$1(this);
        this.I = new Comment$commentCardScrollTo$1(this);
        this.J = Comment$interceptMaskClick$1.INSTANCE;
        this.K = Comment$clickArea$1.INSTANCE;
        this.L = Comment$filterData$1.INSTANCE;
        this.M = Comment$newCommentId$1.INSTANCE;
        this.N = new Comment$clickImage$1(this);
        this.O = new CopyOnWriteArrayList();
        this.P = Comment$countChange$1.INSTANCE;
        this.Q = Comment$clickResolve$1.INSTANCE;
        this.R = new CopyOnWriteArrayList();
        this.S = new CopyOnWriteArrayList();
        Comment$clickUserImg$1 r26 = Comment$clickUserImg$1.INSTANCE;
        this.T = Comment$sameLink$1.INSTANCE;
        this.U = Comment$clickLink$1.INSTANCE;
        this.V = Comment$copyListener$1.INSTANCE;
        this.X = Comment$sendListener$1.INSTANCE;
        this.Y = Comment$commentEditFocusChange$1.INSTANCE;
        this.Z = Comment$closeListener$1.INSTANCE;
        this.a0 = Comment$panelHeightUpdate$1.INSTANCE;
        this.b0 = Comment$editIng$1.INSTANCE;
        this.c0 = Comment$heightChange$1.INSTANCE;
        this.d0 = new Comment$isWholeChange$1(this);
        this.e0 = Comment$switchListener$1.INSTANCE;
        this.f0 = Comment$clickBack$1.INSTANCE;
        this.g0 = Comment$showFull$1.INSTANCE;
        this.h0 = Comment$closeFull$1.INSTANCE;
        this.i0 = Comment$editListener$1.INSTANCE;
        this.j0 = Comment$cardsShow$1.INSTANCE;
        this.k0 = Comment$gotoProfile$1.INSTANCE;
        this.l0 = Comment$forcePortrait$1.INSTANCE;
        this.m0 = Comment$forceOrientationRequestHandler$1.INSTANCE;
        this.n0 = Comment$onVoiceBarShowingChanged$1.INSTANCE;
        this.o0 = new Comment$showSharePermissionDialogInCardComment$1(this);
        this.p0 = new Comment$showSharePermissionDialogInWholeComment$1(this);
        this.q0 = new Comment$sharePermission$1(this);
        this.r0 = new Comment$reactionAddListener$1(this);
        this.s0 = Comment$onCreateComment$1.INSTANCE;
        this.t0 = Comment$inputViewShow$1.INSTANCE;
        this.u0 = Comment$onActivateImageChange$1.INSTANCE;
        this.v0 = new Comment$onCommentImageClick$1(this);
        this.w0 = Comment$onMenuClickListener$1.INSTANCE;
        this.x0 = Comment$onSendToIm$1.INSTANCE;
        return;
    L39:
        r15 = new CardAdapterAddin();
        goto L40
    L30:
        if (Intrinsics.areEqual(r10, sbb.e.w.getType()) == false) goto L33;
        r11 = CollectionsKt.emptyList();
        goto L36
    L33:
        if (Intrinsics.areEqual(r10, sbb.e.i.getType()) == false) goto L35;
        r11 = CollectionsKt.plus(df5.a.a(r3), CollectionsKt.listOf(new com.bytedance.ee.bear.middleground.comment.extension.addins.c()));
        goto L36
    L35:
        r11 = df5.a.a(r3);
        goto L36
    L19:
        if (r64 != CommentStyle.HALF_SCREEN) goto L22;
        r7 = new CommentFunction(r3, this, this.w);
        goto L23
    L15:
        com.bytedance.ee.bear.rn.g r27 = (com.bytedance.ee.bear.rn.g) org.koin.java.a.b(com.bytedance.ee.bear.rn.g.class, null, new AnonymousClass2(this));
        this.t = r27;
        Intrinsics.checkNotNull(r27);
        Intrinsics.checkNotNull(r5);
        u r28 = new u(r27, r5, new AnonymousClass3(this));
        this.w = r28;
        Function1<String, Unit> r29 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r29, "listener");
        com.bytedance.ee.bear.middleground.comment.control.v r30 = new com.bytedance.ee.bear.middleground.comment.control.v(r29);
        com.bytedance.ee.bear.rn.g r31 = r28.a;
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type com.bytedance.ee.bear.rn.RnCommentProtocol.CommentDataObserver");
        r31.o(r30);
        goto L16
    L11:
        r35 = r74;
        goto L12
    L5:
        if (((CommentPlugin.g) r73).c() != true) goto L7;
        r22 = true;
        goto L8
    }
}
