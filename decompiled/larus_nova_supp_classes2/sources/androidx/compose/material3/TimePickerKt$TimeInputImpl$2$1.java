package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
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
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt$TimeInputImpl$2$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ Ref<Boolean> $userOverride;

    public TimePickerKt$TimeInputImpl$2$1(MutableState<TextFieldValue> r1, TimePickerState r2, Ref<Boolean> r3, TimePickerColors r4, MutableState<TextFieldValue> r5) {
        this.$hourValue$delegate = r1;
        this.$state = r2;
        this.$userOverride = r3;
        this.$colors = r4;
        this.$minuteValue$delegate = r5;
    }

    public static /* synthetic */ Unit a(TimePickerState r0, Ref r1, MutableState r2, TextFieldValue r3) {
        return invoke$lambda$12$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(TimePickerState r0, KeyboardActionScope r1) {
        return invoke$lambda$12$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit c(TimePickerState r0, KeyboardActionScope r1) {
        return invoke$lambda$12$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit d(TimePickerState r0, Ref r1, MutableState r2, TextFieldValue r3) {
        return invoke$lambda$12$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(MutableState r0, TextFieldValue r1) {
        return invoke$lambda$12$lambda$9$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit f(MutableState r0, TextFieldValue r1) {
        return invoke$lambda$12$lambda$3$lambda$2$lambda$1(r0, r1);
    }

    private static final Unit invoke$lambda$12$lambda$11$lambda$10(TimePickerState r0, KeyboardActionScope r1) {
        r0.mo2288setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$12$lambda$3$lambda$2$lambda$1(MutableState r0, TextFieldValue r1) {
        TimePickerKt.access$TimeInputImpl$lambda$19(r0, r1);
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$12$lambda$5$lambda$4(TimePickerState r0, KeyboardActionScope r1) {
        r0.mo2288setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$12$lambda$9$lambda$8$lambda$7(MutableState r0, TextFieldValue r1) {
        TimePickerKt.access$TimeInputImpl$lambda$23(r0, r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r40, int r41) {
        if ((r41 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r40.shouldExecute(r2, r41 & 1) == true) goto L9;
        r40.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1306700887, r41, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:1032)");
    L11:
        final MutableState<TextFieldValue> r1 = this.$hourValue$delegate;
        final TimePickerState r13 = this.$state;
        final Ref<Boolean> r14 = this.$userOverride;
        TimePickerColors r15 = this.$colors;
        final MutableState<TextFieldValue> r11 = this.$minuteValue$delegate;
        Modifier.Companion r10 = Modifier.Companion;
        MeasurePolicy r3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), r40, 0);
        int r4 = ComposablesKt.getCurrentCompositeKeyHash(r40, 0);
        CompositionLocalMap r5 = r40.getCurrentCompositionLocalMap();
        Modifier r6 = ComposedModifierKt.materializeModifier(r40, r10);
        ComposeUiNode.Companion r7 = ComposeUiNode.Companion;
        Function0 r8 = r7.getConstructor();
        if ((r40.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r40.startReusableNode();
        if (r40.getInserting() == false) goto L17;
        r40.createNode(r8);
    L18:
        Composer r9 = Updater.constructor-impl(r40);
        Updater.set-impl(r9, r3, r7.getSetMeasurePolicy());
        Updater.set-impl(r9, r5, r7.getSetResolvedCompositionLocals());
        Function2 r12 = r7.getSetCompositeKeyHash();
        if (r9.getInserting() == false) goto L21;
    L22:
        r9.updateRememberedValue(Integer.valueOf(r4));
        r9.apply(Integer.valueOf(r4), r12);
    L23:
        Updater.set-impl(r9, r6, r7.getSetModifier());
        RowScopeInstance r16 = RowScopeInstance.INSTANCE;
        boolean r17 = r40.changed(r1) | r40.changedInstance(r13);
        Object r18 = r40.rememberedValue();
        if (r17 == false) goto L26;
    L27:
        r18 = new TimePickerKt$TimeInputImpl$2$1$1$1$1(r13, r1);
        r40.updateRememberedValue(r18);
    L28:
        Modifier r19 = KeyInputModifierKt.onKeyEvent(r10, (Function1) r18);
        TextFieldValue r20 = TimePickerKt.access$TimeInputImpl$lambda$18(r1);
        boolean r21 = (r40.changedInstance(r13) | r40.changed(r1)) | r40.changedInstance(r14);
        Object r22 = r40.rememberedValue();
        if (r21 == false) goto L31;
    L32:
        r22 = new gw(r13, r14, r1);
        r40.updateRememberedValue(r22);
    L33:
        Function1 r23 = (Function1) r22;
        TimePickerSelectionMode.Companion r110 = TimePickerSelectionMode.Companion;
        int r24 = r110.m3439getHouryecRtBI();
        ImeAction.Companion r111 = ImeAction.Companion;
        int r25 = r111.getNext-eUduSuo();
        KeyboardType.Companion r28 = KeyboardType.Companion;
        KeyboardOptions r26 = new KeyboardOptions(0, null, r28.getNumber-PjHm6EE(), r25, null, null, null, 115, null);
        boolean r27 = r40.changedInstance(r13);
        Object r29 = r40.rememberedValue();
        if (r27 == false) goto L36;
    L37:
        r29 = new hw(r13);
        r40.updateRememberedValue(r29);
    L38:
        TimePickerKt.m3409access$TimePickerTextField1vLObsk(r19, r20, r23, r13, r24, r26, new KeyboardActions(null, null, (Function1) r29, null, null, null, 59, null), r15, r40, 24576, 0);
        TimePickerKt.access$DisplaySeparator(SizeKt.m1016sizeVpY3zN4(r10, TimePickerKt.access$getDisplaySeparatorWidth$p(), TimeInputTokens.INSTANCE.getPeriodSelectorContainerHeight-D9Ej5fM()), r40, 6);
        boolean r30 = r40.changed(r11) | r40.changedInstance(r13);
        Object r31 = r40.rememberedValue();
        if (r30 == false) goto L41;
    L42:
        r31 = new TimePickerKt$TimeInputImpl$2$1$1$4$1(r13, r11);
        r40.updateRememberedValue(r31);
    L43:
        Modifier r32 = KeyInputModifierKt.onPreviewKeyEvent(r10, (Function1) r31);
        TextFieldValue r33 = TimePickerKt.access$TimeInputImpl$lambda$22(r11);
        boolean r0 = (r40.changedInstance(r13) | r40.changed(r11)) | r40.changedInstance(r14);
        Object r34 = r40.rememberedValue();
        if (r0 == false) goto L46;
    L47:
        r34 = new iw(r13, r14, r11);
        r40.updateRememberedValue(r34);
    L48:
        Function1 r35 = (Function1) r34;
        int r36 = r110.m3440getMinuteyecRtBI();
        int r37 = r111.getDone-eUduSuo();
        KeyboardOptions r38 = new KeyboardOptions(0, null, r28.getNumber-PjHm6EE(), r37, null, null, null, 115, null);
        boolean r39 = r40.changedInstance(r13);
        Object r42 = r40.rememberedValue();
        if (r39 == false) goto L51;
    L52:
        r42 = new jw(r13);
        r40.updateRememberedValue(r42);
    L53:
        TimePickerKt.m3409access$TimePickerTextField1vLObsk(r32, r33, r35, r13, r36, r38, new KeyboardActions(null, null, (Function1) r42, null, null, null, 59, null), r15, r40, 24576, 0);
        r40.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventEnd();
        return;
    L58:
        return;
    L51:
        if (r42 != Composer.Companion.getEmpty()) goto L53;
    L46:
        if (r34 != Composer.Companion.getEmpty()) goto L48;
    L41:
        if (r31 != Composer.Companion.getEmpty()) goto L43;
    L36:
        if (r29 != Composer.Companion.getEmpty()) goto L38;
    L31:
        if (r22 != Composer.Companion.getEmpty()) goto L33;
    L26:
        if (r18 != Composer.Companion.getEmpty()) goto L28;
    L21:
        if (Intrinsics.areEqual(r9.rememberedValue(), Integer.valueOf(r4)) == true) goto L23;
    L17:
        r40.useNode();
        goto L18
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$12$lambda$3$lambda$2(TimePickerState r8, Ref r9, final MutableState r10, TextFieldValue r11) {
        int r1 = TimePickerSelectionMode.Companion.m3439getHouryecRtBI();
        TextFieldValue r4 = TimePickerKt.access$TimeInputImpl$lambda$18(r10);
        if (r8.is24hour() == false) goto L5;
        int r5 = 23;
    L6:
        TimePickerKt.m3413access$timeInputOnChange_K77t0(r1, r8, r11, r4, r5, r9, new kw(r10));
        return Unit.INSTANCE;
    L5:
        r5 = 12;
        goto L6
    }

    private static final Unit invoke$lambda$12$lambda$9$lambda$8(TimePickerState r8, Ref r9, final MutableState r10, TextFieldValue r11) {
        TimePickerKt.m3413access$timeInputOnChange_K77t0(TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI(), r8, r11, TimePickerKt.access$TimeInputImpl$lambda$22(r10), 59, r9, new fw(r10));
        return Unit.INSTANCE;
    }
}
