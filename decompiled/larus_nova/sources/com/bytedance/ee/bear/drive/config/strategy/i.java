package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;

/* JADX INFO: loaded from: classes16.dex */
public class i implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConnectionService f224107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g85.f f224108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q75.a f224109g;

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean a(long r100) {
        if (r100 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean b(long r100, w75.a r101, String r102, DownloadOptions r103) {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public String c(String r100) {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public String d() {
        return FileInfoPuller.CALLER_EXPLORER;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public boolean enableStreaming() {
        return !(this instanceof m);
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public String getPreviewFileSourceType() {
        return "1";
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DrivePriority$DownloadPriority f() {
        return d.f224093b;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DriveFilePath h(Context r100) {
        return t.f();
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public String i(w75.a r100) {
        return t.c(r100);
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean e(long r100, String r101) {
        if (((g85.b) this.f224108f).f(r101) == false) goto L15;
        if (w55.n.h(this.f224109g) == true) goto L13;
        int r102 = q75.b.f531970a;
        if (q75.b.a.a() == true) goto L13;
        if (r100 > (this.f224109g.a().getExcel_tab_data_max_size() * 1024)) goto L22;
        return false;
    L22:
        return true;
    L13:
        return false;
    L15:
        if (((g85.b) this.f224108f).n(r101) == true) goto L17;
        return false;
    L17:
        if (r100 > (this.f224109g.a().getText_preview_max_size() * 1024)) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean g(t r100, w75.c r101) {
        boolean r102 = j.a(this.f224107e, r101.getFileSize(), getPreviewFileSourceType());
        if (r102 == false) goto L9;
        if (r100 != null) goto L6;
        return r102;
    L6:
        if (t.i(du5.d.a(r101.getFileToken()), false, new a95.a()) != null) goto L11;
        return true;
    L11:
        return false;
    L9:
        return r102;
    }

    public i(g85.b r100, com.bytedance.ee.bear.contract.j r101, q75.a r102) {
        this.f224107e = r101;
        this.f224108f = r100;
        this.f224109g = r102;
    }
}
