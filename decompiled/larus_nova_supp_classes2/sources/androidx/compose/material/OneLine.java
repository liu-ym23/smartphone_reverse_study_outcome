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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u0017R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/OneLine;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "F", "MinHeightWithIcon", "IconMinPaddedWidth", "IconLeftPadding", "IconVerticalPadding", "ContentLeftPadding", "ContentRightPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OneLine {
    private static final float ContentLeftPadding = 0.0f;
    private static final float ContentRightPadding = 0.0f;
    public static final OneLine INSTANCE = null;
    private static final float IconLeftPadding = 0.0f;
    private static final float IconMinPaddedWidth = 0.0f;
    private static final float IconVerticalPadding = 0.0f;
    private static final float MinHeight = 0.0f;
    private static final float MinHeightWithIcon = 0.0f;
    private static final float TrailingRightPadding = 0.0f;

    private OneLine() {
    }

    private static final Unit ListItem$lambda$4(OneLine r9, Modifier r10, Function2 r11, Function2 r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        r9.ListItem(r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(OneLine r0, Modifier r1, Function2 r2, Function2 r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return ListItem$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    static {
        INSTANCE = new OneLine();
        MinHeight = Dp.constructor-impl(48);
        MinHeightWithIcon = Dp.constructor-impl(56);
        IconMinPaddedWidth = Dp.constructor-impl(40);
        float r0 = 16;
        IconLeftPadding = Dp.constructor-impl(r0);
        IconVerticalPadding = Dp.constructor-impl(8);
        ContentLeftPadding = Dp.constructor-impl(r0);
        ContentRightPadding = Dp.constructor-impl(r0);
        TrailingRightPadding = Dp.constructor-impl(r0);
    }

    public final void ListItem(Modifier r26, final Function2<? super Composer, ? super Integer, Unit> r27, final Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(413592998);
        int r2 = r32 & 1;
        if (r2 == 0) goto L6;
        int r9 = r31 | 6;
        Modifier r8 = r26;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r9 = r9 | 48;
    L24:
        if ((r32 & 4) == 0) goto L27;
        r9 = r9 | 384;
    L34:
        if ((r32 & 8) == 0) goto L37;
        r9 = r9 | 3072;
    L44:
        if ((r32 & 16) == 0) goto L47;
        r9 = r9 | 24576;
    L55:
        if ((r9 & 9363) == 9362) goto L57;
        boolean r11 = true;
    L59:
        if (r1.shouldExecute(r11, r9 & 1) == false) goto L127;
        if (r2 == 0) goto L63;
        r8 = Modifier.Companion;
    L63:
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventStart(413592998, r9, -1, "androidx.compose.material.OneLine.ListItem (ListItem.kt:147)");
    L65:
        if (r27 != null) goto L67;
        float r0 = MinHeight;
    L68:
        Modifier r3 = SizeKt.m1002heightInVpY3zN4$default(r8, r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        Arrangement.Horizontal r12 = Arrangement.INSTANCE.getStart();
        Alignment.Companion r14 = Alignment.Companion;
        MeasurePolicy r13 = RowKt.rowMeasurePolicy(r12, r14.getTop(), r1, 0);
        int r15 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r16 = r1.getCurrentCompositionLocalMap();
        Modifier r4 = ComposedModifierKt.materializeModifier(r1, r3);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r5 = r17.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L74;
        r1.createNode(r5);
    L75:
        Composer r6 = Updater.constructor-impl(r1);
        Updater.set-impl(r6, r13, r17.getSetMeasurePolicy());
        Updater.set-impl(r6, r16, r17.getSetResolvedCompositionLocals());
        Function2 r7 = r17.getSetCompositeKeyHash();
        if (r6.getInserting() == false) goto L78;
    L79:
        r6.updateRememberedValue(Integer.valueOf(r15));
        r6.apply(Integer.valueOf(r15), r7);
    L80:
        Updater.set-impl(r6, r4, r17.getSetModifier());
        RowScopeInstance r10 = RowScopeInstance.INSTANCE;
        if (r27 == null) goto L95;
        r1.startReplaceGroup(-999770394);
        Modifier r18 = r10.align(Modifier.Companion, r14.getCenterVertically());
        float r19 = IconLeftPadding;
        Modifier r110 = SizeKt.m1021widthInVpY3zN4$default(r18, Dp.constructor-impl(r19 + IconMinPaddedWidth), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        float r22 = IconVerticalPadding;
        Modifier r20 = PaddingKt.m964paddingqDBjuR0$default(r110, r19, r22, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r22, 4, null);
        MeasurePolicy r21 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getCenterStart(), false);
        int r111 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r112 = r1.getCurrentCompositionLocalMap();
        Modifier r23 = ComposedModifierKt.materializeModifier(r1, r20);
        Function0 r113 = r17.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L85;
        ComposablesKt.invalidApplier();
    L85:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L88;
        r1.createNode(r113);
    L89:
        Composer r114 = Updater.constructor-impl(r1);
        Updater.set-impl(r114, r21, r17.getSetMeasurePolicy());
        Updater.set-impl(r114, r112, r17.getSetResolvedCompositionLocals());
        Function2 r24 = r17.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L92;
    L93:
        r114.updateRememberedValue(Integer.valueOf(r111));
        r114.apply(Integer.valueOf(r111), r24);
    L94:
        Updater.set-impl(r114, r23, r17.getSetModifier());
        BoxScopeInstance r25 = BoxScopeInstance.INSTANCE;
        r27.invoke(r1, Integer.valueOf((r9 >> 3) & 14));
        r1.endNode();
        r1.endReplaceGroup();
    L96:
        Modifier.Companion r33 = Modifier.Companion;
        Modifier r34 = PaddingKt.m964paddingqDBjuR0$default(r10.align(RowScope.CC.weight$default(r10, r33, 1.0f, false, 2, null), r14.getCenterVertically()), ContentLeftPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ContentRightPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null);
        MeasurePolicy r115 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getCenterStart(), false);
        int r116 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r117 = r1.getCurrentCompositionLocalMap();
        Modifier r35 = ComposedModifierKt.materializeModifier(r1, r34);
        Function0 r118 = r17.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L99;
        ComposablesKt.invalidApplier();
    L99:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L102;
        r1.createNode(r118);
    L103:
        Composer r36 = Updater.constructor-impl(r1);
        Updater.set-impl(r36, r115, r17.getSetMeasurePolicy());
        Updater.set-impl(r36, r117, r17.getSetResolvedCompositionLocals());
        Function2 r119 = r17.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L106;
    L107:
        r36.updateRememberedValue(Integer.valueOf(r116));
        r36.apply(Integer.valueOf(r116), r119);
    L108:
        Updater.set-impl(r36, r35, r17.getSetModifier());
        BoxScopeInstance r37 = BoxScopeInstance.INSTANCE;
        r28.invoke(r1, Integer.valueOf((r9 >> 6) & 14));
        r1.endNode();
        if (r29 == null) goto L123;
        r1.startReplaceGroup(-998918452);
        Modifier r38 = PaddingKt.m964paddingqDBjuR0$default(r10.align(r33, r14.getCenterVertically()), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, TrailingRightPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 11, null);
        MeasurePolicy r39 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getTopStart(), false);
        int r40 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r41 = r1.getCurrentCompositionLocalMap();
        Modifier r42 = ComposedModifierKt.materializeModifier(r1, r38);
        Function0 r120 = r17.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L113;
        ComposablesKt.invalidApplier();
    L113:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L116;
        r1.createNode(r120);
    L117:
        Composer r121 = Updater.constructor-impl(r1);
        Updater.set-impl(r121, r39, r17.getSetMeasurePolicy());
        Updater.set-impl(r121, r41, r17.getSetResolvedCompositionLocals());
        Function2 r43 = r17.getSetCompositeKeyHash();
        if (r121.getInserting() == false) goto L120;
    L121:
        r121.updateRememberedValue(Integer.valueOf(r40));
        r121.apply(Integer.valueOf(r40), r43);
    L122:
        Updater.set-impl(r121, r42, r17.getSetModifier());
        r29.invoke(r1, Integer.valueOf((r9 >> 9) & 14));
        r1.endNode();
        r1.endReplaceGroup();
    L124:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
    L128:
        final Modifier r44 = r8;
        ScopeUpdateScope r45 = r1.endRestartGroup();
        if (r45 == null) goto L132;
        r45.updateScope(new f7(this, r44, r27, r28, r29, r31, r32));
        return;
    L132:
        return;
    L120:
        if (Intrinsics.areEqual(r121.rememberedValue(), Integer.valueOf(r40)) == true) goto L122;
    L116:
        r1.useNode();
        goto L117
    L123:
        r1.startReplaceGroup(-998722408);
        r1.endReplaceGroup();
        goto L124
    L106:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r116)) == true) goto L108;
    L102:
        r1.useNode();
        goto L103
    L92:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r111)) == true) goto L94;
    L88:
        r1.useNode();
        goto L89
    L95:
        r1.startReplaceGroup(-999261064);
        r1.endReplaceGroup();
        goto L96
    L78:
        if (Intrinsics.areEqual(r6.rememberedValue(), Integer.valueOf(r15)) == true) goto L80;
    L74:
        r1.useNode();
        goto L75
    L67:
        r0 = MinHeightWithIcon;
        goto L68
    L127:
        r1.skipToGroupEnd();
        goto L128
    L57:
        r11 = false;
        goto L59
    L47:
        if ((r31 & 24576) != 0) goto L55;
        if (r1.changed(this) == false) goto L51;
        int r122 = 16384;
    L52:
        r9 = r9 | r122;
        goto L55
    L51:
        r122 = 8192;
        goto L52
    L37:
        if ((r31 & 3072) != 0) goto L44;
        if (r1.changedInstance(r29) == false) goto L41;
        int r123 = 2048;
    L42:
        r9 = r9 | r123;
        goto L44
    L41:
        r123 = 1024;
        goto L42
    L27:
        if ((r31 & 384) != 0) goto L34;
        if (r1.changedInstance(r28) == false) goto L31;
        int r124 = 256;
    L32:
        r9 = r9 | r124;
        goto L34
    L31:
        r124 = 128;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L24;
        if (r1.changedInstance(r27) == false) goto L21;
        int r125 = 32;
    L22:
        r9 = r9 | r125;
        goto L24
    L21:
        r125 = 16;
        goto L22
    L6:
        if ((r31 & 6) != 0) goto L12;
        r8 = r26;
        if (r1.changed(r8) == false) goto L10;
        int r46 = 4;
    L11:
        r9 = r46 | r31;
        goto L14
    L10:
        r46 = 2;
        goto L11
    L12:
        r8 = r26;
        r9 = r31;
        goto L14
    }
}
