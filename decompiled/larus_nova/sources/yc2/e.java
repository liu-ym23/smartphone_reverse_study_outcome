package yc2;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showPoiInfoDialogForAudience")
public final class e extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Unit invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("user_id");
        String r104 = r102.optString("poi_id_str");
        String r105 = r102.optString("room_id");
        IHostBusiness r106 = (IHostBusiness) k.f(IHostBusiness.class);
        if (r106 == null) goto L6;
        r106.showPoiInfoDialogForAudience(r101.getContext(), r104, r103, r105);
    L6:
        return Unit.INSTANCE;
    }
}
