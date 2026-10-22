package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0016¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/lazy/LazyListState$prefetchScope$1", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "onPrefetchFinished", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListPrefetchResultScope;", "", "Lkotlin/ExtensionFunctionType;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListState$prefetchScope$1 implements LazyListPrefetchScope {
    final /* synthetic */ LazyListState this$0;

    public static /* synthetic */ Unit a(Function1 r0, int r1, LazyListMeasureResult r2, LazyLayoutPrefetchState.PrefetchResultScope r3) {
        return schedulePrefetch$lambda$2(r0, r1, r2, r3);
    }

    public LazyListState$prefetchScope$1(LazyListState r1) {
        this.this$0 = r1;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchScope
    public LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch(final int r9, final Function1<? super LazyListPrefetchResultScope, Unit> r10) {
        Snapshot.Companion r0 = Snapshot.Companion;
        LazyListState r1 = this.this$0;
        Snapshot r2 = r0.getCurrentThreadSnapshot();
        if (r2 == null) goto L5;
        Function1 r3 = r2.getReadObserver();
    L6:
        Snapshot r4 = r0.makeCurrentNonObservable(r2);
        final LazyListMeasureResult r5 = (LazyListMeasureResult) LazyListState.access$getLayoutInfoState$p(r1).getValue();     // Catch: Throwable -> L10
        r0.restoreNonObservable(r2, r4, r3);
        return this.this$0.getPrefetchState$foundation_release().m1178schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(r9, r5.m1089getChildConstraintsmsEJaDk(), LazyListState.access$getExecuteRequestsInHighPriorityMode$p(this.this$0), new b0(r10, r9, r5));
    L10:
        th = move-exception;
        r0.restoreNonObservable(r2, r4, r3);
        throw th;
    L5:
        r3 = null;
        goto L6
    }

    private static final Unit schedulePrefetch$lambda$2(Function1 r7, int r8, LazyListMeasureResult r9, LazyLayoutPrefetchState.PrefetchResultScope r10) {
        if (r7 == null) goto L12;
        int r0 = r10.getPlaceablesCount();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r0) goto L10;
        if (r9.getOrientation() != Orientation.Vertical) goto L8;
        long r3 = r10.mo1181getSizeYEO4UFw(r1) & 4294967295L;
    L9:
        r2 = r2 + ((int) r3);
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = r10.mo1181getSizeYEO4UFw(r1) >> 32;
        goto L9
    L10:
        r7.invoke(new LazyListPrefetchResultScopeImpl(r8, r2));
    L12:
        return Unit.INSTANCE;
    }
}
