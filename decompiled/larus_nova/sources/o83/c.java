package o83;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c {
    static {
    }

    public static JSONObject a(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        JSONObject r103 = new JSONObject();
        r103.put("id", r100);
        r103.put("address_type", r101);
        if (r102 == null) goto L5;
        JSONObject r104 = new JSONObject();
        r104.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r102);
        Unit r105 = Unit.INSTANCE;
        r103.put("extra", r104);
    L5:
        return r103;
    }
}
