package com.bytedance.ies.bullet.lynx;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.q1;
import com.lynx.tasm.s0;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {
    public TemplateBundle A;
    public s0.a B;
    public boolean C;
    public boolean D;
    public String E;
    public boolean F;
    public Boolean G;
    public final List<q1> H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f247262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f247263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxGroup f247264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f247265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f247266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f247267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f247268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f247269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f247270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f247271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f247272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Float f247273l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k7a.a f247274m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TemplateData f247275n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f247276o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f247277p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f247278q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f247279r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super LynxViewBuilder, Unit> f247280s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public o f247281t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f247282u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f247283v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g26.b f247284w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f247285x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f247286y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f247287z;

    public h() {
        this.f247279r = true;
        this.f247287z = 1.0f;
        this.E = TrafficMetrics.FRPM_TTNET;
        this.H = new ArrayList();
    }

    public final void b(String r100, boolean r110, boolean r111, String[] r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        if (com.bytedance.ies.bullet.service.base.h.M() == false) goto L6;
        this.f247264c = a(r100, r110, r111, r112, r113, false, Boolean.FALSE);
        return;
    L6:
        this.f247266e = r100;
        if (Intrinsics.areEqual(r100, "-1") == false) goto L11;
        this.f247264c = LynxGroup.Create(r100, r100, r112, false, r111, r113);
        return;
    L11:
        if (r110 == false) goto L23;
        Object r114 = com.bytedance.ies.bullet.lynx.init.e.f247345a;
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Object r115 = com.bytedance.ies.bullet.lynx.init.e.f247345a;
        monitor-enter(r115);
        com.bytedance.ies.bullet.lynx.init.e.a(r100);     // Catch: Throwable -> L20
        Map<String, LynxGroup> r101 = com.bytedance.ies.bullet.lynx.init.e.f247346b;     // Catch: Throwable -> L20
        LynxGroup r102 = (LynxGroup) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L20
        if (r102 != null) goto L18;
        r102 = LynxGroup.Create(r100, r112, false, r111, r113);     // Catch: Throwable -> L20
        r101.put(r100, r102);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r115);
    L24:
        this.f247264c = r102;
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        r102 = LynxGroup.Create(r100, r112, false, r111, r113);
        goto L24
    }

    public static LynxGroup a(String r100, boolean r101, boolean r102, String[] r103, boolean r110, boolean r111, Boolean r112) {
        boolean r104 = false;
        boolean r105 = true;
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L10;
        LynxGroup.a r106 = new LynxGroup.a();
        r106.f381661a = r100;
        r106.f381662b = r100;
        r106.f381663c = r103;
        if (r102 == true) goto L7;
        if (r111 == true) goto L7;
    L8:
        r106.f381664d = r104;
        r106.f381665e = r110;
        r106.f381666f = r112;
        return new LynxGroup(r106);
    L7:
        r104 = true;
        goto L8
    L10:
        if (r101 == true) goto L12;
        if (r102 == true) goto L23;
        if (r111 == true) goto L23;
        r105 = false;
    L23:
        return LynxGroup.Create(r100, r103, false, r105, r110);
    L12:
        if (r102 == true) goto L16;
        if (r111 == true) goto L16;
        boolean r107 = false;
    L24:
        return LynxGroup.Create(r100, r100, r103, false, r107, r110);
    L16:
        r107 = true;
        goto L24
    }

    public static void d(h r100, String r110, boolean r111, boolean r112, String[] r113, boolean r114, boolean r115) {
        Boolean r101 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r110, "groupName");
        r100.c(r110, r111, r112, r113, r114, r115, false, r101);
    }

    public final void c(String r100, boolean r101, boolean r110, String[] r111, boolean r112, boolean r113, boolean r114, Boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        if (r114 == false) goto L7;
        Object r102 = com.bytedance.ies.bullet.lynx.init.e.f247345a;
        this.f247264c = com.bytedance.ies.bullet.lynx.init.e.c(r100, r111, r110, r112, r113, true);
        return;
    L7:
        if (com.bytedance.ies.bullet.service.base.h.M() == false) goto L10;
        this.f247264c = a(r100, r101, r110, r111, r112, r113, r115);
        return;
    L10:
        this.f247266e = r100;
        if (Intrinsics.areEqual(r100, "-1") == false) goto L14;
        this.f247264c = LynxGroup.Create(r100, r100, r111, false, r110, r112, r113);
        return;
    L14:
        if (r101 == false) goto L16;
        LynxGroup r103 = com.bytedance.ies.bullet.lynx.init.e.d(r100, r111, r110, r112, r113);
    L17:
        this.f247264c = r103;
        return;
    L16:
        r103 = LynxGroup.Create(r100, r111, false, r110, r112, r113);
        goto L17
    }
}
