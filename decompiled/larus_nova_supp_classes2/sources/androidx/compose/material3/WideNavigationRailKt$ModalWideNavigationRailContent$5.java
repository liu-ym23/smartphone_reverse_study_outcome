package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt$ModalWideNavigationRailContent$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Arrangement.Vertical $arrangement;
    final /* synthetic */ WideNavigationRailColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $header;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ RailPredictiveBackState $predictiveBackState;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ WindowInsets $windowInsets;

    public WideNavigationRailKt$ModalWideNavigationRailContent$5(Animatable<Float, AnimationVector1D> r1, RailPredictiveBackState r2, boolean r3, boolean r4, WideNavigationRailColors r5, Shape r6, Function2<? super Composer, ? super Integer, Unit> r7, WindowInsets r8, Arrangement.Vertical r9, Function2<? super Composer, ? super Integer, Unit> r10) {
        this.$predictiveBackProgress = r1;
        this.$predictiveBackState = r2;
        this.$isRtl = r3;
        this.$expanded = r4;
        this.$colors = r5;
        this.$shape = r6;
        this.$header = r7;
        this.$windowInsets = r8;
        this.$arrangement = r9;
        this.$content = r10;
    }

    public static /* synthetic */ Unit a(Animatable r0, RailPredictiveBackState r1, boolean r2, GraphicsLayerScope r3) {
        return invoke$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    public final void invoke(Composer r12, int r13) {
        if ((r13 & 3) == 2) goto L5;
        boolean r1 = true;
    L7:
        if (r12.shouldExecute(r1, r13 & 1) == true) goto L9;
        r12.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1043835354, r13, -1, "androidx.compose.material3.ModalWideNavigationRailContent.<anonymous> (WideNavigationRail.kt:1044)");
    L11:
        Modifier.Companion r0 = Modifier.Companion;
        boolean r2 = (r12.changedInstance(this.$predictiveBackProgress) | r12.changed(this.$predictiveBackState)) | r12.changed(this.$isRtl);
        final Animatable<Float, AnimationVector1D> r3 = this.$predictiveBackProgress;
        final RailPredictiveBackState r4 = this.$predictiveBackState;
        final boolean r5 = this.$isRtl;
        Object r6 = r12.rememberedValue();
        if (r2 == false) goto L14;
    L15:
        r6 = new ky(r3, r4, r5);
        r12.updateRememberedValue(r6);
    L16:
        WideNavigationRailKt.access$WideNavigationRailLayout(GraphicsLayerModifierKt.graphicsLayer(r0, (Function1) r6), true, this.$expanded, this.$colors, this.$shape, this.$header, this.$windowInsets, this.$arrangement, this.$content, r12, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r6 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r1 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$1$lambda$0(Animatable r3, RailPredictiveBackState r4, boolean r5, GraphicsLayerScope r6) {
        float r7 = ((Number) r3.getValue()).floatValue();
        float r0 = MenuKt.ClosedAlphaTarget;
        if (r7 <= MenuKt.ClosedAlphaTarget) goto L5;
        float r8 = WideNavigationRailKt.access$calculatePredictiveBackScaleX(r6, r7, r4.getSwipeEdgeMatchesRail());
        float r9 = WideNavigationRailKt.access$calculatePredictiveBackScaleY(r6, r7);
        if (r8 != MenuKt.ClosedAlphaTarget) goto L9;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        float r10 = r9 / r8;
    L14:
        r6.setScaleX(r10);
        if (r5 == true) goto L18;
        r0 = 1.0f;
    L18:
        r6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(r0, 0.5f));
        return Unit.INSTANCE;
    L13:
        r10 = 1.0f;
        goto L14
    L9:
        r1 = false;
        goto L11
    L5:
        return Unit.INSTANCE;
    }
}
