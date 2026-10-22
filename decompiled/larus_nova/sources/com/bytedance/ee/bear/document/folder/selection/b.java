package com.bytedance.ee.bear.document.folder.selection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectFileBlockMediaPlugin f219918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f219919b;

    public b(SelectFileBlockMediaPlugin r100, JSONArray r101) {
        this.f219918a = r100;
        this.f219919b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("SelectFileBlockMediaPlugin", "saveFilesFlow result=" + ((Boolean) r100));
        JSONObject r101 = new JSONObject();
        JSONArray r102 = this.f219919b;
        r101.put2("code", 0);
        r101.put2("thumbs", r102);
        SelectFileBlockMediaPlugin.b r103 = SelectFileBlockMediaPlugin.access$getSelectMediaHandler$p(this.f219918a);
        if (r103 == null) goto L8;
        m r104 = r103.f219914a;
        if (r104 == null) goto L9;
        r104.b(r101);
        return;
    L9:
        return;
    }
}
