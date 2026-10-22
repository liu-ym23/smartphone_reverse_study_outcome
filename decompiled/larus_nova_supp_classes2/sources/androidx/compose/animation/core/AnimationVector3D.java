package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0000H\u0010¢\u0006\u0002\b\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0090\u0002¢\u0006\u0002\b\u0019J\u001e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u001bJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u0018H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0014\u0010\u001c\u001a\u00020\u0018X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Landroidx/compose/animation/core/AnimationVector3D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "<init>", "(FFF)V", "value", "getV1", "()F", "setV1$animation_core", "(F)V", "getV2", "setV2$animation_core", "getV3", "setV3$animation_core", "reset", "", "reset$animation_core", "newVector", "newVector$animation_core", "get", "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationVector3D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;
    private float v1;
    private float v2;
    private float v3;

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core() {
        this.v1 = MenuKt.ClosedAlphaTarget;
        this.v2 = MenuKt.ClosedAlphaTarget;
        this.v3 = MenuKt.ClosedAlphaTarget;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.v1) * 31) + Float.floatToIntBits(this.v2)) * 31) + Float.floatToIntBits(this.v3);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public AnimationVector3D newVector$animation_core() {
        return new AnimationVector3D(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.v1 + ", v2 = " + this.v2 + ", v3 = " + this.v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core() {
        return this.size;
    }

    public final float getV1() {
        return this.v1;
    }

    public final float getV2() {
        return this.v2;
    }

    public final float getV3() {
        return this.v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public /* bridge */ /* synthetic */ AnimationVector newVector$animation_core() {
        return newVector$animation_core();
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof AnimationVector3D) == false) goto L21;
        AnimationVector3D r6 = (AnimationVector3D) r5;
        if (r6.v1 != this.v1) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (r6.v2 != this.v2) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        if (r6.v3 != this.v3) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L24;
        return true;
    L24:
        return false;
    L17:
        r7 = false;
        goto L18
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
        goto L8
    L21:
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core(int r2) {
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L13;
        return MenuKt.ClosedAlphaTarget;
    L13:
        return this.v3;
    L14:
        return this.v2;
    L11:
        return this.v1;
    }

    public final void setV1$animation_core(float r1) {
        this.v1 = r1;
    }

    public final void setV2$animation_core(float r1) {
        this.v2 = r1;
    }

    public final void setV3$animation_core(float r1) {
        this.v3 = r1;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core(int r2, float r3) {
        if (r2 != 0) goto L4;
        this.v1 = r3;
        return;
    L4:
        if (r2 != 1) goto L6;
        this.v2 = r3;
        return;
    L6:
        if (r2 != 2) goto L14;
        this.v3 = r3;
        return;
    }

    public AnimationVector3D(float r2, float r3, float r4) {
        super(null);
        this.v1 = r2;
        this.v2 = r3;
        this.v3 = r4;
        this.size = 3;
    }
}
