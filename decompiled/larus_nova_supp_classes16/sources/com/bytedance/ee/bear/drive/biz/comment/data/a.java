package com.bytedance.ee.bear.drive.biz.comment.data;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a implements Function {
    public /* synthetic */ a() {
    }

    public final Object apply(Object r1) {
        return (ArrayList) ((Result) r1).getData();
    }
}
