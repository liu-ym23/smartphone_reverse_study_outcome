package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/AudioEventKey;", "", "", "value", "I", "getValue", "()I", "AudioPrepared", "AudioPlaybackStateChanged", "AudioLoadingStateChanged", "AudioSeek", "AudioTimeUpdate", "AudioError", "AudioFinished", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AudioEventKey extends Enum<AudioEventKey> {
    public static final AudioEventKey AudioError = null;
    public static final AudioEventKey AudioFinished = null;
    public static final AudioEventKey AudioLoadingStateChanged = null;
    public static final AudioEventKey AudioPlaybackStateChanged = null;
    public static final AudioEventKey AudioPrepared = null;
    public static final AudioEventKey AudioSeek = null;
    public static final AudioEventKey AudioTimeUpdate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioEventKey[] f404677a = null;
    private final int value;

    public static AudioEventKey valueOf(String r100) {
        return (AudioEventKey) r27.a.a(AudioEventKey.class, r100);
    }

    public static AudioEventKey[] values() {
        return (AudioEventKey[]) f404677a.clone();
    }

    static {
        AudioEventKey r100 = new AudioEventKey("AudioPrepared", 0, 30087);
        AudioPrepared = r100;
        AudioEventKey r101 = new AudioEventKey("AudioPlaybackStateChanged", 1, 30088);
        AudioPlaybackStateChanged = r101;
        AudioEventKey r102 = new AudioEventKey("AudioLoadingStateChanged", 2, 30089);
        AudioLoadingStateChanged = r102;
        AudioEventKey r103 = new AudioEventKey("AudioSeek", 3, 30090);
        AudioSeek = r103;
        AudioEventKey r104 = new AudioEventKey("AudioTimeUpdate", 4, 30091);
        AudioTimeUpdate = r104;
        AudioEventKey r105 = new AudioEventKey("AudioError", 5, 30092);
        AudioError = r105;
        AudioEventKey r110 = new AudioEventKey("AudioFinished", 6, 30093);
        AudioFinished = r110;
        f404677a = new AudioEventKey[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public AudioEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
