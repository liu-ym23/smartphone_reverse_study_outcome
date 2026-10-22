package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1", f = "WideNavigationRail.kt", i = {0}, l = {561}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
public final class DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Boolean> $channel;
    final /* synthetic */ ModalWideNavigationRailState $modalState;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1$1", f = "WideNavigationRail.kt", i = {}, l = {565, 567}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ModalWideNavigationRailState $modalState;
        final /* synthetic */ boolean $newTarget;
        int label;

        public AnonymousClass1(boolean r1, ModalWideNavigationRailState r2, Continuation<? super AnonymousClass1> r3) {
            this.$newTarget = r1;
            this.$modalState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$newTarget, this.$modalState, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r5);
            if (this.$newTarget == false) goto L15;
            ModalWideNavigationRailState r6 = this.$modalState;
            this.label = 1;
            if (r6.expand(this) != r0) goto L19;
            return r0;
        L15:
            ModalWideNavigationRailState r7 = this.$modalState;
            this.label = 2;
            if (r7.collapse(this) != r0) goto L19;
            return r0;
        }
    }

    public DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(Channel<Boolean> r1, ModalWideNavigationRailState r2, Continuation<? super DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1> r3) {
        this.$channel = r1;
        this.$modalState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 r0 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(this.$channel, this.$modalState, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003f -> B:13:0x0044). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r10 = r3;
        ChannelIterator r4 = r2;
        Object r5 = r0;
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 r6 = this;
    L14:
        if (((Boolean) r12).booleanValue() == false) goto L20;
        boolean r13 = ((Boolean) r4.next()).booleanValue();
        Boolean r7 = (Boolean) kotlinx.coroutines.channels.g.b(r6.$channel.tryReceive-PtdJZtk());
        if (r7 == null) goto L18;
        r13 = r7.booleanValue();
    L18:
        AnonymousClass1 r8 = new AnonymousClass1(r13, r6.$modalState, null);
        BuildersKt.launch$default(r10, null, null, r8, 3, null);
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 r14 = r6;
        r0 = r5;
        ChannelIterator r9 = r4;
        CoroutineScope r11 = r10;
    L9:
        r14.L$0 = r11;
        r14.L$1 = r9;
        r14.label = 1;
        Object r15 = r9.hasNext(r14);
        if (r15 != r0) goto L12;
        return r0;
    L12:
        r10 = r11;
        r4 = r9;
        r5 = r0;
        r6 = r14;
        r12 = r15;
        goto L14
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        r9 = this.$channel.iterator();
        r11 = r16;
        r14 = this;
        goto L9
    }
}
