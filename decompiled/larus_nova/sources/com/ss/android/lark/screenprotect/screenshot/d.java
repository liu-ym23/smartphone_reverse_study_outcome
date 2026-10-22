package com.ss.android.lark.screenprotect.screenshot;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotPreviewActivity f439818a;

    public d(ScreenshotPreviewActivity r100) {
        this.f439818a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        ScsLogger.d("SHARE_SS_ScreenshotPreviewActivity", "Dialog onCancel.");
        ShareScreenshotUtil r101 = ShareScreenshotUtil.f439806a;
        ShareScreenshotUtil.f(this.f439818a.f439801b);
    }
}
