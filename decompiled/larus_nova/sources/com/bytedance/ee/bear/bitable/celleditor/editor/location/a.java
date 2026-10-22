package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorLocation;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends com.bytedance.ee.bear.bitable.celleditor.editor.b {
    public a() {
    }

    public final void f(EditorLocation r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        r102.put("loading", Boolean.valueOf(r101));
        r102.put("location", r100);
        r102.put("action", "NativeLocationTempLoading");
        e(r102);
    }
}
