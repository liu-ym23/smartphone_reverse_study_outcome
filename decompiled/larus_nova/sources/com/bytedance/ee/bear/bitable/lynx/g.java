package com.bytedance.ee.bear.bitable.lynx;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableModalLynxFragment f214630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f214631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f214632c;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        this.f214630a.I.run();
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void c() {
        JSONObject r100 = this.f214631b.getJSONObject("confirmAction");
        this.f214632c.b(r100);
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void d() {
        this.f214630a.I.run();
    }

    public g(BitableModalLynxFragment r100, JSONObject r101, m r102) {
        this.f214630a = r100;
        this.f214631b = r101;
        this.f214632c = r102;
    }
}
