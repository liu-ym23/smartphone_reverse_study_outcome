package vi2;

import android.text.TextUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l0 implements h.f<com.bytedance.android.ec.model.response.r> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;

    @Override // vi2.h.f
    public final wi2.a<com.bytedance.android.ec.model.response.r> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("room_id", r1));
        r0.add(si2.k.a.a("room_unique_key", this.b));
        Lazy r3 = ECAppInfoService.a;
        if (we.a.a == false) goto L5;
        r0.add(si2.k.a.a("author_open_id", this.c));
    L6:
        r0.add(si2.k.a.a("is_linkmic", String.valueOf(this.d)));
        r0.add(si2.k.a.a("is_ecom", String.valueOf(this.e)));
        r0.add(si2.k.a.a("sec_author_id", this.f));
        r0.add(si2.k.a.a("entrance_info", this.g));
        if (this.h.isEmpty() == true) goto L9;
        r0.add(si2.k.a.a("cart_extra", this.h));
    L9:
        r0.add(si2.k.a.a("enter_room_extra", this.i));
        r0.add(si2.k.a.a("related_info", this.j));
        r0.add(si2.k.a.a("group_id", this.k));
        if (TextUtils.isEmpty(this.l) == true) goto L13;
        r0.add(si2.k.a.a("preview_button_info", this.l));
    L13:
        if (TextUtils.isEmpty(this.m) == true) goto L15;
        r0.add(si2.k.a.a("coupon_passthrough_params", this.m));
    L15:
        Map<String, String> r4 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        String r5 = h.g(si2.g.P, r0);
        int r6 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((com.bytedance.android.ec.model.response.r) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r5, com.bytedance.android.ec.model.response.r.class), r4, null);
    L5:
        r0.add(si2.k.a.a("author_id", this.c));
        goto L6
    }

    public l0(String r1, String r2, String r3, boolean r4, boolean r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13) {
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
        this.l = r12;
        this.m = r13;
    }
}
