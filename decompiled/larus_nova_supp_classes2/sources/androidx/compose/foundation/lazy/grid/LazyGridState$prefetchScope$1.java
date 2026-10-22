package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J1\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0016¨\u0006\f"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridState$prefetchScope$1", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "scheduleLinePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "", "onPrefetchFinished", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchResultScope;", "", "Lkotlin/ExtensionFunctionType;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridState$prefetchScope$1 implements LazyGridPrefetchScope {
    final /* synthetic */ LazyGridState this$0;

    public static /* synthetic */ Unit a(List r0, Ref.IntRef r1, List r2, Function1 r3, int r4, LazyGridMeasureResult r5, LazyLayoutPrefetchState.PrefetchResultScope r6) {
        return scheduleLinePrefetch$lambda$4$lambda$3$lambda$2$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    public LazyGridState$prefetchScope$1(LazyGridState r1) {
        this.this$0 = r1;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> scheduleLinePrefetch(int r2) {
        return scheduleLinePrefetch(r2, null);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> scheduleLinePrefetch(final int r27, final Function1<? super LazyGridPrefetchResultScope, Unit> r28) {
        ArrayList r0 = new ArrayList();
        Function1 r1 = null;
        if (r28 != null) goto L5;
        ArrayList r9 = null;
    L6:
        Snapshot.Companion r10 = Snapshot.Companion;
        LazyGridState r12 = this.this$0;
        Snapshot r13 = r10.getCurrentThreadSnapshot();
        if (r13 == null) goto L9;
        r1 = r13.getReadObserver();
    L9:
        Snapshot r14 = r10.makeCurrentNonObservable(r13);
    L22:
        th = move-exception;
        r10.restoreNonObservable(r13, r14, r1);
        throw th;
    L11:
        if (r12.getHasLookaheadOccurred$foundation_release() == false) goto L14;
        LazyGridMeasureResult r2 = r12.getApproachLayoutInfo$foundation_release();     // Catch: Throwable -> L22
    L13:
        final LazyGridMeasureResult r15 = r2;
        if (r15 == null) goto L20;
        Ref.IntRef r8 = new Ref.IntRef();     // Catch: Throwable -> L22
        r8.element = 1;     // Catch: Throwable -> L22
        List r7 = (List) r15.getPrefetchInfoRetriever().invoke(Integer.valueOf(r27));     // Catch: Throwable -> L22
        int r6 = r7.size();     // Catch: Throwable -> L22
        int r5 = 0;
    L17:
        if (r5 >= r6) goto L19;
        Pair r3 = (Pair) r7.get(r5);     // Catch: Throwable -> L22
        final ArrayList r4 = r9;
        final Ref.IntRef r11 = r8;
        int r22 = r5;
        final List r16 = r7;
        r0.add(r12.getPrefetchState$foundation_release().m1178schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(((Number) r3.getFirst()).intValue(), ((Constraints) r3.getSecond()).unbox-impl(), LazyGridState.access$getExecuteRequestsInHighPriorityMode$p(r12), new g0(r4, r11, r16, r28, r27, r15)));     // Catch: Throwable -> L22
        r5 = r22 + 1;     // Catch: Throwable -> L22
        r6 = r6;
        r7 = r7;
        r8 = r8;
        goto L17
    L19:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        r10.restoreNonObservable(r13, r14, r1);
        return r0;
    L14:
        r2 = (LazyGridMeasureResult) LazyGridState.access$getLayoutInfoState$p(r12).getValue();     // Catch: Throwable -> L22
        goto L13
    L5:
        r9 = new ArrayList();
        goto L6
    }

    private static final Unit scheduleLinePrefetch$lambda$4$lambda$3$lambda$2$lambda$1(List r7, Ref.IntRef r8, List r9, Function1 r10, int r11, LazyGridMeasureResult r12, LazyLayoutPrefetchState.PrefetchResultScope r13) {
        int r0 = r13.getPlaceablesCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r12.getOrientation() != Orientation.Vertical) goto L7;
        long r3 = r13.mo1181getSizeYEO4UFw(r1) & 4294967295L;
    L8:
        r2 = r2 + ((int) r3);
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = r13.mo1181getSizeYEO4UFw(r1) >> 32;
        goto L8
    L9:
        if (r7 == null) goto L12;
        r7.add(Integer.valueOf(r2));
    L12:
        if (r8.element != r9.size()) goto L16;
        if (r10 == null) goto L18;
        if (r7 == null) goto L18;
        r10.invoke(new LazyGridPrefetchResultScopeImpl(r11, r7));
    L18:
        return Unit.INSTANCE;
    L16:
        r8.element++;
        goto L18
    }
}
