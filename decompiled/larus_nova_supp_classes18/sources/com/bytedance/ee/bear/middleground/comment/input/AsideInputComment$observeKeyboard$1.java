package com.bytedance.ee.bear.middleground.comment.input;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.input.AsideInputComment$observeKeyboard$1", f = "AsideInputComment.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
final class AsideInputComment$observeKeyboard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Integer> $keyboardHeightChangeChannel;
    final /* synthetic */ Lazy<ocb.a> $keyboardHeightObserver$delegate;
    int label;
    final /* synthetic */ AsideInputComment this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.AsideInputComment$observeKeyboard$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.input.AsideInputComment$observeKeyboard$1$1", f = "AsideInputComment.kt", i = {0, 1, 1, 2}, l = {434, 435, 438}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "keyboardPosInScreen", "$this$flow"}, s = {"L$0", "L$0", "I$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Integer> $keyboardHeightChangeChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AsideInputComment this$0;

        public AnonymousClass1(Channel<Integer> r1, AsideInputComment r2, Continuation<? super AnonymousClass1> r3) {
            this.$keyboardHeightChangeChannel = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$keyboardHeightChangeChannel, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super Integer> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ChannelIterator r2 = (ChannelIterator) this.L$1;
            FlowCollector r5 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r11);
        L13:
            AnonymousClass1 r12 = this;
        L14:
            r12.L$0 = r5;
            r12.L$1 = r2;
            r12.label = 1;
            Object r6 = r2.hasNext(r12);
            if (r6 != r0) goto L17;
            return r0;
        L17:
            Object r9 = r0;
            AnonymousClass1 r3 = r12;
            r11 = r6;
            FlowCollector r7 = r5;
            ChannelIterator r8 = r2;
            Object r4 = r9;
        L19:
            if (((Boolean) r11).booleanValue() == false) goto L31;
            int r13 = ((Number) r8.next()).intValue();
            r3.L$0 = r7;
            r3.L$1 = r8;
            r3.I$0 = r13;
            r3.label = 2;
            if (DelayKt.delay(100, r3) != r4) goto L23;
            return r4;
        L23:
            Object r10 = r4;
            int r14 = r13;
            r12 = r3;
            r0 = r10;
        L24:
            float r15 = com.bytedance.ee.util.ui.n.b(r12.this$0.k).bottom;
            float r16 = r14;
            if (r15 <= r16) goto L29;
            Integer r17 = Boxing.boxInt(((int) (r15 - r16)) + AsideInputComment.t0);
            r12.L$0 = r7;
            r12.L$1 = r8;
            r12.label = 3;
            if (r7.emit(r17, r12) != r0) goto L29;
            return r0;
        L29:
            r2 = r8;
            r5 = r7;
            goto L14
        L32:
            r2 = r8;
            r5 = r7;
            goto L14
        L31:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r14 = this.I$0;
            r8 = (ChannelIterator) this.L$1;
            r7 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r11);
            r12 = this;
            goto L24
        L11:
            ChannelIterator r18 = (ChannelIterator) this.L$1;
            FlowCollector r19 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r11);
            r7 = r19;
            r8 = r18;
            r4 = r0;
            r3 = this;
            goto L19
        L12:
            ResultKt.throwOnFailure(r11);
            FlowCollector r110 = (FlowCollector) this.L$0;
            r2 = this.$keyboardHeightChangeChannel.iterator();
            r5 = r110;
            goto L13
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ AsideInputComment a;

        public a(AsideInputComment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = ((Number) r1).intValue();
            if (this.a.e().hasFocus() == false) goto L6;
            this.a.h0.invoke(Boxing.boxInt(r3));
        L6:
            return Unit.INSTANCE;
        }
    }

    public AsideInputComment$observeKeyboard$1(AsideInputComment r1, Lazy<? extends ocb.a> r2, Channel<Integer> r3, Continuation<? super AsideInputComment$observeKeyboard$1> r4) {
        this.this$0 = r1;
        this.$keyboardHeightObserver$delegate = r2;
        this.$keyboardHeightChangeChannel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AsideInputComment$observeKeyboard$1(this.this$0, this.$keyboardHeightObserver$delegate, this.$keyboardHeightChangeChannel, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        pcb.a r7 = this.this$0.a.r;
        Lazy<ocb.a> r2 = this.$keyboardHeightObserver$delegate;
        int r3 = AsideInputComment.t0;
        r7.c((ocb.a) r2.getValue());
        Flow r8 = kotlinx.coroutines.flow.e.m(new kotlinx.coroutines.flow.c1(new AnonymousClass1(this.$keyboardHeightChangeChannel, this.this$0, null)), 100);
        a r4 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
