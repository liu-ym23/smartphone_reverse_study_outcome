package com.bytedance.ee.bear.sheet.filter;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements FilterViewModel.b {
    public final /* synthetic */ tb5.m a;

    public o(tb5.m r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterViewModel.b
    public final <T> void a(String r4, String r5, int r6, T r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        tb5.m r1 = this.a;
        if (r1 == null) goto L9;
        JSONObject r2 = new JSONObject();
        r2.put(ResourceData.KEY_ID, r4);
        r2.put("sheetId", r5);
        r2.put("currentCol", Integer.valueOf(r6));
        r2.put("value", r7);
        if (r8 == null) goto L7;
        r8.booleanValue();
        r2.put("isSearch", r8);
    L7:
        tt5.a.b("FilterPlugin", "callback: " + r1 + ' ' + r2);
        r1.b(r2);
        return;
    }
}
