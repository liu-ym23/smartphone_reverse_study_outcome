package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt$NavigationRailItem$1$indicator$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Float> $alphaAnimationProgress;
    final /* synthetic */ NavigationRailItemColors $colors;
    final /* synthetic */ Shape $indicatorShape;

    public NavigationRailKt$NavigationRailItem$1$indicator$1(State<Float> r1, NavigationRailItemColors r2, Shape r3) {
        this.$alphaAnimationProgress = r1;
        this.$colors = r2;
        this.$indicatorShape = r3;
    }

    public static /* synthetic */ Unit a(State r0, GraphicsLayerScope r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(State r0, GraphicsLayerScope r1) {
        r1.setAlpha(((Number) r0.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r5, int r6) {
        if ((r6 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r5.shouldExecute(r0, r6 & 1) == true) goto L9;
        r5.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(2137606782, r6, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:306)");
    L11:
        Modifier r7 = LayoutIdKt.layoutId(Modifier.Companion, "indicator");
        boolean r1 = r5.changed(this.$alphaAnimationProgress);
        final State<Float> r2 = this.$alphaAnimationProgress;
        Object r3 = r5.rememberedValue();
        if (r1 == false) goto L14;
    L15:
        r3 = new qi(r2);
        r5.updateRememberedValue(r3);
    L16:
        BoxKt.Box(BackgroundKt.m341backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(r7, (Function1) r3), this.$colors.m2950getIndicatorColor0d7_KjU$material3(), this.$indicatorShape), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L14:
        if (r3 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
