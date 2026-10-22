package kw5;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f506393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f506394b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f506393a, r101.f506393a) == true) goto L12;
        return false;
    L12:
        if (this.f506394b == r101.f506394b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f506393a) * 31) + this.f506394b;
    }

    public final String toString() {
        return "FlowAsrFileAudioData(data=" + Arrays.toString(this.f506393a) + ", dataSize=" + this.f506394b + ')';
    }

    public a(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f506393a = r100;
        this.f506394b = r101;
    }
}
