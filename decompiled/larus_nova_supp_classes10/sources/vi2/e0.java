package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0 implements h.f<xi2.d0> {
    public e0() {
    }

    @Override // vi2.h.f
    public final wi2.a<xi2.d0> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        Map<String, String> r1 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r2 = h.g(si2.g.J, r0);
        int r3 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.d0) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r2, xi2.d0.class), r1, null);
    }
}
