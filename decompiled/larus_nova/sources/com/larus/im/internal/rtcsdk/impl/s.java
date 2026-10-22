package com.larus.im.internal.rtcsdk.impl;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioRenderType;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.data.AudioSourceType;
import com.ss.bytertc.engine.type.AudioCodecType;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class s implements ff9.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1 f349984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f349985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f349986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public df9.f f349987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public df9.a f349988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ff9.c f349989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ff9.b f349990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f349991h;

    public static final class a {
    }

    static {
    }

    @Override // ff9.r
    public final void f() {
        this.f349991h = false;
        RTCEngine r100 = this.f349984a.a(false);
        if (r100 == null) goto L5;
        r100.stopAudioCapture();
    L5:
        fe9.h.f476628a.e("FlowRTCAudioServiceImpl", "[stopAudioCapture] stop audio capture");
    }

    @Override // ff9.r
    public final void K() {
        if (this.f349988e != null) goto L6;
        fe9.h.f476628a.b("FlowRTCAudioServiceImpl", "call setCaptureConfig first");
        return;
    L6:
        this.f349991h = true;
        RTCEngine r100 = this.f349984a.a(true);
        if (r100 == null) goto L10;
        int r101 = r100.startAudioCapture();
        fe9.h.f476628a.e("FlowRTCAudioServiceImpl", "startAudioCapture ret: " + r101);
        return;
    }

    public final ff9.y a() {
        df9.a r100 = this.f349988e;
        if (r100 != null) goto L5;
    L8:
        if (r100 != null) goto L10;
        String r101 = "call setCaptureConfig first";
    L11:
        fe9.a.f476620a.b("FlowRTCAudioServiceImpl", r101);
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L16;
        ff9.f r102 = ff9.f.f476689a;
        return ff9.f.f476689a;
    L16:
        throw new IllegalStateException(r101);
    L10:
        r101 = "only internal capture can call getFrameProcessControl";
        goto L11
    L5:
        if ((r100 instanceof df9.d) == false) goto L8;
        return ((df9.d) r100).f468324e;
    }

    public final ff9.p b() {
        df9.f r100 = this.f349987d;
        if (r100 != null) goto L5;
    L8:
        if (r100 != null) goto L10;
        String r101 = "call setPlayConfig first";
    L11:
        fe9.a.f476620a.b("FlowRTCAudioServiceImpl", r101);
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L16;
        ff9.d r102 = ff9.d.f476687a;
        return ff9.d.f476687a;
    L16:
        throw new IllegalStateException(r101);
    L10:
        r101 = "only external play can call getExternalPlayObservable";
        goto L11
    L5:
        if ((r100 instanceof df9.c) == false) goto L8;
        return ((df9.c) r100).f468319c;
    }

    public final ff9.x c() {
        df9.f r100 = this.f349987d;
        if (r100 != null) goto L5;
    L8:
        if (r100 != null) goto L10;
        String r101 = "call setPlayConfig first";
    L11:
        fe9.a.f476620a.b("FlowRTCAudioServiceImpl", r101);
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L16;
        ff9.e r102 = ff9.e.f476688a;
        return ff9.e.f476688a;
    L16:
        throw new IllegalStateException(r101);
    L10:
        r101 = "only internal play can call getFrameProcessControl";
        goto L11
    L5:
        if ((r100 instanceof df9.e) == false) goto L8;
        return ((df9.e) r100).f468329d;
    }

    public final void d() {
        RTCEngine r100 = this.f349984a.a(false);
        if (r100 == null) goto L5;
        r100.setAudioSourceType(AudioSourceType.AUDIO_SOURCE_TYPE_EXTERNAL);
        r100.setAudioRenderType(AudioRenderType.AUDIO_RENDER_TYPE_INTERNAL);
        ef9.a.c(r100);
    L5:
        df9.f r101 = this.f349987d;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        this.f349987d = null;
        df9.a r102 = this.f349988e;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        this.f349988e = null;
        this.f349989f = null;
        this.f349990g = null;
        this.f349991h = false;
    }

    public final void e() {
        RTCEngine r100 = this.f349984a.a(true);
        if (r100 == null) goto L17;
        int r101 = ef9.a.f472593a;
        Intrinsics.checkNotNullParameter(r100, "engine");
        if (ef9.a.e() == true) goto L7;
        return;
    L7:
        if (ef9.a.d() == false) goto L19;
        String[] r102 = new String[4];
        String r103 = null;
        File r104 = com.larus.im.internal.delegate.c.f348197a.getApplication().getExternalFilesDir(null);
        if (r104 == null) goto L12;
        r103 = r104.getAbsolutePath();
    L12:
        r102[0] = r103;
        r102[1] = "audio";
        r102[2] = com.larus.im.internal.utils.x.f350564b;
        r102[3] = "rtc-dump";
        List r105 = CollectionsKt.listOfNotNull(r102);
        String r106 = File.separator;
        String r107 = CollectionsKt.joinToString$default(r105, r106, null, r106, 0, null, null, 58, null);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107);
        if (r108.exists() == true) goto L15;
        r108.mkdirs();
    L15:
        r100.setRuntimeParameters(ef9.a.a(true, r107));
        r100.setRuntimeParameters(ef9.a.b(true));
        fe9.c.f476624a.a("RTCDumpUtils", "enable rtc dump success");
        return;
    L19:
        return;
    }

    public s(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "engineProvider");
        this.f349984a = r100;
        this.f349985b = LazyKt.lazy(new q());
        this.f349986c = LazyKt.lazy(new r());
    }

    public final int g(ff9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        AudioSampleRate r101 = AudioSampleRate.fromId(r100.f476692c);
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "sampleRate");
        AudioFrame r102 = new AudioFrame(r100.f476690a, r101.value() / 100, r101, AudioChannel.fromId(r100.f476691b), r100.f476693d);
        RTCEngine r103 = this.f349984a.a(true);
        if (r103 == null) goto L5;
        int r104 = r103.pushExternalAudioFrame(r102);
    L6:
        if (r104 >= 0) goto L8;
        fe9.h.f476628a.b("FlowRTCAudioServiceImpl", "[sendAudioFrame] push audio frame failed, error code: " + r104 + '.');
    L8:
        return r104;
    L5:
        r104 = -1;
        goto L6
    }

    public final int h(ff9.h r110) {
        Intrinsics.checkNotNullParameter(r110, "frame");
        Long r100 = r110.f476698e;
        if (r100 == null) goto L7;
        if (r100.longValue() < 0) goto L7;
    L8:
        AudioCodecType r101 = AudioCodecType.OPUS;
        ByteBuffer r102 = com.flow.kmp.common.util.b.g(r110.f476694a);
        int r103 = r110.f476694a.length;
        if (r100 == null) goto L11;
        long r104 = r100.longValue();
    L12:
        AudioSampleRate r105 = AudioSampleRate.fromId(r110.f476696c);
        AudioChannel r111 = AudioChannel.fromId(r110.f476695b);
        int r112 = r110.f476699f;
        byte[] r106 = r110.f476697d;
        if (r106 == null) goto L19;
        if (r112 <= 0) goto L19;
        int r107 = r112 / 10;
        StringBuilder r108 = new StringBuilder();
        r108.append(r106.length);
        r108.append(' ');
        byte[] r109 = r108.toString().getBytes(Charsets.UTF_8);
        byte[] r113 = new byte[(r109.length + r106.length) * r107];
        int r114 = 0;
        int r115 = 0;
    L17:
        if (r114 >= r107) goto L20;
        System.arraycopy(r109, 0, r113, r115, r109.length);
        int r116 = r115 + r109.length;
        System.arraycopy(r106, 0, r113, r116, r106.length);
        r115 = r116 + r106.length;
        r114 = r114 + 1;
        r107 = r107;
    L20:
        EncodedAudioFrameData r117 = new EncodedAudioFrameData(r101, r102, r103, r104, r105, r111, r112, com.flow.kmp.common.util.b.g(r113));
        RTCEngine r118 = this.f349984a.a(true);
        if (r118 == null) goto L23;
        int r119 = r118.pushExternalEncodedAudioFrame(r117);
    L24:
        if (r119 >= 0) goto L26;
        fe9.h.f476628a.b("FlowRTCAudioServiceImpl", "[sendEncodedAudioFrame] push audio frame failed, error code: " + r119 + '.');
    L26:
        return r119;
    L23:
        r119 = -1;
    L19:
        r113 = null;
        goto L20
    L11:
        r104 = -1;
    L7:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L8;
        throw new IllegalStateException("timestamp must be greater than 0");
    }

    public final void i(boolean r100) {
        RTCEngine r101 = this.f349984a.a(true);
        if (r101 == null) goto L6;
        JSONObject r102 = new JSONObject();
        r102.put("rtc.bluetooth_force_to_media", r100);
        int r103 = r101.setRuntimeParameters(r102);
        fe9.h.f476628a.e("FlowRTCAudioServiceImpl", "setBluetoothForceToMedia ret: " + r103 + ", enable: " + r100);
        return;
    }

    public final void j(ff9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f349990g = r100;
        fe9.h.f476628a.e("FlowRTCAudioServiceImpl", "[setCaptureConfig] start register config(" + r100 + ')');
        RTCEngine r101 = this.f349984a.a(true);
        if (r101 != null) goto L6;
        fe9.a.f476620a.b("FlowRTCAudioServiceImpl", "[setCaptureConfig] rtcEngine is null, skip");
        return;
    L6:
        r101.setAudioSourceType(r100.f476672a);
        df9.a r102 = this.f349988e;
        if (r102 == null) goto L9;
        r102.d(r100);
    L9:
        if (r102 == null) goto L12;
        r102.a();
    L12:
        if (r100.f476672a != AudioSourceType.AUDIO_SOURCE_TYPE_INTERNAL) goto L14;
        df9.a r103 = new df9.d(r100.f476677f, r101, (f) this.f349986c.getValue());
    L15:
        this.f349988e = r103;
        r103.b(r100);
        return;
    L14:
        r103 = new df9.b(r101);
        goto L15
    }

    public final void k(ff9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f349989f = r100;
        fe9.h.f476628a.e("FlowRTCAudioServiceImpl", "[setPlayConfig] start register config(" + r100 + ')');
        RTCEngine r101 = this.f349984a.a(true);
        if (r101 != null) goto L6;
        fe9.a.f476620a.b("FlowRTCAudioServiceImpl", "[setPlayConfig] rtcEngine is null, skip");
        return;
    L6:
        r101.setAudioRenderType(r100.f476683a);
        df9.f r102 = this.f349987d;
        if (r102 != null) goto L9;
    L11:
        if (r102 == null) goto L14;
        r102.a();
    L14:
        if (r100.f476683a != AudioRenderType.AUDIO_RENDER_TYPE_INTERNAL) goto L16;
        df9.f r103 = new df9.e(r100.f476686d, r101, (f) this.f349986c.getValue(), (d) this.f349985b.getValue());
    L17:
        this.f349987d = r103;
        r103.b(r100);
        return;
    L16:
        r103 = new df9.c(r100.f476686d, r101, (d) this.f349985b.getValue());
        goto L17
    L9:
        if (r102.c(r100) == false) goto L11;
        r102.b(r100);
    }

    @Override // ff9.r
    public final void setVolume(float r100) {
        RTCEngine r101 = this.f349984a.a(true);
        if (r101 == null) goto L6;
        r101.setPlaybackVolume((int) r100);
        return;
    }
}
