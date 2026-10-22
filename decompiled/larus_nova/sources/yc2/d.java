package yc2;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showManagePoiDialog")
public final class d extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
    public d() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Unit invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = r112.optInt("is_in_room", 0);
        String r113 = r112.optString("room_id");
        IMiddlewareHostBusiness r101 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r101 == null) goto L14;
        Context r102 = r111.getContext();
        if (r100 != 1) goto L7;
        boolean r103 = true;
    L8:
        Long r114 = StringsKt.toLongOrNull(r113);
        if (r114 == null) goto L11;
        long r115 = r114.longValue();
    L12:
        r101.showManagePoiDialog(r102, r103, r115, null);
        goto L14
    L11:
        r115 = 0;
        goto L12
    L7:
        r103 = false;
    L14:
        return Unit.INSTANCE;
    }
}
