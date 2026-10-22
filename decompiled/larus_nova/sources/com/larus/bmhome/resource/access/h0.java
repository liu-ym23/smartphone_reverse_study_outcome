package com.larus.bmhome.resource.access;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f313671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f313672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile j0 f313673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile mr9.c f313674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Long f313675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile mr9.h f313676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f313677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile f0 f313678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f313679i;

    public final Map<String, String> b() {
        return MapsKt.toMap(this.f313679i);
    }

    public final synchronized void a(i0 r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "update");     // Catch: Throwable -> L24
        j0 r101 = r100.f313681a;     // Catch: Throwable -> L24
        if (r101 == null) goto L6;
        this.f313673c = r101;     // Catch: Throwable -> L24
    L6:
        mr9.c r102 = r100.f313682b;     // Catch: Throwable -> L24
        if (r102 == null) goto L9;
        this.f313674d = r102;     // Catch: Throwable -> L24
    L9:
        Long r103 = r100.f313683c;     // Catch: Throwable -> L24
        if (r103 == null) goto L12;
        this.f313675e = Long.valueOf(r103.longValue());     // Catch: Throwable -> L24
    L12:
        mr9.h r104 = r100.f313684d;     // Catch: Throwable -> L24
        if (r104 == null) goto L15;
        this.f313676f = r104;     // Catch: Throwable -> L24
    L15:
        String r105 = r100.f313685e;     // Catch: Throwable -> L24
        if (r105 == null) goto L18;
        this.f313677g = r105;     // Catch: Throwable -> L24
    L18:
        f0 r106 = r100.f313686f;     // Catch: Throwable -> L24
        if (r106 == null) goto L21;
        this.f313678h = r106;     // Catch: Throwable -> L24
    L21:
        this.f313679i.putAll(r100.f313687g);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public h0(w r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "task");
        this.f313671a = r100;
        this.f313672b = r101;
        this.f313673c = r100.f313763b;
        this.f313674d = r100.f313765d.f313662i;
        this.f313675e = r100.f313765d.f313663j;
        this.f313676f = r100.f313765d.f313661h;
        this.f313677g = r100.f313765d.f313658e;
        this.f313679i = new ConcurrentHashMap(r100.f313765d.f313666m);
    }
}
