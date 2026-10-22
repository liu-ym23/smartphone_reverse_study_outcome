package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/AudioAttributeKey;", "", "", "value", "I", "getValue", "()I", "Src", "Autoplay", "Loop", "Interval", "PlayerType", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AudioAttributeKey extends Enum<AudioAttributeKey> {
    public static final AudioAttributeKey Autoplay = null;
    public static final AudioAttributeKey Interval = null;
    public static final AudioAttributeKey Loop = null;
    public static final AudioAttributeKey PlayerType = null;
    public static final AudioAttributeKey Src = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioAttributeKey[] f404676a = null;
    private final int value;

    public static AudioAttributeKey valueOf(String r100) {
        return (AudioAttributeKey) r27.a.a(AudioAttributeKey.class, r100);
    }

    public static AudioAttributeKey[] values() {
        return (AudioAttributeKey[]) f404676a.clone();
    }

    static {
        AudioAttributeKey r100 = new AudioAttributeKey("Src", 0, 20002);
        Src = r100;
        AudioAttributeKey r101 = new AudioAttributeKey("Autoplay", 1, 20043);
        Autoplay = r101;
        AudioAttributeKey r102 = new AudioAttributeKey("Loop", 2, 20157);
        Loop = r102;
        AudioAttributeKey r103 = new AudioAttributeKey("Interval", 3, 20046);
        Interval = r103;
        AudioAttributeKey r104 = new AudioAttributeKey("PlayerType", 4, 20179);
        PlayerType = r104;
        f404676a = new AudioAttributeKey[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public AudioAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
