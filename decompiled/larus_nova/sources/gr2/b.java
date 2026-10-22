package gr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import fr2.e0;
import fr2.u1;
import fr2.y;
import fr2.z;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import zf2.k0;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements fr2.e, hr2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei6.a f482300a;

    @Override // fr2.e
    public final void H3() {
        si6.b r100 = this.f482300a.b();
        if (r100 == null) goto L6;
        si6.a.a(r100, String.valueOf(getRtcRoomId()), false, 8);
        return;
    }

    @Override // fr2.e
    public final u1 X() {
        return new u1(this.f482300a);
    }

    @Override // hr2.a
    public final void disableRemoteOrientation() {
        SpatialAudioManager r100 = this.f482300a.m();
        if (r100 == null) goto L6;
        r100.a(String.valueOf(getRtcRoomId()));
        return;
    }

    @Override // fr2.e
    public final void dispose() {
        si6.b r100 = this.f482300a.b();
        if (r100 == null) goto L6;
        si6.a.b(r100, false, "MainClient", 3);
        return;
    }

    @Override // fr2.e
    public final void f() {
        vi6.a r100 = this.f482300a.v();
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // fr2.e
    public final String getBusinessId() {
        li6.a r100 = this.f482300a.e();
        if (r100 == null) goto L7;
        li6.c r101 = (li6.c) r100.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
        if (r101 == null) goto L7;
        String r102 = r101.f509383b;
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }

    @Override // fr2.e
    public final IConfig getConfig() {
        fi6.a r100 = this.f482300a.g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new f(r100);
    }

    @Override // fr2.e
    public final h getRtcExtInfo() {
        li6.a r100 = this.f482300a.e();
        if (r100 == null) goto L7;
        li6.c r101 = (li6.c) r100.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
        if (r101 == null) goto L7;
        return new h(r101);
    L7:
        return null;
    }

    @Override // fr2.e
    public final String getRtcRoomId() {
        si6.b r100 = this.f482300a.b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.m();
    }

    @Override // fr2.e
    public final void j() {
        si6.b r100 = this.f482300a.b();
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    @Override // fr2.e
    public final void n() {
        ti6.d r100 = this.f482300a.p();
        if (r100 == null) goto L8;
        ti6.e r101 = r100.f();
        if (r101 == null) goto L9;
        r101.n();
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void o() {
        ti6.d r100 = this.f482300a.p();
        if (r100 == null) goto L8;
        ti6.e r101 = r100.f();
        if (r101 == null) goto L9;
        r101.o();
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void q() {
        ui6.b r100 = this.f482300a.h();
        if (r100 == null) goto L6;
        r100.a(String.valueOf(getRtcRoomId()));
        return;
    }

    @Override // fr2.e
    public final void s1() {
        ri6.b r100 = this.f482300a.r();
        if (r100 == null) goto L6;
        r100.s1();
        return;
    }

    @Override // fr2.e
    public final void start() {
        si6.b r100 = this.f482300a.b();
        if (r100 == null) goto L6;
        si6.a.a(r100, String.valueOf(getRtcRoomId()), false, 14);
        return;
    }

    @Override // fr2.e
    public final void t1() {
        ri6.b r100 = this.f482300a.r();
        if (r100 == null) goto L6;
        r100.t1();
        return;
    }

    public final String toString() {
        return "MainClient{roomId=" + getRtcRoomId() + '}';
    }

    @Override // fr2.e
    public final void x1() {
        ChorusManager r100 = this.f482300a.i();
        if (r100 == null) goto L6;
        r100.B();
        return;
    }

    @Override // fr2.e
    public final void z1() {
        si6.b r100 = this.f482300a.b();
        if (r100 == null) goto L6;
        r100.k(null);
        return;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482300a;
    }

    public b(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482300a = r100;
    }

    @Override // fr2.e
    public final void A1(boolean r100) {
        xi6.c r101 = this.f482300a.t();
        if (r101 == null) goto L8;
        com.bytedance.live.livelink.kmp.impl.core.video.c r102 = r101.d();
        if (r102 == null) goto L9;
        r102.u(r100);
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void B1(IConfig.c r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof MixStreamType) == false) goto L10;
        r101 = r102;
    L10:
        MixStreamType r103 = (MixStreamType) r101;
        if (r103 == null) goto L16;
        ti6.d r104 = this.f482300a.p();
        if (r104 == null) goto L17;
        r104.m(r103);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // fr2.e
    public final int D2(ArrayList<fr2.g> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ui6.b r101 = this.f482300a.h();
        if (r101 == null) goto L21;
        String r102 = String.valueOf(getRtcRoomId());
        ArrayList r103 = new ArrayList();
        Iterator<fr2.g> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next().getReal();
        if ((r105 instanceof ui6.a) == true) goto L10;
        r105 = null;
    L10:
        ui6.a r106 = (ui6.a) r105;
        if (r106 == null) goto L6;
        r103.add(r106);
        goto L6
    L13:
        r101.e(r102, r103, "");
        return 0;
    L21:
        return 0;
    }

    @Override // fr2.e
    public final void D4(boolean r100) {
        xi6.c r101 = this.f482300a.t();
        if (r101 == null) goto L7;
        com.bytedance.live.livelink.kmp.impl.core.video.c r102 = r101.d();
        if (r102 == null) goto L7;
        r102.e(r100);
    L7:
        ri6.b r103 = this.f482300a.r();
        if (r103 == null) goto L11;
        r103.p(String.valueOf(getRtcRoomId()), !r100, "enableAllRemoteRender");
        return;
    }

    @Override // fr2.e
    public final void E3(z r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        y r101 = r100.f478563c;
        bg2.q r102 = new bg2.q();
        String r103 = r100.f478561a;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f18929a = r103;
        String r104 = r100.f478562b;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f18930b = r104;
        if (r101 != null) goto L5;
        bg2.r r105 = null;
    L6:
        r102.f18931c = r105;
        ti6.d r106 = this.f482300a.p();
        if (r106 == null) goto L10;
        r106.g(r102);
        return;
    L10:
        return;
    L5:
        r105 = new bg2.r();
        r105.f18932a = r101.f478555a;
        r105.f18933b = r101.f478556b;
        r105.f18934c = r101.f478557c;
        String r107 = r101.f478558d;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f18935d = r107;
        Unit r108 = Unit.INSTANCE;
        goto L6
    }

    @Override // fr2.e
    public final void G3(IConfig.b r100) {
        Intrinsics.checkNotNullParameter(r100, "interactMode");
        Object r101 = r100.getReal();
        if ((r101 instanceof InteractMode) == true) goto L5;
        r101 = null;
    L5:
        InteractMode r102 = (InteractMode) r101;
        if (r102 == null) goto L11;
        si6.b r103 = this.f482300a.b();
        if (r103 == null) goto L12;
        r103.a(r102);
        return;
    L12:
        return;
    }

    @Override // fr2.e
    public final void J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ti6.d r101 = this.f482300a.p();
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // fr2.e
    public final void N0(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        si6.b r101 = this.f482300a.b();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // fr2.e
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcExtInfo");
        si6.b r101 = this.f482300a.b();
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // fr2.e
    public final void c4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        xi6.c r101 = this.f482300a.t();
        if (r101 == null) goto L8;
        com.bytedance.live.livelink.kmp.impl.core.video.c r102 = r101.d();
        if (r102 == null) goto L9;
        r102.l(r100, true, "main client");
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessId");
        si6.b r101 = this.f482300a.b();
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // hr2.a
    public final void i(boolean r100) {
        SpatialAudioManager r101 = this.f482300a.m();
        if (r101 == null) goto L6;
        r101.b(String.valueOf(getRtcRoomId()), false);
        return;
    }

    @Override // fr2.e
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "waterMarkId");
        ti6.d r101 = this.f482300a.p();
        if (r101 == null) goto L8;
        ti6.e r102 = r101.f();
        if (r102 == null) goto L9;
        r102.k(r100);
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void muteLocalVideo(boolean r100) {
        xi6.c r101 = this.f482300a.t();
        if (r101 == null) goto L8;
        com.bytedance.live.livelink.kmp.impl.core.video.b r102 = r101.f();
        if (r102 == null) goto L9;
        r102.e(r100);
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void n3(com.bytedance.android.live.revenuelink.rtc.s r100) {
        gi6.e r101 = this.f482300a.getEventManager();
        if (r101 == null) goto L14;
        Object r102 = null;
        if (r100 == null) goto L7;
        Object r103 = r100.f478520a;
    L9:
        if ((r103 instanceof ii6.a) == false) goto L12;
        r102 = r103;
    L12:
        r101.b((ii6.a) r102);
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // hr2.a
    public final void p4(hr2.e r100) {
        Intrinsics.checkNotNullParameter(r100, "streamIndexMain");
        Object r101 = r100.getReal();
        if ((r101 instanceof LiveWrappedStreamIndex) == true) goto L5;
        r101 = null;
    L5:
        LiveWrappedStreamIndex r102 = (LiveWrappedStreamIndex) r101;
        xi6.c r103 = this.f482300a.t();
        if (r103 == null) goto L11;
        com.bytedance.live.livelink.kmp.impl.core.video.b r104 = r103.f();
        if (r104 == null) goto L12;
        r104.h();
        return;
    L12:
        return;
    }

    @Override // fr2.e
    public final void stop(boolean r100) {
        si6.b r101 = this.f482300a.b();
        if (r101 == null) goto L6;
        si6.a.b(r101, r100, "revenue", 2);
        return;
    }

    @Override // fr2.e
    public final void u1(boolean r100) {
        ri6.b r101 = this.f482300a.r();
        if (r101 == null) goto L6;
        r101.s(String.valueOf(getRtcRoomId()), !r100);
        return;
    }

    @Override // fr2.e
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ri6.b r101 = this.f482300a.r();
        if (r101 == null) goto L6;
        r101.w(r100);
        return;
    }

    @Override // fr2.e
    public final void w1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        ri6.b r101 = this.f482300a.r();
        if (r101 == null) goto L6;
        r101.l(bj6.a.b(this.f482300a), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r100, true, "main client");
        return;
    }

    @Override // fr2.e
    public final void y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "liveCoreExtInfo");
        si6.b r101 = this.f482300a.b();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // fr2.e
    public final void A(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "msg");
        si6.b r102 = this.f482300a.b();
        if (r102 == null) goto L6;
        r102.p(bj6.a.b(this.f482300a), r100, r101);
        return;
    }

    @Override // fr2.e
    public final int K3(ArrayList<fr2.g> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, "roomGroupId");
        ui6.b r102 = this.f482300a.h();
        if (r102 == null) goto L21;
        String r103 = String.valueOf(getRtcRoomId());
        ArrayList r104 = new ArrayList();
        Iterator<fr2.g> r105 = r100.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next().getReal();
        if ((r106 instanceof ui6.a) == true) goto L10;
        r106 = null;
    L10:
        ui6.a r107 = (ui6.a) r106;
        if (r107 == null) goto L6;
        r104.add(r107);
        goto L6
    L13:
        r102.e(r103, r104, r101);
        return 0;
    L21:
        return 0;
    }

    @Override // hr2.a
    public final void L4(hr2.d r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcRemoteStreamInfo");
        Object r102 = r100.getReal();
        if ((r102 instanceof k0) == true) goto L5;
        r102 = null;
    L5:
        k0 r103 = (k0) r102;
        if (r103 == null) goto L16;
        xi6.c r104 = this.f482300a.t();
        if (r104 == null) goto L17;
        com.bytedance.live.livelink.kmp.impl.core.video.c r105 = r104.d();
        if (r105 == null) goto L18;
        if (r101 == false) goto L13;
        LiveWrappedVideoSuperResolutionMode r106 = LiveWrappedVideoSuperResolutionMode.SCALE_AUTO;
    L14:
        r105.q(r103, r106);
        return;
    L13:
        r106 = LiveWrappedVideoSuperResolutionMode.OFF;
        goto L14
    L18:
        return;
    L17:
        return;
    }

    @Override // fr2.e
    public final int T3(ArrayList<fr2.g> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, "roomGroupId");
        ui6.b r102 = this.f482300a.h();
        if (r102 == null) goto L21;
        String r103 = String.valueOf(getRtcRoomId());
        ArrayList r104 = new ArrayList();
        Iterator<fr2.g> r105 = r100.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next().getReal();
        if ((r106 instanceof ui6.a) == true) goto L10;
        r106 = null;
    L10:
        ui6.a r107 = (ui6.a) r106;
        if (r107 == null) goto L6;
        r104.add(r107);
        goto L6
    L13:
        r102.d(r103, r104, r101);
        return 0;
    L21:
        return 0;
    }

    @Override // fr2.e
    public final void p0(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        ri6.b r102 = this.f482300a.r();
        if (r102 == null) goto L6;
        r102.s(String.valueOf(getRtcRoomId()), r100);
        return;
    }

    @Override // fr2.e
    public final void r1(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        xi6.c r102 = this.f482300a.t();
        if (r102 == null) goto L7;
        com.bytedance.live.livelink.kmp.impl.core.video.c r103 = r102.d();
        if (r103 == null) goto L7;
        r103.l(r100, r101, "");
    L7:
        ti6.d r104 = this.f482300a.p();
        if (r104 == null) goto L11;
        r104.i(true, false);
        return;
    }

    @Override // fr2.e
    public final void s2(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        xi6.c r102 = this.f482300a.t();
        if (r102 == null) goto L8;
        com.bytedance.live.livelink.kmp.impl.core.video.c r103 = r102.d();
        if (r103 == null) goto L9;
        r103.s(r100, r101);
        return;
    L9:
        return;
    }

    @Override // fr2.e
    public final void t3(boolean r100, boolean r101) {
        ChorusManager r102 = this.f482300a.i();
        if (r102 == null) goto L6;
        r102.y(r100, r101);
        return;
    }

    @Override // fr2.e
    public final void b0(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r102, "reason");
        ri6.b r103 = this.f482300a.r();
        if (r103 == null) goto L6;
        r103.D(String.valueOf(getRtcRoomId()), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r100, r101);
        return;
    }

    @Override // fr2.e
    public final void h(String r100, boolean r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r110, "reason");
        ri6.b r102 = this.f482300a.r();
        if (r102 == null) goto L6;
        r102.l(String.valueOf(getRtcRoomId()), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r100, r101, r110);
        return;
    }

    @Override // fr2.e
    public final void o4(String r100, e0 r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "waterMarkId");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        Object r103 = r101.getReal();
        if ((r103 instanceof RTCWaterMarkRegion) == true) goto L5;
        r103 = null;
    L5:
        RTCWaterMarkRegion r104 = (RTCWaterMarkRegion) r103;
        if (r104 == null) goto L13;
        ti6.d r105 = this.f482300a.p();
        if (r105 == null) goto L14;
        ti6.e r106 = r105.f();
        if (r106 == null) goto L15;
        r106.a(r100, r104);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // fr2.e
    public final void J0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        si6.b r105 = this.f482300a.b();
        if (r105 == null) goto L6;
        r105.l(new dg2.d(0));
        return;
    }
}
