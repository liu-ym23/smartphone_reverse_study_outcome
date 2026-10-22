package com.bytedance.ug.sdk.luckycat.impl.manager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements hn7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f271313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f271314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f271315c;

    public final void m() {
        if (this.f271315c != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f271315c != null) goto L8;
        JSONObject r100 = this.f271314b.a();     // Catch: Throwable -> L10
        this.f271315c = r100;     // Catch: Throwable -> L10
        x(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    public d() {
        this.f271313a = new CopyOnWriteArrayList();
        this.f271314b = new e0();
    }

    public final void x(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<g> r101 = this.f271313a;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (((CopyOnWriteArrayList) this.f271313a).size() <= 0) goto L9;
        Object[] r102 = ((CopyOnWriteArrayList) this.f271313a).toArray();     // Catch: Throwable -> L16
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (r102 == null) goto L15;
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L22;
        ((g) r102[r104]).a(r100);
        r104 = r104 + 1;
        goto L13
    L22:
        return;
    L15:
        return;
    L9:
        r102 = null;
        goto L10
    }
}
