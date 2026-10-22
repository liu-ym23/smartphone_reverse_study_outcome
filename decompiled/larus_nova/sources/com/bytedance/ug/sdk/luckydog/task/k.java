package com.bytedance.ug.sdk.luckydog.task;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f271929a;

    public k(JSONObject r100) {
        this.f271929a = r100;
    }

    public final void a() {
        String r100 = (String) uk7.n.c("https://polaris.zijieapi.com/polaris/task/external/transfer/", this.f271929a).body();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r100) == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ThirdPartyExchangeManager", "transfer request fail, reason: body empty");     // Catch: Throwable -> L9
        return;
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ThirdPartyExchangeManager", "request finish, code: " + new JSONObject(r100).optInt("status_code"));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("ThirdPartyExchangeManager", th.getLocalizedMessage(), th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
