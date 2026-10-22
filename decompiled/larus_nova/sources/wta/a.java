package wta;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends com.ss.android.dypay.webview.c {
    public a() {
    }

    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        if (r100 != null) goto L6;
        r102.a("context is null", 0);
        return;
    L6:
        qta.a.g(r102, null, 0, null, 7);
        int r103 = r101.optInt("code", 1);
        String r104 = r101.optString("msg");
        Intent r105 = new Intent();
        r105.putExtra("code", r103);
        r105.putExtra("msg", r104);
        r100.setResult(-1, r105);
        r100.finish();
    }
}
