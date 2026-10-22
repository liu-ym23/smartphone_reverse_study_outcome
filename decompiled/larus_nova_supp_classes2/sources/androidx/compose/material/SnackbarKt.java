package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u001au\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a \u0010\u0018\u001a\u00020\u00012\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0019\u001a3\u0010\u001a\u001a\u00020\u00012\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001d\u001a\u00020\u00012\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u001c\"\u0010\u0010\u001e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010 \u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010\"\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010#\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010$\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010%\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010&\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010'\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006("}, d2 = {"Snackbar", "", "modifier", "Landroidx/compose/ui/Modifier;", "action", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "snackbarData", "Landroidx/compose/material/SnackbarData;", "actionColor", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "NewLineButtonSnackbar", "text", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "HeightToFirstLine", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt {
    private static final float HeightToFirstLine = 0.0f;
    private static final float HorizontalSpacing = 0.0f;
    private static final float HorizontalSpacingButtonSide = 0.0f;
    private static final float LongButtonVerticalOffset = 0.0f;
    private static final float SeparateButtonExtraY = 0.0f;
    private static final float SnackbarMinHeightOneLine = 0.0f;
    private static final float SnackbarMinHeightTwoLines = 0.0f;
    private static final float SnackbarVerticalPadding = 0.0f;
    private static final float TextEndExtraSpacing = 0.0f;

    private static final Unit NewLineButtonSnackbar$lambda$9(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        NewLineButtonSnackbar(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit OneRowSnackbar$lambda$14(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        OneRowSnackbar(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Snackbar_7zSek6w$lambda$0(Modifier r14, Function2 r15, boolean r16, Shape r17, long r18, long r20, float r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m2155Snackbar7zSek6w(r14, r15, r16, r17, r18, r20, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit Snackbar_sPrSdHI$lambda$1(SnackbarData r15, Modifier r16, boolean r17, Shape r18, long r19, long r21, long r23, float r25, int r26, int r27, Composer r28, int r29) {
        m2156SnackbarsPrSdHI(r15, r16, r17, r18, r19, r21, r23, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit TextOnlySnackbar$lambda$5(Function2 r0, int r1, Composer r2, int r3) {
        TextOnlySnackbar(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        return NewLineButtonSnackbar$lambda$9(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(Modifier r0, Function2 r1, boolean r2, Shape r3, long r4, long r6, float r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return Snackbar_7zSek6w$lambda$0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(SnackbarData r0, Modifier r1, boolean r2, Shape r3, long r4, long r6, long r8, float r10, int r11, int r12, Composer r13, int r14) {
        return Snackbar_sPrSdHI$lambda$1(r0, r1, r2, r3, r4, r6, r8, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit d(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        return OneRowSnackbar$lambda$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit e(Function2 r0, int r1, Composer r2, int r3) {
        return TextOnlySnackbar$lambda$5(r0, r1, r2, r3);
    }

    static {
        HeightToFirstLine = Dp.constructor-impl(30);
        HorizontalSpacing = Dp.constructor-impl(16);
        float r0 = 8;
        HorizontalSpacingButtonSide = Dp.constructor-impl(r0);
        SeparateButtonExtraY = Dp.constructor-impl(2);
        SnackbarVerticalPadding = Dp.constructor-impl(6);
        TextEndExtraSpacing = Dp.constructor-impl(r0);
        LongButtonVerticalOffset = Dp.constructor-impl(12);
        SnackbarMinHeightOneLine = Dp.constructor-impl(48);
        SnackbarMinHeightTwoLines = Dp.constructor-impl(68);
    }

    public static final /* synthetic */ float access$getHeightToFirstLine$p() {
        return HeightToFirstLine;
    }

    public static final /* synthetic */ float access$getSnackbarMinHeightOneLine$p() {
        return SnackbarMinHeightOneLine;
    }

    public static final /* synthetic */ float access$getSnackbarMinHeightTwoLines$p() {
        return SnackbarMinHeightTwoLines;
    }

    public static final /* synthetic */ float access$getTextEndExtraSpacing$p() {
        return TextEndExtraSpacing;
    }

    private static final void TextOnlySnackbar(final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(343813818);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r13.shouldExecute(r2, r1 & 1) == true) goto L17;
        r13.skipToGroupEnd();
    L50:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L54;
        r14.updateScope(new qa(r10, r12));
        return;
    L54:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(343813818, r1, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:235)");
    L19:
        Object r0 = r13.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L22;
        r0 = SnackbarKt$TextOnlySnackbar$2$1.INSTANCE;
        r13.updateRememberedValue(r0);
    L22:
        MeasurePolicy r3 = (MeasurePolicy) r0;
        Modifier.Companion r4 = Modifier.Companion;
        int r5 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r6 = r13.getCurrentCompositionLocalMap();
        Modifier r7 = ComposedModifierKt.materializeModifier(r13, r4);
        ComposeUiNode.Companion r8 = ComposeUiNode.Companion;
        Function0 r9 = r8.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L25;
        ComposablesKt.invalidApplier();
    L25:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L28;
        r13.createNode(r9);
    L29:
        Composer r15 = Updater.constructor-impl(r13);
        Updater.set-impl(r15, r3, r8.getSetMeasurePolicy());
        Updater.set-impl(r15, r6, r8.getSetResolvedCompositionLocals());
        Function2 r16 = r8.getSetCompositeKeyHash();
        if (r15.getInserting() == false) goto L32;
    L33:
        r15.updateRememberedValue(Integer.valueOf(r5));
        r15.apply(Integer.valueOf(r5), r16);
    L34:
        Updater.set-impl(r15, r7, r8.getSetModifier());
        Modifier r17 = PaddingKt.m961paddingVpY3zN4(r4, HorizontalSpacing, SnackbarVerticalPadding);
        MeasurePolicy r18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r19 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r20 = r13.getCurrentCompositionLocalMap();
        Modifier r21 = ComposedModifierKt.materializeModifier(r13, r17);
        Function0 r22 = r8.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L37;
        ComposablesKt.invalidApplier();
    L37:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L40;
        r13.createNode(r22);
    L41:
        Composer r23 = Updater.constructor-impl(r13);
        Updater.set-impl(r23, r18, r8.getSetMeasurePolicy());
        Updater.set-impl(r23, r20, r8.getSetResolvedCompositionLocals());
        Function2 r24 = r8.getSetCompositeKeyHash();
        if (r23.getInserting() == false) goto L44;
    L45:
        r23.updateRememberedValue(Integer.valueOf(r19));
        r23.apply(Integer.valueOf(r19), r24);
    L46:
        Updater.set-impl(r23, r21, r8.getSetModifier());
        BoxScopeInstance r25 = BoxScopeInstance.INSTANCE;
        r10.invoke(r13, Integer.valueOf(r1 & 14));
        r13.endNode();
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventEnd();
        goto L50
    L44:
        if (Intrinsics.areEqual(r23.rememberedValue(), Integer.valueOf(r19)) == true) goto L46;
    L40:
        r13.useNode();
        goto L41
    L32:
        if (Intrinsics.areEqual(r15.rememberedValue(), Integer.valueOf(r5)) == true) goto L34;
    L28:
        r13.useNode();
        goto L29
    L13:
        r2 = false;
        goto L15
    L5:
        if (r13.changedInstance(r10) == false) goto L7;
        int r26 = 4;
    L8:
        r1 = r26 | r12;
        goto L11
    L7:
        r26 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$TextOnlySnackbar(Function2 r0, Composer r1, int r2) {
        TextOnlySnackbar(r0, r1, r2);
    }

    private static final void NewLineButtonSnackbar(final Function2<? super Composer, ? super Integer, Unit> r21, final Function2<? super Composer, ? super Integer, Unit> r22, Composer r23, final int r24) {
        Composer r4 = r23.startRestartGroup(-1534293206);
        if ((r24 & 6) == 0) goto L5;
        int r5 = r24;
    L11:
        if ((r24 & 48) != 0) goto L18;
        if (r4.changedInstance(r22) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r5 & 19) == 18) goto L20;
        boolean r7 = true;
    L22:
        if (r4.shouldExecute(r7, r5 & 1) == true) goto L24;
        r4.skipToGroupEnd();
    L66:
        ScopeUpdateScope r3 = r4.endRestartGroup();
        if (r3 == null) goto L70;
        r3.updateScope(new pa(r21, r22, r24));
        return;
    L70:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1534293206, r5, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:289)");
    L26:
        Modifier r8 = Modifier.Companion;
        Modifier r10 = SizeKt.fillMaxWidth$default(r8, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null);
        float r11 = HorizontalSpacing;
        float r9 = HorizontalSpacingButtonSide;
        Modifier r12 = PaddingKt.m964paddingqDBjuR0$default(r10, r11, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, SeparateButtonExtraY, 2, null);
        Arrangement.Vertical r13 = Arrangement.INSTANCE.getTop();
        Alignment.Companion r14 = Alignment.Companion;
        MeasurePolicy r15 = ColumnKt.columnMeasurePolicy(r13, r14.getStart(), r4, 0);
        int r16 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r17 = r4.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r4, r12);
        ComposeUiNode.Companion r20 = ComposeUiNode.Companion;
        Function0 r19 = r20.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L29;
        ComposablesKt.invalidApplier();
    L29:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L32;
        r4.createNode(r19);
    L33:
        Composer r110 = Updater.constructor-impl(r4);
        Updater.set-impl(r110, r15, r20.getSetMeasurePolicy());
        Updater.set-impl(r110, r17, r20.getSetResolvedCompositionLocals());
        Function2 r25 = r20.getSetCompositeKeyHash();
        if (r110.getInserting() == false) goto L36;
    L37:
        r110.updateRememberedValue(Integer.valueOf(r16));
        r110.apply(Integer.valueOf(r16), r25);
    L38:
        Updater.set-impl(r110, r18, r20.getSetModifier());
        ColumnScopeInstance r26 = ColumnScopeInstance.INSTANCE;
        Modifier r27 = PaddingKt.m964paddingqDBjuR0$default(AlignmentLineKt.m776paddingFromBaselineVpY3zN4(r8, HeightToFirstLine, LongButtonVerticalOffset), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 11, null);
        MeasurePolicy r28 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getTopStart(), false);
        int r111 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r112 = r4.getCurrentCompositionLocalMap();
        Modifier r29 = ComposedModifierKt.materializeModifier(r4, r27);
        Function0 r113 = r20.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L41;
        ComposablesKt.invalidApplier();
    L41:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L44;
        r4.createNode(r113);
    L45:
        Composer r114 = Updater.constructor-impl(r4);
        Updater.set-impl(r114, r28, r20.getSetMeasurePolicy());
        Updater.set-impl(r114, r112, r20.getSetResolvedCompositionLocals());
        Function2 r30 = r20.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L48;
    L49:
        r114.updateRememberedValue(Integer.valueOf(r111));
        r114.apply(Integer.valueOf(r111), r30);
    L50:
        Updater.set-impl(r114, r29, r20.getSetModifier());
        BoxScopeInstance r31 = BoxScopeInstance.INSTANCE;
        r21.invoke(r4, Integer.valueOf(r5 & 14));
        r4.endNode();
        Modifier r32 = r26.align(r8, r14.getEnd());
        MeasurePolicy r33 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getTopStart(), false);
        int r34 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r35 = r4.getCurrentCompositionLocalMap();
        Modifier r36 = ComposedModifierKt.materializeModifier(r4, r32);
        Function0 r37 = r20.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L53;
        ComposablesKt.invalidApplier();
    L53:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L56;
        r4.createNode(r37);
    L57:
        Composer r38 = Updater.constructor-impl(r4);
        Updater.set-impl(r38, r33, r20.getSetMeasurePolicy());
        Updater.set-impl(r38, r35, r20.getSetResolvedCompositionLocals());
        Function2 r39 = r20.getSetCompositeKeyHash();
        if (r38.getInserting() == false) goto L60;
    L61:
        r38.updateRememberedValue(Integer.valueOf(r34));
        r38.apply(Integer.valueOf(r34), r39);
    L62:
        Updater.set-impl(r38, r36, r20.getSetModifier());
        r22.invoke(r4, Integer.valueOf((r5 >> 3) & 14));
        r4.endNode();
        r4.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
        goto L66
    L60:
        if (Intrinsics.areEqual(r38.rememberedValue(), Integer.valueOf(r34)) == true) goto L62;
    L56:
        r4.useNode();
        goto L57
    L48:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r111)) == true) goto L50;
    L44:
        r4.useNode();
        goto L45
    L36:
        if (Intrinsics.areEqual(r110.rememberedValue(), Integer.valueOf(r16)) == true) goto L38;
    L32:
        r4.useNode();
        goto L33
    L20:
        r7 = false;
        goto L22
    L5:
        if (r4.changedInstance(r21) == false) goto L7;
        int r40 = 4;
    L8:
        r5 = r40 | r24;
        goto L11
    L7:
        r40 = 2;
        goto L8
    }

    private static final void OneRowSnackbar(final Function2<? super Composer, ? super Integer, Unit> r17, final Function2<? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20) {
        Composer r4 = r19.startRestartGroup(1302703572);
        if ((r20 & 6) == 0) goto L5;
        int r5 = r20;
    L11:
        if ((r20 & 48) != 0) goto L18;
        if (r4.changedInstance(r18) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r5 & 19) == 18) goto L20;
        boolean r7 = true;
    L22:
        if (r4.shouldExecute(r7, r5 & 1) == true) goto L24;
        r4.skipToGroupEnd();
    L69:
        ScopeUpdateScope r3 = r4.endRestartGroup();
        if (r3 == null) goto L73;
        r3.updateScope(new ma(r17, r18, r20));
        return;
    L73:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1302703572, r5, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:310)");
    L26:
        Modifier.Companion r8 = Modifier.Companion;
        Modifier r9 = PaddingKt.m964paddingqDBjuR0$default(r8, HorizontalSpacing, androidx.compose.material3.MenuKt.ClosedAlphaTarget, HorizontalSpacingButtonSide, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null);
        Object r10 = r4.rememberedValue();
        if (r10 != Composer.Companion.getEmpty()) goto L29;
        r10 = new SnackbarKt$OneRowSnackbar$2$1("action", "text");
        r4.updateRememberedValue(r10);
    L29:
        MeasurePolicy r11 = (MeasurePolicy) r10;
        int r12 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r13 = r4.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r4, r9);
        ComposeUiNode.Companion r15 = ComposeUiNode.Companion;
        Function0 r16 = r15.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L32;
        ComposablesKt.invalidApplier();
    L32:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L35;
        r4.createNode(r16);
    L36:
        Composer r21 = Updater.constructor-impl(r4);
        Updater.set-impl(r21, r11, r15.getSetMeasurePolicy());
        Updater.set-impl(r21, r13, r15.getSetResolvedCompositionLocals());
        Function2 r22 = r15.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L39;
    L40:
        r21.updateRememberedValue(Integer.valueOf(r12));
        r21.apply(Integer.valueOf(r12), r22);
    L41:
        Updater.set-impl(r21, r14, r15.getSetModifier());
        Modifier r23 = PaddingKt.m962paddingVpY3zN4$default(LayoutIdKt.layoutId(r8, "text"), androidx.compose.material3.MenuKt.ClosedAlphaTarget, SnackbarVerticalPadding, 1, null);
        Alignment.Companion r24 = Alignment.Companion;
        MeasurePolicy r25 = BoxKt.maybeCachedBoxMeasurePolicy(r24.getTopStart(), false);
        int r110 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r26 = r4.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r4, r23);
        Function0 r111 = r15.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L44;
        ComposablesKt.invalidApplier();
    L44:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L47;
        r4.createNode(r111);
    L48:
        Composer r112 = Updater.constructor-impl(r4);
        Updater.set-impl(r112, r25, r15.getSetMeasurePolicy());
        Updater.set-impl(r112, r26, r15.getSetResolvedCompositionLocals());
        Function2 r28 = r15.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L51;
    L52:
        r112.updateRememberedValue(Integer.valueOf(r110));
        r112.apply(Integer.valueOf(r110), r28);
    L53:
        Updater.set-impl(r112, r27, r15.getSetModifier());
        BoxScopeInstance r29 = BoxScopeInstance.INSTANCE;
        r17.invoke(r4, Integer.valueOf(r5 & 14));
        r4.endNode();
        Modifier r30 = LayoutIdKt.layoutId(r8, "action");
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(r24.getTopStart(), false);
        int r32 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r33 = r4.getCurrentCompositionLocalMap();
        Modifier r34 = ComposedModifierKt.materializeModifier(r4, r30);
        Function0 r35 = r15.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L56;
        ComposablesKt.invalidApplier();
    L56:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L59;
        r4.createNode(r35);
    L60:
        Composer r36 = Updater.constructor-impl(r4);
        Updater.set-impl(r36, r31, r15.getSetMeasurePolicy());
        Updater.set-impl(r36, r33, r15.getSetResolvedCompositionLocals());
        Function2 r37 = r15.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L63;
    L64:
        r36.updateRememberedValue(Integer.valueOf(r32));
        r36.apply(Integer.valueOf(r32), r37);
    L65:
        Updater.set-impl(r36, r34, r15.getSetModifier());
        r18.invoke(r4, Integer.valueOf((r5 >> 3) & 14));
        r4.endNode();
        r4.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
        goto L69
    L63:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r32)) == true) goto L65;
    L59:
        r4.useNode();
        goto L60
    L51:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r110)) == true) goto L53;
    L47:
        r4.useNode();
        goto L48
    L39:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r12)) == true) goto L41;
    L35:
        r4.useNode();
        goto L36
    L20:
        r7 = false;
        goto L22
    L5:
        if (r4.changedInstance(r17) == false) goto L7;
        int r38 = 4;
    L8:
        r5 = r38 | r20;
        goto L11
    L7:
        r38 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$NewLineButtonSnackbar(Function2 r0, Function2 r1, Composer r2, int r3) {
        NewLineButtonSnackbar(r0, r1, r2, r3);
    }

    public static final /* synthetic */ void access$OneRowSnackbar(Function2 r0, Function2 r1, Composer r2, int r3) {
        OneRowSnackbar(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: Snackbar-7zSek6w, reason: not valid java name */
    public static final void m2155Snackbar7zSek6w(Modifier r27, Function2<? super Composer, ? super Integer, Unit> r28, boolean r29, Shape r30, long r31, long r33, float r35, final Function2<? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(-662779944);
        int r2 = r39 & 1;
        if (r2 == 0) goto L6;
        int r4 = r38 | 6;
    L13:
        int r5 = r39 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r7 = r39 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L36:
        if ((r38 & 3072) != 0) goto L47;
        if ((r39 & 8) != 0) goto L43;
        if (r1.changed(r30) == false) goto L43;
        int r13 = 2048;
    L44:
        r4 = r4 | r13;
    L43:
        r13 = 1024;
    L47:
        if ((r38 & 24576) == 0) goto L49;
        long r14 = r31;
    L58:
        if ((196608 & r38) != 0) goto L66;
        long r8 = r33;
        if ((r39 & 32) == 0) goto L62;
    L64:
        int r15 = 65536;
    L65:
        r4 = r4 | r15;
    L67:
        int r16 = r39 & 64;
        if (r16 == 0) goto L71;
        r4 = r4 | 1572864;
    L78:
        if ((r39 & 128) == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        boolean r18 = false;
        if ((4793491 & r4) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L138;
        r1.startDefaults();
        if ((r38 & 1) != 0) goto L96;
    L109:
        if (r2 == 0) goto L111;
        Modifier r3 = Modifier.Companion;
    L112:
        if (r5 == 0) goto L114;
        final Function2<? super Composer, ? super Integer, Unit> r6 = null;
    L115:
        if (r7 != 0) goto L119;
        r18 = r29;
    L119:
        if ((r39 & 8) == 0) goto L121;
        Shape r9 = MaterialTheme.INSTANCE.getShapes(r1, 6).getSmall();
        r4 = r4 & (-7169);
    L123:
        if ((r39 & 16) == 0) goto L126;
        r14 = SnackbarDefaults.INSTANCE.getBackgroundColor(r1, 6);
        r4 = r4 & (-57345);
    L126:
        if ((r39 & 32) == 0) goto L128;
        r8 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r4 = (-458753) & r4;
    L128:
        if (r16 == 0) goto L130;
        long r25 = r8;
        long r10 = r14;
        int r11 = r4;
        float r12 = Dp.constructor-impl(6);
        final boolean r17 = r18;
    L131:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(-662779944, r11, -1, "androidx.compose.material.Snackbar (Snackbar.kt:93)");
    L134:
        int r19 = r11 >> 6;
        SurfaceKt.m2175SurfaceFjzlyU(r3, r9, r10, r25, null, r12, ComposableLambdaKt.rememberComposableLambda(-1429068516, true, new SnackbarKt$Snackbar$1(r6, r36, r17), r1, 54), r1, (((((r11 & 14) | 1572864) | (r19 & 112)) | (r19 & 896)) | (r19 & 7168)) | ((r11 >> 3) & 458752), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventEnd();
    L137:
        final float r20 = r12;
        boolean r21 = r17;
        Function2<? super Composer, ? super Integer, Unit> r22 = r6;
        Modifier r23 = r3;
    L139:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L143;
        final Modifier r24 = r23;
        final Function2<? super Composer, ? super Integer, Unit> r26 = r22;
        final boolean r32 = r21;
        final Shape r34 = r9;
        final long r40 = r10;
        final long r41 = r25;
        r110.updateScope(new na(r24, r26, r32, r34, r40, r41, r20, r36, r38, r39));
        return;
    L143:
        return;
    L130:
        r25 = r8;
        r10 = r14;
        r17 = r18;
    L108:
        r11 = r4;
        r12 = r35;
        goto L131
    L121:
        r9 = r30;
        goto L123
    L114:
        r6 = r28;
        goto L115
    L111:
        r3 = r27;
        goto L112
    L96:
        if (r1.getDefaultsInvalid() == true) goto L109;
        r1.skipToGroupEnd();
        if ((r39 & 8) == 0) goto L102;
        r4 = r4 & (-7169);
    L102:
        if ((r39 & 16) == 0) goto L105;
        r4 = r4 & (-57345);
    L105:
        if ((r39 & 32) == 0) goto L107;
        r4 = r4 & (-458753);
    L107:
        r3 = r27;
        r6 = r28;
        r17 = r29;
        r9 = r30;
        r25 = r8;
        r10 = r14;
        goto L108
    L138:
        r1.skipToGroupEnd();
        r23 = r27;
        r22 = r28;
        r21 = r29;
        r9 = r30;
        r25 = r8;
        r10 = r14;
        r20 = r35;
        goto L139
    L90:
        r0 = false;
        goto L92
    L81:
        if ((r38 & 12582912) != 0) goto L87;
        if (r1.changedInstance(r36) == false) goto L85;
        int r42 = 8388608;
    L86:
        r4 = r4 | r42;
        goto L87
    L85:
        r42 = 4194304;
        goto L86
    L71:
        if ((r38 & 1572864) != 0) goto L78;
        if (r1.changed(r35) == false) goto L75;
        int r111 = 1048576;
    L76:
        r4 = r4 | r111;
        goto L78
    L75:
        r111 = 524288;
        goto L76
    L62:
        if (r1.changed(r8) == false) goto L64;
        r15 = 131072;
        goto L65
    L66:
        r8 = r33;
        goto L67
    L49:
        if ((r39 & 16) != 0) goto L53;
        r14 = r31;
        if (r1.changed(r14) == false) goto L54;
        int r112 = 16384;
    L55:
        r4 = r4 | r112;
    L54:
        r112 = 8192;
        goto L55
    L53:
        r14 = r31;
        goto L54
    L28:
        if ((r38 & 384) != 0) goto L36;
        if (r1.changed(r29) == false) goto L32;
        int r43 = 256;
    L33:
        r4 = r4 | r43;
        goto L36
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r1.changedInstance(r28) == false) goto L21;
        int r44 = 32;
    L22:
        r4 = r4 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r4 = r38;
        goto L13
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r45 = 4;
    L11:
        r4 = r45 | r38;
        goto L13
    L10:
        r45 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    public static final void m2156SnackbarsPrSdHI(final SnackbarData r27, Modifier r28, boolean r29, Shape r30, long r31, long r33, long r35, float r37, Composer r38, final int r39, final int r40) {
        Composer r2 = r38.startRestartGroup(258660814);
        if ((r40 & 1) == 0) goto L6;
        int r3 = r39 | 6;
    L16:
        int r4 = r40 & 2;
        if (r4 == 0) goto L20;
        r3 = r3 | 48;
    L27:
        int r6 = r40 & 4;
        if (r6 == 0) goto L31;
        r3 = r3 | 384;
    L37:
        boolean r7 = r29;
    L39:
        if ((r39 & 3072) == 0) goto L41;
        Shape r8 = r30;
    L50:
        if ((r39 & 24576) == 0) goto L52;
        long r9 = r31;
    L61:
        if ((196608 & r39) != 0) goto L69;
        long r14 = r33;
        if ((r40 & 32) == 0) goto L65;
    L67:
        int r11 = 65536;
    L68:
        r3 = r3 | r11;
    L71:
        if ((1572864 & r39) != 0) goto L80;
        if ((r40 & 64) == 0) goto L75;
    L77:
        int r16 = 524288;
    L78:
        r3 = r3 | r16;
        goto L80
    L75:
        if (r2.changed(r35) == false) goto L77;
        r16 = 1048576;
    L80:
        int r12 = r40 & 128;
        if (r12 == 0) goto L84;
        r3 = r3 | 12582912;
    L91:
        if ((4793491 & r3) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L149;
        r2.startDefaults();
        if ((r39 & 1) != 0) goto L99;
    L114:
        if (r4 == 0) goto L116;
        Modifier r1 = Modifier.Companion;
    L117:
        if (r6 == 0) goto L120;
        r7 = false;
    L120:
        if ((r40 & 8) == 0) goto L122;
        final Shape r5 = MaterialTheme.INSTANCE.getShapes(r2, 6).getSmall();
        r3 = r3 & (-7169);
    L124:
        if ((r40 & 16) == 0) goto L126;
        long r10 = SnackbarDefaults.INSTANCE.getBackgroundColor(r2, 6);
        r3 = r3 & (-57345);
    L128:
        if ((r40 & 32) == 0) goto L131;
        r14 = MaterialTheme.INSTANCE.getColors(r2, 6).m2003getSurface0d7_KjU();
        r3 = r3 & (-458753);
    L131:
        if ((r40 & 64) == 0) goto L133;
        long r17 = SnackbarDefaults.INSTANCE.getPrimaryActionColor(r2, 6);
        r3 = (-3670017) & r3;
    L134:
        if (r12 == 0) goto L136;
        float r13 = Dp.constructor-impl(6);
    L137:
        long r15 = r14;
        long r18 = r17;
    L138:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventStart(258660814, r3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:165)");
    L141:
        String r19 = r27.getActionLabel();
        if (r19 == null) goto L144;
        r2.startReplaceGroup(593509092);
        final SnackbarData r20 = r27;
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(r18, r20, r19), r2, 54);
        r2.endReplaceGroup();
    L145:
        Modifier r210 = r1;
        long r110 = r18;
        m2155Snackbar7zSek6w(PaddingKt.m960padding3ABfNKs(r1, Dp.constructor-impl(12)), r21, r7, r5, r10, r15, r13, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new SnackbarKt$Snackbar$3(r20), r2, 54), r2, (((((r3 & 896) | 12582912) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | ((r3 >> 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        Modifier r22 = r210;
        float r111 = r13;
    L150:
        ScopeUpdateScope r112 = r2.endRestartGroup();
        if (r112 == null) goto L154;
        final Modifier r23 = r22;
        final boolean r24 = r7;
        final long r25 = r10;
        final long r26 = r15;
        final long r32 = r110;
        final float r113 = r111;
        r112.updateScope(new oa(r27, r23, r24, r5, r25, r26, r32, r113, r39, r40));
        return;
    L154:
        return;
    L144:
        r20 = r27;
        r2.startReplaceGroup(593808056);
        r2.endReplaceGroup();
        r21 = null;
        goto L145
    L136:
        r13 = r37;
        goto L137
    L133:
        r17 = r35;
        goto L134
    L126:
        r10 = r9;
        goto L128
    L122:
        r5 = r8;
        goto L124
    L116:
        r1 = r28;
        goto L117
    L99:
        if (r2.getDefaultsInvalid() == true) goto L114;
        r2.skipToGroupEnd();
        if ((r40 & 8) == 0) goto L105;
        r3 = r3 & (-7169);
    L105:
        if ((r40 & 16) == 0) goto L108;
        r3 = r3 & (-57345);
    L108:
        if ((r40 & 32) == 0) goto L111;
        r3 = r3 & (-458753);
    L111:
        if ((r40 & 64) == 0) goto L113;
        r3 = r3 & (-3670017);
    L113:
        r1 = r28;
        r13 = r37;
        r5 = r8;
        r10 = r9;
        r15 = r14;
        r18 = r35;
        goto L138
    L149:
        r2.skipToGroupEnd();
        r22 = r28;
        r110 = r35;
        r5 = r8;
        r10 = r9;
        r15 = r14;
        r111 = r37;
        goto L150
    L93:
        r0 = false;
        goto L95
    L84:
        if ((r39 & 12582912) != 0) goto L91;
        if (r2.changed(r37) == false) goto L88;
        int r34 = 8388608;
    L89:
        r3 = r3 | r34;
        goto L91
    L88:
        r34 = 4194304;
        goto L89
    L65:
        if (r2.changed(r14) == false) goto L67;
        r11 = 131072;
        goto L68
    L69:
        r14 = r33;
        goto L71
    L52:
        if ((r40 & 16) != 0) goto L56;
        r9 = r31;
        if (r2.changed(r9) == false) goto L57;
        int r114 = 16384;
    L58:
        r3 = r3 | r114;
    L57:
        r114 = 8192;
        goto L58
    L56:
        r9 = r31;
        goto L57
    L41:
        if ((r40 & 8) != 0) goto L45;
        r8 = r30;
        if (r2.changed(r8) == false) goto L46;
        int r36 = 2048;
    L47:
        r3 = r3 | r36;
    L46:
        r36 = 1024;
        goto L47
    L45:
        r8 = r30;
        goto L46
    L31:
        if ((r39 & 384) != 0) goto L37;
        r7 = r29;
        if (r2.changed(r7) == false) goto L35;
        int r41 = 256;
    L36:
        r3 = r3 | r41;
        goto L39
    L35:
        r41 = 128;
        goto L36
    L20:
        if ((r39 & 48) != 0) goto L27;
        if (r2.changed(r28) == false) goto L24;
        int r42 = 32;
    L25:
        r3 = r3 | r42;
        goto L27
    L24:
        r42 = 16;
        goto L25
    L6:
        if ((r39 & 6) == 0) goto L8;
        r3 = r39;
        goto L16
    L8:
        if ((r39 & 8) != 0) goto L10;
        boolean r43 = r2.changed(r27);
    L11:
        if (r43 == false) goto L13;
        int r44 = 4;
    L14:
        r3 = r44 | r39;
        goto L16
    L13:
        r44 = 2;
        goto L14
    L10:
        r43 = r2.changedInstance(r27);
        goto L11
    }
}
