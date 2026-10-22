package com.ss.android.ugc.aweme.framework.services.dyext.impl;

import com.ss.android.ugc.aweme.framework.services.dyext.AsyncResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022'\u0010\u0007\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\f0\bH\u0016ø\u0001\u0000J1\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\f0\bH\u0016R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/impl/ImmediateAsyncResult;", "R", "Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncResult;", "result", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "onComplete", "action", "Lkotlin/Function1;", "Lkotlin/Result;", "Lkotlin/ParameterName;", "name", "", "onSuccess", "value", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class ImmediateAsyncResult<R> extends AsyncResult<R> {
    private final R result;

    public ImmediateAsyncResult(R r100) {
        this.result = r100;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.AsyncResult
    public AsyncResult<R> onComplete(Function1<? super Result<? extends R>, Unit> r100) {
        Result.Companion r101 = Result.Companion;
        r100.invoke(Result.m9448boximpl(Result.m9449constructorimpl(this.result)));
        return this;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.AsyncResult
    public AsyncResult<R> onSuccess(Function1<? super R, Unit> r100) {
        r100.invoke(this.result);
        return this;
    }
}
