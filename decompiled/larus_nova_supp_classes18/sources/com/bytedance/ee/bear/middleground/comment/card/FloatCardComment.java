package com.bytedance.ee.bear.middleground.comment.card;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.CommentVoiceInputResultConsumer;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentSimpleSession;
import com.bytedance.ee.bear.middleground.comment.export.CommentVoiceHostPolicy;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widgets.CardIndicator;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FloatCardComment extends com.bytedance.ee.bear.middleground.comment.card.b {
    public static final int L0 = 0;
    public static final int P0 = 0;
    public AppCompatImageView A;
    public View B;
    public boolean C;
    public final b2 D;
    public com.bytedance.ee.bear.middleground.comment.export.bean.a E;
    public String F;
    public List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> G;
    public SmartReplyDataForInsert H;
    public final Lazy H0;
    public int I;
    public String J;
    public boolean K;
    public String L;
    public String M;
    public final Lazy<CommentImmersiveVoiceTouchDelegate> N;
    public final Lazy<CommentUnifiedVoiceComponentSimpleSession> O;
    public final Lazy P;
    public final int Q;
    public final ViewGroup R;
    public ForsetiViewMode S;
    public ForsetiViewMode T;
    public tua.b U;
    public final n V;
    public final g0 W;
    public final Function2<Integer, Boolean, Unit> X;
    public final m Y;
    public final Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit> Z;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p e;
    public final com.bytedance.ee.bear.middleground.comment.control.z f;
    public final com.bytedance.ee.bear.middleground.comment.control.t g;
    public final com.bytedance.ee.bear.middleground.comment.control.y h;
    public final Function1<CommentInputRequest, Unit> i;
    public final Function0<Boolean> j;
    public final SharePermissionViewModel k;
    public boolean k0;
    public final View l;
    public final VerticalViewPager m;
    public final CardIndicator n;
    public CommentPagerAdapter2 o;
    public com.bytedance.ee.bear.middleground.comment.card.d p;
    public int p0;
    public Integer q;
    public boolean r;
    public CommentTextView s;
    public AppCompatImageView t;
    public ImageView u;
    public View v;
    public View w;
    public View x;
    public View y;
    public AppCompatImageView z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForsetiViewMode.values().length];
            r0[ForsetiViewMode.EXPAND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ForsetiViewMode.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FloatCardComment a;
        public final /* synthetic */ View b;

        public c(FloatCardComment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Rect r0 = new Rect();
            AppCompatTextView r1 = this.a.s;
            VerticalViewPager r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            r1 = null;
        L5:
            r1.getGlobalVisibleRect(r0);
            Rect r3 = new Rect();
            this.b.getGlobalVisibleRect(r3);
            if ((r0.top - 30) >= r3.bottom) goto L18;
            CommentPagerAdapter2 r4 = this.a.o;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r4 = null;
        L10:
            VerticalViewPager r5 = this.a.m;
            if (r5 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        L14:
            RecyclerView r6 = r4.P0(Integer.valueOf(r2.getCurrentItem()));
            if (r6 == null) goto L19;
            r6.scrollBy(0, this.b.getHeight());
            return;
        L19:
            return;
        L13:
            r2 = r5;
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ FloatCardComment a;

        public d(FloatCardComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (((Boolean) this.a.j.invoke()).booleanValue() == true) goto L6;
            this.a.Ni(false);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ FloatCardComment a;

        public e(FloatCardComment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            List<CommentBean> r14 = (List) r13;
            if (r14 != null) goto L5;
            tt5.a.k("Comment#CardComment2", "data is null");
            return;
        L5:
            this.a.f.q1().invoke(Integer.valueOf(r14.size()));
            boolean r2 = true;
            if (r14.isEmpty() == false) goto L8;
            tt5.a.d("Comment#CardComment2", "data is empty");
            this.a.Ni(true);
            return;
        L8:
            FloatCardComment r1 = this.a;
            r1.getClass();
            if (com.bytedance.ee.bear.middleground.comment.export.e.c() != CommentVoiceHostPolicy.Route.LARK_IM) goto L35;
            String r3 = r1.M;
            if (r3 == null) goto L35;
            List<CommentBean> r4 = r14;
            if ((r4 instanceof Collection) == true) goto L17;
        L19:
            Iterator<T> r5 = r4.iterator();
        L21:
            if (r5.hasNext() == false) goto L25;
            if (Intrinsics.areEqual(((CommentBean) r5.next()).getComment_id(), r3) == false) goto L21;
            boolean r6 = true;
        L26:
            if (r6 == true) goto L35;
            tt5.a.h("Comment#CardComment2", "cancel voice because session comment is gone");
            CommentImmersiveVoiceTouchDelegate r7 = r1.i();
            if (r7 == null) goto L32;
            r7.a();
        L32:
            if (Intrinsics.areEqual(r1.M, r3) == false) goto L34;
            r1.M = null;
        L34:
            r1.o(false, null);
        L25:
            r6 = false;
            goto L26
        L17:
            if (r4.isEmpty() == false) goto L19;
        L35:
            SharePermissionViewModel.PreviewPermissionState r8 = this.a.k.h();
            if (r8 != null) goto L38;
        L39:
            FloatCardComment r9 = this.a;
            Iterator<T> r10 = r14.iterator();
        L41:
            if (r10.hasNext() == false) goto L59;
            List<CommentBean.CommentDetail> r11 = ((CommentBean) r10.next()).getComment_list();
            if (r11 == null) goto L41;
            Iterator<T> r12 = r11.iterator();
        L46:
            if (r12.hasNext() == false) goto L41;
            CommentBean.CommentDetail.ExtraEntity r15 = ((CommentBean.CommentDetail) r12.next()).getExtra();
            if (r15 == null) goto L46;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r16 = r15.getImage_list();
            if (r16 == null) goto L46;
            Iterator<T> r17 = r16.iterator();
        L53:
            if (r17.hasNext() == false) goto L46;
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r18 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r17.next();
            if (r18 == null) goto L53;
            String r19 = r18.getToken();
            if (r19 == null) goto L53;
            r9.k.m(r9.e, r19);
        L59:
            tt5.a.h("Comment#CardComment2", "data size = " + r14.size());
            this.a.q();
            CommentPagerAdapter2 r0 = this.a.o;
            if (r0 != null) goto L62;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r0 = null;
        L62:
            this.a.e.h.getClass();
            this.a.e.h.getClass();
            List<String> r20 = CollectionsKt.listOf(new String[]{com.bytedance.ee.bear.middleground.comment.p.a(), null});
            r0.getClass();
            Intrinsics.checkNotNullParameter(r20, "userIds");
            Intrinsics.checkNotNullParameter(r14, "cards");
            Intrinsics.checkNotNullParameter(r14, "cards");
            int r21 = com.bytedance.ee.bear.middleground.comment.card.e.a;     // Catch: Exception -> L100
            if (com.bytedance.ee.bear.middleground.comment.card.e.c(r0.b) == false) goto L102;
            List<CommentBean> r22 = r0.b;     // Catch: Exception -> L100
            if (r22 == null) goto L70;
            CommentBean r23 = (CommentBean) ListProtector.get(r22, r0.E().intValue());     // Catch: Exception -> L100
            if (r23 == null) goto L70;
            String r24 = r23.getComment_id();     // Catch: Exception -> L100
        L71:
            int r25 = com.bytedance.ee.bear.middleground.comment.card.e.a(r0.E().intValue(), r0.b);     // Catch: Exception -> L100
            List<CommentBean> r26 = r0.b;     // Catch: Exception -> L100
            if (r26 == null) goto L82;
            CommentBean r27 = (CommentBean) ListProtector.get(r26, r0.E().intValue());     // Catch: Exception -> L100
            if (r27 == null) goto L82;
            List<CommentBean.CommentDetail> r28 = r27.getComment_list();     // Catch: Exception -> L100
            if (r28 == null) goto L82;
            CommentBean.CommentDetail r29 = (CommentBean.CommentDetail) ListProtector.get(r28, r25);     // Catch: Exception -> L100
            if (r29 == null) goto L82;
            String r30 = r29.getReply_id();     // Catch: Exception -> L100
            if (r30 == null) goto L82;
        L84:
            if (r30.length() <= 0) goto L86;
            boolean r31 = true;
        L87:
            if (r31 == false) goto L102;
            Iterator<T> r32 = r14.iterator();     // Catch: Exception -> L100
        L89:
            if (r32.hasNext() == false) goto L102;
            CommentBean r33 = (CommentBean) r32.next();     // Catch: Exception -> L100
            if (Intrinsics.areEqual(r33.getComment_id(), r24) == false) goto L89;
            List<CommentBean.CommentDetail> r34 = r33.getComment_list();     // Catch: Exception -> L100
            if (r34 == null) goto L89;
            Iterator<T> r35 = r34.iterator();     // Catch: Exception -> L100
        L97:
            if (r35.hasNext() == false) goto L89;
            CommentBean.CommentDetail r110 = (CommentBean.CommentDetail) r35.next();     // Catch: Exception -> L100
            r110.setEditStatus(Intrinsics.areEqual(r110.getReply_id(), r30));     // Catch: Exception -> L100
            r110.isEditStatus();     // Catch: Exception -> L100
            goto L97
        L86:
            r31 = false;
        L82:
            r30 = "";
        L70:
            r24 = null;
        L102:
            r0.f = r20;
            r0.b = r14;
            CommentPagerAdapter2 r36 = this.a.o;
            if (r36 != null) goto L105;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r36 = null;
        L105:
            r36.notifyDataSetChanged();
            com.bytedance.ee.bear.middleground.comment.card.d r37 = this.a.p;
            if (r37 != null) goto L108;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r37 = null;
        L108:
            VerticalViewPager r38 = this.a.m;
            if (r38 != null) goto L111;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            r38 = null;
        L111:
            int r39 = r37.j(r38.getCurrentItem());
            VerticalViewPager r40 = this.a.m;
            if (r40 != null) goto L114;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            r40 = null;
        L114:
            int r41 = r40.getCurrentItem();
            View r42 = this.a.t;
            if (r42 != null) goto L117;
            Intrinsics.throwUninitializedPropertyAccessException("privateIcon");
            r42 = null;
        L117:
            CommentBean r43 = (CommentBean) CollectionsKt.getOrNull(r14, r39);
            if (r43 == null) goto L122;
            CommentBean.Extra r44 = r43.getExtra();
            if (r44 == null) goto L122;
            int r45 = r44.getVisibility();
        L123:
            if (r45 == 0) goto L125;
            boolean r46 = true;
        L126:
            if (r46 == false) goto L128;
            int r47 = 0;
        L129:
            r42.setVisibility(r47);
            FloatCardComment r48 = this.a;
            r48.p0 = r39;
            VerticalViewPager r49 = r48.m;
            if (r49 != null) goto L132;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            r49 = null;
        L132:
            r49.setCurrentItem(r39, false);
            CardIndicator r50 = this.a.n;
            if (r50 != null) goto L135;
            Intrinsics.throwUninitializedPropertyAccessException("pagerIndicator");
            r50 = null;
        L135:
            r50.update();
            FloatCardComment r51 = this.a;
            if (r51.C == false) goto L146;
            com.bytedance.ee.bear.middleground.comment.card.d r52 = r51.p;
            if (r52 != null) goto L140;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r52 = null;
        L140:
            VerticalViewPager r53 = this.a.m;
            if (r53 != null) goto L144;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            r53 = null;
        L144:
            if (r52.r(r53.getCurrentItem()) == false) goto L146;
        L147:
            r51.p(r2);
            this.a.e.N.a(new ef5.m(r14, Integer.valueOf(r39), Integer.valueOf(r41), null));
            FloatCardComment r111 = this.a;
            FloatCardComment.b(r111.e.getActivity().getWindow()).post(new l(r111));
            return;
        L146:
            r2 = false;
            goto L147
        L128:
            r47 = 8;
            goto L129
        L125:
            r46 = false;
        L122:
            r45 = 0;
        L100:
            e = move-exception;
            tt5.a.f("Comment#CommentPagerAdapter2", e, false);
            goto L102
        L38:
            if (r8 != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L59;
            goto L39
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ FloatCardComment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> c;
        public final /* synthetic */ SmartReplyDataForInsert d;

        /* JADX WARN: Multi-variable type inference failed */
        public f(FloatCardComment r1, String r2, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3, SmartReplyDataForInsert r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.s(this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FloatCardComment() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void IX() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    public final void n() {
        o(true, Boolean.FALSE);
    }

    static {
        L0 = com.bytedance.ee.util.ui.n.d(90);
        P0 = com.bytedance.ee.util.ui.n.d(90);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void LM() {
        View r0 = this.l;
        View r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r0 = null;
    L6:
        if (r0.isAttachedToWindow() == false) goto L16;
        View r2 = this.l;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r2 = null;
    L10:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = com.bytedance.ee.util.ui.n.t();
        View r4 = this.l;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        r1.setLayoutParams(r3);
        return;
    L13:
        r1 = r4;
        goto L14
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final String UT() {
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.p;
        VerticalViewPager r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        VerticalViewPager r2 = this.m;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L10:
        return r0.f(Integer.valueOf(r1.getCurrentItem()));
    L8:
        r1 = r2;
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final View getRootView() {
        View r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L6:
        return r0;
    }

    public final int h() {
        int r0 = com.bytedance.ee.util.ui.n.E(b(this.e.getActivity().getWindow()).getHeight() - ((com.bytedance.ee.util.ui.n.t() * 2) / 5));
        CommentPagerAdapter2 r1 = this.o;
        View r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r1 = null;
    L5:
        VerticalViewPager r3 = this.m;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r3 = null;
    L8:
        RecyclerView r4 = r1.P0(Integer.valueOf(r3.getCurrentItem()));
        if (r4 != null) goto L11;
        return r0;
    L11:
        RecyclerView.Adapter r5 = r4.getAdapter();
        if ((r5 instanceof CardAdapter2) == false) goto L14;
        CardAdapter2 r6 = (CardAdapter2) r5;
    L15:
        if (r6 == null) goto L17;
        int r7 = r6.getHeightFromTop();
    L18:
        if (r7 != 0) goto L20;
        return r0;
    L20:
        if (r4.getMeasuredHeight() == 0) goto L32;
        View r8 = this.l;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        int r9 = r2.getMeasuredHeight() - r7;
        if (r9 >= 0) goto L30;
        return r0;
    L30:
        return r9;
    L25:
        r2 = r8;
        goto L26
    L32:
        return r0;
    L17:
        r7 = 0;
        goto L18
    L14:
        r6 = null;
        goto L15
    }

    public final CommentImmersiveVoiceTouchDelegate i() {
        if (this.N.isInitialized() == true) goto L7;
        return null;
    L7:
        return (CommentImmersiveVoiceTouchDelegate) this.N.getValue();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean isShowing() {
        View r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r0 = null;
    L6:
        if (r0.getParent() == null) goto L8;
        return true;
    L8:
        return false;
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k j() {
        if (this.O.isInitialized() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k) this.O.getValue();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void jN() {
        CommentPagerAdapter2 r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r0 = null;
    L5:
        int r1 = r0.E().intValue();
        List<CommentBean> r2 = r0.b;
        if (r2 == null) goto L8;
        int r3 = r2.size();
    L9:
        if (r1 >= r3) goto L12;
        Map<Integer, RecyclerView> r4 = r0.l;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        Object r6 = r5.get(Integer.valueOf(r1));
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        r0.z2((RecyclerView) r6, r1, false);
        return;
    L12:
        return;
    L8:
        r3 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final q1 jV() {
        CommentPagerAdapter2 r0 = this.o;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        return null;
    L6:
        return r0;
    }

    public final void k() {
        ForsetiViewMode r0 = this.T;
        if (r0 == this.S) goto L41;
        tt5.a.h("Comment#CardComment2", "viewMode changed, cur is: " + r0);
        this.S = r0;
        if (ForsetiHelper.d() == false) goto L44;
        tt5.a.h("Comment#CardComment2", "onForsetiViewModeChanged() called with: viewMode = " + r0 + ' ');
        int r1 = b.a[r0.ordinal()];
        int r2 = -1;
        if (r1 != 1) goto L10;
        int r3 = this.Q;
    L14:
        View r4 = this.v;
        VerticalViewPager r5 = null;
        if (r4 == null) goto L28;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if ((r6 instanceof FrameLayout.LayoutParams) == false) goto L19;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
    L20:
        if (r7 == null) goto L28;
        if (r3 == (-1)) goto L24;
        r2 = r3 - com.bytedance.ee.util.ui.n.d(18);
    L24:
        r7.width = r2;
        r7.gravity = 8388693;
        View r8 = this.v;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("inputCommentView");
        r8 = null;
    L27:
        r8.setLayoutParams(r7);
        goto L28
    L19:
        r7 = null;
    L28:
        VerticalViewPager r9 = this.m;
        if (r9 == null) goto L42;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof FrameLayout.LayoutParams) == false) goto L33;
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10;
    L34:
        if (r11 == null) goto L43;
        r11.width = r3;
        r11.gravity = 8388613;
        VerticalViewPager r12 = this.m;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L39:
        r5.setLayoutParams(r11);
        return;
    L38:
        r5 = r12;
        goto L39
    L43:
        return;
    L33:
        r11 = null;
        goto L34
    L42:
        return;
    L10:
        if (r1 == 2) goto L12;
        r3 = -1;
        goto L14
    L12:
        r3 = this.Q;
        goto L14
    L44:
        return;
    }

    public final void q() {
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.p;
        VerticalViewPager r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        VerticalViewPager r2 = this.m;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r2 = null;
    L8:
        final CommentBean r3 = r0.e(Integer.valueOf(r2.getCurrentItem()));
        com.bytedance.ee.bear.middleground.comment.control.y r4 = this.h;
        if (r3 == null) goto L11;
        String r5 = r3.getUserId();
    L12:
        if (r3 == null) goto L14;
        List<String> r6 = r3.getParticipantList();
    L16:
        if (r4.t(r5, r6) == false) goto L21;
        CommentPagerAdapter2 r7 = this.o;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r7 = null;
    L20:
        r7.n = new FloatCardComment$setUiStatus$1(this, r3);
    L25:
        p(this.e.q.getComment());
        this.C = this.e.q.getComment();
        CommentPagerAdapter2 r8 = this.o;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r8 = null;
    L28:
        r8.o = new FloatCardComment$setUiStatus$2(this);
        VerticalViewPager r9 = this.m;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r9 = null;
    L31:
        r9.mRecyclerView.setItemAnimator(null);
        VerticalViewPager r10 = this.m;
        if (r10 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L35:
        r1.setOnClickListener(new d(this));
        return;
    L34:
        r1 = r10;
        goto L35
    L21:
        CommentPagerAdapter2 r11 = this.o;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r11 = null;
    L24:
        r11.n = null;
        goto L25
    L14:
        r6 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    }

    public final boolean r() {
        String r0 = this.L;
        if (r0 != null) goto L6;
        return false;
    L6:
        com.bytedance.ee.bear.middleground.comment.card.d r1 = this.p;
        VerticalViewPager r2 = null;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L9:
        VerticalViewPager r3 = this.m;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L14:
        return Intrinsics.areEqual(r0, r1.f(Integer.valueOf(r2.getCurrentItem())));
    L12:
        r2 = r3;
        goto L14
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.p;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        return null;
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b
    public final boolean a() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k r0 = j();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        CommentImmersiveVoiceTouchDelegate r1 = i();
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L14;
        r1.a();
        return true;
    L14:
        return false;
    L8:
        if (r1.k != true) goto L10;
        r3 = true;
        goto L11
    }

    public static View b(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void E7(String r5) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.p;
        VerticalViewPager r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.d = r5;
        com.bytedance.ee.bear.middleground.comment.card.d r6 = this.p;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r6 = null;
    L8:
        VerticalViewPager r1 = this.m;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r1 = null;
    L11:
        int r7 = r6.j(r1.getCurrentItem());
        this.p0 = r7;
        VerticalViewPager r3 = this.m;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L15:
        r2.setCurrentItem(r7, false);
        return;
    L14:
        r2 = r3;
        goto L15
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Ni(boolean r6) {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k r0 = j();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        CommentImmersiveVoiceTouchDelegate r1 = i();
        if (r1 == null) goto L8;
        r1.a();
    L8:
        o(false, null);
        this.L = null;
        this.M = null;
        super.Ni(r6);
        this.h.q();
        this.h.h();
        ((sw4.c) org.koin.java.a.c(sw4.c.class, null, null, 6)).f(this.e.d(), CardAdapter2.TAG);
        int r7 = com.bytedance.ee.bear.middleground.comment.card.a.a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r8 = this.e;
        if (r8.s == false) goto L11;
    L24:
        this.k.d();
        CommentPagerAdapter2 r9 = this.o;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r9 = null;
    L27:
        r9.A2();
        this.I = 0;
        this.f.a().remove(this.X);
        this.f.f().remove(this.Z);
        this.e.c.removeOnLayoutChangeListener(this.Y);
        View r10 = this.l;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r10 = null;
    L30:
        r10.setPadding(0, 0, 0, 0);
        AtUtils.c.clear();
        com.bytedance.ee.bear.middleground.comment.card.d r11 = this.p;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r11 = null;
    L33:
        MutableLiveData<List<CommentBean>> r12 = r11.f;
        if (r12 == null) goto L36;
        r12.removeObservers(this.e.getActivity());
    L36:
        com.bytedance.ee.bear.middleground.comment.card.d r13 = this.p;
        if (r13 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r13 = null;
    L39:
        r13.b();
        if (isShowing() == true) goto L42;
    L44:
        this.f.k0().invoke();
        Function1<Boolean, Unit> r14 = this.f.z0();
        Boolean r3 = Boolean.FALSE;
        r14.invoke(r3);
        View r15 = this.l;
        if (r15 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r15 = null;
    L47:
        ViewParent r16 = r15.getParent();
        if ((r16 instanceof ViewGroup) == false) goto L50;
        ViewGroup r17 = (ViewGroup) r16;
    L51:
        if (r17 == null) goto L56;
        View r4 = this.l;
        if (r4 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r4 = null;
    L55:
        r17.removeView(r4);
    L56:
        SharePermissionViewModel r18 = this.k;
        if (r18.g.getValue() != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L59;
        r18.h = false;
    L59:
        Function1<Boolean, Unit> r19 = this.f.n();
        if (r19 == null) goto L62;
        r19.invoke(r3);
    L62:
        this.e.N.a(new ef5.d());
        if (ForsetiHelper.d() == false) goto L69;
        this.R.getViewTreeObserver().removeOnPreDrawListener(this.V);
        tua.b r20 = this.U;
        if (r20 == null) goto L67;
        r20.e(this.W);
    L67:
        this.U = null;
        return;
    L69:
        return;
    L50:
        r17 = null;
        goto L51
    L42:
        if (((Boolean) this.f.T().d.invoke()).booleanValue() == false) goto L44;
        this.f.T().c.invoke();
        goto L44
    L11:
        if (r8.t == false) goto L24;
        if (r8.P == false) goto L24;
        Integer r21 = this.q;
        if (r21 == null) goto L22;
        int r22 = r21.intValue();
        FragmentActivity r2 = this.e.getActivity();
        Fragment r5 = this.e.b;
        if (r5 == null) goto L19;
        Fragment r23 = r5.getParentFragment();
    L20:
        bp5.c.e(r2, ForsetiHelper.g(r23), r22, this.r);
        this.q = null;
        goto L22
    L19:
        r23 = null;
    L22:
        if (this.k0 == false) goto L24;
        View r24 = b(this.e.getActivity().getWindow());
        r24.setSystemUiVisibility((r24.getSystemUiVisibility() | DocUserPermission.USER_PERM_FULL_ACCESS) | 256);
        this.k0 = false;
        goto L24
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Qa(FocusInputBean r5) {
        Intrinsics.checkNotNullParameter(r5, "focusInputBean");
        if (this.e.q.getComment() == true) goto L7;
        tt5.a.k("Comment#CardComment2", "focusInput: not comment permission");
        return;
    L7:
        if (Intrinsics.areEqual(UT(), r5.getCommentId()) == true) goto L10;
        tt5.a.h("Comment#CardComment2", "focusInput: not current comment, currentCommentId = ".concat(UT()));
        return;
    L10:
        tt5.a.h("Comment#CardComment2", "focusInput: " + r5);
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.p;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L13:
        VerticalViewPager r3 = this.m;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r3 = null;
    L16:
        CommentBean r1 = r0.e(Integer.valueOf(r3.getCurrentItem()));
        if (r1 != null) goto L20;
        tt5.a.k("Comment#CardComment2", "focusInput: commentBean is null");
        return;
    L20:
        int r4 = r5.getType();
        if (r4 != 0) goto L23;
        tt5.a.k("Comment#CardComment2", "unsupported type");
        return;
    L23:
        if (r4 != 1) goto L25;
        int r2 = com.bytedance.ee.bear.middleground.comment.input.utils.c.a;
        com.bytedance.ee.bear.middleground.comment.input.utils.c.a(r1, r5.getReplyId(), this.e, this.f, r5.getFrom());
        return;
    L25:
        if (r4 != 2) goto L33;
        m(this, r1, null, 6);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
        this.E = r1;
    }

    public final void e(boolean r4) {
        VerticalViewPager r0 = this.m;
        CommentPagerAdapter2 r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r0 = null;
    L5:
        RecyclerView.Adapter r2 = r0.getAdapter();
        if ((r2 instanceof CommentPagerAdapter2) == false) goto L8;
        r1 = (CommentPagerAdapter2) r2;
    L8:
        if (r1 == null) goto L11;
        r1.p = r4;
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void hc(ScrollCommentBean r7) {
        Intrinsics.checkNotNullParameter(r7, "scrollCommentBean");
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.p;
        CommentPagerAdapter2 r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        String r3 = r7.cur_comment_id;
        int r4 = com.bytedance.ee.bear.middleground.comment.card.d.l;
        r0.s(r3, null);
        com.bytedance.ee.bear.middleground.comment.card.d r1 = this.p;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L8:
        VerticalViewPager r5 = this.m;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r5 = null;
    L11:
        int r6 = r1.j(r5.getCurrentItem());
        VerticalViewPager r8 = this.m;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r8 = null;
    L15:
        if (r6 == r8.getCurrentItem()) goto L19;
        tt5.a.h("Comment#CardComment2", "commentCardScrollTo: outPosition = " + r6);
        return;
    L19:
        if (r7.replyId.equals(ScrollCommentBean.HEAD) == false) goto L25;
        CommentPagerAdapter2 r9 = this.o;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L24:
        r2.B2(r6, 1, r7.replyPercentage);
        return;
    L23:
        r2 = r9;
        goto L24
    L25:
        com.bytedance.ee.bear.middleground.comment.card.d r10 = this.p;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r10 = null;
    L28:
        int r11 = r10.h(r6, r7.replyId);
        if (r11 >= 0) goto L32;
        tt5.a.h("Comment#CardComment2", "commentCardScrollTo: replyId fail");
        return;
    L32:
        CommentPagerAdapter2 r12 = this.o;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L36:
        r2.B2(r6, r11, r7.replyPercentage);
        return;
    L35:
        r2 = r12;
        goto L36
    }

    public final void p(boolean r8) {
        View r3 = null;
        if (r8 == true) goto L5;
    L78:
        VerticalViewPager r9 = this.m;
        if (r9 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r9 = null;
    L81:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L84;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L85:
        if (r11 == null) goto L87;
        r11.bottomMargin = 0;
    L87:
        View r12 = this.v;
        if (r12 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("inputCommentView");
    L91:
        r3.setVisibility(8);
        return;
    L90:
        r3 = r12;
        goto L91
    L84:
        r11 = null;
        goto L85
    L5:
        if (com.bytedance.ee.util.ui.n.C(this.e.getActivity()) == false) goto L13;
        View r13 = this.l;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r13 = null;
    L10:
        if (ku5.c.k(r13.getContext()) == true) goto L13;
        if (this.e.C == false) goto L78;
    L13:
        com.bytedance.ee.bear.middleground.comment.card.d r14 = this.p;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r14 = null;
    L16:
        com.bytedance.ee.bear.middleground.comment.card.d r5 = this.p;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r5 = null;
    L19:
        VerticalViewPager r6 = this.m;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r6 = null;
    L23:
        if (r14.q(r5.f(Integer.valueOf(r6.getCurrentItem()))) == true) goto L78;
        com.bytedance.ee.bear.middleground.comment.card.d r15 = this.p;
        if (r15 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r15 = null;
    L27:
        VerticalViewPager r7 = this.m;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r7 = null;
    L31:
        if (r15.r(r7.getCurrentItem()) == false) goto L78;
        if (this.I > 0) goto L78;
        com.bytedance.ee.bear.middleground.comment.card.d r16 = this.p;
        if (r16 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r16 = null;
    L37:
        VerticalViewPager r17 = this.m;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r17 = null;
    L41:
        if (r16.m(r17.getCurrentItem()) == false) goto L78;
        com.bytedance.ee.bear.middleground.comment.card.d r18 = this.p;
        if (r18 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r18 = null;
    L45:
        VerticalViewPager r19 = this.m;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r19 = null;
    L49:
        if (r18.n(r19.getCurrentItem()) == true) goto L78;
        com.bytedance.ee.bear.middleground.comment.card.d r20 = this.p;
        if (r20 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r20 = null;
    L53:
        VerticalViewPager r4 = this.m;
        if (r4 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r4 = null;
    L57:
        if (r20.l(r4.getCurrentItem(), CommentAction.INPUT) == true) goto L78;
        VerticalViewPager r21 = this.m;
        if (r21 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r21 = null;
    L61:
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L64;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
    L65:
        if (r23 == null) goto L73;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = this.e;
        if (r2.C == true) goto L69;
    L71:
        int r24 = L0;
    L72:
        r23.bottomMargin = r24;
        goto L73
    L69:
        if (com.bytedance.ee.util.ui.n.C(r2.getActivity()) == false) goto L71;
        r24 = P0;
    L73:
        View r25 = this.v;
        if (r25 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("inputCommentView");
    L77:
        r3.setVisibility(0);
        return;
    L76:
        r3 = r25;
        goto L77
    L64:
        r23 = null;
        goto L65
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void qN(boolean r8) {
        this.k.d();
        p(this.e.q.getComment());
        this.C = this.e.q.getComment();
        CommentPagerAdapter2 r0 = this.o;
        CommentPagerAdapter2 r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r0 = null;
    L5:
        Iterator r3 = ((LinkedHashMap) r0.l).keySet().iterator();
    L6:
        int r5 = 0;
        if (r3.hasNext() == false) goto L13;
        int r4 = ((Number) r3.next()).intValue();
        List<CommentBean> r6 = r0.b;
        if (r6 == null) goto L11;
        r5 = r6.size();
    L11:
        if (r4 >= r5) goto L6;
        Object r7 = ((LinkedHashMap) r0.l).get(Integer.valueOf(r4));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        r0.z2((RecyclerView) r7, r4, r8);
        goto L6
    L13:
        VerticalViewPager r9 = this.m;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r9 = null;
    L16:
        RecyclerView r10 = r9.mRecyclerView;
        if (r10 == null) goto L29;
        int r1 = this.p0;
        CommentPagerAdapter2 r11 = this.o;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L22:
        r10.scrollToPosition(Math.max(0, Math.min(r1, r2.getItemCount() - 1)));
        return;
    L21:
        r2 = r11;
        goto L22
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void r20(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        r4.postDelayed(new c(this, r4), 200);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void tI(String r3) {
        VerticalViewPager r0 = null;
        if (r3 != null) goto L5;
    L12:
        com.bytedance.ee.bear.middleground.comment.card.d r4 = this.p;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r4 = null;
    L15:
        VerticalViewPager r1 = this.m;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L19:
        r3 = r4.f(Integer.valueOf(r0.getCurrentItem()));
    L20:
        this.L = r3;
        n();
        return;
    L18:
        r0 = r1;
        goto L19
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r3 = null;
    L11:
        if (r3 != null) goto L20;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Q6(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "commentId");
        com.bytedance.ee.bear.middleground.comment.card.d r5 = this.p;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r5 = null;
    L5:
        int r1 = com.bytedance.ee.bear.middleground.comment.card.d.l;
        r5.s(r3, null);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void fj(String r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r11, "targetId");
        super.fj(r11, r12);
        if (ForsetiHelper.d() == false) goto L5;
        this.R.getViewTreeObserver().addOnPreDrawListener(this.V);
    L5:
        int r0 = com.bytedance.ee.bear.middleground.comment.card.a.a;
        com.bytedance.ee.bear.middleground.comment.card.d r1 = null;
        if (isShowing() == false) goto L9;
        tt5.a.k("Comment#CardComment2", "saveStatusbarState: isShowing,avoid repeated save");
    L24:
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = this.e;
        if (r2.s == false) goto L27;
    L59:
        CardIndicator r3 = this.n;
        if (r3 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("pagerIndicator");
        r3 = null;
    L62:
        r3.setVisibility(0);
        e(false);
        this.f.a().add(this.X);
        this.f.f().add(this.Z);
        q();
        com.bytedance.ee.bear.middleground.comment.card.d r4 = this.p;
        if (r4 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r4 = null;
    L65:
        r4.s(r11, null);
        this.k.n();
        com.bytedance.ee.bear.middleground.comment.card.d r13 = this.p;
        if (r13 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r13 = null;
    L68:
        MutableLiveData<List<CommentBean>> r14 = r13.f;
        if (r14 == null) goto L71;
        r14.removeObservers(this.e.getActivity());
    L71:
        com.bytedance.ee.bear.middleground.comment.card.d r15 = this.p;
        if (r15 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r15 = null;
    L74:
        MutableLiveData<List<CommentBean>> r16 = r15.f;
        if (r16 == null) goto L77;
        r16.observe(this.e.getActivity(), new e(this));
    L77:
        tt5.a.h("Comment#CardComment2", "show card comment");
        com.bytedance.ee.bear.middleground.comment.uitls.h r5 = this.e.d0;
        r5.c = false;
        r5.d("view_docs_message_sub_page", null, "", "", true);
        com.bytedance.ee.bear.middleground.comment.card.d r17 = this.p;
        if (r17 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r17 = null;
    L80:
        r17.g = r12;
        View r18 = this.l;
        if (r18 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r18 = null;
    L83:
        ViewParent r19 = r18.getParent();
        if ((r19 instanceof ViewGroup) == false) goto L86;
        ViewGroup r110 = (ViewGroup) r19;
    L87:
        if (r110 == null) goto L92;
        View r6 = this.l;
        if (r6 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r6 = null;
    L91:
        r110.removeView(r6);
    L92:
        this.e.c.addOnLayoutChangeListener(this.Y);
        FrameLayout r111 = this.e.c;
        View r7 = this.l;
        if (r7 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r7 = null;
    L95:
        r111.addView(r7);
        Function1<Boolean, Unit> r112 = this.f.n();
        if (r112 == null) goto L98;
        r112.invoke(Boolean.TRUE);
    L98:
        gf5.d r113 = this.e.N;
        com.bytedance.ee.bear.middleground.comment.card.d r8 = this.p;
        if (r8 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L102:
        r113.a(new ef5.i(r1.k));
        return;
    L101:
        r1 = r8;
        goto L102
    L86:
        r110 = null;
        goto L87
    L27:
        if (r2.t == false) goto L59;
        if (r2.P == false) goto L59;
        if (r2.k != sbb.e.i) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r9 == false) goto L54;
        View r10 = b(this.e.getActivity().getWindow());
        Activity r20 = this.e.getActivity();
        int r21 = (r10.getSystemUiVisibility() & (-1025)) & (-257);
        List r22 = (List) ((HashMap) bp5.c.b).get(Integer.valueOf(r20.hashCode()));
        if (r22 == null) goto L49;
        if (r22.isEmpty() == true) goto L49;
        int r23 = r22.size();
    L43:
        r23 = r23 - 1;
        if (r23 < 0) goto L49;
        if (((bp5.c.a) ListProtector.get(r22, r23)).interceptSetSystemUiVisibility(r20, r21) == false) goto L43;
    L53:
        this.k0 = true;
    L49:
        if (r20.getWindow() == null) goto L53;
        if (bp5.c.a(r20.getWindow()) == null) goto L53;
        bp5.c.a(r20.getWindow()).setSystemUiVisibility(r21);
    L54:
        int r24 = this.e.getActivity().getResources().getColor(2131100562);
        FragmentActivity r25 = this.e.getActivity();
        Fragment r26 = this.e.b;
        if (r26 == null) goto L57;
        Fragment r27 = r26.getParentFragment();
    L58:
        bp5.c.e(r25, ForsetiHelper.g(r27), r24, this.r);
        goto L59
    L57:
        r27 = null;
        goto L58
    L34:
        if ((b(r2.getActivity().getWindow()).getSystemUiVisibility() & DocUserPermission.USER_PERM_FULL_ACCESS) != 1024) goto L36;
        r9 = true;
        goto L37
    L9:
        if (ForsetiHelper.s(this.e.b) == false) goto L17;
        Fragment r28 = this.e.b;
        if (r28 == null) goto L15;
        Fragment r29 = r28.getParentFragment();
        if (r29 == null) goto L15;
        Integer r30 = Integer.valueOf(WindowInsetsUtils.b(r29).a());
    L16:
        this.q = r30;
    L15:
        r30 = null;
        goto L16
    L17:
        this.q = Integer.valueOf(this.e.getActivity().getWindow().getStatusBarColor());
        if (Build.VERSION.SDK_INT < 23) goto L24;
        if ((b(this.e.getActivity().getWindow()).getSystemUiVisibility() & 8192) != 8192) goto L22;
        boolean r31 = true;
    L23:
        this.r = r31;
        goto L24
    L22:
        r31 = false;
        goto L23
    }

    public final void o(boolean r5, Boolean r6) {
        CommentVoiceHostPolicy.Route r0 = com.bytedance.ee.bear.middleground.comment.export.e.c();
        if (r0 != CommentVoiceHostPolicy.Route.DISABLED) goto L5;
        return;
    L5:
        boolean r1 = true;
        int r2 = 0;
        if (r6 == null) goto L9;
        boolean r7 = r6.booleanValue();
    L23:
        boolean r3 = this.K;
        if (r5 == true) goto L26;
    L31:
        r1 = false;
    L32:
        this.K = r1;
        View r8 = this.x;
        if (r8 == null) goto L38;
        if (r1 == false) goto L36;
        int r4 = 8;
    L37:
        r8.setVisibility(r4);
        goto L38
    L36:
        r4 = 0;
    L38:
        View r9 = this.y;
        if (r9 == null) goto L46;
        if (this.K == true) goto L44;
        r2 = 8;
    L44:
        r9.setVisibility(r2);
    L46:
        if (r3 == this.K) goto L48;
        this.f.k1().invoke(Boolean.valueOf(this.K));
    L48:
        if (r3 == false) goto L50;
        return;
    L50:
        if (this.K == true) goto L52;
        return;
    L52:
        if (r0 != CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT) goto L59;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k r10 = (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k) this.O.getValue();
        if (r10 == null) goto L60;
        r10.c();
        return;
    L60:
        return;
    L59:
        return;
    L26:
        if (this.e.s == true) goto L31;
        if (this.D.f() == false) goto L31;
        if (r7 == true) goto L31;
    L9:
        if (this.F.length() <= 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == true) goto L22;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r12 = this.G;
        if (r12 != null) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r13 == true) goto L22;
        r7 = false;
        goto L23
    L16:
        if ((!r12.isEmpty()) != true) goto L18;
        r13 = true;
    L22:
        r7 = true;
        goto L23
    L11:
        r11 = false;
        goto L12
    }

    public final void t(boolean r3, CommentVoiceHostPolicy.Route r4) {
        if (r4 != CommentVoiceHostPolicy.Route.DISABLED) goto L5;
        return;
    L5:
        View r5 = this.v;
        TextView r0 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputCommentView");
        r5 = null;
    L8:
        if (r3 == false) goto L10;
        int r1 = 2131233319;
    L11:
        r5.setBackgroundResource(r1);
        if (this.K == true) goto L14;
        return;
    L14:
        View r6 = this.B;
        if ((r6 instanceof TextView) == false) goto L17;
        r0 = (TextView) r6;
    L17:
        if (r0 == null) goto L23;
        if (r3 == false) goto L20;
        int r7 = 2131890974;
    L21:
        r0.setText(r7);
        return;
    L20:
        r7 = 2131890964;
        goto L21
    L23:
        return;
    L10:
        r1 = 2131233318;
        goto L11
    }

    public static final void c(FloatCardComment r7, RecyclerView r8, int r9) {
        r7.getClass();
        tt5.a.h("Comment#CardComment2", "inputCommentTop = " + r9 + "  rv = " + r8);
        CardIndicator r2 = null;
        VerticalViewPager r3 = null;
        if (r9 > 0) goto L20;
        CardIndicator r10 = r7.n;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("pagerIndicator");
        r10 = null;
    L7:
        r10.setVisibility(0);
        if (r8 == null) goto L10;
        r8.setVerticalFadingEdgeEnabled(true);
    L10:
        r7.e(false);
        CommentPagerAdapter2 r11 = r7.o;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r11 = null;
    L13:
        r11.A2();
        if (r7.e.s == false) goto L32;
        VerticalViewPager r12 = r7.m;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L19:
        r3.postDelayed(new k(r7), 50);
        return;
    L18:
        r3 = r12;
        goto L19
    L32:
        return;
    L20:
        CardIndicator r5 = r7.n;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("pagerIndicator");
    L24:
        r2.setVisibility(4);
        if (r8 == null) goto L27;
        r8.setVerticalFadingEdgeEnabled(false);
    L27:
        r7.e(true);
        int[] r0 = new int[2];
        r7.e.c.getLocationOnScreen(r0);
        int r4 = (r0[1] + r7.e.c.getHeight()) - r9;
        tt5.a.h("Comment#CardComment2", "calculatePadding diff = " + r4 + "  viewPager.location[1] = " + r0[1] + " config.viewParent.height = " + r7.e.c.getHeight() + " inputCommentTop = " + r9 + ' ');
        if (r4 < 0) goto L34;
        if (r8 == null) goto L35;
        r8.setPadding(0, 0, 0, r4);
        return;
    L35:
        return;
    L34:
        return;
    L23:
        r2 = r5;
        goto L24
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void bG(String r3, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4, SmartReplyDataForInsert r5) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        this.H = null;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        s(r3, r4, r5);
        return;
    L13:
        com.bytedance.ee.util.ui.j.c(new f(this, r3, r4, r5));
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void l(CommentBean r13, boolean r14, Boolean r15) {
        com.bytedance.ee.bear.middleground.comment.export.m r0 = this.e.M;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        String r3 = "";
        if (r13 == null) goto L14;
        String r4 = r13.getComment_id();
        if (r4 == null) goto L14;
    L15:
        if (r13 == null) goto L24;
        List<CommentBean.CommentDetail> r5 = r13.getComment_list();
        if (r5 == null) goto L24;
        CommentBean.CommentDetail r6 = (CommentBean.CommentDetail) CollectionsKt.lastOrNull(r5);
        if (r6 == null) goto L24;
        String r7 = r6.getReply_id();
        if (r7 == null) goto L24;
        r3 = r7;
    L24:
        this.e.N.a(new ef5.f0());
        com.bytedance.ee.bear.middleground.comment.uitls.h r8 = this.e.d0;
        int r10 = 2;
        Pair[] r9 = new Pair[2];
        r9[0] = TuplesKt.to(ResourceData.KEY_TYPE, "comment");
        CommentBean.CommentDetail.ExtraEntity r11 = null;
        if (r13 == null) goto L29;
        CommentBean.Extra r12 = r13.getExtra();
        if (r12 == null) goto L29;
        String r16 = r12.getReportVisibility();
    L30:
        r9[1] = TuplesKt.to("comment_visible_range", r16);
        r8.g("input_box", r4, null, MapsKt.mapOf(r9));
        this.e.d0.d("reply_comment", null, r4, null, false);
        com.bytedance.ee.bear.middleground.comment.card.d r17 = this.p;
        if (r17 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r17 = null;
    L33:
        VerticalViewPager r18 = this.m;
        if (r18 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r18 = null;
    L36:
        CommentBean r19 = r17.e(Integer.valueOf(r18.getCurrentItem()));
        CommentTextView r20 = this.s;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r20 = null;
    L39:
        r20.getRawString();
        CommentInputRequest r21 = new CommentInputRequest();
        r21.comment_id = r4;
        if (r13 == null) goto L45;
        CommentBean.Extra r22 = r13.getExtra();
        if (r22 == null) goto L45;
        VisibilityBean r23 = r22.getNewInputVisibility();
        if (r23 == null) goto L45;
    L52:
        r21.visibilityBean = r23;
        if (r13 == null) goto L55;
        int r24 = r13.getCommentType();
    L56:
        r21.setCommentType(r24);
        r21.lastReplyId = r3;
        r21.is_whole = false;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L60;
        r14 = true;
    L60:
        r21.keyboard_pop = r14;
        r21.restoreVoiceModeOnVoiceClick = r15;
        r21.show_voice = true;
        com.bytedance.ee.bear.middleground.comment.uitls.p r110 = this.e;
        r21.show_insert_image = r110.E;
        r21.doc_url = r110.j;
        r21.show_comment_image = r110.F;
        if (r13 != null) goto L63;
    L65:
        boolean r111 = false;
    L66:
        if (r111 == false) goto L68;
        r10 = 0;
    L68:
        r21.type = r10;
        r21.canUseBlankContent = true;
        r21.content = this.F;
        if (r19 == null) goto L71;
        String r112 = r19.getPosition();
    L72:
        r21.position = r112;
        if (r19 == null) goto L75;
        Map<Object, Object> r113 = r19.getBizParams();
    L76:
        r21.bizParams = r113;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r114 = this.G;
        if (r114 != null) goto L79;
    L81:
        r1 = false;
    L82:
        if (r1 == false) goto L84;
        r11 = new CommentBean.CommentDetail.ExtraEntity();
        r11.setImage_list(new ArrayList());
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r115 = r11.getImage_list();
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r116 = this.G;
        Intrinsics.checkNotNull(r116);
        r115.addAll(r116);
    L84:
        r21.extra = r11;
        this.i.invoke(r21);
        return;
    L79:
        if ((!r114.isEmpty()) != true) goto L81;
    L75:
        r113 = null;
        goto L76
    L71:
        r112 = null;
        goto L72
    L63:
        if (r13.isTmpCard() != true) goto L65;
        r111 = true;
        goto L66
    L55:
        r24 = 0;
    L45:
        r23 = new VisibilityBean(0, 1, null);
        if (r13 == null) goto L50;
        CommentBean.Extra r25 = r13.getExtra();
        if (r25 == null) goto L50;
        int r26 = r25.getVisibility();
    L51:
        r23.setType(r26);
    L50:
        r26 = 0;
    L29:
        r16 = null;
    L14:
        r4 = "";
        goto L15
    L5:
        if (r0.b() == true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void s(String r9, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r10, SmartReplyDataForInsert r11) {
        String r0 = "";
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        this.F = r9;
        this.G = r10;
        this.H = r11;
        if (r9.length() != 0) goto L8;
        boolean r12 = true;
    L9:
        CommentTextView r1 = null;
        if (r12 == false) goto L25;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r13 = this.G;
        if (r13 == null) goto L15;
        Intrinsics.checkNotNull(r13);
        if (r13.isEmpty() == false) goto L25;
    L15:
        ImageView r14 = this.u;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("sendIv");
        r14 = null;
    L18:
        r14.setEnabled(false);
        CommentTextView r15 = this.s;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
    L22:
        r1.setRawString("");
        if (r() == false) goto L52;
        n();
        return;
    L52:
        return;
    L21:
        r1 = r15;
    L25:
        ImageView r16 = this.u;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("sendIv");
        r16 = null;
    L28:
        r16.setEnabled(true);
        CommentTextView r17 = this.s;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r17 = null;
    L31:
        StringBuilder r2 = new StringBuilder();
        r2.append(this.F);
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4 = this.G;
        if (r4 != null) goto L34;
    L41:
        r2.append(r0);
        r17.setRawString(r2.toString());
        SharePermissionViewModel r18 = this.k;
        AppCompatTextView r3 = this.s;
        if (r3 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r3 = null;
    L44:
        int r5 = SharePermissionViewModel.j;
        r18.i(r3, true, null);
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L47;
        return;
    L47:
        if (r() == false) goto L49;
        n();
        return;
    L49:
        o(false, null);
        return;
    L34:
        if (r4.isEmpty() == true) goto L41;
        String r6 = "[" + this.e.getActivity().getString(((pw4.f) org.koin.java.a.c(pw4.f.class, null, null, 6)).a()) + ']';
        StringBuilder r7 = new StringBuilder();
        Iterator<T> r8 = r4.iterator();
    L38:
        if (r8.hasNext() == false) goto L40;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r19 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r8.next();
        r7.append(r6);
        goto L38
    L40:
        r0 = r7.toString();
        goto L41
    L8:
        r12 = false;
        goto L9
    }

    public static final void d(FloatCardComment r25, CharSequence r26, String r27, boolean r28) {
        com.bytedance.ee.bear.middleground.comment.card.d r1 = r25.p;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L5:
        int r2 = r1.i(r27);
        if (r2 != (-1)) goto L11;
        tt5.a.h("Comment#CardComment2", "skip voice reply publish because session comment is gone");
        CommentImmersiveVoiceTouchDelegate r3 = r25.i();
        if (r3 == null) goto L10;
        r3.a();
    L10:
        r25.M = null;
        r25.o(false, null);
        return;
    L11:
        com.bytedance.ee.bear.middleground.comment.card.d r4 = r25.p;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r4 = null;
    L14:
        CommentBean r8 = r4.e(Integer.valueOf(r2));
        r25.e.N.a(new ef5.h(r27, null, 2, false, false));
        String r14 = com.larksuite.framework.utils.l0.a().toString();
        af5.b r5 = r25.e.Q;
        if (r5 == null) goto L19;
        com.bytedance.ee.bear.middleground.comment.performance.d r6 = r5.b();
        if (r6 == null) goto L19;
        r6.e(r14, "reply");
    L19:
        StringBuilder r7 = new StringBuilder("[voiceSend] float reply shouldAuthorize=");
        r7.append(r28);
        r7.append(", ");
        CommentVoiceLog.a.getClass();
        r7.append(CommentVoiceLog.d("commentId", r27));
        r7.append(", ");
        r7.append(CommentVoiceLog.i("content", r26));
        tt5.a.h("CommentVoice", r7.toString());
        int r9 = CommentVoiceEditTextBridge.i;
        String r10 = CommentVoiceEditTextBridge.a.b(r26);
        if (r8 == null) goto L22;
        String r16 = r8.getPosition();
    L23:
        if (r8 == null) goto L25;
        Map<Object, Object> r18 = r8.getBizParams();
    L26:
        if (r8 == null) goto L28;
        int r22 = r8.getCommentType();
    L29:
        Flowable<String> r11 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r25.g.B(new com.bytedance.ee.bear.rn.e(null, r10, r27, false, false, null, null, null, null, null, r28, null, r16, r18, r14, null, r22, null, 35785)), null);
        if (r11 == null) goto L32;
        Disposable r15 = r11.subscribe(new o(r25), new p(r25));
    L33:
        com.bytedance.ee.bear.middleground.comment.card.d r0 = r25.p;
        if (r0 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L36:
        r0.a(r15);
        return;
    L32:
        r15 = null;
        goto L33
    L28:
        r22 = 0;
        goto L29
    L25:
        r18 = null;
        goto L26
    L22:
        r16 = null;
        goto L23
    }

    public static /* synthetic */ void m(FloatCardComment r1, CommentBean r2, Boolean r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        r1.l(r2, r0, r3);
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void XC(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "content");
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r11, "aiReplyId");
        CommentInputRequest r0 = new CommentInputRequest();
        com.bytedance.ee.bear.middleground.comment.card.d r1 = z7();
        CommentBean.CommentDetail.ExtraEntity r2 = null;
        if (r1 == null) goto L8;
        VerticalViewPager r3 = this.m;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r3 = null;
    L7:
        CommentBean r4 = r1.e(Integer.valueOf(r3.getCurrentItem()));
    L9:
        r0.comment_id = r9;
        int r5 = 0;
        if (r4 == null) goto L15;
        CommentBean.Extra r6 = r4.getExtra();
        if (r6 == null) goto L15;
        VisibilityBean r7 = r6.getNewInputVisibility();
        if (r7 == null) goto L15;
    L22:
        r0.visibilityBean = r7;
        if (r4 == null) goto L25;
        int r12 = r4.getCommentType();
    L26:
        r0.setCommentType(r12);
        if (r4 == null) goto L34;
        List<CommentBean.CommentDetail> r13 = r4.getComment_list();
        if (r13 == null) goto L34;
        CommentBean.CommentDetail r14 = (CommentBean.CommentDetail) CollectionsKt.lastOrNull(r13);
        if (r14 == null) goto L34;
        String r15 = r14.getReply_id();
        if (r15 == null) goto L34;
    L35:
        r0.lastReplyId = r15;
        r0.is_whole = false;
        r0.keyboard_pop = true;
        r0.show_voice = true;
        com.bytedance.ee.bear.middleground.comment.uitls.p r16 = this.e;
        r0.show_insert_image = r16.E;
        r0.doc_url = r16.j;
        r0.show_comment_image = r16.F;
        if (r4 != null) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == true) goto L44;
        r5 = 2;
    L44:
        r0.type = r5;
        r0.canUseBlankContent = true;
        r0.content = r8;
        if (r4 == null) goto L47;
        String r18 = r4.getPosition();
    L48:
        r0.position = r18;
        if (r4 == null) goto L51;
        Map<Object, Object> r19 = r4.getBizParams();
    L52:
        r0.bizParams = r19;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r20 = this.G;
        if (r20 != null) goto L55;
    L60:
        r0.extra = r2;
        SmartReplyDataForInsert r21 = new SmartReplyDataForInsert();
        r0.smartReplyDataForInsert = r21;
        r21.setAiReplyId(r11);
        r0.smartReplyDataForInsert.setReplyId(r10);
        r0.smartReplyDataForInsert.setCommentId(r9);
        r0.smartReplyDataForInsert.setText(r8);
        this.H = r0.smartReplyDataForInsert;
        this.i.invoke(r0);
        return;
    L55:
        if ((true ^ r20.isEmpty()) == true) goto L58;
        r20 = null;
    L58:
        if (r20 == null) goto L60;
        r2 = new CommentBean.CommentDetail.ExtraEntity();
        r2.setImage_list(new ArrayList(r20));
        goto L60
    L51:
        r19 = null;
        goto L52
    L47:
        r18 = null;
        goto L48
    L38:
        if (r4.isTmpCard() != true) goto L40;
        r17 = true;
    L34:
        r15 = "";
        goto L35
    L25:
        r12 = 0;
    L15:
        r7 = new VisibilityBean(0, 1, null);
        if (r4 == null) goto L20;
        CommentBean.Extra r22 = r4.getExtra();
        if (r22 == null) goto L20;
        int r23 = r22.getVisibility();
    L21:
        r7.setType(r23);
    L20:
        r23 = 0;
        goto L21
    L8:
        r4 = null;
        goto L9
    }

    public final boolean g(View r7, MotionEvent r8, boolean r9, String r10) {
        CommentVoiceHostPolicy.Route r5 = com.bytedance.ee.bear.middleground.comment.export.e.c();
        int r0 = r8.getAction() & 255;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        t(false, r5);
    L11:
        return f(r7, r8, r9, r10, r5);
    L6:
        if (r0 == 3) goto L8;
    L9:
        t(true, r5);
        goto L11
    }

    public final boolean f(View r13, MotionEvent r14, boolean r15, String r16, CommentVoiceHostPolicy.Route r17) {
        int r2 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        FragmentActivity r3 = this.e.getActivity();
        boolean r10 = true;
        if (r17 == CommentVoiceHostPolicy.Route.DISABLED) goto L5;
        boolean r4 = true;
    L7:
        if (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.b(r3, r14, r4, this.f.P()) == false) goto L9;
        return true;
    L9:
        CommentVoiceHostPolicy.Route r5 = CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT;
        if (r17 != r5) goto L26;
        Intrinsics.checkNotNullParameter(r17, "route");
        if (r17 == r5) goto L15;
        r10 = false;
    L15:
        if (r10 == true) goto L17;
        return false;
    L17:
        if (r14.getActionMasked() != 0) goto L21;
        Fragment r1 = this.e.b;
        if (r1 == null) goto L21;
        CommentVoiceExtraAnalyticParams.a.update(r1, r16);
    L21:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k r6 = (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k) this.O.getValue();
        if (r6 != null) goto L24;
        return false;
    L24:
        return r6.onTouch(r13, r14);
    L26:
        if (r17 == CommentVoiceHostPolicy.Route.LARK_IM) goto L28;
        return r15;
    L28:
        com.bytedance.ee.bear.middleground.comment.card.d r7 = this.p;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r7 = null;
    L31:
        VerticalViewPager r8 = this.m;
        if (r8 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r8 = null;
    L34:
        final String r9 = r7.f(Integer.valueOf(r8.getCurrentItem()));
        if (r14.getActionMasked() != 0) goto L37;
        this.M = null;
    L37:
        CommentImmersiveVoiceTouchDelegate r11 = (CommentImmersiveVoiceTouchDelegate) this.N.getValue();
        if (r11 == null) goto L41;
        r11.b(r13, r14, new FloatCardComment$dispatchVoiceTouch$1(this), (CommentVoiceInputResultConsumer) this.H0.getValue(), r16, new FloatCardComment$dispatchVoiceTouch$2(this, r9), this.f.n1(), new FloatCardComment$dispatchVoiceTouch$3((CommentVoiceMentionPermissionHelper) this.P.getValue()));
        return true;
    L41:
        return r15;
    L5:
        r4 = false;
        goto L7
    }

    public FloatCardComment(com.bytedance.ee.bear.middleground.comment.uitls.p r24, Comment r25, com.bytedance.ee.bear.middleground.comment.control.t r26, com.bytedance.ee.bear.middleground.comment.control.y r27, Function1 r28, Function0 r29) {
        SharePermissionViewModel r7 = new SharePermissionViewModel(r24);
        Intrinsics.checkNotNullParameter(r24, "config");
        Intrinsics.checkNotNullParameter(r25, "commentListeners");
        Intrinsics.checkNotNullParameter(r26, "dataControl");
        Intrinsics.checkNotNullParameter(r27, "actionControl");
        Intrinsics.checkNotNullParameter(r28, "relpy");
        Intrinsics.checkNotNullParameter(r29, "interceptClickEmpty");
        Intrinsics.checkNotNullParameter(r7, "sharePermissionViewModel");
        super(r24, r25, r26, r27);
        this.e = r24;
        this.f = r25;
        this.g = r26;
        this.h = r27;
        this.i = r28;
        this.j = r29;
        this.k = r7;
        b2 r5 = new b2(r24, r26, r25);
        this.D = r5;
        this.F = "";
        this.J = "";
        this.N = LazyKt.lazy(new FloatCardComment$immersiveVoiceTouchDelegateLazy$1(this));
        this.O = LazyKt.lazy(new FloatCardComment$unifiedVoiceComponentSessionLazy$1(this));
        this.P = LazyKt.lazy(new FloatCardComment$voiceMentionPermissionHelper$2(this));
        this.Q = com.bytedance.ee.util.ui.n.c(376.0f);
        FragmentActivity r6 = r24.getActivity();
        this.R = (ViewGroup) r6.findViewById(R.id.content);
        ForsetiViewMode r11 = ForsetiViewMode.UNKNOWN;
        this.S = r11;
        this.T = r11;
        this.V = new n(this);
        g0 r12 = new g0(this);
        this.W = r12;
        View r13 = LayoutInflater.from(r24.getActivity()).inflate(2131559854, null);
        this.l = r13;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r15 = null;
    L6:
        r15.setOnGenericMotionListener(new j());
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r14 = null;
    L10:
        CardIndicator r16 = (CardIndicator) r14.findViewById(2131367365);
        this.n = r16;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r17 = null;
    L14:
        VerticalViewPager r18 = (VerticalViewPager) r17.findViewById(2131369308);
        this.m = r18;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        VerticalViewPager r8 = null;
    L18:
        r8.setOrientation(1);
        if (r18 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        VerticalViewPager r9 = null;
    L22:
        r9.setOffscreenPageLimit(1);
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r10 = null;
    L26:
        this.w = r10.findViewById(2131375349);
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L85;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r19 = null;
    L31:
        this.v = r19.findViewById(2131375352);
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r20 = null;
    L35:
        this.x = r20.findViewById(2131375353);
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r21 = null;
    L39:
        this.y = r21.findViewById(2131375354);
        if (r13 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r22 = null;
    L43:
        this.z = r22.findViewById(2131367477);
        if (r13 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r23 = null;
    L47:
        this.A = r23.findViewById(2131367381);
        ew4.g r30 = r24.X.l();
        if (r30 == null) goto L54;
        Integer r31 = r30.a;
        if (r31 == null) goto L54;
        int r32 = r31.intValue();
        AppCompatImageView r110 = this.A;
        if (r110 == null) goto L54;
        r110.setImageResource(r32);
    L54:
        if (r13 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r33 = null;
    L57:
        this.B = r33.findViewById(2131367476);
        if (r13 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r34 = null;
    L61:
        this.u = (ImageView) r34.findViewById(2131369349);
        if (r13 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r35 = null;
    L65:
        this.s = (CommentTextView) r35.findViewById(2131369301);
        if (r13 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r36 = null;
    L69:
        this.t = r36.findViewById(2131367410);
        View r37 = this.w;
        if (r37 == null) goto L72;
        r37.setVisibility(8);
    L72:
        AppCompatImageView r38 = this.z;
        if (r38 != null) goto L75;
    L81:
        View r39 = this.v;
        if (r39 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("inputCommentView");
        r39 = null;
    L84:
        r39.setVisibility(0);
        o(false, null);
    L104:
        CommentTextView r40 = this.s;
        if (r40 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r40 = null;
    L107:
        RichTextInjector.b(r40, null, null, false, 24);
        if (r24.G == false) goto L113;
        AppCompatTextView r41 = this.s;
        if (r41 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r41 = null;
    L112:
        zz7.a.d(r41, LarkFont.BODY0);
    L113:
        tt5.a.h("Comment#CardComment2", "initDefaultData");
        com.bytedance.ee.bear.middleground.comment.card.d r42 = new com.bytedance.ee.bear.middleground.comment.card.d();
        this.p = r42;
        r42.k(r24.i, r26);
        CommentPagerAdapter2 r3 = new CommentPagerAdapter2();
        this.o = r3;
        if (r18 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        VerticalViewPager r43 = null;
    L117:
        r3.a = r43;
        CommentPagerAdapter2 r44 = this.o;
        if (r44 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r44 = null;
    L120:
        FragmentActivity r111 = r24.getActivity();
        com.bytedance.ee.bear.middleground.comment.export.o r112 = r24.q;
        String r45 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        com.bytedance.ee.bear.middleground.comment.card.d r113 = this.p;
        if (r113 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r113 = null;
    L123:
        Function0<Unit> r4 = new FloatCardComment$initDefaultData$1(this);
        Function2<Integer, Boolean, Unit> r114 = new FloatCardComment$initDefaultData$2(this);
        r44.getClass();
        Intrinsics.checkNotNullParameter(r24, "config");
        Intrinsics.checkNotNullParameter(r111, "activity");
        Intrinsics.checkNotNullParameter(r112, "per");
        Intrinsics.checkNotNullParameter(r45, "language");
        Intrinsics.checkNotNullParameter(r25, "IListeners");
        Intrinsics.checkNotNullParameter(r27, "actionControl");
        Intrinsics.checkNotNullParameter(r113, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r7, "sharePermissionViewModel");
        Intrinsics.checkNotNullParameter(r4, "clickLink");
        Intrinsics.checkNotNullParameter(r114, "switchItem");
        r44.c = r24;
        r44.d = r111;
        r44.e = r45;
        r44.g = r25;
        r44.h = r27;
        r44.i = r113;
        r44.j = r7;
        r44.k = r4;
        if (r24.getActivity().getResources().getConfiguration().orientation == 2) goto L126;
        boolean r115 = true;
    L127:
        r44.m = r115;
        r44.q = r114;
        if (r18 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        VerticalViewPager r46 = null;
    L131:
        CommentPagerAdapter2 r1 = this.o;
        if (r1 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r1 = null;
    L134:
        r46.setAdapter(r1);
        if (r16 != 0) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("pagerIndicator");
        CardIndicator r47 = null;
    L138:
        if (r18 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        VerticalViewPager r48 = null;
    L141:
        r47.setViewPager2(r48);
        q();
        if (((Boolean) r25.J.invoke()).booleanValue() == false) goto L147;
        if (r13 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r116 = null;
    L146:
        r116.setOnClickListener(new x(this));
        goto L147
    L145:
        r116 = r13;
    L147:
        if (r16 != 0) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("pagerIndicator");
        CardIndicator r117 = null;
    L150:
        r117.setOnClickListener(new y(this));
        View r49 = this.v;
        if (r49 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("inputCommentView");
        r49 = null;
    L153:
        r49.setOnClickListener(new z(this));
        AppCompatTextView r50 = this.s;
        if (r50 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r50 = null;
    L156:
        r50.setOnClickListener(new a0(this));
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L162;
        AppCompatTextView r51 = this.s;
        if (r51 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r51 = null;
    L161:
        r51.setOnTouchListener(new b0(this));
    L162:
        AppCompatTextView r52 = this.s;
        if (r52 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r52 = null;
    L165:
        r52.setOnLongClickListener(new c0(this));
        AppCompatImageView r2 = this.z;
        if (r2 == null) goto L168;
        r2.setOnClickListener(new d0(this));
    L168:
        AppCompatImageView r53 = this.z;
        if (r53 == null) goto L171;
        r53.setOnTouchListener(new e0(this));
    L171:
        AppCompatImageView r54 = this.A;
        if (r54 == null) goto L174;
        r54.setOnClickListener(new f0(this));
    L174:
        AppCompatImageView r55 = this.A;
        if (r55 == null) goto L177;
        r55.setOnLongClickListener(r.a);
    L177:
        View r56 = this.y;
        if (r56 == null) goto L180;
        r56.setOnTouchListener(new s(this));
    L180:
        View r57 = this.B;
        if (r57 == null) goto L183;
        r57.setOnTouchListener(new t(this));
    L183:
        ImageView r58 = this.u;
        if (r58 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("sendIv");
        r58 = null;
    L186:
        r58.setOnClickListener(new u(this));
        ImageView r59 = this.t;
        if (r59 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("privateIcon");
        r59 = null;
    L189:
        r59.setOnClickListener(new v(this));
        Ref.BooleanRef r60 = new Ref.BooleanRef();
        Ref.LongRef r61 = new Ref.LongRef();
        if (r18 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        VerticalViewPager r118 = null;
    L193:
        r118.registerOnPageChangeCallback(new w(r60, this, r61));
        if (ForsetiHelper.d() == false) goto L202;
        tua.b r62 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r6);
        this.U = r62;
        if (r62 == null) goto L198;
        r62.e(r12);
    L198:
        tua.b r63 = this.U;
        if (r63 == null) goto L201;
        r63.P(r12);
    L201:
        k();
    L202:
        this.X = new FloatCardComment$onInputCommentTopChange$1(this);
        this.Y = new m(this);
        this.Z = new FloatCardComment$onInputClose$1(this);
        this.H0 = LazyKt.lazy(new FloatCardComment$voiceResultConsumer$2(this));
        return;
    L192:
        r118 = r18;
        goto L193
    L149:
        r117 = r16;
        goto L150
    L140:
        r48 = r18;
        goto L141
    L137:
        r47 = r16;
        goto L138
    L130:
        r46 = r18;
        goto L131
    L126:
        r115 = false;
        goto L127
    L116:
        r43 = r18;
        goto L117
    L75:
        if (r24.s == false) goto L77;
    L79:
        int r64 = 8;
    L80:
        r38.setVisibility(r64);
        goto L81
    L77:
        if (r5.f() == false) goto L79;
        r64 = 0;
        goto L80
    L68:
        r36 = r13;
        goto L69
    L64:
        r35 = r13;
        goto L65
    L60:
        r34 = r13;
        goto L61
    L56:
        r33 = r13;
        goto L57
    L46:
        r23 = r13;
        goto L47
    L42:
        r22 = r13;
        goto L43
    L38:
        r21 = r13;
        goto L39
    L34:
        r20 = r13;
        goto L35
    L30:
        r19 = r13;
        goto L31
    L85:
        View r65 = this.w;
        if (r65 != null) goto L91;
        if (r13 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r66 = null;
    L90:
        r65 = r66.findViewById(2131375349);
        goto L91
    L89:
        r66 = r13;
    L91:
        this.v = r65;
        if (r13 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r67 = null;
    L95:
        this.u = (ImageView) r67.findViewById(2131369348);
        if (r13 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r68 = null;
    L99:
        this.s = (CommentTextView) r68.findViewById(2131369299);
        if (r13 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r69 = null;
    L103:
        this.t = r69.findViewById(2131367409);
        goto L104
    L102:
        r69 = r13;
        goto L103
    L98:
        r68 = r13;
        goto L99
    L94:
        r67 = r13;
        goto L95
    L25:
        r10 = r13;
        goto L26
    L21:
        r9 = r18;
        goto L22
    L17:
        r8 = r18;
        goto L18
    L13:
        r17 = r13;
        goto L14
    L9:
        r14 = r13;
        goto L10
    L5:
        r15 = r13;
        goto L6
    }
}
