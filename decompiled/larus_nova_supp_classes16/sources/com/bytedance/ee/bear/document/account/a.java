package com.bytedance.ee.bear.document.account;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ m a;

    public a(m r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        JSONObject r0 = new JSONObject();
        r0.put("tanent_tag", ((AccountService$Account) r3).tenantTag);
        m r4 = this.a;
        if (r4 == null) goto L6;
        r4.b(r0);
        return;
    }
}
