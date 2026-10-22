package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements d {
    public final ConnectionService e;

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean a(long r4) {
        if (r4 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String c(String r1) {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String d() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean e(long r1, String r3) {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean enableStreaming() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String getPreviewFileSourceType() {
        return "4";
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DrivePriority.DownloadPriority f() {
        return d.a;
    }

    public b(com.bytedance.ee.bear.contract.j r1) {
        this.e = r1;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DriveFilePath h(Context r1) {
        return t.f();
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String i(w75.a r2) {
        return t.c(r2) + "_origin";
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean g(t r5, w75.c r6) {
        boolean r0 = j.a(this.e, r6.getFileSize(), "4");
        if (r0 == false) goto L9;
        if (r5 != null) goto L6;
        return r0;
    L6:
        if (t.i(i(r6.getDetails()), false, null) != null) goto L11;
        return true;
    L11:
        return false;
    L9:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean b(long r1, w75.a r3, String r4, DownloadOptions r5) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining");
        tt5.a.h("ExternalOpenStrategy", "canCache: isWatermarkRemainingFgOn = " + r2);
        if (r2 == false) goto L15;
        if (r5 != null) goto L11;
        return true;
    L11:
        if (r5.canCache() == true) goto L18;
        tt5.a.h("ExternalOpenStrategy", "canCache: downloadOptions can not cache, downloadOptions = " + r5);
        return false;
    L18:
        return true;
    L15:
        return true;
    L5:
        if (r3.e != 26) goto L7;
        return false;
    }
}
