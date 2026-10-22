package ot3;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f526665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f526666b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f526667a = null;

        static {
            f526667a = new d();
        }
    }

    public d() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f526665a == false) goto L20;
        monitor-exit(this);
        return;
    L20:
        PolarisFileWrapper r100 = new PolarisFileWrapper(mt3.b.e(), "header");     // Catch: Throwable -> L12
        this.f526666b = r100;     // Catch: Throwable -> L12
        if (r100.exists() == true) goto L14;
        this.f526666b.mkdirs();     // Catch: Throwable -> L12
    L14:
        this.f526665a = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        av3.b.b("APM", "header store init error " + th.toString());     // Catch: Throwable -> L17
        goto L14
    }
}
