package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJG\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0098\u0001\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0003¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "<init>", "()V", "DateRangePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "DateRangePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DateRangePickerHeadline", "selectedStartDateMillis", "", "selectedEndDateMillis", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "DateRangePickerHeadline-qS89cEg", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerHeadline-nZrIstQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/util/Locale;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = null;

    static {
        INSTANCE = new DateRangePickerDefaults();
    }

    private DateRangePickerDefaults() {
    }

    private static final Unit DateRangePickerHeadline_nZrIstQ$lambda$5(DateRangePickerDefaults r17, Long r18, Long r19, int r20, DatePickerFormatter r21, Modifier r22, long r23, String r25, String r26, Function2 r27, Function2 r28, Function2 r29, Locale r30, int r31, int r32, Composer r33, int r34) {
        r17.m2598DateRangePickerHeadlinenZrIstQ(r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r33, RecomposeScopeImplKt.updateChangedFlags(r31 | 1), RecomposeScopeImplKt.updateChangedFlags(r32));
        return Unit.INSTANCE;
    }

    private static final Unit DateRangePickerHeadline_qS89cEg$lambda$1(DateRangePickerDefaults r12, Long r13, Long r14, int r15, DatePickerFormatter r16, Modifier r17, long r18, int r20, int r21, Composer r22, int r23) {
        r12.m2599DateRangePickerHeadlineqS89cEg(r13, r14, r15, r16, r17, r18, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit DateRangePickerTitle_FNtVw6o$lambda$0(DateRangePickerDefaults r9, int r10, Modifier r11, long r12, int r14, int r15, Composer r16, int r17) {
        r9.m2600DateRangePickerTitleFNtVw6o(r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DateRangePickerDefaults r0, Long r1, Long r2, int r3, DatePickerFormatter r4, Modifier r5, long r6, int r8, int r9, Composer r10, int r11) {
        return DateRangePickerHeadline_qS89cEg$lambda$1(r0, r1, r2, r3, r4, r5, r6, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(String r0, String r1, SemanticsPropertyReceiver r2) {
        return DateRangePickerHeadline_nZrIstQ$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(DateRangePickerDefaults r0, int r1, Modifier r2, long r3, int r5, int r6, Composer r7, int r8) {
        return DateRangePickerTitle_FNtVw6o$lambda$0(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit d(DateRangePickerDefaults r1, Long r2, Long r3, int r4, DatePickerFormatter r5, Modifier r6, long r7, String r9, String r10, Function2 r11, Function2 r12, Function2 r13, Locale r14, int r15, int r16, Composer r17, int r18) {
        return DateRangePickerHeadline_nZrIstQ$lambda$5(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    private static final Unit DateRangePickerHeadline_nZrIstQ$lambda$3$lambda$2(String r1, String r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(r3, LiveRegionMode.Companion.getPolite-0phEisY());
        SemanticsPropertiesKt.setContentDescription(r3, r1 + ", " + r2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DateRangePickerTitle-FNtVw6o, reason: not valid java name */
    public final void m2600DateRangePickerTitleFNtVw6o(final int r36, Modifier r37, long r38, Composer r40, final int r41, final int r42) {
        Composer r1 = r40.startRestartGroup(694693107);
        if ((r42 & 1) == 0) goto L6;
        int r3 = r41 | 6;
    L13:
        int r4 = r42 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r37;
    L25:
        if ((r41 & 384) == 0) goto L27;
        long r7 = r38;
    L36:
        if ((r3 & 147) == 146) goto L38;
        boolean r9 = true;
    L40:
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L70;
        r1.startDefaults();
        if ((r41 & 1) != 0) goto L44;
    L50:
        if (r4 == 0) goto L52;
        Modifier r6 = Modifier.Companion;
    L54:
        if ((r42 & 4) == 0) goto L56;
        r7 = DatePickerDefaults.INSTANCE.colors(r1, 6).m2571getTitleContentColor0d7_KjU();
        r3 = r3 & (-897);
    L56:
        long r33 = r7;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventStart(694693107, r3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:371)");
    L59:
        DisplayMode.Companion r0 = DisplayMode.Companion;
        if (DisplayMode.m2626equalsimpl0(r36, r0.m2631getPickerjFl4v0()) == false) goto L63;
        r1.startReplaceGroup(1880154051);
        Modifier r8 = r6;
        TextKt.m3363TextNvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911748), r1, 0), r8, r33, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r1, (r3 & 112) | (r3 & 896), 0, 262136);
        r1.endReplaceGroup();
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
    L69:
        final Modifier r10 = r6;
        final long r11 = r33;
    L71:
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L75;
        r12.updateScope(new f7(this, r36, r10, r11, r41, r42));
        return;
    L75:
        return;
    L63:
        if (DisplayMode.m2626equalsimpl0(r36, r0.m2630getInputjFl4v0()) == false) goto L65;
        r1.startReplaceGroup(1880161282);
        Modifier r13 = r6;
        TextKt.m3363TextNvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911742), r1, 0), r13, r33, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r1, (r3 & 112) | (r3 & 896), 0, 262136);
        r1.endReplaceGroup();
        goto L67
    L65:
        r1.startReplaceGroup(-1844364305);
        r1.endReplaceGroup();
        goto L67
    L52:
        r6 = r5;
        goto L54
    L44:
        if (r1.getDefaultsInvalid() == true) goto L50;
        r1.skipToGroupEnd();
        if ((r42 & 4) == 0) goto L49;
        r3 = r3 & (-897);
    L49:
        r6 = r5;
        goto L56
    L70:
        r1.skipToGroupEnd();
        r10 = r5;
        r11 = r7;
        goto L71
    L38:
        r9 = false;
        goto L40
    L27:
        if ((r42 & 4) != 0) goto L31;
        r7 = r38;
        if (r1.changed(r7) == false) goto L32;
        int r14 = 256;
    L33:
        r3 = r3 | r14;
    L32:
        r14 = 128;
        goto L33
    L31:
        r7 = r38;
        goto L32
    L17:
        if ((r41 & 48) != 0) goto L23;
        r5 = r37;
        if (r1.changed(r5) == false) goto L21;
        int r15 = 32;
    L22:
        r3 = r3 | r15;
        goto L25
    L21:
        r15 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r3 = r41;
        goto L13
    L8:
        if (r1.changed(r36) == false) goto L10;
        int r16 = 4;
    L11:
        r3 = r16 | r41;
        goto L13
    L10:
        r16 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DateRangePickerHeadline-qS89cEg, reason: not valid java name */
    public final void m2599DateRangePickerHeadlineqS89cEg(final Long r22, final Long r23, final int r24, final DatePickerFormatter r25, Modifier r26, long r27, Composer r29, final int r30, final int r31) {
        Composer r7 = r29.startRestartGroup(1655228151);
        if ((r31 & 1) == 0) goto L6;
        int r1 = r30 | 6;
    L14:
        if ((r31 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r31 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r31 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L46:
        int r2 = r31 & 16;
        if (r2 == 0) goto L50;
        r1 = r1 | 24576;
    L56:
        Modifier r8 = r26;
    L58:
        if ((196608 & r30) == 0) goto L60;
        long r9 = r27;
    L69:
        if ((r31 & 64) == 0) goto L72;
        r1 = r1 | 1572864;
    L79:
        if ((599187 & r1) == 599186) goto L81;
        boolean r11 = true;
    L83:
        if (r7.shouldExecute(r11, r1 & 1) == false) goto L105;
        r7.startDefaults();
        if ((r30 & 1) != 0) goto L87;
    L92:
        if (r2 == 0) goto L95;
        r8 = Modifier.Companion;
    L95:
        if ((r31 & 32) == 0) goto L98;
        r9 = DatePickerDefaults.INSTANCE.colors(r7, 6).m2564getHeadlineContentColor0d7_KjU();
    L97:
        r1 = r1 & (-458753);
    L98:
        int r12 = r1;
        Modifier r17 = r8;
        final long r3 = r9;
        r7.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventStart(1655228151, r12, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:409)");
    L101:
        final String r0 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911747), r7, 0);
        final String r13 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911744), r7, 0);
        Composer r20 = r7;
        m2598DateRangePickerHeadlinenZrIstQ(r22, r23, r24, r25, r17, r3, r0, r13, ComposableLambdaKt.rememberComposableLambda(850203865, true, new DateRangePickerDefaults$DateRangePickerHeadline$1(r0, r3), r7, 54), ComposableLambdaKt.rememberComposableLambda(282231642, true, new DateRangePickerDefaults$DateRangePickerHeadline$2(r13, r3), r7, 54), ComposableLambdaKt.rememberComposableLambda(-320655704, true, new DateRangePickerDefaults$DateRangePickerHeadline$3(r3), r7, 54), CalendarLocale_androidKt.defaultLocale(r7, 0), r20, ((((((r12 & 14) | 905969664) | (r12 & 112)) | (r12 & 896)) | (r12 & 7168)) | (57344 & r12)) | (458752 & r12), ((r12 >> 12) & 896) | 6);
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventEnd();
    L104:
        final Modifier r6 = r17;
        final long r10 = r3;
    L106:
        ScopeUpdateScope r14 = r20.endRestartGroup();
        if (r14 == null) goto L110;
        r14.updateScope(new e7(this, r22, r23, r24, r25, r6, r10, r30, r31));
        return;
    L110:
        return;
    L87:
        if (r7.getDefaultsInvalid() == true) goto L92;
        r7.skipToGroupEnd();
        if ((r31 & 32) == 0) goto L98;
    L105:
        r20 = r7;
        r20.skipToGroupEnd();
        r6 = r8;
        r10 = r9;
        goto L106
    L81:
        r11 = false;
        goto L83
    L72:
        if ((r30 & 1572864) != 0) goto L79;
        if (r7.changed(this) == false) goto L76;
        int r15 = 1048576;
    L77:
        r1 = r1 | r15;
        goto L79
    L76:
        r15 = 524288;
        goto L77
    L60:
        if ((r31 & 32) != 0) goto L64;
        r9 = r27;
        if (r7.changed(r9) == false) goto L65;
        int r16 = 131072;
    L66:
        r1 = r1 | r16;
    L65:
        r16 = 65536;
        goto L66
    L64:
        r9 = r27;
        goto L65
    L50:
        if ((r30 & 24576) != 0) goto L56;
        r8 = r26;
        if (r7.changed(r8) == false) goto L54;
        int r18 = 16384;
    L55:
        r1 = r1 | r18;
        goto L58
    L54:
        r18 = 8192;
        goto L55
    L37:
        if ((r30 & 3072) != 0) goto L46;
        if ((r30 & 4096) != 0) goto L41;
        boolean r4 = r7.changed(r25);
    L42:
        if (r4 == false) goto L44;
        int r5 = 2048;
    L45:
        r1 = r1 | r5;
        goto L46
    L44:
        r5 = 1024;
        goto L45
    L41:
        r4 = r7.changedInstance(r25);
        goto L42
    L27:
        if ((r30 & 384) != 0) goto L34;
        if (r7.changed(r24) == false) goto L31;
        int r19 = 256;
    L32:
        r1 = r1 | r19;
        goto L34
    L31:
        r19 = 128;
        goto L32
    L17:
        if ((r30 & 48) != 0) goto L24;
        if (r7.changed(r23) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r1 = r30;
        goto L14
    L8:
        if (r7.changed(r22) == false) goto L10;
        int r28 = 4;
    L11:
        r1 = r28 | r30;
        goto L14
    L10:
        r28 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DateRangePickerHeadline-nZrIstQ, reason: not valid java name */
    private final void m2598DateRangePickerHeadlinenZrIstQ(final Long r48, final Long r49, final int r50, final DatePickerFormatter r51, final Modifier r52, final long r53, final String r55, final String r56, final Function2<? super Composer, ? super Integer, Unit> r57, final Function2<? super Composer, ? super Integer, Unit> r58, final Function2<? super Composer, ? super Integer, Unit> r59, final Locale r60, Composer r61, final int r62, final int r63) {
        Composer r3 = r61.startRestartGroup(1381313200);
        int r2 = 2;
        if ((r62 & 6) == 0) goto L5;
        int r1 = r62;
    L10:
        int r18 = 32;
        if ((r62 & 48) != 0) goto L18;
        if (r3.changed(r49) == false) goto L15;
        int r17 = 32;
    L16:
        r1 = r1 | r17;
        goto L18
    L15:
        r17 = 16;
    L18:
        if ((r62 & 384) != 0) goto L25;
        if (r3.changed(r50) == false) goto L22;
        int r0 = 256;
    L23:
        r1 = r1 | r0;
        goto L25
    L22:
        r0 = 128;
    L25:
        if ((r62 & 3072) != 0) goto L35;
        if ((r62 & 4096) != 0) goto L29;
        boolean r4 = r3.changed(r51);
    L30:
        if (r4 == false) goto L32;
        int r5 = 2048;
    L33:
        r1 = r1 | r5;
        goto L35
    L32:
        r5 = 1024;
        goto L33
    L29:
        r4 = r3.changedInstance(r51);
    L35:
        if ((r62 & 24576) != 0) goto L42;
        if (r3.changed(r52) == false) goto L39;
        int r6 = 16384;
    L40:
        r1 = r1 | r6;
        goto L42
    L39:
        r6 = 8192;
    L42:
        if ((196608 & r62) != 0) goto L49;
        if (r3.changed(r53) == false) goto L46;
        int r7 = 131072;
    L47:
        r1 = r1 | r7;
        goto L49
    L46:
        r7 = 65536;
    L49:
        if ((1572864 & r62) != 0) goto L56;
        if (r3.changed(r55) == false) goto L53;
        int r8 = 1048576;
    L54:
        r1 = r1 | r8;
        goto L56
    L53:
        r8 = 524288;
    L56:
        if ((12582912 & r62) != 0) goto L63;
        if (r3.changed(r56) == false) goto L60;
        int r9 = 8388608;
    L61:
        r1 = r1 | r9;
        goto L63
    L60:
        r9 = 4194304;
    L63:
        if ((100663296 & r62) != 0) goto L70;
        if (r3.changedInstance(r57) == false) goto L67;
        int r10 = 67108864;
    L68:
        r1 = r1 | r10;
        goto L70
    L67:
        r10 = 33554432;
    L70:
        if ((805306368 & r62) != 0) goto L77;
        if (r3.changedInstance(r58) == false) goto L74;
        int r11 = 536870912;
    L75:
        r1 = r1 | r11;
        goto L77
    L74:
        r11 = 268435456;
    L77:
        if ((r63 & 6) == 0) goto L79;
        int r12 = r63;
    L84:
        if ((r63 & 48) == 0) goto L86;
    L90:
        int r13 = r12;
        if ((306783379 & r1) == 306783378) goto L93;
    L96:
        boolean r14 = true;
    L98:
        if (r3.shouldExecute(r14, r1 & 1) == true) goto L100;
        Composer r15 = r3;
        r15.skipToGroupEnd();
    L153:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L157;
        r16.updateScope(new h7(this, r48, r49, r50, r51, r52, r53, r55, r56, r57, r58, r59, r60, r62, r63));
        return;
    L157:
        return;
    L100:
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventStart(1381313200, r1, r13, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:468)");
    L102:
        int r42 = r1;
        String r19 = DatePickerFormatter.CC.formatDate$default(r51, r48, r60, false, 4, null);
        String r20 = DatePickerFormatter.CC.formatDate$default(r51, r49, r60, false, 4, null);
        String r21 = r51.formatDate(r48, r60, true);
        if (r21 != null) goto L112;
        r15 = r3;
        r15.startReplaceGroup(620891895);
        DisplayMode.Companion r22 = DisplayMode.Companion;
        int r23 = r50;
        if (DisplayMode.m2626equalsimpl0(r23, r22.m2631getPickerjFl4v0()) == false) goto L108;
        r15.startReplaceGroup(297125251);
        r21 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911729), r15, 0);
        r15.endReplaceGroup();
    L111:
        r15.endReplaceGroup();
    L113:
        String r24 = r51.formatDate(r49, r60, true);
        if (r24 != null) goto L123;
        r15.startReplaceGroup(621382935);
        DisplayMode.Companion r25 = DisplayMode.Companion;
        if (DisplayMode.m2626equalsimpl0(r23, r25.m2631getPickerjFl4v0()) == false) goto L119;
        r15.startReplaceGroup(297141091);
        String r26 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911729), r15, 0);
        r15.endReplaceGroup();
    L122:
        r15.endReplaceGroup();
        r24 = r26;
    L124:
        final String r27 = r55 + ": " + r21;
        final String r28 = r56 + ": " + r24;
        boolean r29 = r15.changed(r27) | r15.changed(r28);
        Object r30 = r15.rememberedValue();
        if (r29 == false) goto L127;
    L128:
        r30 = new g7(r27, r28);
        r15.updateRememberedValue(r30);
    L129:
        Modifier r31 = SemanticsModifierKt.clearAndSetSemantics(r52, (Function1) r30);
        MeasurePolicy r32 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(4)), Alignment.Companion.getCenterVertically(), r15, 54);
        int r33 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r34 = r15.getCurrentCompositionLocalMap();
        Modifier r35 = ComposedModifierKt.materializeModifier(r15, r31);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r36 = r110.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L132;
        ComposablesKt.invalidApplier();
    L132:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L135;
        r15.createNode(r36);
    L136:
        Composer r37 = Updater.constructor-impl(r15);
        Updater.set-impl(r37, r32, r110.getSetMeasurePolicy());
        Updater.set-impl(r37, r34, r110.getSetResolvedCompositionLocals());
        Function2 r38 = r110.getSetCompositeKeyHash();
        if (r37.getInserting() == false) goto L139;
    L140:
        r37.updateRememberedValue(Integer.valueOf(r33));
        r37.apply(Integer.valueOf(r33), r38);
    L141:
        Updater.set-impl(r37, r35, r110.getSetModifier());
        RowScopeInstance r39 = RowScopeInstance.INSTANCE;
        if (r19 == null) goto L144;
        r15.startReplaceGroup(-177386503);
        TextKt.m3363TextNvy7gAk(r19, null, r53, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r15, (r42 >> 9) & 896, 0, 262138);
        r15.endReplaceGroup();
    L145:
        r59.invoke(r15, Integer.valueOf(r13 & 14));
        if (r20 == null) goto L148;
        r15.startReplaceGroup(-177171301);
        TextKt.m3363TextNvy7gAk(r20, null, r53, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r15, (r42 >> 9) & 896, 0, 262138);
        r15.endReplaceGroup();
    L149:
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventEnd();
        goto L153
    L148:
        r15.startReplaceGroup(-177083974);
        r58.invoke(r15, Integer.valueOf((r42 >> 27) & 14));
        r15.endReplaceGroup();
        goto L149
    L144:
        r15.startReplaceGroup(-177297192);
        r57.invoke(r15, Integer.valueOf((r42 >> 24) & 14));
        r15.endReplaceGroup();
        goto L145
    L139:
        if (Intrinsics.areEqual(r37.rememberedValue(), Integer.valueOf(r33)) == true) goto L141;
    L135:
        r15.useNode();
        goto L136
    L127:
        if (r30 != Composer.Companion.getEmpty()) goto L129;
    L119:
        if (DisplayMode.m2626equalsimpl0(r23, r25.m2630getInputjFl4v0()) == false) goto L121;
        r15.startReplaceGroup(297144062);
        String r40 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911724), r15, 0);
        r15.endReplaceGroup();
        r26 = r40;
        goto L122
    L121:
        r15.startReplaceGroup(621604366);
        r15.endReplaceGroup();
        r26 = "";
        goto L122
    L123:
        r15.startReplaceGroup(297133385);
        r15.endReplaceGroup();
        goto L124
    L108:
        if (DisplayMode.m2626equalsimpl0(r23, r22.m2630getInputjFl4v0()) == false) goto L110;
        r15.startReplaceGroup(297128222);
        r21 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911724), r15, 0);
        r15.endReplaceGroup();
        goto L111
    L110:
        r15.startReplaceGroup(621113326);
        r15.endReplaceGroup();
        r21 = "";
        goto L111
    L112:
        r23 = r50;
        r15 = r3;
        r15.startReplaceGroup(297117483);
        r15.endReplaceGroup();
        goto L113
    L93:
        if ((r13 & 19) != 18) goto L96;
        r14 = false;
        goto L98
    L86:
        if (r3.changedInstance(r60) == true) goto L89;
        r18 = 16;
    L89:
        r12 = r12 | r18;
        goto L90
    L79:
        if (r3.changedInstance(r59) == false) goto L81;
        r2 = 4;
    L81:
        r12 = r63 | r2;
        goto L84
    L5:
        if (r3.changed(r48) == false) goto L7;
        int r41 = 4;
    L8:
        r1 = r41 | r62;
        goto L10
    L7:
        r41 = 2;
        goto L8
    }
}
