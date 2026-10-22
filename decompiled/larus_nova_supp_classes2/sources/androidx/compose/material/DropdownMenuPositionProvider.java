package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001e\u0010\rJ\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u001b\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J@\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2 = {"Landroidx/compose/material/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "", "<init>", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "copy", "copy-rOJDEFc", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;)Landroidx/compose/material/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final long contentOffset;
    private final Density density;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ DropdownMenuPositionProvider(long r1, Density r3, Function2 r4, DefaultConstructorMarker r5) {
        this(r1, r3, r4);
    }

    public static /* synthetic */ Unit a(IntRect r0, IntRect r1) {
        return _init_$lambda$0(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-rOJDEFc$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m2050copyrOJDEFc$default(DropdownMenuPositionProvider r0, long r1, Density r3, Function2 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.contentOffset;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.density;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.onPositionCalculated;
    L12:
        return r0.m2053copyrOJDEFc(r1, r3, r4);
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name */
    public final long m2052component1RKDOV3M() {
        return this.contentOffset;
    }

    public final Density component2() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    /* JADX INFO: renamed from: copy-rOJDEFc, reason: not valid java name */
    public final DropdownMenuPositionProvider m2053copyrOJDEFc(long r8, Density r10, Function2<? super IntRect, ? super IntRect, Unit> r11) {
        return new DropdownMenuPositionProvider(r8, r10, r11, null);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DropdownMenuPositionProvider) == true) goto L8;
        return false;
    L8:
        DropdownMenuPositionProvider r9 = (DropdownMenuPositionProvider) r8;
        if (DpOffset.equals-impl0(this.contentOffset, r9.contentOffset) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.density, r9.density) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onPositionCalculated, r9.onPositionCalculated) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((DpOffset.hashCode-impl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + DpOffset.toString-impl(this.contentOffset) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m2054getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    private static final Unit _init_$lambda$0(IntRect r0, IntRect r1) {
        return Unit.INSTANCE;
    }

    private DropdownMenuPositionProvider(long r1, Density r3, Function2<? super IntRect, ? super IntRect, Unit> r4) {
        this.contentOffset = r1;
        this.density = r3;
        this.onPositionCalculated = r4;
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long m2051calculatePositionllwVHH4(IntRect r19, long r20, LayoutDirection r22, long r23) {
        int r2 = this.density.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        int r3 = this.density.roundToPx-0680j_4(DpOffset.getX-D9Ej5fM(this.contentOffset));
        LayoutDirection r4 = LayoutDirection.Ltr;
        if (r22 != r4) goto L5;
        int r6 = 1;
    L6:
        int r5 = r3 * r6;
        int r7 = this.density.roundToPx-0680j_4(DpOffset.getY-D9Ej5fM(this.contentOffset));
        int r8 = r19.getLeft() + r5;
        int r11 = (int) (r23 >> 32);
        int r9 = (r19.getRight() - r11) + r5;
        int r10 = (int) (r20 >> 32);
        int r12 = r10 - r11;
        if (r22 != r4) goto L13;
        Integer[] r1 = new Integer[3];
        r1[0] = Integer.valueOf(r8);
        r1[1] = Integer.valueOf(r9);
        if (r19.getLeft() >= 0) goto L12;
        r12 = 0;
    L12:
        r1[2] = Integer.valueOf(r12);
        Sequence r13 = SequencesKt.sequenceOf(r1);
    L17:
        Iterator r14 = r13.iterator();
    L19:
        if (r14.hasNext() == false) goto L28;
        Object r15 = r14.next();
        int r16 = ((Number) r15).intValue();
        if (r16 >= 0) goto L23;
    L25:
        boolean r17 = false;
    L26:
        if (r17 == false) goto L19;
    L29:
        Integer r18 = (Integer) r15;
        if (r18 == null) goto L32;
        r9 = r18.intValue();
    L32:
        int r21 = Math.max(r19.getBottom() + r7, r2);
        int r110 = (int) (r23 & 4294967295L);
        int r24 = (r19.getTop() - r110) + r7;
        int r25 = (r19.getTop() - (r110 / 2)) + r7;
        int r26 = r9;
        int r27 = (int) (r20 & 4294967295L);
        Iterator r28 = SequencesKt.sequenceOf(new Integer[]{Integer.valueOf(r21), Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf((r27 - r110) - r2)}).iterator();
    L34:
        if (r28.hasNext() == false) goto L43;
        Object r29 = r28.next();
        int r30 = ((Number) r29).intValue();
        if (r30 >= r2) goto L38;
    L40:
        boolean r31 = false;
    L41:
        if (r31 == false) goto L34;
        Object r32 = r29;
    L44:
        Integer r33 = (Integer) r32;
        if (r33 == null) goto L47;
        r24 = r33.intValue();
    L47:
        this.onPositionCalculated.invoke(r19, new IntRect(r26, r24, r26 + r11, r110 + r24));
        return IntOffset.constructor-impl((((long) r26) << 32) | (((long) r24) & 4294967295L));
    L38:
        if ((r30 + r110) > (r27 - r2)) goto L40;
        r31 = true;
        goto L41
    L43:
        r32 = null;
        goto L44
    L23:
        if ((r16 + r11) > r10) goto L25;
        r17 = true;
        goto L26
    L28:
        r15 = null;
        goto L29
    L13:
        Integer[] r34 = new Integer[3];
        r34[0] = Integer.valueOf(r9);
        r34[1] = Integer.valueOf(r8);
        if (r19.getRight() > r10) goto L16;
        r12 = 0;
    L16:
        r34[2] = Integer.valueOf(r12);
        r13 = SequencesKt.sequenceOf(r34);
        goto L17
    L5:
        r6 = -1;
        goto L6
    }

    public /* synthetic */ DropdownMenuPositionProvider(long r7, Density r9, Function2 r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 4) == 0) goto L5;
        r10 = new q4();
    L5:
        this(r7, r9, r10, null);
    }
}
