package com.bytedance.ee.bear.middleground.comment.input;

import android.R;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.comment.widget.CommentKeyboardPlaceholderView;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class InputCommentV2 extends BaseInputComment {
    public static final int u0 = 0;
    public final Function1<Integer, Unit> h0;
    public final String i0;
    public boolean j0;
    public final View k0;
    public final ConstraintLayout l0;
    public final RecordPanelView m0;
    public final CommentKeyboardPlaceholderView n0;
    public int o0;
    public Integer p0;
    public final HashSet<String> q0;
    public final boolean r0;
    public final boolean s0;
    public final e t0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputCommentV2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputCommentV2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<unused var>", "", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda implements Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(5);
        }

        public final void invoke(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, boolean r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r1, "<unused var>");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
            invoke((String) r7, (List) r8, ((Boolean) r9).booleanValue(), (String) r10, ((Boolean) r11).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputCommentV2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda implements Function1<Integer, Unit> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1);
        }

        public final void invoke(int r1) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputCommentV2$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda implements Function0<FrameLayout> {
        final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p $configComment;

        public AnonymousClass4(com.bytedance.ee.bear.middleground.comment.uitls.p r1) {
            this.$configComment = r1;
            super(0);
        }

        public final FrameLayout invoke() {
            return this.$configComment.c;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m225invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputCommentV2$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentManager;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass5 extends Lambda implements Function0<FragmentManager> {
        final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p $configComment;

        public AnonymousClass5(com.bytedance.ee.bear.middleground.comment.uitls.p r1) {
            this.$configComment = r1;
            super(0);
        }

        public final FragmentManager invoke() {
            return this.$configComment.d();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m226invoke() {
            return invoke();
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InputCommentV2 a;

        public a(InputCommentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h(this.a.i0, "click rootView, so dismiss inputComment");
            kf5.a.a(this.a, false, false, 2);
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ InputCommentV2 a;

        public b(InputCommentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r4 - r2;
            if (this.a.F().getLayoutParams().width != r10) goto L5;
            return;
        L5:
            if (this.a.D0() == false) goto L9;
            ViewGroup.LayoutParams r11 = this.a.F().getLayoutParams();
            r11.width = r10 + com.bytedance.ee.util.ui.n.d(40);
            AtFinderView r12 = this.a.F();
            r12.setPadding(com.bytedance.ee.util.ui.n.d(40), r12.getPaddingTop(), r12.getPaddingRight(), r12.getPaddingBottom());
            this.a.F().requestLayout();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InputCommentV2 a;
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p b;

        public static final class a implements CommentCollaboratorControlFragmentV2.b {
            public final /* synthetic */ InputCommentV2 a;

            @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2.b
            public final void onDismiss() {
                InputCommentV2 r0 = this.a;
                r0.c(r0.i0);
                this.a.l();
            }

            public a(InputCommentV2 r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2.b
            public final void a(int r2) {
                this.a.X.e.visibilityBean.setType(r2);
                this.a.T();
            }
        }

        public c(InputCommentV2 r1, com.bytedance.ee.bear.middleground.comment.uitls.p r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            InputCommentV2 r5 = this.a;
            r5.a(r5.i0);
            int r6 = CommentCollaboratorControlFragmentV2.r;
            int r7 = this.a.X.e.visibilityBean.getType();
            boolean r0 = this.a.X.e.is_whole;
            sbb.e r1 = this.b.k;
            Intrinsics.checkNotNullParameter(r1, "pageType");
            new CommentCollaboratorControlFragmentV2(r7, r0, r1).da0(this.b.g, new a(this.a));
        }
    }

    public static final class d {
    }

    public static final class e implements sa5.d {
        public final /* synthetic */ InputCommentV2 a;

        public e(InputCommentV2 r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = this.a.W();
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L10;
            return true;
        L10:
            CommentImmersiveVoiceTouchDelegate r2 = this.a.V();
            if (r2 != null) goto L13;
        L15:
            boolean r3 = false;
        L16:
            if (r3 == false) goto L19;
            r2.a();
            return true;
        L19:
            tt5.a.h(this.a.i0, "backPress, so dismiss inputComment");
            kf5.a.a(this.a, false, false, 3);
            return true;
        L13:
            if (r2.k != true) goto L15;
            r3 = true;
            goto L16
        L5:
            if (r0.a() != true) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class f implements OnApplyWindowInsetsListener {
        public final /* synthetic */ InputCommentV2 a;

        public f(InputCommentV2 r1) {
            this.a = r1;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
            Intrinsics.checkNotNullParameter(r4, "<unused var>");
            Intrinsics.checkNotNullParameter(r5, "insets");
            Insets r6 = r5.getInsets(WindowInsetsCompat.Type.navigationBars());
            this.a.k.setPadding(r6.left, r6.top, r6.right, r6.bottom);
            return WindowInsetsCompat.CONSUMED;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ InputCommentV2 a;

        public g(InputCommentV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InputCommentV2 r0 = this.a;     // Catch: Throwable -> L4
            r0.Q.g.removeObservers(r0.a.getActivity());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ InputCommentV2 a;

        public h(InputCommentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h(this.a.i0, "click dismissView, so dismiss inputComment");
            kf5.a.a(this.a, false, false, 3);
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ InputCommentV2 a;

        public static final class a<T> implements Observer {
            public final /* synthetic */ InputCommentV2 a;

            public a(InputCommentV2 r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                Intrinsics.checkNotNullParameter((String) r2, "it");
                this.a.m0.f();
            }
        }

        public i(InputCommentV2 r1) {
            this.a = r1;
        }

        public final void a() {
            InputCommentV2 r0 = this.a;
            r0.Q.g.removeObservers(r0.a.getActivity());
            InputCommentV2 r1 = this.a;
            r1.Q.g.observe(r1.a.getActivity(), new a(this.a));
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

    static {
        u0 = cu5.c.b(100);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void C() {
        if (this.a.W == false) goto L5;
        this.n0.setVisibility(8);
        this.n0.setHostAdjustResize(true);
    L6:
        this.Y = com.bytedance.ee.bear.contract.j.a.a.a();
        o0();
        com.bytedance.ee.util.ui.m.a(new o(this));
        sa5.b r0 = C0();
        if (r0 == null) goto L9;
        r0.e(this.t0);
    L9:
        View r1 = this.k0;
        ViewGroup r2 = null;
        if (r1 == null) goto L12;
        ViewParent r3 = r1.getParent();
    L14:
        if ((r3 instanceof ViewGroup) == false) goto L16;
        r2 = (ViewGroup) r3;
    L16:
        if (r2 == null) goto L18;
        r2.removeView(this.k0);
    L18:
        ((ViewGroup) this.f.invoke()).addView(this.k0);
        ViewGroup r4 = (ViewGroup) this.k.getParent();
        if (r4 == null) goto L21;
        r4.removeView(this.k);
    L21:
        com.bytedance.ee.bear.middleground.comment.uitls.p r5 = this.a;
        if (r5.s == true) goto L24;
        ((ViewGroup) this.f.invoke()).addView(this.k);
        return;
    L24:
        if (r5.V == false) goto L26;
        ((ViewGroup) this.f.invoke()).addView(this.k);
        return;
    L26:
        FragmentActivity r6 = r5.getActivity();
        ((com.ss.android.lark.insets.c) WindowInsetsUtils.c(r6)).b = new f(this);
        Window r7 = r6.getWindow();
        if (r7 == null) goto L40;
        View r8 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L33;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r9 = ThreadMethodProxy.currentThread();
        if (r9 == com.larus.home.impl.utils.c.a) goto L33;
        com.larus.home.impl.utils.c.a(r9, "getDecorView");
    L33:
        if (r8 == null) goto L41;
        ViewGroup r10 = (ViewGroup) r8.findViewById(R.id.content);
        if (r10 == null) goto L42;
        r10.addView(this.k);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L12:
        r3 = null;
        goto L14
    L5:
        this.n0.setVisibility(0);
        this.n0.setHostAdjustResize(false);
        goto L6
    }

    public final boolean D0() {
        Lazy r0 = CommentUtils.a;
        FragmentActivity r1 = this.a.getActivity();
        if (this.a.C == true) goto L5;
    L7:
        return false;
    L5:
        if (CommentUtils.b(r1) == false) goto L7;
        return true;
    }

    public final void E0() {
        tt5.a.h(this.i0, "setFullClickIfNeed(), isFullScreen: " + this.j0);
        if (this.j0 == false) goto L5;
        this.k.setClickable(false);
        this.k0.setClickable(true);
        this.k0.setOnClickListener(new h(this));
        return;
    L5:
        this.k0.setClickable(false);
        this.k.setClickable(false);
    }

    public final void G0() {
        ViewGroup.LayoutParams r0 = this.m0.getLayoutParams();
        if (D0() == false) goto L5;
        int r1 = this.n0.getKeyboardFixedHeight();
    L6:
        r0.height = r1;
        if (D0() == true) goto L10;
        ViewGroup.LayoutParams r2 = this.n0.getLayoutParams();
        r2.height = this.m0.getMeasuredHeight();
        return;
    L10:
        return;
    L5:
        r1 = -2;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final int K() {
        return this.n0.getKeyboardFixedHeight();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void S() {
        this.n0.f(false);
        R();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void Z() {
        this.n0.f(false);
        R();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void f0() {
        if (this.j.isCreate() == false) goto L28;
        String r0 = this.j.local_comment_id;
        boolean r1 = true;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L29;
        Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> r3 = this.d;
        Editable r4 = e().getText();
        if (r4 == null) goto L16;
        String r5 = r4.toString();
        if (r5 == null) goto L16;
    L17:
        String r6 = r5;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = this.X.k;
        Boolean r8 = Boolean.TRUE;
        String r9 = this.j.tmpCommentId;
        if (this.A.getVisibility() != 0) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == true) goto L23;
    L25:
        r1 = false;
    L26:
        r3.invoke(r6, r7, r8, r9, Boolean.valueOf(r1));
        return;
    L23:
        if (this.E.b == false) goto L25;
    L20:
        r10 = false;
    L16:
        r5 = "";
        goto L17
    L29:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void v() {
        this.n0.g();
    }

    public final sa5.b C0() {
        if (ForsetiHelper.p() == false) goto L6;
        sa5.o.a r0 = sa5.o.q2;
        FragmentActivity r2 = this.a.getActivity();
        FrameLayout r3 = this.a.c;
        r0.getClass();
        return (sa5.b) sa5.o.a.a(sa5.b.class, r2, r3);
    L6:
        return (sa5.b) sa5.m.a.a(this.a.getActivity(), sa5.b.class);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void b() {
        boolean r6 = false;
        if (D0() == false) goto L5;
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this.l);
        r0.constrainWidth(this.V.getId(), -2);
        r0.constrainHeight(this.V.getId(), -2);
        r0.constrainMaxWidth(this.V.getId(), com.bytedance.ee.util.ui.n.d(120));
        r0.constrainWidth(this.H.getId(), 0);
        r0.constrainHeight(this.H.getId(), -2);
        r0.connect(this.H.getId(), 2, this.J.getId(), 1);
        r0.connect(this.H.getId(), 1, this.x.getId(), 1);
        r0.connect(this.H.getId(), 4, this.x.getId(), 3, com.bytedance.ee.util.ui.n.d(8));
        r0.connect(this.w.getId(), 4, this.H.getId(), 3, com.bytedance.ee.util.ui.n.d(8));
        ViewGroup r4 = this.A;
        r4.setPadding(com.bytedance.ee.util.ui.n.d(50), r4.getPaddingTop(), r4.getPaddingRight(), r4.getPaddingBottom());
        r0.constrainWidth(this.J.getId(), -2);
        r0.constrainHeight(this.J.getId(), 0);
        r0.connect(this.J.getId(), 4, this.x.getId(), 3, 0);
        r0.connect(this.J.getId(), 3, this.w.getId(), 4, 0);
        r0.connect(this.J.getId(), 2, this.x.getId(), 2, 0);
        r0.applyTo(this.l);
        this.H.setMaxElementsWrap(2);
        F().setCommentLandscape(true);
        e().setGravity(8388627);
        e().setMinHeight(com.bytedance.ee.util.ui.n.d(32));
        e().setMaxHeight(com.bytedance.ee.util.ui.n.d(56));
        e().setPadding(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(1), com.bytedance.ee.util.ui.n.d(6), com.bytedance.ee.util.ui.n.d(1));
        CommentImageAdapter r1 = this.W;
        r1.b = com.bytedance.ee.util.ui.n.d(48);
        CommentImageAdapter r2 = this.W;
        r2.c = com.bytedance.ee.util.ui.n.d(23);
        this.W.notifyDataSetChanged();
        this.V.setPadding(0, com.bytedance.ee.util.ui.n.d(4), 0, com.bytedance.ee.util.ui.n.d(4));
        GradientDrawable r3 = new GradientDrawable();
        r3.setSize(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(1));
        this.J.setDividerDrawable(r3);
        this.J.setShowDividers(2);
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        this.I.setVisibility(0);
    L20:
        F0(this.q.isSelected());
        Y(true);
        return;
    L5:
        ConstraintSet r5 = new ConstraintSet();
        r5.clone(this.l0.getContext(), 2131559848);
        r5.setVisibility(F().getId(), F().getVisibility());
        r5.setVisibility(this.V.getId(), this.V.getVisibility());
        r5.setVisibility(this.J.getId(), this.J.getVisibility());
        r5.setVisibility(this.m0.getId(), this.m0.getVisibility());
        r5.clear(this.n0.getId());
        r5.applyTo(this.l);
        F().getLayoutParams().width = -1;
        AtFinderView r7 = F();
        r7.setPadding(0, r7.getPaddingTop(), r7.getPaddingRight(), r7.getPaddingBottom());
        this.H.setMaxElementsWrap(1);
        ViewGroup r8 = this.A;
        r8.setPadding(com.bytedance.ee.util.ui.n.d(24), r8.getPaddingTop(), r8.getPaddingRight(), r8.getPaddingBottom());
        F().setCommentLandscape(false);
        e().setGravity(8388611);
        e().setMinHeight(com.bytedance.ee.util.ui.n.d(48));
        e().setMaxHeight(com.bytedance.ee.util.ui.n.d(84));
        int r9 = 16;
        e().setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(16), com.bytedance.ee.util.ui.n.d(12));
        CommentImageAdapter r10 = this.W;
        r10.b = com.bytedance.ee.util.ui.n.d(80);
        CommentImageAdapter r11 = this.W;
        r11.c = com.bytedance.ee.util.ui.n.d(30);
        this.W.notifyDataSetChanged();
        this.V.setPadding(com.bytedance.ee.util.ui.n.d(16), 0, com.bytedance.ee.util.ui.n.d(16), com.bytedance.ee.util.ui.n.d(8));
        GradientDrawable r12 = new GradientDrawable();
        FragmentActivity r13 = this.a.getActivity();
        if (r13 == null) goto L12;
        Resources r14 = r13.getResources();
        if (r14 == null) goto L12;
        Configuration r15 = r14.getConfiguration();
        if (r15 == null) goto L12;
        int r16 = r15.screenWidthDp;
    L13:
        if (1 <= r16) goto L15;
    L17:
        if (r6 == false) goto L19;
        r9 = 4;
    L19:
        r12.setSize(com.bytedance.ee.util.ui.n.d(r9), com.bytedance.ee.util.ui.n.d(1));
        this.J.setDividerDrawable(r12);
        this.J.setShowDividers(2);
        this.y.setVisibility(4);
        this.z.setVisibility(8);
        this.I.setVisibility(8);
        goto L20
    L15:
        if (r16 >= 360) goto L17;
        r6 = true;
    L12:
        r16 = 0;
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void destroy() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.n0.d();
    L5:
        super.destroy();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void h0() {
        super.h0();
        this.m0.e();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f w() {
        return com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f.a(super.w(), null, false, new InputCommentV2$buildVoiceInputContext$1(this), null, null, null, null, false, null, 0, null, null, null, -16385, 31);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void y0() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = M();
        if (r0 == null) goto L6;
        r0.h();
        return;
    L6:
        RecordPanelView r1 = this.m0;
        int r2 = 0;
        if (r1.c() == true) goto L19;
        x(false);
        this.m0.e();
        this.n0.f(false);
        R();
        this.n0.g();
        this.q.setSelected(true);
        kn4.g r3 = e().getAtWindow();
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L18;
        this.n.setSelected(false);
        kn4.g r5 = e().getAtWindow();
        if (r5 == null) goto L18;
        r5.j();
    L18:
        F0(true);
    L20:
        r1.setVisibility(r2);
        return;
    L11:
        if (r3.isShowing() != true) goto L13;
        r4 = true;
        goto L14
    L19:
        w0(0);
        this.n0.c();
        this.Q.i();
        F0(false);
        r2 = 8;
        goto L20
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void z() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.n0.d();
    L5:
        super.z();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final String L() {
        return this.i0;
    }

    public final void F0(boolean r4) {
        r0();
        if (r4 == false) goto L5;
        this.J.setVisibility(8);
        this.V.setVisibility(8);
        this.p0 = Integer.valueOf(this.a.getActivity().getWindow().getNavigationBarColor());
        this.a.getActivity().getWindow().setNavigationBarColor(com.bytedance.ee.util.ui.n.h(this.a.getActivity(), 2131100549));
    L13:
        G0();
        this.a.h.getClass();
        if (com.bytedance.ee.bear.middleground.comment.p.c() != true) goto L17;
        this.n.setVisibility(8);
        return;
    L17:
        return;
    L5:
        Integer r5 = this.p0;
        if (r5 == null) goto L8;
        int r6 = r5.intValue();
        this.a.getActivity().getWindow().setNavigationBarColor(r6);
    L8:
        h0();
        int r1 = 0;
        this.J.setVisibility(0);
        this.m0.setVisibility(8);
        m0();
        ImageView r7 = this.U;
        if (this.X.c.E == true) goto L12;
        r1 = 8;
    L12:
        r7.setVisibility(r1);
        q0();
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.q0.add(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void a0(CommentImageSelectorDismissReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.n0.c();
        super.a0(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void b0(boolean r6) {
        super.b0(r6);
        RecordPanelView r0 = this.m0;
        if (r6 == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        r0.setEnabled(r3);
        RecordViewModel r1 = this.Q;
        r1.h = r6;
        if (r6 == false) goto L12;
        return;
    L12:
        if (r1.d == true) goto L14;
        return;
    L14:
        if (this.m0.c() == false) goto L18;
        RecordPanelView r7 = this.m0;
        r7.d(true);
        RecordViewModel r8 = r7.l;
        if (r8 == null) goto L22;
        r8.g();
        return;
    L22:
        return;
    L18:
        this.Q.i();
        e().P();
        this.Q.g();
        z0(false);
        return;
    L5:
        if (r0.getVisibility() != 8) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.q0.remove(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void i0(BaseInputComment.m r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L6;
        super.i0(r3);
        return;
    L6:
        this.n0.i(new u1(this), r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void n(SmartReplyDataForInsert r2) {
        this.X.l = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void q(boolean r1) {
        this.j0 = r1;
        E0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void w0(long r3) {
        this.n0.f(true);
        super.w0(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final boolean x(boolean r2) {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.n0.d();
    L5:
        boolean r3 = super.x(r2);
        this.n0.c();
        return r3;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void d(boolean r5, boolean r6) {
        tt5.a.h(this.i0, "dismiss(), bySend: " + r5 + ", isShowing: " + isShowing());
        if (isShowing() == true) goto L27;
        return;
    L27:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        com.bytedance.ee.util.ui.m.a(new g(this));     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        this.o0 = 0;
        View r1 = this.k0;
        ViewGroup r2 = null;
        if (r1 == null) goto L12;
        ViewParent r3 = r1.getParent();
    L14:
        if ((r3 instanceof ViewGroup) == false) goto L16;
        r2 = (ViewGroup) r3;
    L16:
        if (r2 == null) goto L18;
        r2.removeView(this.k0);
    L18:
        super.d(r5, r6);
        super.g0();
        sa5.b r7 = C0();
        if (r7 == null) goto L21;
        r7.d(this.t0);
    L21:
        Iterator<T> r8 = this.b.a().iterator();
    L23:
        if (r8.hasNext() == false) goto L25;
        ((Function2) r8.next()).invoke(0, Boolean.valueOf(this.j.isForWhole()));
        goto L23
    L25:
        this.m0.setVisibility(8);
        F0(false);
        return;
    L12:
        r3 = null;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void g(String r3, DriveCommentWrapper.7 r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.h.k(r3, true, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void j0(boolean r4, Boolean r5) {
        tt5.a.h(this.i0, "sendComment, so dismiss inputComment");
        kf5.a.a(this, true, false, 2);
        super.j0(r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void m(List r2, com.bytedance.ee.bear.drive.biz.comment.e1 r3) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.h.j(r2, r3);
    }

    @Override // kf5.b
    public final void k(String r2, boolean r3, ArrayList<String> r4) {
        AtFinderViewModel r0 = F().e;
        if (r0 == null) goto L6;
        r0.setOwnerAndAuthors(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment, kf5.b
    public final void h(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        b();
        com.bytedance.ee.util.ui.m.a(new i(this));
        super.h(r2, r3, r4, r5, r6);
        e().requestFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InputCommentV2(com.bytedance.ee.bear.middleground.comment.uitls.p r17, com.bytedance.ee.bear.middleground.comment.control.z r18, com.bytedance.ee.bear.middleground.comment.control.t r19, Function1<? super String, Unit> r20, CommentInputRequest r21, Function5<? super String, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, ? super Boolean, ? super String, ? super Boolean, Unit> r22, Function1<? super Integer, Unit> r23, boolean r24, Map<String, String> r25, Function0<? extends ViewGroup> r26, Function0<? extends FragmentManager> r27, bb5.b r28, SharePermissionViewModel r29) {
        Intrinsics.checkNotNullParameter(r17, "configComment");
        Intrinsics.checkNotNullParameter(r18, "commentListeners");
        Intrinsics.checkNotNullParameter(r19, "dataControl");
        Intrinsics.checkNotNullParameter(r20, "createCallBack");
        Intrinsics.checkNotNullParameter(r21, "inputRequest");
        Intrinsics.checkNotNullParameter(r22, "dismissCallback");
        Intrinsics.checkNotNullParameter(r23, "heightChange");
        Intrinsics.checkNotNullParameter(r26, "getViewParent");
        Intrinsics.checkNotNullParameter(r27, "getFragmentManager");
        Intrinsics.checkNotNullParameter(r28, "dialogLifecycle");
        Intrinsics.checkNotNullParameter(r29, "sharePermissionViewModel");
        super(r17, r18, r19, r20, r21, r22, r25, r26, r27, r29, 2131559864);
        this.h0 = r23;
        this.i0 = "Comment#InputComment";
        this.j0 = r24;
        this.q0 = new HashSet();
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.r0 = r0.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.s0 = r0.h("ccm.mobile.shrink_comment_panel_when_zoom_in");
        this.k0 = new View(r17.getActivity());
        this.k.setOnClickListener(new a(this));
        AtFinderView r1 = (AtFinderView) this.k.findViewById(2131363295);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.L = r1;
        RecordPanelView r2 = (RecordPanelView) this.k.findViewById(2131392643);
        this.m0 = r2;
        this.l0 = this.k.findViewById(2131375404);
        CommentKeyboardPlaceholderView r3 = (CommentKeyboardPlaceholderView) this.k.findViewById(2131376823);
        this.n0 = r3;
        r2.setViewModel(this.Q);
        r2.setCommentAnalytic(r17.d0);
        U(r28, null);
        r3.setKeyboardHeightProvider(this.a.r);
        CommentEditText r4 = e();
        Intrinsics.checkNotNullParameter(r4, "editText");
        r2.i = r4;
        E0();
        this.I.setOnClickListener(new v1(this));
        r3.setOnHeightChangeListener(new w1(this));
        this.l.addOnLayoutChangeListener(new x1(this));
        r2.setRecordPanelOperationCallback(new y1(this));
        AtFinderView r5 = F();
        Intrinsics.checkNotNullParameter(r5, "atList");
        r5.setAtFinderViewDelegate(new q(this));
        this.a.getActivity();
        bo4.c r6 = kn4.f.a().a();
        com.bytedance.ee.bear.middleground.comment.uitls.p r7 = this.a;
        kn4.h r8 = new kn4.h(r6, r7.k, r7.i);
        r8.l = r5;
        r8.k = 1;
        ArrayList r9 = new ArrayList();
        r9.addAll(AtUtils.c());
        r9.addAll(ArraysKt.toList(com.bytedance.ee.bear.utils.a.c));
        r9.add("7");
        r8.j = r9;
        r8.p = ((xe5.a) org.koin.java.a.c(xe5.a.class, null, null, 6)).a(this.e);
        e().C(r8);
        kn4.g r10 = e().getAtWindow();
        if (r10 == null) goto L5;
        r10.b(new r(this));
    L5:
        kn4.g r11 = e().getAtWindow();
        if (r11 == null) goto L8;
        r11.j();
    L8:
        kn4.g r12 = e().getAtWindow();
        if (r12 == null) goto L11;
        r12.f(new s(this));
    L11:
        e().addOnLayoutChangeListener(new b(this));
        this.s.setOnClickListener(new c(this, r17));
        this.t0 = new e(this);
    }
}
