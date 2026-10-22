package y05;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements tb5.i<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s45.c f565582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IChameleonHandlerContext f565583b;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public i(s45.c r100, IChameleonHandlerContext r101) {
        this.f565582a = r100;
        this.f565583b = r101;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        Void r102 = (Void) r100;
        tt5.a.h("FetchDomainConfigHandler", "handle()...");
        s45.c r103 = this.f565582a;
        if (r103 != null) goto L6;
        tt5.a.h("FetchDomainConfigHandler", "domainCharacteristicService is null");
        return;
    L6:
        if (this.f565583b != null) goto L8;
        tt5.a.h("FetchDomainConfigHandler", "docWebService is null");
        return;
    L8:
        r103.ka().observeOn(fo5.d.d()).flatMap(new f(this)).subscribe(new g(), new h());
    }
}
