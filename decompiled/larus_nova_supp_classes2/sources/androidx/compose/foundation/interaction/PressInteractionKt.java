package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"collectIsPressedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PressInteractionKt {
    public static final State<Boolean> collectIsPressedAsState(InteractionSource r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1692965168, r8, -1, "androidx.compose.foundation.interaction.collectIsPressedAsState (PressInteraction.kt:80)");
    L5:
        Object r0 = r7.rememberedValue();
        Composer.Companion r1 = Composer.Companion;
        if (r0 != r1.getEmpty()) goto L8;
        r0 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r7.updateRememberedValue(r0);
    L8:
        MutableState r2 = (MutableState) r0;
        int r3 = r8 & 14;
        if ((r3 ^ 6) <= 4) goto L13;
        if (r7.changed(r6) == false) goto L13;
    L14:
        boolean r9 = true;
    L16:
        Object r4 = r7.rememberedValue();
        if (r9 == false) goto L19;
    L20:
        r4 = new PressInteractionKt$collectIsPressedAsState$1$1(r6, r2, null);
        r7.updateRememberedValue(r4);
    L21:
        EffectsKt.LaunchedEffect(r6, (Function2) r4, r7, r3);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r2;
    L19:
        if (r4 != r1.getEmpty()) goto L21;
    L13:
        if ((r8 & 6) == 4) goto L14;
        r9 = false;
        goto L16
    }
}
