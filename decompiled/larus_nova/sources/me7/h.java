package me7;

import androidx.camera.video.AudioStats;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultType f513531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f513532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f513533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f513534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f513535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f513536f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f513531a == r101.f513531a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f513532b, r101.f513532b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513533c, r101.f513533c) == true) goto L18;
        return false;
    L18:
        if (this.f513534d == r101.f513534d) goto L21;
        return false;
    L21:
        if (this.f513535e == r101.f513535e) goto L24;
        return false;
    L24:
        if (this.f513536f == r101.f513536f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f513531a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f513532b);
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f513533c.hashCode()) * 31) + this.f513534d) * 31;
        if (this.f513535e == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f513536f;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "IDLDefaultValue(type=" + this.f513531a + ", doubleValue=" + this.f513532b + ", stringValue=" + this.f513533c + ", intValue=" + this.f513534d + ", boolValue=" + this.f513535e + ", longValue=" + this.f513536f + ')';
    }

    public h() {
        this(DefaultType.NONE, AudioStats.AUDIO_AMPLITUDE_NONE, "", 0, false, 0);
    }

    public final DefaultType getType() {
        return this.f513531a;
    }

    public h(DefaultType r100, double r101, String r102, int r103, boolean r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "stringValue");
        this.f513531a = r100;
        this.f513532b = r101;
        this.f513533c = r102;
        this.f513534d = r103;
        this.f513535e = r104;
        this.f513536f = r105;
    }
}
