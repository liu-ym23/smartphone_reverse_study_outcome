package f3;

import androidx.camera.video.AudioStats;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultType f475315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f475316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f475317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f475318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f475319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f475320f;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f475315a == r101.f475315a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f475316b, r101.f475316b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475317c, r101.f475317c) == true) goto L18;
        return false;
    L18:
        if (this.f475318d == r101.f475318d) goto L21;
        return false;
    L21:
        if (this.f475319e == r101.f475319e) goto L24;
        return false;
    L24:
        if (this.f475320f == r101.f475320f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f475315a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f475316b);
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f475317c.hashCode()) * 31) + this.f475318d) * 31;
        if (this.f475319e == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f475320f;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "DefaultValue(type=" + this.f475315a + ", doubleValue=" + this.f475316b + ", stringValue=" + this.f475317c + ", intValue=" + this.f475318d + ", boolValue=" + this.f475319e + ", longValue=" + this.f475320f + ')';
    }

    public final DefaultType getType() {
        return this.f475315a;
    }

    public /* synthetic */ j(int r110) {
        this(DefaultType.NONE, AudioStats.AUDIO_AMPLITUDE_NONE, "", 0, false, 0);
    }

    public j(DefaultType r100, double r101, String r102, int r103, boolean r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "stringValue");
        this.f475315a = r100;
        this.f475316b = r101;
        this.f475317c = r102;
        this.f475318d = r103;
        this.f475319e = r104;
        this.f475320f = r105;
    }
}
