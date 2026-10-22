package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001an\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032#\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a\u009f\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060%j\u0002`&2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b'\u0010(\"\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,\"\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u008e\u0002"}, d2 = {"DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-xJ3Ic0Y", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding = null;
    private static final float InputTextNonErroneousBottomPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String $labelText;
        final /* synthetic */ String $pattern;

        public AnonymousClass2(String r1, String r2) {
            this.$labelText = r1;
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
            ComposerKt.traceEventStart(-752164549, r29, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:93)");
        L11:
            String r15 = this.$labelText;
            Modifier.Companion r2 = Modifier.Companion;
            boolean r4 = r28.changed(r15) | r28.changed(this.$pattern);
            final String r5 = this.$labelText;
            final String r7 = this.$pattern;
            Object r8 = r28.rememberedValue();
            if (r4 == false) goto L14;
        L15:
            r8 = new q4(r5, r7);
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

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String $pattern;

        public AnonymousClass3(String r1) {
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
            ComposerKt.traceEventStart(-1179434278, r28, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:98)");
        L11:
            String r15 = this.$pattern;
            Modifier.Companion r1 = Modifier.Companion;
            Object r3 = r27.rememberedValue();
            if (r3 != Composer.Companion.getEmpty()) goto L14;
            r3 = new r4();
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

    private static final Unit DateInputContent$lambda$3(Long r11, Function1 r12, CalendarModel r13, IntRange r14, DatePickerFormatter r15, SelectableDates r16, DatePickerColors r17, FocusRequester r18, int r19, Composer r20, int r21) {
        DateInputContent(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DateInputTextField_xJ3Ic0Y$lambda$17(Modifier r16, Long r17, Function1 r18, CalendarModel r19, Function2 r20, Function2 r21, int r22, DateInputValidator r23, DateInputFormat r24, Locale r25, DatePickerColors r26, FocusRequester r27, int r28, int r29, Composer r30, int r31) {
        m2548DateInputTextFieldxJ3Ic0Y(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), RecomposeScopeImplKt.updateChangedFlags(r29));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ MutableState a() {
        return DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4();
    }

    public static /* synthetic */ MutableState b(DateInputValidator r0, CalendarModel r1, DateInputFormat r2, Locale r3, int r4, MutableState r5) {
        return DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(DateInputFormat r0, MutableState r1, Function1 r2, CalendarModel r3, Locale r4, DateInputValidator r5, int r6, MutableState r7, TextFieldValue r8) {
        return DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit d(MutableState r0, SemanticsPropertyReceiver r1) {
        return DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ Unit e(Modifier r0, Long r1, Function1 r2, CalendarModel r3, Function2 r4, Function2 r5, int r6, DateInputValidator r7, DateInputFormat r8, Locale r9, DatePickerColors r10, FocusRequester r11, int r12, int r13, Composer r14, int r15) {
        return DateInputTextField_xJ3Ic0Y$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit f(Long r0, Function1 r1, CalendarModel r2, IntRange r3, DatePickerFormatter r4, SelectableDates r5, DatePickerColors r6, FocusRequester r7, int r8, Composer r9, int r10) {
        return DateInputContent$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        float r0 = 24;
        InputTextFieldPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(Dp.constructor-impl(r0), Dp.constructor-impl(10), Dp.constructor-impl(r0), MenuKt.ClosedAlphaTarget, 8, null);
        InputTextNonErroneousBottomPadding = Dp.constructor-impl(16);
    }

    private static final MutableState DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4() {
        return SnapshotStateKt.mutableStateOf$default(new TextFieldValue(null, 0, null, 7, null), null, 2, null);
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }

    private static final TextFieldValue DateInputTextField_xJ3Ic0Y$lambda$6(MutableState<TextFieldValue> r0) {
        return (TextFieldValue) r0.getValue();
    }

    private static final Unit DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(MutableState r1, SemanticsPropertyReceiver r2) {
        if ((!StringsKt.isBlank((CharSequence) r1.getValue())) == false) goto L6;
        SemanticsPropertiesKt.error(r2, (String) r1.getValue());
    L6:
        return Unit.INSTANCE;
    }

    private static final void DateInputTextField_xJ3Ic0Y$lambda$7(MutableState<TextFieldValue> r0, TextFieldValue r1) {
        r0.setValue(r1);
    }

    public static final /* synthetic */ void access$DateInputTextField_xJ3Ic0Y$lambda$7(MutableState r0, TextFieldValue r1) {
        DateInputTextField_xJ3Ic0Y$lambda$7(r0, r1);
    }

    private static final MutableState DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(DateInputValidator r1, CalendarModel r2, DateInputFormat r3, Locale r4, int r5, MutableState r6) {
        if (DateInputTextField_xJ3Ic0Y$lambda$6(r6).getText().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r7 = r1.m2549validateXivgLIo(r2.parse(DateInputTextField_xJ3Ic0Y$lambda$6(r6).getText(), r3.getPatternWithoutDelimiters(), r4), r5, r4);
    L10:
        return SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
    L8:
        r7 = "";
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(DateInputFormat r5, MutableState r6, Function1 r7, CalendarModel r8, Locale r9, DateInputValidator r10, int r11, MutableState r12, TextFieldValue r13) {
        if (r13.getText().length() > r5.getPatternWithoutDelimiters().length()) goto L31;
        String r0 = r13.getText();
        boolean r1 = false;
        int r2 = 0;
    L6:
        if (r2 >= r0.length()) goto L11;
        if (Character.isDigit(r0.charAt(r2)) == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L31;
        DateInputTextField_xJ3Ic0Y$lambda$7(r12, r13);
        String r14 = StringsKt.trim(r13.getText()).toString();
        if (r14.length() != 0) goto L16;
        boolean r15 = true;
    L17:
        Long r4 = null;
        if (r15 == false) goto L20;
    L29:
        r6.setValue("");
        r7.invoke(null);
        goto L31
    L20:
        if (r14.length() < r5.getPatternWithoutDelimiters().length()) goto L29;
        CalendarDate r16 = r8.parse(r14, r5.getPatternWithoutDelimiters(), r9);
        r6.setValue(r10.m2549validateXivgLIo(r16, r11, r9));
        if (((CharSequence) r6.getValue()).length() != 0) goto L25;
        r1 = true;
    L25:
        if (r1 == false) goto L28;
        if (r16 == null) goto L28;
        r4 = Long.valueOf(r16.getUtcTimeMillis());
    L28:
        r7.invoke(r4);
        goto L31
    L16:
        r15 = false;
        goto L17
    L11:
        r3 = true;
    L31:
        return Unit.INSTANCE;
    }

    public static final void DateInputContent(final Long r22, final Function1<? super Long, Unit> r23, final CalendarModel r24, final IntRange r25, final DatePickerFormatter r26, final SelectableDates r27, final DatePickerColors r28, final FocusRequester r29, Composer r30, final int r31) {
        Composer r11 = r30.startRestartGroup(-432341251);
        if ((r31 & 6) == 0) goto L5;
        int r1 = r31;
    L11:
        if ((r31 & 48) != 0) goto L18;
        if (r11.changedInstance(r23) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r31 & 384) != 0) goto L25;
        if (r11.changedInstance(r24) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r31 & 3072) != 0) goto L32;
        if (r11.changedInstance(r25) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r31 & 24576) != 0) goto L42;
        if ((r31 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) != 0) goto L36;
        boolean r5 = r11.changed(r26);
    L37:
        if (r5 == false) goto L39;
        int r6 = 16384;
    L40:
        r1 = r1 | r6;
        goto L42
    L39:
        r6 = 8192;
        goto L40
    L36:
        r5 = r11.changedInstance(r26);
    L42:
        if ((196608 & r31) != 0) goto L49;
        if (r11.changed(r27) == false) goto L46;
        int r7 = 131072;
    L47:
        r1 = r1 | r7;
        goto L49
    L46:
        r7 = 65536;
    L49:
        if ((1572864 & r31) != 0) goto L56;
        if (r11.changed(r28) == false) goto L53;
        int r8 = 1048576;
    L54:
        r1 = r1 | r8;
        goto L56
    L53:
        r8 = 524288;
    L56:
        if ((12582912 & r31) == 0) goto L58;
    L62:
        int r9 = r1;
        if ((4793491 & r9) == 4793490) goto L65;
        boolean r10 = true;
    L67:
        if (r11.shouldExecute(r10, r9 & 1) == true) goto L69;
        Composer r18 = r11;
        r18.skipToGroupEnd();
    L96:
        ScopeUpdateScope r12 = r18.endRestartGroup();
        if (r12 == null) goto L100;
        r12.updateScope(new k4(r22, r23, r24, r25, r26, r27, r28, r29, r31));
        return;
    L100:
        return;
    L69:
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventStart(-432341251, r9, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:67)");
    L71:
        boolean r0 = r11.changed(r24.getLocale());
        Object r13 = r11.rememberedValue();
        if (r0 == false) goto L74;
    L75:
        r13 = r24.getDateInputFormat(r24.getLocale());
        r11.updateRememberedValue(r13);
    L76:
        DateInputFormat r14 = (DateInputFormat) r13;
        String r17 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911720), r11, 0);
        String r19 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911722), r11, 0);
        String r110 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911721), r11, 0);
        boolean r15 = r11.changed(r14);
        if ((57344 & r9) != 16384) goto L79;
    L84:
        boolean r16 = true;
    L85:
        boolean r20 = r15 | r16;
        Object r21 = r11.rememberedValue();
        if (r20 == false) goto L88;
    L91:
        DateInputFormat r210 = r14;
        int r111 = 0;
        DateInputValidator r32 = new DateInputValidator(r25, r27, r210, r26, r17, r19, r110, "");
        r11.updateRememberedValue(r32);
        r21 = r32;
    L92:
        DateInputValidator r33 = (DateInputValidator) r21;
        String r34 = r210.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
        String r35 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911723), r11, r111);
        Modifier r36 = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, 1, null), InputTextFieldPadding);
        int r37 = InputIdentifier.Companion.m2807getSingleDateInputJ2x2o4M();
        r33.setCurrentStartDateMillis(r22);
        Locale r38 = r24.getLocale();
        ComposableLambda r39 = ComposableLambdaKt.rememberComposableLambda(-752164549, true, new AnonymousClass2(r35, r34), r11, 54);
        ComposableLambda r40 = ComposableLambdaKt.rememberComposableLambda(-1179434278, true, new AnonymousClass3(r34), r11, 54);
        int r41 = r9 << 3;
        int r112 = (((r41 & 112) | 1794054) | (r41 & 896)) | (r41 & 7168);
        int r42 = r9 >> 18;
        DateInputFormat r43 = r210;
        r18 = r11;
        m2548DateInputTextFieldxJ3Ic0Y(r36, r22, r23, r24, r39, r40, r37, r33, r43, r38, r28, r29, r18, r112, (r42 & 14) | (r42 & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventEnd();
        goto L96
    L88:
        if (r21 == Composer.Companion.getEmpty()) goto L91;
        r210 = r14;
        r111 = 0;
        goto L92
    L79:
        if ((32768 & r9) != 0) goto L81;
    L83:
        r16 = false;
        goto L85
    L81:
        if (r11.changed(r26) == false) goto L83;
    L74:
        if (r13 != Composer.Companion.getEmpty()) goto L76;
    L65:
        r10 = false;
        goto L67
    L58:
        if (r11.changed(r29) == false) goto L60;
        int r44 = 8388608;
    L61:
        r1 = r1 | r44;
        goto L62
    L60:
        r44 = 4194304;
        goto L61
    L5:
        if (r11.changed(r22) == false) goto L7;
        int r45 = 4;
    L8:
        r1 = r45 | r31;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: DateInputTextField-xJ3Ic0Y, reason: not valid java name */
    public static final void m2548DateInputTextFieldxJ3Ic0Y(final Modifier r51, final Long r52, final Function1<? super Long, Unit> r53, final CalendarModel r54, final Function2<? super Composer, ? super Integer, Unit> r55, final Function2<? super Composer, ? super Integer, Unit> r56, final int r57, final DateInputValidator r58, final DateInputFormat r59, final Locale r60, final DatePickerColors r61, final FocusRequester r62, Composer r63, final int r64, final int r65) {
        Composer r10 = r63.startRestartGroup(1456309913);
        int r3 = 2;
        if ((r64 & 6) == 0) goto L5;
        int r1 = r64;
    L10:
        int r5 = 16;
        if ((r64 & 48) != 0) goto L18;
        if (r10.changed(r52) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r64 & 384) != 0) goto L26;
        if (r10.changedInstance(r53) == false) goto L22;
        int r16 = 256;
    L23:
        r1 = r1 | r16;
        goto L26
    L22:
        r16 = 128;
    L26:
        if ((r64 & 3072) != 0) goto L33;
        if (r10.changedInstance(r54) == false) goto L30;
        int r2 = 2048;
    L31:
        r1 = r1 | r2;
        goto L33
    L30:
        r2 = 1024;
    L33:
        if ((r64 & 24576) != 0) goto L41;
        if (r10.changedInstance(r55) == false) goto L37;
        int r17 = 16384;
    L38:
        r1 = r1 | r17;
        goto L41
    L37:
        r17 = 8192;
    L41:
        if ((r64 & 196608) != 0) goto L48;
        if (r10.changedInstance(r56) == false) goto L45;
        int r18 = 131072;
    L46:
        r1 = r1 | r18;
        goto L48
    L45:
        r18 = 65536;
    L48:
        if ((r64 & 1572864) != 0) goto L55;
        if (r10.changed(r57) == false) goto L52;
        int r19 = 1048576;
    L53:
        r1 = r1 | r19;
        goto L55
    L52:
        r19 = 524288;
    L55:
        if ((r64 & 12582912) != 0) goto L62;
        if (r10.changed(r58) == false) goto L59;
        int r20 = 8388608;
    L60:
        r1 = r1 | r20;
        goto L62
    L59:
        r20 = 4194304;
    L62:
        if ((r64 & 100663296) != 0) goto L69;
        if (r10.changed(r59) == false) goto L66;
        int r21 = 67108864;
    L67:
        r1 = r1 | r21;
        goto L69
    L66:
        r21 = 33554432;
    L69:
        if ((r64 & 805306368) != 0) goto L76;
        if (r10.changedInstance(r60) == false) goto L73;
        int r22 = 536870912;
    L74:
        r1 = r1 | r22;
        goto L76
    L73:
        r22 = 268435456;
    L76:
        if ((r65 & 6) == 0) goto L78;
        int r6 = r65;
    L83:
        if ((r65 & 48) == 0) goto L85;
    L88:
        int r7 = r6;
        if ((306783379 & r1) == 306783378) goto L91;
    L94:
        boolean r8 = true;
    L96:
        if (r10.shouldExecute(r8, r1 & 1) == true) goto L98;
        Composer r9 = r10;
        r9.skipToGroupEnd();
    L185:
        ScopeUpdateScope r15 = r9.endRestartGroup();
        if (r15 == null) goto L189;
        r15.updateScope(new p4(r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r64, r65));
        return;
    L189:
        return;
    L98:
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventStart(1456309913, r1, r7, "androidx.compose.material3.DateInputTextField (DateInput.kt:128)");
    L100:
        Object[] r11 = new Object[0];
        Saver r12 = TextFieldValue.Companion.getSaver();
        Object r13 = r10.rememberedValue();
        Composer.Companion r36 = Composer.Companion;
        if (r13 != r36.getEmpty()) goto L103;
        r13 = new l4();
        r10.updateRememberedValue(r13);
    L103:
        final MutableState r14 = RememberSaveableKt.rememberSaveable(r11, r12, (Function0) r13, r10, 384);
        Object[] r23 = {DateInputTextField_xJ3Ic0Y$lambda$6(r14)};
        boolean r0 = r10.changed(r14);
        int r24 = r1 & 29360128;
        if (r24 != 8388608) goto L106;
        boolean r25 = true;
    L107:
        boolean r26 = (r0 | r25) | r10.changedInstance(r54);
        int r27 = 234881024 & r1;
        if (r27 != 67108864) goto L110;
        boolean r28 = true;
    L111:
        boolean r29 = (r26 | r28) | r10.changedInstance(r60);
        int r30 = r1 & 3670016;
        int r210 = r1;
        if (r30 != 1048576) goto L114;
        boolean r31 = true;
    L115:
        boolean r32 = r29 | r31;
        Object r33 = r10.rememberedValue();
        if (r32 == false) goto L118;
    L121:
        int r211 = r24;
        int r110 = r30;
        char r34 = 256;
        Function0 r35 = new m4(r58, r54, r59, r60, r57, r14);
        r10.updateRememberedValue(r35);
        r33 = r35;
    L122:
        final MutableState r37 = (MutableState) RememberSaveableKt.rememberSaveable(r23, (Function0) r33, r10, 0);
        if (StringsKt.isBlank((CharSequence) r37.getValue()) == false) goto L125;
        float r38 = InputTextNonErroneousBottomPadding;
    L126:
        TextFieldValue r39 = DateInputTextField_xJ3Ic0Y$lambda$6(r14);
        if (r27 != 67108864(0x4000000, float:1.5046328E-36)) goto L129;
        boolean r40 = true;
    L130:
        boolean r41 = (r40 | r10.changed(r14)) | r10.changed(r37);
        if ((r210 & 896) != r34) goto L133;
        boolean r42 = true;
    L134:
        boolean r43 = ((r41 | r42) | r10.changedInstance(r54)) | r10.changedInstance(r60);
        if (r211 != 8388608) goto L137;
        boolean r44 = true;
    L138:
        boolean r45 = r43 | r44;
        if (r110 != 1048576) goto L141;
        boolean r46 = true;
    L142:
        boolean r47 = r45 | r46;
        Object r48 = r10.rememberedValue();
        if (r47 == false) goto L145;
    L148:
        Composer r49 = r10;
        r48 = new n4(r59, r37, r53, r54, r60, r58, r57, r14);
        r49.updateRememberedValue(r48);
    L149:
        Function1 r50 = (Function1) r48;
        Modifier r66 = PaddingKt.m964paddingqDBjuR0$default(r51, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r38, 7, null);
        boolean r67 = r49.changed(r37);
        Object r68 = r49.rememberedValue();
        if (r67 == false) goto L152;
    L153:
        r68 = new o4(r37);
        r49.updateRememberedValue(r68);
    L154:
        Modifier r69 = SemanticsModifierKt.semantics$default(r66, false, (Function1) r68, 1, null);
        if (r62 == 0) goto L157;
        Modifier r70 = FocusRequesterModifierKt.focusRequester(Modifier.Companion, r62);
    L158:
        int r71 = r210 << 6;
        int r310 = (r71 & 3670016) | (r71 & 29360128);
        boolean r72 = false;
        OutlinedTextFieldKt.OutlinedTextField(r39, r50, r69.then(r70), false, false, null, r55, r56, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-357881838, true, new DateInputKt$DateInputTextField$3(r37), r49, 54), !StringsKt.isBlank((CharSequence) r37.getValue()), new DateVisualTransformation(r59), new KeyboardOptions(0, Boolean.FALSE, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), null, null, null, 113, null), null, true, 0, 0, null, null, r61.getDateTextFieldColors(), r49, r310, 12779904, 0, 4001592);
        Unit r73 = Unit.INSTANCE;
        if ((r7 & 112) != 32) goto L161;
        boolean r74 = true;
    L162:
        Object r75 = r49.rememberedValue();
        if (r74 == false) goto L165;
    L166:
        r75 = new DateInputKt$DateInputTextField$4$1(r62, null);
        r49.updateRememberedValue(r75);
    L167:
        EffectsKt.LaunchedEffect(r73, (Function2) r75, r49, 6);
        if ((r210 & 112) != 32) goto L170;
        boolean r76 = true;
    L171:
        boolean r77 = r76 | r49.changedInstance(r54);
        if (r27 != 67108864) goto L174;
        r72 = true;
    L174:
        boolean r78 = ((r77 | r72) | r49.changedInstance(r60)) | r49.changed(r14);
        Object r79 = r49.rememberedValue();
        if (r78 == false) goto L177;
    L180:
        r9 = r49;
        DateInputKt$DateInputTextField$5$1 r80 = new DateInputKt$DateInputTextField$5$1(r52, r54, r59, r60, r14, null);
        r9.updateRememberedValue(r80);
        r79 = r80;
    L181:
        EffectsKt.LaunchedEffect(r52, (Function2) r79, r9, (r210 >> 3) & 14);
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventEnd();
        goto L185
    L177:
        if (r79 == r36.getEmpty()) goto L180;
        r9 = r49;
        goto L181
    L170:
        r76 = false;
        goto L171
    L165:
        if (r75 != r36.getEmpty()) goto L167;
    L161:
        r74 = false;
        goto L162
    L157:
        r70 = Modifier.Companion;
        goto L158
    L152:
        if (r68 != r36.getEmpty()) goto L154;
    L145:
        if (r48 == r36.getEmpty()) goto L148;
        r49 = r10;
        goto L149
    L141:
        r46 = false;
        goto L142
    L137:
        r44 = false;
        goto L138
    L133:
        r42 = false;
        goto L134
    L129:
        r40 = false;
        goto L130
    L125:
        PaddingValues r81 = TextFieldDefaults.m3337supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        r38 = Dp.constructor-impl(InputTextNonErroneousBottomPadding - Dp.constructor-impl(r81.mo898calculateBottomPaddingD9Ej5fM() + r81.mo901calculateTopPaddingD9Ej5fM()));
        goto L126
    L118:
        if (r33 == r36.getEmpty()) goto L121;
        r34 = 256;
        r211 = r24;
        r110 = r30;
        goto L122
    L114:
        r31 = false;
        goto L115
    L110:
        r28 = false;
        goto L111
    L106:
        r25 = false;
        goto L107
    L91:
        if ((r7 & 19) != 18) goto L94;
        r8 = false;
        goto L96
    L85:
        if (r10.changed(r62) == false) goto L87;
        r5 = 32;
    L87:
        r6 = r6 | r5;
        goto L88
    L78:
        if (r10.changed(r61) == false) goto L80;
        r3 = 4;
    L80:
        r6 = r65 | r3;
        goto L83
    L5:
        if (r10.changed(r51) == false) goto L7;
        int r82 = 4;
    L8:
        r1 = r82 | r64;
        goto L10
    L7:
        r82 = 2;
        goto L8
    }
}
