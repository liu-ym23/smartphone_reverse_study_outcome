package com.bytedance.pia.core.worker;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.utils.d;
import com.bytedance.pia.core.worker.binding.WarmupModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;
import i47.c;
import java.util.concurrent.atomic.AtomicBoolean;
import s47.f;
import s47.n;
import v47.b;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile a f266455k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f266456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsWorker f266457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSModuleManager f266458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f266459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Runnable f266460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Throwable f266461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f266462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f266463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f266464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f266465j;

    public final boolean a() {
        monitor-enter(this);
        boolean r100 = this.f266459d;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(Uri r100) {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f266455k != null) goto L7;
    L9:
        monitor-exit(a.class);
        return;
    L7:
        if (f266455k.f266456a.equals(r100) == false) goto L9;
        f266455k.f266457b.terminate();     // Catch: Throwable -> L11
        f266455k = null;     // Catch: Throwable -> L11
        goto L9
    }

    public static synchronized void c(n.a r100) {
        monitor-enter(a.class);
        n r101 = r100.a();     // Catch: Throwable -> L26
        if (r101 != null) goto L7;
    L24:
        monitor-exit(a.class);
        return;
    L7:
        if (r101.f17555d.k() == false) goto L24;
        Uri r102 = UriProtector.parse(r101.f17555d.e());     // Catch: Throwable -> L26
        if (f266455k == null) goto L16;
        if (f266455k.f266456a.equals(r102) == false) goto L16;
        monitor-exit(a.class);
        return;
    L16:
        if (f266455k == null) goto L29;
        f266455k.f266457b.terminate();     // Catch: Throwable -> L26
    L29:
        f266455k = new a(r101.f17563l, r102);     // Catch: Throwable -> L20
    L22:
        monitor-exit(a.class);
        return;
    L20:
        th = move-exception;
        d.d("[Worker] try warmup failed!", th);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public a(c r100, Uri r110) {
        this.f266459d = false;
        this.f266460e = null;
        this.f266461f = null;
        this.f266462g = System.currentTimeMillis();
        this.f266456a = r110;
        JsWorker.EngineType r101 = JsWorker.EngineType.QUICKJS;
        AtomicBoolean r102 = Worker.b.f266453a;
        JSModuleManager r103 = new JSModuleManager(c47.c.a.f22405a);
        this.f266458c = r103;
        r103.b(WarmupModule.NAME, WarmupModule.class, this);
        this.f266457b = new JsWorker(r103, r101, null, false, "PIA");
        this.f266464i = System.currentTimeMillis();
        r100.b(LoadFrom.Auto, new f(r110), new v47.a(this), new b(this));
    }
}
