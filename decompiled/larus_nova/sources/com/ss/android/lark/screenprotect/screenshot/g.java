package com.ss.android.lark.screenprotect.screenshot;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotPreviewActivity f439821a;

    public g(ScreenshotPreviewActivity r100) {
        this.f439821a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ScsLogger.d("SHARE_SS_ScreenshotPreviewActivity", "Dialog cancel button click.");
        ShareScreenshotUtil r102 = ShareScreenshotUtil.f439806a;
        ShareScreenshotUtil.f(this.f439821a.f439801b);
    }
}
