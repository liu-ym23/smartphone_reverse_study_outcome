package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.view.View;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e b;
    public final /* synthetic */ i.a c;

    public j(i r1, com.bytedance.kmp.ec.yata.event.common.e r2, i.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        AndroidYaTaInstance r10 = this.a.g;
        if (r10 == null) goto L11;
        YataEventCenter r11 = r10.k();
        if (r11 == null) goto L11;
        com.bytedance.kmp.ec.yata.event.common.e.a r0 = com.bytedance.kmp.ec.yata.event.common.e.a;
        AndroidYaTaInstance r1 = this.a.g;
        com.bytedance.kmp.ec.yata.common.platform.o r2 = this.b.m();
        com.bytedance.kmp.ec.yata.store.node.c r3 = this.b.j();
        if (r3 == null) goto L9;
        String r4 = r3.getKey();
    L10:
        i.a r5 = this.c;
        r11.d(r0.a(r1, r2, r4, r5.c, r5.a, "OrderCommonOrderShowMoreMenuFunction"));
        goto L11
    L9:
        r4 = null;
    L11:
        Function0<Unit> r12 = this.a.d;
        if (r12 == null) goto L15;
        Unit r13 = (Unit) r12.invoke();
        return;
    }
}
