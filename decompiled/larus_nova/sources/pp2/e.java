package pp2;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f530194a;

    public e(DataCenter r100) {
        this.f530194a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        new qp2.d(r101.getContext(), this.f530194a, r100.optString(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL)).a();
        return null;
    }
}
