package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J \u0010\u0018\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J \u0010\u001a\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J \u0010\u001c\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002J3\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0002¢\u0006\u0004\b$\u0010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/foundation/GlowOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Landroidx/compose/foundation/layout/PaddingValues;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawLeftGlow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "left", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawTopGlow", "top", "drawRightGlow", "right", "drawBottomGlow", "bottom", "drawWithRotationAndOffset", "rotationDegrees", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "edgeEffect", "drawWithRotationAndOffset-ubNVwUQ", "(FJLandroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GlowOverscrollNode extends DelegatingNode implements DrawModifierNode {
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final PaddingValues glowDrawPadding;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public void draw(ContentDrawScope r7) {
        this.overscrollEffect.m322updateSizeuvyYCjk$foundation_release(r7.getSize-NH-jbRc());
        if (Size.isEmpty-impl(r7.getSize-NH-jbRc()) == false) goto L6;
        r7.drawContent();
        return;
    L6:
        r7.drawContent();
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        Canvas r0 = AndroidCanvas_androidKt.getNativeCanvas(r7.getDrawContext().getCanvas());
        EdgeEffectWrapper r1 = this.edgeEffectWrapper;
        boolean r3 = false;
        if (r1.isLeftAnimating() == false) goto L9;
        boolean r2 = drawLeftGlow(r7, r1.getOrCreateLeftEffect(), r0);
    L11:
        if (r1.isTopAnimating() == false) goto L19;
        if (drawTopGlow(r7, r1.getOrCreateTopEffect(), r0) == true) goto L17;
        if (r2 == true) goto L17;
        r2 = false;
    L17:
        r2 = true;
    L19:
        if (r1.isRightAnimating() == false) goto L27;
        if (drawRightGlow(r7, r1.getOrCreateRightEffect(), r0) == true) goto L25;
        if (r2 == true) goto L25;
        r2 = false;
    L25:
        r2 = true;
    L27:
        if (r1.isBottomAnimating() == true) goto L29;
    L33:
        if (r2 == false) goto L36;
        this.overscrollEffect.invalidateOverscroll$foundation_release();
        return;
    L36:
        return;
    L29:
        if (drawBottomGlow(r7, r1.getOrCreateBottomEffect(), r0) == true) goto L31;
        if (r2 == true) goto L31;
    L32:
        r2 = r3;
    L31:
        r3 = true;
        goto L32
    L9:
        r2 = false;
        goto L11
    }

    private final boolean drawBottomGlow(DrawScope r9, EdgeEffect r10, Canvas r11) {
        float r0 = r9.toPx-0680j_4(this.glowDrawPadding.mo898calculateBottomPaddingD9Ej5fM());
        float r1 = -Float.intBitsToFloat((int) (r9.getSize-NH-jbRc() >> 32));
        float r12 = (-Float.intBitsToFloat((int) (r9.getSize-NH-jbRc() & 4294967295L))) + r0;
        return m405drawWithRotationAndOffsetubNVwUQ(180.0f, Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r12)) & 4294967295L)), r10, r11);
    }

    private final boolean drawLeftGlow(DrawScope r9, EdgeEffect r10, Canvas r11) {
        float r0 = -Float.intBitsToFloat((int) (r9.getSize-NH-jbRc() & 4294967295L));
        float r12 = r9.toPx-0680j_4(this.glowDrawPadding.mo899calculateLeftPaddingu2uoSUM(r9.getLayoutDirection()));
        return m405drawWithRotationAndOffsetubNVwUQ(270.0f, Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(r12)))), r10, r11);
    }

    private final boolean drawRightGlow(DrawScope r9, EdgeEffect r10, Canvas r11) {
        float r0 = (-MathKt.roundToInt(Float.intBitsToFloat((int) (r9.getSize-NH-jbRc() >> 32)))) + r9.toPx-0680j_4(this.glowDrawPadding.mo900calculateRightPaddingu2uoSUM(r9.getLayoutDirection()));
        long r3 = Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget);
        return m405drawWithRotationAndOffsetubNVwUQ(90.0f, Offset.constructor-impl((((long) Float.floatToRawIntBits(r0)) & 4294967295L) | (r3 << 32)), r10, r11);
    }

    private final boolean drawTopGlow(DrawScope r9, EdgeEffect r10, Canvas r11) {
        float r12 = r9.toPx-0680j_4(this.glowDrawPadding.mo901calculateTopPaddingD9Ej5fM());
        return m405drawWithRotationAndOffsetubNVwUQ(MenuKt.ClosedAlphaTarget, Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r12)) & 4294967295L)), r10, r11);
    }

    public GlowOverscrollNode(DelegatableNode r1, AndroidEdgeEffectOverscrollEffect r2, EdgeEffectWrapper r3, PaddingValues r4) {
        this.overscrollEffect = r2;
        this.edgeEffectWrapper = r3;
        this.glowDrawPadding = r4;
        delegate(r1);
    }

    /* JADX INFO: renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    private final boolean m405drawWithRotationAndOffsetubNVwUQ(float r4, long r5, EdgeEffect r7, Canvas r8) {
        int r0 = r8.save();
        r8.rotate(r4);
        r8.translate(Float.intBitsToFloat((int) (r5 >> 32)), Float.intBitsToFloat((int) (r5 & 4294967295L)));
        boolean r6 = r7.draw(r8);
        r8.restoreToCount(r0);
        return r6;
    }
}
