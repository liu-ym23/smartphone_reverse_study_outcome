package kotlinx.coroutines.channels;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@JvmInline
public final class g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f504696b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f504697a;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f504698a;

        public final int hashCode() {
            Throwable r100 = this.f504698a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        @Override // kotlinx.coroutines.channels.g.c
        public final String toString() {
            return "Closed(" + this.f504698a + ')';
        }

        public a(Throwable r100) {
            this.f504698a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.f504698a, ((a) r100).f504698a) == false) goto L7;
            return true;
        }
    }

    public static final class b {
    }

    public static class c {
        public c() {
        }

        public String toString() {
            return "Failed";
        }
    }

    static {
        f504696b = new c();
    }

    public final int hashCode() {
        Object r100 = this.f504697a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        Object r100 = this.f504697a;
        if ((r100 instanceof a) == false) goto L6;
        return ((a) r100).toString();
    L6:
        return "Value(" + r100 + ')';
    }

    public /* synthetic */ g(Object r100) {
        this.f504697a = r100;
    }

    public static final Throwable a(Object r100) {
        if ((r100 instanceof a) == false) goto L5;
        a r101 = (a) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f504698a;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T b(Object r100) {
        if ((r100 instanceof c) == false) goto L7;
        return null;
    L7:
        return r100;
    }

    public static final void c(Object r100) {
        if ((r100 instanceof c) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof a) == false) goto L11;
        Throwable r101 = ((a) r100).f504698a;
        if (r101 == null) goto L11;
        throw r101;
    L11:
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + r100).toString());
    }

    public final boolean equals(Object r100) {
        Object r101 = this.f504697a;
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r101, ((g) r100).f504697a) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
