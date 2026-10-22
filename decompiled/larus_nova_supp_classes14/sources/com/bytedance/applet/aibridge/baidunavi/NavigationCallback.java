package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.applet.aibridge.baidunavi.tts.BaiduNaviTtsPlayer;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.navigation.api.baidu.BaiduNaviServiceDelegate;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class NavigationCallback implements tl9.a {
    public static final Companion k = null;
    public static NavigationCallback l;
    public static String m;
    public static AbsStartBaiduNavigationIDL.b n;
    public static Pair<Integer, Integer> o;
    public BaiduNaviTtsPlayer a;
    public boolean b;
    public boolean c;
    public String d;
    public Integer e;
    public boolean f;
    public Boolean g;
    public volatile String h;
    public volatile String i;
    public int j;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(AbsStartBaiduNavigationIDL.b r9, Continuation<? super Unit> r10) {
            if ((r10 instanceof NavigationCallback$Companion$updateParams$1) == false) goto L7;
            NavigationCallback$Companion$updateParams$1 r0 = (NavigationCallback$Companion$updateParams$1) r10;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            NavigationCallback$Companion$updateParams$1 r6 = r0;
            Object r11 = r6.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r6.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r9 = (AbsStartBaiduNavigationIDL.b) r6.L$0;
            ResultKt.throwOnFailure(r11);
        L27:
            BotModel r12 = (BotModel) r11;
            if (r12 == null) goto L34;
            SpeakerVoice r13 = r12.getVoiceType();
            if (r13 == null) goto L34;
            String r14 = r13.getStyleId();
            if (r14 == null) goto L34;
            NavigationCallback.m = r14;
        L34:
            NavigationCallback.n = r9;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r11);
            String r15 = r9.getBotId();
            String r4 = r9.getStyleId();
            if (r4 != null) goto L17;
        L20:
            boolean r5 = true;
        L21:
            if (r5 == true) goto L23;
            NavigationCallback.m = r9.getStyleId();
            goto L34
        L23:
            if (r15 == null) goto L34;
            IBotRepoService r7 = zh8.a.e;
            r6.L$0 = r9;
            r6.label = 1;
            r11 = IBotRepoService.b.a(r7, r15, false, null, false, r6, 28);
            if (r11 != r2) goto L27;
            return r2;
        L17:
            if (StringsKt.isBlank(r4) == true) goto L20;
            r5 = false;
        L7:
            r0 = new NavigationCallback$Companion$updateParams$1(this, r10);
            goto L8
        }
    }

    static {
        k = new Companion();
    }

    public NavigationCallback() {
    }

    public static dv3.b f(ul9.a r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new dv3.b(r5.c(), r5.b());
    }

    public static dv3.d g(ul9.e r18) {
        String r1 = r18.e();
        dv3.b r2 = f(r18.f());
        dv3.b r3 = f(r18.c());
        int r4 = r18.a();
        int r5 = r18.b();
        List r0 = r18.g();
        if (r0 == null) goto L12;
        List r6 = r0;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        ul9.h r9 = (ul9.h) r7.next();
        if (r9 == null) goto L10;
        String r10 = r9.b();
    L11:
        r8.add(new dv3.f(r10));
        goto L6
    L10:
        r10 = null;
    L13:
        String r11 = r18.h();
        List r12 = r18.g();
        if (r12 == null) goto L48;
        ul9.h r13 = (ul9.h) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L48;
        ul9.d r14 = r13.a();
        if (r14 == null) goto L48;
        List r15 = r14.b();
        if (r15 == null) goto L48;
        List r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r19 = r16.iterator();
    L23:
        if (r19.hasNext() == false) goto L47;
        vl9.d r20 = (vl9.d) r19.next();
        if (r20 == null) goto L27;
        Integer r110 = Integer.valueOf(r20.b());
    L28:
        if (r20 == null) goto L30;
        Integer r111 = Integer.valueOf(r20.a());
    L31:
        if (r20 == null) goto L33;
        ul9.a r112 = r20.c();
    L34:
        dv3.b r113 = f(r112);
        if (r20 == null) goto L39;
        vl9.a r114 = r20.d();
        if (r114 == null) goto L39;
        int r21 = r114.a();
    L40:
        if (r20 == null) goto L45;
        vl9.a r22 = r20.d();
        if (r22 == null) goto L45;
        String r23 = r22.b();
        if (r23 == null) goto L45;
    L46:
        r17.add(new dv3.h(r110, r111, r113, new dv3.g(r21, r23)));
    L45:
        r23 = "";
    L39:
        r21 = 1;
        goto L40
    L33:
        r112 = null;
        goto L34
    L30:
        r111 = null;
        goto L31
    L27:
        r110 = null;
        goto L28
    L47:
        ArrayList r115 = r17;
    L50:
        return new dv3.d(r1, r2, r3, r4, r5, r8, r11, r115, 96);
    L48:
        r115 = null;
        goto L50
    L12:
        r8 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean, int] */
    public final void b(ul9.i r19) {
        Intrinsics.checkNotNullParameter(r19, "update");
        int r2 = r19.a;
        String r3 = r19.b;
        String r6 = r19.c;
        int r10 = r19.d;
        String r4 = r19.e;
        ul9.a r5 = r19.f;
        Integer r15 = r19.g;
        ul9.e r1 = r19.h;
        FLogger r14 = FLogger.a;
        StringBuilder r7 = new StringBuilder("onNaviUpdate,sessionId[");
        r7.append(r6);
        r7.append("];routeId[");
        r7.append(r4);
        r7.append("];status[");
        r7.append(r2);
        r7.append("];hasLocation[");
        if (r5 == null) goto L5;
        boolean r13 = true;
    L6:
        r7.append(r13);
        r7.append("];hasRoute[");
        if (r1 == null) goto L9;
        boolean r16 = true;
    L10:
        r7.append(r16);
        r7.append(']');
        r14.i("navi_callback", r7.toString());
        vl9.d r0 = null;
        if (tl9.b.a() == false) goto L17;
        StringBuilder r8 = new StringBuilder("onNaviUpdate,sessionId[");
        r8.append(r6);
        r8.append("];routeId[");
        r8.append(r4);
        r8.append("];status[");
        r8.append(r2);
        r8.append("];message[");
        r8.append(r3);
        r8.append("];mmLocation[");
        r8.append(r5);
        r8.append("];route[");
        if (r1 == null) goto L15;
        String r9 = r1.i();
    L16:
        r8.append(r9);
        r8.append(']');
        r14.d("navi_callback", r8.toString());
    L22:
        if (r1 == null) goto L29;
        if (r5 == null) goto L26;
        dv3.b r11 = new dv3.b(r5.c(), r5.b());
    L27:
        dv3.c r12 = new dv3.c(1, r6, r11, r15, CollectionsKt.listOf(g(r1)));
        ?? r17 = 0;
        ?? r18 = 1;
    L33:
        a.a(r2, r3, r12);
        if (r2 != r18) goto L36;
    L52:
        NavigationCallback r20 = this;
        int r21 = r20.j + r18;
        r20.j = r21;
        ?? r22 = r20;
        if (r21 < 5) goto L56;
        r20.j = r17;
        r20.e(AppHost.a.getApplication().getString(2131908068), r18);
        r14.i(r12, "status error dut to continuous status: " + r2);
        ?? r23 = r20;
    L55:
        boolean r110 = true;
        NavigationCallback r24 = r23;
    L57:
        if (r110 == false) goto L67;
        e.b("status_error");
        BaiduNaviServiceDelegate.b.a("status_error");
        if (r24.c == true) goto L61;
    L63:
        r24.b = r17;
    L64:
        String r25 = ev3.a.a;
        ev3.a.b(null, RealTimeNavEndReason.STATUS_ERROR.getValue() + '_' + r2, r18);
        r14.i(r12, "auto stop navi due to error status");
        return;
    L61:
        if (r24.b == false) goto L63;
    L67:
        if (r2 != 6) goto L80;
        Integer r26 = r24.e;
        if (r26 == null) goto L74;
        if (r26.intValue() == r2) goto L80;
    L74:
        if (r24.f == false) goto L80;
        if (r24.h == null) goto L78;
        r24.e(AppHost.a.getApplication().getString(2131908078), r17);
        r14.i(r12, "origin not reached tts triggered,mLatestNaviUpdateStatus:" + r24.e);
    L123:
        r24.e = Integer.valueOf(r2);
        if (r1 == null) goto L153;
        List r27 = r1.g();
        if (r27 == null) goto L154;
        ul9.h r28 = (ul9.h) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L155;
        ul9.d r29 = r28.a();
        if (r29 == null) goto L156;
        List r30 = r29.a();
        if (r30 == null) goto L157;
        vl9.c r31 = (vl9.c) CollectionsKt.firstOrNull(r30);
        if (r31 == null) goto L158;
        List r32 = r31.b();
        if (r32 == null) goto L159;
        vl9.b r33 = (vl9.b) CollectionsKt.firstOrNull(r32);
        if (r33 == null) goto L160;
        String r34 = r33.d();
        if (r34 != null) goto L143;
        return;
    L143:
        if (Intrinsics.areEqual(r24.d, r34) == true) goto L161;
        Pair<Integer, Integer> r35 = o;
        if (r35 != null) goto L147;
    L151:
        r24.d = r34;
        r24.f = r17;
        r24.e(r34, r17);
        r14.i(r12, "tts play text: ".concat(r34));
        return;
    L147:
        if (r33.c() >= ((Number) r35.getFirst()).intValue()) goto L149;
        return;
    L149:
        if (r33.c() <= ((Number) r35.getSecond()).intValue()) goto L151;
        return;
    L161:
        return;
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L78:
        r14.i(r12, "origin not reached tts ignored,mLatestNaviUpdateStatus:" + r24.e);
    L80:
        if (r2 != 4) goto L87;
        Integer r36 = r24.e;
        if (r36 != null) goto L85;
    L86:
        r24.f = r17;
        r24.e(AppHost.a.getApplication().getString(2131908067), r18);
        r14.i(r12, "reroute tts triggered,mLatestNaviUpdateStatus:" + r24.e);
        goto L123
    L85:
        if (r36.intValue() != r2) goto L86;
    L87:
        if (r2 != 0) goto L123;
        if (r24.h == null) goto L123;
        boolean r37 = r24.c;
        r24.c = r17;
        r24.h = null;
        Boolean r38 = r24.g;
        r24.g = null;
        if (r1 == null) goto L101;
        List r111 = r1.g();
        if (r111 == null) goto L101;
        ul9.h r112 = (ul9.h) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L101;
        ul9.d r113 = r112.a();
        if (r113 == null) goto L101;
        List r114 = r113.b();
        if (r114 == null) goto L101;
        r0 = (vl9.d) CollectionsKt.firstOrNull(r114);
    L101:
        if (r0 == null) goto L122;
        int r39 = r0.a();
        String r115 = "";
        if (r10 != 0) goto L105;
        String r40 = AppHost.a.getApplication().getString(2131908070);
    L112:
        Intrinsics.checkNotNull(r40);
        if (Intrinsics.areEqual(r38, Boolean.TRUE) == false) goto L115;
        String r41 = r40 + AppHost.a.getApplication().getString(2131908069);
    L116:
        if (r37 == false) goto L118;
        r14.i(r12, "start text ignored due to quickRestart,mLatestNaviUpdateStatus:" + r24.e);
        r41 = "";
    L118:
        if (r39 == 0) goto L121;
        StringBuilder r42 = new StringBuilder();
        AppHost.Companion r43 = AppHost.a;
        r42.append(r43.getApplication().getString(2131908058));
        r42.append(r39);
        r42.append(r43.getApplication().getString(2131908077));
        r115 = r42.toString();
    L121:
        r24.e(r41 + r115, r17);
        r14.i(r12, "start tts triggered,mLatestNaviUpdateStatus:" + r24.e + ",distanceToCurrent:" + r39);
        goto L123
    L115:
        r41 = "";
        goto L116
    L105:
        if (r10 != r18) goto L107;
        r40 = AppHost.a.getApplication().getString(2131908056);
        goto L112
    L107:
        if (r10 == 2) goto L109;
        r40 = "";
        goto L112
    L109:
        r40 = AppHost.a.getApplication().getString(2131908057);
        goto L112
    L122:
        r14.i(r12, "start tts triggered fails,mLatestNaviUpdateStatus:" + r24.e);
    L56:
        r110 = false;
        r24 = r22;
        goto L57
    L36:
        if (r2 == 9001) goto L52;
        NavigationCallback r44 = this;
        r44.j = r17;
        if (r2 != 5) goto L40;
        String r45 = AppHost.a.getApplication().getString(2131908061);
    L51:
        Intrinsics.checkNotNull(r45);
        r14.i("navi_callback", "status error dut to status: " + r2);
        r44.e(r45, r18);
        r23 = r44;
        goto L55
    L40:
        if (r2 == 2001) goto L49;
        r22 = r44;
        if (r2 == 2002) goto L48;
        switch(r2) {
            case 3001: goto L47;
            case 3002: goto L46;
            case 3003: goto L45;
            default: goto L56;
        };
    L45:
        r45 = AppHost.a.getApplication().getString(2131908066);
        goto L51
    L46:
        r45 = AppHost.a.getApplication().getString(2131908064);
        goto L51
    L47:
        r45 = AppHost.a.getApplication().getString(2131908063);
        goto L51
    L48:
        r45 = AppHost.a.getApplication().getString(2131908065);
        goto L51
    L49:
        r45 = AppHost.a.getApplication().getString(2131908062);
        goto L51
    L26:
        r11 = null;
        goto L27
    L29:
        if (r5 == null) goto L31;
        dv3.b r46 = new dv3.b(r5.c(), r5.b());
    L32:
        r18 = 1;
        r17 = 0;
        r12 = new dv3.c(null, null, r46, r15, null);
        goto L33
    L31:
        r46 = null;
        goto L32
    L15:
        r9 = null;
        goto L16
    L17:
        StringBuilder r47 = new StringBuilder("onNaviUpdate,sessionId[");
        r47.append(r6);
        r47.append("];routeId[");
        r47.append(r4);
        r47.append("];status[");
        r47.append(r2);
        r47.append("];message[");
        r47.append(r3);
        r47.append("];route[");
        if (r1 == null) goto L20;
        String r48 = r1.i();
    L21:
        r47.append(r48);
        r47.append(']');
        r14.d("navi_callback", r47.toString());
        goto L22
    L20:
        r48 = null;
        goto L21
    L9:
        r16 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    public final void e(String r9, boolean r10) {
        boolean r0 = false;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        FLogger.a.i("navi_callback", "startTts with NullOrBlank");
        return;
    L13:
        if (this.a != null) goto L24;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L16:
        if (this.a != null) goto L18;
        this.a = new BaiduNaviTtsPlayer();     // Catch: Throwable -> L21
    L18:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
    L24:
        BaiduNaviTtsPlayer r4 = this.a;
        if (r4 == null) goto L49;
        String r5 = m;
        AbsStartBaiduNavigationIDL.b r6 = n;
        if (r6 == null) goto L29;
        String r7 = r6.getConversationId();
    L30:
        LinkedHashMap r8 = new LinkedHashMap();
        AbsStartBaiduNavigationIDL.b r11 = n;
        if (r11 == null) goto L35;
        String r12 = r11.getBotId();
        if (r12 == null) goto L35;
        r8.put("bot_id", r12);
    L35:
        Unit r13 = Unit.INSTANCE;
        if (r9 != null) goto L38;
    L39:
        r0 = true;
    L40:
        if (r0 == false) goto L43;
        FLogger.a.i("BaiduNaviTtsPlayer", "empty text for tts");
        return;
    L43:
        if (r5 != null) goto L45;
        r5 = "zh_female_maomao_conversation_wvae_bigtts";
    L45:
        r4.b(new BaiduNaviTtsPlayer.a(r9, r5, r7, r8), r10);
        return;
    L38:
        if (r9.length() != 0) goto L40;
    L29:
        r7 = null;
        goto L30
    L49:
        return;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void h(ul9.e r8, boolean r9) {
        FLogger.a.i("navi_callback", "updateStartEndGuide triggered");
        ul9.b r0 = null;
        Object r1 = null;
        if (r8 == null) goto L5;
        List r10 = r8.d();
    L7:
        if (r10 == null) goto L24;
        Iterator r3 = r10.iterator();
    L10:
        if (r3.hasNext() == false) goto L22;
        Object r4 = r3.next();
        ul9.b r5 = (ul9.b) r4;
        if (r5 == null) goto L19;
        Integer r6 = r5.getType();
        if (r6 == null) goto L19;
        if (r6.intValue() != 1) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L10;
    L23:
        ul9.b r11 = (ul9.b) r4;
    L25:
        if (r10 == null) goto L41;
        Iterator r12 = r10.iterator();
    L28:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();
        ul9.b r14 = (ul9.b) r13;
        if (r14 == null) goto L37;
        Integer r15 = r14.getType();
        if (r15 == null) goto L37;
        if (r15.intValue() != 3) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == false) goto L28;
        r1 = r13;
    L37:
        r16 = false;
    L40:
        r0 = (ul9.b) r1;
    L41:
        this.g = Boolean.valueOf(r9);
        if (r11 == null) goto L45;
        String r17 = r11.a();
        if (r17 == null) goto L45;
    L46:
        this.h = r17;
        if (r0 == null) goto L50;
        String r18 = r0.a();
        if (r18 == null) goto L50;
    L51:
        this.i = r18;
        return;
    L50:
        r18 = AppHost.a.getApplication().getString(2131908055);
    L45:
        r17 = "";
    L19:
        r7 = false;
        goto L20
    L22:
        r4 = null;
        goto L23
    L24:
        r11 = null;
        goto L25
    L5:
        r10 = null;
        goto L7
    }

    public final void c(String r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "routeId");
        boolean r10 = this.c;
        if (r10 == true) goto L14;
        boolean r4 = this.b;
        if (r4 == false) goto L14;
        if (r10 == false) goto L9;
        if (r4 == false) goto L9;
    L10:
        String r11 = this.i;
        if (r11 == null) goto L13;
        this.i = null;
        e(r11, true);
        FLogger.a.i("navi_callback", "auto stop tts triggered");
    L15:
        FLogger.a.i("navi_callback", "onNaviEnd,sessionId[" + r7 + "];routeId[" + r9 + ']');
        a.a(9, null, null);
        String r12 = ev3.a.a;
        ev3.a.b(RealTimeNavEndReason.ARRIVE, null, 2);
        this.a = null;
        e.b("navi_end");
        m = null;
        n = null;
        o = null;
        return;
    L13:
        FLogger.a.i("navi_callback", "auto stop tts triggered fails");
    L9:
        this.b = false;
    L14:
        FLogger.a.i("navi_callback", "onNaviEnd,sessionId[" + r7 + "];routeId[" + r9 + "] ignored due to keepNavi");
        goto L15
    }

    public final void d(String r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "routeId");
        this.f = true;
        this.e = null;
        this.d = null;
        if (this.c == true) goto L5;
    L7:
        this.b = true;
    L8:
        FLogger.a.i("navi_callback", "onNaviStart,sessionId:[" + r4 + "];routeId:[" + r6 + "];routePlanType:[" + r5 + ']');
        return;
    L5:
        if (this.b == false) goto L7;
        goto L7
    }

    public final void a(int r7, String r8, String r9, String r10, String r11, ul9.e r12) {
        Intrinsics.checkNotNullParameter(r8, "oldSessionId");
        Intrinsics.checkNotNullParameter(r9, "oldRouteId");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "routeId");
        Intrinsics.checkNotNullParameter(r12, "route");
        FLogger.a.i("navi_callback", "onNaviRouteChange,sessionId[" + r10 + "];routeId[" + r12.e() + ']');
        h(r12, false);
        int r13 = a.a;
        a.a(4, null, new dv3.c(1, r10, null, null, CollectionsKt.listOf(g(r12))));
    }
}
