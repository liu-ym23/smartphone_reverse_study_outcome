package q15;

import com.ss.android.lark.chameleon.AbsChameleonService;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends AbsChameleonService {
    public d() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        String r101 = "#WEB#";
        if (r100.getWebView() == null) goto L5;
        r101 = "#WEB#" + r100.getWebView().hashCode();
    L5:
        bindBridgeHandlerAutoUnbind("biz.util.logger", new c(r101));
        bindBridgeHandlerAutoUnbind("biz.util.batchLogger", new com.bytedance.ee.bear.document.frontendlog.b(r101));
    }
}
