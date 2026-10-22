package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0003)*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bJ\b\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u001f¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "gridContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;)V", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "bucketSize", "", "getBucketSize", "()I", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "cachedBucketIndex", "cachedBucket", "", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "getDefaultSpans", "currentSlotsPerLine", "totalSize", "getTotalSize", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "itemIndex", "spanOf", "maxSpan", "invalidateCache", "", "LineConfiguration", "Bucket", "LazyGridItemSpanScopeImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridSpanLayoutProvider {
    public static final int $stable = 8;
    private final ArrayList<Bucket> buckets;
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;
    private final LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "<init>", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }

        public Bucket(int r1, int r2) {
            this.firstItemIndex = r1;
            this.firstItemKnownSpan = r2;
        }

        public /* synthetic */ Bucket(int r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = 0;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "<init>", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = null;
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        static {
            INSTANCE = new LazyGridItemSpanScopeImpl();
        }

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int r1) {
            maxCurrentLineSpan = r1;
        }

        public void setMaxLineSpan(int r1) {
            maxLineSpan = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "<init>", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List<GridItemSpan> spans;

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }

        public LineConfiguration(int r1, List<GridItemSpan> r2) {
            this.firstItemIndex = r1;
            this.spans = r2;
        }
    }

    public static /* synthetic */ int a(int r0, Bucket r1) {
        return getLineIndexOfItem$lambda$8(r0, r1);
    }

    private final void invalidateCache() {
        this.buckets.clear();
        int r4 = 0;
        this.buckets.add(new Bucket(r4, r4, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent r5) {
        this.gridContent = r5;
        ArrayList<Bucket> r6 = new ArrayList();
        int r3 = 0;
        r6.add(new Bucket(r3, r3, 2, null));
        this.buckets = r6;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    private final List<GridItemSpan> getDefaultSpans(int r5) {
        if (r5 == this.previousDefaultSpans.size()) goto L11;
        ArrayList r0 = new ArrayList(r5);
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L8;
        r0.add(GridItemSpan.m1102boximpl(LazyGridSpanKt.GridItemSpan(1)));
        r1 = r1 + 1;
        goto L6
    L8:
        this.previousDefaultSpans = r0;
        return r0;
    L11:
        return this.previousDefaultSpans;
    }

    public final LineConfiguration getLineConfiguration(int r11) {
        if (this.gridContent.getHasCustomSpans$foundation_release() == true) goto L6;
        int r0 = this.slotsPerLine;
        int r12 = r11 * r0;
        return new LineConfiguration(r12, getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r0, getTotalSize() - r12), 0)));
    L6:
        int r1 = Math.min(r11 / getBucketSize(), this.buckets.size() - 1);
        int r2 = getBucketSize() * r1;
        int r4 = ((Bucket) ListProtector.get(this.buckets, r1)).getFirstItemIndex();
        int r5 = ((Bucket) ListProtector.get(this.buckets, r1)).getFirstItemKnownSpan();
        int r6 = this.lastLineIndex;
        if (r2 > r6) goto L10;
        if (r6 > r11) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L14;
        r4 = this.lastLineStartItemIndex;
        r5 = this.lastLineStartKnownSpan;
        r2 = r6;
    L19:
        if ((r2 % getBucketSize()) != 0) goto L27;
        int r8 = getBucketSize();
        int r9 = r11 - r2;
        if (2 > r9) goto L24;
        if (r9 >= r8) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L30;
        this.cachedBucketIndex = r1;
        this.cachedBucket.clear();
    L30:
        if (r2 > r11) goto L32;
        boolean r3 = true;
    L33:
        if (r3 == true) goto L35;
        InlineClassHelperKt.throwIllegalStateException("currentLine (" + r2 + ") > lineIndex (" + r11 + ')');
    L35:
        if (r2 >= r11) goto L63;
        if (r4 >= getTotalSize()) goto L63;
        if (r13 == false) goto L40;
        this.cachedBucket.add(Integer.valueOf(r4));
    L40:
        int r14 = 0;
    L42:
        if (r14 >= this.slotsPerLine) goto L52;
        if (r4 >= getTotalSize()) goto L52;
        if (r5 != 0) goto L47;
        int r15 = r5;
        r5 = spanOf(r4, this.slotsPerLine - r14);
    L48:
        r14 = r14 + r5;
        if (r14 > this.slotsPerLine) goto L52;
        r4 = r4 + 1;
        r5 = r15;
        goto L42
    L47:
        r15 = 0;
    L52:
        r2 = r2 + 1;
        if ((r2 % getBucketSize()) != 0) goto L35;
        if (r4 >= getTotalSize()) goto L35;
        if (this.buckets.size() != (r2 / getBucketSize())) goto L59;
        boolean r16 = true;
    L60:
        if (r16 == true) goto L62;
        InlineClassHelperKt.throwIllegalStateException("invalid starting point");
    L62:
        this.buckets.add(new Bucket(r4, r5));
        goto L35
    L59:
        r16 = false;
    L63:
        this.lastLineIndex = r11;
        this.lastLineStartItemIndex = r4;
        this.lastLineStartKnownSpan = r5;
        ArrayList r17 = new ArrayList();
        int r18 = r4;
        int r19 = 0;
    L65:
        if (r19 >= this.slotsPerLine) goto L75;
        if (r18 >= getTotalSize()) goto L75;
        if (r5 != 0) goto L70;
        int r20 = r5;
        r5 = spanOf(r18, this.slotsPerLine - r19);
        int r21 = r20;
    L71:
        r19 = r19 + r5;
        if (r19 > this.slotsPerLine) goto L75;
        r18 = r18 + 1;
        r17.add(GridItemSpan.m1102boximpl(LazyGridSpanKt.GridItemSpan(r5)));
        r5 = r21;
        goto L65
    L70:
        r21 = 0;
    L75:
        return new LineConfiguration(r4, r17);
    L32:
        r3 = false;
    L24:
        r10 = false;
    L27:
        r13 = false;
        goto L28
    L14:
        if (r1 != this.cachedBucketIndex) goto L19;
        int r22 = r11 - r2;
        if (r22 >= this.cachedBucket.size()) goto L19;
        r4 = ((Number) ListProtector.get(this.cachedBucket, r22)).intValue();
        r2 = r11;
        r5 = 0;
    L10:
        r7 = false;
        goto L11
    }

    public final int getLineIndexOfItem(final int r11) {
        int r1 = 0;
        if (getTotalSize() > 0) goto L6;
        return 0;
    L6:
        if (r11 >= getTotalSize()) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        InlineClassHelperKt.throwIllegalArgumentException("ItemIndex > total count");
    L12:
        if (this.gridContent.getHasCustomSpans$foundation_release() == false) goto L14;
        int r2 = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new x(r11), 3, null);
        int r3 = 2;
        if (r2 >= 0) goto L19;
        r2 = (-r2) - 2;
    L19:
        int r4 = getBucketSize() * r2;
        int r5 = ((Bucket) ListProtector.get(this.buckets, r2)).getFirstItemIndex();
        if (r5 > r11) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
        InlineClassHelperKt.throwIllegalArgumentException("currentItemIndex > itemIndex");
    L25:
        int r7 = 0;
    L26:
        if (r5 >= r11) goto L44;
        int r8 = r5 + 1;
        int r9 = spanOf(r5, this.slotsPerLine - r7);
        r7 = r7 + r9;
        int r10 = this.slotsPerLine;
        if (r7 < r10) goto L34;
        if (r7 != r10) goto L32;
        r4 = r4 + 1;
        r7 = 0;
        goto L34
    L32:
        r4 = r4 + 1;
        r7 = r9;
    L34:
        if ((r4 % getBucketSize()) != 0) goto L42;
        if ((r4 / getBucketSize()) < this.buckets.size()) goto L42;
        ArrayList<Bucket> r12 = this.buckets;
        if (r7 <= 0) goto L40;
        int r13 = 1;
    L41:
        r12.add(new Bucket(r8 - r13, r1, r3, null));
        goto L42
    L40:
        r13 = 0;
    L42:
        r5 = r8;
        goto L26
    L44:
        if ((r7 + spanOf(r11, this.slotsPerLine - r7)) > this.slotsPerLine) goto L46;
        return r4;
    L46:
        return r4 + 1;
    L22:
        r6 = false;
        goto L23
    L14:
        return r11 / this.slotsPerLine;
    L8:
        r0 = false;
        goto L9
    }

    public final void setSlotsPerLine(int r2) {
        if (r2 == this.slotsPerLine) goto L6;
        this.slotsPerLine = r2;
        invalidateCache();
        return;
    }

    private static final int getLineIndexOfItem$lambda$8(int r0, Bucket r1) {
        return r1.getFirstItemIndex() - r0;
    }

    public final int spanOf(int r3, int r4) {
        LazyGridItemSpanScopeImpl r0 = LazyGridItemSpanScopeImpl.INSTANCE;
        r0.setMaxCurrentLineSpan(r4);
        r0.setMaxLineSpan(this.slotsPerLine);
        IntervalList.Interval<LazyGridInterval> r5 = this.gridContent.getIntervals().get(r3);
        int r6 = r3 - r5.getStartIndex();
        return GridItemSpan.m1106getCurrentLineSpanimpl(((GridItemSpan) r5.getValue().getSpan().invoke(r0, Integer.valueOf(r6))).m1109unboximpl());
    }
}
