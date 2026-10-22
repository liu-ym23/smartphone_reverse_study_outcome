package com.bytedance.ee.bear.document.account;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f218673a;

    public a(m r100) {
        this.f218673a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = new JSONObject();
        r101.put("tanent_tag", ((AccountService$Account) r100).tenantTag);
        m r102 = this.f218673a;
        if (r102 == null) goto L6;
        r102.b(r101);
        return;
    }
}
