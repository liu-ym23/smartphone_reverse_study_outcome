package com.bytedance.ee.bear.bitable.itemview.util;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l {
    public static void a(String r100, ItemViewLogger r101, Boolean r102, Throwable r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = ItemViewLogger.ItemViewDefault;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = Boolean.FALSE;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L16;
        if (r101 != null) goto L15;
        r101 = ItemViewLogger.ItemViewDefault;
    L15:
        String r105 = r101.toString();
        Log.e(r105, r100, r103);
        com.bytedance.ee.bear.contract.d r106 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r107 = new HashMap();
        r107.put(EventConstant.Key.MODULE, r105);
        r107.put("msg", r100);
        Unit r108 = Unit.INSTANCE;
        r106.n("ccm_bitable_item_view_error_path", r107);
        return;
    L16:
        if (r101 != null) goto L18;
        r101 = ItemViewLogger.ItemViewDefault;
    L18:
        Log.i(r101.toString(), r100);
    }
}
