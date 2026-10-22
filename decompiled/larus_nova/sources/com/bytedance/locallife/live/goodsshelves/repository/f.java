package com.bytedance.locallife.live.goodsshelves.repository;

import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesDSLPagingResponse;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGoodsShelvesDSLPagingResponse f259809a;

    public f(LiveGoodsShelvesDSLPagingResponse r100) {
        this.f259809a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<LiveGoodsShelvesDSLPagingResponse> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        r100.onSuccess(this.f259809a);
    }
}
