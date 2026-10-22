package wta;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends com.ss.android.dypay.webview.c {
    public j() {
    }

    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        String r103 = r101.optString("app_id");
        String r104 = vta.d.d(r101.optString("merchant_id"), r103);
    L13:
        r102.a("data parse error", 0);
        return;
    L4:
        if (r104.length() != 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L9;
        qta.a.g(r102, null, 0, new JSONObject(r104), 3);     // Catch: Exception -> L13
        return;
    L9:
        com.ss.android.dypay.webview.a.a(r102.f408531a, 0, "settings is empty", new JSONObject(), r102.f408532b);     // Catch: Exception -> L13
        return;
    L6:
        r105 = false;
        goto L7
    }
}
