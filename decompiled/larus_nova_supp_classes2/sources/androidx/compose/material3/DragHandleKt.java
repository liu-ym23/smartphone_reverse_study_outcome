package androidx.compose.material3;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.DragInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"VerticalDragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "colors", "Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DragHandleSizes;Landroidx/compose/material3/DragHandleColors;Landroidx/compose/material3/DragHandleShapes;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "pressable", "onPressed", "Lkotlin/Function0;", "onReleasedOrCancelled", "material3", "isDragged", "", "isPressed"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragHandleKt {
    private static final Unit VerticalDragHandle$lambda$16(Modifier r9, DragHandleSizes r10, DragHandleColors r11, DragHandleShapes r12, MutableInteractionSource r13, int r14, int r15, Composer r16, int r17) {
        VerticalDragHandle(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return VerticalDragHandle$lambda$13$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit b(Modifier r0, DragHandleSizes r1, DragHandleColors r2, DragHandleShapes r3, MutableInteractionSource r4, int r5, int r6, Composer r7, int r8) {
        return VerticalDragHandle$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(MutableState r0) {
        return VerticalDragHandle$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ Unit d(DragHandleColors r0, State r1, MutableState r2, DrawScope r3) {
        return VerticalDragHandle$lambda$15$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(DragHandleShapes r0, State r1, MutableState r2, GraphicsLayerScope r3) {
        return VerticalDragHandle$lambda$10$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ MeasureResult f(DragHandleSizes r0, State r1, MutableState r2, MeasureScope r3, Measurable r4, Constraints r5) {
        return VerticalDragHandle$lambda$13$lambda$12(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit g(MutableState r0) {
        return VerticalDragHandle$lambda$6$lambda$5(r0);
    }

    private static final boolean VerticalDragHandle$lambda$1(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean VerticalDragHandle$lambda$3(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Unit VerticalDragHandle$lambda$6$lambda$5(MutableState r1) {
        VerticalDragHandle$lambda$4(r1, true);
        return Unit.INSTANCE;
    }

    private static final Unit VerticalDragHandle$lambda$8$lambda$7(MutableState r1) {
        VerticalDragHandle$lambda$4(r1, false);
        return Unit.INSTANCE;
    }

    private static final Unit VerticalDragHandle$lambda$13$lambda$12$lambda$11(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.placeRelative$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final void VerticalDragHandle$lambda$4(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final Unit VerticalDragHandle$lambda$10$lambda$9(DragHandleShapes r0, State r1, MutableState r2, GraphicsLayerScope r3) {
        if (VerticalDragHandle$lambda$1(r1) == false) goto L6;
        Shape r4 = r0.getDraggedShape();
    L9:
        r3.setShape(r4);
        r3.setClip(true);
        return Unit.INSTANCE;
    L6:
        if (VerticalDragHandle$lambda$3(r2) == false) goto L8;
        r4 = r0.getPressedShape();
        goto L9
    L8:
        r4 = r0.getShape();
        goto L9
    }

    private static final Unit VerticalDragHandle$lambda$15$lambda$14(DragHandleColors r15, State r16, MutableState r17, DrawScope r18) {
        if (VerticalDragHandle$lambda$1(r16) == false) goto L7;
        long r0 = r15.m2637getDraggedColor0d7_KjU();
    L10:
        DrawScope.-CC.drawRect-n-J9OG0$default(r18, r0, 0, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 126, null);
        return Unit.INSTANCE;
    L7:
        if (VerticalDragHandle$lambda$3(r17) == false) goto L9;
        r0 = r15.m2638getPressedColor0d7_KjU();
        goto L10
    L9:
        r0 = r15.m2636getColor0d7_KjU();
        goto L10
    }

    private static final Modifier pressable(Modifier r1, MutableInteractionSource r2, final Function0<Unit> r3, final Function0<Unit> r4) {
        return SuspendingPointerInputFilterKt.pointerInput(r1, r2, new AnonymousClass1(r3, r4));
    }

    private static final MeasureResult VerticalDragHandle$lambda$13$lambda$12(DragHandleSizes r7, State r8, MutableState r9, MeasureScope r10, Measurable r11, Constraints r12) {
        if (VerticalDragHandle$lambda$1(r8) == false) goto L6;
        long r13 = r7.m2639getDraggedSizeMYxV2XQ();
    L9:
        long r14 = r10.toSize-XkaWNTQ(r13);
        final Placeable r15 = r11.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(Math.round(Float.intBitsToFloat((int) (r14 >> 32))), Math.round(Float.intBitsToFloat((int) (r14 & 4294967295L)))));
        return MeasureScope.-CC.layout$default(r10, r15.getWidth(), r15.getHeight(), null, new m9(r15), 4, null);
    L6:
        if (VerticalDragHandle$lambda$3(r9) == false) goto L8;
        r13 = r7.m2640getPressedSizeMYxV2XQ();
        goto L9
    L8:
        r13 = r7.m2641getSizeMYxV2XQ();
        goto L9
    }

    public static final void VerticalDragHandle(Modifier r17, DragHandleSizes r18, DragHandleColors r19, DragHandleShapes r20, MutableInteractionSource r21, Composer r22, final int r23, final int r24) {
        Composer r1 = r22.startRestartGroup(1693656835);
        int r2 = r24 & 1;
        if (r2 == 0) goto L6;
        int r5 = r23 | 6;
        Modifier r4 = r17;
    L14:
        if ((r23 & 48) == 0) goto L16;
        DragHandleSizes r7 = r18;
    L25:
        if ((r23 & 384) == 0) goto L27;
        final DragHandleColors r9 = r19;
    L36:
        if ((r23 & 3072) == 0) goto L38;
        final DragHandleShapes r11 = r20;
    L46:
        int r13 = r24 & 16;
        if (r13 == 0) goto L50;
        r5 = r5 | 24576;
    L56:
        MutableInteractionSource r14 = r21;
    L57:
        boolean r16 = true;
        if ((r5 & 9363) == 9362) goto L60;
        boolean r10 = true;
    L62:
        if (r1.shouldExecute(r10, r5 & 1) == false) goto L153;
        r1.startDefaults();
        if ((r23 & 1) != 0) goto L66;
    L78:
        if (r2 == 0) goto L80;
        Modifier r3 = Modifier.Companion;
    L82:
        if ((r24 & 2) == 0) goto L84;
        final DragHandleSizes r6 = VerticalDragHandleDefaults.INSTANCE.sizes();
        r5 = r5 & (-113);
    L86:
        if ((r24 & 4) == 0) goto L89;
        r5 = r5 & (-897);
        r9 = VerticalDragHandleDefaults.INSTANCE.colors(r1, 6);
    L89:
        if ((r24 & 8) == 0) goto L91;
        r5 = r5 & (-7169);
        r11 = VerticalDragHandleDefaults.INSTANCE.shapes(r1, 6);
    L91:
        if (r13 == 0) goto L93;
        r14 = null;
    L93:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventStart(1693656835, r5, -1, "androidx.compose.material3.VerticalDragHandle (DragHandle.kt:78)");
    L96:
        if (r14 != null) goto L101;
        r1.startReplaceGroup(-1544610024);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L100;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r0);
    L100:
        MutableInteractionSource r8 = (MutableInteractionSource) r0;
        r1.endReplaceGroup();
    L102:
        final State<Boolean> r12 = DragInteractionKt.collectIsDraggedAsState(r8, r1, 0);
        Object r15 = r1.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r15 != r110.getEmpty()) goto L105;
        r15 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r1.updateRememberedValue(r15);
    L105:
        final MutableState r111 = (MutableState) r15;
        Modifier r25 = HoverableKt.hoverable$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(r3), r8, false, 2, null);
        Object r112 = r1.rememberedValue();
        if (r112 != r110.getEmpty()) goto L108;
        r112 = new n9(r111);
        r1.updateRememberedValue(r112);
    L108:
        Function0 r113 = (Function0) r112;
        Object r114 = r1.rememberedValue();
        if (r114 != r110.getEmpty()) goto L111;
        r114 = new o9(r111);
        r1.updateRememberedValue(r114);
    L111:
        Modifier r26 = pressable(r25, r8, r113, (Function0) r114);
        boolean r27 = r1.changed(r12);
        if (((r5 & 7168) ^ 3072) <= 2048) goto L116;
        if (r1.changed(r11) == false) goto L116;
    L117:
        boolean r115 = true;
    L119:
        boolean r28 = r27 | r115;
        Object r116 = r1.rememberedValue();
        if (r28 == false) goto L122;
    L123:
        r116 = new p9(r11, r12, r111);
        r1.updateRememberedValue(r116);
    L124:
        Modifier r29 = GraphicsLayerModifierKt.graphicsLayer(r26, (Function1) r116);
        boolean r30 = r1.changed(r12);
        if (((r5 & 112) ^ 48) <= 32) goto L129;
        if (r1.changed(r6) == false) goto L129;
    L130:
        boolean r117 = true;
    L132:
        boolean r31 = r30 | r117;
        Object r118 = r1.rememberedValue();
        if (r31 == false) goto L135;
    L136:
        r118 = new q9(r6, r12, r111);
        r1.updateRememberedValue(r118);
    L137:
        Modifier r32 = LayoutModifierKt.layout(r29, (Function3) r118);
        boolean r33 = r1.changed(r12);
        if (((r5 & 896) ^ 384) <= 256) goto L142;
        if (r1.changed(r9) == false) goto L142;
    L145:
        boolean r34 = r33 | r16;
        Object r35 = r1.rememberedValue();
        if (r34 == false) goto L148;
    L149:
        r35 = new r9(r9, r12, r111);
        r1.updateRememberedValue(r35);
    L150:
        BoxKt.Box(IndicationKt.indication(DrawModifierKt.drawBehind(r32, (Function1) r35), r8, RippleKt.m3031rippleH2RKhps$default(false, MenuKt.ClosedAlphaTarget, 0, 7, null)), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L154;
        ComposerKt.traceEventEnd();
    L154:
        final DragHandleColors r36 = r9;
        final MutableInteractionSource r37 = r14;
        ScopeUpdateScope r38 = r1.endRestartGroup();
        if (r38 == null) goto L158;
        final Modifier r39 = r3;
        final DragHandleSizes r40 = r6;
        final DragHandleShapes r41 = r11;
        r38.updateScope(new s9(r39, r40, r36, r41, r37, r23, r24));
        return;
    L158:
        return;
    L148:
        if (r35 != r110.getEmpty()) goto L150;
    L142:
        if ((r5 & 384) == 256) goto L145;
        r16 = false;
        goto L145
    L135:
        if (r118 != r110.getEmpty()) goto L137;
    L129:
        if ((r5 & 48) == 32) goto L130;
        r117 = false;
        goto L132
    L122:
        if (r116 != r110.getEmpty()) goto L124;
    L116:
        if ((r5 & 3072) == 2048) goto L117;
        r115 = false;
        goto L119
    L101:
        r1.startReplaceGroup(-188374113);
        r1.endReplaceGroup();
        r8 = r14;
        goto L102
    L84:
        r6 = r7;
        goto L86
    L80:
        r3 = r4;
        goto L82
    L66:
        if (r1.getDefaultsInvalid() == true) goto L78;
        r1.skipToGroupEnd();
        if ((r24 & 2) == 0) goto L72;
        r5 = r5 & (-113);
    L72:
        if ((r24 & 4) == 0) goto L75;
        r5 = r5 & (-897);
    L75:
        if ((r24 & 8) == 0) goto L77;
        r5 = r5 & (-7169);
    L77:
        r3 = r4;
        r6 = r7;
        goto L93
    L153:
        r1.skipToGroupEnd();
        r3 = r4;
        r6 = r7;
        goto L154
    L60:
        r10 = false;
        goto L62
    L50:
        if ((r23 & 24576) != 0) goto L56;
        r14 = r21;
        if (r1.changed(r14) == false) goto L54;
        int r119 = 16384;
    L55:
        r5 = r5 | r119;
        goto L57
    L54:
        r119 = 8192;
        goto L55
    L38:
        if ((r24 & 8) != 0) goto L42;
        r11 = r20;
        if (r1.changed(r11) == false) goto L43;
        int r120 = 2048;
    L44:
        r5 = r5 | r120;
    L43:
        r120 = 1024;
        goto L44
    L42:
        r11 = r20;
        goto L43
    L27:
        if ((r24 & 4) != 0) goto L31;
        r9 = r19;
        if (r1.changed(r9) == false) goto L32;
        int r121 = 256;
    L33:
        r5 = r5 | r121;
    L32:
        r121 = 128;
        goto L33
    L31:
        r9 = r19;
        goto L32
    L16:
        if ((r24 & 2) != 0) goto L20;
        r7 = r18;
        if (r1.changed(r7) == false) goto L21;
        int r42 = 32;
    L22:
        r5 = r5 | r42;
    L21:
        r42 = 16;
        goto L22
    L20:
        r7 = r18;
        goto L21
    L6:
        if ((r23 & 6) != 0) goto L12;
        r4 = r17;
        if (r1.changed(r4) == false) goto L10;
        int r43 = 4;
    L11:
        r5 = r43 | r23;
        goto L14
    L10:
        r43 = 2;
        goto L11
    L12:
        r4 = r17;
        r5 = r23;
        goto L14
    }
}
