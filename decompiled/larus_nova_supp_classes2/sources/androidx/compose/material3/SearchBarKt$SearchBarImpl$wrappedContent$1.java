package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt$SearchBarImpl$wrappedContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchBarKt$SearchBarImpl$wrappedContent$1(Animatable<Float, AnimationVector1D> r1, SearchBarColors r2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r3) {
        this.$animationProgress = r1;
        this.$colors = r2;
        this.$content = r3;
    }

    public static /* synthetic */ Unit a(Animatable r0, GraphicsLayerScope r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(Animatable r0, GraphicsLayerScope r1) {
        r1.setAlpha(((Number) r0.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r10, int r11) {
        if ((r11 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r10.shouldExecute(r0, r11 & 1) == true) goto L9;
        r10.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1831594093, r11, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.kt:2135)");
    L11:
        Modifier.Companion r12 = Modifier.Companion;
        boolean r1 = r10.changedInstance(this.$animationProgress);
        final Animatable<Float, AnimationVector1D> r2 = this.$animationProgress;
        Object r3 = r10.rememberedValue();
        if (r1 == false) goto L14;
    L15:
        r3 = new ym(r2);
        r10.updateRememberedValue(r3);
    L16:
        Modifier r13 = GraphicsLayerModifierKt.graphicsLayer(r12, (Function1) r3);
        SearchBarColors r4 = this.$colors;
        Function3<ColumnScope, Composer, Integer, Unit> r5 = this.$content;
        MeasurePolicy r6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r10, 0);
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r10, 0);
        CompositionLocalMap r8 = r10.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r10, r13);
        ComposeUiNode.Companion r9 = ComposeUiNode.Companion;
        Function0 r15 = r9.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L19;
        ComposablesKt.invalidApplier();
    L19:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L22;
        r10.createNode(r15);
    L23:
        Composer r16 = Updater.constructor-impl(r10);
        Updater.set-impl(r16, r6, r9.getSetMeasurePolicy());
        Updater.set-impl(r16, r8, r9.getSetResolvedCompositionLocals());
        Function2 r17 = r9.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L26;
    L27:
        r16.updateRememberedValue(Integer.valueOf(r7));
        r16.apply(Integer.valueOf(r7), r17);
    L28:
        Updater.set-impl(r16, r14, r9.getSetModifier());
        ColumnScopeInstance r18 = ColumnScopeInstance.INSTANCE;
        DividerKt.m2634HorizontalDivider9IZ8Weo(null, MenuKt.ClosedAlphaTarget, r4.m3039getDividerColor0d7_KjU(), r10, 0, 3);
        r5.invoke(r18, r10, 6);
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        return;
    L33:
        return;
    L26:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r7)) == true) goto L28;
    L22:
        r10.useNode();
        goto L23
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
