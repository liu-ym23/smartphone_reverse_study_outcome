package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u00ad\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0018\u0010I\u001a\u0004\u0018\u00010\u00002\u0006\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u000bJ\t\u0010L\u001a\u00020MH\u0096\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010-R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0014\u0010\u001b\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00106R\u0014\u0010\u001c\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00106R\u0014\u0010\u001d\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00106R\u0014\u0010\u001e\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00106R\u0014\u0010\u001f\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00106R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bD\u0010-R\u0014\u0010E\u001a\u00020FX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001e\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00150OX\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0012\u0010S\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u00106R'\u0010U\u001a\u0015\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020M\u0018\u00010V¢\u0006\u0002\bX8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0012\u0010[\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u00106¨\u0006]"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "scrollBackAmount", "canScrollForward", "", "isVertical", "remeasureNeeded", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "density", "Landroidx/compose/ui/unit/Density;", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "([I[IFLandroidx/compose/ui/layout/MeasureResult;FZZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;Landroidx/compose/ui/unit/Density;ILjava/util/List;JIIIIILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "getConsumedScroll", "()F", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "getScrollBackAmount", "getCanScrollForward", "()Z", "getRemeasureNeeded", "getSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTotalItemsCount", "()I", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getViewportEndOffset", "getBeforeContentPadding", "getAfterContentPadding", "getMainAxisItemSpacing", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "canScrollBackward", "getCanScrollBackward", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final int[] firstVisibleItemIndices;
    private final int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final float scrollBackAmount;
    private final LazyStaggeredGridSlots slots;
    private final LazyStaggeredGridSpanProvider spanProvider;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<LazyStaggeredGridMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] r1, int[] r2, float r3, MeasureResult r4, float r5, boolean r6, boolean r7, boolean r8, LazyStaggeredGridSlots r9, LazyStaggeredGridSpanProvider r10, Density r11, int r12, List r13, long r14, int r16, int r17, int r18, int r19, int r20, CoroutineScope r21, DefaultConstructorMarker r22) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21);
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.measureResult.getRulers();
    }

    public int getWidth() {
        return this.measureResult.getWidth();
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    public final boolean getCanScrollBackward() {
        if (this.firstVisibleItemIndices[0] == 0) goto L5;
    L6:
        return true;
    L5:
        if (this.firstVisibleItemScrollOffsets[0] > 0) goto L6;
        return false;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    public final LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo1218getViewportSizeYbymL2g() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public List<LazyStaggeredGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final LazyStaggeredGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int r31, boolean r32) {
        if (this.remeasureNeeded == false) goto L5;
    L71:
        return null;
    L5:
        if (getVisibleItemsInfo().isEmpty() == true) goto L71;
        if (this.firstVisibleItemIndices.length != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L71;
        if (this.firstVisibleItemScrollOffsets.length != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L71;
        int r4 = getViewportEndOffset() - getAfterContentPadding();
        List<LazyStaggeredGridMeasuredItem> r6 = getVisibleItemsInfo();
        int r7 = r6.size();
        int r8 = 0;
    L18:
        if (r8 >= r7) goto L57;
        LazyStaggeredGridMeasuredItem r9 = (LazyStaggeredGridMeasuredItem) ListProtector.get(r6, r8);
        if (r9.getNonScrollableItem() == true) goto L56;
        if (r9.getMainAxisOffset() > 0) goto L24;
        boolean r10 = true;
    L26:
        if ((r9.getMainAxisOffset() + r31) > 0) goto L28;
        boolean r11 = true;
    L29:
        if (r10 != r11) goto L56;
        if (r9.getMainAxisOffset() > getViewportStartOffset()) goto L44;
        if (r31 >= 0) goto L38;
        if (((r9.getMainAxisOffset() + r9.getMainAxisSizeWithSpacings()) - getViewportStartOffset()) > (-r31)) goto L39;
    L40:
        boolean r12 = false;
    L41:
        if (r12 == true) goto L44;
        return null;
    L39:
        r12 = true;
        goto L41
    L38:
        if ((getViewportStartOffset() - r9.getMainAxisOffset()) <= r31) goto L40;
    L44:
        if ((r9.getMainAxisOffset() + r9.getMainAxisSizeWithSpacings()) < r4) goto L55;
        if (r31 >= 0) goto L50;
        if (((r9.getMainAxisOffset() + r9.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-r31)) goto L51;
    L52:
        boolean r13 = false;
    L53:
        if (r13 == true) goto L55;
        return null;
    L51:
        r13 = true;
        goto L53
    L50:
        if ((getViewportEndOffset() - r9.getMainAxisOffset()) <= r31) goto L52;
    L55:
        r8 = r8 + 1;
        goto L18
    L28:
        r11 = false;
        goto L29
    L24:
        r10 = false;
    L56:
        return null;
    L57:
        List<LazyStaggeredGridMeasuredItem> r5 = getVisibleItemsInfo();
        int r14 = r5.size();
        int r15 = 0;
    L58:
        if (r15 >= r14) goto L60;
        ((LazyStaggeredGridMeasuredItem) ListProtector.get(r5, r15)).applyScrollDelta(r31, r32);
        r15 = r15 + 1;
        goto L58
    L60:
        int[] r16 = this.firstVisibleItemIndices;
        int r17 = this.firstVisibleItemScrollOffsets.length;
        int[] r18 = new int[r17];
        int r19 = 0;
    L61:
        if (r19 >= r17) goto L63;
        r18[r19] = this.firstVisibleItemScrollOffsets[r19] - r31;
        r19 = r19 + 1;
        goto L61
    L63:
        float r110 = r31;
        float r111 = this.scrollBackAmount;
        MeasureResult r112 = this.measureResult;
        if (this.canScrollForward == true) goto L68;
        if (r31 > 0) goto L68;
        boolean r113 = false;
    L70:
        return new LazyStaggeredGridMeasureResult(r16, r18, r110, r112, r111, r113, this.isVertical, this.remeasureNeeded, this.slots, this.spanProvider, this.density, getTotalItemsCount(), getVisibleItemsInfo(), mo1218getViewportSizeYbymL2g(), getViewportStartOffset(), getViewportEndOffset(), getBeforeContentPadding(), getAfterContentPadding(), getMainAxisItemSpacing(), this.coroutineScope, null);
    L68:
        r113 = true;
        goto L70
    L14:
        r3 = false;
        goto L15
    L9:
        r2 = false;
        goto L10
    }

    private LazyStaggeredGridMeasureResult(int[] r5, int[] r6, float r7, MeasureResult r8, float r9, boolean r10, boolean r11, boolean r12, LazyStaggeredGridSlots r13, LazyStaggeredGridSpanProvider r14, Density r15, int r16, List<LazyStaggeredGridMeasuredItem> r17, long r18, int r20, int r21, int r22, int r23, int r24, CoroutineScope r25) {
        this.firstVisibleItemIndices = r5;
        this.firstVisibleItemScrollOffsets = r6;
        this.consumedScroll = r7;
        this.measureResult = r8;
        this.scrollBackAmount = r9;
        this.canScrollForward = r10;
        this.isVertical = r11;
        this.remeasureNeeded = r12;
        this.slots = r13;
        this.spanProvider = r14;
        this.density = r15;
        this.totalItemsCount = r16;
        this.visibleItemsInfo = r17;
        this.viewportSize = r18;
        this.viewportStartOffset = r20;
        this.viewportEndOffset = r21;
        this.beforeContentPadding = r22;
        this.afterContentPadding = r23;
        this.mainAxisItemSpacing = r24;
        this.coroutineScope = r25;
        if (r11 == false) goto L5;
        Orientation r1 = Orientation.Vertical;
    L6:
        this.orientation = r1;
        return;
    L5:
        r1 = Orientation.Horizontal;
        goto L6
    }
}
