package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes41.dex */
public final class o<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o<Object> f495051b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f495052a;

    static {
        f495051b = new o(null);
    }

    public final Throwable b() {
        Object r100 = this.f495052a;
        if (NotificationLite.isError(r100) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r100);
    }

    public final T c() {
        Object r100 = this.f495052a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (NotificationLite.isError(r100) == false) goto L7;
        return null;
    L7:
        return (T) this.f495052a;
    }

    public final boolean d() {
        return NotificationLite.isError(this.f495052a);
    }

    public final boolean e() {
        Object r100 = this.f495052a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isError(r100) == true) goto L7;
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f495052a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        Object r100 = this.f495052a;
        if (r100 != null) goto L7;
        return "OnCompleteNotification";
    L7:
        if (NotificationLite.isError(r100) == false) goto L11;
        return "OnErrorNotification[" + NotificationLite.getError(r100) + "]";
    L11:
        return "OnNextNotification[" + this.f495052a + "]";
    }

    public o(Object r100) {
        this.f495052a = r100;
    }

    public static <T> o<T> a(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "error is null");
        return new o(NotificationLite.error(r100));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof o) == true) goto L5;
        return false;
    L5:
        return ObjectHelper.equals(this.f495052a, ((o) r100).f495052a);
    }
}
