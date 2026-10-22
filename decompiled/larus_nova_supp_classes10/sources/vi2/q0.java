package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q0 implements h.f<ECPromotionList.o> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;

    @Override // vi2.h.f
    public final wi2.a<ECPromotionList.o> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        if (hh2.f.g() == false) goto L5;
        String r1 = "author_open_id";
    L6:
        String r2 = this.a;
        int r3 = si2.k.c;
        r0.add(si2.k.a.a(r1, r2));
        r0.add(si2.k.a.a("sec_author_id", this.b));
        r0.add(si2.k.a.a("room_id", this.c));
        r0.add(si2.k.a.a("room_unique_key", this.d));
        if (this.e == false) goto L9;
        String r4 = "1";
    L10:
        r0.add(si2.k.a.a("close_order_banner", r4));
        r0.add(si2.k.a.a("entrance_info", this.f));
        r0.add(si2.k.a.a("height_percent", String.valueOf(this.g)));
        Map<String, String> r5 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r6 = h.g(si2.g.j, r0);
        int r7 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECPromotionList.o) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r6, ECPromotionList.o.class), r5, null);
    L9:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r1 = "author_id";
        goto L6
    }

    public q0(String r1, String r2, String r3, String r4, boolean r5, String r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
