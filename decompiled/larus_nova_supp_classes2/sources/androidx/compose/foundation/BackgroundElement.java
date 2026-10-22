package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BF\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u000e*\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BackgroundNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "create", "update", "node", "inspectableProperties", "hashCode", "", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BackgroundElement extends ModifierNodeElement<BackgroundNode> {
    private final float alpha;
    private final Brush brush;
    private final long color;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final Shape shape;

    public /* synthetic */ BackgroundElement(long r1, Brush r3, float r4, Shape r5, Function1 r6, DefaultConstructorMarker r7) {
        this(r1, r3, r4, r5, r6);
    }

    public BackgroundNode create() {
        return new BackgroundNode(this.color, this.brush, this.alpha, this.shape, null);
    }

    public int hashCode() {
        int r0 = Color.hashCode-impl(this.color) * 31;
        Brush r1 = this.brush;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((((r0 + r2) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.shape.hashCode();
    L5:
        r2 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m340create() {
        return create();
    }

    public boolean equals(Object r6) {
        if ((r6 instanceof BackgroundElement) == false) goto L5;
        BackgroundElement r7 = (BackgroundElement) r6;
    L7:
        if (r7 != null) goto L10;
        return false;
    L10:
        if (Color.equals-impl0(this.color, r7.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.brush, r7.brush) == true) goto L14;
        return false;
    L14:
        if (this.alpha != r7.alpha) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.shape, r7.shape) == false) goto L25;
        return true;
    L25:
        return false;
    L16:
        r1 = false;
        goto L17
    L5:
        r7 = null;
        goto L7
    }

    public void inspectableProperties(InspectorInfo r2) {
        this.inspectorInfo.invoke(r2);
    }

    public void update(BackgroundNode r3) {
        r3.m344setColor8_81llA(this.color);
        r3.setBrush(this.brush);
        r3.setAlpha(this.alpha);
        r3.setShape(this.shape);
        DrawModifierNodeKt.invalidateDraw(r3);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((BackgroundNode) r1);
    }

    private BackgroundElement(long r1, Brush r3, float r4, Shape r5, Function1<? super InspectorInfo, Unit> r6) {
        this.color = r1;
        this.brush = r3;
        this.alpha = r4;
        this.shape = r5;
        this.inspectorInfo = r6;
    }

    public /* synthetic */ BackgroundElement(long r11, Brush r13, float r14, Shape r15, Function1 r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r17 & 2) == 0) goto L9;
        Brush r5 = null;
    L10:
        this(r3, r5, r14, r15, r16, null);
        return;
    L9:
        r5 = r13;
        goto L10
    L5:
        r3 = r11;
        goto L7
    }
}
