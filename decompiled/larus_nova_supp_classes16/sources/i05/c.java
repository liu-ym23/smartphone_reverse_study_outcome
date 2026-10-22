package i05;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.bridgestatus.BridgeReadyModel;
import com.bytedance.ee.bear.document.f1;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements i<BridgeReadyModel> {
    public final b a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public c(f1 r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, m r4) {
        BridgeReadyModel r5 = (BridgeReadyModel) r3;
        tt5.a.b("BridgeReadyHandler", "handle()... ");
        if (this.a == null) goto L9;
        if (r5 == null) goto L9;
        if (TextUtils.isEmpty(r5.getType()) == true) goto L9;
        this.a.a(r5);
        return;
    L9:
        StringBuilder r0 = new StringBuilder("readyHandler data: ");
        if (r5 != null) goto L12;
        String r6 = "";
    L13:
        r0.append(r6);
        tt5.a.h("BridgeReadyHandler", r0.toString());
        return;
    L12:
        r6 = r5.toString();
        goto L13
    }
}
