package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt$MonthsNavigation$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ String $yearPickerText;

    public DatePickerKt$MonthsNavigation$1$1(String r1, DatePickerColors r2) {
        this.$yearPickerText = r1;
        this.$colors = r2;
    }

    public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(String r1, SemanticsPropertyReceiver r2) {
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(r2, LiveRegionMode.Companion.getPolite-0phEisY());
        SemanticsPropertiesKt.setContentDescription(r2, r1);
        return Unit.INSTANCE;
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
        ComposerKt.traceEventStart(619076006, r29, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2204)");
    L11:
        String r15 = this.$yearPickerText;
        Modifier.Companion r2 = Modifier.Companion;
        boolean r4 = r28.changed(r15);
        final String r5 = this.$yearPickerText;
        Object r7 = r28.rememberedValue();
        if (r4 == false) goto L14;
    L15:
        r7 = new r6(r5);
        r28.updateRememberedValue(r7);
    L16:
        TextKt.m3363TextNvy7gAk(r15, SemanticsModifierKt.semantics$default(r2, false, (Function1) r7, 1, null), this.$colors.m2565getNavigationContentColor0d7_KjU(), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r28, 0, 0, 262136);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r7 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
