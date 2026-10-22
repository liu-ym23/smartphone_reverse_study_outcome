package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DateRangeInputKt$DateRangeInputContent$2$6 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $pattern;

    public DateRangeInputKt$DateRangeInputContent$2$6(String r1) {
        this.$pattern = r1;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r27, int r28) {
        if ((r28 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r27.shouldExecute(r2, r28 & 1) == true) goto L9;
        r27.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1956183348, r28, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:109)");
    L11:
        String r15 = this.$pattern;
        Modifier.Companion r1 = Modifier.Companion;
        Object r3 = r27.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L14;
        r3 = new d7();
        r27.updateRememberedValue(r3);
    L14:
        TextKt.m3363TextNvy7gAk(r15, SemanticsModifierKt.clearAndSetSemantics(r1, (Function1) r3), 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r27, 0, 0, 262140);
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventEnd();
        return;
    L19:
        return;
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
