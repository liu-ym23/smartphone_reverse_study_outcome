package com.larus.audio.audiov3.task.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrResultValue;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MIDDLE_ASR_STREAM", "FINAL_ASR_STREAM", "FINAL_ASR", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrResultValue extends Enum<AsrResultValue> {
    public static final AsrResultValue FINAL_ASR = null;
    public static final AsrResultValue FINAL_ASR_STREAM = null;
    public static final AsrResultValue MIDDLE_ASR_STREAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrResultValue[] f288534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288535b = null;
    private final String value;

    public static EnumEntries<AsrResultValue> getEntries() {
        return f288535b;
    }

    static {
        AsrResultValue r100 = new AsrResultValue("MIDDLE_ASR_STREAM", 0, "0");
        MIDDLE_ASR_STREAM = r100;
        AsrResultValue r101 = new AsrResultValue("FINAL_ASR_STREAM", 1, "1");
        FINAL_ASR_STREAM = r101;
        AsrResultValue r102 = new AsrResultValue("FINAL_ASR", 2, "2");
        FINAL_ASR = r102;
        AsrResultValue[] r103 = {r100, r101, r102};
        f288534a = r103;
        f288535b = EnumEntriesKt.enumEntries(r103);
    }

    public static AsrResultValue[] values() {
        return (AsrResultValue[]) f288534a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AsrResultValue valueOf(String r100) {
        return (AsrResultValue) a.a(AsrResultValue.class, r100);
    }

    public AsrResultValue(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
