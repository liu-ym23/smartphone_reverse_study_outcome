package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b \u0010!\u001a\u0090\u0001\u0010\"\u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001a2\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0002\u0010.\"\u0014\u0010/\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = null;

    private static final Unit DropdownMenuItem$lambda$7(Function2 r13, Function0 r14, Modifier r15, Function2 r16, Function2 r17, boolean r18, MenuItemColors r19, PaddingValues r20, MutableInteractionSource r21, int r22, int r23, Composer r24, int r25) {
        DropdownMenuItem(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenu_4kj__NE$lambda$5(boolean r12, Function0 r13, Modifier r14, long r15, ScrollState r17, PopupProperties r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m2290DropdownMenu4kj_NE(r12, r13, r14, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenu_ILWXrKs$lambda$6(boolean r11, Function0 r12, Modifier r13, long r14, PopupProperties r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        m2291DropdownMenuILWXrKs(r11, r12, r13, r14, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenu_IlH_yew$lambda$4(boolean r18, Function0 r19, Modifier r20, long r21, ScrollState r23, PopupProperties r24, Shape r25, long r26, float r28, float r29, BorderStroke r30, Function3 r31, int r32, int r33, int r34, Composer r35, int r36) {
        m2292DropdownMenuIlH_yew(r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function0 r1, Modifier r2, Function2 r3, Function2 r4, boolean r5, MenuItemColors r6, PaddingValues r7, MutableInteractionSource r8, int r9, int r10, Composer r11, int r12) {
        return DropdownMenuItem$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit b(boolean r1, Function0 r2, Modifier r3, long r4, ScrollState r6, PopupProperties r7, Shape r8, long r9, float r11, float r12, BorderStroke r13, Function3 r14, int r15, int r16, int r17, Composer r18, int r19) {
        return DropdownMenu_IlH_yew$lambda$4(r1, r2, r3, r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit c(MutableState r0, IntRect r1, IntRect r2) {
        return DropdownMenu_IlH_yew$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(boolean r0, Function0 r1, Modifier r2, long r3, PopupProperties r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return DropdownMenu_ILWXrKs$lambda$6(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit e(boolean r0, Function0 r1, Modifier r2, long r3, ScrollState r5, PopupProperties r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return DropdownMenu_4kj__NE$lambda$5(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    static {
        DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, null);
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }

    private static final Unit DropdownMenu_IlH_yew$lambda$3$lambda$2(MutableState r0, IntRect r1, IntRect r2) {
        r0.setValue(TransformOrigin.box-impl(MenuKt.calculateTransformOrigin(r1, r2)));
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m2291DropdownMenuILWXrKs(final boolean r27, final Function0 r28, Modifier r29, long r30, PopupProperties r32, final Function3 r33, Composer r34, final int r35, final int r36) {
        Composer r1 = r34.startRestartGroup(1744198621);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L14:
        if ((r36 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r36 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r7 = r29;
    L35:
        int r9 = r36 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        long r10 = r30;
    L46:
        int r12 = r36 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        PopupProperties r13 = r32;
    L58:
        if ((r36 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r0 = true;
    L72:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L88;
        if (r6 == 0) goto L75;
        r7 = Modifier.Companion;
    L75:
        if (r9 == 0) goto L77;
        float r8 = 0;
        float r2 = Dp.constructor-impl(r8);
        float r11 = Dp.constructor-impl(r8);
        long r14 = Float.floatToRawIntBits(r2);
        long r5 = DpOffset.constructor-impl((((long) Float.floatToRawIntBits(r11)) & 4294967295L) | (r14 << 32));
    L78:
        if (r12 == 0) goto L80;
        PopupProperties r4 = new PopupProperties(true, false, false, false, 14, null);
    L82:
        if (ComposerKt.isTraceInProgress() == false) goto L84;
        ComposerKt.traceEventStart(1744198621, r3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:158)");
    L84:
        m2292DropdownMenuIlH_yew(r27, r28, r7, r5, ScrollKt.rememberScrollState(0, r1, 0, 1), r4, null, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, r33, r1, ((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | ((r3 << 3) & 458752), (r3 >> 12) & 112, 1984);
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventEnd();
    L87:
        r10 = r5;
        final Modifier r15 = r7;
        final PopupProperties r16 = r4;
    L89:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L93;
        final long r18 = r10;
        r17.updateScope(new i(r27, r28, r15, r18, r16, r33, r35, r36));
        return;
    L93:
        return;
    L80:
        r4 = r13;
        goto L82
    L77:
        r5 = r10;
        goto L78
    L88:
        r1.skipToGroupEnd();
        r15 = r7;
        r16 = r13;
        goto L89
    L70:
        r0 = false;
        goto L72
    L61:
        if ((r35 & 196608) != 0) goto L68;
        if (r1.changedInstance(r33) == false) goto L65;
        int r19 = 131072;
    L66:
        r3 = r3 | r19;
        goto L68
    L65:
        r19 = 65536;
        goto L66
    L50:
        if ((r35 & 24576) != 0) goto L56;
        r13 = r32;
        if (r1.changed(r13) == false) goto L54;
        int r110 = 16384;
    L55:
        r3 = r3 | r110;
        goto L58
    L54:
        r110 = 8192;
        goto L55
    L39:
        if ((r35 & 3072) != 0) goto L45;
        r10 = r30;
        if (r1.changed(r10) == false) goto L43;
        int r111 = 2048;
    L44:
        r3 = r3 | r111;
        goto L46
    L43:
        r111 = 1024;
        goto L44
    L28:
        if ((r35 & 384) != 0) goto L34;
        r7 = r29;
        if (r1.changed(r7) == false) goto L32;
        int r20 = 256;
    L33:
        r3 = r3 | r20;
        goto L35
    L32:
        r20 = 128;
        goto L33
    L17:
        if ((r35 & 48) != 0) goto L24;
        if (r1.changedInstance(r28) == false) goto L21;
        int r21 = 32;
    L22:
        r3 = r3 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L14
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r22 = 4;
    L11:
        r3 = r22 | r35;
        goto L14
    L10:
        r22 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith = @ReplaceWith(expression = "DropdownMenu(\n    expanded = expanded,\n    onDismissRequest = onDismissRequest,\n    modifier = modifier,\n    offset = offset,\n    scrollState = scrollState,\n    properties = properties,\n    shape = MenuDefaults.shape,\n    containerColor = MenuDefaults.containerColor,\n    tonalElevation = MenuDefaults.TonalElevation,\n    shadowElevation = MenuDefaults.ShadowElevation,\n    border = null,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final /* synthetic */ void m2290DropdownMenu4kj_NE(final boolean r28, final Function0 r29, Modifier r30, long r31, ScrollState r33, PopupProperties r34, final Function3 r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(1518067413);
        if ((r38 & 1) == 0) goto L6;
        int r3 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r38 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r7 = r30;
    L35:
        int r8 = r38 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        long r10 = r31;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        ScrollState r12 = r33;
    L57:
        int r13 = r38 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        PopupProperties r14 = r34;
    L69:
        if ((r38 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L112;
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L88;
    L95:
        if (r6 == 0) goto L97;
        r7 = Modifier.Companion;
    L97:
        if (r8 == 0) goto L99;
        float r9 = 0;
        float r2 = Dp.constructor-impl(r9);
        float r11 = Dp.constructor-impl(r9);
        long r15 = Float.floatToRawIntBits(r2);
        long r5 = DpOffset.constructor-impl((((long) Float.floatToRawIntBits(r11)) & 4294967295L) | (r15 << 32));
    L101:
        if ((r38 & 16) == 0) goto L103;
        r3 = r3 & (-57345);
        r12 = ScrollKt.rememberScrollState(0, r1, 0, 1);
    L103:
        if (r13 != 0) goto L104;
    L94:
        ScrollState r4 = r12;
        PopupProperties r16 = r14;
    L105:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L108;
        ComposerKt.traceEventStart(1518067413, r3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:123)");
    L108:
        MenuDefaults r17 = MenuDefaults.INSTANCE;
        m2292DropdownMenuIlH_yew(r28, r29, r7, r5, r4, r16, r17.getShape(r1, 6), r17.getContainerColor(r1, 6), r17.m2852getTonalElevationD9Ej5fM(), r17.m2851getShadowElevationD9Ej5fM(), null, r35, r1, ((((((r3 & 14) | 905969664) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3), ((r3 >> 15) & 112) | 6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L111;
        ComposerKt.traceEventEnd();
    L111:
        r12 = r4;
        final Modifier r18 = r7;
        final PopupProperties r19 = r16;
    L113:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L117;
        final long r20 = r5;
        final ScrollState r21 = r12;
        r110.updateScope(new j(r28, r29, r18, r20, r21, r19, r35, r37, r38));
        return;
    L117:
        return;
    L104:
        r16 = new PopupProperties(true, false, false, false, 14, null);
        r4 = r12;
        goto L105
    L99:
        r5 = r10;
        goto L101
    L88:
        if (r1.getDefaultsInvalid() == true) goto L95;
        r1.skipToGroupEnd();
        if ((r38 & 16) == 0) goto L93;
        r3 = r3 & (-57345);
    L93:
        r5 = r10;
        goto L94
    L112:
        r1.skipToGroupEnd();
        r18 = r7;
        r5 = r10;
        r19 = r14;
        goto L113
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r37 & 1572864) != 0) goto L80;
        if (r1.changedInstance(r35) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((196608 & r37) != 0) goto L67;
        r14 = r34;
        if (r1.changed(r14) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L49:
        if ((r38 & 16) != 0) goto L53;
        r12 = r33;
        if (r1.changed(r12) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r12 = r33;
        goto L54
    L39:
        if ((r37 & 3072) != 0) goto L45;
        r10 = r31;
        if (r1.changed(r10) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L47
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r37 & 384) != 0) goto L34;
        r7 = r30;
        if (r1.changed(r7) == false) goto L32;
        int r22 = 256;
    L33:
        r3 = r3 | r22;
        goto L35
    L32:
        r22 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r1.changedInstance(r29) == false) goto L21;
        int r23 = 32;
    L22:
        r3 = r3 | r23;
        goto L24
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r3 = r37;
        goto L14
    L8:
        if (r1.changed(r28) == false) goto L10;
        int r24 = 4;
    L11:
        r3 = r24 | r37;
        goto L14
    L10:
        r24 = 2;
        goto L11
    }

    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> r24, final Function0<Unit> r25, Modifier r26, Function2<? super Composer, ? super Integer, Unit> r27, Function2<? super Composer, ? super Integer, Unit> r28, boolean r29, MenuItemColors r30, PaddingValues r31, MutableInteractionSource r32, Composer r33, final int r34, final int r35) {
        Composer r1 = r33.startRestartGroup(-532959117);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r35 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r7 = r35 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r8 = r27;
    L46:
        int r9 = r35 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function2<? super Composer, ? super Integer, Unit> r12 = r28;
    L57:
        int r13 = r35 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r14 = r29;
    L69:
        if ((1572864 & r34) == 0) goto L71;
        MenuItemColors r15 = r30;
    L79:
        int r0 = r35 & 128;
        if (r0 == 0) goto L83;
        r3 = r3 | 12582912;
    L89:
        int r2 = r35 & 256;
        if (r2 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r3 & 38347923) == 38347922) goto L102;
        boolean r4 = true;
    L104:
        if (r1.shouldExecute(r4, r3 & 1) == false) goto L142;
        r1.startDefaults();
        if ((r34 & 1) != 0) goto L108;
    L114:
        if (r5 == 0) goto L116;
        Modifier r6 = Modifier.Companion;
    L117:
        MutableInteractionSource r10 = null;
        if (r7 == 0) goto L120;
        r8 = null;
    L120:
        if (r9 == 0) goto L122;
        r12 = null;
    L122:
        if (r13 == 0) goto L125;
        r14 = true;
    L125:
        if ((r35 & 64) == 0) goto L127;
        final MenuItemColors r11 = MenuDefaults.INSTANCE.itemColors(r1, 6);
        r3 = r3 & (-3670017);
    L128:
        if (r0 == 0) goto L130;
        PaddingValues r16 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
    L131:
        if (r2 != 0) goto L134;
        r10 = r32;
    L134:
        int r17 = r3;
        boolean r18 = r14;
        PaddingValues r19 = r16;
        Function2<? super Composer, ? super Integer, Unit> r20 = r12;
    L135:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventStart(-532959117, r17, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:179)");
    L138:
        MenuKt.DropdownMenuItemContent(r24, r25, r6, r8, r20, r18, r11, r19, r10, r1, ((((((((r17 & 14) | (r17 & 112)) | (r17 & 896)) | (r17 & 7168)) | (57344 & r17)) | (458752 & r17)) | (3670016 & r17)) | (29360128 & r17)) | (r17 & 234881024));
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventEnd();
    L141:
        final boolean r21 = r18;
        final MutableInteractionSource r22 = r10;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r20;
        Function2<? super Composer, ? super Integer, Unit> r210 = r8;
        final PaddingValues r36 = r19;
        final Modifier r37 = r6;
        final Function2<? super Composer, ? super Integer, Unit> r38 = r210;
    L143:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L147;
        r110.updateScope(new m(r24, r25, r37, r38, r23, r21, r11, r36, r22, r34, r35));
        return;
    L147:
        return;
    L130:
        r16 = r31;
        goto L131
    L127:
        r11 = r15;
        goto L128
    L116:
        r6 = r26;
        goto L117
    L108:
        if (r1.getDefaultsInvalid() == true) goto L114;
        r1.skipToGroupEnd();
        if ((r35 & 64) == 0) goto L113;
        r3 = r3 & (-3670017);
    L113:
        r6 = r26;
        r10 = r32;
        r17 = r3;
        r20 = r12;
        r18 = r14;
        r11 = r15;
        r19 = r31;
        goto L135
    L142:
        r1.skipToGroupEnd();
        r37 = r26;
        r22 = r32;
        r38 = r8;
        r23 = r12;
        r21 = r14;
        r11 = r15;
        r36 = r31;
        goto L143
    L102:
        r4 = false;
        goto L104
    L93:
        if ((r34 & 100663296) != 0) goto L100;
        if (r1.changed(r32) == false) goto L97;
        int r111 = 67108864;
    L98:
        r3 = r3 | r111;
        goto L100
    L97:
        r111 = 33554432;
        goto L98
    L83:
        if ((r34 & 12582912) != 0) goto L89;
        if (r1.changed(r31) == false) goto L87;
        int r112 = 8388608;
    L88:
        r3 = r3 | r112;
        goto L89
    L87:
        r112 = 4194304;
        goto L88
    L71:
        if ((r35 & 64) != 0) goto L75;
        r15 = r30;
        if (r1.changed(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
    L76:
        r113 = 524288;
        goto L77
    L75:
        r15 = r30;
        goto L76
    L61:
        if ((196608 & r34) != 0) goto L67;
        r14 = r29;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L69
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r34 & 24576) != 0) goto L56;
        r12 = r28;
        if (r1.changedInstance(r12) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r34 & 3072) != 0) goto L45;
        r8 = r27;
        if (r1.changedInstance(r8) == false) goto L43;
        int r39 = 2048;
    L44:
        r3 = r3 | r39;
        goto L46
    L43:
        r39 = 1024;
        goto L44
    L28:
        if ((r34 & 384) != 0) goto L35;
        if (r1.changed(r26) == false) goto L32;
        int r40 = 256;
    L33:
        r3 = r3 | r40;
        goto L35
    L32:
        r40 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r1.changedInstance(r25) == false) goto L21;
        int r41 = 32;
    L22:
        r3 = r3 | r41;
        goto L24
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L14
    L8:
        if (r1.changedInstance(r24) == false) goto L10;
        int r42 = 4;
    L11:
        r3 = r42 | r34;
        goto L14
    L10:
        r42 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DropdownMenu-IlH_yew, reason: not valid java name */
    public static final void m2292DropdownMenuIlH_yew(final boolean r36, final Function0<Unit> r37, Modifier r38, long r39, ScrollState r41, PopupProperties r42, Shape r43, long r44, float r46, float r47, BorderStroke r48, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r49, Composer r50, final int r51, final int r52, final int r53) {
        Composer r1 = r50.startRestartGroup(1725609375);
        if ((r53 & 1) == 0) goto L6;
        int r5 = r51 | 6;
    L14:
        if ((r53 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r9 = r53 & 4;
        if (r9 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        Modifier r10 = r38;
    L35:
        int r11 = r53 & 8;
        if (r11 == 0) goto L39;
        r5 = r5 | 3072;
    L45:
        long r12 = r39;
    L47:
        if ((r51 & 24576) != 0) goto L57;
        if ((r53 & 16) != 0) goto L54;
        if (r1.changed(r41) == false) goto L54;
        int r17 = 16384;
    L55:
        r5 = r5 | r17;
    L54:
        r17 = 8192;
    L57:
        int r18 = r53 & 32;
        if (r18 == 0) goto L61;
        r5 = r5 | 196608;
    L68:
        if ((r51 & 1572864) != 0) goto L78;
        if ((r53 & 64) == 0) goto L72;
    L74:
        int r20 = 524288;
    L75:
        r5 = r5 | r20;
        goto L78
    L72:
        if (r1.changed(r43) == false) goto L74;
        r20 = 1048576;
    L78:
        if ((r51 & 12582912) != 0) goto L87;
        if ((r53 & 128) == 0) goto L82;
    L84:
        int r21 = 4194304;
    L85:
        r5 = r5 | r21;
        goto L87
    L82:
        if (r1.changed(r44) == false) goto L84;
        r21 = 8388608;
    L87:
        int r0 = r53 & 256;
        if (r0 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r2 = r53 & 512;
        if (r2 == 0) goto L101;
        r5 = r5 | 805306368;
    L107:
        int r3 = r53 & 1024;
        if (r3 == 0) goto L111;
        int r16 = r52 | 6;
    L119:
        if ((r53 & 2048) == 0) goto L122;
        r16 = r16 | 48;
    L129:
        int r4 = r16;
        if ((r5 & 306783379) == 306783378) goto L132;
    L135:
        boolean r6 = true;
    L137:
        if (r1.shouldExecute(r6, r5 & 1) == false) goto L214;
        r1.startDefaults();
        if ((r51 & 1) != 0) goto L141;
    L153:
        if (r9 == 0) goto L155;
        Modifier r7 = Modifier.Companion;
    L156:
        if (r11 == 0) goto L158;
        float r13 = 0;
        float r14 = Dp.constructor-impl(r13);
        float r15 = Dp.constructor-impl(r13);
        long r19 = Float.floatToRawIntBits(r14);
        long r22 = DpOffset.constructor-impl((((long) Float.floatToRawIntBits(r15)) & 4294967295L) | (r19 << 32));
    L160:
        if ((r53 & 16) == 0) goto L162;
        ScrollState r110 = ScrollKt.rememberScrollState(0, r1, 0, 1);
        r5 = r5 & (-57345);
    L163:
        if (r18 == 0) goto L165;
        PopupProperties r111 = DefaultMenuProperties;
    L167:
        if ((r53 & 64) == 0) goto L169;
        final Shape r8 = MenuDefaults.INSTANCE.getShape(r1, 6);
        r5 = r5 & (-3670017);
    L171:
        if ((r53 & 128) == 0) goto L173;
        long r23 = MenuDefaults.INSTANCE.getContainerColor(r1, 6);
        r5 = r5 & (-29360129);
    L174:
        if (r0 == 0) goto L176;
        float r24 = MenuDefaults.INSTANCE.m2852getTonalElevationD9Ej5fM();
    L177:
        if (r2 == 0) goto L179;
        float r25 = MenuDefaults.INSTANCE.m2851getShadowElevationD9Ej5fM();
    L180:
        if (r3 == 0) goto L182;
        BorderStroke r26 = null;
    L183:
        float r27 = r25;
        long r28 = r23;
    L184:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L187;
        ComposerKt.traceEventStart(1725609375, r5, r4, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:54)");
    L187:
        Object r29 = r1.rememberedValue();
        Composer.Companion r112 = Composer.Companion;
        if (r29 != r112.getEmpty()) goto L190;
        r29 = new MutableTransitionState(Boolean.FALSE);
        r1.updateRememberedValue(r29);
    L190:
        final MutableTransitionState r30 = (MutableTransitionState) r29;
        r30.setTargetState(Boolean.valueOf(r36));
        if (((Boolean) r30.getCurrentState()).booleanValue() == false) goto L193;
    L196:
        r1.startReplaceGroup(1165905588);
        Object r113 = r1.rememberedValue();
        PopupProperties r410 = r111;
        if (r113 != r112.getEmpty()) goto L200;
        r113 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), null, 2, null);
        r1.updateRememberedValue(r113);
    L200:
        final MutableState r31 = (MutableState) r113;
        Density r114 = (Density) r1.consume(CompositionLocalsKt.getLocalDensity());
        int r115 = r5;
        if ((r5 & 7168) != 2048) goto L203;
        boolean r116 = true;
    L204:
        boolean r117 = r116 | r1.changed(r114);
        Object r118 = r1.rememberedValue();
        if (r117 == false) goto L207;
    L208:
        r118 = new DropdownMenuPositionProvider(r22, r114, 0, new k(r31), 4, null);
        r1.updateRememberedValue(r118);
    L209:
        final Modifier r210 = r7;
        final ScrollState r211 = r110;
        final Shape r212 = r8;
        final long r213 = r28;
        final float r32 = r24;
        final float r33 = r27;
        final BorderStroke r34 = r26;
        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) r118, r37, r410, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new AndroidMenu_androidKt$DropdownMenu$1(r210, r30, r31, r211, r212, r213, r32, r33, r34, r49), r1, 54), r1, ((r115 & 112) | 3072) | ((r115 >> 9) & 896), 0);
        r1.endReplaceGroup();
    L211:
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L213:
        final PopupProperties r35 = r410;
        final float r119 = r24;
        final float r120 = r27;
        final long r40 = r22;
        final long r45 = r28;
        final Modifier r54 = r7;
        final ScrollState r55 = r110;
        final BorderStroke r121 = r26;
    L215:
        ScopeUpdateScope r122 = r1.endRestartGroup();
        if (r122 == null) goto L219;
        r122.updateScope(new l(r36, r37, r54, r40, r55, r35, r8, r45, r119, r120, r121, r49, r51, r52, r53));
        return;
    L219:
        return;
    L207:
        if (r118 != r112.getEmpty()) goto L209;
    L203:
        r116 = false;
        goto L204
    L193:
        if (((Boolean) r30.getTargetState()).booleanValue() == true) goto L196;
        r1.startReplaceGroup(1166965571);
        r1.endReplaceGroup();
        r26 = r26;
        r410 = r111;
        goto L211
    L182:
        r26 = r48;
        goto L183
    L179:
        r25 = r47;
        goto L180
    L176:
        r24 = r46;
        goto L177
    L173:
        r23 = r44;
        goto L174
    L169:
        r8 = r43;
        goto L171
    L165:
        r111 = r42;
        goto L167
    L162:
        r110 = r41;
        goto L163
    L158:
        r22 = r12;
        goto L160
    L155:
        r7 = r10;
        goto L156
    L141:
        if (r1.getDefaultsInvalid() == true) goto L153;
        r1.skipToGroupEnd();
        if ((r53 & 16) == 0) goto L147;
        r5 = r5 & (-57345);
    L147:
        if ((r53 & 64) == 0) goto L150;
        r5 = r5 & (-3670017);
    L150:
        if ((r53 & 128) == 0) goto L152;
        r5 = r5 & (-29360129);
    L152:
        r8 = r43;
        r28 = r44;
        r24 = r46;
        r26 = r48;
        r5 = r5;
        r7 = r10;
        r22 = r12;
        r110 = r41;
        r111 = r42;
        r27 = r47;
        goto L184
    L214:
        r1.skipToGroupEnd();
        r55 = r41;
        r35 = r42;
        r8 = r43;
        r119 = r46;
        r54 = r10;
        r40 = r12;
        r45 = r44;
        r120 = r47;
        r121 = r48;
        goto L215
    L132:
        if ((r4 & 19) != 18) goto L135;
        r6 = false;
        goto L137
    L122:
        if ((r52 & 48) != 0) goto L129;
        if (r1.changedInstance(r49) == false) goto L126;
        int r123 = 32;
    L127:
        r16 = r16 | r123;
        goto L129
    L126:
        r123 = 16;
        goto L127
    L111:
        if ((r52 & 6) == 0) goto L113;
        r16 = r52;
        goto L119
    L113:
        if (r1.changed(r48) == false) goto L115;
        int r124 = 4;
    L116:
        r16 = r52 | r124;
        goto L119
    L115:
        r124 = 2;
        goto L116
    L101:
        if ((r51 & 805306368) != 0) goto L107;
        if (r1.changed(r47) == false) goto L105;
        int r214 = 536870912;
    L106:
        r5 = r5 | r214;
        goto L107
    L105:
        r214 = 268435456;
        goto L106
    L91:
        if ((r51 & 100663296) != 0) goto L97;
        if (r1.changed(r46) == false) goto L95;
        int r215 = 67108864;
    L96:
        r5 = r5 | r215;
        goto L97
    L95:
        r215 = 33554432;
        goto L96
    L61:
        if ((r51 & 196608) != 0) goto L68;
        if (r1.changed(r42) == false) goto L65;
        int r125 = 131072;
    L66:
        r5 = r5 | r125;
        goto L68
    L65:
        r125 = 65536;
        goto L66
    L39:
        if ((r51 & 3072) != 0) goto L45;
        r12 = r39;
        if (r1.changed(r12) == false) goto L43;
        int r126 = 2048;
    L44:
        r5 = r5 | r126;
        goto L47
    L43:
        r126 = 1024;
        goto L44
    L28:
        if ((r51 & 384) != 0) goto L34;
        r10 = r38;
        if (r1.changed(r10) == false) goto L32;
        int r127 = 256;
    L33:
        r5 = r5 | r127;
        goto L35
    L32:
        r127 = 128;
        goto L33
    L17:
        if ((r51 & 48) != 0) goto L24;
        if (r1.changedInstance(r37) == false) goto L21;
        int r56 = 32;
    L22:
        r5 = r5 | r56;
        goto L24
    L21:
        r56 = 16;
        goto L22
    L6:
        if ((r51 & 6) == 0) goto L8;
        r5 = r51;
        goto L14
    L8:
        if (r1.changed(r36) == false) goto L10;
        int r57 = 4;
    L11:
        r5 = r57 | r51;
        goto L14
    L10:
        r57 = 2;
        goto L11
    }
}
