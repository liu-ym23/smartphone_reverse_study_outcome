package com.bytedance.android.livesdk.livecommerce.iron.category;

import com.bytedance.android.livesdk.livecommerce.event.a1;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Runnable {
    public final /* synthetic */ CategoryListAdapter a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ PromotionCategory c;
    public final /* synthetic */ List d;
    public final /* synthetic */ Boolean e;

    public a(CategoryListAdapter r1, boolean r2, PromotionCategory r3, List r4, Boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        int r0 = a1.d;
        boolean r1 = false;
        String r2 = a1.a.a(this.b, false, false);
        com.bytedance.android.ec.common.api.jump.model.b r3 = this.a.k;
        if (r3 != null) goto L5;
        r3 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L5:
        v r4 = new v(r2, r3);
        String r5 = this.c.getId();
        if (r5.length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        String r7 = null;
        if (r6 == true) goto L13;
        r5 = null;
    L13:
        String r8 = BDLocationException.ERROR_TIMEOUT;
        if (r5 != null) goto L16;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L16:
        r4.c("live_tab_id", r5);
        r4.c("tab_rank", String.valueOf(this.d.indexOf(this.c) + 1));
        List<String> r9 = this.c.getPromotionIds();
        if (r9 == null) goto L19;
        int r10 = r9.size();
    L20:
        r4.a("product_cnt", r10);
        r4.a("tab_row", this.c.getTabRow());
        String r11 = this.c.getCategoryType();
        if (r11.length() <= 0) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == true) goto L27;
        r11 = null;
    L27:
        if (r11 != null) goto L29;
        r11 = BDLocationException.ERROR_TIMEOUT;
    L29:
        r4.c("tab_type", r11);
        if (this.c.isResorted() == false) goto L32;
        String r13 = "1";
    L33:
        r4.c("is_resorted", r13);
        r4.c("tab_name", this.c.getName());
        String r14 = this.c.getUniqueIndex();
        if (r14.length() <= 0) goto L36;
        r1 = true;
    L36:
        if (r1 == false) goto L38;
        r7 = r14;
    L38:
        if (r7 != null) goto L40;
        r7 = BDLocationException.ERROR_TIMEOUT;
    L40:
        r4.c("tab_unique_index", r7);
        if (this.b == true) goto L48;
        Boolean r15 = this.e;
        if (r15 == null) goto L48;
        if (r15.booleanValue() == false) goto L47;
        r8 = "1";
    L47:
        r4.c("is_current_tab", r8);
    L48:
        r4.i("a1.b0715.c19983.d579112_i" + this.d.indexOf(this.c));
        return;
    L32:
        r13 = BDLocationException.ERROR_TIMEOUT;
        goto L33
    L23:
        r12 = false;
        goto L24
    L19:
        r10 = 0;
        goto L20
    L8:
        r6 = false;
        goto L9
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
