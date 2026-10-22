package com.bytedance.ee.bear.document.offline.sync;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.m f220614a;

    public l(tb5.m r100) {
        this.f220614a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        tb5.m r102 = this.f220614a;
        if (r102 == null) goto L6;
        r102.b(r101);
        return;
    }
}
