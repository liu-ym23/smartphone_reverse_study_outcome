package com.bytedance.ee.bear.document.folder.selection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ SelectFileBlockMediaPlugin a;
    public final /* synthetic */ JSONArray b;

    public b(SelectFileBlockMediaPlugin r1, JSONArray r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        tt5.a.h("SelectFileBlockMediaPlugin", "saveFilesFlow result=" + ((Boolean) r4));
        JSONObject r5 = new JSONObject();
        JSONArray r0 = this.b;
        r5.put("code", 0);
        r5.put("thumbs", r0);
        SelectFileBlockMediaPlugin.b r1 = SelectFileBlockMediaPlugin.access$getSelectMediaHandler$p(this.a);
        if (r1 == null) goto L8;
        m r2 = r1.a;
        if (r2 == null) goto L9;
        r2.b(r5);
        return;
    L9:
        return;
    }
}
