package com.obric.sva.framework.wrapper;

import android.hardware.soundtrigger.SoundTrigger;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class SoundTriggerWrapper {
    public static final int MODEL_PARAM_INVALID = -1;
    public static final int MODEL_PARAM_THRESHOLD_FACTOR = 0;
    public static final int RC_BAD_VALUE = 0;
    public static final int RC_DEAD_OBJECT = 0;
    public static final int RC_ERROR = Integer.MIN_VALUE;
    public static final int RC_INVALID_OPERATION = 0;
    public static final int RC_NO_INIT = 0;
    public static final int RC_OK = 0;
    public static final int RC_PERMISSION_DENIED = 0;
    public static final int RECOGNITION_MODE_GENERIC = 8;
    public static final int RECOGNITION_MODE_USER_AUTHENTICATION = 4;
    public static final int RECOGNITION_MODE_USER_IDENTIFICATION = 2;
    public static final int RECOGNITION_MODE_VOICE_TRIGGER = 1;
    public static final int RECOGNITION_STATUS_ABORT = 1;
    public static final int RECOGNITION_STATUS_FAILURE = 2;
    public static final int RECOGNITION_STATUS_GET_STATE_RESPONSE = 3;
    public static final int RECOGNITION_STATUS_SUCCESS = 0;
    public static final int STATUS_ERROR = Integer.MIN_VALUE;
    public static final int STATUS_OK = 0;

    public static class ConfidenceLevelWrapper {
        public SoundTrigger.ConfidenceLevel confidenceLevel;

        public int userId() {
            return this.confidenceLevel.userId;
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.ConfidenceLevel.class;
        }

        public ConfidenceLevelWrapper(int r100, int r101) {
            this.confidenceLevel = new SoundTrigger.ConfidenceLevel(r100, r101);
        }
    }

    public static class KeyphraseRecognitionEventWrapper {
        public SoundTrigger.KeyphraseRecognitionEvent keyphraseRecognitionEvent;

        public boolean captureAvailable() {
            return this.keyphraseRecognitionEvent.captureAvailable;
        }

        public int captureSession() {
            return this.keyphraseRecognitionEvent.captureSession;
        }

        public byte[] data() {
            return this.keyphraseRecognitionEvent.data;
        }

        public int soundModelHandle() {
            return this.keyphraseRecognitionEvent.soundModelHandle;
        }

        public int status() {
            return this.keyphraseRecognitionEvent.status;
        }

        public String toString() {
            return this.keyphraseRecognitionEvent.toString();
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.KeyphraseRecognitionEvent.class;
        }

        public KeyphraseRecognitionEventWrapper(RecognitionEventWrapper r100) {
            this.keyphraseRecognitionEvent = RecognitionEventWrapper.access$000(r100);
        }
    }

    public static class KeyphraseRecognitionExtraWrapper {
        private SoundTrigger.KeyphraseRecognitionExtra keyphraseRecognitionExtra;

        public static /* synthetic */ ConfidenceLevelWrapper a(SoundTrigger.ConfidenceLevel r100) {
            return lambda$_confidenceLevels$2(r100);
        }

        public static /* synthetic */ SoundTrigger.ConfidenceLevel[] b(int r100) {
            return lambda$new$1(r100);
        }

        public static /* synthetic */ ConfidenceLevelWrapper[] c(int r100) {
            return lambda$_confidenceLevels$3(r100);
        }

        public static /* synthetic */ SoundTrigger.ConfidenceLevel d(ConfidenceLevelWrapper r100) {
            return lambda$new$0(r100);
        }

        public ConfidenceLevelWrapper[] _confidenceLevels() {
            return (ConfidenceLevelWrapper[]) ((List) Arrays.stream(this.keyphraseRecognitionExtra.confidenceLevels).map(new a()).collect(Collectors.toList())).toArray(new b());
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.KeyphraseRecognitionExtra.class;
        }

        public SoundTrigger.KeyphraseRecognitionExtra getKeyphraseRecognitionExtra() {
            return this.keyphraseRecognitionExtra;
        }

        private static /* synthetic */ ConfidenceLevelWrapper lambda$_confidenceLevels$2(SoundTrigger.ConfidenceLevel r100) {
            return new ConfidenceLevelWrapper(r100.userId, r100.confidenceLevel);
        }

        private static /* synthetic */ ConfidenceLevelWrapper[] lambda$_confidenceLevels$3(int r100) {
            return new ConfidenceLevelWrapper[r100];
        }

        private static /* synthetic */ SoundTrigger.ConfidenceLevel lambda$new$0(ConfidenceLevelWrapper r100) {
            return r100.confidenceLevel;
        }

        private static /* synthetic */ SoundTrigger.ConfidenceLevel[] lambda$new$1(int r100) {
            return new SoundTrigger.ConfidenceLevel[r100];
        }

        public KeyphraseRecognitionExtraWrapper(int r100, int r101, int r102) {
            this(r100, r101, r102, new ConfidenceLevelWrapper[0]);
        }

        public KeyphraseRecognitionExtraWrapper(int r100, int r101, int r102, ConfidenceLevelWrapper[] r103) {
            this.keyphraseRecognitionExtra = new SoundTrigger.KeyphraseRecognitionExtra(r100, r101, r102, (SoundTrigger.ConfidenceLevel[]) ((List) Arrays.stream(r103).map(new c()).collect(Collectors.toList())).toArray(new d()));
        }
    }

    public static final class KeyphraseSoundModelWrapper {
        private SoundTrigger.KeyphraseSoundModel soundModel;

        public static /* synthetic */ SoundTrigger.Keyphrase a(KeyphraseWrapper r100) {
            return lambda$new$0(r100);
        }

        public static /* synthetic */ SoundTrigger.Keyphrase[] b(int r100) {
            return lambda$new$1(r100);
        }

        public String toString() {
            return this.soundModel.toString();
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.KeyphraseSoundModel.class;
        }

        public SoundTrigger.KeyphraseSoundModel getSoundModel() {
            return this.soundModel;
        }

        private static /* synthetic */ SoundTrigger.Keyphrase lambda$new$0(KeyphraseWrapper r100) {
            return r100.getKeyphrase();
        }

        private static /* synthetic */ SoundTrigger.Keyphrase[] lambda$new$1(int r100) {
            return new SoundTrigger.Keyphrase[r100];
        }

        public KeyphraseSoundModelWrapper(UUID r100, UUID r101, byte[] r102, KeyphraseWrapper[] r103) {
            SoundTrigger.Keyphrase[] r104 = new SoundTrigger.Keyphrase[0];
            if (Build.VERSION.SDK_INT < 24) goto L5;
            r104 = (SoundTrigger.Keyphrase[]) ((List) Arrays.stream(r103).map(new e()).collect(Collectors.toList())).toArray(new f());
        L5:
            this.soundModel = new SoundTrigger.KeyphraseSoundModel(r100, r101, r102, r104);
        }
    }

    public static final class KeyphraseWrapper {
        private SoundTrigger.Keyphrase keyphrase;

        public int[] getUsers() {
            return this.keyphrase.getUsers();
        }

        public String toString() {
            return this.keyphrase.toString();
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.Keyphrase.class;
        }

        public SoundTrigger.Keyphrase getKeyphrase() {
            return this.keyphrase;
        }

        public KeyphraseWrapper(int r100, int r101, Locale r110, String r111, int[] r112) {
            this.keyphrase = new SoundTrigger.Keyphrase(r100, r101, r110, r111, r112);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class ModulePropertiesWrapper {
        private SoundTrigger.ModuleProperties moduleProperties;

        public int getId() {
            return this.moduleProperties.getId();
        }

        public boolean isConcurrentCaptureSupported() {
            SoundTrigger.ModuleProperties r100 = this.moduleProperties;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isConcurrentCaptureSupported();
        }

        public String toString() {
            return this.moduleProperties.toString();
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.ModuleProperties.class;
        }

        public SoundTrigger.ModuleProperties getModuleProperties() {
            return this.moduleProperties;
        }

        public ModulePropertiesWrapper(SoundTrigger.ModuleProperties r100) {
            this.moduleProperties = r100;
        }
    }

    public static class RecognitionConfigWrapper {
        private SoundTrigger.RecognitionConfig recognitionConfig;

        public static /* synthetic */ SoundTrigger.KeyphraseRecognitionExtra a(KeyphraseRecognitionExtraWrapper r100) {
            return lambda$new$0(r100);
        }

        public static /* synthetic */ SoundTrigger.KeyphraseRecognitionExtra[] b(int r100) {
            return lambda$new$1(r100);
        }

        public String toString() {
            return this.recognitionConfig.toString();
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.RecognitionConfig.class;
        }

        public SoundTrigger.RecognitionConfig getConfig() {
            return this.recognitionConfig;
        }

        private static /* synthetic */ SoundTrigger.KeyphraseRecognitionExtra lambda$new$0(KeyphraseRecognitionExtraWrapper r100) {
            return r100.getKeyphraseRecognitionExtra();
        }

        private static /* synthetic */ SoundTrigger.KeyphraseRecognitionExtra[] lambda$new$1(int r100) {
            return new SoundTrigger.KeyphraseRecognitionExtra[r100];
        }

        public RecognitionConfigWrapper(boolean r100, boolean r101, KeyphraseRecognitionExtraWrapper[] r102, byte[] r103) {
            SoundTrigger.KeyphraseRecognitionExtra[] r104 = new SoundTrigger.KeyphraseRecognitionExtra[0];
            if (Build.VERSION.SDK_INT < 24) goto L5;
            r104 = (SoundTrigger.KeyphraseRecognitionExtra[]) ((List) Arrays.stream(r102).map(new g()).collect(Collectors.toList())).toArray(new h());
        L5:
            this.recognitionConfig = new SoundTrigger.RecognitionConfig(r100, r101, r104, r103);
        }
    }

    public static class RecognitionEventWrapper {
        private SoundTrigger.RecognitionEvent recognitionEvent;

        public boolean captureAvailable() {
            return this.recognitionEvent.captureAvailable;
        }

        public int captureSession() {
            return this.recognitionEvent.captureSession;
        }

        public byte[] data() {
            return this.recognitionEvent.data;
        }

        public int soundModelHandle() {
            return this.recognitionEvent.soundModelHandle;
        }

        public int status() {
            return this.recognitionEvent.status;
        }

        public String toString() {
            return this.recognitionEvent.toString();
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.RecognitionEvent.class;
        }

        public RecognitionEventWrapper(SoundTrigger.RecognitionEvent r100) {
            this.recognitionEvent = r100;
        }

        public static /* synthetic */ SoundTrigger.RecognitionEvent access$000(RecognitionEventWrapper r100) {
            return r100.recognitionEvent;
        }
    }

    public static class SoundModelWrapper {
        private SoundTrigger.SoundModel model;

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.SoundModel.class;
        }

        public SoundModelWrapper(UUID r100, UUID r101, int r110, byte[] r111, int r112) {
            this.model = new SoundTrigger.SoundModel(r100, r101, r110, r111, r112);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class StatusListenerWrapper {
        public SoundTrigger.StatusListener statusListener;

        public void onModelUnloadedExt(int r100) {
        }

        public void onRecognitionExt(RecognitionEventWrapper r100) {
        }

        public void onResourcesAvailableExt() {
        }

        public void onServiceDiedExt() {
        }

        public StatusListenerWrapper() {
            this.statusListener = new AnonymousClass1(this);
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return SoundTrigger.StatusListener.class;
        }
    }

    static {
        RC_PERMISSION_DENIED = SoundTrigger.STATUS_PERMISSION_DENIED;
        RC_NO_INIT = SoundTrigger.STATUS_NO_INIT;
        RC_BAD_VALUE = SoundTrigger.STATUS_BAD_VALUE;
        RC_DEAD_OBJECT = SoundTrigger.STATUS_DEAD_OBJECT;
        RC_INVALID_OPERATION = SoundTrigger.STATUS_INVALID_OPERATION;
    }

    private SoundTriggerWrapper() {
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return SoundTrigger.class;
    }
}
