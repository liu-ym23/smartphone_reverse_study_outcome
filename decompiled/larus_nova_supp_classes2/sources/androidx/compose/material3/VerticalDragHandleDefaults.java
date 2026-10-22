package androidx.compose.material3;

import androidx.compose.material3.tokens.DragHandleTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J-\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJ1\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J+\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u00020\u000e*\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/material3/VerticalDragHandleDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DragHandleColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DragHandleColors;", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DragHandleShapes;", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "draggedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DragHandleShapes;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "sizes-L9TjZb0", "(JJJ)Landroidx/compose/material3/DragHandleSizes;", "Landroidx/compose/material3/ColorScheme;", "getColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/DragHandleColors;", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/DragHandleShapes;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VerticalDragHandleDefaults {
    public static final int $stable = 0;
    public static final VerticalDragHandleDefaults INSTANCE = null;
    private static final DragHandleSizes sizes = null;

    private VerticalDragHandleDefaults() {
    }

    static {
        INSTANCE = new VerticalDragHandleDefaults();
        DragHandleTokens r1 = DragHandleTokens.INSTANCE;
        sizes = new DragHandleSizes(DpKt.DpSize-YgX7TsA(r1.getWidth-D9Ej5fM(), r1.getHeight-D9Ej5fM()), DpKt.DpSize-YgX7TsA(r1.getPressedWidth-D9Ej5fM(), r1.getPressedHeight-D9Ej5fM()), DpKt.DpSize-YgX7TsA(r1.getDraggedWidth-D9Ej5fM(), r1.getDraggedHeight-D9Ej5fM()), null);
    }

    public final DragHandleSizes sizes() {
        return sizes;
    }

    private final DragHandleColors getColors(ColorScheme r10) {
        DragHandleColors r0 = r10.getDefaultVerticalDragHandleColorsCached$material3();
        if (r0 != null) goto L6;
        DragHandleTokens r1 = DragHandleTokens.INSTANCE;
        DragHandleColors r2 = new DragHandleColors(ColorSchemeKt.fromToken(r10, r1.getColor()), ColorSchemeKt.fromToken(r10, r1.getPressedColor()), ColorSchemeKt.fromToken(r10, r1.getDraggedColor()), null);
        r10.setDefaultVerticalDragHandleColorsCached$material3(r2);
        return r2;
    L6:
        return r0;
    }

    private final DragHandleShapes getShapes(Shapes r5) {
        DragHandleShapes r0 = r5.getDefaultVerticalDragHandleShapesCached$material3();
        if (r0 != null) goto L6;
        DragHandleTokens r1 = DragHandleTokens.INSTANCE;
        DragHandleShapes r2 = new DragHandleShapes(ShapesKt.fromToken(r5, r1.getShape()), ShapesKt.fromToken(r5, r1.getPressedShape()), ShapesKt.fromToken(r5, r1.getDraggedShape()));
        r5.setDefaultVerticalDragHandleShapesCached$material3(r2);
        return r2;
    L6:
        return r0;
    }

    public final DragHandleColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1465068453, r5, -1, "androidx.compose.material3.VerticalDragHandleDefaults.colors (DragHandle.kt:215)");
    L5:
        DragHandleColors r6 = getColors(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final DragHandleShapes shapes(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1385335639, r5, -1, "androidx.compose.material3.VerticalDragHandleDefaults.shapes (DragHandle.kt:246)");
    L5:
        DragHandleShapes r6 = getShapes(MaterialTheme.INSTANCE.getShapes(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: sizes-L9TjZb0, reason: not valid java name */
    public final DragHandleSizes m3604sizesL9TjZb0(long r13, long r15, long r17) {
        DragHandleSizes r0 = sizes;
        boolean r1 = true;
        if (r13 == 9205357640488583168L) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r6 = r13;
    L10:
        if (r15 == 9205357640488583168L) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        long r8 = r15;
    L17:
        if (r17 != 9205357640488583168L) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        long r10 = r17;
    L24:
        return new DragHandleSizes(r6, r8, r10, null);
    L22:
        r10 = r0.m2639getDraggedSizeMYxV2XQ();
        goto L24
    L15:
        r8 = r0.m2640getPressedSizeMYxV2XQ();
        goto L17
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = r0.m2641getSizeMYxV2XQ();
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: sizes-L9TjZb0$default, reason: not valid java name */
    public static /* synthetic */ DragHandleSizes m3602sizesL9TjZb0$default(VerticalDragHandleDefaults r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L8:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L12;
        r12 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L12:
        return r7.m3604sizesL9TjZb0(r1, r3, r12);
    }

    /* JADX INFO: renamed from: colors-RGew2ao, reason: not valid java name */
    public final DragHandleColors m3603colorsRGew2ao(long r14, long r16, long r18, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-2062501640, r21, -1, "androidx.compose.material3.VerticalDragHandleDefaults.colors (DragHandle.kt:234)");
    L17:
        DragHandleColors r6 = getColors(MaterialTheme.INSTANCE.getColorScheme(r20, 6));
        boolean r8 = false;
        if (r0 == 16) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L25;
        r0 = r6.m2636getColor0d7_KjU();
    L25:
        if (r2 == 16) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == true) goto L32;
        r2 = r6.m2638getPressedColor0d7_KjU();
    L32:
        if (r4 == 16) goto L34;
        r8 = true;
    L34:
        if (r8 == true) goto L37;
        r4 = r6.m2637getDraggedColor0d7_KjU();
    L37:
        DragHandleColors r9 = new DragHandleColors(r0, r2, r4, null);
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventEnd();
    L40:
        return r9;
    L27:
        r13 = false;
        goto L28
    L20:
        r12 = false;
        goto L21
    L13:
        r4 = r18;
        goto L15
    L9:
        r2 = r16;
        goto L11
    L5:
        r0 = r14;
        goto L7
    }

    public final DragHandleShapes shapes(Shape r3, Shape r4, Shape r5, Composer r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(650848370, r7, -1, "androidx.compose.material3.VerticalDragHandleDefaults.shapes (DragHandle.kt:265)");
    L14:
        DragHandleShapes r9 = getShapes(MaterialTheme.INSTANCE.getShapes(r6, 6));
        if (r3 != null) goto L17;
        r3 = r9.getShape();
    L17:
        if (r4 != null) goto L19;
        r4 = r9.getPressedShape();
    L19:
        if (r5 != null) goto L21;
        r5 = r9.getDraggedShape();
    L21:
        DragHandleShapes r10 = new DragHandleShapes(r3, r4, r5);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r10;
    }
}
