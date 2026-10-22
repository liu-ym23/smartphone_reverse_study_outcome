package qe5;

import com.bytedance.ies.xbridge.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f532647a;

    public c(b r100) {
        this.f532647a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this.f532647a + ") registerSecretPush - pushListener, token: " + du5.b.k(this.f532647a.f532642a) + ", type: " + this.f532647a.f532643b);
        JSONObject r101 = new JSONObject();
        r101.putOpt("token", this.f532647a.f532642a);
        XBridgeMethod.b r102 = (XBridgeMethod.b) this.f532647a.provideContext(XBridgeMethod.b.class);
        if (r102 == null) goto L6;
        r102.sendJsEvent("ccm.notifyPermissionUpdated", new f66.d(r101));
        return;
    }
}
