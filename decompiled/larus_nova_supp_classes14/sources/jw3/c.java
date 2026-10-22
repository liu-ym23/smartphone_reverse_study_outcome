package jw3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final c a = null;
    public static final AtomicReference<a> b = null;
    public static final AtomicReference<d> c = null;
    public static final AtomicReference<e> d = null;

    public c() {
    }

    static {
        a = new c();
        b = new AtomicReference(null);
        c = new AtomicReference(null);
        d = new AtomicReference(null);
    }

    public static a a() {
        return b.get();
    }
}
