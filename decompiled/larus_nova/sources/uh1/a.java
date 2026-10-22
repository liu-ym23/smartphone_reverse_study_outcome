package uh1;

import am2.n;
import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.utils.k0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void b() {
        o r100 = u.l().c(x.class);
        if (r100 == null) goto L5;
        r100.remove("is_other_channel");
    L5:
        o r101 = u.l().c(n.class);
        if (r101 == null) goto L8;
        r101.remove("is_other_channel");
        r101.remove(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE);
    L8:
        n r102 = n.f();
        r102.f4313b = "";
        r102.f4315d = "";
        r102.f4316e = "";
        r102.f4317f = "";
        r102.f4319h = "";
        r102.f4318g = false;
        r102.f4314c = "";
    }

    public static void a(Bundle r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        b();
        if (c0.b().shouldHandleCommerceJob(r110.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID), r110) == true) goto L7;
        return;
    L7:
        boolean r100 = r110.getBoolean("enter_from_effect_ad", false);
        boolean r101 = r110.getBoolean("enter_from_dou_plus", false);
        Serializable r102 = r110.getSerializable(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP);
        Serializable r103 = r110.getSerializable("live_douplus_log_extra");
        if ((r102 instanceof HashMap) == false) goto L14;
        HashMap r104 = (HashMap) r102;
        n r105 = n.f();
        r105.f4313b = k0.a((String) r104.get("log_extra"), (String) r104.get("value"));
        n r106 = n.f();
        Intrinsics.checkNotNullParameter(r104, "adInfoMap");
        JSONObject r111 = new JSONObject();
        String r112 = (String) r104.get(BdpAppEventConstant.PARAMS_RIT);
        if (r112 == null) goto L12;
        r111.put(BdpAppEventConstant.PARAMS_RIT, r112);
    L12:
        r106.f4314c = r111.toString();
        n r107 = n.f();
        r107.f4315d = (String) r104.get("is_other_channel");
        n r108 = n.f();
        r108.f4317f = (String) r104.get("ad_id");
    L14:
        if ((r103 instanceof HashMap) == false) goto L19;
        HashMap r109 = (HashMap) r103;
        n r113 = n.f();
        r113.f4313b = k0.a((String) r109.get("log_extra"), (String) r109.get("value"));
        n r114 = n.f();
        Intrinsics.checkNotNullParameter(r109, "adInfoMap");
        JSONObject r115 = new JSONObject();
        String r116 = (String) r109.get(BdpAppEventConstant.PARAMS_RIT);
        if (r116 == null) goto L18;
        r115.put(BdpAppEventConstant.PARAMS_RIT, r116);
    L18:
        r114.f4314c = r115.toString();
        n r117 = n.f();
        r117.f4315d = (String) r109.get("is_other_channel");
        n r118 = n.f();
        r118.f4317f = (String) r109.get("ad_id");
    L19:
        String r119 = r110.getString(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE);
        if (TextUtils.isEmpty(r119) == true) goto L22;
        n.f().f4313b = r119;
    L22:
        String r120 = r110.getString("enter_from_ad_type");
        if (TextUtils.isEmpty(r120) == true) goto L26;
        n.f().f4316e = r120;
    L26:
        if (TextUtils.isEmpty(r110.getString("ad_enter_method")) == true) goto L28;
        n.f().getClass();
    L28:
        if (r100 == false) goto L30;
        n.f().f4315d = com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD;
    L32:
        String r121 = r110.getString("is_other_channel");
        if (TextUtils.isEmpty(r121) == true) goto L35;
        n.f().f4315d = r121;
    L35:
        boolean r122 = r110.getBoolean("is_ad_coin", false);
        String r123 = r110.getString("extra_adx_coin_task_info");
        n.f().f4318g = r122;
        n.f().f4319h = r123;
        return;
    L30:
        if (r101 == false) goto L32;
        n.f().f4315d = IPerformanceManager.SCENE_CLICK_DOU_PLUS;
        goto L32
    }
}
