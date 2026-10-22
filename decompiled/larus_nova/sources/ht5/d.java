package ht5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import otb.i;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht5.a f487138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, otb.c> f487139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, i> f487140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f487141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<otb.b> f487142e;

    public static final class a {
    }

    static {
    }

    public d(ht5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        this.f487138a = r100;
        this.f487139b = new ConcurrentHashMap();
        this.f487140c = new ConcurrentHashMap();
        this.f487141d = new ConcurrentHashMap();
        this.f487142e = new ArrayList();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        this.f487138a.c("PlatformViewRegistry", r100, "destroyPlugin");
        this.f487139b.remove(r100);
        e r101 = b(r100);
        if (r101 == null) goto L6;
        r101.h(false);
        e r102 = this.f487141d.remove(r100);
        return;
    }

    public final synchronized e b(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        e r101 = this.f487141d.get(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        r101 = new e(r100);     // Catch: Throwable -> L12
        this.f487141d.put(r100, r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }
}
