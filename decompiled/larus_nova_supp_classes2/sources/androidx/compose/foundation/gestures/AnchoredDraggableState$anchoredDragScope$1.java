package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "leftBound", "getLeftBound", "()Ljava/lang/Object;", "setLeftBound", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "rightBound", "getRightBound", "setRightBound", "distance", "", "getDistance", "()F", "setDistance", "(F)V", "dragTo", "", "newOffset", "lastKnownVelocity", "updateIfNeeded", "isMovingForward", "", "updateBounds", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableState$anchoredDragScope$1 implements AnchoredDragScope {
    private float distance;
    private T leftBound;
    private T rightBound;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    public final float getDistance() {
        return this.distance;
    }

    public final T getLeftBound() {
        return this.leftBound;
    }

    public final T getRightBound() {
        return this.rightBound;
    }

    public AnchoredDraggableState$anchoredDragScope$1(AnchoredDraggableState<T> r1) {
        this.this$0 = r1;
        this.distance = Float.NaN;
    }

    public final void setDistance(float r1) {
        this.distance = r1;
    }

    public final void setLeftBound(T r1) {
        this.leftBound = r1;
    }

    public final void setRightBound(T r1) {
        this.rightBound = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15, types: [T, java.lang.Object] */
    public final void updateBounds(boolean r5) {
        float r0 = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
        if (this.this$0.getOffset() != r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L17;
        float r2 = this.this$0.getOffset();
        if (r5 == false) goto L10;
        float r3 = 1.0f;
    L11:
        float r4 = r2 + r3;
        Object r6 = this.this$0.getAnchors().closestAnchor(r4, r5);
        T r7 = r6;
        if (r6 != null) goto L14;
        r7 = this.this$0.getCurrentValue();
    L14:
        if (r5 == false) goto L16;
        this.leftBound = this.this$0.getCurrentValue();
        this.rightBound = r7;
    L24:
        DraggableAnchors r8 = this.this$0.getAnchors();
        T r9 = this.leftBound;
        Intrinsics.checkNotNull(r9);
        float r10 = r8.positionOf(r9);
        DraggableAnchors r11 = this.this$0.getAnchors();
        T r12 = this.rightBound;
        Intrinsics.checkNotNull(r12);
        this.distance = Math.abs(r10 - r11.positionOf(r12));
        return;
    L16:
        this.leftBound = r7;
        this.rightBound = this.this$0.getCurrentValue();
        goto L24
    L10:
        r3 = -1.0f;
        goto L11
    L17:
        Object r13 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), false);
        T r14 = r13;
        if (r13 != null) goto L20;
        r14 = this.this$0.getCurrentValue();
    L20:
        Object r15 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), true);
        T r16 = r15;
        if (r15 != null) goto L23;
        r16 = this.this$0.getCurrentValue();
    L23:
        this.leftBound = r14;
        this.rightBound = r16;
        goto L24
    L5:
        r1 = false;
        goto L6
    }

    public final void updateIfNeeded(boolean r4) {
        updateBounds(r4);
        if (Math.abs(this.this$0.getOffset() - this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue())) < (this.distance / 2.0f)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        if (r4 == false) goto L9;
        Object r5 = this.rightBound;
    L10:
        if (r5 != null) goto L13;
        r5 = this.this$0.getCurrentValue();
    L13:
        if (((Boolean) this.this$0.getConfirmValueChange$foundation_release().invoke(r5)).booleanValue() == false) goto L17;
        AnchoredDraggableState.access$setCurrentValue(this.this$0, r5);
        return;
    L17:
        return;
    L9:
        r5 = this.leftBound;
        goto L10
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.AnchoredDragScope
    public void dragTo(float r3, float r4) {
        float r0 = this.this$0.getOffset();
        AnchoredDraggableState.access$setOffset(this.this$0, r3);
        AnchoredDraggableState.access$setLastVelocity(this.this$0, r4);
        if (Float.isNaN(r0) == false) goto L6;
        return;
    L6:
        if (r3 < r0) goto L8;
        boolean r5 = true;
    L9:
        updateIfNeeded(r5);
        return;
    L8:
        r5 = false;
        goto L9
    }
}
