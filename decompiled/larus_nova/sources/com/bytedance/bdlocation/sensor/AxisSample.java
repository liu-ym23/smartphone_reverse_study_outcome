package com.bytedance.bdlocation.sensor;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/bdlocation/sensor/AxisSample;", "", "timestampMs", "", "x", "", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "(JFFF)V", "getTimestampMs", "()J", "getX", "()F", "getY", "getZ", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class AxisSample {
    private final long timestampMs;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f199922x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f199923y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final float f199924z;

    public static /* synthetic */ AxisSample copy$default(AxisSample r100, long r101, float r102, float r110, float r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.timestampMs;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f199922x;
    L8:
        float r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f199923y;
    L11:
        float r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.f199924z;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.timestampMs;
    }

    public final float component2() {
        return this.f199922x;
    }

    public final float component3() {
        return this.f199923y;
    }

    public final float component4() {
        return this.f199924z;
    }

    public final AxisSample copy(long r100, float r110, float r111, float r112) {
        return new AxisSample(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AxisSample) == false) goto L14;
        AxisSample r101 = (AxisSample) r100;
        if (this.timestampMs == r101.timestampMs) goto L8;
        return false;
    L8:
        if (Float.compare(this.f199922x, r101.f199922x) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f199923y, r101.f199923y) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f199924z, r101.f199924z) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r100 = this.timestampMs;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.f199922x)) * 31) + Float.floatToIntBits(this.f199923y)) * 31) + Float.floatToIntBits(this.f199924z);
    }

    public String toString() {
        return "AxisSample(timestampMs=" + this.timestampMs + ", x=" + this.f199922x + ", y=" + this.f199923y + ", z=" + this.f199924z + ")";
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final float getX() {
        return this.f199922x;
    }

    public final float getY() {
        return this.f199923y;
    }

    public final float getZ() {
        return this.f199924z;
    }

    public AxisSample(long r100, float r101, float r102, float r103) {
        this.timestampMs = r100;
        this.f199922x = r101;
        this.f199923y = r102;
        this.f199924z = r103;
    }
}
