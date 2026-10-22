package com.larus.audio.call;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ouc.d0;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements IRealtimeCallTracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f289114a;

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void C(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void D(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void E() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void F(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void G(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void I() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void J(int r100, String r101, int r102) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void L(RealtimeCallParam r100, int r101, String r102, String r103, Long r104, Long r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void M(String r100, String r101, String r102, Long r103, String r104) {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void N(RealtimeCallParam r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "comfortType");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void O(String r100, RealtimeCallParam r101) {
        Intrinsics.checkNotNullParameter(r100, "endReason");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void P(RealtimeCallParam r100, Long r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Q(IRealtimeCallTracer.HelloStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void S() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void U(int r100, String r101, long r102, RealtimeCallParam r103, Boolean r104, int r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r103, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void W() {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void X(String r100, RealtimeCallParam r101) {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void Y(long r100, long r101, long r102) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Z(RealtimeCallParam r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "comfortType");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void a0(Flow<Integer> r100, CoroutineScope r101, RealtimeCallParam r102) {
        Intrinsics.checkNotNullParameter(r100, "callStateFlow");
        Intrinsics.checkNotNullParameter(r102, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void b0(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c0(long r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d0(RealtimeCallParam r100, int r101, long r102, long r103, boolean r104, String r105, String r106, String r110, Long r111, Long r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e(String r100, String r101, String r102, String r103) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f(RealtimeCallParam r100, String r101, boolean r102, IRealtimeCallTracer.EnterCallSessionStatus r103, Integer r104, long r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r103, "sessionStatus");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f0(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h0(long r100, long r101, String r102, String r103) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j(RealtimeCallParam r100, boolean r101, IRealtimeCallTracer.EnterCallSessionStatus r102, long r103, long r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "sessionStatus");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j0(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k(long r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l(String r100, String r101, String r102, String r103, String r104) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l0(RealtimeCallParam r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "botFromStatus");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void m(RealtimeCallParam r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void m0(String r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void n(RealtimeCallParam r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void n0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o(String r100, long r101, boolean r102, boolean r103, boolean r104, long r105, long r106, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "audioRoute");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o0() {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void onSessionStarted() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p0(RealtimeCallParam r100, IRealtimeCallTracer.EnterCallSessionStatus r101, String r102, int r103, String r104, Boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r104, "errorMsg");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void q(boolean r100, long r101) {
    }

    @Override // com.larus.audio.call.tracer.c
    public final void q0(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "result");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r0(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void u0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void w(RealtimeCallParam r100, int r101, boolean r102, String r103, String r104, long r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final d0 x(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        return r100;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void y(String r100, RealtimeCallParam r101, d0 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void z(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final boolean R() {
        return this.f289114a;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void K(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "serverInfo");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d(com.larus.audio.call.play.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void v(boolean r100) {
        this.f289114a = r100;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void B(IRealtimeCallTracer.TotalTimeType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void H(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        Intrinsics.checkNotNullParameter(r101, "serverParamJson");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void T(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void reportEvent(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void A(RealtimeCallParam r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e0(String r100, String r101, RealtimeCallParam r102, e3a.a r103) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r103, "argumentData");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k0(String r100, RealtimeCallParam r101, boolean r102, e3a.a r103) {
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r103, "argumentData");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "startType");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r103, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r104, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r105, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r106, "translateMode");
        com.larus.audio.call.tracer.c.a.c(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void V(String r100, Integer r101, String r102, Long r103, Long r104, Long r105, Long r106, Integer r107) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void u(String r100, String r110, long r111, String r112, String r113, String r114, String r115, String r116, long r117) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r112, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r113, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r114, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r115, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r116, "translateMode");
        com.larus.audio.call.tracer.c.a.b(r100, r110, r112, r113, r114, r115, r116);
    }
}
