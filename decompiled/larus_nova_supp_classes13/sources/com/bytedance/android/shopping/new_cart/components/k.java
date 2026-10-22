package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements Runnable {
    public final /* synthetic */ CartPageCallBackComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.common.biz.callback.a d;

    public k(CartPageCallBackComponent r1, String r2, boolean r3, com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        CartPageCallBackComponent r0 = this.a;
        String r1 = this.b;
        r0.h = r1;
        switch(r1.hashCode()) {
            case -1124743790: goto L77;
            case -934641255: goto L74;
            case -906336856: goto L71;
            case -703498103: goto L66;
            case -357507885: goto L9;
            case 316254760: goto L6;
            default: goto L81;
        };
    L81:
        this.a.e.compareAndSet(-1, System.currentTimeMillis());
        CartLoadingComponent r2 = CartPageCallBackComponent.o(this.a);
        if (r2 == null) goto L92;
        CartLoadingComponent.o(r2, this.b, false, this.d, false, true, false, 40);
        return;
    L92:
        return;
    L6:
        if (r1.equals("drop_down_to_split_screen") == false) goto L81;
    L78:
        CartLoadingComponent r3 = CartPageCallBackComponent.o(this.a);
        if (r3 == null) goto L90;
        CartLoadingComponent.o(r3, this.b, false, this.d, true, true, false, 32);
        return;
    L90:
        return;
    L9:
        if (r1.equals("yata_update") == false) goto L81;
        com.bytedance.kmp.ec.yata.common.biz.callback.a r4 = this.d;
        if (r4 == null) goto L14;
        String r5 = r4.b;
        if (r5 == null) goto L14;
    L15:
        AndroidYaTaInstance r6 = (AndroidYaTaInstance) this.a.x.e.d.invoke();
        Object r7 = null;
        if (r6 == null) goto L18;
        Object r8 = r6.i("hit_client_selected");
    L20:
        if ((r8 instanceof Boolean) == true) goto L22;
        r8 = null;
    L22:
        Boolean r9 = (Boolean) r8;
        boolean r10 = false;
        if (r9 == null) goto L25;
        boolean r11 = r9.booleanValue();
    L27:
        if (r11 == false) goto L43;
        int r12 = s.a;
        List r13 = ECSettingKeys.p().b();
        if (r13 == null) goto L43;
        StringBuilder r14 = new StringBuilder();
        com.bytedance.kmp.ec.yata.common.biz.callback.a r15 = this.d;
        if (r15 == null) goto L37;
        com.bytedance.kmp.ec.yata.store.node.c r16 = r15.a;
        if (r16 == null) goto L37;
        com.bytedance.kmp.ec.yata.common.protocol.data.k r17 = r16.r();
        if (r17 == null) goto L37;
        String r18 = r17.h();
    L38:
        r14.append(r18);
        r14.append('_');
        r14.append(r5);
        if (r13.contains(r14.toString()) != true) goto L43;
        this.a.e.compareAndSet(-1, System.currentTimeMillis());
        CartLoadingComponent r19 = CartPageCallBackComponent.o(this.a);
        if (r19 == null) goto L85;
        CartLoadingComponent.o(r19, this.b, false, this.d, false, false, true, 24);
        return;
    L85:
        return;
    L37:
        r18 = null;
    L43:
        int r20 = s.a;
        List r21 = ECSettingKeys.p().d();
        if (r21 == null) goto L46;
        boolean r22 = r21.contains(r5);
    L47:
        Map<String, ?> r23 = this.a.x.e.a();
        if (r23 == null) goto L51;
        r7 = r23.get("new_del_express");
    L51:
        if (mq.b.a(r7) == true) goto L53;
    L57:
        boolean r24 = false;
    L58:
        if (r22 == true) goto L60;
        if (r24 == true) goto L60;
    L61:
        CartLoadingComponent r25 = CartPageCallBackComponent.o(this.a);
        if (r25 == null) goto L64;
        CartLoadingComponent.o(r25, this.b, this.c, this.d, !r10, true, false, 32);
    L64:
        this.a.e.compareAndSet(-1, System.currentTimeMillis());
        return;
    L60:
        r10 = true;
        goto L61
    L53:
        if (Intrinsics.areEqual(r5, "collectClick") == false) goto L55;
    L56:
        r24 = true;
        goto L58
    L55:
        if (Intrinsics.areEqual(r5, "deleteClick") == false) goto L57;
    L46:
        r22 = false;
        goto L47
    L25:
        r11 = false;
        goto L27
    L18:
        r8 = null;
    L14:
        r5 = "no-ignore-direct-loading";
        goto L15
    L66:
        if (r1.equals("first_enter") == false) goto L81;
        this.a.e.compareAndSet(-1, System.currentTimeMillis());
        CartLoadingComponent r26 = CartPageCallBackComponent.o(this.a);
        if (r26 == null) goto L88;
        CartLoadingComponent.o(r26, this.b, this.c, this.d, true, true, false, 32);
        return;
    L88:
        return;
    L71:
        if (r1.equals("search") == false) goto L81;
    L74:
        if (r1.equals("reload") == false) goto L81;
        return;
    L77:
        if (r1.equals("pull_to_full_screen") == false) goto L81;
        goto L78
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
