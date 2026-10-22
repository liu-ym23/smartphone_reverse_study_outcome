package androidx.compose.foundation;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010-\u001a\u00020.*\u00020/H\u0016J\b\u00100\u001a\u00020.H\u0016J\f\u00101\u001a\u00020.*\u00020/H\u0002J\f\u00102\u001a\u00020.*\u00020/H\u0002J\f\u00103\u001a\u00020**\u00020/H\u0002J\f\u00104\u001a\u00020.*\u000205H\u0016R\u001c\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0010\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/compose/foundation/BackgroundNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "lastSize", "Landroidx/compose/ui/geometry/Size;", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastShape", "tmpOutline", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "drawRect", "drawOutline", "getOutline", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode, SemanticsModifierNode {
    private float alpha;
    private Brush brush;
    private long color;
    private final boolean isImportantForBounds;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private Outline tmpOutline;

    public /* synthetic */ BackgroundNode(long r1, Brush r3, float r4, Shape r5, DefaultConstructorMarker r6) {
        this(r1, r3, r4, r5);
    }

    public static /* synthetic */ Unit a(BackgroundNode r0, ContentDrawScope r1) {
        return getOutline$lambda$2(r0, r1);
    }

    public void applySemantics(SemanticsPropertyReceiver r1) {
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public void onObservedReadsChanged() {
        this.lastSize = Size.Companion.getUnspecified-NH-jbRc();
        this.lastLayoutDirection = null;
        this.lastOutline = null;
        this.lastShape = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m343getColor0d7_KjU() {
        return this.color;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    private final void drawOutline(ContentDrawScope r12) {
        Outline r10 = getOutline(r12);
        if (Color.equals-impl0(this.color, Color.Companion.getUnspecified-0d7_KjU()) == true) goto L5;
        OutlineKt.drawOutline-wDX37Ww$default(r12, r10, this.color, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
    L5:
        Brush r2 = this.brush;
        if (r2 == null) goto L9;
        OutlineKt.drawOutline-hn5TExg$default(r12, r10, r2, this.alpha, null, null, 0, 56, null);
        return;
    }

    private final void drawRect(ContentDrawScope r28) {
        if (Color.equals-impl0(this.color, Color.Companion.getUnspecified-0d7_KjU()) == true) goto L5;
        DrawScope.-CC.drawRect-n-J9OG0$default(r28, this.color, 0, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 126, null);
    L5:
        Brush r1 = this.brush;
        if (r1 == null) goto L9;
        DrawScope.-CC.drawRect-AsUm42w$default(r28, r1, 0, 0, this.alpha, null, null, 0, 118, null);
        return;
    }

    private final Outline getOutline(final ContentDrawScope r5) {
        if (Size.equals-impl0(r5.getSize-NH-jbRc(), this.lastSize) == true) goto L5;
    L9:
        ObserverModifierNodeKt.observeReads(this, new k(this, r5));
        Outline r0 = this.tmpOutline;
        this.tmpOutline = null;
    L10:
        this.lastOutline = r0;
        this.lastSize = r5.getSize-NH-jbRc();
        this.lastLayoutDirection = r5.getLayoutDirection();
        this.lastShape = this.shape;
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (r5.getLayoutDirection() != this.lastLayoutDirection) goto L9;
        if (Intrinsics.areEqual(this.lastShape, this.shape) == false) goto L9;
        r0 = this.lastOutline;
        Intrinsics.checkNotNull(r0);
        goto L10
    }

    public void draw(ContentDrawScope r3) {
        if (this.shape != RectangleShapeKt.getRectangleShape()) goto L5;
        drawRect(r3);
    L6:
        r3.drawContent();
        return;
    L5:
        drawOutline(r3);
        goto L6
    }

    public final void setAlpha(float r1) {
        this.alpha = r1;
    }

    public final void setBrush(Brush r1) {
        this.brush = r1;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m344setColor8_81llA(long r1) {
        this.color = r1;
    }

    public final void setShape(Shape r1) {
        this.shape = r1;
    }

    private static final Unit getOutline$lambda$2(BackgroundNode r4, ContentDrawScope r5) {
        r4.tmpOutline = r4.shape.createOutline-Pq9zytI(r5.getSize-NH-jbRc(), r5.getLayoutDirection(), r5);
        return Unit.INSTANCE;
    }

    private BackgroundNode(long r1, Brush r3, float r4, Shape r5) {
        this.color = r1;
        this.brush = r3;
        this.alpha = r4;
        this.shape = r5;
        this.lastSize = Size.Companion.getUnspecified-NH-jbRc();
    }
}
