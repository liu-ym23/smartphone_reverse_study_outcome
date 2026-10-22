package dk4;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mj4.h;
import pk4.j;
import pk4.m;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h, IDoraLinkCallback, sk4.d, dk4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f468993a = 1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f468994a = null;

        static {
            f468994a = new c();
        }
    }

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

    @Override // dk4.a
    public final /* synthetic */ void a() {
    }

    @Override // mj4.h
    public final /* synthetic */ void a0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void a1(DoraDevice r100, mj4.b r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void b() {
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

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
        IDoraLinkCallback.CC.$default$onBtConnectStateChanged(this, r100, r101, r102);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onBtStateChanged(int r100, int r101) {
        IDoraLinkCallback.CC.$default$onBtStateChanged(this, r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onDeviceFound(DoraDevice r100) {
        IDoraLinkCallback.CC.$default$onDeviceFound(this, r100);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onScanFailed(int r100) {
        IDoraLinkCallback.CC.$default$onScanFailed(this, r100);
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

    @Override // dk4.a
    public final void onScreenOff() {
        m.a(new b());
    }

    @Override // dk4.a
    public final void onScreenOn() {
        m.a(new b());
    }

    public c() {
    }

    @Override // mj4.h
    public final void b0(DoraDevice r100, int[] r101) {
        m.a(new b());
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        f468993a = 1;
        if (r102 != 2) goto L5;
        Set<dk4.a> r103 = d.f468995a;
        StringBuilder r104 = new StringBuilder("addScreenStateCallback, size: ");
        CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) d.f468995a;
        r104.append(r105.size());
        j.d("ScreenStateUtils", r104.toString());
        r105.add(this);
        return;
    L5:
        if (r102 != 0) goto L9;
        Set<dk4.a> r106 = d.f468995a;
        StringBuilder r107 = new StringBuilder("removeScreenStateCallback, size: ");
        CopyOnWriteArraySet r108 = (CopyOnWriteArraySet) d.f468995a;
        r107.append(r108.size());
        j.d("ScreenStateUtils", r107.toString());
        r108.remove(this);
        return;
    }

    @Override // sk4.d
    public final void e(int r100, int r101, int r102, int r103, int r104, String r105, String r106) {
        if (r102 != 2) goto L6;
        return;
    L6:
        if (r102 != 1) goto L9;
        j.d("NapManager", "queryStop");
        f468993a = 1;
        m.a(new b());
        return;
    }
}
