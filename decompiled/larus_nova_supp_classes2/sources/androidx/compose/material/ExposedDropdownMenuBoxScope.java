package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&JU\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "exposedDropdownSize", "Landroidx/compose/ui/Modifier;", "matchTextFieldWidth", "", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public ExposedDropdownMenuBoxScope() {
    }

    private static final Unit ExposedDropdownMenu$lambda$4(ExposedDropdownMenuBoxScope r10, boolean r11, Function0 r12, Modifier r13, ScrollState r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        r10.ExposedDropdownMenu(r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ExposedDropdownMenuBoxScope r0, boolean r1, Function0 r2, Modifier r3, ScrollState r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return ExposedDropdownMenu$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit b(MutableState r0, IntRect r1, IntRect r2) {
        return ExposedDropdownMenu$lambda$3$lambda$2(r0, r1, r2);
    }

    public abstract Modifier exposedDropdownSize(Modifier r1, boolean r2);

    private static final Unit ExposedDropdownMenu$lambda$3$lambda$2(MutableState r0, IntRect r1, IntRect r2) {
        r0.setValue(TransformOrigin.box-impl(MenuKt.calculateTransformOrigin(r1, r2)));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope r0, Modifier r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = true;
    L7:
        return r0.exposedDropdownSize(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    public final void ExposedDropdownMenu(final boolean r27, final Function0<Unit> r28, Modifier r29, ScrollState r30, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r8 = r32.startRestartGroup(-1576205770);
        if ((r34 & 1) == 0) goto L6;
        int r1 = r33 | 6;
    L14:
        if ((r34 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r34 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        final Modifier r4 = r29;
    L35:
        if ((r33 & 3072) == 0) goto L37;
        final ScrollState r5 = r30;
    L46:
        if ((r34 & 16) == 0) goto L49;
        r1 = r1 | 24576;
    L57:
        if ((r34 & 32) == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        if ((74899 & r1) == 74898) goto L69;
        boolean r11 = true;
    L71:
        if (r8.shouldExecute(r11, r1 & 1) == false) goto L112;
        r8.startDefaults();
        if ((r33 & 1) != 0) goto L75;
    L81:
        if (r3 == 0) goto L83;
        Modifier r6 = Modifier.Companion;
    L85:
        if ((r34 & 8) == 0) goto L87;
        r1 = r1 & (-7169);
        Modifier r18 = r6;
        ScrollState r19 = ScrollKt.rememberScrollState(0, r8, 0, 1);
    L89:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(-1576205770, r1, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:186)");
    L92:
        Object r0 = r8.rememberedValue();
        Composer.Companion r7 = Composer.Companion;
        if (r0 != r7.getEmpty()) goto L95;
        r0 = new MutableTransitionState(Boolean.FALSE);
        r8.updateRememberedValue(r0);
    L95:
        final MutableTransitionState r12 = (MutableTransitionState) r0;
        r12.setTargetState(Boolean.valueOf(r27));
        if (((Boolean) r12.getCurrentState()).booleanValue() == false) goto L98;
    L101:
        r8.startReplaceGroup(132216667);
        Object r2 = r8.rememberedValue();
        if (r2 != r7.getEmpty()) goto L104;
        r2 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), null, 2, null);
        r8.updateRememberedValue(r2);
    L104:
        final MutableState r13 = (MutableState) r2;
        Density r23 = (Density) r8.consume(CompositionLocalsKt.getLocalDensity());
        long r21 = DpOffset.Companion.getZero-RKDOV3M();
        Object r9 = r8.rememberedValue();
        if (r9 != r7.getEmpty()) goto L107;
        r9 = new t4(r13);
        r8.updateRememberedValue(r9);
    L107:
        final ScrollState r14 = r19;
        final Modifier r16 = r18;
        ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(r28, new DropdownMenuPositionProvider(r21, r23, (Function2) r9, null), ComposableLambdaKt.rememberComposableLambda(1604457564, true, new AnonymousClass1(r12, r13, r14, this, r16, r31), r8, 54), r8, ((r1 >> 3) & 14) | 384, 0);
        r8.endReplaceGroup();
    L109:
        if (ComposerKt.isTraceInProgress() == false) goto L111;
        ComposerKt.traceEventEnd();
    L111:
        r4 = r18;
        r5 = r19;
    L113:
        ScopeUpdateScope r15 = r8.endRestartGroup();
        if (r15 == null) goto L117;
        r15.updateScope(new u4(this, r27, r28, r4, r5, r31, r33, r34));
        return;
    L117:
        return;
    L98:
        if (((Boolean) r12.getTargetState()).booleanValue() == true) goto L101;
        r8.startReplaceGroup(133094060);
        r8.endReplaceGroup();
        goto L109
    L87:
        r18 = r6;
    L88:
        r19 = r5;
        goto L89
    L83:
        r6 = r4;
        goto L85
    L75:
        if (r8.getDefaultsInvalid() == true) goto L81;
        r8.skipToGroupEnd();
        if ((r34 & 8) == 0) goto L80;
        r1 = r1 & (-7169);
    L80:
        r18 = r4;
        goto L88
    L112:
        r8.skipToGroupEnd();
        goto L113
    L69:
        r11 = false;
        goto L71
    L60:
        if ((r33 & 196608) != 0) goto L67;
        if (r8.changed(this) == false) goto L64;
        int r17 = 131072;
    L65:
        r1 = r1 | r17;
        goto L67
    L64:
        r17 = 65536;
        goto L65
    L49:
        if ((r33 & 24576) != 0) goto L57;
        if (r8.changedInstance(r31) == false) goto L53;
        int r110 = 16384;
    L54:
        r1 = r1 | r110;
        goto L57
    L53:
        r110 = 8192;
        goto L54
    L37:
        if ((r34 & 8) != 0) goto L41;
        r5 = r30;
        if (r8.changed(r5) == false) goto L42;
        int r10 = 2048;
    L43:
        r1 = r1 | r10;
    L42:
        r10 = 1024;
        goto L43
    L41:
        r5 = r30;
        goto L42
    L27:
        if ((r33 & 384) != 0) goto L33;
        r4 = r29;
        if (r8.changed(r4) == false) goto L31;
        int r20 = 256;
    L32:
        r1 = r1 | r20;
        goto L35
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r33 & 48) != 0) goto L23;
        if (r8.changedInstance(r28) == false) goto L21;
        int r22 = 32;
    L22:
        r1 = r1 | r22;
        goto L23
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r1 = r33;
        goto L14
    L8:
        if (r8.changed(r27) == false) goto L10;
        int r24 = 4;
    L11:
        r1 = r24 | r33;
        goto L14
    L10:
        r24 = 2;
        goto L11
    }
}
