package h25;

import com.bytedance.ee.bear.contract.offline.ModifyDocBean;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements tb5.i<ModifyDocBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f483594b;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public d(String r100) {
        this.f483593a = "Offline#Modify#";
        String r101 = "Offline#Modify#" + r100 + Integer.toHexString(hashCode());
        this.f483593a = r101;
        tt5.a.h(r101, "construct");
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        tt5.a.h(this.f483593a, "handle:" + ((ModifyDocBean) r100));
    }
}
