package vi2;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n0 implements h.f<xi2.b0> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // vi2.h.f
    public final wi2.a<xi2.b0> execute() throws Exception {
        String r0 = si2.g.a + "/live/promotions/public_comment/action/";
        JSONObject r1 = new JSONObject();
        FilterNullArrayList r2 = new FilterNullArrayList();
        String r3 = this.a;
        int r4 = si2.k.c;
        r2.add(si2.k.a.a("room_id", r3));
        r2.add(si2.k.a.a("room_unique_key", this.b));
        Lazy r5 = ECAppInfoService.a;
        if (we.a.a == false) goto L5;
        r2.add(si2.k.a.a("author_open_id", this.c));
    L6:
        r2.add(si2.k.a.a("entrance_info", this.d));
        r2.add(si2.k.a.a("product_id", this.e));
        Map<String, String> r6 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r2);
        HashMap r7 = new HashMap();
        r7.put("Agw-Js-Conv", "1");
        String r8 = h.c(r0, r2, r1, r7);
        int r9 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.b0) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r8, xi2.b0.class), r6, null);
    L5:
        r2.add(si2.k.a.a("author_id", this.c));
        goto L6
    }

    public n0(String r1, String r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
