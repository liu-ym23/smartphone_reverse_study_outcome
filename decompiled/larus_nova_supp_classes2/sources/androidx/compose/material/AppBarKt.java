package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001as\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b!\u0010\"\u001ak\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0082\b\u001a\u0019\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0080\b\u001a,\u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0,2\u0006\u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\u0006\u0010.\u001a\u00020&H\u0000\u001ag\u0010/\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0003¢\u0006\u0004\b1\u00102\"\u0010\u00103\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00105\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u000e\u00106\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00109\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u000e\u0010:\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"TopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "Landroidx/compose/ui/graphics/Shape;", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "square", "", "x", "calculateCutoutCircleYIntercept", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "AppBar", "shape", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AppBarHeight", "F", "AppBarHorizontalPadding", "TitleInsetWithoutIcon", "TitleIconModifier", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarKt {
    private static final float AppBarHeight = 0.0f;
    private static final float AppBarHorizontalPadding = 0.0f;
    private static final float BottomAppBarCutoutOffset = 0.0f;
    private static final float BottomAppBarRoundedEdgeRadius = 0.0f;
    private static final Modifier TitleIconModifier = null;
    private static final Modifier TitleInsetWithoutIcon = null;
    private static final WindowInsets ZeroInsets = null;

    private static final Unit AppBar_HkEspTQ$lambda$6(long r14, long r16, float r18, PaddingValues r19, Shape r20, WindowInsets r21, Modifier r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m1924AppBarHkEspTQ(r14, r16, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBar_DanWW_k$lambda$4(WindowInsets r14, Modifier r15, long r16, long r18, Shape r20, float r21, PaddingValues r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m1925BottomAppBarDanWWk(r14, r15, r16, r18, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit BottomAppBar_Y1yfwus$lambda$5(Modifier r13, long r14, long r16, Shape r18, float r19, PaddingValues r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m1926BottomAppBarY1yfwus(r13, r14, r16, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar_HsRjFd4$lambda$3(Modifier r12, long r13, long r15, float r17, PaddingValues r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m1927TopAppBarHsRjFd4(r12, r13, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar_Rx1qByU$lambda$0(Function2 r14, WindowInsets r15, Modifier r16, Function2 r17, Function3 r18, long r19, long r21, float r23, int r24, int r25, Composer r26, int r27) {
        m1928TopAppBarRx1qByU(r14, r15, r16, r17, r18, r19, r21, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar_afqeVBk$lambda$2(WindowInsets r13, Modifier r14, long r15, long r17, float r19, PaddingValues r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m1929TopAppBarafqeVBk(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit TopAppBar_xWeB9_s$lambda$1(Function2 r13, Modifier r14, Function2 r15, Function3 r16, long r17, long r19, float r21, int r22, int r23, Composer r24, int r25) {
        m1930TopAppBarxWeB9s(r13, r14, r15, r16, r17, r19, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r0, long r2, float r4, PaddingValues r5, Shape r6, WindowInsets r7, Modifier r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return AppBar_HkEspTQ$lambda$6(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit b(Function2 r0, WindowInsets r1, Modifier r2, Function2 r3, Function3 r4, long r5, long r7, float r9, int r10, int r11, Composer r12, int r13) {
        return TopAppBar_Rx1qByU$lambda$0(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(WindowInsets r0, Modifier r1, long r2, long r4, float r6, PaddingValues r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return TopAppBar_afqeVBk$lambda$2(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit d(WindowInsets r0, Modifier r1, long r2, long r4, Shape r6, float r7, PaddingValues r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return BottomAppBar_DanWW_k$lambda$4(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit e(Modifier r0, long r1, long r3, float r5, PaddingValues r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return TopAppBar_HsRjFd4$lambda$3(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit f(Function2 r0, Modifier r1, Function2 r2, Function3 r3, long r4, long r6, float r8, int r9, int r10, Composer r11, int r12) {
        return TopAppBar_xWeB9_s$lambda$1(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit g(Modifier r0, long r1, long r3, Shape r5, float r6, PaddingValues r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return BottomAppBar_Y1yfwus$lambda$5(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    private static final float square(float r0) {
        return r0 * r0;
    }

    static {
        AppBarHeight = Dp.constructor-impl(56);
        float r0 = 4;
        float r1 = Dp.constructor-impl(r0);
        AppBarHorizontalPadding = r1;
        Modifier.Companion r2 = Modifier.Companion;
        TitleInsetWithoutIcon = SizeKt.m1019width3ABfNKs(r2, Dp.constructor-impl(Dp.constructor-impl(16) - r1));
        TitleIconModifier = SizeKt.m1019width3ABfNKs(SizeKt.fillMaxHeight$default(r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), Dp.constructor-impl(Dp.constructor-impl(72) - r1));
        BottomAppBarCutoutOffset = Dp.constructor-impl(8);
        BottomAppBarRoundedEdgeRadius = Dp.constructor-impl(r0);
        ZeroInsets = WindowInsetsKt.m1045WindowInsetsa9UjIt4$default(Dp.constructor-impl(0), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    }

    public static final /* synthetic */ float access$getAppBarHeight$p() {
        return AppBarHeight;
    }

    public static final /* synthetic */ float access$getAppBarHorizontalPadding$p() {
        return AppBarHorizontalPadding;
    }

    public static final /* synthetic */ float access$getBottomAppBarCutoutOffset$p() {
        return BottomAppBarCutoutOffset;
    }

    public static final /* synthetic */ float access$getBottomAppBarRoundedEdgeRadius$p() {
        return BottomAppBarRoundedEdgeRadius;
    }

    public static final /* synthetic */ Modifier access$getTitleIconModifier$p() {
        return TitleIconModifier;
    }

    public static final /* synthetic */ Modifier access$getTitleInsetWithoutIcon$p() {
        return TitleInsetWithoutIcon;
    }

    public static final float calculateCutoutCircleYIntercept(float r0, float r1) {
        return -((float) Math.sqrt((r0 * r0) - (r1 * r1)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float r7, float r8, float r9) {
        float r0 = r8 * r8;
        float r10 = r9 * r9;
        float r2 = (r7 * r7) + r0;
        float r1 = (r0 * r10) * (r2 - r10);
        float r3 = r7 * r10;
        double r4 = r1;
        float r5 = (r3 - ((float) Math.sqrt(r4))) / r2;
        float r6 = (r3 + ((float) Math.sqrt(r4))) / r2;
        float r11 = (float) Math.sqrt(r10 - (r5 * r5));
        float r12 = (float) Math.sqrt(r10 - (r6 * r6));
        if (r8 <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L10;
        if (r11 <= r12) goto L7;
        Float r13 = Float.valueOf(r5);
        Float r14 = Float.valueOf(r11);
    L8:
        Pair r15 = TuplesKt.to(r13, r14);
    L14:
        float r16 = ((Number) r15.component1()).floatValue();
        float r17 = ((Number) r15.component2()).floatValue();
        if (r16 >= r7) goto L18;
        r17 = -r17;
    L18:
        return TuplesKt.to(Float.valueOf(r16), Float.valueOf(r17));
    L7:
        r13 = Float.valueOf(r6);
        r14 = Float.valueOf(r12);
        goto L8
    L10:
        if (r11 >= r12) goto L12;
        Float r18 = Float.valueOf(r5);
        Float r19 = Float.valueOf(r11);
    L13:
        r15 = TuplesKt.to(r18, r19);
        goto L14
    L12:
        r18 = Float.valueOf(r6);
        r19 = Float.valueOf(r12);
        goto L13
    }

    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    public static final void m1927TopAppBarHsRjFd4(Modifier r23, long r24, long r26, float r28, PaddingValues r29, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-2030536439);
        int r2 = r33 & 1;
        if (r2 == 0) goto L6;
        int r4 = r32 | 6;
        Modifier r3 = r23;
    L14:
        if ((r32 & 48) == 0) goto L16;
        long r5 = r24;
    L25:
        if ((r32 & 384) == 0) goto L27;
        long r7 = r26;
    L35:
        int r10 = r33 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        float r11 = r28;
    L46:
        int r12 = r33 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        PaddingValues r13 = r29;
    L58:
        if ((r33 & 32) == 0) goto L61;
        r4 = r4 | 196608;
    L68:
        if ((74899 & r4) == 74898) goto L70;
        boolean r0 = true;
    L72:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L106;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L76;
    L86:
        if (r2 == 0) goto L88;
        Modifier r6 = Modifier.Companion;
    L90:
        if ((r33 & 2) == 0) goto L93;
        r4 = r4 & (-113);
        r5 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r1, 6));
    L93:
        if ((r33 & 4) == 0) goto L95;
        long r8 = ColorsKt.m2017contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
        r7 = r8;
    L95:
        if (r10 == 0) goto L97;
        r11 = AppBarDefaults.INSTANCE.m1923getTopAppBarElevationD9Ej5fM();
    L97:
        if (r12 != 0) goto L98;
    L85:
        float r9 = r11;
        PaddingValues r14 = r13;
    L99:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventStart(-2030536439, r4, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
    L102:
        int r15 = r4 >> 3;
        int r16 = (((r15 & 14) | 221184) | (r15 & 112)) | (r15 & 896);
        int r21 = (((r15 & 7168) | r16) | ((r4 << 18) & 3670016)) | ((r4 << 6) & 29360128);
        long r17 = r5;
        long r18 = r7;
        float r19 = r9;
        PaddingValues r110 = r14;
        m1924AppBarHkEspTQ(r17, r18, r19, r110, RectangleShapeKt.getRectangleShape(), ZeroInsets, r6, r30, r1, r21, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventEnd();
    L105:
        r11 = r9;
        r13 = r14;
        r3 = r6;
    L107:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L111;
        final Modifier r20 = r3;
        final long r22 = r5;
        final long r25 = r7;
        final float r27 = r11;
        final PaddingValues r34 = r13;
        r111.updateScope(new c0(r20, r22, r25, r27, r34, r30, r32, r33));
        return;
    L111:
        return;
    L98:
        r14 = AppBarDefaults.INSTANCE.getContentPadding();
        r9 = r11;
        goto L99
    L88:
        r6 = r3;
        goto L90
    L76:
        if (r1.getDefaultsInvalid() == true) goto L86;
        r1.skipToGroupEnd();
        if ((r33 & 2) == 0) goto L82;
        r4 = r4 & (-113);
    L82:
        if ((r33 & 4) == 0) goto L84;
        r4 = r4 & (-897);
    L84:
        r6 = r3;
        goto L85
    L106:
        r1.skipToGroupEnd();
        goto L107
    L70:
        r0 = false;
        goto L72
    L61:
        if ((r32 & 196608) != 0) goto L68;
        if (r1.changedInstance(r30) == false) goto L65;
        int r112 = 131072;
    L66:
        r4 = r4 | r112;
        goto L68
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r32 & 24576) != 0) goto L56;
        r13 = r29;
        if (r1.changed(r13) == false) goto L54;
        int r113 = 16384;
    L55:
        r4 = r4 | r113;
        goto L58
    L54:
        r113 = 8192;
        goto L55
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r11 = r28;
        if (r1.changed(r11) == false) goto L43;
        int r114 = 2048;
    L44:
        r4 = r4 | r114;
        goto L46
    L43:
        r114 = 1024;
        goto L44
    L27:
        if ((r33 & 4) != 0) goto L31;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r115 = 256;
    L33:
        r4 = r4 | r115;
    L32:
        r115 = 128;
        goto L33
    L31:
        r7 = r26;
        goto L32
    L16:
        if ((r33 & 2) != 0) goto L20;
        r5 = r24;
        if (r1.changed(r5) == false) goto L21;
        int r35 = 32;
    L22:
        r4 = r4 | r35;
    L21:
        r35 = 16;
        goto L22
    L20:
        r5 = r24;
        goto L21
    L6:
        if ((r32 & 6) != 0) goto L12;
        r3 = r23;
        if (r1.changed(r3) == false) goto L10;
        int r36 = 4;
    L11:
        r4 = r36 | r32;
        goto L14
    L10:
        r36 = 2;
        goto L11
    L12:
        r3 = r23;
        r4 = r32;
        goto L14
    }

    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    public static final void m1926BottomAppBarY1yfwus(Modifier r25, long r26, long r28, Shape r30, float r31, PaddingValues r32, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r33, Composer r34, final int r35, final int r36) {
        Composer r1 = r34.startRestartGroup(-2058075642);
        int r2 = r36 & 1;
        if (r2 == 0) goto L6;
        int r4 = r35 | 6;
    L14:
        if ((r35 & 48) != 0) goto L25;
        if ((r36 & 2) != 0) goto L21;
        if (r1.changed(r26) == false) goto L21;
        int r7 = 32;
    L22:
        r4 = r4 | r7;
    L21:
        r7 = 16;
    L25:
        if ((r35 & 384) == 0) goto L27;
        long r8 = r28;
    L35:
        int r9 = r36 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Shape r11 = r30;
    L46:
        int r12 = r36 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        float r13 = r31;
    L57:
        int r14 = r36 & 32;
        if (r14 == 0) goto L60;
        r4 = r4 | 196608;
        PaddingValues r15 = r32;
    L68:
        if ((r36 & 64) == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        boolean r17 = false;
        if ((r4 & 599187) == 599186) goto L80;
        boolean r0 = true;
    L82:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L131;
        r1.startDefaults();
        if ((r35 & 1) != 0) goto L86;
    L96:
        if (r2 == 0) goto L98;
        Modifier r3 = Modifier.Companion;
    L100:
        if ((r36 & 2) == 0) goto L102;
        long r5 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r1, 6));
        r4 = r4 & (-113);
    L104:
        if ((r36 & 4) == 0) goto L106;
        long r6 = ColorsKt.m2017contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
    L107:
        if (r9 == 0) goto L109;
        Shape r10 = null;
    L110:
        if (r12 == 0) goto L112;
        float r16 = AppBarDefaults.INSTANCE.m1922getBottomAppBarElevationD9Ej5fM();
    L113:
        if (r14 != 0) goto L114;
    L95:
        int r18 = r4;
        PaddingValues r19 = r15;
    L115:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(-2058075642, r18, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
    L118:
        FabPlacement r110 = (FabPlacement) r1.consume(ScaffoldKt.getLocalFabPlacement());
        if (r10 == null) goto L126;
        if (r110 != null) goto L122;
    L124:
        if (r17 == false) goto L126;
        Shape r20 = new BottomAppBarCutoutShape(r10, r110);
    L127:
        int r21 = r18 >> 3;
        int r111 = (r21 & 14) | 196608;
        int r22 = (r21 & 112) | r111;
        int r112 = r18 >> 6;
        int r23 = (((r22 | (r112 & 896)) | (r112 & 7168)) | ((r18 << 18) & 3670016)) | ((r18 << 3) & 29360128);
        long r113 = r5;
        long r114 = r6;
        float r115 = r16;
        PaddingValues r116 = r19;
        m1924AppBarHkEspTQ(r113, r114, r115, r116, r20, ZeroInsets, r3, r33, r1, r23, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventEnd();
    L130:
        r15 = r19;
        long r24 = r5;
        Modifier r27 = r3;
    L132:
        ScopeUpdateScope r117 = r1.endRestartGroup();
        if (r117 == null) goto L136;
        final Modifier r29 = r27;
        final long r37 = r24;
        final long r38 = r6;
        final Shape r39 = r10;
        final float r40 = r16;
        final PaddingValues r41 = r15;
        r117.updateScope(new x(r29, r37, r38, r39, r40, r41, r33, r35, r36));
        return;
    L136:
        return;
    L122:
        if (r110.isDocked() != true) goto L124;
        r17 = true;
    L126:
        r20 = RectangleShapeKt.getRectangleShape();
        goto L127
    L114:
        PaddingValues r118 = AppBarDefaults.INSTANCE.getContentPadding();
        r18 = r4;
        r19 = r118;
        goto L115
    L112:
        r16 = r13;
        goto L113
    L109:
        r10 = r11;
        goto L110
    L106:
        r6 = r8;
        goto L107
    L102:
        r5 = r26;
        goto L104
    L98:
        r3 = r25;
        goto L100
    L86:
        if (r1.getDefaultsInvalid() == true) goto L96;
        r1.skipToGroupEnd();
        if ((r36 & 2) == 0) goto L92;
        r4 = r4 & (-113);
    L92:
        if ((r36 & 4) == 0) goto L94;
        r4 = r4 & (-897);
    L94:
        r3 = r25;
        r5 = r26;
        r6 = r8;
        r10 = r11;
        r16 = r13;
        goto L95
    L131:
        r1.skipToGroupEnd();
        r27 = r25;
        r24 = r26;
        r6 = r8;
        r10 = r11;
        r16 = r13;
        goto L132
    L80:
        r0 = false;
        goto L82
    L71:
        if ((r35 & 1572864) != 0) goto L77;
        if (r1.changedInstance(r33) == false) goto L75;
        int r119 = 1048576;
    L76:
        r4 = r4 | r119;
        goto L77
    L75:
        r119 = 524288;
        goto L76
    L60:
        r15 = r32;
        if ((r35 & 196608) != 0) goto L68;
        if (r1.changed(r15) == false) goto L65;
        int r120 = 131072;
    L66:
        r4 = r4 | r120;
        goto L68
    L65:
        r120 = 65536;
        goto L66
    L50:
        if ((r35 & 24576) != 0) goto L56;
        r13 = r31;
        if (r1.changed(r13) == false) goto L54;
        int r121 = 16384;
    L55:
        r4 = r4 | r121;
        goto L57
    L54:
        r121 = 8192;
        goto L55
    L39:
        if ((r35 & 3072) != 0) goto L45;
        r11 = r30;
        if (r1.changed(r11) == false) goto L43;
        int r122 = 2048;
    L44:
        r4 = r4 | r122;
        goto L46
    L43:
        r122 = 1024;
        goto L44
    L27:
        if ((r36 & 4) != 0) goto L31;
        r8 = r28;
        if (r1.changed(r8) == false) goto L32;
        int r42 = 256;
    L33:
        r4 = r4 | r42;
    L32:
        r42 = 128;
        goto L33
    L31:
        r8 = r28;
        goto L32
    L6:
        if ((r35 & 6) == 0) goto L8;
        r4 = r35;
        goto L14
    L8:
        if (r1.changed(r25) == false) goto L10;
        int r43 = 4;
    L11:
        r4 = r43 | r35;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TopAppBar-afqeVBk, reason: not valid java name */
    public static final void m1929TopAppBarafqeVBk(final WindowInsets r26, Modifier r27, long r28, long r30, float r32, PaddingValues r33, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(684777089);
        if ((r37 & 1) == 0) goto L6;
        int r3 = r36 | 6;
    L13:
        int r4 = r37 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r27;
    L25:
        if ((r36 & 384) == 0) goto L27;
        long r6 = r28;
    L36:
        if ((r36 & 3072) == 0) goto L38;
        long r8 = r30;
    L46:
        int r11 = r37 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r12 = r32;
    L57:
        int r13 = r37 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        PaddingValues r14 = r33;
    L69:
        if ((r37 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L116;
        r1.startDefaults();
        if ((r36 & 1) != 0) goto L88;
    L97:
        if (r4 == 0) goto L100;
        r5 = Modifier.Companion;
    L100:
        if ((r37 & 4) == 0) goto L103;
        r6 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r1, 6));
        r3 = r3 & (-897);
    L103:
        if ((r37 & 8) == 0) goto L105;
        r8 = ColorsKt.m2017contentColorForek8zF_U(r6, r1, (r3 >> 6) & 14);
        r3 = r3 & (-7169);
    L105:
        if (r11 == 0) goto L107;
        r12 = AppBarDefaults.INSTANCE.m1923getTopAppBarElevationD9Ej5fM();
    L107:
        if (r13 != 0) goto L108;
    L96:
        float r2 = r12;
        PaddingValues r7 = r14;
    L109:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(684777089, r3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
    L112:
        int r9 = r3 >> 6;
        int r15 = (((r9 & 14) | 24576) | (r9 & 112)) | (r9 & 896);
        int r10 = (r9 & 7168) | r15;
        int r16 = r3 << 15;
        int r22 = ((r10 | (458752 & r16)) | (r16 & 3670016)) | ((r3 << 3) & 29360128);
        long r17 = r6;
        long r18 = r8;
        float r19 = r2;
        PaddingValues r110 = r7;
        m1924AppBarHkEspTQ(r17, r18, r19, r110, RectangleShapeKt.getRectangleShape(), r26, r5, r34, r1, r22, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
    L115:
        final long r20 = r6;
        final float r21 = r2;
        long r24 = r8;
        final PaddingValues r23 = r7;
        final Modifier r25 = r5;
        final long r29 = r24;
    L117:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L121;
        r111.updateScope(new y(r26, r25, r20, r29, r21, r23, r34, r36, r37));
        return;
    L121:
        return;
    L108:
        r7 = AppBarDefaults.INSTANCE.getContentPadding();
        r2 = r12;
        goto L109
    L88:
        if (r1.getDefaultsInvalid() == true) goto L97;
        r1.skipToGroupEnd();
        if ((r37 & 4) == 0) goto L94;
        r3 = r3 & (-897);
    L94:
        if ((r37 & 8) == 0) goto L96;
        r3 = r3 & (-7169);
        goto L96
    L116:
        r1.skipToGroupEnd();
        r25 = r5;
        r20 = r6;
        r29 = r8;
        r21 = r12;
        r23 = r14;
        goto L117
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r36 & 1572864) != 0) goto L80;
        if (r1.changedInstance(r34) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L80
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r36) != 0) goto L67;
        r14 = r33;
        if (r1.changed(r14) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L69
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r36 & 24576) != 0) goto L56;
        r12 = r32;
        if (r1.changed(r12) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L38:
        if ((r37 & 8) != 0) goto L42;
        r8 = r30;
        if (r1.changed(r8) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
    L43:
        r115 = 1024;
        goto L44
    L42:
        r8 = r30;
        goto L43
    L27:
        if ((r37 & 4) != 0) goto L31;
        r6 = r28;
        if (r1.changed(r6) == false) goto L32;
        int r31 = 256;
    L33:
        r3 = r3 | r31;
    L32:
        r31 = 128;
        goto L33
    L31:
        r6 = r28;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L23;
        r5 = r27;
        if (r1.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L25
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r3 = r36;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r36;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m1930TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> r28, Modifier r29, Function2<? super Composer, ? super Integer, Unit> r30, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r31, long r32, long r34, float r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(-350082398);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L13:
        int r4 = r39 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r29;
    L24:
        int r6 = r39 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r7 = r30;
    L35:
        int r8 = r39 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r9 = r31;
    L47:
        if ((r38 & 24576) == 0) goto L49;
        long r11 = r32;
    L58:
        if ((196608 & r38) == 0) goto L60;
        long r13 = r34;
    L68:
        int r15 = r39 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r3 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L118;
        r1.startDefaults();
        if ((r38 & 1) != 0) goto L87;
    L97:
        if (r4 == 0) goto L99;
        r5 = Modifier.Companion;
    L99:
        if (r6 == 0) goto L101;
        r7 = null;
    L101:
        if (r8 == 0) goto L104;
        r9 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
    L104:
        if ((r39 & 16) == 0) goto L107;
        r11 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r1, 6));
        r3 = r3 & (-57345);
    L107:
        if ((r39 & 32) == 0) goto L109;
        r13 = ColorsKt.m2017contentColorForek8zF_U(r11, r1, (r3 >> 12) & 14);
        r3 = r3 & (-458753);
    L109:
        if (r15 != 0) goto L110;
    L95:
        float r2 = r36;
    L96:
        int r10 = r3;
        long r12 = r11;
        long r24 = r13;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(-350082398, r10, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
    L114:
        int r14 = (r10 & 14) | 48;
        int r16 = r10 << 3;
        m1928TopAppBarRx1qByU(r28, ZeroInsets, r5, r7, r9, r12, r24, r2, r1, (((((r14 | (r16 & 896)) | (r16 & 7168)) | (57344 & r16)) | (458752 & r16)) | (3670016 & r16)) | (r16 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r17 = r9;
        final float r18 = r2;
        final Modifier r19 = r5;
        final long r20 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r21 = r7;
        final long r22 = r24;
    L119:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L123;
        r110.updateScope(new a0(r28, r19, r21, r17, r20, r22, r18, r38, r39));
        return;
    L123:
        return;
    L110:
        r2 = AppBarDefaults.INSTANCE.m1923getTopAppBarElevationD9Ej5fM();
        goto L96
    L87:
        if (r1.getDefaultsInvalid() == true) goto L97;
        r1.skipToGroupEnd();
        if ((r39 & 16) == 0) goto L93;
        r3 = r3 & (-57345);
    L93:
        if ((r39 & 32) == 0) goto L95;
        r3 = r3 & (-458753);
        goto L95
    L118:
        r1.skipToGroupEnd();
        r19 = r5;
        r21 = r7;
        r17 = r9;
        r20 = r11;
        r22 = r13;
        r18 = r36;
        goto L119
    L81:
        r0 = false;
        goto L83
    L72:
        if ((r38 & 1572864) != 0) goto L79;
        if (r1.changed(r36) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L60:
        if ((r39 & 32) != 0) goto L64;
        r13 = r34;
        if (r1.changed(r13) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r13 = r34;
        goto L65
    L49:
        if ((r39 & 16) != 0) goto L53;
        r11 = r32;
        if (r1.changed(r11) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r11 = r32;
        goto L54
    L39:
        if ((r38 & 3072) != 0) goto L45;
        r9 = r31;
        if (r1.changedInstance(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L47
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r38 & 384) != 0) goto L34;
        r7 = r30;
        if (r1.changedInstance(r7) == false) goto L32;
        int r23 = 256;
    L33:
        r3 = r3 | r23;
        goto L35
    L32:
        r23 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L23;
        r5 = r29;
        if (r1.changed(r5) == false) goto L21;
        int r25 = 32;
    L22:
        r3 = r3 | r25;
        goto L24
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L13
    L8:
        if (r1.changedInstance(r28) == false) goto L10;
        int r26 = 4;
    L11:
        r3 = r26 | r38;
        goto L13
    L10:
        r26 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: AppBar-HkEspTQ, reason: not valid java name */
    private static final void m1924AppBarHkEspTQ(final long r25, final long r27, final float r29, final PaddingValues r30, final Shape r31, final WindowInsets r32, Modifier r33, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(1222317265);
        if ((r37 & 1) == 0) goto L6;
        int r4 = r36 | 6;
    L14:
        if ((r37 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r37 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L35:
        if ((r37 & 8) == 0) goto L38;
        r4 = r4 | 3072;
    L45:
        if ((r37 & 16) == 0) goto L48;
        r4 = r4 | 24576;
    L56:
        if ((r37 & 32) == 0) goto L59;
        r4 = r4 | 196608;
    L65:
        int r9 = r37 & 64;
        if (r9 == 0) goto L68;
        r4 = r4 | 1572864;
        Modifier r13 = r33;
    L76:
        if ((r37 & 128) == 0) goto L79;
        r4 = r4 | 12582912;
    L86:
        if ((4793491 & r4) == 4793490) goto L88;
        boolean r0 = true;
    L90:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L101;
        if (r9 == 0) goto L93;
        Modifier r2 = Modifier.Companion;
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(1222317265, r4, -1, "androidx.compose.material.AppBar (AppBar.kt:699)");
    L97:
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(-1628734195, true, new AppBarKt$AppBar$1(r32, r30, r34), r1, 54);
        int r3 = (((r4 >> 18) & 14) | 1572864) | ((r4 >> 9) & 112);
        int r5 = r4 << 6;
        Modifier r14 = r2;
        SurfaceKt.m2175SurfaceFjzlyU(r14, r31, r25, r27, null, r29, r21, r1, ((r3 | (r5 & 896)) | (r5 & 7168)) | (458752 & (r4 << 9)), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventEnd();
    L100:
        final Modifier r10 = r2;
    L102:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L106;
        r15.updateScope(new d0(r25, r27, r29, r30, r31, r32, r10, r34, r36, r37));
        return;
    L106:
        return;
    L93:
        r2 = r13;
        goto L95
    L101:
        r1.skipToGroupEnd();
        r10 = r13;
        goto L102
    L88:
        r0 = false;
        goto L90
    L79:
        if ((r36 & 12582912) != 0) goto L86;
        if (r1.changedInstance(r34) == false) goto L83;
        int r6 = 8388608;
    L84:
        r4 = r4 | r6;
        goto L86
    L83:
        r6 = 4194304;
        goto L84
    L68:
        r13 = r33;
        if ((r36 & 1572864) != 0) goto L76;
        if (r1.changed(r13) == false) goto L73;
        int r16 = 1048576;
    L74:
        r4 = r4 | r16;
        goto L76
    L73:
        r16 = 524288;
        goto L74
    L59:
        if ((r36 & 196608) != 0) goto L65;
        if (r1.changed(r32) == false) goto L63;
        int r11 = 131072;
    L64:
        r4 = r4 | r11;
        goto L65
    L63:
        r11 = 65536;
        goto L64
    L48:
        if ((r36 & 24576) != 0) goto L56;
        if (r1.changed(r31) == false) goto L52;
        int r12 = 16384;
    L53:
        r4 = r4 | r12;
        goto L56
    L52:
        r12 = 8192;
        goto L53
    L38:
        if ((r36 & 3072) != 0) goto L45;
        if (r1.changed(r30) == false) goto L42;
        int r7 = 2048;
    L43:
        r4 = r4 | r7;
        goto L45
    L42:
        r7 = 1024;
        goto L43
    L27:
        if ((r36 & 384) != 0) goto L35;
        if (r1.changed(r29) == false) goto L31;
        int r8 = 256;
    L32:
        r4 = r4 | r8;
        goto L35
    L31:
        r8 = 128;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r1.changed(r27) == false) goto L21;
        int r17 = 32;
    L22:
        r4 = r4 | r17;
        goto L24
    L21:
        r17 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r4 = r36;
        goto L14
    L8:
        if (r1.changed(r25) == false) goto L10;
        int r18 = 4;
    L11:
        r4 = r18 | r36;
        goto L14
    L10:
        r18 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BottomAppBar-DanWW-k, reason: not valid java name */
    public static final void m1925BottomAppBarDanWWk(final WindowInsets r29, Modifier r30, long r31, long r33, Shape r35, float r36, PaddingValues r37, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(-1136595494);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r4 = r41 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r40 & 384) == 0) goto L27;
        long r6 = r31;
    L36:
        if ((r40 & 3072) == 0) goto L38;
        long r8 = r33;
    L46:
        int r10 = r41 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Shape r13 = r35;
    L57:
        int r14 = r41 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        float r15 = r36;
    L68:
        int r16 = r41 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r41 & 128) == 0) goto L82;
        r3 = r3 | 12582912;
    L89:
        boolean r18 = false;
        if ((r3 & 4793491) == 4793490) goto L92;
        boolean r0 = true;
    L94:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L140;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L98;
    L109:
        if (r4 == 0) goto L111;
        Modifier r2 = Modifier.Companion;
    L113:
        if ((r41 & 4) == 0) goto L116;
        r6 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r1, 6));
        r3 = r3 & (-897);
    L116:
        if ((r41 & 8) == 0) goto L118;
        r8 = ColorsKt.m2017contentColorForek8zF_U(r6, r1, (r3 >> 6) & 14);
        r3 = r3 & (-7169);
    L118:
        if (r10 == 0) goto L120;
        r13 = null;
    L120:
        if (r14 == 0) goto L122;
        r15 = AppBarDefaults.INSTANCE.m1922getBottomAppBarElevationD9Ej5fM();
    L122:
        if (r16 != 0) goto L123;
    L107:
        PaddingValues r5 = r37;
    L108:
        int r11 = r3;
        Shape r7 = r13;
        float r9 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L127;
        ComposerKt.traceEventStart(-1136595494, r11, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
    L127:
        FabPlacement r17 = (FabPlacement) r1.consume(ScaffoldKt.getLocalFabPlacement());
        if (r7 == null) goto L135;
        if (r17 != null) goto L131;
    L133:
        if (r18 == false) goto L135;
        Shape r12 = new BottomAppBarCutoutShape(r7, r17);
    L136:
        Shape r19 = r12;
        int r20 = r11 >> 6;
        int r21 = (r20 & 112) | (r20 & 14);
        int r110 = r11 >> 9;
        int r22 = (r21 | (r110 & 896)) | (r110 & 7168);
        int r111 = r11 << 15;
        m1924AppBarHkEspTQ(r6, r8, r9, r5, r19, r29, r2, r38, r1, ((r22 | (458752 & r111)) | (r111 & 3670016)) | (r11 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventEnd();
    L139:
        final Modifier r23 = r2;
        final Shape r24 = r7;
        final long r25 = r8;
        final float r26 = r9;
        final PaddingValues r27 = r5;
        final long r28 = r6;
    L141:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L145;
        r112.updateScope(new b0(r29, r23, r28, r25, r24, r26, r27, r38, r40, r41));
        return;
    L145:
        return;
    L131:
        if (r17.isDocked() != true) goto L133;
        r18 = true;
    L135:
        r12 = RectangleShapeKt.getRectangleShape();
        goto L136
    L123:
        r5 = AppBarDefaults.INSTANCE.getContentPadding();
        goto L108
    L111:
        r2 = r30;
        goto L113
    L98:
        if (r1.getDefaultsInvalid() == true) goto L109;
        r1.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L104;
        r3 = r3 & (-897);
    L104:
        if ((r41 & 8) == 0) goto L106;
        r3 = r3 & (-7169);
    L106:
        r2 = r30;
        goto L107
    L140:
        r1.skipToGroupEnd();
        r23 = r30;
        r28 = r6;
        r25 = r8;
        r24 = r13;
        r26 = r15;
        r27 = r37;
        goto L141
    L92:
        r0 = false;
        goto L94
    L82:
        if ((r40 & 12582912) != 0) goto L89;
        if (r1.changedInstance(r38) == false) goto L86;
        int r113 = 8388608;
    L87:
        r3 = r3 | r113;
        goto L89
    L86:
        r113 = 4194304;
        goto L87
    L72:
        if ((r40 & 1572864) != 0) goto L79;
        if (r1.changed(r37) == false) goto L76;
        int r114 = 1048576;
    L77:
        r3 = r3 | r114;
        goto L79
    L76:
        r114 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r15 = r36;
        if (r1.changed(r15) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
        goto L68
    L65:
        r115 = 65536;
        goto L66
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r13 = r35;
        if (r1.changed(r13) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
        goto L57
    L54:
        r116 = 8192;
        goto L55
    L38:
        if ((r41 & 8) != 0) goto L42;
        r8 = r33;
        if (r1.changed(r8) == false) goto L43;
        int r117 = 2048;
    L44:
        r3 = r3 | r117;
    L43:
        r117 = 1024;
        goto L44
    L42:
        r8 = r33;
        goto L43
    L27:
        if ((r41 & 4) != 0) goto L31;
        r6 = r31;
        if (r1.changed(r6) == false) goto L32;
        int r32 = 256;
    L33:
        r3 = r3 | r32;
    L32:
        r32 = 128;
        goto L33
    L31:
        r6 = r31;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L25;
        if (r1.changed(r30) == false) goto L21;
        int r34 = 32;
    L22:
        r3 = r3 | r34;
        goto L25
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r42 = 4;
    L11:
        r3 = r42 | r40;
        goto L13
    L10:
        r42 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TopAppBar-Rx1qByU, reason: not valid java name */
    public static final void m1928TopAppBarRx1qByU(final Function2<? super Composer, ? super Integer, Unit> r28, final WindowInsets r29, Modifier r30, Function2<? super Composer, ? super Integer, Unit> r31, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r32, long r33, long r35, float r37, Composer r38, final int r39, final int r40) {
        Composer r2 = r38.startRestartGroup(138090236);
        if ((r40 & 1) == 0) goto L6;
        int r3 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r40 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r30;
    L35:
        int r7 = r40 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        final Function2<? super Composer, ? super Integer, Unit> r8 = r31;
    L46:
        int r9 = r40 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r10 = r32;
    L58:
        if ((196608 & r39) == 0) goto L60;
        long r13 = r33;
    L69:
        if ((1572864 & r39) != 0) goto L78;
        if ((r40 & 64) == 0) goto L73;
    L75:
        int r16 = 524288;
    L76:
        r3 = r3 | r16;
        goto L78
    L73:
        if (r2.changed(r35) == false) goto L75;
        r16 = 1048576;
    L78:
        int r15 = r40 & 128;
        if (r15 == 0) goto L82;
        r3 = r3 | 12582912;
    L89:
        if ((4793491 & r3) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L130;
        r2.startDefaults();
        if ((r39 & 1) != 0) goto L97;
    L107:
        if (r5 == 0) goto L109;
        r6 = Modifier.Companion;
    L109:
        if (r7 == 0) goto L111;
        r8 = null;
    L111:
        if (r9 == 0) goto L114;
        r10 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
    L114:
        if ((r40 & 32) == 0) goto L117;
        r13 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r2, 6));
        r3 = r3 & (-458753);
    L117:
        if ((r40 & 64) == 0) goto L119;
        long r17 = ColorsKt.m2017contentColorForek8zF_U(r13, r2, (r3 >> 15) & 14);
        r3 = r3 & (-3670017);
    L120:
        if (r15 == 0) goto L122;
        int r11 = r3;
        long r26 = r17;
        float r4 = AppBarDefaults.INSTANCE.m1923getTopAppBarElevationD9Ej5fM();
        long r1 = r13;
    L123:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventStart(138090236, r11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
    L126:
        int r12 = r11 >> 15;
        int r14 = r11 << 12;
        long r18 = r1;
        long r19 = r26;
        float r110 = r4;
        Modifier r21 = r6;
        m1924AppBarHkEspTQ(r18, r19, r110, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), r29, r21, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new AppBarKt$TopAppBar$1(r8, r28, r10), r2, 54), r2, (((r12 & 896) | (((r12 & 14) | 12610560) | (r12 & 112))) | (458752 & r14)) | (r14 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventEnd();
    L129:
        final Function2<? super Composer, ? super Integer, Unit> r20 = r8;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r22 = r10;
        final float r111 = r4;
        final Modifier r23 = r6;
        final long r24 = r1;
    L131:
        ScopeUpdateScope r112 = r2.endRestartGroup();
        if (r112 == null) goto L135;
        final long r25 = r26;
        r112.updateScope(new z(r28, r29, r23, r20, r22, r24, r25, r111, r39, r40));
        return;
    L135:
        return;
    L122:
        r11 = r3;
        r1 = r13;
        r26 = r17;
    L106:
        r4 = r37;
        goto L123
    L119:
        r17 = r35;
        goto L120
    L97:
        if (r2.getDefaultsInvalid() == true) goto L107;
        r2.skipToGroupEnd();
        if ((r40 & 32) == 0) goto L103;
        r3 = r3 & (-458753);
    L103:
        if ((r40 & 64) == 0) goto L105;
        r3 = r3 & (-3670017);
    L105:
        r26 = r35;
        r11 = r3;
        r1 = r13;
        goto L106
    L130:
        r2.skipToGroupEnd();
        r26 = r35;
        r23 = r6;
        r20 = r8;
        r22 = r10;
        r24 = r13;
        r111 = r37;
        goto L131
    L91:
        r0 = false;
        goto L93
    L82:
        if ((r39 & 12582912) != 0) goto L89;
        if (r2.changed(r37) == false) goto L86;
        int r27 = 8388608;
    L87:
        r3 = r3 | r27;
        goto L89
    L86:
        r27 = 4194304;
        goto L87
    L60:
        if ((r40 & 32) != 0) goto L64;
        r13 = r33;
        if (r2.changed(r13) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
    L65:
        r113 = 65536;
        goto L66
    L64:
        r13 = r33;
        goto L65
    L50:
        if ((r39 & 24576) != 0) goto L56;
        r10 = r32;
        if (r2.changedInstance(r10) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L58
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r39 & 3072) != 0) goto L45;
        r8 = r31;
        if (r2.changedInstance(r8) == false) goto L43;
        int r34 = 2048;
    L44:
        r3 = r3 | r34;
        goto L46
    L43:
        r34 = 1024;
        goto L44
    L28:
        if ((r39 & 384) != 0) goto L34;
        r6 = r30;
        if (r2.changed(r6) == false) goto L32;
        int r36 = 256;
    L33:
        r3 = r3 | r36;
        goto L35
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r2.changed(r29) == false) goto L21;
        int r41 = 32;
    L22:
        r3 = r3 | r41;
        goto L24
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r3 = r39;
        goto L14
    L8:
        if (r2.changedInstance(r28) == false) goto L10;
        int r42 = 4;
    L11:
        r3 = r42 | r39;
        goto L14
    L10:
        r42 = 2;
        goto L11
    }
}
