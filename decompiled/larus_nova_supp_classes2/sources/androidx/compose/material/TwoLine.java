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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J~\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\u001fR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006 "}, d2 = {"Landroidx/compose/material/TwoLine;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "F", "MinHeightWithIcon", "IconMinPaddedWidth", "IconLeftPadding", "IconVerticalPadding", "ContentLeftPadding", "ContentRightPadding", "OverlineBaselineOffset", "OverlineToPrimaryBaselineOffset", "PrimaryBaselineOffsetNoIcon", "PrimaryBaselineOffsetWithIcon", "PrimaryToSecondaryBaselineOffsetNoIcon", "PrimaryToSecondaryBaselineOffsetWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TwoLine {
    private static final float ContentLeftPadding = 0.0f;
    private static final float ContentRightPadding = 0.0f;
    public static final TwoLine INSTANCE = null;
    private static final float IconLeftPadding = 0.0f;
    private static final float IconMinPaddedWidth = 0.0f;
    private static final float IconVerticalPadding = 0.0f;
    private static final float MinHeight = 0.0f;
    private static final float MinHeightWithIcon = 0.0f;
    private static final float OverlineBaselineOffset = 0.0f;
    private static final float OverlineToPrimaryBaselineOffset = 0.0f;
    private static final float PrimaryBaselineOffsetNoIcon = 0.0f;
    private static final float PrimaryBaselineOffsetWithIcon = 0.0f;
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon = 0.0f;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon = 0.0f;
    private static final float TrailingRightPadding = 0.0f;

    private TwoLine() {
    }

    private static final Unit ListItem$lambda$2(TwoLine r11, Modifier r12, Function2 r13, Function2 r14, Function2 r15, Function2 r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        r11.ListItem(r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TwoLine r0, Modifier r1, Function2 r2, Function2 r3, Function2 r4, Function2 r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return ListItem$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        INSTANCE = new TwoLine();
        MinHeight = Dp.constructor-impl(64);
        MinHeightWithIcon = Dp.constructor-impl(72);
        IconMinPaddedWidth = Dp.constructor-impl(40);
        float r0 = 16;
        IconLeftPadding = Dp.constructor-impl(r0);
        IconVerticalPadding = Dp.constructor-impl(r0);
        ContentLeftPadding = Dp.constructor-impl(r0);
        ContentRightPadding = Dp.constructor-impl(r0);
        OverlineBaselineOffset = Dp.constructor-impl(24);
        float r1 = 20;
        OverlineToPrimaryBaselineOffset = Dp.constructor-impl(r1);
        PrimaryBaselineOffsetNoIcon = Dp.constructor-impl(28);
        PrimaryBaselineOffsetWithIcon = Dp.constructor-impl(32);
        PrimaryToSecondaryBaselineOffsetNoIcon = Dp.constructor-impl(r1);
        PrimaryToSecondaryBaselineOffsetWithIcon = Dp.constructor-impl(r1);
        TrailingRightPadding = Dp.constructor-impl(r0);
    }

    public static final /* synthetic */ float access$getTrailingRightPadding$p() {
        return TrailingRightPadding;
    }

    public final void ListItem(Modifier r32, final Function2<? super Composer, ? super Integer, Unit> r33, final Function2<? super Composer, ? super Integer, Unit> r34, final Function2<? super Composer, ? super Integer, Unit> r35, final Function2<? super Composer, ? super Integer, Unit> r36, final Function2<? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(598947838);
        int r2 = r40 & 1;
        if (r2 == 0) goto L6;
        int r11 = r39 | 6;
        Modifier r10 = r32;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r11 = r11 | 48;
    L24:
        if ((r40 & 4) == 0) goto L27;
        r11 = r11 | 384;
    L34:
        if ((r40 & 8) == 0) goto L37;
        r11 = r11 | 3072;
    L44:
        if ((r40 & 16) == 0) goto L47;
        r11 = r11 | 24576;
    L54:
        if ((r40 & 32) == 0) goto L57;
        r11 = r11 | 196608;
    L64:
        if ((r40 & 64) == 0) goto L67;
        r11 = r11 | 1572864;
    L74:
        if ((599187 & r11) == 599186) goto L76;
        boolean r12 = true;
    L78:
        if (r1.shouldExecute(r12, r11 & 1) == false) goto L139;
        if (r2 == 0) goto L81;
        Modifier r3 = Modifier.Companion;
    L83:
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventStart(598947838, r11, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:214)");
    L85:
        if (r33 != null) goto L87;
        final float r0 = MinHeight;
    L88:
        Modifier r13 = SizeKt.m1002heightInVpY3zN4$default(r3, r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        Arrangement.Horizontal r14 = Arrangement.INSTANCE.getStart();
        Alignment.Companion r15 = Alignment.Companion;
        MeasurePolicy r16 = RowKt.rowMeasurePolicy(r14, r15.getTop(), r1, 0);
        int r17 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r9 = r1.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r1, r13);
        ComposeUiNode.Companion r23 = ComposeUiNode.Companion;
        Modifier r310 = r3;
        Function0 r4 = r23.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L91;
        ComposablesKt.invalidApplier();
    L91:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L94;
        r1.createNode(r4);
    L95:
        Composer r5 = Updater.constructor-impl(r1);
        Updater.set-impl(r5, r16, r23.getSetMeasurePolicy());
        Updater.set-impl(r5, r9, r23.getSetResolvedCompositionLocals());
        Function2 r8 = r23.getSetCompositeKeyHash();
        if (r5.getInserting() == false) goto L98;
    L99:
        r5.updateRememberedValue(Integer.valueOf(r17));
        r5.apply(Integer.valueOf(r17), r8);
    L100:
        Updater.set-impl(r5, r18, r23.getSetModifier());
        RowScopeInstance r19 = RowScopeInstance.INSTANCE;
        Modifier.Companion r6 = Modifier.Companion;
        Modifier r110 = PaddingKt.m964paddingqDBjuR0$default(RowScope.CC.weight$default(r19, r6, 1.0f, false, 2, null), ContentLeftPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ContentRightPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null);
        if (r33 == null) goto L115;
        r1.startReplaceGroup(1807018686);
        float r20 = IconLeftPadding;
        Modifier r111 = SizeKt.m1018sizeInqDBjuR0$default(r6, Dp.constructor-impl(IconMinPaddedWidth + r20), r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 12, null);
        float r21 = IconVerticalPadding;
        Modifier r7 = PaddingKt.m964paddingqDBjuR0$default(r111, r20, r21, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r21, 4, null);
        MeasurePolicy r22 = BoxKt.maybeCachedBoxMeasurePolicy(r15.getTopStart(), false);
        int r112 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r24 = r1.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r1, r7);
        Function0 r113 = r23.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L105;
        ComposablesKt.invalidApplier();
    L105:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L108;
        r1.createNode(r113);
    L109:
        Composer r114 = Updater.constructor-impl(r1);
        Updater.set-impl(r114, r22, r23.getSetMeasurePolicy());
        Updater.set-impl(r114, r24, r23.getSetResolvedCompositionLocals());
        Function2 r26 = r23.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L112;
    L113:
        r114.updateRememberedValue(Integer.valueOf(r112));
        r114.apply(Integer.valueOf(r112), r26);
    L114:
        Updater.set-impl(r114, r25, r23.getSetModifier());
        BoxScopeInstance r27 = BoxScopeInstance.INSTANCE;
        r33.invoke(r1, Integer.valueOf((r11 >> 3) & 14));
        r1.endNode();
        r1.endReplaceGroup();
    L117:
        if (r36 == null) goto L119;
        r1.startReplaceGroup(1807622349);
        boolean r28 = true;
        ListItemKt.access$BaselinesOffsetColumn(CollectionsKt.listOf(new Dp[]{Dp.box-impl(OverlineBaselineOffset), Dp.box-impl(OverlineToPrimaryBaselineOffset)}), r110, ComposableLambdaKt.rememberComposableLambda(979717374, true, new TwoLine$ListItem$1$2(r36, r34), r1, 54), r1, 390, 0);
        r1.endReplaceGroup();
    L128:
        if (r37 == null) goto L134;
        r1.startReplaceGroup(1808643799);
        if (r33 == null) goto L132;
        float r29 = PrimaryBaselineOffsetWithIcon;
    L133:
        ListItemKt.m2085access$OffsetToBaselineOrCenterKz89ssw(r29, null, ComposableLambdaKt.rememberComposableLambda(-1476831345, r28, new TwoLine$ListItem$1$4(r0, r37), r1, 54), r1, 384, 2);
        r1.endReplaceGroup();
    L135:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventEnd();
    L138:
        final Modifier r30 = r310;
    L140:
        ScopeUpdateScope r115 = r1.endRestartGroup();
        if (r115 == null) goto L144;
        r115.updateScope(new yd(this, r30, r33, r34, r35, r36, r37, r39, r40));
        return;
    L144:
        return;
    L132:
        r29 = PrimaryBaselineOffsetNoIcon;
        goto L133
    L134:
        r1.startReplaceGroup(1809267488);
        r1.endReplaceGroup();
        goto L135
    L119:
        r28 = true;
        r1.startReplaceGroup(1807914338);
        Dp[] r31 = new Dp[2];
        if (r33 == null) goto L122;
        float r41 = PrimaryBaselineOffsetWithIcon;
    L123:
        r31[0] = Dp.box-impl(r41);
        if (r33 == null) goto L126;
        float r42 = PrimaryToSecondaryBaselineOffsetWithIcon;
    L127:
        r31[1] = Dp.box-impl(r42);
        ListItemKt.access$BaselinesOffsetColumn(CollectionsKt.listOf(r31), r110, ComposableLambdaKt.rememberComposableLambda(-1888627961, true, new TwoLine$ListItem$1$3(r34, r35), r1, 54), r1, 384, 0);
        r1.endReplaceGroup();
        goto L128
    L126:
        r42 = PrimaryToSecondaryBaselineOffsetNoIcon;
        goto L127
    L122:
        r41 = PrimaryBaselineOffsetNoIcon;
        goto L123
    L112:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r112)) == true) goto L114;
    L108:
        r1.useNode();
        goto L109
    L115:
        r1.startReplaceGroup(1807574144);
        r1.endReplaceGroup();
        goto L117
    L98:
        if (Intrinsics.areEqual(r5.rememberedValue(), Integer.valueOf(r17)) == true) goto L100;
    L94:
        r1.useNode();
        goto L95
    L87:
        r0 = MinHeightWithIcon;
        goto L88
    L81:
        r3 = r10;
        goto L83
    L139:
        r1.skipToGroupEnd();
        r30 = r10;
        goto L140
    L76:
        r12 = false;
        goto L78
    L67:
        if ((r39 & 1572864) != 0) goto L74;
        if (r1.changed(this) == false) goto L71;
        int r116 = 1048576;
    L72:
        r11 = r11 | r116;
        goto L74
    L71:
        r116 = 524288;
        goto L72
    L57:
        if ((r39 & 196608) != 0) goto L64;
        if (r1.changedInstance(r37) == false) goto L61;
        int r117 = 131072;
    L62:
        r11 = r11 | r117;
        goto L64
    L61:
        r117 = 65536;
        goto L62
    L47:
        if ((r39 & 24576) != 0) goto L54;
        if (r1.changedInstance(r36) == false) goto L51;
        int r118 = 16384;
    L52:
        r11 = r11 | r118;
        goto L54
    L51:
        r118 = 8192;
        goto L52
    L37:
        if ((r39 & 3072) != 0) goto L44;
        if (r1.changedInstance(r35) == false) goto L41;
        int r119 = 2048;
    L42:
        r11 = r11 | r119;
        goto L44
    L41:
        r119 = 1024;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L34;
        if (r1.changedInstance(r34) == false) goto L31;
        int r120 = 256;
    L32:
        r11 = r11 | r120;
        goto L34
    L31:
        r120 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r1.changedInstance(r33) == false) goto L21;
        int r121 = 32;
    L22:
        r11 = r11 | r121;
        goto L24
    L21:
        r121 = 16;
        goto L22
    L6:
        if ((r39 & 6) != 0) goto L12;
        r10 = r32;
        if (r1.changed(r10) == false) goto L10;
        int r122 = 4;
    L11:
        r11 = r122 | r39;
        goto L14
    L10:
        r122 = 2;
        goto L11
    L12:
        r10 = r32;
        r11 = r39;
        goto L14
    }
}
