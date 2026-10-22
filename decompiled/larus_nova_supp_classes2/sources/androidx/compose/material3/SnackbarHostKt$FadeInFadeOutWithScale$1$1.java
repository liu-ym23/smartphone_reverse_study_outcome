package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostKt$FadeInFadeOutWithScale$1$1 implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ String $a11yPaneTitle;
    final /* synthetic */ SnackbarData $current;
    final /* synthetic */ SnackbarData $key;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    public SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData r1, SnackbarData r2, FadeInFadeOutState<SnackbarData> r3, String r4) {
        this.$key = r1;
        this.$current = r2;
        this.$state = r3;
        this.$a11yPaneTitle = r4;
    }

    public static /* synthetic */ Unit a(SnackbarData r0, FadeInFadeOutState r1) {
        return invoke$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ boolean b(SnackbarData r0) {
        return invoke$lambda$5$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(boolean r0, String r1, SnackbarData r2, SemanticsPropertyReceiver r3) {
        return invoke$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean d(SnackbarData r0, FadeInFadeOutAnimationItem r1) {
        return invoke$lambda$2$lambda$1$lambda$0(r0, r1);
    }

    private static final boolean invoke$lambda$5$lambda$4$lambda$3(SnackbarData r0) {
        r0.dismiss();
        return true;
    }

    private static final Unit invoke$lambda$2$lambda$1(final SnackbarData r2, FadeInFadeOutState r3) {
        if (Intrinsics.areEqual(r2, r3.getCurrent()) == true) goto L8;
        CollectionsKt.removeAll(r3.getItems(), new uq(r2));
        RecomposeScope r4 = r3.getScope();
        if (r4 == null) goto L8;
        r4.invalidate();
    L8:
        return Unit.INSTANCE;
    }

    private static final boolean invoke$lambda$2$lambda$1$lambda$0(SnackbarData r0, FadeInFadeOutAnimationItem r1) {
        return Intrinsics.areEqual(r1.getKey(), r0);
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> r37, Composer r38, int r39) {
        if ((r39 & 6) == 0) goto L5;
        int r9 = r39;
    L11:
        if ((r9 & 19) == 18) goto L13;
        boolean r2 = true;
    L15:
        if (r38.shouldExecute(r2, r9 & 1) == true) goto L17;
        r38.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1952400805, r9, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
    L19:
        final boolean r12 = Intrinsics.areEqual(this.$key, this.$current);
        FiniteAnimationSpec r3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r38, 6);
        boolean r4 = r38.changed(this.$key) | r38.changedInstance(this.$state);
        final SnackbarData r5 = this.$key;
        final FadeInFadeOutState<SnackbarData> r6 = this.$state;
        Object r7 = r38.rememberedValue();
        if (r4 == false) goto L22;
    L23:
        r7 = new vq(r5, r6);
        r38.updateRememberedValue(r7);
    L24:
        State r8 = SnackbarHostKt.access$animatedOpacity(r3, r12, (Function0) r7, r38, 0, 0);
        State r10 = SnackbarHostKt.access$animatedScale(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r38, 6), r12, r38, 0);
        Modifier r11 = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(Modifier.Companion, ((Number) r10.getValue()).floatValue(), ((Number) r10.getValue()).floatValue(), ((Number) r8.getValue()).floatValue(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, null, false, null, 0, 0, 0, 131064, null);
        boolean r13 = (r38.changed(r12) | r38.changed(this.$key)) | r38.changed(this.$a11yPaneTitle);
        final String r14 = this.$a11yPaneTitle;
        final SnackbarData r15 = this.$key;
        Object r16 = r38.rememberedValue();
        if (r13 == false) goto L27;
    L28:
        r16 = new wq(r12, r14, r15);
        r38.updateRememberedValue(r16);
    L29:
        Modifier r17 = SemanticsModifierKt.semantics$default(r11, false, (Function1) r16, 1, null);
        MeasurePolicy r18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r19 = ComposablesKt.getCurrentCompositeKeyHash(r38, 0);
        CompositionLocalMap r20 = r38.getCurrentCompositionLocalMap();
        Modifier r21 = ComposedModifierKt.materializeModifier(r38, r17);
        ComposeUiNode.Companion r22 = ComposeUiNode.Companion;
        Function0 r23 = r22.getConstructor();
        if ((r38.getApplier() instanceof Applier) == true) goto L32;
        ComposablesKt.invalidApplier();
    L32:
        r38.startReusableNode();
        if (r38.getInserting() == false) goto L35;
        r38.createNode(r23);
    L36:
        Composer r24 = Updater.constructor-impl(r38);
        Updater.set-impl(r24, r18, r22.getSetMeasurePolicy());
        Updater.set-impl(r24, r20, r22.getSetResolvedCompositionLocals());
        Function2 r25 = r22.getSetCompositeKeyHash();
        if (r24.getInserting() == false) goto L39;
    L40:
        r24.updateRememberedValue(Integer.valueOf(r19));
        r24.apply(Integer.valueOf(r19), r25);
    L41:
        Updater.set-impl(r24, r21, r22.getSetModifier());
        BoxScopeInstance r26 = BoxScopeInstance.INSTANCE;
        r37.invoke(r38, Integer.valueOf(r9 & 14));
        r38.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
        return;
    L46:
        return;
    L39:
        if (Intrinsics.areEqual(r24.rememberedValue(), Integer.valueOf(r19)) == true) goto L41;
    L35:
        r38.useNode();
        goto L36
    L27:
        if (r16 != Composer.Companion.getEmpty()) goto L29;
    L22:
        if (r7 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r2 = false;
        goto L15
    L5:
        if (r38.changedInstance(r37) == false) goto L7;
        int r27 = 4;
    L8:
        r9 = r39 | r27;
        goto L11
    L7:
        r27 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Function2) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$5$lambda$4(boolean r1, String r2, final SnackbarData r3, SemanticsPropertyReceiver r4) {
        if (r1 == false) goto L4;
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(r4, LiveRegionMode.Companion.getPolite-0phEisY());
    L4:
        SemanticsPropertiesKt.dismiss$default(r4, null, new tq(r3), 1, null);
        SemanticsPropertiesKt.setPaneTitle(r4, r2);
        return Unit.INSTANCE;
    }
}
