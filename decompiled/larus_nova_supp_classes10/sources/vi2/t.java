package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECApplyCouponResponse;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements h.f<ECApplyCouponResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    @Override // vi2.h.f
    public final wi2.a<ECApplyCouponResponse> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        int r1 = RoomContextController.h;
        RoomContextController.a.a();
        String r2 = this.a;
        int r3 = si2.k.c;
        r0.add(si2.k.a.a("price", r2));
        r0.add(si2.k.a.a("product_id", this.b));
        r0.add(si2.k.a.a("promotion_id", this.c));
        r0.add(si2.k.a.a("shop_id", this.d));
        r0.add(si2.k.a.a("room_id", this.e));
        r0.add(si2.k.a.a("author_id", this.f));
        r0.add(si2.k.a.a("sec_author_id", this.g));
        r0.add(si2.k.a.a("ecom_scene_id", this.h));
        r0.add(si2.k.a.a("author_open_id", this.f));
        Map<String, String> r4 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        if (hh2.f.g() == false) goto L5;
        String r5 = h.a(si2.g.C, r0);
    L6:
        int r6 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECApplyCouponResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r5, ECApplyCouponResponse.class), r4, null);
    L5:
        r5 = h.a(si2.g.B, r0);
        goto L6
    }

    public t(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
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
