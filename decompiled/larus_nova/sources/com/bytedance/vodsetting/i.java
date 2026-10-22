package com.bytedance.vodsetting;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f272573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsManager f272574b;

    @Override // java.lang.Runnable
    public final void run() {
        SettingsManager r100 = this.f272574b;     // Catch: Throwable -> L42
        String r101 = this.f272573a;     // Catch: Throwable -> L42
        monitor-enter(r100);     // Catch: Throwable -> L42
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L5:
        if (r100.f272540g >= 1) goto L20;
        j r102 = r100.f272538e.get("common");     // Catch: Throwable -> L39
        r102.g(r100.f272536c.getApplicationContext());     // Catch: Throwable -> L39
        r100.f272541h = r102.a("fetch_interval", 0);     // Catch: Throwable -> L13
        r100.f272542i = r102.c("config_version", 0);     // Catch: Throwable -> L13
        r100.f272540g = r102.c("local_cache_expire", 0);     // Catch: Throwable -> L13
        if (r102.a("use_local_cache", 1) <= 0) goto L10;
        boolean r103 = true;
    L11:
        r100.f272539f = r103;     // Catch: Throwable -> L13
        r100.f272543j = r102.a("max_fetch_times", r100.f272543j);     // Catch: Throwable -> L13
    L15:
        int r104 = 0;
    L16:
        SettingsManager.ModuleItem[] r105 = r100.f272546m;     // Catch: Throwable -> L39
        if (r104 >= r105.length) goto L20;
        r100.a(r105[r104].stringValue);     // Catch: Throwable -> L39
        r104 = r104 + 1;     // Catch: Throwable -> L39
        goto L16
    L10:
        r103 = false;
    L13:
        th = move-exception;
        e.a("Manager", th.toString());     // Catch: Throwable -> L39
    L20:
        if (r100.f272537d == null) goto L29;
        int r106 = r100.f272541h;     // Catch: Throwable -> L39
        if (r106 >= 1) goto L24;
        e.a("Fetcher", "set fetch interval fail. interval = " + r106);     // Catch: Throwable -> L39
    L24:
        b r107 = r100.f272537d;     // Catch: Throwable -> L39
        int r108 = r100.f272543j;     // Catch: Throwable -> L39
        if (r108 >= 1) goto L27;
        r107.getClass();     // Catch: Throwable -> L39
        e.a("Fetcher", "set max fetch times fail. times = " + r108);     // Catch: Throwable -> L39
    L28:
        r100.f272537d.b(r100.f272542i);     // Catch: Throwable -> L39
        goto L29
    L27:
        r107.f272560d = r108;     // Catch: Throwable -> L39
    L29:
        long r109 = System.currentTimeMillis();     // Catch: Throwable -> L39
        e.b("Manager", "use cache: " + r100.f272539f + ", expire = " + r100.f272540g + ", curTimeMs = " + r109);     // Catch: Throwable -> L39
        if (r100.f272539f == true) goto L32;
    L33:
        b r110 = r100.f272537d;     // Catch: Throwable -> L39
        if (r110 == null) goto L36;
        r110.f272561e = 0;     // Catch: Throwable -> L39
        r110.c(r101, null);     // Catch: Throwable -> L39
    L36:
        r100.c(r100.f272541h);     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L42
        return;
    L32:
        if (r100.f272540g > r109) goto L36;
    L42:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L53;
        throw th;
    }

    public i(SettingsManager r100, String r101) {
        this.f272574b = r100;
        this.f272573a = r101;
    }
}
