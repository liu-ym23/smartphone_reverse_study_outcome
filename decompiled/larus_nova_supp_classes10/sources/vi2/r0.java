package vi2;

import com.bytedance.android.ec.model.response.ECPromotionPriceResponse;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r0 implements h.f<ECPromotionPriceResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ int i;

    @Override // vi2.h.f
    public final wi2.a<ECPromotionPriceResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        if (hh2.f.g() == false) goto L5;
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("author_open_id", r1));
    L6:
        r0.add(si2.k.a.a("sec_author_id", this.b));
        r0.add(si2.k.a.a("room_id", this.c));
        r0.add(si2.k.a.a("room_unique_key", this.d));
        r0.add(si2.k.a.a("entrance_info", this.e));
        r0.add(si2.k.a.a("op_type", this.f));
        r0.add(si2.k.a.a("product_ids", this.g));
        r0.add(si2.k.a.a("promotion_ids", this.h));
        r0.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r0.add(si2.k.a.a("request_status", String.valueOf(this.i)));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        SsResponse r4 = h.h(si2.g.l, r0);
        return h.f((ECPromotionPriceResponse) h.j(r4, ECPromotionPriceResponse.class), r3, r4);
    L5:
        String r5 = this.a;
        int r6 = si2.k.c;
        r0.add(si2.k.a.a("author_id", r5));
        goto L6
    }

    public r0(String r1, String r2, String r3, String r4, String r5, String r6, String r7, int r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = "3";
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }
}
