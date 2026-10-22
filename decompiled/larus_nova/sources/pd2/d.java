package pd2;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.ktv.common.util.MusicInfoError;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends mb0.b implements mb0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f528646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f528647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f528648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f528649e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f528650f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f528651g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f528652h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f528653i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f528654j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<Long, Long> f528655k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f528656l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f528657m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f528658n = null;

    static {
        f528658n = new d();
        f528649e = "err_path";
        f528650f = ((Boolean) h.f556198o3.getValue(null, h.f556082a[221(0xdd, float:3.1E-43)])).booleanValue();
        f528651g = "err_path_paid_check";
        f528652h = "same_music";
        f528653i = "node_timeout";
        f528654j = "param_error";
        f528655k = new LinkedHashMap();
        f528656l = new a();
        f528657m = new e();
    }

    public static void z() {
        JSONObject r100 = new JSONObject();
        r100.put("support_hardware_echo", "0");
        w(LinkMonitorData.BusinessEchoSdkInitSuccess, r100);
    }

    public d() {
    }

    public static void D(long r100) {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r101 = KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r101 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r102 = r101.getCurState();
        if (r102 == null) goto L11;
        MusicPanel r103 = r102.b();
        if (r103 == null) goto L11;
        KtvMusic r104 = r103.f153577a;
        if (r104 == null) goto L11;
        Long r105 = Long.valueOf(r104.getMId());
    L12:
        JSONObject r106 = new JSONObject();
        if (r105 == null) goto L15;
        mb0.b.p(r106, r105.longValue());
    L15:
        BaseMonitor.add(r106, "delta", r100);
        w(LinkMonitorData.BusinessLyricsShowInvalid, r106);
        return;
    L11:
        r105 = null;
        goto L12
    }

    public static void H(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "extraParams");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        w(LinkMonitorData.BusinessPanelAction, r101);
    }

    public static String P(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        switch(r100.hashCode()) {
            case -1573175220: goto L27;
            case -1017267399: goto L24;
            case -980878517: goto L21;
            case -451847020: goto L18;
            case -251973555: goto L15;
            case 278176884: goto L12;
            case 450050607: goto L9;
            case 825102518: goto L6;
            default: goto L45;
        };
    L45:
        return r100;
    L6:
        if (r100.equals("choose_api_success") == false) goto L30;
        return "success";
    L30:
        return r100;
    L9:
        if (r100.equals("choose_check_permission_fail") == false) goto L32;
        return "check_auth_permission_failed";
    L32:
        return r100;
    L12:
        if (r100.equals("choose_download_success") == false) goto L34;
        return "download_success";
    L34:
        return r100;
    L15:
        if (r100.equals("choose_download_fail") == false) goto L36;
        return "download_failed";
    L36:
        return r100;
    L18:
        if (r100.equals("start_choose") == false) goto L38;
        return "start";
    L38:
        return r100;
    L21:
        if (r100.equals("choose_api_fail") == false) goto L40;
        return "api_fail";
    L40:
        return r100;
    L24:
        if (r100.equals("choose_song_limit") == false) goto L42;
        return "song_limt";
    L42:
        return r100;
    L27:
        if (r100.equals("start_sing") == true) goto L29;
        return r100;
    L29:
        return "start_sing";
    }

    public static void u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JSONObject r101 = new JSONObject().put("source", r100);
        w(LinkMonitorData.BusinessAdjustToneButtonClick, r101);
    }

    public final void F(long r100) {
        JSONObject r101 = mb0.b.p(new JSONObject(), r100);
        w(LinkMonitorData.BusinessMidiStatus, r101);
    }

    public final void N(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        JSONObject r101 = mb0.b.p(new JSONObject(), r100.f153577a.getMId());
        List<String> r102 = r100.f153577a.getMLyricUrlList();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = "0";
    L12:
        BaseMonitor.add(r101, "hasLyric", r104);
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L15;
        int r105 = ((IInteractService) k.n(IInteractService.class)).getAudioTalkService().b();
    L16:
        BaseMonitor.add(r101, "audioRoute", r105);
        w(LinkMonitorData.BusinessMusicStartSing, r101);
        b("start_sing", r100, null);
        return;
    L15:
        r105 = ((IInteractService) k.n(IInteractService.class)).getVideoTalkService().K(j.i());
        goto L16
    L11:
        r104 = "1";
        goto L12
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // mb0.c
    public final void e(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        JSONObject r101 = mb0.b.p(new JSONObject(), r100.f153577a.getMId());
        String r102 = r100.f153577a.getMTitle();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        JSONObject r103 = mb0.b.q(r101, r102);
        w(LinkMonitorData.BusinessFavoriteSong, r103);
    }

    @Override // mb0.c
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        JSONObject r101 = new JSONObject().put("keyword", r100);
        w(LinkMonitorData.BusinessSearch, r101);
    }

    public static void A(MusicPanel r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        JSONObject r102 = mb0.b.p(new JSONObject(), r100.f153577a.getMId());
        BaseMonitor.add(r102, MapBundleKey.OfflineMapKey.OFFLINE_RATION, r101);
        w(LinkMonitorData.BusinessMusicFinishSing, r102);
    }

    public static void C(List r100, KtvMusic r101) {
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L5;
        long r103 = r101.getMId();
    L6:
        JSONObject r104 = mb0.b.p(r102, r103);
        String r105 = "";
        if (r101 == null) goto L10;
        String r106 = r101.getMTitle();
        if (r106 == null) goto L10;
    L11:
        JSONObject r107 = mb0.b.q(r104, r106);
        if (r101 == null) goto L19;
        List<String> r108 = r101.getMLyricUrlList();
        if (r108 == null) goto L19;
        String r109 = (String) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L19;
        r105 = r109;
    L19:
        mb0.b.o(r107, r105);
        if (r100 == null) goto L22;
        int r110 = r100.size();
    L23:
        BaseMonitor.add(r102, "lyrics_size", String.valueOf(r110));
        w(LinkMonitorData.BusinessLyricsRender, r102);
        return;
    L22:
        r110 = 0;
    L10:
        r106 = "";
        goto L11
    L5:
        r103 = 0;
        goto L6
    }

    public static void G(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JSONObject r102 = new JSONObject().put("source", r100).put("isFirst", r101);
        w(LinkMonitorData.BusinessOrderSongPanelShow, r102);
    }

    public static void I(MusicPanel r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "curPath");
        JSONObject r102 = new JSONObject().put("cur_path", r101);
        if (r100 == null) goto L12;
        d r103 = f528658n;
        KtvMusic r104 = r100.f153577a;
        if (r104 == null) goto L7;
        Long r105 = Long.valueOf(r104.getMId());
    L8:
        long r106 = r105.longValue();
        r103.getClass();
        JSONObject r107 = mb0.b.p(r102, r106);
        String r108 = r100.f153577a.getMTitle();
        if (r108 != null) goto L11;
        r108 = "";
    L11:
        mb0.b.l(mb0.b.q(r107, r108), r100);
        goto L12
    L7:
        r105 = null;
    L12:
        w(LinkMonitorData.BusinessReportMidiScore, r102);
    }

    public static void s(MusicPanel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "interuptPath");
        if (h.o() == false) goto L5;
        a r102 = f528656l;
        b r103 = new b(r100, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(f528649e, r101)}));
        r102.getClass();
        Intrinsics.checkNotNullParameter("choose_song_path_interrupt", "path");
        Intrinsics.checkNotNullParameter(r103, "param");
        f528658n.getClass();
        r102.a(P("choose_song_path_interrupt"), r103);
        return;
    L5:
        t("choose_song_path_interrupt", r100, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(f528649e, r101)}));
    }

    @JvmStatic
    public static final void v(LinkMonitorData r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "map");
        JSONObject r102 = new JSONObject();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L6:
        w(r100, r102);
    }

    @JvmStatic
    public static final void w(LinkMonitorData r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "extra");
        f528658n.getClass();
        c.a(r111);
        nd0.c.p(nd0.c.f518746a, r110, r111, MultiLinkEventModule.KTV, 0, null, false, null, 120);
        String r112 = "businessName:" + r110.getEventTypeValue() + ", extra:" + r111;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r112 + ", invoke class :" + d.class.getSimpleName());
    }

    @JvmStatic
    public static final void y(long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "path");
        if (Intrinsics.areEqual(r111, "start_cut") == false) goto L6;
        f528646b = true;
        f528648d = r110;
        f528647c = System.currentTimeMillis();
    L9:
        if (f528647c != 0) goto L11;
    L14:
        d r100 = f528658n;
        JSONObject r101 = new JSONObject();
        r100.getClass();
        JSONObject r112 = mb0.b.p(r101, r110);
        Intrinsics.checkNotNullParameter(r112, "$this$putPath");
        Intrinsics.checkNotNullParameter(r111, "path");
        JSONObject r113 = r112.put("path", r111);
        if ((!Intrinsics.areEqual(r111, "start_cut")) == false) goto L17;
        long r102 = System.currentTimeMillis() - f528647c;
        Intrinsics.checkNotNullParameter(r113, "$this$putDuration");
        r113.put("duration", r102);
    L17:
        w(LinkMonitorData.BusinessCutMusicPath, r113);
        int r114 = r111.hashCode();
        if (r114 == (-158830720)) goto L26;
        if (r114 == 1748725402) goto L23;
        return;
    L23:
        if (r111.equals("cut_music_list_change") == false) goto L29;
        f528646b = false;
        f528647c = 0;
        f528648d = 0;
        return;
    L29:
        return;
    L26:
        if (r111.equals("cut_api_fail") == false) goto L31;
        f528646b = false;
        f528647c = 0;
        f528648d = 0;
        return;
    L31:
        return;
    L11:
        if ((System.currentTimeMillis() - f528647c) <= 10000) goto L14;
        f528646b = false;
        f528647c = 0;
        f528648d = 0;
        return;
    L6:
        if (f528646b == true) goto L9;
    }

    @Override // mb0.c
    public final void h(KtvMusic r100, MusicInfoError r101) {
        Intrinsics.checkNotNullParameter(r101, "errorInfo");
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r102 = mb0.b.p(new JSONObject(), r100.getMId());
        String r103 = r100.getMTitle();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        JSONObject r104 = mb0.b.n(mb0.b.m(mb0.b.q(r102, r103), Integer.valueOf(r101.getErrorCode())), r101.getErrorMsg());
        w(LinkMonitorData.BusinessMusicInfoStatus, r104);
    }

    public static void B(String r100, MusicPanel r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r101 == null) goto L9;
        d r103 = f528658n;
        LinkMonitorData r104 = LinkMonitorData.BusinessChooseSongPath;
        r103.getClass();
        x(r104, r100, r101, r102);
        if (h.o() == false) goto L7;
        f528656l.f(r100, new b(r101, r102));
        return;
    L7:
        x(LinkMonitorData.BusinessMultiKtvChooseSongPath, r100, r101, r102);
        return;
    }

    public static void L(d r100, long r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "process");
        if (((Boolean) vm2.d.K3.getValue(null, vm2.d.f555776a[242(0xf2, float:3.39E-43)])).booleanValue() == false) goto L7;
        f528657m.e(r102, new f(r101, null));
        return;
    }

    public static void M(d r100, MusicPanel r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "process");
        if (((Boolean) vm2.d.K3.getValue(null, vm2.d.f555776a[242(0xf2, float:3.39E-43)])).booleanValue() == false) goto L9;
        if (r101 == null) goto L8;
        long r103 = r101.c();
        f528657m.e(r102, new f(r103, null));
        return;
    L8:
        return;
    }

    public static void t(String r100, MusicPanel r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, "originPath");
        Intrinsics.checkNotNullParameter(r101, "musicPanel");
        JSONObject r103 = mb0.b.p(new JSONObject(), r101.f153577a.getMId());
        String r104 = r101.f153577a.getMTitle();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        JSONObject r105 = mb0.b.q(r103, r104);
        Intrinsics.checkNotNullParameter(r105, "$this$putPath");
        Intrinsics.checkNotNullParameter(r100, "path");
        JSONObject r106 = r105.put("path", r100);
        mb0.b.r(r106, r100);
        if (r102 == null) goto L11;
        Iterator r107 = r102.entrySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.put((String) r108.getKey(), r108.getValue());
    L11:
        w(LinkMonitorData.BusinessMultiKtvChooseSongPath, r106);
    }

    public final void E(LinkMonitorData r110, tlc.d r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Intrinsics.checkNotNullParameter(r112, "extra");
        long r100 = r111.getMessageId();
        Intrinsics.checkNotNullParameter(r112, "$this$putMessageId");
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, String.valueOf(r100));
        if ((r111 instanceof t) == false) goto L9;
        m0 r113 = ((t) r111).getBaseMessage();
        if (r113 == null) goto L7;
        long r101 = r113.getMessageId();
    L8:
        Intrinsics.checkNotNullParameter(r112, "$this$putServerMessageName");
        r112.put("server_message_name", String.valueOf(r101));
        goto L9
    L7:
        r101 = 0;
    L9:
        c.a(r112);
        nd0.c.p(nd0.c.f518746a, r110, r112, MultiLinkEventModule.KTV, 0, null, false, null, 120);
        String r114 = "on Message:" + r110.getEventTypeValue() + ", extra:" + r112;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r114 + ", invoke class :" + d.class.getSimpleName());
    }

    @Override // mb0.c
    public final void b(String r100, MusicPanel r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "musicPanel");
        x(LinkMonitorData.BusinessChooseSongPath, r100, r101, r102);
        if (h.o() == false) goto L5;
        f528656l.f(r100, new b(r101, r102));
        return;
    L5:
        x(LinkMonitorData.BusinessMultiKtvChooseSongPath, r100, r101, r102);
    }

    @Override // mb0.c
    public final void g(long r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "url");
        JSONObject r103 = mb0.b.o(mb0.b.p(new JSONObject(), r100), r101);
        w(LinkMonitorData.BusinessLyricsDownloadSuccess, r103);
    }

    @Override // mb0.c
    public final void i(String r100, long r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "$this$putPage");
        Intrinsics.checkNotNullParameter(r100, "page");
        JSONObject r104 = r103.put("page", r100);
        Intrinsics.checkNotNullParameter(r104, "$this$putDuration");
        JSONObject r105 = r104.put("duration", r101);
        Iterator<Map.Entry<String, String>> r106 = r102.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Map.Entry<String, String> r107 = r106.next();
        r105.put(r107.getKey(), r107.getValue());
        goto L4
    L6:
        w(LinkMonitorData.BusinessFirstFrameTime, r105);
    }

    public static void K(MusicPanel r100, String r101, int r102, Exception r103) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "funcType");
        JSONObject r104 = new JSONObject();
        KtvMusic r105 = r100.f153577a;
        String r106 = null;
        if (r105 == null) goto L5;
        Long r107 = Long.valueOf(r105.getMId());
    L6:
        JSONObject r108 = mb0.b.p(r104, r107.longValue());
        KtvMusic r109 = r100.f153577a;
        String r110 = "";
        if (r109 == null) goto L10;
        String r111 = r109.getMTitle();
        if (r111 == null) goto L10;
    L11:
        JSONObject r112 = mb0.b.q(r108, r111);
        List<String> r113 = r100.f153577a.getMLyricUrlList();
        if (r113 == null) goto L15;
        String r114 = (String) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L15;
    L16:
        JSONObject r115 = mb0.b.o(r112, r114);
        BaseMonitor.add(r115, "full_track_local_path", r100.f153590n);
        AudioInfo r116 = r100.f153577a.getMFullTrack();
        if (r116 == null) goto L20;
        String r117 = r116.getMUrl();
        if (r117 == null) goto L20;
    L21:
        BaseMonitor.add(r115, "full_track_url", r117);
        BaseMonitor.add(r115, "accompaniment_track_local_path", r100.f153591o);
        AudioInfo r118 = r100.f153577a.getMAccompanimentTrack();
        if (r118 == null) goto L27;
        String r119 = r118.getMUrl();
        if (r119 == null) goto L27;
        r110 = r119;
    L27:
        BaseMonitor.add(r115, "accompaniment_track_url", r110);
        BaseMonitor.add(r115, "lyrics_local_path", r100.f153588l);
        BaseMonitor.add(r115, "midi_local_path", r100.f153593q);
        BaseMonitor.add(r115, "midi_url", r100.f153577a.getMidiUrl());
        BaseMonitor.add(r115, "function_type", r101);
        BaseMonitor.add(r115, "status_code", String.valueOf(r102));
        BaseMonitor.add(r115, "reason", String.valueOf(i.f142515t.get(Integer.valueOf(r102))));
        if (r103 == null) goto L30;
        r106 = r103.getMessage();
    L30:
        BaseMonitor.add(r115, "stack_trace", String.valueOf(r106));
        w(LinkMonitorData.BusinessPlayMusicPlayFailed, r115);
        return;
    L20:
        r117 = "";
    L15:
        r114 = "";
    L10:
        r111 = "";
        goto L11
    L5:
        r107 = null;
        goto L6
    }

    public static void O(long r100, String r101, int r102, com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a r103) {
        Intrinsics.checkNotNullParameter(r101, "lyricsUrl");
        Intrinsics.checkNotNullParameter(r103, "info");
        JSONObject r104 = mb0.b.o(mb0.b.p(new JSONObject(), r100), r101);
        Intrinsics.checkNotNullParameter(r104, "$this$putLyricsType");
        JSONObject r105 = mb0.b.n(mb0.b.m(r104.put("lyrics_type", r102), Integer.valueOf(r103.f143194a)), r103.f143195b);
        w(LinkMonitorData.BusinessLyricsParseStatusFail, r105);
    }

    public static void x(LinkMonitorData r100, String r101, MusicPanel r102, HashMap r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "originPath");
        Intrinsics.checkNotNullParameter(r102, "musicPanel");
        JSONObject r104 = mb0.b.p(new JSONObject(), r102.f153577a.getMId());
        String r105 = r102.f153577a.getMTitle();
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        JSONObject r106 = mb0.b.q(r104, r105);
        Intrinsics.checkNotNullParameter(r106, "$this$putPath");
        Intrinsics.checkNotNullParameter(r101, "path");
        JSONObject r107 = r106.put("path", r101);
        if (r100 != LinkMonitorData.BusinessMultiKtvChooseSongPath) goto L14;
        mb0.b.r(r107, P(r101));
        if (r103 == null) goto L14;
        Iterator r108 = r103.entrySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L14;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.put((String) r109.getKey(), r109.getValue());
    L14:
        if (Intrinsics.areEqual(r101, "start_choose") == false) goto L16;
    L17:
        f528655k.put(Long.valueOf(r102.f153577a.getMId()), Long.valueOf(System.currentTimeMillis()));
    L19:
        if ((!Intrinsics.areEqual(r101, "start_choose")) == true) goto L21;
    L29:
        w(r100, r107);
        return;
    L21:
        if ((!Intrinsics.areEqual(r101, "start")) == false) goto L29;
        Map<Long, Long> r110 = f528655k;
        Long r111 = (Long) ((LinkedHashMap) r110).get(Long.valueOf(r102.f153577a.getMId()));
        if (r111 == null) goto L29;
        long r112 = r111.longValue();
        d r113 = f528658n;
        long r114 = System.currentTimeMillis() - r112;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r107, "$this$putDuration");
        r107.put("duration", r114);
        if (Intrinsics.areEqual(r101, "start_sing") == false) goto L27;
    L28:
        r110.remove(Long.valueOf(r102.f153577a.getMId()));
        goto L29
    L27:
        if (Intrinsics.areEqual(r101, "start_sing") == false) goto L29;
    L16:
        if (Intrinsics.areEqual(r101, "start") == false) goto L19;
        goto L17
    }

    @Override // mb0.c
    public final void a(LinkMonitorData r110, long r111, Throwable r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r113, "extra");
        c.a(r113);
        nd0.c.r(nd0.c.f518746a, r110, MultiLinkEventModule.KTV, r111, r112, r113, 32);
        String r114 = "api call fail:" + r110.getEventTypeValue() + ", extra:" + r113;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r114 + ", invoke class :" + d.class.getSimpleName());
    }

    @Override // mb0.c
    public final void c(long r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        JSONObject r104 = mb0.b.m(mb0.b.n(mb0.b.o(mb0.b.p(new JSONObject(), r100), r101), r103), Integer.valueOf(r102));
        w(LinkMonitorData.BusinessLyricsDownloadFail, r104);
    }

    @Override // mb0.c
    public final void d(MusicPanel r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "downloadUrl");
        if (r100 != null) goto L5;
        return;
    L5:
        int r104 = r101.hashCode();
        if (r104 == (-1959575691)) goto L16;
        if (r104 == (-446820453)) goto L11;
    L20:
        long r105 = 0;
    L21:
        JSONObject r106 = mb0.b.p(new JSONObject(), r100.f153577a.getMId());
        Intrinsics.checkNotNullParameter(r106, "$this$putType");
        Intrinsics.checkNotNullParameter(r101, "type");
        JSONObject r107 = r106.put("type", r101);
        Intrinsics.checkNotNullParameter(r107, "$this$putAudioId");
        JSONObject r108 = r107.put("audio_id", r105);
        Intrinsics.checkNotNullParameter(r108, "$this$putDownloadUrl");
        Intrinsics.checkNotNullParameter(r102, "url");
        JSONObject r109 = r108.put("download _url", r102);
        w(LinkMonitorData.BusinessMusicDownloadStatusSuccess, r109);
        return;
    L11:
        if (r101.equals("full_track") == false) goto L20;
        AudioInfo r110 = r100.f153577a.getMFullTrack();
        if (r110 == null) goto L20;
        r105 = r110.getMAudioId();
        goto L21
    L16:
        if (r101.equals("accompaniment_track") == false) goto L20;
        AudioInfo r111 = r100.f153577a.getMAccompanimentTrack();
        if (r111 == null) goto L20;
        r105 = r111.getMAudioId();
        goto L21
    }

    @Override // mb0.c
    public final void j(LinkMonitorData r110, long r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r112, "logId");
        Intrinsics.checkNotNullParameter(r113, "extra");
        c.a(r113);
        nd0.c.s(nd0.c.f518746a, r110, MultiLinkEventModule.KTV, r111, r112, r113, 96);
        String r114 = "api call success:" + r110.getEventTypeValue() + ", extra:" + r113;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r114 + ", invoke class :" + d.class.getSimpleName());
    }

    @Override // mb0.c
    public final void f(MusicPanel r100, String r101, String r102, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "downloadUrl");
        Intrinsics.checkNotNullParameter(r111, "errorMsg");
        if (r100 != null) goto L5;
        return;
    L5:
        int r103 = r101.hashCode();
        if (r103 == (-1959575691)) goto L16;
        if (r103 == (-446820453)) goto L11;
    L20:
        long r104 = 0;
    L21:
        JSONObject r105 = mb0.b.p(new JSONObject(), r100.f153577a.getMId());
        Intrinsics.checkNotNullParameter(r105, "$this$putAudioId");
        JSONObject r106 = r105.put("audio_id", r104);
        Intrinsics.checkNotNullParameter(r106, "$this$putType");
        Intrinsics.checkNotNullParameter(r101, "type");
        JSONObject r107 = r106.put("type", r101);
        Intrinsics.checkNotNullParameter(r107, "$this$putDownloadUrl");
        Intrinsics.checkNotNullParameter(r102, "url");
        JSONObject r108 = mb0.b.m(mb0.b.n(r107.put("download _url", r102), r111), Integer.valueOf(r110));
        w(LinkMonitorData.BusinessMusicDownloadStatusFail, r108);
        return;
    L11:
        if (r101.equals("full_track") == false) goto L20;
        AudioInfo r109 = r100.f153577a.getMFullTrack();
        if (r109 == null) goto L20;
        r104 = r109.getMAudioId();
        goto L21
    L16:
        if (r101.equals("accompaniment_track") == false) goto L20;
        AudioInfo r112 = r100.f153577a.getMAccompanimentTrack();
        if (r112 == null) goto L20;
        r104 = r112.getMAudioId();
        goto L21
    }

    public static void J(d r100, String r101, String r102, Long r103, Queue r104, int r105) {
        Integer r106 = null;
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "reason");
        JSONObject r107 = new JSONObject();
        BaseMonitor.add(r107, "reason", r101);
        int r108 = r101.hashCode();
        if (r108 == (-981062358)) goto L25;
        if (r108 == 28675372) goto L20;
        if (r108 != 1333677739) goto L30;
        r101.equals("processor_fail");
    L30:
        w(LinkMonitorData.BusinessSeiFail, r107);
        return;
    L20:
        if (r101.equals("cache_full") == false) goto L30;
        if (r104 == null) goto L23;
        r106 = Integer.valueOf(r104.size());
    L23:
        BaseMonitor.add(r107, "sei_cache_capacity", String.valueOf(r106));
        goto L30
    L25:
        if (r101.equals("parse_fail") == false) goto L30;
        BaseMonitor.add(r107, "sei_content", r102);
        BaseMonitor.add(r107, HiAnalyticsConstant.BI_KEY_COST_TIME, String.valueOf(r103));
        BaseMonitor.add(r107, "sei_cache_capacity", String.valueOf(((Number) h.f556254v3.getValue(null, h.f556082a[228(0xe4, float:3.2E-43)])).intValue()));
        if (r104 == null) goto L29;
        r106 = Integer.valueOf(r104.size());
    L29:
        BaseMonitor.add(r107, "sei_cache_size", String.valueOf(r106));
        goto L30
    }
}
