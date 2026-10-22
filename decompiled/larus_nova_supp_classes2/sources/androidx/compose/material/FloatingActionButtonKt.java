package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0085\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"FloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "content", "Landroidx/compose/runtime/Composable;", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ExtendedFloatingActionButton", "text", "icon", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FabSize", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabIconPadding", "ExtendedFabTextPadding", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float ExtendedFabIconPadding = 0.0f;
    private static final float ExtendedFabSize = 0.0f;
    private static final float ExtendedFabTextPadding = 0.0f;
    private static final float FabSize = 0.0f;

    private static final Unit ExtendedFloatingActionButton_wqdebIU$lambda$4(Function2 r15, Function0 r16, Modifier r17, Function2 r18, MutableInteractionSource r19, Shape r20, long r21, long r23, FloatingActionButtonElevation r25, int r26, int r27, Composer r28, int r29) {
        m2078ExtendedFloatingActionButtonwqdebIU(r15, r16, r17, r18, r19, r20, r21, r23, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit FloatingActionButton_bogVsAg$lambda$3(Function0 r14, Modifier r15, MutableInteractionSource r16, Shape r17, long r18, long r20, FloatingActionButtonElevation r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m2079FloatingActionButtonbogVsAg(r14, r15, r16, r17, r18, r20, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, MutableInteractionSource r2, Shape r3, long r4, long r6, FloatingActionButtonElevation r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return FloatingActionButton_bogVsAg$lambda$3(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
        return FloatingActionButton_bogVsAg$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ Unit c(Function2 r0, Function0 r1, Modifier r2, Function2 r3, MutableInteractionSource r4, Shape r5, long r6, long r8, FloatingActionButtonElevation r10, int r11, int r12, Composer r13, int r14) {
        return ExtendedFloatingActionButton_wqdebIU$lambda$4(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14);
    }

    static {
        FabSize = Dp.constructor-impl(56);
        ExtendedFabSize = Dp.constructor-impl(48);
        ExtendedFabIconPadding = Dp.constructor-impl(12);
        ExtendedFabTextPadding = Dp.constructor-impl(20);
    }

    public static final /* synthetic */ float access$getExtendedFabIconPadding$p() {
        return ExtendedFabIconPadding;
    }

    public static final /* synthetic */ float access$getExtendedFabTextPadding$p() {
        return ExtendedFabTextPadding;
    }

    public static final /* synthetic */ float access$getFabSize$p() {
        return FabSize;
    }

    private static final Unit FloatingActionButton_bogVsAg$lambda$2$lambda$1(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    public static final void m2079FloatingActionButtonbogVsAg(final Function0<Unit> r28, Modifier r29, MutableInteractionSource r30, Shape r31, long r32, long r34, FloatingActionButtonElevation r36, final Function2<? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(-482679837);
        if ((r40 & 1) == 0) goto L6;
        int r3 = r39 | 6;
    L13:
        int r4 = r40 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r29;
    L24:
        int r6 = r40 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r39 & 3072) != 0) goto L47;
        if ((r40 & 8) != 0) goto L43;
        if (r1.changed(r31) == false) goto L43;
        int r9 = 2048;
    L44:
        r3 = r3 | r9;
    L43:
        r9 = 1024;
    L47:
        if ((r39 & 24576) != 0) goto L55;
        long r13 = r32;
        if ((r40 & 16) == 0) goto L51;
    L53:
        int r10 = 8192;
    L54:
        r3 = r3 | r10;
    L57:
        if ((196608 & r39) != 0) goto L65;
        final long r7 = r34;
        if ((r40 & 32) == 0) goto L61;
    L63:
        int r11 = 65536;
    L64:
        r3 = r3 | r11;
    L67:
        if ((1572864 & r39) == 0) goto L69;
        final FloatingActionButtonElevation r12 = r36;
    L78:
        if ((r40 & 128) == 0) goto L81;
        r3 = r3 | 12582912;
    L88:
        if ((4793491 & r3) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L148;
        r1.startDefaults();
        if ((r39 & 1) != 0) goto L96;
    L113:
        if (r4 == 0) goto L115;
        r5 = Modifier.Companion;
    L115:
        if (r6 == 0) goto L117;
        MutableInteractionSource r2 = null;
    L119:
        if ((r40 & 8) == 0) goto L121;
        Shape r8 = MaterialTheme.INSTANCE.getShapes(r1, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
        r3 = r3 & (-7169);
    L123:
        if ((r40 & 16) == 0) goto L126;
        r13 = MaterialTheme.INSTANCE.getColors(r1, 6).m2001getSecondary0d7_KjU();
        r3 = r3 & (-57345);
    L126:
        if ((r40 & 32) == 0) goto L128;
        final long r14 = ColorsKt.m2017contentColorForek8zF_U(r13, r1, (r3 >> 12) & 14);
        r3 = r3 & (-458753);
    L130:
        if ((r40 & 64) != 0) goto L131;
    L111:
        int r15 = r3;
    L112:
        long r16 = r13;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventStart(-482679837, r15, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
    L135:
        if (r2 != null) goto L140;
        r1.startReplaceGroup(36083320);
        Object r17 = r1.rememberedValue();
        if (r17 != Composer.Companion.getEmpty()) goto L139;
        r17 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r17);
    L139:
        r1.endReplaceGroup();
        MutableInteractionSource r18 = (MutableInteractionSource) r17;
    L141:
        Object r19 = r1.rememberedValue();
        if (r19 != Composer.Companion.getEmpty()) goto L144;
        r19 = new k5();
        r1.updateRememberedValue(r19);
    L144:
        MutableInteractionSource r210 = r2;
        Modifier r33 = r5;
        int r26 = ((((r15 & 14) | 805306368) | (r15 & 7168)) | (57344 & r15)) | (458752 & r15);
        MutableInteractionSource r20 = r18;
        Shape r110 = r8;
        long r111 = r14;
        SurfaceKt.m2176SurfaceLPr_se0(r28, SemanticsModifierKt.semantics$default(r5, false, (Function1) r19, 1, null), false, r110, r16, r111, null, ((Dp) r12.elevation(r18, r1, (r15 >> 15) & 112).getValue()).unbox-impl(), r20, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new FloatingActionButtonKt$FloatingActionButton$2(r14, r37), r1, 54), r1, r26, 68);
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
    L147:
        r7 = r14;
        final long r21 = r16;
        final MutableInteractionSource r22 = r210;
        final Shape r23 = r8;
        final Modifier r24 = r33;
    L149:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L153;
        r112.updateScope(new l5(r28, r24, r22, r23, r21, r7, r12, r37, r39, r40));
        return;
    L153:
        return;
    L140:
        r1.startReplaceGroup(1163327);
        r1.endReplaceGroup();
        r18 = r2;
        goto L141
    L131:
        r15 = r3 & (-3670017);
        r12 = FloatingActionButtonDefaults.INSTANCE.m2075elevationxZ9QkE(androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r1, 24576, 15);
        goto L112
    L128:
        r14 = r7;
        goto L130
    L121:
        r8 = r31;
        goto L123
    L117:
        r2 = r30;
        goto L119
    L96:
        if (r1.getDefaultsInvalid() == true) goto L113;
        r1.skipToGroupEnd();
        if ((r40 & 8) == 0) goto L102;
        r3 = r3 & (-7169);
    L102:
        if ((r40 & 16) == 0) goto L105;
        r3 = r3 & (-57345);
    L105:
        if ((r40 & 32) == 0) goto L108;
        r3 = r3 & (-458753);
    L108:
        if ((r40 & 64) == 0) goto L110;
        r3 = r3 & (-3670017);
    L110:
        r2 = r30;
        r8 = r31;
        r14 = r7;
        goto L111
    L148:
        r1.skipToGroupEnd();
        r22 = r30;
        r23 = r31;
        r24 = r5;
        r21 = r13;
        goto L149
    L90:
        r0 = false;
        goto L92
    L81:
        if ((r39 & 12582912) != 0) goto L88;
        if (r1.changedInstance(r37) == false) goto L85;
        int r113 = 8388608;
    L86:
        r3 = r3 | r113;
        goto L88
    L85:
        r113 = 4194304;
        goto L86
    L69:
        if ((r40 & 64) != 0) goto L73;
        r12 = r36;
        if (r1.changed(r12) == false) goto L74;
        int r114 = 1048576;
    L75:
        r3 = r3 | r114;
    L74:
        r114 = 524288;
        goto L75
    L73:
        r12 = r36;
        goto L74
    L61:
        if (r1.changed(r7) == false) goto L63;
        r11 = 131072;
        goto L64
    L65:
        r7 = r34;
        goto L67
    L51:
        if (r1.changed(r13) == false) goto L53;
        r10 = 16384;
        goto L54
    L55:
        r13 = r32;
        goto L57
    L28:
        if ((r39 & 384) != 0) goto L36;
        if (r1.changed(r30) == false) goto L32;
        int r25 = 256;
    L33:
        r3 = r3 | r25;
        goto L36
    L32:
        r25 = 128;
        goto L33
    L17:
        if ((r39 & 48) != 0) goto L23;
        r5 = r29;
        if (r1.changed(r5) == false) goto L21;
        int r27 = 32;
    L22:
        r3 = r3 | r27;
        goto L24
    L21:
        r27 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r3 = r39;
        goto L13
    L8:
        if (r1.changedInstance(r28) == false) goto L10;
        int r35 = 4;
    L11:
        r3 = r35 | r39;
        goto L13
    L10:
        r35 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m2078ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> r29, final Function0<Unit> r30, Modifier r31, Function2<? super Composer, ? super Integer, Unit> r32, MutableInteractionSource r33, Shape r34, long r35, long r37, FloatingActionButtonElevation r39, Composer r40, final int r41, final int r42) {
        Composer r2 = r40.startRestartGroup(-1506973027);
        if ((r42 & 1) == 0) goto L6;
        int r3 = r41 | 6;
    L14:
        if ((r42 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r42 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r7 = r42 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        final Function2<? super Composer, ? super Integer, Unit> r8 = r32;
    L46:
        int r9 = r42 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L58:
        if ((196608 & r41) != 0) goto L69;
        if ((r42 & 32) != 0) goto L65;
        if (r2.changed(r34) == false) goto L65;
        int r14 = 131072;
    L66:
        r3 = r3 | r14;
    L65:
        r14 = 65536;
    L69:
        if ((1572864 & r41) == 0) goto L71;
        long r15 = r35;
    L80:
        if ((r41 & 12582912) != 0) goto L88;
        long r10 = r37;
        if ((r42 & 128) == 0) goto L84;
    L86:
        int r0 = 4194304;
    L87:
        r3 = r3 | r0;
    L90:
        if ((100663296 & r41) != 0) goto L101;
        if ((r42 & 256) != 0) goto L97;
        if (r2.changed(r39) == false) goto L97;
        int r18 = 67108864;
    L98:
        r3 = r3 | r18;
    L97:
        r18 = 33554432;
    L101:
        if ((r3 & 38347923) == 38347922) goto L103;
        boolean r1 = true;
    L105:
        if (r2.shouldExecute(r1, r3 & 1) == false) goto L156;
        r2.startDefaults();
        if ((r41 & 1) != 0) goto L109;
    L126:
        if (r5 == 0) goto L128;
        Modifier r4 = Modifier.Companion;
    L129:
        final MutableInteractionSource r6 = null;
        if (r7 == 0) goto L132;
        r8 = null;
    L132:
        if (r9 != 0) goto L136;
        r6 = r33;
    L136:
        if ((r42 & 32) == 0) goto L138;
        Shape r11 = MaterialTheme.INSTANCE.getShapes(r2, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
        r3 = r3 & (-458753);
    L140:
        if ((r42 & 64) == 0) goto L143;
        r15 = MaterialTheme.INSTANCE.getColors(r2, 6).m2001getSecondary0d7_KjU();
        r3 = r3 & (-3670017);
    L143:
        if ((r42 & 128) == 0) goto L145;
        final long r12 = ColorsKt.m2017contentColorForek8zF_U(r15, r2, (r3 >> 18) & 14);
        r3 = r3 & (-29360129);
    L147:
        if ((r42 & 256) != 0) goto L148;
    L124:
        final FloatingActionButtonElevation r13 = r39;
    L125:
        long r27 = r15;
        int r16 = r3;
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L152;
        ComposerKt.traceEventStart(-1506973027, r16, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
    L152:
        float r17 = ExtendedFabSize;
        Modifier r36 = r4;
        int r19 = r16 >> 6;
        m2079FloatingActionButtonbogVsAg(r30, SizeKt.m1018sizeInqDBjuR0$default(r36, r17, r17, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 12, null), r6, r11, r27, r12, r13, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$1(r8, r29), r2, 54), r2, (((((((r16 >> 3) & 14) | 12582912) | (r19 & 896)) | (r19 & 7168)) | (57344 & r19)) | (458752 & r19)) | (r19 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L155;
        ComposerKt.traceEventEnd();
    L155:
        final Shape r20 = r11;
        final Modifier r21 = r36;
        final Function2<? super Composer, ? super Integer, Unit> r22 = r8;
        final long r23 = r27;
    L157:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L161;
        r110.updateScope(new j5(r29, r30, r21, r22, r6, r20, r23, r12, r13, r41, r42));
        return;
    L161:
        return;
    L148:
        r13 = FloatingActionButtonDefaults.INSTANCE.m2075elevationxZ9QkE(androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r2, 24576, 15);
        r3 = r3 & (-234881025);
        goto L125
    L145:
        r12 = r10;
        goto L147
    L138:
        r11 = r34;
        goto L140
    L128:
        r4 = r31;
        goto L129
    L109:
        if (r2.getDefaultsInvalid() == true) goto L126;
        r2.skipToGroupEnd();
        if ((r42 & 32) == 0) goto L115;
        r3 = r3 & (-458753);
    L115:
        if ((r42 & 64) == 0) goto L118;
        r3 = r3 & (-3670017);
    L118:
        if ((r42 & 128) == 0) goto L121;
        r3 = r3 & (-29360129);
    L121:
        if ((r42 & 256) == 0) goto L123;
        r3 = r3 & (-234881025);
    L123:
        r4 = r31;
        r6 = r33;
        r11 = r34;
        r12 = r10;
        goto L124
    L156:
        r2.skipToGroupEnd();
        r21 = r31;
        r6 = r33;
        r20 = r34;
        r22 = r8;
        r12 = r10;
        r23 = r15;
        r13 = r39;
        goto L157
    L103:
        r1 = false;
        goto L105
    L84:
        if (r2.changed(r10) == false) goto L86;
        r0 = 8388608;
        goto L87
    L88:
        r10 = r37;
        goto L90
    L71:
        if ((r42 & 64) != 0) goto L75;
        r15 = r35;
        if (r2.changed(r15) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
    L76:
        r111 = 524288;
        goto L77
    L75:
        r15 = r35;
        goto L76
    L50:
        if ((r41 & 24576) != 0) goto L58;
        if (r2.changed(r33) == false) goto L54;
        int r112 = 16384;
    L55:
        r3 = r3 | r112;
        goto L58
    L54:
        r112 = 8192;
        goto L55
    L39:
        if ((r41 & 3072) != 0) goto L45;
        r8 = r32;
        if (r2.changedInstance(r8) == false) goto L43;
        int r24 = 2048;
    L44:
        r3 = r3 | r24;
        goto L46
    L43:
        r24 = 1024;
        goto L44
    L28:
        if ((r41 & 384) != 0) goto L35;
        if (r2.changed(r31) == false) goto L32;
        int r25 = 256;
    L33:
        r3 = r3 | r25;
        goto L35
    L32:
        r25 = 128;
        goto L33
    L17:
        if ((r41 & 48) != 0) goto L24;
        if (r2.changedInstance(r30) == false) goto L21;
        int r26 = 32;
    L22:
        r3 = r3 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r3 = r41;
        goto L14
    L8:
        if (r2.changedInstance(r29) == false) goto L10;
        int r28 = 4;
    L11:
        r3 = r28 | r41;
        goto L14
    L10:
        r28 = 2;
        goto L11
    }
}
