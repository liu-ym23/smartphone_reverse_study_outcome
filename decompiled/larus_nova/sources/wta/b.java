package wta;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends com.ss.android.dypay.webview.c {
    public b() {
    }

    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        if (r100 != null) goto L7;
        r102.a("context is null", 0);
        return;
    L7:
        if (com.ss.android.dypay.utils.e.e(r100, "123") == com.ss.android.dypay.utils.e.a.f408488d) goto L9;
        qta.a.g(r102, null, 0, null, 7);
        Intent r103 = new Intent();
        r103.putExtra("code", 101);
        r100.setResult(-1, r103);
        r100.finish();
        return;
    L9:
        qta.a.g(r102, "dou yin not installed", 2, null, 4);
    }
}
