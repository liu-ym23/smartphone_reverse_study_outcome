package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 implements h.f<xi2.g0> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    @Override // vi2.h.f
    public final wi2.a<xi2.g0> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("room_id", r1));
        r0.add(si2.k.a.a("cps_track", this.b));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r4 = h.g(si2.g.L, r0);
        int r5 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.g0) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r4, xi2.g0.class), r3, null);
    }

    public b0(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
