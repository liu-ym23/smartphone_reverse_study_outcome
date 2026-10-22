package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BY\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fB;\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\rJ]\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0018J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\n\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", "medium", "large", "extraLarge", "largeIncreased", "extraLargeIncreased", "extraExtraLarge", "<init>", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraSmall", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getSmall", "getMedium", "getLarge", "getExtraLarge", "getLargeIncreased$material3", "getExtraLargeIncreased$material3", "getExtraExtraLarge$material3", "copy", "copy$material3", "defaultVerticalDragHandleShapesCached", "Landroidx/compose/material3/DragHandleShapes;", "getDefaultVerticalDragHandleShapesCached$material3", "()Landroidx/compose/material3/DragHandleShapes;", "setDefaultVerticalDragHandleShapesCached$material3", "(Landroidx/compose/material3/DragHandleShapes;)V", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Shapes {
    public static final int $stable = 0;
    private DragHandleShapes defaultVerticalDragHandleShapesCached;
    private final CornerBasedShape extraExtraLarge;
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraLargeIncreased;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape largeIncreased;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public int hashCode() {
        return (((((((((((((this.extraSmall.hashCode() * 31) + this.small.hashCode()) * 31) + this.medium.hashCode()) * 31) + this.large.hashCode()) * 31) + this.extraLarge.hashCode()) * 31) + this.largeIncreased.hashCode()) * 31) + this.extraLargeIncreased.hashCode()) * 31) + this.extraExtraLarge.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", largeIncreased=" + this.largeIncreased + ", extraLarge=" + this.extraLarge + ", extralargeIncreased=" + this.extraLargeIncreased + ", extraExtraLarge=" + this.extraExtraLarge + ')';
    }

    public final DragHandleShapes getDefaultVerticalDragHandleShapesCached$material3() {
        return this.defaultVerticalDragHandleShapesCached;
    }

    public final CornerBasedShape getExtraExtraLarge$material3() {
        return this.extraExtraLarge;
    }

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public final CornerBasedShape getExtraLargeIncreased$material3() {
        return this.extraLargeIncreased;
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public final CornerBasedShape getLargeIncreased$material3() {
        return this.largeIncreased;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Shapes) == true) goto L8;
        return false;
    L8:
        Shapes r6 = (Shapes) r5;
        if (Intrinsics.areEqual(this.extraSmall, r6.extraSmall) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.small, r6.small) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.medium, r6.medium) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.large, r6.large) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraLarge, r6.extraLarge) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.largeIncreased, r6.largeIncreased) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extraLargeIncreased, r6.extraLargeIncreased) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraExtraLarge, r6.extraExtraLarge) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final void setDefaultVerticalDragHandleShapesCached$material3(DragHandleShapes r1) {
        this.defaultVerticalDragHandleShapesCached = r1;
    }

    public Shapes(CornerBasedShape r11, CornerBasedShape r12, CornerBasedShape r13, CornerBasedShape r14, CornerBasedShape r15) {
        ShapeDefaults r0 = ShapeDefaults.INSTANCE;
        this(r11, r12, r13, r14, r15, r0.getLargeIncreased$material3(), r0.getExtraLargeIncreased$material3(), r0.getExtraExtraLarge$material3());
    }

    public final Shapes copy(CornerBasedShape r8, CornerBasedShape r9, CornerBasedShape r10, CornerBasedShape r11, CornerBasedShape r12) {
        return new Shapes(r8, r9, r10, r11, r12);
    }

    public /* synthetic */ Shapes(CornerBasedShape r4, CornerBasedShape r5, CornerBasedShape r6, CornerBasedShape r7, CornerBasedShape r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = ShapeDefaults.INSTANCE.getExtraSmall();
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = ShapeDefaults.INSTANCE.getSmall();
    L8:
        CornerBasedShape r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = ShapeDefaults.INSTANCE.getMedium();
    L11:
        CornerBasedShape r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = ShapeDefaults.INSTANCE.getLarge();
    L14:
        CornerBasedShape r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = ShapeDefaults.INSTANCE.getExtraLarge();
    L17:
        CornerBasedShape r12 = r4;
        this(r12, r11, r0, r1, r8);
    }

    public Shapes(CornerBasedShape r1, CornerBasedShape r2, CornerBasedShape r3, CornerBasedShape r4, CornerBasedShape r5, CornerBasedShape r6, CornerBasedShape r7, CornerBasedShape r8) {
        this.extraSmall = r1;
        this.small = r2;
        this.medium = r3;
        this.large = r4;
        this.extraLarge = r5;
        this.largeIncreased = r6;
        this.extraLargeIncreased = r7;
        this.extraExtraLarge = r8;
    }

    public static /* synthetic */ Shapes copy$default(Shapes r3, CornerBasedShape r4, CornerBasedShape r5, CornerBasedShape r6, CornerBasedShape r7, CornerBasedShape r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.extraSmall;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.small;
    L8:
        CornerBasedShape r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.medium;
    L11:
        CornerBasedShape r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.large;
    L14:
        CornerBasedShape r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.extraLarge;
    L17:
        CornerBasedShape r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Shapes copy$material3(CornerBasedShape r11, CornerBasedShape r12, CornerBasedShape r13, CornerBasedShape r14, CornerBasedShape r15, CornerBasedShape r16, CornerBasedShape r17, CornerBasedShape r18) {
        return new Shapes(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public /* synthetic */ Shapes(CornerBasedShape r9, CornerBasedShape r10, CornerBasedShape r11, CornerBasedShape r12, CornerBasedShape r13, CornerBasedShape r14, CornerBasedShape r15, CornerBasedShape r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        CornerBasedShape r1 = ShapeDefaults.INSTANCE.getExtraSmall();
    L7:
        if ((r17 & 2) == 0) goto L9;
        CornerBasedShape r2 = ShapeDefaults.INSTANCE.getSmall();
    L11:
        if ((r17 & 4) == 0) goto L13;
        CornerBasedShape r3 = ShapeDefaults.INSTANCE.getMedium();
    L15:
        if ((r17 & 8) == 0) goto L17;
        CornerBasedShape r4 = ShapeDefaults.INSTANCE.getLarge();
    L19:
        if ((r17 & 16) == 0) goto L21;
        CornerBasedShape r5 = ShapeDefaults.INSTANCE.getExtraLarge();
    L23:
        if ((r17 & 32) == 0) goto L25;
        CornerBasedShape r6 = ShapeDefaults.INSTANCE.getLargeIncreased$material3();
    L27:
        if ((r17 & 64) == 0) goto L29;
        CornerBasedShape r7 = ShapeDefaults.INSTANCE.getExtraLargeIncreased$material3();
    L31:
        if ((r17 & 128) == 0) goto L33;
        CornerBasedShape r0 = ShapeDefaults.INSTANCE.getExtraExtraLarge$material3();
    L34:
        this(r1, r2, r3, r4, r5, r6, r7, r0);
        return;
    L33:
        r0 = r16;
        goto L34
    L29:
        r7 = r15;
        goto L31
    L25:
        r6 = r14;
        goto L27
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public static /* synthetic */ Shapes copy$material3$default(Shapes r9, CornerBasedShape r10, CornerBasedShape r11, CornerBasedShape r12, CornerBasedShape r13, CornerBasedShape r14, CornerBasedShape r15, CornerBasedShape r16, CornerBasedShape r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        CornerBasedShape r2 = r9.extraSmall;
    L7:
        if ((r18 & 2) == 0) goto L9;
        CornerBasedShape r3 = r9.small;
    L11:
        if ((r18 & 4) == 0) goto L13;
        CornerBasedShape r4 = r9.medium;
    L15:
        if ((r18 & 8) == 0) goto L17;
        CornerBasedShape r5 = r9.large;
    L19:
        if ((r18 & 16) == 0) goto L21;
        CornerBasedShape r6 = r9.extraLarge;
    L23:
        if ((r18 & 32) == 0) goto L25;
        CornerBasedShape r7 = r9.largeIncreased;
    L27:
        if ((r18 & 64) == 0) goto L29;
        CornerBasedShape r8 = r9.extraLargeIncreased;
    L31:
        if ((r18 & 128) == 0) goto L33;
        CornerBasedShape r1 = r9.extraExtraLarge;
    L35:
        return r9.copy$material3(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
