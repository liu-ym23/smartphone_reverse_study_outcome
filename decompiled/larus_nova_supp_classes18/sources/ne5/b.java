package ne5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import f66.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements bu5.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r3) {
        tt5.a.h("CCMRegisterSecretChangeMethod", "(" + this.a + ") initSecretPush-pushListener, token: " + du5.b.k(this.a.a) + ", type: " + this.a.b);
        JSONObject r4 = new JSONObject();
        r4.putOpt(ResourceData.KEY_TOKEN, this.a.a);
        XBridgeMethod.b r0 = (XBridgeMethod.b) this.a.provideContext(XBridgeMethod.b.class);
        if (r0 == null) goto L6;
        r0.sendJsEvent("ccm.notifySecLevelUpdated", new d(r4));
        return;
    }
}
