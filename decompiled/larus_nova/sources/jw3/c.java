package jw3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f500706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<a> f500707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<d> f500708c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference<e> f500709d = null;

    public c() {
    }

    static {
        f500706a = new c();
        f500707b = new AtomicReference(null);
        f500708c = new AtomicReference(null);
        f500709d = new AtomicReference(null);
    }

    public static a a() {
        return f500707b.get();
    }
}
