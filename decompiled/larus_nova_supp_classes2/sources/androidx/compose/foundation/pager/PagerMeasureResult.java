package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BÁ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010D\u001a\u0004\u0018\u00010\u00002\u0006\u0010E\u001a\u00020\u0007J\t\u0010F\u001a\u00020GH\u0096\u0001R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0014\u0010\r\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u0010\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u0010\u0019\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010$R\u0011\u0010B\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bC\u0010,R\u001e\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00070IX\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0012\u0010M\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010$R'\u0010O\u001a\u0015\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020G\u0018\u00010P¢\u0006\u0002\bR8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0012\u0010U\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u0010$¨\u0006W"}, d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;)V", "getVisiblePagesInfo", "()Ljava/util/List;", "getPageSize", "()I", "getPageSpacing", "getAfterContentPadding", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getViewportStartOffset", "getViewportEndOffset", "getReverseLayout", "()Z", "getBeyondViewportPageCount", "getFirstVisiblePage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPage", "getCurrentPageOffsetFraction", "()F", "getFirstVisiblePageScrollOffset", "getCanScrollForward", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getRemeasureNeeded", "getExtraPagesBefore", "getExtraPagesAfter", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "copyWithScrollDeltaWithoutRemeasure", "delta", "placeChildren", "", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "width", "getWidth", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private final boolean canScrollForward;
    private final CoroutineScope coroutineScope;
    private final MeasuredPage currentPage;
    private final float currentPageOffsetFraction;
    private final List<MeasuredPage> extraPagesAfter;
    private final List<MeasuredPage> extraPagesBefore;
    private final MeasuredPage firstVisiblePage;
    private final int firstVisiblePageScrollOffset;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<MeasuredPage> visiblePagesInfo;

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
        MeasuredPage r0 = this.firstVisiblePage;
        if (r0 == null) goto L5;
        int r1 = r0.getIndex();
    L6:
        if (r1 == 0) goto L8;
    L9:
        return true;
    L8:
        if (this.firstVisiblePageScrollOffset != 0) goto L9;
        return false;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo1261getViewportSizeYbymL2g() {
        int r0 = getWidth();
        long r2 = ((long) r0) << 32;
        return IntSize.constructor-impl((((long) getHeight()) & 4294967295L) | r2);
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final List<MeasuredPage> getExtraPagesAfter() {
        return this.extraPagesAfter;
    }

    public final List<MeasuredPage> getExtraPagesBefore() {
        return this.extraPagesBefore;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List<MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    public final PagerMeasureResult copyWithScrollDeltaWithoutRemeasure(int r30) {
        int r2 = getPageSize() + getPageSpacing();
        PagerMeasureResult r4 = null;
        if (this.remeasureNeeded == false) goto L5;
    L51:
        return r4;
    L5:
        if (getVisiblePagesInfo().isEmpty() == true) goto L51;
        if (this.firstVisiblePage == null) goto L51;
        int r3 = this.firstVisiblePageScrollOffset - r30;
        if (r3 < 0) goto L12;
        if (r3 >= r2) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L51;
        if (r2 == 0) goto L17;
        float r6 = r30 / r2;
    L18:
        float r7 = this.currentPageOffsetFraction - r6;
        if (this.currentPage == null) goto L51;
        if (r7 >= 0.5f) goto L51;
        if (r7 <= (-0.5f)) goto L51;
        MeasuredPage r8 = (MeasuredPage) CollectionsKt.first(getVisiblePagesInfo());
        MeasuredPage r9 = (MeasuredPage) CollectionsKt.last(getVisiblePagesInfo());
        if (r30 >= 0) goto L31;
        if (Math.min((r8.getOffset() + r2) - getViewportStartOffset(), (r9.getOffset() + r2) - getViewportEndOffset()) > (-r30)) goto L32;
    L33:
        boolean r10 = false;
    L34:
        if (r10 == false) goto L51;
        List<MeasuredPage> r11 = getVisiblePagesInfo();
        int r12 = r11.size();
        int r13 = 0;
    L36:
        if (r13 >= r12) goto L38;
        ((MeasuredPage) ListProtector.get(r11, r13)).applyScrollDelta(r30);
        r13 = r13 + 1;
        goto L36
    L38:
        List<MeasuredPage> r14 = this.extraPagesBefore;
        int r15 = r14.size();
        int r16 = 0;
    L39:
        if (r16 >= r15) goto L41;
        ((MeasuredPage) ListProtector.get(r14, r16)).applyScrollDelta(r30);
        r16 = r16 + 1;
        goto L39
    L41:
        List<MeasuredPage> r17 = this.extraPagesAfter;
        int r18 = r17.size();
        int r19 = 0;
    L42:
        if (r19 >= r18) goto L44;
        ((MeasuredPage) ListProtector.get(r17, r19)).applyScrollDelta(r30);
        r19 = r19 + 1;
        goto L42
    L44:
        List<MeasuredPage> r20 = getVisiblePagesInfo();
        int r110 = getPageSize();
        int r111 = getPageSpacing();
        int r112 = getAfterContentPadding();
        Orientation r113 = getOrientation();
        int r114 = getViewportStartOffset();
        int r115 = getViewportEndOffset();
        boolean r116 = getReverseLayout();
        int r117 = getBeyondViewportPageCount();
        MeasuredPage r21 = this.firstVisiblePage;
        MeasuredPage r22 = this.currentPage;
        float r23 = this.currentPageOffsetFraction - r6;
        int r24 = this.firstVisiblePageScrollOffset - r30;
        if (this.canScrollForward == true) goto L49;
        if (r30 > 0) goto L49;
        boolean r25 = false;
    L50:
        r4 = new PagerMeasureResult(r20, r110, r111, r112, r113, r114, r115, r116, r117, r21, r22, r23, r24, r25, getSnapPosition(), this.measureResult, this.remeasureNeeded, this.extraPagesBefore, this.extraPagesAfter, this.coroutineScope);
    L49:
        r25 = true;
    L32:
        r10 = true;
        goto L34
    L31:
        if (Math.min(getViewportStartOffset() - r8.getOffset(), getViewportEndOffset() - r9.getOffset()) <= r30) goto L33;
    L17:
        r6 = MenuKt.ClosedAlphaTarget;
    L12:
        r5 = false;
        goto L13
    }

    public PagerMeasureResult(List<MeasuredPage> r3, int r4, int r5, int r6, Orientation r7, int r8, int r9, boolean r10, int r11, MeasuredPage r12, MeasuredPage r13, float r14, int r15, boolean r16, SnapPosition r17, MeasureResult r18, boolean r19, List<MeasuredPage> r20, List<MeasuredPage> r21, CoroutineScope r22) {
        this.visiblePagesInfo = r3;
        this.pageSize = r4;
        this.pageSpacing = r5;
        this.afterContentPadding = r6;
        this.orientation = r7;
        this.viewportStartOffset = r8;
        this.viewportEndOffset = r9;
        this.reverseLayout = r10;
        this.beyondViewportPageCount = r11;
        this.firstVisiblePage = r12;
        this.currentPage = r13;
        this.currentPageOffsetFraction = r14;
        this.firstVisiblePageScrollOffset = r15;
        this.canScrollForward = r16;
        this.snapPosition = r17;
        this.measureResult = r18;
        this.remeasureNeeded = r19;
        this.extraPagesBefore = r20;
        this.extraPagesAfter = r21;
        this.coroutineScope = r22;
    }

    public /* synthetic */ PagerMeasureResult(List r23, int r24, int r25, int r26, Orientation r27, int r28, int r29, boolean r30, int r31, MeasuredPage r32, MeasuredPage r33, float r34, int r35, boolean r36, SnapPosition r37, MeasureResult r38, boolean r39, List r40, List r41, CoroutineScope r42, int r43, DefaultConstructorMarker r44) {
        if ((r43 & 131072) == 0) goto L5;
        List r19 = CollectionsKt.emptyList();
    L7:
        if ((r43 & 262144) == 0) goto L9;
        List r20 = CollectionsKt.emptyList();
    L10:
        this(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r19, r20, r42);
        return;
    L9:
        r20 = r41;
        goto L10
    L5:
        r19 = r40;
        goto L7
    }
}
