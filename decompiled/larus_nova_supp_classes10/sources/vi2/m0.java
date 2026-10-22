package vi2;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0 implements h.f<com.bytedance.android.ec.model.response.r> {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;

    @Override // vi2.h.f
    public final wi2.a<com.bytedance.android.ec.model.response.r> execute() throws Exception {
        String r0 = si2.g.a + this.a;
        JSONObject r1 = this.b;
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        FilterNullArrayList r2 = new FilterNullArrayList();
        String r3 = this.c;
        int r4 = si2.k.c;
        r2.add(si2.k.a.a("room_id", r3));
        r2.add(si2.k.a.a("room_unique_key", this.d));
        Lazy r5 = ECAppInfoService.a;
        if (we.a.a == false) goto L8;
        r2.add(si2.k.a.a("author_open_id", this.e));
    L9:
        r2.add(si2.k.a.a("entrance_info", this.f));
        if (this.g.isEmpty() == true) goto L12;
        r2.add(si2.k.a.a("cart_extra", this.g));
    L12:
        r1.put("is_ecom", this.h);
        Map<String, String> r6 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r2);
        HashMap r7 = new HashMap();
        r7.put("Agw-Js-Conv", "1");
        String r8 = h.c(r0, r2, r1, r7);
        int r9 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((com.bytedance.android.ec.model.response.r) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r8, com.bytedance.android.ec.model.response.r.class), r6, null);
    L8:
        r2.add(si2.k.a.a("author_id", this.e));
        goto L9
    }

    public m0(String r1, JSONObject r2, String r3, String r4, String r5, String r6, String r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
