package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.ee.bear.doc.resupdate.download.v2.RustDownloader;
import com.ss.android.lark.vfs.VFSPath;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z extends cz4.a {
    public final /* synthetic */ String c;
    public final /* synthetic */ g0 d;
    public final /* synthetic */ w.b e;

    @Override // cz4.c
    public final void onFinished() {
        this.b = SystemClock.uptimeMillis();
        tt5.a.h("LocalResUpdateServiceImpl", "onFinished(): ");
        Context r1 = this.e.b.g;     // Catch: Exception -> L5
        VFSPath r2 = d0.c().getVfsPath().subPath(this.c);     // Catch: Exception -> L5
        VFSPath r3 = d0.j(this.e.b.g.getString(2131895998)).getVfsPath();     // Catch: Exception -> L5
        w.l(this.e.b, this.d.f, r2, r3, true);     // Catch: Exception -> L5
        this.e.a.onReady();     // Catch: Exception -> L5
        w.b r4 = this.e;     // Catch: Exception -> L5
        w.m(r4.b, this.b - this.a, true, "success", r4.a.b);     // Catch: Exception -> L5
        tt5.a.h("LocalResUpdateServiceImpl", "transferToSDFromDownloadX onFinished(): ");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("LocalResUpdateServiceImpl", "onFinished(): failed", e, false);
        w.m(this.e.b, this.b - this.a, false, e.getMessage(), this.e.a.b);
        w.b r0 = this.e;
        w.k(r0.b, r0.a);
    }

    @Override // cz4.c
    public final void onStart() {
        this.a = SystemClock.uptimeMillis();
        tt5.a.h("LocalResUpdateServiceImpl", "onStart(): ");
    }

    @Override // cz4.c
    public final void a(RustDownloader.RustDownloadException r8) {
        this.b = SystemClock.uptimeMillis();
        boolean r2 = false;
        tt5.a.e("LocalResUpdateServiceImpl", "onFail()", r8, false);
        if (r8.errorCode == 1007) goto L8;
        com.bytedance.ee.bear.contract.j r0 = this.e.b.n;
        if (r0 == null) goto L8;
        r2 = r0.getNetworkState().a();
    L8:
        if (r2 == true) goto L10;
        w.b r9 = this.e;
        Queue<f0> r1 = r9.b.l;
        ConcurrentLinkedQueue r3 = (ConcurrentLinkedQueue) r1;
        r3.offer(r9.a);
        return;
    L10:
        w.m(this.e.b, this.b - this.a, false, r8.getMessage(), this.e.a.b);
        w.b r10 = this.e;
        w.k(r10.b, r10.a);
    }

    public z(w.b r1, String r2, g0 r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
