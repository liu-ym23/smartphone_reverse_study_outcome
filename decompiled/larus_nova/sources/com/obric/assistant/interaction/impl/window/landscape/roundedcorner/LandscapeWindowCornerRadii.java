package com.obric.assistant.interaction.impl.window.landscape.roundedcorner;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "<init>", "(FFFF)V", "getTopLeft", "()F", "getTopRight", "getBottomRight", "getBottomLeft", "hasRoundedCorner", "", "getHasRoundedCorner$impl_mainlandRelease", "()Z", "sanitized", "sanitized$impl_mainlandRelease", "maxWith", "other", "maxWith$impl_mainlandRelease", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeWindowCornerRadii {
    public static final Companion Companion = null;
    private static final LandscapeWindowCornerRadii ZERO = null;
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii$Companion;", "", "<init>", "()V", "ZERO", "Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "getZERO$impl_mainlandRelease", "()Lcom/obric/assistant/interaction/impl/window/landscape/roundedcorner/LandscapeWindowCornerRadii;", "uniform", "radiusPx", "", "uniform$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LandscapeWindowCornerRadii getZERO$impl_mainlandRelease() {
            return LandscapeWindowCornerRadii.access$getZERO$cp();
        }

        public final LandscapeWindowCornerRadii uniform$impl_mainlandRelease(float r100) {
            return new LandscapeWindowCornerRadii(r100, r100, r100, r100).sanitized$impl_mainlandRelease();
        }
    }

    public static /* synthetic */ LandscapeWindowCornerRadii copy$default(LandscapeWindowCornerRadii r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.topLeft;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.topRight;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bottomRight;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottomLeft;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final float component1() {
        return this.topLeft;
    }

    public final float component2() {
        return this.topRight;
    }

    public final float component3() {
        return this.bottomRight;
    }

    public final float component4() {
        return this.bottomLeft;
    }

    public final LandscapeWindowCornerRadii copy(float r100, float r101, float r102, float r103) {
        return new LandscapeWindowCornerRadii(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LandscapeWindowCornerRadii) == true) goto L8;
        return false;
    L8:
        LandscapeWindowCornerRadii r101 = (LandscapeWindowCornerRadii) r100;
        if (Float.compare(this.topLeft, r101.topLeft) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.topRight, r101.topRight) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.bottomRight, r101.bottomRight) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.bottomLeft, r101.bottomLeft) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.topLeft) * 31) + Float.floatToIntBits(this.topRight)) * 31) + Float.floatToIntBits(this.bottomRight)) * 31) + Float.floatToIntBits(this.bottomLeft);
    }

    public String toString() {
        return "LandscapeWindowCornerRadii(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ')';
    }

    static {
        Companion = new Companion(null);
        ZERO = new LandscapeWindowCornerRadii(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final boolean getHasRoundedCorner$impl_mainlandRelease() {
        if (this.topLeft <= 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.topRight > 0.0f) goto L12;
        if (this.bottomRight > 0.0f) goto L12;
        if (this.bottomLeft > 0.0f) goto L12;
        return false;
    }

    public final LandscapeWindowCornerRadii sanitized$impl_mainlandRelease() {
        return new LandscapeWindowCornerRadii(RangesKt.coerceAtLeast(this.topLeft, 0.0f), RangesKt.coerceAtLeast(this.topRight, 0.0f), RangesKt.coerceAtLeast(this.bottomRight, 0.0f), RangesKt.coerceAtLeast(this.bottomLeft, 0.0f));
    }

    public static final /* synthetic */ LandscapeWindowCornerRadii access$getZERO$cp() {
        return ZERO;
    }

    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    public final float getBottomRight() {
        return this.bottomRight;
    }

    public final float getTopLeft() {
        return this.topLeft;
    }

    public final float getTopRight() {
        return this.topRight;
    }

    public final LandscapeWindowCornerRadii maxWith$impl_mainlandRelease(LandscapeWindowCornerRadii r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return new LandscapeWindowCornerRadii(Math.max(this.topLeft, r100.topLeft), Math.max(this.topRight, r100.topRight), Math.max(this.bottomRight, r100.bottomRight), Math.max(this.bottomLeft, r100.bottomLeft)).sanitized$impl_mainlandRelease();
    }

    public LandscapeWindowCornerRadii(float r100, float r101, float r102, float r103) {
        this.topLeft = r100;
        this.topRight = r101;
        this.bottomRight = r102;
        this.bottomLeft = r103;
    }
}
