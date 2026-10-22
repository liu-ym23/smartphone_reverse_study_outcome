package p5;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f527736a;

    public final String toString() {
        return "ComparableByteArray(value=" + Arrays.toString(this.f527736a) + ')';
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f527736a);
    }

    public b(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f527736a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r101) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ai.resource.loader.ComparableByteArray");
        return Arrays.equals(this.f527736a, ((b) r100).f527736a);
    L8:
        r101 = null;
        goto L10
    }
}
