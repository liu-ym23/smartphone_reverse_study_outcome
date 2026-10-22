package androidx.compose.material3;

import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001av\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0015\u001a\u0090\u0001\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u009a\u0001\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001e¨\u0006\u001f"}, d2 = {"PlainTooltipAndroid", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "maxWidth", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltipAndroid", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Tooltip_androidKt {
    private static final Unit PlainTooltipAndroid_7QI4Sbk$lambda$0(TooltipScope r16, Modifier r17, long r18, Shape r20, long r21, long r23, float r25, float r26, Function2 r27, int r28, int r29, Composer r30, int r31) {
        PlainTooltip(r16, r17, r18, r20, r21, r23, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit PlainTooltipAndroid_m9Er_Xc$lambda$1(TooltipScope r17, Modifier r18, long r19, float r21, Shape r22, long r23, long r25, float r27, float r28, Function2 r29, int r30, int r31, Composer r32, int r33) {
        PlainTooltip(r17, r18, r19, r21, r22, r23, r25, r27, r28, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), r31);
        return Unit.INSTANCE;
    }

    private static final Unit RichTooltipAndroid_ZuUcA3Q$lambda$3(TooltipScope r17, Modifier r18, Function2 r19, Function2 r20, long r21, float r23, Shape r24, RichTooltipColors r25, float r26, float r27, Function2 r28, int r29, int r30, int r31, Composer r32, int r33) {
        RichTooltip(r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit RichTooltipAndroid_yDvdmqw$lambda$2(TooltipScope r15, Modifier r16, Function2 r17, Function2 r18, long r19, Shape r21, RichTooltipColors r22, float r23, float r24, Function2 r25, int r26, int r27, Composer r28, int r29) {
        RichTooltip(r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TooltipScope r1, Modifier r2, Function2 r3, Function2 r4, long r5, float r7, Shape r8, RichTooltipColors r9, float r10, float r11, Function2 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return RichTooltipAndroid_ZuUcA3Q$lambda$3(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit b(TooltipScope r0, Modifier r1, Function2 r2, Function2 r3, long r4, Shape r6, RichTooltipColors r7, float r8, float r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        return RichTooltipAndroid_yDvdmqw$lambda$2(r0, r1, r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit c(TooltipScope r1, Modifier r2, long r3, float r5, Shape r6, long r7, long r9, float r11, float r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        return PlainTooltipAndroid_m9Er_Xc$lambda$1(r1, r2, r3, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit d(TooltipScope r0, Modifier r1, long r2, Shape r4, long r5, long r7, float r9, float r10, Function2 r11, int r12, int r13, Composer r14, int r15) {
        return PlainTooltipAndroid_7QI4Sbk$lambda$0(r0, r1, r2, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with maxWidth parameter.")
    public static final /* synthetic */ void PlainTooltip(final TooltipScope r30, Modifier r31, long r32, Shape r34, long r35, long r37, float r39, float r40, final Function2 r41, Composer r42, final int r43, final int r44) {
        Composer r12 = r42.startRestartGroup(2114904198);
        if ((Integer.MIN_VALUE & r44) == 0) goto L6;
        int r1 = r43 | 6;
    L16:
        int r2 = r44 & 1;
        if (r2 == 0) goto L20;
        r1 = r1 | 48;
    L28:
        if ((r43 & 384) != 0) goto L39;
        if ((r44 & 2) != 0) goto L35;
        if (r12.changed(r32) == false) goto L35;
        int r6 = 256;
    L36:
        r1 = r1 | r6;
    L35:
        r6 = 128;
    L39:
        if ((r43 & 3072) == 0) goto L41;
        Shape r7 = r34;
    L50:
        if ((r43 & 24576) == 0) goto L52;
        long r8 = r35;
    L61:
        if ((196608 & r43) == 0) goto L63;
        long r9 = r37;
    L71:
        int r11 = r44 & 32;
        if (r11 == 0) goto L75;
        r1 = r1 | 1572864;
    L81:
        int r17 = r44 & 64;
        if (r17 == 0) goto L85;
        r1 = r1 | 12582912;
    L92:
        if ((r44 & 128) == 0) goto L95;
        r1 = r1 | 100663296;
    L103:
        if ((r1 & 38347923) == 38347922) goto L105;
        boolean r0 = true;
    L107:
        if (r12.shouldExecute(r0, r1 & 1) == false) goto L160;
        r12.startDefaults();
        if ((r43 & 1) != 0) goto L111;
    L126:
        if (r2 == 0) goto L128;
        Modifier r3 = Modifier.Companion;
    L130:
        if ((r44 & 2) == 0) goto L132;
        long r18 = DpSize.Companion.getUnspecified-MYxV2XQ();
        r1 = r1 & (-897);
    L134:
        if ((r44 & 4) == 0) goto L136;
        Shape r4 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(r12, 6);
        r1 = r1 & (-7169);
    L138:
        if ((r44 & 8) == 0) goto L140;
        long r10 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(r12, 6);
        r1 = r1 & (-57345);
    L142:
        if ((r44 & 16) == 0) goto L144;
        long r5 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(r12, 6);
        r1 = r1 & (-458753);
    L146:
        if (r11 == 0) goto L148;
        float r13 = Dp.constructor-impl(0);
    L149:
        if (r17 == 0) goto L151;
        float r24 = Dp.constructor-impl(0);
    L152:
        long r21 = r5;
        float r23 = r13;
        long r14 = r18;
        Shape r19 = r4;
        long r110 = r10;
    L153:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventStart(2114904198, r1, -1, "androidx.compose.material3.PlainTooltipAndroid (Tooltip.android.kt:61)");
    L156:
        TooltipDefaults r15 = TooltipDefaults.INSTANCE;
        Shape r16 = r15.m3543caretShapeEaSLcWc(r14);
        float r20 = r15.m3545getPlainTooltipMaxWidthD9Ej5fM();
        int r22 = ((r1 & 14) | 3072) | (r1 & 112);
        int r25 = r1 << 3;
        long r26 = r14;
        Composer r28 = r12;
        TooltipKt.m3555PlainTooltipgv3ox5I(r30, r3, r16, r20, r19, r110, r21, r23, r24, r41, r12, (((((r22 | (57344 & r25)) | (458752 & r25)) | (3670016 & r25)) | (29360128 & r25)) | (234881024 & r25)) | (r25 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L159;
        ComposerKt.traceEventEnd();
    L159:
        final Modifier r27 = r3;
        final Shape r29 = r19;
        final long r33 = r110;
        final long r36 = r21;
        final float r111 = r23;
        final float r112 = r24;
        final long r38 = r26;
    L161:
        ScopeUpdateScope r113 = r28.endRestartGroup();
        if (r113 == null) goto L165;
        r113.updateScope(new gx(r30, r27, r38, r29, r33, r36, r111, r112, r41, r43, r44));
        return;
    L165:
        return;
    L151:
        r24 = r40;
        goto L152
    L148:
        r13 = r39;
        goto L149
    L144:
        r5 = r9;
        goto L146
    L140:
        r10 = r8;
        goto L142
    L136:
        r4 = r7;
        goto L138
    L132:
        r18 = r32;
        goto L134
    L128:
        r3 = r31;
        goto L130
    L111:
        if (r12.getDefaultsInvalid() == true) goto L126;
        r12.skipToGroupEnd();
        if ((r44 & 2) == 0) goto L117;
        r1 = r1 & (-897);
    L117:
        if ((r44 & 4) == 0) goto L120;
        r1 = r1 & (-7169);
    L120:
        if ((r44 & 8) == 0) goto L123;
        r1 = r1 & (-57345);
    L123:
        if ((r44 & 16) == 0) goto L125;
        r1 = r1 & (-458753);
    L125:
        r3 = r31;
        r23 = r39;
        r24 = r40;
        r19 = r7;
        r110 = r8;
        r21 = r9;
        r14 = r32;
        goto L153
    L160:
        r28 = r12;
        r28.skipToGroupEnd();
        r27 = r31;
        r38 = r32;
        r112 = r40;
        r29 = r7;
        r33 = r8;
        r36 = r9;
        r111 = r39;
        goto L161
    L105:
        r0 = false;
        goto L107
    L95:
        if ((r43 & 100663296) != 0) goto L103;
        if (r12.changedInstance(r41) == false) goto L99;
        int r114 = 67108864;
    L100:
        r1 = r1 | r114;
        goto L103
    L99:
        r114 = 33554432;
        goto L100
    L85:
        if ((r43 & 12582912) != 0) goto L92;
        if (r12.changed(r40) == false) goto L89;
        int r115 = 8388608;
    L90:
        r1 = r1 | r115;
        goto L92
    L89:
        r115 = 4194304;
        goto L90
    L75:
        if ((r43 & 1572864) != 0) goto L81;
        if (r12.changed(r39) == false) goto L79;
        int r116 = 1048576;
    L80:
        r1 = r1 | r116;
        goto L81
    L79:
        r116 = 524288;
        goto L80
    L63:
        if ((r44 & 16) != 0) goto L67;
        r9 = r37;
        if (r12.changed(r9) == false) goto L68;
        int r117 = 131072;
    L69:
        r1 = r1 | r117;
    L68:
        r117 = 65536;
        goto L69
    L67:
        r9 = r37;
        goto L68
    L52:
        if ((r44 & 8) != 0) goto L56;
        r8 = r35;
        if (r12.changed(r8) == false) goto L57;
        int r45 = 16384;
    L58:
        r1 = r1 | r45;
    L57:
        r45 = 8192;
        goto L58
    L56:
        r8 = r35;
        goto L57
    L41:
        if ((r44 & 4) != 0) goto L45;
        r7 = r34;
        if (r12.changed(r7) == false) goto L46;
        int r46 = 2048;
    L47:
        r1 = r1 | r46;
    L46:
        r46 = 1024;
        goto L47
    L45:
        r7 = r34;
        goto L46
    L20:
        if ((r43 & 48) != 0) goto L28;
        if (r12.changed(r31) == false) goto L24;
        int r47 = 32;
    L25:
        r1 = r1 | r47;
        goto L28
    L24:
        r47 = 16;
        goto L25
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L16
    L8:
        if ((r43 & 8) != 0) goto L10;
        boolean r48 = r12.changed(r30);
    L11:
        if (r48 == false) goto L13;
        int r49 = 4;
    L14:
        r1 = r49 | r43;
        goto L16
    L13:
        r49 = 2;
        goto L14
    L10:
        r48 = r12.changedInstance(r30);
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public static final /* synthetic */ void PlainTooltip(final TooltipScope r32, Modifier r33, long r34, float r36, Shape r37, long r38, long r40, float r42, float r43, final Function2 r44, Composer r45, final int r46, final int r47) {
        Composer r12 = r45.startRestartGroup(1456881596);
        if ((Integer.MIN_VALUE & r47) == 0) goto L6;
        int r1 = r46 | 6;
    L16:
        int r2 = r47 & 1;
        if (r2 == 0) goto L20;
        r1 = r1 | 48;
    L28:
        if ((r46 & 384) != 0) goto L38;
        if ((r47 & 2) != 0) goto L35;
        if (r12.changed(r34) == false) goto L35;
        int r6 = 256;
    L36:
        r1 = r1 | r6;
    L35:
        r6 = 128;
    L38:
        int r7 = r47 & 4;
        if (r7 == 0) goto L42;
        r1 = r1 | 3072;
    L48:
        float r8 = r36;
    L50:
        if ((r46 & 24576) == 0) goto L52;
        Shape r9 = r37;
    L61:
        if ((196608 & r46) == 0) goto L63;
        long r10 = r38;
    L72:
        if ((1572864 & r46) != 0) goto L80;
        int r48 = r1;
        if ((r47 & 32) == 0) goto L76;
    L78:
        int r16 = 524288;
    L79:
        int r17 = r48 | r16;
    L81:
        int r18 = r47 & 64;
        if (r18 == 0) goto L84;
        r17 = r17 | 12582912;
        final float r11 = r42;
    L91:
        int r0 = r47 & 128;
        if (r0 == 0) goto L95;
        r17 = r17 | 100663296;
    L102:
        int r19 = 805306368;
        if ((r47 & 256) == 0) goto L106;
    L104:
        r17 = r17 | r19;
    L112:
        int r3 = r17;
        if ((r3 & 306783379) == 306783378) goto L115;
        boolean r4 = true;
    L117:
        if (r12.shouldExecute(r4, r3 & 1) == false) goto L172;
        r12.startDefaults();
        if ((r46 & 1) != 0) goto L121;
    L136:
        if (r2 == 0) goto L138;
        Modifier r5 = Modifier.Companion;
    L140:
        if ((r47 & 2) == 0) goto L142;
        long r110 = DpSize.Companion.getUnspecified-MYxV2XQ();
        r3 = r3 & (-897);
    L143:
        if (r7 == 0) goto L145;
        float r13 = TooltipDefaults.INSTANCE.m3545getPlainTooltipMaxWidthD9Ej5fM();
    L147:
        if ((r47 & 8) == 0) goto L149;
        Shape r14 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(r12, 6);
        r3 = r3 & (-57345);
    L151:
        if ((r47 & 16) == 0) goto L153;
        long r15 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(r12, 6);
        r3 = r3 & (-458753);
    L155:
        if ((r47 & 32) == 0) goto L157;
        long r21 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(r12, 6);
        r3 = r3 & (-3670017);
    L158:
        if (r18 == 0) goto L160;
        float r20 = Dp.constructor-impl(0);
    L161:
        if (r0 == 0) goto L163;
        float r24 = Dp.constructor-impl(0);
    L164:
        Modifier r111 = r5;
        float r112 = r13;
        float r23 = r20;
        Shape r113 = r14;
        long r114 = r110;
        long r115 = r15;
    L165:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L168;
        ComposerKt.traceEventStart(1456881596, r3, -1, "androidx.compose.material3.PlainTooltipAndroid (Tooltip.android.kt:104)");
    L168:
        long r27 = r114;
        Composer r29 = r12;
        TooltipKt.m3555PlainTooltipgv3ox5I(r32, r111, TooltipDefaults.INSTANCE.m3543caretShapeEaSLcWc(r114), r112, r113, r115, r21, r23, r24, r44, r12, ((((((((r3 & 14) | (r3 & 112)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventEnd();
    L171:
        final Modifier r22 = r111;
        final float r25 = r112;
        final Shape r26 = r113;
        final long r28 = r115;
        final long r30 = r21;
        r11 = r23;
        final float r116 = r24;
        final long r31 = r27;
    L173:
        ScopeUpdateScope r117 = r29.endRestartGroup();
        if (r117 == null) goto L177;
        r117.updateScope(new ix(r32, r22, r31, r25, r26, r28, r30, r11, r116, r44, r46, r47));
        return;
    L177:
        return;
    L163:
        r24 = r43;
        goto L164
    L160:
        r20 = r11;
        goto L161
    L157:
        r21 = r40;
        goto L158
    L153:
        r15 = r10;
        goto L155
    L149:
        r14 = r9;
        goto L151
    L145:
        r13 = r8;
        goto L147
    L142:
        r110 = r34;
        goto L143
    L138:
        r5 = r33;
        goto L140
    L121:
        if (r12.getDefaultsInvalid() == true) goto L136;
        r12.skipToGroupEnd();
        if ((r47 & 2) == 0) goto L127;
        r3 = r3 & (-897);
    L127:
        if ((r47 & 8) == 0) goto L130;
        r3 = r3 & (-57345);
    L130:
        if ((r47 & 16) == 0) goto L133;
        r3 = r3 & (-458753);
    L133:
        if ((r47 & 32) == 0) goto L135;
        r3 = r3 & (-3670017);
    L135:
        r111 = r33;
        r21 = r40;
        r24 = r43;
        r112 = r8;
        r113 = r9;
        r115 = r10;
        r23 = r11;
        r114 = r34;
        goto L165
    L172:
        r29 = r12;
        r29.skipToGroupEnd();
        r22 = r33;
        r31 = r34;
        r116 = r43;
        r25 = r8;
        r26 = r9;
        r28 = r10;
        r30 = r40;
        goto L173
    L115:
        r4 = false;
        goto L117
    L106:
        if ((r46 & 805306368) != 0) goto L112;
        if (r12.changedInstance(r44) == false) goto L110;
        r19 = 536870912;
        goto L104
    L110:
        r19 = 268435456;
        goto L104
    L95:
        if ((100663296 & r46) != 0) goto L102;
        if (r12.changed(r43) == false) goto L99;
        int r118 = 67108864;
    L100:
        r17 = r17 | r118;
        goto L102
    L99:
        r118 = 33554432;
        goto L100
    L84:
        r11 = r42;
        if ((r46 & 12582912) != 0) goto L91;
        if (r12.changed(r11) == false) goto L89;
        int r119 = 8388608;
    L90:
        r17 = r17 | r119;
        goto L91
    L89:
        r119 = 4194304;
        goto L90
    L76:
        if (r12.changed(r40) == false) goto L78;
        r16 = 1048576;
        goto L79
    L80:
        r17 = r1;
        goto L81
    L63:
        if ((r47 & 16) != 0) goto L67;
        r10 = r38;
        if (r12.changed(r10) == false) goto L68;
        int r120 = 131072;
    L69:
        r1 = r1 | r120;
    L68:
        r120 = 65536;
        goto L69
    L67:
        r10 = r38;
        goto L68
    L52:
        if ((r47 & 8) != 0) goto L56;
        r9 = r37;
        if (r12.changed(r9) == false) goto L57;
        int r35 = 16384;
    L58:
        r1 = r1 | r35;
    L57:
        r35 = 8192;
        goto L58
    L56:
        r9 = r37;
        goto L57
    L42:
        if ((r46 & 3072) != 0) goto L48;
        r8 = r36;
        if (r12.changed(r8) == false) goto L46;
        int r39 = 2048;
    L47:
        r1 = r1 | r39;
        goto L50
    L46:
        r39 = 1024;
        goto L47
    L20:
        if ((r46 & 48) != 0) goto L28;
        if (r12.changed(r33) == false) goto L24;
        int r41 = 32;
    L25:
        r1 = r1 | r41;
        goto L28
    L24:
        r41 = 16;
        goto L25
    L6:
        if ((r46 & 6) == 0) goto L8;
        r1 = r46;
        goto L16
    L8:
        if ((r46 & 8) != 0) goto L10;
        boolean r49 = r12.changed(r32);
    L11:
        if (r49 == false) goto L13;
        int r50 = 4;
    L14:
        r1 = r50 | r46;
        goto L16
    L13:
        r50 = 2;
        goto L14
    L10:
        r49 = r12.changedInstance(r32);
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with maxWidth parameter.")
    public static final /* synthetic */ void RichTooltip(final TooltipScope r29, Modifier r30, Function2 r31, Function2 r32, long r33, Shape r35, RichTooltipColors r36, float r37, float r38, final Function2 r39, Composer r40, final int r41, final int r42) {
        Composer r12 = r40.startRestartGroup(-244908363);
        if ((Integer.MIN_VALUE & r42) == 0) goto L6;
        int r1 = r41 | 6;
    L16:
        int r2 = r42 & 1;
        if (r2 == 0) goto L20;
        r1 = r1 | 48;
    L27:
        int r4 = r42 & 2;
        if (r4 == 0) goto L31;
        r1 = r1 | 384;
    L38:
        int r6 = r42 & 4;
        if (r6 == 0) goto L42;
        r1 = r1 | 3072;
    L48:
        Function2 r7 = r32;
    L50:
        if ((r41 & 24576) == 0) goto L52;
        long r8 = r33;
    L61:
        if ((r41 & 196608) == 0) goto L63;
        Shape r11 = r35;
    L72:
        if ((r41 & 1572864) != 0) goto L80;
        RichTooltipColors r10 = r36;
        if ((r42 & 32) == 0) goto L76;
    L78:
        int r16 = 524288;
    L79:
        r1 = r1 | r16;
    L81:
        int r17 = r42 & 64;
        if (r17 == 0) goto L85;
        r1 = r1 | 12582912;
    L91:
        int r0 = r42 & 128;
        if (r0 == 0) goto L95;
        r1 = r1 | 100663296;
    L102:
        if ((r42 & 256) == 0) goto L105;
        r1 = r1 | 805306368;
    L113:
        if ((r1 & 306783379) == 306783378) goto L115;
        boolean r3 = true;
    L117:
        if (r12.shouldExecute(r3, r1 & 1) == false) goto L169;
        r12.startDefaults();
        if ((r41 & 1) != 0) goto L121;
    L133:
        if (r2 == 0) goto L135;
        Modifier r5 = Modifier.Companion;
    L136:
        Function2 r9 = null;
        if (r4 == 0) goto L139;
        Function2 r13 = null;
    L140:
        if (r6 != 0) goto L144;
        r9 = r7;
    L144:
        if ((r42 & 8) == 0) goto L146;
        long r14 = DpSize.Companion.getUnspecified-MYxV2XQ();
        r1 = r1 & (-57345);
    L148:
        if ((r42 & 16) == 0) goto L150;
        Shape r15 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(r12, 6);
        r1 = r1 & (-458753);
    L152:
        if ((r42 & 32) == 0) goto L154;
        RichTooltipColors r18 = TooltipDefaults.INSTANCE.richTooltipColors(r12, 6);
        r1 = r1 & (-3670017);
    L155:
        if (r17 == 0) goto L157;
        float r19 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    L158:
        if (r0 == 0) goto L160;
        float r23 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L161:
        Modifier r110 = r5;
        Function2 r111 = r9;
        Function2 r112 = r13;
        float r22 = r19;
        long r113 = r14;
        Shape r20 = r15;
        RichTooltipColors r21 = r18;
    L162:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventStart(-244908363, r1, -1, "androidx.compose.material3.RichTooltipAndroid (Tooltip.android.kt:154)");
    L165:
        TooltipDefaults r24 = TooltipDefaults.INSTANCE;
        int r25 = r1 << 3;
        long r26 = r113;
        Composer r28 = r12;
        TooltipKt.m3557RichTooltipEkvW5A0(r29, r110, r112, r111, r24.m3543caretShapeEaSLcWc(r113), r24.m3546getRichTooltipMaxWidthD9Ej5fM(), r20, r21, r22, r23, r39, r12, ((((((((r1 & 14) | 196608) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (3670016 & r25)) | (29360128 & r25)) | (234881024 & r25)) | (r25 & 1879048192), (r1 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L168;
        ComposerKt.traceEventEnd();
    L168:
        final Modifier r27 = r110;
        final Function2 r34 = r112;
        final Function2 r43 = r111;
        final Shape r44 = r20;
        final RichTooltipColors r45 = r21;
        final float r46 = r22;
        final float r114 = r23;
        final long r47 = r26;
    L170:
        ScopeUpdateScope r115 = r28.endRestartGroup();
        if (r115 == null) goto L174;
        r115.updateScope(new jx(r29, r27, r34, r43, r47, r44, r45, r46, r114, r39, r41, r42));
        return;
    L174:
        return;
    L160:
        r23 = r38;
        goto L161
    L157:
        r19 = r37;
        goto L158
    L154:
        r18 = r10;
        goto L155
    L150:
        r15 = r11;
        goto L152
    L146:
        r14 = r8;
        goto L148
    L139:
        r13 = r31;
        goto L140
    L135:
        r5 = r30;
        goto L136
    L121:
        if (r12.getDefaultsInvalid() == true) goto L133;
        r12.skipToGroupEnd();
        if ((r42 & 8) == 0) goto L127;
        r1 = r1 & (-57345);
    L127:
        if ((r42 & 16) == 0) goto L130;
        r1 = r1 & (-458753);
    L130:
        if ((r42 & 32) == 0) goto L132;
        r1 = r1 & (-3670017);
    L132:
        r110 = r30;
        r112 = r31;
        r22 = r37;
        r23 = r38;
        r111 = r7;
        r21 = r10;
        r20 = r11;
        r113 = r8;
        goto L162
    L169:
        r28 = r12;
        r28.skipToGroupEnd();
        r27 = r30;
        r34 = r31;
        r43 = r7;
        r47 = r8;
        r45 = r10;
        r44 = r11;
        r46 = r37;
        r114 = r38;
        goto L170
    L115:
        r3 = false;
        goto L117
    L105:
        if ((r41 & 805306368) != 0) goto L113;
        if (r12.changedInstance(r39) == false) goto L109;
        int r116 = 536870912;
    L110:
        r1 = r1 | r116;
        goto L113
    L109:
        r116 = 268435456;
        goto L110
    L95:
        if ((r41 & 100663296) != 0) goto L102;
        if (r12.changed(r38) == false) goto L99;
        int r117 = 67108864;
    L100:
        r1 = r1 | r117;
        goto L102
    L99:
        r117 = 33554432;
        goto L100
    L85:
        if ((r41 & 12582912) != 0) goto L91;
        if (r12.changed(r37) == false) goto L89;
        int r118 = 8388608;
    L90:
        r1 = r1 | r118;
        goto L91
    L89:
        r118 = 4194304;
        goto L90
    L76:
        if (r12.changed(r10) == false) goto L78;
        r16 = 1048576;
        goto L79
    L80:
        r10 = r36;
        goto L81
    L63:
        if ((r42 & 16) != 0) goto L67;
        r11 = r35;
        if (r12.changed(r11) == false) goto L68;
        int r119 = 131072;
    L69:
        r1 = r1 | r119;
    L68:
        r119 = 65536;
        goto L69
    L67:
        r11 = r35;
        goto L68
    L52:
        if ((r42 & 8) != 0) goto L56;
        r8 = r33;
        if (r12.changed(r8) == false) goto L57;
        int r120 = 16384;
    L58:
        r1 = r1 | r120;
    L57:
        r120 = 8192;
        goto L58
    L56:
        r8 = r33;
        goto L57
    L42:
        if ((r41 & 3072) != 0) goto L48;
        r7 = r32;
        if (r12.changedInstance(r7) == false) goto L46;
        int r48 = 2048;
    L47:
        r1 = r1 | r48;
        goto L50
    L46:
        r48 = 1024;
        goto L47
    L31:
        if ((r41 & 384) != 0) goto L38;
        if (r12.changedInstance(r31) == false) goto L35;
        int r49 = 256;
    L36:
        r1 = r1 | r49;
        goto L38
    L35:
        r49 = 128;
        goto L36
    L20:
        if ((r41 & 48) != 0) goto L27;
        if (r12.changed(r30) == false) goto L24;
        int r50 = 32;
    L25:
        r1 = r1 | r50;
        goto L27
    L24:
        r50 = 16;
        goto L25
    L6:
        if ((r41 & 6) == 0) goto L8;
        r1 = r41;
        goto L16
    L8:
        if ((r41 & 8) != 0) goto L10;
        boolean r51 = r12.changed(r29);
    L11:
        if (r51 == false) goto L13;
        int r52 = 4;
    L14:
        r1 = r52 | r41;
        goto L16
    L13:
        r52 = 2;
        goto L14
    L10:
        r51 = r12.changedInstance(r29);
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public static final /* synthetic */ void RichTooltip(final TooltipScope r32, Modifier r33, Function2 r34, Function2 r35, long r36, float r38, Shape r39, RichTooltipColors r40, float r41, float r42, final Function2 r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r12 = r44.startRestartGroup(-905938553);
        if ((Integer.MIN_VALUE & r47) == 0) goto L6;
        int r1 = r45 | 6;
    L16:
        int r4 = r47 & 1;
        if (r4 == 0) goto L20;
        r1 = r1 | 48;
    L27:
        int r6 = r47 & 2;
        if (r6 == 0) goto L31;
        r1 = r1 | 384;
    L38:
        int r8 = r47 & 4;
        if (r8 == 0) goto L42;
        r1 = r1 | 3072;
    L48:
        Function2 r9 = r35;
    L50:
        if ((r45 & 24576) == 0) goto L52;
        long r10 = r36;
    L60:
        int r16 = r47 & 16;
        if (r16 == 0) goto L64;
        r1 = r1 | 196608;
    L71:
        if ((r45 & 1572864) != 0) goto L81;
        if ((r47 & 32) == 0) goto L75;
    L77:
        int r18 = 524288;
    L78:
        r1 = r1 | r18;
        goto L81
    L75:
        if (r12.changed(r39) == false) goto L77;
        r18 = 1048576;
    L81:
        if ((r45 & 12582912) != 0) goto L90;
        if ((r47 & 64) == 0) goto L85;
    L87:
        int r19 = 4194304;
    L88:
        r1 = r1 | r19;
        goto L90
    L85:
        if (r12.changed(r40) == false) goto L87;
        r19 = 8388608;
    L90:
        int r0 = r47 & 128;
        if (r0 == 0) goto L94;
        r1 = r1 | 100663296;
    L100:
        int r2 = r47 & 256;
        if (r2 == 0) goto L104;
        r1 = r1 | 805306368;
    L111:
        if ((r47 & 512) == 0) goto L114;
        int r3 = r46 | 6;
    L122:
        if ((r1 & 306783379) == 306783378) goto L124;
    L127:
        boolean r5 = true;
    L129:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L184;
        r12.startDefaults();
        if ((r45 & 1) != 0) goto L133;
    L145:
        if (r4 == 0) goto L147;
        Modifier r7 = Modifier.Companion;
    L148:
        Function2 r11 = null;
        if (r6 == 0) goto L151;
        Function2 r13 = null;
    L152:
        if (r8 != 0) goto L156;
        r11 = r9;
    L156:
        if ((r47 & 8) == 0) goto L158;
        long r14 = DpSize.Companion.getUnspecified-MYxV2XQ();
        r1 = r1 & (-57345);
    L159:
        if (r16 == 0) goto L161;
        float r15 = TooltipDefaults.INSTANCE.m3546getRichTooltipMaxWidthD9Ej5fM();
    L163:
        if ((r47 & 32) == 0) goto L165;
        Shape r17 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(r12, 6);
        r1 = r1 & (-3670017);
    L166:
        Modifier r37 = r7;
        if ((r47 & 64) == 0) goto L169;
        RichTooltipColors r20 = TooltipDefaults.INSTANCE.richTooltipColors(r12, 6);
        r1 = r1 & (-29360129);
    L170:
        if (r0 == 0) goto L172;
        float r21 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    L173:
        if (r2 == 0) goto L175;
        float r24 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L176:
        RichTooltipColors r22 = r20;
        Function2 r110 = r11;
        Function2 r111 = r13;
        float r23 = r15;
        Shape r25 = r17;
        r10 = r14;
    L177:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventStart(-905938553, r1, r3, "androidx.compose.material3.RichTooltipAndroid (Tooltip.android.kt:201)");
    L180:
        long r27 = r10;
        Composer r29 = r12;
        TooltipKt.m3557RichTooltipEkvW5A0(r32, r37, r111, r110, TooltipDefaults.INSTANCE.m3543caretShapeEaSLcWc(r10), r23, r25, r22, r21, r24, r43, r12, ((((((((r1 & 14) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | (234881024 & r1)) | (r1 & 1879048192), r3 & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L183;
        ComposerKt.traceEventEnd();
    L183:
        final Modifier r26 = r37;
        final Function2 r28 = r111;
        final Function2 r30 = r110;
        final float r31 = r23;
        final Shape r48 = r25;
        final RichTooltipColors r49 = r22;
        final float r112 = r21;
        final float r113 = r24;
        final long r50 = r27;
    L185:
        ScopeUpdateScope r114 = r29.endRestartGroup();
        if (r114 == null) goto L189;
        r114.updateScope(new hx(r32, r26, r28, r30, r50, r31, r48, r49, r112, r113, r43, r45, r46, r47));
        return;
    L189:
        return;
    L175:
        r24 = r42;
        goto L176
    L172:
        r21 = r41;
        goto L173
    L169:
        r20 = r40;
        goto L170
    L165:
        r17 = r39;
        goto L166
    L161:
        r15 = r38;
        goto L163
    L158:
        r14 = r10;
        goto L159
    L151:
        r13 = r34;
        goto L152
    L147:
        r7 = r33;
        goto L148
    L133:
        if (r12.getDefaultsInvalid() == true) goto L145;
        r12.skipToGroupEnd();
        if ((r47 & 8) == 0) goto L139;
        r1 = r1 & (-57345);
    L139:
        if ((r47 & 32) == 0) goto L142;
        r1 = r1 & (-3670017);
    L142:
        if ((r47 & 64) == 0) goto L144;
        r1 = r1 & (-29360129);
    L144:
        r37 = r33;
        r111 = r34;
        r23 = r38;
        r25 = r39;
        r22 = r40;
        r21 = r41;
        r24 = r42;
        r110 = r9;
        goto L177
    L184:
        r29 = r12;
        r29.skipToGroupEnd();
        r26 = r33;
        r28 = r34;
        r31 = r38;
        r48 = r39;
        r30 = r9;
        r50 = r10;
        r49 = r40;
        r112 = r41;
        r113 = r42;
        goto L185
    L124:
        if ((r3 & 3) != 2) goto L127;
        r5 = false;
        goto L129
    L114:
        if ((r46 & 6) == 0) goto L116;
        r3 = r46;
        goto L122
    L116:
        if (r12.changedInstance(r43) == false) goto L118;
        int r115 = 4;
    L119:
        r3 = r46 | r115;
        goto L122
    L118:
        r115 = 2;
        goto L119
    L104:
        if ((r45 & 805306368) != 0) goto L111;
        if (r12.changed(r42) == false) goto L108;
        int r116 = 536870912;
    L109:
        r1 = r1 | r116;
        goto L111
    L108:
        r116 = 268435456;
        goto L109
    L94:
        if ((r45 & 100663296) != 0) goto L100;
        if (r12.changed(r41) == false) goto L98;
        int r117 = 67108864;
    L99:
        r1 = r1 | r117;
        goto L100
    L98:
        r117 = 33554432;
        goto L99
    L64:
        if ((r45 & 196608) != 0) goto L71;
        if (r12.changed(r38) == false) goto L68;
        int r118 = 131072;
    L69:
        r1 = r1 | r118;
        goto L71
    L68:
        r118 = 65536;
        goto L69
    L52:
        if ((r47 & 8) != 0) goto L56;
        r10 = r36;
        if (r12.changed(r10) == false) goto L57;
        int r119 = 16384;
    L58:
        r1 = r1 | r119;
    L57:
        r119 = 8192;
        goto L58
    L56:
        r10 = r36;
        goto L57
    L42:
        if ((r45 & 3072) != 0) goto L48;
        r9 = r35;
        if (r12.changedInstance(r9) == false) goto L46;
        int r120 = 2048;
    L47:
        r1 = r1 | r120;
        goto L50
    L46:
        r120 = 1024;
        goto L47
    L31:
        if ((r45 & 384) != 0) goto L38;
        if (r12.changedInstance(r34) == false) goto L35;
        int r51 = 256;
    L36:
        r1 = r1 | r51;
        goto L38
    L35:
        r51 = 128;
        goto L36
    L20:
        if ((r45 & 48) != 0) goto L27;
        if (r12.changed(r33) == false) goto L24;
        int r52 = 32;
    L25:
        r1 = r1 | r52;
        goto L27
    L24:
        r52 = 16;
        goto L25
    L6:
        if ((r45 & 6) == 0) goto L8;
        r1 = r45;
        goto L16
    L8:
        if ((r45 & 8) != 0) goto L10;
        boolean r53 = r12.changed(r32);
    L11:
        if (r53 == false) goto L13;
        int r54 = 4;
    L14:
        r1 = r54 | r45;
        goto L16
    L13:
        r54 = 2;
        goto L14
    L10:
        r53 = r12.changedInstance(r32);
        goto L11
    }
}
