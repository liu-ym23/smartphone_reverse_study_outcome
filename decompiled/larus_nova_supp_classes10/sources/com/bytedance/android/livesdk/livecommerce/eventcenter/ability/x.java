package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.u0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public static final class a extends u0 {
        public a(x r2, String r3) {
            super(r3);
            f("page_name", "live_list");
            f("source_page", l0.n());
            f("ecom_entrance_form", "live_list_card");
            f("anchor_id", l0.i("anchor_id"));
            f("group_id", l0.i("group_id"));
            f("carrier_source", l0.d());
            f("source_method", l0.e());
            f("enter_from_merge", l0.d());
            f("enter_method", l0.i("enter_method"));
            f("room_id", l0.i("room_id"));
            if (r2.a.length() <= 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L9;
            f("btm_id", r2.a);
            return;
        L9:
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    public x(String r1, String r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = new a(this, this.b);     // Catch: Throwable -> L4
        r0.g(this.c);     // Catch: Throwable -> L4
        r0.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
