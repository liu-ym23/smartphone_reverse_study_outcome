package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.z;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements com.bytedance.android.live.liveinteract.plantform.core.k {
    public final /* synthetic */ c a;

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

    public d(c r1) {
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

    public final void J3(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r6, "message");
        c r7 = this.a;
        r7.getClass();
        if (r6.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L19;
        JSONObject r2 = new JSONObject(r6).optJSONObject("ktv_chorus_midi");     // Catch: Exception -> L14
        if (r2 == null) goto L17;
        ALogger.d("RTChorusMidiRtsManager", "handleMidiMessage: ".concat(r6));     // Catch: Exception -> L14
        r7.d(r2.optString("userId", ""), (float) r2.optDouble("midi", 0.0d));     // Catch: Exception -> L14
        if (((Boolean) KtvSettingHelper.j1.getValue()).booleanValue() == false) goto L18;
        r7.b();     // Catch: Exception -> L14
        return;
    L18:
        return;
    L17:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public final void d5(dg2.e r2, dg2.e[] r3) {
        Intrinsics.checkNotNullParameter(r2, "localQuality");
        Intrinsics.checkNotNullParameter(r3, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r2, r3);
    }

    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
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

    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TYPE);
    }
}
