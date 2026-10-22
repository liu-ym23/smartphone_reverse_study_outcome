package com.larus.camera.impl.edulibs.cameraapi.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ox8.d;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/idl/RotatedBox;", "Ljava/io/Serializable;", "center", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;", "width", "", "height", "theta", "<init>", "(Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getCenter", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "getTheta", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/camera/impl/edulibs/cameraapi/idl/Point;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/larus/camera/impl/edulibs/cameraapi/idl/RotatedBox;", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RotatedBox implements Serializable {

    @SerializedName("center")
    private final d center;

    @SerializedName("height")
    private final Double height;

    @SerializedName("theta")
    private final Double theta;

    @SerializedName("width")
    private final Double width;

    public RotatedBox() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RotatedBox copy$default(RotatedBox r100, d r101, Double r102, Double r103, Double r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.center;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.width;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.theta;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final d component1() {
        return this.center;
    }

    public final Double component2() {
        return this.width;
    }

    public final Double component3() {
        return this.height;
    }

    public final Double component4() {
        return this.theta;
    }

    public final RotatedBox copy(d r100, Double r101, Double r102, Double r103) {
        return new RotatedBox(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RotatedBox) == true) goto L8;
        return false;
    L8:
        RotatedBox r101 = (RotatedBox) r100;
        if (Intrinsics.areEqual(this.center, r101.center) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.theta, r101.theta) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        d r100 = this.center;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.width;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.height;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.theta;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RotatedBox(center=" + this.center + ", width=" + this.width + ", height=" + this.height + ", theta=" + this.theta + ')';
    }

    public final d getCenter() {
        return this.center;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getTheta() {
        return this.theta;
    }

    public final Double getWidth() {
        return this.width;
    }

    public RotatedBox(d r100, Double r101, Double r102, Double r103) {
        this.center = r100;
        this.width = r101;
        this.height = r102;
        this.theta = r103;
    }

    public /* synthetic */ RotatedBox(d r100, Double r101, Double r102, Double r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
