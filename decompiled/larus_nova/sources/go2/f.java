package go2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements com.bytedance.android.livesdk.performance.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481904a = 0;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        HashMap<String, String> r102 = r101.Z;
        if (r102.isEmpty() == false) goto L7;
        return;
    L7:
        String r103 = r102.get(IPerformanceManager.PlayerClient.player_client_state);
        String r104 = "";
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        HashMap r105 = (HashMap) r100;
        r105.put(IPerformanceManager.PlayerClient.player_client_state, r103);
        String r106 = r102.get(IPerformanceManager.PlayerClient.player_client_can_share);
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r105.put(IPerformanceManager.PlayerClient.player_client_can_share, r106);
        String r107 = r102.get(IPerformanceManager.PlayerClient.player_client_play_url);
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        r105.put(IPerformanceManager.PlayerClient.player_client_play_url, r107);
        String r108 = r102.get(IPerformanceManager.PlayerClient.player_client_resolution);
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r105.put(IPerformanceManager.PlayerClient.player_client_resolution, r108);
        String r109 = r102.get(IPerformanceManager.PlayerClient.player_client_stream_size);
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r105.put(IPerformanceManager.PlayerClient.player_client_stream_size, r109);
        String r110 = r102.get(IPerformanceManager.PlayerClient.player_client_vr_fov);
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        r105.put(IPerformanceManager.PlayerClient.player_client_vr_fov, r110);
        String r111 = r102.get(IPerformanceManager.PlayerClient.player_client_associate_page);
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        r105.put(IPerformanceManager.PlayerClient.player_client_associate_page, r111);
        String r112 = r102.get(IPerformanceManager.PlayerClient.player_client_biz_domain);
        if (r112 != null) goto L31;
        r112 = "";
    L31:
        r105.put(IPerformanceManager.PlayerClient.player_client_biz_domain, r112);
        String r113 = r102.get(IPerformanceManager.PlayerClient.super_resolution_enabled);
        if (r113 != null) goto L34;
        r113 = "";
    L34:
        r105.put(IPerformanceManager.PlayerClient.super_resolution_enabled, r113);
        String r114 = r102.get(IPerformanceManager.PlayerClient.sharpen_enabled);
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        r105.put(IPerformanceManager.PlayerClient.sharpen_enabled, r114);
        String r115 = r102.get(IPerformanceManager.PlayerClient.texture_render_enabled);
        if (r115 != null) goto L40;
        r115 = "";
    L40:
        r105.put(IPerformanceManager.PlayerClient.texture_render_enabled, r115);
        String r116 = r102.get(IPerformanceManager.PlayerClient.p2p_play_enabled);
        if (r116 != null) goto L43;
        r116 = "";
    L43:
        r105.put(IPerformanceManager.PlayerClient.p2p_play_enabled, r116);
        String r117 = r102.get(IPerformanceManager.PlayerClient.player_client_count);
        if (r117 != null) goto L46;
        r117 = "";
    L46:
        r105.put(IPerformanceManager.PlayerClient.player_client_count, r117);
        String r118 = r102.get(IPerformanceManager.PlayerClient.player_client_pulling_stream_count);
        if (r118 != null) goto L49;
        r118 = "";
    L49:
        r105.put(IPerformanceManager.PlayerClient.player_client_pulling_stream_count, r118);
        String r119 = r102.get(IPerformanceManager.PlayerClient.player_client_playing_count);
        if (r119 != null) goto L52;
        r119 = "";
    L52:
        r105.put(IPerformanceManager.PlayerClient.player_client_playing_count, r119);
        String r120 = r102.get(IPerformanceManager.PlayerClient.player_audio_render_rms_db);
        if (r120 != null) goto L55;
        r120 = "";
    L55:
        r105.put(IPerformanceManager.PlayerClient.player_audio_render_rms_db, r120);
        String r121 = r102.get(IPerformanceManager.PlayerClient.player_audio_decoder_rms_db);
        if (r121 == null) goto L59;
        r104 = r121;
    L59:
        r105.put(IPerformanceManager.PlayerClient.player_audio_decoder_rms_db, r104);
    }
}
