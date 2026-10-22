package rk7;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<gk7.f> f538341a = null;

    static {
        f538341a = new CopyOnWriteArraySet();
    }

    public static void a(gk7.f r100) {
        CopyOnWriteArraySet<gk7.f> r101 = f538341a;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }
}
