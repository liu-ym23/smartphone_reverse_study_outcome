package com.larus.audio.audiov3.task.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_START", "ASR_STOP", "ASR_ERROR", "ASR_RESULT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrLifeState extends Enum<AsrLifeState> {
    public static final AsrLifeState ASR_ERROR = null;
    public static final AsrLifeState ASR_RESULT = null;
    public static final AsrLifeState ASR_START = null;
    public static final AsrLifeState ASR_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrLifeState[] f288532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288533b = null;

    public static EnumEntries<AsrLifeState> getEntries() {
        return f288533b;
    }

    static {
        AsrLifeState r100 = new AsrLifeState("ASR_START", 0);
        ASR_START = r100;
        AsrLifeState r101 = new AsrLifeState("ASR_STOP", 1);
        ASR_STOP = r101;
        AsrLifeState r102 = new AsrLifeState("ASR_ERROR", 2);
        ASR_ERROR = r102;
        AsrLifeState r103 = new AsrLifeState("ASR_RESULT", 3);
        ASR_RESULT = r103;
        AsrLifeState[] r104 = {r100, r101, r102, r103};
        f288532a = r104;
        f288533b = EnumEntriesKt.enumEntries(r104);
    }

    public static AsrLifeState[] values() {
        return (AsrLifeState[]) f288532a.clone();
    }

    public static AsrLifeState valueOf(String r100) {
        return (AsrLifeState) a.a(AsrLifeState.class, r100);
    }

    public AsrLifeState(String r100, int r101) {
        super(r100, r101);
    }
}
