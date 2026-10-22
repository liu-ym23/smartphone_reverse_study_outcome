package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt$DatePickerContent$2$4$2 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ CalendarMonth $displayedMonth;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;
    final /* synthetic */ IntRange $yearRange;

    public DatePickerKt$DatePickerContent$2$4$2(long r1, MutableState<Boolean> r3, CoroutineScope r4, LazyListState r5, IntRange r6, CalendarMonth r7, SelectableDates r8, CalendarModel r9, DatePickerColors r10) {
        this.$displayedMonthMillis = r1;
        this.$yearPickerVisible$delegate = r3;
        this.$coroutineScope = r4;
        this.$monthsListState = r5;
        this.$yearRange = r6;
        this.$displayedMonth = r7;
        this.$selectableDates = r8;
        this.$calendarModel = r9;
        this.$colors = r10;
    }

    public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(CoroutineScope r0, MutableState r1, LazyListState r2, IntRange r3, CalendarMonth r4, int r5) {
        return invoke$lambda$4$lambda$3$lambda$2(r0, r1, r2, r3, r4, r5);
    }

    private static final Unit invoke$lambda$1$lambda$0(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setPaneTitle(r1, r0);
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope r19, Composer r20, int r21) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1193716082, r21, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1632)");
    L5:
        final String r1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911740), r20, 0);
        Modifier.Companion r3 = Modifier.Companion;
        boolean r4 = r20.changed(r1);
        Object r5 = r20.rememberedValue();
        if (r4 == false) goto L8;
    L9:
        r5 = new i6(r1);
        r20.updateRememberedValue(r5);
    L10:
        Modifier r2 = SemanticsModifierKt.semantics$default(r3, false, (Function1) r5, 1, null);
        long r6 = this.$displayedMonthMillis;
        final MutableState<Boolean> r14 = this.$yearPickerVisible$delegate;
        final CoroutineScope r13 = this.$coroutineScope;
        final LazyListState r15 = this.$monthsListState;
        final IntRange r7 = this.$yearRange;
        final CalendarMonth r8 = this.$displayedMonth;
        SelectableDates r9 = this.$selectableDates;
        CalendarModel r10 = this.$calendarModel;
        DatePickerColors r12 = this.$colors;
        MeasurePolicy r0 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r20, 0);
        int r11 = ComposablesKt.getCurrentCompositeKeyHash(r20, 0);
        CompositionLocalMap r16 = r20.getCurrentCompositionLocalMap();
        Modifier r17 = ComposedModifierKt.materializeModifier(r20, r2);
        ComposeUiNode.Companion r18 = ComposeUiNode.Companion;
        Function0 r110 = r18.getConstructor();
        if ((r20.getApplier() instanceof Applier) == true) goto L13;
        ComposablesKt.invalidApplier();
    L13:
        r20.startReusableNode();
        if (r20.getInserting() == false) goto L16;
        r20.createNode(r110);
    L17:
        Composer r111 = Updater.constructor-impl(r20);
        Updater.set-impl(r111, r0, r18.getSetMeasurePolicy());
        Updater.set-impl(r111, r16, r18.getSetResolvedCompositionLocals());
        Function2 r22 = r18.getSetCompositeKeyHash();
        if (r111.getInserting() == false) goto L20;
    L21:
        r111.updateRememberedValue(Integer.valueOf(r11));
        r111.apply(Integer.valueOf(r11), r22);
    L22:
        Updater.set-impl(r111, r17, r18.getSetModifier());
        ColumnScopeInstance r23 = ColumnScopeInstance.INSTANCE;
        Modifier r24 = PaddingKt.m962paddingVpY3zN4$default(SizeKt.m1003requiredHeight3ABfNKs(r3, Dp.constructor-impl(Dp.constructor-impl(DatePickerKt.getRecommendedSizeForAccessibility() * 7) - DividerDefaults.INSTANCE.m2632getThicknessD9Ej5fM())), DatePickerKt.getDatePickerHorizontalPadding(), MenuKt.ClosedAlphaTarget, 2, null);
        boolean r25 = (((r20.changed(r14) | r20.changedInstance(r13)) | r20.changed(r15)) | r20.changedInstance(r7)) | r20.changed(r8);
        Object r26 = r20.rememberedValue();
        if (r25 == false) goto L25;
    L28:
        r26 = new j6(r13, r14, r15, r7, r8);
        r20.updateRememberedValue(r26);
    L29:
        DatePickerKt.access$YearPicker(r24, r6, (Function1) r26, r9, r10, r7, r17, r20, 6);
        DividerKt.m2634HorizontalDivider9IZ8Weo(null, MenuKt.ClosedAlphaTarget, r12.m2563getDividerColor0d7_KjU(), r20, 0, 3);
        r20.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        return;
    L33:
        return;
    L25:
        if (r26 != Composer.Companion.getEmpty()) goto L29;
    L20:
        if (Intrinsics.areEqual(r111.rememberedValue(), Integer.valueOf(r11)) == true) goto L22;
    L16:
        r20.useNode();
        goto L17
    L8:
        if (r5 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((AnimatedVisibilityScope) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$4$lambda$3$lambda$2(CoroutineScope r8, MutableState r9, LazyListState r10, IntRange r11, CalendarMonth r12, int r13) {
        DatePickerKt.access$DatePickerContent$lambda$27(r9, !DatePickerKt.access$DatePickerContent$lambda$26(r9));
        BuildersKt.launch$default(r8, null, null, new DatePickerKt$DatePickerContent$2$4$2$2$1$1$1(r10, r13, r11, r12, null), 3, null);
        return Unit.INSTANCE;
    }
}
