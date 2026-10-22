package com.bytedance.ee.bear.bitable.toast;

import com.alibaba.fastjson.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements b.InterfaceC0027b {
    public final /* synthetic */ m a;
    public final /* synthetic */ ToastModel b;

    @Override // com.bytedance.ee.bear.bitable.toast.b.InterfaceC0027b
    public final void a() {
        JSONObject r0 = new JSONObject();
        r0.put("id", this.b.getId());
        r0.put("closeType", Integer.valueOf(ToastModel.CLoseType.Confirm.getValue()));
        m r1 = this.a;
        if (r1 == null) goto L6;
        r1.b(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.toast.b.InterfaceC0027b
    public final void onTimeout() {
        JSONObject r0 = new JSONObject();
        r0.put("id", this.b.getId());
        r0.put("closeType", Integer.valueOf(ToastModel.CLoseType.Timeout.getValue()));
        m r1 = this.a;
        if (r1 == null) goto L6;
        r1.b(r0);
        return;
    }

    public e(m r1, ToastModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
