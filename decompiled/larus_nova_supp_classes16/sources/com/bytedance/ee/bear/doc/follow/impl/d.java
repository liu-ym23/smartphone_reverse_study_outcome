package com.bytedance.ee.bear.doc.follow.impl;

import android.text.TextUtils;
import com.bytedance.ee.bear.doc.follow.FollowInvokeResult;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNDestroyData;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamInvoke;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamSendEvent;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class d implements py4.j {
    public BaseFollowImpl a;

    public d() {
    }

    public abstract void k();

    public abstract String l(String r1, String r2, String r3);

    public abstract String m();

    public abstract void n(RNDestroyData r1);

    public abstract void o(RNParamInvoke r1);

    public abstract void p(RNParamRegisterEventHandler r1, ry4.a r2);

    public abstract void q(RNParamSendEvent r1);

    public abstract void r(RNParamRegisterEventHandler r1);

    @Override // py4.j
    public final void a(String r2) {
        n(new RNDestroyData(r2));
        py4.e r3 = c();
        r3.c.clear();
        r3.a.clear();
        r3.b.clear();
    }

    @Override // py4.j
    public final void b(FollowInvokeResult r3) {
        if (r3 != null) goto L4;
    L10:
        tt5.a.k(m(), "onInvokeResult no callbackId");
        return;
    L4:
        if (TextUtils.isEmpty(r3.callbackId) == true) goto L10;
        py4.f r0 = c().b(r3.callbackId);
        if (r0 == null) goto L12;
        r0.b(r3);
        return;
    }

    @Override // py4.j
    public final ry4.a d(RNFollowEvent r3) {
        String r4 = l(r3.token, r3.module, r3.eventType);
        return c().a(r4);
    }

    @Override // py4.j
    public final py4.k<? extends NonProguard> h(RNFollowEvent r3) {
        String r4 = l(r3.token, r3.module, r3.eventType);
        py4.e r0 = c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "registerKey");
        return r0.b.get(r4);
    }

    @Override // py4.j
    public void onEvent(RNFollowEvent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = l(r4.token, r4.module, r4.eventType);
        ry4.a r1 = c().a(r0);
        if (r1 == null) goto L8;
        r1.onEvent(r4);
        return;
    }

    @Override // py4.j
    public final void i(String r5, String r6, String r7) {
        k();
        tt5.a.h(m(), "unRegisterEventHandler:" + du5.b.g(r5) + "," + r6 + "," + r7);
        String r0 = l(r5, r6, r7);
        py4.e r1 = c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "registerKey");
        r1.a.remove(r0);
        py4.e r2 = c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "registerKey");
        r2.b.remove(r0);
        tt5.a.b(m(), "unRegisterEventHandler: registeredKey=" + new ArrayList(c().a.keySet()));
        r(new RNParamRegisterEventHandler(r5, r6, r7));
    }

    @Override // py4.j
    public final void j(py4.k<? extends NonProguard> r9, ry4.a r10, py4.a r11) {
        String r0 = l(r11.a, r11.b, r11.c);
        py4.e r1 = c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "registerKey");
        Intrinsics.checkNotNullParameter(r9, "parserHandler");
        r1.b.put(r0, r9);
        f(r11.a, r11.b, r11.c, r10, r11.d);
    }

    @Override // py4.j
    public final void g(String r2, String r3, String r4, String r5) {
        k();
        q(new RNParamSendEvent(r2, r3, r4, r5));
    }

    @Override // py4.j
    public final String e(final String r9, final String r10, String r11, String r12, py4.f r13) {
        k();
        if (r13 != null) goto L5;
        final String r14 = "Empty";
    L7:
        if ("replayActions".equals(r10) == false) goto L9;
    L11:
        com.bytedance.ee.util.ui.j.d(new c(this, r14, r10, r9), 5000);
        o(new RNParamInvoke(r9, r10, r11, r12, r14));
        return r14;
    L9:
        if ("getCurrentStatus".equals(r10) == true) goto L11;
        tt5.a.h(m(), "invoke:" + r10);
        goto L11
    L5:
        py4.e r0 = c();
        r0.getClass();
        String r1 = Integer.toHexString(r13.hashCode());
        py4.f r16 = r0.c.put(r1, r13);
        r14 = r1;
        goto L7
    }

    @Override // py4.j
    public final void f(String r5, String r6, String r7, ry4.a r8, boolean r9) {
        k();
        tt5.a.h(m(), "registerEventHandler:" + du5.b.g(r5) + "," + r6 + "," + r7);
        String r0 = l(r5, r6, r7);
        if (r8 == null) goto L5;
        py4.e r1 = c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "registerKey");
        Intrinsics.checkNotNullParameter(r8, "eventHandler");
        r1.a.put(r0, r8);
        tt5.a.b(m(), "registerEventHandler: registeredKey=" + new ArrayList(c().a.keySet()));
    L5:
        p(new RNParamRegisterEventHandler(r5, r6, r7, r9), r8);
    }
}
