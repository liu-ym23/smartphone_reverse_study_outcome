package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/forwardv3/data/services/ForwardGetServices$getRecentForwardData$2$innerCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardGetServices$getRecentForwardData$2$innerCallback$1 implements IGetDataCallback<List<SearchBaseInfo>> {
    final /* synthetic */ boolean $isLocal;
    final /* synthetic */ Continuation<List<SearchBaseInfo>> $it;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("ForwardGetServices", "get recent forward data v1 error: " + r100 + ", from local: " + this.$isLocal, r100);
        Continuation<List<SearchBaseInfo>> r101 = this.$it;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
    }

    public void onSuccess(List<SearchBaseInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.$it.resumeWith(Result.m9449constructorimpl(r100));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ForwardGetServices$getRecentForwardData$2$innerCallback$1(Continuation<? super List<SearchBaseInfo>> r100, boolean r101) {
        this.$it = r100;
        this.$isLocal = r101;
    }
}
