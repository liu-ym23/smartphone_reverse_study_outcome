package vt2;

import am2.x;
import android.text.TextUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.lx;
import com.bytedance.android.livesdk.event.FollowStatusDataErrorEvent;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f557192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f557193b = null;

    public a() {
    }

    static {
        f557193b = new a();
        f557192a = lx.f120714a.getValue();
    }

    @Override // vt2.b
    public final String b(FollowInfo r100) {
        if (r100 != null) goto L5;
        return "data is null";
    L5:
        StringBuilder r101 = new StringBuilder();
        if (TextUtils.isEmpty(r100.getFollowerCountStr()) == false) goto L9;
        r101.append("follower_count_str is null");
    L9:
        if (TextUtils.isEmpty(r100.getFollowingCountStr()) == false) goto L12;
        r101.append("following_count_str is null");
    L12:
        return r101.toString();
    }

    public static void e(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
    L7:
        e = move-exception;
        ALogger.e("TabTraceMonitor", e);
        return;
    L4:
        if (r100.has(r101) == true) goto L12;
        r100.put(r101, r102);     // Catch: Exception -> L7
        return;
    }

    public static void c(String r100, int r101, String r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        HashMap r104 = new HashMap();
        Iterator r105 = r103.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L19;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r107 = (String) r106.getKey();
        String r108 = "";
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        String r109 = (String) r106.getValue();
        if (r109 == null) goto L12;
        r108 = r109;
    L12:
        Intrinsics.checkNotNullParameter(r104, "$this$safePut");
        Intrinsics.checkNotNullParameter(r107, "key");
        Intrinsics.checkNotNullParameter(r108, "value");
    L17:
        e = move-exception;
        ALogger.e("FollowLogMonitor", e);
        goto L4
    L14:
        if (r104.containsKey(r107) == true) goto L4;
        r104.put(r107, r108);     // Catch: Exception -> L17
        goto L4
    L19:
        r104.put("status_code", String.valueOf(r101));
        r104.put("status_msg", r102);
        u.l().sendLog(r100, r104, new Object[]{x.class, Room.class});
    }

    public static void d(String r100, int r101, String r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter("live_follow", "businessType");
        Intrinsics.checkNotNullParameter("webcast_client_community", "productId");
        Intrinsics.checkNotNullParameter(r110, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        if (f557192a.booleanValue() == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        ArrayList r103 = new ArrayList(r111.size());
        Iterator r112 = r111.entrySet().iterator();
    L7:
        if (r112.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r112.next();
        e(r102, (String) r104.getKey(), (String) r104.getValue());
        r103.add(Unit.INSTANCE);
        goto L7
    L9:
        e(r102, "status_code", String.valueOf(r101));
        e(r102, "status_msg", r110);
        Intrinsics.checkNotNullParameter(r102, "$this$injectCommonParams");
        Room r105 = null;
        RoomContext r113 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r113 == null) goto L14;
        m<Room> r114 = r113.getRoom();
        if (r114 == null) goto L14;
        Room r115 = r114.getValue();
    L16:
        if (IRoom.Companion.isValid(r115) == false) goto L19;
        r105 = r115;
    L19:
        if (r105 == null) goto L21;
        e(r102, "room_id", String.valueOf(r105.f162599id));
    L21:
        IUserService r106 = (IUserService) k.f(IUserService.class);
        if (r106 == null) goto L27;
        f r107 = r106.user();
        if (r107 == null) goto L27;
        String r108 = r107.n();
        if (r108 == null) goto L27;
    L28:
        e(r102, "user_id", r108);
        e(r102, BindCardPayConfirmConstants.Key.TRACE_ID, r108);
        LinkedHashMap r109 = new LinkedHashMap();
        IHostContext r116 = (IHostContext) k.f(IHostContext.class);
        if (r116 == null) goto L31;
        r109.put("aid", String.valueOf(r116.appId()));
    L31:
        int r117 = e.f64997m;
        e.a r118 = e.b.a(r100, "live_follow");
        r118.f65012c = "webcast_client_community";
        r118.f65017h = Integer.valueOf(r101);
        r118.f65018i = r110;
        r118.f65014e = r102.optString("room_id");
        r118.f65015f = r102.optString("anchor_id");
        r118.f65016g = r102.optString("user_id");
        r118.f65010a = r102.optString(BindCardPayConfirmConstants.Key.TRACE_ID);
        r118.f65011b = r102.optString("log_id");
        Intrinsics.checkNotNullParameter(r109, "index");
        r118.f65019j = r109;
        com.bytedance.android.live.core.monitor.trace.c.b(r118.a(), r102);
        return;
    L27:
        r108 = "0";
    L14:
        r115 = null;
        goto L16
    }

    @Override // vt2.b
    public final void a(String r100, FollowStatusDataErrorEvent.FollowDataSource r101, String r102, String r103, String r104, FollowInfo r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "enterRoomFollow");
        HashMap r105 = new HashMap();     // Catch: Exception -> L35
        r105.put("data_status", r100);     // Catch: Exception -> L35
        r105.put("api", r101.getSource());     // Catch: Exception -> L35
        if (r102 != null) goto L7;
        String r106 = "";
    L8:
        r105.put("data", r106);     // Catch: Exception -> L35
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r105.put("log_id", r103);     // Catch: Exception -> L35
        Object r112 = r111;
        if (r111 != null) goto L14;
        r112 = 0L;
    L14:
        r105.put("adopter_id", r112.toString());     // Catch: Exception -> L35
        String r107 = "0";
        if (r104 != null) goto L18;
        r104 = "0";
    L18:
        r105.put("anchor_id", r104);     // Catch: Exception -> L35
        IUserService r108 = (IUserService) k.f(IUserService.class);     // Catch: Exception -> L35
        if (r108 == null) goto L26;
        f r109 = r108.user();     // Catch: Exception -> L35
        if (r109 == null) goto L26;
        String r113 = r109.n();     // Catch: Exception -> L35
        if (r113 == null) goto L26;
        r107 = r113;
    L26:
        r105.put("uid", r107);     // Catch: Exception -> L35
        if (r110 == null) goto L30;
        String r114 = r110.toString();     // Catch: Exception -> L35
        if (r114 == null) goto L30;
    L31:
        r105.put("follow_info", r114);     // Catch: Exception -> L35
        c("ttlive_follow_data", 0, "", r105);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r102) == true) goto L40;
        d("ttlive_follow_data", 0, "", r105);     // Catch: Exception -> L35
        return;
    L40:
        return;
    L30:
        r114 = "";
        goto L31
    L7:
        r106 = r102;
    L35:
        e = move-exception;
        e.printStackTrace();
    }
}
