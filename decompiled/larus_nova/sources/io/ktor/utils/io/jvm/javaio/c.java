package io.ktor.utils.io.jvm.javaio;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<b<Thread>> f492125a = null;

    static {
        f492125a = new ThreadLocal();
    }

    public static final b<Thread> a() {
        b<Thread> r100 = f492125a.get();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return a.f492124a;
    }
}
