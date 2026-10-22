package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenAudioCaptureAndroidManager extends MediaProjection.Callback {
    private static final int NUM_SAMPLES_PER_READ = 1024;
    private static final int SAMPLE_RATE = 48000;
    private int mAudioMode;
    private AudioRecord mAudioRecord;
    private ScreenAudioCaptureObserver mCaptureObserver;
    private WeakReference<Context> mContextRef;
    private boolean mIsDisposed;
    private volatile boolean mIsRecording;
    private MediaProjection mMediaProjection;
    private Thread mRecordingThread;
    private Handler sHandler;
    private HandlerThread sHandlerThread;

    /* JADX INFO: renamed from: com.ss.bytertc.base.media.screen.ScreenAudioCaptureAndroidManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class HOLDER {
        private static final ScreenAudioCaptureAndroidManager INSTANCE = null;

        private HOLDER() {
        }

        static {
            INSTANCE = new ScreenAudioCaptureAndroidManager(null);
        }

        public static /* synthetic */ ScreenAudioCaptureAndroidManager access$100() {
            return INSTANCE;
        }
    }

    public static /* synthetic */ void a(ScreenAudioCaptureAndroidManager r100, MediaProjection r101) {
        r100.lambda$startAudioCapture$0(r101);
    }

    public static /* synthetic */ void b(ScreenAudioCaptureAndroidManager r100) {
        r100.doRun();
    }

    public static /* synthetic */ void c(ScreenAudioCaptureAndroidManager r100) {
        r100.stopAudioCapture_();
    }

    public void dispose() {
        this.mIsDisposed = true;
    }

    private void checkNotDisposed() {
        if (this.mIsDisposed == true) goto L6;
        return;
    L6:
        throw new RuntimeException("screen audio capturer is disposed.");
    }

    private void doRun() {
        short[] r100 = new short[1024];
    L4:
        if (this.mIsRecording == false) goto L15;
        AudioRecord r101 = this.mAudioRecord;
        if (r101 == null) goto L23;
        if (r101.read(r100, 0, 1024) < 0) goto L4;
        byte[] r102 = short2byte(r100);
        ScreenAudioCaptureObserver r103 = this.mCaptureObserver;
        if (r103 == null) goto L24;
        r103.onAudioFrameCapture(r102, 1024, SAMPLE_RATE, 1);
        goto L4
    L24:
        return;
    L23:
        return;
    }

    private void stopAudioCapture_() {
        if (Build.VERSION.SDK_INT > 28) goto L6;
        return;
    L6:
        if (this.mIsRecording == true) goto L8;
        return;
    L8:
        this.mIsRecording = false;
        AudioRecord r100 = this.mAudioRecord;
        if (r100 == null) goto L11;
        INVOKEVIRTUAL_com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(r100);
        com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_release(this.mAudioRecord);
        this.mAudioRecord = null;
    L11:
        this.mCaptureObserver.onCapturerStopped();
        this.mMediaProjection = null;
    }

    private ScreenAudioCaptureAndroidManager() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("sdk-audio-share");
        this.sHandlerThread = r100;
        ThreadMethodProxy.start(r100);
        this.sHandler = new Handler(this.sHandlerThread.getLooper());
        this.mIsRecording = false;
        this.mCaptureObserver = null;
        this.mAudioRecord = null;
        this.mRecordingThread = null;
        this.mIsDisposed = false;
    }

    public static ScreenAudioCaptureAndroidManager INSTANCE() {
        return HOLDER.access$100();
    }

    @Override // android.media.projection.MediaProjection.Callback
    public void onStop() {
        super.onStop();
        stopAudioCapture_();
    }

    public void stopAudioCapture() {
        checkNotDisposed();
        MediaProjection r100 = this.mMediaProjection;
        if (r100 == null) goto L5;
        r100.unregisterCallback(this);
    L5:
        this.sHandler.removeCallbacksAndMessages(null);
        this.sHandler.post(new k(this));
    }

    public /* synthetic */ ScreenAudioCaptureAndroidManager(AnonymousClass1 r100) {
        this();
    }

    public static void INVOKEVIRTUAL_com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r100) {
        if (fna.g.d() == true) goto L6;
        com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_startRecording(r100);
        return;
    L6:
        com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_startRecording(r100);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        hna.a.b(r100.hashCode());
        return;
    }

    public static void INVOKEVIRTUAL_com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(AudioRecord r100) {
        if (fna.g.d() == true) goto L6;
        com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_stop(r100);
        return;
    L6:
        com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_stop(r100);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        hna.a.c(r100.hashCode());
        return;
    }

    private static void com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_release(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    private static void com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_startRecording(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    private static void com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_media_AudioRecord_stop(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }

    private /* synthetic */ void lambda$startAudioCapture$0(MediaProjection r100) {
        startAudioCapture_(r100);
    }

    private void setMusicMode(boolean r100) {
        AudioManager r101 = (AudioManager) this.mContextRef.get().getSystemService("audio");
        if (r100 == false) goto L5;
        this.mAudioMode = r101.getMode();     // Catch: Exception -> L7
        r101.setMode(0);     // Catch: Exception -> L7
    L10:
        return;
    L5:
        r101.setMode(this.mAudioMode);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.getMessage();
    }

    private byte[] short2byte(short[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101 * 2];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r104 = r103 * 2;
        short r105 = r100[r103];
        r102[r104] = (byte) (r105 & 255);
        r102[r104 + 1] = (byte) (r105 >> 8);
        r100[r103] = 0;
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private void startAudioCapture_(MediaProjection r100) {
        if (Build.VERSION.SDK_INT > 28) goto L6;
        return;
    L6:
        if (this.mIsRecording == false) goto L8;
        return;
    L8:
        this.mMediaProjection = r100;
        if (r100 != null) goto L11;
        return;
    L11:
        AudioPlaybackCaptureConfiguration r101 = new AudioPlaybackCaptureConfiguration.Builder(this.mMediaProjection).addMatchingUsage(1).addMatchingUsage(14).addMatchingUsage(0).build();
        AudioFormat r102 = new AudioFormat.Builder().setEncoding(2).setSampleRate(SAMPLE_RATE).setChannelMask(16).build();
        AudioRecord r103 = new AudioRecord.Builder().setAudioFormat(r102).setBufferSizeInBytes(2048).setAudioPlaybackCaptureConfig(r101).build();     // Catch: UnsupportedOperationException -> L19
        this.mAudioRecord = r103;     // Catch: UnsupportedOperationException -> L19
        if (r103.getState() != 0) goto L17;
        hasPermissions(this.mContextRef.get(), new String[]{"android.permission.RECORD_AUDIO"});
        this.mAudioRecord = null;
        return;
    L17:
        this.mMediaProjection.registerCallback(this, this.sHandler);
        this.mCaptureObserver.onCapturerStarted();
        setMusicMode(true);
        this.mIsRecording = true;
        INVOKEVIRTUAL_com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(this.mAudioRecord);
        PthreadThreadV2 r104 = new PthreadThreadV2(new j(this), "ScreenAudioCaptureAndroidManager");
        this.mRecordingThread = r104;
        ThreadMethodProxy.start(r104);
        setMusicMode(false);
        return;
    L19:
        e = move-exception;
        e.getMessage();
    }

    public void startAudioCapture(final MediaProjection r100) {
        checkNotDisposed();
        this.sHandler.post(new i(this, r100));
    }

    private static int com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static boolean hasPermissions(Context r100, String... r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (selfPermissionGranted(r100, r101[r103]) == false) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static boolean selfPermissionGranted(Context r100, String r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        if (r100.getApplicationInfo().targetSdkVersion < 23) goto L11;
        if (com_ss_bytertc_base_media_screen_ScreenAudioCaptureAndroidManager_android_content_Context_checkSelfPermission(r100, r101) == 0) goto L15;
    L9:
        return false;
    L15:
        return true;
    L11:
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L9;
        return true;
    }

    public void initialize(Context r100, ScreenAudioCaptureObserver r101) {
        if (r101 == null) goto L6;
        this.mCaptureObserver = r101;
        this.mContextRef = new WeakReference(r100);
        this.mIsDisposed = false;
        return;
    L6:
        throw new RuntimeException("audio capture observer not set.");
    }
}
