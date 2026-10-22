package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.g;
import com.bytedance.android.live.liveinteract.plantform.core.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.f50;
import com.bytedance.android.livesdk.config.x8;
import com.bytedance.android.livesdk.ktvimpl.base.m;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uf2.z;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements ld2.b {
    public float a;
    public float b;
    public final Map<String, Integer> c;
    public boolean d;
    public int e;
    public final b f;
    public final j1 g;

    public static final class a {
    }

    public static final class b implements k {
        public final /* synthetic */ d a;

        public final void D1(String r1, ByteBuffer r2, int r3) {
        }

        public final void G9(long r1, Exception r3) {
        }

        public final void J(String[] r1, boolean[] r2, int[] r3) {
        }

        public final void L(String r1) {
        }

        public final void L0(String r1, TextureView r2, int r3, int r4) {
        }

        public final void Lb() {
        }

        public final void M1() {
        }

        public final void R(long r1, Exception r3) {
        }

        public final void S(String r1, int r2, int r3) {
        }

        public final void T6(String r1, s0 r2) {
        }

        public final void V4(String r1, z.a r2) {
        }

        public final void Xi(int r1, int r2) {
        }

        public final void al(String r1, int r2) {
        }

        public final void b4(String r1, z.a r2, int r3, int r4) {
        }

        public final void ci() {
        }

        public final void e1(String r1, long r2) {
        }

        public final void f0(long r1, Exception r3) {
        }

        public final void f1(long r1, long r3) {
        }

        public final void f4() {
        }

        public final void h1(String r1, SurfaceView r2, int r3, int r4) {
        }

        public final void h6(int r1) {
        }

        public final void ip(Object r1) {
        }

        public final void j0(String r1, TextureView r2, int r3, int r4) {
        }

        public final void k1() {
        }

        public final void o() {
        }

        public final void o0(long r1) {
        }

        public final void p2(fi6.a r1) {
        }

        public final void wf(String r1) {
        }

        public final void wk(String r1) {
        }

        public final void y0(String r1, SurfaceView r2, int r3, int r4) {
        }

        public final void z7() {
        }

        public b(d r1) {
            this.a = r1;
        }

        public final void onUserJoined(String r2) {
            Intrinsics.checkNotNullParameter(r2, "s");
            Intrinsics.checkNotNullParameter(r2, "s");
        }

        public final void A(String r1, Boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "interactId");
            Intrinsics.checkNotNullParameter(r1, "interactId");
        }

        public final void J3(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "message");
            g.a(r2, r3);
        }

        public final void S1(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r3, "interactId");
            g.c(r2, r3);
        }

        public final void Z4(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "interactId");
            Intrinsics.checkNotNullParameter(r1, "interactId");
        }

        public final void d5(dg2.e r2, dg2.e[] r3) {
            Intrinsics.checkNotNullParameter(r2, "localQuality");
            Intrinsics.checkNotNullParameter(r3, "remoteQualities");
            g.d(r2, r3);
        }

        public final void g(String r6, Boolean r7) {
            Intrinsics.checkNotNullParameter(r6, "interactId");
            d r0 = this.a;
            if (r0.d == true) goto L6;
            return;
        L6:
            if (r6.length() != 0) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == true) goto L31;
            if (r7 != null) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r7, Boolean.TRUE) == true) goto L35;
            Integer r8 = (Integer) ((LinkedHashMap) r0.c).get(r6);
            if (r8 == null) goto L17;
            int r9 = r8.intValue();
        L18:
            ALogger.i("ConcertVolumeController", "updatePlaybackVolumeWhenPushStreamChanged, volume: " + r9 + ", currentVolume: " + r0.e);
            cg6.a r2 = r0.k();
            if (r2 == null) goto L28;
            hg6.g r3 = r2.getRtcManager();
            if (r3 == null) goto L28;
            ei6.a r4 = r3.V0();
            if (r4 == null) goto L28;
            ri6.b r5 = r4.r();
            if (r5 == null) goto L28;
            r5.D(bj6.a.b(r4), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r6, r9);
        L28:
            if (StringsKt.startsWith$default(r6, "linkmic_robot", false, 2, null) != true) goto L33;
            int r10 = xe2.a.a;
            float r11 = r9;
            xe2.a.h(r6, r11, r11 / KtvSettingHelper.d().e(), "remote user join rtc");
            return;
        L33:
            return;
        L17:
            r9 = r0.e;
            goto L18
        L35:
            return;
        L31:
            return;
        L8:
            r1 = false;
            goto L9
        }

        public final void n2(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r3, "interactId");
            g.b(r2, r3);
        }

        public final void Hf(int r1, String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "deviceId");
            Intrinsics.checkNotNullParameter(r2, "deviceId");
        }

        public final void Rj(int r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }

        public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TYPE);
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TYPE);
        }
    }

    static {
    }

    public final int a() {
        if (this.e <= KtvSettingHelper.d().e()) goto L7;
        return KtvSettingHelper.d().e();
    L7:
        return this.e;
    }

    public final cg6.a k() {
        j1 r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public final void j() {
        cg6.a r0 = k();
        if (r0 == null) goto L12;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L13;
        ec6.b r2 = r1.R();
        if (r2 == null) goto L14;
        com.bytedance.android.live.pushstream.d r3 = gc6.b.a(r2);
        if (r3 == null) goto L15;
        r3.u();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final float e() {
        return this.a;
    }

    public final float f() {
        return this.b;
    }

    public final int i() {
        return this.e;
    }

    public d(j1 r3) {
        this.g = r3;
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.f0;
        Float r0 = (Float) r4.getValue();
        if (r0 != null) goto L5;
    L8:
        float r1 = ((Number) r4.getValue()).floatValue();
        float r5 = KtvSettingHelper.d().f();
    L9:
        this.a = r5 * r1;
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.b0;
        Float r2 = (Float) r6.getValue();
        if (r2 != null) goto L12;
    L15:
        float r7 = ((Number) r6.getValue()).floatValue();
        float r8 = KtvSettingHelper.d().d();
    L16:
        this.b = r8 * r7;
        this.c = new LinkedHashMap();
        this.d = true;
        this.e = (int) (KtvSettingHelper.d().e() * KtvSettingHelper.d().b());
        b r9 = new b(this);
        this.f = r9;
        cg6.a r10 = k();
        if (r10 == null) goto L22;
        hg6.g r11 = r10.getRtcManager();
        if (r11 == null) goto L23;
        r11.p(r9);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r2.floatValue() != (-1.0f)) goto L15;
        r8 = KtvSettingHelper.d().a();
        r7 = KtvSettingHelper.d().d();
        goto L16
    L5:
        if (r0.floatValue() != (-1.0f)) goto L8;
        r5 = KtvSettingHelper.d().c();
        r1 = KtvSettingHelper.d().f();
        goto L9
    }

    public final void b(float r4) {
        float r0 = KtvSettingHelper.d().f();
        if (r4 >= 0.0f) goto L5;
        return;
    L5:
        if (r4 > r0) goto L9;
        float r1 = r4 / 100.0f;
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.f0;
        Float r3 = Float.valueOf(r4 / KtvSettingHelper.d().f());
        r2.getClass();
        f.d(r2, r3);
        this.a = r4;
        j();
        w.a("ConcertVolumeController", "updateVoiceVolume " + r1);
        m.a(r1, "ConcertVolumeController#updateVoiceVolume");
        return;
    }

    public final void c(int r6) {
        ALogger.i("ConcertVolumeController", "setDefaultPlaybackVolume, volume: " + r6);
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L8;
        i r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L8;
        List r2 = r1.getOnlineUserList();
        if (r2 == null) goto L8;
    L9:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        String r5 = ((ILinkPlayerInfoBridge) r4.next()).getInteractId();
        if (r5 == null) goto L11;
        r3.add(r5);
        goto L11
    L15:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r3.iterator();
    L17:
        if (r8.hasNext() == false) goto L21;
        Object r9 = r8.next();
        if ((!this.c.containsKey((String) r9)) == false) goto L17;
        r7.add(r9);
        goto L17
    L21:
        Iterator r10 = r7.iterator();
    L23:
        if (r10.hasNext() == false) goto L33;
        String r11 = (String) r10.next();
        cg6.a r12 = k();
        if (r12 == null) goto L23;
        hg6.g r13 = r12.getRtcManager();
        if (r13 == null) goto L23;
        ei6.a r14 = r13.V0();
        if (r14 == null) goto L23;
        ri6.b r15 = r14.r();
        if (r15 == null) goto L23;
        r15.D(bj6.a.b(r14), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r11, r6);
        goto L23
    L33:
        this.e = r6;
        return;
    L8:
        r2 = CollectionsKt.emptyList();
        goto L9
    }

    public final void g(float r5) {
        float r0 = KtvSettingHelper.d().d();
        if (r5 >= 0.0f) goto L5;
        return;
    L5:
        if (r5 > r0) goto L15;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.b0;
        Float r2 = Float.valueOf(r5 / KtvSettingHelper.d().d());
        r1.getClass();
        f.d(r1, r2);
        StringBuilder r3 = new StringBuilder("supportHardWareEcho: ktv_hardware_echo_ab=");
        x8 r4 = x8.a;
        r3.append((Boolean) r4.getValue());
        r3.append(" ;;audioFilterManager?.isSupportHardWareEarMonitor=false");
        j();
        ALogger.e("ConcertVolumeController", r3.toString());
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L9;
        j();
    L9:
        StringBuilder r6 = new StringBuilder("supportSoftWareEcho: setting=");
        f50 r7 = f50.a;
        r6.append(((Boolean) r7.getValue()).booleanValue());
        r6.append(" ;; enable_ktv_software_echo=false");
        j();
        ALogger.e("ConcertVolumeController", r6.toString());
        if (((Boolean) r7.getValue()).booleanValue() == false) goto L12;
        j();
    L12:
        this.b = r5;
        return;
    }

    public final void h(float r3) {
        float r0 = KtvSettingHelper.d().f();
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (r3 > r0) goto L9;
        float r1 = r3 / 100.0f;
        this.a = r3;
        j();
        w.a("ConcertVolumeController", "setVoiceVolume " + r1);
        m.a(r1, "ConcertVolumeController#setVoiceVolume");
        return;
    }

    public final void d(String r3, int r4, LiveWrappedStreamIndex r5) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        Intrinsics.checkNotNullParameter(r5, "streamIndex");
        ALogger.i("ConcertVolumeController", "setRemoteAudioPlaybackVolume, interactId: " + r3 + ", volume: " + r4);
        this.c.put(r3, Integer.valueOf(r4));
        cg6.a r0 = k();
        if (r0 == null) goto L12;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L13;
        ei6.a r2 = r1.V0();
        if (r2 == null) goto L14;
        ri6.b r6 = r2.r();
        if (r6 == null) goto L15;
        r6.D(bj6.a.b(r2), r5, r3, r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
