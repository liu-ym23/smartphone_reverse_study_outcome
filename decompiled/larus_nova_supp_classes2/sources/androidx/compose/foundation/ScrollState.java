package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J?\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2'\u0010&\u001a#\b\u0001\u0012\u0004\u0012\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0)\u0012\u0006\u0012\u0004\u0018\u00010*0'¢\u0006\u0002\b+H\u0096@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0016J&\u0010=\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020 0?H\u0086@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010BR+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@@X\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u0005R+\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00101R\u001b\u00102\u001a\u0002008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b3\u00101R\u001b\u00106\u001a\u0002008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u00101R\u0014\u00109\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00101R\u0014\u0010;\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u00101¨\u0006D"}, d2 = {"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initial", "", "<init>", "(I)V", "<set-?>", "value", "getValue", "()I", "setValue", "value$delegate", "Landroidx/compose/runtime/MutableIntState;", "newMax", "maxValue", "getMaxValue", "setMaxValue$foundation_release", "viewportSize", "getViewportSize", "setViewportSize$foundation_release", "viewportSize$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_maxValueState", "Landroidx/compose/runtime/MutableIntState;", "accumulator", "", "scrollableState", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "", "()Z", "canScrollForward", "getCanScrollForward", "canScrollForward$delegate", "Landroidx/compose/runtime/State;", "canScrollBackward", "getCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "animateScrollTo", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<ScrollState, ?> Saver = null;
    private MutableIntState _maxValueState;
    private float accumulator;
    private final State canScrollBackward$delegate;
    private final State canScrollForward$delegate;
    private final MutableInteractionSource internalInteractionSource;
    private final ScrollableState scrollableState;
    private final MutableIntState value$delegate;
    private final MutableIntState viewportSize$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/ScrollState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/ScrollState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<ScrollState, ?> getSaver() {
            return ScrollState.access$getSaver$cp();
        }
    }

    public static /* synthetic */ boolean a(ScrollState r0) {
        return canScrollForward_delegate$lambda$2(r0);
    }

    public static /* synthetic */ boolean b(ScrollState r0) {
        return canScrollBackward_delegate$lambda$3(r0);
    }

    public static /* synthetic */ float c(ScrollState r0, float r1) {
        return scrollableState$lambda$1(r0, r1);
    }

    public static /* synthetic */ ScrollState d(int r0) {
        return Saver$lambda$5(r0);
    }

    public static /* synthetic */ Integer e(SaverScope r0, ScrollState r1) {
        return Saver$lambda$4(r0, r1);
    }

    static {
        Companion = new Companion(null);
        Saver = SaverKt.Saver(new n1(), new o1());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final int getMaxValue() {
        return this._maxValueState.getIntValue();
    }

    public final int getValue() {
        return this.value$delegate.getIntValue();
    }

    public final int getViewportSize() {
        return this.viewportSize$delegate.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public ScrollState(int r1) {
        this.value$delegate = SnapshotIntStateKt.mutableIntStateOf(r1);
        this.viewportSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this._maxValueState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
        this.scrollableState = ScrollableStateKt.ScrollableState(new k1(this));
        this.canScrollForward$delegate = SnapshotStateKt.derivedStateOf(new l1(this));
        this.canScrollBackward$delegate = SnapshotStateKt.derivedStateOf(new m1(this));
    }

    private static final ScrollState Saver$lambda$5(int r1) {
        return new ScrollState(r1);
    }

    private static final boolean canScrollBackward_delegate$lambda$3(ScrollState r0) {
        if (r0.getValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean canScrollForward_delegate$lambda$2(ScrollState r1) {
        if (r1.getValue() >= r1.getMaxValue()) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setValue(int r2) {
        this.value$delegate.setIntValue(r2);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float r2) {
        return this.scrollableState.dispatchRawDelta(r2);
    }

    public final void setMaxValue$foundation_release(int r6) {
        this._maxValueState.setIntValue(r6);
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
    L13:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L8:
        if (getValue() <= r6) goto L10;
        setValue(r6);     // Catch: Throwable -> L13
    L10:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void setViewportSize$foundation_release(int r2) {
        this.viewportSize$delegate.setIntValue(r2);
    }

    private static final Integer Saver$lambda$4(SaverScope r0, ScrollState r1) {
        return Integer.valueOf(r1.getValue());
    }

    private static final float scrollableState$lambda$1(ScrollState r4, float r5) {
        float r0 = (r4.getValue() + r5) + r4.accumulator;
        float r1 = RangesKt.coerceIn(r0, MenuKt.ClosedAlphaTarget, r4.getMaxValue());
        if (r0 != r1) goto L5;
        boolean r2 = true;
    L6:
        boolean r3 = !r2;
        float r6 = r1 - r4.getValue();
        int r7 = Math.round(r6);
        r4.setValue(r4.getValue() + r7);
        r4.accumulator = r6 - r7;
        if (r3 == true) goto L9;
        return r5;
    L9:
        return r6;
    L5:
        r2 = false;
        goto L6
    }

    public final Object scrollTo(int r2, Continuation<? super Float> r3) {
        return ScrollExtensionsKt.scrollBy(this, r2 - getValue(), r3);
    }

    public final Object animateScrollTo(int r2, AnimationSpec<Float> r3, Continuation<? super Unit> r4) {
        Object r5 = ScrollExtensionsKt.animateScrollBy(this, r2 - getValue(), r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority r2, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super Unit> r4) {
        Object r5 = this.scrollableState.scroll(r2, r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollTo$default(ScrollState r6, int r7, AnimationSpec r8, Continuation r9, int r10, Object r11) {
        if ((r10 & 2) == 0) goto L6;
        r8 = new SpringSpec(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L6:
        return r6.animateScrollTo(r7, r8, r9);
    }
}
