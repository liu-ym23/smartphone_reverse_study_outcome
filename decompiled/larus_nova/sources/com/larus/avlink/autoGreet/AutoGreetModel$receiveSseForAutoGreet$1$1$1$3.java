package com.larus.avlink.autoGreet;

import java.io.BufferedReader;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chunkPackage", "Lcom/larus/avlink/activeSummary/ChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.autoGreet.AutoGreetModel$receiveSseForAutoGreet$1$1$1$3", f = "AutoGreetModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AutoGreetModel$receiveSseForAutoGreet$1$1$1$3 extends SuspendLambda implements Function2<com.larus.avlink.activeSummary.a, Continuation<? super Unit>, Object> {
    final /* synthetic */ BufferedReader $br;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AutoGreetModel this$0;

    public AutoGreetModel$receiveSseForAutoGreet$1$1$1$3(AutoGreetModel r100, BufferedReader r101, Continuation<? super AutoGreetModel$receiveSseForAutoGreet$1$1$1$3> r102) {
        this.this$0 = r100;
        this.$br = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AutoGreetModel$receiveSseForAutoGreet$1$1$1$3 r102 = new AutoGreetModel$receiveSseForAutoGreet$1$1$1$3(this.this$0, this.$br, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.larus.avlink.activeSummary.a r100, Continuation<? super Unit> r101) {
        return ((AutoGreetModel$receiveSseForAutoGreet$1$1$1$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(com.larus.avlink.activeSummary.a r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        com.larus.avlink.activeSummary.a r101 = (com.larus.avlink.activeSummary.a) this.L$0;
        Lazy r102 = e.f291674a;
        e.c("ChunkParser.parseStream " + r101.f291447b + " -> " + r101.f291448c);
        String r103 = r101.f291447b;
        int r104 = r103.hashCode();
        if (r104 == 3089282) goto L26;
        if (r104 == 3271912) goto L16;
        if (r104 != 1642639251) goto L29;
        if (r103.equals("keep_alive") == false) goto L29;
        e.c("Receive keep_alive package");
    L29:
        return Unit.INSTANCE;
    L16:
        if (r103.equals("json") == false) goto L29;
        AutoGreetModel r105 = this.this$0;
        AutoGreetModel.a r106 = AutoGreetModel.f291651n;
        r105.getClass();
        JSONObject r107 = new JSONObject(r101.f291448c);     // Catch: Exception -> L23
        if (Intrinsics.areEqual(r107.optString("command_name", ""), "dora_auto_greet") == false) goto L29;
        String r108 = r107.optString("summary_id", "");     // Catch: Exception -> L23
        e.c("Received auto greet command, summaryId: " + r108);     // Catch: Exception -> L23
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L23
        r105.i(r108);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.b("handleSseJsonEvent error", e);
        goto L29
    L26:
        if (r103.equals("done") == false) goto L29;
        this.this$0.f291654b = false;
        e.c("Receive END package");
        this.$br.close();
        goto L29
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
