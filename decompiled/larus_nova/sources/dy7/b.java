package dy7;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<by7.c> f470545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f470546b;

    public final int hashCode() {
        return this.f470546b;
    }

    public b(by7.c r100) {
        this.f470545a = new WeakReference(r100);
        this.f470546b = r100.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        if (r100 == this) goto L14;
        return false;
    L14:
        return true;
    L5:
        if (((b) r100).f470545a.get() == this.f470545a.get()) goto L13;
        return false;
    L13:
        return true;
    }
}
