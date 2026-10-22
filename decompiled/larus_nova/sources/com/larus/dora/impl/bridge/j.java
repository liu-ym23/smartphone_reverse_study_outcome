package com.larus.dora.impl.bridge;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements t39.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraService f332098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f332099b;

    @Override // t39.u
    public final void b() {
    }

    public j(IDoraService r100, k r101) {
        this.f332098a = r100;
        this.f332099b = r101;
    }

    @Override // t39.u
    public final void a(boolean r100, String r101, String r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        boolean r105 = true;
        if (r104 != 2) goto L12;
        if (r101.length() == 0) goto L8;
        r105 = false;
    L8:
        if (r105 == false) goto L10;
        r101 = "unknown";
    L10:
        FLogger.f375446a.i("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace point log result success=" + r100 + ", msg=" + r101);
        return;
    L12:
        if (r101.length() > 0) goto L15;
        r105 = false;
    L15:
        if (r105 == false) goto L17;
        FLogger.f375446a.i("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace key log result success=" + r100 + ", msg=" + r101);
    L17:
        FLogger.f375446a.d("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace startUploadLog " + r102 + ". success: " + r100 + ", curLogType: " + r104);
        this.f332098a.k0(r102, r104, this.f332099b);
    }
}
