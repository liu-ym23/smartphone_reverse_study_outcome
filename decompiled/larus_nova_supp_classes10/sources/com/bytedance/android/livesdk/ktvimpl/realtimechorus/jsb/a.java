package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.core.k;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.zl0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import dg2.e;
import hg6.g;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;
import ui6.d;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final b a;
    public final DataCenter b;
    public final String c;
    public final j1 d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a$a, reason: collision with other inner class name */
    public static final class C0048a {
    }

    public static final class b implements k {
        public final /* synthetic */ a a;

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

        public final void Xi(int r1, int r2) {
        }

        public final void al(String r1, int r2) {
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

        public final void k1() {
            j1 r0 = this.a.d;
            if (r0 == null) goto L15;
            cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r1 == null) goto L15;
            g r2 = r1.getRtcManager();
            if (r2 == null) goto L15;
            ei6.a r3 = r2.V0();
            if (r3 == null) goto L15;
            d r4 = r3.l();
            if (r4 == null) goto L15;
            mi6.a r5 = r4.b();
            if (r5 == null) goto L15;
            r5.v();
        L15:
            JsonObject r6 = new JsonObject();
            r6.addProperty("sub_type", "chorus");
            r6.addProperty("ntp_time", 0L);
            r6.addProperty("current_time", Long.valueOf(System.currentTimeMillis()));
            this.a.c("onNtpTimeSynchronizationCompleted", r6);
            ALogger.i("ChorusJsbService", "onNtpTimeSynchronizationCompleted, ntp: 0");
        }

        public b(a r1) {
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
            com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
        }

        public final void S1(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r3, "interactId");
            com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
        }

        public final void V4(String r3, z.a r4) {
            if (((Boolean) zl0.a.getValue()).booleanValue() == true) goto L5;
            return;
        L5:
            ALogger.i("ChorusJsbService", "onFirstRemoteVideoFrameRender, linkId: " + r3);
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("linkId", r3);
            this.a.c("onFirstRemoteVideoFrameDecode", r5);
            xe2.a.b(r3);
        }

        public final void Z4(String r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "interactId");
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("audio_device_loop_delay", Integer.valueOf(r4));
            this.a.c("onAudioDeviceLoopDelayUpdate", r5);
        }

        public final void d5(e r3, e[] r4) {
            Intrinsics.checkNotNullParameter(r3, "localQuality");
            Intrinsics.checkNotNullParameter(r4, "remoteQualities");
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("rtt", 0);
            r5.addProperty("fraction_lost", Double.valueOf(0.0d));
            r5.addProperty("tx_quality", 0);
            this.a.c("onNetworkQuality", r5);
        }

        public final void g(String r5, Boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "interactId");
            if (r5.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L15;
            if (r6 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r5, KtvSettingHelper.p().getAccompanimentRobotPrefix() + je0.d.a()) == false) goto L17;
            JsonObject r2 = new JsonObject();
            r2.addProperty("sub_type", "chorus");
            r2.addProperty("interactId", r5);
            r2.addProperty("mute", r6);
            ALogger.i("ChorusJsbService", "onRemoteAudioMute, interactId: " + r5 + ", mute: " + r6);
            this.a.c("onUserPublishStreamAudio", r2);
            return;
        L17:
            return;
        L15:
            return;
        L5:
            r1 = false;
            goto L6
        }

        public final void n2(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r3, "interactId");
            com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
        }

        public final void Hf(int r1, String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "deviceId");
            Intrinsics.checkNotNullParameter(r2, "deviceId");
        }

        public final void Rj(int r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }

        public final void x1(LiveWrappedNetworkDetectionLinkType r3, int r4, double r5) {
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
            JsonObject r6 = new JsonObject();
            r6.addProperty("sub_type", "chorus");
            r6.addProperty("rtt", Integer.valueOf(r4));
            r6.addProperty("fraction_lost", Double.valueOf(r5));
            this.a.c("onNetworkDetectionResult", r6);
        }

        public final void b4(String r1, z.a r2, int r3, int r4) {
            ALogger.i("ChorusJsbService", "onFirstRemoteVideoFrame, linkId: " + r1);
            if (((Boolean) zl0.a.getValue()).booleanValue() == false) goto L5;
            return;
        L5:
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("linkId", r1);
            this.a.c("onFirstRemoteVideoFrameDecode", r5);
            xe2.a.b(r1);
        }
    }

    static {
    }

    public final void a() {
        j1 r0 = this.d;
        if (r0 == null) goto L5;
        cg6.a r1 = (cg6.a) r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r1 == null) goto L11;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L12;
        r2.Z(this.a);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void b(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        ALogger.i("ChorusJsbService", "onCheckPerMissionResult, result: " + r4);
        JsonObject r0 = new JsonObject();
        r0.addProperty("sub_type", "chorus");
        r0.addProperty("Success", Boolean.valueOf(r4));
        c("onCheckPermissionFinished", r0);
        xe2.a.a(r4, r5);
    }

    public final void c(String r4, JsonObject r5) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L8;
        ih0.b r1 = r0.dynamicService(this.b);
        if (r1 == null) goto L9;
        r1.Dk(this.c, r4, r5, true);
        return;
    L9:
        return;
    }

    public a(DataCenter r2, String r3, j1 r4) {
        Intrinsics.checkNotNullParameter(r3, "businessId");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        b r5 = new b(this);
        this.a = r5;
        if (r4 == null) goto L5;
        cg6.a r6 = (cg6.a) r4.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r6 == null) goto L11;
        g r7 = r6.getRtcManager();
        if (r7 == null) goto L12;
        r7.p(r5);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
