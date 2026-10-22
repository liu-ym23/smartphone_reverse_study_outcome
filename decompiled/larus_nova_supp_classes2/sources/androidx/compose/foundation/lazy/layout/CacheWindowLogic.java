package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b \b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000fJ\b\u0010\"\u001a\u00020\u001fH\u0002J\n\u0010#\u001a\u00020\u001f*\u00020 J\u0006\u0010$\u001a\u00020\u0013J\u0014\u0010%\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0014\u0010&\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0014\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0006\u0010)\u001a\u00020\u001fJD\u0010*\u001a\u00020\u001f*\u00020 2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0013H\u0002J@\u00102\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\u001c\u00104\u001a\u00020\u0011*\u00020 2\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0013H\u0002J\u0018\u00107\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002J\u0018\u00109\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011H\u0002J\u001c\u0010=\u001a\u00020\u001f*\u00020 2\u0006\u00105\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0002J\f\u0010?\u001a\u00020\u001f*\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;)V", "prefetchWindowHandles", "Landroidx/collection/MutableIntObjectMap;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indicesToRemove", "Landroidx/collection/MutableIntSet;", "windowCache", "Landroidx/collection/MutableIntIntMap;", "previousPassDelta", "", "previousPassItemCount", "", "hasUpdatedVisibleItemsOnce", "", "value", "prefetchWindowStartLine", "getPrefetchWindowStartLine$foundation_release", "()I", "prefetchWindowEndLine", "getPrefetchWindowEndLine$foundation_release", "prefetchWindowStartExtraSpace", "prefetchWindowEndExtraSpace", "shouldRefillWindow", "itemsCount", "onScroll", "", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "delta", "traceWindowInfo", "onVisibleItemsUpdated", "hasValidBounds", "fillCacheWindowBackward", "fillCacheWindowForward", "refillWindow", "refillForward", "resetStrategy", "onPrefetchForward", "visibleWindowStart", "visibleWindowEnd", "prefetchForwardWindow", "mainAxisExtraSpaceEnd", "mainAxisExtraSpaceStart", "scrollDelta", "applyForwardPrefetch", "onKeepAround", "keepAroundWindow", "getItemSizeOrPrefetch", "index", "isUrgent", "cachePrefetchedItem", "size", "cacheVisibleItemsInfo", "removeOutOfBoundsItems", "startLine", "endLine", "onItemPrefetched", "itemSize", "scheduleNextItemIfNeeded", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CacheWindowLogic {
    public static final int $stable = 8;
    private final LazyLayoutCacheWindow cacheWindow;
    private boolean hasUpdatedVisibleItemsOnce;
    private final MutableIntSet indicesToRemove;
    private int itemsCount;
    private int prefetchWindowEndExtraSpace;
    private int prefetchWindowEndLine;
    private final MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> prefetchWindowHandles;
    private int prefetchWindowStartExtraSpace;
    private int prefetchWindowStartLine;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean shouldRefillWindow;
    private final MutableIntIntMap windowCache;

    public static /* synthetic */ Unit a(CacheWindowLogic r0, CacheWindowScope r1, int r2, int r3) {
        return scheduleNextItemIfNeeded$lambda$15(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(CacheWindowLogic r0, CacheWindowScope r1, int r2, int r3) {
        return getItemSizeOrPrefetch$lambda$8(r0, r1, r2, r3);
    }

    private final void traceWindowInfo() {
        AndroidTrace_androidKt.traceValue("prefetchWindowStartExtraSpace", this.prefetchWindowStartExtraSpace);
        AndroidTrace_androidKt.traceValue("prefetchWindowEndExtraSpace", this.prefetchWindowEndExtraSpace);
        AndroidTrace_androidKt.traceValue("prefetchWindowStartIndex", this.prefetchWindowStartLine);
        AndroidTrace_androidKt.traceValue("prefetchWindowEndIndex", this.prefetchWindowEndLine);
    }

    public final boolean hasValidBounds() {
        if (this.prefetchWindowStartLine != Integer.MAX_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (this.prefetchWindowEndLine == Integer.MIN_VALUE) goto L7;
        return true;
    }

    public final void resetStrategy() {
        this.prefetchWindowStartLine = Integer.MAX_VALUE;
        this.prefetchWindowEndLine = RtlSpacingHelper.UNDEFINED;
        this.prefetchWindowStartExtraSpace = 0;
        this.prefetchWindowEndExtraSpace = 0;
        this.shouldRefillWindow = false;
        this.windowCache.clear();
        MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> r1 = this.prefetchWindowHandles;
        long[] r2 = r1.metadata;
        int r3 = r2.length - 2;
        if (r3 < 0) goto L22;
        int r4 = 0;
    L5:
        long r5 = r2[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L20;
        int r7 = 8 - ((~(r4 - r3)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L19;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L18;
        int r11 = (r4 << 3) + r9;
        int r12 = r1.keys[r11];
        List r13 = (List) r1.values[r11];
        int r14 = r13.size();
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L17;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r13, r15)).cancel();
        r15 = r15 + 1;
        goto L15
    L17:
        r1.removeValueAt(r11);
    L18:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L19:
        if (r7 == 8) goto L20;
        return;
    L20:
        if (r4 == r3) goto L30;
        r4 = r4 + 1;
        goto L5
    L30:
        return;
    }

    public final int getPrefetchWindowEndLine$foundation_release() {
        return this.prefetchWindowEndLine;
    }

    public final int getPrefetchWindowStartLine$foundation_release() {
        return this.prefetchWindowStartLine;
    }

    public CacheWindowLogic(LazyLayoutCacheWindow r1) {
        this.cacheWindow = r1;
        this.prefetchWindowHandles = IntObjectMapKt.mutableIntObjectMapOf();
        this.indicesToRemove = IntSetKt.mutableIntSetOf();
        this.windowCache = IntIntMapKt.mutableIntIntMapOf();
        this.previousPassItemCount = -1;
        this.prefetchWindowStartLine = Integer.MAX_VALUE;
        this.prefetchWindowEndLine = RtlSpacingHelper.UNDEFINED;
    }

    private final void scheduleNextItemIfNeeded(final CacheWindowScope r4) {
        if (Math.signum(this.previousPassDelta) > MenuKt.ClosedAlphaTarget) goto L8;
        if (this.prefetchWindowEndExtraSpace <= 0) goto L12;
        int r0 = this.prefetchWindowEndLine + 1;
    L13:
        if (r0 > 0) goto L15;
        return;
    L15:
        if (r4.getLastIndexInLine(r0) != (-1)) goto L17;
        return;
    L17:
        if (r4.getLastIndexInLine(r0) >= this.itemsCount) goto L22;
        this.prefetchWindowHandles.set(r0, r4.schedulePrefetch(r0, new c(this, r4)));
        return;
    L22:
        return;
    L12:
        r0 = -1;
        goto L13
    L8:
        if (Math.signum(this.previousPassDelta) <= MenuKt.ClosedAlphaTarget) goto L12;
        if (this.prefetchWindowStartExtraSpace <= 0) goto L12;
        r0 = this.prefetchWindowStartLine - 1;
        goto L13
    }

    public final void onVisibleItemsUpdated(CacheWindowScope r7) {
        boolean r1 = true;
        if (this.hasUpdatedVisibleItemsOnce == true) goto L11;
        LazyLayoutCacheWindow r0 = this.cacheWindow;
        Density r3 = r7.getDensity();
        if (r3 == null) goto L7;
        int r2 = r0.calculateAheadWindow(r3, r7.getMainAxisViewportSize());
    L8:
        if (r2 == 0) goto L10;
        this.shouldRefillWindow = true;
    L10:
        this.hasUpdatedVisibleItemsOnce = true;
        goto L11
    L7:
        r2 = 0;
    L11:
        int r4 = this.previousPassItemCount;
        if (r4 != (-1)) goto L14;
    L18:
        this.itemsCount = r7.getTotalItemsCount();
        if (r7.getHasVisibleItems() == false) goto L30;
        int r5 = r7.getVisibleLineCount();
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L24;
        cacheVisibleItemsInfo(r7.getVisibleItemLine(r6), r7.getVisibleItemSize(r6));
        r6 = r6 + 1;
        goto L21
    L24:
        if (this.shouldRefillWindow == true) goto L26;
    L31:
        this.previousPassItemCount = r7.getTotalItemsCount();
        return;
    L26:
        if (this.previousPassDelta <= MenuKt.ClosedAlphaTarget) goto L29;
        r1 = false;
    L29:
        refillWindow(r7, r1);
        this.shouldRefillWindow = false;
        goto L31
    L30:
        resetStrategy();
        goto L31
    L14:
        if (r4 == r7.getTotalItemsCount()) goto L18;
        this.shouldRefillWindow = true;
        this.prefetchWindowStartLine = RangesKt.coerceAtLeast(this.prefetchWindowStartLine, 0);
        int r8 = r7.getLastLineIndex();
        if (r8 == (-1)) goto L18;
        this.prefetchWindowEndLine = RangesKt.coerceAtMost(this.prefetchWindowEndLine, r8);
        goto L18
    }

    private final void cachePrefetchedItem(int r2, int r3) {
        this.windowCache.set(r2, r3);
        if (r2 <= this.prefetchWindowEndLine) goto L6;
        this.prefetchWindowEndLine = r2;
        this.prefetchWindowEndExtraSpace -= r3;
        return;
    L6:
        if (r2 >= this.prefetchWindowStartLine) goto L10;
        this.prefetchWindowStartLine = r2;
        this.prefetchWindowStartExtraSpace -= r3;
        return;
    }

    private final void cacheVisibleItemsInfo(int r3, int r4) {
        if (this.windowCache.containsKey(r3) == true) goto L5;
    L7:
        this.windowCache.set(r3, r4);
        this.prefetchWindowStartLine = Math.min(this.prefetchWindowStartLine, r3);
        this.prefetchWindowEndLine = Math.max(this.prefetchWindowEndLine, r3);
        List<LazyLayoutPrefetchState.PrefetchHandle> r5 = this.prefetchWindowHandles.remove(r3);
        if (r5 == null) goto L12;
        int r6 = r5.size();
        int r0 = 0;
    L10:
        if (r0 >= r6) goto L14;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r5, r0)).cancel();
        r0 = r0 + 1;
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        if (this.windowCache.get(r3) == r4) goto L7;
        this.shouldRefillWindow = true;
        goto L7
    }

    private final void fillCacheWindowBackward(CacheWindowScope r10, float r11) {
        if (r10.getHasVisibleItems() == false) goto L10;
        int r0 = r10.getMainAxisViewportSize();
        LazyLayoutCacheWindow r1 = this.cacheWindow;
        Density r2 = r10.getDensity();
        if (r2 == null) goto L7;
        int r6 = r1.calculateBehindWindow(r2, r0);
    L8:
        this.itemsCount = r10.getTotalItemsCount();
        int r3 = r10.getFirstVisibleLineIndex();
        int r4 = r10.getLastVisibleLineIndex();
        int r8 = r10.getTotalItemsCount();
        int r5 = r10.getMainAxisExtraSpaceStart();
        onKeepAround(r3, r4, r10.getMainAxisExtraSpaceEnd(), r5, r6, r11, r8);
        return;
    L7:
        r6 = 0;
        goto L8
    }

    private final void fillCacheWindowForward(CacheWindowScope r14, float r15) {
        if (r14.getHasVisibleItems() == false) goto L14;
        int r0 = r14.getMainAxisViewportSize();
        LazyLayoutCacheWindow r1 = this.cacheWindow;
        Density r2 = r14.getDensity();
        if (r2 == null) goto L7;
        int r8 = r1.calculateAheadWindow(r2, r0);
    L8:
        int r6 = r14.getFirstVisibleLineIndex();
        int r7 = r14.getLastVisibleLineIndex();
        int r10 = r14.getMainAxisExtraSpaceStart();
        int r9 = r14.getMainAxisExtraSpaceEnd();
        if (r15 > MenuKt.ClosedAlphaTarget) goto L11;
        boolean r12 = true;
    L12:
        onPrefetchForward(r14, r6, r7, r8, r9, r10, r15, r12);
        return;
    L11:
        r12 = false;
        goto L12
    L7:
        r8 = 0;
        goto L8
    }

    private final void refillWindow(CacheWindowScope r11, boolean r12) {
        if (r11.getHasVisibleItems() == false) goto L10;
        int r0 = r11.getMainAxisViewportSize();
        LazyLayoutCacheWindow r1 = this.cacheWindow;
        Density r2 = r11.getDensity();
        if (r2 == null) goto L7;
        int r5 = r1.calculateAheadWindow(r2, r0);
    L8:
        int r3 = r11.getFirstVisibleLineIndex();
        int r4 = r11.getLastVisibleLineIndex();
        int r7 = r11.getMainAxisExtraSpaceStart();
        onPrefetchForward(r11, r3, r4, r5, r11.getMainAxisExtraSpaceEnd(), r7, MenuKt.ClosedAlphaTarget, r12);
        return;
    L7:
        r5 = 0;
        goto L8
    }

    private final void removeOutOfBoundsItems(int r26, int r27) {
        this.indicesToRemove.clear();
        MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> r3 = this.prefetchWindowHandles;
        int[] r4 = r3.keys;
        long[] r5 = r3.metadata;
        int r6 = r5.length - 2;
        char r10 = 7;
        long r11 = -9187201950435737472L;
        if (r6 < 0) goto L25;
        int r14 = 0;
    L5:
        long r7 = r5[r14];
        if (((((~r7) << 7) & r7) & r11) == r11) goto L23;
        int r8 = 8 - ((~(r14 - r6)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L22;
        if ((r7 & 255) >= 128) goto L12;
        boolean r20 = true;
    L13:
        if (r20 == false) goto L21;
        int r15 = r4[(r14 << 3) + r9];
        if (r26 > r15) goto L18;
        if (r15 > r27) goto L18;
        boolean r21 = true;
    L19:
        if (r21 == false) goto L21;
        this.indicesToRemove.add(r15);
    L18:
        r21 = false;
    L21:
        r7 = r7 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r20 = false;
        goto L13
    L22:
        if (r8 != 8) goto L25;
    L23:
        if (r14 == r6) goto L25;
        r14 = r14 + 1;
        r11 = -9187201950435737472L;
    L25:
        MutableIntIntMap r12 = this.windowCache;
        int[] r13 = r12.keys;
        long[] r16 = r12.metadata;
        int r17 = r16.length - 2;
        if (r17 < 0) goto L48;
        int r18 = 0;
    L28:
        long r19 = r16[r18];
        if (((((~r19) << 7) & r19) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L46;
        int r22 = 8 - ((~(r18 - r17)) >>> 31);
        int r110 = 0;
    L31:
        if (r110 >= r22) goto L45;
        if ((r19 & 255) >= 128) goto L35;
        boolean r111 = true;
    L36:
        if (r111 == false) goto L44;
        int r112 = r13[(r18 << 3) + r110];
        if (r26 > r112) goto L41;
        if (r112 > r27) goto L41;
        boolean r113 = true;
    L42:
        if (r113 == false) goto L44;
        this.indicesToRemove.add(r112);
    L41:
        r113 = false;
    L44:
        r19 = r19 >> 8;
        r110 = r110 + 1;
        goto L31
    L35:
        r111 = false;
        goto L36
    L45:
        if (r22 != 8) goto L48;
    L46:
        if (r18 == r17) goto L48;
        r18 = r18 + 1;
    L48:
        MutableIntSet r1 = this.indicesToRemove;
        int[] r2 = r1.elements;
        long[] r23 = r1.metadata;
        int r24 = r23.length - 2;
        if (r24 < 0) goto L73;
        int r25 = 0;
    L51:
        long r28 = r23[r25];
        if (((((~r28) << r10) & r28) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L71;
        int r29 = 8 - ((~(r25 - r24)) >>> 31);
        int r30 = 0;
    L54:
        if (r30 >= r29) goto L68;
        if ((r28 & 255) >= 128) goto L58;
        boolean r31 = true;
    L59:
        if (r31 == false) goto L66;
        int r32 = r2[(r25 << 3) + r30];
        List<LazyLayoutPrefetchState.PrefetchHandle> r114 = this.prefetchWindowHandles.remove(r32);
        if (r114 == null) goto L65;
        int r115 = r114.size();
        int r116 = 0;
    L63:
        if (r116 >= r115) goto L65;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r114, r116)).cancel();
        r116 = r116 + 1;
    L65:
        this.windowCache.remove(r32);
    L66:
        r28 = r28 >> 8;
        r30 = r30 + 1;
        goto L54
    L58:
        r31 = false;
        goto L59
    L68:
        if (r29 == 8) goto L71;
        return;
    L71:
        if (r25 == r24) goto L93;
        r25 = r25 + 1;
        r10 = 7;
        goto L51
    L93:
        return;
    }

    public final void onScroll(CacheWindowScope r1, float r2) {
        traceWindowInfo();
        fillCacheWindowBackward(r1, r2);
        fillCacheWindowForward(r1, r2);
        this.previousPassDelta = r2;
        traceWindowInfo();
    }

    private final int getItemSizeOrPrefetch(final CacheWindowScope r5, int r6, boolean r7) {
        if (this.windowCache.containsKey(r6) == true) goto L24;
        int r1 = 0;
        if (this.prefetchWindowHandles.containsKey(r6) == false) goto L13;
        if (r7 == false) goto L20;
        List<LazyLayoutPrefetchState.PrefetchHandle> r8 = this.prefetchWindowHandles.get(r6);
        if (r8 == null) goto L20;
        int r9 = r8.size();
    L11:
        if (r1 >= r9) goto L20;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r8, r1)).markAsUrgent();
        r1 = r1 + 1;
    L20:
        return -1;
    L13:
        this.prefetchWindowHandles.set(r6, r5.schedulePrefetch(r6, new b(this, r5)));
        if (r7 == false) goto L20;
        List<LazyLayoutPrefetchState.PrefetchHandle> r10 = this.prefetchWindowHandles.get(r6);
        if (r10 == null) goto L20;
        int r11 = r10.size();
    L18:
        if (r1 >= r11) goto L20;
        ((LazyLayoutPrefetchState.PrefetchHandle) ListProtector.get(r10, r1)).markAsUrgent();
        r1 = r1 + 1;
        goto L18
    L24:
        return this.windowCache.get(r6);
    }

    private final void onItemPrefetched(CacheWindowScope r1, int r2, int r3) {
        cachePrefetchedItem(r2, r3);
        scheduleNextItemIfNeeded(r1);
        traceWindowInfo();
    }

    private static final Unit getItemSizeOrPrefetch$lambda$8(CacheWindowLogic r0, CacheWindowScope r1, int r2, int r3) {
        r0.onItemPrefetched(r1, r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit scheduleNextItemIfNeeded$lambda$15(CacheWindowLogic r0, CacheWindowScope r1, int r2, int r3) {
        r0.onItemPrefetched(r1, r2, r3);
        return Unit.INSTANCE;
    }

    private final void onKeepAround(int r2, int r3, int r4, int r5, int r6, float r7, int r8) {
        if (r7 > MenuKt.ClosedAlphaTarget) goto L13;
        this.prefetchWindowStartExtraSpace = r6 - r5;
        this.prefetchWindowStartLine = r2;
    L6:
        if (this.prefetchWindowStartExtraSpace <= 0) goto L12;
        int r9 = this.prefetchWindowStartLine;
        if (r9 <= 0) goto L12;
        if (this.windowCache.containsKey(r9 - 1) == false) goto L12;
        int r10 = this.windowCache.get(this.prefetchWindowStartLine - 1);
        this.prefetchWindowStartLine--;
        this.prefetchWindowStartExtraSpace -= r10;
    L12:
        removeOutOfBoundsItems(0, this.prefetchWindowStartLine - 1);
        return;
    L13:
        this.prefetchWindowEndExtraSpace = r6 - r4;
        this.prefetchWindowEndLine = r3;
    L15:
        if (this.prefetchWindowEndExtraSpace <= 0) goto L21;
        int r11 = this.prefetchWindowEndLine;
        if (r11 >= (r8 - 1)) goto L21;
        if (this.windowCache.containsKey(r11 + 1) == false) goto L21;
        int r12 = this.windowCache.get(this.prefetchWindowEndLine + 1);
        this.prefetchWindowEndLine++;
        this.prefetchWindowEndExtraSpace -= r12;
    L21:
        removeOutOfBoundsItems(this.prefetchWindowEndLine + 1, r8 - 1);
    }

    private final void onPrefetchForward(CacheWindowScope r5, int r6, int r7, int r8, int r9, int r10, float r11, boolean r12) {
        if (Math.signum(r11) != Math.signum(this.previousPassDelta)) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = !r0;
        if (r12 == false) goto L29;
        if (r1 == false) goto L10;
    L13:
        this.prefetchWindowEndExtraSpace = r8 - r9;
        this.prefetchWindowEndLine = r7;
    L15:
        if (this.prefetchWindowEndExtraSpace <= 0) goto L48;
        if (r5.getLastIndexInLine(this.prefetchWindowEndLine) == (-1)) goto L58;
        if (r5.getLastIndexInLine(this.prefetchWindowEndLine) >= (this.itemsCount - 1)) goto L59;
        if ((this.prefetchWindowEndLine + 1) == (r7 + 1)) goto L23;
    L25:
        boolean r13 = false;
    L26:
        int r14 = getItemSizeOrPrefetch(r5, this.prefetchWindowEndLine + 1, r13);
        if (r14 == (-1)) goto L60;
        this.prefetchWindowEndLine++;
        this.prefetchWindowEndExtraSpace -= r14;
        goto L15
    L60:
        return;
    L23:
        if (Math.abs(r11) < r9) goto L25;
        r13 = true;
        goto L26
    L59:
        return;
    L58:
        return;
    L48:
        return;
    L10:
        if (this.shouldRefillWindow == true) goto L13;
        this.prefetchWindowEndExtraSpace += MathKt.roundToInt(Math.abs(r11));
        goto L15
    L29:
        if (r1 == false) goto L31;
    L34:
        this.prefetchWindowStartExtraSpace = r8 - r10;
        this.prefetchWindowStartLine = r6;
    L36:
        if (this.prefetchWindowStartExtraSpace <= 0) goto L61;
        int r15 = this.prefetchWindowStartLine;
        if (r15 <= 0) goto L62;
        if ((r15 - 1) == (r6 - 1)) goto L42;
    L44:
        boolean r16 = false;
    L45:
        int r17 = getItemSizeOrPrefetch(r5, this.prefetchWindowStartLine - 1, r16);
        if (r17 == (-1)) goto L63;
        this.prefetchWindowStartLine--;
        this.prefetchWindowStartExtraSpace -= r17;
        goto L36
    L63:
        return;
    L42:
        if (Math.abs(r11) < r10) goto L44;
        r16 = true;
        goto L45
    L62:
        return;
    L61:
        return;
    L31:
        if (this.shouldRefillWindow == true) goto L34;
        this.prefetchWindowStartExtraSpace += MathKt.roundToInt(Math.abs(r11));
        goto L36
    L5:
        r0 = false;
        goto L6
    }
}
