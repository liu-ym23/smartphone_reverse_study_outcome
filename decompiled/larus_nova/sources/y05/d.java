package y05;

import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements tb5.i<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s45.c f565579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f565580b;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public d(s45.c r100, m r101) {
        this.f565579a = r100;
        this.f565580b = r101;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        Void r102 = (Void) r100;
        tt5.a.h("FetchDomainConfigHandler", "handle()...");
        s45.c r103 = this.f565579a;
        if (r103 != null) goto L6;
        tt5.a.h("FetchDomainConfigHandler", "domainCharacteristicService is null");
        return;
    L6:
        if (this.f565580b != null) goto L8;
        tt5.a.h("FetchDomainConfigHandler", "docWebService is null");
        return;
    L8:
        r103.ka().observeOn(fo5.d.d()).flatMap(new a(this)).subscribe(new b(), new c());
    }
}
