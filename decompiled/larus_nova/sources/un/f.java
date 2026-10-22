package un;

import java.lang.Comparable;
import java.util.Objects;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T extends Comparable<? super T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f550757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f550758b;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f550757a, this.f550758b});
    }

    public final String toString() {
        return String.format("[%s, %s]", new Object[]{this.f550757a, this.f550758b});
    }

    public final boolean a(T r100) {
        if (r100 == null) goto L17;
        if (r100.compareTo(this.f550757a) < 0) goto L6;
        boolean r101 = true;
    L8:
        if (r100.compareTo(this.f550758b) > 0) goto L10;
        boolean r102 = true;
    L11:
        if (r101 == false) goto L14;
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L10:
        r102 = false;
        goto L11
    L6:
        r101 = false;
        goto L8
    L17:
        throw new IllegalArgumentException("value must not be null");
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (this.f550757a.equals(r101.f550757a) == true) goto L13;
        return false;
    L13:
        if (this.f550758b.equals(r101.f550758b) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public f(T r100, T r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        this.f550757a = r100;
        this.f550758b = r101;
        if (r100.compareTo(r101) > 0) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("lower must be less than or equal to upper");
    L11:
        throw new IllegalArgumentException("upper must not be null");
    L13:
        throw new IllegalArgumentException("lower must not be null");
    }
}
