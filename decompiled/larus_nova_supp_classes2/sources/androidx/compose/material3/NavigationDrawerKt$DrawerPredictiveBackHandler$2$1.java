package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1", f = "NavigationDrawer.kt", i = {}, l = {957, 983, 983, 983}, m = "invokeSuspend", n = {}, s = {})
public final class NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceGrow;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceShrink;
    final /* synthetic */ Ref.FloatRef $maxScaleYDistance;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1$2", f = "NavigationDrawer.kt", i = {}, l = {974}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
        int label;

        public AnonymousClass2(DrawerPredictiveBackState r1, Continuation<? super AnonymousClass2> r2) {
            this.$drawerPredictiveBackState = r1;
            super(2, r2);
        }

        public static /* synthetic */ Unit a(DrawerPredictiveBackState r0, float r1, float r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$drawerPredictiveBackState, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            this.$drawerPredictiveBackState.clear();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            float r3 = this.$drawerPredictiveBackState.getScaleXDistance();
            final DrawerPredictiveBackState r13 = this.$drawerPredictiveBackState;
            Function2 r7 = new jh(r13);
            this.label = 1;
            if (SuspendAnimationKt.animate$default(r3, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, r7, this, 12, null) != r0) goto L11;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(DrawerPredictiveBackState r0, float r1, float r2) {
            r0.setScaleXDistance(r1);
            return Unit.INSTANCE;
        }
    }

    public NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(DrawerPredictiveBackState r1, CoroutineScope r2, DrawerState r3, boolean r4, Ref.FloatRef r5, Ref.FloatRef r6, Ref.FloatRef r7, Continuation<? super NavigationDrawerKt$DrawerPredictiveBackHandler$2$1> r8) {
        this.$drawerPredictiveBackState = r1;
        this.$scope = r2;
        this.$drawerState = r3;
        this.$isRtl = r4;
        this.$maxScaleXDistanceGrow = r5;
        this.$maxScaleXDistanceShrink = r6;
        this.$maxScaleYDistance = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 r9 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(this.$drawerPredictiveBackState, this.$scope, this.$drawerState, this.$isRtl, this.$maxScaleXDistanceGrow, this.$maxScaleXDistanceShrink, this.$maxScaleYDistance, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Flow) r1, (Continuation) r2);
    }

    public final Object invoke(Flow<BackEventCompat> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L9;
        Throwable r2 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r14);
        throw r2;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r14);
    L34:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14 CancellationException -> L26
    L20:
        if (this.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() == false) goto L23;
        BuildersKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$drawerPredictiveBackState, null), 3, null);
    L23:
        DrawerState r15 = this.$drawerState;
        this.label = 2;
        if (r15.close(this) != r0) goto L34;
        return r0;
    L16:
        ResultKt.throwOnFailure(r14);
        Flow r16 = (Flow) this.L$0;
        final DrawerPredictiveBackState r8 = this.$drawerPredictiveBackState;     // Catch: Throwable -> L14 CancellationException -> L26
        final boolean r9 = this.$isRtl;     // Catch: Throwable -> L14 CancellationException -> L26
        final Ref.FloatRef r10 = this.$maxScaleXDistanceGrow;     // Catch: Throwable -> L14 CancellationException -> L26
        final Ref.FloatRef r11 = this.$maxScaleXDistanceShrink;     // Catch: Throwable -> L14 CancellationException -> L26
        final Ref.FloatRef r12 = this.$maxScaleYDistance;     // Catch: Throwable -> L14 CancellationException -> L26
        FlowCollector r3 = new AnonymousClass1(r8, r9, r10, r11, r12);     // Catch: Throwable -> L14 CancellationException -> L26
        this.label = 1;     // Catch: Throwable -> L14 CancellationException -> L26
        if (r16.collect(r3, this) != r0) goto L20;
        return r0;
    L26:
        this.$drawerPredictiveBackState.clear();     // Catch: Throwable -> L14
        if (this.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() == false) goto L30;
        BuildersKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$drawerPredictiveBackState, null), 3, null);
    L30:
        DrawerState r17 = this.$drawerState;
        this.label = 3;
        if (r17.close(this) != r0) goto L34;
        return r0;
    L14:
        th = move-exception;
        if (this.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() == false) goto L38;
        BuildersKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$drawerPredictiveBackState, null), 3, null);
    L38:
        DrawerState r4 = this.$drawerState;
        this.L$0 = th;
        this.label = 4;
        if (r4.close(this) != r0) goto L42;
        return r0;
    L42:
        throw th;
    }
}
