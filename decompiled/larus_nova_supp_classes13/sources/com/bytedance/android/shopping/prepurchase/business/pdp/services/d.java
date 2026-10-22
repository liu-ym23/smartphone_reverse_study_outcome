package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.text.ClipboardManager;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import vg3.f0;
import vg3.u;
import vg3.w;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends b0 {
    public static final /* synthetic */ int m = 0;
    public String i;
    public Integer j;
    public boolean k;
    public boolean l;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{u.class, f0.class, x.class, w.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.f r0 = O1().e();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "updateAddress", false, new PdpCommonBridgeService$registerJsHandler$1(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "ecom_coupon_exchange_success", false, new PdpCommonBridgeService$registerJsHandler$2(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "MemberJoinResult", false, new PdpCommonBridgeService$registerJsHandler$3(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "triggerPdpEvent", PdpAB.a(), new PdpCommonBridgeService$registerJsHandler$4(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "lynxCardSendLog", false, new PdpCommonBridgeService$registerJsHandler$5(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "apt_copy", false, new PdpCommonBridgeService$registerJsHandler$6(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "updateSelectedCarModel", false, new PdpCommonBridgeService$registerJsHandler$7(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "closePDPHalfPanel", false, new PdpCommonBridgeService$registerJsHandler$8(this));
        Z1(x.class, new PdpCommonBridgeService$registerNetworkInterceptor$1(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().w.getValue(), this, new c(this));
    }

    public d() {
    }

    public static void b2(ClipboardManager r18, CharSequence r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101812);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101812, "android/text/ClipboardManager", "setText", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setText(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
