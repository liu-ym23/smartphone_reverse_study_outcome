package com.larus.audio.audiov3.config.task.sami.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/config/task/sami/asr/AsrResultState;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL", "STREAM", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrResultState extends Enum<AsrResultState> {
    public static final AsrResultState FAIL = null;
    public static final AsrResultState STREAM = null;
    public static final AsrResultState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrResultState[] f288514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288515b = null;

    public static EnumEntries<AsrResultState> getEntries() {
        return f288515b;
    }

    static {
        AsrResultState r100 = new AsrResultState("SUCCESS", 0);
        SUCCESS = r100;
        AsrResultState r101 = new AsrResultState("FAIL", 1);
        FAIL = r101;
        AsrResultState r102 = new AsrResultState("STREAM", 2);
        STREAM = r102;
        AsrResultState[] r103 = {r100, r101, r102};
        f288514a = r103;
        f288515b = EnumEntriesKt.enumEntries(r103);
    }

    public static AsrResultState[] values() {
        return (AsrResultState[]) f288514a.clone();
    }

    public static AsrResultState valueOf(String r100) {
        return (AsrResultState) a.a(AsrResultState.class, r100);
    }

    public AsrResultState(String r100, int r101) {
        super(r100, r101);
    }
}
