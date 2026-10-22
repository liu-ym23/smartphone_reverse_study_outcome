package com.bytedance.ee.bear.middleground.comment.input;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.middleground.comment.audio.MotionImageView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.UserInfo;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionView;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.bytedance.ee.bear.middleground.comment.widget.BotAtHintView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.comment.widget.CommentKeyboardPlaceholderView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentVoiceBarLayout;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.ui.button.LKUICheckBox2;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class InputComment implements kf5.b {
    public static final int x0 = 0;
    public final View A;
    public final View B;
    public final View C;
    public final View D;
    public final ViewGroup E;
    public AnimatorSet F;
    public AnimatorSet G;
    public Boolean H;
    public final LKUICheckBox2 I;
    public final TextView J;
    public final View K;
    public final SharePermissionView L;
    public final Flow M;
    public final ImageView N;
    public final LinearLayout O;
    public final View P;
    public final ConstraintLayout Q;
    public final View R;
    public final RecordPanelView S;
    public final RecordViewModel T;
    public final Lazy<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g> U;
    public final Lazy<CommentImmersiveVoiceTouchDelegate> V;
    public final Lazy W;
    public final ImageView X;
    public final RecyclerView Y;
    public final CommentKeyboardPlaceholderView Z;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final BotAtHintView a0;
    public final com.bytedance.ee.bear.middleground.comment.control.z b;
    public final t b0;
    public final Function1<String, Unit> c;
    public final h c0;
    public final Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> d;
    public final Lazy d0;
    public final Function1<Integer, Unit> e;
    public int e0;
    public final Map<String, String> f;
    public final FileSelectConfig f0;
    public final Function0<ViewGroup> g;
    public DialogFragment g0;
    public final Function0<FragmentManager> h;
    public final CommentImageAdapter h0;
    public final bb5.b i;
    public final b2 i0;
    public final SharePermissionViewModel j;
    public LiveData<ConnectionService.NetworkState> j0;
    public CommentInputRequest k;
    public final l k0;
    public boolean l;
    public final boolean l0;
    public final View m;
    public final boolean m0;
    public final View n;
    public final boolean n0;
    public final View o;
    public final boolean o0;
    public final CommentEditText p;
    public final boolean p0;
    public final ImageView q;
    public Integer q0;
    public final ImageView r;
    public IImageViewer r0;
    public final ImageView s;
    public com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a s0;
    public final AtFinderView t;
    public boolean t0;
    public final MotionImageView u;
    public final HashSet<String> u0;
    public final FrameLayout v;
    public final g v0;
    public final InputCommentVisibleView w;
    public final o w0;
    public final AppCompatImageView x;
    public final AppCompatImageView y;
    public boolean z;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$2, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$3, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$4, reason: invalid class name */
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
        public /* bridge */ /* synthetic */ Object m197invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentManager;", "Lkotlin/jvm/internal/EnhancedNullability;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass5 extends Lambda implements Function0<FragmentManager> {
        final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p $configComment;

        public AnonymousClass5(com.bytedance.ee.bear.middleground.comment.uitls.p r1) {
            this.$configComment = r1;
            super(0);
        }

        public final FragmentManager invoke() {
            return this.$configComment.getActivity().getSupportFragmentManager();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m198invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<com.bytedance.ee.bear.middleground.comment.widget.b, Unit> {
        public AnonymousClass7(Object r8) {
            super(1, r8, InputComment.class, "handleBotHintAction", "handleBotHintAction(Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintInfo;)V", 0);
        }

        public final void invoke(com.bytedance.ee.bear.middleground.comment.widget.b r6) {
            Intrinsics.checkNotNullParameter(r6, "p0");
            final InputComment r0 = (InputComment) ((CallableReference) this).receiver;
            int r1 = InputComment.x0;
            final ve5.c r7 = r0.H().i(r6);
            if ((r7 instanceof ve5.c.b) == false) goto L6;
            int r2 = a2.a;
            a2.a(r0.a.getActivity(), r0, new InputComment$handleBotHintAction$1(r0), new InputComment$handleBotHintAction$2(r0), new InputComment$handleBotHintAction$3(r7));
            return;
        L6:
            if (Intrinsics.areEqual(r7, ve5.c.a.a) == false) goto L9;
            return;
        L9:
            throw new NoWhenBranchMatchedException();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.ee.bear.middleground.comment.widget.b) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InputComment a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.InputComment$a$a, reason: collision with other inner class name */
        public static final class C0070a implements CommentCollaboratorControlFragmentV2.b {
            public final /* synthetic */ InputComment a;

            @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2.b
            public final void onDismiss() {
                InputComment r0 = this.a;
                r0.z = false;
                r0.l();
            }

            public C0070a(InputComment r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2.b
            public final void a(int r2) {
                this.a.i0.e.visibilityBean.setType(r2);
                this.a.L();
            }
        }

        public a(InputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            InputComment r5 = this.a;
            r5.z = true;
            int r0 = CommentCollaboratorControlFragmentV2.r;
            int r6 = r5.i0.e.visibilityBean.getType();
            InputComment r1 = this.a;
            boolean r2 = r1.i0.e.is_whole;
            sbb.e r3 = r1.a.k;
            Intrinsics.checkNotNullParameter(r3, "pageType");
            CommentCollaboratorControlFragmentV2 r7 = new CommentCollaboratorControlFragmentV2(r6, r2, r3);
            InputComment r8 = this.a;
            r7.da0(r8.a.g, new C0070a(r8));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InputComment a;

        public b(InputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            InputComment r0 = this.a;
            if (r0.w.e == true) goto L6;
            Toast.showText(r5.getContext(), 2131888987);
            return;
        L6:
            boolean r6 = true;
            r0.z = true;
            ArrayList r1 = new ArrayList();     // Catch: Throwable -> L20
            InputComment r2 = this.a;     // Catch: Throwable -> L20
            Function0<Pair<String, String>> r3 = r2.b.N();     // Catch: Throwable -> L20
            if (r3 == null) goto L25;
            Pair r4 = (Pair) r3.invoke();     // Catch: Throwable -> L20
            if (r4 == null) goto L26;
            com.bytedance.ee.bear.middleground.comment.export.v r7 = r2.a.H;     // Catch: Throwable -> L20
            if (r7 != null) goto L14;
        L16:
            r6 = false;
        L17:
            if (r6 == false) goto L27;
            UserInfo r8 = new UserInfo();     // Catch: Throwable -> L20
            r8.setUserId((String) r4.getFirst());     // Catch: Throwable -> L20
            r8.setUserName((String) r4.getSecond());     // Catch: Throwable -> L20
            r1.add(r8);     // Catch: Throwable -> L20
            return;
        L27:
            return;
        L14:
            if (r7.isOwner() == true) goto L16;
        L26:
            return;
        L25:
            return;
        L20:
            th = move-exception;
            tt5.a.e("Comment#InputComment", "openCommentCollaboratorControlFragment failed", th, false);
            iu5.d.a("Comment#InputComment", th);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InputComment a;

        public c(InputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            InputComment r4 = this.a;
            r4.a.N.a(new ef5.a0(r4.i0.e.is_whole));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InputComment a;

        public d(InputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h("Comment#InputComment", "click rootView, so dismiss inputComment");
            kf5.a.a(this.a, false, false, 2);
        }
    }

    public static final class e extends za5.b {
        public final /* synthetic */ InputComment a;

        public e(InputComment r1) {
            this.a = r1;
        }

        public final void c(List<? extends FileBean> r2) {
            Intrinsics.checkNotNullParameter(r2, "fileList");
            InputComment.v(this.a, r2);
        }
    }

    public static final class f {
    }

    public static final class g implements sa5.d {
        public final /* synthetic */ InputComment a;

        public g(InputComment r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = this.a.M();
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L10;
            return true;
        L10:
            InputComment r2 = this.a;
            if (r2.V.isInitialized() == false) goto L13;
            CommentImmersiveVoiceTouchDelegate r3 = (CommentImmersiveVoiceTouchDelegate) r2.V.getValue();
        L14:
            if (r3 != null) goto L16;
        L18:
            boolean r4 = false;
        L19:
            if (r4 == false) goto L22;
            r3.a();
            return true;
        L22:
            tt5.a.h("Comment#InputComment", "backPress, so dismiss inputComment");
            kf5.a.a(this.a, false, false, 3);
            return true;
        L16:
            if (r3.k != true) goto L18;
            r4 = true;
            goto L19
        L13:
            r3 = null;
            goto L14
        L5:
            if (r0.a() != true) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class h implements View.OnLayoutChangeListener {
        public final /* synthetic */ InputComment a;

        public h(InputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            InputComment r10 = this.a;
            r10.n.removeCallbacks(r10.b0);
            r10.n.post(r10.b0);
        }
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ InputComment a;

        public i(InputComment r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            this.a.E.getLayoutParams().height = ((Integer) r3).intValue();
            this.a.E.requestLayout();
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ InputComment a;

        public j(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InputComment r0 = this.a;     // Catch: Throwable -> L4
            r0.T.g.removeObservers(r0.a.getActivity());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ InputComment a;

        public k(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InputComment r0 = this.a;     // Catch: Throwable -> L6
            LiveData<ConnectionService.NetworkState> r1 = r0.j0;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.removeObserver(r0.k0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ InputComment a;

        public l(InputComment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            ConnectionService.NetworkState r8 = (ConnectionService.NetworkState) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            boolean r0 = false;
            if (r8.a() != true) goto L5;
            boolean r9 = true;
        L6:
            ImageView r2 = this.a.q;
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("atView");
            r2 = null;
        L9:
            r2.setEnabled(r9);
            InputComment r3 = this.a;
            RecordPanelView r4 = r3.S;
            if (r9 == false) goto L12;
        L15:
            boolean r5 = true;
        L16:
            r4.setEnabled(r5);
            r3.V();
            r3.T.h = r9;
            if (r9 == true) goto L26;
            r3.p.setEnabled(true);
            if (r3.T.d == false) goto L26;
            if (r3.S.c() == false) goto L25;
            RecordPanelView r6 = r3.S;
            r6.d(true);
            RecordViewModel r10 = r6.l;
            if (r10 == null) goto L26;
            r10.g();
            goto L26
        L25:
            r3.T.i();
            r3.p.P();
            r3.T.g();
            r3.b0(false);
        L26:
            CommentImageAdapter r11 = r3.h0;
            r11.a = r9;
            r11.notifyDataSetChanged();
            r3.X.setEnabled(r9);
            ImageView r12 = r3.r;
            if (r9 == false) goto L29;
        L30:
            r0 = true;
        L31:
            r12.setEnabled(r0);
            return;
        L29:
            if (r12.isSelected() == false) goto L31;
        L12:
            if (r4.getVisibility() != 8) goto L15;
            r5 = false;
            goto L16
        L5:
            r9 = false;
            goto L6
        }
    }

    public static final class m implements Animator.AnimatorListener {
        public final /* synthetic */ InputComment a;
        public final /* synthetic */ AnimatorSet b;
        public final /* synthetic */ AnimatorSet c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.a.E.setVisibility(8);
            this.c.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.E.setVisibility(8);
            this.b.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            this.a.E.setVisibility(0);
        }

        public m(InputComment r1, AnimatorSet r2, AnimatorSet r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class n implements View.OnClickListener {
        public final /* synthetic */ InputComment a;

        public n(InputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h("Comment#InputComment", "click dismissView, so dismiss inputComment");
            kf5.a.a(this.a, false, false, 3);
        }
    }

    public static final class o implements Runnable {
        public final /* synthetic */ InputComment a;

        public o(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.T(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class p implements Runnable {
        public final /* synthetic */ InputComment a;

        public p(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InputComment r0 = this.a;     // Catch: Throwable -> L4
            List<ve5.m> r1 = r0.E(r0.D());     // Catch: Throwable -> L4
            ve5.e r2 = r0.H();     // Catch: Throwable -> L4
            r2.getClass();     // Catch: Throwable -> L4
            Intrinsics.checkNotNullParameter(r1, "mentions");     // Catch: Throwable -> L4
            r2.l(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ InputComment a;

        public static final class a<T> implements Observer {
            public final /* synthetic */ InputComment a;

            public a(InputComment r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                Intrinsics.checkNotNullParameter((String) r2, "it");
                this.a.S.f();
            }
        }

        public q(InputComment r1) {
            this.a = r1;
        }

        public final void a() {
            InputComment r0 = this.a;
            r0.T.g.removeObservers(r0.a.getActivity());
            InputComment r1 = this.a;
            r1.T.g.observe(r1.a.getActivity(), new a(this.a));
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

    public static final class r implements Runnable {
        public final /* synthetic */ InputComment a;

        public r(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.K();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class s implements Runnable {
        public final /* synthetic */ InputComment a;

        public s(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.Y();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class t implements Runnable {
        public final /* synthetic */ InputComment a;

        public t(InputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InputComment r0 = this.a;     // Catch: Throwable -> L13
            if (r0.o.isLaidOut() == false) goto L16;
            int r1 = r0.o.getTop();     // Catch: Throwable -> L13
            BotAtHintView r2 = r0.a0;     // Catch: Throwable -> L13
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("botAtHintView");     // Catch: Throwable -> L13
            r2 = null;
        L9:
            if (r2.h == r1) goto L20;
            r2.h = r1;     // Catch: Throwable -> L13
            int r3 = r2.b.z2();     // Catch: Throwable -> L13
            r2.c(r3, r3, "updateAvailableTopSpace");     // Catch: Throwable -> L13
            return;
        L20:
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    @Override // kf5.b
    public void update(boolean r1) {
    }

    static {
        x0 = cu5.c.b(100);
    }

    public final void C() {
        SharePermissionView r0 = this.L;
        Disposable r1 = r0.d;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r0.setVisibility(8);
    }

    public final List<un5.l> D() {
        Editable r0 = this.p.getText();
        if (r0 == null) goto L11;
        Editable r1 = this.p.getText();
        if (r1 == null) goto L7;
        int r2 = r1.length();
    L8:
        un5.l[] r3 = (un5.l[]) r0.getSpans(0, r2, un5.l.class);
        if (r3 == null) goto L11;
        List<un5.l> r4 = ArraysKt.toList(r3);
    L12:
        if (r4 == null) goto L14;
        return r4;
    L14:
        return CollectionsKt.emptyList();
    L7:
        r2 = 0;
    L11:
        r4 = null;
        goto L12
    }

    public final ve5.e H() {
        return (ve5.e) this.d0.getValue();
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g I() {
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g) this.U.getValue();
    }

    public final CommentVoiceMentionPermissionHelper J() {
        return (CommentVoiceMentionPermissionHelper) this.W.getValue();
    }

    public final void K() {
        this.Z.f(false);
        rcb.c.c(this.n.getContext());
        rcb.c.d((View) this.g.invoke());
    }

    public final void L() {
        if (this.a.e0 == false) goto L21;
        int r1 = 8;
        this.w.setVisibility(8);
        AppCompatImageView r0 = this.x;
        boolean r3 = true;
        if (this.a.f0 == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        int r4 = 0;
    L13:
        r0.setVisibility(r4);
        AppCompatImageView r5 = this.y;
        if (this.i0.e.visibilityBean.getType() != 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r1 = 0;
    L19:
        r5.setVisibility(r1);
        return;
    L12:
        r4 = 8;
        goto L13
    L7:
        if (this.i0.e.isCreate() == false) goto L9;
        r2 = true;
        goto L10
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g M() {
        if (this.U.isInitialized() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g) this.U.getValue();
    }

    public final boolean N() {
        Lazy r0 = CommentUtils.a;
        FragmentActivity r1 = this.a.getActivity();
        if (this.a.C == true) goto L5;
    L7:
        return false;
    L5:
        if (CommentUtils.b(r1) == false) goto L7;
        return true;
    }

    public final void P() {
        this.p.setEnabled(true);
        this.S.e();
        this.u.setSelected(false);
    }

    public final void R() {
        ImageView r0 = this.r;
        if (this.i0.j() == true) goto L7;
        if (this.a.g0.a == false) goto L7;
    L8:
        int r1 = 0;
    L10:
        r0.setVisibility(r1);
        return;
    L7:
        if (this.k.isShowAreaSelectBtn == true) goto L8;
        r1 = 8;
        goto L10
    }

    public final void S() {
        tt5.a.h("Comment#InputComment", "setFullClickIfNeed(), isFullScreen: " + this.l);
        if (this.l == false) goto L5;
        this.n.setClickable(false);
        this.m.setClickable(true);
        this.m.setOnClickListener(new n(this));
        return;
    L5:
        this.m.setClickable(false);
        this.n.setClickable(false);
    }

    public final void U() {
        RecyclerView r0 = this.Y;
        b2 r1 = this.i0;
        if (r1.c.F == true) goto L5;
    L7:
        int r2 = 8;
    L8:
        r0.setVisibility(r2);
        return;
    L5:
        if ((!r1.k.isEmpty()) == false) goto L7;
        r2 = 0;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void V() {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        AppCompatImageView r1 = this.u;
        if (r0 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r1.setEnabled(r2);
        return;
    L5:
        if (this.i0.f() == false) goto L7;
        r2 = true;
        goto L8
    }

    public final void W() {
        if (this.a.X.f() == false) goto L25;
        tt5.a.h("Comment#InputComment", "showHostImageSelectorFragment in InputComment");
        int r3 = this.Z.getKeyboardFixedHeight();
        int r4 = 9 - ((ArrayList) this.i0.k).size();
        Function1<List<? extends ew4.f>, Unit> r5 = new InputComment$showHostImageSelectorFragment$request$1(this);
        Function1<CommentImageSelectorDismissReason, Unit> r6 = new InputComment$showHostImageSelectorFragment$request$2(this);
        bb5.b r2 = this.i;
        if (r2 != null) goto L7;
        ew4.d.a.getClass();
        l0 r7 = ew4.d.a.b;
    L8:
        ew4.e r0 = new ew4.e(r3, r4, r5, r6, r7);
        DialogFragment r1 = this.a.X.e(new p0(this), r0);
        if (r1 == null) goto L32;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L18
        this.g0 = r1;     // Catch: Throwable -> L18
        FragmentManager r9 = (FragmentManager) this.h.invoke();     // Catch: Throwable -> L18
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L18
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "Comment#InputComment", r10);     // Catch: Throwable -> L18
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r1, r10) == false) goto L28;
    L16:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L23;
        tt5.a.e("Comment#InputComment", "showHostImageSelectorFragment failed", r12, false);
        this.g0 = null;
    L23:
        Result.isSuccess-impl(r11);
        return;
    L28:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27 Throwable -> L18
    L15:
        r1.show(r9, "Comment#InputComment");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L32:
        return;
    L7:
        r7 = new l0(r2);
        goto L8
    L25:
        int r14 = com.bytedance.ee.bear.fileselector.d.a;
        this.g0 = com.bytedance.ee.bear.fileselector.d.a.c(this.a.getActivity(), (FragmentManager) this.h.invoke(), this.f0, "Comment#InputComment");
    }

    public final void X() {
        if (this.X.isSelected() == false) goto L10;
        if (this.n0 == true) goto L7;
        Z(0);
        B(false);
        return;
    L7:
        B(true);
        return;
    L10:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L13;
        Y();
        return;
    L13:
        this.Z.i(new r(this), new s(this));
    }

    public final void Y() {
        kn4.g r0 = this.p.getAtWindow();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L15;
        ImageView r2 = this.q;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
        r2 = null;
    L12:
        r2.setSelected(false);
        kn4.g r3 = this.p.getAtWindow();
        if (r3 == null) goto L15;
        r3.j();
    L15:
        C();
        this.X.setSelected(true);
        this.b.U0().invoke(this.k);
        this.Z.g();
        FileSelectConfig r4 = this.f0;
        r4.maxSelectImageNum = 9 - ((ArrayList) this.i0.k).size();
        FileSelectConfig r5 = this.f0;
        r5.ccmPickViewHeight = this.Z.getKeyboardFixedHeight();
        W();
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void d0() {
        ViewGroup.LayoutParams r0 = this.S.getLayoutParams();
        if (N() == false) goto L5;
        int r1 = this.Z.getKeyboardFixedHeight();
    L6:
        r0.height = r1;
        if (N() == true) goto L10;
        ViewGroup.LayoutParams r2 = this.Z.getLayoutParams();
        r2.height = this.S.getMeasuredHeight();
        return;
    L10:
        return;
    L5:
        r1 = -2;
        goto L6
    }

    public final void e0() {
        Editable r0 = this.p.getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
    L7:
        boolean r2 = false;
        if (TextUtils.isEmpty(com.bytedance.ee.bear.middleground.comment.uitls.n.f(r1)) == true) goto L10;
    L13:
        boolean r3 = true;
    L14:
        ImageView r4 = this.s;
        if (r3 == true) goto L17;
    L19:
        r4.setEnabled(r2);
        return;
    L17:
        if (this.t0 == true) goto L19;
        r2 = true;
        goto L19
    L10:
        if ((!this.i0.k.isEmpty()) == true) goto L13;
        r3 = false;
    L6:
        r1 = "";
        goto L7
    }

    @Override // kf5.b
    public final boolean isShowing() {
        if (this.n.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kf5.b
    public final void l() {
        StringBuilder r0 = new StringBuilder("restoreInputStatus()... isShowing = ");
        r0.append(isShowing());
        r0.append(", insertImageView.isSelected = ");
        r0.append(this.X.isSelected());
        r0.append(", recordPanelView.isShowing() = ");
        r0.append(this.S.c());
        r0.append(", atWindow.isShowing = ");
        kn4.g r1 = this.p.getAtWindow();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isShowing());
    L6:
        r0.append(r2);
        tt5.a.h("Comment#InputComment", r0.toString());
        if (isShowing() == true) goto L10;
        return;
    L10:
        if (this.X.isSelected() == false) goto L13;
        return;
    L13:
        if (this.S.c() == false) goto L15;
        return;
    L15:
        Z(100);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // kf5.b
    public final void s() {
        ((ArrayList) this.i0.k).clear();
        CommentImageAdapter r0 = this.h0;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = this.i0.k;
        r0.p.dispose();
        r0.z2(r1, false);
        e0();
    }

    @Override // kf5.b
    public final int t() {
        return this.o.getMeasuredHeight();
    }

    public final sa5.b G() {
        if (ForsetiHelper.p() == false) goto L6;
        sa5.o.a r0 = sa5.o.q2;
        FragmentActivity r2 = this.a.getActivity();
        FrameLayout r3 = this.a.c;
        r0.getClass();
        return (sa5.b) sa5.o.a.a(sa5.b.class, r2, r3);
    L6:
        return (sa5.b) sa5.m.a.a(this.a.getActivity(), sa5.b.class);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kf5.b
    public final void b() {
        int r4 = 8;
        if (N() == false) goto L5;
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this.Q);
        r0.constrainWidth(this.Y.getId(), -2);
        r0.constrainHeight(this.Y.getId(), -2);
        r0.constrainMaxWidth(this.Y.getId(), com.bytedance.ee.util.ui.n.d(120));
        r0.constrainWidth(this.M.getId(), 0);
        r0.constrainHeight(this.M.getId(), -2);
        r0.connect(this.M.getId(), 2, this.O.getId(), 1);
        r0.connect(this.M.getId(), 1, this.B.getId(), 1);
        r0.connect(this.M.getId(), 4, this.B.getId(), 3, com.bytedance.ee.util.ui.n.d(8));
        r0.connect(this.A.getId(), 4, this.M.getId(), 3, com.bytedance.ee.util.ui.n.d(8));
        ViewGroup r7 = this.E;
        r7.setPadding(com.bytedance.ee.util.ui.n.d(50), r7.getPaddingTop(), r7.getPaddingRight(), r7.getPaddingBottom());
        r0.constrainWidth(this.O.getId(), -2);
        r0.constrainHeight(this.O.getId(), 0);
        r0.connect(this.O.getId(), 4, this.B.getId(), 3, 0);
        r0.connect(this.O.getId(), 3, this.A.getId(), 4, 0);
        r0.connect(this.O.getId(), 2, this.B.getId(), 2, 0);
        r0.constrainWidth(this.t.getId(), 0);
        r0.connect(this.t.getId(), 1, this.M.getId(), 1);
        r0.connect(this.t.getId(), 2, this.M.getId(), 2);
        r0.setVisibility(this.R.getId(), 0);
        r0.applyTo(this.Q);
        this.M.setMaxElementsWrap(2);
        this.t.setCommentLandscape(true);
        this.p.setGravity(8388627);
        this.p.setMinHeight(com.bytedance.ee.util.ui.n.d(32));
        this.p.setMaxHeight(com.bytedance.ee.util.ui.n.d(56));
        this.p.setPadding(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(1), com.bytedance.ee.util.ui.n.d(6), com.bytedance.ee.util.ui.n.d(1));
        CommentImageAdapter r1 = this.h0;
        r1.b = com.bytedance.ee.util.ui.n.d(48);
        CommentImageAdapter r2 = this.h0;
        r2.c = com.bytedance.ee.util.ui.n.d(23);
        this.h0.notifyDataSetChanged();
        this.Y.setPadding(0, com.bytedance.ee.util.ui.n.d(4), 0, com.bytedance.ee.util.ui.n.d(4));
        GradientDrawable r3 = new GradientDrawable();
        r3.setSize(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(1));
        this.O.setDividerDrawable(r3);
        this.O.setShowDividers(2);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        this.N.setVisibility(0);
    L21:
        c0(this.u.isSelected());
        InputCommentVisibleView r5 = this.w;
        boolean r6 = N();
        AppCompatTextView r8 = r5.getCommentVisibleTitleFromXml();
        if (r6 == true) goto L25;
        r4 = 0;
    L25:
        r8.setVisibility(r4);
        O(true);
        return;
    L5:
        ConstraintSet r9 = new ConstraintSet();
        r9.clone(this.Q.getContext(), 2131559863);
        r9.setVisibility(this.t.getId(), this.t.getVisibility());
        r9.setVisibility(this.L.getId(), this.L.getVisibility());
        r9.setVisibility(this.Y.getId(), this.Y.getVisibility());
        r9.setVisibility(this.O.getId(), this.O.getVisibility());
        r9.setVisibility(this.S.getId(), this.S.getVisibility());
        r9.setVisibility(this.R.getId(), 8);
        r9.clear(this.Z.getId());
        r9.applyTo(this.Q);
        this.M.setMaxElementsWrap(1);
        ViewGroup r10 = this.E;
        r10.setPadding(com.bytedance.ee.util.ui.n.d(24), r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
        this.t.setCommentLandscape(false);
        this.p.setGravity(8388611);
        this.p.setMinHeight(com.bytedance.ee.util.ui.n.d(48));
        this.p.setMaxHeight(com.bytedance.ee.util.ui.n.d(84));
        int r11 = 16;
        this.p.setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(16), com.bytedance.ee.util.ui.n.d(12));
        CommentImageAdapter r12 = this.h0;
        r12.b = com.bytedance.ee.util.ui.n.d(80);
        CommentImageAdapter r13 = this.h0;
        r13.c = com.bytedance.ee.util.ui.n.d(30);
        this.h0.notifyDataSetChanged();
        this.Y.setPadding(com.bytedance.ee.util.ui.n.d(16), 0, com.bytedance.ee.util.ui.n.d(16), com.bytedance.ee.util.ui.n.d(8));
        GradientDrawable r14 = new GradientDrawable();
        FragmentActivity r15 = this.a.getActivity();
        if (r15 == null) goto L12;
        Resources r16 = r15.getResources();
        if (r16 == null) goto L12;
        Configuration r17 = r16.getConfiguration();
        if (r17 == null) goto L12;
        int r18 = r17.screenWidthDp;
    L13:
        if (1 <= r18) goto L15;
    L17:
        boolean r19 = false;
    L18:
        if (r19 == false) goto L20;
        r11 = 4;
    L20:
        r14.setSize(com.bytedance.ee.util.ui.n.d(r11), com.bytedance.ee.util.ui.n.d(1));
        this.O.setDividerDrawable(r14);
        this.O.setShowDividers(2);
        this.C.setVisibility(4);
        this.D.setVisibility(8);
        this.N.setVisibility(8);
        goto L21
    L15:
        if (r18 >= 360) goto L17;
        r19 = true;
    L12:
        r18 = 0;
        goto L13
    }

    @Override // kf5.b
    public final void destroy() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.Z.d();
    L5:
        this.i0.b();
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = M();
        if (r0 == null) goto L9;
        r0.destroy();
    L9:
        if (this.V.isInitialized() == false) goto L11;
        CommentImmersiveVoiceTouchDelegate r1 = (CommentImmersiveVoiceTouchDelegate) this.V.getValue();
    L12:
        if (r1 == null) goto L15;
        r1.a();
        return;
    L15:
        return;
    L11:
        r1 = null;
        goto L12
    }

    @Override // kf5.b
    public final CommentEditText e() {
        return this.p;
    }

    @Override // kf5.b
    public final b2 f() {
        return this.i0;
    }

    @Override // kf5.b
    public final View getRootView() {
        return this.n;
    }

    @Override // kf5.b
    public final CommentInputRequest i() {
        return this.k;
    }

    public static final void A(InputComment r5) {
        kn4.g r0 = r5.p.getAtWindow();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ImageView r4 = null;
        if (r1 == false) goto L17;
        ImageView r2 = r5.q;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
    L14:
        r4.setSelected(false);
        kn4.g r6 = r5.p.getAtWindow();
        if (r6 == null) goto L27;
        r6.j();
        return;
    L27:
        return;
    L13:
        r4 = r2;
        goto L14
    L17:
        ImageView r3 = r5.q;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
    L21:
        r4.setSelected(true);
        r5.p.J();
        if (r5.n0 == true) goto L24;
        r5.Z(0);
        r5.B(false);
    L25:
        r5.C();
        return;
    L24:
        r5.B(true);
        goto L25
    L20:
        r4 = r3;
        goto L21
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    public static /* synthetic */ void a0(InputComment r2) {
        r2.Z(0);
    }

    public static final void u(InputComment r2) {
        r2.getClass();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
    L8:
        r2.X();
        return;
    L5:
        if (r2.X.isSelected() == false) goto L7;
        r2.Z(0);
        goto L8
    L7:
        r2.K();
        goto L8
    }

    public static final void y(InputComment r9) {
        if (r9.k.isCreate() == false) goto L29;
        String r0 = r9.k.local_comment_id;
        boolean r1 = true;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L30;
        Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> r3 = r9.d;
        Editable r4 = r9.p.getText();
        if (r4 == null) goto L17;
        String r5 = r4.toString();
        if (r5 == null) goto L17;
    L18:
        String r6 = r5;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = r9.i0.k;
        Boolean r8 = Boolean.TRUE;
        String r10 = r9.k.tmpCommentId;
        if (r9.E.getVisibility() != 0) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == true) goto L24;
    L26:
        r1 = false;
    L27:
        r3.invoke(r6, r7, r8, r10, Boolean.valueOf(r1));
        return;
    L24:
        if (r9.I.b == false) goto L26;
    L21:
        r11 = false;
    L17:
        r5 = "";
        goto L18
    L30:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    public final void B(boolean r8) {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.Z.d();
    L5:
        boolean r1 = false;
        this.X.setSelected(false);
        this.Z.c();
        if (this.n0 == true) goto L10;
        tt5.a.h("Comment#InputComment", "closeImageSelectorView in InputComment, fg is off");
        int r9 = com.bytedance.ee.bear.fileselector.d.a;
        com.bytedance.ee.bear.fileselector.d.a.a((FragmentManager) this.h.invoke(), "Comment#InputComment");
        return;
    L10:
        if (this.a.X.f() == true) goto L16;
        int r0 = com.bytedance.ee.bear.fileselector.d.a;
        boolean r2 = com.bytedance.ee.bear.fileselector.d.a.a((FragmentManager) this.h.invoke(), "Comment#InputComment");
        if (r8 == false) goto L14;
        Z(0);
    L14:
        tt5.a.h("Comment#InputComment", "closeImageSelectorView in InputComment, fg is on, use default selector, showKeyboardAfterDismiss=" + r8 + ", dismissedByManager=" + r2);
        return;
    L16:
        DialogFragment r3 = this.g0;
        if (r8 == false) goto L19;
        CommentImageSelectorDismissReason r5 = CommentImageSelectorDismissReason.PASSIVE_INPUT_HOST_CLOSE;
    L20:
        if (r3 != null) goto L22;
    L24:
        if (r8 == false) goto L27;
        if (r1 == true) goto L27;
        Z(0);
    L27:
        tt5.a.h("Comment#InputComment", "closeImageSelectorView in InputComment, fg is on, use host selector, showKeyboardAfterDismiss=" + r8 + ", dismissedByHost=" + r1 + ", reason=" + r5);
        return;
    L22:
        if (this.a.X.c(r3, r5) != true) goto L24;
        r1 = true;
        goto L24
    L19:
        r5 = CommentImageSelectorDismissReason.PASSIVE_INPUT_OTHER_ACTION;
        goto L20
    }

    public final List<ve5.m> E(List<? extends un5.l> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L43;
        un5.l r1 = (un5.l) r9.next();
        String r2 = r1.d;
        ve5.m r3 = null;
        if (r2 != null) goto L8;
    L41:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L41;
        String r4 = r1.a();
        if (r4 == null) goto L23;
        String r5 = StringsKt.removePrefix(r4, "@");
        if (r5 == null) goto L23;
        if ((!StringsKt.isBlank(r5)) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L23;
    L40:
        r3 = new ve5.m(r2, r5, r1.q);
    L23:
        String r6 = r1.i;
        if (r6 == null) goto L30;
        r5 = StringsKt.removePrefix(r6, "@");
        if (r5 == null) goto L30;
        if ((!StringsKt.isBlank(r5)) == false) goto L30;
    L31:
        if (r5 != null) goto L40;
        r5 = r1.f;
        if (r5 != null) goto L35;
    L37:
        r5 = null;
    L38:
        if (r5 != null) goto L40;
    L35:
        if ((!StringsKt.isBlank(r5)) == false) goto L37;
    L30:
        r5 = null;
        goto L31
    L43:
        return r0;
    }

    public final void O(boolean r14) {
        if (this.l0 == true) goto L6;
        tt5.a.h("Comment#InputComment", "mentionOptV2Enable is false");
        return;
    L6:
        boolean r0 = this.j.e();
        int r3 = 8;
        if (this.m0 == false) goto L12;
        tt5.a.h("Comment#InputComment", "mentionBatchAskOwnerEnable is true, currUserManageCollaborator is " + r0);
        if (r0 == true) goto L11;
        this.J.setText(com.bytedance.ee.util.ui.n.x(this.n.getContext(), 2131889126));
    L18:
        Editable r1 = this.p.getText();
        if (r1 == null) goto L32;
        Editable r4 = this.p.getText();
        if (r4 == null) goto L23;
        int r5 = r4.length();
    L24:
        un5.l[] r2 = (un5.l[]) r1.getSpans(0, r5, un5.l.class);
        if (r2 == null) goto L32;
        int r6 = r2.length;
        int r7 = 0;
        boolean r8 = false;
    L27:
        if (r7 >= r6) goto L34;
        if (r2[r7].j == false) goto L31;
        r8 = true;
    L31:
        r7 = r7 + 1;
    L34:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L39;
        if (Intrinsics.areEqual(this.H, Boolean.valueOf(r8)) == false) goto L39;
        return;
    L39:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L41;
        this.H = Boolean.valueOf(r8);
    L41:
        AnimatorSet r9 = this.F;
        if (r9 != null) goto L44;
    L46:
        boolean r10 = false;
    L47:
        if (r10 == false) goto L50;
        if (r8 == false) goto L50;
        return;
    L50:
        AnimatorSet r11 = this.G;
        if (r11 != null) goto L53;
    L55:
        boolean r12 = false;
    L56:
        if (r12 == false) goto L60;
        if (r8 == true) goto L60;
        return;
    L60:
        if (this.E.getVisibility() != 0) goto L62;
        boolean r13 = true;
    L63:
        if (r13 != r8) goto L79;
        AnimatorSet r15 = this.F;
        if (r15 != null) goto L67;
    L69:
        boolean r16 = false;
    L70:
        if (r16 == true) goto L79;
        AnimatorSet r17 = this.G;
        if (r17 != null) goto L74;
    L76:
        boolean r18 = false;
    L77:
        if (r18 == true) goto L79;
        return;
    L74:
        if (r17.isRunning() != true) goto L76;
        r18 = true;
        goto L77
    L67:
        if (r15.isRunning() != true) goto L69;
        r16 = true;
    L79:
        if (r8 == false) goto L100;
        com.bytedance.ee.bear.middleground.comment.uitls.p r19 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r20 = r19.d0;
        CommentInputRequest r21 = this.k;
        String r22 = r21.comment_id;
        if (r22 != null) goto L83;
        r22 = "";
    L83:
        String r23 = r21.reply_id;
        if (r23 != null) goto L86;
        String r24 = "";
    L87:
        CommentPlugin.g r25 = r19.R;
        if (r25 != null) goto L90;
    L92:
        boolean r110 = false;
    L93:
        CommentPlugin.g r26 = this.a.R;
        if (r26 != null) goto L96;
    L98:
        boolean r111 = false;
    L99:
        r20.f(r22, r24, r110, r111, this.k.visibilityBean.getReportVisibility());
        goto L100
    L96:
        if (r26.c() != true) goto L98;
        r111 = true;
        goto L99
    L90:
        if (r25.b() != true) goto L92;
        r110 = true;
        goto L93
    L86:
        r24 = r23;
    L100:
        AnimatorSet r27 = this.G;
        if (r27 == null) goto L103;
        r27.cancel();
    L103:
        AnimatorSet r28 = this.F;
        if (r28 == null) goto L106;
        r28.cancel();
    L106:
        this.I.setChecked(false);
        ViewGroup r29 = this.E;
        if (r8 == false) goto L109;
        r3 = 0;
    L109:
        r29.setVisibility(r3);
        if (r14 == false) goto L124;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L120;
        if (r8 == false) goto L120;
        ViewGroup r112 = this.E;
        ViewGroup.LayoutParams r30 = r112.getLayoutParams();
        if (r30 == null) goto L117;
        r30.height = -2;
    L118:
        r112.setLayoutParams(r30);
        this.E.setAlpha(1.0f);
        this.E.requestLayout();
        return;
    L117:
        r30 = null;
    L120:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L140;
        this.E.setAlpha(0.0f);
        return;
    L140:
        return;
    L124:
        if (this.F != null) goto L126;
    L127:
        int r113 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        this.E.getLayoutParams().height = -2;
        this.E.measure(r113, r113);
        this.F = F(0, this.E.getMeasuredHeight(), 0.0f, 1.0f);
        this.G = F(this.E.getMeasuredHeight(), 0, 1.0f, 0.0f);
    L128:
        if (r8 == false) goto L132;
        AnimatorSet r114 = this.F;
        if (r114 == null) goto L141;
        r114.start();
        return;
    L141:
        return;
    L132:
        AnimatorSet r115 = this.G;
        if (r115 == null) goto L143;
        r115.addListener(new m(this, r115, r115));
        r115.start();
        return;
    L143:
        return;
    L126:
        if (this.G != null) goto L128;
    L62:
        r13 = false;
        goto L63
    L53:
        if (r11.isRunning() != true) goto L55;
        r12 = true;
        goto L56
    L44:
        if (r9.isRunning() != true) goto L46;
        r10 = true;
        goto L47
    L23:
        r5 = 0;
    L32:
        r8 = false;
        goto L34
    L11:
        this.J.setText(com.bytedance.ee.util.ui.n.x(this.n.getContext(), 2131889123));
        goto L18
    L12:
        if (r0 == true) goto L18;
        tt5.a.h("Comment#InputComment", "currUserManageCollaborator is false");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L16;
        this.H = Boolean.FALSE;
    L16:
        this.E.setVisibility(8);
    }

    public final void T(boolean r1) {
        this.t0 = r1;
        e0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void Z(long r3) {
        this.Z.f(true);
        this.p.postDelayed(new InputComment$showKeyboardByEditText$1(this), r3);
        L();
    }

    @Override // kf5.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.u0.add(r2);
    }

    public final void b0(boolean r3) {
        ViewGroup.LayoutParams r0 = this.p.getLayoutParams();
        if (r3 == false) goto L6;
        if (r0 == null) goto L8;
        r0.height = (int) this.a.getActivity().getResources().getDimension(2131165348);
    L8:
        this.p.requestLayout();
        return;
    L6:
        if (r0 == null) goto L8;
        r0.height = -2;
        goto L8
    }

    @Override // kf5.b
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.u0.remove(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c0(boolean r4) {
        V();
        int r0 = 0;
        if (r4 == false) goto L13;
        this.O.setVisibility(8);
        this.Y.setVisibility(8);
        if (this.l0 == false) goto L7;
        this.q0 = Integer.valueOf(this.a.getActivity().getWindow().getNavigationBarColor());
        this.a.getActivity().getWindow().setNavigationBarColor(com.bytedance.ee.util.ui.n.h(this.a.getActivity(), 2131100549));
    L23:
        d0();
        this.a.h.getClass();
        if (com.bytedance.ee.bear.middleground.comment.p.c() != true) goto L30;
        ImageView r5 = this.q;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
        r5 = null;
    L28:
        r5.setVisibility(8);
        return;
    L30:
        return;
    L7:
        UDEditText r6 = this.p;
        if (N() == true) goto L11;
        r0 = 6;
    L11:
        r6.setMinLines(r0);
        goto L23
    L13:
        if (this.l0 == false) goto L17;
        Integer r7 = this.q0;
        if (r7 == null) goto L18;
        int r8 = r7.intValue();
        this.a.getActivity().getWindow().setNavigationBarColor(r8);
    L18:
        P();
        this.O.setVisibility(0);
        this.S.setVisibility(8);
        R();
        ImageView r9 = this.X;
        if (this.i0.c.E == true) goto L22;
        r0 = 8;
    L22:
        r9.setVisibility(r0);
        U();
        goto L23
    L17:
        this.p.setMinLines(0);
        goto L18
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
    @Override // kf5.b
    public final void j(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "userIds");
        this.j.l(r4);
        this.j.i(this.p, true, new InputComment$updateUserPermission$1(this));
    }

    @Override // kf5.b
    public final void n(SmartReplyDataForInsert r2) {
        this.i0.l = r2;
    }

    @Override // kf5.b
    public final void o(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3) {
        b2 r0 = this.i0;
        ((ArrayList) r0.k).clear();
        if (r3 == null) goto L5;
        ArrayList r1 = (ArrayList) r0.k;
        r1.addAll(r3);
    L5:
        CommentImageAdapter r4 = this.h0;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2 = this.i0.k;
        r4.p.dispose();
        r4.z2(r2, false);
        U();
        e0();
    }

    @Override // kf5.b
    public final void p(CommentInputRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.k = r2;
        this.i0.l(r2);
    }

    @Override // kf5.b
    public final void q(boolean r1) {
        this.l = r1;
        S();
    }

    @Override // kf5.b
    public final void r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.p.setRichText(r2);
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        this.p.post(new p(this));
        return;
    L9:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static final void v(InputComment r2, List r3) {
        r2.getClass();
        Flowable.just(r3).flatMap(new q0(r2, r3)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new r0(r2, r3), new s0(r2));
    }

    public static final void w(InputComment r5, List r6) {
        r5.getClass();
        tt5.a.b("Comment#InputComment", "Receive selected images. " + r6);
        r5.B(false);
        r5.Z(50);
        if (((ArrayList) r5.i0.k).size() != 9) goto L6;
        Toast.showFailureText(r5.a.getActivity(), xo5.a.c(r5.a.getActivity(), 2131886932, "count", "9"));
        return;
    L6:
        if ((!r6.isEmpty()) == true) goto L8;
        return;
    L8:
        if ((r6.size() + ((ArrayList) r5.i0.k).size()) <= 9) goto L10;
        r6 = r6.subList(0, 9 - ((ArrayList) r5.i0.k).size());
    L10:
        r5.i0.getClass();
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = b2.e(r6);
        r5.h0.z2(r7, true);
        b2 r1 = r5.i0;
        r1.getClass();
        ((ArrayList) r7).isEmpty();
        ((ArrayList) r1.k).addAll(r7);
        r5.e0();
        r5.a.N.a(new ef5.s(0, r7, r5));
        r5.U();
    }

    public static final boolean x(InputComment r1, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r2) {
        if (r1.isShowing() == false) goto L7;
        int r0 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p.g;
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p.a.a(r1.k)) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void Q(final boolean r4, Boolean r5) {
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L13:
        CommentVoiceMentionPermissionHelper r0 = J();
        CharSequence r1 = this.p.getText();
        if (r1 != null) goto L17;
        r1 = "";
    L17:
        r0.e(r1, r6, new InputComment$sendComment$1(this, r4));
        return;
    L5:
        if (this.E.getVisibility() != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L10;
    L12:
        r6 = false;
        goto L13
    L10:
        if (this.I.b == false) goto L12;
        r6 = true;
        goto L13
    L7:
        r7 = false;
        goto L8
    }

    @Override // kf5.b
    public final void d(final boolean r8, boolean r9) {
        tt5.a.h("Comment#InputComment", "dismiss(), bySend: " + r8 + ", isShowing: " + isShowing());
        if (isShowing() == true) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = M();
        if (r0 == null) goto L8;
        r0.d();
    L8:
        this.M.removeOnLayoutChangeListener(this.c0);
        this.n.removeCallbacks(this.b0);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.ee.util.ui.m.a(new j(this));     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        ViewGroup r2 = null;
        if (r8 == true) goto L20;
        Pair[] r3 = new Pair[3];
        r3[0] = new Pair("is_full_comment_flag", String.valueOf(this.k.is_whole));
        if (this.a.V == false) goto L18;
        String r4 = "discussion";
    L19:
        r3[1] = TuplesKt.to(ResourceData.KEY_TYPE, r4);
        r3[2] = TuplesKt.to("comment_visible_range", this.k.visibilityBean.getReportVisibility());
        this.a.d0.g("cancel_click", null, null, MapsKt.mutableMapOf(r3));
        goto L20
    L18:
        r4 = "comment";
    L20:
        kn4.g r5 = this.p.getAtWindow();
        if (r5 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L30;
        kn4.g r7 = this.p.getAtWindow();
        if (r7 == null) goto L30;
        r7.close();
    L30:
        CommentEditText r10 = this.p;
        r10.getClass();
        tt5.a.h("Comment#CommentEditText", "onInputHide");
        if (r10.V1 == true) goto L33;
    L35:
        IImageViewer r11 = this.r0;
        if (r11 == null) goto L38;
        r11.close();
    L38:
        this.r0 = null;
        C();
        B(false);
        sa5.b r12 = G();
        if (r12 == null) goto L41;
        r12.d(this.v0);
    L41:
        this.i0.f = false;
        P();
        this.e0 = 0;
        if (r9 == false) goto L44;
        rcb.c.d(this.n);
    L44:
        com.bytedance.ee.util.ui.m.a(new k(this));
        com.bytedance.ee.util.ui.j.e(this.w0);
        T(false);
        ViewParent r13 = this.n.getParent();
        if ((r13 instanceof ViewGroup) == false) goto L47;
        ViewGroup r14 = (ViewGroup) r13;
    L48:
        if (r14 == null) goto L50;
        r14.removeView(this.n);
    L50:
        View r15 = this.m;
        if (r15 == null) goto L53;
        ViewParent r16 = r15.getParent();
    L55:
        if ((r16 instanceof ViewGroup) == false) goto L57;
        r2 = (ViewGroup) r16;
    L57:
        if (r2 == null) goto L59;
        r2.removeView(this.m);
    L59:
        Iterator<T> r17 = this.b.a().iterator();
    L61:
        if (r17.hasNext() == false) goto L63;
        ((Function2) r17.next()).invoke(0, Boolean.valueOf(this.k.isForWhole()));
        goto L61
    L63:
        this.T.i();
        this.T.f();
        this.S.setVisibility(8);
        c0(false);
        H().d();
        int r18 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        com.bytedance.ee.bear.middleground.comment.uitls.n.a(this.p, new InputComment$dismiss$closeD$1(this, r8));
        return;
    L53:
        r16 = null;
        goto L55
    L47:
        r14 = null;
        goto L48
    L33:
        if (r10.g2 == true) goto L35;
        tt5.a.h("Comment#CommentEditText", "edittext is hidden after stopping recording, so force stop update audio text");
        r10.g2 = true;
        goto L35
    L23:
        if (r5.isShowing() != true) goto L25;
        r6 = true;
    L11:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // kf5.b
    public final void g(String r3, DriveCommentWrapper.7 r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.j.k(r3, true, r4);
    }

    @Override // kf5.b
    public final void m(List r2, com.bytedance.ee.bear.drive.biz.comment.e1 r3) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.j.j(r2, r3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void z(final InputComment r12, final CharSequence r13, boolean r14) {
        r12.getClass();
        if (StringsKt.isBlank(r13) == false) goto L5;
        tt5.a.h("Comment#InputComment", "sendVoiceCommentDirectly skip: blank content");
        return;
    L5:
        Editable r0 = r12.p.getText();
        int r2 = 0;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        r12.P();
        b2 r4 = r12.i0;
        CommentEditText r5 = r12.p;
        Function4<Boolean, String, Throwable, CommentInputRequest, Unit> r6 = new InputComment$sendVoiceCommentWithoutChangingDraft$1(r12, r13);
        InputComment$getVipCb$1 r7 = new InputComment$getVipCb$1(r12);
        int r15 = CommentVoiceEditTextBridge.i;
        r4.k(r5, r6, true, r7, r14, CommentVoiceEditTextBridge.a.b(r13), CollectionsKt.emptyList(), false);
        return;
    L20:
        r12.s();
        Editable r8 = r12.p.getText();
        if (r8 == null) goto L28;
        Editable r9 = r12.p.getText();
        if (r9 == null) goto L25;
        int r10 = r9.length();
    L27:
        if (r8.replace(0, r10, r13) == null) goto L28;
    L29:
        UDEditText r16 = r12.p;
        Editable r11 = r16.getText();
        if (r11 == null) goto L32;
        r2 = r11.length();
    L32:
        r16.setSelection(r2);
        r12.j.i(r12.p, true, new InputComment$sendVoiceCommentDirectly$1(r12));
        r12.Q(true, Boolean.valueOf(r14));
        return;
    L25:
        r10 = 0;
    L28:
        r12.p.setText(new SpannableStringBuilder(r13));
        Unit r17 = Unit.INSTANCE;
        goto L29
    L14:
        if ((!((ArrayList) r12.i0.k).isEmpty()) == true) goto L17;
        r3 = false;
        goto L18
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r1 = false;
        goto L12
    }

    @Override // kf5.b
    public final void k(String r2, boolean r3, ArrayList<String> r4) {
        AtFinderViewModel r0 = this.t.e;
        if (r0 == null) goto L6;
        r0.setOwnerAndAuthors(r2, r3, r4);
        return;
    }

    public final AnimatorSet F(int r6, int r7, float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r6, r7});
        r10.addUpdateListener(new i(this));
        r0.playTogether(new Animator[]{r10, ObjectAnimator.ofFloat(this.E, "alpha", new float[]{r8, r9})});
        r0.setDuration(100);
        return r0;
    }

    /* JADX WARN: Type inference failed for: r5v24, types: [android.widget.EditText, com.bytedance.ee.bear.middleground.comment.widget.CommentEditText] */
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
    @Override // kf5.b
    public final void h(boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        String r4 = "";
        r("");
        tt5.a.h("Comment#InputComment", "show(), showRecordPanel: " + r16 + ", showAt: " + r17 + ", showKeyBoard: " + r18 + ", inputRequest: " + this.i0.e);
        this.M.removeOnLayoutChangeListener(this.c0);
        this.M.addOnLayoutChangeListener(this.c0);
        this.n.removeCallbacks(this.b0);
        this.n.post(this.b0);
        int r6 = 8;
        boolean r7 = true;
        if (this.a.W == false) goto L5;
        this.Z.setVisibility(8);
        this.Z.setHostAdjustResize(true);
    L7:
        if (this.a.o != 0) goto L9;
    L15:
        String r5 = this.a.getActivity().getString(2131887661);
    L16:
        Intrinsics.checkNotNull(r5);
        this.p.setHint(this.i0.e.resolveInputHint(r5));
        if (this.a.B == false) goto L19;
        this.j.i(this.p, true, new InputComment$setInputConfig$1(this));
    L19:
        FrameLayout r8 = this.v;
        if (this.i0.f() == true) goto L22;
    L29:
        int r9 = 8;
    L30:
        r8.setVisibility(r9);
        this.r.setSelected(this.a.g0.b);
        if (this.r.isSelected() == true) goto L42;
        LiveData<ConnectionService.NetworkState> r10 = this.j0;
        if (r10 == null) goto L39;
        ConnectionService.NetworkState r11 = (ConnectionService.NetworkState) r10.getValue();
        if (r11 == null) goto L39;
        if (r11.a() != true) goto L39;
    L40:
        if (r7 == true) goto L42;
        this.r.setEnabled(false);
    L39:
        r7 = false;
    L42:
        R();
        ImageView r12 = this.X;
        if (this.i0.c.E == false) goto L45;
        r6 = 0;
    L45:
        r12.setVisibility(r6);
        U();
        ?? r13 = this.p;
        CharSequence r14 = r13.getHint();
        if (r14 == null) goto L51;
        String r15 = r14.toString();
        if (r15 == null) goto L51;
        r4 = r15;
    L51:
        r13.setOriginHint(r4);
        boolean r21 = this.i0.e.is_whole;
        if (r21 == false) goto L54;
        String r110 = "full_comment";
    L55:
        if (r21 == false) goto L57;
        String r111 = "full_comment";
    L58:
        int r22 = AtUtils.h(this.a.k);
        if (TextUtils.isEmpty(this.a.I) == true) goto L61;
        int r112 = 24;
    L62:
        CommentEditText r23 = this.p;
        com.bytedance.ee.bear.middleground.comment.uitls.p r24 = this.a;
        bo4.d r25 = new bo4.d(r24.i, r112, r110, r111, r24.I);
        kn4.g r26 = r23.k1;
        if (r26 == null) goto L65;
        r26.g(r25);
    L65:
        this.j0 = com.bytedance.ee.bear.contract.j.a.a.a();
        com.bytedance.ee.util.ui.m.a(new n0(this));
        View r27 = this.m;
        ImageView r28 = null;
        if (r27 == null) goto L68;
        ViewParent r29 = r27.getParent();
    L70:
        if ((r29 instanceof ViewGroup) == false) goto L72;
        ViewGroup r30 = (ViewGroup) r29;
    L73:
        if (r30 == null) goto L75;
        r30.removeView(this.m);
    L75:
        ((ViewGroup) this.g.invoke()).addView(this.m);
        ViewGroup r31 = (ViewGroup) this.n.getParent();
        if (r31 == null) goto L78;
        r31.removeView(this.n);
    L78:
        com.bytedance.ee.bear.middleground.comment.uitls.p r32 = this.a;
        if (r32.s == true) goto L81;
        ((ViewGroup) this.g.invoke()).addView(this.n);
    L95:
        sa5.b r33 = G();
        if (r33 == null) goto L98;
        r33.e(this.v0);
    L98:
        b();
        this.a.N.a(new ef5.t(this));
        this.j.n();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L101;
        this.H = null;
    L101:
        this.j.i(this.p, false, new InputComment$show$1(this));
        List<ve5.m> r34 = E(D());
        ve5.e r35 = H();
        r35.getClass();
        Intrinsics.checkNotNullParameter(r34, "mentions");
        r35.l(r34);
        H().j();
        this.I.setChecked(r20);
        if (r17 == false) goto L108;
        ImageView r2 = this.q;
        if (r2 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
    L107:
        r28.performClick();
        goto L108
    L106:
        r28 = r2;
    L108:
        if (r16 == false) goto L112;
        this.p.setShowSoftInputOnFocus(false);
        this.p.requestFocus();
        com.bytedance.ee.bear.middleground.comment.audio.b r1 = this.u.a;
        if (r1 == null) goto L116;
        r1.onClick();
    L116:
        this.p.requestFocus();
        com.bytedance.ee.util.ui.m.a(new q(this));
        this.b.B0().invoke();
        return;
    L112:
        if (r19 == false) goto L114;
        X();
        goto L116
    L114:
        if (r18 == false) goto L116;
        Z(50);
        goto L116
    L81:
        if (r32.V == false) goto L83;
        ((ViewGroup) this.g.invoke()).addView(this.n);
        goto L95
    L83:
        FragmentActivity r36 = r32.getActivity();
        ((com.ss.android.lark.insets.c) WindowInsetsUtils.c(r36)).b = new o0(this);
        Window r37 = r36.getWindow();
        if (r37 == null) goto L95;
        View r38 = r37.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L90;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r39 = ThreadMethodProxy.currentThread();
        if (r39 == com.larus.home.impl.utils.c.a) goto L90;
        com.larus.home.impl.utils.c.a(r39, "getDecorView");
    L90:
        if (r38 == null) goto L95;
        ViewGroup r40 = (ViewGroup) r38.findViewById(R.id.content);
        if (r40 == null) goto L95;
        r40.addView(this.n);
        goto L95
    L72:
        r30 = null;
        goto L73
    L68:
        r29 = null;
        goto L70
    L61:
        r112 = r22;
        goto L62
    L57:
        r111 = "part_comment";
        goto L58
    L54:
        r110 = "part_comment";
        goto L55
    L22:
        if (this.i0.j() == true) goto L24;
    L26:
        boolean r41 = false;
    L27:
        if (r41 == true) goto L29;
        r9 = 0;
        goto L30
    L24:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L26;
        r41 = true;
        goto L27
    L9:
        if (this.i0.e.isCreate() == true) goto L15;
        if (this.i0.e.visibilityBean.getType() == 0) goto L14;
        r5 = this.a.getActivity().getString(2131889228);
        goto L16
    L14:
        r5 = this.a.getActivity().getString(2131887629);
        goto L16
    L5:
        this.Z.setVisibility(0);
        this.Z.setHostAdjustResize(false);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.widget.ImageView, com.bytedance.ee.bear.middleground.comment.audio.MotionImageView] */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.widget.EditText, android.widget.TextView, com.bytedance.ee.bear.middleground.comment.widget.CommentEditText, com.bytedance.ee.bear.widget.AtEditText, java.lang.Object] */
    public InputComment(com.bytedance.ee.bear.middleground.comment.uitls.p r27, com.bytedance.ee.bear.middleground.comment.control.z r28, com.bytedance.ee.bear.middleground.comment.control.t r29, Function1<? super String, Unit> r30, CommentInputRequest r31, Function5<? super String, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, ? super Boolean, ? super String, ? super Boolean, Unit> r32, Function1<? super Integer, Unit> r33, boolean r34, Map<String, String> r35, Function0<? extends ViewGroup> r36, Function0<? extends FragmentManager> r37, bb5.b r38, SharePermissionViewModel r39) {
        Intrinsics.checkNotNullParameter(r27, "configComment");
        Intrinsics.checkNotNullParameter(r28, "commentListeners");
        Intrinsics.checkNotNullParameter(r29, "dataControl");
        Intrinsics.checkNotNullParameter(r30, "createCallBack");
        Intrinsics.checkNotNullParameter(r31, "inputRequest");
        Intrinsics.checkNotNullParameter(r32, "dismissCallback");
        Intrinsics.checkNotNullParameter(r33, "heightChange");
        Intrinsics.checkNotNullParameter(r36, "getViewParent");
        Intrinsics.checkNotNullParameter(r37, "getFragmentManager");
        Intrinsics.checkNotNullParameter(r38, "dialogLifecycle");
        Intrinsics.checkNotNullParameter(r39, "sharePermissionViewModel");
        this.a = r27;
        this.b = r28;
        this.c = r30;
        this.d = r32;
        this.e = r33;
        this.f = r35;
        this.g = r36;
        this.h = r37;
        this.i = r38;
        this.j = r39;
        this.k = r31;
        this.l = r34;
        RecordViewModel r4 = new RecordViewModel(r27);
        this.T = r4;
        this.U = LazyKt.lazy(new InputComment$voiceAdapterLazy$1(this));
        this.V = LazyKt.lazy(new InputComment$immersiveVoiceTouchDelegateLazy$1(this));
        this.W = LazyKt.lazy(new InputComment$voiceMentionPermissionHelper$2(this));
        this.b0 = new t(this);
        this.c0 = new h(this);
        this.d0 = LazyKt.lazy(new InputComment$botMentionHintCoordinator$2(this));
        CommentImageAdapter r5 = new CommentImageAdapter();
        this.h0 = r5;
        b2 r6 = new b2(r27, r29, r28);
        this.i0 = r6;
        this.k0 = new l(this);
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r2.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.l0 = r3;
        this.m0 = r2.g("ccm.mobile.comment_batch_askowner");
        this.n0 = !r2.g("ccm_mobile_ccm_at_doubao_reverse_in_feishu");
        this.o0 = r2.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.p0 = r2.h("ccm.mobile.shrink_comment_panel_when_zoom_in");
        this.u0 = new HashSet();
        this.m = new View(r27.getActivity());
        View r7 = LayoutInflater.from(r27.getActivity()).inflate(2131559863, null);
        this.n = r7;
        r7.setOnClickListener(new d(this));
        View r9 = r7.findViewById(2131367794);
        this.o = r9;
        ViewGroup r10 = (ViewGroup) r7.findViewById(2131365642);
        this.E = r10;
        this.J = (TextView) r7.findViewById(2131365655);
        LKUICheckBox2 r12 = r7.findViewById(2131365640);
        this.I = r12;
        View r13 = r7.findViewById(2131365659);
        this.K = r13;
        ?? r14 = (CommentEditText) r7.findViewById(2131369299);
        this.p = r14;
        View r15 = r7.findViewById(2131369300);
        this.R = r15;
        FrameLayout r8 = (FrameLayout) r7.findViewById(2131372887);
        this.v = r8;
        ?? r11 = (MotionImageView) r7.findViewById(2131367301);
        this.u = r11;
        ImageView r16 = (ImageView) r7.findViewById(2131369295);
        this.q = r16;
        this.L = (SharePermissionView) r7.findViewById(2131387022);
        ImageView r17 = (ImageView) r7.findViewById(2131369294);
        this.r = r17;
        ImageView r18 = (ImageView) r7.findViewById(2131369348);
        this.s = r18;
        AtFinderView r19 = (AtFinderView) r7.findViewById(2131363295);
        this.t = r19;
        View r110 = r7.findViewById(2131369209);
        this.A = r110;
        View r111 = r7.findViewById(2131369210);
        this.B = r111;
        ImageView r20 = (ImageView) r7.findViewById(2131369305);
        this.X = r20;
        RecyclerView r112 = r7.findViewById(2131385004);
        this.Y = r112;
        RecordPanelView r21 = (RecordPanelView) r7.findViewById(2131392643);
        this.S = r21;
        Flow r113 = r7.findViewById(2131369298);
        this.M = r113;
        this.Q = r7.findViewById(2131375404);
        LinearLayout r22 = (LinearLayout) r7.findViewById(2131369296);
        this.O = r22;
        View r114 = r7.findViewById(2131367474);
        this.P = r114;
        if ((r114 instanceof CommentVoiceBarLayout) == false) goto L11;
        CommentVoiceBarLayout r115 = (CommentVoiceBarLayout) r114;
    L13:
        if (r115 == null) goto L16;
        r115.setToggleIconConfig(r27.X.l());
    L16:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L19;
        we5.a.a(r22, r8, r20);
    L19:
        ImageView r23 = (ImageView) r7.findViewById(2131369297);
        this.N = r23;
        this.C = r7.findViewById(2131369189);
        this.D = r7.findViewById(2131369190);
        InputCommentVisibleView r116 = (InputCommentVisibleView) r7.findViewById(2131367470);
        this.w = r116;
        AppCompatImageView r117 = r7.findViewById(2131369309);
        this.x = r117;
        AppCompatImageView r118 = r7.findViewById(2131369302);
        this.y = r118;
        CommentKeyboardPlaceholderView r119 = (CommentKeyboardPlaceholderView) r7.findViewById(2131376823);
        this.Z = r119;
        BotAtHintView r24 = (BotAtHintView) r7.findViewById(2131364352);
        this.a0 = r24;
        if (r24 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("botAtHintView");
        BotAtHintView r25 = null;
    L23:
        r25.setCommentAnalytic(r27.d0);
        if (r24 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("botAtHintView");
        BotAtHintView r26 = null;
    L27:
        r26.setOnActionClick(new AnonymousClass7(this));
        if (r24 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("botAtHintView");
        boolean r40 = false;
        r24 = null;
    L31:
        r24.setRecyclerNestedScrollingEnabled(r40);
        r21.setViewModel(r4);
        r21.setCommentAnalytic(r27.d0);
        if (r27.G == false) goto L35;
        zz7.a.d(r14, LarkFont.BODY0);
    L35:
        if (r3 == true) goto L37;
        r9.setBackground(new ColorDrawable(com.bytedance.ee.util.ui.n.h(r27.getActivity(), 2131100548)));
        r110.setBackground(new ColorDrawable(com.bytedance.ee.util.ui.n.h(r27.getActivity(), 2131103351)));
        com.bytedance.ee.util.ui.l.b(r15, 2131109046);
        ViewGroup.LayoutParams r41 = r113.getLayoutParams();
        r41.width = -2;
        r113.setLayoutParams(r41);
        r10.setVisibility(8);
        r22.setBackground(null);
        r111.setBackground(new ColorDrawable(com.bytedance.ee.util.ui.n.h(r27.getActivity(), 2131100548)));
        r119.setBackground(new ColorDrawable(com.bytedance.ee.util.ui.n.h(r27.getActivity(), 2131100548)));
    L37:
        r27.h.getClass();
        r6.l(this.k);
        r112.setLayoutManager(new LinearLayoutManager(r27.getActivity(), 0, false));
        r112.addItemDecoration(new InputComment$initDefaultData$1());
        r5.a = r6.c.E;
        r5.notifyDataSetChanged();
        r112.setAdapter(r5);
        r119.setKeyboardHeightProvider(r27.r);
        r14.setPreImeListener(new t0(this));
        if (r3 == false) goto L40;
        r14.setMovementMethod(new com.bytedance.ee.bear.middleground.comment.widget.l0());
    L40:
        U();
        V();
        C();
        r27.getActivity();
        kn4.h r42 = new kn4.h(kn4.f.a().a(), r27.k, r27.i);
        r42.l = r19;
        r42.k = 1;
        ArrayList r43 = new ArrayList();
        r43.addAll(AtUtils.c());
        r43.addAll(ArraysKt.toList(com.bytedance.ee.bear.utils.a.c));
        r43.add("7");
        r42.j = r43;
        r42.p = ((xe5.a) org.koin.java.a.c(xe5.a.class, null, null, 6)).a(r35);
        this.p.C(r42);
        kn4.g r44 = r14.getAtWindow();
        if (r44 == null) goto L43;
        r44.b(new u0(this));
    L43:
        kn4.g r45 = r14.getAtWindow();
        if (r45 == null) goto L46;
        r45.j();
    L46:
        kn4.g r46 = r14.getAtWindow();
        if (r46 == null) goto L49;
        r46.f(new v0(this));
    L49:
        r14.setOnPasteListener(new x0(this));
        r27.h.getClass();
        if (com.bytedance.ee.bear.middleground.comment.p.c() != true) goto L55;
        if (r16 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
        ImageView r47 = null;
    L54:
        r47.setVisibility(8);
        goto L55
    L53:
        r47 = r16;
    L55:
        Intrinsics.checkNotNullParameter(r14, "editText");
        r21.i = r14;
        r17.setOnClickListener(new h1(this));
        r14.addOnAttachStateChangeListener(new m1(this));
        r13.setOnClickListener(new n1(this));
        r12.setOnCheckedChangeListener(new o1(this));
        if (rcb.b.a(r27.getActivity()) == false) goto L58;
        r14.setOnEditorActionListener(new p1(this));
    L58:
        r14.addTextChangedListener(new InputComment$setListener$6(this));
        S();
        r18.setOnClickListener(new q1(this));
        r21.setOnClickListener(r1.a);
        r23.setOnClickListener(new s1(this));
        r119.setOnHeightChangeListener(new y0(this));
        r9.addOnLayoutChangeListener(new z0(this));
        r14.setOnClickListener(new a1(this));
        r11.setOnTouchListener(new b1(this));
        r11.setMotionCallbackListener(new InputComment$setListener$14(this));
        View r48 = r114.findViewById(2131387913);
        if (r48 == null) goto L61;
        r48.setOnClickListener(new c1(this));
    L61:
        View r49 = r114.findViewById(2131371700);
        if (r49 == null) goto L64;
        r49.setOnTouchListener(new d1(this));
    L64:
        if (r16 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
        ImageView r120 = null;
    L67:
        r120.setOnClickListener(new e1(this));
        r19.setAtFinderViewDelegate(new f1(this));
        bf5.a r50 = r27.S;
        int r51 = r27.k.b;
        gj5.c r52 = r50.a(r27.i);
        Ref.ObjectRef r53 = new Ref.ObjectRef();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r54 = jg5.e.a.a.g();
        if (r54 == false) goto L71;
        r53.element = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, ""), "ATTACHMENT_UPLOAD"), null);
    L71:
        if (r52.a == false) goto L73;
        float r55 = 1.0f;
    L74:
        r20.setAlpha(r55);
        r20.setOnClickListener(new g1(r54, r53, this, r52));
        r5.j = new i1(this);
        r5.k = new j1(this);
        r21.setRecordPanelOperationCallback(new k1(this));
        r9.setOnClickListener(l1.a);
        FileSelectConfig.e r56 = FileSelectConfig.ccmAlbumBuilder();
        FileSelectConfig r57 = ((FileSelectConfig.c) r56).a;
        r57.adjustHeightByKeyboard = false;
        r57.showGif = true;
        r57.showVideo = false;
        r57.enableImageCompress = true;
        r57.actionType = 1;
        r57.totalMaxPhotoCount = 9;
        e r58 = new e(this);
        FileSelectConfig r59 = ((FileSelectConfig.c) r56).a;
        r59.fileSelectListener = r58;
        r59.dialogLifecycle = r38;
        if (r2.g("ccm.bitable.comment_memory_leak_fix_enable") == false) goto L82;
        if (r27.V == false) goto L79;
    L84:
        this.f0 = r56.a();
        r5.g = r27.i;
        r5.h = r27.k.b;
        r117.setOnClickListener(new a(this));
        r116.setOnClickListener(new b(this));
        r118.setOnClickListener(new c(this));
        this.v0 = new g(this);
        this.w0 = new o(this);
        return;
    L79:
        if (ForsetiHelper.s(r27.b) == false) goto L84;
        ((FileSelectConfig.c) r56).a.container = r27.c;
        goto L84
    L82:
        if (ForsetiHelper.s(r27.b) == false) goto L84;
        ((FileSelectConfig.c) r56).a.container = r27.c;
        goto L84
    L73:
        r55 = 0.5f;
        goto L74
    L66:
        r120 = r16;
        goto L67
    L30:
        r40 = false;
        goto L31
    L26:
        r26 = r24;
        goto L27
    L22:
        r25 = r24;
        goto L23
    L11:
        r115 = null;
        goto L13
    L5:
        if (r2.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r3 = true;
        goto L8
    }
}
