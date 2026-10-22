package f93;

import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(JSONObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "obj");
        Intrinsics.checkNotNullParameter(r2, "btmID");
        r1.put("btm_id", r2);
    }

    public static Map b(Map r4, PageFinder r5, boolean r6) {
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L4
    L5:
        String r7 = r0.optString("btm");
        JSONObject r1 = r0.optJSONObject("bcm");
        JSONObject r8 = BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r7, Boolean.valueOf(r6)).withPageFinder(r5).build());
        if (r6 == false) goto L9;
        if (r1 == null) goto L9;
        BcmParams r2 = new BcmParams().merge(r1);
        b.a.appendUnitParams(r5, "ecom_entrance", r2);
    L9:
        if (r6 == false) goto L12;
        return MapsKt.emptyMap();
    L12:
        return cd.a.e(r8);
    L4:
        r0 = new JSONObject();
        goto L5
    }

    public static String a(String r2, boolean r3, View r4, BcmParams r5) {
        Intrinsics.checkNotNullParameter(r2, "btm");
        BtmSDK r0 = BtmSDK.INSTANCE;
        BtmItemBuilder r6 = new BtmItemBuilder(r2, Boolean.valueOf(r3)).withView(r4);
        if (r5 == null) goto L5;
        r6.internalSetUnitParams("description", r5);
    L5:
        Unit r7 = Unit.INSTANCE;
        return r0.createBtmId(r6.build());
    }
}
