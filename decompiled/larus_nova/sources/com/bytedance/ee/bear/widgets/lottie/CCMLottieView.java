package com.bytedance.ee.bear.widgets.lottie;

import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0014J\b\u0010\u001a\u001a\u00020\bH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/widgets/lottie/CCMLottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pendingAction", "Lkotlin/Function0;", "", "setAnimation", "assetName", "", "playAnimation", "cancelAnimation", "resumeAnimation", "pauseAnimation", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "onViewUpdated", "isAttachedToWindow", "", "isVisible", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CCMLottieView extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lambda f240228a;

    public static final class a {
    }

    static {
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public final void cancelAnimation() {
        tt5.a.h("CCMLottieView", "cancelAnimation");
        super.cancelAnimation();
        this.f240228a = null;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public final void pauseAnimation() {
        tt5.a.h("CCMLottieView", "pauseAnimation");
        super.pauseAnimation();
        this.f240228a = null;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h("CCMLottieView", "onAttachedToWindow, visibility: " + getVisibility() + ", isAttachedToWindow: true");
        l(getVisibility(), true);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h("CCMLottieView", "onDetachedFromWindow, visibility: " + getVisibility() + ", isAttachedToWindow: false");
        l(getVisibility(), false);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.widgets.lottie.CCMLottieView$playAnimation$1, kotlin.jvm.internal.Lambda] */
    @Override // com.airbnb.lottie.LottieAnimationView
    public final void playAnimation() {
        boolean r100 = j(getVisibility());
        if (r100 == true) goto L5;
    L7:
        tt5.a.h("CCMLottieView", "playAnimation, pending it, isVisible: " + r100 + ", isAttachedToWindow: " + isAttachedToWindow());
        this.f240228a = new AnonymousClass1(this);
        return;
    L5:
        if (isAttachedToWindow() == false) goto L7;
        tt5.a.h("CCMLottieView", "playAnimation, visible & attachedToWindow, play animation.");
        this.f240228a = null;
        super.playAnimation();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ee.bear.widgets.lottie.CCMLottieView$resumeAnimation$1, kotlin.jvm.internal.Lambda] */
    @Override // com.airbnb.lottie.LottieAnimationView
    public final void resumeAnimation() {
        if (isAnimating() == false) goto L6;
        tt5.a.h("CCMLottieView", "resumeAnimation, already animating.");
        return;
    L6:
        boolean r100 = j(getVisibility());
        if (r100 == true) goto L9;
    L11:
        tt5.a.h("CCMLottieView", "resumeAnimation, pending it, isVisible: " + r100 + ", isAttachedToWindow: " + isAttachedToWindow());
        this.f240228a = new C105401(this);
        return;
    L9:
        if (isAttachedToWindow() == false) goto L11;
        tt5.a.h("CCMLottieView", "resumeAnimation, visible & attachedToWindow, resume animation.");
        this.f240228a = null;
        super.resumeAnimation();
    }

    public CCMLottieView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final boolean j(int r100) {
        if (r100 == 0) goto L4;
    L8:
        return false;
    L4:
        if (getWidth() <= 0) goto L8;
        if (getHeight() <= 0) goto L8;
        return true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimation(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        tt5.a.k("CCMLottieView", "setAnimation, assetName is null or empty.");
        return;
    L10:
        super.setAnimation(r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ee.bear.widgets.lottie.CCMLottieView$onViewUpdated$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v4, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final void l(int r100, boolean r101) {
        if (j(r100) == false) goto L10;
        if (r101 == false) goto L10;
        ?? r102 = this.f240228a;
        if (r102 == 0) goto L8;
        r102.invoke();
    L8:
        this.f240228a = null;
        return;
    L10:
        if (isAnimating() == false) goto L14;
        pauseAnimation();
        this.f240228a = new CCMLottieView$onViewUpdated$1(this);
        return;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        tt5.a.h("CCMLottieView", "onVisibilityChanged, visibility: " + r101 + ", isAttachedToWindow: " + isAttachedToWindow());
        l(r101, isAttachedToWindow());
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        tt5.a.h("CCMLottieView", "onSizeChanged, visibility: " + getVisibility() + ", isAttachedToWindow: " + isAttachedToWindow());
        l(getVisibility(), isAttachedToWindow());
    }
}
