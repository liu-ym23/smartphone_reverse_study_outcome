package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"rememberLazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "EmptyLazyGridLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridStateKt {
    private static final LazyGridMeasureResult EmptyLazyGridLayoutInfo = null;

    private static final int EmptyLazyGridLayoutInfo$lambda$8(int r0) {
        return -1;
    }

    public static /* synthetic */ LazyGridState a(int r0, int r1, LazyGridPrefetchStrategy r2) {
        return rememberLazyGridState$lambda$4$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ LazyGridState b(LazyLayoutCacheWindow r0, int r1, int r2) {
        return rememberLazyGridState$lambda$6$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ LazyGridState c(int r0, int r1) {
        return rememberLazyGridState$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ int d(int r0) {
        return EmptyLazyGridLayoutInfo$lambda$8(r0);
    }

    public static /* synthetic */ List e(int r0) {
        return EmptyLazyGridLayoutInfo$lambda$7(r0);
    }

    static {
        MeasureResult r0 = new LazyGridStateKt$EmptyLazyGridLayoutInfo$1();
        List r13 = CollectionsKt.emptyList();
        Orientation r18 = Orientation.Vertical;
        Density r9 = DensityKt.Density$default(1.0f, MenuKt.ClosedAlphaTarget, 2, null);
        EmptyLazyGridLayoutInfo = new LazyGridMeasureResult(null, 0, false, MenuKt.ClosedAlphaTarget, r0, MenuKt.ClosedAlphaTarget, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), r9, 0, new j0(), new k0(), r13, 0, 0, 0, false, r18, 0, 0);
    }

    public static final /* synthetic */ LazyGridMeasureResult access$getEmptyLazyGridLayoutInfo$p() {
        return EmptyLazyGridLayoutInfo;
    }

    private static final List EmptyLazyGridLayoutInfo$lambda$7(int r0) {
        return CollectionsKt.emptyList();
    }

    private static final LazyGridState rememberLazyGridState$lambda$1$lambda$0(int r1, int r2) {
        return new LazyGridState(r1, r2);
    }

    private static final LazyGridState rememberLazyGridState$lambda$4$lambda$3(int r1, int r2, LazyGridPrefetchStrategy r3) {
        return new LazyGridState(r1, r2, r3);
    }

    private static final LazyGridState rememberLazyGridState$lambda$6$lambda$5(LazyLayoutCacheWindow r1, int r2, int r3) {
        return new LazyGridState(r1, r2, r3);
    }

    public static final LazyGridState rememberLazyGridState(final int r6, final int r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r7 = 0;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(29186956, r9, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:77)");
    L11:
        Object[] r11 = new Object[0];
        Saver<LazyGridState, ?> r0 = LazyGridState.Companion.getSaver();
        boolean r4 = true;
        if (((r9 & 14) ^ 6) <= 4) goto L16;
        if (r8.changed(r6) == false) goto L16;
    L17:
        boolean r2 = true;
    L20:
        if (((r9 & 112) ^ 48) <= 32) goto L24;
        if (r8.changed(r7) == false) goto L24;
    L27:
        boolean r12 = r2 | r4;
        Object r3 = r8.rememberedValue();
        if (r12 == false) goto L30;
    L31:
        r3 = new h0(r6, r7);
        r8.updateRememberedValue(r3);
    L32:
        LazyGridState r13 = (LazyGridState) RememberSaveableKt.rememberSaveable(r11, r0, (Function0) r3, r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        return r13;
    L30:
        if (r3 != Composer.Companion.getEmpty()) goto L32;
    L24:
        if ((r9 & 48) == 32) goto L27;
        r4 = false;
    L16:
        if ((r9 & 6) == 4) goto L17;
        r2 = false;
        goto L20
    }

    public static final LazyGridState rememberLazyGridState(final int r6, final int r7, final LazyGridPrefetchStrategy r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r7 = 0;
    L8:
        boolean r2 = true;
        if ((r11 & 4) == 0) goto L15;
        Object r12 = r9.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L13;
        r12 = LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null);
        r9.updateRememberedValue(r12);
    L13:
        r8 = (LazyGridPrefetchStrategy) r12;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-20335728, r10, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:101)");
    L17:
        Object[] r13 = {r8};
        Saver<LazyGridState, ?> r3 = LazyGridState.Companion.saver$foundation_release(r8);
        if (((r10 & 14) ^ 6) <= 4) goto L22;
        if (r9.changed(r6) == false) goto L22;
    L23:
        boolean r0 = true;
    L26:
        if (((r10 & 112) ^ 48) <= 32) goto L30;
        if (r9.changed(r7) == false) goto L30;
    L31:
        boolean r4 = true;
    L33:
        boolean r1 = r0 | r4;
        if (((r10 & 896) ^ 384) <= 256) goto L38;
        if (r9.changedInstance(r8) == false) goto L38;
    L41:
        boolean r14 = r1 | r2;
        Object r5 = r9.rememberedValue();
        if (r14 == false) goto L44;
    L45:
        r5 = new i0(r6, r7, r8);
        r9.updateRememberedValue(r5);
    L46:
        LazyGridState r15 = (LazyGridState) RememberSaveableKt.rememberSaveable(r13, r3, (Function0) r5, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        return r15;
    L44:
        if (r5 != Composer.Companion.getEmpty()) goto L46;
    L38:
        if ((r10 & 384) == 256) goto L41;
        r2 = false;
    L30:
        if ((r10 & 48) == 32) goto L31;
        r4 = false;
    L22:
        if ((r10 & 6) == 4) goto L23;
        r0 = false;
        goto L26
    }

    public static final LazyGridState rememberLazyGridState(final LazyLayoutCacheWindow r6, final int r7, final int r8, Composer r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r7 = 0;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r8 = 0;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1537306572, r10, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:129)");
    L11:
        boolean r12 = true;
        Object[] r2 = {r6};
        Saver<LazyGridState, ?> r3 = LazyGridState.Companion.saver$foundation_release(r6);
        if (((r10 & 14) ^ 6) <= 4) goto L16;
        if (r9.changed(r6) == false) goto L16;
    L17:
        boolean r0 = true;
    L20:
        if (((r10 & 112) ^ 48) <= 32) goto L24;
        if (r9.changed(r7) == false) goto L24;
    L25:
        boolean r4 = true;
    L27:
        boolean r1 = r0 | r4;
        if (((r10 & 896) ^ 384) <= 256) goto L32;
        if (r9.changed(r8) == false) goto L32;
    L35:
        boolean r13 = r1 | r12;
        Object r14 = r9.rememberedValue();
        if (r13 == false) goto L38;
    L39:
        r14 = new l0(r6, r7, r8);
        r9.updateRememberedValue(r14);
    L40:
        LazyGridState r15 = (LazyGridState) RememberSaveableKt.rememberSaveable(r2, r3, (Function0) r14, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
    L43:
        return r15;
    L38:
        if (r14 != Composer.Companion.getEmpty()) goto L40;
    L32:
        if ((r10 & 384) == 256) goto L35;
        r12 = false;
    L24:
        if ((r10 & 48) == 32) goto L25;
        r4 = false;
    L16:
        if ((r10 & 6) == 4) goto L17;
        r0 = false;
        goto L20
    }
}
