package com.bytedance.android.livesdk.ktvimpl.base;

import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdk.utils.z0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public static final Map<Integer, String> t = null;
    public boolean a;
    public boolean b;
    public int c;
    public final CompositeDisposable d;
    public final int e;
    public MusicPanel f;
    public final PublishSubject<fd2.a> g;
    public Long h;
    public Long i;
    public Long j;
    public final KtvContext k;
    public Disposable l;
    public boolean m;
    public boolean n;
    public boolean o;
    public SetBgmFunctionType p;
    public long q;
    public com.bytedance.android.live.pushstream.d r;
    public final oe2.b s;

    public static final class a {
    }

    public static final class b {
    }

    static {
        t = MapsKt.mapOf(new Pair[]{TuplesKt.to(-4, "FF_DECODE_STREAM_ERROR_FORMAT_INVALID"), TuplesKt.to(-5, "FF_DECODE_STREAM_ERROR_OPEN_FILE_FAILED"), TuplesKt.to(-6, "FF_DECODE_STREAM_ERROR_DECODE_ERROR"), TuplesKt.to(-7, "FF_DECODE_STREAM_ERROR_READ_PACKET_ERROR")});
    }

    public static void m() {
        KtvContext.Companion.getClass();
        if (((Boolean) KtvContext.a.g().getHasBgm().getValue()).booleanValue() == false) goto L6;
        KtvContext.a.g().getHasBgm().setValue(Boolean.FALSE);
        return;
    }

    public final void a() {
        Disposable r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public final void d() {
        oe2.b r0 = this.s;
        if (r0 == null) goto L7;
        com.bytedance.android.live.pushstream.d r1 = r0.h(com.bytedance.android.live.ktv.common.util.j.i());
        if (r1 == null) goto L7;
        r1.u();
    L7:
        com.bytedance.android.live.pushstream.d r2 = this.r;
        if (r2 == null) goto L11;
        r2.u();
        return;
    }

    public final Long e() {
        if (this.f != null) goto L5;
        return null;
    L5:
        long r2 = 0;
        if (this.q != 0) goto L9;
        return this.h;
    L9:
        if (this.m == false) goto L12;
        return this.h;
    L12:
        if (MultiLinkSettingHelper.a() == true) goto L14;
    L16:
        Long r0 = this.h;
        if (r0 == null) goto L20;
        r2 = r0.longValue();
    L20:
        return Long.valueOf((r2 + SystemClock.elapsedRealtime()) - this.q);
    L14:
        if ((SystemClock.elapsedRealtime() - this.q) <= (this.e + 20)) goto L16;
        return this.h;
    }

    public final Long f() {
        if (this.f != null) goto L6;
        return null;
    L6:
        return this.i;
    }

    public final Long h() {
        if (this.f != null) goto L6;
        return 0L;
    L6:
        return this.j;
    }

    public final void j() {
        this.d.clear();
    }

    public final void u() {
        boolean r0 = !this.m;
        this.m = r0;
        if (r0 == false) goto L7;
        d();
        if (vm2.h.d() == false) goto L11;
        d();
        return;
    L11:
        return;
    L7:
        d();
        if (vm2.h.d() == false) goto L13;
        d();
        return;
    }

    public final long b() {
        Long r0 = e();
        Long r1 = h();
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        long r2 = r1.longValue();
        Long r3 = Long.valueOf(r0.longValue() - r2);
    L7:
        if (r3 != null) goto L11;
        return 0;
    L11:
        return r3.longValue();
    L6:
        r3 = null;
        goto L7
    }

    public final float c() {
        Long r0 = f();
        if (r0 != null) goto L5;
    L13:
        return 0.0f;
    L5:
        if (r0.longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return b() / r0.longValue();
    L7:
        r1 = false;
        goto L8
    }

    public final void l() {
        m();
        if (this.f == null) goto L5;
        r(null);
    L5:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        if (r0 == null) goto L8;
        r0.B(false);
    L8:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = KSongTuningPanelHelperKt.d();
        if (r1 == null) goto L12;
        r1.f0();
    L12:
        if (vm2.h.l() == false) goto L14;
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
    L14:
        d();
        d();
        a();
    }

    public final void s() {
        ALogger.i(bb0.b.b(), "stop, invoke class :".concat(i.class.getSimpleName()));
        this.m = true;
        d();
        if (vm2.h.d() == false) goto L5;
        d();
    L5:
        r(null);
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
        d();
        d();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        if (r0 == null) goto L8;
        r0.C();
    L8:
        a();
        if (((Boolean) KtvSettingHelper.b1.getValue()).booleanValue() == false) goto L12;
        m();
        return;
    }

    public final void g(double[] r3) {
        Intrinsics.checkNotNullParameter(r3, "scoreInfo");
        d();     // Catch: Exception -> L7
        if (r3.length < 21) goto L12;
        KtvContext.Companion.getClass();     // Catch: Exception -> L7
        KtvContext r0 = KtvContext.a.g();     // Catch: Exception -> L7
        com.bytedance.live.datacontext.m<p> r1 = r0.getRealTimeInfoModel();     // Catch: Exception -> L7
        p r2 = (p) r0.getRealTimeInfoModel().getValue();     // Catch: Exception -> L7
        r2.a(r3);     // Catch: Exception -> L7
        r1.setValue(r2);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e("KtvCoreController", "getScoreInfo error", e);
    }

    public final boolean i(long r6) {
        long r0 = 0;
        if (r6 < 0) goto L15;
        Long r2 = f();
        if (r2 == null) goto L7;
        long r3 = r2.longValue();
    L8:
        Long r4 = h();
        if (r4 == null) goto L12;
        r0 = r4.longValue();
    L12:
        if (r6 > (r3 + r0)) goto L17;
        return true;
    L17:
        return false;
    L7:
        r3 = 0;
        goto L8
    L15:
        return false;
    }

    public final void k(Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r4) {
        if (r4.isEmpty() == false) goto L7;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; map is empty");
        return;
    L7:
        if (this.a == false) goto L10;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; hasSetBGMMusicWithAllResource");
        KtvContext.Companion.getClass();
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(new LinkedHashMap());
        return;
    L10:
        com.bytedance.android.live.ktv.common.model.bean.f r5 = r4.get(KtvUtilsKt.c(this.f));
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.a == DownloadResourceType.OTHER_RESOURCE) goto L16;
        return;
    L16:
        if (r5.b == false) goto L18;
        return;
    L18:
        if (this.f != null) goto L20;
    L29:
        StringBuilder r0 = new StringBuilder("setBGMMusicIfNeed ;; curMusicPanel == ");
        r0.append(this.f);
        r0.append(" ;; curProgress== ");
        r0.append(e());
        r0.append(" ;; isSupportOriginSwitchWithPath == ");
        MusicPanel r2 = this.f;
        if (r2 == null) goto L32;
        Boolean r3 = Boolean.valueOf(com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r2));
    L33:
        r0.append(r3);
        r0.append(" ;; ");
        r0.append(r5);
        ALogger.i("ktv_music_resource_download_opt_tag", r0.toString());
        return;
    L32:
        r3 = null;
        goto L33
    L20:
        if (e() == null) goto L29;
        MusicPanel r1 = this.f;
        Intrinsics.checkNotNull(r1);
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r1) == false) goto L29;
        if (this.b == true) goto L26;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithMainResource ;; " + r5);
        MusicPanel r6 = this.f;
        Intrinsics.checkNotNull(r6);
        q(r6);
    L26:
        MusicPanel r7 = this.f;
        Intrinsics.checkNotNull(r7);
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r7) == false) goto L37;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithAllResource ;; " + r5);
        KtvContext.Companion.getClass();
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(new LinkedHashMap());
        MusicPanel r8 = this.f;
        Intrinsics.checkNotNull(r8);
        Long r9 = e();
        Intrinsics.checkNotNull(r9);
        p(r8, r9.longValue(), this.c);
        return;
    }

    public final void n(long r3) {
        if (i(r3) == true) goto L8;
        ALogger.i("KtvCoreController", "seekLyricPos: progress is invalid, progress: " + r3 + ", durationMs: " + f());
        if (KtvSettingHelper.y() == false) goto L8;
        return;
    L8:
        if (vm2.h.d() == false) goto L10;
        d();
        return;
    L10:
        d();
    }

    public final void q(MusicPanel r4) {
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicWithMainResource ;; song_id == " + r4.a.getMId());
        this.b = true;
        Lazy r2 = com.bytedance.android.live.ktv.common.util.KtvUtilsKt.a;
        Intrinsics.checkNotNullParameter(r4, "$this$isRealOriginFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r4.n) == false) goto L5;
        d();
        boolean r5 = true;
    L12:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = KSongTuningPanelHelperKt.d();
        if (r1 == null) goto L16;
        r1.q(r5, true);
        return;
    L16:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r4, "$this$isRealAccompanimentFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r4.o) == false) goto L8;
        d();
    L11:
        r5 = false;
        goto L12
    L8:
        int r3 = mb0.f.a;
        mb0.f.o(r4);
        ALogger.i("ktv_music_resource_download_opt_tag", "music file path not exists ");
        if (((Boolean) vm2.h.a1.getValue(null, vm2.h.a[103(0x67, float:1.44E-43)])).booleanValue() == false) goto L11;
        t("music_path_not_exist_source");
        goto L11
    }

    public final void r(MusicPanel r3) {
        this.f = r3;
        ec0.a r0 = KSongTuningPanelHelperKt.e();
        if (r0 == null) goto L5;
        r0.m(this.f);
    L5:
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<KtvMusic> r1 = KtvContext.a.g().getCurrentSongOfSelf();
        if (r3 == null) goto L8;
        KtvMusic r4 = r3.a;
    L9:
        r1.setValue(r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void t(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if (this.n == true) goto L33;
        Long r2 = null;
        if (((Boolean) vm2.h.c1.getValue(null, vm2.h.a[105(0x69, float:1.47E-43)])).booleanValue() == true) goto L7;
    L9:
        this.h = null;
        this.n = true;
        ALogger.i(bb0.b.b(), "on stop bgm, invoke class :".concat(i.class.getSimpleName()));
        this.g.onNext(fd2.a.d.a);
        MusicPanel r0 = this.f;
        if (r0 == null) goto L27;
        pd2.d r1 = pd2.d.n;
        String r3 = this.p.name();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "funcType");
        JSONObject r4 = new JSONObject();
        KtvMusic r5 = r0.a;
        if (r5 == null) goto L14;
        r2 = Long.valueOf(r5.getMId());
    L14:
        JSONObject r6 = mb0.b.p(r4, r2.longValue());
        KtvMusic r8 = r0.a;
        String r9 = "";
        if (r8 == null) goto L18;
        String r10 = r8.getMTitle();
        if (r10 == null) goto L18;
    L19:
        JSONObject r11 = mb0.b.q(r6, r10);
        List r12 = r0.a.getMLyricUrlList();
        if (r12 == null) goto L25;
        String r13 = (String) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L25;
        r9 = r13;
    L25:
        JSONObject r14 = mb0.b.o(r11, r9);
        BaseMonitor.add(r14, "function_type", r3);
        pd2.d.w(LinkMonitorData.BusinessPlayerStopCalled, r14);
    L18:
        r10 = "";
    L27:
        if (Intrinsics.areEqual(r7, "live_core_stop_music_callback_source") == false) goto L29;
        ALogger.i("logKtvMainPath", "livecore stop, invoke class :".concat(i.class.getSimpleName()));
        int r15 = mb0.f.a;
        mb0.f.d(this.f);
    L29:
        this.h = 0L;
        a();
        if (((Boolean) KtvSettingHelper.b1.getValue()).booleanValue() == false) goto L34;
        m();
        return;
    L34:
        return;
    L7:
        if (this.o == false) goto L9;
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
        goto L9
    }

    public i(com.bytedance.android.live.pushstream.d r6, oe2.b r7) {
        this.r = r6;
        this.s = r7;
        CompositeDisposable r8 = new CompositeDisposable();
        this.d = r8;
        int r9 = ge2.a.a;
        float r0 = z0.b(true);
        boolean r1 = false;
        if (r0 > 0) goto L5;
    L7:
        if (r1 == false) goto L9;
        int r2 = ((Number) KtvSettingHelper.T0.getValue()).intValue();
    L17:
        this.e = r2;
        ALogger.i("logKtvMainPath", "init ktv core controller, invoke class :".concat(i.class.getSimpleName()));
        d();
        LinkMonitorData r3 = LinkMonitorData.BusinessAudioFilterManagerNull;
        boolean r4 = pd2.d.b;
        pd2.d.w(r3, new JSONObject());
        KtvContext.Companion.getClass();
        k((Map) KtvContext.a.g().getMusicDownloadResourceMap().getValue());
        Disposable r5 = KtvContext.a.g().getMusicDownloadResourceMap().a().subscribe(new k(this));
        if (r5 == null) goto L20;
        RxUtilKt.c(r5, r8);
    L20:
        this.g = PublishSubject.create();
        this.k = KtvContext.a.g();
        this.m = true;
        this.p = SetBgmFunctionType.KSONG;
        return;
    L9:
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L14;
        if (vm2.h.a0() == false) goto L14;
    L15:
        r2 = ((Number) KtvSettingHelper.S0.getValue()).intValue();
    L14:
        if (KtvContext.a.j() == true) goto L15;
        r2 = ((Number) KtvSettingHelper.T0.getValue()).intValue();
        goto L17
    L5:
        if (r0 >= ((Number) vm2.h.c3.getValue(null, vm2.h.a[209(0xd1, float:2.93E-43)])).floatValue()) goto L7;
        r1 = true;
        goto L7
    }

    public final void p(MusicPanel r5, long r6, int r8) {
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicWithAllResource ;; song_id == " + r5.a.getMId() + " startTime " + r6);
        this.a = true;
        long r0 = r5.c();
        int r7 = j.a[r5.h().ordinal()];
        boolean r3 = false;
        if (r7 != 1) goto L5;
        d();
        if (r8 == 0) goto L22;
        if (r8 != 1) goto L22;
        r3 = true;
    L22:
        pd2.d.L(pd2.d.n, r0, "set_bgm");
    L23:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r9 = KSongTuningPanelHelperKt.d();
        if (r9 == null) goto L27;
        r9.q(r3, true);
        return;
    L27:
        return;
    L5:
        if (r7 != 2) goto L7;
        d();
        pd2.d.L(pd2.d.n, r0, "set_bgm");
        r3 = true;
        goto L23
    L7:
        if (r7 != 3) goto L9;
        d();
        pd2.d.L(pd2.d.n, r0, "set_bgm");
        goto L23
    L9:
        if (r7 != 4) goto L23;
        if (((Boolean) vm2.h.a1.getValue(null, vm2.h.a[103(0x67, float:1.44E-43)])).booleanValue() == false) goto L14;
        t("music_path_not_exist_source");
    L15:
        f2.c(s1.B(2131918394), 0);
        pd2.d.v(LinkMonitorData.BusinessSetBgmFailed, MapsKt.mapOf(TuplesKt.to("reason", "both of origin and accompaniment are empty")));
        int r10 = mb0.f.a;
        mb0.f.p(r5, "both of origin and accompaniment are empty");
        ALogger.i("KtvCoreController", "both of origin and accompaniment are empty.");
        pd2.d.L(pd2.d.n, r0, "error");
        goto L23
    L14:
        s();
        goto L15
    }

    public final void o(MusicPanel r26, SetBgmFunctionType r27, int r28, long r29, Long r31, boolean r32) {
        Intrinsics.checkNotNullParameter(r26, "panel");
        Intrinsics.checkNotNullParameter(r27, "functionType");
        if (r29 != 0) goto L5;
        KtvMusic.a r6 = KtvMusic.Companion;
        KtvMusic r7 = r26.a;
        r6.getClass();
        long r8 = KtvMusic.a.c(r7);
    L6:
        if (r31 != null) goto L8;
        KtvMusic.a r9 = KtvMusic.Companion;
        KtvMusic r10 = r26.a;
        r9.getClass();
        long r11 = KtvMusic.a.a(r10);
    L9:
        Pair r12 = new Pair(Long.valueOf(r8), Long.valueOf(r11));
        long r13 = ((Number) r12.component1()).longValue();
        long r14 = ((Number) r12.component2()).longValue();
        StringBuilder r15 = new StringBuilder("setBGMMusic ;; track_name == ");
        r15.append(r26.h().name());
        r15.append(" kSongTuningCore == null :");
        if (KSongTuningPanelHelperKt.d() != null) goto L12;
        boolean r16 = true;
    L13:
        r15.append(r16);
        String r17 = r15.toString();
        ALogger.i(bb0.b.b(), "KtvCoreController :" + r17 + ", invoke class :" + i.class.getSimpleName());
        d();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getEchoStateCheckEvent().post(new Object());
        KtvContext.a.g().getHasBgm().setValue(Boolean.TRUE);
        pd2.d r18 = pd2.d.n;
        String r19 = r27.name();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r26, "musicPanel");
        Intrinsics.checkNotNullParameter(r19, "funcType");
        JSONObject r4 = new JSONObject();
        KtvMusic r5 = r26.a;
        String r110 = null;
        if (r5 == null) goto L16;
        Long r20 = Long.valueOf(r5.getMId());
    L17:
        JSONObject r21 = mb0.b.p(r4, r20.longValue());
        KtvMusic r22 = r26.a;
        String r111 = "";
        if (r22 == null) goto L21;
        String r23 = r22.getMTitle();
        if (r23 == null) goto L21;
    L22:
        JSONObject r24 = mb0.b.q(r21, r23);
        List r25 = r26.a.getMLyricUrlList();
        if (r25 == null) goto L26;
        String r30 = (String) CollectionsKt.firstOrNull(r25);
        if (r30 == null) goto L26;
    L27:
        JSONObject r33 = mb0.b.o(r24, r30);
        BaseMonitor.add(r33, "full_track_local_path", r26.n);
        AudioInfo r34 = r26.a.getMFullTrack();
        if (r34 == null) goto L31;
        String r35 = r34.getMUrl();
        if (r35 == null) goto L31;
    L32:
        BaseMonitor.add(r33, "full_track_url", r35);
        BaseMonitor.add(r33, "accompaniment_track_local_path", r26.o);
        AudioInfo r36 = r26.a.getMAccompanimentTrack();
        if (r36 == null) goto L38;
        String r37 = r36.getMUrl();
        if (r37 == null) goto L38;
        r111 = r37;
    L38:
        BaseMonitor.add(r33, "accompaniment_track_url", r111);
        BaseMonitor.add(r33, "lyrics_local_path", r26.l);
        BaseMonitor.add(r33, "midi_local_path", r26.q);
        BaseMonitor.add(r33, "midi_url", r26.a.getMidiUrl());
        BaseMonitor.add(r33, "function_type", r19);
        pd2.d.w(LinkMonitorData.BusinessPlayMusicSetBgmMusic, r33);
        int r38 = mb0.f.a;
        String r39 = r27.name();
        d();
        Intrinsics.checkNotNullParameter(r26, "musicPanel");
        Intrinsics.checkNotNullParameter(r39, "funcType");
        JSONObject r112 = new JSONObject();
        mb0.f.b(r26, r112);
        r112.put("track", r26.h());
        r112.put("track_mode", r28);
        r112.put("function_type", r39);
        r112.put("AudioFilterIsNull", true);
        int r40 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "setBgmMusic", 0, null, r112, 88);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r41 = KSongTuningPanelHelperKt.d();
        if (r41 == null) goto L41;
        r41.s();
    L41:
        this.q = 0;
        if (r32 == false) goto L44;
        d();
    L45:
        r(r26);
        this.c = r28;
        this.n = false;
        this.o = false;
        this.p = r27;
        this.j = Long.valueOf(r13);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r2 = KSongTuningPanelHelperKt.d();
        if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L48;
        r2 = null;
    L48:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r3 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r2;
        if (r3 == null) goto L51;
        r3.l(System.currentTimeMillis());
    L51:
        this.h = Long.valueOf(r13);
        String r42 = "setBGMMusic,track:" + r26.h();
        JSONObject r43 = new JSONObject();
        r43.put("extra", r42);
        r43.put("fullTrackLocalPath", r26.n);
        r43.put("accompanimentTrackLocalPath", r26.o);
        r43.put("lrcLocalPath", r26.l);
        r43.put("midiLocalPath", r26.q);
        r43.put(BaseCoreViewModel.CORE_TAG_STATE, r26.b);
        r43.put("mId", r26.a.getMId());
        r43.put("mTitle", r26.a.getMTitle());
        OrderInfo r44 = r26.a.getOrderInfo();
        if (r44 == null) goto L56;
        Intrinsics.checkNotNullParameter(r44, "$this$topUserFlex");
        b8 r45 = r44.getTopUser();
        if (r45 == null) goto L56;
        r110 = r45.getNickNameFlex();
    L56:
        r43.put("to_nickName", r110);
        r43.put("source", r26.f);
        ALogger.i(bb0.b.b(), r43.toString());
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r46 = KSongTuningPanelHelperKt.d();
        if (r46 == null) goto L59;
        r46.f0();
    L59:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r47 = KSongTuningPanelHelperKt.d();
        float r48 = 0.0f;
        if (r47 == null) goto L66;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r49 = KSongTuningPanelHelperKt.d();
        if (r49 == null) goto L64;
        float r50 = r49.e();
    L65:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.b(r47, r50, 4);
        goto L66
    L64:
        r50 = 0.0f;
    L66:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r51 = KSongTuningPanelHelperKt.d();
        if (r51 == null) goto L73;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r52 = KSongTuningPanelHelperKt.d();
        if (r52 == null) goto L71;
        r48 = r52.A();
    L71:
        r51.G(r48);
    L73:
        if (vm2.h.d() == false) goto L75;
        d();
    L78:
        StringBuilder r53 = new StringBuilder("setBGMMusic trackMode null ;; ");
        d();
        r53.append(this.r);
        String r54 = r53.toString();
        ALogger.i(bb0.b.b(), "KtvCoreController :" + r54 + ", invoke class :" + i.class.getSimpleName());
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
        this.a = false;
        this.b = false;
        q(r26);
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r26) == false) goto L81;
        p(r26, r13, r28);
    L81:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r55 = KSongTuningPanelHelperKt.d();
        if (r55 == null) goto L84;
        r55.E();
    L84:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r56 = KSongTuningPanelHelperKt.d();
        if (r56 == null) goto L88;
        r56.c();
    L88:
        if (this.m == false) goto L90;
        u();
    L90:
        long r57 = (long) 1000.0f;
        Long r58 = Long.valueOf(r14 * r57);
        long r59 = r26.a.getMDuration() * r57;
        d();
        if (r58 == null) goto L93;
        r59 = r58.longValue();
    L93:
        this.i = Long.valueOf(r59);
        return;
    L75:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L78;
        d();
        goto L78
    L44:
        d();
    L31:
        r35 = "";
    L26:
        r30 = "";
    L21:
        r23 = "";
        goto L22
    L16:
        r20 = null;
        goto L17
    L12:
        r16 = false;
        goto L13
    L8:
        r11 = r31.longValue();
        goto L9
    L5:
        r8 = r29;
        goto L6
    }
}
