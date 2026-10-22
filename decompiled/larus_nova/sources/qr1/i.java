package qr1;

import am2.a0;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.awemeopen.apps.photo.event.PinchStableViewEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements jm1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f534523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f534524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f534525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<APMEvent> f534526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveRoomAPMConfig f534527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f534528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f534529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f534530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f534531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f534532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f534533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final wr1.a f534534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f534535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f534536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f534537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final WeakHandler f534538p;

    public class a implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f534539a;

        public a(i r100) {
            this.f534539a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
            if (r100.what != 2) goto L13;
            this.f534539a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, "enter room timeout"));
            if (this.f534539a.f534525c.opt("network_status") != null) goto L9;
            this.f534539a.a("network_status", "time_out");
        L9:
            if (this.f534539a.f534525c.opt("player_status") != null) goto L11;
            this.f534539a.a("player_status", "time_out");
        L11:
            i r101 = this.f534539a;
            r101.f534528f.f534542c = true;
            r101.h(1, "");
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f534540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f534541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f534542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f534543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f534544e;

        public b() {
        }
    }

    public final long f() {
        Bundle r100 = this.f534529g;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Long r101 = Long.valueOf(r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_BEGIN_START_ACTIVITY_TIME, 0));
        if (r101.longValue() > 0) goto L8;
        Long r102 = Long.valueOf(this.f534529g.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ACTIVITY_ON_CREATE_TIME, 0));
        if (r102.longValue() <= 0) goto L14;
        return r102.longValue();
    L14:
        return this.f534529g.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_STAR_TIME, 0);
    L8:
        return r101.longValue();
    }

    public final void b(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.containsKey("enter_from_merge") == false) goto L8;
        a("enter_from_merge", r100.get("enter_from_merge"));
    L8:
        if (r100.containsKey("enter_method") == false) goto L11;
        a("enter_method", r100.get("enter_method"));
    L11:
        if (r100.containsKey("action_type") == false) goto L14;
        a("action_type", r100.get("action_type"));
        return;
    }

    public final void c(APMEvent r110) {
        List<String> r100 = this.f534527e.blackEventName;
        if (r100 == null) goto L7;
        if (r100.contains(r110.a()) == false) goto L7;
        return;
    L7:
        if (((ArrayList) this.f534526d).size() <= this.f534527e.maxEventSize) goto L9;
        ListProtector.remove(this.f534526d, 0);
    L9:
        ((ArrayList) this.f534526d).add(r110);
        if (r110.b() != APMEvent.Level.E) goto L19;
        if (this.f534527e.enableWriteALogE == false) goto L27;
        Spm r101 = Spm.obtain().businessId(String.valueOf(this.f534530h)).addArg("user_id", String.valueOf(this.f534532j)).result(500).addArg("tag", "VSEpisodeAPMMonitor").addArg("key", r110.a());
        if (r110.c() != null) goto L16;
        String r111 = "";
    L17:
        Spm r112 = r101.addArg("message", r111);
        ArrayList<String> r102 = sw2.a.f543700a;
        Intrinsics.checkNotNullParameter(r112, "spm");
        sw2.a.b(r112, "");
        return;
    L16:
        r111 = r110.c();
        goto L17
    L27:
        return;
    L19:
        if (this.f534527e.enableWriteALogI == false) goto L29;
        Spm r103 = Spm.obtain().businessId(String.valueOf(this.f534530h)).addArg("user_id", String.valueOf(this.f534532j)).result(200).addArg("tag", "VSEpisodeAPMMonitor").addArg("key", r110.a());
        if (r110.c() != null) goto L23;
        String r113 = "";
    L24:
        Spm r114 = r103.addArg("message", r113);
        ArrayList<String> r104 = sw2.a.f543700a;
        Intrinsics.checkNotNullParameter(r114, "spm");
        sw2.a.b(r114, "");
        return;
    L23:
        r113 = r110.c();
        goto L24
    }

    @Override // jm1.b
    public final void m00(Episode r100) {
        this.f534531i = r100.attachRoomIdStr;
        this.f534533k = EpisodeExtKt.getOwnerIdString(r100);
        c(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "room/enter request success", "log_id=" + r100.getRequestLogID()));
        d("room_auth", String.valueOf(r100.getRoomAuthStatus()));
        d("log_id", r100.getRequestLogID());
        long r101 = this.f534524b.optLong("point_start_request_time", -1);
        d("point_finish_request_time", String.valueOf(System.currentTimeMillis()));
        if (r101 <= 0) goto L5;
        e("enter_request_start_to_end_cost", System.currentTimeMillis() - r101);
    L5:
        a("network_status", "success");
        this.f534528f.f534541b = true;
        h(0, "");
    }

    public static void g(Map r100, JSONObject r101) {
        if (r100 == null) goto L15;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L23;
        Iterator r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L24;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L24:
        return;
    L23:
        return;
    }

    public final void a(String r100, String r101) {
        JSONObject r102 = this.f534525c;
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void d(String r100, String r101) {
        JSONObject r102 = this.f534524b;
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void e(String r100, long r101) {
        JSONObject r102 = this.f534523a;
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void h(int r110, String r111) {
        b r100 = this.f534528f;
        if (r100.f534542c == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        return;
    L11:
        if (r100.f534544e == false) goto L13;
        return;
    L13:
        r100.f534544e = true;
        this.f534538p.removeMessages(2);
        DataCenter r102 = this.f534535m;
        if (r102 != null) goto L16;
    L22:
        DataCenter r103 = this.f534535m;
        if (r103 != null) goto L25;
        Map<String, String> r104 = Collections.emptyMap();
    L29:
        b(r104);
        long r105 = f();
        long r106 = System.currentTimeMillis() - r105;
        if (r105 <= 0) goto L38;
        if (r106 >= this.f534527e.enterRoomTimeout) goto L38;
        d("duration", String.valueOf(r106));
        if (r110 == 1) goto L36;
        e("start_to_total_ready_cost", r106);
    L36:
        c(com.bytedance.android.live.livepullstream.api.apm.a.b(APMEvent.Level.I, PinchStableViewEvent.State.ENTER_START, r105));
    L38:
        if (r110 == 1) goto L40;
        a("status_code", String.valueOf(r110));
    L48:
        if (TextUtils.isEmpty(r111) == false) goto L50;
        d("status_msg", r111);
    L50:
        d("metric", this.f534523a.toString());
        d("category", this.f534525c.toString());
        c(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "enter_finish", "enter_code=" + r110 + ", desc=" + r111 + ", total cost=" + r106));
        i(this.f534526d, this.f534524b);
        g(r104, this.f534524b);
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L53;
        String r107 = LiveTracingMonitor.EventModule.f64911vs.getName();
        int r108 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r109 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_vs_apm_enter", r107);
        r109.f65012c = "webcast_client_room_apm";
        r109.f65017h = Integer.valueOf(r110);
        r109.f65018i = r111;
        r109.f65014e = this.f534531i;
        r109.f65015f = this.f534533k;
        r109.f65016g = String.valueOf(((IUserService) k.f(IUserService.class)).user().n());
        com.bytedance.android.live.core.monitor.trace.e r112 = r109.a();
        JSONObject r113 = this.f534525c;
        JSONObject r114 = this.f534523a;
        JSONObject r115 = this.f534524b;
        Intrinsics.checkNotNullParameter(r112, "traceMeta");
        TraceMonitor.i(r112, r113, r114, r115);
    L54:
        ((ArrayList) this.f534526d).clear();
        this.f534524b = new JSONObject();
        this.f534525c = new JSONObject();
        this.f534523a = new JSONObject();
        this.f534536n = System.currentTimeMillis();
        return;
    L53:
        LiveTracingMonitor.e("ttlive_vs_apm_enter", LiveTracingMonitor.EventModule.f64911vs, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.f534525c, this.f534523a, this.f534524b);
        goto L54
    L40:
        b r116 = this.f534528f;
        if (r116.f534541b == true) goto L44;
        a("status_code", String.valueOf(5));
        goto L48
    L44:
        if (r116.f534542c == true) goto L46;
        a("status_code", String.valueOf(6));
        goto L48
    L46:
        a("status_code", String.valueOf(r110));
        goto L48
    L25:
        HashMap r117 = new HashMap();
        if (pm1.f.f() == null) goto L28;
        pm1.f.f().c(r103, a0.class, r117);
    L28:
        r104 = r117;
        goto L29
    L16:
        if (r102.get("data_vs_episode_data", null) == null) goto L22;
        Episode r118 = (Episode) this.f534535m.get("data_vs_episode_data", null);
        if (r118 == null) goto L22;
        d(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, String.valueOf(r118.getIdExt()));
        d("episode", r118.toString());
        EpisodeMod r119 = r118.episodeMod;
        if (r119 == null) goto L22;
        a("state_type", String.valueOf(r119.episodeStage));
        a("record_type", String.valueOf(r119.episodeRecordType));
        goto L22
    L5:
        if (r100.f534541b == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void i(List<APMEvent> r100, JSONObject r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L22;
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L11
        Iterator r103 = ((ArrayList) r100).iterator();     // Catch: Exception -> L11
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.put(((APMEvent) r103.next()).h());     // Catch: Exception -> L11
        goto L7
    L9:
        r101.put("event_list", r102.toString());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        r101.put("event_list_error", e.getMessage());     // Catch: JSONException -> L15
        return;
    L24:
        return;
    L22:
        return;
    }

    @Override // jm1.b
    public final void fX(long r100, String r101, boolean r110, Episode r111, ls2.e r112) {
        b r102 = this.f534528f;
        if (r102.f534540a == true) goto L5;
        return;
    L5:
        if (r102.f534543d == false) goto L7;
        return;
    L7:
        if (k.f(IRoomModuleService.class) != null) goto L9;
        return;
    L9:
        if (((IRoomModuleService) k.f(IRoomModuleService.class)).getLiveRoomMonitorHelper() == null) goto L60;
        this.f534528f.f534543d = true;
        this.f534538p.removeMessages(2);
        EndReason r103 = (EndReason) r112.getReasonV2Ext();
        if (r103 == null) goto L14;
        a("exit_code", ((IRoomModuleService) k.f(IRoomModuleService.class)).getLiveRoomMonitorHelper().b(r103));
    L16:
        if (this.f534534l.a().getValue() != null) goto L18;
    L20:
        boolean r113 = ((IRoomModuleService) k.f(IRoomModuleService.class)).getLiveRoomMonitorHelper().a(r103);
        if (r113 == false) goto L23;
        APMEvent.Level r114 = APMEvent.Level.I;
    L24:
        c(com.bytedance.android.live.livepullstream.api.apm.a.c(r114, "exit room", "error=" + r112 + ", exit_error_ms=" + r112.getErrMsgV2() + ", reason=" + r112.getReasonV2Ext()));
        if (r113 == true) goto L28;
        d("status_code", r112.getErrorCode() + "");
        d("status_msg", r112.getErrMsgV2() + " " + ((IRoomModuleService) k.f(IRoomModuleService.class)).getLiveRoomMonitorHelper().b(r103));
    L28:
        if (this.f534536n <= 0) goto L32;
        long r115 = System.currentTimeMillis();
        long r104 = this.f534536n;
        if (r115 <= r104) goto L32;
        e("watch_live_duration", r115 - r104);
        d("duration", String.valueOf(r115 - this.f534536n));
    L32:
        LiveRoomAPMConfig r105 = this.f534527e;
        int r116 = r105.uploadExitRoomLevel;
        if (r116 == 2) goto L37;
        if (r116 != 1) goto L58;
        if (r113 == false) goto L37;
        return;
    L58:
        return;
    L37:
        if (r105.exitUploadAll() == false) goto L39;
    L41:
        d("trace", Log.getStackTraceString(new Exception()));
    L42:
        c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "upload events by exit room=" + hashCode()));
        DataCenter r106 = this.f534535m;
        if (r106 != null) goto L45;
        Map<String, String> r107 = Collections.emptyMap();
    L49:
        b(r107);
        g(r107, this.f534524b);
        i(this.f534526d, this.f534524b);
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L52;
        String r108 = LiveTracingMonitor.EventModule.f64911vs.getName();
        int r109 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r117 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_vs_apm_exit", r108);
        r117.f65012c = "webcast_client_room_apm";
        r117.f65014e = this.f534531i;
        r117.f65015f = this.f534533k;
        r117.f65016g = String.valueOf(((IUserService) k.f(IUserService.class)).user().n());
        com.bytedance.android.live.core.monitor.trace.e r118 = r117.a();
        JSONObject r119 = this.f534525c;
        JSONObject r120 = this.f534523a;
        JSONObject r121 = this.f534524b;
        Intrinsics.checkNotNullParameter(r118, "traceMeta");
        TraceMonitor.i(r118, r119, r120, r121);
    L53:
        this.f534524b = new JSONObject();
        this.f534523a = new JSONObject();
        ((ArrayList) this.f534526d).clear();
        b r122 = this.f534528f;
        r122.f534542c = false;
        r122.f534541b = false;
        r122.f534543d = false;
        r122.f534540a = false;
        r122.f534544e = false;
        return;
    L52:
        LiveTracingMonitor.e("ttlive_vs_apm_exit", LiveTracingMonitor.EventModule.f64911vs, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.f534525c, this.f534523a, this.f534524b);
        goto L53
    L45:
        HashMap r123 = new HashMap();
        if (pm1.f.f() == null) goto L48;
        pm1.f.f().c(r106, a0.class, r123);
    L48:
        r107 = r123;
        goto L49
    L39:
        if (this.f534527e.exitUploadOnlyAbnormal() == false) goto L42;
        if (r113 == true) goto L42;
    L23:
        r114 = APMEvent.Level.E;
        goto L24
    L18:
        if (TextUtils.isEmpty(this.f534534l.a().getValue().get("log_id")) == true) goto L20;
        d("log_id", this.f534534l.a().getValue().get("log_id"));
        goto L20
    L14:
        a("exit_code", "unknown");
        goto L16
    }

    public i(Bundle r100, Fragment r101, String r102, String r103, ReplayEventHub r104, DataCenter r105, LiveRoomAPMConfig r110) {
        this.f534537o = new a(this);
        this.f534538p = new WeakHandler(Looper.getMainLooper(), this.f534537o);
        this.f534523a = new JSONObject();
        this.f534524b = new JSONObject();
        this.f534525c = new JSONObject();
        this.f534526d = new ArrayList();
        this.f534528f = new b();
        if (r100 != null) goto L5;
        r100 = Bundle.EMPTY;
    L5:
        this.f534529g = r100;
        this.f534534l = r104;
        this.f534535m = r105;
        this.f534527e = r110;
        if (r110.enableRoomAPM == false) goto L13;
        this.f534530h = r102;
        this.f534532j = r103;
        c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "monitor start"));
        if (r101 == null) goto L14;
        r104.f118051e.observe(r101, new qr1.a(this));
        r104.f118048b.observe(r101, new qr1.b(this), true);
        r104.f118052f.observe(r101, new c(this));
        r104.f118070x.observe(r101, new d(this));
        r104.f118058l.observe(r101, new e(this));
        r104.f118071y.observe(r101, new f(this));
        r104.f118054h.observe(r101, new g(this));
        r104.f118059m.observe(r101, new h(this));
        return;
    L14:
        return;
    }
}
