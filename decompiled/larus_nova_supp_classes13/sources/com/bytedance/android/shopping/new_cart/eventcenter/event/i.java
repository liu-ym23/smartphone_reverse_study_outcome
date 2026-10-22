package com.bytedance.android.shopping.new_cart.eventcenter.event;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Map e;

    public i(j r1, String r2, Function1 r3, String r4, Map r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        String r0 = this.b;
        Context r1 = this.a.b.getContext();
        Unit r2 = null;
        boolean r3 = true;
        if (r0 == null) goto L49;
        if (r1 == null) goto L49;
        if (r0.length() != 0) goto L8;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        Function1 r4 = this.c;
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    L48:
        r2 = Unit.INSTANCE;
        goto L49
    L12:
        String r7 = this.d;
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L35;
        int r9 = com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.c.a;
        Uri r10 = com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.c.a(r0, this.d, this.e, this.a.b.e.j);
        if (((Boolean) this.a.a.getValue()).booleanValue() == true) goto L24;
        int r11 = ECSdk.a;
        IAdapterService r12 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r12 == null) goto L47;
        IAdapterService.a.a(r12, r1, r10, true, 8);
    L47:
        Function1 r13 = this.c;
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r13.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        goto L48
    L24:
        if (l0.b(r1) == null) goto L47;
        nj.d r15 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r15 == null) goto L28;
        r10.toString();
        r15.i();
    L28:
        int r16 = ECSdk.a;
        IAdapterService r17 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r17 == null) goto L47;
        IAdapterService.a.a(r17, r1, r10, true, 8);
        goto L47
    L35:
        if (((Boolean) this.a.a.getValue()).booleanValue() == true) goto L37;
        int r18 = ECSdk.a;
        IAdapterService r19 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r19 == null) goto L47;
        IAdapterService.a.a(r19, r1, UriProtector.parse(r0), true, 8);
        goto L47
    L37:
        if (l0.b(r1) == null) goto L47;
        nj.d r20 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r20 == null) goto L41;
        r20.i();
    L41:
        int r21 = ECSdk.a;
        IAdapterService r22 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r22 == null) goto L47;
        IAdapterService.a.a(r22, r1, UriProtector.parse(r0), true, 8);
        goto L47
    L15:
        if (r7.length() == 0) goto L18;
        r8 = false;
        goto L20
    L8:
        r5 = false;
    L49:
        if (r2 != null) goto L61;
        String r23 = this.b;
        if (r23 != null) goto L53;
    L56:
        if (r3 == false) goto L58;
        String r24 = "schema is null";
    L59:
        String r25 = r24;
        Function1 r26 = this.c;
        int r27 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r26.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r25, null, null, 57));
        Unit r28 = Unit.INSTANCE;
        return;
    L58:
        r24 = "context is null";
        goto L59
    L53:
        if (r23.length() == 0) goto L56;
        r3 = false;
        goto L56
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
