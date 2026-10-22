package com.larus.audio.audiov3.task.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrDataSourceState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "INITIALIZED", "STARTED", "STOPPED", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrDataSourceState extends Enum<AsrDataSourceState> {
    public static final AsrDataSourceState INITIALIZED = null;
    public static final AsrDataSourceState STARTED = null;
    public static final AsrDataSourceState STOPPED = null;
    public static final AsrDataSourceState UNINITIALIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrDataSourceState[] f288526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288527b = null;

    public static EnumEntries<AsrDataSourceState> getEntries() {
        return f288527b;
    }

    static {
        AsrDataSourceState r100 = new AsrDataSourceState("UNINITIALIZED", 0);
        UNINITIALIZED = r100;
        AsrDataSourceState r101 = new AsrDataSourceState("INITIALIZED", 1);
        INITIALIZED = r101;
        AsrDataSourceState r102 = new AsrDataSourceState("STARTED", 2);
        STARTED = r102;
        AsrDataSourceState r103 = new AsrDataSourceState("STOPPED", 3);
        STOPPED = r103;
        AsrDataSourceState[] r104 = {r100, r101, r102, r103};
        f288526a = r104;
        f288527b = EnumEntriesKt.enumEntries(r104);
    }

    public static AsrDataSourceState[] values() {
        return (AsrDataSourceState[]) f288526a.clone();
    }

    public static AsrDataSourceState valueOf(String r100) {
        return (AsrDataSourceState) a.a(AsrDataSourceState.class, r100);
    }

    public AsrDataSourceState(String r100, int r101) {
        super(r100, r101);
    }
}
