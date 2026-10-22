package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0000¢\u0006\u0002\b9J\u0015\u0010:\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b?J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\tH\u0002J\b\u0010E\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\n\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0017\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u000fR+\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010%R+\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010'\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010%R+\u0010,\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010%R+\u00100\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010%R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "progress", "getProgress", "()F", "refreshing", "", "getRefreshing$material", "()Z", "position", "getPosition$material", "getThreshold$material", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "_refreshing", "get_refreshing", "set_refreshing", "(Z)V", "_refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "_position", "get_position", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableFloatState;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "_threshold", "get_threshold", "set_threshold", "_threshold$delegate", "_refreshingOffset", "get_refreshingOffset", "set_refreshingOffset", "_refreshingOffset$delegate", "onPull", "pullDelta", "onPull$material", "onRelease", "velocity", "onRelease$material", "setRefreshing", "setRefreshing$material", "setThreshold", "setThreshold$material", "setRefreshingOffset", "setRefreshingOffset$material", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", "offset", "calculateIndicatorPosition", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshState {
    public static final int $stable = 8;
    private final MutableFloatState _position$delegate;
    private final MutableState _refreshing$delegate;
    private final MutableFloatState _refreshingOffset$delegate;
    private final MutableFloatState _threshold$delegate;
    private final State adjustedDistancePulled$delegate;
    private final CoroutineScope animationScope;
    private final MutableFloatState distancePulled$delegate;
    private final MutatorMutex mutatorMutex;
    private final State<Function0<Unit>> onRefreshState;

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1", f = "PullRefreshState.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $offset;
        int label;
        final /* synthetic */ PullRefreshState this$0;

        /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1", f = "PullRefreshState.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00621 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ float $offset;
            int label;
            final /* synthetic */ PullRefreshState this$0;

            public C00621(PullRefreshState r1, float r2, Continuation<? super C00621> r3) {
                this.this$0 = r1;
                this.$offset = r2;
                super(1, r3);
            }

            public static /* synthetic */ Unit a(PullRefreshState r0, float r1, float r2) {
                return invokeSuspend$lambda$0(r0, r1, r2);
            }

            public final Continuation<Unit> create(Continuation<?> r4) {
                return new C00621(this.this$0, this.$offset, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r12) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r12);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r12);
                float r3 = PullRefreshState.access$get_position(this.this$0);
                float r4 = this.$offset;
                final PullRefreshState r13 = this.this$0;
                Function2 r7 = new j(r13);
                this.label = 1;
                if (SuspendAnimationKt.animate$default(r3, r4, MenuKt.ClosedAlphaTarget, null, r7, this, 12, null) != r0) goto L12;
                return r0;
            }

            private static final Unit invokeSuspend$lambda$0(PullRefreshState r0, float r1, float r2) {
                PullRefreshState.access$set_position(r0, r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(PullRefreshState r1, float r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$offset = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$offset, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            MutatorMutex r3 = PullRefreshState.access$getMutatorMutex$p(this.this$0);
            C00621 r5 = new C00621(this.this$0, this.$offset, null);
            this.label = 1;
            if (MutatorMutex.mutate$default(r3, null, r5, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ float a(PullRefreshState r0) {
        return adjustedDistancePulled_delegate$lambda$0(r0);
    }

    private final float getAdjustedDistancePulled() {
        return ((Number) this.adjustedDistancePulled$delegate.getValue()).floatValue();
    }

    private final float getDistancePulled() {
        return this.distancePulled$delegate.getFloatValue();
    }

    private final float get_position() {
        return this._position$delegate.getFloatValue();
    }

    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing$delegate.getValue()).booleanValue();
    }

    private final float get_refreshingOffset() {
        return this._refreshingOffset$delegate.getFloatValue();
    }

    private final float get_threshold() {
        return this._threshold$delegate.getFloatValue();
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() <= getThreshold$material()) goto L13;
        float r0 = Math.abs(getProgress()) - 1.0f;
        if (r0 >= MenuKt.ClosedAlphaTarget) goto L9;
        r0 = MenuKt.ClosedAlphaTarget;
    L9:
        if (r0 <= 2.0f) goto L12;
        r0 = 2.0f;
    L12:
        return getThreshold$material() + (getThreshold$material() * (r0 - (((float) Math.pow(r0, 2)) / 4)));
    L13:
        return getAdjustedDistancePulled();
    }

    public final float getPosition$material() {
        return get_position();
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / getThreshold$material();
    }

    public final boolean getRefreshing$material() {
        return get_refreshing();
    }

    public final float getThreshold$material() {
        return get_threshold();
    }

    public static final /* synthetic */ MutatorMutex access$getMutatorMutex$p(PullRefreshState r0) {
        return r0.mutatorMutex;
    }

    public static final /* synthetic */ float access$get_position(PullRefreshState r0) {
        return r0.get_position();
    }

    private static final float adjustedDistancePulled_delegate$lambda$0(PullRefreshState r1) {
        return r1.getDistancePulled() * 0.5f;
    }

    private final Job animateIndicatorTo(float r7) {
        return BuildersKt.launch$default(this.animationScope, null, null, new AnonymousClass1(this, r7, null), 3, null);
    }

    private final void setDistancePulled(float r2) {
        this.distancePulled$delegate.setFloatValue(r2);
    }

    private final void set_position(float r2) {
        this._position$delegate.setFloatValue(r2);
    }

    private final void set_refreshing(boolean r2) {
        this._refreshing$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void set_refreshingOffset(float r2) {
        this._refreshingOffset$delegate.setFloatValue(r2);
    }

    private final void set_threshold(float r2) {
        this._threshold$delegate.setFloatValue(r2);
    }

    public final float onPull$material(float r3) {
        if (get_refreshing() == false) goto L5;
        return MenuKt.ClosedAlphaTarget;
    L5:
        float r4 = RangesKt.coerceAtLeast(getDistancePulled() + r3, MenuKt.ClosedAlphaTarget);
        float r0 = r4 - getDistancePulled();
        setDistancePulled(r4);
        set_position(calculateIndicatorPosition());
        return r0;
    }

    public final float onRelease$material(float r4) {
        if (getRefreshing$material() == false) goto L6;
        return MenuKt.ClosedAlphaTarget;
    L6:
        if (getAdjustedDistancePulled() <= getThreshold$material()) goto L8;
        ((Function0) this.onRefreshState.getValue()).invoke();
    L8:
        animateIndicatorTo(MenuKt.ClosedAlphaTarget);
        if (getDistancePulled() != MenuKt.ClosedAlphaTarget) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
    L13:
        r4 = MenuKt.ClosedAlphaTarget;
    L17:
        setDistancePulled(MenuKt.ClosedAlphaTarget);
        return r4;
    L15:
        if (r4 >= MenuKt.ClosedAlphaTarget) goto L17;
    L11:
        r0 = false;
        goto L12
    }

    public final void setRefreshing$material(boolean r2) {
        if (get_refreshing() == r2) goto L9;
        set_refreshing(r2);
        float r0 = MenuKt.ClosedAlphaTarget;
        setDistancePulled(MenuKt.ClosedAlphaTarget);
        if (r2 == false) goto L7;
        r0 = get_refreshingOffset();
    L7:
        animateIndicatorTo(r0);
        return;
    }

    public final void setRefreshingOffset$material(float r2) {
        if (get_refreshingOffset() != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L11;
        set_refreshingOffset(r2);
        if (getRefreshing$material() == false) goto L12;
        animateIndicatorTo(r2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setThreshold$material(float r1) {
        set_threshold(r1);
    }

    public static final /* synthetic */ void access$set_position(PullRefreshState r0, float r1) {
        r0.set_position(r1);
    }

    public PullRefreshState(CoroutineScope r2, State<? extends Function0<Unit>> r3, float r4, float r5) {
        this.animationScope = r2;
        this.onRefreshState = r3;
        this.adjustedDistancePulled$delegate = SnapshotStateKt.derivedStateOf(new i(this));
        this._refreshing$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this._position$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this._threshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r5);
        this._refreshingOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r4);
        this.mutatorMutex = new MutatorMutex();
    }
}
