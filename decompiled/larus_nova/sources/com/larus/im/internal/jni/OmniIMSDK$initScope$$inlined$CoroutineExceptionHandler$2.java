package com.larus.im.internal.jni;

import com.larus.im.internal.delegate.d1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniIMSDK$initScope$$inlined$CoroutineExceptionHandler$2 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public OmniIMSDK$initScope$$inlined$CoroutineExceptionHandler$2(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext r100, Throwable r101) {
        com.larus.im.internal.delegate.a.f348188b.e(OmniIMSDK.TAG, "omniServiceScope exception: " + r101);
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L6;
        d1 r102 = d1.f348206b;
        StringBuilder r103 = new StringBuilder("exception:");
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r103.append(ExceptionsKt.stackTraceToString(r101));
        r102.b("OmniIMSDK_scope", r103.toString());
        return;
    }
}
