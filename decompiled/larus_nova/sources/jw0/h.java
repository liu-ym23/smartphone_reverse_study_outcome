package jw0;

import am2.x;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f500665a = 0;

    static {
    }

    public static void a(Throwable r100) {
        HashMap r101 = new HashMap();
        k r102 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        String r103 = "";
        if (r102 == null) goto L7;
        IRoom r104 = r102.getRoom();
        if (r104 == null) goto L7;
        Comparable r105 = Long.valueOf(r104.getRoomId());
    L8:
        r101.put("room_id", r105);
        if (r102 == null) goto L16;
        IRoom r106 = r102.getRoom();
        if (r106 == null) goto L16;
        String r107 = r106.getOwnerUserIdString();
        if (r107 == null) goto L16;
        r103 = r107;
    L16:
        r101.put("anchor_id", r103);
        if (r100 != null) goto L19;
    L21:
        LiveSlardarMonitor.monitorStatus("ttlive_income_exchange_error", 12, r101);
        int r108 = v.f91009a;
        JSONObject r109 = new JSONObject();
        Iterator r110 = r101.entrySet().iterator();
    L23:
        if (r110.hasNext() == false) goto L28;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Exception -> L26
        r109.put((String) r111.getKey(), r111.getValue());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L28:
        v.b("ttlive_exchange", String.valueOf(r109), null);
        return;
    L19:
        if ((r100 instanceof ApiException) == false) goto L21;
        r101.put("error_code", String.valueOf(((ApiException) r100).getErrorCode()));
        r101.put("error_message", String.valueOf(r100.getMessage()));
    L7:
        r105 = "";
        goto L8
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        HashMap r101 = new HashMap();
        r101.put("click_type", r100);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r102 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_auto_exchange_click", r101, new Class[]{IRoom.class, x.class});
    }

    public static void e(String r100, Long r101) {
        HashMap r102 = new HashMap();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.put("request_page", r100);
        r102.put("charge_reason", "exchange_diamond");
        r102.put("money", String.valueOf(r101));
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r103 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_recharge_success", r102, new Class[]{IRoom.class, x.class});
    }

    public static void c(long r100, long r101, int r102, int r103, Boolean r104) {
        HashMap r105 = new HashMap();
        r105.put("exchange_reason", String.valueOf(r102));
        r105.put("exchange_gift_confirm", String.valueOf(r103));
        r105.put("money_paid", String.valueOf(r100));
        r105.put("money_exchanged", String.valueOf(r101));
        r105.put("remind", String.valueOf(r104));
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r106 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_paypopup_click", r105, new Class[]{IRoom.class, x.class});
    }

    public static void d(long r100, long r101, int r102, Boolean r103, Integer r104, String r105) {
        Intrinsics.checkNotNullParameter(r105, "clickArea");
        HashMap r106 = new HashMap();
        r106.put("exchange_gift_confirm", String.valueOf(r102));
        r106.put("money_paid", String.valueOf(r100));
        r106.put("money_exchanged", String.valueOf(r101));
        r106.put("given_coins", String.valueOf(r104));
        r106.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r105);
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L5;
        String r107 = "1";
    L7:
        if (com.bytedance.android.live.recharge.utils.e.c() == false) goto L9;
        r106.put("is_close_notice", r107);
    L10:
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r108 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_paypopup_click", r106, new Class[]{IRoom.class, x.class, hx0.b.class});
        return;
    L9:
        r106.put("is_auto_exchange", r107);
        goto L10
    L5:
        r107 = "0";
        goto L7
    }
}
