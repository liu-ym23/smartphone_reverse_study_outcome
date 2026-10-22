package com.bytedance.ee.bear.document.offline.sync;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ tb5.m a;

    public l(tb5.m r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        JSONObject r3 = (JSONObject) r2;
        tb5.m r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r3);
        return;
    }
}
