package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements h.f<xi2.m> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    @Override // vi2.h.f
    public final wi2.a<xi2.m> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("meta_id", r1));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r4 = h.g(this.b, r0);
        int r5 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.m) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r4, xi2.m.class), r3, null);
    }

    public j(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
