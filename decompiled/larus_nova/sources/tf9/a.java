package tf9;

import com.larus.im.service.audio.vlm.EncodedVideoCodecType;
import com.larus.im.service.audio.vlm.EncodedVideoFrameType;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f545767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f545768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f545769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f545770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f545771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f545772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EncodedVideoCodecType f545773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final EncodedVideoFrameType f545774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f545775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f545776j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f545767a, r101.f545767a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545768b, r101.f545768b) == true) goto L15;
        return false;
    L15:
        if (this.f545769c == r101.f545769c) goto L18;
        return false;
    L18:
        if (this.f545770d == r101.f545770d) goto L21;
        return false;
    L21:
        if (this.f545771e == r101.f545771e) goto L24;
        return false;
    L24:
        if (this.f545772f == r101.f545772f) goto L27;
        return false;
    L27:
        if (this.f545773g == r101.f545773g) goto L30;
        return false;
    L30:
        if (this.f545774h == r101.f545774h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f545775i, r101.f545775i) == true) goto L36;
        return false;
    L36:
        if (this.f545776j == r101.f545776j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((Arrays.hashCode(this.f545767a) * 31) + Arrays.hashCode(this.f545768b)) * 31;
        long r101 = this.f545769c;
        int r102 = (((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f545770d) * 31) + this.f545771e) * 31) + this.f545772f) * 31) + this.f545773g.hashCode()) * 31) + this.f545774h.hashCode()) * 31;
        byte[] r103 = this.f545775i;
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r102 + r104) * 31;
        long r106 = this.f545776j;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r104 = Arrays.hashCode(r103);
        goto L6
    }

    public final String toString() {
        return "EncodedVideoFrameParam(data=" + Arrays.toString(this.f545767a) + ", codecConfig=" + Arrays.toString(this.f545768b) + ", timestampUs=" + this.f545769c + ", width=" + this.f545770d + ", height=" + this.f545771e + ", rotation=" + this.f545772f + ", codecType=" + this.f545773g + ", frameType=" + this.f545774h + ", seiData=" + Arrays.toString(this.f545775i) + ", frameId=" + this.f545776j + ')';
    }

    public a(byte[] r100, byte[] r101, long r102, int r103, int r104, int r105, EncodedVideoCodecType r106, EncodedVideoFrameType r110, byte[] r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = new byte[0];
    L6:
        if ((r112 & 256) == 0) goto L8;
        r111 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "codecConfig");
        Intrinsics.checkNotNullParameter(r106, "codecType");
        Intrinsics.checkNotNullParameter(r110, "frameType");
        this.f545767a = r100;
        this.f545768b = r101;
        this.f545769c = r102;
        this.f545770d = r103;
        this.f545771e = r104;
        this.f545772f = r105;
        this.f545773g = r106;
        this.f545774h = r110;
        this.f545775i = r111;
        this.f545776j = 0;
    }
}
