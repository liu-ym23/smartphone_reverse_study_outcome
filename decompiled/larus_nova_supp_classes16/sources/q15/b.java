package q15;

import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends vv4.a {
    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r3) {
        super.onAttachToWeb(r3);
        String r1 = "#WEB#";
        if (r3.getWebView() == null) goto L5;
        r1 = "#WEB#" + r3.getWebView().hashCode();
    L5:
        bindBridgeHandlerAutoUnbind("biz.util.logger", new a(r1));
        bindBridgeHandlerAutoUnbind("biz.util.batchLogger", new com.bytedance.ee.bear.document.frontendlog.a(r1));
    }
}
