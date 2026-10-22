package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.audio.call.mgr.MajorState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class h extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements s0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f289472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<com.larus.im.service.audio.t> f289473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f289474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b78.b f289475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f289476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f289477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile byte[] f289478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final buc.c f289479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g f289480n;

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        this.f289475i.b(true, WidgetCostModule.TYPE_ON_START);
        id9.d r100 = getContext().j();
        if (r100 == null) goto L6;
        r100.q(this.f289480n);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        cancel("onStop");
        id9.d r100 = getContext().j();
        if (r100 == null) goto L6;
        r100.n(this.f289480n);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f289474h;
    }

    @Override // com.larus.audio.call.plugins.s0
    public final void cancel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        this.f289478l = null;
        this.f289475i.b(false, r100);
    }

    @Override // com.larus.audio.call.plugins.s0
    public final void m2(com.larus.im.service.audio.l r110) {
        Intrinsics.checkNotNullParameter(r110, "frame");
        if (this.f289475i.a() == true) goto L5;
        return;
    L5:
        byte[] r111 = r110.f350772a;
        v58.a r100 = com.larus.audio.call.arch.b.a(getContext()).g0();
        if (r111.length != 0) goto L8;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        List r112 = CollectionsKt.emptyList();
    L90:
        if (r112.isEmpty() == true) goto L124;
        Iterator r113 = r112.iterator();
    L94:
        if (r113.hasNext() == false) goto L148;
        com.larus.im.service.audio.l r102 = (com.larus.im.service.audio.l) r113.next();
        if (this.f289475i.a() == false) goto L147;
        com.larus.audio.call.util.e.f289645a.i(this.f289474h, "sender handleData sendFrame : " + r102.f350772a);
        id9.d r103 = getContext().j();
        if (r103 == null) goto L94;
        if ((r102.getType() instanceof ue9.g.a) == false) goto L123;
        r102 = this.f289473g.invoke().a(r102);
        MajorState r104 = getContext().a().s1();
        if (Intrinsics.areEqual(r104, MajorState.h.f289190c) == false) goto L106;
    L111:
        boolean r105 = true;
    L112:
        if (r105 == false) goto L114;
        LinkedHashMap r106 = new LinkedHashMap();
        LinkedHashMap r107 = new LinkedHashMap();
        ouc.g0 r108 = ouc.k.b(Long.valueOf(SystemClock.elapsedRealtime() - this.f289476j));
        Intrinsics.checkNotNullParameter("playing_duration", "key");
        Intrinsics.checkNotNullParameter(r108, "element");
        ouc.i r109 = (ouc.i) r107.put("playing_duration", r108);
        ouc.g0 r114 = ouc.k.c(this.f289477k);
        Intrinsics.checkNotNullParameter("tts_msg_id", "key");
        Intrinsics.checkNotNullParameter(r114, "element");
        ouc.i r115 = (ouc.i) r107.put("tts_msg_id", r114);
        Unit r116 = Unit.INSTANCE;
        ouc.d0 r117 = new ouc.d0(r107);
        Intrinsics.checkNotNullParameter("tts_status", "key");
        Intrinsics.checkNotNullParameter(r117, "element");
        ouc.i r118 = (ouc.i) r106.put("tts_status", r117);
        ouc.d0 r119 = new ouc.d0(r106);
    L116:
        if (StringsKt.isBlank(String.valueOf(r119)) == true) goto L123;
        byte[] r120 = r102.f350772a;
        ue9.g r121 = r102.getType();
        boolean r122 = r102.f350775d;
        if (r119 == null) goto L121;
        ouc.d0 r123 = q68.d.a(r119, b78.g.a(r102.f350773b));
    L122:
        r102 = new com.larus.im.service.audio.l(r120, String.valueOf(r123), r121, r122);
        goto L123
    L121:
        r123 = null;
        goto L122
    L114:
        r119 = null;
        goto L116
    L106:
        if ((r104 instanceof MajorState.d) == true) goto L108;
    L110:
        r105 = false;
        goto L112
    L108:
        if (((MajorState.d) r104).f289182c != MajorState.From.TTS_ENDED) goto L110;
    L123:
        r103.u(r102);
        goto L94
    L147:
        return;
    L148:
        return;
    L124:
        return;
    L13:
        if (this.f289472f == true) goto L16;
        r112 = CollectionsKt.listOf(new com.larus.im.service.audio.l(r111, null, new ue9.g.a(r100.f553275a, r100.f553276b), false));
        goto L90
    L16:
        if (this.f289478l != null) goto L18;
        this.f289478l = new byte[(((r100.f553275a / 1000) * 10) * r100.f553276b) * 2];
    L18:
        byte[] r124 = this.f289478l;
        if (r124 == null) goto L21;
        int r125 = r124.length;
    L22:
        int r126 = r125 - this.f289479m.b();
        int r127 = r111.length;
        if (r126 != r127) goto L36;
        int r128 = r111.length;
        int r129 = 0;
    L25:
        if (r129 >= r128) goto L30;
        byte[] r130 = this.f289478l;
        if (r130 == null) goto L29;
        r130[this.f289479m.b() + r129] = r111[r129];
    L29:
        r129 = r129 + 1;
        goto L25
    L30:
        buc.c r131 = this.f289479m;
        r131.d(r131.b() + r127);
        byte[] r132 = this.f289478l;
        if (r132 == null) goto L34;
        byte[] r133 = Arrays.copyOf(r132, r132.length);
        if (r133 == null) goto L34;
    L35:
        this.f289479m.d(0);
        r112 = CollectionsKt.listOf(new com.larus.im.service.audio.l(r133, null, new ue9.g.a(r100.f553275a, r100.f553276b), false));
    L34:
        r133 = new byte[0];
        goto L35
    L36:
        if (r126 <= r127) goto L44;
        int r134 = r111.length;
        int r135 = 0;
    L38:
        if (r135 >= r134) goto L43;
        byte[] r136 = this.f289478l;
        if (r136 == null) goto L42;
        r136[this.f289479m.b() + r135] = r111[r135];
    L42:
        r135 = r135 + 1;
        goto L38
    L43:
        buc.c r137 = this.f289479m;
        r137.d(r137.b() + r127);
        r112 = CollectionsKt.emptyList();
        goto L90
    L44:
        ArrayList r138 = new ArrayList();
        int r139 = 0;
    L45:
        int r140 = r126 + r139;
        byte[] r141 = ArraysKt.copyOfRange(r111, r139, r140);     // Catch: Exception -> L48
    L55:
        if (r141 == null) goto L88;
        if (r141.length != 0) goto L59;
        boolean r142 = true;
    L60:
        if (r142 == true) goto L88;
        int r143 = r141.length;
        int r144 = 0;
    L63:
        if (r144 >= r143) goto L68;
        byte[] r145 = this.f289478l;
        if (r145 == null) goto L67;
        r145[this.f289479m.b() + r144] = r141[r144];
    L67:
        r144 = r144 + 1;
        goto L63
    L68:
        buc.c r146 = this.f289479m;
        r146.d(r146.b() + r141.length);
        byte[] r147 = this.f289478l;
        if (r147 == null) goto L71;
        int r148 = r147.length;
    L73:
        if ((r148 - this.f289479m.b()) != 0) goto L80;
        byte[] r149 = this.f289478l;
        if (r149 == null) goto L78;
        byte[] r150 = Arrays.copyOf(r149, r149.length);
        if (r150 == null) goto L78;
    L79:
        this.f289479m.d(0);
        r138.add(new com.larus.im.service.audio.l(r150, null, new ue9.g.a(r100.f553275a, r100.f553276b), false));
    L78:
        r150 = new byte[0];
    L80:
        byte[] r151 = this.f289478l;
        if (r151 == null) goto L83;
        int r152 = r151.length;
    L84:
        int r153 = Math.min(r152 - this.f289479m.b(), r127 - r140);
        if (r140 >= r127) goto L88;
        r139 = r140;
        r126 = r153;
        goto L45
    L83:
        r152 = 0;
        goto L84
    L71:
        r148 = 0;
        goto L73
    L59:
        r142 = false;
    L88:
        r112 = r138;
    L48:
        e = move-exception;
        com.larus.audio.call.g r154 = com.larus.audio.call.f.f289121a;
        if (com.larus.audio.call.f.c().appContext().e() == true) goto L125;
        com.larus.audio.call.util.e r155 = com.larus.audio.call.util.e.f289645a;
        String r156 = this.f289474h;
        String r157 = e.getMessage();
        if (r157 != null) goto L54;
        r157 = "";
    L54:
        r155.e(r156, r157, e);
        r141 = null;
        goto L55
    L125:
        throw e;
    L21:
        r125 = 0;
        goto L22
    L8:
        r101 = false;
        goto L10
    }

    public h(com.larus.audio.call.arch.c r100, boolean r101, com.larus.audio.call.arch.m r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "preProcessor");
        super(r100);
        this.f289472f = r101;
        this.f289473g = r102;
        this.f289474h = "CommonAudioFrameSender";
        this.f289475i = new b78.b("CommonAudioFrameSender");
        this.f289476j = -1;
        this.f289479m = buc.b.b();
        this.f289480n = new g(this);
    }
}
