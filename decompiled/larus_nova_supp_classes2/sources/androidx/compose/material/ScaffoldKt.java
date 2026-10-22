package androidx.compose.material;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a¤\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b)\u0010*\u001a\u009c\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b+\u0010,\u001a¥\u0001\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00162\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b02\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b0H\u0003¢\u0006\u0004\b3\u00104\"\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010706X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109\"\u0010\u0010:\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;¨\u0006<"}, d2 = {"rememberScaffoldState", "Landroidx/compose/material/ScaffoldState;", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "Scaffold", "", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "Landroidx/compose/ui/unit/Dp;", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "FabSpacing", "F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldKt {
    private static final float FabSpacing = 0.0f;
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = null;

    private static final FabPlacement LocalFabPlacement$lambda$26() {
        return null;
    }

    private static final Unit ScaffoldLayout_i1QSOvI$lambda$25(boolean r11, int r12, Function2 r13, Function3 r14, Function2 r15, Function2 r16, WindowInsets r17, Function2 r18, int r19, Composer r20, int r21) {
        m2145ScaffoldLayouti1QSOvI(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Scaffold_27mzLpw$lambda$4(Modifier r27, ScaffoldState r28, Function2 r29, Function2 r30, Function3 r31, Function2 r32, int r33, boolean r34, Function3 r35, boolean r36, Shape r37, float r38, long r39, long r41, long r43, long r45, long r47, Function3 r49, int r50, int r51, int r52, Composer r53, int r54) {
        m2143Scaffold27mzLpw(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r41, r43, r45, r47, r49, r53, RecomposeScopeImplKt.updateChangedFlags(r50 | 1), RecomposeScopeImplKt.updateChangedFlags(r51), r52);
        return Unit.INSTANCE;
    }

    private static final Unit Scaffold_u4IkXBM$lambda$3(WindowInsets r28, Modifier r29, ScaffoldState r30, Function2 r31, Function2 r32, Function3 r33, Function2 r34, int r35, boolean r36, Function3 r37, boolean r38, Shape r39, float r40, long r41, long r43, long r45, long r47, long r49, Function3 r51, int r52, int r53, int r54, Composer r55, int r56) {
        m2144Scaffoldu4IkXBM(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r55, RecomposeScopeImplKt.updateChangedFlags(r52 | 1), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(WindowInsets r1, Modifier r2, ScaffoldState r3, Function2 r4, Function2 r5, Function3 r6, Function2 r7, int r8, boolean r9, Function3 r10, boolean r11, Shape r12, float r13, long r14, long r16, long r18, long r20, long r22, Function3 r24, int r25, int r26, int r27, Composer r28, int r29) {
        return Scaffold_u4IkXBM$lambda$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27, r28, r29);
    }

    public static /* synthetic */ MeasureResult b(Function2 r0, Function2 r1, Function2 r2, int r3, boolean r4, WindowInsets r5, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 r6, Function2 r7, Function3 r8, SubcomposeMeasureScope r9, Constraints r10) {
        return ScaffoldLayout_i1QSOvI$lambda$24$lambda$23(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit c(Modifier r1, ScaffoldState r2, Function2 r3, Function2 r4, Function3 r5, Function2 r6, int r7, boolean r8, Function3 r9, boolean r10, Shape r11, float r12, long r13, long r15, long r17, long r19, long r21, Function3 r23, int r24, int r25, int r26, Composer r27, int r28) {
        return Scaffold_27mzLpw$lambda$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r19, r21, r23, r24, r25, r26, r27, r28);
    }

    public static /* synthetic */ Unit d(boolean r0, int r1, Function2 r2, Function3 r3, Function2 r4, Function2 r5, WindowInsets r6, Function2 r7, int r8, Composer r9, int r10) {
        return ScaffoldLayout_i1QSOvI$lambda$25(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit e(List r0, List r1, List r2, List r3, List r4, int r5, int r6, int r7, Integer r8, FabPlacement r9, Integer r10, Placeable.PlacementScope r11) {
        return ScaffoldLayout_i1QSOvI$lambda$24$lambda$23$lambda$22(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ FabPlacement f() {
        return LocalFabPlacement$lambda$26();
    }

    static {
        LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new y8());
        FabSpacing = Dp.constructor-impl(16);
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState r3, SnackbarHostState r4, Composer r5, int r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, r5, 6, 2);
    L6:
        if ((r7 & 2) == 0) goto L12;
        Object r8 = r5.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L10;
        r8 = new SnackbarHostState();
        r5.updateRememberedValue(r8);
    L10:
        r4 = (SnackbarHostState) r8;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1569641925, r6, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:73)");
    L14:
        Object r9 = r5.rememberedValue();
        if (r9 != Composer.Companion.getEmpty()) goto L17;
        r9 = new ScaffoldState(r3, r4);
        r5.updateRememberedValue(r9);
    L17:
        ScaffoldState r10 = (ScaffoldState) r9;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r10;
    }

    /* JADX INFO: renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    private static final void m2145ScaffoldLayouti1QSOvI(final boolean r20, final int r21, final Function2<? super Composer, ? super Integer, Unit> r22, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r23, final Function2<? super Composer, ? super Integer, Unit> r24, final Function2<? super Composer, ? super Integer, Unit> r25, final WindowInsets r26, final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29) {
        Composer r1 = r28.startRestartGroup(675142332);
        if ((r29 & 6) == 0) goto L5;
        int r4 = r29;
    L11:
        if ((r29 & 48) != 0) goto L19;
        if (r1.changed(r21) == false) goto L15;
        int r7 = 32;
    L16:
        r4 = r4 | r7;
        goto L19
    L15:
        r7 = 16;
    L19:
        if ((r29 & 384) != 0) goto L27;
        if (r1.changedInstance(r22) == false) goto L23;
        int r10 = 256;
    L24:
        r4 = r4 | r10;
        goto L27
    L23:
        r10 = 128;
    L27:
        if ((r29 & 3072) != 0) goto L34;
        if (r1.changedInstance(r23) == false) goto L31;
        int r11 = 2048;
    L32:
        r4 = r4 | r11;
        goto L34
    L31:
        r11 = 1024;
    L34:
        if ((r29 & 24576) != 0) goto L41;
        if (r1.changedInstance(r24) == false) goto L38;
        int r12 = 16384;
    L39:
        r4 = r4 | r12;
        goto L41
    L38:
        r12 = 8192;
    L41:
        if ((196608 & r29) != 0) goto L49;
        if (r1.changedInstance(r25) == false) goto L45;
        int r16 = 131072;
    L46:
        r4 = r4 | r16;
        goto L49
    L45:
        r16 = 65536;
    L49:
        if ((r29 & 1572864) != 0) goto L56;
        if (r1.changed(r26) == false) goto L53;
        int r17 = 1048576;
    L54:
        r4 = r4 | r17;
        goto L56
    L53:
        r17 = 524288;
    L56:
        if ((r29 & 12582912) != 0) goto L63;
        if (r1.changedInstance(r27) == false) goto L60;
        int r19 = 8388608;
    L61:
        r4 = r4 | r19;
        goto L63
    L60:
        r19 = 4194304;
    L63:
        if ((r4 & 4793491) == 4793490) goto L65;
        boolean r13 = true;
    L67:
        if (r1.shouldExecute(r13, r4 & 1) == true) goto L69;
        r1.skipToGroupEnd();
    L117:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L121;
        r14.updateScope(new v8(r20, r21, r22, r23, r24, r25, r26, r27, r29));
        return;
    L121:
        return;
    L69:
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventStart(675142332, r4, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:376)");
    L71:
        Object r0 = r1.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r0 != r15.getEmpty()) goto L74;
        r0 = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
        r1.updateRememberedValue(r0);
    L74:
        final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 r2 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) r0;
        if ((r4 & 896) != 256) goto L77;
        boolean r18 = true;
    L79:
        if ((57344 & r4) != 16384) goto L81;
        boolean r8 = true;
    L82:
        boolean r9 = r8 | r18;
        if ((3670016 & r4) != 1048576) goto L85;
        boolean r110 = true;
    L86:
        boolean r30 = r9 | r110;
        if ((458752 & r4) != 131072) goto L89;
        boolean r111 = true;
    L90:
        boolean r31 = r30 | r111;
        if ((r4 & 112) != 32) goto L93;
        boolean r112 = true;
    L94:
        boolean r32 = r31 | r112;
        if ((r4 & 14) != 4) goto L97;
        boolean r113 = true;
    L98:
        boolean r33 = r32 | r113;
        if ((29360128 & r4) != 8388608) goto L101;
        boolean r114 = true;
    L102:
        boolean r34 = r33 | r114;
        if ((r4 & 7168) != 2048) goto L105;
        boolean r5 = true;
    L106:
        boolean r6 = r5 | r34;
        Object r35 = r1.rememberedValue();
        if (r6 == false) goto L109;
    L112:
        int r36 = 0;
        r35 = new u8(r22, r24, r25, r21, r20, r26, r2, r27, r23);
        r1.updateRememberedValue(r35);
    L113:
        SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) r35, r1, r36, 1);
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
        goto L117
    L109:
        if (r35 == r15.getEmpty()) goto L112;
        r36 = 0;
        goto L113
    L105:
        r5 = false;
        goto L106
    L101:
        r114 = false;
        goto L102
    L97:
        r113 = false;
        goto L98
    L93:
        r112 = false;
        goto L94
    L89:
        r111 = false;
        goto L90
    L85:
        r110 = false;
        goto L86
    L81:
        r8 = false;
        goto L82
    L77:
        r18 = false;
        goto L79
    L65:
        r13 = false;
        goto L67
    L5:
        if (r1.changed(r20) == false) goto L7;
        int r37 = 4;
    L8:
        r4 = r37 | r29;
        goto L11
    L7:
        r37 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final /* synthetic */ void m2146access$ScaffoldLayouti1QSOvI(boolean r0, int r1, Function2 r2, Function3 r3, Function2 r4, Function2 r5, WindowInsets r6, Function2 r7, Composer r8, int r9) {
        m2145ScaffoldLayouti1QSOvI(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private static final MeasureResult ScaffoldLayout_i1QSOvI$lambda$24$lambda$23(Function2 r25, Function2 r26, Function2 r27, int r28, boolean r29, WindowInsets r30, final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 r31, final Function2 r32, final Function3 r33, SubcomposeMeasureScope r34, Constraints r35) {
        int r5 = Constraints.getMaxWidth-impl(r35.unbox-impl());
        int r6 = Constraints.getMaxHeight-impl(r35.unbox-impl());
        long r7 = Constraints.copy-Zbe2FdA$default(r35.unbox-impl(), 0, 0, 0, 0, 10, null);
        List r9 = r34.subcompose(ScaffoldLayoutContent.TopBar, r25);
        final ArrayList r10 = new ArrayList(r9.size());
        int r11 = r9.size();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r10.add(((Measurable) ListProtector.get(r9, r13)).measure-BRTryo0(r7));
        r13 = r13 + 1;
        goto L3
    L6:
        if (r10.isEmpty() == false) goto L8;
        Object r12 = null;
    L16:
        Placeable r14 = (Placeable) r12;
        if (r14 == null) goto L19;
        int r15 = r14.getHeight();
    L20:
        List r16 = r34.subcompose(ScaffoldLayoutContent.Snackbar, r26);
        ArrayList r17 = new ArrayList(r16.size());
        int r18 = r16.size();
        int r19 = 0;
    L21:
        if (r19 >= r18) goto L23;
        Measurable r110 = (Measurable) ListProtector.get(r16, r19);
        List r210 = r16;
        int r20 = r30.getLeft(r34, r34.getLayoutDirection());
        int r111 = r18;
        r17.add(r110.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r7, (-r20) - r30.getRight(r34, r34.getLayoutDirection()), -r30.getBottom(r34))));
        r19 = r19 + 1;
        r16 = r210;
        r18 = r111;
        r15 = r15;
        r6 = r6;
        goto L21
    L23:
        final int r21 = r6;
        final int r112 = r15;
        if (r17.isEmpty() == false) goto L26;
        Object r22 = null;
    L35:
        Placeable r23 = (Placeable) r22;
        if (r23 == null) goto L38;
        int r8 = r23.getHeight();
    L39:
        List r24 = r34.subcompose(ScaffoldLayoutContent.Fab, r27);
        final ArrayList r113 = new ArrayList(r24.size());
        int r114 = r24.size();
        int r115 = 0;
    L40:
        if (r115 >= r114) goto L42;
        Measurable r116 = (Measurable) ListProtector.get(r24, r115);
        List r211 = r24;
        int r36 = r30.getLeft(r34, r34.getLayoutDirection());
        int r212 = r114;
        r113.add(r116.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(r7, (-r36) - r30.getRight(r34, r34.getLayoutDirection()), -r30.getBottom(r34))));
        r115 = r115 + 1;
        r24 = r211;
        r114 = r212;
        r17 = r17;
        goto L40
    L42:
        final ArrayList r117 = r17;
        if ((!r113.isEmpty()) == true) goto L45;
    L94:
        final FabPlacement r0 = null;
    L95:
        List r37 = r34.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-502652347, true, new ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1(r0, r32)));
        final ArrayList r118 = new ArrayList(r37.size());
        int r119 = r37.size();
        int r120 = 0;
    L96:
        if (r120 >= r119) goto L99;
        r118.add(((Measurable) ListProtector.get(r37, r120)).measure-BRTryo0(r7));
        r120 = r120 + 1;
        goto L96
    L99:
        if (r118.isEmpty() == false) goto L101;
        Object r121 = null;
    L110:
        Placeable r122 = (Placeable) r121;
        if (r122 == null) goto L113;
        Integer r123 = Integer.valueOf(r122.getHeight());
    L114:
        if (r0 == null) goto L122;
        if (r123 != null) goto L118;
        int r1 = r0.getHeight() + r34.roundToPx-0680j_4(FabSpacing);
        int r38 = r30.getBottom(r34);
    L121:
        Integer r2 = Integer.valueOf(r1 + r38);
    L123:
        if (r8 == 0) goto L130;
        if (r2 == null) goto L126;
        int r39 = r2.intValue();
    L129:
        int r40 = r8 + r39;
    L131:
        PaddingValues r3 = WindowInsetsKt.asPaddingValues(r30, r34);
        if (r10.isEmpty() == false) goto L134;
        float r124 = r3.mo901calculateTopPaddingD9Ej5fM();
    L136:
        if (r118.isEmpty() == true) goto L140;
        if (r123 == null) goto L140;
        float r125 = r34.toDp-u2uoSUM(r123.intValue());
    L141:
        r31.setPaddingHolder(PaddingKt.m956PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(r3, r34.getLayoutDirection()), r124, PaddingKt.calculateEndPadding(r3, r34.getLayoutDirection()), r125));
        int r4 = r21 - r112;
        List r41 = r34.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-574531306, true, new ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1(r33, r31)));
        final ArrayList r42 = new ArrayList(r41.size());
        int r126 = r41.size();
        int r127 = 0;
    L142:
        if (r127 >= r126) goto L144;
        r42.add(((Measurable) ListProtector.get(r41, r127)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r7, 0, 0, 0, r4, 7, null)));
        r127 = r127 + 1;
        r41 = r41;
        r4 = r4;
        goto L142
    L144:
        final int r128 = r40;
        final Integer r129 = r123;
        final FabPlacement r130 = r0;
        final Integer r131 = r2;
        return MeasureScope.-CC.layout$default(r34, r5, r21, null, new z8(r42, r10, r117, r118, r113, r112, r21, r128, r129, r130, r131), 4, null);
    L140:
        r125 = r3.mo898calculateBottomPaddingD9Ej5fM();
        goto L141
    L134:
        r124 = Dp.constructor-impl(0);
        goto L136
    L126:
        if (r123 == null) goto L128;
        r39 = r123.intValue();
        goto L129
    L128:
        r39 = r30.getBottom(r34);
        goto L129
    L130:
        r40 = 0;
        goto L131
    L118:
        if (r29 == false) goto L120;
        r1 = r123.intValue();
        r38 = r0.getHeight() / 2;
        goto L121
    L120:
        r1 = r123.intValue() + r0.getHeight();
        r38 = r34.roundToPx-0680j_4(FabSpacing);
        goto L121
    L122:
        r2 = null;
        goto L123
    L113:
        r123 = null;
        goto L114
    L101:
        r121 = ListProtector.get(r118, 0);
        int r43 = ((Placeable) r121).getHeight();
        int r132 = CollectionsKt.getLastIndex(r118);
        if (1 > r132) goto L110;
        int r133 = 1;
    L104:
        Object r134 = ListProtector.get(r118, r133);
        Object r213 = r121;
        int r135 = ((Placeable) r134).getHeight();
        if (r43 >= r135) goto L107;
        r43 = r135;
        r121 = r134;
    L108:
        if (r133 == r132) goto L110;
        r133 = r133 + 1;
        goto L104
    L107:
        r121 = r213;
        goto L108
    L45:
        if (r113.isEmpty() == false) goto L47;
        Object r136 = null;
    L56:
        Placeable r137 = (Placeable) r136;
        if (r137 == null) goto L59;
        int r44 = r137.getWidth();
    L61:
        if (r113.isEmpty() == false) goto L63;
        Object r138 = null;
    L73:
        Placeable r139 = (Placeable) r138;
        if (r139 == null) goto L76;
        int r140 = r139.getHeight();
    L77:
        if (r44 == 0) goto L94;
        if (r140 == 0) goto L94;
        FabPosition.Companion r141 = FabPosition.Companion;
        if (FabPosition.m2064equalsimpl0(r28, r141.m2070getStart5ygKITE()) == false) goto L87;
        if (r34.getLayoutDirection() != LayoutDirection.Ltr) goto L84;
        int r45 = r34.roundToPx-0680j_4(FabSpacing);
    L93:
        r0 = new FabPlacement(r29, r45, r44, r140);
        goto L95
    L84:
        int r46 = r34.roundToPx-0680j_4(FabSpacing);
    L85:
        r45 = (r5 - r46) - r44;
        goto L93
    L87:
        if (FabPosition.m2064equalsimpl0(r28, r141.m2069getEnd5ygKITE()) == true) goto L89;
        r45 = (r5 - r44) / 2;
        goto L93
    L89:
        if (r34.getLayoutDirection() != LayoutDirection.Ltr) goto L91;
        r46 = r34.roundToPx-0680j_4(FabSpacing);
        goto L85
    L91:
        r45 = r34.roundToPx-0680j_4(FabSpacing);
        goto L93
    L76:
        r140 = 0;
        goto L77
    L63:
        r138 = ListProtector.get(r113, 0);
        int r142 = ((Placeable) r138).getHeight();
        int r143 = CollectionsKt.getLastIndex(r113);
        if (1 > r143) goto L73;
        Object r144 = r138;
        int r145 = r142;
        int r146 = 1;
    L66:
        Object r147 = ListProtector.get(r113, r146);
        Object r214 = r144;
        int r148 = ((Placeable) r147).getHeight();
        if (r145 >= r148) goto L69;
        r145 = r148;
        r144 = r147;
    L70:
        if (r146 == r143) goto L72;
        r146 = r146 + 1;
        goto L66
    L72:
        r138 = r144;
        goto L73
    L69:
        r144 = r214;
        goto L70
    L59:
        r44 = 0;
        goto L61
    L47:
        r136 = ListProtector.get(r113, 0);
        int r47 = ((Placeable) r136).getWidth();
        int r149 = CollectionsKt.getLastIndex(r113);
        if (1 > r149) goto L56;
        int r150 = r47;
        int r48 = 1;
    L50:
        Object r151 = ListProtector.get(r113, r48);
        Object r215 = r136;
        int r152 = ((Placeable) r151).getWidth();
        if (r150 >= r152) goto L53;
        r150 = r152;
        r136 = r151;
    L54:
        if (r48 == r149) goto L56;
        r48 = r48 + 1;
        goto L50
    L53:
        r136 = r215;
        goto L54
    L38:
        r8 = 0;
        goto L39
    L26:
        r22 = ListProtector.get(r17, 0);
        int r49 = ((Placeable) r22).getHeight();
        int r153 = CollectionsKt.getLastIndex(r17);
        if (1 > r153) goto L35;
        Object r154 = r22;
        int r50 = r49;
        int r51 = 1;
    L29:
        Object r155 = ListProtector.get(r17, r51);
        int r156 = ((Placeable) r155).getHeight();
        if (r50 >= r156) goto L32;
        r154 = r155;
        r50 = r156;
    L32:
        if (r51 == r153) goto L34;
        r51 = r51 + 1;
        goto L29
    L34:
        r22 = r154;
        goto L35
    L19:
        r15 = 0;
        goto L20
    L8:
        r12 = ListProtector.get(r10, 0);
        int r157 = ((Placeable) r12).getHeight();
        int r158 = CollectionsKt.getLastIndex(r10);
        if (1 > r158) goto L16;
        int r159 = 1;
    L11:
        Object r160 = ListProtector.get(r10, r159);
        int r161 = ((Placeable) r160).getHeight();
        if (r157 >= r161) goto L14;
        r157 = r161;
        r12 = r160;
    L14:
        if (r159 == r158) goto L16;
        r159 = r159 + 1;
        goto L11
    }

    private static final Unit ScaffoldLayout_i1QSOvI$lambda$24$lambda$23$lambda$22(List r16, List r17, List r18, List r19, List r20, int r21, int r22, int r23, Integer r24, FabPlacement r25, Integer r26, Placeable.PlacementScope r27) {
        int r5 = r16.size();
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L5;
        Placeable.PlacementScope.place$default(r27, (Placeable) ListProtector.get(r16, r7), 0, r21, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r7 = r7 + 1;
        goto L3
    L5:
        int r0 = r17.size();
        int r6 = 0;
    L6:
        if (r6 >= r0) goto L8;
        Placeable.PlacementScope.place$default(r27, (Placeable) ListProtector.get(r17, r6), 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r6 = r6 + 1;
        goto L6
    L8:
        int r1 = r18.size();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        Placeable.PlacementScope.place$default(r27, (Placeable) ListProtector.get(r18, r2), 0, r22 - r23, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r2 = r2 + 1;
        goto L9
    L11:
        int r3 = r19.size();
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L18;
        Placeable r8 = (Placeable) ListProtector.get(r19, r4);
        if (r24 == null) goto L16;
        int r9 = r24.intValue();
    L17:
        Placeable.PlacementScope.place$default(r27, r8, 0, r22 - r9, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r4 = r4 + 1;
        goto L12
    L16:
        r9 = 0;
        goto L17
    L18:
        int r10 = r20.size();
        int r11 = 0;
    L19:
        if (r11 >= r10) goto L29;
        Placeable r12 = (Placeable) ListProtector.get(r20, r11);
        if (r25 == null) goto L23;
        int r13 = r25.getLeft();
    L24:
        if (r26 == null) goto L26;
        int r14 = r26.intValue();
    L27:
        Placeable.PlacementScope.place$default(r27, r12, r13, r22 - r14, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r11 = r11 + 1;
        goto L19
    L26:
        r14 = 0;
        goto L27
    L23:
        r13 = 0;
        goto L24
    L29:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    public static final void m2143Scaffold27mzLpw(Modifier r58, ScaffoldState r59, Function2<? super Composer, ? super Integer, Unit> r60, Function2<? super Composer, ? super Integer, Unit> r61, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r62, Function2<? super Composer, ? super Integer, Unit> r63, int r64, boolean r65, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r66, boolean r67, Shape r68, float r69, long r70, long r72, long r74, long r76, long r78, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r80, Composer r81, final int r82, final int r83, final int r84) {
        Composer r0 = r81.startRestartGroup(1135600301);
        int r1 = r84 & 1;
        if (r1 == 0) goto L6;
        int r5 = r82 | 6;
    L14:
        if ((r82 & 48) != 0) goto L24;
        if ((r84 & 2) != 0) goto L21;
        if (r0.changed(r59) == false) goto L21;
        int r9 = 32;
    L22:
        r5 = r5 | r9;
    L21:
        r9 = 16;
    L24:
        int r10 = r84 & 4;
        if (r10 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r12 = r60;
    L35:
        int r16 = r84 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L46:
        int r19 = r84 & 16;
        int r20 = 16384;
        if (r19 == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r23 = r84 & 32;
        if (r23 == 0) goto L61;
        r5 = r5 | 196608;
    L67:
        int r28 = r84 & 64;
        if (r28 == 0) goto L71;
        r5 = r5 | 1572864;
    L77:
        int r11 = r84 & 128;
        if (r11 == 0) goto L80;
        r5 = r5 | 12582912;
        boolean r13 = r65;
    L87:
        int r2 = r84 & 256;
        if (r2 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r3 = r84 & 512;
        if (r3 == 0) goto L101;
        r5 = r5 | 805306368;
    L108:
        if ((r83 & 6) == 0) goto L110;
        int r22 = r83;
    L118:
        int r4 = r84 & 2048;
        if (r4 == 0) goto L122;
        r22 = r22 | 48;
    L129:
        if ((r83 & 384) != 0) goto L140;
        if ((r84 & 4096) != 0) goto L136;
        if (r0.changed(r70) == false) goto L136;
        int r31 = 256;
    L137:
        r22 = r22 | r31;
    L136:
        r31 = 128;
    L140:
        if ((r83 & 3072) != 0) goto L151;
        if ((r84 & 8192) != 0) goto L147;
        if (r0.changed(r72) == false) goto L147;
    L148:
        r22 = r22 | r17;
    L147:
        r17 = 1024;
    L151:
        if ((r83 & 24576) != 0) goto L162;
        if ((r84 & 16384) != 0) goto L158;
        if (r0.changed(r74) == false) goto L158;
    L159:
        r22 = r22 | r20;
    L158:
        r20 = 8192;
    L162:
        if ((r83 & 196608) != 0) goto L172;
        if ((r84 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        int r18 = 65536;
    L169:
        r22 = r22 | r18;
        goto L172
    L166:
        if (r0.changed(r76) == false) goto L168;
        r18 = 131072;
    L172:
        if ((r83 & 1572864) != 0) goto L182;
        if ((r84 & 65536) == 0) goto L176;
    L178:
        int r110 = 524288;
    L179:
        r22 = r22 | r110;
        goto L182
    L176:
        if (r0.changed(r78) == false) goto L178;
        r110 = 1048576;
    L182:
        if ((r84 & 131072) == 0) goto L185;
        r22 = r22 | 12582912;
    L191:
        boolean r111 = true;
        if ((r5 & 306783379) == 306783378) goto L194;
    L197:
        boolean r6 = true;
    L199:
        if (r0.shouldExecute(r6, r5 & 1) == false) goto L294;
        r0.startDefaults();
        if ((r82 & 1) != 0) goto L203;
    L227:
        if (r1 == 0) goto L229;
        Modifier r7 = Modifier.Companion;
    L231:
        if ((r84 & 2) == 0) goto L233;
        final ScaffoldState r8 = rememberScaffoldState(null, null, r0, 0, 3);
        r5 = r5 & (-113);
    L234:
        if (r10 == 0) goto L236;
        Function2<? super Composer, ? super Integer, Unit> r14 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$566090785$material();
    L237:
        if (r16 == 0) goto L239;
        Function2<? super Composer, ? super Integer, Unit> r15 = ComposableSingletons$ScaffoldKt.INSTANCE.m2025getLambda$1624772335$material();
    L240:
        if (r19 == 0) goto L242;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r21 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$939725476$material();
    L243:
        if (r23 == 0) goto L245;
        Function2<? super Composer, ? super Integer, Unit> r112 = ComposableSingletons$ScaffoldKt.INSTANCE.m2023getLambda$1341284559$material();
    L246:
        if (r28 == 0) goto L248;
        int r113 = FabPosition.Companion.m2069getEnd5ygKITE();
    L249:
        if (r11 == 0) goto L251;
        r13 = false;
    L251:
        if (r2 == 0) goto L253;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r24 = null;
    L254:
        if (r3 != 0) goto L258;
        r111 = r67;
    L258:
        if ((r84 & 1024) == 0) goto L260;
        Shape r25 = MaterialTheme.INSTANCE.getShapes(r0, 6).getLarge();
        r22 = r22 & (-15);
    L261:
        int r26 = r22;
        if (r4 == 0) goto L264;
        float r27 = DrawerDefaults.INSTANCE.m2039getElevationD9Ej5fM();
    L266:
        if ((r84 & 4096) == 0) goto L268;
        r26 = r26 & (-897);
        long r29 = MaterialTheme.INSTANCE.getColors(r0, 6).m2003getSurface0d7_KjU();
    L270:
        if ((r84 & 8192) == 0) goto L272;
        long r114 = ColorsKt.m2017contentColorForek8zF_U(r29, r0, (r26 >> 6) & 14);
        r26 = r26 & (-7169);
    L274:
        if ((r84 & 16384) == 0) goto L276;
        int r30 = 6;
        long r210 = DrawerDefaults.INSTANCE.getScrimColor(r0, 6);
        r26 = r26 & (-57345);
    L278:
        if ((32768 & r84) == 0) goto L280;
        long r32 = MaterialTheme.INSTANCE.getColors(r0, r30).m1992getBackground0d7_KjU();
        r26 = r26 & (-458753);
    L282:
        if ((r84 & 65536) == 0) goto L284;
        int r115 = r26 & (-3670017);
        long r52 = ColorsKt.m2017contentColorForek8zF_U(r32, r0, (r26 >> 15) & 14);
    L285:
        final Modifier r33 = r7;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r34 = r24;
        Shape r35 = r25;
        int r36 = r113;
    L286:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L290;
        ComposerKt.traceEventStart(1135600301, r5, r115, "androidx.compose.material.Scaffold (Scaffold.kt:321)");
    L290:
        int r37 = r5 << 3;
        float r510 = r27;
        int r41 = ((((((((r37 & 896) | (r37 & 112)) | (r37 & 7168)) | (57344 & r37)) | (458752 & r37)) | (3670016 & r37)) | (29360128 & r37)) | (234881024 & r37)) | (r37 & 1879048192);
        int r116 = r115 << 3;
        m2144Scaffoldu4IkXBM(WindowInsetsKt.m1045WindowInsetsa9UjIt4$default(Dp.constructor-impl(0), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r33, r8, r14, r15, r21, r112, r36, r13, r34, r111, r35, r510, r29, r114, r210, r32, r52, r80, r0, r41, (((((((((r5 >> 27) & 14) | (r116 & 112)) | (r116 & 896)) | (r116 & 7168)) | (57344 & r116)) | (458752 & r116)) | (3670016 & r116)) | (29360128 & r116)) | (r116 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L293;
        ComposerKt.traceEventEnd();
    L293:
        final boolean r117 = r111;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r38 = r21;
        final long r118 = r29;
        long r119 = r114;
        final long r120 = r210;
        final long r121 = r32;
        final long r211 = r52;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r39 = r34;
        final Function2<? super Composer, ? super Integer, Unit> r40 = r15;
        final int r42 = r36;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r112;
        final float r122 = r510;
        boolean r57 = r13;
        final Shape r123 = r35;
        final boolean r45 = r57;
    L295:
        ScopeUpdateScope r46 = r0.endRestartGroup();
        if (r46 == null) goto L299;
        final long r511 = r119;
        r46.updateScope(new x8(r33, r8, r43, r40, r38, r44, r42, r45, r39, r117, r123, r122, r118, r511, r120, r121, r211, r80, r82, r83, r84));
        return;
    L299:
        return;
    L284:
        r52 = r78;
        r115 = r26;
        goto L285
    L280:
        r32 = r76;
        goto L282
    L276:
        r30 = 6;
        r210 = r74;
        goto L278
    L272:
        r114 = r72;
        goto L274
    L268:
        r29 = r70;
        goto L270
    L264:
        r27 = r69;
        goto L266
    L260:
        r25 = r68;
        goto L261
    L253:
        r24 = r66;
        goto L254
    L248:
        r113 = r64;
        goto L249
    L245:
        r112 = r63;
        goto L246
    L242:
        r21 = r62;
        goto L243
    L239:
        r15 = r61;
        goto L240
    L236:
        r14 = r12;
        goto L237
    L233:
        r8 = r59;
        goto L234
    L229:
        r7 = r58;
        goto L231
    L203:
        if (r0.getDefaultsInvalid() == true) goto L227;
        r0.skipToGroupEnd();
        if ((r84 & 2) == 0) goto L209;
        r5 = r5 & (-113);
    L209:
        if ((r84 & 1024) == 0) goto L211;
        r22 = r22 & (-15);
    L211:
        int r47 = r22;
        if ((r84 & 4096) == 0) goto L215;
        r47 = r47 & (-897);
    L215:
        if ((r84 & 8192) == 0) goto L218;
        r47 = r47 & (-7169);
    L218:
        if ((r84 & 16384) == 0) goto L221;
        r47 = r47 & (-57345);
    L221:
        if ((32768 & r84) == 0) goto L224;
        r47 = r47 & (-458753);
    L224:
        if ((r84 & 65536) == 0) goto L226;
        r47 = r47 & (-3670017);
    L226:
        r8 = r59;
        r15 = r61;
        r21 = r62;
        r36 = r64;
        r34 = r66;
        r35 = r68;
        r27 = r69;
        r29 = r70;
        r114 = r72;
        r210 = r74;
        r32 = r76;
        r52 = r78;
        r115 = r47;
        r5 = r5;
        r14 = r12;
        r33 = r58;
        r112 = r63;
        r111 = r67;
        goto L286
    L294:
        r0 = r0;
        r0.skipToGroupEnd();
        r33 = r58;
        r8 = r59;
        r40 = r61;
        r38 = r62;
        r44 = r63;
        r42 = r64;
        r39 = r66;
        r117 = r67;
        r118 = r70;
        r119 = r72;
        r120 = r74;
        r121 = r76;
        r211 = r78;
        r45 = r13;
        r43 = r12;
        r123 = r68;
        r122 = r69;
        goto L295
    L194:
        if ((r22 & 4793491) != 4793490) goto L197;
        r6 = false;
        goto L199
    L185:
        if ((r83 & 12582912) != 0) goto L191;
        if (r0.changedInstance(r80) == false) goto L189;
        int r124 = 8388608;
    L190:
        r22 = r22 | r124;
        goto L191
    L189:
        r124 = 4194304;
        goto L190
    L122:
        if ((r83 & 48) != 0) goto L129;
        if (r0.changed(r69) == false) goto L126;
        int r212 = 32;
    L127:
        r22 = r22 | r212;
        goto L129
    L126:
        r212 = 16;
        goto L127
    L110:
        if ((r84 & 1024) != 0) goto L115;
        if (r0.changed(r68) == false) goto L115;
        int r213 = 4;
    L116:
        r22 = r83 | r213;
    L115:
        r213 = 2;
        goto L116
    L101:
        if ((r82 & 805306368) != 0) goto L108;
        if (r0.changed(r67) == false) goto L105;
        int r310 = 536870912;
    L106:
        r5 = r5 | r310;
        goto L108
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r82 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r66) == false) goto L95;
        int r311 = 67108864;
    L96:
        r5 = r5 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L80:
        r13 = r65;
        if ((r82 & 12582912) != 0) goto L87;
        if (r0.changed(r13) == false) goto L85;
        int r312 = 8388608;
    L86:
        r5 = r5 | r312;
        goto L87
    L85:
        r312 = 4194304;
        goto L86
    L71:
        if ((r82 & 1572864) != 0) goto L77;
        if (r0.changed(r64) == false) goto L75;
        int r313 = 1048576;
    L76:
        r5 = r5 | r313;
        goto L77
    L75:
        r313 = 524288;
        goto L76
    L61:
        if ((r82 & 196608) != 0) goto L67;
        if (r0.changedInstance(r63) == false) goto L65;
        int r214 = 131072;
    L66:
        r5 = r5 | r214;
        goto L67
    L65:
        r214 = 65536;
        goto L66
    L50:
        if ((r82 & 24576) != 0) goto L57;
        if (r0.changedInstance(r62) == false) goto L54;
        int r215 = 16384;
    L55:
        r5 = r5 | r215;
        goto L57
    L54:
        r215 = 8192;
        goto L55
    L39:
        if ((r82 & 3072) != 0) goto L46;
        if (r0.changedInstance(r61) == false) goto L43;
        int r125 = 2048;
    L44:
        r5 = r5 | r125;
        goto L46
    L43:
        r125 = 1024;
        goto L44
    L28:
        if ((r82 & 384) != 0) goto L34;
        r12 = r60;
        if (r0.changedInstance(r12) == false) goto L32;
        int r126 = 256;
    L33:
        r5 = r5 | r126;
        goto L35
    L32:
        r126 = 128;
        goto L33
    L6:
        if ((r82 & 6) == 0) goto L8;
        r5 = r82;
        goto L14
    L8:
        if (r0.changed(r58) == false) goto L10;
        int r48 = 4;
    L11:
        r5 = r48 | r82;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    public static final void m2144Scaffoldu4IkXBM(final WindowInsets r37, Modifier r38, ScaffoldState r39, Function2<? super Composer, ? super Integer, Unit> r40, Function2<? super Composer, ? super Integer, Unit> r41, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r42, Function2<? super Composer, ? super Integer, Unit> r43, int r44, boolean r45, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r46, boolean r47, Shape r48, float r49, long r50, long r52, long r54, long r56, long r58, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r60, Composer r61, final int r62, final int r63, final int r64) {
        Composer r0 = r61.startRestartGroup(50073903);
        if ((r64 & 1) == 0) goto L6;
        int r2 = r62 | 6;
    L13:
        int r5 = r64 & 2;
        if (r5 == 0) goto L17;
        r2 = r2 | 48;
    L25:
        if ((r62 & 384) != 0) goto L35;
        if ((r64 & 4) != 0) goto L32;
        if (r0.changed(r39) == false) goto L32;
        int r12 = 256;
    L33:
        r2 = r2 | r12;
    L32:
        r12 = 128;
    L35:
        int r13 = r64 & 8;
        int r16 = 1024;
        if (r13 == 0) goto L39;
        r2 = r2 | 3072;
    L46:
        int r18 = r64 & 16;
        int r19 = 16384;
        if (r18 == 0) goto L50;
        r2 = r2 | 24576;
    L57:
        int r22 = r64 & 32;
        if (r22 == 0) goto L61;
        r2 = r2 | 196608;
    L67:
        int r27 = r64 & 64;
        if (r27 == 0) goto L71;
        r2 = r2 | 1572864;
    L77:
        int r11 = r64 & 128;
        if (r11 == 0) goto L81;
        r2 = r2 | 12582912;
    L87:
        int r3 = r64 & 256;
        if (r3 == 0) goto L91;
        r2 = r2 | 100663296;
    L97:
        int r4 = r64 & 512;
        if (r4 == 0) goto L101;
        r2 = r2 | 805306368;
    L107:
        int r6 = r64 & 1024;
        if (r6 == 0) goto L111;
        int r32 = r63 | 6;
    L119:
        if ((r63 & 48) != 0) goto L129;
        if ((r64 & 2048) != 0) goto L126;
        if (r0.changed(r48) == false) goto L126;
        int r21 = 32;
    L127:
        r32 = r32 | r21;
    L126:
        r21 = 16;
    L129:
        int r7 = r32;
        int r8 = r64 & 4096;
        if (r8 == 0) goto L133;
        r7 = r7 | 384;
    L141:
        if ((r63 & 3072) != 0) goto L151;
        if ((r64 & 8192) != 0) goto L148;
        if (r0.changed(r50) == false) goto L148;
        r16 = 2048;
    L148:
        r7 = r7 | r16;
    L151:
        if ((r63 & 24576) != 0) goto L162;
        if ((r64 & 16384) != 0) goto L158;
        if (r0.changed(r52) == false) goto L158;
    L159:
        r7 = r7 | r19;
    L158:
        r19 = 8192;
    L162:
        if ((r63 & 196608) != 0) goto L172;
        if ((r64 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        int r17 = 65536;
    L169:
        r7 = r7 | r17;
        goto L172
    L166:
        if (r0.changed(r54) == false) goto L168;
        r17 = 131072;
    L172:
        if ((r63 & 1572864) != 0) goto L182;
        if ((r64 & 65536) == 0) goto L176;
    L178:
        int r110 = 524288;
    L179:
        r7 = r7 | r110;
        goto L182
    L176:
        if (r0.changed(r56) == false) goto L178;
        r110 = 1048576;
    L182:
        if ((r63 & 12582912) != 0) goto L192;
        if ((r64 & 131072) == 0) goto L186;
    L188:
        int r111 = 4194304;
    L189:
        r7 = r7 | r111;
        goto L192
    L186:
        if (r0.changed(r58) == false) goto L188;
        r111 = 8388608;
    L192:
        if ((r64 & 262144) == 0) goto L195;
        r7 = r7 | 100663296;
    L202:
        if ((r2 & 306783379) == 306783378) goto L204;
    L207:
        boolean r9 = true;
    L209:
        if (r0.shouldExecute(r9, r2 & 1) == false) goto L316;
        r0.startDefaults();
        if ((r62 & 1) != 0) goto L213;
    L237:
        if (r5 == 0) goto L239;
        Modifier r10 = Modifier.Companion;
    L241:
        if ((r64 & 4) == 0) goto L243;
        ScaffoldState r14 = rememberScaffoldState(null, null, r0, 0, 3);
        r2 = r2 & (-897);
    L244:
        if (r13 == 0) goto L246;
        Function2<? super Composer, ? super Integer, Unit> r15 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$866784315$material();
    L247:
        if (r18 == 0) goto L249;
        Function2<? super Composer, ? super Integer, Unit> r112 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1714259275$material();
    L250:
        if (r22 == 0) goto L252;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r113 = ComposableSingletons$ScaffoldKt.INSTANCE.m2026getLambda$1836397928$material();
    L253:
        if (r27 == 0) goto L255;
        Function2<? super Composer, ? super Integer, Unit> r114 = ComposableSingletons$ScaffoldKt.INSTANCE.m2024getLambda$1406416085$material();
    L256:
        if (r11 == 0) goto L258;
        int r115 = FabPosition.Companion.m2069getEnd5ygKITE();
    L259:
        if (r3 == 0) goto L261;
        boolean r20 = false;
    L262:
        if (r4 == 0) goto L264;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r23 = null;
    L265:
        if (r6 == 0) goto L267;
        boolean r24 = true;
    L268:
        int r310 = r2;
        if ((r64 & 2048) == 0) goto L271;
        Shape r25 = MaterialTheme.INSTANCE.getShapes(r0, 6).getLarge();
        r7 = r7 & (-113);
    L272:
        if (r8 == 0) goto L274;
        float r26 = DrawerDefaults.INSTANCE.m2039getElevationD9Ej5fM();
    L276:
        if ((r64 & 8192) == 0) goto L278;
        long r28 = MaterialTheme.INSTANCE.getColors(r0, 6).m2003getSurface0d7_KjU();
        r7 = r7 & (-7169);
    L279:
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r410 = r23;
        if ((r64 & 16384) == 0) goto L282;
        long r116 = ColorsKt.m2017contentColorForek8zF_U(r28, r0, (r7 >> 9) & 14);
        r7 = r7 & (-57345);
    L284:
        if ((32768 & r64) == 0) goto L286;
        int r29 = 6;
        long r30 = DrawerDefaults.INSTANCE.getScrimColor(r0, 6);
        r7 = r7 & (-458753);
    L287:
        long r411 = r30;
        if ((r64 & 65536) == 0) goto L290;
        long r31 = MaterialTheme.INSTANCE.getColors(r0, r29).m1992getBackground0d7_KjU();
        r7 = (-3670017) & r7;
    L292:
        if ((r64 & 131072) == 0) goto L294;
        long r210 = ColorsKt.m2017contentColorForek8zF_U(r31, r0, (r7 >> 18) & 14);
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r33 = r410;
        long r211 = r31;
        int r117 = r7 & (-29360129);
        long r212 = r210;
        final Modifier r34 = r10;
        int r35 = r310;
        boolean r36 = r20;
        long r213 = r411;
    L295:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L300;
        ComposerKt.traceEventStart(50073903, r35, r117, "androidx.compose.material.Scaffold (Scaffold.kt:196)");
    L300:
        if ((r35 & 14) != 4) goto L302;
        boolean r51 = true;
    L303:
        Object r118 = r0.rememberedValue();
        if (r51 == false) goto L306;
    L307:
        r118 = new MutableWindowInsets(r37);
        r0.updateRememberedValue(r118);
    L308:
        boolean r55 = r36;
        final ComposableLambda r1 = ComposableLambdaKt.rememberComposableLambda(-1236753028, true, new ScaffoldKt$Scaffold$child$1((MutableWindowInsets) r118, r37, r211, r212, r36, r115, r15, r60, r114, r112, r113, r14), r0, 54);
        if (r33 == null) goto L311;
        r0.startReplaceGroup(1400260027);
        int r53 = (((r35 >> 27) & 14) | 805306368) | (r35 & 112);
        int r57 = r117 << 9;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r311 = r33;
        Modifier r312 = r34;
        boolean r412 = r24;
        Shape r413 = r25;
        float r414 = r26;
        long r415 = r28;
        long r416 = r116;
        long r417 = r213;
        DrawerKt.m2042ModalDrawerGs3lGvM(r311, r312, r14.getDrawerState(), r412, r413, r414, r415, r416, r417, ComposableLambdaKt.rememberComposableLambda(-1888468172, true, new ScaffoldKt$Scaffold$1(r1), r0, 54), r0, (((((r53 | (r57 & 7168)) | (57344 & r57)) | (458752 & r57)) | (3670016 & r57)) | (29360128 & r57)) | (r57 & 234881024), 0);
        r0.endReplaceGroup();
    L313:
        if (ComposerKt.isTraceInProgress() == false) goto L315;
        ComposerKt.traceEventEnd();
    L315:
        final float r119 = r26;
        final boolean r59 = r55;
        final ScaffoldState r65 = r14;
        final int r66 = r115;
        final Function2<? super Composer, ? super Integer, Unit> r67 = r114;
        final long r120 = r116;
        final long r121 = r213;
        final long r214 = r212;
        final boolean r122 = r24;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r68 = r113;
        final long r123 = r28;
        final long r215 = r211;
        Function2<? super Composer, ? super Integer, Unit> r313 = r15;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r124 = r33;
        final Function2<? super Composer, ? super Integer, Unit> r69 = r313;
        Function2<? super Composer, ? super Integer, Unit> r314 = r112;
        final Shape r125 = r25;
        final Function2<? super Composer, ? super Integer, Unit> r70 = r314;
    L317:
        ScopeUpdateScope r71 = r0.endRestartGroup();
        if (r71 == null) goto L321;
        r71.updateScope(new w8(r37, r34, r65, r69, r70, r68, r67, r66, r59, r124, r122, r125, r119, r123, r120, r121, r215, r214, r60, r62, r63, r64));
        return;
    L321:
        return;
    L311:
        r0.startReplaceGroup(1400751284);
        r1.invoke(r34, r0, Integer.valueOf(((r35 >> 3) & 14) | 48));
        r0.endReplaceGroup();
        goto L313
    L306:
        if (r118 != Composer.Companion.getEmpty()) goto L308;
    L302:
        r51 = false;
        goto L303
    L294:
        r33 = r410;
        r213 = r411;
        r212 = r58;
        r211 = r31;
        r117 = r7;
        r34 = r10;
        r35 = r310;
        r36 = r20;
        goto L295
    L290:
        r31 = r56;
        goto L292
    L286:
        r29 = 6;
        r30 = r54;
        goto L287
    L282:
        r116 = r52;
        goto L284
    L278:
        r28 = r50;
        goto L279
    L274:
        r26 = r49;
        goto L276
    L271:
        r25 = r48;
        goto L272
    L267:
        r24 = r47;
        goto L268
    L264:
        r23 = r46;
        goto L265
    L261:
        r20 = r45;
        goto L262
    L258:
        r115 = r44;
        goto L259
    L255:
        r114 = r43;
        goto L256
    L252:
        r113 = r42;
        goto L253
    L249:
        r112 = r41;
        goto L250
    L246:
        r15 = r40;
        goto L247
    L243:
        r14 = r39;
        goto L244
    L239:
        r10 = r38;
        goto L241
    L213:
        if (r0.getDefaultsInvalid() == true) goto L237;
        r0.skipToGroupEnd();
        if ((r64 & 4) == 0) goto L219;
        r2 = r2 & (-897);
    L219:
        if ((r64 & 2048) == 0) goto L222;
        r7 = r7 & (-113);
    L222:
        if ((r64 & 8192) == 0) goto L225;
        r7 = r7 & (-7169);
    L225:
        if ((r64 & 16384) == 0) goto L228;
        r7 = r7 & (-57345);
    L228:
        if ((32768 & r64) == 0) goto L231;
        r7 = r7 & (-458753);
    L231:
        if ((r64 & 65536) == 0) goto L234;
        r7 = r7 & (-3670017);
    L234:
        if ((r64 & 131072) == 0) goto L236;
        r7 = r7 & (-29360129);
    L236:
        r14 = r39;
        r15 = r40;
        r112 = r41;
        r113 = r42;
        r114 = r43;
        r115 = r44;
        r36 = r45;
        r33 = r46;
        r24 = r47;
        r25 = r48;
        r26 = r49;
        r28 = r50;
        r116 = r52;
        r213 = r54;
        r211 = r56;
        r212 = r58;
        r117 = r7;
        r35 = r2;
        r34 = r38;
        goto L295
    L316:
        r0.skipToGroupEnd();
        r34 = r38;
        r65 = r39;
        r69 = r40;
        r70 = r41;
        r68 = r42;
        r67 = r43;
        r66 = r44;
        r59 = r45;
        r124 = r46;
        r122 = r47;
        r125 = r48;
        r119 = r49;
        r123 = r50;
        r120 = r52;
        r121 = r54;
        r215 = r56;
        r214 = r58;
        goto L317
    L204:
        if ((38347923 & r7) != 38347922) goto L207;
        r9 = false;
        goto L209
    L195:
        if ((r63 & 100663296) != 0) goto L202;
        if (r0.changedInstance(r60) == false) goto L199;
        int r126 = 67108864;
    L200:
        r7 = r7 | r126;
        goto L202
    L199:
        r126 = 33554432;
        goto L200
    L133:
        if ((r63 & 384) != 0) goto L141;
        if (r0.changed(r49) == false) goto L137;
        int r216 = 256;
    L138:
        r7 = r7 | r216;
        goto L141
    L137:
        r216 = 128;
        goto L138
    L111:
        if ((r63 & 6) == 0) goto L113;
        r32 = r63;
        goto L119
    L113:
        if (r0.changed(r47) == false) goto L115;
        int r315 = 4;
    L116:
        r32 = r63 | r315;
        goto L119
    L115:
        r315 = 2;
        goto L116
    L101:
        if ((r62 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r46) == false) goto L105;
        int r316 = 536870912;
    L106:
        r2 = r2 | r316;
        goto L107
    L105:
        r316 = 268435456;
        goto L106
    L91:
        if ((r62 & 100663296) != 0) goto L97;
        if (r0.changed(r45) == false) goto L95;
        int r317 = 67108864;
    L96:
        r2 = r2 | r317;
        goto L97
    L95:
        r317 = 33554432;
        goto L96
    L81:
        if ((r62 & 12582912) != 0) goto L87;
        if (r0.changed(r44) == false) goto L85;
        int r318 = 8388608;
    L86:
        r2 = r2 | r318;
        goto L87
    L85:
        r318 = 4194304;
        goto L86
    L71:
        if ((r62 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r43) == false) goto L75;
        int r217 = 1048576;
    L76:
        r2 = r2 | r217;
        goto L77
    L75:
        r217 = 524288;
        goto L76
    L61:
        if ((r62 & 196608) != 0) goto L67;
        if (r0.changedInstance(r42) == false) goto L65;
        int r218 = 131072;
    L66:
        r2 = r2 | r218;
        goto L67
    L65:
        r218 = 65536;
        goto L66
    L50:
        if ((r62 & 24576) != 0) goto L57;
        if (r0.changedInstance(r41) == false) goto L54;
        int r219 = 16384;
    L55:
        r2 = r2 | r219;
        goto L57
    L54:
        r219 = 8192;
        goto L55
    L39:
        if ((r62 & 3072) != 0) goto L46;
        if (r0.changedInstance(r40) == false) goto L43;
        int r127 = 2048;
    L44:
        r2 = r2 | r127;
        goto L46
    L43:
        r127 = 1024;
        goto L44
    L17:
        if ((r62 & 48) != 0) goto L25;
        if (r0.changed(r38) == false) goto L21;
        int r72 = 32;
    L22:
        r2 = r2 | r72;
        goto L25
    L21:
        r72 = 16;
        goto L22
    L6:
        if ((r62 & 6) == 0) goto L8;
        r2 = r62;
        goto L13
    L8:
        if (r0.changed(r37) == false) goto L10;
        int r73 = 4;
    L11:
        r2 = r73 | r62;
        goto L13
    L10:
        r73 = 2;
        goto L11
    }
}
