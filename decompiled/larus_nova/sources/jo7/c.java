package jo7;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f499913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f499914b = null;

    static {
        b r100 = a.f499905a;
        f499913a = r100;
        f499914b = r100;
        new AtomicInteger();
    }

    public static void a(Runnable r100) {
        f499913a.submit(r100);
    }
}
