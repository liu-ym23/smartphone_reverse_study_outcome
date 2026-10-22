package h80;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c<?> f484054b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f484055a;

    static {
        f484054b = new c();
    }

    public final T a() {
        T r100 = this.f484055a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NoSuchElementException("No value present");
    }

    public final boolean b() {
        if (this.f484055a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        T r100 = this.f484055a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        T r100 = this.f484055a;
        if (r100 != null) goto L7;
        return "Optional.empty";
    L7:
        return String.format("Optional[%s]", new Object[]{r100});
    }

    public c() {
        this.f484055a = null;
    }

    public c(T r100) {
        Objects.requireNonNull(r100);
        this.f484055a = r100;
    }

    public static <T> c<T> c(T r100) {
        if (r100 != null) goto L5;
        return (c<T>) f484054b;
    L5:
        return new c(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        T r101 = this.f484055a;
        T r102 = ((c) r100).f484055a;
        if (r101 == r102) goto L16;
        if (r101 != null) goto L12;
    L14:
        return false;
    L12:
        if (r101.equals(r102) == false) goto L14;
        return true;
    L16:
        return true;
    }
}
