package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001eR\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "", "<init>", "()V", "scrollDeltaBetweenPasses", "", "getScrollDeltaBetweenPasses$foundation_release", "()F", "job", "Lkotlinx/coroutines/Job;", "getJob$foundation_release", "()Lkotlinx/coroutines/Job;", "setJob$foundation_release", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "isActive$foundation_release", "()Z", "_scrollDeltaBetweenPasses", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "updateScrollDeltaForApproach", "", "delta", "density", "Landroidx/compose/ui/unit/Density;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "updateScrollDeltaForApproach$foundation_release", "stop", "stop$foundation_release", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutScrollDeltaBetweenPasses {
    public static final int $stable = 8;
    private AnimationState<Float, AnimationVector1D> _scrollDeltaBetweenPasses;
    private Job job;

    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return this._scrollDeltaBetweenPasses.getValue().floatValue();
    }

    public final boolean isActive$foundation_release() {
        if (this._scrollDeltaBetweenPasses.getValue().floatValue() != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L7:
        return !r0;
    L5:
        r0 = false;
        goto L7
    }

    public final void stop$foundation_release() {
        Job r0 = this.job;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this._scrollDeltaBetweenPasses = new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(MenuKt.ClosedAlphaTarget), null, 0, 0, false, 60, null);
    }

    public LazyLayoutScrollDeltaBetweenPasses() {
        TwoWayConverter<Float, AnimationVector1D> r1 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Float r3 = Float.valueOf(MenuKt.ClosedAlphaTarget);
        this._scrollDeltaBetweenPasses = AnimationStateKt.AnimationState$default(r1, r3, r3, 0, 0, false, 56, null);
    }

    public final Job getJob$foundation_release() {
        return this.job;
    }

    public static final /* synthetic */ AnimationState access$get_scrollDeltaBetweenPasses$p(LazyLayoutScrollDeltaBetweenPasses r0) {
        return r0._scrollDeltaBetweenPasses;
    }

    public final void setJob$foundation_release(Job r1) {
        this.job = r1;
    }

    public final void updateScrollDeltaForApproach$foundation_release(float r25, Density r26, CoroutineScope r27) {
        if (r25 > r26.toPx-0680j_4(LazyLayoutScrollDeltaBetweenPassesKt.access$getDeltaThresholdForScrollAnimation$p())) goto L5;
        return;
    L5:
        Snapshot.Companion r2 = Snapshot.Companion;
        Snapshot r3 = r2.getCurrentThreadSnapshot();
        if (r3 == null) goto L8;
        Function1 r5 = r3.getReadObserver();
    L9:
        Snapshot r6 = r2.makeCurrentNonObservable(r3);
        float r7 = this._scrollDeltaBetweenPasses.getValue().floatValue();     // Catch: Throwable -> L20
        Job r8 = this.job;     // Catch: Throwable -> L20
        if (r8 == null) goto L14;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);     // Catch: Throwable -> L20
    L14:
        if (this._scrollDeltaBetweenPasses.isRunning() == false) goto L16;
        this._scrollDeltaBetweenPasses = AnimationStateKt.copy$default(this._scrollDeltaBetweenPasses, r7 - r25, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);     // Catch: Throwable -> L20
    L17:
        this.job = BuildersKt.launch$default(r27, null, null, new LazyLayoutScrollDeltaBetweenPasses$updateScrollDeltaForApproach$2$1(this, null), 3, null);     // Catch: Throwable -> L20
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r2.restoreNonObservable(r3, r6, r5);
        return;
    L16:
        this._scrollDeltaBetweenPasses = new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(-r25), null, 0, 0, false, 60, null);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r2.restoreNonObservable(r3, r6, r5);
        throw th;
    L8:
        r5 = null;
        goto L9
    }
}
