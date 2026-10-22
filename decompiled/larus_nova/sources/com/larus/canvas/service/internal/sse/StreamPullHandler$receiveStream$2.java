package com.larus.canvas.service.internal.sse;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chunkPkg", "Lcom/larus/canvas/service/internal/sse/CanvasChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.StreamPullHandler$receiveStream$2", f = "StreamPullHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class StreamPullHandler$receiveStream$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $dispatcher;
    final /* synthetic */ String $logId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StreamPullHandler this$0;

    public StreamPullHandler$receiveStream$2(e r100, StreamPullHandler r101, String r102, Continuation<? super StreamPullHandler$receiveStream$2> r103) {
        this.$dispatcher = r100;
        this.this$0 = r101;
        this.$logId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        StreamPullHandler$receiveStream$2 r102 = new StreamPullHandler$receiveStream$2(this.$dispatcher, this.this$0, this.$logId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b r100, Continuation<? super Unit> r101) {
        return ((StreamPullHandler$receiveStream$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(b r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        b r101 = (b) this.L$0;
        String r102 = r101.f323860b;
        int r103 = r102.hashCode();
        if (r103 == 3089282) goto L25;
        if (r103 == 3271912) goto L21;
        if (r103 != 96784904) goto L29;
        if (r102.equals("error") == false) goto L29;
        Ref.IntRef r104 = new Ref.IntRef();
        r104.element = -1;
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = "";
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        JSONObject r107 = new JSONObject(r101.f323861c);     // Catch: Throwable -> L17
        r104.element = r107.optInt("status_code");     // Catch: Throwable -> L17
        r105.element = r107.optString("status_msg");     // Catch: Throwable -> L17
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L17
    L19:
        this.$dispatcher.a(new f(1, this.$logId, r104.element, (String) r105.element));
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L29:
        return Unit.INSTANCE;
    L21:
        if (r102.equals("json") == false) goto L29;
        this.$dispatcher.b(r101);
        goto L29
    L25:
        if (r102.equals("done") == false) goto L29;
        FLogger r109 = FLogger.f375446a;
        int r110 = StreamPullHandler.f323848k;
        r109.i("SSEHandler", "Stream Done.");
        this.this$0.f323853e = true;
        this.$dispatcher.a(new f(0, this.$logId, 12));
        goto L29
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
