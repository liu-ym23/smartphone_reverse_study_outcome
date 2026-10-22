package wr0;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IPerfToolsService f560789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, a> f560790b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, List<String>> f560791c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f560792d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f560793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f560794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f560795g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap<Integer, wr0.a> f560796h = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f560797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HashMap<String, String> f560798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Double> f560799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f560800d;

        public a() {
        }
    }

    static {
        f560790b = new HashMap();
        HashMap<Integer, List<String>> r100 = new HashMap();
        f560791c = r100;
        f560792d = new ArrayList();
        f560793e = true;
        f560794f = true;
        f560795g = new ArrayList();
        f560796h = new HashMap();
        f560789a = (IPerfToolsService) k.f(IPerfToolsService.class);
        r100.put(0, Arrays.asList(new String[]{"data_host_version_code", "data_host_update_version_code", "data_push_client_sdk_version", "data_player_sdk_version", "data_live_sdk_version", "data_current_device_id", "data_current_user_id", "data_channel_id", "data_effect_sdk_version", "data_live_core_version", "data_android_release", "data_device_model", "data_device_brand", "data_device_score"}));
        r100.put(9, IPerfToolsService.baseAudienceInfo);
        r100.put(10, IPerfToolsService.baseBroadcastInfo);
        r100.put(11, Arrays.asList(new String[]{"data_channel_id", "data_inviter_established_time", "data_invitee_established_time", "data_end_to_end_delay", "data_mix_type"}));
        r100.put(12, Arrays.asList(new String[]{"data_channel_id", "data_inviter_established_time", "data_invitee_established_time", "data_end_to_end_delay", "data_mix_type"}));
        r100.put(13, Arrays.asList(new String[]{e(IPerformanceManager.MODULE_GIFT_EFFECT, "data_cpu_rate"), e(IPerformanceManager.MODULE_GIFT_EFFECT, "data_cpu_speed"), e(IPerformanceManager.MODULE_GIFT_EFFECT, "data_temperature"), e(IPerformanceManager.MODULE_GIFT_EFFECT, "data_cpu_rate")}));
        r100.put(14, Arrays.asList(new String[]{"data_push_client_bitrate", "data_push_client_fps", e("ktv", "data_http_rtt")}));
        r100.put(4, Arrays.asList(new String[]{"surface_render_enabled", "data_pull_cdn_ip", "data_play_url", "data_stream_id"}));
    }

    public static void b() {
        Set<Map.Entry<String, a>> r100 = f560790b.entrySet();
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, a>> r101 = r100.iterator();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.hasNext() == false) goto L19;
        Map.Entry<String, a> r102 = r101.next();
        if (r102 == null) goto L9;
        a r103 = r102.getValue();
        if (r103 == null) goto L9;
        if (r103.f560800d != 2) goto L9;
        r101.remove();
        goto L9
    }

    public static boolean i() {
        String r100 = g("data_current_user_id");
        String r101 = g("data_current_room_user_id");
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.equals(r101) == false) goto L8;
        return false;
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Iterator r101 = ((ArrayList) f560792d).iterator();
    L7:
        if (r101.hasNext() == false) goto L17;
        Integer r102 = (Integer) r101.next();
        List<String> r103 = f560791c.get(r102);
        if (r103 == null) goto L7;
        if (r103.isEmpty() == true) goto L7;
        if (r103.contains(r100) == false) goto L7;
        return true;
    L17:
        return false;
    }

    public static String c(String r100) {
        byte r101 = 1;
        if (r100.contains("@") == true) goto L5;
    L7:
        r100.getClass();
        switch(r100.hashCode()) {
            case -2098952852: goto L314;
            case -2069970221: goto L311;
            case -2055283396: goto L307;
            case -2027658481: goto L303;
            case -1865703285: goto L299;
            case -1854495991: goto L295;
            case -1839659303: goto L291;
            case -1751273442: goto L287;
            case -1683983720: goto L283;
            case -1673262874: goto L279;
            case -1651528858: goto L275;
            case -1512049965: goto L271;
            case -1501977995: goto L267;
            case -1496783394: goto L263;
            case -1485802067: goto L259;
            case -1304311193: goto L255;
            case -1228425742: goto L251;
            case -1208425186: goto L247;
            case -1197089414: goto L243;
            case -1186101051: goto L239;
            case -1075497622: goto L235;
            case -962495820: goto L231;
            case -947329893: goto L227;
            case -904685260: goto L223;
            case -816061345: goto L219;
            case -810571734: goto L215;
            case -782072151: goto L211;
            case -759990539: goto L207;
            case -755484584: goto L203;
            case -743322109: goto L199;
            case -540811163: goto L195;
            case -505578446: goto L191;
            case -340863070: goto L187;
            case -318342954: goto L183;
            case -266741086: goto L179;
            case -224380421: goto L175;
            case -177258790: goto L171;
            case 101871466: goto L167;
            case 129833242: goto L163;
            case 134121448: goto L159;
            case 179824264: goto L155;
            case 214569036: goto L151;
            case 307992101: goto L147;
            case 321142133: goto L143;
            case 321332499: goto L139;
            case 443461424: goto L135;
            case 452790756: goto L131;
            case 459278241: goto L127;
            case 484930240: goto L123;
            case 489736068: goto L119;
            case 564530084: goto L115;
            case 580941647: goto L111;
            case 654258054: goto L107;
            case 676916096: goto L103;
            case 701936399: goto L99;
            case 806289238: goto L95;
            case 913326647: goto L91;
            case 987659062: goto L87;
            case 1007300814: goto L83;
            case 1077775884: goto L79;
            case 1170375963: goto L75;
            case 1185147752: goto L71;
            case 1186730026: goto L67;
            case 1250111221: goto L63;
            case 1277840416: goto L59;
            case 1353095156: goto L55;
            case 1545043401: goto L51;
            case 1681370334: goto L47;
            case 1687634951: goto L43;
            case 1771867293: goto L39;
            case 1835769126: goto L35;
            case 1850916179: goto L31;
            case 1866308317: goto L27;
            case 1906108724: goto L23;
            case 2050361740: goto L19;
            case 2102414013: goto L15;
            case 2118975743: goto L11;
            default: goto L9;
        };
    L9:
        r101 = -1;
    L318:
        switch(r101) {
            case 0: goto L473;
            case 1: goto L471;
            case 2: goto L469;
            case 3: goto L467;
            case 4: goto L465;
            case 5: goto L463;
            case 6: goto L461;
            case 7: goto L459;
            case 8: goto L457;
            case 9: goto L455;
            case 10: goto L453;
            case 11: goto L451;
            case 12: goto L449;
            case 13: goto L447;
            case 14: goto L445;
            case 15: goto L443;
            case 16: goto L441;
            case 17: goto L439;
            case 18: goto L437;
            case 19: goto L435;
            case 20: goto L433;
            case 21: goto L431;
            case 22: goto L429;
            case 23: goto L427;
            case 24: goto L425;
            case 25: goto L423;
            case 26: goto L421;
            case 27: goto L419;
            case 28: goto L417;
            case 29: goto L415;
            case 30: goto L413;
            case 31: goto L411;
            case 32: goto L409;
            case 33: goto L407;
            case 34: goto L405;
            case 35: goto L403;
            case 36: goto L401;
            case 37: goto L399;
            case 38: goto L397;
            case 39: goto L395;
            case 40: goto L393;
            case 41: goto L391;
            case 42: goto L389;
            case 43: goto L387;
            case 44: goto L385;
            case 45: goto L383;
            case 46: goto L381;
            case 47: goto L379;
            case 48: goto L377;
            case 49: goto L375;
            case 50: goto L373;
            case 51: goto L371;
            case 52: goto L369;
            case 53: goto L367;
            case 54: goto L365;
            case 55: goto L363;
            case 56: goto L361;
            case 57: goto L359;
            case 58: goto L357;
            case 59: goto L355;
            case 60: goto L353;
            case 61: goto L351;
            case 62: goto L349;
            case 63: goto L347;
            case 64: goto L345;
            case 65: goto L343;
            case 66: goto L341;
            case 67: goto L339;
            case 68: goto L337;
            case 69: goto L335;
            case 70: goto L333;
            case 71: goto L331;
            case 72: goto L329;
            case 73: goto L327;
            case 74: goto L325;
            case 75: goto L323;
            case 76: goto L321;
            default: goto L319;
        };
    L319:
        return r100;
    L321:
        return s1.B(R.string.ttlive_perftools_inviter_establish_cost);
    L323:
        return s1.B(R.string.ttlive_perftools_is_VPASS);
    L325:
        return s1.B(R.string.ttlive_perftools_channel_id);
    L327:
        return s1.B(R.string.ttlive_perftools_push_stream_encode_type);
    L329:
        return s1.B(R.string.ttlive_perftools_preview_fps);
    L331:
        return s1.B(R.string.ttlive_perftools_liveCore_extra);
    L333:
        return s1.B(R.string.ttlive_perftools_room_owner_uid);
    L335:
        return s1.B(R.string.ttlive_perftools_pull_stream_decode_type);
    L337:
        return s1.B(R.string.ttlive_perftools_system_used);
    L339:
        return s1.B(R.string.ttlive_perftools_sharpen_used);
    L341:
        return s1.B(R.string.ttlive_perftools_code_used);
    L343:
        return s1.B(R.string.ttlive_perftools_sticker_used);
    L345:
        return s1.B(R.string.ttlive_perftools_local_memory);
    L347:
        return s1.B(R.string.ttlive_perftools_live_sdk_version);
    L349:
        return s1.B(R.string.ttlive_perftools_beauty_ids);
    L351:
        return s1.B(R.string.ttlive_perftools_magic_gesture_used);
    L353:
        return s1.B(R.string.ttlive_perftools_push_stream_resolution);
    L355:
        return s1.B(R.string.ttlive_perftools_cpu_rate);
    L357:
        return s1.B(R.string.ttlive_perftools_push_stream_max_bitrate);
    L359:
        return s1.B(R.string.ttlive_perftools_network_frequency);
    L361:
        return s1.B(R.string.ttlive_perftools_makeup_ids);
    L363:
        return s1.B(R.string.ttlive_perftools_livecore_version);
    L365:
        return s1.B(R.string.ttlive_perftools_push_sdk_version);
    L367:
        return s1.B(R.string.ttlive_perftools_graphic_total);
    L369:
        return s1.B(R.string.ttlive_perftools_pull_stream_resolution);
    L371:
        return s1.B(R.string.ttlive_perftools_pull_stream_fps);
    L373:
        return s1.B(R.string.ttlive_perftools_room_id);
    L375:
        return s1.B(R.string.ttlive_perftools_stream_type);
    L377:
        return s1.B(R.string.ttlive_perftools_pss_total);
    L379:
        return s1.B(R.string.ttlive_perftools_sticker_ids);
    L381:
        return s1.B(R.string.ttlive_perftools_battery_health);
    L383:
        return s1.B(R.string.ttlive_perftools_http_rtt);
    L385:
        return s1.B(R.string.ttlive_perftools_small_beauty_used);
    L387:
        return s1.B(R.string.ttlive_perftools_enter_room_cost);
    L389:
        return s1.B(R.string.ttlive_perftools_push_stream_fps);
    L391:
        return s1.B(R.string.ttlive_perftools_current_resolution);
    L393:
        return s1.B(R.string.ttlive_perftools_host_update_version_code);
    L395:
        return s1.B(R.string.ttlive_perftools_live_room_entrance_type);
    L397:
        return s1.B(R.string.ttlive_perftools_stack_used);
    L399:
        return s1.B(R.string.ttlive_perftools_surfaceView_render_used);
    L401:
        return s1.B(R.string.ttlive_perftools_effect_sdk_version);
    L403:
        return s1.B(R.string.ttlive_perftools_java_heap_used);
    L405:
        return s1.B(R.string.ttlive_perftools_small_beauty_ids);
    L407:
        return s1.B(R.string.ttlive_perftools_host_version_code);
    L409:
        return s1.B(R.string.ttlive_perftools_android_release);
    L411:
        return s1.B(R.string.ttlive_perftools_mix_type);
    L413:
        return s1.B(R.string.ttlive_perftools_gpu_used);
    L415:
        return s1.B(R.string.ttlive_perftools_battery_health);
    L417:
        return s1.B(R.string.ttlive_perftools_network_status);
    L419:
        return s1.B(R.string.ttlive_perftools_pull_stream_download_speed);
    L421:
        return s1.B(R.string.ttlive_perftools_push_stream_bitrate);
    L423:
        return s1.B(R.string.ttlive_perftools_player_version);
    L425:
        return s1.B(R.string.ttlive_perftools_battery_temperature);
    L427:
        return s1.B(R.string.ttlive_perftools_end_to_end_delay);
    L429:
        return s1.B(R.string.ttlive_perftools_cpu_speed);
    L431:
        return s1.B(R.string.ttlive_perftools_user_id);
    L433:
        return s1.B(R.string.ttlive_perftools_default_resolution);
    L435:
        return s1.B(R.string.ttlive_perftools_room_watched_count);
    L437:
        return s1.B(R.string.ttlive_perftools_enter_room_cost_split);
    L439:
        return s1.B(R.string.ttlive_perftools_decode);
    L441:
        return s1.B(R.string.ttlive_perftools_super_resolution_used);
    L443:
        return s1.B(R.string.ttlive_perftools_real_fps);
    L445:
        return s1.B(R.string.ttlive_perftools_magic_gesture_ids);
    L447:
        return s1.B(R.string.ttlive_perftools_device_score);
    L449:
        return s1.B(R.string.ttlive_perftools_device_model);
    L451:
        return s1.B(R.string.ttlive_perftools_device_brand);
    L453:
        return s1.B(R.string.ttlive_perftools_native_heap_used);
    L455:
        return s1.B(R.string.ttlive_perftools_private_other_used);
    L457:
        return s1.B(R.string.ttlive_perftools_game_fps);
    L459:
        return s1.B(R.string.ttlive_perftools_makeup_used);
    L461:
        return s1.B(R.string.ttlive_perftools_pull_stream_url);
    L463:
        return s1.B(R.string.ttlive_perftools_device_id);
    L465:
        return s1.B(R.string.ttlive_perftools_beauty_used);
    L467:
        return s1.B(R.string.ttlive_perftools_filter_used);
    L469:
        return s1.B(R.string.ttlive_perftools_texture_render_used);
    L471:
        return s1.B(R.string.ttlive_perftools_pull_stream_bitrate);
    L473:
        return s1.B(R.string.ttlive_perftools_invitee_establish_cost);
    L11:
        if (r100.equals("data_inviter_established_time") == false) goto L9;
        r101 = 76;
        goto L318
    L15:
        if (r100.equals("isvPass") == false) goto L9;
        r101 = 75;
        goto L318
    L19:
        if (r100.equals("data_channel_id") == false) goto L9;
        r101 = 74;
        goto L318
    L23:
        if (r100.equals("data_push_stream_encode_type") == false) goto L9;
        r101 = 73;
        goto L318
    L27:
        if (r100.equals("data_preview_fps") == false) goto L9;
        r101 = 72;
        goto L318
    L31:
        if (r100.equals("data_chatroom_livecore_extra") == false) goto L9;
        r101 = 71;
        goto L318
    L35:
        if (r100.equals("data_current_room_user_id") == false) goto L9;
        r101 = 70;
        goto L318
    L39:
        if (r100.equals("data_pull_stream_codec_type") == false) goto L9;
        r101 = 69;
        goto L318
    L43:
        if (r100.equals("data_private_system_summary") == false) goto L9;
        r101 = 68;
        goto L318
    L47:
        if (r100.equals("data_sharpen_used") == false) goto L9;
        r101 = 67;
        goto L318
    L51:
        if (r100.equals("data_code_summary") == false) goto L9;
        r101 = 66;
        goto L318
    L55:
        if (r100.equals("data_sticker_used") == false) goto L9;
        r101 = 65;
        goto L318
    L59:
        if (r100.equals("local_resolution_memory") == false) goto L9;
        r101 = 64;
        goto L318
    L63:
        if (r100.equals("data_live_sdk_version") == false) goto L9;
        r101 = 63;
        goto L318
    L67:
        if (r100.equals("data_beauty_ids") == false) goto L9;
        r101 = 62;
        goto L318
    L71:
        if (r100.equals("data_gesture_used") == false) goto L9;
        r101 = Base64.padSymbol;
        goto L318
    L75:
        if (r100.equals("data_push_stream_resolution") == false) goto L9;
        r101 = 60;
        goto L318
    L79:
        if (r100.equals("data_cpu_rate") == false) goto L9;
        r101 = 59;
        goto L318
    L83:
        if (r100.equals("data_push_client_max_bitrate") == false) goto L9;
        r101 = 58;
        goto L318
    L87:
        if (r100.equals("data_network_frequency") == false) goto L9;
        r101 = 57;
        goto L318
    L91:
        if (r100.equals("data_makeup_ids") == false) goto L9;
        r101 = 56;
        goto L318
    L95:
        if (r100.equals("data_live_core_version") == false) goto L9;
        r101 = 55;
        goto L318
    L99:
        if (r100.equals("data_push_client_sdk_version") == false) goto L9;
        r101 = 54;
        goto L318
    L103:
        if (r100.equals("data_graphics") == false) goto L9;
        r101 = 53;
        goto L318
    L107:
        if (r100.equals("data_pull_stream_resolution") == false) goto L9;
        r101 = 52;
        goto L318
    L111:
        if (r100.equals("data_pull_stream_fps") == false) goto L9;
        r101 = 51;
        goto L318
    L115:
        if (r100.equals("data_current_room_id") == false) goto L9;
        r101 = 50;
        goto L318
    L119:
        if (r100.equals("data_stream_type") == false) goto L9;
        r101 = 49;
        goto L318
    L123:
        if (r100.equals("data_pss_total") == false) goto L9;
        r101 = 48;
        goto L318
    L127:
        if (r100.equals("data_sticker_ids") == false) goto L9;
        r101 = 47;
        goto L318
    L131:
        if (r100.equals("data_current") == false) goto L9;
        r101 = 46;
        goto L318
    L135:
        if (r100.equals("data_http_rtt") == false) goto L9;
        r101 = 45;
        goto L318
    L139:
        if (r100.equals("data_small_beauty_used") == false) goto L9;
        r101 = 44;
        goto L318
    L143:
        if (r100.equals("data_enter_room_cost") == false) goto L9;
        r101 = 43;
        goto L318
    L147:
        if (r100.equals("data_push_client_fps") == false) goto L9;
        r101 = 42;
        goto L318
    L151:
        if (r100.equals("resolution_key") == false) goto L9;
        r101 = 41;
        goto L318
    L155:
        if (r100.equals("data_host_update_version_code") == false) goto L9;
        r101 = 40;
        goto L318
    L159:
        if (r100.equals("data_live_room_enter_source") == false) goto L9;
        r101 = 39;
        goto L318
    L163:
        if (r100.equals("data_stack_summary") == false) goto L9;
        r101 = 38;
        goto L318
    L167:
        if (r100.equals("surface_render_enabled") == false) goto L9;
        r101 = 37;
        goto L318
    L171:
        if (r100.equals("data_effect_sdk_version") == false) goto L9;
        r101 = 36;
        goto L318
    L175:
        if (r100.equals("data_java_heap_summary") == false) goto L9;
        r101 = 35;
        goto L318
    L179:
        if (r100.equals("data_small_beauty_ids") == false) goto L9;
        r101 = 34;
        goto L318
    L183:
        if (r100.equals("data_host_version_code") == false) goto L9;
        r101 = 33;
        goto L318
    L187:
        if (r100.equals("data_android_release") == false) goto L9;
        r101 = 32;
        goto L318
    L191:
        if (r100.equals("data_mix_type") == false) goto L9;
        r101 = 31;
        goto L318
    L195:
        if (r100.equals("data_gpu_used") == false) goto L9;
        r101 = 30;
        goto L318
    L199:
        if (r100.equals("data_battery_health") == false) goto L9;
        r101 = 29;
        goto L318
    L203:
        if (r100.equals("data_network_status") == false) goto L9;
        r101 = 28;
        goto L318
    L207:
        if (r100.equals("data_pull_download_speed") == false) goto L9;
        r101 = 27;
        goto L318
    L211:
        if (r100.equals("data_push_client_bitrate") == false) goto L9;
        r101 = 26;
        goto L318
    L215:
        if (r100.equals("data_player_sdk_version") == false) goto L9;
        r101 = 25;
        goto L318
    L219:
        if (r100.equals("data_temperature") == false) goto L9;
        r101 = 24;
        goto L318
    L223:
        if (r100.equals("data_end_to_end_delay") == false) goto L9;
        r101 = 23;
        goto L318
    L227:
        if (r100.equals("data_cpu_speed") == false) goto L9;
        r101 = 22;
        goto L318
    L231:
        if (r100.equals("data_current_user_id") == false) goto L9;
        r101 = 21;
        goto L318
    L235:
        if (r100.equals("default_resolution") == false) goto L9;
        r101 = 20;
        goto L318
    L239:
        if (r100.equals("data_current_room_watched") == false) goto L9;
        r101 = 19;
        goto L318
    L243:
        if (r100.equals("data_enter_room_split_cost") == false) goto L9;
        r101 = 18;
        goto L318
    L247:
        if (r100.equals("decode_way") == false) goto L9;
        r101 = 17;
        goto L318
    L251:
        if (r100.equals(IPerformanceManager.PlayerClient.super_resolution_enabled) == false) goto L9;
        r101 = 16;
        goto L318
    L255:
        if (r100.equals("data_avg_fps") == false) goto L9;
        r101 = 15;
        goto L318
    L259:
        if (r100.equals("data_gesture_ids") == false) goto L9;
        r101 = 14;
        goto L318
    L263:
        if (r100.equals("data_device_score") == false) goto L9;
        r101 = HTTP.CR;
        goto L318
    L267:
        if (r100.equals("data_device_model") == false) goto L9;
        r101 = 12;
        goto L318
    L271:
        if (r100.equals("data_device_brand") == false) goto L9;
        r101 = 11;
        goto L318
    L275:
        if (r100.equals("data_native_heap_summary") == false) goto L9;
        r101 = 10;
        goto L318
    L279:
        if (r100.equals("data_private_other_summary") == false) goto L9;
        r101 = 9;
        goto L318
    L283:
        if (r100.equals("data_game_render_fps") == false) goto L9;
        r101 = 8;
        goto L318
    L287:
        if (r100.equals("data_makeup_used") == false) goto L9;
        r101 = 7;
        goto L318
    L291:
        if (r100.equals("data_play_url") == false) goto L9;
        r101 = 6;
        goto L318
    L295:
        if (r100.equals("data_current_device_id") == false) goto L9;
        r101 = 5;
        goto L318
    L299:
        if (r100.equals("data_beauty_used") == false) goto L9;
        r101 = 4;
        goto L318
    L303:
        if (r100.equals("data_filter_used") == false) goto L9;
        r101 = 3;
        goto L318
    L307:
        if (r100.equals(IPerformanceManager.PlayerClient.texture_render_enabled) == false) goto L9;
        r101 = 2;
        goto L318
    L311:
        if (r100.equals("data_pull_stream_bitrate") == true) goto L318;
    L314:
        if (r100.equals("data_invitee_established_time") == false) goto L9;
        r101 = 0;
        goto L318
    L5:
        if (r100.indexOf("@") >= (r100.length() - 1)) goto L7;
        r100 = r100.substring(r100.indexOf("@") + 1);
        goto L7
    }

    public static int d(String r100) {
        r100.getClass();
        switch(r100.hashCode()) {
            case -1828284544: goto L14;
            case 106541: goto L10;
            case 1194522754: goto L6;
            default: goto L4;
        };
    L4:
        byte r101 = -1;
    L17:
        switch(r101) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            default: goto L28;
        };
    L19:
        return 11;
    L23:
        return 13;
    L28:
        return -1;
    L21:
        if (i() == true) goto L26;
        return 14;
    L26:
        return -1;
    L6:
        if (r100.equals("link_mic") == false) goto L4;
        r101 = 2;
        goto L17
    L10:
        if (r100.equals("ktv") == false) goto L4;
        r101 = 1;
        goto L17
    L14:
        if (r100.equals(IPerformanceManager.MODULE_GIFT_EFFECT) == false) goto L4;
        r101 = 0;
        goto L17
    }

    public static List<vr0.a> f(int r100) {
        if (r100 != 2) goto L28;
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) f560792d).iterator();
    L6:
        if (r102.hasNext() == false) goto L27;
        Integer r103 = (Integer) r102.next();
        HashMap<Integer, List<String>> r104 = f560791c;
        if (r104.containsKey(r103) == false) goto L6;
        List<String> r105 = r104.get(r103);
        if (r105 == null) goto L6;
        if (r105.isEmpty() == true) goto L6;
        Iterator<String> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L6;
        String r107 = r106.next();
        HashMap<String, a> r108 = f560790b;
        if (r108.containsKey(r107) == false) goto L17;
        a r109 = r108.get(r107);
        if (r109 == null) goto L17;
        if (r109.f560800d != 0) goto L17;
        vr0.a r110 = new vr0.a();
        r110.f556805a = r107;
        r110.f556806b = c(r107);
        r110.f556807c = r109.f560797a;
        r101.add(r110);
        goto L17
    L27:
        return r101;
    L28:
        LinkedList r111 = new LinkedList();
        if (r100 == 1) goto L31;
    L34:
        HashMap<Integer, List<String>> r112 = f560791c;
        if (r112.containsKey(Integer.valueOf(r100)) == true) goto L37;
        return r111;
    L37:
        List<String> r113 = r112.get(Integer.valueOf(r100));
        if (r113 != null) goto L40;
    L46:
        return r111;
    L40:
        if (r113.isEmpty() == true) goto L46;
        Iterator<String> r114 = r113.iterator();
    L44:
        if (r114.hasNext() == false) goto L46;
        String r115 = r114.next();
        vr0.a r116 = new vr0.a();
        r116.f556805a = r115;
        r116.f556806b = c(r115);
        r116.f556807c = g(r115);
        r111.add(r116);
        goto L44
    L31:
        if (i() == false) goto L33;
        r100 = 9;
        goto L34
    L33:
        r100 = 10;
        goto L34
    }

    public static String g(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        HashMap<String, a> r101 = f560790b;
        if (r101.containsKey(r100) == false) goto L14;
        a r102 = r101.get(r100);
        if (r102 == null) goto L14;
        if (r102.f560800d != 0) goto L14;
        return r102.f560797a;
    L14:
        return "";
    }

    public static HashMap<String, String> h(int r100) {
        HashMap<String, String> r101 = new HashMap();
        switch(r100) {
            case 1000: goto L25;
            case 1001: goto L24;
            case 1002: goto L23;
            case 1003: goto L22;
            case 1004: goto L21;
            case 1005: goto L20;
            case 1006: goto L19;
            case 1007: goto L18;
            case 1008: goto L17;
            case 1009: goto L16;
            case 1010: goto L15;
            case 1011: goto L14;
            case 1012: goto L13;
            case 1013: goto L12;
            case 1014: goto L11;
            case 1015: goto L10;
            case 1016: goto L9;
            case 1017: goto L8;
            case 1018: goto L7;
            case 1019: goto L6;
            case 1020: goto L5;
            default: goto L4;
        };
    L4:
        String r102 = "";
        String r103 = "";
    L26:
        r101.put("data_performance_title", r102);
        r101.put("data_performance_type", r103);
        return r101;
    L5:
        r102 = s1.B(R.string.ttlive_perftools_network_status);
        r103 = "data_network_status";
        goto L26
    L6:
        r102 = s1.B(R.string.ttlive_perftools_network_frequency);
        r103 = "data_network_frequency";
        goto L26
    L7:
        r102 = s1.B(R.string.ttlive_perftools_http_rtt);
        r103 = "data_http_rtt";
        goto L26
    L8:
        r102 = s1.B(R.string.ttlive_perftools_pull_stream_download_speed);
        r103 = "data_pull_download_speed";
        goto L26
    L9:
        r102 = s1.B(R.string.ttlive_perftools_real_fps);
        r103 = "data_avg_fps";
        goto L26
    L10:
        r102 = s1.B(R.string.ttlive_perftools_preview_fps);
        r103 = "data_preview_fps";
        goto L26
    L11:
        r102 = s1.B(R.string.ttlive_perftools_game_fps);
        r103 = "data_game_render_fps";
        goto L26
    L12:
        r102 = s1.B(R.string.ttlive_perftools_battery_temperature);
        r103 = "data_temperature";
        goto L26
    L13:
        r102 = s1.B(R.string.ttlive_perftools_battery_current);
        r103 = "data_current";
        goto L26
    L14:
        r102 = s1.B(R.string.ttlive_perftools_battery_health);
        r103 = "data_battery_health";
        goto L26
    L15:
        r102 = s1.B(R.string.ttlive_perftools_system_used);
        r103 = "data_private_system_summary";
        goto L26
    L16:
        r102 = s1.B(R.string.ttlive_perftools_private_other_used);
        r103 = "data_private_other_summary";
        goto L26
    L17:
        r102 = s1.B(R.string.ttlive_perftools_stack_used);
        r103 = "data_stack_summary";
        goto L26
    L18:
        r102 = s1.B(R.string.ttlive_perftools_code_used);
        r103 = "data_code_summary";
        goto L26
    L19:
        r102 = s1.B(R.string.ttlive_perftools_native_heap_used);
        r103 = "data_native_heap_summary";
        goto L26
    L20:
        r102 = s1.B(R.string.ttlive_perftools_java_heap_used);
        r103 = "data_java_heap_summary";
        goto L26
    L21:
        r102 = s1.B(R.string.ttlive_perftools_graphic_total);
        r103 = "data_graphics";
        goto L26
    L22:
        r102 = s1.B(R.string.ttlive_perftools_pss_total);
        r103 = "data_pss_total";
        goto L26
    L23:
        r102 = s1.B(R.string.ttlive_perftools_gpu_used);
        r103 = "data_gpu_used";
        goto L26
    L24:
        r102 = s1.B(R.string.ttlive_perftools_cpu_speed);
        r103 = "data_cpu_speed";
        goto L26
    L25:
        r102 = s1.B(R.string.ttlive_perftools_cpu_rate);
        r103 = "data_cpu_rate";
        goto L26
    }

    public static String e(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        return r100 + "@" + r101;
    }

    public static void j(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r102 = d(r100);
        if (r102 >= 0) goto L8;
        return;
    L8:
        if (r101 == false) goto L12;
        List<Integer> r103 = f560792d;
        ArrayList r104 = (ArrayList) r103;
        if (r104.contains(Integer.valueOf(r102)) == true) goto L16;
        ArrayList r105 = (ArrayList) r103;
        r105.add(Integer.valueOf(r102));
        return;
    L16:
        return;
    L12:
        List<Integer> r106 = f560792d;
        ArrayList r107 = (ArrayList) r106;
        if (r107.contains(Integer.valueOf(r102)) == false) goto L18;
        ArrayList r108 = (ArrayList) r106;
        r108.remove(Integer.valueOf(r102));
        return;
    }
}
