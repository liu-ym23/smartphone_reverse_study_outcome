package com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ long d;
    public final /* synthetic */ a e;

    public d(JSONObject r1, String r2, JSONObject r3, long r4, a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void a() {
        v r0 = new v("livesdk_coupon_window_show_duration", this.e.p);
        Pair[] r1 = new Pair[12];
        r1[0] = TuplesKt.to("page_name", "live");
        r1[1] = TuplesKt.to("module_label", "live");
        r1[2] = TuplesKt.to("request_id", String.valueOf(this.e.k));
        JSONObject r2 = this.a;
        if (r2 == null) goto L5;
        String r3 = JSONObjectProtectorUtils.getString(r2, "coupon_key");
    L6:
        String r5 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1[3] = TuplesKt.to("kol_user_tag", r3);
        JSONObject r4 = this.a;
        if (r4 == null) goto L12;
        String r6 = JSONObjectProtectorUtils.getString(r4, "coupon_meta_id");
    L13:
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r1[4] = TuplesKt.to("coupon_meta_id", r6);
        JSONObject r7 = this.a;
        if (r7 == null) goto L18;
        String r8 = JSONObjectProtectorUtils.getString(r7, "coupon_id");
    L19:
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        r1[5] = TuplesKt.to("coupon_id", r8);
        r1[6] = TuplesKt.to("user_auth_type", this.b);
        r1[7] = TuplesKt.to("previous_page", this.e.i.a);
        r1[8] = TuplesKt.to("window_type", "mini");
        JSONObject r9 = this.a;
        if (r9 == null) goto L24;
        String r10 = JSONObjectProtectorUtils.getString(r9, "coupon_key");
    L25:
        if (r10 != null) goto L27;
        r10 = "";
    L27:
        r1[9] = TuplesKt.to("organize_type", r10);
        JSONObject r11 = this.c;
        if (r11 == null) goto L30;
        String r12 = JSONObjectProtectorUtils.getString(r11, "is_from_ug");
    L31:
        if (r12 == null) goto L34;
        r5 = r12;
    L34:
        r1[10] = TuplesKt.to("is_from_ug", r5);
        r1[11] = TuplesKt.to("show_duration", String.valueOf(this.d));
        r0.d(MapsKt.mapOf(r1));
        r0.i(null);
        return;
    L30:
        r12 = null;
        goto L31
    L24:
        r10 = null;
        goto L25
    L18:
        r8 = null;
        goto L19
    L12:
        r6 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
