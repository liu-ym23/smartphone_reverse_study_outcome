package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements BaseCellPanelViewModel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.m f238249a;

    public u(tb5.m r100) {
        this.f238249a = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel.a
    public final <V> void a(String r100, V r101) {
        if (this.f238249a == null) goto L6;
        JSONObject r102 = new JSONObject();
        r102.put2("id", r100);
        r102.put2("value", r101);
        this.f238249a.b(r102);
        return;
    }
}
