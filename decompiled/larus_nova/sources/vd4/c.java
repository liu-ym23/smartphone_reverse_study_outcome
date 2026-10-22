package vd4;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f554188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f554191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f554192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f554193f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f554188a, r101.f554188a) == true) goto L12;
        return false;
    L12:
        if (this.f554189b == r101.f554189b) goto L15;
        return false;
    L15:
        if (this.f554190c == r101.f554190c) goto L18;
        return false;
    L18:
        if (this.f554191d == r101.f554191d) goto L21;
        return false;
    L21:
        if (this.f554192e == r101.f554192e) goto L24;
        return false;
    L24:
        if (this.f554193f == r101.f554193f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f554188a.hashCode() * 31) + this.f554189b) * 31) + this.f554190c) * 31) + this.f554191d) * 31) + this.f554192e) * 31) + this.f554193f;
    }

    public final String toString() {
        return "ImageMeta(bitmap=" + this.f554188a + ", from=" + this.f554189b + ", fileSize=" + this.f554190c + ", memorySize=" + this.f554191d + ", resolutionWidth=" + this.f554192e + ", resolutionHeight=" + this.f554193f + ')';
    }

    public c(Bitmap r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f554188a = r100;
        this.f554189b = r101;
        this.f554190c = 0;
        this.f554191d = r102;
        this.f554192e = r103;
        this.f554193f = r104;
    }
}
