package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 implements h.f<xi2.o> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ long m;
    public final /* synthetic */ String n;
    public final /* synthetic */ int o;
    public final /* synthetic */ String p;
    public final /* synthetic */ String[] q;
    public final /* synthetic */ String r;

    @Override // vi2.h.f
    public final wi2.a<xi2.o> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("product_name", r1));
        r0.add(si2.k.a.a("target_uid", this.b));
        r0.add(si2.k.a.a("cover", this.c));
        r0.add(si2.k.a.a("stock_num", this.d));
        r0.add(si2.k.a.a("price", this.e));
        r0.add(si2.k.a.a("note", this.f));
        r0.add(si2.k.a.a("cids", this.g));
        r0.add(si2.k.a.a("room_id", this.h));
        r0.add(si2.k.a.a("room_unique_key", this.i));
        r0.add(si2.k.a.a("properties", this.j));
        r0.add(si2.k.a.a("barcode_info", this.k));
        r0.add(si2.k.a.a("sku_state", this.l));
        r0.add(si2.k.a.a("delivery_delay_time", String.valueOf(this.m)));
        r0.add(si2.k.a.a("supply_day_return_code", this.n));
        int r3 = this.o;
        if (r3 == 0) goto L5;
        r0.add(si2.k.a.a("stock_reduction", String.valueOf(r3)));
    L5:
        String r4 = this.p;
        if (r4 == null) goto L8;
        r0.add(si2.k.a.a("deposit_find_goods_option_json", r4));
    L8:
        String[] r5 = this.q;
        if (r5 != null) goto L11;
    L16:
        Map<String, String> r6 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r7 = h.a(this.r, r0);
        int r8 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((xi2.o) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r7, xi2.o.class), r6, null);
    L11:
        if (r5.length <= 0) goto L16;
        StringBuilder r9 = new StringBuilder();
        String[] r10 = this.q;
        int r11 = r10.length;
        int r12 = 0;
    L13:
        if (r12 >= r11) goto L15;
        r9.append(r10[r12]);
        r9.append(',');
        r12 = r12 + 1;
        goto L13
    L15:
        r9.deleteCharAt(r9.length() - 1);
        r0.add(si2.k.a.a("privileges", r9.toString()));
        goto L16
    }

    public a0(String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, long r16, String r18, int r19, String r20, String[] r21, String r22) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
        this.r = r22;
    }
}
