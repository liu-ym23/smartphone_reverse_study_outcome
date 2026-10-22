package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s0 implements h.f<ECPromotionList> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    @Override // vi2.h.f
    public final wi2.a<ECPromotionList> execute() throws Exception {
        if (hh2.f.g() == false) goto L9;
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r7 = this.a;
        int r8 = si2.k.c;
        r0.add(si2.k.a.a("author_open_id", r7));
        r0.add(si2.k.a.a("sec_author_id", this.b));
        r0.add(si2.k.a.a("room_id", this.c));
        r0.add(si2.k.a.a("room_unique_key", this.d));
        r0.add(si2.k.a.a("meta_id", this.e));
        r0.add(si2.k.a.a("entrance_info", this.f));
        Map<String, String> r2 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r1 = h.g(si2.g.n, r0);
        int r3 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        ECPromotionList r4 = (ECPromotionList) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r1, ECPromotionList.class);
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.livecommerce.utils.k.l(r4.promotionList, r4.extraParam);
    L8:
        return h.f(r4, r2, null);
    L9:
        FilterNullArrayList r5 = new FilterNullArrayList();
        String r9 = this.a;
        int r10 = si2.k.c;
        r5.add(si2.k.a.a("author_id", r9));
        r5.add(si2.k.a.a("sec_author_id", this.b));
        r5.add(si2.k.a.a("room_id", this.c));
        r5.add(si2.k.a.a("room_unique_key", this.d));
        r5.add(si2.k.a.a("meta_id", this.e));
        r5.add(si2.k.a.a("entrance_info", this.f));
        Map<String, String> r6 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r5);
        String r11 = h.g(si2.g.m, r5);
        int r12 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        ECPromotionList r13 = (ECPromotionList) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r11, ECPromotionList.class);
        ECPromotionList.m r14 = r13.extra;
        if (r14 == null) goto L15;
        String r15 = r14.logid;
        if (r15 == null) goto L15;
        com.bytedance.android.livesdk.livecommerce.utils.k.k(r13.promotionList, r15);
    L15:
        return h.f(r13, r6, null);
    }

    public s0(String r1, String r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = "";
        this.f = r5;
    }
}
