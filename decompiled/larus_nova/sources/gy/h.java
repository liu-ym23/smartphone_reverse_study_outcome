package gy;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class h extends BaseMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f483311d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<LiveTracingMonitor.EventModule, e> f483312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Room f483313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f483314c;

    public static final class a {
    }

    static {
    }

    public h(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f483313b = r100;
        this.f483314c = false;
        this.f483312a = new HashMap();
    }

    public final void l(JSONObject r100) {
        c.f483309c2.getClass();
        c r101 = c.a.a();
        String r102 = "";
        if (r101 == null) goto L9;
        f r103 = r101.getRtcManager();
        if (r103 == null) goto L9;
        String r104 = r103.O();
        if (r104 == null) goto L9;
    L10:
        BaseMonitor.add(r100, "channel_id", r104);
        c r105 = c.a.a();
        if (r105 == null) goto L18;
        f r106 = r105.getRtcManager();
        if (r106 == null) goto L18;
        String r107 = r106.c0();
        if (r107 == null) goto L18;
        r102 = r107;
    L18:
        BaseMonitor.add(r100, "linker_session_id", r102);
        BaseMonitor.add(r100, "event_session_id", r104);
        Room r108 = this.f483313b;
        IRoom.Companion r109 = IRoom.Companion;
        if (r109.isValid(r108) == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L31;
        String r110 = "0";
        if (r109.isValid(this.f483313b) == false) goto L26;
        String r111 = r108.getIdStr();
    L27:
        BaseMonitor.add(r100, "room_id", r111);
        if (r109.isValid(this.f483313b) == false) goto L30;
        r110 = r108.getOwnerUserIdString();
    L30:
        BaseMonitor.add(r100, "anchor_id", r110);
        goto L31
    L26:
        r111 = "0";
    L31:
        c r112 = c.a.a();
        if (r112 == null) goto L41;
        f r113 = r112.getRtcManager();
        if (r113 != null) goto L36;
        return;
    L36:
        if (r113.F() != true) goto L38;
        long r114 = 1;
    L39:
        BaseMonitor.add(r100, "is_client_mixstream", r114);
        return;
    L38:
        r114 = 0;
        goto L39
    L41:
        return;
    L9:
        r104 = "";
        goto L10
    }

    public final void m(LiveTracingMonitor.EventModule r100, String r101, Map<String, ? extends Object> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r101, "sdkApiName");
        dy.b r104 = dy.b.f470518a;
        if (dy.b.c(r101) == false) goto L5;
        return;
    L5:
        JSONObject r105 = new JSONObject();
        BaseMonitor.add(r105, "sdk_api_name", r101);
        if (r102 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r106 = r102.entrySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r107 = r106.next();
        r105.putOpt(r107.getKey(), r107.getValue());
    L11:
        if (r103 == true) goto L15;
        l(r105);
        e r108 = this.f483312a.get(r100);
        if (r108 == null) goto L15;
        r108.b();
    L15:
        HashMap r109 = new HashMap();
        r109.put("sdk_api_name", r101);
        dy.b r110 = dy.b.f470518a;
        r109.put("android_event_key", "rtc_".concat(r101));
        if (this.f483314c == false) goto L18;
        String r111 = "2";
    L19:
        r109.put("role_type", r111);
        dy.b.e("ttlive_interact_sdk_api_call", r100, r109, r105);
        return;
    L18:
        r111 = "3";
        goto L19
    }

    public final void n(LiveTracingMonitor.EventModule r100, String r110, String r111, Map<String, ? extends Object> r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r110, "rtcCallBackName");
        Intrinsics.checkNotNullParameter(r111, "linkmicId");
        Intrinsics.checkNotNullParameter(r114, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        dy.b r101 = dy.b.f470518a;
        if (dy.b.c(r110) == false) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "rtc_callback_name", r110);
        BaseMonitor.add(r102, "linkmic_id", r111);
        l(r102);
        if (r112 == null) goto L11;
        Iterator<Map.Entry<String, ? extends Object>> r115 = r112.entrySet().iterator();
    L9:
        if (r115.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r116 = r115.next();
        r102.putOpt(r116.getKey(), r116.getValue());
    L11:
        e r117 = this.f483312a.get(r100);
        if (r117 == null) goto L14;
        r117.a();
    L14:
        HashMap r103 = new HashMap();
        r103.put("sdk_callback_name", r110);
        if (this.f483314c == false) goto L17;
        String r118 = "2";
    L18:
        r103.put("role_type", r118);
        dy.b r104 = dy.b.f470518a;
        r103.put("android_event_key", "callback_".concat(r110));
        r104.d("ttlive_interact_sdk_callback", r100, r113, r114, r103, r102);
        return;
    L17:
        r118 = "3";
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(h r100, LiveTracingMonitor.EventModule r110, String r111, String r112, Map r113, int r114, int r115) {
        String r101 = null;
        if ((r115 & 8) == 0) goto L5;
        Map r102 = null;
    L7:
        if ((r115 & 16) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r115 & 32) == 0) goto L13;
        r101 = "";
    L13:
        r100.n(r110, r111, r112, r102, r103, r101);
        return;
    L9:
        r103 = r114;
        goto L11
    L5:
        r102 = r113;
        goto L7
    }
}
