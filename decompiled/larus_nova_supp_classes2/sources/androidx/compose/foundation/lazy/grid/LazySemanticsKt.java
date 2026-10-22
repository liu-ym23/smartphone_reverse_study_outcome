package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberLazyGridSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "reverseScrolling", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazySemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyGridSemanticState(final LazyGridState r5, boolean r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1247008005, r8, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridSemanticState (LazySemantics.kt:31)");
    L5:
        boolean r1 = false;
        if (((r8 & 14) ^ 6) <= 4) goto L10;
        if (r7.changed(r5) == false) goto L10;
    L11:
        boolean r0 = true;
    L14:
        if (((r8 & 112) ^ 48) <= 32) goto L18;
        if (r7.changed(r6) == false) goto L18;
    L19:
        r1 = true;
    L20:
        boolean r9 = r0 | r1;
        Object r10 = r7.rememberedValue();
        if (r9 == false) goto L23;
    L24:
        r10 = new LazySemanticsKt$rememberLazyGridSemanticState$1$1(r5);
        r7.updateRememberedValue(r10);
    L25:
        LazySemanticsKt$rememberLazyGridSemanticState$1$1 r11 = (LazySemanticsKt$rememberLazyGridSemanticState$1$1) r10;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r11;
    L23:
        if (r10 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r8 & 48) != 32) goto L20;
    L10:
        if ((r8 & 6) == 4) goto L11;
        r0 = false;
        goto L14
    }
}
