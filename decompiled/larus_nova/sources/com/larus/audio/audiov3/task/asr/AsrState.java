package com.larus.audio.audiov3.task.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrState;", "", "step", "", "<init>", "(Ljava/lang/String;II)V", "getStep", "()I", "ASR_IDLE", "ASR_STARTED", "ASR_STOP", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrState extends Enum<AsrState> {
    public static final AsrState ASR_IDLE = null;
    public static final AsrState ASR_STARTED = null;
    public static final AsrState ASR_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrState[] f288536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288537b = null;
    private final int step;

    public static EnumEntries<AsrState> getEntries() {
        return f288537b;
    }

    static {
        AsrState r100 = new AsrState("ASR_IDLE", 0, -1);
        ASR_IDLE = r100;
        AsrState r101 = new AsrState("ASR_STARTED", 1, 0);
        ASR_STARTED = r101;
        AsrState r102 = new AsrState("ASR_STOP", 2, 1);
        ASR_STOP = r102;
        AsrState[] r103 = {r100, r101, r102};
        f288536a = r103;
        f288537b = EnumEntriesKt.enumEntries(r103);
    }

    public static AsrState[] values() {
        return (AsrState[]) f288536a.clone();
    }

    public final int getStep() {
        return this.step;
    }

    public static AsrState valueOf(String r100) {
        return (AsrState) a.a(AsrState.class, r100);
    }

    public AsrState(String r100, int r101, int r102) {
        super(r100, r101);
        this.step = r102;
    }
}
