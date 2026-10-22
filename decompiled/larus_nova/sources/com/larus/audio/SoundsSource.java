package com.larus.audio;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/audio/SoundsSource;", "", "keyStr", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKeyStr", "()Ljava/lang/String;", "NOT_LAST_PLAY", "NOT_PLAY", "MESSAGE_TTS", "REALTIME_CALL", MediaScene.NEWS, "VIDEO", "VOICE_TEST", "TEXT_GENERATED_MUSIC", "FIRST_PART_MUSIC", "AI_PODCAST", FlowDoraWifiScene.OTHER, "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SoundsSource extends Enum<SoundsSource> {
    public static final SoundsSource AI_PODCAST = null;
    public static final SoundsSource FIRST_PART_MUSIC = null;
    public static final SoundsSource MESSAGE_TTS = null;
    public static final SoundsSource NEWS = null;
    public static final SoundsSource NOT_LAST_PLAY = null;
    public static final SoundsSource NOT_PLAY = null;
    public static final SoundsSource OTHER = null;
    public static final SoundsSource REALTIME_CALL = null;
    public static final SoundsSource TEXT_GENERATED_MUSIC = null;
    public static final SoundsSource VIDEO = null;
    public static final SoundsSource VOICE_TEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SoundsSource[] f288315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288316b = null;
    private final String keyStr;

    public static EnumEntries<SoundsSource> getEntries() {
        return f288316b;
    }

    static {
        SoundsSource r100 = new SoundsSource("NOT_LAST_PLAY", 0, "no_last_message");
        NOT_LAST_PLAY = r100;
        SoundsSource r101 = new SoundsSource("NOT_PLAY", 1, "no_play");
        NOT_PLAY = r101;
        SoundsSource r102 = new SoundsSource("MESSAGE_TTS", 2, GlobalAudioSceneEnum.TTS_IM);
        MESSAGE_TTS = r102;
        SoundsSource r103 = new SoundsSource("REALTIME_CALL", 3, GlobalAudioSceneEnum.TTS_REAL_TIME_CALL);
        REALTIME_CALL = r103;
        SoundsSource r104 = new SoundsSource(MediaScene.NEWS, 4, "news");
        NEWS = r104;
        SoundsSource r105 = new SoundsSource("VIDEO", 5, "video");
        VIDEO = r105;
        SoundsSource r110 = new SoundsSource("VOICE_TEST", 6, GlobalAudioSceneEnum.TRAIL_LISTENING);
        VOICE_TEST = r110;
        SoundsSource r111 = new SoundsSource("TEXT_GENERATED_MUSIC", 7, GlobalAudioSceneEnum.TEXT_GENERATE_MUSIC);
        TEXT_GENERATED_MUSIC = r111;
        SoundsSource r112 = new SoundsSource("FIRST_PART_MUSIC", 8, "music");
        FIRST_PART_MUSIC = r112;
        SoundsSource r113 = new SoundsSource("AI_PODCAST", 9, "ai_podcast");
        AI_PODCAST = r113;
        SoundsSource r114 = new SoundsSource(FlowDoraWifiScene.OTHER, 10, "others");
        OTHER = r114;
        SoundsSource[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f288315a = r106;
        f288316b = EnumEntriesKt.enumEntries(r106);
    }

    public static SoundsSource[] values() {
        return (SoundsSource[]) f288315a.clone();
    }

    public final String getKeyStr() {
        return this.keyStr;
    }

    public static SoundsSource valueOf(String r100) {
        return (SoundsSource) r27.a.a(SoundsSource.class, r100);
    }

    public SoundsSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.keyStr = r102;
    }
}
