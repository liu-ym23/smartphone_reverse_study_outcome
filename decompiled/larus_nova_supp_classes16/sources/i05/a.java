package i05;

import com.bytedance.ee.bear.document.bridgestatus.BridgeReadyModel;
import com.bytedance.ee.bear.document.g1;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements i<String> {
    public final b a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(g1 r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r2, m r3) {
        String r4 = (String) r2;
        tt5.a.b("BridgePreloadReadyHandler", "handle()... data: " + r4);
        if (this.a == null) goto L8;
        if (r4 == null) goto L9;
        BridgeReadyModel r5 = new BridgeReadyModel();
        r5.setData(r4);
        this.a.a(r5);
        return;
    L9:
        return;
    }
}
