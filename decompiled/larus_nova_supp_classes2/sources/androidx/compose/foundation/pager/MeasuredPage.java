package androidx.compose.foundation.pager;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0003J\u0017\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J(\u00105\u001a\u00020\t*\u00020\t2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000307H\u0082\b¢\u0006\u0004\b8\u00109R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u000e\u0010&\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00102\u001a\u00020\u0003*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006:"}, d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "<init>", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getSize", "J", "getKey", "()Ljava/lang/Object;", "isVertical", "crossAxisSize", "getCrossAxisSize", "placeableOffsets", "", "value", "offset", "getOffset", "mainAxisLayoutSize", "position", "", "layoutWidth", "layoutHeight", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "applyScrollDelta", "delta", "getOffset-Bjo55l4", "(I)J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MeasuredPage implements PageInfo {
    public static final int $stable = 8;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int r1, int r2, List r3, long r4, Object r6, Orientation r7, Alignment.Horizontal r8, Alignment.Vertical r9, LayoutDirection r10, boolean r11, DefaultConstructorMarker r12) {
        this(r1, r2, r3, r4, r6, r7, r8, r9, r10, r11);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    public final int getSize() {
        return this.size;
    }

    private final int getMainAxisSize(Placeable r2) {
        if (this.isVertical == false) goto L6;
        return r2.getHeight();
    L6:
        return r2.getWidth();
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    private final long m1254getOffsetBjo55l4(int r7) {
        int[] r0 = this.placeableOffsets;
        int r8 = r7 * 2;
        int r1 = r0[r8];
        int r9 = r0[r8 + 1];
        return IntOffset.constructor-impl((((long) r1) << 32) | (((long) r9) & 4294967295L));
    }

    public final void applyScrollDelta(int r6) {
        this.offset = getOffset() + r6;
        int r0 = this.placeableOffsets.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        boolean r2 = this.isVertical;
        if (r2 == true) goto L7;
    L8:
        if (r2 == true) goto L12;
        if ((r1 % 2) != 0) goto L12;
    L11:
        int[] r3 = this.placeableOffsets;
        r3[r1] = r3[r1] + r6;
    L12:
        r1 = r1 + 1;
        goto L3
    L7:
        if ((r1 % 2) == 1) goto L11;
    }

    public final void place(Placeable.PlacementScope r13) {
        int r2 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        int r1 = this.placeables.size();
    L9:
        if (r2 >= r1) goto L26;
        Placeable r4 = (Placeable) ListProtector.get(this.placeables, r2);
        long r5 = m1254getOffsetBjo55l4(r2);
        if (this.reverseLayout == true) goto L13;
    L21:
        long r6 = IntOffset.plus-qkQi6aY(r5, this.visualOffset);
        if (this.isVertical == false) goto L24;
        Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(r13, r4, r6, MenuKt.ClosedAlphaTarget, null, 6, null);
    L25:
        r2 = r2 + 1;
        goto L9
    L24:
        Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(r13, r4, r6, MenuKt.ClosedAlphaTarget, null, 6, null);
        goto L25
    L13:
        if (this.isVertical == false) goto L15;
        int r3 = IntOffset.getX-impl(r5);
    L17:
        if (this.isVertical == false) goto L19;
        int r7 = IntOffset.getY-impl(r5);
        int r8 = (this.mainAxisLayoutSize - r7) - getMainAxisSize(r4);
    L20:
        r5 = IntOffset.constructor-impl((((long) r3) << 32) | (((long) r8) & 4294967295L));
        goto L21
    L19:
        r8 = IntOffset.getY-impl(r5);
        goto L20
    L15:
        int r9 = IntOffset.getX-impl(r5);
        r3 = (this.mainAxisLayoutSize - r9) - getMainAxisSize(r4);
        goto L17
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1253copy4Tuh3kE(long r5, Function1<? super Integer, Integer> r7) {
        if (this.isVertical == false) goto L5;
        int r0 = IntOffset.getX-impl(r5);
    L6:
        boolean r1 = this.isVertical;
        int r6 = IntOffset.getY-impl(r5);
        if (r1 == false) goto L10;
        r6 = ((Number) r7.invoke(Integer.valueOf(r6))).intValue();
    L10:
        return IntOffset.constructor-impl((((long) r0) << 32) | (((long) r6) & 4294967295L));
    L5:
        r0 = ((Number) r7.invoke(Integer.valueOf(IntOffset.getX-impl(r5)))).intValue();
        goto L6
    }

    public final void position(int r10, int r11, int r12) {
        this.offset = r10;
        if (this.isVertical == false) goto L5;
        int r0 = r12;
    L6:
        this.mainAxisLayoutSize = r0;
        List<Placeable> r1 = this.placeables;
        int r2 = r1.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L21;
        Placeable r4 = (Placeable) ListProtector.get(r1, r3);
        int r5 = r3 * 2;
        if (this.isVertical == false) goto L15;
        int[] r6 = this.placeableOffsets;
        Alignment.Horizontal r7 = this.horizontalAlignment;
        if (r7 == null) goto L13;
        r6[r5] = r7.align(r4.getWidth(), r11, this.layoutDirection);
        this.placeableOffsets[r5 + 1] = r10;
        int r8 = r4.getHeight();
    L18:
        r10 = r10 + r8;
        r3 = r3 + 1;
        goto L7
    L13:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment");
        throw new KotlinNothingValueException();
    L15:
        int[] r9 = this.placeableOffsets;
        r9[r5] = r10;
        int r13 = r5 + 1;
        Alignment.Vertical r14 = this.verticalAlignment;
        if (r14 == null) goto L19;
        r9[r13] = r14.align(r4.getHeight(), r12);
        r8 = r4.getWidth();
        goto L18
    L19:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment");
        throw new KotlinNothingValueException();
    L21:
        return;
    L5:
        r0 = r11;
        goto L6
    }

    private MeasuredPage(int r1, int r2, List<? extends Placeable> r3, long r4, Object r6, Orientation r7, Alignment.Horizontal r8, Alignment.Vertical r9, LayoutDirection r10, boolean r11) {
        this.index = r1;
        this.size = r2;
        this.placeables = r3;
        this.visualOffset = r4;
        this.key = r6;
        this.horizontalAlignment = r8;
        this.verticalAlignment = r9;
        this.layoutDirection = r10;
        this.reverseLayout = r11;
        int r5 = 0;
        if (r7 != Orientation.Vertical) goto L5;
        boolean r12 = true;
    L6:
        this.isVertical = r12;
        int r13 = r3.size();
        int r14 = 0;
    L7:
        if (r5 >= r13) goto L13;
        Placeable r15 = (Placeable) ListProtector.get(r3, r5);
        if (this.isVertical == true) goto L11;
        int r16 = r15.getHeight();
    L12:
        r14 = Math.max(r14, r16);
        r5 = r5 + 1;
        goto L7
    L11:
        r16 = r15.getWidth();
        goto L12
    L13:
        this.crossAxisSize = r14;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = RtlSpacingHelper.UNDEFINED;
        return;
    L5:
        r12 = false;
        goto L6
    }
}
