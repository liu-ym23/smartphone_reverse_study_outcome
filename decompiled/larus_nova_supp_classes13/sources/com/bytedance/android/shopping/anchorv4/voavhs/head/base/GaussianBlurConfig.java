package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "Ljava/io/Serializable;", "radius", "", "fps", "maskColor", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getFps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaskColor", "()Ljava/lang/String;", "getRadius", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GaussianBlurConfig implements Serializable {

    @SerializedName("fps")
    private final Integer fps;

    @SerializedName("mask_color")
    private final String maskColor;

    @SerializedName("gaussian_blur_radius")
    private final Integer radius;

    public GaussianBlurConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GaussianBlurConfig copy$default(GaussianBlurConfig r0, Integer r1, Integer r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.radius;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.fps;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.maskColor;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.radius;
    }

    public final Integer component2() {
        return this.fps;
    }

    public final String component3() {
        return this.maskColor;
    }

    public final GaussianBlurConfig copy(Integer r2, Integer r3, String r4) {
        return new GaussianBlurConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof GaussianBlurConfig) == false) goto L12;
        GaussianBlurConfig r4 = (GaussianBlurConfig) r3;
        if (Intrinsics.areEqual(this.radius, r4.radius) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fps, r4.fps) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maskColor, r4.maskColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.radius;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.fps;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.maskColor;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "GaussianBlurConfig(radius=" + this.radius + ", fps=" + this.fps + ", maskColor=" + this.maskColor + ")";
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public GaussianBlurConfig(Integer r1, Integer r2, String r3) {
        this.radius = r1;
        this.fps = r2;
        this.maskColor = r3;
    }

    public /* synthetic */ GaussianBlurConfig(Integer r1, Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(30));
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 24;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "#80666666";
    L11:
        this(r1, r2, r3);
    }
}
