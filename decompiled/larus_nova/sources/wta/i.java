package wta;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends com.ss.android.dypay.webview.c {
    public i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        boolean r103 = r101.optBoolean("need_show", false);
        if ((r100 instanceof com.ss.android.dypay.webview.e) == false) goto L5;
        ((com.ss.android.dypay.webview.e) r100).b(r103);
        qta.a.g(r102, null, 0, null, 7);
        return;
    L5:
        r102.a("can not handle", 0);
    }
}
