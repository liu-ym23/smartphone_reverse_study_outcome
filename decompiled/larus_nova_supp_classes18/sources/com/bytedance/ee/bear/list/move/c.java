package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class c implements Function {
    public /* synthetic */ c() {
    }

    public final Object apply(Object r1) {
        return (GetMoveReviewerInfoPuller$Result) ((Result) r1).data;
    }
}
