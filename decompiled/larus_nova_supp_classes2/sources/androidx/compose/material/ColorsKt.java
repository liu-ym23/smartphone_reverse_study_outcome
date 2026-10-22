package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0085\u0001\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0000\"\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"lightColors", "Landroidx/compose/material/Colors;", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "lightColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "darkColors", "darkColors-2qZNXz8", "primarySurface", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "updateColorsFrom", "", "other", "LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = null;

    public static /* synthetic */ Colors a() {
        return LocalColors$lambda$1();
    }

    static {
        LocalColors = CompositionLocalKt.staticCompositionLocalOf(new z2());
    }

    private static final Colors LocalColors$lambda$1() {
        return m2021lightColors2qZNXz8$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, null);
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    public static final long getPrimarySurface(Colors r2) {
        if (r2.isLight() == false) goto L6;
        return r2.m1999getPrimary0d7_KjU();
    L6:
        return r2.m2003getSurface0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m2016contentColorFor4WTKRHQ(Colors r2, long r3) {
        if (Color.equals-impl0(r3, r2.m1999getPrimary0d7_KjU()) == false) goto L6;
        return r2.m1996getOnPrimary0d7_KjU();
    L6:
        if (Color.equals-impl0(r3, r2.m2000getPrimaryVariant0d7_KjU()) == false) goto L9;
        return r2.m1996getOnPrimary0d7_KjU();
    L9:
        if (Color.equals-impl0(r3, r2.m2001getSecondary0d7_KjU()) == false) goto L12;
        return r2.m1997getOnSecondary0d7_KjU();
    L12:
        if (Color.equals-impl0(r3, r2.m2002getSecondaryVariant0d7_KjU()) == false) goto L15;
        return r2.m1997getOnSecondary0d7_KjU();
    L15:
        if (Color.equals-impl0(r3, r2.m1992getBackground0d7_KjU()) == false) goto L18;
        return r2.m1994getOnBackground0d7_KjU();
    L18:
        if (Color.equals-impl0(r3, r2.m2003getSurface0d7_KjU()) == false) goto L21;
        return r2.m1998getOnSurface0d7_KjU();
    L21:
        if (Color.equals-impl0(r3, r2.m1993getError0d7_KjU()) == false) goto L24;
        return r2.m1995getOnError0d7_KjU();
    L24:
        return Color.Companion.getUnspecified-0d7_KjU();
    }

    public static final void updateColorsFrom(Colors r2, Colors r3) {
        r2.m2011setPrimary8_81llA$material(r3.m1999getPrimary0d7_KjU());
        r2.m2012setPrimaryVariant8_81llA$material(r3.m2000getPrimaryVariant0d7_KjU());
        r2.m2013setSecondary8_81llA$material(r3.m2001getSecondary0d7_KjU());
        r2.m2014setSecondaryVariant8_81llA$material(r3.m2002getSecondaryVariant0d7_KjU());
        r2.m2004setBackground8_81llA$material(r3.m1992getBackground0d7_KjU());
        r2.m2015setSurface8_81llA$material(r3.m2003getSurface0d7_KjU());
        r2.m2005setError8_81llA$material(r3.m1993getError0d7_KjU());
        r2.m2008setOnPrimary8_81llA$material(r3.m1996getOnPrimary0d7_KjU());
        r2.m2009setOnSecondary8_81llA$material(r3.m1997getOnSecondary0d7_KjU());
        r2.m2006setOnBackground8_81llA$material(r3.m1994getOnBackground0d7_KjU());
        r2.m2010setOnSurface8_81llA$material(r3.m1998getOnSurface0d7_KjU());
        r2.m2007setOnError8_81llA$material(r3.m1995getOnError0d7_KjU());
        r2.setLight$material(r3.isLight());
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m2017contentColorForek8zF_U(long r3, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(441849991, r6, -1, "androidx.compose.material.contentColorFor (Colors.kt:310)");
    L5:
        r5.startReplaceGroup(-583916561);
        long r4 = m2016contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(r5, 6), r3);
        if (r4 == 16) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        r4 = ((Color) r5.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L12:
        r5.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        return r4;
    L8:
        r7 = false;
        goto L9
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m2018darkColors2qZNXz8(long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50) {
        return new Colors(r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, false, null);
    }

    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m2020lightColors2qZNXz8(long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50) {
        return new Colors(r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, true, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m2019darkColors2qZNXz8$default(long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, int r50, Object r51) {
        if ((r50 & 1) == 0) goto L5;
        long r1 = ColorKt.Color(4290479868L);
    L7:
        if ((r50 & 2) == 0) goto L9;
        long r3 = ColorKt.Color(4281794739L);
    L11:
        if ((r50 & 4) == 0) goto L13;
        long r5 = ColorKt.Color(4278442694L);
    L15:
        if ((r50 & 8) == 0) goto L17;
        long r7 = r5;
    L19:
        if ((r50 & 16) == 0) goto L21;
        long r12 = ColorKt.Color(4279374354L);
    L23:
        if ((r50 & 32) == 0) goto L25;
        long r9 = ColorKt.Color(4279374354L);
    L27:
        if ((r50 & 64) == 0) goto L29;
        long r14 = ColorKt.Color(4291782265L);
    L31:
        if ((r50 & 128) == 0) goto L33;
        long r16 = Color.Companion.getBlack-0d7_KjU();
    L35:
        if ((r50 & 256) == 0) goto L37;
        long r18 = Color.Companion.getBlack-0d7_KjU();
    L39:
        if ((r50 & 512) == 0) goto L41;
        long r20 = Color.Companion.getWhite-0d7_KjU();
    L43:
        if ((r50 & 1024) == 0) goto L45;
        long r22 = Color.Companion.getWhite-0d7_KjU();
    L47:
        if ((r50 & 2048) == 0) goto L49;
        long r24 = Color.Companion.getBlack-0d7_KjU();
    L51:
        return m2018darkColors2qZNXz8(r1, r3, r5, r7, r12, r9, r14, r16, r18, r20, r22, r24);
    L49:
        r24 = r48;
        goto L51
    L45:
        r22 = r46;
        goto L47
    L41:
        r20 = r44;
        goto L43
    L37:
        r18 = r42;
        goto L39
    L33:
        r16 = r40;
        goto L35
    L29:
        r14 = r38;
        goto L31
    L25:
        r9 = r36;
        goto L27
    L21:
        r12 = r34;
        goto L23
    L17:
        r7 = r32;
        goto L19
    L13:
        r5 = r30;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }

    /* JADX INFO: renamed from: lightColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m2021lightColors2qZNXz8$default(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, int r43, Object r44) {
        if ((r43 & 1) == 0) goto L5;
        long r1 = ColorKt.Color(4284612846L);
    L7:
        if ((r43 & 2) == 0) goto L9;
        long r3 = ColorKt.Color(4281794739L);
    L11:
        if ((r43 & 4) == 0) goto L13;
        long r5 = ColorKt.Color(4278442694L);
    L15:
        if ((r43 & 8) == 0) goto L17;
        long r7 = ColorKt.Color(4278290310L);
    L19:
        if ((r43 & 16) == 0) goto L21;
        long r9 = Color.Companion.getWhite-0d7_KjU();
    L23:
        if ((r43 & 32) == 0) goto L25;
        long r11 = Color.Companion.getWhite-0d7_KjU();
    L27:
        if ((r43 & 64) == 0) goto L29;
        long r13 = ColorKt.Color(4289724448L);
    L31:
        if ((r43 & 128) == 0) goto L33;
        long r15 = Color.Companion.getWhite-0d7_KjU();
    L34:
        long r34 = r15;
        if ((r43 & 256) == 0) goto L37;
        long r16 = Color.Companion.getBlack-0d7_KjU();
    L38:
        long r36 = r16;
        if ((r43 & 512) == 0) goto L41;
        long r17 = Color.Companion.getBlack-0d7_KjU();
    L42:
        long r38 = r17;
        if ((r43 & 1024) == 0) goto L45;
        long r18 = Color.Companion.getBlack-0d7_KjU();
    L47:
        if ((r43 & 2048) == 0) goto L49;
        long r110 = Color.Companion.getWhite-0d7_KjU();
    L51:
        return m2020lightColors2qZNXz8(r1, r3, r5, r7, r9, r11, r13, r34, r36, r38, r18, r110);
    L49:
        r110 = r41;
        goto L51
    L45:
        r18 = r39;
        goto L47
    L41:
        r17 = r37;
        goto L42
    L37:
        r16 = r35;
        goto L38
    L33:
        r15 = r33;
        goto L34
    L29:
        r13 = r31;
        goto L31
    L25:
        r11 = r29;
        goto L27
    L21:
        r9 = r27;
        goto L23
    L17:
        r7 = r25;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
