package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/media/RecordSourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VOICE_COMMUNICATION", "MIC", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordSourceType extends Enum<RecordSourceType> {
    public static final RecordSourceType MIC = null;
    public static final RecordSourceType VOICE_COMMUNICATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordSourceType[] f358975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358976b = null;
    private final int value;

    public static EnumEntries<RecordSourceType> getEntries() {
        return f358976b;
    }

    static {
        RecordSourceType r100 = new RecordSourceType("VOICE_COMMUNICATION", 0, 7);
        VOICE_COMMUNICATION = r100;
        RecordSourceType r101 = new RecordSourceType("MIC", 1, 0);
        MIC = r101;
        RecordSourceType[] r102 = {r100, r101};
        f358975a = r102;
        f358976b = EnumEntriesKt.enumEntries(r102);
    }

    public static RecordSourceType[] values() {
        return (RecordSourceType[]) f358975a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RecordSourceType valueOf(String r100) {
        return (RecordSourceType) r27.a.a(RecordSourceType.class, r100);
    }

    public RecordSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
