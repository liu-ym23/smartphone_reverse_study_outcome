package com.bytedance.ee.bear.bitable.plugin;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f214921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f214922b;

    public b(JSONObject r100, m r101) {
        this.f214921a = r100;
        this.f214922b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        BitableDebugPlugin.Companion.getClass();
        tt5.a.h(BitableDebugPlugin.access$getTAG$cp(), "save debug file: " + r101);
        this.f214921a.put("code", Integer.valueOf(!r101.booleanValue() ? 1 : 0));
        m r102 = this.f214922b;
        if (r102 == null) goto L6;
        r102.b(this.f214921a);
        return;
    }
}
