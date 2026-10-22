package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"rememberLazyGridBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState(LazyGridState r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(2004349821, r5, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridBeyondBoundsState (LazyGridBeyondBoundsModifier.kt:24)");
    L6:
        if (((r5 & 14) ^ 6) <= 4) goto L10;
        if (r4.changed(r3) == false) goto L10;
    L11:
        boolean r6 = true;
    L13:
        Object r0 = r4.rememberedValue();
        if (r6 == false) goto L16;
    L17:
        r0 = new LazyGridBeyondBoundsState(r3);
        r4.updateRememberedValue(r0);
    L18:
        LazyGridBeyondBoundsState r1 = (LazyGridBeyondBoundsState) r0;
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        return r1;
    L16:
        if (r0 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r5 & 6) == 4) goto L11;
        r6 = false;
        goto L13
    }
}
