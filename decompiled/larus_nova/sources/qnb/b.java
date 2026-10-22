package qnb;

import rnb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f534121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static snb.a f534122b;

    public interface a {
        snb.a a();
    }

    public static snb.a a() {
        if (f534122b != null) goto L9;
        if (f534121a != null) goto L7;
        qnb.a r100 = new qnb.a();
        f534121a = r100;
        f534122b = r100.a();
        c.f538745a = r100.b();
    L7:
        f534122b = f534121a.a();
    L9:
        return f534122b;
    }
}
