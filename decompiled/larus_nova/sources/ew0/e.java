package ew0;

import com.bytedance.android.live.revenue.common.s;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final void a(com.bytedance.android.live.recharge.model.d r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$provideEventProperties");
        Intrinsics.checkNotNullParameter(r101, "map");
        r101.put("request_page", r100.f90014c);
        r101.put("charge_scene", r100.f90019h);
        r101.put("charge_reason", r100.f90013b);
        String r102 = r100.f90023l;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.put(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r102);
        r101.put("recharge_show_type", r100.f90020i);
        String r104 = r100.f90025n;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101.put("session_id", r104);
        String r105 = r100.f90025n;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r101.put("recharge_session_id", r105);
        com.bytedance.android.live.recharge.model.b r106 = r100.f90021j;
        String r107 = null;
        if (r106 == null) goto L19;
        com.bytedance.android.live.recharge.model.a r108 = r106.f90009g;
        if (r108 == null) goto L19;
        s r109 = r108.f90001b;
        KProperty r110 = com.bytedance.android.live.recharge.model.a.f89999d[2];
        r109.getClass();
        Intrinsics.checkNotNullParameter(r108, "thisRef");
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Object r111 = r108.get(r109.f90992a);
        if (r111 != null) goto L18;
        r111 = r109.f90993b.invoke();
    L18:
        String r112 = (String) r111;
    L20:
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        r101.put("gift_panel_session_id", r112);
        com.bytedance.android.live.recharge.model.f r113 = r100.f90022k;
        if (r113 != null) goto L25;
    L29:
        String r114 = "0";
    L30:
        r101.put("is_vipopen_package", r114);
        r101.put("money_diff", String.valueOf(r100.f90015d));
        r101.put("rd_recharge_scene", "live_room_recharge");
        com.bytedance.android.live.recharge.model.b r115 = r100.f90021j;
        if (r115 == null) goto L33;
        Long r116 = Long.valueOf(r115.f90007e);
    L34:
        r101.put("previous_gift_id", String.valueOf(r116));
        com.bytedance.android.live.recharge.model.b r117 = r100.f90021j;
        if (r117 == null) goto L37;
        Long r118 = Long.valueOf(r117.f90006d);
    L38:
        r101.put("previous_gift_money", String.valueOf(r118));
        com.bytedance.android.live.recharge.model.b r119 = r100.f90021j;
        if (r119 == null) goto L41;
        Long r120 = Long.valueOf(r119.f90005c);
    L42:
        r101.put("previous_pay_money", String.valueOf(r120));
        com.bytedance.android.live.recharge.model.b r121 = r100.f90021j;
        if (r121 == null) goto L45;
        r107 = r121.f90004b;
    L45:
        r101.put("previous_gift_type", String.valueOf(r107));
        com.bytedance.android.live.recharge.model.b r122 = r100.f90021j;
        if (r122 == null) goto L51;
        String r123 = r122.f90003a;
        if (r123 == null) goto L51;
        r103 = r123;
    L51:
        r101.put("gift_dialog_request_id", r103);
        return;
    L41:
        r120 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L25:
        if (r113.f90032c != 1) goto L29;
        if (r100.f90015d == 0) goto L29;
        r114 = "1";
    L19:
        r112 = null;
        goto L20
    }
}
