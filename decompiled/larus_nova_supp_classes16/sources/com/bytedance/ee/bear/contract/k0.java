package com.bytedance.ee.bear.contract;

import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k0 {
    public static int a(Throwable r1) {
        if (r1 != null) goto L4;
        return -1;
    L4:
        if ((r1 instanceof NetService.ServerErrorException) == true) goto L6;
        return -1;
    L6:
        return ((NetService.ServerErrorException) r1).getCode();
    }

    public static boolean b(int r5) {
        if (eu5.b.a() != null) goto L6;
        return false;
    L6:
        if (r5 != 900004230) goto L10;
        UDToast.a r6 = UDToast.build(eu5.b.a());
        r6.b.e(2131887344);
        r6.b.d = -1;
        r6.h();
        return true;
    L10:
        if (r5 != 900004511) goto L12;
    L15:
        UDToast.a r7 = UDToast.build(eu5.b.a());
        r7.b.e(2131887345);
        r7.b.d = -1;
        r7.h();
        return true;
    L12:
        if (r5 == 900004510) goto L15;
        return false;
    }

    public static boolean c(Throwable r1) {
        if ((r1 instanceof NetService.ServerErrorException) == true) goto L5;
        return false;
    L5:
        return b(((NetService.ServerErrorException) r1).getCode());
    }
}
