package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.event.ability.uplink.response.UplinkFailedException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ CartPageCallBackComponent a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ UplinkFailedException c;

    public j(CartPageCallBackComponent r1, boolean r2, UplinkFailedException r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        CartBodyComponent r0 = this.a.p();
        if (r0 == null) goto L5;
        r0.n();
    L5:
        vf3.a r1 = this.a.d.getMultiUpdateImpl();
        if (r1 == null) goto L16;
        boolean r2 = this.b;
        dm.a.a("cart MultiUpdateImpl").i("onUpdateEnd: success: " + r2 + "，enable: " + r1.b + ", hitClick: " + r1.n());
        if (r1.b == false) goto L16;
        if (r1.n() == false) goto L16;
        if (r2 == true) goto L16;
        r1.q();
    L16:
        if (this.b == true) goto L27;
        List r3 = ECSettingKeys.p().p();
        if (r3 == null) goto L28;
        List r4 = r3;
        UplinkFailedException r5 = this.c;
        if (r5 == null) goto L22;
        Integer r6 = Integer.valueOf(r5.getStatusCode());
    L24:
        if (CollectionsKt.contains(r4, r6) != true) goto L29;
        CartViewModel.doQuery$default(this.a.d, false, "reload", null, 4, null);
        return;
    L29:
        return;
    L22:
        r6 = null;
        goto L24
    L28:
        return;
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
