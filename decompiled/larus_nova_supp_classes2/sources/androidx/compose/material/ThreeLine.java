package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J|\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ThreeLine;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "F", "IconMinPaddedWidth", "IconLeftPadding", "IconThreeLineVerticalPadding", "ContentLeftPadding", "ContentRightPadding", "ThreeLineBaselineFirstOffset", "ThreeLineBaselineSecondOffset", "ThreeLineBaselineThirdOffset", "ThreeLineTrailingTopPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ThreeLine {
    private static final float ContentLeftPadding = 0.0f;
    private static final float ContentRightPadding = 0.0f;
    public static final ThreeLine INSTANCE = null;
    private static final float IconLeftPadding = 0.0f;
    private static final float IconMinPaddedWidth = 0.0f;
    private static final float IconThreeLineVerticalPadding = 0.0f;
    private static final float MinHeight = 0.0f;
    private static final float ThreeLineBaselineFirstOffset = 0.0f;
    private static final float ThreeLineBaselineSecondOffset = 0.0f;
    private static final float ThreeLineBaselineThirdOffset = 0.0f;
    private static final float ThreeLineTrailingTopPadding = 0.0f;
    private static final float TrailingRightPadding = 0.0f;

    private ThreeLine() {
    }

    private static final Unit ListItem$lambda$2(ThreeLine r11, Modifier r12, Function2 r13, Function2 r14, Function2 r15, Function2 r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        r11.ListItem(r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ThreeLine r0, Modifier r1, Function2 r2, Function2 r3, Function2 r4, Function2 r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return ListItem$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        INSTANCE = new ThreeLine();
        MinHeight = Dp.constructor-impl(88);
        IconMinPaddedWidth = Dp.constructor-impl(40);
        float r0 = 16;
        IconLeftPadding = Dp.constructor-impl(r0);
        IconThreeLineVerticalPadding = Dp.constructor-impl(r0);
        ContentLeftPadding = Dp.constructor-impl(r0);
        ContentRightPadding = Dp.constructor-impl(r0);
        ThreeLineBaselineFirstOffset = Dp.constructor-impl(28);
        float r1 = 20;
        ThreeLineBaselineSecondOffset = Dp.constructor-impl(r1);
        ThreeLineBaselineThirdOffset = Dp.constructor-impl(r1);
        ThreeLineTrailingTopPadding = Dp.constructor-impl(r0);
        TrailingRightPadding = Dp.constructor-impl(r0);
    }

    public final void ListItem(Modifier r32, final Function2<? super Composer, ? super Integer, Unit> r33, final Function2<? super Composer, ? super Integer, Unit> r34, final Function2<? super Composer, ? super Integer, Unit> r35, final Function2<? super Composer, ? super Integer, Unit> r36, final Function2<? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(1651890924);
        int r2 = r40 & 1;
        if (r2 == 0) goto L6;
        int r9 = r39 | 6;
        Modifier r8 = r32;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r9 = r9 | 48;
    L24:
        if ((r40 & 4) == 0) goto L27;
        r9 = r9 | 384;
    L34:
        if ((r40 & 8) == 0) goto L37;
        r9 = r9 | 3072;
    L44:
        if ((r40 & 16) == 0) goto L47;
        r9 = r9 | 24576;
    L54:
        if ((r40 & 32) == 0) goto L57;
        r9 = r9 | 196608;
    L64:
        if ((r40 & 64) == 0) goto L67;
        r9 = r9 | 1572864;
    L73:
        int r12 = r9;
        if ((599187 & r12) == 599186) goto L76;
        boolean r10 = true;
    L78:
        if (r1.shouldExecute(r10, r12 & 1) == false) goto L121;
        if (r2 == 0) goto L81;
        Modifier r3 = Modifier.Companion;
    L83:
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventStart(1651890924, r12, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:314)");
    L85:
        Modifier r0 = SizeKt.m1002heightInVpY3zN4$default(r3, MinHeight, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        Arrangement.Horizontal r11 = Arrangement.INSTANCE.getStart();
        Alignment.Companion r13 = Alignment.Companion;
        MeasurePolicy r14 = RowKt.rowMeasurePolicy(r11, r13.getTop(), r1, 0);
        int r15 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r7 = r1.getCurrentCompositionLocalMap();
        Modifier r4 = ComposedModifierKt.materializeModifier(r1, r0);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r16 = r17.getConstructor();
        Modifier r310 = r3;
        if ((r1.getApplier() instanceof Applier) == true) goto L88;
        ComposablesKt.invalidApplier();
    L88:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L91;
        r1.createNode(r16);
    L92:
        Composer r5 = Updater.constructor-impl(r1);
        Updater.set-impl(r5, r14, r17.getSetMeasurePolicy());
        Updater.set-impl(r5, r7, r17.getSetResolvedCompositionLocals());
        Function2 r18 = r17.getSetCompositeKeyHash();
        if (r5.getInserting() == false) goto L95;
    L96:
        r5.updateRememberedValue(Integer.valueOf(r15));
        r5.apply(Integer.valueOf(r15), r18);
    L97:
        Updater.set-impl(r5, r4, r17.getSetModifier());
        RowScopeInstance r19 = RowScopeInstance.INSTANCE;
        if (r33 == null) goto L112;
        r1.startReplaceGroup(2022185866);
        float r20 = IconLeftPadding;
        float r23 = Dp.constructor-impl(r20 + IconMinPaddedWidth);
        Modifier r110 = SizeKt.m1018sizeInqDBjuR0$default(Modifier.Companion, r23, r23, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 12, null);
        float r24 = IconThreeLineVerticalPadding;
        Modifier r6 = PaddingKt.m964paddingqDBjuR0$default(r110, r20, r24, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r24, 4, null);
        MeasurePolicy r21 = BoxKt.maybeCachedBoxMeasurePolicy(r13.getCenterStart(), false);
        int r22 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r25 = r1.getCurrentCompositionLocalMap();
        Modifier r26 = ComposedModifierKt.materializeModifier(r1, r6);
        Function0 r27 = r17.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L102;
        ComposablesKt.invalidApplier();
    L102:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L105;
        r1.createNode(r27);
    L106:
        Composer r28 = Updater.constructor-impl(r1);
        Updater.set-impl(r28, r21, r17.getSetMeasurePolicy());
        Updater.set-impl(r28, r25, r17.getSetResolvedCompositionLocals());
        Function2 r29 = r17.getSetCompositeKeyHash();
        if (r28.getInserting() == false) goto L109;
    L110:
        r28.updateRememberedValue(Integer.valueOf(r22));
        r28.apply(Integer.valueOf(r22), r29);
    L111:
        Updater.set-impl(r28, r26, r17.getSetModifier());
        BoxScopeInstance r30 = BoxScopeInstance.INSTANCE;
        r33.invoke(r1, Integer.valueOf((r12 >> 3) & 14));
        r1.endNode();
        r1.endReplaceGroup();
    L113:
        float r31 = ThreeLineBaselineFirstOffset;
        List r41 = CollectionsKt.listOf(new Dp[]{Dp.box-impl(r31), Dp.box-impl(ThreeLineBaselineSecondOffset), Dp.box-impl(ThreeLineBaselineThirdOffset)});
        Modifier.Companion r42 = Modifier.Companion;
        ListItemKt.access$BaselinesOffsetColumn(r41, PaddingKt.m964paddingqDBjuR0$default(RowScope.CC.weight$default(r19, r42, 1.0f, false, 2, null), ContentLeftPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ContentRightPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null), ComposableLambdaKt.rememberComposableLambda(-595668326, true, new ThreeLine$ListItem$1$2(r36, r34, r35), r1, 54), r1, 390, 0);
        if (r37 == null) goto L116;
        r1.startReplaceGroup(2023227156);
        float r210 = ThreeLineTrailingTopPadding;
        ListItemKt.m2085access$OffsetToBaselineOrCenterKz89ssw(Dp.constructor-impl(r31 - r210), PaddingKt.m964paddingqDBjuR0$default(r42, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r210, TrailingRightPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 9, null), r37, r1, ((r12 >> 9) & 896) | 54, 0);
        r1.endReplaceGroup();
    L117:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final Modifier r43 = r310;
    L122:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L126;
        r111.updateScope(new xd(this, r43, r33, r34, r35, r36, r37, r39, r40));
        return;
    L126:
        return;
    L116:
        r1.startReplaceGroup(2023502002);
        r1.endReplaceGroup();
        goto L117
    L109:
        if (Intrinsics.areEqual(r28.rememberedValue(), Integer.valueOf(r22)) == true) goto L111;
    L105:
        r1.useNode();
        goto L106
    L112:
        r1.startReplaceGroup(2022716338);
        r1.endReplaceGroup();
        goto L113
    L95:
        if (Intrinsics.areEqual(r5.rememberedValue(), Integer.valueOf(r15)) == true) goto L97;
    L91:
        r1.useNode();
        goto L92
    L81:
        r3 = r8;
        goto L83
    L121:
        r1.skipToGroupEnd();
        r43 = r8;
        goto L122
    L76:
        r10 = false;
        goto L78
    L67:
        if ((r39 & 1572864) != 0) goto L73;
        if (r1.changed(this) == false) goto L71;
        int r112 = 1048576;
    L72:
        r9 = r9 | r112;
        goto L73
    L71:
        r112 = 524288;
        goto L72
    L57:
        if ((r39 & 196608) != 0) goto L64;
        if (r1.changedInstance(r37) == false) goto L61;
        int r113 = 131072;
    L62:
        r9 = r9 | r113;
        goto L64
    L61:
        r113 = 65536;
        goto L62
    L47:
        if ((r39 & 24576) != 0) goto L54;
        if (r1.changedInstance(r36) == false) goto L51;
        int r114 = 16384;
    L52:
        r9 = r9 | r114;
        goto L54
    L51:
        r114 = 8192;
        goto L52
    L37:
        if ((r39 & 3072) != 0) goto L44;
        if (r1.changedInstance(r35) == false) goto L41;
        int r115 = 2048;
    L42:
        r9 = r9 | r115;
        goto L44
    L41:
        r115 = 1024;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L34;
        if (r1.changedInstance(r34) == false) goto L31;
        int r116 = 256;
    L32:
        r9 = r9 | r116;
        goto L34
    L31:
        r116 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r1.changedInstance(r33) == false) goto L21;
        int r117 = 32;
    L22:
        r9 = r9 | r117;
        goto L24
    L21:
        r117 = 16;
        goto L22
    L6:
        if ((r39 & 6) != 0) goto L12;
        r8 = r32;
        if (r1.changed(r8) == false) goto L10;
        int r44 = 4;
    L11:
        r9 = r44 | r39;
        goto L14
    L10:
        r44 = 2;
        goto L11
    L12:
        r8 = r32;
        r9 = r39;
        goto L14
    }
}
