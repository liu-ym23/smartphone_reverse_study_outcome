package com.larus.audio.audiov3.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/audiov3/tts/PlayStateEnum;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "PLAY_STATE_STOPPED", "PLAY_STATE_PREPARE", "PLAY_STATE_PAUSED", "PLAY_STATE_PLAYING", "PLAY_STATE_FAIL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlayStateEnum extends Enum<PlayStateEnum> {
    public static final PlayStateEnum PLAY_STATE_FAIL = null;
    public static final PlayStateEnum PLAY_STATE_PAUSED = null;
    public static final PlayStateEnum PLAY_STATE_PLAYING = null;
    public static final PlayStateEnum PLAY_STATE_PREPARE = null;
    public static final PlayStateEnum PLAY_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayStateEnum[] f288687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288688b = null;
    private final int state;

    public static EnumEntries<PlayStateEnum> getEntries() {
        return f288688b;
    }

    static {
        PlayStateEnum r100 = new PlayStateEnum("PLAY_STATE_STOPPED", 0, 1);
        PLAY_STATE_STOPPED = r100;
        PlayStateEnum r101 = new PlayStateEnum("PLAY_STATE_PREPARE", 1, 2);
        PLAY_STATE_PREPARE = r101;
        PlayStateEnum r102 = new PlayStateEnum("PLAY_STATE_PAUSED", 2, 3);
        PLAY_STATE_PAUSED = r102;
        PlayStateEnum r103 = new PlayStateEnum("PLAY_STATE_PLAYING", 3, 4);
        PLAY_STATE_PLAYING = r103;
        PlayStateEnum r104 = new PlayStateEnum("PLAY_STATE_FAIL", 4, 5);
        PLAY_STATE_FAIL = r104;
        PlayStateEnum[] r110 = {r100, r101, r102, r103, r104};
        f288687a = r110;
        f288688b = EnumEntriesKt.enumEntries(r110);
    }

    public static PlayStateEnum[] values() {
        return (PlayStateEnum[]) f288687a.clone();
    }

    public final int getState() {
        return this.state;
    }

    public static PlayStateEnum valueOf(String r100) {
        return (PlayStateEnum) a.a(PlayStateEnum.class, r100);
    }

    public PlayStateEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
