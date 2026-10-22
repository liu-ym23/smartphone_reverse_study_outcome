package q15;

import com.ss.android.lark.chameleon.AbsChameleonService;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends AbsChameleonService {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r3) {
        super.onAttachToWeb(r3);
        String r1 = "#WEB#";
        if (r3.getWebView() == null) goto L5;
        r1 = "#WEB#" + r3.getWebView().hashCode();
    L5:
        bindBridgeHandlerAutoUnbind("biz.util.logger", new c(r1));
        bindBridgeHandlerAutoUnbind("biz.util.batchLogger", new com.bytedance.ee.bear.document.frontendlog.b(r1));
    }
}
