package com.bytedance.ee.bear.bitable.plugin;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f214923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f214924b;

    public c(JSONObject r100, m r101) {
        this.f214923a = r100;
        this.f214924b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BitableDebugPlugin.Companion.getClass();
        String r101 = BitableDebugPlugin.access$getTAG$cp();
        tt5.a.e(r101, "save debug file failed", (Throwable) r100, false);
        this.f214923a.put("code", 1);
        m r102 = this.f214924b;
        if (r102 == null) goto L6;
        r102.b(this.f214923a);
        return;
    }
}
