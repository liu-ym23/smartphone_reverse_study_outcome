package com.bytedance.navigation.kmp.capability.sensor;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements com.bytedance.navigation.kmp.listener.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FallbackDeviceHeadingSensor f265825a;

    public g(FallbackDeviceHeadingSensor r100) {
        this.f265825a = r100;
    }

    @Override // com.bytedance.navigation.kmp.listener.b
    public final void a(float r110, float r111, boolean r210) {
        FallbackDeviceHeadingSensor.State r100 = this.f265825a.f265790h;
        if (r100 != FallbackDeviceHeadingSensor.State.BOOTSTRAP_ROTV) goto L5;
    L7:
        d37.e r101 = this.f265825a.f265795m;
        r101.getClass();
        double r102 = -r110;
    L9:
        if (r102 <= 180.0d) goto L12;
        r102 = r102 - 360.0d;
    L12:
        if (r102 >= (-180.0d)) goto L15;
        r102 = r102 + 360.0d;
        goto L12
    L15:
        if (r101.f466743a == true) goto L17;
        r101.f466744b = r102;
        r101.f466743a = true;
        float r103 = r110;
    L48:
        float r104 = (((360.0f - r103) % 360.0f) + 360.0f) % 360.0f;
        com.bytedance.navigation.kmp.listener.b r105 = this.f265825a.f265791i;
        if (r105 == null) goto L62;
        r105.a(r103, r104, r210);
        return;
    L62:
        return;
    L17:
        double r106 = r102 - r101.f466744b;
    L19:
        if (r106 <= 180.0d) goto L22;
        r106 = r106 - 360.0d;
    L22:
        if (r106 >= (-180.0d)) goto L25;
        r106 = r106 + 360.0d;
        goto L22
    L25:
        if (Math.abs(r106) >= 0.3d) goto L33;
        double r107 = -r101.f466744b;
    L28:
        if (r107 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        r107 = r107 + 360.0d;
    L31:
        if (r107 < 360.0d) goto L47;
        r107 = r107 - 360.0d;
    L47:
        r103 = (float) r107;
        goto L48
    L33:
        double r112 = r101.f466744b + (r106 * 0.35d);
    L35:
        if (r112 <= 180.0d) goto L38;
        r112 = r112 - 360.0d;
    L38:
        if (r112 >= (-180.0d)) goto L40;
        r112 = r112 + 360.0d;
        goto L38
    L40:
        r101.f466744b = r112;
        r107 = -r112;
    L42:
        if (r107 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
        r107 = r107 + 360.0d;
    L45:
        if (r107 < 360.0d) goto L47;
        r107 = r107 - 360.0d;
        goto L45
    L5:
        if (r100 == FallbackDeviceHeadingSensor.State.DEGRADED_ROTV) goto L7;
    }
}
