package com.lynx.canvas;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonAudioModule extends KryptonModule {

    public static final enum AudioStatus extends Enum<AudioStatus> {
        private static final /* synthetic */ AudioStatus[] $VALUES = null;
        public static final AudioStatus DESTROY = null;
        public static final AudioStatus INIT = null;
        public static final AudioStatus PAUSE = null;
        public static final AudioStatus RESUME = null;

        static {
            AudioStatus r100 = new AudioStatus(ErrorCode.INIT, 0);
            INIT = r100;
            AudioStatus r101 = new AudioStatus("PAUSE", 1);
            PAUSE = r101;
            AudioStatus r102 = new AudioStatus("RESUME", 2);
            RESUME = r102;
            AudioStatus r103 = new AudioStatus("DESTROY", 3);
            DESTROY = r103;
            $VALUES = new AudioStatus[]{r100, r101, r102, r103};
        }

        public static AudioStatus[] values() {
            return (AudioStatus[]) $VALUES.clone();
        }

        public static AudioStatus valueOf(String r100) {
            return (AudioStatus) a.a(AudioStatus.class, r100);
        }

        private AudioStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface StatusListener {
        void onStatusChange(AudioStatus r100);
    }

    public static String moduleName() {
        return "audio";
    }

    public abstract String engineType();

    public abstract boolean loadAudioEffectModule(String r100);

    public abstract boolean loadAudioModule();

    public abstract void setStatusListener(StatusListener r100);

    public abstract boolean startAudioEngine(KryptonApp r100);

    public KryptonAudioModule() {
    }
}
