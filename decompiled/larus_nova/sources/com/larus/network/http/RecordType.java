package com.larus.network.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/network/http/RecordType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_RECORD", "DOUBAO_RECORD", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordType extends Enum<RecordType> {
    public static final RecordType DOUBAO_RECORD = null;
    public static final RecordType NO_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordType[] f360131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360132b = null;
    private final int value;

    public static EnumEntries<RecordType> getEntries() {
        return f360132b;
    }

    static {
        RecordType r100 = new RecordType("NO_RECORD", 0, 0);
        NO_RECORD = r100;
        RecordType r101 = new RecordType("DOUBAO_RECORD", 1, 1);
        DOUBAO_RECORD = r101;
        RecordType[] r102 = {r100, r101};
        f360131a = r102;
        f360132b = EnumEntriesKt.enumEntries(r102);
    }

    public static RecordType[] values() {
        return (RecordType[]) f360131a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RecordType valueOf(String r100) {
        return (RecordType) r27.a.a(RecordType.class, r100);
    }

    public RecordType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
