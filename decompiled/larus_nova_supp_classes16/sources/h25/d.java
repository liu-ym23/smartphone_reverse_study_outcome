package h25;

import com.bytedance.ee.bear.contract.offline.ModifyDocBean;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements tb5.i<ModifyDocBean> {
    public final String a;
    public n b;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public d(String r3) {
        this.a = "Offline#Modify#";
        String r4 = "Offline#Modify#" + r3 + Integer.toHexString(hashCode());
        this.a = r4;
        tt5.a.h(r4, "construct");
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, tb5.m r4) {
        tt5.a.h(this.a, "handle:" + ((ModifyDocBean) r3));
    }
}
