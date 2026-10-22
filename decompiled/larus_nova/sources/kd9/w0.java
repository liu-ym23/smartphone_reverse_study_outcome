package kd9;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class w0 extends v implements ff9.a0 {
    @Override // ff9.a0
    public final void onPause() {
        this.f502943a = false;
        v(true);
        t(new j0());
    }

    @Override // ff9.a0
    public final void onResume() {
        this.f502943a = true;
        v(false);
        t(new k0());
    }

    public w0() {
    }

    @Override // ff9.a0
    public final void b(final boolean r100) {
        if (r100 == false) goto L4;
        this.f502943a = true;
        v(false);
    L4:
        t(new i0(r100));
    }

    @Override // ff9.a0
    public final void d(final com.larus.im.service.audio.l r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        t(new v0(r100));
    }

    @Override // ff9.a0
    public final void e(final Integer r100) {
        u(new q0(r100));
    }

    @Override // ff9.a0
    public final void h(final boolean r100) {
        u(new m0(r100));
    }

    @Override // ff9.a0
    public final void k(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "traceInfo");
        u(new t0(r100));
    }

    @Override // ff9.a0
    public final void n(final com.larus.im.internal.rtcsdk.impl.trace.a r100) {
        u(new p0(r100));
    }

    @Override // ff9.a0
    public final void o(final JSONObject r100) {
        u(new h0(r100));
    }

    @Override // ff9.z
    public final void c(final byte[] r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        t(new l0(r100, r101));
    }

    @Override // ff9.z
    public final void g(final byte[] r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        t(new n0(r100, r101));
    }

    @Override // ff9.z
    public final void i(final byte[] r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        t(new o0(r100, r101));
    }

    @Override // ff9.a0
    public final void f(final byte[] r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "queryRound");
        Intrinsics.checkNotNullParameter(r102, "sectionId");
        t(new u0(r100, r101, r102));
    }

    @Override // ff9.a0
    public final void m(final boolean r100, final boolean r101, final JSONObject r102) {
        if (r100 == false) goto L4;
        this.f502943a = false;
        v(false);
    L4:
        t(new r0(r100, r101));
        if (r100 == false) goto L8;
        u(new s0(r102));
        return;
    }
}
