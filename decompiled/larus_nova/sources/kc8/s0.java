package kc8;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f502571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f502572b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (this.f502571a == r101.f502571a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502572b, r101.f502572b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f502571a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Bitmap r102 = this.f502572b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "RichMediaCreationVideoPlaybackSnapshot(progressMs=" + this.f502571a + ", coverBitmap=" + this.f502572b + ')';
    }

    public s0(long r100, Bitmap r101) {
        this.f502571a = r100;
        this.f502572b = r101;
    }
}
