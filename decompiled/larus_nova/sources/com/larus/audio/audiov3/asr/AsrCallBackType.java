package com.larus.audio.audiov3.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/asr/AsrCallBackType;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_START", "AS_SUCCESS", "ASR_CANCEL", "ASR_FAILED", "ASR_FAILED_SERVER", "ASR_FAILED_TOKEN", "ASR_STREAM", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrCallBackType extends Enum<AsrCallBackType> {
    public static final AsrCallBackType ASR_CANCEL = null;
    public static final AsrCallBackType ASR_FAILED = null;
    public static final AsrCallBackType ASR_FAILED_SERVER = null;
    public static final AsrCallBackType ASR_FAILED_TOKEN = null;
    public static final AsrCallBackType ASR_START = null;
    public static final AsrCallBackType ASR_STREAM = null;
    public static final AsrCallBackType AS_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrCallBackType[] f288495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288496b = null;

    public static EnumEntries<AsrCallBackType> getEntries() {
        return f288496b;
    }

    static {
        AsrCallBackType r100 = new AsrCallBackType("ASR_START", 0);
        ASR_START = r100;
        AsrCallBackType r101 = new AsrCallBackType("AS_SUCCESS", 1);
        AS_SUCCESS = r101;
        AsrCallBackType r102 = new AsrCallBackType("ASR_CANCEL", 2);
        ASR_CANCEL = r102;
        AsrCallBackType r103 = new AsrCallBackType("ASR_FAILED", 3);
        ASR_FAILED = r103;
        AsrCallBackType r104 = new AsrCallBackType("ASR_FAILED_SERVER", 4);
        ASR_FAILED_SERVER = r104;
        AsrCallBackType r105 = new AsrCallBackType("ASR_FAILED_TOKEN", 5);
        ASR_FAILED_TOKEN = r105;
        AsrCallBackType r110 = new AsrCallBackType("ASR_STREAM", 6);
        ASR_STREAM = r110;
        AsrCallBackType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f288495a = r111;
        f288496b = EnumEntriesKt.enumEntries(r111);
    }

    public static AsrCallBackType[] values() {
        return (AsrCallBackType[]) f288495a.clone();
    }

    public static AsrCallBackType valueOf(String r100) {
        return (AsrCallBackType) a.a(AsrCallBackType.class, r100);
    }

    public AsrCallBackType(String r100, int r101) {
        super(r100, r101);
    }
}
