package ne5;

import com.bytedance.ies.xbridge.XBridgeMethod;
import f66.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f518886a;

    public b(a r100) {
        this.f518886a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("CCMRegisterSecretChangeMethod", "(" + this.f518886a + ") initSecretPush-pushListener, token: " + du5.b.k(this.f518886a.f518882a) + ", type: " + this.f518886a.f518883b);
        JSONObject r101 = new JSONObject();
        r101.putOpt("token", this.f518886a.f518882a);
        XBridgeMethod.b r102 = (XBridgeMethod.b) this.f518886a.provideContext(XBridgeMethod.b.class);
        if (r102 == null) goto L6;
        r102.sendJsEvent("ccm.notifySecLevelUpdated", new d(r101));
        return;
    }
}
