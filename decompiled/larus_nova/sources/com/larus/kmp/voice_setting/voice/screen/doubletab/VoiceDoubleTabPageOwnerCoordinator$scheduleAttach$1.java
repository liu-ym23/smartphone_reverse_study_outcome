package com.larus.kmp.voice_setting.voice.screen.doubletab;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.screen.doubletab.VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1", f = "VoiceDoubleTabPageOwnerCoordinator.kt", i = {1}, l = {83, 93}, m = "invokeSuspend", n = {"index$iv"}, s = {"I$0"})
final class VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.kmp.voice_setting.voice.component.v4 $args;
    final /* synthetic */ Function2<Integer, String, Unit> $attachPageOwner;
    final /* synthetic */ Function0<Integer> $currentArgsHash;
    final /* synthetic */ Function1<com.larus.kmp.voice_setting.voice.component.v4, Boolean> $isCurrentArgs;
    final /* synthetic */ List<Integer> $order;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ e5 this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1(List<Integer> r100, e5 r101, Function1<? super com.larus.kmp.voice_setting.voice.component.v4, Boolean> r102, com.larus.kmp.voice_setting.voice.component.v4 r103, Function0<Integer> r104, Function2<? super Integer, ? super String, Unit> r105, Continuation<? super VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1> r106) {
        this.$order = r100;
        this.this$0 = r101;
        this.$isCurrentArgs = r102;
        this.$args = r103;
        this.$currentArgsHash = r104;
        this.$attachPageOwner = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        return new VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1(this.$order, this.this$0, this.$isCurrentArgs, this.$args, this.$currentArgsHash, this.$attachPageOwner, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        int r102 = this.I$0;
        Iterator r103 = (Iterator) this.L$5;
        Function2<Integer, String, Unit> r104 = (Function2) this.L$4;
        Function0<Integer> r105 = (Function0) this.L$3;
        e5 r106 = (e5) this.L$2;
        com.larus.kmp.voice_setting.voice.component.v4 r107 = (com.larus.kmp.voice_setting.voice.component.v4) this.L$1;
        Function1<com.larus.kmp.voice_setting.voice.component.v4, Boolean> r108 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r110);
        int r109 = r102;
        Function1<com.larus.kmp.voice_setting.voice.component.v4, Boolean> r111 = r108;
    L15:
        if (r103.hasNext() == false) goto L27;
        Object r112 = r103.next();
        int r113 = r109 + 1;
        if (r109 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        int r114 = ((Number) r112).intValue();
        if (r111.invoke(r107).booleanValue() == false) goto L21;
        r104.invoke(Boxing.boxInt(r114), "scheduled_" + r109);
        this.L$0 = r111;
        this.L$1 = r107;
        this.L$2 = r106;
        this.L$3 = r105;
        this.L$4 = r104;
        this.L$5 = r103;
        this.I$0 = r113;
        this.label = 2;
        if (kotlinx.coroutines.f2.a(this) == r100) goto L25;
        r109 = r113;
        goto L15
    L25:
        return r100;
    L21:
        r106.f354272a.invoke("[entryPerf:ownerAttach:stale] orderIndex=" + r109 + " pageIndex=" + r114 + " argsHash=" + r107.hashCode() + " currentArgsHash=" + r105.invoke());
        return Unit.INSTANCE;
    L27:
        this.this$0.f354274c = null;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
    L13:
        List<Integer> r115 = this.$order;
        Function1<com.larus.kmp.voice_setting.voice.component.v4, Boolean> r116 = this.$isCurrentArgs;
        com.larus.kmp.voice_setting.voice.component.v4 r117 = this.$args;
        e5 r118 = this.this$0;
        Function0<Integer> r119 = this.$currentArgsHash;
        Function2<Integer, String, Unit> r120 = this.$attachPageOwner;
        r109 = 0;
        r103 = r115.iterator();
        r111 = r116;
        r107 = r117;
        r104 = r120;
        r106 = r118;
        r105 = r119;
        goto L15
    L10:
        ResultKt.throwOnFailure(r110);
        this.label = 1;
        if (kotlinx.coroutines.f2.a(this) != r100) goto L13;
        return r100;
    }
}
