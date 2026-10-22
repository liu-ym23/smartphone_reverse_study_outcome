package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberLazyStaggeredGridState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridStateKt {
    public static /* synthetic */ LazyStaggeredGridState a(int r0, int r1) {
        return rememberLazyStaggeredGridState$lambda$1$lambda$0(r0, r1);
    }

    private static final LazyStaggeredGridState rememberLazyStaggeredGridState$lambda$1$lambda$0(int r1, int r2) {
        return new LazyStaggeredGridState(r1, r2);
    }

    public static final LazyStaggeredGridState rememberLazyStaggeredGridState(final int r6, final int r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r7 = 0;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(161145796, r9, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState (LazyStaggeredGridState.kt:78)");
    L11:
        Object[] r11 = new Object[0];
        Saver<LazyStaggeredGridState, Object> r0 = LazyStaggeredGridState.Companion.getSaver();
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
        r3 = new u(r6, r7);
        r8.updateRememberedValue(r3);
    L32:
        LazyStaggeredGridState r13 = (LazyStaggeredGridState) RememberSaveableKt.rememberSaveable(r11, r0, (Function0) r3, r8, 0);
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
}
