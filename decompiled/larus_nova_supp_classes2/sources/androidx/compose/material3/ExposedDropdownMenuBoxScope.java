package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\tH&J\u0095\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0007J\u009f\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b.\u0010/JU\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00100R\u0012\u0010\u000e\u001a\u00020\u0007X \u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\tX \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u00011¨\u00062"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "exposedDropdownSize", "matchAnchorWidth", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "matchTextFieldWidth", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    private ExposedDropdownMenuBoxScope() {
    }

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker r1) {
        this();
    }

    private static final Unit ExposedDropdownMenu$lambda$9(ExposedDropdownMenuBoxScope r10, boolean r11, Function0 r12, Modifier r13, ScrollState r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        r10.ExposedDropdownMenu(r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenu_kbRbctU$lambda$8(ExposedDropdownMenuBoxScope r18, boolean r19, Function0 r20, Modifier r21, ScrollState r22, boolean r23, boolean r24, Shape r25, long r26, float r28, float r29, BorderStroke r30, Function3 r31, int r32, int r33, int r34, Composer r35, int r36) {
        r18.m2679ExposedDropdownMenukbRbctU(r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenu_vNxi1II$lambda$7(ExposedDropdownMenuBoxScope r17, boolean r18, Function0 r19, Modifier r20, ScrollState r21, boolean r22, Shape r23, long r24, float r26, float r27, BorderStroke r28, Function3 r29, int r30, int r31, int r32, Composer r33, int r34) {
        r17.m2680ExposedDropdownMenuvNxi1II(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(MutableState r0, IntRect r1, IntRect r2) {
        return ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(ExposedDropdownMenuBoxScope r0, boolean r1, Function0 r2, Modifier r3, ScrollState r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return ExposedDropdownMenu$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit c(ExposedDropdownMenuBoxScope r1, boolean r2, Function0 r3, Modifier r4, ScrollState r5, boolean r6, Shape r7, long r8, float r10, float r11, BorderStroke r12, Function3 r13, int r14, int r15, int r16, Composer r17, int r18) {
        return ExposedDropdownMenu_vNxi1II$lambda$7(r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit d(ExposedDropdownMenuBoxScope r1, boolean r2, Function0 r3, Modifier r4, ScrollState r5, boolean r6, boolean r7, Shape r8, long r9, float r11, float r12, BorderStroke r13, Function3 r14, int r15, int r16, int r17, Composer r18, int r19) {
        return ExposedDropdownMenu_kbRbctU$lambda$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit e(MutableState r0) {
        return ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(r0);
    }

    public abstract Modifier exposedDropdownSize(Modifier r1, boolean r2);

    public abstract boolean getAlwaysFocusable$material3();

    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3, reason: not valid java name */
    public abstract String mo2681getAnchorTypeoYjWRB4$material3();

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac, reason: not valid java name */
    public abstract Modifier mo2682menuAnchor2Hz36ac(Modifier r1, String r2, boolean r3);

    private static final Unit ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(MutableState r1) {
        Unit r0 = Unit.INSTANCE;
        r1.setValue(r0);
        return r0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes ExposedDropdownMenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier r8) {
        return m2678menuAnchor2Hz36ac$default(this, r8, ExposedDropdownMenuAnchorType.Companion.m2676getPrimaryNotEditableoYjWRB4(), false, 2, null);
    }

    private static final Unit ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(MutableState r0, IntRect r1, IntRect r2) {
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

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2678menuAnchor2Hz36ac$default(ExposedDropdownMenuBoxScope r0, Modifier r1, String r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L7;
        r3 = true;
    L7:
        return r0.mo2682menuAnchor2Hz36ac(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-2Hz36ac");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    public final /* synthetic */ void ExposedDropdownMenu(final boolean r27, final Function0 r28, Modifier r29, ScrollState r30, final Function3 r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-1501437777);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L14:
        if ((r34 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r34 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r29;
    L36:
        if ((r33 & 3072) == 0) goto L38;
        ScrollState r8 = r30;
    L47:
        if ((r34 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        if ((r34 & 32) == 0) goto L60;
        r3 = r3 | 196608;
    L67:
        if ((74899 & r3) == 74898) goto L69;
        boolean r9 = true;
    L71:
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L95;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L75;
    L81:
        if (r5 == 0) goto L83;
        Modifier r7 = Modifier.Companion;
    L85:
        if ((r34 & 8) == 0) goto L87;
        ScrollState r10 = ScrollKt.rememberScrollState(0, r1, 0, 1);
        r3 = r3 & (-7169);
    L88:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventStart(-1501437777, r3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
    L91:
        MenuDefaults r0 = MenuDefaults.INSTANCE;
        Shape r15 = r0.getShape(r1, 6);
        long r16 = r0.getContainerColor(r1, 6);
        float r18 = r0.m2852getTonalElevationD9Ej5fM();
        float r19 = r0.m2851getShadowElevationD9Ej5fM();
        int r23 = ((((r3 & 14) | 906166272) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168);
        int r2 = r3 >> 9;
        Modifier r11 = r7;
        ScrollState r12 = r10;
        m2679ExposedDropdownMenukbRbctU(r27, r28, r11, r12, false, true, r15, r16, r18, r19, null, r31, r1, r23, ((r2 & 112) | 6) | (r2 & 896), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventEnd();
    L94:
        r8 = r10;
    L96:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L100;
        final Modifier r4 = r7;
        final ScrollState r14 = r8;
        r13.updateScope(new ma(this, r27, r28, r4, r14, r31, r33, r34));
        return;
    L100:
        return;
    L87:
        r10 = r8;
        goto L88
    L83:
        r7 = r6;
        goto L85
    L75:
        if (r1.getDefaultsInvalid() == true) goto L81;
        r1.skipToGroupEnd();
        if ((r34 & 8) == 0) goto L80;
        r3 = r3 & (-7169);
    L80:
        r7 = r6;
        goto L87
    L95:
        r1.skipToGroupEnd();
        r7 = r6;
        goto L96
    L69:
        r9 = false;
        goto L71
    L60:
        if ((r33 & 196608) != 0) goto L67;
        if (r1.changed(this) == false) goto L64;
        int r17 = 131072;
    L65:
        r3 = r3 | r17;
        goto L67
    L64:
        r17 = 65536;
        goto L65
    L50:
        if ((r33 & 24576) != 0) goto L57;
        if (r1.changedInstance(r31) == false) goto L54;
        int r20 = 16384;
    L55:
        r3 = r3 | r20;
        goto L57
    L54:
        r20 = 8192;
        goto L55
    L38:
        if ((r34 & 8) != 0) goto L42;
        r8 = r30;
        if (r1.changed(r8) == false) goto L43;
        int r21 = 2048;
    L44:
        r3 = r3 | r21;
    L43:
        r21 = 1024;
        goto L44
    L42:
        r8 = r30;
        goto L43
    L28:
        if ((r33 & 384) != 0) goto L34;
        r6 = r29;
        if (r1.changed(r6) == false) goto L32;
        int r22 = 256;
    L33:
        r3 = r3 | r22;
        goto L36
    L32:
        r22 = 128;
        goto L33
    L17:
        if ((r33 & 48) != 0) goto L24;
        if (r1.changedInstance(r28) == false) goto L21;
        int r24 = 32;
    L22:
        r3 = r3 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L14
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r25 = 4;
    L11:
        r3 = r25 | r33;
        goto L14
    L10:
        r25 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    public final void m2680ExposedDropdownMenuvNxi1II(final boolean r38, final Function0<Unit> r39, Modifier r40, ScrollState r41, boolean r42, Shape r43, long r44, float r46, float r47, BorderStroke r48, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r49, Composer r50, final int r51, final int r52, final int r53) {
        Composer r1 = r50.startRestartGroup(-126848451);
        if ((r53 & 1) == 0) goto L6;
        int r3 = r51 | 6;
    L14:
        if ((r53 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r9 = r53 & 4;
        if (r9 == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r51 & 3072) == 0) goto L38;
        ScrollState r11 = r41;
    L46:
        int r12 = r53 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r13 = r42;
    L58:
        if ((r51 & 196608) != 0) goto L68;
        if ((r53 & 32) == 0) goto L62;
    L64:
        int r16 = 65536;
    L65:
        r3 = r3 | r16;
        goto L68
    L62:
        if (r1.changed(r43) == false) goto L64;
        r16 = 131072;
    L68:
        if ((r51 & 1572864) != 0) goto L77;
        if ((r53 & 64) == 0) goto L72;
    L74:
        int r17 = 524288;
    L75:
        r3 = r3 | r17;
        goto L77
    L72:
        if (r1.changed(r44) == false) goto L74;
        r17 = 1048576;
    L77:
        int r5 = r53 & 128;
        if (r5 == 0) goto L81;
        r3 = r3 | 12582912;
    L87:
        int r0 = r53 & 256;
        if (r0 == 0) goto L91;
        r3 = r3 | 100663296;
    L97:
        int r4 = r53 & 512;
        if (r4 == 0) goto L101;
        r3 = r3 | 805306368;
    L108:
        if ((r53 & 1024) == 0) goto L111;
        int r19 = r52 | 6;
    L119:
        if ((r53 & 2048) == 0) goto L122;
        r19 = r19 | 48;
    L129:
        int r6 = r19;
        if ((r3 & 306783379) == 306783378) goto L132;
    L135:
        boolean r7 = true;
    L137:
        if (r1.shouldExecute(r7, r3 & 1) == false) goto L214;
        r1.startDefaults();
        if ((r51 & 1) != 0) goto L141;
    L153:
        if (r9 == 0) goto L155;
        Modifier r8 = Modifier.Companion;
    L157:
        if ((r53 & 8) == 0) goto L159;
        r11 = ScrollKt.rememberScrollState(0, r1, 0, 1);
        r3 = r3 & (-7169);
    L159:
        if (r12 == 0) goto L162;
        r13 = true;
    L162:
        if ((r53 & 32) == 0) goto L164;
        Shape r10 = MenuDefaults.INSTANCE.getShape(r1, 6);
        r3 = r3 & (-458753);
    L166:
        if ((r53 & 64) == 0) goto L168;
        long r110 = MenuDefaults.INSTANCE.getContainerColor(r1, 6);
        r3 = r3 & (-3670017);
    L169:
        if (r5 == 0) goto L171;
        float r14 = MenuDefaults.INSTANCE.m2852getTonalElevationD9Ej5fM();
    L172:
        if (r0 == 0) goto L174;
        float r2 = MenuDefaults.INSTANCE.m2851getShadowElevationD9Ej5fM();
    L175:
        if (r4 == 0) goto L177;
        int r15 = r3;
        long r18 = r110;
        BorderStroke r111 = null;
    L178:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L181;
        ComposerKt.traceEventStart(-126848451, r15, r6, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
    L181:
        Object r20 = r1.rememberedValue();
        Composer.Companion r21 = Composer.Companion;
        if (r20 != r21.getEmpty()) goto L184;
        r20 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        r1.updateRememberedValue(r20);
    L184:
        final MutableState r22 = (MutableState) r20;
        Density r112 = (Density) r1.consume(CompositionLocalsKt.getLocalDensity());
        int r113 = r15;
        int r114 = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, r1, 6).getTop(r112);
        if (r38 == false) goto L190;
        r1.startReplaceGroup(629991660);
        Object r115 = r1.rememberedValue();
        if (r115 != r21.getEmpty()) goto L189;
        r115 = new oa(r22);
        r1.updateRememberedValue(r115);
    L189:
        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) r115, r1, 6);
        r1.endReplaceGroup();
    L191:
        Object r23 = r1.rememberedValue();
        if (r23 != r21.getEmpty()) goto L194;
        r23 = new MutableTransitionState(Boolean.FALSE);
        r1.updateRememberedValue(r23);
    L194:
        final MutableTransitionState r24 = (MutableTransitionState) r23;
        r24.setTargetState(Boolean.valueOf(r38));
        if (((Boolean) r24.getCurrentState()).booleanValue() == false) goto L197;
    L200:
        r1.startReplaceGroup(630396489);
        Object r116 = r1.rememberedValue();
        final BorderStroke r410 = r111;
        if (r116 != r21.getEmpty()) goto L204;
        r116 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), null, 2, null);
        r1.updateRememberedValue(r116);
    L204:
        final MutableState r25 = (MutableState) r116;
        boolean r117 = r1.changed(r112) | r1.changed(r114);
        Object r118 = r1.rememberedValue();
        if (r117 == false) goto L207;
    L208:
        r118 = new ExposedDropdownMenuPositionProvider(r112, r114, r22, 0, new pa(r25), 8, null);
        r1.updateRememberedValue(r118);
    L209:
        final Modifier r26 = r8;
        final boolean r27 = r13;
        final ScrollState r28 = r11;
        final Shape r29 = r10;
        final long r210 = r18;
        final float r211 = r14;
        final float r30 = r2;
        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) r118, r39, ExposedDropdownMenu_androidKt.m2699popupPropertiesForAnchorTypeBTG8q0(mo2681getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), r1, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new AnonymousClass2(this, r26, r27, r24, r25, r28, r29, r210, r211, r30, r410, r49), r1, 54), r1, (r113 & 112) | 3072, 0);
        r1.endReplaceGroup();
    L211:
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L213:
        final BorderStroke r119 = r410;
        final float r120 = r14;
        final ScrollState r31 = r11;
        final boolean r32 = r13;
        final float r121 = r2;
        final Modifier r33 = r8;
        final Shape r34 = r10;
        final long r35 = r18;
    L215:
        ScopeUpdateScope r122 = r1.endRestartGroup();
        if (r122 == null) goto L219;
        r122.updateScope(new qa(this, r38, r39, r33, r31, r32, r34, r35, r120, r121, r119, r49, r51, r52, r53));
        return;
    L219:
        return;
    L207:
        if (r118 != r21.getEmpty()) goto L209;
    L197:
        if (((Boolean) r24.getTargetState()).booleanValue() == true) goto L200;
        r1.startReplaceGroup(631807237);
        r1.endReplaceGroup();
        r2 = r2;
        r410 = r111;
        goto L211
    L190:
        r1.startReplaceGroup(630077189);
        r1.endReplaceGroup();
        goto L191
    L177:
        r111 = r48;
        r15 = r3;
        r18 = r110;
        goto L178
    L174:
        r2 = r47;
        goto L175
    L171:
        r14 = r46;
        goto L172
    L168:
        r110 = r44;
        goto L169
    L164:
        r10 = r43;
        goto L166
    L155:
        r8 = r40;
        goto L157
    L141:
        if (r1.getDefaultsInvalid() == true) goto L153;
        r1.skipToGroupEnd();
        if ((r53 & 8) == 0) goto L147;
        r3 = r3 & (-7169);
    L147:
        if ((r53 & 32) == 0) goto L150;
        r3 = r3 & (-458753);
    L150:
        if ((r53 & 64) == 0) goto L152;
        r3 = r3 & (-3670017);
    L152:
        r8 = r40;
        r10 = r43;
        r14 = r46;
        r2 = r47;
        r111 = r48;
        r15 = r3;
        r18 = r44;
        goto L178
    L214:
        r1.skipToGroupEnd();
        r33 = r40;
        r34 = r43;
        r35 = r44;
        r120 = r46;
        r119 = r48;
        r31 = r11;
        r32 = r13;
        r121 = r47;
        goto L215
    L132:
        if ((r6 & 19) != 18) goto L135;
        r7 = false;
        goto L137
    L122:
        if ((r52 & 48) != 0) goto L129;
        if (r1.changed(this) == false) goto L126;
        int r123 = 32;
    L127:
        r19 = r19 | r123;
        goto L129
    L126:
        r123 = 16;
        goto L127
    L111:
        if ((r52 & 6) == 0) goto L113;
        r19 = r52;
        goto L119
    L113:
        if (r1.changedInstance(r49) == false) goto L115;
        int r124 = 4;
    L116:
        r19 = r52 | r124;
        goto L119
    L115:
        r124 = 2;
        goto L116
    L101:
        if ((r51 & 805306368) != 0) goto L108;
        if (r1.changed(r48) == false) goto L105;
        int r125 = 536870912;
    L106:
        r3 = r3 | r125;
        goto L108
    L105:
        r125 = 268435456;
        goto L106
    L91:
        if ((r51 & 100663296) != 0) goto L97;
        if (r1.changed(r47) == false) goto L95;
        int r126 = 67108864;
    L96:
        r3 = r3 | r126;
        goto L97
    L95:
        r126 = 33554432;
        goto L96
    L81:
        if ((r51 & 12582912) != 0) goto L87;
        if (r1.changed(r46) == false) goto L85;
        int r127 = 8388608;
    L86:
        r3 = r3 | r127;
        goto L87
    L85:
        r127 = 4194304;
        goto L86
    L50:
        if ((r51 & 24576) != 0) goto L56;
        r13 = r42;
        if (r1.changed(r13) == false) goto L54;
        int r128 = 16384;
    L55:
        r3 = r3 | r128;
        goto L58
    L54:
        r128 = 8192;
        goto L55
    L38:
        if ((r53 & 8) != 0) goto L42;
        r11 = r41;
        if (r1.changed(r11) == false) goto L43;
        int r129 = 2048;
    L44:
        r3 = r3 | r129;
    L43:
        r129 = 1024;
        goto L44
    L42:
        r11 = r41;
        goto L43
    L28:
        if ((r51 & 384) != 0) goto L36;
        if (r1.changed(r40) == false) goto L32;
        int r130 = 256;
    L33:
        r3 = r3 | r130;
        goto L36
    L32:
        r130 = 128;
        goto L33
    L17:
        if ((r51 & 48) != 0) goto L24;
        if (r1.changedInstance(r39) == false) goto L21;
        int r36 = 32;
    L22:
        r3 = r3 | r36;
        goto L24
    L21:
        r36 = 16;
        goto L22
    L6:
        if ((r51 & 6) == 0) goto L8;
        r3 = r51;
        goto L14
    L8:
        if (r1.changed(r38) == false) goto L10;
        int r37 = 4;
    L11:
        r3 = r37 | r51;
        goto L14
    L10:
        r37 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper ExposedDropdownMenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* JADX INFO: renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    public final void m2679ExposedDropdownMenukbRbctU(final boolean r36, final Function0<Unit> r37, Modifier r38, ScrollState r39, boolean r40, boolean r41, Shape r42, long r43, float r45, float r46, BorderStroke r47, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r48, Composer r49, final int r50, final int r51, final int r52) {
        Composer r1 = r49.startRestartGroup(-1772805535);
        if ((r52 & 1) == 0) goto L6;
        int r5 = r50 | 6;
    L14:
        if ((r52 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r9 = r52 & 4;
        if (r9 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        Modifier r12 = r38;
    L36:
        if ((r50 & 3072) != 0) goto L46;
        if ((r52 & 8) != 0) goto L43;
        if (r1.changed(r39) == false) goto L43;
        int r16 = 2048;
    L44:
        r5 = r5 | r16;
    L43:
        r16 = 1024;
    L46:
        int r17 = r52 & 32;
        if (r17 == 0) goto L50;
        r5 = r5 | 196608;
    L57:
        if ((r50 & 1572864) != 0) goto L67;
        if ((r52 & 64) == 0) goto L61;
    L63:
        int r19 = 524288;
    L64:
        r5 = r5 | r19;
        goto L67
    L61:
        if (r1.changed(r42) == false) goto L63;
        r19 = 1048576;
    L67:
        if ((r50 & 12582912) != 0) goto L75;
        long r10 = r43;
        if ((r52 & 128) == 0) goto L71;
    L73:
        int r21 = 4194304;
    L74:
        r5 = r5 | r21;
    L76:
        int r8 = r52 & 256;
        if (r8 == 0) goto L80;
        r5 = r5 | 100663296;
    L86:
        int r0 = r52 & 512;
        if (r0 == 0) goto L90;
        r5 = r5 | 805306368;
    L96:
        int r2 = r52 & 1024;
        if (r2 == 0) goto L100;
        int r18 = r51 | 6;
    L108:
        if ((r52 & 2048) == 0) goto L111;
        r18 = r18 | 48;
    L118:
        int r3 = r18;
        if ((r52 & 4096) == 0) goto L122;
        r3 = r3 | 384;
    L129:
        final boolean r7 = true;
        if ((r5 & 306775187) == 306775186) goto L132;
    L135:
        boolean r4 = true;
    L137:
        if (r1.shouldExecute(r4, r5 & 1) == false) goto L191;
        r1.startDefaults();
        if ((r50 & 1) != 0) goto L141;
    L154:
        if (r9 == 0) goto L156;
        Modifier r6 = Modifier.Companion;
    L158:
        if ((r52 & 8) == 0) goto L160;
        ScrollState r11 = ScrollKt.rememberScrollState(0, r1, 0, 1);
        r5 = r5 & (-7169);
    L162:
        if ((r52 & 16) == 0) goto L164;
        boolean r13 = true;
    L165:
        if (r17 != 0) goto L168;
        r7 = r41;
    L168:
        Modifier r310 = r6;
        if ((r52 & 64) == 0) goto L171;
        Shape r14 = MenuDefaults.INSTANCE.getShape(r1, 6);
        r5 = r5 & (-3670017);
    L173:
        if ((r52 & 128) == 0) goto L175;
        r10 = MenuDefaults.INSTANCE.getContainerColor(r1, 6);
        r5 = r5 & (-29360129);
    L175:
        if (r8 == 0) goto L177;
        float r15 = MenuDefaults.INSTANCE.m2852getTonalElevationD9Ej5fM();
    L178:
        if (r0 == 0) goto L180;
        float r20 = MenuDefaults.INSTANCE.m2851getShadowElevationD9Ej5fM();
    L181:
        if (r2 == 0) goto L183;
        int r22 = r5;
        BorderStroke r23 = null;
        float r24 = r20;
        boolean r25 = r13;
        r12 = r310;
    L184:
        r1.endDefaults();
        boolean r311 = r25;
        if (ComposerKt.isTraceInProgress() == false) goto L187;
        ComposerKt.traceEventStart(-1772805535, r22, r3, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
    L187:
        int r26 = (((r22 & 14) | (r22 & 112)) | (r22 & 896)) | (r22 & 7168);
        int r27 = r22 >> 3;
        int r30 = (((((r26 | (57344 & r27)) | (458752 & r27)) | (3670016 & r27)) | (29360128 & r27)) | (r27 & 234881024)) | ((r3 << 27) & 1879048192);
        int r28 = r3 >> 3;
        m2680ExposedDropdownMenuvNxi1II(r36, r37, r12, r11, r7, r14, r10, r15, r24, r23, r48, r1, r30, (r28 & 14) | (r28 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventEnd();
    L190:
        final Shape r29 = r14;
        final BorderStroke r110 = r23;
        final ScrollState r31 = r11;
        final long r32 = r10;
        final Modifier r33 = r12;
        final float r111 = r24;
        final float r112 = r15;
        final boolean r34 = r311;
    L192:
        ScopeUpdateScope r35 = r1.endRestartGroup();
        if (r35 == null) goto L196;
        r35.updateScope(new na(this, r36, r37, r33, r31, r34, r7, r29, r32, r112, r111, r110, r48, r50, r51, r52));
        return;
    L196:
        return;
    L183:
        r24 = r20;
        r22 = r5;
        r25 = r13;
        r12 = r310;
    L153:
        r23 = r47;
        goto L184
    L180:
        r20 = r46;
        goto L181
    L177:
        r15 = r45;
        goto L178
    L171:
        r14 = r42;
        goto L173
    L164:
        r13 = r40;
        goto L165
    L160:
        r11 = r39;
        goto L162
    L156:
        r6 = r12;
        goto L158
    L141:
        if (r1.getDefaultsInvalid() == true) goto L154;
        r1.skipToGroupEnd();
        if ((r52 & 8) == 0) goto L147;
        r5 = r5 & (-7169);
    L147:
        if ((r52 & 64) == 0) goto L150;
        r5 = r5 & (-3670017);
    L150:
        if ((r52 & 128) == 0) goto L152;
        r5 = r5 & (-29360129);
    L152:
        r11 = r39;
        r25 = r40;
        r7 = r41;
        r14 = r42;
        r15 = r45;
        r24 = r46;
        r22 = r5;
        goto L153
    L191:
        r1.skipToGroupEnd();
        r31 = r39;
        r34 = r40;
        r7 = r41;
        r29 = r42;
        r110 = r47;
        r32 = r10;
        r33 = r12;
        r112 = r45;
        r111 = r46;
        goto L192
    L132:
        if ((r3 & 147) != 146) goto L135;
        r4 = false;
        goto L137
    L122:
        if ((r51 & 384) != 0) goto L129;
        if (r1.changed(this) == false) goto L126;
        int r210 = 256;
    L127:
        r3 = r3 | r210;
        goto L129
    L126:
        r210 = 128;
        goto L127
    L111:
        if ((r51 & 48) != 0) goto L118;
        if (r1.changedInstance(r48) == false) goto L115;
        int r113 = 32;
    L116:
        r18 = r18 | r113;
        goto L118
    L115:
        r113 = 16;
        goto L116
    L100:
        if ((r51 & 6) == 0) goto L102;
        r18 = r51;
        goto L108
    L102:
        if (r1.changed(r47) == false) goto L104;
        int r114 = 4;
    L105:
        r18 = r51 | r114;
        goto L108
    L104:
        r114 = 2;
        goto L105
    L90:
        if ((r50 & 805306368) != 0) goto L96;
        if (r1.changed(r46) == false) goto L94;
        int r211 = 536870912;
    L95:
        r5 = r5 | r211;
        goto L96
    L94:
        r211 = 268435456;
        goto L95
    L80:
        if ((r50 & 100663296) != 0) goto L86;
        if (r1.changed(r45) == false) goto L84;
        int r212 = 67108864;
    L85:
        r5 = r5 | r212;
        goto L86
    L84:
        r212 = 33554432;
        goto L85
    L71:
        if (r1.changed(r10) == false) goto L73;
        r21 = 8388608;
        goto L74
    L75:
        r10 = r43;
        goto L76
    L50:
        if ((r50 & 196608) != 0) goto L57;
        if (r1.changed(r41) == false) goto L54;
        int r115 = 131072;
    L55:
        r5 = r5 | r115;
        goto L57
    L54:
        r115 = 65536;
        goto L55
    L28:
        if ((r50 & 384) != 0) goto L34;
        r12 = r38;
        if (r1.changed(r12) == false) goto L32;
        int r116 = 256;
    L33:
        r5 = r5 | r116;
        goto L36
    L32:
        r116 = 128;
        goto L33
    L17:
        if ((r50 & 48) != 0) goto L24;
        if (r1.changedInstance(r37) == false) goto L21;
        int r44 = 32;
    L22:
        r5 = r5 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r5 = r50;
        goto L14
    L8:
        if (r1.changed(r36) == false) goto L10;
        int r53 = 4;
    L11:
        r5 = r53 | r50;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }
}
