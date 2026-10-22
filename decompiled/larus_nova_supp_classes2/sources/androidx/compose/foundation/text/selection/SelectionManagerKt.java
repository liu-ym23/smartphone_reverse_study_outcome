package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0002\u001a*\u0010\t\u001a\u00020\u00052\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\f\u0010\u001c\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\u001b\u0010\u001d\u001a\u00020\u001e*\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0010H\u0000¢\u0006\u0004\b \u0010!\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"merge", "Landroidx/compose/foundation/text/selection/Selection;", "lhs", "rhs", "invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "firstAndLast", "", "T", "getSelectedRegionRect", "selectableSubSelectionPairs", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/selection/Selectable;", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getMagnifierCenter", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getMagnifierCenter-JVtK1S4", "(Landroidx/compose/foundation/text/selection/SelectionManager;JLandroidx/compose/foundation/text/selection/Selection$AnchorInfo;)J", "visibleBounds", "containsInclusive", "", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionManagerKt {
    private static final Rect invertedInfiniteRect = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Handle.values().length];
            r0[Handle.SelectionStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Handle.SelectionEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Handle.Cursor.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }

    public static final /* synthetic */ Rect access$getInvertedInfiniteRect$p() {
        return invertedInfiniteRect;
    }

    public static final /* synthetic */ List access$firstAndLast(List r0) {
        return firstAndLast(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> firstAndLast(List<? extends T> r4) {
        int r0 = r4.size();
        if (r0 != 0) goto L5;
        return r4;
    L5:
        if (r0 != 1) goto L7;
        return r4;
    L7:
        return CollectionsKt.listOf(new Object[]{CollectionsKt.first(r4), CollectionsKt.last(r4)});
    }

    public static final Rect visibleBounds(LayoutCoordinates r5) {
        Rect r0 = LayoutCoordinatesKt.boundsInWindow(r5);
        return RectKt.Rect-0a9Yr6o(r5.windowToLocal-MK-Hz9U(r0.getTopLeft-F1C5BW0()), r5.windowToLocal-MK-Hz9U(r0.getBottomRight-F1C5BW0()));
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m1877calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager r4, long r5) {
        Selection r0 = r4.getSelection();
        if (r0 == null) goto L5;
        Handle r1 = r4.getDraggingHandle();
        if (r1 != null) goto L9;
        int r2 = -1;
    L10:
        if (r2 == (-1)) goto L25;
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L26;
        if (r2 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    L26:
        return m1879getMagnifierCenterJVtK1S4(r4, r5, r0.getEnd());
    L23:
        return m1879getMagnifierCenterJVtK1S4(r4, r5, r0.getStart());
    L25:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L9:
        r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        goto L10
    L5:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m1878containsInclusiveUv8p0NA(Rect r5, long r6) {
        float r0 = r5.getLeft();
        float r1 = r5.getRight();
        float r2 = Float.intBitsToFloat((int) (r6 >> 32));
        if (r0 <= r2) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L17;
        float r4 = r5.getTop();
        float r7 = r5.getBottom();
        float r8 = Float.intBitsToFloat((int) (r6 & 4294967295L));
        if (r4 <= r8) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
        return true;
    L12:
        if (r8 > r7) goto L14;
        r9 = true;
    L17:
        return false;
    L5:
        if (r2 > r1) goto L7;
        r3 = true;
        goto L8
    }

    public static final Rect getSelectedRegionRect(List<? extends Pair<? extends Selectable, Selection>> r18, LayoutCoordinates r19) {
        List<? extends Pair<? extends Selectable, Selection>> r0 = r18;
        if (r18.isEmpty() == true) goto L5;
        Rect r2 = invertedInfiniteRect;
        float r3 = r2.component1();
        float r4 = r2.component2();
        float r5 = r2.component3();
        float r6 = r2.component4();
        int r7 = r0.size();
        char r8 = 0;
        int r9 = 0;
    L7:
        if (r9 >= r7) goto L24;
        Pair r10 = (Pair) ListProtector.get(r0, r9);
        Selectable r11 = (Selectable) r10.component1();
        Selection r12 = (Selection) r10.component2();
        int r13 = r12.getStart().getOffset();
        int r14 = r12.getEnd().getOffset();
        if (r13 == r14) goto L21;
        LayoutCoordinates r15 = r11.getLayoutCoordinates();
        if (r15 == null) goto L21;
        int r16 = Math.min(r13, r14);
        int r17 = Math.max(r13, r14) - 1;
        if (r16 != r17) goto L16;
        int[] r20 = new int[1];
        r20[r8] = r16;
    L17:
        Rect r110 = invertedInfiniteRect;
        float r111 = r110.component1();
        float r112 = r110.component2();
        float r113 = r110.component3();
        float r114 = r110.component4();
        int r21 = r20.length;
        int r1 = 0;
    L18:
        if (r1 >= r21) goto L20;
        int r115 = r7;
        Rect r22 = r11.getBoundingBox(r20[r1]);
        r111 = Math.min(r111, r22.getLeft());
        r112 = Math.min(r112, r22.getTop());
        r113 = Math.max(r113, r22.getRight());
        r114 = Math.max(r114, r22.getBottom());
        r1 = r1 + 1;
        r7 = r115;
        r21 = r21;
        goto L18
    L20:
        int r116 = r7;
        long r23 = Offset.constructor-impl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(r112)) & 4294967295L));
        long r24 = Float.floatToRawIntBits(r113);
        float r117 = r4;
        long r25 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r114)) & 4294967295L) | (r24 << 32));
        long r26 = r19.localPositionOf-R5De75A(r15, r23);
        long r27 = r19.localPositionOf-R5De75A(r15, r25);
        r3 = Math.min(r3, Float.intBitsToFloat((int) (r26 >> 32)));
        float r28 = Math.min(r117, Float.intBitsToFloat((int) (r26 & 4294967295L)));
        float r29 = Math.max(r5, Float.intBitsToFloat((int) (r27 >> 32)));
        r6 = Math.max(r6, Float.intBitsToFloat((int) (r27 & 4294967295L)));
        r5 = r29;
        r4 = r28;
    L22:
        r9 = r9 + 1;
        r0 = r18;
        r7 = r116;
        r8 = 0;
        goto L7
    L16:
        int[] r118 = new int[2];
        r118[r8] = r16;
        r118[1] = r17;
        r20 = r118;
    L21:
        r116 = r7;
        r4 = r4;
        r5 = r5;
        goto L22
    L24:
        return new Rect(r3, r4, r5, r6);
    L5:
        return invertedInfiniteRect;
    }

    public static final Selection merge(Selection r0, Selection r1) {
        if (r0 == null) goto L8;
        Selection r2 = r0.merge(r1);
        if (r2 != null) goto L7;
        return r1;
    L7:
        return r2;
    L8:
        return r1;
    }

    /* JADX INFO: renamed from: getMagnifierCenter-JVtK1S4, reason: not valid java name */
    private static final long m1879getMagnifierCenterJVtK1S4(SelectionManager r10, long r11, Selection.AnchorInfo r13) {
        Selectable r0 = r10.getAnchorSelectable$foundation_release(r13);
        if (r0 == null) goto L5;
        LayoutCoordinates r1 = r10.getContainerLayoutCoordinates();
        if (r1 == null) goto L9;
        LayoutCoordinates r2 = r0.getLayoutCoordinates();
        if (r2 == null) goto L13;
        int r14 = r13.getOffset();
        if (r14 > r0.getLastVisibleOffset()) goto L17;
        Offset r12 = r10.m1866getCurrentDragPosition_m7T9E();
        Intrinsics.checkNotNull(r12);
        float r3 = Float.intBitsToFloat((int) (r2.localPositionOf-R5De75A(r1, r12.unbox-impl()) >> 32));
        long r4 = r0.mo1831getRangeOfLineContainingjx7JFs(r14);
        boolean r7 = true;
        if (TextRange.getCollapsed-impl(r4) == false) goto L21;
        float r5 = r0.getLineLeft(r14);
    L23:
        if (r5 != (-1.0f)) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L30;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L30:
        if (IntSize.equals-impl0(r11, IntSize.Companion.getZero-YbymL2g()) == false) goto L32;
    L35:
        float r15 = r0.getCenterYForOffset(r14);
        if (r15 == (-1.0f)) goto L39;
        r7 = false;
    L39:
        if (r7 == false) goto L43;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L43:
        return r1.localPositionOf-R5De75A(r2, Offset.constructor-impl((Float.floatToRawIntBits(r5) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(r15)))));
    L32:
        if (Math.abs(r3 - r5) <= (((int) (r11 >> 32)) / 2)) goto L35;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L25:
        r8 = false;
        goto L26
    L21:
        float r6 = r0.getLineLeft(TextRange.getStart-impl(r4));
        float r9 = r0.getLineRight(TextRange.getEnd-impl(r4) - 1);
        r5 = RangesKt.coerceIn(r3, Math.min(r6, r9), Math.max(r6, r9));
        goto L23
    L17:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L13:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L9:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L5:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }
}
