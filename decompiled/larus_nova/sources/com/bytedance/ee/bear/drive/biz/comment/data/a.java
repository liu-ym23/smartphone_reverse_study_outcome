package com.bytedance.ee.bear.drive.biz.comment.data;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a implements Function {
    public /* synthetic */ a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return (ArrayList) ((Result) r100).getData();
    }
}
