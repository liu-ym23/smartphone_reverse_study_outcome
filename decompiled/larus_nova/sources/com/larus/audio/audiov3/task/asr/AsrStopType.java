package com.larus.audio.audiov3.task.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrStopType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ASR_END", "USER_CANCEL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrStopType extends Enum<AsrStopType> {
    public static final AsrStopType ASR_END = null;
    public static final AsrStopType USER_CANCEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrStopType[] f288538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288539b = null;
    private final String type;

    public static EnumEntries<AsrStopType> getEntries() {
        return f288539b;
    }

    static {
        AsrStopType r100 = new AsrStopType("ASR_END", 0, "asr_end");
        ASR_END = r100;
        AsrStopType r101 = new AsrStopType("USER_CANCEL", 1, "user_cancel");
        USER_CANCEL = r101;
        AsrStopType[] r102 = {r100, r101};
        f288538a = r102;
        f288539b = EnumEntriesKt.enumEntries(r102);
    }

    public static AsrStopType[] values() {
        return (AsrStopType[]) f288538a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static AsrStopType valueOf(String r100) {
        return (AsrStopType) a.a(AsrStopType.class, r100);
    }

    public AsrStopType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
