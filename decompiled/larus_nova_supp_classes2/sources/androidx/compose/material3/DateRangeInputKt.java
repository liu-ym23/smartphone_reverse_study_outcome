package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = 0.0f;

    private static final Unit DateRangeInputContent$lambda$8(Long r12, Long r13, Function2 r14, CalendarModel r15, IntRange r16, DatePickerFormatter r17, SelectableDates r18, DatePickerColors r19, FocusRequester r20, int r21, Composer r22, int r23) {
        DateRangeInputContent(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Long r1, Long r2) {
        return DateRangeInputContent$lambda$7$lambda$4$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Long r0, Long r1, Function2 r2, CalendarModel r3, IntRange r4, DatePickerFormatter r5, SelectableDates r6, DatePickerColors r7, FocusRequester r8, int r9, Composer r10, int r11) {
        return DateRangeInputContent$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit c(Function2 r0, Long r1, Long r2) {
        return DateRangeInputContent$lambda$7$lambda$6$lambda$5(r0, r1, r2);
    }

    static {
        TextFieldSpacing = Dp.constructor-impl(8);
    }

    private static final Unit DateRangeInputContent$lambda$7$lambda$4$lambda$3(Function2 r0, Long r1, Long r2) {
        r0.invoke(r2, r1);
        return Unit.INSTANCE;
    }

    private static final Unit DateRangeInputContent$lambda$7$lambda$6$lambda$5(Function2 r0, Long r1, Long r2) {
        r0.invoke(r1, r2);
        return Unit.INSTANCE;
    }

    public static final void DateRangeInputContent(final Long r31, final Long r32, final Function2<? super Long, ? super Long, Unit> r33, final CalendarModel r34, final IntRange r35, final DatePickerFormatter r36, final SelectableDates r37, final DatePickerColors r38, final FocusRequester r39, Composer r40, final int r41) {
        Composer r9 = r40.startRestartGroup(1372713366);
        if ((r41 & 6) == 0) goto L5;
        int r1 = r41;
    L11:
        if ((r41 & 48) != 0) goto L18;
        if (r9.changed(r32) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r41 & 384) != 0) goto L25;
        if (r9.changedInstance(r33) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r41 & 3072) != 0) goto L32;
        if (r9.changedInstance(r34) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r41 & 24576) != 0) goto L39;
        if (r9.changedInstance(r35) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r41) != 0) goto L49;
        if ((r41 & 262144) != 0) goto L43;
        boolean r6 = r9.changed(r36);
    L44:
        if (r6 == false) goto L46;
        int r7 = 131072;
    L47:
        r1 = r1 | r7;
        goto L49
    L46:
        r7 = 65536;
        goto L47
    L43:
        r6 = r9.changedInstance(r36);
    L49:
        if ((1572864 & r41) != 0) goto L57;
        if (r9.changed(r37) == false) goto L53;
        int r16 = 1048576;
    L54:
        r1 = r1 | r16;
        goto L57
    L53:
        r16 = 524288;
    L57:
        if ((r41 & 12582912) != 0) goto L64;
        if (r9.changed(r38) == false) goto L61;
        int r17 = 8388608;
    L62:
        r1 = r1 | r17;
        goto L64
    L61:
        r17 = 4194304;
    L64:
        if ((r41 & 100663296) != 0) goto L71;
        if (r9.changed(r39) == false) goto L68;
        int r18 = 67108864;
    L69:
        r1 = r1 | r18;
        goto L71
    L68:
        r18 = 33554432;
    L71:
        if ((r1 & 38347923) == 38347922) goto L73;
        boolean r8 = true;
    L75:
        if (r9.shouldExecute(r8, r1 & 1) == true) goto L77;
        Composer r19 = r9;
        r19.skipToGroupEnd();
    L143:
        ScopeUpdateScope r11 = r19.endRestartGroup();
        if (r11 == null) goto L147;
        r11.updateScope(new z6(r31, r32, r33, r34, r35, r36, r37, r38, r39, r41));
        return;
    L147:
        return;
    L77:
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventStart(1372713366, r1, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:44)");
    L79:
        boolean r0 = r9.changed(r34.getLocale());
        Object r10 = r9.rememberedValue();
        if (r0 == false) goto L82;
    L83:
        r10 = r34.getDateInputFormat(r34.getLocale());
        r9.updateRememberedValue(r10);
    L84:
        DateInputFormat r12 = (DateInputFormat) r10;
        String r13 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911720), r9, 0);
        String r110 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911722), r9, 0);
        String r21 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911721), r9, 0);
        String r22 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911741), r9, 0);
        boolean r14 = r9.changed(r12);
        if ((r1 & 458752) != 131072) goto L87;
    L92:
        boolean r15 = true;
    L93:
        boolean r20 = r14 | r15;
        Object r23 = r9.rememberedValue();
        if (r20 == false) goto L96;
    L99:
        char r111 = 256;
        DateInputValidator r112 = new DateInputValidator(r35, r37, r12, r36, r13, r110, r21, r22);
        r9.updateRememberedValue(r112);
        r23 = r112;
    L100:
        DateInputValidator r113 = (DateInputValidator) r23;
        r113.setCurrentStartDateMillis(r31);
        r113.setCurrentEndDateMillis(r32);
        Modifier.Companion r24 = Modifier.Companion;
        Modifier r25 = PaddingKt.padding(r24, DateInputKt.getInputTextFieldPadding());
        MeasurePolicy r26 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m806spacedBy0680j_4(TextFieldSpacing), Alignment.Companion.getTop(), r9, 6);
        int r27 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r28 = r9.getCurrentCompositionLocalMap();
        Modifier r29 = ComposedModifierKt.materializeModifier(r9, r25);
        ComposeUiNode.Companion r30 = ComposeUiNode.Companion;
        Function0 r42 = r30.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L103;
        ComposablesKt.invalidApplier();
    L103:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L106;
        r9.createNode(r42);
    L107:
        Composer r43 = Updater.constructor-impl(r9);
        Updater.set-impl(r43, r26, r30.getSetMeasurePolicy());
        Updater.set-impl(r43, r28, r30.getSetResolvedCompositionLocals());
        Function2 r44 = r30.getSetCompositeKeyHash();
        if (r43.getInserting() == false) goto L110;
    L111:
        r43.updateRememberedValue(Integer.valueOf(r27));
        r43.apply(Integer.valueOf(r27), r44);
    L112:
        Updater.set-impl(r43, r29, r30.getSetModifier());
        RowScopeInstance r114 = RowScopeInstance.INSTANCE;
        String r45 = r12.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
        String r46 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911747), r9, 0);
        Modifier r47 = RowScope.CC.weight$default(r114, r24, 0.5f, false, 2, null);
        InputIdentifier.Companion r115 = InputIdentifier.Companion;
        int r116 = r115.m2808getStartDateInputJ2x2o4M();
        Locale r210 = r34.getLocale();
        int r48 = r1 & 896;
        if (r48 != r111) goto L115;
        boolean r49 = true;
    L116:
        int r50 = r1 & 112;
        if (r50 != 32) goto L119;
        boolean r51 = true;
    L120:
        boolean r52 = r49 | r51;
        Object r53 = r9.rememberedValue();
        if (r52 == false) goto L123;
    L124:
        r53 = new x6(r33, r32);
        r9.updateRememberedValue(r53);
    L125:
        ComposableLambda r211 = ComposableLambdaKt.rememberComposableLambda(1740538748, true, new DateRangeInputKt$DateRangeInputContent$2$2(r46, r45), r9, 54);
        ComposableLambda r212 = ComposableLambdaKt.rememberComposableLambda(1229526589, true, new DateRangeInputKt$DateRangeInputContent$2$3(r45), r9, 54);
        int r54 = r1 & 7168;
        int r213 = (((r1 << 3) & 112) | 1794048) | r54;
        int r55 = r1 >> 21;
        int r214 = r55 & 14;
        boolean r117 = false;
        int r215 = r1;
        DateInputKt.m2548DateInputTextFieldxJ3Ic0Y(r47, r31, (Function1) r53, r34, r211, r212, r116, r113, r12, r210, r38, r39, r9, r213, r214 | (r55 & 112));
        String r56 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911744), r9, 0);
        Modifier r57 = RowScope.CC.weight$default(r114, r24, 0.5f, false, 2, null);
        int r58 = r115.m2806getEndDateInputJ2x2o4M();
        Locale r59 = r34.getLocale();
        if (r48 != 256) goto L128;
        boolean r60 = true;
    L130:
        if ((r215 & 14) != 4) goto L132;
        r117 = true;
    L132:
        boolean r61 = r60 | r117;
        Object r62 = r9.rememberedValue();
        if (r61 == false) goto L135;
    L138:
        boolean r63 = true;
        r62 = new y6(r33, r31);
        r9.updateRememberedValue(r62);
    L139:
        r19 = r9;
        DateInputKt.m2548DateInputTextFieldxJ3Ic0Y(r57, r32, (Function1) r62, r34, ComposableLambdaKt.rememberComposableLambda(-882370893, r63, new DateRangeInputKt$DateRangeInputContent$2$5(r56, r45), r9, 54), ComposableLambdaKt.rememberComposableLambda(1956183348, r63, new DateRangeInputKt$DateRangeInputContent$2$6(r45), r9, 54), r58, r113, r12, r59, r38, null, r9, (r50 | 1794048) | r54, r214 | 48);
        r19.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventEnd();
        goto L143
    L135:
        if (r62 == Composer.Companion.getEmpty()) goto L138;
        r63 = true;
        goto L139
    L128:
        r60 = false;
        goto L130
    L123:
        if (r53 != Composer.Companion.getEmpty()) goto L125;
    L119:
        r51 = false;
        goto L120
    L115:
        r49 = false;
        goto L116
    L110:
        if (Intrinsics.areEqual(r43.rememberedValue(), Integer.valueOf(r27)) == true) goto L112;
    L106:
        r9.useNode();
        goto L107
    L96:
        if (r23 == Composer.Companion.getEmpty()) goto L99;
        r111 = 256;
        goto L100
    L87:
        if ((262144 & r1) != 0) goto L89;
    L91:
        r15 = false;
        goto L93
    L89:
        if (r9.changed(r36) == false) goto L91;
    L82:
        if (r10 != Composer.Companion.getEmpty()) goto L84;
    L73:
        r8 = false;
        goto L75
    L5:
        if (r9.changed(r31) == false) goto L7;
        int r64 = 4;
    L8:
        r1 = r64 | r41;
        goto L11
    L7:
        r64 = 2;
        goto L8
    }
}
