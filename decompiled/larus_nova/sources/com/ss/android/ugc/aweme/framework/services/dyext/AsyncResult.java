package com.ss.android.ugc.aweme.framework.services.dyext;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J:\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002'\u0010\u0005\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016ø\u0001\u0000J1\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0006H\u0007J1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016J:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002'\u0010\u0005\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0007ø\u0001\u0000J1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncResult;", "R", "", "()V", "onComplete", "action", "Lkotlin/Function1;", "Lkotlin/Result;", "Lkotlin/ParameterName;", "name", "result", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", a.KEY_EXCEPTION, "onFailure", "onResult", "onSuccess", "value", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public class AsyncResult<R> {
    public AsyncResult() {
    }

    public AsyncResult<R> onComplete(Function1<? super Result<? extends R>, Unit> r100) {
        return this;
    }

    public AsyncResult<R> onFailure(Function1<? super Throwable, Unit> r100) {
        return this;
    }

    public AsyncResult<R> onSuccess(Function1<? super R, Unit> r100) {
        return this;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "onFailure(action)", imports = {}))
    public final AsyncResult<R> onError(Function1<? super Throwable, Unit> r100) {
        onFailure(r100);
        return this;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "onComplete(action)", imports = {}))
    public final AsyncResult<R> onResult(Function1<? super Result<? extends R>, Unit> r100) {
        onComplete(r100);
        return this;
    }
}
