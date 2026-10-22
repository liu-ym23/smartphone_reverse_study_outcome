package androidx.compose.foundation;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Canvas", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "contentDescription", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CanvasKt {
    private static final Unit Canvas$lambda$0(Modifier r0, Function1 r1, int r2, Composer r3, int r4) {
        Canvas(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Canvas$lambda$3(Modifier r0, String r1, Function1 r2, int r3, Composer r4, int r5) {
        Canvas(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, Function1 r1, int r2, Composer r3, int r4) {
        return Canvas$lambda$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(String r0, SemanticsPropertyReceiver r1) {
        return Canvas$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit c(Modifier r0, String r1, Function1 r2, int r3, Composer r4, int r5) {
        return Canvas$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    private static final Unit Canvas$lambda$2$lambda$1(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    public static final void Canvas(final Modifier r5, final Function1<? super DrawScope, Unit> r6, Composer r7, final int r8) {
        Composer r9 = r7.startRestartGroup(-932836462);
        if ((r8 & 6) == 0) goto L5;
        int r1 = r8;
    L11:
        if ((r8 & 48) != 0) goto L18;
        if (r9.changedInstance(r6) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r9.shouldExecute(r3, r1 & 1) == true) goto L24;
        r9.skipToGroupEnd();
    L30:
        ScopeUpdateScope r10 = r9.endRestartGroup();
        if (r10 == null) goto L34;
        r10.updateScope(new d0(r5, r6, r8));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-932836462, r1, -1, "androidx.compose.foundation.Canvas (Canvas.kt:40)");
    L26:
        SpacerKt.Spacer(DrawModifierKt.drawBehind(r5, r6), r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r9.changed(r5) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r8;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    public static final void Canvas(final Modifier r7, final String r8, final Function1<? super DrawScope, Unit> r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(-1162737955);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r11 & 48) != 0) goto L18;
        if (r12.changed(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r11 & 384) != 0) goto L25;
        if (r12.changedInstance(r9) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r12.shouldExecute(r4, r1 & 1) == true) goto L31;
        r12.skipToGroupEnd();
    L46:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L50;
        r13.updateScope(new f0(r7, r8, r9, r11));
        return;
    L50:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1162737955, r1, -1, "androidx.compose.foundation.Canvas (Canvas.kt:60)");
    L33:
        Modifier r0 = DrawModifierKt.drawBehind(r7, r9);
        if ((r1 & 112) != 32) goto L36;
        boolean r5 = true;
    L37:
        Object r6 = r12.rememberedValue();
        if (r5 == false) goto L40;
    L41:
        r6 = new e0(r8);
        r12.updateRememberedValue(r6);
    L42:
        SpacerKt.Spacer(SemanticsModifierKt.semantics$default(r0, false, (Function1) r6, 1, null), r12, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
        goto L46
    L40:
        if (r6 != Composer.Companion.getEmpty()) goto L42;
    L36:
        r5 = false;
        goto L37
    L27:
        r4 = false;
        goto L29
    L5:
        if (r12.changed(r7) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r11;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }
}
