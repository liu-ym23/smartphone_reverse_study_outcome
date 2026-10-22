package q15;

import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.frontendlog.LoggerMessage;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import tb5.h;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements h<LoggerMessage> {
    public final String a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public c(String r3) {
        Intrinsics.checkNotNullParameter(r3, DocRedirectToDocxPlugin.FROM);
        this.a = "JSLoggerHandler";
        this.a = "JSLoggerHandler#" + r3;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r1, m r2) {
        LoggerMessage r3 = (LoggerMessage) r1;
        String r4 = this.a;
        if (r3 == null) goto L5;
        String r5 = r3.logMessage;
    L6:
        tt5.a.h(r4, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
