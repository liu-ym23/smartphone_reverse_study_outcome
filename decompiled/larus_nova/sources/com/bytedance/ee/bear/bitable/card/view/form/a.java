package com.bytedance.ee.bear.bitable.card.view.form;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements gu4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f208421a;

    public a(m r100) {
        this.f208421a = r100;
    }

    @Override // gu4.b
    public final void a(boolean r100) {
        b(r100, "manualClick");
    }

    @Override // gu4.b
    public final void c(String r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r102.put2("action", "sendNotification");
        r102.put2("shareToken", r100);
        r101.put2("options", r102);
        this.f208421a.b(r101);
    }

    @Override // gu4.b
    public final void b(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r103.put2("action", "noticeMe");
        r103.put2("noticeMeValue", Boolean.valueOf(r100));
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "manualClick";
    L5:
        r103.put2("source", r101);
        r102.put2("options", r103);
        this.f208421a.b(r102);
    }
}
