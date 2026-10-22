package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H&J\u0016\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H&J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0006H\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/RectListNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "rect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getRect", "()Lkotlin/jvm/functions/Function1;", "setRect", "androidRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "onGloballyPositioned", "", "coordinates", "onDetach", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "updateRects", "rects", "replaceRect", "newRect", "calcBounds", "layoutCoordinates", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class RectListNode extends Modifier.Node implements GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Rect androidRect;
    private Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> rect;

    public abstract MutableVector<Rect> currentRects();

    public abstract void updateRects(MutableVector<Rect> r1);

    public final View getView() {
        return DelegatableNode_androidKt.requireView(this);
    }

    public void onDetach() {
        super.onDetach();
        replaceRect(null);
    }

    public Function1<LayoutCoordinates, androidx.compose.ui.geometry.Rect> getRect() {
        return this.rect;
    }

    public RectListNode(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> r1) {
        this.rect = r1;
    }

    private final void replaceRect(Rect r4) {
        MutableVector<Rect> r0 = currentRects();
        Rect r1 = this.androidRect;
        if (r1 == null) goto L5;
        r0.remove(r1);
    L5:
        boolean r2 = false;
        if (r4 != null) goto L8;
    L10:
        if (r2 == false) goto L12;
        r0.add(r4);
    L12:
        updateRects(r0);
        this.androidRect = r4;
        return;
    L8:
        if (r4.isEmpty() == true) goto L10;
        r2 = true;
        goto L10
    }

    public void onGloballyPositioned(LayoutCoordinates r5) {
        if (getRect() != null) goto L5;
        androidx.compose.ui.geometry.Rect r6 = LayoutCoordinatesKt.boundsInRoot(r5);
        Rect r0 = new Rect(MathKt.roundToInt(r6.getLeft()), MathKt.roundToInt(r6.getTop()), MathKt.roundToInt(r6.getRight()), MathKt.roundToInt(r6.getBottom()));
    L6:
        replaceRect(r0);
        return;
    L5:
        Function1<LayoutCoordinates, androidx.compose.ui.geometry.Rect> r1 = getRect();
        Intrinsics.checkNotNull(r1);
        r0 = calcBounds(r5, (androidx.compose.ui.geometry.Rect) r1.invoke(r5));
        goto L6
    }

    public void setRect(Function1<? super LayoutCoordinates, androidx.compose.ui.geometry.Rect> r1) {
        this.rect = r1;
    }

    private final Rect calcBounds(LayoutCoordinates r20, androidx.compose.ui.geometry.Rect r21) {
        LayoutCoordinates r1 = LayoutCoordinatesKt.findRootCoordinates(r20);
        long r2 = r1.localPositionOf-R5De75A(r20, r21.getTopLeft-F1C5BW0());
        long r4 = r1.localPositionOf-R5De75A(r20, r21.getTopRight-F1C5BW0());
        long r6 = r1.localPositionOf-R5De75A(r20, r21.getBottomLeft-F1C5BW0());
        long r0 = r1.localPositionOf-R5De75A(r20, r21.getBottomRight-F1C5BW0());
        int r10 = (int) (r2 >> 32);
        int r14 = (int) (r4 >> 32);
        int r12 = (int) (r6 >> 32);
        int r8 = (int) (r0 >> 32);
        int r3 = (int) (r2 & 4294967295L);
        int r5 = (int) (r4 & 4294967295L);
        int r7 = (int) (r6 & 4294967295L);
        int r9 = (int) (r0 & 4294967295L);
        return new Rect(MathKt.roundToInt(ComparisonsKt.minOf(Float.intBitsToFloat(r10), new float[]{Float.intBitsToFloat(r14), Float.intBitsToFloat(r12), Float.intBitsToFloat(r8)})), MathKt.roundToInt(ComparisonsKt.minOf(Float.intBitsToFloat(r3), new float[]{Float.intBitsToFloat(r5), Float.intBitsToFloat(r7), Float.intBitsToFloat(r9)})), MathKt.roundToInt(ComparisonsKt.maxOf(Float.intBitsToFloat(r10), new float[]{Float.intBitsToFloat(r14), Float.intBitsToFloat(r12), Float.intBitsToFloat(r8)})), MathKt.roundToInt(ComparisonsKt.maxOf(Float.intBitsToFloat(r3), new float[]{Float.intBitsToFloat(r5), Float.intBitsToFloat(r7), Float.intBitsToFloat(r9)})));
    }
}
