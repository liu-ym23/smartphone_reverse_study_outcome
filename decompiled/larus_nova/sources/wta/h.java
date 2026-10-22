package wta;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends com.ss.android.dypay.webview.c {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        if (r100 != 0) goto L7;
        r102.a("context is null", 0);
        return;
    L7:
        if ((r100 instanceof com.ss.android.dypay.webview.e) == false) goto L9;
        ((com.ss.android.dypay.webview.e) r100).e();
        qta.a.g(r102, null, 0, null, 7);
        return;
    L9:
        r102.a("can not handle", 0);
    }
}
