package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;", "Ljava/io/Serializable;", "x", "", "y", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getX", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getY", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShadowOffset implements Serializable {

    @SerializedName("x")
    private final Double x;

    @SerializedName("y")
    private final Double y;

    public ShadowOffset() {
        Double r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ShadowOffset copy$default(ShadowOffset r0, Double r1, Double r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.x;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.y;
    L9:
        return r0.copy(r1, r2);
    }

    public final Double component1() {
        return this.x;
    }

    public final Double component2() {
        return this.y;
    }

    public final ShadowOffset copy(Double r2, Double r3) {
        return new ShadowOffset(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShadowOffset) == false) goto L10;
        ShadowOffset r4 = (ShadowOffset) r3;
        if (Intrinsics.areEqual(this.x, r4.x) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.y, r4.y) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Double r0 = this.x;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.y;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ShadowOffset(x=" + this.x + ", y=" + this.y + ")";
    }

    public final Double getX() {
        return this.x;
    }

    public final Double getY() {
        return this.y;
    }

    public ShadowOffset(Double r1, Double r2) {
        this.x = r1;
        this.y = r2;
    }

    public /* synthetic */ ShadowOffset(Double r2, Double r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
