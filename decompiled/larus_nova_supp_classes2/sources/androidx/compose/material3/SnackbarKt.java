package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001ab\u0010\u0019\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001ad\u0010\u001f\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0003¢\u0006\u0004\b\"\u0010\u001e\"\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010&\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010'\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010)\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010*\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010+\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010,\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006-"}, d2 = {"Snackbar", "", "modifier", "Landroidx/compose/ui/Modifier;", "action", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "dismissAction", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionContentColor", "dismissActionContentColor", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "NewLineButtonSnackbar", "text", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt {
    private static final float ContainerMaxWidth = 0.0f;
    private static final float HeightToFirstLine = 0.0f;
    private static final float HorizontalSpacing = 0.0f;
    private static final float HorizontalSpacingButtonSide = 0.0f;
    private static final float LongButtonVerticalOffset = 0.0f;
    private static final float SeparateButtonExtraY = 0.0f;
    private static final float SnackbarVerticalPadding = 0.0f;
    private static final float TextEndExtraSpacing = 0.0f;

    private static final Unit NewLineButtonSnackbar_kKq0p4A$lambda$6(Function2 r11, Function2 r12, Function2 r13, TextStyle r14, long r15, long r17, int r19, Composer r20, int r21) {
        m3194NewLineButtonSnackbarkKq0p4A(r11, r12, r13, r14, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit OneRowSnackbar_kKq0p4A$lambda$12(Function2 r11, Function2 r12, Function2 r13, TextStyle r14, long r15, long r17, int r19, Composer r20, int r21) {
        m3195OneRowSnackbarkKq0p4A(r11, r12, r13, r14, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Snackbar_eQBnUkQ$lambda$0(Modifier r17, Function2 r18, Function2 r19, boolean r20, Shape r21, long r22, long r24, long r26, long r28, Function2 r30, int r31, int r32, Composer r33, int r34) {
        m3196SnackbareQBnUkQ(r17, r18, r19, r20, r21, r22, r24, r26, r28, r30, r33, RecomposeScopeImplKt.updateChangedFlags(r31 | 1), r32);
        return Unit.INSTANCE;
    }

    private static final Unit Snackbar_sDKtq54$lambda$1(SnackbarData r17, Modifier r18, boolean r19, Shape r20, long r21, long r23, long r25, long r27, long r29, int r31, int r32, Composer r33, int r34) {
        m3197SnackbarsDKtq54(r17, r18, r19, r20, r21, r23, r25, r27, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r31 | 1), r32);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function2 r1, Function2 r2, TextStyle r3, long r4, long r6, int r8, Composer r9, int r10) {
        return NewLineButtonSnackbar_kKq0p4A$lambda$6(r0, r1, r2, r3, r4, r6, r8, r9, r10);
    }

    public static /* synthetic */ Unit b(SnackbarData r1, Modifier r2, boolean r3, Shape r4, long r5, long r7, long r9, long r11, long r13, int r15, int r16, Composer r17, int r18) {
        return Snackbar_sDKtq54$lambda$1(r1, r2, r3, r4, r5, r7, r9, r11, r13, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit c(Modifier r1, Function2 r2, Function2 r3, boolean r4, Shape r5, long r6, long r8, long r10, long r12, Function2 r14, int r15, int r16, Composer r17, int r18) {
        return Snackbar_eQBnUkQ$lambda$0(r1, r2, r3, r4, r5, r6, r8, r10, r12, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit d(Function2 r0, Function2 r1, Function2 r2, TextStyle r3, long r4, long r6, int r8, Composer r9, int r10) {
        return OneRowSnackbar_kKq0p4A$lambda$12(r0, r1, r2, r3, r4, r6, r8, r9, r10);
    }

    static {
        ContainerMaxWidth = Dp.constructor-impl(600);
        HeightToFirstLine = Dp.constructor-impl(30);
        HorizontalSpacing = Dp.constructor-impl(16);
        float r0 = 8;
        HorizontalSpacingButtonSide = Dp.constructor-impl(r0);
        SeparateButtonExtraY = Dp.constructor-impl(2);
        SnackbarVerticalPadding = Dp.constructor-impl(6);
        TextEndExtraSpacing = Dp.constructor-impl(r0);
        LongButtonVerticalOffset = Dp.constructor-impl(12);
    }

    public static final /* synthetic */ float access$getContainerMaxWidth$p() {
        return ContainerMaxWidth;
    }

    public static final /* synthetic */ float access$getHeightToFirstLine$p() {
        return HeightToFirstLine;
    }

    public static final /* synthetic */ float access$getTextEndExtraSpacing$p() {
        return TextEndExtraSpacing;
    }

    /* JADX INFO: renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    private static final void m3194NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> r27, final Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, final TextStyle r30, final long r31, final long r33, Composer r35, final int r36) {
        Composer r5 = r35.startRestartGroup(-264666338);
        if ((r36 & 6) == 0) goto L5;
        int r6 = r36;
    L11:
        if ((r36 & 48) != 0) goto L18;
        if (r5.changedInstance(r28) == false) goto L15;
        int r8 = 32;
    L16:
        r6 = r6 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r36 & 384) != 0) goto L25;
        if (r5.changedInstance(r29) == false) goto L22;
        int r9 = 256;
    L23:
        r6 = r6 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r36 & 3072) != 0) goto L32;
        if (r5.changed(r30) == false) goto L29;
        int r10 = 2048;
    L30:
        r6 = r6 | r10;
        goto L32
    L29:
        r10 = 1024;
    L32:
        if ((r36 & 24576) != 0) goto L39;
        if (r5.changed(r31) == false) goto L36;
        int r11 = 16384;
    L37:
        r6 = r6 | r11;
        goto L39
    L36:
        r11 = 8192;
    L39:
        if ((196608 & r36) != 0) goto L46;
        if (r5.changed(r33) == false) goto L43;
        int r12 = 131072;
    L44:
        r6 = r6 | r12;
        goto L46
    L43:
        r12 = 65536;
    L46:
        if ((74899 & r6) == 74898) goto L48;
        boolean r13 = true;
    L50:
        if (r5.shouldExecute(r13, r6 & 1) == true) goto L52;
        r5.skipToGroupEnd();
    L114:
        ScopeUpdateScope r14 = r5.endRestartGroup();
        if (r14 == null) goto L118;
        r14.updateScope(new xq(r27, r28, r29, r30, r31, r33, r36));
        return;
    L118:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-264666338, r6, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:258)");
    L54:
        Modifier r0 = Modifier.Companion;
        Modifier r7 = PaddingKt.m964paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1021widthInVpY3zN4$default(r0, MenuKt.ClosedAlphaTarget, ContainerMaxWidth, 1, null), MenuKt.ClosedAlphaTarget, 1, null), HorizontalSpacing, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, SeparateButtonExtraY, 6, null);
        Arrangement r15 = Arrangement.INSTANCE;
        Arrangement.Vertical r16 = r15.getTop();
        Alignment.Companion r17 = Alignment.Companion;
        MeasurePolicy r18 = ColumnKt.columnMeasurePolicy(r16, r17.getStart(), r5, 0);
        int r19 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r20 = r5.getCurrentCompositionLocalMap();
        Modifier r21 = ComposedModifierKt.materializeModifier(r5, r7);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L57;
        ComposablesKt.invalidApplier();
    L57:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L60;
        r5.createNode(r111);
    L61:
        Composer r112 = Updater.constructor-impl(r5);
        Updater.set-impl(r112, r18, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r20, r110.getSetResolvedCompositionLocals());
        Function2 r22 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L64;
    L65:
        r112.updateRememberedValue(Integer.valueOf(r19));
        r112.apply(Integer.valueOf(r19), r22);
    L66:
        Updater.set-impl(r112, r21, r110.getSetModifier());
        ColumnScopeInstance r23 = ColumnScopeInstance.INSTANCE;
        Modifier r113 = AlignmentLineKt.m776paddingFromBaselineVpY3zN4(r0, HeightToFirstLine, LongButtonVerticalOffset);
        float r24 = HorizontalSpacingButtonSide;
        Modifier r114 = PaddingKt.m964paddingqDBjuR0$default(r113, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r24, MenuKt.ClosedAlphaTarget, 11, null);
        MeasurePolicy r115 = BoxKt.maybeCachedBoxMeasurePolicy(r17.getTopStart(), false);
        int r116 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r117 = r5.getCurrentCompositionLocalMap();
        Modifier r118 = ComposedModifierKt.materializeModifier(r5, r114);
        Function0 r25 = r110.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L69;
        ComposablesKt.invalidApplier();
    L69:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L72;
        r5.createNode(r25);
    L73:
        Composer r26 = Updater.constructor-impl(r5);
        Updater.set-impl(r26, r115, r110.getSetMeasurePolicy());
        Updater.set-impl(r26, r117, r110.getSetResolvedCompositionLocals());
        Function2 r119 = r110.getSetCompositeKeyHash();
        if (r26.getInserting() == false) goto L76;
    L77:
        r26.updateRememberedValue(Integer.valueOf(r116));
        r26.apply(Integer.valueOf(r116), r119);
    L78:
        Updater.set-impl(r26, r118, r110.getSetModifier());
        BoxScopeInstance r32 = BoxScopeInstance.INSTANCE;
        r27.invoke(r5, Integer.valueOf(r6 & 14));
        r5.endNode();
        Modifier r210 = r23.align(r0, r17.getEnd());
        if (r29 != null) goto L81;
        float r211 = r24;
    L82:
        Modifier r34 = PaddingKt.m964paddingqDBjuR0$default(r210, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r211, MenuKt.ClosedAlphaTarget, 11, null);
        MeasurePolicy r37 = BoxKt.maybeCachedBoxMeasurePolicy(r17.getTopStart(), false);
        int r120 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r121 = r5.getCurrentCompositionLocalMap();
        Modifier r38 = ComposedModifierKt.materializeModifier(r5, r34);
        Function0 r122 = r110.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L85;
        ComposablesKt.invalidApplier();
    L85:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L88;
        r5.createNode(r122);
    L89:
        Composer r123 = Updater.constructor-impl(r5);
        Updater.set-impl(r123, r37, r110.getSetMeasurePolicy());
        Updater.set-impl(r123, r121, r110.getSetResolvedCompositionLocals());
        Function2 r39 = r110.getSetCompositeKeyHash();
        if (r123.getInserting() == false) goto L92;
    L93:
        r123.updateRememberedValue(Integer.valueOf(r120));
        r123.apply(Integer.valueOf(r120), r39);
    L94:
        Updater.set-impl(r123, r38, r110.getSetModifier());
        MeasurePolicy r40 = RowKt.rowMeasurePolicy(r15.getStart(), r17.getTop(), r5, 0);
        int r41 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r42 = r5.getCurrentCompositionLocalMap();
        Modifier r1 = ComposedModifierKt.materializeModifier(r5, r0);
        Function0 r124 = r110.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L97;
        ComposablesKt.invalidApplier();
    L97:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L100;
        r5.createNode(r124);
    L101:
        Composer r125 = Updater.constructor-impl(r5);
        Updater.set-impl(r125, r40, r110.getSetMeasurePolicy());
        Updater.set-impl(r125, r42, r110.getSetResolvedCompositionLocals());
        Function2 r43 = r110.getSetCompositeKeyHash();
        if (r125.getInserting() == false) goto L104;
    L105:
        r125.updateRememberedValue(Integer.valueOf(r41));
        r125.apply(Integer.valueOf(r41), r43);
    L106:
        Updater.set-impl(r125, r1, r110.getSetModifier());
        RowScopeInstance r2 = RowScopeInstance.INSTANCE;
        ProvidedValue[] r3 = {ContentColorKt.getLocalContentColor().provides(Color.box-impl(r31)), TextKt.getLocalTextStyle().provides(r30)};
        int r44 = ProvidedValue.$stable;
        CompositionLocalKt.CompositionLocalProvider(r3, r28, r5, (r6 & 112) | r44);
        if (r29 == null) goto L109;
        r5.startReplaceGroup(916269829);
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r33)), r29, r5, ((r6 >> 3) & 112) | r44);
        r5.endReplaceGroup();
    L110:
        r5.endNode();
        r5.endNode();
        r5.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventEnd();
        goto L114
    L109:
        r5.startReplaceGroup(916475483);
        r5.endReplaceGroup();
        goto L110
    L104:
        if (Intrinsics.areEqual(r125.rememberedValue(), Integer.valueOf(r41)) == true) goto L106;
    L100:
        r5.useNode();
        goto L101
    L92:
        if (Intrinsics.areEqual(r123.rememberedValue(), Integer.valueOf(r120)) == true) goto L94;
    L88:
        r5.useNode();
        goto L89
    L81:
        r211 = Dp.constructor-impl(0);
        goto L82
    L76:
        if (Intrinsics.areEqual(r26.rememberedValue(), Integer.valueOf(r116)) == true) goto L78;
    L72:
        r5.useNode();
        goto L73
    L64:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r19)) == true) goto L66;
    L60:
        r5.useNode();
        goto L61
    L48:
        r13 = false;
        goto L50
    L5:
        if (r5.changedInstance(r27) == false) goto L7;
        int r45 = 4;
    L8:
        r6 = r45 | r36;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    private static final void m3195OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> r23, final Function2<? super Composer, ? super Integer, Unit> r24, final Function2<? super Composer, ? super Integer, Unit> r25, final TextStyle r26, final long r27, final long r29, Composer r31, final int r32) {
        Composer r5 = r31.startRestartGroup(-931325388);
        if ((r32 & 6) == 0) goto L5;
        int r6 = r32;
    L11:
        if ((r32 & 48) != 0) goto L18;
        if (r5.changedInstance(r24) == false) goto L15;
        int r8 = 32;
    L16:
        r6 = r6 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r32 & 384) != 0) goto L25;
        if (r5.changedInstance(r25) == false) goto L22;
        int r9 = 256;
    L23:
        r6 = r6 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r32 & 3072) != 0) goto L32;
        if (r5.changed(r26) == false) goto L29;
        int r10 = 2048;
    L30:
        r6 = r6 | r10;
        goto L32
    L29:
        r10 = 1024;
    L32:
        if ((r32 & 24576) != 0) goto L39;
        if (r5.changed(r27) == false) goto L36;
        int r11 = 16384;
    L37:
        r6 = r6 | r11;
        goto L39
    L36:
        r11 = 8192;
    L39:
        if ((196608 & r32) != 0) goto L46;
        if (r5.changed(r29) == false) goto L43;
        int r12 = 131072;
    L44:
        r6 = r6 | r12;
        goto L46
    L43:
        r12 = 65536;
    L46:
        if ((74899 & r6) == 74898) goto L48;
        boolean r13 = true;
    L50:
        if (r5.shouldExecute(r13, r6 & 1) == true) goto L52;
        r5.skipToGroupEnd();
    L120:
        ScopeUpdateScope r14 = r5.endRestartGroup();
        if (r14 == null) goto L124;
        r14.updateScope(new zq(r23, r24, r25, r26, r27, r29, r32));
        return;
    L124:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-931325388, r6, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:303)");
    L54:
        Modifier.Companion r0 = Modifier.Companion;
        float r17 = HorizontalSpacing;
        if (r25 != null) goto L57;
        float r15 = HorizontalSpacingButtonSide;
    L58:
        Modifier r16 = PaddingKt.m964paddingqDBjuR0$default(r0, r17, MenuKt.ClosedAlphaTarget, r15, MenuKt.ClosedAlphaTarget, 10, null);
        Object r18 = r5.rememberedValue();
        if (r18 != Composer.Companion.getEmpty()) goto L61;
        r18 = new SnackbarKt$OneRowSnackbar$2$1("action", "dismissAction", "text");
        r5.updateRememberedValue(r18);
    L61:
        MeasurePolicy r19 = (MeasurePolicy) r18;
        int r110 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r111 = r5.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r5, r16);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r113 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L64;
        ComposablesKt.invalidApplier();
    L64:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L67;
        r5.createNode(r113);
    L68:
        Composer r114 = Updater.constructor-impl(r5);
        Updater.set-impl(r114, r19, r112.getSetMeasurePolicy());
        Updater.set-impl(r114, r111, r112.getSetResolvedCompositionLocals());
        Function2 r115 = r112.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L71;
    L72:
        r114.updateRememberedValue(Integer.valueOf(r110));
        r114.apply(Integer.valueOf(r110), r115);
    L73:
        Updater.set-impl(r114, r20, r112.getSetModifier());
        Modifier r7 = PaddingKt.m962paddingVpY3zN4$default(LayoutIdKt.layoutId(r0, "text"), MenuKt.ClosedAlphaTarget, SnackbarVerticalPadding, 1, null);
        Alignment.Companion r21 = Alignment.Companion;
        MeasurePolicy r116 = BoxKt.maybeCachedBoxMeasurePolicy(r21.getTopStart(), false);
        int r117 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r118 = r5.getCurrentCompositionLocalMap();
        Modifier r22 = ComposedModifierKt.materializeModifier(r5, r7);
        Function0 r119 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L76;
        ComposablesKt.invalidApplier();
    L76:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L79;
        r5.createNode(r119);
    L80:
        Composer r120 = Updater.constructor-impl(r5);
        Updater.set-impl(r120, r116, r112.getSetMeasurePolicy());
        Updater.set-impl(r120, r118, r112.getSetResolvedCompositionLocals());
        Function2 r121 = r112.getSetCompositeKeyHash();
        if (r120.getInserting() == false) goto L83;
    L84:
        r120.updateRememberedValue(Integer.valueOf(r117));
        r120.apply(Integer.valueOf(r117), r121);
    L85:
        Updater.set-impl(r120, r22, r112.getSetModifier());
        BoxScopeInstance r28 = BoxScopeInstance.INSTANCE;
        r23.invoke(r5, Integer.valueOf(r6 & 14));
        r5.endNode();
        if (r24 == null) goto L100;
        r5.startReplaceGroup(-1014168049);
        Modifier r30 = LayoutIdKt.layoutId(r0, "action");
        MeasurePolicy r33 = BoxKt.maybeCachedBoxMeasurePolicy(r21.getTopStart(), false);
        int r122 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r123 = r5.getCurrentCompositionLocalMap();
        Modifier r34 = ComposedModifierKt.materializeModifier(r5, r30);
        Function0 r124 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L90;
        ComposablesKt.invalidApplier();
    L90:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L93;
        r5.createNode(r124);
    L94:
        Composer r125 = Updater.constructor-impl(r5);
        Updater.set-impl(r125, r33, r112.getSetMeasurePolicy());
        Updater.set-impl(r125, r123, r112.getSetResolvedCompositionLocals());
        Function2 r35 = r112.getSetCompositeKeyHash();
        if (r125.getInserting() == false) goto L97;
    L98:
        r125.updateRememberedValue(Integer.valueOf(r122));
        r125.apply(Integer.valueOf(r122), r35);
    L99:
        Updater.set-impl(r125, r34, r112.getSetModifier());
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r27)), TextKt.getLocalTextStyle().provides(r26)}, r24, r5, ProvidedValue.$stable | (r6 & 112));
        r5.endNode();
        r5.endReplaceGroup();
    L101:
        if (r25 == null) goto L115;
        r5.startReplaceGroup(-1013804481);
        Modifier r1 = LayoutIdKt.layoutId(r0, "dismissAction");
        MeasurePolicy r36 = BoxKt.maybeCachedBoxMeasurePolicy(r21.getTopStart(), false);
        int r37 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r38 = r5.getCurrentCompositionLocalMap();
        Modifier r2 = ComposedModifierKt.materializeModifier(r5, r1);
        Function0 r126 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L105;
        ComposablesKt.invalidApplier();
    L105:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L108;
        r5.createNode(r126);
    L109:
        Composer r127 = Updater.constructor-impl(r5);
        Updater.set-impl(r127, r36, r112.getSetMeasurePolicy());
        Updater.set-impl(r127, r38, r112.getSetResolvedCompositionLocals());
        Function2 r39 = r112.getSetCompositeKeyHash();
        if (r127.getInserting() == false) goto L112;
    L113:
        r127.updateRememberedValue(Integer.valueOf(r37));
        r127.apply(Integer.valueOf(r37), r39);
    L114:
        Updater.set-impl(r127, r2, r112.getSetModifier());
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r29)), r25, r5, ((r6 >> 3) & 112) | ProvidedValue.$stable);
        r5.endNode();
        r5.endReplaceGroup();
    L116:
        r5.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
        goto L120
    L112:
        if (Intrinsics.areEqual(r127.rememberedValue(), Integer.valueOf(r37)) == true) goto L114;
    L108:
        r5.useNode();
        goto L109
    L115:
        r5.startReplaceGroup(-1013535401);
        r5.endReplaceGroup();
        goto L116
    L97:
        if (Intrinsics.areEqual(r125.rememberedValue(), Integer.valueOf(r122)) == true) goto L99;
    L93:
        r5.useNode();
        goto L94
    L100:
        r5.startReplaceGroup(-1013852841);
        r5.endReplaceGroup();
        goto L101
    L83:
        if (Intrinsics.areEqual(r120.rememberedValue(), Integer.valueOf(r117)) == true) goto L85;
    L79:
        r5.useNode();
        goto L80
    L71:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r110)) == true) goto L73;
    L67:
        r5.useNode();
        goto L68
    L57:
        r15 = Dp.constructor-impl(0);
        goto L58
    L48:
        r13 = false;
        goto L50
    L5:
        if (r5.changedInstance(r23) == false) goto L7;
        int r40 = 4;
    L8:
        r6 = r40 | r32;
        goto L11
    L7:
        r40 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final /* synthetic */ void m3198access$NewLineButtonSnackbarkKq0p4A(Function2 r0, Function2 r1, Function2 r2, TextStyle r3, long r4, long r6, Composer r8, int r9) {
        m3194NewLineButtonSnackbarkKq0p4A(r0, r1, r2, r3, r4, r6, r8, r9);
    }

    /* JADX INFO: renamed from: access$OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final /* synthetic */ void m3199access$OneRowSnackbarkKq0p4A(Function2 r0, Function2 r1, Function2 r2, TextStyle r3, long r4, long r6, Composer r8, int r9) {
        m3195OneRowSnackbarkKq0p4A(r0, r1, r2, r3, r4, r6, r8, r9);
    }

    /* JADX INFO: renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m3197SnackbarsDKtq54(final SnackbarData r41, Modifier r42, boolean r43, Shape r44, long r45, long r47, long r49, long r51, long r53, Composer r55, final int r56, final int r57) {
        Composer r2 = r55.startRestartGroup(274621471);
        if ((r57 & 1) == 0) goto L6;
        int r3 = r56 | 6;
    L13:
        int r4 = r57 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r42;
    L24:
        int r6 = r57 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r43;
    L36:
        if ((r56 & 3072) == 0) goto L38;
        Shape r8 = r44;
    L47:
        if ((r56 & 24576) == 0) goto L49;
        long r9 = r45;
    L58:
        if ((196608 & r56) == 0) goto L60;
        long r11 = r47;
    L69:
        if ((1572864 & r56) != 0) goto L79;
        if ((r57 & 64) == 0) goto L73;
    L75:
        int r16 = 524288;
    L76:
        r3 = r3 | r16;
        goto L79
    L73:
        if (r2.changed(r49) == false) goto L75;
        r16 = 1048576;
    L79:
        if ((r56 & 12582912) != 0) goto L89;
        if ((r57 & 128) == 0) goto L83;
    L85:
        int r14 = 4194304;
    L86:
        r3 = r3 | r14;
        goto L89
    L83:
        if (r2.changed(r51) == false) goto L85;
        r14 = 8388608;
    L89:
        if ((100663296 & r56) != 0) goto L99;
        if ((r57 & 256) == 0) goto L93;
    L95:
        int r15 = 33554432;
    L96:
        r3 = r3 | r15;
        goto L99
    L93:
        if (r2.changed(r53) == false) goto L95;
        r15 = 67108864;
    L99:
        if ((38347923 & r3) == 38347922) goto L101;
        boolean r0 = true;
    L103:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L174;
        r2.startDefaults();
        if ((r56 & 1) != 0) goto L107;
    L128:
        if (r4 == 0) goto L130;
        Modifier r1 = Modifier.Companion;
    L131:
        if (r6 == 0) goto L133;
        boolean r17 = false;
    L135:
        if ((r57 & 8) == 0) goto L137;
        final Shape r10 = SnackbarDefaults.INSTANCE.getShape(r2, 6);
        r3 = r3 & (-7169);
    L139:
        if ((r57 & 16) == 0) goto L141;
        long r12 = SnackbarDefaults.INSTANCE.getColor(r2, 6);
        r3 = r3 & (-57345);
    L143:
        if ((r57 & 32) == 0) goto L145;
        long r13 = SnackbarDefaults.INSTANCE.getContentColor(r2, 6);
        r3 = r3 & (-458753);
    L147:
        if ((r57 & 64) == 0) goto L149;
        long r18 = SnackbarDefaults.INSTANCE.getActionColor(r2, 6);
        r3 = r3 & (-3670017);
    L151:
        if ((r57 & 128) == 0) goto L153;
        long r33 = SnackbarDefaults.INSTANCE.getActionContentColor(r2, 6);
        r3 = r3 & (-29360129);
    L155:
        if ((r57 & 256) == 0) goto L157;
        r3 = r3 & (-234881025);
        long r35 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(r2, 6);
    L158:
        r7 = r17;
        long r19 = r18;
        r11 = r13;
        r9 = r12;
    L159:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(274621471, r3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:206)");
    L162:
        String r20 = r41.getVisuals().getActionLabel();
        if (r20 == null) goto L165;
        r2.startReplaceGroup(-663815981);
        final SnackbarData r110 = r41;
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(r19, r110, r20), r2, 54);
        r2.endReplaceGroup();
    L167:
        if (r41.getVisuals().getWithDismissAction() == false) goto L169;
        r2.startReplaceGroup(-663364652);
        Function2 r22 = ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(r110), r2, 54);
        r2.endReplaceGroup();
        Function2 r111 = r22;
    L170:
        int r23 = r3 << 3;
        ComposableLambda r112 = r21;
        boolean r113 = r7;
        Shape r24 = r10;
        long r25 = r9;
        long r26 = r11;
        long r27 = r33;
        long r28 = r35;
        m3196SnackbareQBnUkQ(PaddingKt.m960padding3ABfNKs(r1, Dp.constructor-impl(12)), r112, r111, r113, r24, r25, r26, r27, r28, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new SnackbarKt$Snackbar$3(r110), r2, 54), r2, (((r23 & 3670016) | ((((r23 & 7168) | 805306368) | (57344 & r23)) | (458752 & r23))) | (29360128 & r3)) | (r3 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventEnd();
    L173:
        r5 = r1;
        final boolean r29 = r7;
        final long r30 = r11;
        long r114 = r19;
    L175:
        ScopeUpdateScope r115 = r2.endRestartGroup();
        if (r115 == null) goto L179;
        final Modifier r31 = r5;
        final long r32 = r9;
        final long r34 = r114;
        final long r116 = r33;
        final long r117 = r35;
        r115.updateScope(new yq(r41, r31, r29, r10, r32, r30, r34, r116, r117, r56, r57));
        return;
    L179:
        return;
    L169:
        r2.startReplaceGroup(-662974393);
        r2.endReplaceGroup();
        r111 = null;
        goto L170
    L165:
        r110 = r41;
        r2.startReplaceGroup(-663517017);
        r2.endReplaceGroup();
        r21 = null;
        goto L167
    L157:
        r35 = r53;
        goto L158
    L153:
        r33 = r51;
        goto L155
    L149:
        r18 = r49;
        goto L151
    L145:
        r13 = r11;
        goto L147
    L141:
        r12 = r9;
        goto L143
    L137:
        r10 = r8;
        goto L139
    L133:
        r17 = r7;
        goto L135
    L130:
        r1 = r5;
        goto L131
    L107:
        if (r2.getDefaultsInvalid() == true) goto L128;
        r2.skipToGroupEnd();
        if ((r57 & 8) == 0) goto L113;
        r3 = r3 & (-7169);
    L113:
        if ((r57 & 16) == 0) goto L116;
        r3 = r3 & (-57345);
    L116:
        if ((r57 & 32) == 0) goto L119;
        r3 = r3 & (-458753);
    L119:
        if ((r57 & 64) == 0) goto L122;
        r3 = r3 & (-3670017);
    L122:
        if ((r57 & 128) == 0) goto L125;
        r3 = r3 & (-29360129);
    L125:
        if ((r57 & 256) == 0) goto L127;
        r3 = r3 & (-234881025);
    L127:
        r33 = r51;
        r35 = r53;
        r1 = r5;
        r10 = r8;
        r19 = r49;
        goto L159
    L174:
        r2.skipToGroupEnd();
        r33 = r51;
        r35 = r53;
        r29 = r7;
        r10 = r8;
        r30 = r11;
        r114 = r49;
        goto L175
    L101:
        r0 = false;
        goto L103
    L60:
        if ((r57 & 32) != 0) goto L64;
        r11 = r47;
        if (r2.changed(r11) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
    L65:
        r118 = 65536;
        goto L66
    L64:
        r11 = r47;
        goto L65
    L49:
        if ((r57 & 16) != 0) goto L53;
        r9 = r45;
        if (r2.changed(r9) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
    L54:
        r119 = 8192;
        goto L55
    L53:
        r9 = r45;
        goto L54
    L38:
        if ((r57 & 8) != 0) goto L42;
        r8 = r44;
        if (r2.changed(r8) == false) goto L43;
        int r36 = 2048;
    L44:
        r3 = r3 | r36;
    L43:
        r36 = 1024;
        goto L44
    L42:
        r8 = r44;
        goto L43
    L28:
        if ((r56 & 384) != 0) goto L34;
        r7 = r43;
        if (r2.changed(r7) == false) goto L32;
        int r37 = 256;
    L33:
        r3 = r3 | r37;
        goto L36
    L32:
        r37 = 128;
        goto L33
    L17:
        if ((r56 & 48) != 0) goto L23;
        r5 = r42;
        if (r2.changed(r5) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r56 & 6) == 0) goto L8;
        r3 = r56;
        goto L13
    L8:
        if (r2.changed(r41) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r56;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    public static final void m3196SnackbareQBnUkQ(Modifier r26, Function2<? super Composer, ? super Integer, Unit> r27, Function2<? super Composer, ? super Integer, Unit> r28, boolean r29, Shape r30, long r31, long r33, long r35, long r37, final Function2<? super Composer, ? super Integer, Unit> r39, Composer r40, final int r41, final int r42) {
        Composer r1 = r40.startRestartGroup(-1218779924);
        int r2 = r42 & 1;
        if (r2 == 0) goto L6;
        int r4 = r41 | 6;
    L13:
        int r5 = r42 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r7 = r42 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r8 = r28;
    L35:
        int r9 = r42 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L47:
        if ((r41 & 24576) != 0) goto L58;
        if ((r42 & 16) != 0) goto L54;
        if (r1.changed(r30) == false) goto L54;
        int r12 = 16384;
    L55:
        r4 = r4 | r12;
    L54:
        r12 = 8192;
    L58:
        if ((196608 & r41) == 0) goto L60;
        long r13 = r31;
    L69:
        if ((r41 & 1572864) != 0) goto L79;
        if ((r42 & 64) == 0) goto L73;
    L75:
        int r16 = 524288;
    L76:
        r4 = r4 | r16;
        goto L79
    L73:
        if (r1.changed(r33) == false) goto L75;
        r16 = 1048576;
    L79:
        if ((r41 & 12582912) != 0) goto L89;
        if ((r42 & 128) == 0) goto L83;
    L85:
        int r0 = 4194304;
    L86:
        r4 = r4 | r0;
        goto L89
    L83:
        if (r1.changed(r35) == false) goto L85;
        r0 = 8388608;
    L89:
        if ((100663296 & r41) != 0) goto L97;
        long r10 = r37;
        if ((r42 & 256) == 0) goto L93;
    L95:
        int r3 = 33554432;
    L96:
        r4 = r4 | r3;
    L99:
        if ((r42 & 512) == 0) goto L102;
        r4 = r4 | 805306368;
    L109:
        boolean r17 = false;
        if ((r4 & 306783379) == 306783378) goto L112;
        boolean r6 = true;
    L114:
        if (r1.shouldExecute(r6, r4 & 1) == false) goto L174;
        r1.startDefaults();
        if ((r41 & 1) != 0) goto L118;
    L136:
        if (r2 == 0) goto L138;
        Modifier r11 = Modifier.Companion;
    L139:
        Function2<? super Composer, ? super Integer, Unit> r14 = null;
        if (r5 == 0) goto L142;
        Function2<? super Composer, ? super Integer, Unit> r15 = null;
    L143:
        if (r7 != 0) goto L146;
        r14 = r8;
    L146:
        if (r9 != 0) goto L150;
        r17 = r29;
    L150:
        if ((r42 & 16) == 0) goto L152;
        Shape r18 = SnackbarDefaults.INSTANCE.getShape(r1, 6);
        r4 = r4 & (-57345);
    L154:
        if ((r42 & 32) == 0) goto L157;
        r13 = SnackbarDefaults.INSTANCE.getColor(r1, 6);
        r4 = r4 & (-458753);
    L157:
        if ((r42 & 64) == 0) goto L159;
        long r20 = SnackbarDefaults.INSTANCE.getContentColor(r1, 6);
        r4 = r4 & (-3670017);
    L161:
        if ((r42 & 128) == 0) goto L163;
        long r22 = SnackbarDefaults.INSTANCE.getActionContentColor(r1, 6);
        r4 = r4 & (-29360129);
    L165:
        if ((r42 & 256) == 0) goto L167;
        r4 = r4 & (-234881025);
        r10 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(r1, 6);
    L167:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventStart(-1218779924, r4, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
    L170:
        final boolean r210 = r17;
        final Function2<? super Composer, ? super Integer, Unit> r211 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r32 = r14;
        final long r34 = r22;
        final long r36 = r10;
        Function2<? super Composer, ? super Integer, Unit> r43 = r14;
        int r19 = (r4 & 14) | 12779520;
        int r21 = r4 >> 9;
        SurfaceKt.m3213SurfaceT9BRK9s(r11, r18, r13, r20, MenuKt.ClosedAlphaTarget, SnackbarTokens.INSTANCE.getContainerElevation-D9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new SnackbarKt$Snackbar$1(r210, r211, r39, r32, r34, r36), r1, 54), r1, ((r19 | (r21 & 112)) | (r21 & 896)) | (r21 & 7168), 80);
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventEnd();
    L173:
        final Function2<? super Composer, ? super Integer, Unit> r23 = r43;
        Modifier r24 = r11;
        final boolean r25 = r17;
        final long r38 = r20;
        long r110 = r10;
        final long r111 = r22;
    L175:
        ScopeUpdateScope r44 = r1.endRestartGroup();
        if (r44 == null) goto L179;
        final Modifier r45 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r46 = r15;
        final Shape r47 = r18;
        final long r48 = r13;
        final long r112 = r110;
        r44.updateScope(new ar(r45, r46, r23, r25, r47, r48, r38, r111, r112, r39, r41, r42));
        return;
    L179:
        return;
    L163:
        r22 = r35;
        goto L165
    L159:
        r20 = r33;
        goto L161
    L152:
        r18 = r30;
        goto L154
    L142:
        r15 = r27;
        goto L143
    L138:
        r11 = r26;
        goto L139
    L118:
        if (r1.getDefaultsInvalid() == true) goto L136;
        r1.skipToGroupEnd();
        if ((r42 & 16) == 0) goto L124;
        r4 = r4 & (-57345);
    L124:
        if ((r42 & 32) == 0) goto L127;
        r4 = r4 & (-458753);
    L127:
        if ((r42 & 64) == 0) goto L130;
        r4 = r4 & (-3670017);
    L130:
        if ((r42 & 128) == 0) goto L133;
        r4 = r4 & (-29360129);
    L133:
        if ((r42 & 256) == 0) goto L135;
        r4 = r4 & (-234881025);
    L135:
        r11 = r26;
        r15 = r27;
        r17 = r29;
        r18 = r30;
        r20 = r33;
        r22 = r35;
        r14 = r8;
        goto L167
    L174:
        r1.skipToGroupEnd();
        r24 = r26;
        r15 = r27;
        r25 = r29;
        r18 = r30;
        r23 = r8;
        r110 = r10;
        r38 = r33;
        r111 = r35;
        goto L175
    L112:
        r6 = false;
        goto L114
    L102:
        if ((r41 & 805306368) != 0) goto L109;
        if (r1.changedInstance(r39) == false) goto L106;
        int r113 = 536870912;
    L107:
        r4 = r4 | r113;
        goto L109
    L106:
        r113 = 268435456;
        goto L107
    L93:
        if (r1.changed(r10) == false) goto L95;
        r3 = 67108864;
        goto L96
    L97:
        r10 = r37;
        goto L99
    L60:
        if ((r42 & 32) != 0) goto L64;
        r13 = r31;
        if (r1.changed(r13) == false) goto L65;
        int r114 = 131072;
    L66:
        r4 = r4 | r114;
    L65:
        r114 = 65536;
        goto L66
    L64:
        r13 = r31;
        goto L65
    L39:
        if ((r41 & 3072) != 0) goto L47;
        if (r1.changed(r29) == false) goto L43;
        int r115 = 2048;
    L44:
        r4 = r4 | r115;
        goto L47
    L43:
        r115 = 1024;
        goto L44
    L28:
        if ((r41 & 384) != 0) goto L34;
        r8 = r28;
        if (r1.changedInstance(r8) == false) goto L32;
        int r49 = 256;
    L33:
        r4 = r4 | r49;
        goto L35
    L32:
        r49 = 128;
        goto L33
    L17:
        if ((r41 & 48) != 0) goto L24;
        if (r1.changedInstance(r27) == false) goto L21;
        int r50 = 32;
    L22:
        r4 = r4 | r50;
        goto L24
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r4 = r41;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r51 = 4;
    L11:
        r4 = r51 | r41;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }
}
