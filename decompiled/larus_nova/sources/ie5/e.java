package ie5;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f489480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f489481b;

    public e() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f489480a, this.f489481b});
    }

    public final String toString() {
        return "Revision{revision='" + this.f489480a + "', version='" + this.f489481b + "'}";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(e.class, r100.getClass()) == false) goto L17;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f489480a, r101.f489480a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.f489481b, r101.f489481b) == false) goto L15;
        return true;
    }
}
