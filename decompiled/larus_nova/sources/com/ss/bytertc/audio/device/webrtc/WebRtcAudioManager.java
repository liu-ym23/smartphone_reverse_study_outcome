package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.ss.bytertc.audio.device.webrtc.observer.MicMuteChangedObserver;
import com.ss.bytertc.audio.device.webrtc.observer.VolumeChangedObserver;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes40.dex */
public class WebRtcAudioManager implements VolumeChangedObserver.OnVolumeChangedListener, MicMuteChangedObserver.OnMicMuteChangedListener {
    private static final int BITS_PER_SAMPLE = 16;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static int MAX_VOLUMED = 0;
    private static int MAX_VOLUMED_VOIP = 0;
    private static final String TAG = "WebRtcAudioManager";
    private static final boolean blacklistDeviceForAAudioUsage = false;
    private static boolean blacklistDeviceForOpenSLESUsage;
    private static boolean blacklistDeviceForOpenSLESUsageIsOverridden;
    private static boolean useStereoInput;
    private static boolean useStereoOutput;
    private boolean aAudio;
    private int apiLevel;
    private final AudioManager audioManager;
    private int curMode;
    private boolean hardwareAEC;
    private boolean hardwareAGC;
    private boolean hardwareNS;
    private boolean initialized;
    private int inputBufferSize;
    private int inputChannels;
    private Set<NativeRecordCallbackInfo> lastRecordcallbackInfos;
    private boolean lowLatencyInput;
    private boolean lowLatencyOutput;
    private WebRtcAudioEarBack mByteAudioEarback;
    private MicMuteChangedObserver mMicMuteChangedObserver;
    private VolumeChangedObserver mVolumeChangedObserver;
    private int microphoneVolume;
    private boolean modeInvalid;
    private long nativeAudioManager;
    private int nativeChannels;
    private int nativeSampleRate;
    private int outputBufferSize;
    private int outputChannels;
    private AudioManagerPhoneStateListener phoneStateListener;
    private int preferAudioLayer;
    private boolean proAudio;
    private AudioManagerRecordingCallback recordingCallback;
    private int sampleRate;

    public class AudioManagerPhoneStateListener extends PhoneStateListener {
        private int callState;
        final /* synthetic */ WebRtcAudioManager this$0;

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState r100) {
        }

        public AudioManagerPhoneStateListener(WebRtcAudioManager r100) {
            this.this$0 = r100;
            this.callState = 0;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int r100, String r101) {
            WebRtcAudioManager r102 = this.this$0;
            monitor-enter(r102);
            int r103 = this.callState;     // Catch: Throwable -> L22
            this.callState = r100;     // Catch: Throwable -> L22
            RXLogging.i(WebRtcAudioManager.TAG, "onCallStateChanged, from: " + r103 + ", to: " + r100);     // Catch: Throwable -> L22
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L9;
        L20:
            monitor-exit(r102);     // Catch: Throwable -> L22
            return;
        L9:
            if (r103 != 0) goto L20;
            if (WebRtcAudioManager.access$500(this.this$0) == 0) goto L13;
            RXLogging.i(WebRtcAudioManager.TAG, "startPhoneCall");     // Catch: Throwable -> L22
            WebRtcAudioManager r104 = this.this$0;     // Catch: Throwable -> L22
            WebRtcAudioManager.access$900(r104, WebRtcAudioManager.access$500(r104));     // Catch: Throwable -> L22
            goto L20
        L13:
            RXLogging.e(WebRtcAudioManager.TAG, "nativeAudioManager is null");     // Catch: Throwable -> L22
            goto L20
        L14:
            if (r103 == 1) goto L17;
            if (r103 != 2) goto L20;
        L17:
            if (WebRtcAudioManager.access$500(this.this$0) == 0) goto L19;
            RXLogging.i(WebRtcAudioManager.TAG, "endPhoneCall");     // Catch: Throwable -> L22
            WebRtcAudioManager r105 = this.this$0;     // Catch: Throwable -> L22
            WebRtcAudioManager.access$800(r105, WebRtcAudioManager.access$500(r105));     // Catch: Throwable -> L22
            goto L20
        L19:
            RXLogging.e(WebRtcAudioManager.TAG, "nativeAudioManager is null");     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }
    }

    public class AudioManagerRecordingCallback extends AudioManager.AudioRecordingCallback {
        private WebRtcAudioManager manager;
        final /* synthetic */ WebRtcAudioManager this$0;

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> r110) {
            super.onRecordingConfigChanged(r110);
            HashSet r100 = new HashSet();
            int r101 = 0;
        L4:
            if (r101 >= r110.size()) goto L16;
            AudioRecordingConfiguration r102 = (AudioRecordingConfiguration) ListProtector.get(r110, r101);
            NativeRecordCallbackInfo r103 = new NativeRecordCallbackInfo(this.this$0, null);
            NativeRecordCallbackInfo.access$102(r103, r102.getClientAudioSessionId());
            NativeRecordCallbackInfo.access$202(r103, r102.getClientAudioSource());
            int r104 = Build.VERSION.SDK_INT;
            int r105 = -1;
            if (r104 < 29) goto L8;
            int r106 = r102.getAudioSource();
        L9:
            NativeRecordCallbackInfo.access$302(r103, r106);
            if (r104 < 29) goto L15;
            if (r102.isClientSilenced() == false) goto L14;
            r105 = 1;
            goto L15
        L14:
            r105 = 0;
        L15:
            NativeRecordCallbackInfo.access$402(r103, r105);
            r100.add(r103);
            r101 = r101 + 1;
            goto L4
        L8:
            r106 = -1;
            goto L9
        L16:
            WebRtcAudioManager r111 = this.manager;
            monitor-enter(r111);
        L27:
            th = move-exception;
            throw th;
        L19:
            if (WebRtcAudioManager.access$500(this.this$0) != 0) goto L21;
        L25:
            monitor-exit(r111);     // Catch: Throwable -> L27
            return;
        L21:
            if (WebRtcAudioManager.access$600(this.this$0) != null) goto L23;
        L24:
            WebRtcAudioManager.access$700(this.this$0, r100.toArray(new NativeRecordCallbackInfo[r100.size()]), WebRtcAudioManager.access$500(this.this$0));     // Catch: Throwable -> L27
            WebRtcAudioManager.access$602(this.this$0, r100);     // Catch: Throwable -> L27
            goto L25
        L23:
            if (WebRtcAudioManager.access$600(this.this$0).equals(r100) == true) goto L25;
            goto L24
        }

        public AudioManagerRecordingCallback(WebRtcAudioManager r100, WebRtcAudioManager r101) {
            this.this$0 = r100;
            this.manager = r101;
        }
    }

    public static final class NativeAudioLayer {
        public static final int kAndroidAAudioAudio = 8;
        public static final int kAndroidJavaAudio = 5;
        public static final int kAndroidJavaInputAndAAudioOutputAudio = 9;
        public static final int kAndroidJavaInputAndOpenSLESOutputAudio = 7;
        public static final int kAndroidOpenSLESAudio = 6;
        public static final int kPlatformDefaultAudio = 0;

        private NativeAudioLayer() {
        }
    }

    public final class NativeRecordCallbackInfo {
        private int audio_session_id;
        private int audio_source;
        private int client_audio_source;
        private int is_client_silenced;
        final /* synthetic */ WebRtcAudioManager this$0;

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.audio_session_id), Integer.valueOf(this.client_audio_source), Integer.valueOf(this.audio_source), Integer.valueOf(this.is_client_silenced)});
        }

        private NativeRecordCallbackInfo(WebRtcAudioManager r100) {
            this.this$0 = r100;
            this.audio_session_id = -1;
            this.client_audio_source = -1;
            this.audio_source = -1;
            this.is_client_silenced = -1;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if (NativeRecordCallbackInfo.class != r100.getClass()) goto L21;
            NativeRecordCallbackInfo r101 = (NativeRecordCallbackInfo) r100;
            if (this.audio_session_id == r101.audio_session_id) goto L13;
        L19:
            return false;
        L13:
            if (this.client_audio_source != r101.client_audio_source) goto L19;
            if (this.audio_source != r101.audio_source) goto L19;
            if (this.is_client_silenced != r101.is_client_silenced) goto L19;
            return true;
        }

        public /* synthetic */ NativeRecordCallbackInfo(WebRtcAudioManager r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ int access$102(NativeRecordCallbackInfo r100, int r101) {
            r100.audio_session_id = r101;
            return r101;
        }

        public static /* synthetic */ int access$202(NativeRecordCallbackInfo r100, int r101) {
            r100.client_audio_source = r101;
            return r101;
        }

        public static /* synthetic */ int access$302(NativeRecordCallbackInfo r100, int r101) {
            r100.audio_source = r101;
            return r101;
        }

        public static /* synthetic */ int access$402(NativeRecordCallbackInfo r100, int r101) {
            r100.is_client_silenced = r101;
            return r101;
        }
    }

    private int getPreferAudioLayer() {
        return 0;
    }

    private boolean isCommunicationModeEnabled() {
        if (3 != this.audioManager.getMode()) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        StringWriter r100 = new StringWriter();
        e.printStackTrace(new PrintWriter(r100));
        RXLogging.e(TAG, r100.toString());
        return false;
    }

    private native void nativeCacheAudioParameters(int r100, int r101, int r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, int r112, int r113, int r114, long r115);

    private native void nativeOnHardwareEarbackReleased(boolean r100, long r101);

    private native void nativeOnHardwareEarbackSupportParamsGet(String r100, long r101);

    private native void nativeOnHardwareEarbackSupported(boolean r100, long r101);

    private native void nativeOnMicMuteChanged(boolean r100, long r101);

    private native void nativeOnPhoneCallEnd(long r100);

    private native void nativeOnPhoneCallStart(long r100);

    private native void nativeOnPhoneStateListenerRegisterChanged(boolean r100, long r101);

    private native void nativeRecordCallbackChanged(Object[] r100, long r101);

    private native void onVolumeChanged(int r100, int r101, long r102);

    private boolean earBackGetIsSupport() {
        WebRtcAudioEarBack r100 = this.mByteAudioEarback;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.ByteAudioEarBackSupport();
    }

    private int earBackGetLatency() {
        WebRtcAudioEarBack r100 = this.mByteAudioEarback;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.ByteAudioEarBackGetLatency();
    }

    private void earBackInit() {
        if (this.mByteAudioEarback != null) goto L5;
        this.mByteAudioEarback = new WebRtcAudioEarBack(this);
    L5:
        this.mByteAudioEarback.ByteAudioEarBackInit();
    }

    private int[] getActiveRecordingSessionIds() {
        AudioManager r100 = this.audioManager;
        int r101 = 0;
        if (Build.VERSION.SDK_INT < 24) goto L23;
        if (r100 == null) goto L23;
        List<AudioRecordingConfiguration> r102 = r100.getActiveRecordingConfigurations();     // Catch: Throwable -> L19
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L9:
        if (r104 >= r102.size()) goto L14;
        AudioRecordingConfiguration r105 = (AudioRecordingConfiguration) ListProtector.get(r102, r104);
        if (r105 == null) goto L13;
        r103.add(Integer.valueOf(r105.getClientAudioSessionId()));
    L13:
        r104 = r104 + 1;
        goto L9
    L14:
        int[] r106 = new int[r103.size()];
    L16:
        if (r101 >= r103.size()) goto L18;
        r106[r101] = ((Integer) ListProtector.get(r103, r101)).intValue();
        r101 = r101 + 1;
        goto L16
    L18:
        return r106;
    L19:
        th = move-exception;
        th.printStackTrace();
        return new int[0];
    L23:
        return new int[0];
    }

    private int getFixedDevicePlayVolume() {
        int r100 = this.audioManager.getMode();     // Catch: Exception -> L14
        int r101 = 3;
        if (r100 != 0) goto L5;
    L11:
        double r102 = ((double) this.audioManager.getStreamVolume(r101)) * 100.0d;     // Catch: Exception -> L14
        return (int) (r102 / ((double) this.audioManager.getStreamMaxVolume(r101)));
    L5:
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L9;
        if (r100 != 3) goto L11;
    L9:
        r101 = 0;
        goto L11
    L10:
        r101 = 2;
    L14:
        e = move-exception;
        StringWriter r103 = new StringWriter();
        e.printStackTrace(new PrintWriter(r103));
        RXLogging.e(TAG, r103.toString());
        return -1;
    }

    private int getMicrophoneMuteState() {
        return this.audioManager.isMicrophoneMute() ? 1 : 0;
    L4:
        e = move-exception;
        StringWriter r100 = new StringWriter();
        e.printStackTrace(new PrintWriter(r100));
        RXLogging.e(TAG, r100.toString());
        return -1;
    }

    private int getMode() {
        return this.audioManager.getMode();
    L4:
        e = move-exception;
        StringWriter r100 = new StringWriter();
        e.printStackTrace(new PrintWriter(r100));
        RXLogging.e(TAG, r100.toString());
        return -1;
    }

    private int getSampleRateForApiLevel() {
        String r100 = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");     // Catch: Exception -> L4
    L6:
        if (r100 != null) goto L9;
        return WebRtcAudioUtils.getDefaultSampleRateHz();
    L9:
        return CastIntegerProtector.parseInt(r100);
    L4:
        e = move-exception;
        StringWriter r101 = new StringWriter();
        e.printStackTrace(new PrintWriter(r101));
        RXLogging.e(TAG, r101.toString());
        r100 = "";
        goto L6
    }

    public static synchronized boolean getStereoInput() {
        monitor-enter(WebRtcAudioManager.class);
        boolean r100 = useStereoInput;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean getStereoOutput() {
        monitor-enter(WebRtcAudioManager.class);
        boolean r100 = useStereoOutput;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean init() {
        monitor-enter(this);
        RXLogging.i(TAG, "init(" + this + ")" + WebRtcAudioUtils.getThreadInfo());     // Catch: Throwable -> L30
        if (this.initialized == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L30
        return true;
    L8:
        RXLogging.i(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));     // Catch: Throwable -> L30
        if (Build.VERSION.SDK_INT >= 24) goto L11;
    L17:
        registerPhoneStateListener(32);     // Catch: Throwable -> L30
        this.mVolumeChangedObserver = new VolumeChangedObserver(this);     // Catch: Throwable -> L30
        int r100 = this.audioManager.getMode();     // Catch: Exception -> L25 Throwable -> L30
        if (r100 != 0) goto L21;
        onVolumeChanged(3, this.audioManager.getStreamVolume(3));     // Catch: Exception -> L25 Throwable -> L30
    L23:
        this.initialized = true;     // Catch: Exception -> L25 Throwable -> L30
    L27:
        this.mMicMuteChangedObserver = new MicMuteChangedObserver(this);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return true;
    L21:
        if (r100 != 3) goto L23;
        onVolumeChanged(0, this.audioManager.getStreamVolume(0));     // Catch: Exception -> L25 Throwable -> L30
    L25:
        e = move-exception;
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L30
        e.printStackTrace(new PrintWriter(r101));     // Catch: Throwable -> L30
        RXLogging.e(TAG, r101.toString());     // Catch: Throwable -> L30
        goto L27
    L11:
        if (this.recordingCallback != null) goto L17;
        AudioManagerRecordingCallback r102 = new AudioManagerRecordingCallback(this, this);     // Catch: Throwable -> L30
        this.recordingCallback = r102;     // Catch: Throwable -> L30
        this.audioManager.registerAudioRecordingCallback(r102, null);     // Catch: Exception -> L15 Throwable -> L30
    L15:
        e = move-exception;
        StringWriter r103 = new StringWriter();     // Catch: Throwable -> L30
        e.printStackTrace(new PrintWriter(r103));     // Catch: Throwable -> L30
        RXLogging.e(TAG, r103.toString());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private boolean isAAudioSupported() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        if (blacklistDeviceForOpenSLESUsageIsOverridden == false) goto L5;
        boolean r100 = blacklistDeviceForOpenSLESUsage;
    L6:
        if (r100 == false) goto L8;
        RXLogging.i(TAG, Build.MODEL + " is blacklisted for OpenSL ES usage!");
    L8:
        return r100;
    L5:
        r100 = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
        goto L6
    }

    private boolean isProAudioSupported() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L7:
        return false;
    L5:
        if (ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro") == false) goto L7;
        return true;
    }

    private boolean isRecordShouldUseVoiceRecognition() {
        if (Build.BRAND.equals(SmEditTextLeakOpt.SAMSUNG) == false) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isWiredHeadsetOn() {
        return this.audioManager.isWiredHeadsetOn();
    L4:
        e = move-exception;
        StringWriter r100 = new StringWriter();
        e.printStackTrace(new PrintWriter(r100));
        RXLogging.e(TAG, r100.toString());
        return false;
    }

    private void refreshAudioParameters() {
        storeAudioParameters();
        nativeCacheAudioParameters(this.apiLevel, this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, this.preferAudioLayer, this.nativeAudioManager);
    }

    private void storeAudioParameters() {
        this.apiLevel = Build.VERSION.SDK_INT;
        int r100 = 2;
        if (getStereoOutput() == false) goto L5;
        int r101 = 2;
    L6:
        this.outputChannels = r101;
        if (getStereoInput() == true) goto L10;
        r100 = 1;
    L10:
        this.inputChannels = r100;
        this.sampleRate = getNativeOutputSampleRate();
        this.hardwareAEC = isAcousticEchoCancelerSupported();
        this.hardwareAGC = false;
        this.hardwareNS = isNoiseSuppressorSupported();
        this.lowLatencyOutput = isLowLatencyOutputSupported();
        this.lowLatencyInput = isLowLatencyInputSupported();
        this.proAudio = isProAudioSupported();
        this.aAudio = isAAudioSupported();
        if (this.lowLatencyOutput == false) goto L13;
        int r102 = getLowLatencyOutputFramesPerBuffer();
    L14:
        this.outputBufferSize = r102;
        if (this.lowLatencyInput == false) goto L17;
        int r103 = getLowLatencyInputFramesPerBuffer();
    L18:
        this.inputBufferSize = r103;
        this.preferAudioLayer = getPreferAudioLayer();
        return;
    L17:
        r103 = getMinInputFrameSize(this.sampleRate, this.inputChannels);
        goto L18
    L13:
        r102 = getMinOutputFrameSize(this.sampleRate, this.outputChannels);
        goto L14
    L5:
        r101 = 1;
        goto L6
    }

    private String getAudioDeviceInfo() {
        return "{ Audio State: audio mode: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()) + ", has mic: " + WebRtcAudioUtils.hasMicrophone() + ", music active: " + this.audioManager.isMusicActive() + ", speakerphone: " + this.audioManager.isSpeakerphoneOn() + ", headset: " + this.audioManager.isWiredHeadsetOn() + "BT SCO: " + this.audioManager.isBluetoothScoOn() + "music actived: " + this.audioManager.isMusicActive() + "permission: " + WebRtcAudioUtils.isPermissionGranted() + " bt_sco_available_off_call: " + this.audioManager.isBluetoothScoAvailableOffCall() + " }";
    L5:
        e = move-exception;
        StringWriter r100 = new StringWriter();
        e.printStackTrace(new PrintWriter(r100));
        RXLogging.e(TAG, r100.toString());
        return r100.toString();
    }

    private int getLowLatencyInputFramesPerBuffer() {
        return getLowLatencyOutputFramesPerBuffer();
    }

    private int getLowLatencyOutputFramesPerBuffer() {
        if (isLowLatencyOutputSupported() == true) goto L14;
    L13:
        return 256;
    L14:
        String r100 = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");     // Catch: Exception -> L6
    L8:
        if (r100 == null) goto L13;
        if (CastIntegerProtector.parseInt(r100) == 0) goto L13;
        return CastIntegerProtector.parseInt(r100);
    L6:
        e = move-exception;
        StringWriter r101 = new StringWriter();
        e.printStackTrace(new PrintWriter(r101));
        RXLogging.e(TAG, r101.toString());
        r100 = "";
        goto L8
    }

    private int getNativeOutputSampleRate() {
        if (WebRtcAudioUtils.runningOnEmulator() == false) goto L7;
        RXLogging.i(TAG, "Running emulator, overriding sample rate to 8 kHz.");
        return 8000;
    L7:
        if (WebRtcAudioUtils.isDefaultSampleRateOverridden() == false) goto L10;
        RXLogging.i(TAG, "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
        return WebRtcAudioUtils.getDefaultSampleRateHz();
    L10:
        int r100 = WebRtcAudioUtils.getDefaultSampleRateHz();
        RXLogging.i(TAG, "Sample rate is set to " + r100 + " Hz");
        return r100;
    }

    private boolean hasEarpiece() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    private boolean isLowLatencyOutputSupported() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private boolean isPermissionGranted() {
        return WebRtcAudioUtils.isPermissionGranted();
    }

    private void terminate() {
        monitor-enter(this);
        RXLogging.i(TAG, "terminate(" + this + ")" + WebRtcAudioUtils.getThreadInfo());     // Catch: Throwable -> L25
        if (Build.VERSION.SDK_INT < 24) goto L13;
        AudioManagerRecordingCallback r100 = this.recordingCallback;     // Catch: Throwable -> L25
        if (r100 == null) goto L13;
        this.audioManager.unregisterAudioRecordingCallback(r100);     // Catch: Exception -> L10 Throwable -> L25
    L12:
        this.recordingCallback = null;     // Catch: Throwable -> L25
        goto L13
    L10:
        e = move-exception;
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L25
        e.printStackTrace(new PrintWriter(r101));     // Catch: Throwable -> L25
        RXLogging.e(TAG, r101.toString());     // Catch: Throwable -> L25
    L13:
        registerPhoneStateListener(0);     // Catch: Throwable -> L25
        VolumeChangedObserver r102 = this.mVolumeChangedObserver;     // Catch: Throwable -> L25
        if (r102 == null) goto L16;
        r102.release();     // Catch: Throwable -> L25
        this.mVolumeChangedObserver = null;     // Catch: Throwable -> L25
    L16:
        MicMuteChangedObserver r103 = this.mMicMuteChangedObserver;     // Catch: Throwable -> L25
        if (r103 == null) goto L19;
        r103.release();     // Catch: Throwable -> L25
        this.mMicMuteChangedObserver = null;     // Catch: Throwable -> L25
    L19:
        WebRtcAudioEarBack r104 = this.mByteAudioEarback;     // Catch: Throwable -> L25
        if (r104 == null) goto L22;
        r104.ByteAudioEarBackRelease();     // Catch: Throwable -> L25
        this.mByteAudioEarback = null;     // Catch: Throwable -> L25
    L22:
        this.nativeAudioManager = 0;     // Catch: Throwable -> L25
        this.initialized = false;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public boolean isLowLatencyInputSupported() {
        if (isLowLatencyOutputSupported() == false) goto L5;
        return true;
    L5:
        return false;
    }

    private int getFixedDeviceRecordVolume() {
        return this.microphoneVolume;
    }

    public WebRtcAudioManager(long r100) {
        this.preferAudioLayer = 0;
        this.recordingCallback = null;
        this.phoneStateListener = null;
        this.microphoneVolume = 100;
        this.curMode = -2;
        this.modeInvalid = false;
        monitor-enter(this);
        RXLogging.i(TAG, "ctor(" + this + ")" + WebRtcAudioUtils.getThreadInfo());     // Catch: Throwable -> L7
        this.nativeAudioManager = r100;     // Catch: Throwable -> L7
        AudioManager r101 = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");     // Catch: Throwable -> L7
        this.audioManager = r101;     // Catch: Throwable -> L7
        MAX_VOLUMED = r101.getStreamMaxVolume(3);     // Catch: Throwable -> L7
        MAX_VOLUMED_VOIP = r101.getStreamMaxVolume(0);     // Catch: Throwable -> L7
        refreshAudioParameters();     // Catch: Throwable -> L7
        WebRtcAudioUtils.logAudioState(TAG);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int SetAudioMode(int r100) {
        RXLogging.i(TAG, "SetAudioMode enter, modeInvalid: " + this.modeInvalid + ", curMode: " + this.curMode + ", setMode: " + r100);
    L15:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (r100 == this.curMode) goto L6;
    L7:
        this.audioManager.setMode(r100);     // Catch: Exception -> L15
        RXLogging.w(TAG, "set mode from: " + this.curMode + ", to: " + r100 + ", modeInvalid is: " + this.modeInvalid);     // Catch: Exception -> L15
    L8:
        int r101 = getMode();     // Catch: Exception -> L15
        this.curMode = r101;     // Catch: Exception -> L15
        if (r101 == r100) goto L11;
        boolean r102 = true;
    L12:
        this.modeInvalid = r102;     // Catch: Exception -> L15
        RXLogging.i(TAG, "SetAudioMode leave, modeInvalid: " + this.modeInvalid + ", curMode: " + this.curMode + ", setMode: " + r100);
        return 0;
    L11:
        r102 = false;
        goto L12
    L6:
        if (this.modeInvalid == false) goto L8;
        goto L7
    }

    public static /* synthetic */ AudioManagerPhoneStateListener access$1000(WebRtcAudioManager r100) {
        return r100.phoneStateListener;
    }

    public static /* synthetic */ long access$500(WebRtcAudioManager r100) {
        return r100.nativeAudioManager;
    }

    public static /* synthetic */ Set access$600(WebRtcAudioManager r100) {
        return r100.lastRecordcallbackInfos;
    }

    private static void assertTrue(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new AssertionError("Expected condition to be true");
    }

    private int earBackEnable(boolean r100) {
        WebRtcAudioEarBack r101 = this.mByteAudioEarback;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.ByteAudioEarBackEnable(r100);
    }

    private int earBackSetEffect(int r100) {
        WebRtcAudioEarBack r101 = this.mByteAudioEarback;
        if (r101 == null) goto L7;
        r101.ByteAudioEarBackEffect(r100);
        return 0;
    L7:
        return 0;
    }

    private int earBackSetEqualizer(int r100) {
        WebRtcAudioEarBack r101 = this.mByteAudioEarback;
        if (r101 == null) goto L7;
        r101.ByteAudioEarBackEqualizer(r100);
        return 0;
    L7:
        return 0;
    }

    private int earBackSetVolume(int r100) {
        WebRtcAudioEarBack r101 = this.mByteAudioEarback;
        if (r101 == null) goto L7;
        r101.ByteAudioEarBackSetVolume(r100);
        return 0;
    L7:
        return 0;
    }

    private void notifyPhoneStateListenerRegistered(boolean r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.nativeAudioManager == 0) goto L7;
        RXLogging.i(TAG, "dixing: notifyPhoneStateListenerRegistered: " + r100 + ", " + this.nativeAudioManager);     // Catch: Throwable -> L9
        nativeOnPhoneStateListenerRegisterChanged(r100, this.nativeAudioManager);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    private void registerPhoneStateListener(final int r100) {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r100));
    }

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean r100) {
        monitor-enter(WebRtcAudioManager.class);
        blacklistDeviceForOpenSLESUsageIsOverridden = true;     // Catch: Throwable -> L8
        blacklistDeviceForOpenSLESUsage = r100;     // Catch: Throwable -> L8
        monitor-exit(WebRtcAudioManager.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void setStereoInput(boolean r100) {
        monitor-enter(WebRtcAudioManager.class);
        RXLogging.w(TAG, "Overriding default input behavior: setStereoInput(" + r100 + ')');     // Catch: Throwable -> L7
        useStereoInput = r100;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setStereoOutput(boolean r100) {
        monitor-enter(WebRtcAudioManager.class);
        RXLogging.w(TAG, "Overriding default output behavior: setStereoOutput(" + r100 + ')');     // Catch: Throwable -> L7
        useStereoOutput = r100;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyEarbackRecordStateChanged(boolean r100) {
        WebRtcAudioEarBack r101 = this.mByteAudioEarback;
        if (r101 == null) goto L6;
        r101.notifyEarbackRecordStateChanged(r100);
        return;
    }

    public void onHardwareEarbackReleased(boolean r100) {
        monitor-enter(this);
        long r101 = this.nativeAudioManager;     // Catch: Throwable -> L8
        if (r101 == 0) goto L6;
        nativeOnHardwareEarbackReleased(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void onHardwareEarbackSupportParamsGet(String r100) {
        monitor-enter(this);
        long r101 = this.nativeAudioManager;     // Catch: Throwable -> L8
        if (r101 == 0) goto L6;
        nativeOnHardwareEarbackSupportParamsGet(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void onHardwareEarbackSupported(boolean r100) {
        monitor-enter(this);
        long r101 = this.nativeAudioManager;     // Catch: Throwable -> L8
        if (r101 == 0) goto L6;
        nativeOnHardwareEarbackSupported(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.audio.device.webrtc.observer.MicMuteChangedObserver.OnMicMuteChangedListener
    public void onMicMuteChanged(boolean r100) {
        monitor-enter(this);
        long r101 = this.nativeAudioManager;     // Catch: Throwable -> L8
        if (r101 == 0) goto L6;
        nativeOnMicMuteChanged(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ AudioManagerPhoneStateListener access$1002(WebRtcAudioManager r100, AudioManagerPhoneStateListener r101) {
        r100.phoneStateListener = r101;
        return r101;
    }

    public static /* synthetic */ void access$1100(WebRtcAudioManager r100, boolean r101) {
        r100.notifyPhoneStateListenerRegistered(r101);
    }

    public static /* synthetic */ Set access$602(WebRtcAudioManager r100, Set r101) {
        r100.lastRecordcallbackInfos = r101;
        return r101;
    }

    public static /* synthetic */ void access$800(WebRtcAudioManager r100, long r101) {
        r100.nativeOnPhoneCallEnd(r101);
    }

    public static /* synthetic */ void access$900(WebRtcAudioManager r100, long r101) {
        r100.nativeOnPhoneCallStart(r101);
    }

    private static int getMinInputFrameSize(int r100, int r101) {
        int r102 = r101 * 2;
        if (r101 != 1) goto L5;
        int r103 = 16;
    L7:
        return AudioRecord.getMinBufferSize(r100, r103, 2) / r102;
    L5:
        r103 = 12;
        goto L7
    }

    private static int getMinOutputFrameSize(int r100, int r101) {
        int r102 = r101 * 2;
        if (r101 != 1) goto L5;
        int r103 = 4;
    L7:
        return AudioTrack.getMinBufferSize(r100, r103, 2) / r102;
    L5:
        r103 = 12;
        goto L7
    }

    @Override // com.ss.bytertc.audio.device.webrtc.observer.VolumeChangedObserver.OnVolumeChangedListener
    public void onVolumeChanged(int r100, int r101) {
        if (r100 != 0) goto L4;
        int r102 = MAX_VOLUMED_VOIP;
    L5:
        double r103 = ((double) r101) * 1.0d;
        double r104 = (r103 / ((double) r102)) * 100.0d;
        monitor-enter(this);
        long r105 = this.nativeAudioManager;     // Catch: Throwable -> L12
        if (r105 == 0) goto L10;
        onVolumeChanged(r100, (int) r104, r105);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L4:
        r102 = MAX_VOLUMED;
        goto L5
    }

    public static /* synthetic */ void access$700(WebRtcAudioManager r100, Object[] r101, long r102) {
        r100.nativeRecordCallbackChanged(r101, r102);
    }
}
