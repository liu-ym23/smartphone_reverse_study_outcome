package h0c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f483503b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f483504a;

    public static final class a {
    }

    /* JADX INFO: renamed from: h0c.b$b, reason: collision with other inner class name */
    public static final class C6088b<T> extends b<T> {
        public C6088b(T r100) {
            super(r100);
        }
    }

    public static final class c<T> extends b<T> {
        public c(T r100) {
            super(r100);
        }
    }

    static {
    }

    public b() {
        throw null;
    }

    public final int hashCode() {
        T r100 = this.f483504a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object r100) {
        this.f483504a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f483504a, ((b) r100).f483504a) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
