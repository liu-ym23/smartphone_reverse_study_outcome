package com.bytedance.ee.bear.bitable.card.view.form;

import com.alibaba.fastjson.JSONObject;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements BitableSharePlugin.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f208437a;

    public f(k r100) {
        this.f208437a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.form.BitableSharePlugin.c
    public final void a(JSONObject r100) {
        this.f208437a.a(BitableSharePlugin.FORMS_SEND_NOTIFICATION, r100, null);
    }
}
