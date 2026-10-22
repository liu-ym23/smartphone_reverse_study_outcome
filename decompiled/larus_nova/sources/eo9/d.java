package eo9;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc.RecordingRtcOperation;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.utils.AudioFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements nub.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f473398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f473399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f473400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f473401d;

    public d(c r100) {
        this.f473401d = r100;
    }

    public final void a(int r100) {
        if (r100 != 0) goto L4;
        this.f473400c = null;
        return;
    L4:
        if (r100 == 0) goto L13;
        Integer r101 = this.f473400c;
        if (r101 != null) goto L9;
    L10:
        this.f473400c = Integer.valueOf(r100);
        this.f473401d.h2(RecordingRtcOperation.EXTERNAL_PUSH, r100, "return_code");
        return;
    L9:
        if (r101.intValue() != r100) goto L10;
        return;
    }

    @Override // nub.a
    public final void h(sub.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
    }

    @Override // nub.a
    public final void i(byte[] r100, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        if (this.f473401d.f473386r == false) goto L6;
        a(-10001);
        return;
    L6:
        RTCEngine r101 = this.f473401d.f473370b;
        if (r101 != null) goto L10;
        a(-10002);
        return;
    L10:
        AudioSampleRate r102 = AudioSampleRate.fromId(r111);
        if (r102 != null) goto L13;
        r102 = AudioSampleRate.AUDIO_SAMPLE_RATE_16000;
    L13:
        AudioChannel r103 = AudioChannel.fromId(r112);
        if (r103 != null) goto L16;
        r103 = AudioChannel.AUDIO_CHANNEL_MONO;
    L16:
        int r104 = r101.pushExternalAudioFrame(new AudioFrame(r100, r110, r102, r103));
        a(r104);
        long r105 = System.currentTimeMillis();
        if ((r105 - this.f473398a) < 3000) goto L19;
        int r106 = this.f473399b;
        this.f473399b = 0;
        this.f473398a = r105;
        FLogger.f375446a.i("OfficeSDKRtcServiceImpl", "pushExternalAudioFrame samples=" + r110 + " sampleRate=" + r111 + " channel=" + r112 + " bufferSize=" + r100.length + " result=" + r104 + " suppressed=" + r106);
        return;
    L19:
        this.f473399b++;
    }
}
