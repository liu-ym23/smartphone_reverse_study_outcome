package com.larus.audio.audiov3.task.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsStopType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PLAY_DONE", "USER_CANCEL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsStopType extends Enum<TtsStopType> {
    public static final TtsStopType PLAY_DONE = null;
    public static final TtsStopType USER_CANCEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsStopType[] f288683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288684b = null;
    private final String type;

    public static EnumEntries<TtsStopType> getEntries() {
        return f288684b;
    }

    static {
        TtsStopType r100 = new TtsStopType("PLAY_DONE", 0, "play_done");
        PLAY_DONE = r100;
        TtsStopType r101 = new TtsStopType("USER_CANCEL", 1, "user_cancel");
        USER_CANCEL = r101;
        TtsStopType[] r102 = {r100, r101};
        f288683a = r102;
        f288684b = EnumEntriesKt.enumEntries(r102);
    }

    public static TtsStopType[] values() {
        return (TtsStopType[]) f288683a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TtsStopType valueOf(String r100) {
        return (TtsStopType) a.a(TtsStopType.class, r100);
    }

    public TtsStopType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
