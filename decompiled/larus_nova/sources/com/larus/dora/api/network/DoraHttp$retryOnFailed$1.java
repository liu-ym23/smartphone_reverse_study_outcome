package com.larus.dora.api.network;

import com.larus.network.http.y;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.api.network.DoraHttp", f = "DoraHttp.kt", i = {0, 0, 0, 0}, l = {168}, m = "retryOnFailed", n = {"$this$retryOnFailed", "times", VideoThumbInfo.KEY_INTERVAL, "currentRetry"}, s = {"L$0", "I$0", "J$0", "I$1"})
final class DoraHttp$retryOnFailed$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public DoraHttp$retryOnFailed$1(a r100, Continuation<? super DoraHttp$retryOnFailed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        a r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        DoraHttp$retryOnFailed$1<T> r101 = this;
    L6:
        Object r112 = r101.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r101.label;
        if (r103 == 0) goto L12;
        if (r103 != 1) goto L11;
        int r104 = r101.I$1;
        long r105 = r101.J$0;
        int r106 = r101.I$0;
        com.larus.network.http.a r107 = (com.larus.network.http.a) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L13:
        if (r104 >= r106) goto L24;
        if ((r107 instanceof y) == true) goto L31;
        r104 = r104 + 1;
        if (r104 >= r106) goto L24;
        r101.L$0 = r107;
        r101.I$0 = r106;
        r101.J$0 = r105;
        r101.I$1 = r104;
        r101.label = 1;
        if (DelayKt.delay(r105, r101) != r102) goto L13;
        return r102;
    L31:
        return ((y) r107).f360135b;
    L24:
        return null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r112);
        r104 = 0;
        r105 = 0;
        r107 = null;
        r106 = 0;
        goto L13
    L5:
        r101 = new DoraHttp$retryOnFailed$1(r111, this);
        goto L6
    }
}
