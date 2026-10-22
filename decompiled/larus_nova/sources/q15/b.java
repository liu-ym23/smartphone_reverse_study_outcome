package q15;

import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends vv4.a {
    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        String r101 = "#WEB#";
        if (r100.getWebView() == null) goto L5;
        r101 = "#WEB#" + r100.getWebView().hashCode();
    L5:
        bindBridgeHandlerAutoUnbind("biz.util.logger", new a(r101));
        bindBridgeHandlerAutoUnbind("biz.util.batchLogger", new com.bytedance.ee.bear.document.frontendlog.a(r101));
    }
}
