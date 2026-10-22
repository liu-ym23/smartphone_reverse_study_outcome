package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;
import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Function1<k0, Boolean> {
    public boolean a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore> b;
    public final f0 c;

    public final Object invoke(Object r9) {
        k0 r10 = (k0) r9;
        Intrinsics.checkNotNullParameter(r10, "options");
        boolean r0 = false;
        if (r10.c == false) goto L60;
        Function1<String, Unit> r11 = new ClosePanelInterceptor$invoke$intercepted$1(this);
        Intrinsics.checkNotNullParameter(r11, "popAction");
        Control r1 = this.b.getData().c();
        if (r1 == null) goto L56;
        e73.g r2 = r1.getPopupWithClose();
        if (r2 == null) goto L56;
        if (com.bytedance.android.shopping.anchorv3.a.b(r2.c()) == false) goto L12;
    L15:
        boolean r3 = true;
    L16:
        String r4 = r2.b();
        String r6 = "";
        if (com.bytedance.android.shopping.anchorv3.a.b(r4) == false) goto L25;
        com.bytedance.android.ec.sdk.helper.q r5 = com.bytedance.android.ec.sdk.helper.q.a;
        if (r4 != null) goto L21;
        String r7 = "";
    L23:
        if (r5.getInt(r7, 0) <= 0) goto L25;
        boolean r8 = false;
    L26:
        if (r8 == false) goto L56;
        if (r3 == false) goto L56;
        if (com.bytedance.android.shopping.anchorv3.a.b(r4) == false) goto L39;
        com.bytedance.android.ec.sdk.helper.q r12 = com.bytedance.android.ec.sdk.helper.q.a;
        if (r4 != null) goto L33;
        String r13 = "";
    L34:
        int r14 = r12.getInt(r13, 0) + 1;
        if (r4 != null) goto L37;
        r4 = "";
    L37:
        r12.d(r4, r14);
    L43:
        if (com.bytedance.android.shopping.anchorv3.a.b(r2.c()) == false) goto L50;
        String r15 = r2.c();
        if (r15 == null) goto L48;
        r6 = r15;
    L48:
        r11.invoke(r6);
        boolean r16 = true;
    L57:
        if (r16 == false) goto L60;
        r0 = true;
        goto L60
    L50:
        if (com.bytedance.android.shopping.anchorv3.a.b(r2.a()) == false) goto L56;
        String r17 = r2.a();
        if (r17 == null) goto L55;
        r6 = r17;
    L55:
        r11.invoke(r6);
        goto L56
    L33:
        r13 = r4;
        goto L34
    L39:
        if (this.a == true) goto L56;
        this.a = true;
        goto L43
    L21:
        r7 = r4;
    L25:
        r8 = true;
        goto L26
    L12:
        if (com.bytedance.android.shopping.anchorv3.a.b(r2.a()) == true) goto L15;
        r3 = false;
    L56:
        r16 = false;
    L60:
        return Boolean.valueOf(r0);
    }

    public a(com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore> r2, f0 r3) {
        Intrinsics.checkNotNullParameter(r2, "dataFetchAbility");
        this.b = r2;
        this.c = r3;
    }
}
