package com.bytedance.android.livesdk.livecommerce.network.hook;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.PopRoomInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.utils.a0;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    public static void c(String r6, String r7, String r8) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        int r1 = a0.a;
        if (r7 != null) goto L22;
    L16:
        int r9 = -1;
    L17:
        JSONObject r10 = o83.c.a(r6, r9, r8);
        int r11 = ECSdk.a;
        IAddressService r2 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r2 == null) goto L20;
        IAddressService.a.b(r2, r10, 1, true, null, 24);
    L20:
        dm.a.a("LiveAddress").a("saveAddressInfo: addr=" + r10);
        return;
    L22:
        r9 = CastIntegerProtector.parseInt(r7);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L16
    L4:
        if (r6.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final synchronized void a(String r4, String r5, ECCurrentPromotion r6) {
        monitor-enter(this);
        if (r6 != null) goto L28;
        monitor-exit(this);
        return;
    L28:
    L25:
        th = move-exception;
        throw th;
    L7:
        if (((g) r6).statusCode != 0) goto L23;
        PopRoomInfo r0 = r6.roomInfo;     // Catch: Throwable -> L25
        if (r0 == null) goto L11;
        a.b(r4, r5, r0.getVirtualRoomId());     // Catch: Throwable -> L25
    L11:
        PopRoomInfo r7 = r6.roomInfo;     // Catch: Throwable -> L25
        String r8 = null;
        if (r7 == null) goto L14;
        String r9 = r7.getAddressType();     // Catch: Throwable -> L25
    L15:
        PopRoomInfo r1 = r6.roomInfo;     // Catch: Throwable -> L25
        if (r1 == null) goto L18;
        String r2 = r1.getReceiveAddressId();     // Catch: Throwable -> L25
    L19:
        PopRoomInfo r10 = r6.roomInfo;     // Catch: Throwable -> L25
        if (r10 == null) goto L22;
        r8 = r10.getAddressStrategy();     // Catch: Throwable -> L25
    L22:
        c(r2, r9, r8);     // Catch: Throwable -> L25
        goto L23
    L18:
        r2 = null;
        goto L19
    L14:
        r9 = null;
    L23:
        monitor-exit(this);
    }

    public final synchronized void b(String r2, String r3, long r4) {
        monitor-enter(this);
        int r0 = com.bytedance.android.livesdk.livecommerce.messagev2.a.k;     // Catch: Throwable -> L6
        ControllerCenter.c(r2, r3).n.H(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
