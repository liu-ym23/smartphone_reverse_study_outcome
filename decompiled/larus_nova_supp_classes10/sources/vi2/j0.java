package vi2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 implements h.f<ECPromotionList> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ int j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ int l;

    @Override // vi2.h.f
    public final wi2.a<ECPromotionList> execute() throws Exception {
        if (this.a == false) goto L6;
        boolean r1 = true;
    L9:
        FilterNullArrayList r4 = new FilterNullArrayList();
        String r5 = this.c;
        int r6 = si2.k.c;
        r4.add(si2.k.a.a("room_unique_key", r5));
        if (hh2.f.g() == false) goto L28;
        h.b(r4, this.d, true);
        r4.add(si2.k.a.a("sec_author_id", this.e));
        r4.add(si2.k.a.a("room_id", this.b));
        r4.add(si2.k.a.a("entrance_info", this.f));
        r4.add(si2.k.a.a("first_enter", String.valueOf(this.g)));
        int r2 = this.h;
        if (r2 <= 0) goto L14;
        r4.add(si2.k.a.a("apply_coupon", String.valueOf(r2)));
    L15:
        r4.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r4.add(si2.k.a.a("force_refresh", String.valueOf(this.j)));
        if (this.k == false) goto L18;
        String r7 = "1";
    L19:
        r4.add(si2.k.a.a("close_order_banner", r7));
        r4.add(si2.k.a.a("opt_entrance_info", "1"));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r4);
        if (r1 == true) goto L22;
        SsResponse r8 = h.h(si2.g.c, r4);
    L23:
        ECPromotionList r9 = (ECPromotionList) h.j(r8, ECPromotionList.class);
        if (r9 == null) goto L27;
        com.bytedance.android.livesdk.livecommerce.utils.k.l(r9.promotionList, r9.extraParam);
    L27:
        return h.f(r9, r3, r8);
    L22:
        r8 = h.i(si2.g.e, r4);
        goto L23
    L18:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L19
    L14:
        r4.add(si2.k.a.a("auto_apply_coupon", String.valueOf(this.i)));
        goto L15
    L28:
        h.b(r4, this.d, false);
        r4.add(si2.k.a.a("sec_author_id", this.e));
        r4.add(si2.k.a.a("room_id", this.b));
        r4.add(si2.k.a.a("entrance_info", this.f));
        r4.add(si2.k.a.a("first_enter", String.valueOf(this.g)));
        int r10 = this.h;
        if (r10 <= 0) goto L31;
        r4.add(si2.k.a.a("apply_coupon", String.valueOf(r10)));
    L32:
        r4.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r4.add(si2.k.a.a("force_refresh", String.valueOf(this.j)));
        if (this.k == false) goto L35;
        String r11 = "1";
    L36:
        r4.add(si2.k.a.a("close_order_banner", r11));
        r4.add(si2.k.a.a("opt_entrance_info", "1"));
        r4.add(si2.k.a.a("height_percent", String.valueOf(this.l)));
        if (TextUtils.isEmpty(this.b) == true) goto L44;
        if (r1 == true) goto L44;
        String r12 = this.b;
        String r13 = this.c;
        boolean r14 = EntryController.M1;
        String r15 = EntryController.a.b(r12, r13).M().f(IRelatedInfoManager$Scene.PROMOTION_LIST);
        int r16 = xh2.c.a;
        if (xh2.c.a(this.j) == false) goto L44;
        if (TextUtils.isEmpty(r15) == true) goto L44;
        r4.add(si2.k.a.a("related_info", r15));
    L44:
        Map<String, String> r17 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r4);
        if (this.j != 5) goto L48;
        if (r1 == true) goto L48;
        SsResponse r18 = h.h(si2.g.d, r4);
    L51:
        ECPromotionList r19 = (ECPromotionList) h.j(r18, ECPromotionList.class);
        if (r19 == null) goto L59;
        ECPromotionList.m r20 = r19.extra;
        if (r20 == null) goto L59;
        String r21 = r20.logid;
        if (r21 == null) goto L59;
        com.bytedance.android.livesdk.livecommerce.utils.k.k(r19.promotionList, r21);
    L59:
        return h.f(r19, r17, r18);
    L48:
        if (r1 == true) goto L50;
        r18 = h.h(si2.g.c, r4);
        goto L51
    L50:
        r18 = h.h(si2.g.b, r4);
        goto L51
    L35:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L36
    L31:
        r4.add(si2.k.a.a("auto_apply_coupon", String.valueOf(this.i)));
        goto L32
    L6:
        if (TextUtils.isEmpty(this.b) == true) goto L8;
        String r22 = this.b;
        String r23 = this.c;
        PromotionListController.T.getClass();
        r1 = PromotionListController.a.c(r22, r23).s();
        goto L9
    L8:
        r1 = false;
        goto L9
    }

    public j0(boolean r1, String r2, String r3, String r4, String r5, String r6, boolean r7, int r8, int r9, boolean r10, int r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = false;
        this.j = r9;
        this.k = r10;
        this.l = r11;
    }
}
