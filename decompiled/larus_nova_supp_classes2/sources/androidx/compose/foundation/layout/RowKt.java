package androidx.compose.foundation.layout;

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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0000¢\u0006\u0002\u0010\u001f\"\u001c\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "createRowConstraints", "Landroidx/compose/ui/unit/Constraints;", "isPrioritizing", "", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "(ZIIII)J", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RowKt {
    private static final MeasurePolicy DefaultRowMeasurePolicy = null;

    public static /* synthetic */ void getDefaultRowMeasurePolicy$annotations() {
    }

    static {
        DefaultRowMeasurePolicy = new RowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop());
    }

    public static final MeasurePolicy getDefaultRowMeasurePolicy() {
        return DefaultRowMeasurePolicy;
    }

    public static final MeasurePolicy rowMeasurePolicy(Arrangement.Horizontal r5, Alignment.Vertical r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-837807694, r8, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:118)");
    L6:
        if (Intrinsics.areEqual(r5, Arrangement.INSTANCE.getStart()) == true) goto L8;
    L10:
        r7.startReplaceGroup(-1073744896);
        boolean r1 = false;
        if (((r8 & 14) ^ 6) <= 4) goto L15;
        if (r7.changed(r5) == false) goto L15;
    L16:
        boolean r0 = true;
    L19:
        if (((r8 & 112) ^ 48) <= 32) goto L23;
        if (r7.changed(r6) == false) goto L23;
    L24:
        r1 = true;
    L25:
        boolean r9 = r0 | r1;
        Object r2 = r7.rememberedValue();
        if (r9 == false) goto L28;
    L29:
        r2 = new RowMeasurePolicy(r5, r6);
        r7.updateRememberedValue(r2);
    L30:
        MeasurePolicy r10 = (RowMeasurePolicy) r2;
        r7.endReplaceGroup();
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
    L34:
        return r10;
    L28:
        if (r2 != Composer.Companion.getEmpty()) goto L30;
    L23:
        if ((r8 & 48) != 32) goto L25;
    L15:
        if ((r8 & 6) == 4) goto L16;
        r0 = false;
        goto L19
    L8:
        if (Intrinsics.areEqual(r6, Alignment.Companion.getTop()) == false) goto L10;
        r7.startReplaceGroup(-1073795767);
        r7.endReplaceGroup();
        r10 = DefaultRowMeasurePolicy;
        goto L32
    }

    public static final long createRowConstraints(boolean r0, int r1, int r2, int r3, int r4) {
        if (r0 == true) goto L5;
        return ConstraintsKt.Constraints(r1, r3, r2, r4);
    L5:
        return Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(r1, r3, r2, r4);
    }

    public static final void Row(Modifier r4, Arrangement.Horizontal r5, Alignment.Vertical r6, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = Modifier.Companion;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = Arrangement.INSTANCE.getStart();
    L9:
        if ((r10 & 4) == 0) goto L11;
        r6 = Alignment.Companion.getTop();
    L11:
        int r11 = r9 >> 3;
        int r0 = r11 & 14;
        MeasurePolicy r12 = rowMeasurePolicy(r5, r6, r8, (r11 & 112) | r0);
        long r1 = ComposablesKt.getCurrentCompositeKeyHashCode(r8, 0);
        int r13 = (int) (r1 ^ (r1 >>> 32));
        CompositionLocalMap r14 = r8.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r8, r4);
        ComposeUiNode.Companion r2 = ComposeUiNode.Companion;
        Function0 r3 = r2.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L17;
        r8.createNode(r3);
    L18:
        Composer r16 = Updater.constructor-impl(r8);
        Updater.set-impl(r16, r12, r2.getSetMeasurePolicy());
        Updater.set-impl(r16, r14, r2.getSetResolvedCompositionLocals());
        Function2 r17 = r2.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L21;
    L22:
        r16.updateRememberedValue(Integer.valueOf(r13));
        r16.apply(Integer.valueOf(r13), r17);
    L23:
        Updater.set-impl(r16, r15, r2.getSetModifier());
        r7.invoke(RowScopeInstance.INSTANCE, r8, Integer.valueOf(((r9 >> 6) & 112) | 6));
        r8.endNode();
        return;
    L21:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r13)) == true) goto L23;
    L17:
        r8.useNode();
        goto L18
    }
}
