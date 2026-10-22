package le3;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject a(View r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.putOpt(PdpOpenThirdParam.KEY_PROMOTION_ID, r3);
        if (r2 != null) goto L5;
        return r0;
    L5:
        JSONObject r4 = EcomBcmTracker.c(PageFinder.via(r2), r0);
        if (r4 != null) goto L9;
        return r0;
    L9:
        return r4;
    }
}
