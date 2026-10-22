package rw5;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f539717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f539718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f539719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f539720e;

    public final String toString() {
        return "FlowAudioData(id=" + this.f539716a + ", binaryData=" + Arrays.toString(this.f539717b) + ", shouldCalRenderingTime=" + this.f539718c + ')';
    }

    public final int hashCode() {
        if (this.f539718c == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f539716a.hashCode()) * 31) + Arrays.hashCode(this.f539717b);
    L5:
        r100 = 1237;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (d.class != r100.getClass()) goto L20;
        d r101 = (d) r100;
        if (this.f539718c == r101.f539718c) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f539716a, r101.f539716a) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.f539717b, r101.f539717b) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public d(String r100, byte[] r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "binaryData");
        this.f539716a = r100;
        this.f539717b = r101;
        this.f539718c = r102;
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f539719d = LazyKt.lazy(r103, new b(this));
        this.f539720e = LazyKt.lazy(r103, new c(this));
    }
}
