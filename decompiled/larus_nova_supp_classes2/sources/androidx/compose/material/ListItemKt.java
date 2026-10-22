package androidx.compose.material;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\r\u001a8\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BaselinesOffsetColumn", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "content", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListItemKt {
    private static final Unit BaselinesOffsetColumn$lambda$4(List r6, Modifier r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        BaselinesOffsetColumn(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit ListItem$lambda$2(Modifier r11, Function2 r12, Function2 r13, boolean r14, Function2 r15, Function2 r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        ListItem(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit OffsetToBaselineOrCenter_Kz89ssw$lambda$6(float r6, Modifier r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        m2084OffsetToBaselineOrCenterKz89ssw(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(float r0, Modifier r1, Function2 r2, int r3, int r4, Composer r5, int r6) {
        return OffsetToBaselineOrCenter_Kz89ssw$lambda$6(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit b(Modifier r0, Function2 r1, Function2 r2, boolean r3, Function2 r4, Function2 r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return ListItem$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit c(List r0, Modifier r1, Function2 r2, int r3, int r4, Composer r5, int r6) {
        return BaselinesOffsetColumn$lambda$4(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit d(SemanticsPropertyReceiver r0) {
        return ListItem$lambda$1$lambda$0(r0);
    }

    private static final Unit ListItem$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle r4, final float r5, final Function2<? super Composer, ? super Integer, Unit> r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        final LineHeightStyle r1 = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getProportional-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), null);
        return ComposableLambdaKt.composableLambdaInstance(-1000595778, true, new AnonymousClass1(r5, r4, r1, r6));
    }

    private static final void BaselinesOffsetColumn(final List<Dp> r8, Modifier r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12, final int r13) {
        Composer r14 = r11.startRestartGroup(872528548);
        if ((r13 & 1) == 0) goto L6;
        int r1 = r12 | 6;
    L13:
        int r2 = r13 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r13 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r1 & 147) == 146) goto L36;
        boolean r3 = true;
    L38:
        if (r14.shouldExecute(r3, r1 & 1) == false) goto L64;
        if (r2 == 0) goto L42;
        r9 = Modifier.Companion;
    L42:
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventStart(872528548, r1, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:364)");
    L44:
        boolean r0 = r14.changedInstance(r8);
        Object r4 = r14.rememberedValue();
        if (r0 == false) goto L47;
    L48:
        r4 = new ListItemKt$BaselinesOffsetColumn$1$1(r8);
        r14.updateRememberedValue(r4);
    L49:
        MeasurePolicy r5 = (MeasurePolicy) r4;
        int r6 = ((r1 >> 6) & 14) | (r1 & 112);
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r15 = r14.getCurrentCompositionLocalMap();
        Modifier r16 = ComposedModifierKt.materializeModifier(r14, r9);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        int r19 = ((r6 << 6) & 896) | 6;
        if ((r14.getApplier() instanceof Applier) == true) goto L52;
        ComposablesKt.invalidApplier();
    L52:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L55;
        r14.createNode(r18);
    L56:
        Composer r20 = Updater.constructor-impl(r14);
        Updater.set-impl(r20, r5, r17.getSetMeasurePolicy());
        Updater.set-impl(r20, r15, r17.getSetResolvedCompositionLocals());
        Function2 r21 = r17.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L59;
    L60:
        r20.updateRememberedValue(Integer.valueOf(r7));
        r20.apply(Integer.valueOf(r7), r21);
    L61:
        Updater.set-impl(r20, r16, r17.getSetModifier());
        r10.invoke(r14, Integer.valueOf((r19 >> 6) & 14));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventEnd();
    L65:
        final Modifier r22 = r9;
        ScopeUpdateScope r23 = r14.endRestartGroup();
        if (r23 == null) goto L69;
        r23.updateScope(new t5(r8, r22, r10, r12, r13));
        return;
    L69:
        return;
    L59:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r7)) == true) goto L61;
    L55:
        r14.useNode();
        goto L56
    L47:
        if (r4 != Composer.Companion.getEmpty()) goto L49;
    L64:
        r14.skipToGroupEnd();
        goto L65
    L36:
        r3 = false;
        goto L38
    L27:
        if ((r12 & 384) != 0) goto L34;
        if (r14.changedInstance(r10) == false) goto L31;
        int r24 = 256;
    L32:
        r1 = r1 | r24;
        goto L34
    L31:
        r24 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L24;
        if (r14.changed(r9) == false) goto L21;
        int r25 = 32;
    L22:
        r1 = r1 | r25;
        goto L24
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r1 = r12;
        goto L13
    L8:
        if (r14.changedInstance(r8) == false) goto L10;
        int r26 = 4;
    L11:
        r1 = r26 | r12;
        goto L13
    L10:
        r26 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    private static final void m2084OffsetToBaselineOrCenterKz89ssw(final float r8, Modifier r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12, final int r13) {
        Composer r14 = r11.startRestartGroup(953221030);
        if ((r13 & 1) == 0) goto L6;
        int r1 = r12 | 6;
    L13:
        int r3 = r13 & 2;
        if (r3 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r13 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        boolean r7 = true;
        if ((r1 & 147) == 146) goto L36;
        boolean r4 = true;
    L38:
        if (r14.shouldExecute(r4, r1 & 1) == false) goto L68;
        if (r3 == 0) goto L42;
        r9 = Modifier.Companion;
    L42:
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(953221030, r1, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:403)");
    L45:
        if ((r1 & 14) == 4) goto L48;
        r7 = false;
    L48:
        Object r0 = r14.rememberedValue();
        if (r7 == false) goto L51;
    L52:
        r0 = new ListItemKt$OffsetToBaselineOrCenter$1$1(r8);
        r14.updateRememberedValue(r0);
    L53:
        MeasurePolicy r2 = (MeasurePolicy) r0;
        int r5 = (r1 >> 6) & 14;
        int r6 = (r1 & 112) | r5;
        int r15 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r16 = r14.getCurrentCompositionLocalMap();
        Modifier r17 = ComposedModifierKt.materializeModifier(r14, r9);
        ComposeUiNode.Companion r18 = ComposeUiNode.Companion;
        Function0 r19 = r18.getConstructor();
        int r20 = ((r6 << 6) & 896) | 6;
        if ((r14.getApplier() instanceof Applier) == true) goto L56;
        ComposablesKt.invalidApplier();
    L56:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L59;
        r14.createNode(r19);
    L60:
        Composer r21 = Updater.constructor-impl(r14);
        Updater.set-impl(r21, r2, r18.getSetMeasurePolicy());
        Updater.set-impl(r21, r16, r18.getSetResolvedCompositionLocals());
        Function2 r22 = r18.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L63;
    L64:
        r21.updateRememberedValue(Integer.valueOf(r15));
        r21.apply(Integer.valueOf(r15), r22);
    L65:
        Updater.set-impl(r21, r17, r18.getSetModifier());
        r10.invoke(r14, Integer.valueOf((r20 >> 6) & 14));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
    L69:
        final Modifier r23 = r9;
        ScopeUpdateScope r24 = r14.endRestartGroup();
        if (r24 == null) goto L73;
        r24.updateScope(new u5(r8, r23, r10, r12, r13));
        return;
    L73:
        return;
    L63:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r15)) == true) goto L65;
    L59:
        r14.useNode();
        goto L60
    L51:
        if (r0 != Composer.Companion.getEmpty()) goto L53;
    L68:
        r14.skipToGroupEnd();
        goto L69
    L36:
        r4 = false;
        goto L38
    L27:
        if ((r12 & 384) != 0) goto L33;
        if (r14.changedInstance(r10) == false) goto L31;
        int r25 = 256;
    L32:
        r1 = r1 | r25;
        goto L33
    L31:
        r25 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L24;
        if (r14.changed(r9) == false) goto L21;
        int r26 = 32;
    L22:
        r1 = r1 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r1 = r12;
        goto L13
    L8:
        if (r14.changed(r8) == false) goto L10;
        int r27 = 4;
    L11:
        r1 = r27 | r12;
        goto L13
    L10:
        r27 = 2;
        goto L11
    }

    public static final /* synthetic */ void access$BaselinesOffsetColumn(List r0, Modifier r1, Function2 r2, Composer r3, int r4, int r5) {
        BaselinesOffsetColumn(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: access$OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final /* synthetic */ void m2085access$OffsetToBaselineOrCenterKz89ssw(float r0, Modifier r1, Function2 r2, Composer r3, int r4, int r5) {
        m2084OffsetToBaselineOrCenterKz89ssw(r0, r1, r2, r3, r4, r5);
    }

    public static final void ListItem(Modifier r21, Function2<? super Composer, ? super Integer, Unit> r22, Function2<? super Composer, ? super Integer, Unit> r23, boolean r24, Function2<? super Composer, ? super Integer, Unit> r25, Function2<? super Composer, ? super Integer, Unit> r26, final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(1618131318);
        int r2 = r30 & 1;
        if (r2 == 0) goto L6;
        int r4 = r29 | 6;
    L13:
        int r5 = r30 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r30 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Function2<? super Composer, ? super Integer, Unit> r10 = r23;
    L35:
        int r11 = r30 & 8;
        if (r11 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r12 = r24;
    L46:
        int r13 = r30 & 16;
        if (r13 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        Function2<? super Composer, ? super Integer, Unit> r14 = r25;
    L57:
        int r15 = r30 & 32;
        if (r15 == 0) goto L61;
        r4 = r4 | 196608;
    L68:
        if ((r30 & 64) == 0) goto L71;
        r4 = r4 | 1572864;
    L78:
        if ((r4 & 599187) == 599186) goto L80;
        boolean r0 = true;
    L82:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L121;
        if (r2 == 0) goto L85;
        Modifier r3 = Modifier.Companion;
    L86:
        Function2<? super Composer, ? super Integer, Unit> r6 = null;
        if (r5 == 0) goto L89;
        Function2<? super Composer, ? super Integer, Unit> r7 = null;
    L90:
        if (r9 == 0) goto L92;
        Function2<? super Composer, ? super Integer, Unit> r8 = null;
    L93:
        if (r11 == 0) goto L95;
        boolean r19 = true;
    L96:
        if (r13 == 0) goto L98;
        r14 = null;
    L98:
        if (r15 != 0) goto L102;
        r6 = r26;
    L102:
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventStart(1618131318, r4, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
    L104:
        Typography r16 = MaterialTheme.INSTANCE.getTypography(r1, 6);
        TextStyle r17 = r16.getSubtitle1();
        ContentAlpha r18 = ContentAlpha.INSTANCE;
        Function2<? super Composer, ? super Integer, Unit> r110 = applyTextStyle(r17, r18.getHigh(r1, 6), r27);
        Intrinsics.checkNotNull(r110);
        Function2<? super Composer, ? super Integer, Unit> r111 = applyTextStyle(r16.getBody2(), r18.getMedium(r1, 6), r8);
        Function2<? super Composer, ? super Integer, Unit> r20 = applyTextStyle(r16.getOverline(), r18.getHigh(r1, 6), r14);
        Function2<? super Composer, ? super Integer, Unit> r112 = applyTextStyle(r16.getCaption(), r18.getHigh(r1, 6), r6);
        Object r31 = r1.rememberedValue();
        if (r31 != Composer.Companion.getEmpty()) goto L107;
        r31 = new r5();
        r1.updateRememberedValue(r31);
    L107:
        Modifier r113 = SemanticsModifierKt.semantics(r3, true, (Function1) r31);
        if (r111 != null) goto L111;
        if (r20 != null) goto L111;
        r1.startReplaceGroup(-961912553);
        Function2<? super Composer, ? super Integer, Unit> r210 = r14;
        OneLine.INSTANCE.ListItem(r113, r7, r110, r112, r1, (r4 & 112) | 24576, 0);
        r1.endReplaceGroup();
    L118:
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final Function2<? super Composer, ? super Integer, Unit> r32 = r6;
        r10 = r8;
        final boolean r33 = r19;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r210;
        Modifier r35 = r3;
    L122:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L126;
        final Modifier r36 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r37 = r7;
        final Function2<? super Composer, ? super Integer, Unit> r38 = r10;
        r114.updateScope(new s5(r36, r37, r38, r33, r34, r32, r27, r29, r30));
        return;
    L126:
        return;
    L111:
        r210 = r14;
        if (r20 != null) goto L114;
        if (r19 == false) goto L114;
    L115:
        r1.startReplaceGroup(-961713285);
        TwoLine.INSTANCE.ListItem(r113, r7, r110, r111, r20, r112, r1, (r4 & 112) | 1572864, 0);
        r1.endReplaceGroup();
    L114:
        if (r111 == null) goto L115;
        r1.startReplaceGroup(-961499943);
        ThreeLine.INSTANCE.ListItem(r113, r7, r110, r111, r20, r112, r1, (r4 & 112) | 1572864, 0);
        r1.endReplaceGroup();
        goto L118
    L95:
        r19 = r12;
        goto L96
    L92:
        r8 = r10;
        goto L93
    L89:
        r7 = r22;
        goto L90
    L85:
        r3 = r21;
        goto L86
    L121:
        r1.skipToGroupEnd();
        r35 = r21;
        r7 = r22;
        r32 = r26;
        r33 = r12;
        r34 = r14;
        goto L122
    L80:
        r0 = false;
        goto L82
    L71:
        if ((r29 & 1572864) != 0) goto L78;
        if (r1.changedInstance(r27) == false) goto L75;
        int r115 = 1048576;
    L76:
        r4 = r4 | r115;
        goto L78
    L75:
        r115 = 524288;
        goto L76
    L61:
        if ((r29 & 196608) != 0) goto L68;
        if (r1.changedInstance(r26) == false) goto L65;
        int r116 = 131072;
    L66:
        r4 = r4 | r116;
        goto L68
    L65:
        r116 = 65536;
        goto L66
    L50:
        if ((r29 & 24576) != 0) goto L56;
        r14 = r25;
        if (r1.changedInstance(r14) == false) goto L54;
        int r117 = 16384;
    L55:
        r4 = r4 | r117;
        goto L57
    L54:
        r117 = 8192;
        goto L55
    L39:
        if ((r29 & 3072) != 0) goto L45;
        r12 = r24;
        if (r1.changed(r12) == false) goto L43;
        int r118 = 2048;
    L44:
        r4 = r4 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r29 & 384) != 0) goto L34;
        r10 = r23;
        if (r1.changedInstance(r10) == false) goto L32;
        int r119 = 256;
    L33:
        r4 = r4 | r119;
        goto L35
    L32:
        r119 = 128;
        goto L33
    L17:
        if ((r29 & 48) != 0) goto L24;
        if (r1.changedInstance(r22) == false) goto L21;
        int r39 = 32;
    L22:
        r4 = r4 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r29 & 6) == 0) goto L8;
        r4 = r29;
        goto L13
    L8:
        if (r1.changed(r21) == false) goto L10;
        int r40 = 4;
    L11:
        r4 = r40 | r29;
        goto L13
    L10:
        r40 = 2;
        goto L11
    }
}
