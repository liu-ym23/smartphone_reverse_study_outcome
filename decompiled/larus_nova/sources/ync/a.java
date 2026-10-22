package ync;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f568600a;

    public final int hashCode() {
        return this.f568600a;
    }

    public a(T r100) {
        super(r100);
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        this.f568600a = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        return Intrinsics.areEqual(get(), ((a) r100).get());
    }
}
