package vi2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.retrofit2.SsResponse;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p0 implements h.f<vj2.c> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Map f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ String k;

    @Override // vi2.h.f
    public final wi2.a<vj2.c> execute() throws Exception {
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
        r0.add(si2.k.a.a("preferred_coupon", this.e));
        Map r4 = this.f;
        if (r4 == null) goto L12;
        Iterator r5 = r4.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r6 = (Map.Entry) r5.next();
        r0.add(si2.k.a.a((String) r6.getKey(), (String) r6.getValue()));
    L12:
        r0.add(si2.k.a.a("container_room_id", this.g));
        r0.add(si2.k.a.a("entrance_info", this.h));
        r0.add(si2.k.a.a("request_scene", String.valueOf(this.i)));
        r0.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r0.add(si2.k.a.a("height_percent", String.valueOf(this.j)));
        r0.add(si2.k.a.a("enable_ab_opt", String.valueOf(EComABUtils.enableListAbOpt())));
        r0.add(si2.k.a.a("routine_optimize", String.valueOf(EComABUtils.enableServerRoutineOpt())));
        r0.add(si2.k.a.a("use_promotion_v2", String.valueOf(true)));
        r0.add(si2.k.a.a("routine_optimize_reverse_step", String.valueOf(EComABUtils.serverRoutineReverseStep())));
        String r7 = this.c;
        String r8 = this.d;
        PromotionListController.T.getClass();
        String r9 = PromotionListController.a.c(r7, r8).Q;
        if (TextUtils.isEmpty(r9) == true) goto L15;
        r0.add(si2.k.a.a("header_callback", r9));
    L15:
        Map<String, String> r10 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        SsResponse r11 = h.h(this.k, r0);
        return h.f((vj2.c) h.j(r11, vj2.c.class), r10, r11);
    L5:
        r1 = "author_id";
        goto L6
    }

    public p0(String r1, String r2, String r3, String r4, String r5, Map r6, String r7, String r8, int r9, int r10, String r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
