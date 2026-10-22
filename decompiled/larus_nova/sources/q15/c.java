package q15;

import com.bytedance.ee.bear.document.frontendlog.LoggerMessage;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import tb5.h;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements h<LoggerMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531295a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f531295a = "JSLoggerHandler";
        this.f531295a = "JSLoggerHandler#" + r100;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        LoggerMessage r102 = (LoggerMessage) r100;
        String r103 = this.f531295a;
        if (r102 == null) goto L5;
        String r104 = r102.logMessage;
    L6:
        tt5.a.h(r103, r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
