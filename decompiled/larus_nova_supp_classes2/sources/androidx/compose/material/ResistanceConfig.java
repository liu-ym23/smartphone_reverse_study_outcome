package androidx.compose.material;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ResistanceConfig;", "", "basis", "", "factorAtMin", "factorAtMax", "<init>", "(FFF)V", "getBasis", "()F", "getFactorAtMin", "getFactorAtMax", "computeResistance", "overflow", "equals", "", "other", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ResistanceConfig {
    public static final int $stable = 0;
    private final float basis;
    private final float factorAtMax;
    private final float factorAtMin;

    public int hashCode() {
        return (((Float.floatToIntBits(this.basis) * 31) + Float.floatToIntBits(this.factorAtMin)) * 31) + Float.floatToIntBits(this.factorAtMax);
    }

    public String toString() {
        return "ResistanceConfig(basis=" + this.basis + ", factorAtMin=" + this.factorAtMin + ", factorAtMax=" + this.factorAtMax + ')';
    }

    public final float getBasis() {
        return this.basis;
    }

    public final float getFactorAtMax() {
        return this.factorAtMax;
    }

    public final float getFactorAtMin() {
        return this.factorAtMin;
    }

    public final float computeResistance(float r5) {
        if (r5 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L5;
        float r1 = this.factorAtMin;
    L7:
        if (r1 != androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L12:
        float r0 = this.basis;
        float r6 = r5 / r0;
        if (r6 >= (-1.0f)) goto L16;
        r6 = -1.0f;
    L16:
        if (r6 <= 1.0f) goto L19;
        r6 = 1.0f;
    L19:
        return (r0 / r1) * ((float) Math.sin((r6 * 3.1415927f) / 2));
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = this.factorAtMax;
        goto L7
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResistanceConfig) == true) goto L8;
        return false;
    L8:
        ResistanceConfig r6 = (ResistanceConfig) r5;
        if (this.basis != r6.basis) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L15;
        return false;
    L15:
        if (this.factorAtMin != r6.factorAtMin) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L21;
        return false;
    L21:
        if (this.factorAtMax != r6.factorAtMax) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == true) goto L26;
        return false;
    L26:
        return true;
    L23:
        r7 = false;
        goto L24
    L17:
        r2 = false;
        goto L18
    L11:
        r1 = false;
        goto L12
    }

    public ResistanceConfig(float r1, float r2, float r3) {
        this.basis = r1;
        this.factorAtMin = r2;
        this.factorAtMax = r3;
    }

    public /* synthetic */ ResistanceConfig(float r2, float r3, float r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 10.0f;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 10.0f;
    L8:
        this(r2, r3, r4);
    }
}
