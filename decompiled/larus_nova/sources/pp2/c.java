package pp2;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f530193a;

    public c(DataCenter r100) {
        this.f530193a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = new JSONObject();
        DataCenter r103 = this.f530193a;
        if (r103 == null) goto L8;
        Boolean r104 = Boolean.FALSE;
        boolean r105 = ((Boolean) r103.get("DATA_COMMERCE_COMPAT_AUDIENCE_BTN_ATTACH", r104)).booleanValue();
        boolean r106 = ((Boolean) this.f530193a.get("DATA_COMMERCE_COMPAT_ANCHOR_BTN_ATTACH", r104)).booleanValue();
        if (r105 == true) goto L7;
        if (r106 == false) goto L8;
    L7:
        r102.put("data", true);
    L8:
        return r102;
    }
}
