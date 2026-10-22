package rj7;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f538132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f538133b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f538134c = null;

    static {
        b r100 = a.f538124a;
        f538132a = r100;
        f538133b = r100;
        f538134c = a.f538125b;
        new AtomicInteger();
    }

    public static void a(Runnable r100) {
        f538132a.submit(r100);
    }
}
