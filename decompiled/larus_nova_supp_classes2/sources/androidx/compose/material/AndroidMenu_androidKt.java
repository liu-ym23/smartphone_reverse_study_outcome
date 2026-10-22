package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
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
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001ac\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001f\"\u0014\u0010 \u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "scrollState", "Landroidx/compose/foundation/ScrollState;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = null;

    private static final Unit DropdownMenuItem$lambda$6(Function0 r10, Modifier r11, boolean r12, PaddingValues r13, MutableInteractionSource r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        DropdownMenuItem(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenu_4kj__NE$lambda$5(boolean r12, Function0 r13, Modifier r14, long r15, ScrollState r17, PopupProperties r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m1920DropdownMenu4kj_NE(r12, r13, r14, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenu_ILWXrKs$lambda$0(boolean r11, Function0 r12, Modifier r13, long r14, PopupProperties r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        m1921DropdownMenuILWXrKs(r11, r12, r13, r14, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, Function0 r1, Modifier r2, long r3, ScrollState r5, PopupProperties r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return DropdownMenu_4kj__NE$lambda$5(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(MutableState r0, IntRect r1, IntRect r2) {
        return DropdownMenu_4kj__NE$lambda$4$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(Function0 r0, Modifier r1, boolean r2, PaddingValues r3, MutableInteractionSource r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return DropdownMenuItem$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit d(boolean r0, Function0 r1, Modifier r2, long r3, PopupProperties r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return DropdownMenu_ILWXrKs$lambda$0(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    static {
        DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, null);
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }

    private static final Unit DropdownMenu_4kj__NE$lambda$4$lambda$3(MutableState r0, IntRect r1, IntRect r2) {
        r0.setValue(TransformOrigin.box-impl(MenuKt.calculateTransformOrigin(r1, r2)));
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m1921DropdownMenuILWXrKs(final boolean r25, final Function0 r26, Modifier r27, long r28, PopupProperties r30, final Function3 r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-2042390678);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L14:
        if ((r34 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r34 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r7 = r27;
    L35:
        int r9 = r34 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        long r10 = r28;
    L46:
        int r12 = r34 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        PopupProperties r13 = r30;
    L58:
        if ((r34 & 32) == 0) goto L61;
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
        ComposerKt.traceEventStart(-2042390678, r3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:56)");
    L84:
        int r15 = (((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168);
        int r16 = r3 << 3;
        m1920DropdownMenu4kj_NE(r25, r26, r7, r5, ScrollKt.rememberScrollState(0, r1, 0, 1), r4, r31, r1, (r15 | (458752 & r16)) | (r16 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventEnd();
    L87:
        r10 = r5;
        final Modifier r17 = r7;
        final PopupProperties r18 = r4;
    L89:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L93;
        final long r20 = r10;
        r19.updateScope(new v(r25, r26, r17, r20, r18, r31, r33, r34));
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
        r17 = r7;
        r18 = r13;
        goto L89
    L70:
        r0 = false;
        goto L72
    L61:
        if ((r33 & 196608) != 0) goto L68;
        if (r1.changedInstance(r31) == false) goto L65;
        int r110 = 131072;
    L66:
        r3 = r3 | r110;
        goto L68
    L65:
        r110 = 65536;
        goto L66
    L50:
        if ((r33 & 24576) != 0) goto L56;
        r13 = r30;
        if (r1.changed(r13) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r10 = r28;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L46
    L43:
        r112 = 1024;
        goto L44
    L28:
        if ((r33 & 384) != 0) goto L34;
        r7 = r27;
        if (r1.changed(r7) == false) goto L32;
        int r21 = 256;
    L33:
        r3 = r3 | r21;
        goto L35
    L32:
        r21 = 128;
        goto L33
    L17:
        if ((r33 & 48) != 0) goto L24;
        if (r1.changedInstance(r26) == false) goto L21;
        int r22 = 32;
    L22:
        r3 = r3 | r22;
        goto L24
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L14
    L8:
        if (r1.changed(r25) == false) goto L10;
        int r23 = 4;
    L11:
        r3 = r23 | r33;
        goto L14
    L10:
        r23 = 2;
        goto L11
    }

    public static final void DropdownMenuItem(final Function0<Unit> r18, Modifier r19, boolean r20, PaddingValues r21, MutableInteractionSource r22, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(670540513);
        if ((r26 & 1) == 0) goto L6;
        int r3 = r25 | 6;
    L13:
        int r4 = r26 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r19;
    L24:
        int r6 = r26 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r8 = r20;
    L35:
        int r9 = r26 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        PaddingValues r10 = r21;
    L46:
        int r11 = r26 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        MutableInteractionSource r12 = r22;
    L58:
        if ((r26 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r13 = true;
    L72:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L92;
        if (r4 == 0) goto L75;
        Modifier r7 = Modifier.Companion;
    L76:
        if (r6 == 0) goto L78;
        boolean r14 = true;
    L79:
        if (r9 == 0) goto L81;
        PaddingValues r15 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
    L82:
        if (r11 == 0) goto L84;
        MutableInteractionSource r17 = null;
    L86:
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventStart(670540513, r3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
    L88:
        MenuKt.DropdownMenuItemContent(r18, r7, r14, r15, r17, r23, r1, (((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (r3 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
    L91:
        final boolean r16 = r14;
        r10 = r15;
        final MutableInteractionSource r27 = r17;
    L93:
        ScopeUpdateScope r28 = r1.endRestartGroup();
        if (r28 == null) goto L97;
        final Modifier r2 = r7;
        final PaddingValues r29 = r10;
        r28.updateScope(new w(r18, r2, r16, r29, r27, r23, r25, r26));
        return;
    L97:
        return;
    L84:
        r17 = r12;
        goto L86
    L81:
        r15 = r10;
        goto L82
    L78:
        r14 = r8;
        goto L79
    L75:
        r7 = r5;
        goto L76
    L92:
        r1.skipToGroupEnd();
        r7 = r5;
        r16 = r8;
        r27 = r12;
        goto L93
    L70:
        r13 = false;
        goto L72
    L61:
        if ((r25 & 196608) != 0) goto L68;
        if (r1.changedInstance(r23) == false) goto L65;
        int r110 = 131072;
    L66:
        r3 = r3 | r110;
        goto L68
    L65:
        r110 = 65536;
        goto L66
    L50:
        if ((r25 & 24576) != 0) goto L56;
        r12 = r22;
        if (r1.changed(r12) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L39:
        if ((r25 & 3072) != 0) goto L45;
        r10 = r21;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L46
    L43:
        r112 = 1024;
        goto L44
    L28:
        if ((r25 & 384) != 0) goto L34;
        r8 = r20;
        if (r1.changed(r8) == false) goto L32;
        int r30 = 256;
    L33:
        r3 = r3 | r30;
        goto L35
    L32:
        r30 = 128;
        goto L33
    L17:
        if ((r25 & 48) != 0) goto L23;
        r5 = r19;
        if (r1.changed(r5) == false) goto L21;
        int r31 = 32;
    L22:
        r3 = r3 | r31;
        goto L24
    L21:
        r31 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r3 = r25;
        goto L13
    L8:
        if (r1.changedInstance(r18) == false) goto L10;
        int r32 = 4;
    L11:
        r3 = r32 | r25;
        goto L13
    L10:
        r32 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final void m1920DropdownMenu4kj_NE(final boolean r23, final Function0<Unit> r24, Modifier r25, long r26, ScrollState r28, PopupProperties r29, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r8 = r31.startRestartGroup(1275450738);
        if ((r33 & 1) == 0) goto L6;
        int r1 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r33 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r5 = r25;
    L34:
        int r6 = r33 & 8;
        if (r6 == 0) goto L37;
        r1 = r1 | 3072;
        long r12 = r26;
    L45:
        if ((r32 & 24576) != 0) goto L55;
        if ((r33 & 16) != 0) goto L52;
        if (r8.changed(r28) == false) goto L52;
        int r14 = 16384;
    L53:
        r1 = r1 | r14;
    L52:
        r14 = 8192;
    L55:
        int r15 = r33 & 32;
        if (r15 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        PopupProperties r16 = r29;
    L67:
        if ((r33 & 64) == 0) goto L70;
        r1 = r1 | 1572864;
    L77:
        if ((r1 & 599187) == 599186) goto L79;
        boolean r0 = true;
    L81:
        if (r8.shouldExecute(r0, r1 & 1) == false) goto L126;
        r8.startDefaults();
        if ((r32 & 1) != 0) goto L85;
    L92:
        if (r3 == 0) goto L94;
        r5 = Modifier.Companion;
    L94:
        if (r6 == 0) goto L97;
        float r4 = 0;
        float r2 = Dp.constructor-impl(r4);
        float r7 = Dp.constructor-impl(r4);
        long r13 = Float.floatToRawIntBits(r2);
        r12 = DpOffset.constructor-impl((((long) Float.floatToRawIntBits(r7)) & 4294967295L) | (r13 << 32));
    L97:
        if ((r33 & 16) == 0) goto L99;
        ScrollState r9 = ScrollKt.rememberScrollState(0, r8, 0, 1);
        r1 = r1 & (-57345);
    L100:
        if (r15 == 0) goto L102;
        ScrollState r17 = r9;
        r16 = DefaultMenuProperties;
    L91:
        final Modifier r10 = r5;
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventStart(1275450738, r1, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
    L106:
        Object r11 = r8.rememberedValue();
        Composer.Companion r18 = Composer.Companion;
        if (r11 != r18.getEmpty()) goto L109;
        r11 = new MutableTransitionState(Boolean.FALSE);
        r8.updateRememberedValue(r11);
    L109:
        final MutableTransitionState r19 = (MutableTransitionState) r11;
        r19.setTargetState(Boolean.valueOf(r23));
        if (((Boolean) r19.getCurrentState()).booleanValue() == false) goto L112;
    L115:
        r8.startReplaceGroup(-622275818);
        Object r20 = r8.rememberedValue();
        if (r20 != r18.getEmpty()) goto L118;
        r20 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), null, 2, null);
        r8.updateRememberedValue(r20);
    L118:
        final MutableState r21 = (MutableState) r20;
        Density r22 = (Density) r8.consume(CompositionLocalsKt.getLocalDensity());
        Object r27 = r8.rememberedValue();
        if (r27 != r18.getEmpty()) goto L121;
        r27 = new t(r21);
        r8.updateRememberedValue(r27);
    L121:
        DropdownMenuPositionProvider r34 = new DropdownMenuPositionProvider(r12, r22, (Function2) r27, null);
        final ScrollState r210 = r17;
        AndroidPopup_androidKt.Popup(r34, r24, r16, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new AndroidMenu_androidKt$DropdownMenu$2(r19, r21, r210, r10, r30), r8, 54), r8, ((r1 & 112) | 3072) | ((r1 >> 9) & 896), 0);
        r8.endReplaceGroup();
    L123:
        if (ComposerKt.isTraceInProgress() == false) goto L125;
        ComposerKt.traceEventEnd();
    L125:
        final Modifier r35 = r10;
        final long r36 = r12;
        final ScrollState r37 = r17;
    L127:
        final PopupProperties r38 = r16;
        ScopeUpdateScope r110 = r8.endRestartGroup();
        if (r110 == null) goto L131;
        r110.updateScope(new u(r23, r24, r35, r36, r37, r38, r30, r32, r33));
        return;
    L131:
        return;
    L112:
        if (((Boolean) r19.getTargetState()).booleanValue() == true) goto L115;
        r8.startReplaceGroup(-621482032);
        r8.endReplaceGroup();
        goto L123
    L102:
        r17 = r9;
        goto L91
    L99:
        r9 = r28;
        goto L100
    L85:
        if (r8.getDefaultsInvalid() == true) goto L92;
        r8.skipToGroupEnd();
        if ((r33 & 16) == 0) goto L90;
        r1 = r1 & (-57345);
    L90:
        r17 = r28;
        goto L91
    L126:
        r8.skipToGroupEnd();
        r37 = r28;
        r35 = r5;
        r36 = r12;
        goto L127
    L79:
        r0 = false;
        goto L81
    L70:
        if ((r32 & 1572864) != 0) goto L77;
        if (r8.changedInstance(r30) == false) goto L74;
        int r111 = 1048576;
    L75:
        r1 = r1 | r111;
        goto L77
    L74:
        r111 = 524288;
        goto L75
    L59:
        if ((196608 & r32) != 0) goto L65;
        r16 = r29;
        if (r8.changed(r16) == false) goto L63;
        int r112 = 131072;
    L64:
        r1 = r1 | r112;
        goto L67
    L63:
        r112 = 65536;
        goto L64
    L37:
        r12 = r26;
        if ((r32 & 3072) != 0) goto L45;
        if (r8.changed(r12) == false) goto L42;
        int r39 = 2048;
    L43:
        r1 = r1 | r39;
        goto L45
    L42:
        r39 = 1024;
        goto L43
    L27:
        if ((r32 & 384) != 0) goto L33;
        r5 = r25;
        if (r8.changed(r5) == false) goto L31;
        int r40 = 256;
    L32:
        r1 = r1 | r40;
        goto L34
    L31:
        r40 = 128;
        goto L32
    L17:
        if ((r32 & 48) != 0) goto L23;
        if (r8.changedInstance(r24) == false) goto L21;
        int r41 = 32;
    L22:
        r1 = r1 | r41;
        goto L23
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r1 = r32;
        goto L14
    L8:
        if (r8.changed(r23) == false) goto L10;
        int r42 = 4;
    L11:
        r1 = r42 | r32;
        goto L14
    L10:
        r42 = 2;
        goto L11
    }
}
