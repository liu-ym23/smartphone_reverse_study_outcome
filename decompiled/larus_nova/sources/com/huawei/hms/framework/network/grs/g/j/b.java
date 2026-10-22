package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f277254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f277255b;

    public b(Future<com.huawei.hms.framework.network.grs.g.d> r100) {
        this.f277254a = r100;
        this.f277255b = SystemClock.elapsedRealtime();
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f277254a;
    }

    public boolean b() {
        if ((SystemClock.elapsedRealtime() - this.f277255b) > 300000) goto L5;
        return true;
    L5:
        return false;
    }
}
