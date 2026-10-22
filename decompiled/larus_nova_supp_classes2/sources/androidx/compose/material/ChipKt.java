package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001aÆ\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00192\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u001c\"\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010 \u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010\"\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u000e\u0010#\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconStartSpacing", "LeadingIconEndSpacing", "TrailingIconSpacing", "SurfaceOverlayOpacity", "", "SelectedOverlayOpacity", "SelectedIconContainerSize", "material", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChipKt {
    private static final float HorizontalPadding = 0.0f;
    private static final float LeadingIconEndSpacing = 0.0f;
    private static final float LeadingIconStartSpacing = 0.0f;
    private static final float SelectedIconContainerSize = 0.0f;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing = 0.0f;

    private static final Unit Chip$lambda$3(Function0 r13, Modifier r14, boolean r15, MutableInteractionSource r16, Shape r17, BorderStroke r18, ChipColors r19, Function2 r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        Chip(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit FilterChip$lambda$6(boolean r17, Function0 r18, Modifier r19, boolean r20, MutableInteractionSource r21, Shape r22, BorderStroke r23, SelectableChipColors r24, Function2 r25, Function2 r26, Function2 r27, Function3 r28, int r29, int r30, int r31, Composer r32, int r33) {
        FilterChip(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r1, Function0 r2, Modifier r3, boolean r4, MutableInteractionSource r5, Shape r6, BorderStroke r7, SelectableChipColors r8, Function2 r9, Function2 r10, Function2 r11, Function3 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return FilterChip$lambda$6(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
        return Chip$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ Unit c(Function0 r0, Modifier r1, boolean r2, MutableInteractionSource r3, Shape r4, BorderStroke r5, ChipColors r6, Function2 r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return Chip$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit d(SemanticsPropertyReceiver r0) {
        return FilterChip$lambda$5$lambda$4(r0);
    }

    static {
        HorizontalPadding = Dp.constructor-impl(12);
        LeadingIconStartSpacing = Dp.constructor-impl(4);
        float r0 = 8;
        LeadingIconEndSpacing = Dp.constructor-impl(r0);
        TrailingIconSpacing = Dp.constructor-impl(r0);
        SelectedIconContainerSize = Dp.constructor-impl(24);
    }

    public static final /* synthetic */ float access$getHorizontalPadding$p() {
        return HorizontalPadding;
    }

    public static final /* synthetic */ float access$getLeadingIconEndSpacing$p() {
        return LeadingIconEndSpacing;
    }

    public static final /* synthetic */ float access$getLeadingIconStartSpacing$p() {
        return LeadingIconStartSpacing;
    }

    public static final /* synthetic */ float access$getSelectedIconContainerSize$p() {
        return SelectedIconContainerSize;
    }

    public static final /* synthetic */ float access$getTrailingIconSpacing$p() {
        return TrailingIconSpacing;
    }

    private static final long Chip$lambda$0(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final Unit Chip$lambda$2$lambda$1(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit FilterChip$lambda$5$lambda$4(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ long access$Chip$lambda$0(State r2) {
        return Chip$lambda$0(r2);
    }

    public static final void Chip(final Function0<Unit> r29, Modifier r30, boolean r31, MutableInteractionSource r32, Shape r33, BorderStroke r34, ChipColors r35, Function2<? super Composer, ? super Integer, Unit> r36, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(-1232125330);
        if ((r40 & 1) == 0) goto L6;
        int r3 = r39 | 6;
    L13:
        int r4 = r40 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r40 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r31;
    L35:
        int r8 = r40 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        MutableInteractionSource r9 = r32;
    L47:
        if ((r39 & 24576) == 0) goto L49;
        Shape r12 = r33;
    L57:
        int r13 = r40 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        BorderStroke r14 = r34;
    L69:
        if ((1572864 & r39) != 0) goto L79;
        if ((r40 & 64) != 0) goto L76;
        if (r1.changed(r35) == false) goto L76;
        int r16 = 1048576;
    L77:
        r3 = r3 | r16;
    L76:
        r16 = 524288;
    L79:
        int r0 = r40 & 128;
        if (r0 == 0) goto L83;
        r3 = r3 | 12582912;
    L90:
        if ((r40 & 256) == 0) goto L93;
        r3 = r3 | 100663296;
    L101:
        if ((r3 & 38347923) == 38347922) goto L103;
        boolean r2 = true;
    L105:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L149;
        r1.startDefaults();
        if ((r39 & 1) != 0) goto L109;
    L118:
        if (r4 == 0) goto L120;
        final Modifier r5 = Modifier.Companion;
    L121:
        if (r6 == 0) goto L123;
        r7 = true;
    L123:
        if (r8 == 0) goto L126;
        r9 = null;
    L126:
        if ((r40 & 16) == 0) goto L128;
        Shape r10 = MaterialTheme.INSTANCE.getShapes(r1, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
        r3 = r3 & (-57345);
    L129:
        if (r13 == 0) goto L131;
        final BorderStroke r11 = null;
    L133:
        if ((r40 & 64) == 0) goto L135;
        ChipColors r15 = ChipDefaults.INSTANCE.m1982chipColors5tl4gsc(0, 0, 0, 0, 0, 0, r1, 1572864, 63);
        r3 = r3 & (-3670017);
    L136:
        if (r0 == 0) goto L138;
        Function2<? super Composer, ? super Integer, Unit> r17 = null;
    L139:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventStart(-1232125330, r3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
    L142:
        int r18 = ((r3 >> 6) & 14) | ((r3 >> 15) & 112);
        final State<Color> r19 = r15.contentColor(r7, r1, r18);
        Object r110 = r1.rememberedValue();
        if (r110 != Composer.Companion.getEmpty()) goto L145;
        r110 = new x2();
        r1.updateRememberedValue(r110);
    L145:
        final Function2<? super Composer, ? super Integer, Unit> r310 = r17;
        final ChipColors r311 = r15;
        final boolean r312 = r7;
        SurfaceKt.m2176SurfaceLPr_se0(r29, SemanticsModifierKt.semantics$default(r5, false, (Function1) r110, 1, null), r7, r10, ((Color) r15.backgroundColor(r7, r1, r18).getValue()).unbox-impl(), Color.copy-wmQWz5c$default(Chip$lambda$0(r19), 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r11, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, ComposableLambdaKt.rememberComposableLambda(-1849195083, true, new AnonymousClass2(r19, r310, r311, r312, r37), r1, 54), r1, (((((r3 & 14) | 805306368) | (r3 & 896)) | ((r3 >> 3) & 7168)) | ((r3 << 3) & 3670016)) | ((r3 << 15) & 234881024), 128);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        final Shape r20 = r10;
        final boolean r21 = r7;
        final ChipColors r22 = r15;
        final MutableInteractionSource r23 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r24 = r17;
    L150:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L154;
        r111.updateScope(new y2(r29, r5, r21, r23, r20, r11, r22, r24, r37, r39, r40));
        return;
    L154:
        return;
    L138:
        r17 = r36;
        goto L139
    L135:
        r15 = r35;
        goto L136
    L131:
        r11 = r14;
        goto L133
    L128:
        r10 = r12;
        goto L129
    L120:
        r5 = r30;
        goto L121
    L109:
        if (r1.getDefaultsInvalid() == true) goto L118;
        r1.skipToGroupEnd();
        if ((r40 & 16) == 0) goto L115;
        r3 = r3 & (-57345);
    L115:
        if ((r40 & 64) == 0) goto L117;
        r3 = r3 & (-3670017);
    L117:
        r5 = r30;
        r15 = r35;
        r17 = r36;
        r10 = r12;
        r11 = r14;
        goto L139
    L149:
        r1.skipToGroupEnd();
        r5 = r30;
        r24 = r36;
        r21 = r7;
        r23 = r9;
        r20 = r12;
        r11 = r14;
        r22 = r35;
        goto L150
    L103:
        r2 = false;
        goto L105
    L93:
        if ((r39 & 100663296) != 0) goto L101;
        if (r1.changedInstance(r37) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L101
    L97:
        r112 = 33554432;
        goto L98
    L83:
        if ((r39 & 12582912) != 0) goto L90;
        if (r1.changedInstance(r36) == false) goto L87;
        int r113 = 8388608;
    L88:
        r3 = r3 | r113;
        goto L90
    L87:
        r113 = 4194304;
        goto L88
    L61:
        if ((196608 & r39) != 0) goto L67;
        r14 = r34;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L69
    L65:
        r114 = 65536;
        goto L66
    L49:
        if ((r40 & 16) != 0) goto L53;
        r12 = r33;
        if (r1.changed(r12) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r12 = r33;
        goto L54
    L39:
        if ((r39 & 3072) != 0) goto L45;
        r9 = r32;
        if (r1.changed(r9) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r39 & 384) != 0) goto L34;
        r7 = r31;
        if (r1.changed(r7) == false) goto L32;
        int r25 = 256;
    L33:
        r3 = r3 | r25;
        goto L35
    L32:
        r25 = 128;
        goto L33
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r1.changed(r30) == false) goto L21;
        int r26 = 32;
    L22:
        r3 = r3 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r3 = r39;
        goto L13
    L8:
        if (r1.changedInstance(r29) == false) goto L10;
        int r27 = 4;
    L11:
        r3 = r27 | r39;
        goto L13
    L10:
        r27 = 2;
        goto L11
    }

    public static final void FilterChip(final boolean r41, final Function0<Unit> r42, Modifier r43, boolean r44, MutableInteractionSource r45, Shape r46, BorderStroke r47, SelectableChipColors r48, Function2<? super Composer, ? super Integer, Unit> r49, Function2<? super Composer, ? super Integer, Unit> r50, Function2<? super Composer, ? super Integer, Unit> r51, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r52, Composer r53, final int r54, final int r55, final int r56) {
        Composer r4 = r53.startRestartGroup(69602198);
        if ((r56 & 1) == 0) goto L6;
        int r2 = r54 | 6;
    L14:
        if ((r56 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L23:
        int r6 = r56 & 4;
        if (r6 == 0) goto L27;
        r2 = r2 | 384;
    L34:
        int r14 = r56 & 8;
        if (r14 == 0) goto L38;
        r2 = r2 | 3072;
    L45:
        int r16 = r56 & 16;
        if (r16 == 0) goto L49;
        r2 = r2 | 24576;
    L57:
        if ((r54 & 196608) != 0) goto L65;
        Shape r5 = r46;
        if ((r56 & 32) == 0) goto L61;
    L63:
        int r18 = 65536;
    L64:
        r2 = r2 | r18;
    L66:
        int r19 = r56 & 64;
        if (r19 == 0) goto L69;
        r2 = r2 | 1572864;
        final BorderStroke r7 = r47;
    L77:
        if ((r54 & 12582912) == 0) goto L79;
    L88:
        int r8 = r56 & 256;
        if (r8 == 0) goto L92;
        r2 = r2 | 100663296;
    L98:
        int r15 = r56 & 512;
        if (r15 == 0) goto L102;
        r2 = r2 | 805306368;
    L109:
        int r17 = r56 & 1024;
        if (r17 == 0) goto L113;
        int r110 = r55 | 6;
    L121:
        if ((r56 & 2048) == 0) goto L124;
        r110 = r110 | 48;
    L131:
        int r111 = r110;
        if ((r2 & 306783379) == 306783378) goto L134;
    L137:
        boolean r0 = true;
    L139:
        if (r4.shouldExecute(r0, r2 & 1) == false) goto L190;
        r4.startDefaults();
        if ((r54 & 1) != 0) goto L143;
    L152:
        if (r6 == 0) goto L154;
        Modifier r1 = Modifier.Companion;
    L155:
        if (r14 == 0) goto L157;
        boolean r9 = true;
    L158:
        if (r16 == 0) goto L160;
        MutableInteractionSource r36 = null;
    L162:
        if ((r56 & 32) == 0) goto L164;
        r5 = MaterialTheme.INSTANCE.getShapes(r4, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
        r2 = r2 & (-458753);
    L164:
        if (r19 == 0) goto L167;
        r7 = null;
    L167:
        if ((r56 & 128) == 0) goto L169;
        SelectableChipColors r112 = ChipDefaults.INSTANCE.m1983filterChipColorsJ08w3E(0, 0, 0, 0, 0, 0, 0, 0, 0, r4, 805306368, 511);
        r2 = (-29360129) & r2;
    L170:
        if (r8 == 0) goto L172;
        Function2<? super Composer, ? super Integer, Unit> r3 = null;
    L173:
        if (r15 == 0) goto L175;
        Function2<? super Composer, ? super Integer, Unit> r10 = null;
    L176:
        if (r17 == 0) goto L178;
        Function2<? super Composer, ? super Integer, Unit> r21 = null;
    L179:
        Modifier r11 = r1;
        int r113 = r2;
        boolean r12 = r9;
    L180:
        r4.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L183;
        ComposerKt.traceEventStart(69602198, r113, r111, "androidx.compose.material.FilterChip (Chip.kt:194)");
    L183:
        int r13 = r113 << 3;
        int r20 = ((r113 >> 9) & 14) | (r13 & 112);
        int r22 = ((r113 >> 15) & 896) | r20;
        final State<Color> r114 = r112.contentColor(r12, r41, r4, r22);
        Object r23 = r4.rememberedValue();
        if (r23 != Composer.Companion.getEmpty()) goto L186;
        r23 = new v2();
        r4.updateRememberedValue(r23);
    L186:
        Modifier r24 = r11;
        final Function2<? super Composer, ? super Integer, Unit> r410 = r3;
        final Function2<? super Composer, ? super Integer, Unit> r411 = r10;
        final Function2<? super Composer, ? super Integer, Unit> r412 = r21;
        final SelectableChipColors r57 = r112;
        final boolean r58 = r12;
        boolean r25 = r12;
        SelectableChipColors r26 = r112;
        Composer r27 = r4;
        Shape r28 = r5;
        BorderStroke r29 = r7;
        MutableInteractionSource r115 = r36;
        SurfaceKt.m2177SurfaceNy5ogXk(r41, r42, SemanticsModifierKt.semantics$default(r11, false, (Function1) r23, 1, null), r25, r28, ((Color) r112.backgroundColor(r12, r41, r4, r22).getValue()).unbox-impl(), Color.copy-wmQWz5c$default(((Color) r114.getValue()).unbox-impl(), 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r29, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r115, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new C02412(r114, r410, r41, r411, r412, r52, r57, r58), r4, 54), r27, (((((r113 & 14) | (r113 & 112)) | (r113 & 7168)) | ((r113 >> 3) & 57344)) | (29360128 & r13)) | ((r113 << 15) & 1879048192), 6, 256);
        if (ComposerKt.isTraceInProgress() == false) goto L189;
        ComposerKt.traceEventEnd();
    L189:
        final Shape r30 = r5;
        r7 = r7;
        final Function2<? super Composer, ? super Integer, Unit> r31 = r3;
        final Function2<? super Composer, ? super Integer, Unit> r116 = r10;
        final Function2<? super Composer, ? super Integer, Unit> r117 = r21;
        final boolean r32 = r25;
        final Modifier r33 = r24;
        final SelectableChipColors r34 = r26;
        final MutableInteractionSource r35 = r36;
    L191:
        ScopeUpdateScope r118 = r27.endRestartGroup();
        if (r118 == null) goto L195;
        r118.updateScope(new w2(r41, r42, r33, r32, r35, r30, r7, r34, r31, r116, r117, r52, r54, r55, r56));
        return;
    L195:
        return;
    L178:
        r21 = r51;
        goto L179
    L175:
        r10 = r50;
        goto L176
    L172:
        r3 = r49;
        goto L173
    L169:
        r112 = r48;
        goto L170
    L160:
        r36 = r45;
        goto L162
    L157:
        r9 = r44;
        goto L158
    L154:
        r1 = r43;
        goto L155
    L143:
        if (r4.getDefaultsInvalid() == true) goto L152;
        r4.skipToGroupEnd();
        if ((r56 & 32) == 0) goto L149;
        r2 = r2 & (-458753);
    L149:
        if ((r56 & 128) == 0) goto L151;
        r2 = r2 & (-29360129);
    L151:
        r11 = r43;
        r12 = r44;
        r36 = r45;
        r3 = r49;
        r10 = r50;
        r21 = r51;
        r113 = r2;
        r5 = r5;
        r7 = r7;
        r111 = r111;
        r112 = r48;
        goto L180
    L190:
        r27 = r4;
        r27.skipToGroupEnd();
        r33 = r43;
        r32 = r44;
        r34 = r48;
        r31 = r49;
        r116 = r50;
        r117 = r51;
        r30 = r5;
        r35 = r45;
        goto L191
    L134:
        if ((r111 & 19) != 18) goto L137;
        r0 = false;
        goto L139
    L124:
        if ((r55 & 48) != 0) goto L131;
        if (r4.changedInstance(r52) == false) goto L128;
        int r119 = 32;
    L129:
        r110 = r110 | r119;
        goto L131
    L128:
        r119 = 16;
        goto L129
    L113:
        if ((r55 & 6) == 0) goto L115;
        r110 = r55;
        goto L121
    L115:
        if (r4.changedInstance(r51) == false) goto L117;
        int r120 = 4;
    L118:
        r110 = r55 | r120;
        goto L121
    L117:
        r120 = 2;
        goto L118
    L102:
        if ((r54 & 805306368) != 0) goto L109;
        if (r4.changedInstance(r50) == false) goto L106;
        int r210 = 536870912;
    L107:
        r2 = r2 | r210;
        goto L109
    L106:
        r210 = 268435456;
        goto L107
    L92:
        if ((r54 & 100663296) != 0) goto L98;
        if (r4.changedInstance(r49) == false) goto L96;
        int r211 = 67108864;
    L97:
        r2 = r2 | r211;
        goto L98
    L96:
        r211 = 33554432;
        goto L97
    L79:
        if ((r56 & 128) == 0) goto L81;
    L86:
        int r37 = 4194304;
    L87:
        r2 = r2 | r37;
        goto L88
    L81:
        if ((16777216 & r54) != 0) goto L83;
        boolean r38 = r4.changed(r48);
    L84:
        if (r38 == false) goto L86;
        r37 = 8388608;
        goto L87
    L83:
        r38 = r4.changedInstance(r48);
        goto L84
    L69:
        r7 = r47;
        if ((r54 & 1572864) != 0) goto L77;
        if (r4.changed(r7) == false) goto L74;
        int r212 = 1048576;
    L75:
        r2 = r2 | r212;
        goto L77
    L74:
        r212 = 524288;
        goto L75
    L61:
        if (r4.changed(r5) == false) goto L63;
        r18 = 131072;
        goto L64
    L65:
        r5 = r46;
        goto L66
    L49:
        if ((r54 & 24576) != 0) goto L57;
        if (r4.changed(r45) == false) goto L53;
        int r121 = 16384;
    L54:
        r2 = r2 | r121;
        goto L57
    L53:
        r121 = 8192;
        goto L54
    L38:
        if ((r54 & 3072) != 0) goto L45;
        if (r4.changed(r44) == false) goto L42;
        int r122 = 2048;
    L43:
        r2 = r2 | r122;
        goto L45
    L42:
        r122 = 1024;
        goto L43
    L27:
        if ((r54 & 384) != 0) goto L34;
        if (r4.changed(r43) == false) goto L31;
        int r123 = 256;
    L32:
        r2 = r2 | r123;
        goto L34
    L31:
        r123 = 128;
        goto L32
    L17:
        if ((r54 & 48) != 0) goto L23;
        if (r4.changedInstance(r42) == false) goto L21;
        int r39 = 32;
    L22:
        r2 = r2 | r39;
        goto L23
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r54 & 6) == 0) goto L8;
        r2 = r54;
        goto L14
    L8:
        if (r4.changed(r41) == false) goto L10;
        int r40 = 4;
    L11:
        r2 = r40 | r54;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }
}
