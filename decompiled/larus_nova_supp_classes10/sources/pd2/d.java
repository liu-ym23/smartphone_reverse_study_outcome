package pd2;

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
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends mb0.b implements mb0.c {
    public static boolean b;
    public static long c;
    public static long d;
    public static final String e = null;
    public static final boolean f = false;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public static final String j = null;
    public static final Map<Long, Long> k = null;
    public static final a l = null;
    public static final e m = null;
    public static final d n = null;

    static {
        n = new d();
        e = "err_path";
        f = ((Boolean) h.o3.getValue(null, h.a[221(0xdd, float:3.1E-43)])).booleanValue();
        g = "err_path_paid_check";
        h = "same_music";
        i = "node_timeout";
        j = "param_error";
        k = new LinkedHashMap();
        l = new a();
        m = new e();
    }

    public static void z() {
        JSONObject r0 = new JSONObject();
        r0.put("support_hardware_echo", BDLocationException.ERROR_TIMEOUT);
        w(LinkMonitorData.BusinessEchoSdkInitSuccess, r0);
    }

    public d() {
    }

    public static void D(long r4) {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L11;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L11;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L11;
        Long r5 = Long.valueOf(r3.getMId());
    L12:
        JSONObject r6 = new JSONObject();
        if (r5 == null) goto L15;
        mb0.b.p(r6, r5.longValue());
    L15:
        BaseMonitor.add(r6, "delta", r4);
        w(LinkMonitorData.BusinessLyricsShowInvalid, r6);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public static void H(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "extraParams");
        JSONObject r0 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), r1.getValue());
        goto L4
    L6:
        w(LinkMonitorData.BusinessPanelAction, r0);
    }

    public static String P(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        switch(r2.hashCode()) {
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
        return r2;
    L6:
        if (r2.equals("choose_api_success") == false) goto L30;
        return "success";
    L30:
        return r2;
    L9:
        if (r2.equals("choose_check_permission_fail") == false) goto L32;
        return "check_auth_permission_failed";
    L32:
        return r2;
    L12:
        if (r2.equals("choose_download_success") == false) goto L34;
        return "download_success";
    L34:
        return r2;
    L15:
        if (r2.equals("choose_download_fail") == false) goto L36;
        return "download_failed";
    L36:
        return r2;
    L18:
        if (r2.equals("start_choose") == false) goto L38;
        return "start";
    L38:
        return r2;
    L21:
        if (r2.equals("choose_api_fail") == false) goto L40;
        return "api_fail";
    L40:
        return r2;
    L24:
        if (r2.equals("choose_song_limit") == false) goto L42;
        return "song_limt";
    L42:
        return r2;
    L27:
        if (r2.equals("start_sing") == true) goto L29;
        return r2;
    L29:
        return "start_sing";
    }

    public static void u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        JSONObject r3 = new JSONObject().put("source", r2);
        w(LinkMonitorData.BusinessAdjustToneButtonClick, r3);
    }

    public final void F(long r2) {
        JSONObject r3 = mb0.b.p(new JSONObject(), r2);
        w(LinkMonitorData.BusinessMidiStatus, r3);
    }

    public final void N(MusicPanel r4) {
        Intrinsics.checkNotNullParameter(r4, "musicPanel");
        JSONObject r0 = mb0.b.p(new JSONObject(), r4.a.getMId());
        List r1 = r4.a.getMLyricUrlList();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r3 = BDLocationException.ERROR_TIMEOUT;
    L12:
        BaseMonitor.add(r0, "hasLyric", r3);
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L15;
        int r5 = k.n(IInteractService.class).getAudioTalkService().b();
    L16:
        BaseMonitor.add(r0, "audioRoute", r5);
        w(LinkMonitorData.BusinessMusicStartSing, r0);
        b("start_sing", r4, null);
        return;
    L15:
        r5 = k.n(IInteractService.class).getVideoTalkService().K(j.i());
        goto L16
    L11:
        r3 = "1";
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void e(MusicPanel r4) {
        Intrinsics.checkNotNullParameter(r4, "musicPanel");
        JSONObject r0 = mb0.b.p(new JSONObject(), r4.a.getMId());
        String r5 = r4.a.getMTitle();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        JSONObject r6 = mb0.b.q(r0, r5);
        w(LinkMonitorData.BusinessFavoriteSong, r6);
    }

    public final void k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "keyword");
        JSONObject r4 = new JSONObject().put("keyword", r3);
        w(LinkMonitorData.BusinessSearch, r4);
    }

    public static void A(MusicPanel r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        JSONObject r5 = mb0.b.p(new JSONObject(), r3.a.getMId());
        BaseMonitor.add(r5, "ratio", r4);
        w(LinkMonitorData.BusinessMusicFinishSing, r5);
    }

    public static void C(List r4, KtvMusic r5) {
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L5;
        long r1 = r5.getMId();
    L6:
        JSONObject r2 = mb0.b.p(r0, r1);
        String r3 = "";
        if (r5 == null) goto L10;
        String r6 = r5.getMTitle();
        if (r6 == null) goto L10;
    L11:
        JSONObject r7 = mb0.b.q(r2, r6);
        if (r5 == null) goto L19;
        List r8 = r5.getMLyricUrlList();
        if (r8 == null) goto L19;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L19;
        r3 = r9;
    L19:
        mb0.b.o(r7, r3);
        if (r4 == null) goto L22;
        int r10 = r4.size();
    L23:
        BaseMonitor.add(r0, "lyrics_size", String.valueOf(r10));
        w(LinkMonitorData.BusinessLyricsRender, r0);
        return;
    L22:
        r10 = 0;
    L10:
        r6 = "";
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    public static void G(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        JSONObject r4 = new JSONObject().put("source", r2).put("isFirst", r3);
        w(LinkMonitorData.BusinessOrderSongPanelShow, r4);
    }

    public static void I(MusicPanel r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "curPath");
        JSONObject r5 = new JSONObject().put("cur_path", r4);
        if (r3 == null) goto L12;
        d r0 = n;
        KtvMusic r1 = r3.a;
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.getMId());
    L8:
        long r6 = r2.longValue();
        r0.getClass();
        JSONObject r7 = mb0.b.p(r5, r6);
        String r8 = r3.a.getMTitle();
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        mb0.b.l(mb0.b.q(r7, r8), r3);
        goto L12
    L7:
        r2 = null;
    L12:
        w(LinkMonitorData.BusinessReportMidiScore, r5);
    }

    public static void s(MusicPanel r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "musicPanel");
        Intrinsics.checkNotNullParameter(r7, "interuptPath");
        if (h.o() == false) goto L5;
        a r0 = l;
        b r4 = new b(r6, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(e, r7)}));
        r0.getClass();
        Intrinsics.checkNotNullParameter("choose_song_path_interrupt", "path");
        Intrinsics.checkNotNullParameter(r4, "param");
        n.getClass();
        r0.a(P("choose_song_path_interrupt"), r4);
        return;
    L5:
        t("choose_song_path_interrupt", r6, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(e, r7)}));
    }

    @JvmStatic
    public static final void v(LinkMonitorData r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "map");
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r5.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        w(r3, r0);
    }

    @JvmStatic
    public static final void w(LinkMonitorData r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "extra");
        n.getClass();
        c.a(r11);
        nd0.c.p(nd0.c.a, r10, r11, MultiLinkEventModule.KTV, 0, null, false, null, 120);
        String r12 = "businessName:" + r10.getEventTypeValue() + ", extra:" + r11;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r12 + ", invoke class :" + d.class.getSimpleName());
    }

    @JvmStatic
    public static final void y(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        if (Intrinsics.areEqual(r13, "start_cut") == false) goto L6;
        b = true;
        d = r11;
        c = System.currentTimeMillis();
    L9:
        if (c != 0) goto L11;
    L14:
        d r4 = n;
        JSONObject r5 = new JSONObject();
        r4.getClass();
        JSONObject r12 = mb0.b.p(r5, r11);
        Intrinsics.checkNotNullParameter(r12, "$this$putPath");
        Intrinsics.checkNotNullParameter(r13, "path");
        JSONObject r14 = r12.put("path", r13);
        if ((!Intrinsics.areEqual(r13, "start_cut")) == false) goto L17;
        long r0 = System.currentTimeMillis() - c;
        Intrinsics.checkNotNullParameter(r14, "$this$putDuration");
        r14.put("duration", r0);
    L17:
        w(LinkMonitorData.BusinessCutMusicPath, r14);
        int r15 = r13.hashCode();
        if (r15 == (-158830720)) goto L26;
        if (r15 == 1748725402) goto L23;
        return;
    L23:
        if (r13.equals("cut_music_list_change") == false) goto L29;
        b = false;
        c = 0;
        d = 0;
        return;
    L29:
        return;
    L26:
        if (r13.equals("cut_api_fail") == false) goto L31;
        b = false;
        c = 0;
        d = 0;
        return;
    L31:
        return;
    L11:
        if ((System.currentTimeMillis() - c) <= 10000) goto L14;
        b = false;
        c = 0;
        d = 0;
        return;
    L6:
        if (b == true) goto L9;
    }

    public final void h(KtvMusic r4, MusicInfoError r5) {
        Intrinsics.checkNotNullParameter(r5, "errorInfo");
        if (r4 != null) goto L5;
        return;
    L5:
        JSONObject r0 = mb0.b.p(new JSONObject(), r4.getMId());
        String r6 = r4.getMTitle();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        JSONObject r7 = mb0.b.n(mb0.b.m(mb0.b.q(r0, r6), Integer.valueOf(r5.getErrorCode())), r5.getErrorMsg());
        w(LinkMonitorData.BusinessMusicInfoStatus, r7);
    }

    public static void B(String r2, MusicPanel r3, HashMap r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        if (r3 == null) goto L9;
        d r0 = n;
        LinkMonitorData r1 = LinkMonitorData.BusinessChooseSongPath;
        r0.getClass();
        x(r1, r2, r3, r4);
        if (h.o() == false) goto L7;
        l.f(r2, new b(r3, r4));
        return;
    L7:
        x(LinkMonitorData.BusinessMultiKtvChooseSongPath, r2, r3, r4);
        return;
    }

    public static void L(d r2, long r3, String r5) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "process");
        if (((Boolean) vm2.d.K3.getValue(null, vm2.d.a[242(0xf2, float:3.39E-43)])).booleanValue() == false) goto L7;
        m.e(r5, new f(r3, null));
        return;
    }

    public static void M(d r3, MusicPanel r4, String r5) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "process");
        if (((Boolean) vm2.d.K3.getValue(null, vm2.d.a[242(0xf2, float:3.39E-43)])).booleanValue() == false) goto L9;
        if (r4 == null) goto L8;
        long r6 = r4.c();
        m.e(r5, new f(r6, null));
        return;
    L8:
        return;
    }

    public static void t(String r3, MusicPanel r4, HashMap r5) {
        Intrinsics.checkNotNullParameter(r3, "originPath");
        Intrinsics.checkNotNullParameter(r4, "musicPanel");
        JSONObject r0 = mb0.b.p(new JSONObject(), r4.a.getMId());
        String r6 = r4.a.getMTitle();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        JSONObject r7 = mb0.b.q(r0, r6);
        Intrinsics.checkNotNullParameter(r7, "$this$putPath");
        Intrinsics.checkNotNullParameter(r3, "path");
        JSONObject r8 = r7.put("path", r3);
        mb0.b.r(r8, r3);
        if (r5 == null) goto L11;
        Iterator r9 = r5.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        Map.Entry r10 = (Map.Entry) r9.next();
        r8.put((String) r10.getKey(), r10.getValue());
    L11:
        w(LinkMonitorData.BusinessMultiKtvChooseSongPath, r8);
    }

    public final void E(LinkMonitorData r11, tlc.d r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(r13, "extra");
        long r0 = r12.getMessageId();
        Intrinsics.checkNotNullParameter(r13, "$this$putMessageId");
        r13.put("message_id", String.valueOf(r0));
        if ((r12 instanceof t) == false) goto L9;
        m0 r14 = ((t) r12).getBaseMessage();
        if (r14 == null) goto L7;
        long r1 = r14.getMessageId();
    L8:
        Intrinsics.checkNotNullParameter(r13, "$this$putServerMessageName");
        r13.put("server_message_name", String.valueOf(r1));
        goto L9
    L7:
        r1 = 0;
    L9:
        c.a(r13);
        nd0.c.p(nd0.c.a, r11, r13, MultiLinkEventModule.KTV, 0, null, false, null, 120);
        String r15 = "on Message:" + r11.getEventTypeValue() + ", extra:" + r13;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r15 + ", invoke class :" + d.class.getSimpleName());
    }

    public final void b(String r3, MusicPanel r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "musicPanel");
        x(LinkMonitorData.BusinessChooseSongPath, r3, r4, r5);
        if (h.o() == false) goto L5;
        l.f(r3, new b(r4, r5));
        return;
    L5:
        x(LinkMonitorData.BusinessMultiKtvChooseSongPath, r3, r4, r5);
    }

    public final void g(long r1, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        JSONObject r2 = mb0.b.o(mb0.b.p(new JSONObject(), r1), r3);
        w(LinkMonitorData.BusinessLyricsDownloadSuccess, r2);
    }

    public final void i(String r4, long r5, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r4, "page");
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "$this$putPage");
        Intrinsics.checkNotNullParameter(r4, "page");
        JSONObject r6 = r1.put("page", r4);
        Intrinsics.checkNotNullParameter(r6, "$this$putDuration");
        JSONObject r8 = r6.put("duration", r5);
        Iterator<Map.Entry<String, String>> r9 = r7.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry<String, String> r10 = r9.next();
        r8.put(r10.getKey(), r10.getValue());
        goto L4
    L6:
        w(LinkMonitorData.BusinessFirstFrameTime, r8);
    }

    public static void K(MusicPanel r5, String r6, int r7, Exception r8) {
        Intrinsics.checkNotNullParameter(r5, "musicPanel");
        Intrinsics.checkNotNullParameter(r6, "funcType");
        JSONObject r0 = new JSONObject();
        KtvMusic r1 = r5.a;
        String r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.getMId());
    L6:
        JSONObject r4 = mb0.b.p(r0, r3.longValue());
        KtvMusic r9 = r5.a;
        String r10 = "";
        if (r9 == null) goto L10;
        String r11 = r9.getMTitle();
        if (r11 == null) goto L10;
    L11:
        JSONObject r12 = mb0.b.q(r4, r11);
        List r13 = r5.a.getMLyricUrlList();
        if (r13 == null) goto L15;
        String r14 = (String) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L15;
    L16:
        JSONObject r15 = mb0.b.o(r12, r14);
        BaseMonitor.add(r15, "full_track_local_path", r5.n);
        AudioInfo r16 = r5.a.getMFullTrack();
        if (r16 == null) goto L20;
        String r17 = r16.getMUrl();
        if (r17 == null) goto L20;
    L21:
        BaseMonitor.add(r15, "full_track_url", r17);
        BaseMonitor.add(r15, "accompaniment_track_local_path", r5.o);
        AudioInfo r18 = r5.a.getMAccompanimentTrack();
        if (r18 == null) goto L27;
        String r19 = r18.getMUrl();
        if (r19 == null) goto L27;
        r10 = r19;
    L27:
        BaseMonitor.add(r15, "accompaniment_track_url", r10);
        BaseMonitor.add(r15, "lyrics_local_path", r5.l);
        BaseMonitor.add(r15, "midi_local_path", r5.q);
        BaseMonitor.add(r15, "midi_url", r5.a.getMidiUrl());
        BaseMonitor.add(r15, "function_type", r6);
        BaseMonitor.add(r15, "status_code", String.valueOf(r7));
        BaseMonitor.add(r15, "reason", String.valueOf(i.t.get(Integer.valueOf(r7))));
        if (r8 == null) goto L30;
        r2 = r8.getMessage();
    L30:
        BaseMonitor.add(r15, LocationMonitorConst.STACK_TRACE, String.valueOf(r2));
        w(LinkMonitorData.BusinessPlayMusicPlayFailed, r15);
        return;
    L20:
        r17 = "";
    L15:
        r14 = "";
    L10:
        r11 = "";
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public static void O(long r1, String r3, int r4, com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a r5) {
        Intrinsics.checkNotNullParameter(r3, "lyricsUrl");
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.INFO);
        JSONObject r2 = mb0.b.o(mb0.b.p(new JSONObject(), r1), r3);
        Intrinsics.checkNotNullParameter(r2, "$this$putLyricsType");
        JSONObject r6 = mb0.b.n(mb0.b.m(r2.put("lyrics_type", r4), Integer.valueOf(r5.a)), r5.b);
        w(LinkMonitorData.BusinessLyricsParseStatusFail, r6);
    }

    public static void x(LinkMonitorData r6, String r7, MusicPanel r8, HashMap r9) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "originPath");
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        JSONObject r0 = mb0.b.p(new JSONObject(), r8.a.getMId());
        String r1 = r8.a.getMTitle();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        JSONObject r2 = mb0.b.q(r0, r1);
        Intrinsics.checkNotNullParameter(r2, "$this$putPath");
        Intrinsics.checkNotNullParameter(r7, "path");
        JSONObject r3 = r2.put("path", r7);
        if (r6 != LinkMonitorData.BusinessMultiKtvChooseSongPath) goto L14;
        mb0.b.r(r3, P(r7));
        if (r9 == null) goto L14;
        Iterator r10 = r9.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r10.next();
        r3.put((String) r4.getKey(), r4.getValue());
    L14:
        if (Intrinsics.areEqual(r7, "start_choose") == false) goto L16;
    L17:
        k.put(Long.valueOf(r8.a.getMId()), Long.valueOf(System.currentTimeMillis()));
    L19:
        if ((!Intrinsics.areEqual(r7, "start_choose")) == true) goto L21;
    L29:
        w(r6, r3);
        return;
    L21:
        if ((!Intrinsics.areEqual(r7, "start")) == false) goto L29;
        Map<Long, Long> r11 = k;
        Long r5 = (Long) ((LinkedHashMap) r11).get(Long.valueOf(r8.a.getMId()));
        if (r5 == null) goto L29;
        long r12 = r5.longValue();
        d r13 = n;
        long r14 = System.currentTimeMillis() - r12;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$putDuration");
        r3.put("duration", r14);
        if (Intrinsics.areEqual(r7, "start_sing") == false) goto L27;
    L28:
        r11.remove(Long.valueOf(r8.a.getMId()));
        goto L29
    L27:
        if (Intrinsics.areEqual(r7, "start_sing") == false) goto L29;
    L16:
        if (Intrinsics.areEqual(r7, "start") == false) goto L19;
        goto L17
    }

    public final void a(LinkMonitorData r10, long r11, Throwable r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r14, "extra");
        c.a(r14);
        nd0.c.r(nd0.c.a, r10, MultiLinkEventModule.KTV, r11, r13, r14, 32);
        String r12 = "api call fail:" + r10.getEventTypeValue() + ", extra:" + r14;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r12 + ", invoke class :" + d.class.getSimpleName());
    }

    public final void c(long r2, String r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        JSONObject r3 = mb0.b.m(mb0.b.n(mb0.b.o(mb0.b.p(new JSONObject(), r2), r4), r6), Integer.valueOf(r5));
        w(LinkMonitorData.BusinessLyricsDownloadFail, r3);
    }

    public final void d(MusicPanel r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r7, "downloadUrl");
        if (r5 != null) goto L5;
        return;
    L5:
        int r9 = r6.hashCode();
        if (r9 == (-1959575691)) goto L16;
        if (r9 == (-446820453)) goto L11;
    L20:
        long r0 = 0;
    L21:
        JSONObject r10 = mb0.b.p(new JSONObject(), r5.a.getMId());
        Intrinsics.checkNotNullParameter(r10, "$this$putType");
        Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.TYPE);
        JSONObject r11 = r10.put(LocationMonitorConst.TYPE, r6);
        Intrinsics.checkNotNullParameter(r11, "$this$putAudioId");
        JSONObject r12 = r11.put("audio_id", r0);
        Intrinsics.checkNotNullParameter(r12, "$this$putDownloadUrl");
        Intrinsics.checkNotNullParameter(r7, "url");
        JSONObject r13 = r12.put("download _url", r7);
        w(LinkMonitorData.BusinessMusicDownloadStatusSuccess, r13);
        return;
    L11:
        if (r6.equals("full_track") == false) goto L20;
        AudioInfo r14 = r5.a.getMFullTrack();
        if (r14 == null) goto L20;
        r0 = r14.getMAudioId();
        goto L21
    L16:
        if (r6.equals("accompaniment_track") == false) goto L20;
        AudioInfo r15 = r5.a.getMAccompanimentTrack();
        if (r15 == null) goto L20;
        r0 = r15.getMAudioId();
        goto L21
    }

    public final void j(LinkMonitorData r10, long r11, String r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r13, "logId");
        Intrinsics.checkNotNullParameter(r14, "extra");
        c.a(r14);
        nd0.c.s(nd0.c.a, r10, MultiLinkEventModule.KTV, r11, r13, r14, 96);
        String r12 = "api call success:" + r10.getEventTypeValue() + ", extra:" + r14;
        ALogger.i(bb0.b.b(), "KtvFullLinkMonitor :" + r12 + ", invoke class :" + d.class.getSimpleName());
    }

    public final void f(MusicPanel r7, String r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r9, "downloadUrl");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        if (r7 != null) goto L5;
        return;
    L5:
        int r1 = r8.hashCode();
        if (r1 == (-1959575691)) goto L16;
        if (r1 == (-446820453)) goto L11;
    L20:
        long r2 = 0;
    L21:
        JSONObject r12 = mb0.b.p(new JSONObject(), r7.a.getMId());
        Intrinsics.checkNotNullParameter(r12, "$this$putAudioId");
        JSONObject r13 = r12.put("audio_id", r2);
        Intrinsics.checkNotNullParameter(r13, "$this$putType");
        Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.TYPE);
        JSONObject r14 = r13.put(LocationMonitorConst.TYPE, r8);
        Intrinsics.checkNotNullParameter(r14, "$this$putDownloadUrl");
        Intrinsics.checkNotNullParameter(r9, "url");
        JSONObject r15 = mb0.b.m(mb0.b.n(r14.put("download _url", r9), r11), Integer.valueOf(r10));
        w(LinkMonitorData.BusinessMusicDownloadStatusFail, r15);
        return;
    L11:
        if (r8.equals("full_track") == false) goto L20;
        AudioInfo r3 = r7.a.getMFullTrack();
        if (r3 == null) goto L20;
        r2 = r3.getMAudioId();
        goto L21
    L16:
        if (r8.equals("accompaniment_track") == false) goto L20;
        AudioInfo r4 = r7.a.getMAccompanimentTrack();
        if (r4 == null) goto L20;
        r2 = r4.getMAudioId();
        goto L21
    }

    public static void J(d r3, String r4, String r5, Long r6, Queue r7, int r8) {
        Integer r1 = null;
        if ((r8 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if ((r8 & 8) == 0) goto L11;
        r7 = null;
    L11:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "reason");
        JSONObject r9 = new JSONObject();
        BaseMonitor.add(r9, "reason", r4);
        int r10 = r4.hashCode();
        if (r10 == (-981062358)) goto L25;
        if (r10 == 28675372) goto L20;
        if (r10 != 1333677739) goto L30;
        r4.equals("processor_fail");
    L30:
        w(LinkMonitorData.BusinessSeiFail, r9);
        return;
    L20:
        if (r4.equals("cache_full") == false) goto L30;
        if (r7 == null) goto L23;
        r1 = Integer.valueOf(r7.size());
    L23:
        BaseMonitor.add(r9, "sei_cache_capacity", String.valueOf(r1));
        goto L30
    L25:
        if (r4.equals("parse_fail") == false) goto L30;
        BaseMonitor.add(r9, "sei_content", r5);
        BaseMonitor.add(r9, "cost_time", String.valueOf(r6));
        BaseMonitor.add(r9, "sei_cache_capacity", String.valueOf(((Number) h.v3.getValue(null, h.a[228(0xe4, float:3.2E-43)])).intValue()));
        if (r7 == null) goto L29;
        r1 = Integer.valueOf(r7.size());
    L29:
        BaseMonitor.add(r9, "sei_cache_size", String.valueOf(r1));
        goto L30
    }
}
