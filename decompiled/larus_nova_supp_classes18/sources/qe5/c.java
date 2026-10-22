package qe5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements bu5.a {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r3) {
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this.a + ") registerSecretPush - pushListener, token: " + du5.b.k(this.a.a) + ", type: " + this.a.b);
        JSONObject r4 = new JSONObject();
        r4.putOpt(ResourceData.KEY_TOKEN, this.a.a);
        XBridgeMethod.b r0 = (XBridgeMethod.b) this.a.provideContext(XBridgeMethod.b.class);
        if (r0 == null) goto L6;
        r0.sendJsEvent("ccm.notifyPermissionUpdated", new f66.d(r4));
        return;
    }
}
