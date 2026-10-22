package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements BaseCellPanelViewModel.a {
    public final /* synthetic */ tb5.m a;

    public j(tb5.m r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel.a
    public final <V> void a(String r3, V r4) {
        if (this.a == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put(ResourceData.KEY_ID, r3);
        r0.put("value", r4);
        this.a.b(r0);
        return;
    }
}
