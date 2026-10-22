package yl5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Map<String, AtomicInteger> b = null;
    public final String a;

    /* JADX INFO: renamed from: yl5.a$a, reason: collision with other inner class name */
    public static final class C0341a {
    }

    static {
        b = new LinkedHashMap();
    }

    public final int a() {
        Map<String, AtomicInteger> r0 = b;
        monitor-enter(r0);
        LinkedHashMap r2 = (LinkedHashMap) r0;     // Catch: Throwable -> L12
        AtomicInteger r1 = (AtomicInteger) r2.get(this.a);     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        int r3 = r1.decrementAndGet();     // Catch: Throwable -> L12
    L8:
        if (r3 != 0) goto L10;
        r0.remove(this.a);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);
        return r3;
    L7:
        r3 = -1;
    L12:
        th = move-exception;
        throw th;
    }

    public final int b() {
        Map<String, AtomicInteger> r0 = b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r0.containsKey(this.a) == true) goto L7;
        r0.put(this.a, new AtomicInteger(0));     // Catch: Throwable -> L14
    L7:
        LinkedHashMap r2 = (LinkedHashMap) r0;     // Catch: Throwable -> L14
        AtomicInteger r1 = (AtomicInteger) r2.get(this.a);     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        int r3 = r1.incrementAndGet();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r3;
    L11:
        r3 = -1;
        goto L12
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        this.a = r2;
    }
}
