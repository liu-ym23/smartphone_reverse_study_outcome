package androidx.compose.foundation.layout;

import androidx.collection.MutableScatterMap;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001d\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010$\"\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010%\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020\u0007*\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "cacheFor", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/MeasurePolicy;", "propagate", "Cache1", "Cache2", "maybeCachedBoxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "DefaultBoxMeasurePolicy", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "boxChildDataNode", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "getBoxChildDataNode", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildDataNode;", "matchesParentSize", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BoxKt {
    private static final MutableScatterMap<Alignment, MeasurePolicy> Cache1 = null;
    private static final MutableScatterMap<Alignment, MeasurePolicy> Cache2 = null;
    private static final MeasurePolicy DefaultBoxMeasurePolicy = null;
    private static final MeasurePolicy EmptyBoxMeasurePolicy = null;

    static {
        Cache1 = cacheFor(true);
        Cache2 = cacheFor(false);
        DefaultBoxMeasurePolicy = new BoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        EmptyBoxMeasurePolicy = BoxKt$EmptyBoxMeasurePolicy$1.INSTANCE;
    }

    private static final Unit Box$lambda$3(Modifier r0, int r1, Composer r2, int r3) {
        Box(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, int r1, Composer r2, int r3) {
        return Box$lambda$3(r0, r1, r2, r3);
    }

    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return EmptyBoxMeasurePolicy;
    }

    public static final /* synthetic */ boolean access$getMatchesParentSize(Measurable r0) {
        return getMatchesParentSize(r0);
    }

    private static final MutableScatterMap<Alignment, MeasurePolicy> cacheFor(boolean r5) {
        MutableScatterMap<Alignment, MeasurePolicy> r0 = new MutableScatterMap(9);
        Alignment.Companion r1 = Alignment.Companion;
        r0.set(r1.getTopStart(), new BoxMeasurePolicy(r1.getTopStart(), r5));
        r0.set(r1.getTopCenter(), new BoxMeasurePolicy(r1.getTopCenter(), r5));
        r0.set(r1.getTopEnd(), new BoxMeasurePolicy(r1.getTopEnd(), r5));
        r0.set(r1.getCenterStart(), new BoxMeasurePolicy(r1.getCenterStart(), r5));
        r0.set(r1.getCenter(), new BoxMeasurePolicy(r1.getCenter(), r5));
        r0.set(r1.getCenterEnd(), new BoxMeasurePolicy(r1.getCenterEnd(), r5));
        r0.set(r1.getBottomStart(), new BoxMeasurePolicy(r1.getBottomStart(), r5));
        r0.set(r1.getBottomCenter(), new BoxMeasurePolicy(r1.getBottomCenter(), r5));
        r0.set(r1.getBottomEnd(), new BoxMeasurePolicy(r1.getBottomEnd(), r5));
        return r0;
    }

    private static final BoxChildDataNode getBoxChildDataNode(Measurable r1) {
        Object r2 = r1.getParentData();
        if ((r2 instanceof BoxChildDataNode) == true) goto L7;
        return null;
    L7:
        return (BoxChildDataNode) r2;
    }

    private static final boolean getMatchesParentSize(Measurable r0) {
        BoxChildDataNode r1 = getBoxChildDataNode(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.getMatchParentSize();
    }

    public static final MeasurePolicy maybeCachedBoxMeasurePolicy(Alignment r1, boolean r2) {
        if (r2 == false) goto L4;
        MutableScatterMap<Alignment, MeasurePolicy> r0 = Cache1;
    L5:
        MeasurePolicy r3 = r0.get(r1);
        if (r3 == null) goto L8;
        return r3;
    L8:
        return new BoxMeasurePolicy(r1, r2);
    L4:
        r0 = Cache2;
        goto L5
    }

    public static final void Box(final Modifier r7, Composer r8, final int r9) {
        Composer r10 = r8.startRestartGroup(-211209833);
        if ((r9 & 6) == 0) goto L5;
        int r1 = r9;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r10.shouldExecute(r2, r1 & 1) == true) goto L17;
        r10.skipToGroupEnd();
    L35:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L39;
        r11.updateScope(new k(r7, r9));
        return;
    L39:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-211209833, r1, -1, "androidx.compose.foundation.layout.Box (Box.kt:232)");
    L19:
        MeasurePolicy r0 = EmptyBoxMeasurePolicy;
        long r3 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r4 = (int) (r3 ^ (r3 >>> 32));
        Modifier r5 = ComposedModifierKt.materializeModifier(r10, r7);
        CompositionLocalMap r6 = r10.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion r12 = ComposeUiNode.Companion;
        Function0 r13 = r12.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L22;
        ComposablesKt.invalidApplier();
    L22:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L25;
        r10.createNode(r13);
    L26:
        Composer r14 = Updater.constructor-impl(r10);
        Updater.set-impl(r14, r0, r12.getSetMeasurePolicy());
        Updater.set-impl(r14, r6, r12.getSetResolvedCompositionLocals());
        Updater.set-impl(r14, r5, r12.getSetModifier());
        Function2 r15 = r12.getSetCompositeKeyHash();
        if (r14.getInserting() == false) goto L29;
    L30:
        r14.updateRememberedValue(Integer.valueOf(r4));
        r14.apply(Integer.valueOf(r4), r15);
    L31:
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
        goto L35
    L29:
        if (Intrinsics.areEqual(r14.rememberedValue(), Integer.valueOf(r4)) == true) goto L31;
    L25:
        r10.useNode();
        goto L26
    L13:
        r2 = false;
        goto L15
    L5:
        if (r10.changed(r7) == false) goto L7;
        int r16 = 4;
    L8:
        r1 = r16 | r9;
        goto L11
    L7:
        r16 = 2;
        goto L8
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment r5, boolean r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(56522820, r8, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:109)");
    L6:
        if (Intrinsics.areEqual(r5, Alignment.Companion.getTopStart()) == false) goto L9;
        if (r6 == true) goto L9;
        r7.startReplaceGroup(244367063);
        r7.endReplaceGroup();
        MeasurePolicy r9 = DefaultBoxMeasurePolicy;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r9;
    L9:
        r7.startReplaceGroup(244414741);
        boolean r1 = false;
        if (((r8 & 14) ^ 6) <= 4) goto L14;
        if (r7.changed(r5) == false) goto L14;
    L15:
        boolean r0 = true;
    L18:
        if (((r8 & 112) ^ 48) <= 32) goto L22;
        if (r7.changed(r6) == false) goto L22;
    L23:
        r1 = true;
    L24:
        boolean r10 = r0 | r1;
        Object r2 = r7.rememberedValue();
        if (r10 == false) goto L27;
    L28:
        r2 = new BoxMeasurePolicy(r5, r6);
        r7.updateRememberedValue(r2);
    L29:
        r9 = (BoxMeasurePolicy) r2;
        r7.endReplaceGroup();
        goto L31
    L27:
        if (r2 != Composer.Companion.getEmpty()) goto L29;
    L22:
        if ((r8 & 48) != 32) goto L24;
    L14:
        if ((r8 & 6) == 4) goto L15;
        r0 = false;
        goto L18
    }

    public static final void Box(Modifier r4, Alignment r5, boolean r6, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = Modifier.Companion;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = Alignment.Companion.getTopStart();
    L9:
        if ((r10 & 4) == 0) goto L11;
        r6 = false;
    L11:
        MeasurePolicy r11 = maybeCachedBoxMeasurePolicy(r5, r6);
        long r0 = ComposablesKt.getCurrentCompositeKeyHashCode(r8, 0);
        int r12 = (int) (r0 ^ (r0 >>> 32));
        CompositionLocalMap r13 = r8.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r8, r4);
        ComposeUiNode.Companion r1 = ComposeUiNode.Companion;
        Function0 r2 = r1.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L17;
        r8.createNode(r2);
    L18:
        Composer r3 = Updater.constructor-impl(r8);
        Updater.set-impl(r3, r11, r1.getSetMeasurePolicy());
        Updater.set-impl(r3, r13, r1.getSetResolvedCompositionLocals());
        Function2 r15 = r1.getSetCompositeKeyHash();
        if (r3.getInserting() == false) goto L21;
    L22:
        r3.updateRememberedValue(Integer.valueOf(r12));
        r3.apply(Integer.valueOf(r12), r15);
    L23:
        Updater.set-impl(r3, r14, r1.getSetModifier());
        r7.invoke(BoxScopeInstance.INSTANCE, r8, Integer.valueOf(((r9 >> 6) & 112) | 6));
        r8.endNode();
        return;
    L21:
        if (Intrinsics.areEqual(r3.rememberedValue(), Integer.valueOf(r12)) == true) goto L23;
    L17:
        r8.useNode();
        goto L18
    }

    public static final /* synthetic */ void access$placeInBox(Placeable.PlacementScope r0, Placeable r1, Measurable r2, LayoutDirection r3, int r4, int r5, Alignment r6) {
        placeInBox(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final void placeInBox(Placeable.PlacementScope r13, Placeable r14, Measurable r15, LayoutDirection r16, int r17, int r18, Alignment r19) {
        BoxChildDataNode r0 = getBoxChildDataNode(r15);
        if (r0 == null) goto L8;
        Alignment r1 = r0.getAlignment();
        if (r1 == null) goto L8;
        Alignment r2 = r1;
    L9:
        int r3 = r14.getWidth();
        Placeable.PlacementScope.place-70tqf50$default(r13, r14, r2.align-KFBX0sM(IntSize.constructor-impl((((long) r3) << 32) | (((long) r14.getHeight()) & 4294967295L)), IntSize.constructor-impl((((long) r17) << 32) | (((long) r18) & 4294967295L)), r16), MenuKt.ClosedAlphaTarget, 2, null);
        return;
    L8:
        r2 = r19;
        goto L9
    }
}
