package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;

/* JADX INFO: loaded from: classes16.dex */
public class h implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q75.a f224105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g85.f f224106f;

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean a(long r100) {
        if (r100 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String c(String r100) {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String d() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean e(long r100, String r101) {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean enableStreaming() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean g(t r100, w75.c r101) {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String getPreviewFileSourceType() {
        return "2";
    }

    public long j() {
        return this.f224105e.f531962e;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DrivePriority$DownloadPriority f() {
        return d.f224095d;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DriveFilePath h(Context r100) {
        return t.f();
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final String i(w75.a r100) {
        return t.c(r100);
    }

    public h(g85.b r100, q75.a r101) {
        this.f224105e = r101;
        this.f224106f = r100;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean b(long r100, w75.a r101, String r102, DownloadOptions r103) {
        if (((g85.b) this.f224106f).o(r102, null) == false) goto L6;
        return false;
    L6:
        if (r100 > j()) goto L9;
        return true;
    L9:
        return false;
    }
}
