package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c1 {
    public com.bytedance.android.livesdk.ktvimpl.base.i a;
    public MusicPanel b;
    public final CompositeDisposable c;
    public xe2.c d;

    public static final class a {
    }

    static {
    }

    public final long a() {
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = this.a;
        if (r0 == null) goto L7;
        Long r1 = r0.e();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public final void c() {
        KtvContext.Companion.getClass();
        oe2.b r1 = null;
        if (KtvContext.a.g().getKtvCoreController().getValue() == null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r0 == null) goto L7;
        com.bytedance.android.live.pushstream.d r2 = r0.r;
    L9:
        if ((!Intrinsics.areEqual(r2, b())) == true) goto L10;
    L26:
        StringBuilder r3 = new StringBuilder("initPlayer ");
        r3.append(hashCode());
        r3.append(' ');
        r3.append(ThreadMethodProxy.currentThread().getName());
        r3.append(" : ");
        r3.append(ThreadMethodProxy.currentThread().getId());
        r3.append("   ktvCoreController == ");
        com.bytedance.android.livesdk.ktvimpl.base.i r4 = this.a;
        int r5 = 0;
        if (r4 == null) goto L29;
        int r6 = r4.hashCode();
    L30:
        r3.append(r6);
        r3.append(" ;; ktvCoreController2 == ");
        Object r7 = KtvContext.a.g().getKtvCoreController().getValue();
        if (r7 == null) goto L33;
        r5 = r7.hashCode();
    L33:
        r3.append(r5);
        w.a("RealTimeChorusPlayer", r3.toString());
        this.a = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        return;
    L29:
        r6 = 0;
        goto L30
    L7:
        r2 = null;
    L10:
        KtvContext r8 = KtvContext.a.g();
        if (r8 == null) goto L17;
        com.bytedance.live.datacontext.n<oe2.b> r9 = r8.getKtvRoomProvider();
        if (r9 == null) goto L17;
        oe2.b r10 = (oe2.b) r9.getValue();
        if (r10 == null) goto L17;
        com.bytedance.android.live.pushstream.d r11 = r10.h(com.bytedance.android.live.ktv.common.util.j.i());
    L18:
        if (r11 != null) goto L20;
        return;
    L20:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r12 = KtvContext.a.g().getKtvCoreController();
        com.bytedance.android.live.pushstream.d r13 = b();
        KtvContext r14 = KtvContext.a.g();
        if (r14 == null) goto L25;
        com.bytedance.live.datacontext.n<oe2.b> r15 = r14.getKtvRoomProvider();
        if (r15 == null) goto L25;
        r1 = (oe2.b) r15.getValue();
    L25:
        r12.setValue(new com.bytedance.android.livesdk.ktvimpl.base.i(r13, r1));
    L17:
        r11 = null;
        goto L18
    }

    public final void e() {
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.m == true) goto L19;
        StringBuilder r1 = new StringBuilder();
        r1.append(hashCode());
        r1.append(' ');
        r1.append(ThreadMethodProxy.currentThread().getName());
        r1.append(" : ");
        r1.append(ThreadMethodProxy.currentThread().getId());
        r1.append(" pause ");
        MusicPanel r2 = this.b;
        if (r2 == null) goto L11;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L11;
        String r4 = r3.getTitle();
    L12:
        r1.append(r4);
        w.a("RealTimeChorusPlayer", r1.toString());
        com.bytedance.android.livesdk.ktvimpl.base.i r5 = this.a;
        if (r5 == null) goto L20;
        r5.m = true;
        r5.d();
        if (vm2.h.d() == false) goto L21;
        r5.d();
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final void i() {
        StringBuilder r0 = new StringBuilder();
        r0.append(hashCode());
        r0.append(' ');
        r0.append(ThreadMethodProxy.currentThread().getName());
        r0.append(" : ");
        r0.append(ThreadMethodProxy.currentThread().getId());
        r0.append(" stop ");
        MusicPanel r1 = this.b;
        if (r1 == null) goto L7;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L7;
        String r3 = r2.getTitle();
    L8:
        r0.append(r3);
        r0.append(" ktvCoreController == null : ");
        if (this.a != null) goto L11;
        boolean r4 = true;
    L12:
        r0.append(r4);
        w.a("RealTimeChorusPlayer", r0.toString());
        int r5 = xe2.g.a;
        MusicPanel r6 = this.b;
        JSONObject r9 = new JSONObject();
        if (r6 == null) goto L17;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L17;
        Object r8 = Long.valueOf(r7.getMId());
    L18:
        r9.put("music_id", r8);
        if (r6 == null) goto L24;
        KtvMusic r10 = r6.a;
        if (r10 == null) goto L24;
        String r11 = r10.getMTitle();
        if (r11 == null) goto L24;
    L25:
        r9.put("music_name", r11);
        if (r6 == null) goto L30;
        InteractiveSongUserInfo r12 = r6.f();
        if (r12 == null) goto L30;
        Long r13 = Long.valueOf(r12.getId());
    L31:
        r9.put("order_user_id", String.valueOf(r13));
        xe2.g.f(r9);
        int r14 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "MusicStop", 0, null, r9, 88);
        this.b = null;
        fd2.s r15 = RealTimeChorusBusinessContext.Companion.c();
        if (r15 == null) goto L34;
        r15.qf(false);
    L34:
        KtvContext.Companion.getClass();
        KtvContext.a.g().getHasBgm().setValue(Boolean.FALSE);
        com.bytedance.android.livesdk.ktvimpl.base.i r16 = this.a;
        if (r16 == null) goto L37;
        r16.s();
    L37:
        com.bytedance.android.livesdk.ktvimpl.base.i r17 = this.a;
        if (r17 == null) goto L40;
        r17.l();
    L40:
        com.bytedance.android.livesdk.ktvimpl.base.i r18 = this.a;
        if (r18 == null) goto L43;
        r18.j();
    L43:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r19 = KtvContext.a.g().getKtvCoreController();
        if (r19 == null) goto L46;
        r19.setValue(null);
    L46:
        this.a = null;
        return;
    L30:
        r13 = null;
    L24:
        r11 = "";
    L17:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L18
    L11:
        r4 = false;
    L7:
        r3 = null;
        goto L8
    }

    public c1() {
        this.c = new CompositeDisposable();
    }

    public static com.bytedance.android.live.pushstream.d b() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j r1 = r0.getLiveStream();
        if (r1 == null) goto L12;
        return (com.bytedance.android.live.pushstream.d) r1.getValue();
    L12:
        return null;
    L9:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r2 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r2 == null) goto L12;
        return r2.guestLiveStream();
    }

    public final boolean d(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        long r0 = r5.a.getMId();
        MusicPanel r6 = this.b;
        if (r6 == null) goto L9;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L9;
        if (r0 != r7.getMId()) goto L9;
        return true;
    L9:
        return false;
    }

    public final void g(String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.m != true) goto L18;
        StringBuilder r1 = new StringBuilder();
        r1.append(r4);
        r1.append(' ');
        r1.append(hashCode());
        r1.append(' ');
        r1.append(ThreadMethodProxy.currentThread().getName());
        r1.append(" : ");
        r1.append(ThreadMethodProxy.currentThread().getId());
        r1.append(" resume ");
        MusicPanel r2 = this.b;
        if (r2 == null) goto L11;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L11;
        String r5 = r3.getTitle();
    L12:
        r1.append(r5);
        r1.append(' ');
        w.a("RealTimeChorusPlayer", r1.toString());
        com.bytedance.android.livesdk.ktvimpl.base.i r6 = this.a;
        if (r6 == null) goto L15;
        r6.u();
    L15:
        int r7 = xe2.g.a;
        xe2.g.c(this.b);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public final void h(long r5) {
        if (r5 >= 0) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(hashCode());
        r0.append(' ');
        r0.append(ThreadMethodProxy.currentThread().getName());
        r0.append(" : ");
        r0.append(ThreadMethodProxy.currentThread().getId());
        r0.append(' ');
        MusicPanel r1 = this.b;
        if (r1 == null) goto L10;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L10;
        String r3 = r2.getTitle();
    L11:
        r0.append(r3);
        r0.append("   seek progress ");
        r0.append(r5);
        w.a("RealTimeChorusPlayer", r0.toString());
        com.bytedance.android.livesdk.ktvimpl.base.i r4 = this.a;
        if (r4 != null) goto L14;
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.i r6 = this.a;
        if (r6 == null) goto L23;
        r6.n(r5);
        return;
    L23:
        return;
    L14:
        if (r4.i(r5) == true) goto L18;
        ALogger.i("KtvCoreController", "seekProgress: progress is invalid, progress: " + r5 + ", duration: " + r4.f());
        if (KtvSettingHelper.y() == true) goto L19;
    L18:
        r4.d();
    L10:
        r3 = null;
        goto L11
    }

    public final void f(MusicPanel r14, int r15, long r16, Long r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r14, "panel");
        StringBuilder r1 = new StringBuilder("prepareBGM# playingMusic:");
        MusicPanel r2 = this.b;
        Long r10 = null;
        if (r2 == null) goto L7;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L7;
        String r4 = r3.getTitle();
    L8:
        r1.append(r4);
        r1.append('_');
        MusicPanel r5 = this.b;
        if (r5 == null) goto L13;
        KtvMusic r6 = r5.a;
        if (r6 == null) goto L13;
        Long r7 = Long.valueOf(r6.getMId());
    L14:
        r1.append(r7);
        r1.append(", role:");
        RealTimeChorusBusinessContext.a r8 = RealTimeChorusBusinessContext.Companion;
        r1.append(r8.b());
        r1.append(", coreController is null:");
        boolean r9 = false;
        if (this.a != null) goto L17;
        boolean r11 = true;
    L18:
        r1.append(r11);
        r1.append(", liveStream is null:");
        if (b() != null) goto L21;
        boolean r12 = true;
    L22:
        r1.append(r12);
        r1.append(", obtainTuningCore is null:");
        if (KSongTuningPanelHelperKt.d() != null) goto L25;
        boolean r13 = true;
    L26:
        r1.append(r13);
        w.a("RealTimeChorusPlayer", r1.toString());
        if (((Boolean) KtvSettingHelper.q1.getValue()).booleanValue() == false) goto L32;
        if (r8.b() == 2) goto L32;
        return;
    L32:
        if (this.a != null) goto L35;
        c();
    L35:
        if (KSongTuningPanelHelperKt.d() != null) goto L38;
        return;
    L38:
        if (this.b == null) goto L42;
        w.a("RealTimeChorusPlayer", hashCode() + ' ' + ThreadMethodProxy.currentThread().getName() + " : " + ThreadMethodProxy.currentThread().getId() + " prepareBGM " + r14.a.getTitle() + " ;; is playing music ");
        return;
    L42:
        if (b() != null) goto L45;
        return;
    L45:
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L58;
        int r17 = r8.b();
        boolean r110 = KtvUtilsKt.n(r14);
        if (r17 != 2) goto L50;
        if (r110 == false) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == true) goto L54;
        w.a("RealTimeChorusPlayer", hashCode() + ' ' + ThreadMethodProxy.currentThread().getName() + " : " + ThreadMethodProxy.currentThread().getId() + " prepareBGM " + r14.a.getTitle() + " ;; music not ready ;; chorusRole == " + r17 + " ;; isMusicMainResourceDownloaded == " + r110);
        return;
    L54:
        fd2.s r21 = r8.c();
        if (r21 == null) goto L58;
        r21.qf(true);
    L50:
        r20 = false;
    L58:
        if (this.d != null) goto L67;
        fd2.s r22 = r8.c();
        if (r22 == null) goto L62;
        xe2.c r23 = r22.Qe();
    L64:
        if ((r23 instanceof xe2.c) == true) goto L66;
        r23 = null;
    L66:
        this.d = r23;
        goto L67
    L62:
        r23 = null;
    L67:
        xe2.c r24 = this.d;
        if (r24 == null) goto L70;
        r24.c("music_set_time", System.currentTimeMillis());
    L70:
        com.bytedance.android.livesdk.ktvimpl.base.i r25 = this.a;
        if (r25 == null) goto L73;
        com.bytedance.android.live.pushstream.d r26 = r25.r;
    L75:
        if ((!Intrinsics.areEqual(r26, b())) == false) goto L79;
        com.bytedance.android.livesdk.ktvimpl.base.i r27 = this.a;
        if (r27 == null) goto L79;
        r27.r = b();
    L79:
        StringBuilder r28 = new StringBuilder();
        r28.append(hashCode());
        r28.append(' ');
        r28.append(ThreadMethodProxy.currentThread().getName());
        r28.append(" : ");
        r28.append(ThreadMethodProxy.currentThread().getId());
        r28.append(" setBGMMusic ");
        r28.append(r14.a.getTitle());
        r28.append(" ktvCoreController == null : ");
        if (this.a != null) goto L82;
        r9 = true;
    L82:
        r28.append(r9);
        r28.append(" coreController liveStream ");
        com.bytedance.android.livesdk.ktvimpl.base.i r29 = this.a;
        if (r29 == null) goto L85;
        com.bytedance.android.live.pushstream.d r30 = r29.r;
    L86:
        r28.append(r30);
        r28.append(" guestLiveStream ");
        r28.append(b());
        r28.append("  null");
        com.bytedance.android.live.pushstream.d r31 = b();
        if (r31 == null) goto L89;
        r31.u();
    L89:
        w.a("RealTimeChorusPlayer", r28.toString());
        KtvContext.Companion.getClass();
        KtvContext.a.g().getHasBgm().setValue(Boolean.TRUE);
        this.b = r14;
        com.bytedance.android.livesdk.ktvimpl.base.i r32 = this.a;
        if (r32 == null) goto L92;
        r32.o(r14, SetBgmFunctionType.MULTI_KTV, r15, r16, r18, true);
    L92:
        if (r19 == true) goto L94;
        e();
    L95:
        int r33 = xe2.g.a;
        JSONObject r34 = new JSONObject();
        KtvMusic r35 = r14.a;
        if (r35 == null) goto L98;
        Object r36 = Long.valueOf(r35.getMId());
    L99:
        r34.put("music_id", r36);
        KtvMusic r37 = r14.a;
        if (r37 == null) goto L103;
        String r38 = r37.getMTitle();
        if (r38 == null) goto L103;
    L104:
        r34.put("music_name", r38);
        InteractiveSongUserInfo r39 = r14.f();
        if (r39 == null) goto L107;
        r10 = Long.valueOf(r39.getId());
    L107:
        r34.put("order_user_id", String.valueOf(r10));
        xe2.g.f(r34);
        int r40 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "PlayMusic", 0, null, r34, 88);
        return;
    L103:
        r38 = "";
        goto L104
    L98:
        r36 = BDLocationException.ERROR_TIMEOUT;
        goto L99
    L94:
        g("prepareBGM");
        goto L95
    L85:
        r30 = null;
        goto L86
    L73:
        r26 = null;
        goto L75
    L25:
        r13 = false;
        goto L26
    L21:
        r12 = false;
        goto L22
    L17:
        r11 = false;
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }
}
