package wta;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends com.ss.android.dypay.webview.c {
    public f() {
    }

    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        boolean r103 = r101.optBoolean("enable", true);
        if (r100 == null) goto L5;
        r100.runOnUiThread(new e(r103, r100, r102));
        return;
    L5:
        r102.a("context is null", 0);
    }
}
