package com.bytedance.dora.offline.file;

import com.bytedance.dora.device.DoraDevice;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements sk4.d, mj4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, String> f204566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f204567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f204568c;

    @Override // sk4.d
    public final void A(int r100, int r101, byte[] r102, byte[] r103) {
    }

    @Override // mj4.h
    public final /* synthetic */ void D(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void J(byte[] r100) {
    }

    @Override // mj4.h
    public final /* synthetic */ void N(int r100, int r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void N0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void P0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void Y(int r100, int r101, int r102) {
    }

    @Override // mj4.h
    public final /* synthetic */ void a0(DoraDevice r100, int[] r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void b() {
    }

    @Override // mj4.h
    public final /* synthetic */ void b0(DoraDevice r100, int[] r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void c(int r100, int r101, int r102) {
    }

    @Override // sk4.d
    public final /* synthetic */ void d(int r100) {
    }

    @Override // mj4.h
    public final /* synthetic */ void d1(DoraDevice r100, int r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void e1(DoraDevice r100, int[] r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void f(String r100) {
    }

    @Override // mj4.h
    public final /* synthetic */ void f1(int r100, byte r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void g(int r100, long r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void h(int r100) {
    }

    @Override // sk4.d
    public final void i(int r100, String r101, int r102, float r103, float r104, float r105, int r106, int r107, float r108, float r110) {
    }

    @Override // sk4.d
    public final /* synthetic */ void j(int r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void l(int r100) {
    }

    @Override // mj4.h
    public final /* synthetic */ void l1(DoraDevice r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void n() {
    }

    @Override // mj4.h
    public final /* synthetic */ void p(int r100) {
    }

    @Override // sk4.d
    public final void q(int r100, byte[] r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void r(int r100, int r101, int r102) {
    }

    @Override // mj4.h
    public final /* synthetic */ void u(DoraDevice r100, int r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void w(int r100, int r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void y(DoraDevice r100, int r101, byte[] r102) {
    }

    @Override // mj4.h
    public final /* synthetic */ void y0(DoraDevice r100, int[] r101) {
    }

    public a(i r100) {
        this.f204566a = new ConcurrentHashMap();
        this.f204567b = new AtomicBoolean(false);
        this.f204568c = r100;
    }

    @Override // mj4.h
    public final void a1(DoraDevice r100, mj4.b r101) {
        o(r100, r101, "idle_state_changed");
    }

    public final void k(int r100, String r101, String r102) {
        boolean r103 = ((ConcurrentHashMap) this.f204566a).isEmpty();
        ((ConcurrentHashMap) this.f204566a).put(Integer.valueOf(r100), r101);
        pk4.j.d("OfflineFileBusinessBlocker", "High priority business started, reason=" + r101 + ", " + r102);
        if (r103 == false) goto L6;
        pk4.j.d("OfflineFileBusinessBlocker", "Offline file sync will pause for high priority business, reason=".concat(r101));
        return;
    }

    public final void m(int r100, String r101, String r102) {
        if (((ConcurrentHashMap) this.f204566a).remove(Integer.valueOf(r100)) != null) goto L5;
        return;
    L5:
        pk4.j.d("OfflineFileBusinessBlocker", "High priority business ended, reason=" + r101 + ", " + r102);
        if (((ConcurrentHashMap) this.f204566a).isEmpty() == false) goto L9;
        pk4.j.d("OfflineFileBusinessBlocker", "All high priority businesses ended, schedule offline file sync");
        this.f204568c.run();
        return;
    }

    public final void o(DoraDevice r100, mj4.b r101, String r102) {
        boolean r103 = false;
        if (r101 == null) goto L5;
        int r104 = r101.f514221a;
    L14:
        if (r101 == null) goto L16;
        int r105 = r101.f514222b;
    L24:
        String r106 = "source=" + r102 + ", idleState=" + r104 + ", currentIdleState=" + r105;
        if ((r104 & 2) != 0) goto L27;
        if (r105 == 2) goto L27;
    L29:
        if (r103 == false) goto L31;
        k(-1, "hfp", r106);
        return;
    L31:
        m(-1, "hfp", r106);
        return;
    L27:
        r103 = true;
        goto L29
    L16:
        if (r100 == null) goto L23;
        int[] r107 = r100.idleState;
        if (r107 == null) goto L23;
        if (r107.length < 2) goto L23;
        r105 = r107[1];
    L23:
        r105 = -1;
        goto L24
    L5:
        if (r100 == null) goto L12;
        int[] r108 = r100.idleState;
        if (r108 == null) goto L12;
        if (r108.length == 0) goto L12;
        r104 = r108[0];
    L12:
        r104 = 0;
        goto L14
    }

    public static String a(int r100, int r101, int r102, int r103, int r104, String r105) {
        if (r105 == null) goto L4;
        int r106 = r105.length();
    L6:
        return "wakeMode=" + r100 + ", query=" + r101 + ", state=" + r102 + ", side=" + r103 + ", vuiId=" + r104 + ", extraLength=" + r106;
    L4:
        r106 = 0;
        goto L6
    }

    @Override // sk4.d
    public final void e(int r110, int r111, int r112, int r113, int r114, String r115, String r116) {
        boolean r100 = true;
        if (r111 == 1) goto L14;
        if (r111 == 2) goto L14;
        if (r111 == 3) goto L14;
        if (r111 == 32) goto L13;
        switch(r111) {
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L11;
            case 10: goto L11;
            default: goto L9;
        };
    L9:
        switch(r111) {
            case 13: goto L12;
            case 14: goto L12;
            case 15: goto L12;
            case 16: goto L12;
            case 17: goto L12;
            case 18: goto L14;
            default: goto L10;
        };
    L10:
        String r101 = null;
    L15:
        String r102 = r101;
        if (r102 != null) goto L19;
        return;
    L19:
        if (r112 != 2) goto L21;
    L24:
        boolean r103 = true;
    L25:
        if (r103 == false) goto L27;
        k(r111, r102, a(r111, r112, r110, r113, r114, r116));
        return;
    L27:
        if (r112 == 1) goto L35;
        if (r112 == 3) goto L35;
        if (r112 == 8) goto L35;
        if (r112 == 10) goto L35;
        r100 = false;
    L35:
        if (r100 == false) goto L39;
        m(r111, r102, a(r111, r112, r110, r113, r114, r116));
        return;
    L39:
        return;
    L21:
        if (r112 == 7) goto L24;
        r103 = false;
        goto L25
    L12:
        r101 = "record_minutes";
        goto L15
    L11:
        r101 = "simul_interpret";
    L13:
        r101 = "live_ai";
    L14:
        r101 = "query";
        goto L15
    }
}
