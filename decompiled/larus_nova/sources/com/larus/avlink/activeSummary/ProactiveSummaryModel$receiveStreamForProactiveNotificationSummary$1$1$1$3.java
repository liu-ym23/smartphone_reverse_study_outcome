package com.larus.avlink.activeSummary;

import android.os.SystemClock;
import com.larus.avlink.n1;
import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chunkPackage", "Lcom/larus/avlink/activeSummary/ChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3", f = "ProactiveSummaryModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
    final /* synthetic */ BufferedReader $br;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProactiveSummaryModel this$0;

    public ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3(ProactiveSummaryModel r100, BufferedReader r101, Continuation<? super ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3> r102) {
        this.this$0 = r100;
        this.$br = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3 r102 = new ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3(this.this$0, this.$br, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(a r100, Continuation<? super Unit> r101) {
        return ((ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(a r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r100);
        a r101 = (a) this.L$0;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] ChunkParser.parseStream " + r101.f291447b + " -> " + r101.f291448c);
        if (Intrinsics.areEqual(r101.f291447b, "done") == false) goto L16;
        this.this$0.f291423b = false;
        if (this.this$0.f291425d == true) goto L9;
    L11:
        boolean r102 = false;
    L12:
        this.this$0.f291425d = false;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receive END package");
        this.$br.close();
        if (r102 == false) goto L24;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:SSE_DONE_Reconnect: reconnect after done....");
        this.this$0.h("SSE_DONE_Reconnect", false);
    L24:
        return Unit.INSTANCE;
    L9:
        if (SystemClock.elapsedRealtime() >= this.this$0.f291424c) goto L11;
        r102 = true;
        goto L12
    L16:
        if (Intrinsics.areEqual(r101.f291447b, "json") == false) goto L24;
        JSONObject r103 = new JSONObject(r101.f291448c);
        String r104 = r103.optString("command_name", "");
        if (Intrinsics.areEqual(r104, "dora_notification_summary") == false) goto L21;
        String r105 = r103.optString("summary_id", "");
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] onNotificationSummaryGenerated summaryId ---> " + r105);
        ProactiveSummaryModel r106 = this.this$0;
        Intrinsics.checkNotNull(r105);
        r106.d(r105, ProactiveSummarySource.SSE_FRONTIER);
        goto L24
    L21:
        if (Intrinsics.areEqual(r104, "dora_auto_greet") == false) goto L24;
        String r107 = r103.optString("summary_id", "");
        n1.a("ProactiveSummaryRecords", "[AutoGreetTracer] onAutoGreetReceived summaryId ---> " + r107);
        ProactiveSummaryModel r108 = this.this$0;
        Intrinsics.checkNotNull(r107);
        r108.d(r107, ProactiveSummarySource.SSE_FRONTIER);
        goto L24
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
