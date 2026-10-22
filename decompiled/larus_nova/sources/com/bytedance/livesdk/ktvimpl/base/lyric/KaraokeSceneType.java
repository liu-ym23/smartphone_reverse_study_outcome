package com.bytedance.livesdk.ktvimpl.base.lyric;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/livesdk/ktvimpl/base/lyric/KaraokeSceneType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "KTV", "VOICE_CHORUS", "VIDEO_CHORUS", "KTV_COMPONENT", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KaraokeSceneType extends Enum<KaraokeSceneType> {
    public static final KaraokeSceneType KTV = null;
    public static final KaraokeSceneType KTV_COMPONENT = null;
    public static final KaraokeSceneType VIDEO_CHORUS = null;
    public static final KaraokeSceneType VOICE_CHORUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KaraokeSceneType[] f256333a = null;
    private final String type;

    static {
        KaraokeSceneType r100 = new KaraokeSceneType("KTV", 0, "ktv");
        KTV = r100;
        KaraokeSceneType r101 = new KaraokeSceneType("VOICE_CHORUS", 1, "voice_chorus");
        VOICE_CHORUS = r101;
        KaraokeSceneType r102 = new KaraokeSceneType("VIDEO_CHORUS", 2, "video_chorus");
        VIDEO_CHORUS = r102;
        KaraokeSceneType r103 = new KaraokeSceneType("KTV_COMPONENT", 3, "ktv_component");
        KTV_COMPONENT = r103;
        f256333a = new KaraokeSceneType[]{r100, r101, r102, r103};
    }

    public static KaraokeSceneType valueOf(String r100) {
        return (KaraokeSceneType) r27.a.a(KaraokeSceneType.class, r100);
    }

    public static KaraokeSceneType[] values() {
        return (KaraokeSceneType[]) f256333a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public KaraokeSceneType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
