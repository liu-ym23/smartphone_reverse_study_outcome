package com.larus.slides.sdk.impl;

import android.net.Uri;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements rw4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function4<Boolean, Uri, Integer, String, Unit> f369768a;

    @Override // rw4.a
    public final void onDismiss() {
    }

    @Override // rw4.a
    public final void onDownloading(int r100) {
    }

    @Override // rw4.a
    public final void onExportStart() {
    }

    @Override // rw4.a
    public final void onPolling(int r100) {
    }

    @Override // rw4.a
    public final void onStartDownload() {
    }

    @Override // rw4.a
    public final void onStartPolling() {
    }

    public d(com.larus.slides.operation.download.a r100) {
        this.f369768a = r100;
    }

    @Override // rw4.a
    public final void onSuccess(Uri r100) {
        FLogger.f375446a.i("SlidesSdkServiceImplV2", "export onSuccess: uri:" + r100);
        this.f369768a.invoke(Boolean.TRUE, r100, null, null);
    }

    @Override // rw4.a
    public final void onFail(int r100, Throwable r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("export onFail: error:");
        if (r101 == null) goto L5;
        String r104 = r101.getMessage();
    L6:
        r103.append(r104);
        r102.i("SlidesSdkServiceImplV2", r103.toString());
        Function4<Boolean, Uri, Integer, String, Unit> r105 = this.f369768a;
        Boolean r106 = Boolean.FALSE;
        Integer r107 = Integer.valueOf(r100);
        if (r101 == null) goto L10;
        String r108 = r101.getMessage();
        if (r108 == null) goto L10;
    L11:
        r105.invoke(r106, null, r107, r108);
        return;
    L10:
        r108 = "";
        goto L11
    L5:
        r104 = null;
        goto L6
    }
}
