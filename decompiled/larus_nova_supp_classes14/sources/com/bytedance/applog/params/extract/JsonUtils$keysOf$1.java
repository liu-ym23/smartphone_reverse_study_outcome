package com.bytedance.applog.params.extract;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.applog.params.extract.JsonUtils$keysOf$1", f = "JsonUtils.kt", i = {0, 0}, l = {34}, m = "invokeSuspend", n = {"$this$sequence", "it"}, s = {"L$0", "L$1"})
public final class JsonUtils$keysOf$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $obj;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public JsonUtils$keysOf$1(JSONObject r1, Continuation<? super JsonUtils$keysOf$1> r2) {
        this.$obj = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        JsonUtils$keysOf$1 r0 = new JsonUtils$keysOf$1(this.$obj, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super String> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator<String> r2 = (Iterator) this.L$1;
        SequenceScope r3 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L11:
        if (r2.hasNext() == false) goto L16;
        String r4 = r2.next();
        this.L$0 = r3;
        this.L$1 = r2;
        this.label = 1;
        if (r3.yield(r4, this) != r0) goto L11;
        return r0;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SequenceScope r7 = (SequenceScope) this.L$0;
        r2 = this.$obj.keys();
        r3 = r7;
        goto L11
    }
}
