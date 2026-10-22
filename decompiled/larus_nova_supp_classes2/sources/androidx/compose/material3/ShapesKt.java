package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u0018\u0010\r\u001a\u00020\u000b*\u00020\u000e8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"top", "Landroidx/compose/foundation/shape/CornerBasedShape;", "bottomSize", "Landroidx/compose/foundation/shape/CornerSize;", "bottom", "topSize", "start", "endSize", "end", "startSize", "fromToken", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/Shapes;", "value", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShapesKt {
    private static final ProvidableCompositionLocal<Shapes> LocalShapes = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ShapeKeyTokens.values().length];
            r0[ShapeKeyTokens.CornerExtraLarge.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r0[ShapeKeyTokens.CornerExtraLargeIncreased.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r0[ShapeKeyTokens.CornerExtraExtraLarge.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[ShapeKeyTokens.CornerExtraLargeTop.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[ShapeKeyTokens.CornerExtraSmall.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[ShapeKeyTokens.CornerExtraSmallTop.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r0[ShapeKeyTokens.CornerFull.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r0[ShapeKeyTokens.CornerLarge.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r0[ShapeKeyTokens.CornerLargeIncreased.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[ShapeKeyTokens.CornerLargeEnd.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r0[ShapeKeyTokens.CornerLargeTop.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r0[ShapeKeyTokens.CornerMedium.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[ShapeKeyTokens.CornerNone.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r0[ShapeKeyTokens.CornerSmall.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r0[ShapeKeyTokens.CornerLargeStart.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ Shapes a() {
        return LocalShapes$lambda$0();
    }

    static {
        LocalShapes = CompositionLocalKt.staticCompositionLocalOf(new tn());
    }

    private static final Shapes LocalShapes$lambda$0() {
        return new Shapes(null, null, null, null, null, 31, null);
    }

    public static final ProvidableCompositionLocal<Shapes> getLocalShapes() {
        return LocalShapes;
    }

    public static final CornerBasedShape bottom(CornerBasedShape r7, CornerSize r8) {
        return CornerBasedShape.copy$default(r7, r8, r8, null, null, 12, null);
    }

    public static final CornerBasedShape end(CornerBasedShape r7, CornerSize r8) {
        return CornerBasedShape.copy$default(r7, r8, null, null, r8, 6, null);
    }

    public static final Shape fromToken(Shapes r2, ShapeKeyTokens r3) {
        switch(WhenMappings.$EnumSwitchMapping$0[r3.ordinal()]) {
            case 1: goto L21;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L23;
            case 15: goto L22;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L22:
        return start$default(r2.getLarge(), null, 1, null);
    L23:
        return r2.getSmall();
    L24:
        return RectangleShapeKt.getRectangleShape();
    L25:
        return r2.getMedium();
    L26:
        return top$default(r2.getLarge(), null, 1, null);
    L27:
        return end$default(r2.getLarge(), null, 1, null);
    L28:
        return r2.getLargeIncreased$material3();
    L29:
        return r2.getLarge();
    L30:
        return RoundedCornerShapeKt.getCircleShape();
    L31:
        return top$default(r2.getExtraSmall(), null, 1, null);
    L32:
        return r2.getExtraSmall();
    L33:
        return top$default(r2.getExtraLarge(), null, 1, null);
    L34:
        return r2.getExtraExtraLarge$material3();
    L35:
        return r2.getExtraLargeIncreased$material3();
    L21:
        return r2.getExtraLarge();
    }

    public static final CornerBasedShape start(CornerBasedShape r7, CornerSize r8) {
        return CornerBasedShape.copy$default(r7, null, r8, r8, null, 9, null);
    }

    public static final CornerBasedShape top(CornerBasedShape r7, CornerSize r8) {
        return CornerBasedShape.copy$default(r7, null, null, r8, r8, 3, null);
    }

    public static final Shape getValue(ShapeKeyTokens r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1629172543, r5, -1, "androidx.compose.material3.<get-value> (Shapes.kt:358)");
    L5:
        Shape r6 = fromToken(MaterialTheme.INSTANCE.getShapes(r4, 6), r3);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public static /* synthetic */ CornerBasedShape bottom$default(CornerBasedShape r0, CornerSize r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
    L6:
        return bottom(r0, r1);
    }

    public static /* synthetic */ CornerBasedShape end$default(CornerBasedShape r0, CornerSize r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
    L6:
        return end(r0, r1);
    }

    public static /* synthetic */ CornerBasedShape start$default(CornerBasedShape r0, CornerSize r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
    L6:
        return start(r0, r1);
    }

    public static /* synthetic */ CornerBasedShape top$default(CornerBasedShape r0, CornerSize r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
    L6:
        return top(r0, r1);
    }
}
