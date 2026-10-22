package y05;

import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements tb5.i<Void> {
    public final s45.c a;
    public final m b;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public d(s45.c r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r2, tb5.m r3) {
        Void r4 = (Void) r2;
        tt5.a.h("FetchDomainConfigHandler", "handle()...");
        s45.c r5 = this.a;
        if (r5 != null) goto L6;
        tt5.a.h("FetchDomainConfigHandler", "domainCharacteristicService is null");
        return;
    L6:
        if (this.b != null) goto L8;
        tt5.a.h("FetchDomainConfigHandler", "docWebService is null");
        return;
    L8:
        r5.ka().observeOn(fo5.d.d()).flatMap(new a(this)).subscribe(new b(), new c());
    }
}
