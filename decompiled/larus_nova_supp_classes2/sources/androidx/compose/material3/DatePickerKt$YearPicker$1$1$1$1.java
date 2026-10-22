package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt$YearPicker$1$1$1$1 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ int $currentYear;
    final /* synthetic */ int $displayedYear;
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ IntRange $yearRange;

    /* JADX WARN: Multi-variable type inference failed */
    public DatePickerKt$YearPicker$1$1$1$1(IntRange r1, CalendarModel r2, int r3, int r4, Function1<? super Integer, Unit> r5, SelectableDates r6, DatePickerColors r7) {
        this.$yearRange = r1;
        this.$calendarModel = r2;
        this.$displayedYear = r3;
        this.$currentYear = r4;
        this.$onYearSelected = r5;
        this.$selectableDates = r6;
        this.$colors = r7;
    }

    public static /* synthetic */ Unit a(Function1 r0, int r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(Function1 r0, int r1) {
        r0.invoke(Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    public final void invoke(LazyGridItemScope r18, int r19, Composer r20, int r21) {
        if ((r21 & 48) == 0) goto L5;
        int r2 = r21;
    L11:
        if ((r2 & 145) == 144) goto L13;
        boolean r3 = true;
    L15:
        if (r20.shouldExecute(r3, r2 & 1) == true) goto L17;
        r20.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(674613074, r2, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2088)");
    L19:
        final int r1 = r19 + this.$yearRange.getFirst();
        String r4 = CalendarLocale_jvmKt.toLocalString$default(r1, 0, 0, false, this.$calendarModel.getLocale(), 7, null);
        Modifier.Companion r5 = Modifier.Companion;
        DatePickerModalTokens r6 = DatePickerModalTokens.INSTANCE;
        Modifier r7 = SizeKt.m1008requiredSizeVpY3zN4(r5, r6.getSelectionYearContainerWidth-D9Ej5fM(), r6.getSelectionYearContainerHeight-D9Ej5fM());
        if (r1 != this.$displayedYear) goto L22;
        boolean r8 = true;
    L24:
        if (r1 != this.$currentYear) goto L26;
        boolean r9 = true;
    L27:
        boolean r10 = r20.changed(this.$onYearSelected) | r20.changed(r1);
        final Function1<Integer, Unit> r11 = this.$onYearSelected;
        Object r12 = r20.rememberedValue();
        if (r10 == false) goto L30;
    L31:
        r12 = new u6(r11, r1);
        r20.updateRememberedValue(r12);
    L32:
        boolean r13 = r8;
        boolean r14 = r9;
        DatePickerKt.access$Year(r4, r7, r13, r14, (Function0) r12, this.$selectableDates.isSelectableYear(r1), String.format(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911728), r20, 0), Arrays.copyOf(new Object[]{r4}, 1)), this.$colors, r20, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        return;
    L37:
        return;
    L30:
        if (r12 != Composer.Companion.getEmpty()) goto L32;
    L26:
        r9 = false;
        goto L27
    L22:
        r8 = false;
        goto L24
    L13:
        r3 = false;
        goto L15
    L5:
        if (r20.changed(r19) == false) goto L7;
        int r15 = 32;
    L8:
        r2 = r21 | r15;
        goto L11
    L7:
        r15 = 16;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((LazyGridItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
        return Unit.INSTANCE;
    }
}
