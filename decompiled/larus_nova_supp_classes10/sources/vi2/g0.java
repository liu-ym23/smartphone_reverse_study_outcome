package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 implements h.f<xi2.t> {
    public g0() {
    }

    @Override // vi2.h.f
    public final wi2.a<xi2.t> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        int r1 = si2.k.c;
        r0.add(si2.k.a.a("count", "1"));
        Map<String, String> r2 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r3 = h.g(si2.g.K, r0);
        int r4 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.t) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r3, xi2.t.class), r2, null);
    }
}
