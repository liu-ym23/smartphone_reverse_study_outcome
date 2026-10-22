package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public d() {
    }

    static {
    }

    public static boolean a(String r5, String r6, String r7, Long r8, boolean r9) {
        if (r7 != null) goto L5;
        return true;
    L5:
        if (r8 == null) goto L16;
        r8.longValue();
        int r1 = RoomContextController.h;
        LinkedHashMap r10 = (LinkedHashMap) RoomContextController.a.b(r5, r6).e;
        Long r11 = (Long) r10.get(r7);
        if (r11 == null) goto L9;
        long r2 = r11.longValue();
    L10:
        dm.a.a("AuctionFreq").i("check freq, key=" + r7 + ", limit=" + r8 + ", onlyCheck=" + r9 + ", currentCount=" + r2);
        if (r2 < r8.longValue()) goto L14;
        return false;
    L14:
        if (r9 == true) goto L16;
        r10.put(r7, Long.valueOf(r2 + 1));
        goto L16
    L9:
        r2 = 0;
    L16:
        return true;
    }
}
