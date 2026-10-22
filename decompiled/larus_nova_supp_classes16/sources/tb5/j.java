package tb5;

import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;
import com.bytedance.ee.larkwebview.base.LarkWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements at5.f<String, LarkWebView> {
    public final /* synthetic */ o a;

    public final boolean shouldRunInUIThread() {
        if ((this.a instanceof q) == true) goto L5;
    L8:
        return true;
    L5:
        if (BridgeWebViewV2.E == true) goto L8;
        return false;
    }

    public j(o r1) {
        this.a = r1;
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        o r5 = this.a;
        boolean r6 = BridgeWebViewV2.E;
        f.d((String) r1, r5, new l(r2));
    }
}
