package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class c implements Function {
    public /* synthetic */ c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return (GetMoveReviewerInfoPuller$Result) ((Result) r100).data;
    }
}
