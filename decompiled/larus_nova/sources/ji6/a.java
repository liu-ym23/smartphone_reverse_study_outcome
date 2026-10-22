package ji6;

import android.view.View;
import com.bytedance.live.livelink.kmp.impl.core.link.LinkManager$interactListener$2;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.r0;
import uf2.x;
import uf2.z;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f499200a;

    @Override // ji6.c
    public final z C() {
        d0 r100 = this.f499200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.C();
    }

    @Override // ji6.c
    public final void D() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L6;
        r100.D();
        return;
    }

    @Override // ji6.c
    public final r0 E() {
        d0 r100 = this.f499200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.E();
    }

    @Override // ji6.c
    public final int F() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L7;
        d0.a r101 = r100.getBuilder();
        if (r101 == null) goto L7;
        return r101.getVideoWidth();
    L7:
        return 0;
    }

    @Override // ji6.c
    public final boolean a() {
        d0 r100 = this.f499200a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // ji6.c
    public final x b() {
        d0 r100 = this.f499200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // ji6.c
    public final d0.a getBuilder() {
        d0 r100 = this.f499200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBuilder();
    }

    @Override // ji6.c
    public final List<String> getUrls() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrls();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // ji6.c
    public final void h() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    @Override // ji6.c
    public final x l() {
        d0 r100 = this.f499200a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.l();
    }

    @Override // ji6.c
    public final void m() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L6;
        r100.m();
        return;
    }

    @Override // ji6.c
    public final boolean o() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L7;
        d0.a r101 = r100.getBuilder();
        if (r101 == null) goto L7;
        return r101.L();
    L7:
        return true;
    }

    @Override // ji6.c
    public final int s() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L7;
        d0.a r101 = r100.getBuilder();
        if (r101 == null) goto L7;
        return r101.getVideoHeight();
    L7:
        return 0;
    }

    @Override // ji6.c
    public final void stop() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    @Override // ji6.c
    public final void u() {
        d0 r100 = this.f499200a;
        if (r100 == null) goto L6;
        r100.u();
        return;
    }

    public a(d0 r100) {
        this.f499200a = r100;
    }

    @Override // ji6.c
    public final void A(int r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.b0();
        return;
    }

    @Override // ji6.c
    public final void B(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.v();
        return;
    }

    @Override // ji6.c
    public final void G(LinkManager$interactListener$2.a r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.U();
        return;
    }

    @Override // ji6.c
    public final void Ja(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.i();
        return;
    }

    @Override // ji6.c
    public final void n(d0.b r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.H();
        return;
    }

    @Override // ji6.c
    public final void p(boolean r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.t();
        return;
    }

    @Override // ji6.c
    public final void r(int r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.y();
        return;
    }

    @Override // ji6.c
    public final void t(boolean r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.N();
        return;
    }

    @Override // ji6.c
    public final void v(String r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.w();
        return;
    }

    @Override // ji6.c
    public final void w(d0.b r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.g0();
        return;
    }

    @Override // ji6.c
    public final void x(boolean r100) {
        d0 r101 = this.f499200a;
        if (r101 == null) goto L6;
        r101.Z();
        return;
    }

    @Override // ji6.c
    public final void y(int r100, int r101) {
        d0 r102 = this.f499200a;
        if (r102 == null) goto L6;
        r102.G();
        return;
    }

    @Override // ji6.c
    public final void z(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        d0 r102 = this.f499200a;
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof View) == true) goto L7;
        r101 = null;
    L7:
        View r103 = (View) r101;
        r102.f0();
    }

    @Override // ji6.c
    public final void H(int r100, int r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r102, "params");
        d0 r103 = this.f499200a;
        if (r103 == null) goto L6;
        Arrays.copyOf(r102, r102.length);
        r103.k0();
        return;
    }

    @Override // ji6.c
    public final void q(String r100, Object r101, int r102, boolean r103, boolean r104, int r105) {
        d0 r106 = this.f499200a;
        if (r106 == null) goto L6;
        r106.W();
        return;
    }
}
