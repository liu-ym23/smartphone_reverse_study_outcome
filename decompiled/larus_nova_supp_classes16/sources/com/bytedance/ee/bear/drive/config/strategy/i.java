package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class i implements d {
    public final ConnectionService e;
    public final g85.f f;
    public final q75.a g;

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
    public String c(String r1) {
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
        return DiagramData$RESULT.SUCCESS;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DrivePriority.DownloadPriority f() {
        return d.b;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final DriveFilePath h(Context r1) {
        return t.f();
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public String i(w75.a r1) {
        return t.c(r1);
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean e(long r6, String r8) {
        if (((g85.b) this.f).f(r8) == false) goto L15;
        if (w55.n.h(this.g) == true) goto L13;
        int r9 = q75.b.a;
        if (q75.b.a.a() == true) goto L13;
        if (r6 > (this.g.a().getExcel_tab_data_max_size() * 1024)) goto L22;
        return false;
    L22:
        return true;
    L13:
        return false;
    L15:
        if (((g85.b) this.f).n(r8) == true) goto L17;
        return false;
    L17:
        if (r6 > (this.g.a().getText_preview_max_size() * 1024)) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.d
    public final boolean g(t r5, w75.c r6) {
        boolean r0 = j.a(this.e, r6.getFileSize(), getPreviewFileSourceType());
        if (r0 == false) goto L9;
        if (r5 != null) goto L6;
        return r0;
    L6:
        if (t.i(du5.d.a(r6.getFileToken()), false, new a95.a()) != null) goto L11;
        return true;
    L11:
        return false;
    L9:
        return r0;
    }

    public i(g85.b r1, com.bytedance.ee.bear.contract.j r2, q75.a r3) {
        this.e = r2;
        this.f = r1;
        this.g = r3;
    }
}
