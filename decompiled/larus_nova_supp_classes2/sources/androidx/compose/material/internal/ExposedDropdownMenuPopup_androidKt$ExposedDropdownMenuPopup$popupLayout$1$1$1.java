package androidx.compose.material.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Function2<Composer, Integer, Unit>> $currentContent$delegate;
    final /* synthetic */ PopupLayout $this_apply;

    public ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1(PopupLayout r1, State<? extends Function2<? super Composer, ? super Integer, Unit>> r2) {
        this.$this_apply = r1;
        this.$currentContent$delegate = r2;
    }

    public static /* synthetic */ Unit a(PopupLayout r0, IntSize r1) {
        return invoke$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
        SemanticsPropertiesKt.popup(r0);
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$3$lambda$2(PopupLayout r0, IntSize r1) {
        r0.m2247setPopupContentSizefhxjrPA(r1);
        r0.updatePosition();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r9, int r10) {
        if ((r10 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r9.shouldExecute(r0, r10 & 1) == true) goto L9;
        r9.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1879981140, r10, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.android.kt:99)");
    L11:
        Modifier.Companion r11 = Modifier.Companion;
        Object r1 = r9.rememberedValue();
        Composer.Companion r2 = Composer.Companion;
        if (r1 != r2.getEmpty()) goto L14;
        r1 = new i();
        r9.updateRememberedValue(r1);
    L14:
        Modifier r12 = SemanticsModifierKt.semantics$default(r11, false, (Function1) r1, 1, null);
        boolean r3 = r9.changedInstance(this.$this_apply);
        final PopupLayout r4 = this.$this_apply;
        Object r5 = r9.rememberedValue();
        if (r3 == false) goto L17;
    L18:
        r5 = new j(r4);
        r9.updateRememberedValue(r5);
    L19:
        Modifier r13 = OnRemeasuredModifierKt.onSizeChanged(r12, (Function1) r5);
        if (this.$this_apply.getCanCalculatePosition() == false) goto L22;
        float r6 = 1.0f;
    L23:
        Modifier r14 = AlphaKt.alpha(r13, r6);
        Function2 r7 = ExposedDropdownMenuPopup_androidKt.access$ExposedDropdownMenuPopup$lambda$0(this.$currentContent$delegate);
        Object r8 = r9.rememberedValue();
        if (r8 != r2.getEmpty()) goto L26;
        r8 = ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.INSTANCE;
        r9.updateRememberedValue(r8);
    L26:
        MeasurePolicy r15 = (MeasurePolicy) r8;
        int r16 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r17 = r9.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r9, r14);
        ComposeUiNode.Companion r19 = ComposeUiNode.Companion;
        Function0 r20 = r19.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L29;
        ComposablesKt.invalidApplier();
    L29:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L32;
        r9.createNode(r20);
    L33:
        Composer r21 = Updater.constructor-impl(r9);
        Updater.set-impl(r21, r15, r19.getSetMeasurePolicy());
        Updater.set-impl(r21, r17, r19.getSetResolvedCompositionLocals());
        Function2 r22 = r19.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L36;
    L37:
        r21.updateRememberedValue(Integer.valueOf(r16));
        r21.apply(Integer.valueOf(r16), r22);
    L38:
        Updater.set-impl(r21, r18, r19.getSetModifier());
        r7.invoke(r9, 0);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
        return;
    L43:
        return;
    L36:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r16)) == true) goto L38;
    L32:
        r9.useNode();
        goto L33
    L22:
        r6 = MenuKt.ClosedAlphaTarget;
        goto L23
    L17:
        if (r5 != r2.getEmpty()) goto L19;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
