package wta;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends com.ss.android.dypay.webview.c {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.dypay.webview.c
    public final void a(Activity r100, JSONObject r101, com.ss.android.dypay.webview.a.C4736a r102) {
        if (r100 != 0) goto L7;
        r102.a("context is null", 0);
        return;
    L7:
        if (r101.has("disableNativeClose") == false) goto L12;
        boolean r103 = r101.optBoolean("disableNativeClose");
        if ((r100 instanceof com.ss.android.dypay.webview.e) == false) goto L11;
        ((com.ss.android.dypay.webview.e) r100).a(r103);
        com.ss.android.dypay.webview.a.a(r102.f408531a, 1, "success", new JSONObject(), r102.f408532b);
        goto L12
    L11:
        r102.a("can not handle", 0);
    L12:
        qta.a.g(r102, null, 0, null, 7);
    }
}
