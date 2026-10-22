package com.ss.android.lark.screenprotect.screenshot;

import android.animation.ValueAnimator;
import com.ss.android.lark.security.screen.protect.databinding.ActivityScreenshotPreviewBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotPreviewActivity f439823a;

    public i(ScreenshotPreviewActivity r100) {
        this.f439823a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        ActivityScreenshotPreviewBinding r103 = this.f439823a.f439802c;
        ActivityScreenshotPreviewBinding r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L5:
        int r105 = r103.f440492d.getHeight();
        if (r105 > 0) goto L8;
        return;
    L8:
        float r106 = r105;
        float r107 = (r106 - (r102 * r106)) / 4;
        ActivityScreenshotPreviewBinding r108 = this.f439823a.f439802c;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r104.f440492d.setTranslationY(-r107);
        return;
    L11:
        r104 = r108;
        goto L12
    }
}
