package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.exception.ExceptionWithCode;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f250818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f250819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f250820c;

    public d() {
    }

    public final void a() throws Exception {
        g r100 = this.f250818a;
        if (r100 == null) goto L17;
        if (r100 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        if (r100.f250829a == false) goto L17;
        ConcurrentHashMap<String, Long> r101 = g.f250828c;
        Long r102 = r101.get(r100.f250830b);
        if (r102 != null) goto L12;
        r101.put(r100.f250830b, Long.valueOf(System.currentTimeMillis()));
        goto L17
    L12:
        if ((System.currentTimeMillis() - r102.longValue()) <= 600000) goto L15;
        r101.put(r100.f250830b, Long.valueOf(System.currentTimeMillis()));
        goto L17
    L15:
        throw new ExceptionWithCode(600, "repeat gecko update request in 600s");
    L17:
        e r103 = this.f250820c;
        if (r103 == null) goto L22;
        if (r103 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        e.f250821e.remove(r103.f250824c);
    L22:
        a r104 = this.f250819b;
        if (r104 == null) goto L49;
        if (r104 != null) goto L26;
        Intrinsics.throwNpe();
    L26:
        monitor-enter(r104);
        long r105 = 60000;
        if ((System.currentTimeMillis() - a.f250811d) <= r105) goto L31;
        a.f250810c = 0;     // Catch: Throwable -> L46
    L31:
        if (a.f250810c == 3) goto L33;
    L35:
        r104.f250813a = false;     // Catch: Throwable -> L46
    L37:
        if (r104.f250813a == true) goto L39;
    L43:
        r104.f250813a = false;     // Catch: Throwable -> L46
        monitor-exit(r104);
        return;
    L39:
        if ((System.currentTimeMillis() - a.f250812e) > r105) goto L43;
        throw new ExceptionWithCode(601, "gecko update request failed more than 3 times");     // Catch: Throwable -> L46
    L33:
        if (r104.f250814b == false) goto L35;
        r104.f250813a = true;     // Catch: Throwable -> L46
        a.f250812e = System.currentTimeMillis();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }
}
