package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class h implements d {
    public final q75.a e;
    public final g85.f f;

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
    public final boolean g(t r1, w75.c r2) {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String getPreviewFileSourceType() {
        return "2";
    }

    public long j() {
        return this.e.e;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DrivePriority.DownloadPriority f() {
        return d.d;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DriveFilePath h(Context r1) {
        return t.f();
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String i(w75.a r1) {
        return t.c(r1);
    }

    public h(g85.b r1, q75.a r2) {
        this.e = r2;
        this.f = r1;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean b(long r3, w75.a r5, String r6, DownloadOptions r7) {
        if (((g85.b) this.f).o(r6, null) == false) goto L6;
        return false;
    L6:
        if (r3 > j()) goto L9;
        return true;
    L9:
        return false;
    }
}
