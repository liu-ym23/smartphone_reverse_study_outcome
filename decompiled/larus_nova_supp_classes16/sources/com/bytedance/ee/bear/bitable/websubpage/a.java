package com.bytedance.ee.bear.bitable.websubpage;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements ValueCallback {
    public final /* synthetic */ FullScreenWebSubPage a;

    public a(FullScreenWebSubPage r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r4) {
    L9:
        e = move-exception;
        tt5.a.d("FullScreenWebSubPage", "backpress ex:" + e.getMessage());
        FullScreenWebSubPage.a r5 = this.a.i;
        if (r5 == null) goto L18;
        r5.a();
        return;
    L18:
        return;
    L4:
        if (TextUtils.equals("handled", new JSONObject((String) r4).optString(TipCallBackData.RESULT, "")) == true) goto L16;
        FullScreenWebSubPage.a r6 = this.a.i;     // Catch: Exception -> L9
        if (r6 == null) goto L17;
        r6.a();     // Catch: Exception -> L9
        return;
    L17:
        return;
    }
}
