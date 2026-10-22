package yl5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, AtomicInteger> f568319b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568320a;

    /* JADX INFO: renamed from: yl5.a$a, reason: collision with other inner class name */
    public static final class C8354a {
    }

    static {
        f568319b = new LinkedHashMap();
    }

    public final int a() {
        Map<String, AtomicInteger> r100 = f568319b;
        monitor-enter(r100);
        LinkedHashMap r101 = (LinkedHashMap) r100;     // Catch: Throwable -> L12
        AtomicInteger r102 = (AtomicInteger) r101.get(this.f568320a);     // Catch: Throwable -> L12
        if (r102 == null) goto L7;
        int r103 = r102.decrementAndGet();     // Catch: Throwable -> L12
    L8:
        if (r103 != 0) goto L10;
        r100.remove(this.f568320a);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);
        return r103;
    L7:
        r103 = -1;
    L12:
        th = move-exception;
        throw th;
    }

    public final int b() {
        Map<String, AtomicInteger> r100 = f568319b;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r100.containsKey(this.f568320a) == true) goto L7;
        r100.put(this.f568320a, new AtomicInteger(0));     // Catch: Throwable -> L14
    L7:
        LinkedHashMap r101 = (LinkedHashMap) r100;     // Catch: Throwable -> L14
        AtomicInteger r102 = (AtomicInteger) r101.get(this.f568320a);     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        int r103 = r102.incrementAndGet();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);
        return r103;
    L11:
        r103 = -1;
        goto L12
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f568320a = r100;
    }
}
