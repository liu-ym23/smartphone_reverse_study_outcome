package com.larus.livetutor.impl.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.livetutor.api.idl.DoubaoActionbarPageQueryParams;
import com.larus.livetutor.api.idl.LiveTutorQueryType;
import com.larus.livetutor.api.idl.LiveTutorV2Params;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 M2\u00020\u0001:\u0001MB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u000206J\u0014\u00107\u001a\u000202*\u00020\u00172\u0006\u00108\u001a\u000209H\u0002J\f\u0010:\u001a\u000202*\u00020\u0017H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u000209H\u0002J\u0010\u0010=\u001a\u0002022\u0006\u00105\u001a\u000206H\u0002J\b\u0010>\u001a\u000202H\u0002J\b\u0010?\u001a\u000202H\u0002J\u0017\u0010@\u001a\u0002022\b\u0010A\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u000202J\u0006\u0010D\u001a\u000202J\u0006\u0010E\u001a\u000202J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020\u0007H\u0016J\b\u0010H\u001a\u000202H\u0014J\f\u0010I\u001a\u000202*\u00020 H\u0002J\f\u0010J\u001a\u000202*\u00020 H\u0002J\f\u0010K\u001a\u000202*\u00020 H\u0002J\b\u0010L\u001a\u00020\u0007H\u0002R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b%\u0010\"R\u001b\u0010'\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b(\u0010\"R\u001b\u0010*\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b+\u0010\"R\u001b\u0010-\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b.\u0010\u001dR\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/livetutor/impl/view/LiveTutorPlanView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentLoadingStep", "Ljava/lang/Integer;", "enterAnim", "Landroid/animation/AnimatorSet;", "loadingView", "Landroid/view/View;", "planningImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getPlanningImage", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "planningImage$delegate", "Lkotlin/Lazy;", "planningText", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "getPlanningText", "()Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "planningText$delegate", "planningContainer", "getPlanningContainer", "()Landroid/view/View;", "planningContainer$delegate", "maskLottie1", "Lcom/airbnb/lottie/LottieAnimationView;", "getMaskLottie1", "()Lcom/airbnb/lottie/LottieAnimationView;", "maskLottie1$delegate", "maskLottie2", "getMaskLottie2", "maskLottie2$delegate", "titleLottie", "getTitleLottie", "titleLottie$delegate", "bgLottie", "getBgLottie", "bgLottie$delegate", "gradientMask", "getGradientMask", "gradientMask$delegate", "defaultLoadingStep", "adapterSizeByScreen", "", "initContainer", "initLoading", "viewModel", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "loadText", "queryText", "", "calculateHeight", "loadImage", "queryImage", "initObserver", "initTitleLottie", "startEdgeLottie", "setLoadingStep", "step", "(Ljava/lang/Integer;)V", "endLoading", "justStopAnimation", "continueLoading", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "onDetachedFromWindow", "play", "playOnce", "loading1Play", "getContainerWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorPlanView extends ConstraintLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f356713m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f356714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f356715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f356716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f356717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f356718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f356719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f356720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f356721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f356722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f356723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f356724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f356725l;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorPlanView f356726a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public b(LiveTutorPlanView r100) {
            this.f356726a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            com.larus.utils.e1.x(LiveTutorPlanView.V5(this.f356726a));
            LiveTutorPlanView r101 = this.f356726a;
            r101.getClass();
            UtilsKt.w(r101, new LiveTutorPlanView$startEdgeLottie$1(r101, null));
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorPlanView f356727a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public c(LiveTutorPlanView r100) {
            this.f356727a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            com.larus.utils.e1.x(LiveTutorPlanView.Z5(this.f356727a));
            LiveTutorPlanView r101 = this.f356727a;
            LiveTutorPlanView.b6(r101, Integer.valueOf(r101.f356725l));
            com.larus.utils.e1.o(LiveTutorPlanView.V5(this.f356727a));
            com.larus.utils.e1.x(LiveTutorPlanView.T5(this.f356727a));
            LottieAnimationView r102 = LiveTutorPlanView.U5(this.f356727a);
            r102.setImageAssetsFolder("KuangNeiLiuGuang/images");
            r102.setAnimation("KuangNeiLiuGuang/KuangNeiLiuGuang.json");
            r102.setRepeatCount(-1);
            r102.playAnimation();
            LottieAnimationView r103 = LiveTutorPlanView.T5(this.f356727a);
            r103.setAnimation("BGLiuGuang/BGLiuGuang.json");
            r103.setImageAssetsFolder("BGLiuGuang/images");
            r103.setRepeatCount(-1);
            r103.playAnimation();
        }
    }

    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356728a;

        public d(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356728a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356728a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356728a.invoke(r100);
        }
    }

    static {
    }

    public LiveTutorPlanView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveTutorPlanView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LottieAnimationView getBgLottie() {
        return (LottieAnimationView) this.f356723j.getValue();
    }

    private final int getContainerWidth() {
        if (com.larus.platform.service.e2.f365734a.isPad() == false) goto L6;
        return (int) (com.larus.utils.i.d(UtilsKt.c()) * 0.7f);
    L6:
        return com.larus.utils.i.d(UtilsKt.c()) - (i5.E() * 2);
    }

    private final View getGradientMask() {
        return (View) this.f356724k.getValue();
    }

    private final LottieAnimationView getMaskLottie1() {
        return (LottieAnimationView) this.f356720g.getValue();
    }

    private final LottieAnimationView getMaskLottie2() {
        return (LottieAnimationView) this.f356721h.getValue();
    }

    private final View getPlanningContainer() {
        return (View) this.f356719f.getValue();
    }

    private final SimpleDraweeView getPlanningImage() {
        return (SimpleDraweeView) this.f356717d.getValue();
    }

    private final CustomMarkdownTextView getPlanningText() {
        return (CustomMarkdownTextView) this.f356718e.getValue();
    }

    private final LottieAnimationView getTitleLottie() {
        return (LottieAnimationView) this.f356722i.getValue();
    }

    public final void k6() {
        setLoadingStep(Integer.valueOf(this.f356725l));
        getBgLottie().playAnimation();
        getMaskLottie1().playAnimation();
        getMaskLottie2().playAnimation();
    }

    public final void c6() {
        int r100 = getContainerWidth();
        int r101 = (int) (r100 / 3.42f);
        View r102 = getPlanningContainer();
        UtilsKt.s(r102, r100, r101);
        float r103 = (i5.v() * r100) / c7.b(342);
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setColor(ColorProtector.parseColor("#F4F4F4"));
        r104.setCornerRadius(r103);
        r102.setBackground(r104);
        View r105 = getPlanningContainer();
        r105.setOutlineProvider(new f0(r103));
        r105.setClipToOutline(true);
        TextViewCompat.setLineHeight(getPlanningText(), i5.E());
        boolean r106 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorPlanView] scaleLottie width = " + r100 + " containerHeight = " + r101);
        UtilsKt.p(getMaskLottie1(), r100, r101);
        UtilsKt.p(getMaskLottie2(), r100, r101);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L5
        getGradientMask().setBackground(new com.larus.livetutor.impl.utils.f(new int[]{Color.parseColor("#00F4F4F4"), Color.parseColor("#99F4F4F4"), Color.parseColor("#FFF4F4F4")}, new float[]{0.0f, 0.6f, 1.0f}, new Point(0, 0), new Point(0, i5.W())));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        LottieAnimationView r108 = getTitleLottie();
        r108.setImageAssetsFolder("loading_Collection/images");
        if (com.larus.platform.service.e2.f365734a.isPad() == false) goto L13;
        UtilsKt.g(r108, Integer.valueOf((int) (com.larus.utils.i.d(UtilsKt.c()) * 0.15f)), null, null, null, 14);
        int r109 = ((Number) i5.R1.getValue()).intValue();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        ViewGroup.LayoutParams r110 = r108.getLayoutParams();
        if (r110 == null) goto L13;
        r110.width = r109;
        r108.setLayoutParams(r110);
    L13:
        UtilsKt.p(getBgLottie(), com.larus.utils.i.d(UtilsKt.c()), c7.b(Integer.valueOf(BDVideoUploaderBase.KeyIsDynamicSliceLowSize)));
        i6(getPlanningText());
        return;
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void n6() {
        getMaskLottie2().setProgress(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s6();
    }

    public final void s6() {
        getTitleLottie().cancelAnimation();
        getBgLottie().cancelAnimation();
        getMaskLottie1().cancelAnimation();
        getMaskLottie2().cancelAnimation();
        AnimatorSet r100 = this.f356715b;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public static final /* synthetic */ LottieAnimationView T5(LiveTutorPlanView r100) {
        return r100.getBgLottie();
    }

    public static final /* synthetic */ LottieAnimationView U5(LiveTutorPlanView r100) {
        return r100.getMaskLottie1();
    }

    public static final /* synthetic */ LottieAnimationView V5(LiveTutorPlanView r100) {
        return r100.getMaskLottie2();
    }

    public static final /* synthetic */ SimpleDraweeView Y5(LiveTutorPlanView r100) {
        return r100.getPlanningImage();
    }

    public static final /* synthetic */ LottieAnimationView Z5(LiveTutorPlanView r100) {
        return r100.getTitleLottie();
    }

    private final void setLoadingStep(Integer r100) {
        if (Intrinsics.areEqual(r100, this.f356714a) == true) goto L5;
    L7:
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorPlanView] setLoadingStep step = " + r100);
        this.f356714a = r100;
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        if (r100 != null) goto L21;
    L23:
        if (r100 != null) goto L26;
        return;
    L26:
        if (r100.intValue() != 4) goto L32;
        LottieAnimationView r102 = getTitleLottie();
        r102.setAnimation("loading_Collection/lottie4.json");
        r102.setRepeatCount(-1);
        r102.removeAllAnimatorListeners();
        r102.playAnimation();
        return;
    L32:
        return;
    L21:
        if (r100.intValue() != 3) goto L23;
        LottieAnimationView r103 = getTitleLottie();
        r103.setAnimation("loading_Collection/lottie3.json");
        r103.removeAllAnimatorListeners();
        r103.setRepeatCount(0);
        r103.addAnimatorListener(new i0(this));
        r103.playAnimation();
        return;
    L16:
        if (r100.intValue() != 2) goto L18;
        LottieAnimationView r104 = getTitleLottie();
        r104.setAnimation("loading_Collection/lottie2.json");
        r104.removeAllAnimatorListeners();
        r104.setRepeatCount(0);
        r104.addAnimatorListener(new i0(this));
        r104.playAnimation();
        return;
    L11:
        if (r100.intValue() != 1) goto L13;
        LottieAnimationView r105 = getTitleLottie();
        r105.setAnimation("loading_Collection/lottie1.json");
        r105.removeAllAnimatorListeners();
        r105.setMinAndMaxFrame(0, 77);
        r105.addAnimatorListener(new h0(this));
        r105.setRepeatCount(0);
        r105.playAnimation();
        return;
    L5:
        if (getTitleLottie().isAnimating() == false) goto L7;
    }

    public final void i6(CustomMarkdownTextView r100) {
        CharSequence r101 = r100.getText();
        boolean r102 = true;
        int r103 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        com.larus.utils.e1.o(getGradientMask());
        return;
    L12:
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L16:
        if (r106 != null) goto L18;
        return;
    L18:
        r100.measure(View.MeasureSpec.makeMeasureSpec((getContainerWidth() - r106.leftMargin) - r106.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r107 = r100.getMeasuredHeight();
        View r108 = getGradientMask();
        ViewGroup.LayoutParams r109 = getPlanningContainer().getLayoutParams();
        if (r109 == null) goto L21;
        int r110 = r109.height;
    L22:
        if (r107 > r110) goto L25;
        r102 = false;
    L25:
        if (r102 == true) goto L28;
        r103 = 8;
    L28:
        r108.setVisibility(r103);
        return;
    L21:
        r110 = 0;
        goto L22
    L15:
        r106 = null;
        goto L16
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public final void o6(LiveTutorViewModel r110) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        String r100 = oj9.b.b(r110.getLiveTutorV2Params());
        String r101 = oj9.b.c(r110.getLiveTutorV2Params());
        LiveTutorV2Params r102 = r110.getLiveTutorV2Params();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        DoubaoActionbarPageQueryParams r103 = r102.getDoubaoActionbarPageQueryParams();
        if (r103 == null) goto L10;
        Integer r104 = r103.getQueryType();
        int r105 = LiveTutorQueryType.FixedQuery.getValue();
        if (r104 == null) goto L10;
        if (r104.intValue() != r105) goto L10;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        int r107 = 4;
    L15:
        this.f356725l = r107;
        if (r101 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        LifecycleOwner r109 = null;
        if (r108 == true) goto L25;
        boolean r111 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorPlanView] initLoading load text, queryText = " + r101);
        com.larus.utils.e1.o(getPlanningImage());
        com.larus.utils.e1.x(getGradientMask());
        CustomMarkdownTextView r112 = getPlanningText();
        com.larus.utils.e1.x(r112);
        UtilsKt.k(r112, r101);
        i6(r112);
    L37:
        this.f356716c = r112;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(getPlanningContainer(), View.TRANSLATION_Y, new float[]{-i5.A(), 0.0f});
        r113.setDuration(250);
        ObjectAnimator r114 = ObjectAnimator.ofFloat(getMaskLottie1(), View.ALPHA, new float[]{0.0f, 1.0f});
        r114.setDuration(500);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(getBgLottie(), View.ALPHA, new float[]{0.0f, 1.0f});
        r115.setDuration(166);
        AnimatorSet r116 = new AnimatorSet();
        r116.playTogether(new Animator[]{r113, r114, r115});
        r116.addListener(new c(this));
        r116.addListener(new b(this));
        r116.start();
        this.f356715b = r116;
        Context r117 = getContext();
        boolean r118 = UtilsKt.f356659a;
    L38:
        boolean r119 = r117 instanceof LifecycleOwner;
        if (r119 == true) goto L49;
        if ((r117 instanceof ContextWrapper) == false) goto L43;
        ContextWrapper r120 = (ContextWrapper) r117;
    L44:
        if (r120 == null) goto L49;
        Context r121 = r120.getBaseContext();
        if (r121 == null) goto L49;
        r117 = r121;
        goto L38
    L43:
        r120 = null;
    L49:
        if (r119 == false) goto L51;
        r109 = (LifecycleOwner) r117;
    L51:
        if (r109 == null) goto L58;
        r110.getLoadingStep().observe(r109, new d(new d0(this)));
        r110.getActivityConfiguration().observe(r109, new d(new e0(this)));
        return;
    L58:
        return;
    L25:
        if (r100 != null) goto L27;
    L30:
        boolean r122 = true;
    L31:
        if (r122 == true) goto L33;
        boolean r123 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorPlanView] initLoading load image, queryImage = " + r100);
        com.larus.utils.e1.o(getPlanningText());
        com.larus.utils.e1.o(getGradientMask());
        SimpleDraweeView r124 = getPlanningImage();
        com.larus.utils.e1.x(r124);
        final ImageRequest r125 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r100)).setProgressiveRenderingEnabled(true).build();
        final g0 r126 = new g0(this);
        ImageLoaderKt.y(getPlanningImage(), r100, "live_tutor", new v(r125, r126, this), 4);
        r112 = r124;
        goto L37
    L33:
        AppHost.Companion r127 = AppHost.f326268a;
        if (r127.isDebug() == false) goto L36;
        t19.s.j(t19.s.f544207a, r127.getApplication(), "参数错误，未识别到图片或文本query", null, false, 28);
    L36:
        r110.eLogger("LiveTutorPlanView", "initLoading load error, no query text and image");
        r112 = null;
        goto L37
    L27:
        if (r100.length() == 0) goto L30;
        r122 = false;
        goto L31
    L18:
        if (r101.length() == 0) goto L21;
        r108 = false;
        goto L22
    L14:
        r107 = 1;
    L10:
        r106 = false;
        goto L12
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 0) goto L6;
        s6();
        return;
    }

    public static Unit S5(LiveTutorPlanView r100, Integer r101) {
        r100.setLoadingStep(r101);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b6(LiveTutorPlanView r100, Integer r101) {
        r100.setLoadingStep(r101);
    }

    public LiveTutorPlanView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f356717d = LazyKt.lazy(r103, new u(this));
        this.f356718e = LazyKt.lazy(r103, new w(this));
        this.f356719f = LazyKt.lazy(r103, new x(this));
        this.f356720g = LazyKt.lazy(r103, new y(this));
        this.f356721h = LazyKt.lazy(r103, new z(this));
        this.f356722i = LazyKt.lazy(r103, new a0(this));
        this.f356723j = LazyKt.lazy(r103, new b0(this));
        this.f356724k = LazyKt.lazy(r103, new c0(this));
        this.f356725l = 1;
        LayoutInflater.from(r100).inflate(R.layout.live_tutor_plan_layout, this, true);
        c6();
    }

    public /* synthetic */ LiveTutorPlanView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static Unit R5(ImageRequest r100, g0 r101, LiveTutorPlanView r102, PipelineDraweeControllerBuilder r103, Uri r104) {
        Intrinsics.checkNotNullParameter(r103, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r104, "it");
        r103.setImageRequest(r100);
        r103.setControllerListener(r101);
        r103.setOldController(r102.getPlanningImage().getController());
        return Unit.INSTANCE;
    }
}
