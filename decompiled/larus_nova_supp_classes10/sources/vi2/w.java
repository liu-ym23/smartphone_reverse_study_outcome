package vi2;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.ECPromotionCheckResponse;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements h.f<ECPromotionCheckResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ String n;
    public final /* synthetic */ int o;
    public final /* synthetic */ int p;
    public final /* synthetic */ int q;
    public final /* synthetic */ String r;
    public final /* synthetic */ Map s;
    public final /* synthetic */ int t;
    public final /* synthetic */ String u;

    @Override // vi2.h.f
    public final wi2.a<ECPromotionCheckResponse> execute() throws Exception {
        if (hh2.f.g() == false) goto L9;
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r11 = this.a;
        int r22 = si2.k.c;
        r0.add(si2.k.a.a("promotion_id", r11));
        r0.add(si2.k.a.a("product_id", this.b));
        r0.add(si2.k.a.a("status", String.valueOf(this.c)));
        r0.add(si2.k.a.a("room_id", this.d));
        r0.add(si2.k.a.a("room_unique_key", this.e));
        r0.add(si2.k.a.a("container_room_id", this.f));
        h.b(r0, this.g, true);
        r0.add(si2.k.a.a("sec_author_id", this.h));
        r0.add(si2.k.a.a("entrance_info", this.i));
        r0.add(si2.k.a.a("page_init_timestamp", String.valueOf(System.currentTimeMillis())));
        r0.add(si2.k.a.a("opt_entrance_info", "1"));
        r0.add(si2.k.a.a("click_type", String.valueOf(this.j)));
        r0.add(si2.k.a.a("source_page", String.valueOf(this.k)));
        r0.add(si2.k.a.a("click_enter_from", String.valueOf(this.l)));
        r0.add(si2.k.a.a("use_promotion_v2", String.valueOf(this.m)));
        r0.add(si2.k.a.a("check_callback", this.n));
        r0.add(si2.k.a.a("enable_schema_opt", String.valueOf(this.o)));
        int r2 = this.p;
        if (r2 <= 0) goto L7;
        r0.add(si2.k.a.a("request_scene", String.valueOf(r2)));
    L7:
        r0.add(si2.k.a.a("combo_num", String.valueOf(this.q)));
        Map<String, String> r3 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        return h.f((ECPromotionCheckResponse) h.j(h.h(this.r, r0), ECPromotionCheckResponse.class), r3, null);
    L9:
        FilterNullArrayList r1 = new FilterNullArrayList();
        String r5 = this.a;
        int r21 = si2.k.c;
        r1.add(si2.k.a.a("promotion_id", r5));
        r1.add(si2.k.a.a("product_id", this.b));
        r1.add(si2.k.a.a("status", String.valueOf(this.c)));
        r1.add(si2.k.a.a("room_id", this.d));
        r1.add(si2.k.a.a("room_unique_key", this.e));
        r1.add(si2.k.a.a("container_room_id", this.f));
        h.b(r1, this.g, false);
        r1.add(si2.k.a.a("sec_author_id", this.h));
        r1.add(si2.k.a.a("entrance_info", this.i));
        r1.add(si2.k.a.a("page_init_timestamp", String.valueOf(System.currentTimeMillis())));
        r1.add(si2.k.a.a("click_enter_from", String.valueOf(this.l)));
        r1.add(si2.k.a.a("opt_entrance_info", "1"));
        r1.add(si2.k.a.a("click_type", String.valueOf(this.j)));
        r1.add(si2.k.a.a("use_promotion_v2", String.valueOf(this.m)));
        r1.add(si2.k.a.a("enable_schema_opt", String.valueOf(this.o)));
        r1.add(si2.k.a.a("check_callback", this.n));
        Map r4 = this.s;
        if (r4 == null) goto L15;
        Iterator r6 = r4.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        Map.Entry r7 = (Map.Entry) r6.next();
        r1.add(si2.k.a.a((String) r7.getKey(), (String) r7.getValue()));
    L15:
        int r8 = this.p;
        if (r8 <= 0) goto L18;
        r1.add(si2.k.a.a("request_scene", String.valueOf(r8)));
    L18:
        int r9 = this.k;
        if (r9 <= 0) goto L21;
        r1.add(si2.k.a.a("source_page", String.valueOf(r9)));
    L21:
        r1.add(si2.k.a.a("height_percent", String.valueOf(this.t)));
        String r10 = this.u;
        if (r10 != null) goto L24;
    L26:
        r1.add(si2.k.a.a("combo_num", String.valueOf(this.q)));
        r1.add(si2.k.a.a("enable_ab_opt", String.valueOf(EComABUtils.enableListAbOpt())));
        Map<String, String> r12 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r1);
        ECPromotionCheckResponse r13 = (ECPromotionCheckResponse) h.j(h.h(this.r, r1), ECPromotionCheckResponse.class);
        int r14 = ECSdk.a;     // Catch: Exception -> L36
        IECAPTService r15 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L36
        if (r15 == null) goto L39;
        if (r13 == null) goto L39;
        String r16 = r13.getLogId();     // Catch: Exception -> L36
        String r17 = this.r;     // Catch: Exception -> L36
        String r18 = this.a;     // Catch: Exception -> L36
        if (r16 != null) goto L34;
        r16 = "";
    L34:
        String r19 = r16;
        String r110 = r13.getOrderUrl();     // Catch: Exception -> L36
        int r20 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L36
        r15.record(new si2.l(r17, r18, r19, null, r110, com.bytedance.android.livesdk.livecommerce.utils.m0.a.a.toJson(r13.getJumpDestination()), null));     // Catch: Exception -> L36
    L39:
        return h.f(r13, r12, null);
    L36:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L39
    L24:
        if (r10.isEmpty() == true) goto L26;
        r1.add(si2.k.a.a("order_mask_alpha", this.u));
        goto L26
    }

    public w(String r3, String r4, int r5, String r6, String r7, String r8, String r9, String r10, String r11, int r12, int r13, int r14, boolean r15, String r16, int r17, int r18, int r19, String r20, Map r21, int r22) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = null;
    }
}
