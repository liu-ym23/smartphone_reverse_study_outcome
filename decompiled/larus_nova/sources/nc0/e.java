package nc0;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import hh1.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements gy.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<gy.d, com.bytedance.android.live.revenuelink.rtc.g> f518608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.rtc.i f518609b;

    @Override // gy.f
    public final boolean F() {
        return this.f518609b.F();
    }

    @Override // gy.f
    public final boolean G() {
        return this.f518609b.G();
    }

    @Override // gy.f
    public final void K() {
        this.f518609b.K();
    }

    @Override // gy.f
    public final s L() {
        return new s(this.f518609b.L());
    }

    @Override // gy.f
    public final List<ui6.a> L0() {
        List<vc0.a> r100 = this.f518609b.L0();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Object r103 = ((vc0.a) r102.next()).f554079a;
        if (r103 == null) goto L9;
        r101.add((ui6.a) r103);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.livelink.kmp.api.core.rtc.ForwardRoomInfo");
    L10:
        return r101;
    }

    @Override // gy.f
    public final String O() {
        return this.f518609b.O();
    }

    @Override // gy.f
    public final com.bytedance.android.live.revenuelink.e P() {
        return this.f518609b.P();
    }

    @Override // gy.f
    public final String c0() {
        return this.f518609b.c0();
    }

    @Override // gy.f
    public final void f() {
        this.f518609b.f();
    }

    @Override // gy.f
    public final String f0() {
        return this.f518609b.f0();
    }

    @Override // gy.f
    public final boolean g0() {
        return this.f518609b.g0();
    }

    @Override // gy.f
    public final d0 getLiveCore() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
        Object r101 = null;
        if (r100 == null) goto L9;
        vc0.a r102 = this.f518609b.getLiveCore();
        if (r102 == null) goto L8;
        r101 = r102.f554079a;
    L8:
        return r100.buildLiveCore(r101);
    L9:
        return null;
    }

    @Override // gy.f
    public final boolean isEngineOn() {
        return this.f518609b.isEngineOn();
    }

    @Override // gy.f
    public final void n() {
        this.f518609b.n();
    }

    @Override // gy.f
    public final void o() {
        this.f518609b.o();
    }

    @Override // gy.f
    public final void onPause() {
        this.f518609b.onPause();
    }

    @Override // gy.f
    public final void onResume() {
        this.f518609b.onResume();
    }

    public e(com.bytedance.android.live.revenuelink.rtc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518609b = r100;
        this.f518608a = new HashMap();
    }

    @Override // gy.f
    public final void J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f518609b.J(r100);
    }

    @Override // gy.f
    public final void a(InteractMode r100) {
        Intrinsics.checkNotNullParameter(r100, "interactMode");
        this.f518609b.v1(new vc0.a(r100), 17, 19);
    }

    @Override // gy.f
    public final Integer b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcInfoMap");
        Intrinsics.checkNotNullParameter("multiLinkRtcStartSuccess", "reqFrom");
        return this.f518609b.c1(r100, "multiLinkRtcStartSuccess", "");
    }

    @Override // gy.f
    public final void d(f92.c r100) {
        Intrinsics.checkNotNullParameter(r100, "streamMixer");
        this.f518609b.I1(new vc0.a(r100));
    }

    @Override // gy.f
    public final void e(gy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.android.live.revenuelink.rtc.g r101 = (com.bytedance.android.live.revenuelink.rtc.g) ((HashMap) this.f518608a).remove(r100);
        if (r101 == null) goto L6;
        this.f518609b.i1(r101);
        return;
    }

    @Override // gy.f
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reqSrc");
        this.f518609b.T1(r100, false);
    }

    @Override // gy.f
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "waterMarkId");
        this.f518609b.k(r100);
    }

    @Override // gy.f
    public final void l(long r100) {
        this.f518609b.H1(r100, "");
    }

    @Override // gy.f
    public final void m(gy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((HashMap) this.f518608a).containsKey(r100) == false) goto L5;
        return;
    L5:
        d r101 = new d(r100);
        this.f518609b.g1(r101);
        ((HashMap) this.f518608a).put(r100, r101);
    }

    @Override // gy.f
    public final void muteLocalVideo(boolean r100) {
        this.f518609b.muteLocalVideo(r100);
    }

    @Override // gy.f
    public final void u1(boolean r100) {
        this.f518609b.y1(r100, "");
    }

    @Override // gy.f
    public final void Q(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "src");
        this.f518609b.Q(r100, r101);
    }

    @Override // gy.f
    public final void T(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "src");
        this.f518609b.T(r100, r101);
    }

    @Override // gy.f
    public final Integer g(Map<Long, String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r101, "reqFrom");
        return this.f518609b.a1(r100, r101, "");
    }

    @Override // gy.f
    public final void h(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f518609b.h(r100, r101, r102);
    }

    @Override // gy.f
    public final void i(String r100, RTCWaterMarkRegion r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "waterMarkId");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        this.f518609b.S1(r100, new vc0.a(r101), r102);
    }

    @Override // gy.f
    public final void c(v0 r100, gy.g r101, String r102, gy.i r103) {
        Intrinsics.checkNotNullParameter(r101, "configInvocation");
        Intrinsics.checkNotNullParameter(r102, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        com.bytedance.android.live.revenuelink.rtc.i r104 = this.f518609b;
        if (r100 == null) goto L5;
        vc0.a r105 = new vc0.a(r100);
    L6:
        r104.U1(r105, new q(r101), r102, new com.bytedance.android.live.revenuelink.rtc.q(r103.f483315a, r103.f483316b, r103.f483317c, r103.f483318d));
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // gy.f
    public final void d0(String r100, String r101, int r110, int r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r101, "src");
        this.f518609b.d0(r100, r101, r110, r111, r112);
    }
}
