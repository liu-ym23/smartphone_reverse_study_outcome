package fm0;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.monitor.g;
import com.bytedance.android.live.room.api.messagewindow.monitor.h;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.monitor.j;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import m71.c;
import n71.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f477771a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f477772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f477773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f477774d = null;

    /* JADX INFO: renamed from: fm0.a$a, reason: collision with other inner class name */
    public static final class C5927a implements j.a {
        public C5927a() {
        }

        @Override // com.bytedance.android.live.room.api.messagewindow.monitor.j.a
        public final h a() {
            boolean r100 = a.f477771a;
            return a.f477772b;
        }
    }

    public a() {
    }

    static {
        f477774d = new a();
        int r100 = v71.a.f553415a;
        b r101 = c.f512325a.getValue();
        if (r101 == null) goto L7;
        Boolean r102 = r101.a();
        if (r102 == null) goto L7;
        boolean r103 = r102.booleanValue();
    L8:
        f477771a = r103;
        f477773c = new j(new C5927a());
        return;
    L7:
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.monitor.i
    public final void c() {
        j r100 = f477773c;
        r100.getClass();
        if (v.a() == true) goto L21;
        boolean r101 = true;
        if (r100.f99024a == false) goto L22;
        h r102 = r100.f99026c.a();
        if (r102 == null) goto L22;
        if (r102.f99023f < 500) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L21;
        if (r100.f99025b >= 1.0d) goto L21;
        double r104 = Random.Default.nextDouble();
        ALogger.d("TraceSampleStrategy", "random: " + r104 + "\ttraceSample: " + r100.f99025b);
        if (r104 > r100.f99025b) goto L22;
    L14:
        r103 = false;
    L22:
        if (r101 == false) goto L24;
        return;
    L24:
        h r105 = f477772b;
        if (r105 != null) goto L27;
        return;
    L27:
        f477772b = null;
        int r106 = e.f64997m;
        e.a r107 = e.b.a("card_trace", "live_msg_window");
        r107.f65012c = "webcast_client_community";
        r107.f65017h = 0;
        r107.f65018i = "";
        r107.f65014e = r105.f99019b;
        r107.f65016g = r105.f99021d;
        r107.f65015f = r105.f99020c;
        e r108 = r107.a();
        JSONObject r109 = new JSONObject();
        JSONArray r110 = new JSONArray();
        Iterator r111 = ((ArrayList) r105.f99022e).iterator();
    L29:
        if (r111.hasNext() == false) goto L54;
        com.bytedance.android.live.room.api.messagewindow.monitor.e r112 = (com.bytedance.android.live.room.api.messagewindow.monitor.e) r111.next();
        r112.getClass();
        JSONObject r113 = new JSONObject();
        String r114 = r112.f99004a;
        if (r114 == null) goto L36;
        Map<String, String> r115 = g.f99017a;
        Intrinsics.checkNotNullParameter(r114, "$this$mapNodeNameAlias");
        String r116 = (String) ((LinkedHashMap) g.f99017a).get(r114);
        if (r116 != null) goto L35;
        r116 = "unknown";
    L35:
        r113.put("node_alias", r116);
    L36:
        String r117 = r112.f99005b;
        if (r117 == null) goto L39;
        r113.put("card_id", r117);
    L39:
        String r118 = r112.f99007d;
        if (r118 == null) goto L42;
        r113.put("info", r118);
    L42:
        String r119 = r112.f99008e;
        if (r119 == null) goto L45;
        r113.put("error_msg", r119);
    L45:
        Iterator r120 = ((LinkedHashMap) r112.f99009f).entrySet().iterator();
    L47:
        if (r120.hasNext() == false) goto L53;
        Map.Entry r121 = (Map.Entry) r120.next();
        String r122 = (String) r121.getKey();
        Object r123 = r121.getValue();
        if (r123 == null) goto L51;
        String r124 = r123.toString();
    L52:
        r113.put(r122, r124);
        goto L47
    L51:
        r124 = null;
        goto L52
    L53:
        r110.put(r113.toString());
        goto L29
    L54:
        Unit r125 = Unit.INSTANCE;
        r109.put("trace_nodes", r110);
        com.bytedance.android.live.core.monitor.trace.c.b(r108, r109);
        return;
    L21:
        r101 = false;
        goto L22
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.monitor.i
    public final void a(o r100) {
        h r101 = f477772b;
        if (r101 != null) goto L5;
        r101 = new h();
        f477772b = r101;
    L5:
        if (r100 == null) goto L16;
        m<IRoom> r102 = r100.getRoom();
        if (r102 == null) goto L17;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L18;
        r101.f99019b = r103.getIdStr();
        String r104 = r103.getOwnerUserIdString();
        if (r104 != null) goto L14;
        r104 = "0L";
    L14:
        r101.f99020c = r104;
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.monitor.i
    public final void b(com.bytedance.android.live.room.api.messagewindow.monitor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        HashMap r101 = new HashMap();
        r101.putAll(r100.f99001b);
        o r102 = IRoomContextService.a.a((IRoomContextService) k.n(IRoomContextService.class), null, 0, 3);
        if (Intrinsics.areEqual(r102.isAnchor(), Boolean.TRUE) == false) goto L5;
        String r103 = "1";
    L6:
        r101.put(IPerformanceManager.Params.is_anchor, r103);
        User r104 = r102.getUser();
        if (r104 == null) goto L10;
        String r105 = r104.getIdString();
        if (r105 == null) goto L10;
    L11:
        r101.put("user_id", r105);
        j0.l().sendLog(r100.f99000a, r101, new Object[]{x.class, IRoom.class});
        return;
    L10:
        r105 = "";
        goto L11
    L5:
        r103 = "0";
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.monitor.i
    public final void d(com.bytedance.android.live.room.api.messagewindow.monitor.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (f477771a == true) goto L5;
        return;
    L5:
        Throwable r101 = r100.f98999b;
        if (r101 == null) goto L8;
        ALogger.e("MsgWindowCardMonitor", r100.f98998a, r101);
        return;
    L8:
        ALogger.i("MsgWindowCardMonitor", r100.f98998a);
        Unit r102 = Unit.INSTANCE;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.monitor.i
    public final void e(com.bytedance.android.live.room.api.messagewindow.monitor.e r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        h r101 = f477772b;
        if (r101 != null) goto L5;
        r101 = new h();
        f477772b = r101;
    L5:
        Intrinsics.checkNotNullParameter(r100, "node");
        ((ArrayList) r101.f99022e).add(r100);
        long r102 = r100.f99006c;
        if (r102 <= r101.f99023f) goto L9;
        r101.f99023f = r102;
        return;
    }
}
