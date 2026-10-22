package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedInterruptBinding;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020%H\u0016J\b\u00102\u001a\u00020#H\u0002J\u0012\u00103\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00101\u001a\u00020%H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020#H\u0002J\u0010\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0018H\u0002J \u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020G2\u0006\u0010C\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020#H\u0002J\b\u0010I\u001a\u00020#H\u0002J\u0010\u0010J\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010K\u001a\u00020\u00182\u0006\u0010>\u001a\u00020?H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\u001f2\u0006\u0010A\u001a\u00020BH\u0002J\u001a\u0010M\u001a\u00020#2\b\u0010N\u001a\u0004\u0018\u00010'2\u0006\u0010O\u001a\u00020\u0018H\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010O\u001a\u00020\u0018H\u0002J\b\u0010Q\u001a\u00020#H\u0002J\b\u0010R\u001a\u00020#H\u0002J\b\u0010S\u001a\u00020#H\u0002J\b\u0010T\u001a\u00020#H\u0002J\b\u0010U\u001a\u00020#H\u0002J\b\u0010V\u001a\u00020#H\u0002J\b\u0010W\u001a\u00020#H\u0002J\b\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u00020#H\u0016J\b\u0010[\u001a\u00020#H\u0016J\b\u0010\\\u001a\u00020\u001fH\u0016J\b\u0010]\u001a\u00020\u001fH\u0016J\b\u0010^\u001a\u00020\u0018H\u0002J\u0014\u0010_\u001a\u00020#*\u00020?2\u0006\u00101\u001a\u00020%H\u0002J\u000e\u0010`\u001a\u0004\u0018\u00010?*\u00020%H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedInterruptFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "simplifiedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getSimplifiedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "simplifiedModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedInterruptBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedInterruptBinding;", "navBackButton", "Landroidx/appcompat/widget/AppCompatImageView;", "getNavBackButton", "()Landroidx/appcompat/widget/AppCompatImageView;", "backgroundFadeAnimator", "Landroid/animation/ValueAnimator;", "cachedTypewriterExpandedHeight", "", "hasRevealedTypewriterContent", "", "hasConsumedInterruptEntryAnimation", "shouldPlayDeferredReplyEntryAnimation", "latestRenderedReplyRoundToken", "", "Ljava/lang/Long;", "latestRenderedReplyText", "", "interruptMvVideoPath", "interruptMvCoverPath", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onSaveInstanceState", "outState", "setupTypewriterTextColor", "restoreInterruptUiStateIfNeeded", "restoreInterruptContentOnResume", "saveInterruptUiState", "restoreInterruptMvPlaybackOnResume", "prepareTypewriterContainerForSharedElement", "cacheExpandedTypewriterHeightIfNeeded", "applyFixedTypewriterHeightForSharedElement", "scheduleTypewriterContentRevealFallback", "setupInterruptMv", "setupObservers", "renderInterruptUiState", "state", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedInterruptUiState;", "renderQueryState", "queryState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/StreamlinedQueryUiState;", "shouldPrepareEntryAnimation", "renderReplyState", "roundToken", "replyState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/StreamlinedReplyUiState;", "startReplyLoadingIndicator", "stopReplyLoadingIndicator", "consumeEntryAnimationIfNeeded", "shouldPrepareWindowEntryAnimation", "resolveQueryText", "playEntryAnimation", PickerReporterConstants.KEY.TARGET, "shouldAnimate", "playReplyEntryAnimation", "setupBackButton", "hideBackButton", "setupListeners", "animateStaticContent", "animateEnterOverlayIfNeeded", "animateBackgroundFadeIn", "revealTypewriterContentAfterSharedElement", "buildSharedElementEnterTransition", "Landroid/transition/Transition;", "onDestroyView", "onSkipButtonClicked", "getCurrentPageName", "getCurrentCardName", "isUsingSharedElementTransition", "putIntoBundle", "toInterruptUiState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedInterruptFragment extends DoraExternalOnboardingBaseFragment {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f337187z = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f337188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LarusDoraHSimplifiedInterruptBinding f337189p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f337190q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f337191r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f337192s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f337193t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f337194u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Long f337195v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f337196w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f337197x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f337198y;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f337199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f337200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DoraHStreamlinedInterruptFragment f337201c;

        public b(View r100, boolean r101, DoraHStreamlinedInterruptFragment r102) {
            this.f337199a = r100;
            this.f337200b = r101;
            this.f337201c = r102;
        }

        public final void a() {
            boolean r100 = true;
            if (this.f337200b == false) goto L105;
            DoraHStreamlinedInterruptFragment r101 = this.f337201c;
            float r102 = DoraHStreamlinedInterruptFragment.f337187z;
            Bundle r103 = r101.getArguments();
            if (r103 != null) goto L7;
        L9:
            boolean r104 = false;
        L10:
            ViewGroup.LayoutParams r105 = null;
            if (r104 == true) goto L49;
            LarusDoraHSimplifiedInterruptBinding r106 = r101.f337189p;
            if (r106 == null) goto L49;
            FrameLayout r107 = r106.f332687i;
            if (r107 == null) goto L49;
            DoraTextView r110 = r106.f332689k;
            if (r110 == null) goto L49;
            CircleSimpleDraweeView r108 = r106.f332686h;
            if (r108 == null) goto L49;
            int r111 = RangesKt.coerceAtLeast(r110.getMaxLines(), 1);
            float r112 = (r110.getLineHeight() * r111) + (r110.getLineSpacingExtra() * (r111 - 1));
            ViewGroup.LayoutParams r113 = r110.getLayoutParams();
            if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
            ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        L28:
            ViewGroup.LayoutParams r115 = r108.getLayoutParams();
            if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
            ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        L32:
            int r117 = (int) r112;
            if (r114 == null) goto L35;
            int r118 = r114.topMargin;
        L36:
            int r119 = r117 + r118;
            if (r114 == null) goto L39;
            int r120 = r114.bottomMargin;
        L40:
            int r121 = r119 + r120;
            int r109 = RangesKt.coerceAtLeast(r108.getHeight(), r108.getMinimumHeight());
            if (r116 == null) goto L43;
            int r122 = r116.topMargin;
        L44:
            int r123 = r109 + r122;
            if (r116 == null) goto L47;
            int r124 = r116.bottomMargin;
        L48:
            r101.f337191r = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast((Math.max(r121, r123 + r124) + r107.getPaddingTop()) + r107.getPaddingBottom(), r107.getMinimumHeight()), c7.b(48));
            goto L49
        L47:
            r124 = 0;
            goto L48
        L43:
            r122 = 0;
            goto L44
        L39:
            r120 = 0;
            goto L40
        L35:
            r118 = 0;
            goto L36
        L31:
            r116 = null;
            goto L32
        L27:
            r114 = null;
        L49:
            DoraHStreamlinedInterruptFragment r125 = this.f337201c;
            Bundle r126 = r125.getArguments();
            if (r126 != null) goto L52;
        L54:
            boolean r127 = false;
        L55:
            if (r127 == true) goto L73;
            Integer r128 = Integer.valueOf(r125.f337191r);
            if (r128.intValue() <= 0) goto L60;
            boolean r129 = true;
        L61:
            if (r129 == true) goto L64;
            r128 = null;
        L64:
            if (r128 == null) goto L73;
            int r130 = r128.intValue();
            LarusDoraHSimplifiedInterruptBinding r131 = r125.f337189p;
            if (r131 == null) goto L73;
            FrameLayout r132 = r131.f332687i;
            if (r132 == null) goto L73;
            ViewGroup.LayoutParams r133 = r132.getLayoutParams();
            if (r133 == null) goto L72;
            r133.height = r130;
            r105 = r133;
        L72:
            r132.setLayoutParams(r105);
            goto L73
        L60:
            r129 = false;
        L73:
            this.f337201c.startPostponedEnterTransition();
            final DoraHStreamlinedInterruptFragment r134 = this.f337201c;
            Bundle r135 = r134.getArguments();
            if (r135 != null) goto L76;
        L78:
            boolean r136 = false;
        L79:
            if (r136 == true) goto L86;
            LarusDoraHSimplifiedInterruptBinding r137 = r134.f337189p;
            if (r137 == null) goto L86;
            FrameLayout r138 = r137.f332687i;
            if (r138 == null) goto L86;
            r138.postDelayed(new h(r134), 520);
        L86:
            DoraHStreamlinedInterruptFragment r139 = this.f337201c;
            Bundle r140 = r139.getArguments();
            if (r140 != null) goto L89;
        L91:
            boolean r141 = false;
        L92:
            if (r141 == true) goto L105;
            LarusDoraHSimplifiedInterruptBinding r142 = r139.f337189p;
            if (r142 == null) goto L105;
            ConstraintLayout r143 = r142.f332679a;
            if (r143 == null) goto L105;
            ViewPropertyAnimator r144 = r143.animate();
            if (r144 == null) goto L105;
            ViewPropertyAnimator r145 = r144.alpha(1.0f);
            if (r145 == null) goto L105;
            ViewPropertyAnimator r146 = r145.setDuration(300);
            if (r146 == null) goto L105;
            r146.start();
            goto L105
        L89:
            if (r140.getBoolean("arg_is_from_skip") != true) goto L91;
            r141 = true;
            goto L92
        L76:
            if (r135.getBoolean("arg_is_from_skip") != true) goto L78;
            r136 = true;
            goto L79
        L52:
            if (r126.getBoolean("arg_is_from_skip") != true) goto L54;
            r127 = true;
            goto L55
        L7:
            if (r103.getBoolean("arg_is_from_skip") != true) goto L9;
            r104 = true;
        L105:
            DoraHStreamlinedInterruptFragment r147 = this.f337201c;
            float r148 = DoraHStreamlinedInterruptFragment.f337187z;
            Bundle r149 = r147.getArguments();
            if (r149 != null) goto L108;
        L110:
            r100 = false;
        L111:
            if (r100 == false) goto L125;
            LarusDoraHSimplifiedInterruptBinding r150 = r147.f337189p;
            if (r150 == null) goto L125;
            ConstraintLayout r151 = r150.f332679a;
            if (r151 == null) goto L125;
            Drawable r152 = r151.getBackground();
            if (r152 == null) goto L125;
            final Drawable r153 = r152.mutate();
            if (r153 == null) goto L125;
            ValueAnimator r154 = r147.f337190q;
            if (r154 == null) goto L124;
            r154.cancel();
        L124:
            ValueAnimator r155 = ValueAnimator.ofInt(new int[]{0, 255});
            r155.setDuration(300);
            r155.addUpdateListener(new f(r153));
            r155.start();
            r147.f337190q = r155;
        L125:
            LarusDoraHSimplifiedInterruptBinding r156 = r147.f337189p;
            if (r156 == null) goto L130;
            VideoPlayView r157 = r156.f332680b;
            if (r157 == null) goto L130;
            r157.setAlpha(0.0f);
            r157.setTranslationY(16.0f);
            r157.animate().alpha(1.0f).translationY(0.0f).setDuration(300).start();
        L130:
            LarusDoraHSimplifiedInterruptBinding r158 = r147.f337189p;
            if (r158 == null) goto L136;
            DoraTextView r159 = r158.f332681c;
            if (r159 == null) goto L137;
            r159.setAlpha(0.0f);
            r159.setTranslationY(16.0f);
            r159.animate().alpha(1.0f).translationY(0.0f).setDuration(300).start();
            return;
        L137:
            return;
        L136:
            return;
        L108:
            if (r149.getBoolean("arg_is_from_skip") != true) goto L110;
            goto L110
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

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        return "new_interrupt_card";
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_h_streamlined_interrupt";
    }

    static {
        f337187z = c7.b(16);
    }

    public final DoraHStreamlinedOnboardingViewModel fa0() {
        return (DoraHStreamlinedOnboardingViewModel) this.f337188o.getValue();
    }

    public final void ka0() {
        LarusDoraHSimplifiedInterruptBinding r100 = this.f337189p;
        if (r100 == null) goto L14;
        AppCompatImageView r101 = r100.f332684f;
        if (r101 == null) goto L15;
        Object r102 = r101.getDrawable();
        if ((r102 instanceof Animatable) == false) goto L9;
        Animatable r103 = (Animatable) r102;
    L10:
        if (r103 == null) goto L12;
        r103.stop();
    L12:
        r101.setVisibility(8);
        return;
    L9:
        r103 = null;
        goto L10
    L15:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LarusDoraHSimplifiedInterruptBinding r100 = this.f337189p;
        if (r100 == null) goto L7;
        VideoPlayView r101 = r100.f332680b;
        if (r101 == null) goto L7;
        r101.N();
    L7:
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L10;
        AppCompatImageView r103 = (AppCompatImageView) r102.findViewById(R.id.dora_onboarding_nav_back_btn);
    L11:
        if (r103 == null) goto L13;
        r103.animate().cancel();
        r103.clearAnimation();
        r103.setOnClickListener(null);
        r103.setAlpha(1.0f);
        r103.setTranslationX(0.0f);
        r103.setTranslationY(0.0f);
        r103.setVisibility(8);
    L13:
        ValueAnimator r104 = this.f337190q;
        if (r104 == null) goto L16;
        r104.cancel();
    L16:
        this.f337190q = null;
        this.f337191r = 0;
        this.f337192s = false;
        this.f337193t = false;
        this.f337194u = false;
        this.f337195v = null;
        this.f337196w = "";
        this.f337197x = null;
        this.f337198y = null;
        fa0().unregisterMessageObserver();
        fa0().unregisterVoiceCallback();
        super.onDestroyView();
        this.f337189p = null;
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        LarusDoraHSimplifiedInterruptBinding r100 = this.f337189p;
        if (r100 == null) goto L7;
        VideoPlayView r101 = r100.f332680b;
        if (r101 == null) goto L7;
        r101.N();
    L7:
        super.onPause();
    }

    public DoraHStreamlinedInterruptFragment() {
        this.f337188o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedInterruptFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedInterruptFragment$special$$inlined$activityViewModels$default$2(this));
        this.f337196w = "";
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        DoraHStreamlinedOnboardingViewModel.skipAndNext$default(fa0(), false, 1, null);
    }

    public final void ia0() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (this.f337192s == false) goto L13;
        return;
    L13:
        this.f337192s = true;
        LarusDoraHSimplifiedInterruptBinding r102 = this.f337189p;
        FrameLayout r103 = null;
        if (r102 == null) goto L16;
        FrameLayout r104 = r102.f332688j;
    L17:
        if (r104 == null) goto L22;
        ViewPropertyAnimator r105 = r104.animate();
        if (r105 == null) goto L22;
        r105.cancel();
    L22:
        if (this.f337194u == false) goto L31;
        this.f337194u = false;
        if (r104 == null) goto L26;
        r104.setAlpha(1.0f);
    L26:
        LarusDoraHSimplifiedInterruptBinding r106 = this.f337189p;
        if (r106 == null) goto L29;
        r103 = r106.f332687i;
    L29:
        ga0(r103, true);
        return;
    L31:
        if (r104 == null) goto L33;
        r104.setAlpha(0.0f);
    L33:
        if (r104 == null) goto L42;
        ViewPropertyAnimator r107 = r104.animate();
        if (r107 == null) goto L43;
        ViewPropertyAnimator r108 = r107.alpha(1.0f);
        if (r108 == null) goto L44;
        ViewPropertyAnimator r109 = r108.setDuration(300);
        if (r109 == null) goto L45;
        r109.start();
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L16:
        r104 = null;
        goto L17
    L5:
        if (r100.getBoolean("arg_is_from_skip") != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void ja0() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L5;
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.dora_onboarding_nav_back_btn);
    L6:
        if (r101 == null) goto L9;
        r101.animate().cancel();
        r101.clearAnimation();
        r101.setVisibility(0);
        r101.setAlpha(1.0f);
        r101.setTranslationX(0.0f);
        r101.setTranslationY(0.0f);
        e1.d(r101, new d(this));
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ja0();
        o r100 = fa0().getInterruptUiState().getValue();
        if (r100.f337296a <= 0) goto L5;
    L9:
        ha0(o.a(r100, 0, null, null, 11));
    L10:
        LarusDoraHSimplifiedInterruptBinding r101 = this.f337189p;
        if (r101 == null) goto L16;
        VideoPlayView r102 = r101.f332680b;
        if (r102 == null) goto L17;
        r102.post(new g(this));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if ((r100.f337297b instanceof n0.a) == false) goto L9;
        if ((r100.f337299d instanceof o0.b) == false) goto L9;
        goto L9
    }

    public final void ha0(o r110) {
        if (this.f337193t == false) goto L5;
    L14:
        boolean r100 = false;
    L15:
        n0 r101 = r110.f337297b;
        n0.a r102 = n0.a.f337289a;
        FrameLayout r103 = null;
        if (Intrinsics.areEqual(r101, r102) == false) goto L19;
        String r104 = null;
    L24:
        if (r104 == null) goto L26;
        String r105 = StringsKt.trim(r104).toString();
    L27:
        if (r105 != null) goto L29;
    L32:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L36;
        r105 = null;
    L36:
        LarusDoraHSimplifiedInterruptBinding r107 = this.f337189p;
        if (r107 == null) goto L65;
        DoraTextView r108 = r107.f332682d;
        if (r108 == null) goto L65;
        if (r105 != null) goto L42;
        String r111 = "";
    L43:
        r108.setText(r111);
        if (r105 != null) goto L46;
    L49:
        boolean r112 = true;
    L50:
        if (r112 == false) goto L52;
        int r113 = 8;
    L53:
        r108.setVisibility(r113);
        if (r105 != null) goto L56;
    L59:
        boolean r109 = true;
    L60:
        if (r109 == false) goto L62;
        r108.setAlpha(1.0f);
        r108.setTranslationY(0.0f);
        goto L65
    L62:
        if (r100 == false) goto L64;
        r108.setAlpha(0.0f);
        r108.setTranslationY(f337187z);
        goto L65
    L64:
        r108.setAlpha(1.0f);
        r108.setTranslationY(0.0f);
        goto L65
    L56:
        if (r105.length() == 0) goto L59;
        r109 = false;
        goto L60
    L52:
        r113 = 0;
        goto L53
    L46:
        if (r105.length() == 0) goto L49;
        r112 = false;
        goto L50
    L42:
        r111 = r105;
    L65:
        long r114 = r110.f337296a;
        o0 r115 = r110.f337299d;
        boolean r116 = !(r115 instanceof o0.b);
        LarusDoraHSimplifiedInterruptBinding r117 = this.f337189p;
        if (r117 == null) goto L85;
        FrameLayout r118 = r117.f332687i;
        if (r118 == null) goto L85;
        if (r116 == false) goto L71;
        int r119 = 0;
    L72:
        r118.setVisibility(r119);
        if (r116 == false) goto L77;
        if (r100 == false) goto L76;
        r118.setAlpha(0.0f);
        r118.setTranslationY(f337187z);
        goto L85
    L76:
        r118.setAlpha(1.0f);
        r118.setTranslationY(0.0f);
        goto L85
    L77:
        Bundle r120 = getArguments();
        if (r120 != null) goto L80;
    L82:
        boolean r121 = false;
    L83:
        if (r121 == true) goto L85;
        r118.setAlpha(0.0f);
        r118.setTranslationY(0.0f);
        goto L85
    L80:
        if (r120.getBoolean("arg_is_from_skip") != true) goto L82;
        r121 = true;
        goto L83
    L71:
        r119 = 8;
    L85:
        LarusDoraHSimplifiedInterruptBinding r122 = this.f337189p;
        if (r122 == null) goto L94;
        CircleSimpleDraweeView r123 = r122.f332686h;
        if (r123 == null) goto L94;
        if (r116 == false) goto L91;
        int r124 = 0;
    L92:
        r123.setVisibility(r124);
        goto L94
    L91:
        r124 = 8;
    L94:
        if (Intrinsics.areEqual(r115, o0.b.f337302a) == false) goto L106;
        this.f337195v = null;
        this.f337196w = "";
        ka0();
        LarusDoraHSimplifiedInterruptBinding r125 = this.f337189p;
        if (r125 == null) goto L100;
        DoraTextView r126 = r125.f332689k;
        if (r126 == null) goto L100;
        r126.setVisibility(8);
    L100:
        LarusDoraHSimplifiedInterruptBinding r127 = this.f337189p;
        if (r127 == null) goto L162;
        DoraTextView r128 = r127.f332689k;
        if (r128 == null) goto L162;
        r128.setText("");
    L162:
        boolean r129 = false;
    L177:
        if (fa0().consumeEntryAnimation(Long.valueOf(r110.f337296a)) == true) goto L180;
        return;
    L180:
        if (this.f337193t == true) goto L253;
        Bundle r130 = getArguments();
        if (r130 != null) goto L184;
    L186:
        boolean r131 = false;
    L187:
        if (r131 == true) goto L261;
        n0 r132 = r110.f337297b;
        if (Intrinsics.areEqual(r132, r102) == false) goto L193;
        String r133 = null;
    L198:
        if (r133 == null) goto L200;
        String r134 = StringsKt.trim(r133).toString();
    L201:
        if (r134 != null) goto L203;
    L206:
        boolean r135 = true;
    L207:
        if (r135 == false) goto L210;
        r134 = null;
    L210:
        if (r134 != null) goto L212;
    L215:
        boolean r136 = true;
    L216:
        boolean r137 = !r136;
        boolean r138 = !(r110.f337299d instanceof o0.b);
        if (r137 == true) goto L220;
        if (r138 == true) goto L220;
        return;
    L220:
        this.f337193t = true;
        LarusDoraHSimplifiedInterruptBinding r139 = this.f337189p;
        if (r139 == null) goto L223;
        DoraTextView r140 = r139.f332682d;
    L224:
        ga0(r140, r137);
        if (r138 == false) goto L263;
        Bundle r141 = getArguments();
        if (r141 != null) goto L230;
    L232:
        if (r129 == true) goto L242;
        Bundle r142 = getArguments();
        if (r142 == null) goto L236;
        boolean r143 = r142.getBoolean("arg_use_shared_element_transition", true);
    L237:
        if (r143 == false) goto L242;
        if (this.f337192s == true) goto L242;
        this.f337194u = true;
        return;
    L236:
        r143 = true;
    L242:
        LarusDoraHSimplifiedInterruptBinding r144 = this.f337189p;
        if (r144 == null) goto L247;
        FrameLayout r145 = r144.f332688j;
        if (r145 == null) goto L247;
        r145.setAlpha(1.0f);
    L247:
        LarusDoraHSimplifiedInterruptBinding r146 = this.f337189p;
        if (r146 == null) goto L250;
        r103 = r146.f332687i;
    L250:
        ga0(r103, true);
        return;
    L230:
        if (r141.getBoolean("arg_is_from_skip") != true) goto L232;
        r129 = true;
        goto L232
    L263:
        return;
    L223:
        r140 = null;
        goto L224
    L212:
        if (r134.length() == 0) goto L215;
        r136 = false;
        goto L216
    L203:
        if (r134.length() == 0) goto L206;
        r135 = false;
        goto L207
    L200:
        r134 = null;
        goto L201
    L193:
        if ((r132 instanceof n0.b) == false) goto L196;
        r133 = ((n0.b) r132).f337292c;
        goto L198
    L196:
        if ((r132 instanceof n0.c) == false) goto L252;
        r133 = ((n0.c) r132).f337294b;
        goto L198
    L252:
        throw new NoWhenBranchMatchedException();
    L261:
        return;
    L184:
        if (r130.getBoolean("arg_is_from_skip") != true) goto L186;
        r131 = true;
        goto L187
    L253:
        return;
    L106:
        if ((r115 instanceof o0.c) == false) goto L151;
        Long r147 = this.f337195v;
        if (r147 != null) goto L111;
    L118:
        boolean r148 = false;
    L119:
        if (r148 == false) goto L130;
        ka0();
        LarusDoraHSimplifiedInterruptBinding r149 = this.f337189p;
        if (r149 == null) goto L125;
        DoraTextView r150 = r149.f332689k;
        if (r150 == null) goto L125;
        r150.setVisibility(0);
    L125:
        LarusDoraHSimplifiedInterruptBinding r151 = this.f337189p;
        if (r151 == null) goto L162;
        DoraTextView r152 = r151.f332689k;
        if (r152 == null) goto L162;
        r152.setText(this.f337196w);
        goto L162
    L130:
        this.f337195v = Long.valueOf(r114);
        this.f337196w = "";
        LarusDoraHSimplifiedInterruptBinding r153 = this.f337189p;
        if (r153 == null) goto L140;
        AppCompatImageView r154 = r153.f332684f;
        if (r154 == null) goto L140;
        r154.setVisibility(0);
        Object r155 = r154.getDrawable();
        if ((r155 instanceof Animatable) == false) goto L137;
        Animatable r156 = (Animatable) r155;
    L138:
        if (r156 == null) goto L140;
        r156.start();
        goto L140
    L137:
        r156 = null;
    L140:
        LarusDoraHSimplifiedInterruptBinding r157 = this.f337189p;
        if (r157 == null) goto L145;
        DoraTextView r158 = r157.f332689k;
        if (r158 == null) goto L145;
        r158.setText("");
    L145:
        LarusDoraHSimplifiedInterruptBinding r159 = this.f337189p;
        if (r159 == null) goto L162;
        DoraTextView r160 = r159.f332689k;
        if (r160 == null) goto L162;
        r160.setVisibility(4);
        goto L162
    L111:
        if (r147.longValue() != r114) goto L118;
        if (this.f337196w.length() <= 0) goto L115;
        boolean r161 = true;
    L116:
        if (r161 == false) goto L118;
        r148 = true;
        goto L119
    L115:
        r161 = false;
        goto L116
    L151:
        if ((r115 instanceof o0.d) == false) goto L164;
        this.f337195v = Long.valueOf(r114);
        o0.d r162 = (o0.d) r115;
        this.f337196w = r162.f337307c;
        ka0();
        LarusDoraHSimplifiedInterruptBinding r163 = this.f337189p;
        if (r163 == null) goto L157;
        DoraTextView r164 = r163.f332689k;
        if (r164 == null) goto L157;
        r164.setVisibility(0);
    L157:
        LarusDoraHSimplifiedInterruptBinding r165 = this.f337189p;
        if (r165 == null) goto L162;
        DoraTextView r166 = r165.f332689k;
        if (r166 == null) goto L162;
        r166.setText(r162.f337307c);
        goto L162
    L164:
        if ((r115 instanceof o0.a) == false) goto L255;
        this.f337195v = Long.valueOf(r114);
        o0.a r167 = (o0.a) r115;
        this.f337196w = r167.f337301b;
        ka0();
        LarusDoraHSimplifiedInterruptBinding r168 = this.f337189p;
        if (r168 == null) goto L170;
        DoraTextView r169 = r168.f332689k;
        if (r169 == null) goto L170;
        r129 = false;
        r169.setVisibility(0);
    L171:
        LarusDoraHSimplifiedInterruptBinding r170 = this.f337189p;
        if (r170 == null) goto L177;
        DoraTextView r171 = r170.f332689k;
        if (r171 == null) goto L177;
        r171.setText(r167.f337301b);
    L170:
        r129 = false;
        goto L171
    L255:
        throw new NoWhenBranchMatchedException();
    L29:
        if (r105.length() == 0) goto L32;
        r106 = false;
        goto L33
    L26:
        r105 = null;
        goto L27
    L19:
        if ((r101 instanceof n0.b) == false) goto L22;
        r104 = ((n0.b) r101).f337292c;
        goto L24
    L22:
        if ((r101 instanceof n0.c) == false) goto L257;
        r104 = ((n0.c) r101).f337294b;
        goto L24
    L257:
        throw new NoWhenBranchMatchedException();
    L5:
        if (r110.f337298c == false) goto L14;
        Bundle r172 = getArguments();
        if (r172 != null) goto L9;
    L11:
        boolean r173 = false;
    L12:
        if (r173 == true) goto L14;
        r100 = true;
        goto L15
    L9:
        if (r172.getBoolean("arg_is_from_skip") != true) goto L11;
        r173 = true;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = true;
        if (r101 == null) goto L5;
        r102 = r101.getBoolean("arg_use_shared_element_transition", true);
    L5:
        if (r102 == false) goto L8;
        TransitionSet r103 = new TransitionSet();
        r103.setOrdering(0);
        r103.setDuration(520);
        r103.setInterpolator(new FastOutSlowInInterpolator());
        r103.addTransition(new ChangeBounds());
        r103.addTransition(new ChangeTransform());
        r103.addTransition(new ChangeClipBounds());
        r103.addListener(new j(this));
        setSharedElementEnterTransition(r103);
        Fade r104 = new Fade();
        r104.setDuration(300);
        setEnterTransition(r104);
        postponeEnterTransition();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        o r101 = fa0().getInterruptUiState().getValue();
        r100.putLong("state_round_token", r101.f337296a);
        r100.putBoolean("state_should_play_entry_animation", r101.f337298c);
        n0 r102 = r101.f337297b;
        if (Intrinsics.areEqual(r102, n0.a.f337289a) == false) goto L6;
        r100.putString("state_query_type", "hidden");
    L11:
        o0 r103 = r101.f337299d;
        if (Intrinsics.areEqual(r103, o0.b.f337302a) == false) goto L15;
        r100.putString("state_reply_type", "hidden");
    L23:
        r100.putString("state_interrupt_mv_video_path", this.f337197x);
        r100.putString("state_interrupt_mv_cover_path", this.f337198y);
        return;
    L15:
        if ((r103 instanceof o0.c) == false) goto L18;
        r100.putString("state_reply_type", "loading");
        r100.putString("state_reply_placeholder_text", ((o0.c) r103).f337304b);
        goto L23
    L18:
        if ((r103 instanceof o0.d) == false) goto L21;
        r100.putString("state_reply_type", "typing");
        o0.d r104 = (o0.d) r103;
        r100.putString("state_reply_full_text", r104.f337306b);
        r100.putString("state_reply_displayed_text", r104.f337307c);
        goto L23
    L21:
        if ((r103 instanceof o0.a) == false) goto L26;
        r100.putString("state_reply_type", "completed");
        r100.putString("state_reply_text", ((o0.a) r103).f337301b);
        goto L23
    L26:
        throw new NoWhenBranchMatchedException();
    L6:
        if ((r102 instanceof n0.b) == false) goto L9;
        r100.putString("state_query_type", "listening");
        n0.b r105 = (n0.b) r102;
        r100.putString("state_query_source", r105.f337291b);
        r100.putString("state_query_text", r105.f337292c);
        goto L11
    L9:
        if ((r102 instanceof n0.c) == false) goto L28;
        r100.putString("state_query_type", "submitted");
        n0.c r106 = (n0.c) r102;
        r100.putString("state_query_source", r106.f337295c);
        r100.putString("state_query_text", r106.f337294b);
        goto L11
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public static void ga0(View r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
        return;
    L6:
        r100.animate().cancel();
        r100.setVisibility(0);
        r100.setAlpha(0.0f);
        r100.setTranslationY(f337187z);
        r100.animate().alpha(1.0f).translationY(0.0f).setDuration(300).setInterpolator(new FastOutSlowInInterpolator()).start();
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        fa0().onInterruptPageShown();
        boolean r100 = false;
        if (r211 != null) goto L5;
    L72:
        Bundle r101 = getArguments();
        if (r101 == null) goto L75;
        boolean r102 = r101.getBoolean("arg_is_from_skip", false);
    L76:
        Bundle r103 = getArguments();
        if (r103 == null) goto L79;
        boolean r104 = r103.getBoolean("arg_use_shared_element_transition", true);
    L80:
        g49.d.d("DoraHStreamlinedInterruptFragment", "onViewCreated: isFromSkip=" + r102);
        LarusDoraHSimplifiedInterruptBinding r105 = this.f337189p;
        if (r105 == null) goto L97;
        ConstraintLayout r106 = r105.f332679a;
        if (r106 == null) goto L97;
        if (r102 == true) goto L88;
        if (r104 == false) goto L88;
        float r110 = 0.0f;
    L89:
        r106.setAlpha(r110);
        Drawable r107 = r106.getBackground();
        if (r107 == null) goto L97;
        Drawable r108 = r107.mutate();
        if (r108 == null) goto L97;
        if (r102 == false) goto L95;
        int r111 = 0;
    L96:
        r108.setAlpha(r111);
        goto L97
    L95:
        r111 = 255;
    L88:
        r110 = 1.0f;
    L97:
        if (r102 == false) goto L103;
        LarusDoraHSimplifiedInterruptBinding r109 = this.f337189p;
        if (r109 == null) goto L126;
        FrameLayout r112 = r109.f332687i;
        if (r112 == null) goto L126;
        r112.setVisibility(8);
    L126:
        LarusDoraHSimplifiedInterruptBinding r113 = this.f337189p;
        if (r113 == null) goto L149;
        final VideoPlayView r114 = r113.f332680b;
        if (r114 == null) goto L149;
        DoraDevice r115 = DoraAdapterExtKt.h(kj4.a.g());
        boolean r116 = v19.h.f552477a;
        Context r117 = r114.getContext();
        if (r117 != null) goto L134;
        r117 = AppHost.f326268a.getApplication();
    L134:
        if (v19.h.b(r117) == false) goto L136;
        String r118 = "dark";
    L137:
        final String r119 = this.f337197x;
        if (r119 != null) goto L140;
        r119 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4//h/onboarding/interrupt/${product}/v2/video_${sku}_${light_mode}.mp4", r115, r118);
    L140:
        final String r120 = this.f337198y;
        if (r120 != null) goto L143;
        r120 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4//h/onboarding/interrupt/${product}/v2/image_${sku}_${light_mode}.png", r115, r118);
    L143:
        this.f337197x = r119;
        this.f337198y = r120;
        StringBuilder r121 = new StringBuilder("setupInterruptMv: videoPath=");
        r121.append(r119);
        r121.append(", coverPath=");
        r121.append(r120);
        r121.append(", hasSavedVideoPath=");
        String r122 = this.f337197x;
        if (r122 != null) goto L146;
    L147:
        r100 = true;
    L148:
        r121.append(true ^ r100);
        g49.d.d("DoraHStreamlinedInterruptFragment", r121.toString());
        r114.post(new i(r114, r119, r120));
        goto L149
    L146:
        if (r122.length() != 0) goto L148;
    L136:
        r118 = "light";
    L149:
        LarusDoraHSimplifiedInterruptBinding r123 = this.f337189p;
        if (r123 == null) goto L154;
        DoraTextView r124 = r123.f332689k;
        if (r124 == null) goto L154;
        r124.setTextColor(ColorUtils.setAlphaComponent(r124.getCurrentTextColor(), 179));
    L154:
        ja0();
        Lifecycle.State r125 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedInterruptFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r125, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedInterruptFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r125, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedInterruptFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r125, null, this), 3, null);
        TextView r126 = this.f336547h;
        if (r126 == null) goto L157;
        e1.x(r126);
        int r127 = com.larus.utils.j0.f375426a;
        r126.setText(com.larus.utils.j0.d(R.string.larus_dora_btn_continue_cn));
        e1.d(r126, new e(this));
    L157:
        if (r102 == true) goto L159;
        fa0().registerMessageObserver();
    L159:
        OneShotPreDrawListener.add(r210, new b(r210, r104, this));
        if (r102 == true) goto L164;
        fa0().registerVoiceCallback();
        return;
    L164:
        return;
    L103:
        if (r104 == false) goto L121;
        LarusDoraHSimplifiedInterruptBinding r128 = this.f337189p;
        if (r128 == null) goto L109;
        FrameLayout r129 = r128.f332687i;
        if (r129 == null) goto L109;
        r129.setAlpha(1.0f);
    L109:
        LarusDoraHSimplifiedInterruptBinding r130 = this.f337189p;
        if (r130 == null) goto L114;
        FrameLayout r131 = r130.f332688j;
        if (r131 == null) goto L114;
        r131.setAlpha(0.0f);
    L114:
        LarusDoraHSimplifiedInterruptBinding r132 = this.f337189p;
        if (r132 == null) goto L120;
        FrameLayout r133 = r132.f332687i;
        if (r133 == null) goto L163;
        ViewCompat.setTransitionName(r133, "dora_h_simplified_interrupt_card");
        goto L126
    L163:
        return;
    L120:
        return;
    L121:
        this.f337192s = true;
        LarusDoraHSimplifiedInterruptBinding r134 = this.f337189p;
        if (r134 == null) goto L126;
        FrameLayout r135 = r134.f332688j;
        if (r135 == null) goto L126;
        r135.setAlpha(1.0f);
        goto L126
    L79:
        r104 = true;
        goto L80
    L75:
        r102 = false;
        goto L76
    L5:
        if (r211.containsKey("state_round_token") == true) goto L7;
        o r136 = null;
    L69:
        if (r136 == null) goto L72;
        g49.d.d("DoraHStreamlinedInterruptFragment", "restoreInterruptUiStateIfNeeded: roundToken=" + r136.f337296a);
        fa0().restoreInterruptUiState(r136);
        this.f337197x = r211.getString("state_interrupt_mv_video_path");
        this.f337198y = r211.getString("state_interrupt_mv_cover_path");
        this.f337193t = true;
        this.f337194u = false;
        goto L72
    L7:
        long r137 = r211.getLong("state_round_token");
        String r138 = r211.getString("state_query_type");
        String r139 = "";
        if (r138 == null) goto L31;
        int r140 = r138.hashCode();
        if (r140 == (-1218715461)) goto L22;
        if (r140 != 348678395) goto L31;
        if (r138.equals("submitted") == false) goto L31;
        String r141 = r211.getString("state_query_text");
        String r142 = r211.getString("state_query_source");
        if (r142 != null) goto L20;
        r142 = "";
    L20:
        n0 r143 = new n0.c(r137, r141, r142);
    L32:
        n0 r144 = r143;
        String r145 = r211.getString("state_reply_type");
        if (r145 == null) goto L67;
        int r146 = r145.hashCode();
        if (r146 == (-1402931637)) goto L60;
        if (r146 == (-858798729)) goto L49;
        if (r146 != 336650556) goto L67;
        if (r145.equals("loading") == false) goto L67;
        String r147 = r211.getString("state_reply_placeholder_text");
        if (r147 == null) goto L47;
        r139 = r147;
    L47:
        o0 r148 = new o0.c(r137, r139);
    L68:
        r136 = new o(r137, r144, r211.getBoolean("state_should_play_entry_animation", false), r148);
        goto L69
    L49:
        if (r145.equals("typing") == false) goto L67;
        String r149 = r211.getString("state_reply_full_text");
        if (r149 != null) goto L54;
        r149 = "";
    L54:
        String r150 = r211.getString("state_reply_displayed_text");
        if (r150 == null) goto L58;
        r139 = r150;
    L58:
        r148 = new o0.d(r137, r149, r139);
        goto L68
    L60:
        if (r145.equals("completed") == false) goto L67;
        String r151 = r211.getString("state_reply_text");
        if (r151 == null) goto L66;
        r139 = r151;
    L66:
        r148 = new o0.a(r137, r139);
    L67:
        r148 = o0.b.f337302a;
        goto L68
    L22:
        if (r138.equals("listening") == false) goto L31;
        String r152 = r211.getString("state_query_source");
        if (r152 != null) goto L27;
        r152 = "";
    L27:
        String r153 = r211.getString("state_query_text");
        if (r153 != null) goto L30;
        r153 = "";
    L30:
        r143 = new n0.b(r137, r152, r153);
    L31:
        r143 = n0.a.f337289a;
        goto L32
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dora_h_simplified_interrupt, r111, false);
        int r114 = R.id.dora_onboarding_interrupt_mv;
        VideoPlayView r100 = (VideoPlayView) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_interrupt_mv);
        if (r100 == null) goto L27;
        r114 = R.id.dora_onboarding_interrupt_title;
        DoraTextView r101 = (DoraTextView) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_interrupt_title);
        if (r101 == null) goto L27;
        r114 = R.id.dora_onboarding_query_text;
        DoraTextView r102 = (DoraTextView) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_query_text);
        if (r102 == null) goto L27;
        r114 = R.id.dora_onboarding_reply_body_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_reply_body_container)) == null) goto L27;
        r114 = R.id.dora_onboarding_reply_content_container;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_reply_content_container);
        if (r103 == null) goto L27;
        r114 = R.id.dora_onboarding_reply_loading_indicator;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_reply_loading_indicator);
        if (r104 == null) goto L27;
        r114 = R.id.dora_onboarding_top_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_top_container);
        if (r105 == null) goto L27;
        r114 = R.id.dora_onboarding_typewriter_avatar;
        CircleSimpleDraweeView r106 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_typewriter_avatar);
        if (r106 == null) goto L27;
        r114 = R.id.dora_onboarding_typewriter_container;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_typewriter_container);
        if (r107 == null) goto L27;
        r114 = R.id.dora_onboarding_typewriter_content;
        FrameLayout r115 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_typewriter_content);
        if (r115 == null) goto L27;
        r114 = R.id.dora_onboarding_typewriter_text;
        DoraTextView r116 = (DoraTextView) ViewBindings.findChildViewById(r113, R.id.dora_onboarding_typewriter_text);
        if (r116 == null) goto L27;
        ConstraintLayout r117 = (ConstraintLayout) r113;
        this.f337189p = new LarusDoraHSimplifiedInterruptBinding(r117, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        return r117;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
