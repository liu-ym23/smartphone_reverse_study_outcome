package com.bytedance.ee.bear.sheet.filter;

import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements FilterViewModel.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.m f237865a;

    public o(tb5.m r100) {
        this.f237865a = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterViewModel.b
    public final <T> void a(String r100, String r101, int r102, T r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        tb5.m r105 = this.f237865a;
        if (r105 == null) goto L9;
        JSONObject r106 = new JSONObject();
        r106.put("id", r100);
        r106.put("sheetId", r101);
        r106.put("currentCol", Integer.valueOf(r102));
        r106.put("value", r103);
        if (r104 == null) goto L7;
        r104.booleanValue();
        r106.put("isSearch", r104);
    L7:
        tt5.a.b("FilterPlugin", "callback: " + r105 + ' ' + r106);
        r105.b(r106);
        return;
    }
}
