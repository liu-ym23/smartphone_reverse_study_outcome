package androidx.compose.foundation;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010%\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002JC\u0010-\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u00104J\f\u00105\u001a\u000206*\u000207H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private final boolean isImportantForBounds;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private float width;

    public /* synthetic */ BorderModifierNode(float r1, Brush r2, Shape r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public static /* synthetic */ Unit a(Path r0, Brush r1, ContentDrawScope r2) {
        return drawRoundRectBorder_JqoCqck$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ DrawResult b(BorderModifierNode r0, CacheDrawScope r1) {
        return drawWithCacheModifierNode$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit c(boolean r0, Brush r1, long r2, float r4, float r5, long r6, long r8, Stroke r10, ContentDrawScope r11) {
        return drawRoundRectBorder_JqoCqck$lambda$10(r0, r1, r2, r4, r5, r6, r8, r10, r11);
    }

    public static /* synthetic */ Unit d(Outline.Generic r0, Brush r1, ContentDrawScope r2) {
        return drawGenericBorder$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(Rect r0, Ref.ObjectRef r1, long r2, ColorFilter r4, ContentDrawScope r5) {
        return drawGenericBorder$lambda$8(r0, r1, r2, r4, r5);
    }

    public void applySemantics(SemanticsPropertyReceiver r1) {
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m359getWidthD9Ej5fM() {
        return this.width;
    }

    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    public final void setBrush(Brush r2) {
        if (Intrinsics.areEqual(this.brush, r2) == true) goto L6;
        this.brush = r2;
        this.drawWithCacheModifierNode.invalidateDrawCache();
        return;
    }

    public final void setShape(Shape r2) {
        if (Intrinsics.areEqual(this.shape, r2) == true) goto L6;
        this.shape = r2;
        this.drawWithCacheModifierNode.invalidateDrawCache();
        return;
    }

    /* JADX INFO: renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m360setWidth0680j_4(float r2) {
        if (Dp.equals-impl0(this.width, r2) == true) goto L6;
        this.width = r2;
        this.drawWithCacheModifierNode.invalidateDrawCache();
        return;
    }

    private static final DrawResult drawWithCacheModifierNode$lambda$0(BorderModifierNode r16, CacheDrawScope r17) {
        float r2 = r16.width;
        r17.getClass();
        if (Density.-CC.$default$toPx-0680j_4(r17, r2) >= MenuKt.ClosedAlphaTarget) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        return BorderKt.access$drawContentWithoutBorder(r17);
    L11:
        if (Dp.equals-impl0(r16.width, Dp.Companion.getHairline-D9Ej5fM()) == false) goto L13;
        float r4 = 1.0f;
    L14:
        float r6 = 2;
        float r9 = Math.min(r4, (float) Math.ceil(Size.getMinDimension-impl(r17.getSize-NH-jbRc()) / r6));
        float r5 = r9 / r6;
        long r7 = Offset.constructor-impl((Float.floatToRawIntBits(r5) << 32) | (((long) Float.floatToRawIntBits(r5)) & 4294967295L));
        float r8 = Float.intBitsToFloat((int) (r17.getSize-NH-jbRc() >> 32)) - r9;
        float r10 = Float.intBitsToFloat((int) (r17.getSize-NH-jbRc() & 4294967295L)) - r9;
        long r14 = Float.floatToRawIntBits(r8);
        long r11 = Size.constructor-impl((((long) Float.floatToRawIntBits(r10)) & 4294967295L) | (r14 << 32));
        if ((r6 * r9) <= Size.getMinDimension-impl(r17.getSize-NH-jbRc())) goto L17;
        boolean r12 = true;
    L18:
        Outline r13 = r16.shape.createOutline-Pq9zytI(r17.getSize-NH-jbRc(), r17.getLayoutDirection(), r17);
        if ((r13 instanceof Outline.Generic) == false) goto L22;
        return r16.drawGenericBorder(r17, r16.brush, (Outline.Generic) r13, r12, r9);
    L22:
        if ((r13 instanceof Outline.Rounded) == false) goto L25;
        return r16.m358drawRoundRectBorderJqoCqck(r17, r16.brush, (Outline.Rounded) r13, r7, r11, r12, r9);
    L25:
        if ((r13 instanceof Outline.Rectangle) == false) goto L29;
        return BorderKt.m351access$drawRectBorderNsqcLGU(r17, r16.brush, r7, r11, r12, r9);
    L29:
        throw new NoWhenBranchMatchedException();
    L17:
        r12 = false;
        goto L18
    L13:
        r4 = (float) Math.ceil(Density.-CC.$default$toPx-0680j_4(r17, r16.width));
        goto L14
    L5:
        if (Size.getMinDimension-impl(r17.getSize-NH-jbRc()) <= MenuKt.ClosedAlphaTarget) goto L7;
        r3 = true;
        goto L8
    }

    private BorderModifierNode(float r1, Brush r2, Shape r3) {
        this.width = r1;
        this.brush = r2;
        this.shape = r3;
        this.drawWithCacheModifierNode = delegate(DrawModifierKt.CacheDrawModifierNode(new a0(this)));
    }

    private static final Unit drawGenericBorder$lambda$1(Outline.Generic r9, Brush r10, ContentDrawScope r11) {
        r11.drawContent();
        DrawScope.-CC.drawPath-GBMwjPU$default(r11, r9.getPath(), r10, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    private static final Unit drawRoundRectBorder_JqoCqck$lambda$11(Path r9, Brush r10, ContentDrawScope r11) {
        r11.drawContent();
        DrawScope.-CC.drawPath-GBMwjPU$default(r11, r9, r10, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    private final DrawResult drawGenericBorder(CacheDrawScope r50, final Brush r51, final Outline.Generic r52, boolean r53, float r54) {
        if (r53 == true) goto L74;
        ImageBitmapConfig r4 = null;
        if ((r51 instanceof SolidColor) == false) goto L8;
        int r14 = ImageBitmapConfig.Companion.getAlpha8-_sVssgQ();
        ColorFilter r19 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, Color.copy-wmQWz5c$default(((SolidColor) r51).getValue-0d7_KjU(), 1.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 0, 2, null);
    L9:
        final Rect r10 = r52.getPath().getBounds();
        if (this.borderCache != null) goto L12;
        this.borderCache = new BorderCache(null, null, null, null, 15, null);
    L12:
        BorderCache r2 = this.borderCache;
        Intrinsics.checkNotNull(r2);
        Path r9 = r2.obtainPath();
        r9.reset();
        Path.-CC.addRect$default(r9, r10, null, 2, null);
        r9.op-N5in7k0(r9, r52.getPath(), PathOperation.Companion.getDifference-b3I0S0c());
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        final long r23 = IntSize.constructor-impl((((long) ((int) Math.ceil(r10.getBottom() - r10.getTop()))) & 4294967295L) | (((long) ((int) Math.ceil(r10.getRight() - r10.getLeft()))) << 32));
        BorderCache r5 = this.borderCache;
        Intrinsics.checkNotNull(r5);
        ImageBitmap r6 = BorderCache.access$getImageBitmap$p(r5);
        Canvas r7 = BorderCache.access$getCanvas$p(r5);
        if (r6 == null) goto L15;
        ImageBitmapConfig r12 = ImageBitmapConfig.box-impl(r6.getConfig-_sVssgQ());
    L16:
        int r13 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        boolean r15 = false;
        if (r12 != null) goto L19;
        boolean r16 = false;
    L21:
        if (r16 == true) goto L26;
        if (r6 == null) goto L25;
        r4 = ImageBitmapConfig.box-impl(r6.getConfig-_sVssgQ());
    L25:
        if (ImageBitmapConfig.equals-impl(r14, r4) == true) goto L26;
    L27:
        if (r6 == null) goto L36;
        if (r7 == null) goto L36;
        if (Float.intBitsToFloat((int) (r50.getSize-NH-jbRc() >> 32)) > r6.getWidth()) goto L36;
        if (Float.intBitsToFloat((int) (r50.getSize-NH-jbRc() & 4294967295L)) > r6.getHeight()) goto L36;
        if (r15 == false) goto L36;
        ImageBitmap r17 = r6;
        Canvas r18 = r7;
    L37:
        CanvasDrawScope r3 = BorderCache.access$getCanvasDrawScope$p(r5);
        if (r3 != null) goto L40;
        r3 = new CanvasDrawScope();
        BorderCache.access$setCanvasDrawScope$p(r5, r3);
    L40:
        CanvasDrawScope r110 = r3;
        long r11 = IntSizeKt.toSize-ozmzZPI(r23);
        LayoutDirection r20 = r50.getLayoutDirection();
        CanvasDrawScope.DrawParams r21 = r110.getDrawParams();
        Density r111 = r21.component1();
        LayoutDirection r22 = r21.component2();
        Canvas r24 = r21.component3();
        long r25 = r21.component4-NH-jbRc();
        CanvasDrawScope.DrawParams r26 = r110.getDrawParams();
        r26.setDensity(r50);
        r26.setLayoutDirection(r20);
        r26.setCanvas(r18);
        r26.setSize-uvyYCjk(r11);
        r18.save();
        long r27 = Color.Companion.getBlack-0d7_KjU();
        BlendMode.Companion r38 = BlendMode.Companion;
        DrawScope.-CC.drawRect-n-J9OG0$default(r110, r27, 0, r11, MenuKt.ClosedAlphaTarget, null, null, r38.getClear-0nO6VwU(), 58, null);
        float r28 = -r10.getLeft();
        float r29 = -r10.getTop();
        r110.getDrawContext().getTransform().translate(r28, r29);
        float r30 = r29;
        float r31 = r28;
        DrawScope.-CC.drawPath-GBMwjPU$default(r110, r52.getPath(), r51, MenuKt.ClosedAlphaTarget, new Stroke(r54 * 2, MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null), null, 0, 52, null);     // Catch: Throwable -> L58
        float r32 = 1;
        float r33 = (Float.intBitsToFloat((int) (r110.getSize-NH-jbRc() >> 32)) + r32) / Float.intBitsToFloat((int) (r110.getSize-NH-jbRc() >> 32));     // Catch: Throwable -> L58
        float r34 = (Float.intBitsToFloat((int) (r110.getSize-NH-jbRc() & 4294967295L)) + r32) / Float.intBitsToFloat((int) (r110.getSize-NH-jbRc() & 4294967295L));     // Catch: Throwable -> L58
        long r35 = r110.getCenter-F1C5BW0();     // Catch: Throwable -> L58
        DrawContext r112 = r110.getDrawContext();     // Catch: Throwable -> L58
        long r36 = r112.getSize-NH-jbRc();     // Catch: Throwable -> L58
        r112.getCanvas().save();     // Catch: Throwable -> L58
        r112.getTransform().scale-0AR0LA0(r33, r34, r35);     // Catch: Throwable -> L52
        DrawContext r113 = r112;
        DrawScope.-CC.drawPath-GBMwjPU$default(r110, r9, r51, MenuKt.ClosedAlphaTarget, null, null, r38.getClear-0nO6VwU(), 28, null);     // Catch: Throwable -> L50
        r113.getCanvas().restore();     // Catch: Throwable -> L58
        r113.setSize-uvyYCjk(r36);     // Catch: Throwable -> L58
        r110.getDrawContext().getTransform().translate(-r31, -r30);
        r18.restore();
        CanvasDrawScope.DrawParams r37 = r110.getDrawParams();
        r37.setDensity(r111);
        r37.setLayoutDirection(r22);
        r37.setCanvas(r24);
        r37.setSize-uvyYCjk(r25);
        r17.prepareToDraw();
        r8.element = r17;
        final ColorFilter r114 = r19;
        return r50.onDrawWithContent(new c0(r10, r8, r23, r114));
    L50:
        th = th;
        long r39 = r36;
    L66:
        r113.getCanvas().restore();     // Catch: Throwable -> L56
        r113.setSize-uvyYCjk(r39);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L56:
        th = th;
    L62:
        r110.getDrawContext().getTransform().translate(-r31, -r30);
        throw th;
    L52:
        th = th;
        r39 = r36;
        r113 = r112;
    L58:
        th = th;
        r30 = r30;
        r31 = r31;
    L60:
        th = th;
        r30 = r29;
        r31 = r28;
    L36:
        ImageBitmap r40 = ImageBitmapKt.ImageBitmap-x__-hDU$default((int) (r23 >> 32), (int) (r23 & 4294967295L), r14, false, null, 24, null);
        BorderCache.access$setImageBitmap$p(r5, r40);
        Canvas r41 = androidx.compose.ui.graphics.CanvasKt.Canvas(r40);
        BorderCache.access$setCanvas$p(r5, r41);
        r18 = r41;
        r17 = r40;
    L26:
        r15 = true;
        goto L27
    L19:
        r16 = ImageBitmapConfig.equals-impl0(r12.unbox-impl(), r13);
        goto L21
    L15:
        r12 = null;
        goto L16
    L8:
        r14 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        r19 = null;
        goto L9
    L74:
        return r50.onDrawWithContent(new b0(r52, r51));
    }

    private static final Unit drawGenericBorder$lambda$8(Rect r20, Ref.ObjectRef r21, long r22, ColorFilter r24, ContentDrawScope r25) {
        r25.drawContent();
        float r1 = r20.getLeft();
        float r2 = r20.getTop();
        r25.getDrawContext().getTransform().translate(r1, r2);
        DrawScope.-CC.drawImage-AZ2fEMs$default(r25, (ImageBitmap) r21.element, 0, r22, 0, 0, MenuKt.ClosedAlphaTarget, null, r24, 0, 0, 890, null);     // Catch: Throwable -> L6
        r25.getDrawContext().getTransform().translate(-r1, -r2);
        return Unit.INSTANCE;
    L6:
        th = move-exception;
        r25.getDrawContext().getTransform().translate(-r1, -r2);
        throw th;
    }

    /* JADX INFO: renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    private final DrawResult m358drawRoundRectBorderJqoCqck(CacheDrawScope r17, final Brush r18, Outline.Rounded r19, final long r20, final long r22, final boolean r24, final float r25) {
        if (RoundRectKt.isSimple(r19.getRoundRect()) == false) goto L6;
        final long r11 = r19.getRoundRect().getTopLeftCornerRadius-kKHJgLs();
        final float r13 = r25 / 2;
        final Stroke r14 = new Stroke(r25, MenuKt.ClosedAlphaTarget, 0, 0, null, 30, null);
        return r17.onDrawWithContent(new y(r24, r18, r11, r13, r25, r20, r22, r14));
    L6:
        if (this.borderCache != null) goto L8;
        this.borderCache = new BorderCache(null, null, null, null, 15, null);
    L8:
        BorderCache r2 = this.borderCache;
        Intrinsics.checkNotNull(r2);
        final Path r3 = BorderKt.access$createRoundRectPath(r2.obtainPath(), r19.getRoundRect(), r25, r24);
        return r17.onDrawWithContent(new z(r3, r18));
    }

    private static final Unit drawRoundRectBorder_JqoCqck$lambda$10(boolean r30, Brush r31, long r32, float r34, float r35, long r36, long r38, Stroke r40, ContentDrawScope r41) {
        r41.drawContent();
        if (r30 == false) goto L6;
        DrawScope.-CC.drawRoundRect-ZuiqVtQ$default(r41, r31, 0, 0, r32, MenuKt.ClosedAlphaTarget, null, null, 0, 246, null);
    L20:
        return Unit.INSTANCE;
    L6:
        if (Float.intBitsToFloat((int) (r32 >> 32)) >= r34) goto L18;
        float r4 = Float.intBitsToFloat((int) (r41.getSize-NH-jbRc() >> 32)) - r35;
        float r5 = Float.intBitsToFloat((int) (r41.getSize-NH-jbRc() & 4294967295L)) - r35;
        int r6 = ClipOp.Companion.getDifference-rtfAjoo();
        DrawContext r15 = r41.getDrawContext();
        long r13 = r15.getSize-NH-jbRc();
        r15.getCanvas().save();
        r15.getTransform().clipRect-N_I0leg(r35, r35, r4, r5, r6);     // Catch: Throwable -> L14
        DrawScope.-CC.drawRoundRect-ZuiqVtQ$default(r41, r31, 0, 0, r32, MenuKt.ClosedAlphaTarget, null, null, 0, 246, null);     // Catch: Throwable -> L12
        r15.getCanvas().restore();
        r15.setSize-uvyYCjk(r13);
    L12:
        th = th;
        long r1 = r13;
    L16:
        r15.getCanvas().restore();
        r15.setSize-uvyYCjk(r1);
        throw th;
    L14:
        th = th;
        r1 = r13;
        goto L16
    L18:
        DrawScope.-CC.drawRoundRect-ZuiqVtQ$default(r41, r31, r36, r38, BorderKt.m352access$shrinkKibmq7A(r32, r34), MenuKt.ClosedAlphaTarget, r40, null, 0, 208, null);
        goto L20
    }
}
