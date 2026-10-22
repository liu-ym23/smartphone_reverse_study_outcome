package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002\u001a;\u0010\u0012\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002\u001a\u001b\u0010%\u001a\u00020&*\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0002¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {OutlinedTextFieldKt.BorderId, "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "fillArea", "", "strokeWidthPx", "", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "roundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "strokeWidth", "createInsetRoundedRect", "widthPx", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BorderKt {
    public static /* synthetic */ Unit a(ContentDrawScope r0) {
        return drawContentWithoutBorder$lambda$0(r0);
    }

    public static /* synthetic */ Unit b(Brush r0, long r1, long r3, DrawStyle r5, ContentDrawScope r6) {
        return drawRectBorder_NsqcLGU$lambda$1(r0, r1, r3, r5, r6);
    }

    public static final /* synthetic */ DrawResult access$drawContentWithoutBorder(CacheDrawScope r0) {
        return drawContentWithoutBorder(r0);
    }

    private static final DrawResult drawContentWithoutBorder(CacheDrawScope r1) {
        return r1.onDrawWithContent(new w());
    }

    private static final Unit drawContentWithoutBorder$lambda$0(ContentDrawScope r0) {
        r0.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$shrink-Kibmq7A, reason: not valid java name */
    public static final /* synthetic */ long m352access$shrinkKibmq7A(long r0, float r2) {
        return m357shrinkKibmq7A(r0, r2);
    }

    private static final RoundRect createInsetRoundedRect(float r15, RoundRect r16) {
        float r3 = r16.getWidth() - r15;
        float r4 = r16.getHeight() - r15;
        long r5 = m357shrinkKibmq7A(r16.getTopLeftCornerRadius-kKHJgLs(), r15);
        long r7 = m357shrinkKibmq7A(r16.getTopRightCornerRadius-kKHJgLs(), r15);
        long r11 = m357shrinkKibmq7A(r16.getBottomLeftCornerRadius-kKHJgLs(), r15);
        return new RoundRect(r15, r15, r3, r4, r5, r7, m357shrinkKibmq7A(r16.getBottomRightCornerRadius-kKHJgLs(), r15), r11, null);
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    private static final long m357shrinkKibmq7A(long r5, float r7) {
        float r1 = Math.max(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat((int) (r5 >> 32)) - r7);
        float r6 = Math.max(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat((int) (r5 & 4294967295L)) - r7);
        return CornerRadius.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (Float.floatToRawIntBits(r6) & 4294967295L));
    }

    public static final Modifier border(Modifier r1, BorderStroke r2, Shape r3) {
        return m355borderziNgDLE(r1, r2.m368getWidthD9Ej5fM(), r2.getBrush(), r3);
    }

    public static final /* synthetic */ Path access$createRoundRectPath(Path r0, RoundRect r1, float r2, boolean r3) {
        return createRoundRectPath(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m353borderxT4_qwU(Modifier r2, float r3, long r4, Shape r6) {
        return m355borderziNgDLE(r2, r3, new SolidColor(r4, null), r6);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m355borderziNgDLE(Modifier r2, float r3, Brush r4, Shape r5) {
        return r2.then(new BorderModifierNodeElement(r3, r4, r5, null));
    }

    private static final Path createRoundRectPath(Path r2, RoundRect r3, float r4, boolean r5) {
        r2.reset();
        Path.-CC.addRoundRect$default(r2, r3, null, 2, null);
        if (r5 == true) goto L5;
        Path r6 = AndroidPath_androidKt.Path();
        Path.-CC.addRoundRect$default(r6, createInsetRoundedRect(r4, r3), null, 2, null);
        r2.op-N5in7k0(r2, r6, PathOperation.Companion.getDifference-b3I0S0c());
    L5:
        return r2;
    }

    public static /* synthetic */ Modifier border$default(Modifier r0, BorderStroke r1, Shape r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = RectangleShapeKt.getRectangleShape();
    L6:
        return border(r0, r1, r2);
    }

    private static final Unit drawRectBorder_NsqcLGU$lambda$1(Brush r12, long r13, long r15, DrawStyle r17, ContentDrawScope r18) {
        r18.drawContent();
        DrawScope.-CC.drawRect-AsUm42w$default(r18, r12, r13, r15, MenuKt.ClosedAlphaTarget, r17, null, 0, 104, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final /* synthetic */ DrawResult m351access$drawRectBorderNsqcLGU(CacheDrawScope r0, Brush r1, long r2, long r4, boolean r6, float r7) {
        return m356drawRectBorderNsqcLGU(r0, r1, r2, r4, r6, r7);
    }

    /* JADX INFO: renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m354borderxT4_qwU$default(Modifier r0, float r1, long r2, Shape r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = RectangleShapeKt.getRectangleShape();
    L6:
        return m353borderxT4_qwU(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    private static final DrawResult m356drawRectBorderNsqcLGU(CacheDrawScope r16, final Brush r17, long r18, long r20, boolean r22, float r23) {
        if (r22 == false) goto L4;
        final long r4 = Offset.Companion.getZero-F1C5BW0();
    L5:
        if (r22 == false) goto L7;
        final long r6 = r16.getSize-NH-jbRc();
    L8:
        if (r22 == false) goto L10;
        final DrawStyle r8 = Fill.INSTANCE;
    L12:
        return r16.onDrawWithContent(new x(r17, r4, r6, r8));
    L10:
        r8 = new Stroke(r23, MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null);
        goto L12
    L7:
        r6 = r20;
        goto L8
    L4:
        r4 = r18;
        goto L5
    }
}
