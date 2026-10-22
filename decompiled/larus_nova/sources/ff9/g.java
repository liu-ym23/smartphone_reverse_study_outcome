package ff9;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f476690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f476692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f476693d;

    public final String toString() {
        return "FlowRTCAudioFrame(buffer=" + Arrays.toString(this.f476690a) + ", channel=" + this.f476691b + ", sampleRate=" + this.f476692c + ", extra=" + Arrays.toString(this.f476693d) + ')';
    }

    public final int hashCode() {
        int r100 = ((((Arrays.hashCode(this.f476690a) * 31) + this.f476691b) * 31) + this.f476692c) * 31;
        byte[] r101 = this.f476693d;
        if (r101 == null) goto L5;
        int r102 = Arrays.hashCode(r101);
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(g.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.im.internal.rtcsdk.service.FlowRTCAudioFrame");
        g r102 = (g) r100;
        if (Arrays.equals(this.f476690a, r102.f476690a) == true) goto L16;
        return false;
    L16:
        if (this.f476691b == r102.f476691b) goto L19;
        return false;
    L19:
        if (this.f476692c == r102.f476692c) goto L21;
        return false;
    L21:
        byte[] r103 = this.f476693d;
        if (r103 == null) goto L30;
        byte[] r104 = r102.f476693d;
        if (r104 != null) goto L27;
        return false;
    L27:
        if (Arrays.equals(r103, r104) == true) goto L32;
        return false;
    L32:
        return true;
    L30:
        if (r102.f476693d == null) goto L32;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public g(byte[] r100, int r101, int r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        this.f476690a = r100;
        this.f476691b = r101;
        this.f476692c = r102;
        this.f476693d = r103;
    }
}
