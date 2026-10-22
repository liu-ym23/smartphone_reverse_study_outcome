package com.larus.sheet.sdk.impl;

import android.net.Uri;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes31.dex */
public final class l implements rw4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function5<Boolean, Uri, Throwable, Integer, String, Unit> f369162a;

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

    public l(com.larus.sheet.operation.download.b r100) {
        this.f369162a = r100;
    }

    @Override // rw4.a
    public final void onSuccess(Uri r110) {
        FLogger.f375446a.i("SheetSdkServiceImplV2", "export onSuccess: uri:" + r110);
        this.f369162a.invoke(Boolean.TRUE, r110, null, null, null);
    }

    @Override // rw4.a
    public final void onFail(int r110, Throwable r111) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("export onFail: error:");
        if (r111 == null) goto L5;
        String r102 = r111.getMessage();
    L6:
        r101.append(r102);
        r100.i("SheetSdkServiceImplV2", r101.toString());
        Function5<Boolean, Uri, Throwable, Integer, String, Unit> r103 = this.f369162a;
        Boolean r104 = Boolean.FALSE;
        Integer r105 = Integer.valueOf(r110);
        if (r111 == null) goto L10;
        String r112 = r111.getMessage();
        if (r112 == null) goto L10;
    L11:
        r103.invoke(r104, null, r111, r105, r112);
        return;
    L10:
        r112 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
