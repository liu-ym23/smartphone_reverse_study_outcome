package com.bytedance.ee.bear.bitable.lynx.pro;

import com.alibaba.fastjson.JSONObject;
import com.larus.apm.impl.protector.RunnableProtector;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f214644a;

    public e(m r100) {
        this.f214644a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r100 = this.f214644a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L6
        r101.put2("action", "AdvOpenShareSettingPanel");     // Catch: Throwable -> L6
        r100.b(r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
