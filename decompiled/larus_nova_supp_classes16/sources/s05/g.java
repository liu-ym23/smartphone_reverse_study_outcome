package s05;

import com.bytedance.ee.bear.doccomponent.api.entity.DocComponentBizEvent;
import com.bytedance.ee.bear.document.doccomponent.impl.WebDocComponentImpl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements i<DocComponentBizEvent> {
    public final /* synthetic */ WebDocComponentImpl a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public g(WebDocComponentImpl r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r5, m r6) {
        DocComponentBizEvent r7 = (DocComponentBizEvent) r5;
        StringBuilder r0 = new StringBuilder("JSB_INVOKE_NATIVE result=");
        if (r7 == null) goto L5;
        String r1 = r7.toString();
    L6:
        r0.append(du5.b.k(r1));
        r0.append(" cb=");
        r0.append(r6);
        tt5.a.h("DComponent_DocComponentWebImpl", r0.toString());
        if (r7 == null) goto L29;
        r7.setCallBack(r6);     // Catch: Throwable -> L22
        d r8 = this.a.c;     // Catch: Throwable -> L22
        String r2 = r7.getCommand();     // Catch: Throwable -> L22
        String r3 = "";
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        String r4 = r7.getModule();     // Catch: Throwable -> L22
        if (r4 == null) goto L17;
        r3 = r4;
    L17:
        qz4.b r9 = r8.a(r2, r3);     // Catch: Throwable -> L22
        if (r9 != null) goto L20;
        tt5.a.k("DComponent_DocComponentWebImpl", "JSB_INVOKE_NATIVE handler is null");     // Catch: Throwable -> L22
    L25:
        return;
    L20:
        r9.onEvent(r7);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        tt5.a.f("DComponent_DocComponentWebImpl", th, false);
        return;
    L29:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
