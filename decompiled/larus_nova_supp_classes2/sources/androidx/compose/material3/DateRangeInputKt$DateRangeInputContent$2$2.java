package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DateRangeInputKt$DateRangeInputContent$2$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $pattern;
    final /* synthetic */ String $startRangeText;

    public DateRangeInputKt$DateRangeInputContent$2$2(String r1, String r2) {
        this.$startRangeText = r1;
        this.$pattern = r2;
    }

    public static /* synthetic */ Unit a(String r0, String r1, SemanticsPropertyReceiver r2) {
        return invoke$lambda$1$lambda$0(r0, r1, r2);
    }

    public final void invoke(Composer r28, int r29) {
        if ((r29 & 3) == 2) goto L5;
        boolean r3 = true;
    L7:
        if (r28.shouldExecute(r3, r29 & 1) == true) goto L9;
        r28.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1740538748, r29, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:80)");
    L11:
        String r15 = this.$startRangeText;
        Modifier.Companion r2 = Modifier.Companion;
        boolean r4 = r28.changed(r15) | r28.changed(this.$pattern);
        final String r5 = this.$startRangeText;
        final String r7 = this.$pattern;
        Object r8 = r28.rememberedValue();
        if (r4 == false) goto L14;
    L15:
        r8 = new a7(r5, r7);
        r28.updateRememberedValue(r8);
    L16:
        TextKt.m3363TextNvy7gAk(r15, SemanticsModifierKt.semantics$default(r2, false, (Function1) r8, 1, null), 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r28, 0, 0, 262140);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r8 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$1$lambda$0(String r1, String r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1 + ", " + r2);
        return Unit.INSTANCE;
    }
}
