package androidx.camera.view.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AudioConfig {
    public static final AudioConfig AUDIO_DISABLED = null;
    private final boolean mIsAudioEnabled;

    static {
        AUDIO_DISABLED = new AudioConfig(false);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }

    public AudioConfig(boolean r1) {
        this.mIsAudioEnabled = r1;
    }

    public static AudioConfig create(boolean r1) {
        return new AudioConfig(r1);
    }
}
