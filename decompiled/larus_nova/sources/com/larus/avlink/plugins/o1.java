package com.larus.avlink.plugins;

import androidx.core.app.NotificationCompat;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o1 {
    public static final /* synthetic */ int S = 0;
    public long A;
    public boolean B;
    public boolean C;
    public String D;
    public long E;
    public long F;
    public Boolean G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f294008J;
    public long K;
    public long L;
    public long M;
    public boolean N;
    public boolean O;
    public String P;
    public String Q;
    public final p1 R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.audio.call.arch.c f294009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f294011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f294012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f294013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f294014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f294015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f294016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f294017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f294018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f294019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f294020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f294021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f294022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f294023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f294024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f294025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f294026r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q1 f294027s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public r1 f294028t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public s1 f294029u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f294030v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f294031w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f294032x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f294033y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f294034z;

    public static final class a {
    }

    static {
    }

    public final void d() {
        FLogger.f375446a.i("DoraIsolatedCallQueryMonitor", "onTtsPlayFinished");
        if (this.f294022n > 0) goto L5;
    L9:
        this.f294024p = true;
        return;
    L5:
        if (this.f294033y == false) goto L7;
        int r100 = 0;
    L8:
        long r101 = System.currentTimeMillis();
        long r102 = this.f294022n;
        f(r100, r101 - r102, this.f294023o - r102, System.currentTimeMillis() - this.f294016h, 0);
        goto L9
    L7:
        r100 = 3;
        goto L8
    }

    public final void c() {
        this.I = System.currentTimeMillis();
        FLogger.f375446a.i("DoraIsolatedCallQueryMonitor", "onTtsFirstFramePlayed");
        this.f294023o = System.currentTimeMillis();
        s1 r100 = this.f294029u;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f294029u = null;
        e(this, 0, 0, null, "first_frame_play", 6);
    }

    public static long b(long r100) {
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return System.currentTimeMillis() - r100;
    }

    public final void a(Map<String, Object> r100) {
        r100.put("scene", this.f294013e);
        r100.put("call_id", this.f294014f);
        r100.put("room_id", this.f294015g);
        AndroidPlatformKt.a();
        r100.put("is_mock_test", Boolean.FALSE);
        r100.put("task_id", this.f294009a.params().f288752l.f288785a);
        if (Intrinsics.areEqual(this.f294013e, NotificationCompat.CATEGORY_CALL) == false) goto L5;
    L7:
        RealtimeCallParam r101 = this.f294009a.params();
        r100.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r101.f288759s)));
        r100.put("is_quic", Boolean.valueOf(com.larus.im.service.audio.y0.d(r101.f288759s)));
        r100.put("is_mmt", Integer.valueOf(com.larus.im.service.audio.y0.b(r101.f288759s) ? 1 : 0));
        r100.put("client_pre_connect", Integer.valueOf(r101.f288760t));
        r100.put("av_session_type", Integer.valueOf(r101.f288759s.getType()));
        r100.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(this.f294009a.params().f288751k.f288826o, "dora_si") ? 1 : 0));
        r100.put("is_v3", Integer.valueOf(this.C ? 1 : 0));
        boolean r102 = true;
        if (BaseDoraLiteLiveAiPlugin.f293561l == false) goto L10;
    L13:
        r100.put("is_live_ai", Boolean.valueOf(r102));
        return;
    L10:
        if (b98.b.b(1) == true) goto L13;
        r102 = false;
        goto L13
    L5:
        if (Intrinsics.areEqual(this.f294013e, "assistant_scene_mode_click_talk") == true) goto L7;
        r100.put("dora_mode", this.f294013e);
        goto L7
    }

    public o1(com.larus.audio.call.arch.c r100, String r101, boolean r102, u1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "questionId");
        Intrinsics.checkNotNullParameter(r103, "currentConnectValid");
        this.f294009a = r100;
        this.f294010b = r101;
        this.f294011c = r102;
        this.f294012d = r103;
        this.f294013e = r100.params().f288751k.a();
        this.f294014f = r100.params().f288745e;
        this.f294015g = r100.params().f288743d;
        this.f294019k = true;
        this.f294020l = true;
        this.f294021m = true;
        this.f294024p = true;
        this.f294030v = true;
        this.E = -1;
        this.F = -1;
        this.f294008J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        p1 r104 = new p1(this);
        this.R = r104;
        com.larus.audio.call.arch.b.a(r100).e0().i(r104);
    }

    public final void f(final int r110, final long r111, final long r112, final long r113, final int r114) {
        com.larus.utils.l0.b(new l1(this, r110, r112, r111, r113, r114));
    }

    public static void e(final o1 r100, final int r101, int r102, String r103, String r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        final int r104 = -1;
    L7:
        if ((r111 & 4) == 0) goto L9;
        final String r105 = "";
    L11:
        if ((r111 & 8) == 0) goto L13;
        final String r106 = "";
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "agentIntention");
        Intrinsics.checkNotNullParameter(r106, "scene");
        com.larus.utils.l0.b(new m1(r106, r101, r100, r104, r105));
        return;
    L13:
        r106 = r110;
        goto L14
    L9:
        r105 = r103;
        goto L11
    L5:
        r104 = r102;
        goto L7
    }
}
