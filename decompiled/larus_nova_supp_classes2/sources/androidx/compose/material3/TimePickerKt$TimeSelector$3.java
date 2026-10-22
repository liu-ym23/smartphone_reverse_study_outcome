package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt$TimeSelector$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $contentColor;
    final /* synthetic */ int $selection;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ int $value;

    public TimePickerKt$TimeSelector$3(int r1, TimePickerState r2, int r3, long r4) {
        this.$selection = r1;
        this.$state = r2;
        this.$value = r3;
        this.$contentColor = r4;
    }

    public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
        return invoke$lambda$2$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$2$lambda$1$lambda$0(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r30, int r31) {
        if ((r31 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r30.shouldExecute(r2, r31 & 1) == true) goto L9;
        r30.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1477282471, r31, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1431)");
    L11:
        final String r1 = TimePickerKt.m3415numberContentDescriptiondSwYdS4(this.$selection, this.$state.is24hour(), this.$value, r30, 0);
        Alignment r3 = Alignment.Companion.getCenter();
        int r7 = this.$value;
        long r14 = this.$contentColor;
        Modifier.Companion r4 = Modifier.Companion;
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(r3, false);
        int r8 = ComposablesKt.getCurrentCompositeKeyHash(r30, 0);
        CompositionLocalMap r9 = r30.getCurrentCompositionLocalMap();
        Modifier r10 = ComposedModifierKt.materializeModifier(r30, r4);
        ComposeUiNode.Companion r11 = ComposeUiNode.Companion;
        Function0 r12 = r11.getConstructor();
        if ((r30.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r30.startReusableNode();
        if (r30.getInserting() == false) goto L17;
        r30.createNode(r12);
    L18:
        Composer r13 = Updater.constructor-impl(r30);
        Updater.set-impl(r13, r5, r11.getSetMeasurePolicy());
        Updater.set-impl(r13, r9, r11.getSetResolvedCompositionLocals());
        Function2 r6 = r11.getSetCompositeKeyHash();
        if (r13.getInserting() == false) goto L21;
    L22:
        r13.updateRememberedValue(Integer.valueOf(r8));
        r13.apply(Integer.valueOf(r8), r6);
    L23:
        Updater.set-impl(r13, r10, r11.getSetModifier());
        BoxScopeInstance r15 = BoxScopeInstance.INSTANCE;
        boolean r16 = r30.changed(r1);
        Object r17 = r30.rememberedValue();
        if (r16 == false) goto L26;
    L27:
        r17 = new lw(r1);
        r30.updateRememberedValue(r17);
    L28:
        Modifier r18 = SemanticsModifierKt.semantics$default(r4, false, (Function1) r17, 1, null);
        TextKt.m3363TextNvy7gAk(CalendarLocale_jvmKt.toLocalString$default(r7, 2, 0, false, null, 14, null), r18, r14, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r30, 0, 0, 262136);
        r30.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        return;
    L33:
        return;
    L26:
        if (r17 != Composer.Companion.getEmpty()) goto L28;
    L21:
        if (Intrinsics.areEqual(r13.rememberedValue(), Integer.valueOf(r8)) == true) goto L23;
    L17:
        r30.useNode();
        goto L18
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
