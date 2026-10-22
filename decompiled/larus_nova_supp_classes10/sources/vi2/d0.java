package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0 implements h.f<xi2.e0> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    @Override // vi2.h.f
    public final wi2.a<xi2.e0> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("bizID", r1));
        r0.add(si2.k.a.a("uniqueID", this.b));
        r0.add(si2.k.a.a("extraParams", this.c));
        r0.add(si2.k.a.a("taskMetaID", this.d));
        r0.add(si2.k.a.a("taskItemID", this.e));
        r0.add(si2.k.a.a("scene", this.f));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r4 = h.a(si2.g.N, r0);
        int r5 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.e0) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r4, xi2.e0.class), r3, null);
    }

    public d0(String r2, String r3, String r4) {
        this.a = "5";
        this.b = "";
        this.c = "";
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
