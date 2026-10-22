package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarKt$NavigationBarItem$styledIcon$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ FiniteAnimationSpec<Color> $colorAnimationSpec;
    final /* synthetic */ NavigationBarItemColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ boolean $selected;

    public NavigationBarKt$NavigationBarItem$styledIcon$1(NavigationBarItemColors r1, boolean r2, boolean r3, FiniteAnimationSpec<Color> r4, Function2<? super Composer, ? super Integer, Unit> r5, boolean r6, Function2<? super Composer, ? super Integer, Unit> r7) {
        this.$colors = r1;
        this.$selected = r2;
        this.$enabled = r3;
        this.$colorAnimationSpec = r4;
        this.$label = r5;
        this.$alwaysShowLabel = r6;
        this.$icon = r7;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$2$lambda$1(r0);
    }

    private static final long invoke$lambda$0(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final Unit invoke$lambda$2$lambda$1(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r13, int r14) {
        boolean r2 = true;
        if ((r14 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r13.shouldExecute(r0, r14 & 1) == true) goto L9;
        r13.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-876637252, r14, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:212)");
    L11:
        State<Color> r15 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(this.$colors.m2889iconColorWaAFU9c$material3(this.$selected, this.$enabled), this.$colorAnimationSpec, null, null, r13, 0, 12);
        if (this.$label != null) goto L14;
    L18:
        r2 = false;
    L19:
        if (r2 == false) goto L24;
        r13.startReplaceGroup(-634794445);
        Modifier.Companion r1 = Modifier.Companion;
        Object r3 = r13.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L23;
        r3 = new yf();
        r13.updateRememberedValue(r3);
    L23:
        Modifier r4 = SemanticsModifierKt.clearAndSetSemantics(r1, (Function1) r3);
        r13.endReplaceGroup();
    L25:
        Function2<Composer, Integer, Unit> r5 = this.$icon;
        MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r8 = r13.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r13, r4);
        ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
        Function0 r11 = r10.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L28;
        ComposablesKt.invalidApplier();
    L28:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L31;
        r13.createNode(r11);
    L32:
        Composer r12 = Updater.constructor-impl(r13);
        Updater.set-impl(r12, r6, r10.getSetMeasurePolicy());
        Updater.set-impl(r12, r8, r10.getSetResolvedCompositionLocals());
        Function2 r16 = r10.getSetCompositeKeyHash();
        if (r12.getInserting() == false) goto L35;
    L36:
        r12.updateRememberedValue(Integer.valueOf(r7));
        r12.apply(Integer.valueOf(r7), r16);
    L37:
        Updater.set-impl(r12, r9, r10.getSetModifier());
        BoxScopeInstance r17 = BoxScopeInstance.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(invoke$lambda$0(r15))), r5, r13, ProvidedValue.$stable);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
        return;
    L42:
        return;
    L35:
        if (Intrinsics.areEqual(r12.rememberedValue(), Integer.valueOf(r7)) == true) goto L37;
    L31:
        r13.useNode();
        goto L32
    L24:
        r13.startReplaceGroup(-634793532);
        r13.endReplaceGroup();
        r4 = Modifier.Companion;
        goto L25
    L14:
        if (this.$alwaysShowLabel == true) goto L19;
        if (this.$selected == false) goto L18;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
