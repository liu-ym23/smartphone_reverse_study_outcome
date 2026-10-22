package com.ss.android.vesdk;

import androidx.camera.video.AudioStats;
import com.ss.android.ttve.model.VEAudioDeviceType;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.audio.VEAudioCaptureListener;
import com.ss.android.vesdk.audio.VEAudioDevice;
import com.ss.android.vesdk.audio.VEAudioSample;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioCapture implements com.ss.android.vesdk.audio.a {
    private static final String TAG = "VEAudioCapture";
    private com.ss.android.vesdk.audio.f audioRecord;
    private com.ss.android.vesdk.audio.c mAudioDeviceListener;
    b<com.ss.android.vesdk.audio.i> mCaptureListeners;

    public class a implements com.ss.android.vesdk.audio.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEAudioCapture f455510a;

        public a(VEAudioCapture r100) {
            this.f455510a = r100;
        }

        @Override // com.ss.android.vesdk.audio.d
        public final void onReceive(VEAudioSample r100) {
            Iterator<com.ss.android.vesdk.audio.i> r101 = this.f455510a.mCaptureListeners.c().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            com.ss.android.vesdk.audio.i r102 = r101.next();
            if (r102 == null) goto L7;
            if ((r102 instanceof VEAudioCaptureListener) == false) goto L4;
            ((VEAudioCaptureListener) r102).onReceive(r100);
            goto L4
        L7:
            VELogUtil.e(VEAudioCapture.TAG, "onReceive error listener is null");
            goto L4
        }

        @Override // com.ss.android.vesdk.audio.d
        public final void a(int r110, int r111, Object r112) {
            Iterator<com.ss.android.vesdk.audio.i> r100 = this.f455510a.mCaptureListeners.c().iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            com.ss.android.vesdk.audio.i r101 = r100.next();
            if (r101 == null) goto L7;
            r101.onInfo(r110, r111, AudioStats.AUDIO_AMPLITUDE_NONE, r112);
            goto L4
        L7:
            VELogUtil.e(VEAudioCapture.TAG, "onInfo error listener is null");
            goto L4
        }

        @Override // com.ss.android.vesdk.audio.d
        public final void onError(int r100, int r101, String r102) {
            Iterator<com.ss.android.vesdk.audio.i> r103 = this.f455510a.mCaptureListeners.c().iterator();
        L4:
            if (r103.hasNext() == false) goto L9;
            com.ss.android.vesdk.audio.i r104 = r103.next();
            if (r104 == null) goto L7;
            r104.onError(r100, r101, r102);
            goto L4
        L7:
            VELogUtil.e(VEAudioCapture.TAG, "onError error listener is null");
            goto L4
        }
    }

    public static boolean isSupportEarBack(VEAudioDevice r100) {
        return false;
    }

    public void release() {
        release(null);
    }

    public int start() {
        return start(null);
    }

    public int stop() {
        return stop(null);
    }

    public void clean() {
        this.mCaptureListeners.b();
    }

    public int getMicState() {
        return this.audioRecord.f455735a;
    }

    public void onBackGround() {
        this.audioRecord.f455736b = true;
    }

    public void onForeGround() {
        this.audioRecord.f455736b = false;
    }

    public VEAudioCapture() {
        this.mCaptureListeners = new b();
        this.mAudioDeviceListener = null;
        com.ss.android.vesdk.audio.f r100 = new com.ss.android.vesdk.audio.f();
        this.audioRecord = r100;
        r100.f455741g = new a(this);
    }

    public boolean addCaptureListener(VEAudioCaptureListener r100) {
        if (r100 != null) goto L5;
        VELogUtil.e(TAG, "addCaptureListener error listener is null!!!");
        return false;
    L5:
        this.audioRecord.f455739e = r100;
        return this.mCaptureListeners.a(r100);
    }

    public boolean addStateListener(com.ss.android.vesdk.audio.i r100) {
        if (r100 != null) goto L5;
        VELogUtil.e(TAG, "addStateListener error listener is null!!!");
        return false;
    L5:
        this.audioRecord.f455739e = r100;
        return this.mCaptureListeners.a(r100);
    }

    @Override // com.ss.android.vesdk.audio.a
    public int init(VEAudioCaptureSettings r100) {
        VEAudioCaptureSettings r101 = new VEAudioCaptureSettings.Builder(r100).setAudioSource(VEConfigCenter.getInstance().getValue("ve_audio_source_type", 1)).build();
        this.audioRecord.init(r101);
        return 0;
    }

    @Override // com.ss.android.vesdk.audio.a
    public void release(Object r100) {
        this.audioRecord.release(r100);
    }

    public boolean removeCaptureListener(VEAudioCaptureListener r100) {
        return this.mCaptureListeners.e(r100);
    }

    public boolean removeStateListener(com.ss.android.vesdk.audio.i r100) {
        return this.mCaptureListeners.e(r100);
    }

    public void setAudioDevice(VEAudioDevice r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.audioRecord.f455751q = r100;
        com.ss.android.vesdk.audio.c r101 = this.mAudioDeviceListener;
        if (r101 == null) goto L12;
        VEAudioDeviceType r102 = r100.getType();
        g0 r103 = ((TERecorder.y) r101).f455470a.f455335a;
        if (r102 != VEAudioDeviceType.DEFAULT) goto L9;
        boolean r104 = true;
    L10:
        r103.getClass();
        TEBundle r105 = TEBundle.obtain();
        r105.setBool("DefaultAudioDevice", r104);
        r105.setInt("effectInterfaceName", 47);
        r103.f455589a.callEffectInterface(r105);
        return;
    L9:
        r104 = false;
        goto L10
    }

    public void setAudioDeviceChangeListener(com.ss.android.vesdk.audio.c r100) {
        this.mAudioDeviceListener = r100;
    }

    @Override // com.ss.android.vesdk.audio.a
    public int start(Object r100) {
        return this.audioRecord.start(r100);
    }

    @Override // com.ss.android.vesdk.audio.a
    public int stop(Object r100) {
        return this.audioRecord.stop(r100);
    }
}
