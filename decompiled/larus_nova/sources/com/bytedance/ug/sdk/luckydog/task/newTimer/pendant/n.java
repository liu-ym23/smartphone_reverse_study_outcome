package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements ym7.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Class<? extends ym7.h>> f272167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Class<? extends xm7.b>> f272168b;

    public static final class a {
    }

    static {
    }

    public n() {
        this.f272167a = new ConcurrentHashMap();
        this.f272168b = new ConcurrentHashMap();
    }

    @Override // ym7.j
    public final void a(Class r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantViewService", "registerPendantView() called; pendant = crossover, clazz = ".concat(r100.getSimpleName()));
        if (this.f272167a.contains("crossover") == true) goto L6;
        this.f272167a.put("crossover", r100);
        return;
    }

    @Override // ym7.j
    public final void b(Class r100) {
        if (this.f272168b.contains("crossover_counter") == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantViewService", "registerCounterPendantView() called; pendantId = crossover_counter, clazz = ".concat(r100.getSimpleName()));
        this.f272168b.put("crossover_counter", r100);
        return;
    }

    @Override // ym7.j
    public final xm7.b c(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantViewService", "getCounterPendantView() called; pendantId = ".concat(r100));     // Catch: Throwable -> L8
        Class<? extends xm7.b> r101 = this.f272168b.get(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L13;
        return r101.newInstance();
    L13:
        return null;
    L8:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantViewService", th.getLocalizedMessage());
        return null;
    }

    @Override // ym7.j
    public final ym7.h d(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantViewService", "getPendantView() called; pendantId = ".concat(r100));
        Class<? extends ym7.h> r101 = this.f272167a.get(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L13;
        return r101.newInstance();
    L13:
        return null;
    L8:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantViewService", th.getLocalizedMessage());
        return null;
    }
}
