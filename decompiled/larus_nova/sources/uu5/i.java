package uu5;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes19.dex */
public final class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f551761a;

    public static <T> i<T> c() {
        return new i(null);
    }

    public final T a() {
        T r100 = this.f551761a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NoSuchElementException("No value present");
    }

    public final boolean b() {
        if (this.f551761a != null) goto L5;
        return true;
    L5:
        return false;
    }

    public i(T r100) {
        this.f551761a = r100;
    }
}
