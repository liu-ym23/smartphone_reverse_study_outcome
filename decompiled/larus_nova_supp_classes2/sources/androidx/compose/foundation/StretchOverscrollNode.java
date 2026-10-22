package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\u001c\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\u001c\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J$\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Landroidx/compose/foundation/StretchOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "shouldDrawVerticalStretch", "", "shouldDrawHorizontalStretch", "drawLeftStretch", "left", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawTopStretch", "top", "drawRightStretch", "right", "drawBottomStretch", "bottom", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StretchOverscrollNode extends DelegatingNode implements DrawModifierNode {
    private RenderNode _renderNode;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    private final RenderNode getRenderNode() {
        RenderNode r0 = this._renderNode;
        if (r0 != null) goto L6;
        RenderNode r1 = new RenderNode("AndroidEdgeEffectOverscrollEffect");
        this._renderNode = r1;
        return r1;
    L6:
        return r0;
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper r0 = this.edgeEffectWrapper;
        if (r0.isLeftAnimating() == false) goto L5;
    L12:
        return true;
    L5:
        if (r0.isLeftNegationStretched() == true) goto L12;
        if (r0.isRightAnimating() == true) goto L12;
        if (r0.isRightNegationStretched() == true) goto L12;
        return false;
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper r0 = this.edgeEffectWrapper;
        if (r0.isTopAnimating() == false) goto L5;
    L12:
        return true;
    L5:
        if (r0.isTopNegationStretched() == true) goto L12;
        if (r0.isBottomAnimating() == true) goto L12;
        if (r0.isBottomNegationStretched() == true) goto L12;
        return false;
    }

    public void draw(ContentDrawScope r18) {
        this.overscrollEffect.m322updateSizeuvyYCjk$foundation_release(r18.getSize-NH-jbRc());
        Canvas r0 = AndroidCanvas_androidKt.getNativeCanvas(r18.getDrawContext().getCanvas());
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        if (Size.isEmpty-impl(r18.getSize-NH-jbRc()) == false) goto L7;
        r18.drawContent();
        return;
    L7:
        if (r0.isHardwareAccelerated() == true) goto L10;
        this.edgeEffectWrapper.finishAll();
        r18.drawContent();
        return;
    L10:
        float r3 = r18.toPx-0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        EdgeEffectWrapper r4 = this.edgeEffectWrapper;
        boolean r5 = shouldDrawVerticalStretch();
        boolean r6 = shouldDrawHorizontalStretch();
        if (r5 == false) goto L14;
        if (r6 == false) goto L14;
        getRenderNode().setPosition(0, 0, r0.getWidth(), r0.getHeight());
    L18:
        RecordingCanvas r8 = getRenderNode().beginRecording();
        if (r4.isLeftNegationStretched() == false) goto L22;
        EdgeEffect r9 = r4.getOrCreateLeftEffectNegation();
        drawRightStretch(r9, r8);
        r9.finish();
    L22:
        if (r4.isLeftAnimating() == false) goto L26;
        EdgeEffect r10 = r4.getOrCreateLeftEffect();
        boolean r13 = drawLeftStretch(r10, r8);
        if (r4.isLeftStretched() == false) goto L28;
        float r14 = Float.intBitsToFloat((int) (this.overscrollEffect.m321displacementF1C5BW0$foundation_release() & 4294967295L));
        EdgeEffectCompat r15 = EdgeEffectCompat.INSTANCE;
        r15.onPullDistanceCompat(r4.getOrCreateLeftEffectNegation(), r15.getDistanceCompat(r10), 1 - r14);
    L28:
        if (r4.isTopNegationStretched() == false) goto L31;
        EdgeEffect r7 = r4.getOrCreateTopEffectNegation();
        drawBottomStretch(r7, r8);
        r7.finish();
    L31:
        if (r4.isTopAnimating() == false) goto L42;
        EdgeEffect r11 = r4.getOrCreateTopEffect();
        if (drawTopStretch(r11, r8) == true) goto L37;
        if (r13 == true) goto L37;
        r13 = false;
    L39:
        if (r4.isTopStretched() == false) goto L42;
        float r12 = Float.intBitsToFloat((int) (this.overscrollEffect.m321displacementF1C5BW0$foundation_release() >> 32));
        EdgeEffectCompat r16 = EdgeEffectCompat.INSTANCE;
        r16.onPullDistanceCompat(r4.getOrCreateTopEffectNegation(), r16.getDistanceCompat(r11), r12);
    L37:
        r13 = true;
    L42:
        if (r4.isRightNegationStretched() == false) goto L45;
        EdgeEffect r17 = r4.getOrCreateRightEffectNegation();
        drawLeftStretch(r17, r8);
        r17.finish();
    L45:
        if (r4.isRightAnimating() == false) goto L56;
        EdgeEffect r19 = r4.getOrCreateRightEffect();
        if (drawRightStretch(r19, r8) == true) goto L51;
        if (r13 == true) goto L51;
        r13 = false;
    L53:
        if (r4.isRightStretched() == false) goto L56;
        float r110 = Float.intBitsToFloat((int) (this.overscrollEffect.m321displacementF1C5BW0$foundation_release() & 4294967295L));
        EdgeEffectCompat r111 = EdgeEffectCompat.INSTANCE;
        r111.onPullDistanceCompat(r4.getOrCreateRightEffectNegation(), r111.getDistanceCompat(r19), r110);
    L51:
        r13 = true;
    L56:
        if (r4.isBottomNegationStretched() == false) goto L59;
        EdgeEffect r20 = r4.getOrCreateBottomEffectNegation();
        drawTopStretch(r20, r8);
        r20.finish();
    L59:
        if (r4.isBottomAnimating() == false) goto L70;
        EdgeEffect r21 = r4.getOrCreateBottomEffect();
        if (drawBottomStretch(r21, r8) == true) goto L65;
        if (r13 == true) goto L65;
        boolean r112 = false;
    L67:
        if (r4.isBottomStretched() == false) goto L69;
        float r22 = Float.intBitsToFloat((int) (this.overscrollEffect.m321displacementF1C5BW0$foundation_release() >> 32));
        EdgeEffectCompat r113 = EdgeEffectCompat.INSTANCE;
        r113.onPullDistanceCompat(r4.getOrCreateBottomEffectNegation(), r113.getDistanceCompat(r21), 1 - r22);
    L69:
        r13 = r112;
    L65:
        r112 = true;
    L70:
        if (r13 == false) goto L73;
        this.overscrollEffect.invalidateOverscroll$foundation_release();
    L73:
        if (r6 == false) goto L75;
        float r23 = MenuKt.ClosedAlphaTarget;
    L76:
        if (r5 == false) goto L78;
        r3 = MenuKt.ClosedAlphaTarget;
    L78:
        LayoutDirection r24 = r18.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas r25 = AndroidCanvas_androidKt.Canvas(r8);
        long r26 = r18.getSize-NH-jbRc();
        Density r27 = r18.getDrawContext().getDensity();
        LayoutDirection r114 = r18.getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas r115 = r18.getDrawContext().getCanvas();
        long r116 = r18.getDrawContext().getSize-NH-jbRc();
        GraphicsLayer r117 = r18.getDrawContext().getGraphicsLayer();
        DrawContext r118 = r18.getDrawContext();
        r118.setDensity(r18);
        r118.setLayoutDirection(r24);
        r118.setCanvas(r25);
        r118.setSize-uvyYCjk(r26);
        r118.setGraphicsLayer(null);
        r25.save();
        r18.getDrawContext().getTransform().translate(r23, r3);     // Catch: Throwable -> L88
        r18.drawContent();     // Catch: Throwable -> L84
        float r28 = -r23;
        float r29 = -r3;
        r18.getDrawContext().getTransform().translate(r28, r29);     // Catch: Throwable -> L88
        r25.restore();
        DrawContext r2 = r18.getDrawContext();
        r2.setDensity(r27);
        r2.setLayoutDirection(r114);
        r2.setCanvas(r115);
        r2.setSize-uvyYCjk(r116);
        r2.setGraphicsLayer(r117);
        getRenderNode().endRecording();
        int r30 = r0.save();
        r0.translate(r28, r29);
        r0.drawRenderNode(getRenderNode());
        r0.restoreToCount(r30);
        return;
    L84:
        th = move-exception;
        r18.getDrawContext().getTransform().translate(-r23, -r3);     // Catch: Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        r25.restore();
        DrawContext r31 = r18.getDrawContext();
        r31.setDensity(r27);
        r31.setLayoutDirection(r114);
        r31.setCanvas(r115);
        r31.setSize-uvyYCjk(r116);
        r31.setGraphicsLayer(r117);
        throw th;
    L75:
        r23 = r3;
        goto L76
    L26:
        r13 = false;
    L14:
        if (r5 == false) goto L16;
        getRenderNode().setPosition(0, 0, r0.getWidth() + (MathKt.roundToInt(r3) * 2), r0.getHeight());
        goto L18
    L16:
        if (r6 == false) goto L91;
        getRenderNode().setPosition(0, 0, r0.getWidth(), r0.getHeight() + (MathKt.roundToInt(r3) * 2));
        goto L18
    L91:
        r18.drawContent();
    }

    private final boolean drawBottomStretch(EdgeEffect r2, Canvas r3) {
        return drawWithRotation(180.0f, r2, r3);
    }

    private final boolean drawLeftStretch(EdgeEffect r2, Canvas r3) {
        return drawWithRotation(270.0f, r2, r3);
    }

    private final boolean drawRightStretch(EdgeEffect r2, Canvas r3) {
        return drawWithRotation(90.0f, r2, r3);
    }

    private final boolean drawTopStretch(EdgeEffect r2, Canvas r3) {
        return drawWithRotation(MenuKt.ClosedAlphaTarget, r2, r3);
    }

    public StretchOverscrollNode(DelegatableNode r1, AndroidEdgeEffectOverscrollEffect r2, EdgeEffectWrapper r3) {
        this.overscrollEffect = r2;
        this.edgeEffectWrapper = r3;
        delegate(r1);
    }

    private final boolean drawWithRotation(float r2, EdgeEffect r3, Canvas r4) {
        if (r2 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        int r1 = r4.save();
        r4.rotate(r2);
        boolean r5 = r3.draw(r4);
        r4.restoreToCount(r1);
        return r5;
    L8:
        return r3.draw(r4);
    L5:
        r0 = false;
        goto L6
    }
}
