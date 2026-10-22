package ngc;

import android.os.ConditionVariable;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttve.audio.TEDubWriter;
import com.ss.android.vesdk.VEAudioCapture;
import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.audio.VEAudioCaptureListener;
import com.ss.android.vesdk.audio.VEAudioSample;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements VEAudioCaptureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f519094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VEAudioCapture f519095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConditionVariable f519096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f519097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Cert f519098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f519099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f519100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f519101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f519102i;

    public final synchronized int a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.f519095b == null) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        VEAudioCaptureSettings r100 = new VEAudioCaptureSettings.Builder().setSampleRate(44100).setChannel(2).setAudioCaptureLowLatency(false).build();     // Catch: Throwable -> L12
        VEAudioCapture r101 = new VEAudioCapture();     // Catch: Throwable -> L12
        this.f519095b = r101;     // Catch: Throwable -> L12
        r101.addCaptureListener(this);     // Catch: Throwable -> L12
        int r102 = b(new c(this, r100), "init()");     // Catch: Throwable -> L12
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "call init, sourceId:1 retValue:" + r102);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r102;
    }

    public f(TEDubWriter r100) {
        this.f519096c = new ConditionVariable();
        this.f519097d = 44100;
        this.f519094a = r100;
    }

    public final synchronized void c(Cert r100) {
        monitor-enter(this);
        VEAudioCapture r101 = this.f519095b;     // Catch: Throwable -> L15
        if (r101 == null) goto L6;
        r101.release(r100);     // Catch: Throwable -> L15
        this.f519095b = null;     // Catch: Throwable -> L15
    L6:
        b r102 = this.f519094a;     // Catch: Throwable -> L15
        if (r102 == null) goto L12;
        TEDubWriter r103 = (TEDubWriter) r102;     // Catch: Throwable -> L15
        long r104 = r103.f449826a;     // Catch: Throwable -> L15
        if (r104 == 0) goto L11;
        r103.nativeDestroy(r104);     // Catch: Throwable -> L15
    L11:
        this.f519094a = null;     // Catch: Throwable -> L15
    L12:
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "call unInit() finished!");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener
    public final void onReceive(VEAudioSample r100) {
        if (this.f519094a != null) goto L5;
        return;
    L5:
        if ((r100.getSampleBuffer() instanceof VEAudioSample.b) == false) goto L8;
        byte[] r101 = ((VEAudioSample.b) r100.getSampleBuffer()).f455733a.array();
    L11:
        if (r101 == null) goto L16;
        b r102 = this.f519094a;
        int r103 = r100.getByteSize();
        TEDubWriter r104 = (TEDubWriter) r102;
        long r105 = r104.f449826a;
        if (r105 == 0) goto L20;
        r104.nativeAddPCMData(r105, r101, r103);
        r104.f449827b = r104.nativeGetCurrentTime(r104.f449826a);
        return;
    L20:
        return;
    L16:
        VELogUtil.e("TEBufferedAudioCaptureRecorder", "sample buffer is empty!");
        return;
    L8:
        if ((r100.getSampleBuffer() instanceof VEAudioSample.a) == false) goto L10;
        r101 = ((VEAudioSample.a) r100.getSampleBuffer()).f455732a;
        goto L11
    L10:
        r101 = null;
        goto L11
    }

    public final int b(Callable r100, String r101) {
        this.f519096c.close();
        Integer r102 = (Integer) r100.call();     // Catch: Exception -> L13
        if (r102.intValue() != 0) goto L16;
        if (this.f519096c.block(2000) == false) goto L8;
        int r103 = 0;
    L9:
        r102 = Integer.valueOf(r103);     // Catch: Exception -> L13
        if (r102.intValue() != (-1)) goto L16;
        VELogUtil.e("TEBufferedAudioCaptureRecorder", r101.concat(" timeout ! timeoutMs:2000"));     // Catch: Exception -> L13
        goto L16
    L8:
        r103 = -1;
    L16:
        return r102.intValue();
    L13:
        e = move-exception;
        e.printStackTrace();
        r102 = -1;
        goto L16
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener, com.ss.android.vesdk.audio.i
    public final void onError(int r100, int r101, String r102) {
        VELogUtil.e("TEBufferedAudioCaptureRecorder", "errorType:" + r100 + " ret:" + r101 + " msg:" + r102);
        this.f519096c.open();
    }

    @Override // com.ss.android.vesdk.audio.VEAudioCaptureListener, com.ss.android.vesdk.audio.i
    public final void onInfo(int r110, int r111, double r112, Object r113) {
        if (r110 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT) goto L8;
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "oninfo TE_INFO_RECORD_AUDIO_CAPTURE_INIT");
        if (r113 == null) goto L27;
        this.f519097d = ((VEAudioCaptureSettings) r113).getSampleRate();
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "oninfo TE_INFO_RECORD_AUDIO_CAPTURE_INIT samplerate:" + this.f519097d);
    L27:
        this.f519096c.open();
        return;
    L8:
        if (r110 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_START) goto L19;
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "oninfo TE_INFO_RECORD_AUDIO_CAPTURE_START");
        b r114 = this.f519094a;
        if (r114 == null) goto L17;
        String r100 = this.f519099f;
        int r101 = this.f519097d;
        double r102 = this.f519100g;
        int r103 = this.f519101h;
        int r104 = this.f519102i;
        TEDubWriter r105 = (TEDubWriter) r114;
        long r106 = r105.f449826a;
        if (r106 != 0) goto L14;
        int r115 = -112;
    L15:
        if (r115 == 0) goto L27;
        VELogUtil.e("TEBufferedAudioCaptureRecorder", "init wav file failed, ret = " + r115);
        goto L27
    L14:
        r115 = r105.nativeInitWavFile(r106, r100, r101, 2, r102, r103, r104);
        goto L15
    L17:
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "oninfo TE_INFO_RECORD_AUDIO_CAPTURE_START, audioWritter is null !");
        goto L27
    L19:
        if (r110 != VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_STOP) goto L26;
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "oninfo TE_INFO_RECORD_AUDIO_CAPTURE_STOP");
        b r116 = this.f519094a;
        if (r116 == null) goto L27;
        TEDubWriter r117 = (TEDubWriter) r116;
        long r118 = r117.f449826a;
        if (r118 == 0) goto L27;
        r117.nativeCloseWavFile(r118);
        goto L27
    L26:
        VELogUtil.i("TEBufferedAudioCaptureRecorder", "oninfo other type : " + r110);
        goto L27
    }
}
