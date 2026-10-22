package com.bytedance.ee.bear.widgets.lottie;

import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0014J\b\u0010\u001a\u001a\u00020\bH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/widgets/lottie/CCMLottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pendingAction", "Lkotlin/Function0;", "", "setAnimation", "assetName", "", "playAnimation", "cancelAnimation", "resumeAnimation", "pauseAnimation", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "onViewUpdated", "isAttachedToWindow", "", "isVisible", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CCMLottieView extends LottieAnimationView {
    public Lambda a;

    public static final class a {
    }

    static {
    }

    public final void cancelAnimation() {
        tt5.a.h("CCMLottieView", "cancelAnimation");
        super.cancelAnimation();
        this.a = null;
    }

    public final void pauseAnimation() {
        tt5.a.h("CCMLottieView", "pauseAnimation");
        super.pauseAnimation();
        this.a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h("CCMLottieView", "onAttachedToWindow, visibility: " + getVisibility() + ", isAttachedToWindow: true");
        l(getVisibility(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h("CCMLottieView", "onDetachedFromWindow, visibility: " + getVisibility() + ", isAttachedToWindow: false");
        l(getVisibility(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void playAnimation() {
        boolean r0 = j(getVisibility());
        if (r0 == true) goto L5;
    L7:
        tt5.a.h("CCMLottieView", "playAnimation, pending it, isVisible: " + r0 + ", isAttachedToWindow: " + isAttachedToWindow());
        this.a = new AnonymousClass1(this);
        return;
    L5:
        if (isAttachedToWindow() == false) goto L7;
        tt5.a.h("CCMLottieView", "playAnimation, visible & attachedToWindow, play animation.");
        this.a = null;
        super.playAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void resumeAnimation() {
        if (isAnimating() == false) goto L6;
        tt5.a.h("CCMLottieView", "resumeAnimation, already animating.");
        return;
    L6:
        boolean r0 = j(getVisibility());
        if (r0 == true) goto L9;
    L11:
        tt5.a.h("CCMLottieView", "resumeAnimation, pending it, isVisible: " + r0 + ", isAttachedToWindow: " + isAttachedToWindow());
        this.a = new C03561(this);
        return;
    L9:
        if (isAttachedToWindow() == false) goto L11;
        tt5.a.h("CCMLottieView", "resumeAnimation, visible & attachedToWindow, resume animation.");
        this.a = null;
        super.resumeAnimation();
    }

    public CCMLottieView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j(int r1) {
        if (r1 == 0) goto L4;
    L8:
        return false;
    L4:
        if (getWidth() <= 0) goto L8;
        if (getHeight() <= 0) goto L8;
        return true;
    }

    public void setAnimation(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        tt5.a.k("CCMLottieView", "setAnimation, assetName is null or empty.");
        return;
    L10:
        super.setAnimation(r2);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void l(int r1, boolean r2) {
        if (j(r1) == false) goto L10;
        if (r2 == false) goto L10;
        Lambda r3 = this.a;
        if (r3 == null) goto L8;
        r3.invoke();
    L8:
        this.a = null;
        return;
    L10:
        if (isAnimating() == false) goto L14;
        pauseAnimation();
        this.a = new CCMLottieView$onViewUpdated$1(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        tt5.a.h("CCMLottieView", "onVisibilityChanged, visibility: " + r3 + ", isAttachedToWindow: " + isAttachedToWindow());
        l(r3, isAttachedToWindow());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        tt5.a.h("CCMLottieView", "onSizeChanged, visibility: " + getVisibility() + ", isAttachedToWindow: " + isAttachedToWindow());
        l(getVisibility(), isAttachedToWindow());
    }
}
