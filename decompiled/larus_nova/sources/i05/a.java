package i05;

import com.bytedance.ee.bear.document.bridgestatus.BridgeReadyModel;
import com.bytedance.ee.bear.document.g1;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f487877a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(g1 r100) {
        this.f487877a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        String r102 = (String) r100;
        tt5.a.b("BridgePreloadReadyHandler", "handle()... data: " + r102);
        if (this.f487877a == null) goto L8;
        if (r102 == null) goto L9;
        BridgeReadyModel r103 = new BridgeReadyModel();
        r103.setData(r102);
        this.f487877a.a(r103);
        return;
    L9:
        return;
    }
}
