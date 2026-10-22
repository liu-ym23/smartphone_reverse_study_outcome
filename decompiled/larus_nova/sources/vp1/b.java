package vp1;

import am2.x;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements ICameraSwitchTimeExternalService, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f556571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f556572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f556573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<C8031b> f556574d;

    public static final class a {
    }

    /* JADX INFO: renamed from: vp1.b$b, reason: collision with other inner class name */
    public static final class C8031b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f556575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f556576b;

        public final String toString() {
            return "Event: " + this.f556575a + " : " + this.f556576b + '\n';
        }

        public C8031b(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f556575a = r100;
            this.f556576b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService
    public final void startTrace() {
        this.f556572b = false;
        this.f556574d.clear();
        this.f556573c = 0;
        this.f556571a = null;
        this.f556572b = true;
        this.f556573c = System.currentTimeMillis();
        c(ICameraSwitchTimeExternalService.EventName.start_switch_stream);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService
    public final void a() {
        if (this.f556572b == true) goto L5;
        return;
    L5:
        ICameraSwitchTimeExternalService.EventName r100 = ICameraSwitchTimeExternalService.EventName.start_switch_stream;
        long r101 = g(r100, ICameraSwitchTimeExternalService.EventName.playing);
        if (r101 >= 0) goto L9;
        this.f556572b = false;
        this.f556574d.clear();
        this.f556573c = 0;
        this.f556571a = null;
        this.f556572b = false;
        return;
    L9:
        HashMap r102 = new HashMap();
        this.f556571a = r102;
        ICameraSwitchTimeExternalService.EventName r103 = ICameraSwitchTimeExternalService.EventName.start_pull_stream;
        r102.put("duration_before_pull", String.valueOf(g(r100, r103)));
        ICameraSwitchTimeExternalService.EventName r104 = ICameraSwitchTimeExternalService.EventName.stream_start;
        r102.put("duration_invoke", String.valueOf(g(r103, r104)));
        ICameraSwitchTimeExternalService.EventName r105 = ICameraSwitchTimeExternalService.EventName.stream_first_frame_render_end;
        r102.put("duration_stream_duration", String.valueOf(g(r104, r105)));
        ICameraSwitchTimeExternalService.EventName r106 = ICameraSwitchTimeExternalService.EventName.stream_sdk_dns_analysis_end;
        r102.put("duration_sdk_dns_analysis", String.valueOf(g(r104, r106)));
        ICameraSwitchTimeExternalService.EventName r107 = ICameraSwitchTimeExternalService.EventName.stream_player_dns_analysis_end;
        r102.put("duration_player_dns_analysis", String.valueOf(g(r106, r107)));
        ICameraSwitchTimeExternalService.EventName r108 = ICameraSwitchTimeExternalService.EventName.stream_tcp_connect_end;
        r102.put("duration_tcp_connect", String.valueOf(g(r107, r108)));
        ICameraSwitchTimeExternalService.EventName r109 = ICameraSwitchTimeExternalService.EventName.stream_tcp_first_package_end;
        r102.put("duration_tcp_first_package", String.valueOf(g(r108, r109)));
        ICameraSwitchTimeExternalService.EventName r110 = ICameraSwitchTimeExternalService.EventName.stream_first_video_package_end;
        r102.put("duration_first_video_package", String.valueOf(g(r109, r110)));
        ICameraSwitchTimeExternalService.EventName r111 = ICameraSwitchTimeExternalService.EventName.stream_first_video_frame_decode_end;
        r102.put("duration_first_video_decode", String.valueOf(g(r110, r111)));
        r102.put("duration_first_frame_render", String.valueOf(g(r111, r105)));
        r102.put("duration_callback", String.valueOf(g(r105, ICameraSwitchTimeExternalService.EventName.first_frame)));
        Map<String, String> r112 = this.f556571a;
        if (r112 != null) goto L12;
        this.f556572b = false;
    L20:
        r102.put("duration", String.valueOf(r101));
        JSONObject r113 = r.l().getPlayerStatsLog();
        if (r113 == null) goto L23;
        r102.put(IPerformanceManager.Stream.stream_cdn_ip, r113.optString("cdn_ip:"));
        r102.put(IPerformanceManager.Stream.stream_cdn_play_url, r113.optString("url:"));
    L23:
        r.l().sendLog("livesdk_machine_change_duration", r102, new Object[]{IRoom.class, new x()});
        this.f556572b = false;
        this.f556574d.clear();
        this.f556573c = 0;
        this.f556571a = null;
        return;
    L12:
        int r114 = this.f556574d.size();
        int r115 = 0;
    L13:
        if (r115 >= r114) goto L20;
        C8031b r116 = this.f556574d.valueAt(r115);
        if (r116 == null) goto L19;
        if (TextUtils.isEmpty(r116.f556575a) == true) goto L19;
        ((HashMap) r112).put(r116.f556575a, String.valueOf(r116.f556576b));
    L19:
        r115 = r115 + 1;
        goto L13
    }

    public b() {
        this.f556574d = new SparseArray();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService
    public final void c(ICameraSwitchTimeExternalService.EventName r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f(r100, System.currentTimeMillis());
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService
    public final void d(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f(ICameraSwitchTimeExternalService.EventName.stream_start, r100.optLong("start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_sdk_dns_analysis_end, r100.optLong("sdk_dns_analysis_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_prepare_block_end, r100.optLong("prepare_block_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_player_dns_analysis_end, r100.optLong("player_dns_analysis_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_tfo_fall_back_time, r100.optLong("tfo_fall_back_time"));
        f(ICameraSwitchTimeExternalService.EventName.stream_tcp_connect_end, r100.optLong("tcp_connect_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_tcp_first_package_end, r100.optLong("tcp_first_package_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_video_package_end, r100.optLong("first_video_package_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_audio_package_end, r100.optLong("first_audio_package_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_video_frame_decode_end, r100.optLong("first_video_frame_decode_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_audio_frame_decode_end, r100.optLong("first_audio_frame_decode_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_frame_from_player_core, r100.optLong("first_frame_from_player_core"));
        f(ICameraSwitchTimeExternalService.EventName.stream_first_frame_render_end, r100.optLong("first_frame_render_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_open_start, r100.optLong("video_device_open_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_open_end, r100.optLong("video_device_open_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_audio_device_open_start, r100.optLong("audio_device_open_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_audio_device_open_end, r100.optLong("audio_device_open_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_prepare_end, r100.optLong("prepare_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_set_surface_time, r100.optLong("set_surface_time"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_wait_start, r100.optLong("video_device_wait_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_video_device_wait_end, r100.optLong("video_device_wait_end"));
        f(ICameraSwitchTimeExternalService.EventName.stream_find_stream_info_start, r100.optLong("find_stream_info_start"));
        f(ICameraSwitchTimeExternalService.EventName.stream_find_stream_info_end, r100.optLong("find_stream_info_end"));
    }

    public final void f(ICameraSwitchTimeExternalService.EventName r100, long r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f556572b == true) goto L8;
        return;
    L8:
        if (r101 > 0) goto L10;
        return;
    L10:
        if (r101 >= this.f556573c) goto L13;
        return;
    L13:
        if (this.f556574d.get(r100.ordinal()) == null) goto L15;
        return;
    L15:
        this.f556574d.put(r100.ordinal(), new C8031b(r100.toString(), r101));
    }

    public final long g(ICameraSwitchTimeExternalService.EventName r110, ICameraSwitchTimeExternalService.EventName r111) {
        C8031b r112 = this.f556574d.get(r110.ordinal());
        C8031b r113 = this.f556574d.get(r111.ordinal());
        if (r112 == null) goto L13;
        if (r113 == null) goto L13;
        long r100 = r112.f556576b;
        if (r100 <= 0) goto L13;
        long r114 = r113.f556576b;
        if (r114 <= 0) goto L13;
        if ((r114 - r100) > 3600000) goto L13;
        return Math.max(r114 - r100, 0);
    L13:
        return -1;
    }
}
