package androidx.compose.material3;

import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt$DisplayModeToggleButton$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<DisplayMode, Unit> $onDisplayModeChange;

    /* JADX WARN: Multi-variable type inference failed */
    public DatePickerKt$DisplayModeToggleButton$1(int r1, Function1<? super DisplayMode, Unit> r2, Modifier r3) {
        this.$displayMode = r1;
        this.$onDisplayModeChange = r2;
        this.$modifier = r3;
    }

    public static /* synthetic */ Unit a(Function1 r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit b(Function1 r0) {
        return invoke$lambda$3$lambda$2(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(Function1 r1) {
        r1.invoke(DisplayMode.m2623boximpl(DisplayMode.Companion.m2630getInputjFl4v0()));
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$3$lambda$2(Function1 r1) {
        r1.invoke(DisplayMode.m2623boximpl(DisplayMode.Companion.m2631getPickerjFl4v0()));
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r12, int r13) {
        if ((r13 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r12.shouldExecute(r0, r13 & 1) == true) goto L9;
        r12.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventStart(-1734512197, r13, -1, "androidx.compose.material3.DisplayModeToggleButton.<anonymous> (DatePicker.kt:1408)");
    L12:
        if (DisplayMode.m2626equalsimpl0(this.$displayMode, DisplayMode.Companion.m2631getPickerjFl4v0()) == false) goto L19;
        r12.startReplaceGroup(-101264927);
        ImageVector r4 = Icons.Filled.INSTANCE.getEdit$material3();
        String r5 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911734), r12, 0);
        boolean r14 = r12.changed(this.$onDisplayModeChange);
        final Function1<DisplayMode, Unit> r1 = this.$onDisplayModeChange;
        Object r2 = r12.rememberedValue();
        if (r14 == false) goto L16;
    L17:
        r2 = new l6(r1);
        r12.updateRememberedValue(r2);
    L18:
        DatePickerKt.access$IconButtonWithTooltip((Function0) r2, r4, r5, this.$modifier, false, r12, 0, 16);
        r12.endReplaceGroup();
    L26:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        return;
    L30:
        return;
    L16:
        if (r2 != Composer.Companion.getEmpty()) goto L18;
    L19:
        r12.startReplaceGroup(-100967048);
        ImageVector r6 = Icons.Filled.INSTANCE.getDateRange$material3();
        String r7 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911732), r12, 0);
        boolean r15 = r12.changed(this.$onDisplayModeChange);
        final Function1<DisplayMode, Unit> r3 = this.$onDisplayModeChange;
        Object r8 = r12.rememberedValue();
        if (r15 == false) goto L22;
    L23:
        r8 = new m6(r3);
        r12.updateRememberedValue(r8);
    L24:
        DatePickerKt.access$IconButtonWithTooltip((Function0) r8, r6, r7, this.$modifier, false, r12, 0, 16);
        r12.endReplaceGroup();
        goto L26
    L22:
        if (r8 != Composer.Companion.getEmpty()) goto L24;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
