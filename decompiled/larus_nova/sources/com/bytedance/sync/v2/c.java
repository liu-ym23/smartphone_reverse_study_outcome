package com.bytedance.sync.v2;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import hg7.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
import xf7.t;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile AtomicInteger f270392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AtomicBoolean f270393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile AtomicLong f270394c;

    @Override // hg7.l
    public final boolean W() {
        return this.f270393b.get();
    }

    @Override // hg7.l
    public final int Y() {
        return this.f270392a.get();
    }

    @Override // hg7.l
    public final void d() {
        long r100 = this.f270394c.get();
        SDKMonitor r101 = t.f563496a;
        long r102 = System.currentTimeMillis() - r100;     // Catch: Exception -> L5
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        r103.put("sync_cost", r102);     // Catch: Exception -> L5
        t.b("sync_sdk_sync_cost", null, r103, null, 10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        t.d(e, null);
    }

    public c() {
        this.f270392a = new AtomicInteger(1);
        this.f270393b = new AtomicBoolean(true);
        this.f270394c = new AtomicLong(0);
    }

    @Override // hg7.l
    public final void j0(boolean r100) {
        this.f270393b.set(r100);
    }

    @Override // hg7.l
    public final void C(int r100, long r101) {
        this.f270392a.set(r100);
        this.f270394c.set(r101);
    }
}
