package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/Shapes;", "", "small", "Landroidx/compose/foundation/shape/CornerBasedShape;", "medium", "large", "<init>", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getSmall", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getMedium", "getLarge", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Shapes {
    public static final int $stable = 0;
    private final CornerBasedShape large;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this(null, null, null, 7, null);
    }

    public int hashCode() {
        return (((this.small.hashCode() * 31) + this.medium.hashCode()) * 31) + this.large.hashCode();
    }

    public String toString() {
        return "Shapes(small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ')';
    }

    public final CornerBasedShape getLarge() {
        return this.large;
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
        if (Intrinsics.areEqual(this.small, r6.small) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.medium, r6.medium) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.large, r6.large) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public Shapes(CornerBasedShape r1, CornerBasedShape r2, CornerBasedShape r3) {
        this.small = r1;
        this.medium = r2;
        this.large = r3;
    }

    public final Shapes copy(CornerBasedShape r2, CornerBasedShape r3, CornerBasedShape r4) {
        return new Shapes(r2, r3, r4);
    }

    public /* synthetic */ Shapes(CornerBasedShape r2, CornerBasedShape r3, CornerBasedShape r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = RoundedCornerShapeKt.m1334RoundedCornerShape0680j_4(Dp.constructor-impl(4));
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = RoundedCornerShapeKt.m1334RoundedCornerShape0680j_4(Dp.constructor-impl(4));
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = RoundedCornerShapeKt.m1334RoundedCornerShape0680j_4(Dp.constructor-impl(0));
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ Shapes copy$default(Shapes r0, CornerBasedShape r1, CornerBasedShape r2, CornerBasedShape r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.small;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.medium;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.large;
    L12:
        return r0.copy(r1, r2, r3);
    }
}
