package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ List<CustomAccessibilityAction> $customAccessibilityAction;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $month;

    public DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1(DatePickerFormatter r1, CalendarMonth r2, CalendarModel r3, List<CustomAccessibilityAction> r4, DatePickerColors r5) {
        this.$dateFormatter = r1;
        this.$month = r2;
        this.$calendarModel = r3;
        this.$customAccessibilityAction = r4;
        this.$colors = r5;
    }

    public static /* synthetic */ Unit a(List r0, SemanticsPropertyReceiver r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(List r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setCustomActions(r1, r0);
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
        ComposerKt.traceEventStart(-577031469, r29, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:858)");
    L11:
        String r2 = this.$dateFormatter.formatMonthYear(Long.valueOf(this.$month.getStartUtcTimeMillis()), this.$calendarModel.getLocale());
        if (r2 != null) goto L14;
        r2 = "-";
    L14:
        String r23 = r2;
        Modifier r4 = PaddingKt.padding(Modifier.Companion, DateRangePickerKt.getCalendarMonthSubheadPadding());
        boolean r5 = r28.changedInstance(this.$customAccessibilityAction);
        final List<CustomAccessibilityAction> r6 = this.$customAccessibilityAction;
        Object r7 = r28.rememberedValue();
        if (r5 == false) goto L17;
    L18:
        r7 = new y7(r6);
        r28.updateRememberedValue(r7);
    L19:
        TextKt.m3363TextNvy7gAk(r23, SemanticsModifierKt.semantics$default(r4, false, (Function1) r7, 1, null), this.$colors.m2570getSubheadContentColor0d7_KjU(), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r28, 0, 0, 262136);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
        return;
    L24:
        return;
    L17:
        if (r7 != Composer.Companion.getEmpty()) goto L19;
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
