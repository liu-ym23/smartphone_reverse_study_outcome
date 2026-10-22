package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", i = {0}, l = {418}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
public final class AnimateAsStateKt$animateValueAsState$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
    final /* synthetic */ Animatable<T, V> $animatable;
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1", f = "AnimateAsState.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
        final /* synthetic */ Animatable<T, V> $animatable;
        final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
        final /* synthetic */ T $newTarget;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(T r1, Animatable<T, V> r2, State<? extends AnimationSpec<T>> r3, State<? extends Function1<? super T, Unit>> r4, Continuation<? super AnonymousClass1> r5) {
            this.$newTarget = r1;
            this.$animatable = r2;
            this.$animSpec$delegate = r3;
            this.$listener$delegate = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, r8);
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
        L13:
            Function1 r13 = AnimateAsStateKt.access$animateValueAsState$lambda$4(this.$listener$delegate);
            if (r13 == null) goto L17;
            r13.invoke(this.$animatable.getValue());
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            if (Intrinsics.areEqual(this.$newTarget, this.$animatable.getTargetValue()) == true) goto L17;
            Animatable<T, V> r3 = this.$animatable;
            T r4 = this.$newTarget;
            AnimationSpec r5 = AnimateAsStateKt.access$animateValueAsState$lambda$6(this.$animSpec$delegate);
            this.label = 1;
            if (Animatable.animateTo$default(r3, r4, r5, null, null, this, 12, null) != r0) goto L13;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnimateAsStateKt$animateValueAsState$3$1(Channel<T> r1, Animatable<T, V> r2, State<? extends AnimationSpec<T>> r3, State<? extends Function1<? super T, Unit>> r4, Continuation<? super AnimateAsStateKt$animateValueAsState$3$1> r5) {
        this.$channel = r1;
        this.$animatable = r2;
        this.$animSpec$delegate = r3;
        this.$listener$delegate = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        AnimateAsStateKt$animateValueAsState$3$1 r6 = new AnimateAsStateKt$animateValueAsState$3$1(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0041 -> B:12:0x0044). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ChannelIterator r3 = (ChannelIterator) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r6 = r18;
        AnimateAsStateKt$animateValueAsState$3$1 r5 = this;
    L13:
        if (((Boolean) r6).booleanValue() == false) goto L20;
        Object r7 = r3.next();
        Object r8 = kotlinx.coroutines.channels.g.b(r5.$channel.tryReceive-PtdJZtk());
        if (r8 != null) goto L17;
        Object r9 = r7;
    L18:
        CoroutineScope r10 = r4;
        BuildersKt.launch$default(r10, null, null, new AnonymousClass1(r9, r5.$animatable, r5.$animSpec$delegate, r5.$listener$delegate, null), 3, null);
    L9:
        r5.L$0 = r4;
        r5.L$1 = r3;
        r5.label = 1;
        r6 = r3.hasNext(r5);
        if (r6 != r1) goto L13;
        return r1;
    L17:
        r9 = r8;
        goto L18
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ChannelIterator r12 = this.$channel.iterator();
        r5 = this;
        r4 = r11;
        r3 = r12;
        goto L9
    }
}
