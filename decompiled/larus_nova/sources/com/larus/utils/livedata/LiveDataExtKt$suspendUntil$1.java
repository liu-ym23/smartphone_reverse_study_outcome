package com.larus.utils.livedata;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.utils.livedata.LiveDataExtKt", f = "LiveDataExt.kt", i = {0, 0, 0}, l = {101, 106, 110}, m = "suspendUntil", n = {"deferred", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "timeout"}, s = {"L$0", "L$1", "J$0"})
final class LiveDataExtKt$suspendUntil$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public LiveDataExtKt$suspendUntil$1(Continuation<? super LiveDataExtKt$suspendUntil$1> r100) {
        super(r100);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.utils.livedata.a] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.utils.livedata.LiveDataExtKt$suspendUntil$observer$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        LiveDataExtKt$suspendUntil$1<T> r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r112.label;
        if (r102 == 0) goto L16;
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r100);
    L31:
        return r100;
    L15:
        long r103 = r112.J$0;
        final Ref.BooleanRef r104 = (Ref.BooleanRef) r112.L$1;
        final CompletableDeferred r113 = (CompletableDeferred) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L21:
        if (r103 > 0) goto L23;
    L27:
        r112.L$0 = null;
        r112.L$1 = null;
        r112.label = 3;
        r100 = r113.await(r112);
        if (r100 != r101) goto L31;
        return r101;
    L23:
        if (r104.element == true) goto L27;
        LiveDataExtKt$suspendUntil$result$1 r105 = new LiveDataExtKt$suspendUntil$result$1(r113, null);
        r112.L$0 = null;
        r112.L$1 = null;
        r112.label = 2;
        r100 = TimeoutKt.c(r103, r105, r112);
        if (r100 != r101) goto L31;
        return r101;
    L16:
        ResultKt.throwOnFailure(r100);
        r113 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r104 = new Ref.BooleanRef();
        final ?? r106 = new a(r104, r113);
        ?? r107 = new LiveDataExtKt$suspendUntil$observer$1(r106);
        MainCoroutineDispatcher r108 = Dispatchers.getMain();
        LiveDataExtKt$suspendUntil$2 r114 = new LiveDataExtKt$suspendUntil$2(null, null, r107, null);
        r112.L$0 = r113;
        r112.L$1 = r104;
        r112.J$0 = 0;
        r112.label = 1;
        if (BuildersKt.withContext(r108, r114, r112) == r101) goto L32;
        r103 = 0;
        goto L21
    L32:
        return r101;
    L5:
        r112 = new LiveDataExtKt$suspendUntil$1(this);
        goto L6
    }
}
