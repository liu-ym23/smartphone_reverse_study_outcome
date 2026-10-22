package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusLeaveType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusUserType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.interfaces.ChorusConcertApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements gd2.c {
    public ConcertStageComponent a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.a$a, reason: collision with other inner class name */
    public static final class C0014a {
    }

    static {
    }

    public a() {
    }

    public final boolean b() {
        gd2.f r0 = ConcertStageDataContext.Companion.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    public final boolean d() {
        gd2.f r0 = ConcertStageDataContext.Companion.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    public final void h() {
        ALogger.i("ChorusConcertService", "unloadChorusConcertStage, concertStageComponent: " + this.a);
        final ConcertStageComponent r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        de2.b.b();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("function_type2", "chorus");
        de2.b.a("livesdk_connection_over", r1);
    L9:
        x r2 = r0.h;
        if (r2 == null) goto L12;
        JoinChorusConcertStatus r3 = r2.c;
    L14:
        if (r3 != JoinChorusConcertStatus.JOINED) goto L33;
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L20;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L20;
        long r6 = r5.getId();
    L21:
        long r8 = r6;
        x r7 = r0.h;
        if (r7 == null) goto L25;
        String r9 = r7.a;
        if (r9 == null) goto L25;
    L26:
        String r10 = r9;
        if (r7 == null) goto L29;
        int r11 = r7.b;
    L30:
        int r12 = r11;
        w.b("ConcertStageComponent", "before leaveChorus, roomId = " + r8 + ", chorusId = " + r10 + ", userType = " + r12);
        Disposable r13 = ((ChorusConcertApi) com.bytedance.android.live.network.c.b().e(ChorusConcertApi.class)).leaveChorus(r8, r10, ChorusLeaveType.ChorusLeaveType_Mid.getType(), r12).compose(RxUtil.rxSchedulerHelper()).subscribe(g.a, h.a);
        if (r13 == null) goto L33;
        RxUtilKt.c(r13, r0.k);
        goto L33
    L29:
        r11 = ChorusUserType.ChorusUserType_Unknow.getType();
    L25:
        r9 = BDLocationException.ERROR_TIMEOUT;
    L20:
        r6 = 0;
    L33:
        js1.a r14 = r0.n;
        if (r14 == null) goto L39;
        vb6.g r15 = r14.a;
        if (r15 == null) goto L39;
        r15.i1("widget destroy", false);
    L39:
        if (r0.a == true) goto L119;
    L57:
        c r16 = r0.p;
        if (r16 == null) goto L60;
        r16.g(false, false);
    L60:
        js1.a r17 = r0.n;
        if (r17 == null) goto L65;
        vb6.g r18 = r17.a;
        if (r18 == null) goto L65;
        r18.a1(r0.z);
    L65:
        js1.a r19 = r0.n;
        if (r19 == null) goto L70;
        js1.c r20 = r19.c;
        if (r20 == null) goto L70;
        l r21 = r0.y;
        Intrinsics.checkNotNullParameter(r21, "listener");
        r20.b.remove(r21);
    L70:
        js1.a r22 = r0.n;
        if (r22 == null) goto L75;
        vb6.g r23 = r22.a;
        if (r23 == null) goto L75;
        r23.f1(r0.A);
    L75:
        com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a r24 = r0.m;
        if (r24 == null) goto L81;
        Iterator r25 = ((LinkedHashMap) r24.a).entrySet().iterator();
    L79:
        if (r25.hasNext() == false) goto L81;
        ((ce2.a) ((Map.Entry) r25.next()).getValue()).release();
    L81:
        c r26 = r0.p;
        if (r26 == null) goto L96;
        ConcertStageDataContext r27 = ConcertStageDataContext.Companion.getContext();
        if (r27 == null) goto L92;
        com.bytedance.live.datacontext.j<js1.a> r28 = r27.getLinkComponent();
        if (r28 == null) goto L92;
        js1.a r29 = (js1.a) r28.getValue();
        if (r29 == null) goto L92;
        vb6.g r30 = r29.a;
        if (r30 == null) goto L92;
        r30.a1(r26.e);
    L92:
        com.bytedance.android.live.pushstream.d r31 = c.k();
        if (r31 == null) goto L95;
        r31.h1(r26.f);
    L95:
        r26.a.clear();
        w.b("ConcertEarMonitor", "release");
    L96:
        DataCenter r32 = r0.u;
        if (r32 == null) goto L99;
        r32.removeObserver(r0);
    L99:
        m r33 = r0.l;
        if (r33 == null) goto L108;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r34 = r33.a;
        if (r34 == null) goto L104;
        r34.J();
    L104:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r35 = r33.a;
        if (r35 == null) goto L107;
        r35.release();
    L107:
        r33.a = null;
    L108:
        r0.g.clear();
        ViewGroup r36 = r0.C;
        if (r36 == null) goto L111;
        Integer r37 = Integer.valueOf(r36.indexOfChild(r0.v));
    L112:
        int r38 = r37.intValue();
        if (r38 == (-1)) goto L117;
        ViewGroup r39 = r0.C;
        if (r39 == null) goto L117;
        r39.removeViewAt(r38);
    L117:
        UtilityKotlinExtentionsKt.s(0, false, true, new ConcertStageComponent$onDestroy$1(r0), 3);
        w.b("ConcertStageComponent", "onDestroy ;; index == " + r38);
        this.a = null;
        return;
    L111:
        r37 = null;
        goto L112
    L119:
        Context r40 = r0.getContext();     // Catch: Exception -> L54
        if (r40 == null) goto L56;
        ConcertStageComponent$usbReceiver$1 r41 = r0.x;     // Catch: Exception -> L54
        ReceiverRegisterLancet.loge(r41, false);     // Catch: Exception -> L54
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L120;
        r40.unregisterReceiver(r41);     // Catch: Exception -> L54
        goto L56
    L120:
    L48:
        e = move-exception;
        if (r41 == null) goto L51;
        Npth.addTag("unregisterReceiver", r41.toString());     // Catch: Exception -> L54
    L51:
        e.printStackTrace();     // Catch: Exception -> L54
        goto L56
    L45:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r41, r40) == false) goto L56;
        r40.unregisterReceiver(r41);     // Catch: Exception -> L48
    L56:
        r0.a = false;
    L54:
        e = move-exception;
        w.b("ConcertStageComponent", "unregisterReceiver " + e.getMessage());
        goto L56
    L12:
        r3 = null;
        goto L14
    }

    public final void a(VSChorusConcertWidget.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        gd2.f r0 = ConcertStageDataContext.Companion.a();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void c(VSChorusConcertWidget.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        gd2.f r0 = ConcertStageDataContext.Companion.a();
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void e(boolean r2) {
        if (r2 == false) goto L14;
        ConcertStageDataContext r3 = ConcertStageDataContext.Companion.getContext();
        if (r3 == null) goto L26;
        com.bytedance.live.datacontext.j<js1.a> r4 = r3.getLinkComponent();
        if (r4 == null) goto L27;
        js1.a r5 = (js1.a) r4.getValue();
        if (r5 == null) goto L28;
        ei6.a r6 = r5.a();
        if (r6 == null) goto L29;
        ri6.b r7 = r6.r();
        if (r7 == null) goto L30;
        r7.d(0);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L14:
        ConcertStageDataContext r8 = ConcertStageDataContext.Companion.getContext();
        if (r8 == null) goto L32;
        com.bytedance.live.datacontext.j<js1.a> r9 = r8.getLinkComponent();
        if (r9 == null) goto L33;
        js1.a r10 = (js1.a) r9.getValue();
        if (r10 == null) goto L34;
        ei6.a r11 = r10.a();
        if (r11 == null) goto L35;
        ri6.b r12 = r11.r();
        if (r12 == null) goto L36;
        r12.d(100);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void f(int r1, int r2) {
        gd2.f r3 = ConcertStageDataContext.Companion.a();
        if (r3 == null) goto L6;
        r3.f();
        return;
    }

    public final void g(Context r23, ViewGroup r24, DataCenter r25) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "parent");
        ALogger.i("ChorusConcertService", "loadChorusConcertStage, concertStageComponent: " + this.a);
        if (this.a == null) goto L5;
        return;
    L5:
        ConcertStageComponent r4 = new ConcertStageComponent(r23, r24);
        this.a = r4;
        r4.u = r25;
        w.b("ConcertStageComponent", "onCreate");
        Context r1 = r4.B;
        ConcertStageComponent$usbReceiver$1 r5 = r4.x;
        boolean r6 = false;
        if (r1 != null) goto L140;
        w.b("ConcertStageComponent", "registerUsbDeviceReceiver: context is null");
    L11:
        boolean r2 = false;
    L12:
        r4.a = r2;
        RxUtilKt.c(jc1.k.n(IBaseBrowserService.class).registerExternalMethodFactory(new k()).subscribe(), r4.k);
        js1.a r3 = new js1.a(r4.B);
        r4.n = r3;
        js1.c r7 = r3.c;
        if (r7 == null) goto L15;
        l r8 = r4.y;
        Intrinsics.checkNotNullParameter(r8, "listener");
        r7.b.add(r8);
    L15:
        js1.a r9 = r4.n;
        if (r9 == null) goto L20;
        vb6.g r10 = r9.a;
        if (r10 == null) goto L20;
        r10.X0(r4.z, true);
    L20:
        js1.a r11 = r4.n;
        if (r11 == null) goto L25;
        vb6.g r12 = r11.a;
        if (r12 == null) goto L25;
        r12.e1(r4.A, true);
    L25:
        Pair r13 = com.bytedance.live.datacontext.d.a(ConcertStageComponent$initConcertStageDataContext$1.INSTANCE);
        ConcertStageDataContext r14 = (ConcertStageDataContext) r13.component1();
        Disposable r15 = (Disposable) r13.component2();
        r14.getService().d(r4);
        r14.getLinkComponent().d(r4.n);
        com.bytedance.live.datacontext.b.a(r14, ConcertStageDataContext.KEY_CONCERT_STAGE_DATA);
        r4.k.add(r15);
        if (r25 == null) goto L28;
        r4.m = new com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a(r4.B, r25);
        r4.l = new m(r25);
    L28:
        ViewGroup r16 = r4.v;
        if (r16 == null) goto L31;
        FrameLayout r17 = (FrameLayout) r16.findViewById(2131367630);
    L32:
        r4.i = r17;
        Context r18 = r4.B;
        if (r18 == null) goto L89;
        if (r17 == null) goto L89;
        m r19 = r4.l;
        if (r19 == null) goto L89;
        com.bytedance.live.datacontext.m r20 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r20 == null) goto L45;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L45;
        String r22 = r21.getIdStr();
        if (r22 == null) goto L45;
        String r110 = r22;
    L46:
        com.bytedance.live.datacontext.m r26 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r26 == null) goto L54;
        IRoom r27 = (IRoom) r26.getValue();
        if (r27 == null) goto L54;
        String r28 = r27.getOwnerUserIdString();
        if (r28 == null) goto L54;
        String r111 = r28;
    L55:
        jd2.b r29 = new jd2.b(r18, r17, r110, r111, gh0.a.c());
        Intrinsics.checkNotNullParameter(r29, "params");
        String r30 = KtvSettingHelper.e().c().b();
        u6 r112 = new u6(KtvSettingHelper.e().c().a());
        r112.b("url", r30);
        u6 r31 = r112.d("url");
        r31.b("business_type", "vsconcert");
        r31.b("business_group", "vsconcert");
        r31.b("anchor_id", r29.d);
        r31.b("room_id", r29.c);
        r31.b("user_id", r29.e);
        r31.b("is_feed", BDLocationException.ERROR_TIMEOUT);
        int r32 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r33 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(r29.getContext(), r112.c(), new v(), 0, null, 56);
        r19.a = r33;
        r33.registerMethod("registerMessage", new q(r19));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r34 = r19.a;
        if (r34 == null) goto L58;
        r34.registerMethod("registerMessageLatch", new p(r19));
    L58:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r35 = r19.a;
        if (r35 == null) goto L61;
        r35.registerMethod("registerWrds", new r(r19));
    L61:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r36 = r19.a;
        if (r36 == null) goto L64;
        r36.registerMethod("live.getConcertStatus", n.a);
    L64:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r37 = r19.a;
        if (r37 == null) goto L67;
        r37.registerMethod("live.updateConcertStatus", u.a);
    L67:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r38 = r19.a;
        if (r38 == null) goto L70;
        r38.registerMethod("reportAggregateALog", s.a);
    L70:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r39 = r19.a;
        if (r39 == null) goto L73;
        r39.registerMethod("reportLinkmicStatus", t.a);
    L73:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r40 = r19.a;
        if (r40 == null) goto L76;
        r40.registerMethod("getLiveNtpTime", new o(r19));
    L76:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r41 = r19.a;
        if (r41 == null) goto L79;
        ih0.c.a.a(r41, null, null, 7);
    L79:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r42 = r19.a;
        if (r42 == null) goto L86;
        View r43 = r42.h;
        if (r43 == null) goto L86;
        r43.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r44 = r29.b;
        if (r44 == null) goto L86;
        r44.addView(r43);
    L86:
        LinkedHashMap r45 = new LinkedHashMap();
        r45.put("room_id", r29.c);
        r45.put("anchor_id", r29.d);
        r45.put("user_id", r29.e);
        r45.put("is_feed", BDLocationException.ERROR_TIMEOUT);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r46 = r19.a;
        if (r46 == null) goto L89;
        r46.updateGlobalProps(r45);
    L54:
        r111 = "";
    L45:
        r110 = "";
    L89:
        if (r25 == null) goto L91;
        r25.observe(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE, r4);
    L91:
        if (r25 == null) goto L93;
        r25.observe(ChorusJsbDataContext.CMD_START_RTC_ENGINE, r4);
    L93:
        if (r25 == null) goto L95;
        r25.observe("cmd_concert_stage_status", r4);
    L95:
        c r47 = new c();
        w.b("ConcertEarMonitor", "init");
        com.bytedance.android.livesdk.chatroom.o r48 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r48 == null) goto L102;
        com.bytedance.live.datacontext.m r49 = r48.X1();
        if (r49 == null) goto L102;
        Boolean r50 = (Boolean) r49.getValue();
        if (r50 == null) goto L102;
        r6 = r50.booleanValue();
    L102:
        r47.l(r6);
        com.bytedance.android.livesdk.chatroom.o r51 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r51 == null) goto L111;
        com.bytedance.live.datacontext.m r52 = r51.X1();
        if (r52 == null) goto L111;
        Observable r53 = r52.a();
        if (r53 == null) goto L111;
        Disposable r54 = r53.subscribe(new d(r47));
        if (r54 == null) goto L111;
        RxUtilKt.c(r54, r47.a);
    L111:
        com.bytedance.android.livesdk.chatroom.o r55 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r55 == null) goto L120;
        com.bytedance.live.datacontext.m r56 = r55.n2();
        if (r56 == null) goto L120;
        Observable r57 = r56.a();
        if (r57 == null) goto L120;
        Disposable r58 = r57.subscribe(new e(r47));
        if (r58 == null) goto L120;
        RxUtilKt.c(r58, r47.a);
    L120:
        com.bytedance.android.livesdk.chatroom.o r59 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r59 == null) goto L129;
        com.bytedance.live.datacontext.m r60 = r59.N2();
        if (r60 == null) goto L129;
        Observable r61 = r60.a();
        if (r61 == null) goto L129;
        Disposable r62 = r61.subscribe(new f(r47));
        if (r62 == null) goto L129;
        RxUtilKt.c(r62, r47.a);
    L129:
        ConcertStageDataContext r63 = ConcertStageDataContext.Companion.getContext();
        if (r63 == null) goto L138;
        com.bytedance.live.datacontext.j<js1.a> r64 = r63.getLinkComponent();
        if (r64 == null) goto L138;
        js1.a r65 = (js1.a) r64.getValue();
        if (r65 == null) goto L138;
        vb6.g r66 = r65.a;
        if (r66 == null) goto L138;
        r66.X0(r47.e, true);
    L138:
        Unit r67 = Unit.INSTANCE;
        r4.p = r47;
        return;
    L31:
        r17 = null;
        goto L32
    L140:
        IntentFilter r68 = new IntentFilter();     // Catch: Throwable -> L10
        r68.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");     // Catch: Throwable -> L10
        ConcertStageComponent.i(r1, r5, r68);     // Catch: Throwable -> L10
        w.b("ConcertStageComponent", "USB device receiver registered successfully");     // Catch: Throwable -> L10
        r2 = true;
    L10:
        w.b("ConcertStageComponent", "register USB receiver failed");
        goto L11
    }
}
