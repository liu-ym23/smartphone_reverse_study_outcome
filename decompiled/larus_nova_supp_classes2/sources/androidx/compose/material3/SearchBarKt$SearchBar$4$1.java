package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarKt$SearchBar$4$1", f = "SearchBar.kt", i = {}, l = {570}, m = "invokeSuspend", n = {}, s = {})
public final class SearchBarKt$SearchBar$4$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutatorMutex $mutatorMutex;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarKt$SearchBar$4$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SearchBarKt$SearchBar$4$1$1", f = "SearchBar.kt", i = {}, l = {573}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
        final /* synthetic */ MutableFloatState $finalBackProgress;
        final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
        final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
        final /* synthetic */ Flow<BackEventCompat> $progress;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material3.SearchBarKt$SearchBar$4$1$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SearchBarKt$SearchBar$4$1$1$2", f = "SearchBar.kt", i = {}, l = {585}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
            final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
            final /* synthetic */ MutableFloatState $finalBackProgress;
            final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
            int label;

            public AnonymousClass2(Animatable<Float, AnimationVector1D> r1, MutableFloatState r2, MutableState<BackEventCompat> r3, MutableState<BackEventCompat> r4, Continuation<? super AnonymousClass2> r5) {
                this.$animationProgress = r1;
                this.$finalBackProgress = r2;
                this.$firstBackEvent = r3;
                this.$currentBackEvent = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new AnonymousClass2(this.$animationProgress, this.$finalBackProgress, this.$firstBackEvent, this.$currentBackEvent, r8);
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
            L11:
                this.$finalBackProgress.setFloatValue(Float.NaN);
                this.$firstBackEvent.setValue(null);
                this.$currentBackEvent.setValue(null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                Animatable<Float, AnimationVector1D> r2 = this.$animationProgress;
                Float r11 = Boxing.boxFloat(1.0f);
                FiniteAnimationSpec r3 = SearchBarKt.access$getAnimationPredictiveBackExitFloatSpec$p();
                this.label = 1;
                if (Animatable.animateTo$default(r2, r11, r3, null, null, this, 12, null) != r0) goto L11;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(MutableFloatState r1, Flow<BackEventCompat> r2, Animatable<Float, AnimationVector1D> r3, Function1<? super Boolean, Unit> r4, CoroutineScope r5, MutableState<BackEventCompat> r6, MutableState<BackEventCompat> r7, Continuation<? super AnonymousClass1> r8) {
            this.$finalBackProgress = r1;
            this.$progress = r2;
            this.$animationProgress = r3;
            this.$onExpandedChange = r4;
            this.$coroutineScope = r5;
            this.$firstBackEvent = r6;
            this.$currentBackEvent = r7;
            super(1, r8);
        }

        public final Continuation<Unit> create(Continuation<?> r11) {
            return new AnonymousClass1(this.$finalBackProgress, this.$progress, this.$animationProgress, this.$onExpandedChange, this.$coroutineScope, this.$firstBackEvent, this.$currentBackEvent, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r11);     // Catch: CancellationException -> L15
        L13:
            this.$finalBackProgress.setFloatValue(this.$animationProgress.getValue().floatValue());     // Catch: CancellationException -> L15
            this.$onExpandedChange.invoke(Boxing.boxBoolean(false));     // Catch: CancellationException -> L15
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
            this.$finalBackProgress.setFloatValue(Float.NaN);     // Catch: CancellationException -> L15
            Flow<BackEventCompat> r12 = this.$progress;     // Catch: CancellationException -> L15
            final MutableState<BackEventCompat> r3 = this.$firstBackEvent;     // Catch: CancellationException -> L15
            final MutableState<BackEventCompat> r4 = this.$currentBackEvent;     // Catch: CancellationException -> L15
            final Animatable<Float, AnimationVector1D> r5 = this.$animationProgress;     // Catch: CancellationException -> L15
            FlowCollector r2 = new C00701(r3, r4, r5);     // Catch: CancellationException -> L15
            this.label = 1;     // Catch: CancellationException -> L15
            if (r12.collect(r2, this) != r0) goto L13;
            return r0;
        L15:
            BuildersKt.launch$default(this.$coroutineScope, null, null, new AnonymousClass2(this.$animationProgress, this.$finalBackProgress, this.$firstBackEvent, this.$currentBackEvent, null), 3, null);
            goto L17
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchBarKt$SearchBar$4$1(MutatorMutex r1, MutableFloatState r2, Animatable<Float, AnimationVector1D> r3, Function1<? super Boolean, Unit> r4, CoroutineScope r5, MutableState<BackEventCompat> r6, MutableState<BackEventCompat> r7, Continuation<? super SearchBarKt$SearchBar$4$1> r8) {
        this.$mutatorMutex = r1;
        this.$finalBackProgress = r2;
        this.$animationProgress = r3;
        this.$onExpandedChange = r4;
        this.$coroutineScope = r5;
        this.$firstBackEvent = r6;
        this.$currentBackEvent = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        SearchBarKt$SearchBar$4$1 r9 = new SearchBarKt$SearchBar$4$1(this.$mutatorMutex, this.$finalBackProgress, this.$animationProgress, this.$onExpandedChange, this.$coroutineScope, this.$firstBackEvent, this.$currentBackEvent, r12);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        Flow r5 = (Flow) this.L$0;
        MutatorMutex r15 = this.$mutatorMutex;
        AnonymousClass1 r12 = new AnonymousClass1(this.$finalBackProgress, r5, this.$animationProgress, this.$onExpandedChange, this.$coroutineScope, this.$firstBackEvent, this.$currentBackEvent, null);
        this.label = 1;
        if (MutatorMutex.mutate$default(r15, null, r12, this, 1, null) != r0) goto L12;
        return r0;
    }
}
