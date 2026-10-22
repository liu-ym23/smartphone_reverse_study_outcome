package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
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
    final /* synthetic */ List<SnackbarData> $keys;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    public SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData r1, SnackbarData r2, List<SnackbarData> r3, FadeInFadeOutState<SnackbarData> r4, String r5) {
        this.$key = r1;
        this.$current = r2;
        this.$keys = r3;
        this.$state = r4;
        this.$a11yPaneTitle = r5;
    }

    public static /* synthetic */ boolean a(SnackbarData r0, FadeInFadeOutAnimationItem r1) {
        return invoke$lambda$2$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ boolean b(SnackbarData r0) {
        return invoke$lambda$5$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(SnackbarData r0, FadeInFadeOutState r1) {
        return invoke$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit d(boolean r0, String r1, SnackbarData r2, SemanticsPropertyReceiver r3) {
        return invoke$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    private static final boolean invoke$lambda$5$lambda$4$lambda$3(SnackbarData r0) {
        r0.dismiss();
        return true;
    }

    private static final Unit invoke$lambda$2$lambda$1(final SnackbarData r2, FadeInFadeOutState r3) {
        if (Intrinsics.areEqual(r2, r3.getCurrent()) == true) goto L8;
        CollectionsKt.removeAll(r3.getItems(), new ia(r2));
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
        ComposerKt.traceEventStart(-1032415134, r9, -1, "androidx.compose.material.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:257)");
    L19:
        final boolean r12 = Intrinsics.areEqual(this.$key, this.$current);
        if (r12 == false) goto L22;
        int r13 = TextFieldImplKt.AnimationDuration;
    L23:
        if (r12 == true) goto L25;
    L27:
        int r14 = 0;
    L28:
        TweenSpec r3 = AnimationSpecKt.tween(r13, r14, EasingKt.getLinearEasing());
        boolean r4 = r38.changedInstance(this.$key) | r38.changedInstance(this.$state);
        final SnackbarData r5 = this.$key;
        final FadeInFadeOutState<SnackbarData> r6 = this.$state;
        Object r7 = r38.rememberedValue();
        if (r4 == false) goto L31;
    L32:
        r7 = new ja(r5, r6);
        r38.updateRememberedValue(r7);
    L33:
        State r8 = SnackbarHostKt.access$animatedOpacity(r3, r12, (Function0) r7, r38, 0, 0);
        State r10 = SnackbarHostKt.access$animatedScale(AnimationSpecKt.tween(r13, r14, EasingKt.getFastOutSlowInEasing()), r12, r38, 0);
        Modifier r11 = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(Modifier.Companion, ((Number) r10.getValue()).floatValue(), ((Number) r10.getValue()).floatValue(), ((Number) r8.getValue()).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, null, false, null, 0, 0, 0, 131064, null);
        boolean r15 = (r38.changed(r12) | r38.changed(this.$a11yPaneTitle)) | r38.changedInstance(this.$key);
        final String r16 = this.$a11yPaneTitle;
        final SnackbarData r17 = this.$key;
        Object r18 = r38.rememberedValue();
        if (r15 == false) goto L36;
    L37:
        r18 = new ka(r12, r16, r17);
        r38.updateRememberedValue(r18);
    L38:
        Modifier r19 = SemanticsModifierKt.semantics$default(r11, false, (Function1) r18, 1, null);
        MeasurePolicy r20 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r21 = ComposablesKt.getCurrentCompositeKeyHash(r38, 0);
        CompositionLocalMap r22 = r38.getCurrentCompositionLocalMap();
        Modifier r23 = ComposedModifierKt.materializeModifier(r38, r19);
        ComposeUiNode.Companion r24 = ComposeUiNode.Companion;
        Function0 r25 = r24.getConstructor();
        if ((r38.getApplier() instanceof Applier) == true) goto L41;
        ComposablesKt.invalidApplier();
    L41:
        r38.startReusableNode();
        if (r38.getInserting() == false) goto L44;
        r38.createNode(r25);
    L45:
        Composer r26 = Updater.constructor-impl(r38);
        Updater.set-impl(r26, r20, r24.getSetMeasurePolicy());
        Updater.set-impl(r26, r22, r24.getSetResolvedCompositionLocals());
        Function2 r27 = r24.getSetCompositeKeyHash();
        if (r26.getInserting() == false) goto L48;
    L49:
        r26.updateRememberedValue(Integer.valueOf(r21));
        r26.apply(Integer.valueOf(r21), r27);
    L50:
        Updater.set-impl(r26, r23, r24.getSetModifier());
        BoxScopeInstance r28 = BoxScopeInstance.INSTANCE;
        r37.invoke(r38, Integer.valueOf(r9 & 14));
        r38.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventEnd();
        return;
    L55:
        return;
    L48:
        if (Intrinsics.areEqual(r26.rememberedValue(), Integer.valueOf(r21)) == true) goto L50;
    L44:
        r38.useNode();
        goto L45
    L36:
        if (r18 != Composer.Companion.getEmpty()) goto L38;
    L31:
        if (r7 != Composer.Companion.getEmpty()) goto L33;
    L25:
        if (ListUtilsKt.fastFilterNotNull(this.$keys).size() == 1) goto L27;
        r14 = 75;
        goto L28
    L22:
        r13 = 75;
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r38.changedInstance(r37) == false) goto L7;
        int r29 = 4;
    L8:
        r9 = r39 | r29;
        goto L11
    L7:
        r29 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Function2) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$5$lambda$4(boolean r0, String r1, final SnackbarData r2, SemanticsPropertyReceiver r3) {
        if (r0 == false) goto L4;
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(r3, LiveRegionMode.Companion.getPolite-0phEisY());
    L4:
        SemanticsPropertiesKt.setPaneTitle(r3, r1);
        SemanticsPropertiesKt.dismiss$default(r3, null, new la(r2), 1, null);
        return Unit.INSTANCE;
    }
}
