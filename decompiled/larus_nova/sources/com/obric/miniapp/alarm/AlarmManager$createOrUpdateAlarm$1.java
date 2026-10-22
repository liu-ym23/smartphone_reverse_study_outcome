package com.obric.miniapp.alarm;

import java.util.LinkedHashMap;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$createOrUpdateAlarm$1", f = "AlarmManager.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
final class AlarmManager$createOrUpdateAlarm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Map<String, String> $extraInfo;
    final /* synthetic */ String $id;
    final /* synthetic */ long $intervalMinutes;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ int $repeatCount;
    final /* synthetic */ String $title;
    final /* synthetic */ w $triggerTime;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlarmManager$createOrUpdateAlarm$1(String r100, String r101, String r102, w r103, long r104, int r105, Function1<? super Boolean, Unit> r106, Map<String, String> r107, Continuation<? super AlarmManager$createOrUpdateAlarm$1> r110) {
        this.$id = r100;
        this.$title = r101;
        this.$content = r102;
        this.$triggerTime = r103;
        this.$intervalMinutes = r104;
        this.$repeatCount = r105;
        this.$onResult = r106;
        this.$extraInfo = r107;
        super(2, r110);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new AlarmManager$createOrUpdateAlarm$1(this.$id, this.$title, this.$content, this.$triggerTime, this.$intervalMinutes, this.$repeatCount, this.$onResult, this.$extraInfo, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AlarmManager$createOrUpdateAlarm$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L8;
        ResultKt.throwOnFailure(r110);     // Catch: Exception -> L15
    L13:
        this.$onResult.invoke(Boxing.boxBoolean(true));     // Catch: Exception -> L15
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
        AlarmManager r102 = AlarmManager.f397387a;     // Catch: Exception -> L15
        String r103 = this.$id;     // Catch: Exception -> L15
        String r104 = this.$title;     // Catch: Exception -> L15
        String r105 = this.$content;     // Catch: Exception -> L15
        w r106 = this.$triggerTime;     // Catch: Exception -> L15
        LinkedHashMap r107 = new LinkedHashMap();     // Catch: Exception -> L15
        r107.putAll(this.$extraInfo);     // Catch: Exception -> L15
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L15
        long r108 = this.$intervalMinutes;     // Catch: Exception -> L15
        int r112 = this.$repeatCount;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        if (AlarmManager.a(r102, r103, r104, r105, r106, r107, r108, r112, this) != r100) goto L13;
        return r100;
    L15:
        this.$onResult.invoke(Boxing.boxBoolean(false));
        goto L17
    }
}
