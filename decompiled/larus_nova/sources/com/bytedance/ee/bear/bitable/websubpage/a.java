package com.bytedance.ee.bear.bitable.websubpage;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenWebSubPage f216298a;

    public a(FullScreenWebSubPage r100) {
        this.f216298a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
    L9:
        e = move-exception;
        tt5.a.d("FullScreenWebSubPage", "backpress ex:" + e.getMessage());
        FullScreenWebSubPage.a r101 = this.f216298a.f216282i;
        if (r101 == null) goto L18;
        r101.a();
        return;
    L18:
        return;
    L4:
        if (TextUtils.equals("handled", new JSONObject((String) r100).optString("result", "")) == true) goto L16;
        FullScreenWebSubPage.a r102 = this.f216298a.f216282i;     // Catch: Exception -> L9
        if (r102 == null) goto L17;
        r102.a();     // Catch: Exception -> L9
        return;
    L17:
        return;
    }
}
