package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public a0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Boolean r6 = (Boolean) r5;
        if (KtvSettingHelper.b().booleanValue() == true) goto L5;
    L7:
        this.a.f = r6;
        RealTimeChorusBusinessContext.a r7 = RealTimeChorusBusinessContext.Companion;
        int r0 = r7.b();
        boolean r1 = false;
        boolean r3 = true;
        if (r0 == 2) goto L13;
        if (r0 == 1) goto L13;
        r3 = false;
    L13:
        if (KtvSettingHelper.b().booleanValue() == false) goto L21;
        RealTimeChorusBusinessContext r8 = r7.getContext();
        if (r8 == null) goto L22;
        com.bytedance.live.datacontext.j<fd2.s> r9 = r8.m454getService();
        if (r9 == null) goto L22;
        fd2.s r10 = (fd2.s) r9.getValue();
        if (r10 == null) goto L22;
        r1 = r10.Y5();
    L22:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r11 = this.a.Q;
        if (r11 == null) goto L27;
        r11.h(r3, r1);
        return;
    L27:
        return;
    L21:
        r1 = r7.e();
        goto L22
    L5:
        if (Intrinsics.areEqual(this.a.f, r6) == false) goto L7;
        w.a("RealTimeChorusMainViewWidget", "hasBgm not change so return");
    }
}
