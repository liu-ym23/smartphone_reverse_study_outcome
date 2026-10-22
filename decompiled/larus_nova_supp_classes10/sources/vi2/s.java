package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements h.f<xi2.i> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    @Override // vi2.h.f
    public final wi2.a<xi2.i> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        int r1 = si2.k.c;
        r0.add(si2.k.a.a("op_type", PromotionCategory.CATEGORY_TYPE_SECOND));
        r0.add(si2.k.a.a("room_id", this.a));
        r0.add(si2.k.a.a("screenshot", this.b));
        r0.add(si2.k.a.a(LocationMonitorConst.TIMESTAMP, this.c));
        Map<String, String> r2 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r3 = h.a(this.d, r0);
        int r4 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.i) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r3, xi2.i.class), r2, null);
    }

    public s(String r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
