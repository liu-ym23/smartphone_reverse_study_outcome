package com.ss.android.lark.chat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class i2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f416516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k2 f416517b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f416517b.f416533a).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((k2.b) r100.next()).a(this.f416516a);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public i2(k2 r100, JSONObject r101) {
        this.f416517b = r100;
        this.f416516a = r101;
    }
}
