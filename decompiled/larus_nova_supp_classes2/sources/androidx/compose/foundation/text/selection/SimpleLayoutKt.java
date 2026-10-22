package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"SimpleLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SimpleLayoutKt {
    private static final Unit SimpleLayout$lambda$1(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        SimpleLayout(r0, r1, r4, RecomposeScopeImplKt.updateChangedFlags(r2 | 1), r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, Function2 r1, int r2, int r3, Composer r4, int r5) {
        return SimpleLayout$lambda$1(r0, r1, r2, r3, r4, r5);
    }

    public static final void SimpleLayout(final Modifier r8, final Function2<? super Composer, ? super Integer, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(-1854833411);
        int r1 = r12 & 1;
        if (r1 == 0) goto L6;
        int r2 = r11 | 6;
    L14:
        if ((r12 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r2 & 19) == 18) goto L26;
        boolean r3 = true;
    L28:
        if (r13.shouldExecute(r3, r2 & 1) == false) goto L52;
        if (r1 == 0) goto L32;
        r8 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-1854833411, r2, -1, "androidx.compose.foundation.text.selection.SimpleLayout (SimpleLayout.kt:30)");
    L34:
        Object r0 = r13.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L37;
        r0 = SimpleLayoutKt$SimpleLayout$1$1.INSTANCE;
        r13.updateRememberedValue(r0);
    L37:
        MeasurePolicy r4 = (MeasurePolicy) r0;
        int r5 = (((r2 >> 3) & 14) | 384) | ((r2 << 3) & 112);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r14 = r13.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r13, r8);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        int r18 = ((r5 << 6) & 896) | 6;
        if ((r13.getApplier() instanceof Applier) == true) goto L40;
        ComposablesKt.invalidApplier();
    L40:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L43;
        r13.createNode(r17);
    L44:
        Composer r19 = Updater.constructor-impl(r13);
        Updater.set-impl(r19, r4, r16.getSetMeasurePolicy());
        Updater.set-impl(r19, r14, r16.getSetResolvedCompositionLocals());
        Function2 r20 = r16.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L47;
    L48:
        r19.updateRememberedValue(Integer.valueOf(r7));
        r19.apply(Integer.valueOf(r7), r20);
    L49:
        Updater.set-impl(r19, r15, r16.getSetModifier());
        r9.invoke(r13, Integer.valueOf((r18 >> 6) & 14));
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventEnd();
    L53:
        ScopeUpdateScope r110 = r13.endRestartGroup();
        if (r110 == null) goto L57;
        r110.updateScope(new v1(r8, r9, r11, r12));
        return;
    L57:
        return;
    L47:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r7)) == true) goto L49;
    L43:
        r13.useNode();
        goto L44
    L52:
        r13.skipToGroupEnd();
        goto L53
    L26:
        r3 = false;
        goto L28
    L17:
        if ((r11 & 48) != 0) goto L24;
        if (r13.changedInstance(r9) == false) goto L21;
        int r21 = 32;
    L22:
        r2 = r2 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r11 & 6) == 0) goto L8;
        r2 = r11;
        goto L14
    L8:
        if (r13.changed(r8) == false) goto L10;
        int r22 = 4;
    L11:
        r2 = r22 | r11;
        goto L14
    L10:
        r22 = 2;
        goto L11
    }
}
