package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements d {
    public final ConnectionService e;

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean a(long r4) {
        if (r4 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean b(long r1, w75.a r3, String r4, DownloadOptions r5) {
        return true;
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
        return "6";
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DrivePriority.DownloadPriority f() {
        return d.c;
    }

    public g(com.bytedance.ee.bear.contract.j r1) {
        this.e = r1;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DriveFilePath h(Context r1) {
        return t.f();
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String i(w75.a r1) {
        return t.c(r1);
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean g(t r8, w75.c r9) {
        boolean r4 = true;
        if (r9.getFileSize() >= 52428800) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L20;
        if (r8 == null) goto L21;
        DriveCache r10 = t.i(t.c(r9.getDetails()), false, new a95.a());
        if (r10 == null) goto L19;
        if (TextUtils.equals(r9.h(), r10.e) == false) goto L19;
        r4 = false;
    L19:
        return r4;
    L21:
        return r0;
    L20:
        return r0;
    L5:
        if (this.e.getNetworkState().b() == false) goto L9;
        if (t.c == true) goto L9;
        r0 = true;
        goto L10
    }
}
