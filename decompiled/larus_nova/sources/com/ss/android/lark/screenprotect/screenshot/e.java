package com.ss.android.lark.screenprotect.screenshot;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotPreviewActivity f439819a;

    public e(ScreenshotPreviewActivity r100) {
        this.f439819a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        ScreenshotPreviewActivity r101 = this.f439819a;
        ScreenshotPreviewActivity.a r102 = ScreenshotPreviewActivity.f439799d;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(ScreenshotPreviewActivity.z1(r101.getWindow()), "alpha", new float[]{1.0f, 0.0f});
        r103.setDuration(300);
        r103.addUpdateListener(new b(r101.getWindow().getAttributes().dimAmount, r101));
        Intrinsics.checkNotNull(r103);
        r103.addListener(new a(r101));
        r103.start();
    }
}
