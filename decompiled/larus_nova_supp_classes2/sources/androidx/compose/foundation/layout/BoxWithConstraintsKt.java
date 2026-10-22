package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BoxWithConstraintsKt {
    private static final Unit BoxWithConstraints$lambda$3(Modifier r7, Alignment r8, boolean r9, Function3 r10, int r11, int r12, Composer r13, int r14) {
        BoxWithConstraints(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, Alignment r1, boolean r2, Function3 r3, int r4, int r5, Composer r6, int r7) {
        return BoxWithConstraints$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ MeasureResult b(MeasurePolicy r0, Function3 r1, SubcomposeMeasureScope r2, Constraints r3) {
        return BoxWithConstraints$lambda$2$lambda$1(r0, r1, r2, r3);
    }

    private static final MeasureResult BoxWithConstraints$lambda$2$lambda$1(MeasurePolicy r4, final Function3 r5, SubcomposeMeasureScope r6, Constraints r7) {
        final BoxWithConstraintsScopeImpl r0 = new BoxWithConstraintsScopeImpl(r6, r7.unbox-impl(), null);
        return r4.measure-3p2s80s(r6, r6.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(-431986394, true, new BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(r5, r0))), r7.unbox-impl());
    }

    public static final void BoxWithConstraints(Modifier r16, Alignment r17, boolean r18, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> r19, Composer r20, final int r21, final int r22) {
        Composer r1 = r20.startRestartGroup(380139498);
        int r2 = r22 & 1;
        if (r2 == 0) goto L6;
        int r6 = r21 | 6;
        Modifier r3 = r16;
    L13:
        int r7 = r22 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L23:
        Alignment r8 = r17;
    L24:
        int r9 = r22 & 4;
        if (r9 == 0) goto L28;
        r6 = r6 | 384;
    L34:
        boolean r10 = r18;
    L36:
        if ((r22 & 8) == 0) goto L39;
        r6 = r6 | 3072;
    L45:
        boolean r15 = true;
        if ((r6 & 1171) == 1170) goto L48;
        boolean r11 = true;
    L50:
        if (r1.shouldExecute(r11, r6 & 1) == false) goto L74;
        if (r2 == 0) goto L53;
        Modifier r4 = Modifier.Companion;
    L54:
        if (r7 == 0) goto L56;
        Alignment r5 = Alignment.Companion.getTopStart();
    L57:
        if (r9 == 0) goto L60;
        r10 = false;
    L60:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventStart(380139498, r6, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
    L62:
        final MeasurePolicy r0 = BoxKt.maybeCachedBoxMeasurePolicy(r5, r10);
        if ((r6 & 7168) == 2048) goto L66;
        r15 = false;
    L66:
        boolean r12 = r1.changed(r0) | r15;
        Object r13 = r1.rememberedValue();
        if (r12 == false) goto L69;
    L70:
        r13 = new p(r0, r19);
        r1.updateRememberedValue(r13);
    L71:
        SubcomposeLayoutKt.SubcomposeLayout(r4, (Function2) r13, r1, r6 & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventEnd();
    L75:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L79;
        final Modifier r23 = r4;
        final Alignment r24 = r5;
        final boolean r25 = r10;
        r14.updateScope(new q(r23, r24, r25, r19, r21, r22));
        return;
    L79:
        return;
    L69:
        if (r13 != Composer.Companion.getEmpty()) goto L71;
    L56:
        r5 = r8;
        goto L57
    L53:
        r4 = r3;
        goto L54
    L74:
        r1.skipToGroupEnd();
        r4 = r3;
        r5 = r8;
        goto L75
    L48:
        r11 = false;
        goto L50
    L39:
        if ((r21 & 3072) != 0) goto L45;
        if (r1.changedInstance(r19) == false) goto L43;
        int r110 = 2048;
    L44:
        r6 = r6 | r110;
        goto L45
    L43:
        r110 = 1024;
        goto L44
    L28:
        if ((r21 & 384) != 0) goto L34;
        r10 = r18;
        if (r1.changed(r10) == false) goto L32;
        int r111 = 256;
    L33:
        r6 = r6 | r111;
        goto L36
    L32:
        r111 = 128;
        goto L33
    L17:
        if ((r21 & 48) != 0) goto L23;
        r8 = r17;
        if (r1.changed(r8) == false) goto L21;
        int r26 = 32;
    L22:
        r6 = r6 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r21 & 6) != 0) goto L12;
        r3 = r16;
        if (r1.changed(r3) == false) goto L10;
        int r27 = 4;
    L11:
        r6 = r27 | r21;
        goto L13
    L10:
        r27 = 2;
        goto L11
    L12:
        r3 = r16;
        r6 = r21;
        goto L13
    }
}
