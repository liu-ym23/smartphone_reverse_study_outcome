package xe2;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.model.ChorusGuestStatus;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(MusicPanel r7) {
        JSONObject r5 = new JSONObject();
        if (r7 == null) goto L7;
        KtvMusic r0 = r7.a;
        if (r0 == null) goto L7;
        Object r1 = Long.valueOf(r0.getMId());
    L8:
        r5.put("music_id", r1);
        if (r7 == null) goto L14;
        KtvMusic r2 = r7.a;
        if (r2 == null) goto L14;
        String r3 = r2.getMTitle();
        if (r3 == null) goto L14;
    L15:
        r5.put("music_name", r3);
        if (r7 == null) goto L20;
        InteractiveSongUserInfo r8 = r7.f();
        if (r8 == null) goto L20;
        Long r9 = Long.valueOf(r8.getId());
    L21:
        r5.put("order_user_id", String.valueOf(r9));
        f(r5);
        int r10 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "MusicResume", 0, null, r5, 88);
        return;
    L20:
        r9 = null;
    L14:
        r3 = "";
    L7:
        r1 = BDLocationException.ERROR_TIMEOUT;
        goto L8
    }

    public static void f(JSONObject r5) {
        ILinkPlayerInfoBridge r0 = k.n(IInteractService.class).getGuestInfo(k.n(IMiddlewareUserService.class).user().n(), "");
        if (r0 == null) goto L5;
        long r1 = r0.getChorusGuestStatus();
    L7:
        if (r1 <= ChorusGuestStatus.STATUS_UNKNOWN.getValue()) goto L9;
        boolean r2 = true;
    L10:
        r5.put("isLinkGuest", r2);
        RealTimeChorusBusinessContext.a r3 = RealTimeChorusBusinessContext.Companion;
        r5.put("curUserType", r3.d());
        r5.put("cur_chorus_role", r3.b());
        r5.put("chorus_mode", r3.a());
        r5.put("is_lead", r3.e());
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = ChorusGuestStatus.STATUS_UNKNOWN.getValue();
        goto L7
    }

    public static void b(MusicPanel r7, boolean r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        JSONObject r5 = new JSONObject();
        r5.put("music_name", r7.a.getTitle());
        r5.put("music_id", r7.a.getMId());
        InteractiveSongUserInfo r9 = r7.f();
        if (r9 == null) goto L7;
        Long r10 = Long.valueOf(r9.getId());
    L8:
        r5.put("order_user_id", String.valueOf(r10));
        r5.put(LocationMonitorConst.IS_SUCCESS, r8);
        int r11 = rd0.a.a;
        MultiTraceData.TraceBusiness r0 = MultiTraceData.TraceBusiness.RTChorus;
        MultiTraceData.TraceEvent r1 = MultiTraceData.TraceEvent.JoinChorus;
        if (r8 == false) goto L11;
        int r3 = 0;
    L12:
        if (r8 == false) goto L14;
        String r12 = "download success";
    L15:
        rd0.a.b(r0, r1, "MusicDownloadSuccess", r3, r12, r5, 64);
        return;
    L14:
        r12 = "download fail";
        goto L15
    L11:
        r3 = -1;
        goto L12
    L7:
        r10 = null;
        goto L8
    }

    public static void h(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "streamData");
        Intrinsics.checkNotNullParameter(r10, "source");
        JSONObject r7 = new JSONObject();
        r7.put("streamData", r9);
        r7.put("source", r10);
        f(r7);
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "switchStream", 0, null, r7, 88);
    }

    public static void i(long r8, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "source");
        JSONObject r6 = new JSONObject();
        r6.put("roomId", r8);
        r6.put("mixType", r10);
        r6.put("source", r11);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "SwitchStreamType", 0, null, r6, 88);
    }

    public static void d(String r9, String r10, String r11, Long r12) {
        Intrinsics.checkNotNullParameter(r10, "interactId");
        Intrinsics.checkNotNullParameter(r11, BaseCoreViewModel.CORE_TAG_STATE);
        JSONObject r7 = new JSONObject();
        if (r9 == null) goto L5;
        r7.put("rtcRoomId", r9);
    L5:
        r7.put("interactId", r10);
        r7.put(BaseCoreViewModel.CORE_TAG_STATE, r11);
        if (r12 == null) goto L8;
        r12.longValue();
        r7.put("chorusId", r12.longValue());
    L8:
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCaptureStream, "MediaCapture", 0, null, r7, 88);
    }

    public static void e(boolean r8, int r9, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        JSONObject r6 = new JSONObject();
        r6.put("open", r8);
        if (r11 == null) goto L5;
        nd0.c.a.getClass();
        nd0.c.t(r11, r6);
    L5:
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "OpenChorusSwitch", r9, r10, r6, 64);
    }

    public static void g(String r9, int r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "chorusId");
        Intrinsics.checkNotNullParameter(r11, "leaderSingerId");
        Intrinsics.checkNotNullParameter(r12, "leaderSingerInteractId");
        JSONObject r7 = new JSONObject();
        r7.put("chorusId", r9);
        r7.put("cur_chorus_role", String.valueOf(r10));
        r7.put("lead_singer_uid", r11);
        r7.put("lead_singer_interactId", r12);
        if (r13 == false) goto L5;
        String r14 = "1";
    L6:
        r7.put("is_engine_on", r14);
        f(r7);
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusInfoUpdate, "SetBaseUid", 0, null, r7, 88);
        return;
    L5:
        r14 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static void a(String r2, int r3, int r4, long r5, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r2, "chorusId");
        JSONObject r1 = new JSONObject();
        r1.put("chorusId", r2);
        r1.put("cur_chorus_role", String.valueOf(r3));
        r1.put("audio_device_loop_delay", String.valueOf(r4));
        r1.put("local_ntp", String.valueOf(0));
        r1.put("local_progress", String.valueOf(r5));
        r1.put("progress_diff", String.valueOf(r7));
        r1.put("seek_diff", String.valueOf(r9));
        int r6 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "SeekMusic", 0, null, r1, 88);
    }
}
