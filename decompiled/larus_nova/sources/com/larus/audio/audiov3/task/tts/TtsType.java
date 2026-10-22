package com.larus.audio.audiov3.task.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsType;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_BY_MSG_ID", "TTS_BY_TEXT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsType extends Enum<TtsType> {
    public static final TtsType TTS_BY_MSG_ID = null;
    public static final TtsType TTS_BY_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsType[] f288685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288686b = null;

    public static EnumEntries<TtsType> getEntries() {
        return f288686b;
    }

    static {
        TtsType r100 = new TtsType("TTS_BY_MSG_ID", 0);
        TTS_BY_MSG_ID = r100;
        TtsType r101 = new TtsType("TTS_BY_TEXT", 1);
        TTS_BY_TEXT = r101;
        TtsType[] r102 = {r100, r101};
        f288685a = r102;
        f288686b = EnumEntriesKt.enumEntries(r102);
    }

    public static TtsType[] values() {
        return (TtsType[]) f288685a.clone();
    }

    public static TtsType valueOf(String r100) {
        return (TtsType) a.a(TtsType.class, r100);
    }

    public TtsType(String r100, int r101) {
        super(r100, r101);
    }
}
