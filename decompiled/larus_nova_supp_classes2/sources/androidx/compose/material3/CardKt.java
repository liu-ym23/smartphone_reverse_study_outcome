package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001aw\u0010\u0019\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0081\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "onClick", "Lkotlin/Function0;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CardKt {
    private static final Unit Card$lambda$0(Modifier r10, Shape r11, CardColors r12, CardElevation r13, BorderStroke r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        Card(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit Card$lambda$2(Function0 r13, Modifier r14, boolean r15, Shape r16, CardColors r17, CardElevation r18, BorderStroke r19, MutableInteractionSource r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        Card(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedCard$lambda$3(Modifier r9, Shape r10, CardColors r11, CardElevation r12, Function3 r13, int r14, int r15, Composer r16, int r17) {
        ElevatedCard(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedCard$lambda$4(Function0 r12, Modifier r13, boolean r14, Shape r15, CardColors r16, CardElevation r17, MutableInteractionSource r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        ElevatedCard(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedCard$lambda$5(Modifier r10, Shape r11, CardColors r12, CardElevation r13, BorderStroke r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        OutlinedCard(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedCard$lambda$6(Function0 r13, Modifier r14, boolean r15, Shape r16, CardColors r17, CardElevation r18, BorderStroke r19, MutableInteractionSource r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        OutlinedCard(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, boolean r2, Shape r3, CardColors r4, CardElevation r5, BorderStroke r6, MutableInteractionSource r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return OutlinedCard$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit b(Modifier r0, Shape r1, CardColors r2, CardElevation r3, BorderStroke r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return Card$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit c(Modifier r0, Shape r1, CardColors r2, CardElevation r3, Function3 r4, int r5, int r6, Composer r7, int r8) {
        return ElevatedCard$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit d(Modifier r0, Shape r1, CardColors r2, CardElevation r3, BorderStroke r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return OutlinedCard$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit e(Function0 r0, Modifier r1, boolean r2, Shape r3, CardColors r4, CardElevation r5, BorderStroke r6, MutableInteractionSource r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return Card$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit f(Function0 r0, Modifier r1, boolean r2, Shape r3, CardColors r4, CardElevation r5, MutableInteractionSource r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return ElevatedCard$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static final void ElevatedCard(Modifier r19, Shape r20, CardColors r21, CardElevation r22, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(-1464672362);
        int r2 = r26 & 1;
        if (r2 == 0) goto L6;
        int r4 = r25 | 6;
        Modifier r3 = r19;
    L14:
        if ((r25 & 48) == 0) goto L16;
        Shape r5 = r20;
    L25:
        if ((r25 & 384) == 0) goto L27;
        CardColors r7 = r21;
    L36:
        if ((r25 & 3072) == 0) goto L38;
        CardElevation r8 = r22;
    L47:
        if ((r26 & 16) == 0) goto L50;
        r4 = r4 | 24576;
    L57:
        if ((r4 & 9363) == 9362) goto L59;
        boolean r9 = true;
    L61:
        if (r1.shouldExecute(r9, r4 & 1) == false) goto L98;
        r1.startDefaults();
        if ((r25 & 1) != 0) goto L65;
    L77:
        if (r2 == 0) goto L79;
        Modifier r6 = Modifier.Companion;
    L81:
        if ((r26 & 2) == 0) goto L83;
        Shape r10 = CardDefaults.INSTANCE.getElevatedShape(r1, 6);
        r4 = r4 & (-113);
    L85:
        if ((r26 & 4) == 0) goto L87;
        CardColors r11 = CardDefaults.INSTANCE.elevatedCardColors(r1, 6);
        r4 = r4 & (-897);
    L89:
        if ((r26 & 8) == 0) goto L91;
        CardElevation r12 = CardDefaults.INSTANCE.m2373elevatedCardElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 1572864, 63);
        int r13 = r4 & (-7169);
        final CardElevation r14 = r12;
    L92:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventStart(-1464672362, r13, -1, "androidx.compose.material3.ElevatedCard (Card.kt:197)");
    L95:
        int r15 = (((((r13 & 14) | 24576) | (r13 & 112)) | (r13 & 896)) | (r13 & 7168)) | ((r13 << 3) & 458752);
        Card(r6, r10, r11, r14, null, r23, r1, r15, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L99:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L103;
        final Modifier r17 = r6;
        final Shape r18 = r10;
        final CardColors r27 = r11;
        r16.updateScope(new s2(r17, r18, r27, r14, r23, r25, r26));
        return;
    L103:
        return;
    L91:
        r13 = r4;
        r14 = r8;
        goto L92
    L87:
        r11 = r7;
        goto L89
    L83:
        r10 = r5;
        goto L85
    L79:
        r6 = r3;
        goto L81
    L65:
        if (r1.getDefaultsInvalid() == true) goto L77;
        r1.skipToGroupEnd();
        if ((r26 & 2) == 0) goto L71;
        r4 = r4 & (-113);
    L71:
        if ((r26 & 4) == 0) goto L74;
        r4 = r4 & (-897);
    L74:
        if ((r26 & 8) == 0) goto L76;
        r4 = r4 & (-7169);
    L76:
        r6 = r3;
        r10 = r5;
        r11 = r7;
        goto L91
    L98:
        r1.skipToGroupEnd();
        r6 = r3;
        r10 = r5;
        r11 = r7;
        r14 = r8;
        goto L99
    L59:
        r9 = false;
        goto L61
    L50:
        if ((r25 & 24576) != 0) goto L57;
        if (r1.changedInstance(r23) == false) goto L54;
        int r28 = 16384;
    L55:
        r4 = r4 | r28;
        goto L57
    L54:
        r28 = 8192;
        goto L55
    L38:
        if ((r26 & 8) != 0) goto L42;
        r8 = r22;
        if (r1.changed(r8) == false) goto L43;
        int r29 = 2048;
    L44:
        r4 = r4 | r29;
    L43:
        r29 = 1024;
        goto L44
    L42:
        r8 = r22;
        goto L43
    L27:
        if ((r26 & 4) != 0) goto L31;
        r7 = r21;
        if (r1.changed(r7) == false) goto L32;
        int r30 = 256;
    L33:
        r4 = r4 | r30;
    L32:
        r30 = 128;
        goto L33
    L31:
        r7 = r21;
        goto L32
    L16:
        if ((r26 & 2) != 0) goto L20;
        r5 = r20;
        if (r1.changed(r5) == false) goto L21;
        int r31 = 32;
    L22:
        r4 = r4 | r31;
    L21:
        r31 = 16;
        goto L22
    L20:
        r5 = r20;
        goto L21
    L6:
        if ((r25 & 6) != 0) goto L12;
        r3 = r19;
        if (r1.changed(r3) == false) goto L10;
        int r32 = 4;
    L11:
        r4 = r32 | r25;
        goto L14
    L10:
        r32 = 2;
        goto L11
    L12:
        r3 = r19;
        r4 = r25;
        goto L14
    }

    public static final void Card(Modifier r24, Shape r25, CardColors r26, CardElevation r27, BorderStroke r28, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(1359693790);
        int r2 = r32 & 1;
        if (r2 == 0) goto L6;
        int r4 = r31 | 6;
        Modifier r3 = r24;
    L14:
        if ((r31 & 48) == 0) goto L16;
        Shape r5 = r25;
    L25:
        if ((r31 & 384) == 0) goto L27;
        CardColors r8 = r26;
    L36:
        if ((r31 & 3072) == 0) goto L38;
        CardElevation r9 = r27;
    L46:
        int r18 = r32 & 16;
        if (r18 == 0) goto L49;
        r4 = r4 | 24576;
        BorderStroke r15 = r28;
    L57:
        if ((r32 & 32) == 0) goto L60;
        r4 = r4 | 196608;
    L67:
        if ((74899 & r4) == 74898) goto L69;
        boolean r10 = true;
    L71:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L113;
        r1.startDefaults();
        if ((r31 & 1) != 0) goto L75;
    L87:
        if (r2 == 0) goto L89;
        Modifier r6 = Modifier.Companion;
    L91:
        if ((r32 & 2) == 0) goto L93;
        Shape r7 = CardDefaults.INSTANCE.getShape(r1, 6);
        r4 = r4 & (-113);
    L95:
        if ((r32 & 4) == 0) goto L97;
        CardColors r11 = CardDefaults.INSTANCE.cardColors(r1, 6);
        r4 = r4 & (-897);
    L99:
        if ((r32 & 8) == 0) goto L101;
        CardElevation r12 = CardDefaults.INSTANCE.m2371cardElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 1572864, 63);
        r4 = r4 & (-7169);
    L102:
        if (r18 == 0) goto L104;
        BorderStroke r21 = null;
    L105:
        CardElevation r23 = r12;
        int r13 = r4;
        final CardElevation r14 = r23;
    L106:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventStart(1359693790, r13, -1, "androidx.compose.material3.Card (Card.kt:86)");
    L109:
        long r16 = r11.m2363containerColorvNxB06k$material3(true);
        long r17 = r11.m2364contentColorvNxB06k$material3(true);
        float r19 = ((Dp) r14.shadowElevation$material3(true, null, r1, ((r13 >> 3) & 896) | 54).getValue()).unbox-impl();
        ComposableLambda r110 = ComposableLambdaKt.rememberComposableLambda(-97109725, true, new AnonymousClass1(r29), r1, 54);
        int r111 = (((r13 & 14) | 12582912) | (r13 & 112)) | ((r13 << 6) & 3670016);
        SurfaceKt.m3213SurfaceT9BRK9s(r6, r7, r16, r17, MenuKt.ClosedAlphaTarget, r19, r21, r110, r1, r111, 16);
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventEnd();
    L112:
        r8 = r11;
        final BorderStroke r20 = r21;
    L114:
        ScopeUpdateScope r22 = r1.endRestartGroup();
        if (r22 == null) goto L118;
        final Modifier r33 = r6;
        final Shape r34 = r7;
        final CardColors r35 = r8;
        r22.updateScope(new u2(r33, r34, r35, r14, r20, r29, r31, r32));
        return;
    L118:
        return;
    L104:
        r21 = r28;
        goto L105
    L101:
        r12 = r9;
        goto L102
    L97:
        r11 = r8;
        goto L99
    L93:
        r7 = r5;
        goto L95
    L89:
        r6 = r3;
        goto L91
    L75:
        if (r1.getDefaultsInvalid() == true) goto L87;
        r1.skipToGroupEnd();
        if ((r32 & 2) == 0) goto L81;
        r4 = r4 & (-113);
    L81:
        if ((r32 & 4) == 0) goto L84;
        r4 = r4 & (-897);
    L84:
        if ((r32 & 8) == 0) goto L86;
        r4 = r4 & (-7169);
    L86:
        r6 = r3;
        r7 = r5;
        r11 = r8;
        r21 = r15;
        r13 = r4;
        r14 = r9;
        goto L106
    L113:
        r1.skipToGroupEnd();
        r6 = r3;
        r7 = r5;
        r14 = r9;
        r20 = r28;
        goto L114
    L69:
        r10 = false;
        goto L71
    L60:
        if ((r31 & 196608) != 0) goto L67;
        if (r1.changedInstance(r29) == false) goto L64;
        int r112 = 131072;
    L65:
        r4 = r4 | r112;
        goto L67
    L64:
        r112 = 65536;
        goto L65
    L49:
        r15 = r28;
        if ((r31 & 24576) != 0) goto L57;
        if (r1.changed(r15) == false) goto L54;
        int r113 = 16384;
    L55:
        r4 = r4 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L38:
        if ((r32 & 8) != 0) goto L42;
        r9 = r27;
        if (r1.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r4 = r4 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r27;
        goto L43
    L27:
        if ((r32 & 4) != 0) goto L31;
        r8 = r26;
        if (r1.changed(r8) == false) goto L32;
        int r36 = 256;
    L33:
        r4 = r4 | r36;
    L32:
        r36 = 128;
        goto L33
    L31:
        r8 = r26;
        goto L32
    L16:
        if ((r32 & 2) != 0) goto L20;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r37 = 32;
    L22:
        r4 = r4 | r37;
    L21:
        r37 = 16;
        goto L22
    L20:
        r5 = r25;
        goto L21
    L6:
        if ((r31 & 6) != 0) goto L12;
        r3 = r24;
        if (r1.changed(r3) == false) goto L10;
        int r38 = 4;
    L11:
        r4 = r38 | r31;
        goto L14
    L10:
        r38 = 2;
        goto L11
    L12:
        r3 = r24;
        r4 = r31;
        goto L14
    }

    public static final void OutlinedCard(Modifier r21, Shape r22, CardColors r23, CardElevation r24, BorderStroke r25, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-1945643296);
        int r2 = r29 & 1;
        if (r2 == 0) goto L6;
        int r4 = r28 | 6;
        Modifier r3 = r21;
    L14:
        if ((r28 & 48) == 0) goto L16;
        Shape r5 = r22;
    L25:
        if ((r28 & 384) == 0) goto L27;
        CardColors r6 = r23;
    L36:
        if ((r28 & 3072) == 0) goto L38;
        CardElevation r8 = r24;
    L47:
        if ((r28 & 24576) != 0) goto L55;
        BorderStroke r15 = r25;
        if ((r29 & 16) == 0) goto L51;
    L53:
        int r9 = 8192;
    L54:
        r4 = r4 | r9;
    L57:
        if ((r29 & 32) == 0) goto L60;
        r4 = r4 | 196608;
    L67:
        if ((74899 & r4) == 74898) goto L69;
        boolean r10 = true;
    L71:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L116;
        r1.startDefaults();
        if ((r28 & 1) != 0) goto L75;
    L90:
        if (r2 == 0) goto L92;
        Modifier r7 = Modifier.Companion;
    L94:
        if ((r29 & 2) == 0) goto L96;
        Shape r11 = CardDefaults.INSTANCE.getOutlinedShape(r1, 6);
        r4 = r4 & (-113);
    L98:
        if ((r29 & 4) == 0) goto L100;
        CardColors r12 = CardDefaults.INSTANCE.outlinedCardColors(r1, 6);
        r4 = r4 & (-897);
    L102:
        if ((r29 & 8) == 0) goto L104;
        int r0 = 1;
        boolean r13 = false;
        r8 = CardDefaults.INSTANCE.m2375outlinedCardElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 1572864, 63);
        r4 = r4 & (-7169);
    L106:
        if ((r29 & 16) == 0) goto L108;
        BorderStroke r14 = CardDefaults.INSTANCE.outlinedCardBorder(r13, r1, 48, r0);
        int r16 = r4 & (-57345);
        BorderStroke r17 = r14;
        CardElevation r18 = r8;
    L109:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(-1945643296, r16, -1, "androidx.compose.material3.OutlinedCard (Card.kt:298)");
    L112:
        int r19 = (((((r16 & 14) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168)) | (57344 & r16)) | (r16 & 458752);
        Card(r7, r11, r12, r18, r17, r26, r1, r19, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
    L115:
        BorderStroke r20 = r17;
        final CardElevation r30 = r18;
    L117:
        ScopeUpdateScope r31 = r1.endRestartGroup();
        if (r31 == null) goto L121;
        final Modifier r32 = r7;
        final Shape r33 = r11;
        final CardColors r34 = r12;
        final BorderStroke r35 = r20;
        r31.updateScope(new t2(r32, r33, r34, r30, r35, r26, r28, r29));
        return;
    L121:
        return;
    L108:
        r16 = r4;
        r18 = r8;
        r17 = r25;
        goto L109
    L104:
        r0 = 1;
        r13 = false;
        goto L106
    L100:
        r12 = r6;
        goto L102
    L96:
        r11 = r5;
        goto L98
    L92:
        r7 = r3;
        goto L94
    L75:
        if (r1.getDefaultsInvalid() == true) goto L90;
        r1.skipToGroupEnd();
        if ((r29 & 2) == 0) goto L81;
        r4 = r4 & (-113);
    L81:
        if ((r29 & 4) == 0) goto L84;
        r4 = r4 & (-897);
    L84:
        if ((r29 & 8) == 0) goto L87;
        r4 = r4 & (-7169);
    L87:
        if ((r29 & 16) == 0) goto L89;
        r4 = r4 & (-57345);
    L89:
        r7 = r3;
        r11 = r5;
        r12 = r6;
        r18 = r8;
        r16 = r4;
        r17 = r15;
        goto L109
    L116:
        r1.skipToGroupEnd();
        r7 = r3;
        r11 = r5;
        r12 = r6;
        r30 = r8;
        r20 = r25;
        goto L117
    L69:
        r10 = false;
        goto L71
    L60:
        if ((r28 & 196608) != 0) goto L67;
        if (r1.changedInstance(r26) == false) goto L64;
        int r36 = 131072;
    L65:
        r4 = r4 | r36;
        goto L67
    L64:
        r36 = 65536;
        goto L65
    L51:
        if (r1.changed(r15) == false) goto L53;
        r9 = 16384;
        goto L54
    L55:
        r15 = r25;
        goto L57
    L38:
        if ((r29 & 8) != 0) goto L42;
        r8 = r24;
        if (r1.changed(r8) == false) goto L43;
        int r37 = 2048;
    L44:
        r4 = r4 | r37;
    L43:
        r37 = 1024;
        goto L44
    L42:
        r8 = r24;
        goto L43
    L27:
        if ((r29 & 4) != 0) goto L31;
        r6 = r23;
        if (r1.changed(r6) == false) goto L32;
        int r38 = 256;
    L33:
        r4 = r4 | r38;
    L32:
        r38 = 128;
        goto L33
    L31:
        r6 = r23;
        goto L32
    L16:
        if ((r29 & 2) != 0) goto L20;
        r5 = r22;
        if (r1.changed(r5) == false) goto L21;
        int r39 = 32;
    L22:
        r4 = r4 | r39;
    L21:
        r39 = 16;
        goto L22
    L20:
        r5 = r22;
        goto L21
    L6:
        if ((r28 & 6) != 0) goto L12;
        r3 = r21;
        if (r1.changed(r3) == false) goto L10;
        int r40 = 4;
    L11:
        r4 = r40 | r28;
        goto L14
    L10:
        r40 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r28;
        goto L14
    }

    public static final void ElevatedCard(final Function0<Unit> r24, Modifier r25, boolean r26, Shape r27, CardColors r28, CardElevation r29, MutableInteractionSource r30, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-129138571);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L13:
        int r4 = r34 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r25;
    L24:
        int r6 = r34 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r26;
    L36:
        if ((r33 & 3072) == 0) goto L38;
        Shape r8 = r27;
    L47:
        if ((r33 & 24576) == 0) goto L49;
        CardColors r11 = r28;
    L58:
        if ((196608 & r33) == 0) goto L60;
        CardElevation r12 = r29;
    L68:
        int r21 = r34 & 64;
        if (r21 == 0) goto L71;
        r3 = r3 | 1572864;
        MutableInteractionSource r15 = r30;
    L79:
        if ((r34 & 128) == 0) goto L82;
        r3 = r3 | 12582912;
    L89:
        if ((4793491 & r3) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L134;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L97;
    L109:
        if (r4 == 0) goto L111;
        r5 = Modifier.Companion;
    L111:
        if (r6 == 0) goto L114;
        r7 = true;
    L114:
        if ((r34 & 8) == 0) goto L117;
        r3 = r3 & (-7169);
        r8 = CardDefaults.INSTANCE.getElevatedShape(r1, 6);
    L117:
        if ((r34 & 16) == 0) goto L119;
        CardColors r2 = CardDefaults.INSTANCE.elevatedCardColors(r1, 6);
        r3 = r3 & (-57345);
    L121:
        if ((r34 & 32) == 0) goto L123;
        r3 = r3 & (-458753);
        r12 = CardDefaults.INSTANCE.m2373elevatedCardElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 1572864, 63);
    L123:
        if (r21 == 0) goto L125;
        MutableInteractionSource r9 = null;
    L126:
        int r10 = r3;
        CardElevation r13 = r12;
    L127:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventStart(-129138571, r10, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
    L130:
        int r14 = ((((((r10 & 14) | 1572864) | (r10 & 112)) | (r10 & 896)) | (r10 & 7168)) | (57344 & r10)) | (458752 & r10);
        int r16 = r10 << 3;
        int r22 = (r14 | (29360128 & r16)) | (r16 & 234881024);
        Card(r24, r5, r7, r8, r2, r13, null, r9, r31, r1, r22, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventEnd();
    L133:
        r11 = r2;
        final CardElevation r17 = r13;
        final boolean r18 = r7;
        final MutableInteractionSource r19 = r9;
        final Shape r20 = r8;
    L135:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L139;
        final Modifier r23 = r5;
        final CardColors r35 = r11;
        r110.updateScope(new v2(r24, r23, r18, r20, r35, r17, r19, r31, r33, r34));
        return;
    L139:
        return;
    L125:
        r9 = r30;
        goto L126
    L119:
        r2 = r11;
        goto L121
    L97:
        if (r1.getDefaultsInvalid() == true) goto L109;
        r1.skipToGroupEnd();
        if ((r34 & 8) == 0) goto L103;
        r3 = r3 & (-7169);
    L103:
        if ((r34 & 16) == 0) goto L106;
        r3 = r3 & (-57345);
    L106:
        if ((r34 & 32) == 0) goto L108;
        r3 = r3 & (-458753);
    L108:
        r10 = r3;
        r2 = r11;
        r13 = r12;
        r9 = r15;
        goto L127
    L134:
        r1.skipToGroupEnd();
        r18 = r7;
        r20 = r8;
        r17 = r12;
        r19 = r30;
        goto L135
    L91:
        r0 = false;
        goto L93
    L82:
        if ((r33 & 12582912) != 0) goto L89;
        if (r1.changedInstance(r31) == false) goto L86;
        int r111 = 8388608;
    L87:
        r3 = r3 | r111;
        goto L89
    L86:
        r111 = 4194304;
        goto L87
    L71:
        r15 = r30;
        if ((r33 & 1572864) != 0) goto L79;
        if (r1.changed(r15) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L79
    L76:
        r112 = 524288;
        goto L77
    L60:
        if ((r34 & 32) != 0) goto L64;
        r12 = r29;
        if (r1.changed(r12) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
    L65:
        r113 = 65536;
        goto L66
    L64:
        r12 = r29;
        goto L65
    L49:
        if ((r34 & 16) != 0) goto L53;
        r11 = r28;
        if (r1.changed(r11) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
    L54:
        r114 = 8192;
        goto L55
    L53:
        r11 = r28;
        goto L54
    L38:
        if ((r34 & 8) != 0) goto L42;
        r8 = r27;
        if (r1.changed(r8) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
    L43:
        r115 = 1024;
        goto L44
    L42:
        r8 = r27;
        goto L43
    L28:
        if ((r33 & 384) != 0) goto L34;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r36 = 256;
    L33:
        r3 = r3 | r36;
        goto L36
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r33 & 48) != 0) goto L23;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r37 = 32;
    L22:
        r3 = r3 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L13
    L8:
        if (r1.changedInstance(r24) == false) goto L10;
        int r38 = 4;
    L11:
        r3 = r38 | r33;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    public static final void Card(final Function0<Unit> r30, Modifier r31, boolean r32, Shape r33, CardColors r34, CardElevation r35, BorderStroke r36, MutableInteractionSource r37, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(2136075085);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r4 = r41 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r31;
    L24:
        int r6 = r41 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r32;
    L36:
        if ((r40 & 3072) == 0) goto L38;
        Shape r8 = r33;
    L47:
        if ((r40 & 24576) == 0) goto L49;
        CardColors r12 = r34;
    L58:
        if ((196608 & r40) == 0) goto L60;
        CardElevation r13 = r35;
    L68:
        int r22 = r41 & 64;
        if (r22 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r14 = r41 & 128;
        if (r14 == 0) goto L82;
        r3 = r3 | 12582912;
    L89:
        if ((r41 & 256) == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((38347923 & r3) == 38347922) goto L101;
        boolean r0 = true;
    L103:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L155;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L107;
    L120:
        if (r4 == 0) goto L122;
        r5 = Modifier.Companion;
    L122:
        if (r6 == 0) goto L125;
        r7 = true;
    L125:
        if ((r41 & 8) == 0) goto L128;
        r3 = r3 & (-7169);
        r8 = CardDefaults.INSTANCE.getShape(r1, 6);
    L128:
        if ((r41 & 16) == 0) goto L130;
        CardColors r2 = CardDefaults.INSTANCE.cardColors(r1, 6);
        r3 = r3 & (-57345);
    L132:
        if ((r41 & 32) == 0) goto L134;
        boolean r9 = true;
        final CardElevation r10 = CardDefaults.INSTANCE.m2371cardElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 1572864, 63);
        r3 = (-458753) & r3;
    L136:
        if (r22 == 0) goto L138;
        BorderStroke r15 = null;
    L139:
        if (r14 == 0) goto L141;
        int r29 = r3;
        MutableInteractionSource r11 = null;
        BorderStroke r16 = r15;
        int r17 = r29;
    L142:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventStart(2136075085, r17, -1, "androidx.compose.material3.Card (Card.kt:145)");
    L145:
        if (r11 != null) goto L150;
        r1.startReplaceGroup(1577885006);
        Object r18 = r1.rememberedValue();
        if (r18 != Composer.Companion.getEmpty()) goto L149;
        r18 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r18);
    L149:
        r1.endReplaceGroup();
        MutableInteractionSource r19 = (MutableInteractionSource) r18;
    L151:
        CardColors r310 = r2;
        MutableInteractionSource r20 = r19;
        SurfaceKt.m3216Surfaceo_FOJdg(r30, r5, r7, r8, r2.m2363containerColorvNxB06k$material3(r7), r2.m2364contentColorvNxB06k$material3(r7), MenuKt.ClosedAlphaTarget, ((Dp) r10.shadowElevation$material3(r7, r19, r1, ((r17 >> 6) & 14) | ((r17 >> 9) & 896)).getValue()).unbox-impl(), r16, r20, ComposableLambdaKt.rememberComposableLambda(-1347531112, r9, new AnonymousClass3(r38), r1, 54), r1, ((((r17 & 14) | (r17 & 112)) | (r17 & 896)) | (r17 & 7168)) | (234881024 & (r17 << 6)), 6, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L154;
        ComposerKt.traceEventEnd();
    L154:
        final Shape r21 = r8;
        final MutableInteractionSource r23 = r11;
        final boolean r24 = r7;
        final BorderStroke r25 = r16;
        final Modifier r26 = r5;
        final CardColors r27 = r310;
    L156:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L160;
        r110.updateScope(new r2(r30, r26, r24, r21, r27, r10, r25, r23, r38, r40, r41));
        return;
    L160:
        return;
    L150:
        r1.startReplaceGroup(-226195799);
        r1.endReplaceGroup();
        r19 = r11;
        goto L151
    L141:
        r16 = r15;
    L119:
        r17 = r3;
        r11 = r37;
        goto L142
    L138:
        r15 = r36;
        goto L139
    L134:
        r9 = true;
        r10 = r13;
        goto L136
    L130:
        r2 = r12;
        goto L132
    L107:
        if (r1.getDefaultsInvalid() == true) goto L120;
        r1.skipToGroupEnd();
        if ((r41 & 8) == 0) goto L113;
        r3 = r3 & (-7169);
    L113:
        if ((r41 & 16) == 0) goto L116;
        r3 = r3 & (-57345);
    L116:
        if ((r41 & 32) == 0) goto L118;
        r3 = r3 & (-458753);
    L118:
        r16 = r36;
        r2 = r12;
        r10 = r13;
        r9 = true;
        goto L119
    L155:
        r1.skipToGroupEnd();
        r26 = r5;
        r24 = r7;
        r21 = r8;
        r27 = r12;
        r10 = r13;
        r25 = r36;
        r23 = r37;
        goto L156
    L101:
        r0 = false;
        goto L103
    L92:
        if ((r40 & 100663296) != 0) goto L99;
        if (r1.changedInstance(r38) == false) goto L96;
        int r28 = 67108864;
    L97:
        r3 = r3 | r28;
        goto L99
    L96:
        r28 = 33554432;
        goto L97
    L82:
        if ((r40 & 12582912) != 0) goto L89;
        if (r1.changed(r37) == false) goto L86;
        int r111 = 8388608;
    L87:
        r3 = r3 | r111;
        goto L89
    L86:
        r111 = 4194304;
        goto L87
    L72:
        if ((1572864 & r40) != 0) goto L78;
        if (r1.changed(r36) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L78
    L76:
        r112 = 524288;
        goto L77
    L60:
        if ((r41 & 32) != 0) goto L64;
        r13 = r35;
        if (r1.changed(r13) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
    L65:
        r113 = 65536;
        goto L66
    L64:
        r13 = r35;
        goto L65
    L49:
        if ((r41 & 16) != 0) goto L53;
        r12 = r34;
        if (r1.changed(r12) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
    L54:
        r114 = 8192;
        goto L55
    L53:
        r12 = r34;
        goto L54
    L38:
        if ((r41 & 8) != 0) goto L42;
        r8 = r33;
        if (r1.changed(r8) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
    L43:
        r115 = 1024;
        goto L44
    L42:
        r8 = r33;
        goto L43
    L28:
        if ((r40 & 384) != 0) goto L34;
        r7 = r32;
        if (r1.changed(r7) == false) goto L32;
        int r42 = 256;
    L33:
        r3 = r3 | r42;
        goto L36
    L32:
        r42 = 128;
        goto L33
    L17:
        if ((r40 & 48) != 0) goto L23;
        r5 = r31;
        if (r1.changed(r5) == false) goto L21;
        int r43 = 32;
    L22:
        r3 = r3 | r43;
        goto L24
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r1.changedInstance(r30) == false) goto L10;
        int r44 = 4;
    L11:
        r3 = r44 | r40;
        goto L13
    L10:
        r44 = 2;
        goto L11
    }

    public static final void OutlinedCard(final Function0<Unit> r24, Modifier r25, boolean r26, Shape r27, CardColors r28, CardElevation r29, BorderStroke r30, MutableInteractionSource r31, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r1 = r33.startRestartGroup(1401605899);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L13:
        int r4 = r35 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r25;
    L24:
        int r6 = r35 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r26;
    L36:
        if ((r34 & 3072) == 0) goto L38;
        Shape r8 = r27;
    L47:
        if ((r34 & 24576) == 0) goto L49;
        CardColors r9 = r28;
    L58:
        if ((196608 & r34) == 0) goto L60;
        CardElevation r12 = r29;
    L69:
        if ((1572864 & r34) != 0) goto L78;
        if ((r35 & 64) == 0) goto L73;
    L75:
        int r13 = 524288;
    L76:
        r3 = r3 | r13;
        goto L78
    L73:
        if (r1.changed(r30) == false) goto L75;
        r13 = 1048576;
    L78:
        int r14 = r35 & 128;
        if (r14 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        MutableInteractionSource r15 = r31;
    L90:
        if ((r35 & 256) == 0) goto L93;
        r3 = r3 | 100663296;
    L101:
        if ((r3 & 38347923) == 38347922) goto L103;
        boolean r0 = true;
    L105:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L152;
        r1.startDefaults();
        if ((r34 & 1) != 0) goto L109;
    L124:
        if (r4 == 0) goto L126;
        r5 = Modifier.Companion;
    L126:
        if (r6 == 0) goto L129;
        r7 = true;
    L129:
        if ((r35 & 8) == 0) goto L132;
        r3 = r3 & (-7169);
        r8 = CardDefaults.INSTANCE.getOutlinedShape(r1, 6);
    L132:
        if ((r35 & 16) == 0) goto L135;
        r3 = r3 & (-57345);
        r9 = CardDefaults.INSTANCE.outlinedCardColors(r1, 6);
    L135:
        if ((r35 & 32) == 0) goto L137;
        int r10 = 0;
        final CardElevation r11 = CardDefaults.INSTANCE.m2375outlinedCardElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 1572864, 63);
        r3 = r3 & (-458753);
    L139:
        if ((r35 & 64) == 0) goto L141;
        BorderStroke r16 = CardDefaults.INSTANCE.outlinedCardBorder(r7, r1, ((r3 >> 6) & 14) | 48, r10);
        r3 = (-3670017) & r3;
    L142:
        if (r14 == 0) goto L144;
        MutableInteractionSource r2 = null;
    L145:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventStart(1401605899, r3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
    L148:
        Modifier r17 = r5;
        boolean r18 = r7;
        Shape r19 = r8;
        CardColors r110 = r9;
        CardElevation r111 = r11;
        BorderStroke r112 = r16;
        MutableInteractionSource r113 = r2;
        Card(r24, r17, r18, r19, r110, r111, r112, r113, r32, r1, ((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (r3 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L151;
        ComposerKt.traceEventEnd();
    L151:
        final Modifier r20 = r5;
        final boolean r21 = r7;
        final CardColors r22 = r9;
        final BorderStroke r23 = r16;
        final Shape r36 = r8;
        final MutableInteractionSource r37 = r2;
    L153:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L157;
        r114.updateScope(new q2(r24, r20, r21, r36, r22, r11, r23, r37, r32, r34, r35));
        return;
    L157:
        return;
    L144:
        r2 = r31;
        goto L145
    L141:
        r16 = r30;
        goto L142
    L137:
        r10 = 0;
        r11 = r12;
        goto L139
    L109:
        if (r1.getDefaultsInvalid() == true) goto L124;
        r1.skipToGroupEnd();
        if ((r35 & 8) == 0) goto L115;
        r3 = r3 & (-7169);
    L115:
        if ((r35 & 16) == 0) goto L118;
        r3 = r3 & (-57345);
    L118:
        if ((r35 & 32) == 0) goto L121;
        r3 = r3 & (-458753);
    L121:
        if ((r35 & 64) == 0) goto L123;
        r3 = r3 & (-3670017);
    L123:
        r16 = r30;
        r11 = r12;
        r2 = r15;
        goto L145
    L152:
        r1.skipToGroupEnd();
        r20 = r5;
        r21 = r7;
        r36 = r8;
        r22 = r9;
        r11 = r12;
        r23 = r30;
        r37 = r31;
        goto L153
    L103:
        r0 = false;
        goto L105
    L93:
        if ((r34 & 100663296) != 0) goto L101;
        if (r1.changedInstance(r32) == false) goto L97;
        int r115 = 67108864;
    L98:
        r3 = r3 | r115;
        goto L101
    L97:
        r115 = 33554432;
        goto L98
    L82:
        if ((12582912 & r34) != 0) goto L88;
        r15 = r31;
        if (r1.changed(r15) == false) goto L86;
        int r116 = 8388608;
    L87:
        r3 = r3 | r116;
        goto L90
    L86:
        r116 = 4194304;
        goto L87
    L60:
        if ((r35 & 32) != 0) goto L64;
        r12 = r29;
        if (r1.changed(r12) == false) goto L65;
        int r117 = 131072;
    L66:
        r3 = r3 | r117;
    L65:
        r117 = 65536;
        goto L66
    L64:
        r12 = r29;
        goto L65
    L49:
        if ((r35 & 16) != 0) goto L53;
        r9 = r28;
        if (r1.changed(r9) == false) goto L54;
        int r118 = 16384;
    L55:
        r3 = r3 | r118;
    L54:
        r118 = 8192;
        goto L55
    L53:
        r9 = r28;
        goto L54
    L38:
        if ((r35 & 8) != 0) goto L42;
        r8 = r27;
        if (r1.changed(r8) == false) goto L43;
        int r38 = 2048;
    L44:
        r3 = r3 | r38;
    L43:
        r38 = 1024;
        goto L44
    L42:
        r8 = r27;
        goto L43
    L28:
        if ((r34 & 384) != 0) goto L34;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r39 = 256;
    L33:
        r3 = r3 | r39;
        goto L36
    L32:
        r39 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L23;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r40 = 32;
    L22:
        r3 = r3 | r40;
        goto L24
    L21:
        r40 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L13
    L8:
        if (r1.changedInstance(r24) == false) goto L10;
        int r41 = 4;
    L11:
        r3 = r41 | r34;
        goto L13
    L10:
        r41 = 2;
        goto L11
    }
}
