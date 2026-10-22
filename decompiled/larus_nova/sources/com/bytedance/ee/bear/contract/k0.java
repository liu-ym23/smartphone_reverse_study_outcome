package com.bytedance.ee.bear.contract;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class k0 {
    public static int a(Throwable r100) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if ((r100 instanceof NetService.ServerErrorException) == true) goto L6;
        return -1;
    L6:
        return ((NetService.ServerErrorException) r100).getCode();
    }

    public static boolean b(int r100) {
        if (eu5.b.a() != null) goto L6;
        return false;
    L6:
        if (r100 != 900004230) goto L10;
        UDToast.a r101 = UDToast.build(eu5.b.a());
        r101.f285429b.e(R.string.CreationMobile_MultiGeo_900004230);
        r101.f285429b.f417630d = -1;
        r101.h();
        return true;
    L10:
        if (r100 != 900004511) goto L12;
    L15:
        UDToast.a r102 = UDToast.build(eu5.b.a());
        r102.f285429b.e(R.string.CreationMobile_MultiGeo_900004510);
        r102.f285429b.f417630d = -1;
        r102.h();
        return true;
    L12:
        if (r100 == 900004510) goto L15;
        return false;
    }

    public static boolean c(Throwable r100) {
        if ((r100 instanceof NetService.ServerErrorException) == true) goto L5;
        return false;
    L5:
        return b(((NetService.ServerErrorException) r100).getCode());
    }
}
