package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001a!\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ScrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "consumeScrollDelta", "Lkotlin/Function1;", "", "rememberScrollableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/ScrollableState;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScrollableStateKt {
    public static /* synthetic */ float a(State r0, float r1) {
        return rememberScrollableState$lambda$1$lambda$0(r0, r1);
    }

    public static final ScrollableState ScrollableState(Function1<? super Float, Float> r1) {
        return new DefaultScrollableState(r1);
    }

    private static final float rememberScrollableState$lambda$1$lambda$0(State r0, float r1) {
        return ((Number) ((Function1) r0.getValue()).invoke(Float.valueOf(r1))).floatValue();
    }

    public static final ScrollableState rememberScrollableState(Function1<? super Float, Float> r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-180460798, r5, -1, "androidx.compose.foundation.gestures.rememberScrollableState (ScrollableState.kt:159)");
    L5:
        final State r6 = SnapshotStateKt.rememberUpdatedState(r3, r4, r5 & 14);
        Object r7 = r4.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L8;
        r7 = ScrollableState(new j2(r6));
        r4.updateRememberedValue(r7);
    L8:
        ScrollableState r8 = (ScrollableState) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r8;
    }
}
