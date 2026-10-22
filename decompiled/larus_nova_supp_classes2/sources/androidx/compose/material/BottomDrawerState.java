package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0019J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0007J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010*\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\"\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b1\u00102J\u0015\u0010\u0006\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0003H\u0000¢\u0006\u0002\b4R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0017R\u0014\u00105\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001dR\u0014\u00106\u001a\u000207X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Landroidx/compose/material/BottomDrawerState;", "", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material/BottomDrawerValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "targetValue", "getTargetValue", "()Landroidx/compose/material/BottomDrawerValue;", "offset", "getOffset", "()F", "requireOffset", "requireOffset$material", "currentValue", "getCurrentValue", "isOpen", "()Z", "isClosed", "isExpanded", "progress", "getProgress$annotations", "()V", "getProgress", "from", "to", "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "expand", "animateTo", "target", "velocity", "animateTo$material", "(Landroidx/compose/material/BottomDrawerValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "confirmStateChange$material", "isOpenEnabled", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomDrawerState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/BottomDrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ BottomDrawerValue a(SaverScope r0, BottomDrawerState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ BottomDrawerState b(Density r0, Function1 r1, AnimationSpec r2, BottomDrawerValue r3) {
            return Saver$lambda$1(r0, r1, r2, r3);
        }

        private static final BottomDrawerValue Saver$lambda$0(SaverScope r0, BottomDrawerState r1) {
            return r1.getAnchoredDraggableState$material().getCurrentValue();
        }

        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(final Density r3, final Function1<? super BottomDrawerValue, Boolean> r4, final AnimationSpec<Float> r5) {
            return SaverKt.Saver(new o1(), new p1(r3, r4, r5));
        }

        private static final BottomDrawerState Saver$lambda$1(Density r1, Function1 r2, AnimationSpec r3, BottomDrawerValue r4) {
            return new BottomDrawerState(r4, r1, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    private static final boolean _init_$lambda$0(BottomDrawerValue r0) {
        return true;
    }

    public static /* synthetic */ float a(Density r0) {
        return anchoredDraggableState$lambda$4(r0);
    }

    public static /* synthetic */ boolean b(BottomDrawerValue r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ float c(Density r0, float r1) {
        return anchoredDraggableState$lambda$2(r0, r1);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    private final boolean isOpenEnabled() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(BottomDrawerValue.Open);
    }

    public final BottomDrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final BottomDrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isClosed() {
        if (this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Closed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isExpanded() {
        if (this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Expanded) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOpen() {
        if (this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Closed) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<BottomDrawerValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final Density getDensity$material() {
        return this.density;
    }

    public final NestedScrollConnection getNestedScrollConnection$material() {
        return this.nestedScrollConnection;
    }

    private static final float anchoredDraggableState$lambda$4(Density r1) {
        return r1.toPx-0680j_4(DrawerKt.access$getDrawerVelocityThreshold$p());
    }

    public final Object close(Continuation<? super Unit> r7) {
        Object r8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Closed, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final boolean confirmStateChange$material(BottomDrawerValue r2) {
        return ((Boolean) this.anchoredDraggableState.getConfirmValueChange$material().invoke(r2)).booleanValue();
    }

    public final Object expand(Continuation<? super Unit> r7) {
        Object r8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Expanded, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final Object open(Continuation<? super Unit> r8) {
        if (isOpenEnabled() == false) goto L5;
        BottomDrawerValue r0 = BottomDrawerValue.Open;
    L6:
        AnchoredDraggableState<BottomDrawerValue> r1 = this.anchoredDraggableState;
        Object r9 = AnchoredDraggableKt.animateTo$default(r1, r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r8, 2, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r9;
    L10:
        return Unit.INSTANCE;
    L5:
        r0 = BottomDrawerValue.Expanded;
        goto L6
    }

    public final void setDensity$material(Density r1) {
        this.density = r1;
    }

    private static final float anchoredDraggableState$lambda$2(Density r0, float r1) {
        return r0.toPx-0680j_4(DrawerKt.access$getDrawerPositionalThreshold$p());
    }

    public final float progress(BottomDrawerValue r4, BottomDrawerValue r5) {
        float r6 = this.anchoredDraggableState.getAnchors().positionOf(r4);
        float r7 = this.anchoredDraggableState.getAnchors().positionOf(r5);
        float r0 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r6, r7), Math.max(r6, r7)) - r6) / (r7 - r6);
        if (Float.isNaN(r0) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r0);
    }

    public final Object snapTo$material(BottomDrawerValue r2, Continuation<? super Unit> r3) {
        Object r4 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material(BottomDrawerValue r2, float r3, Continuation<? super Unit> r4) {
        Object r5 = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, r2, r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public BottomDrawerState(BottomDrawerValue r8, final Density r9, Function1<? super BottomDrawerValue, Boolean> r10, AnimationSpec<Float> r11) {
        AnchoredDraggableState<BottomDrawerValue> r6 = new AnchoredDraggableState(r8, new m1(r9), new n1(r9), r11, r10);
        this.anchoredDraggableState = r6;
        this.nestedScrollConnection = DrawerKt.access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r6);
    }

    public /* synthetic */ BottomDrawerState(BottomDrawerValue r1, Density r2, Function1 r3, AnimationSpec r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = new l1();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = DrawerDefaults.INSTANCE.getAnimationSpec();
    L8:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object animateTo$material$default(BottomDrawerState r0, BottomDrawerValue r1, float r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.anchoredDraggableState.getLastVelocity();
    L6:
        return r0.animateTo$material(r1, r2, r3);
    }
}
