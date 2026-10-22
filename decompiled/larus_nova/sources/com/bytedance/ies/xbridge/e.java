package com.bytedance.ies.xbridge;

import androidx.camera.video.AudioStats;
import com.bytedance.ies.xbridge.annotation.DefaultType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultType f249466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f249467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f249468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f249469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f249470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f249471f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f249466a == r101.f249466a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f249467b, r101.f249467b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f249468c, r101.f249468c) == true) goto L18;
        return false;
    L18:
        if (this.f249469d == r101.f249469d) goto L21;
        return false;
    L21:
        if (this.f249470e == r101.f249470e) goto L24;
        return false;
    L24:
        if (this.f249471f == r101.f249471f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f249466a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f249467b);
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f249468c.hashCode()) * 31) + this.f249469d) * 31;
        if (this.f249470e == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f249471f;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "IDLDefaultValue(type=" + this.f249466a + ", doubleValue=" + this.f249467b + ", stringValue=" + this.f249468c + ", intValue=" + this.f249469d + ", boolValue=" + this.f249470e + ", longValue=" + this.f249471f + ')';
    }

    public e() {
        this(DefaultType.NONE, AudioStats.AUDIO_AMPLITUDE_NONE, "", 0, false, 0);
    }

    public final DefaultType getType() {
        return this.f249466a;
    }

    public e(DefaultType r100, double r101, String r102, int r103, boolean r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "stringValue");
        this.f249466a = r100;
        this.f249467b = r101;
        this.f249468c = r102;
        this.f249469d = r103;
        this.f249470e = r104;
        this.f249471f = r105;
    }
}
