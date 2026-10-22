package com.larus.im.internal.core.conversation.converter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/core/conversation/converter/ReadCvsInfoFrom;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "GET_MAIN_CVS", "BATCH_GET", "GET_CVS_INFO", "GET_CVS_BY_BOT_ID", "CELL_INFO_UPDATE", "MOCK_MAIN_CVS", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReadCvsInfoFrom extends Enum<ReadCvsInfoFrom> {
    public static final ReadCvsInfoFrom BATCH_GET = null;
    public static final ReadCvsInfoFrom CELL_INFO_UPDATE = null;
    public static final ReadCvsInfoFrom GET_CVS_BY_BOT_ID = null;
    public static final ReadCvsInfoFrom GET_CVS_INFO = null;
    public static final ReadCvsInfoFrom GET_MAIN_CVS = null;
    public static final ReadCvsInfoFrom MOCK_MAIN_CVS = null;
    public static final ReadCvsInfoFrom UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReadCvsInfoFrom[] f347576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347577b = null;
    private final int value;

    public static EnumEntries<ReadCvsInfoFrom> getEntries() {
        return f347577b;
    }

    static {
        ReadCvsInfoFrom r100 = new ReadCvsInfoFrom("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        ReadCvsInfoFrom r101 = new ReadCvsInfoFrom("GET_MAIN_CVS", 1, 0);
        GET_MAIN_CVS = r101;
        ReadCvsInfoFrom r102 = new ReadCvsInfoFrom("BATCH_GET", 2, 1);
        BATCH_GET = r102;
        ReadCvsInfoFrom r103 = new ReadCvsInfoFrom("GET_CVS_INFO", 3, 3);
        GET_CVS_INFO = r103;
        ReadCvsInfoFrom r104 = new ReadCvsInfoFrom("GET_CVS_BY_BOT_ID", 4, 4);
        GET_CVS_BY_BOT_ID = r104;
        ReadCvsInfoFrom r105 = new ReadCvsInfoFrom("CELL_INFO_UPDATE", 5, 5);
        CELL_INFO_UPDATE = r105;
        ReadCvsInfoFrom r110 = new ReadCvsInfoFrom("MOCK_MAIN_CVS", 6, 6);
        MOCK_MAIN_CVS = r110;
        ReadCvsInfoFrom[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f347576a = r111;
        f347577b = EnumEntriesKt.enumEntries(r111);
    }

    public static ReadCvsInfoFrom[] values() {
        return (ReadCvsInfoFrom[]) f347576a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ReadCvsInfoFrom valueOf(String r100) {
        return (ReadCvsInfoFrom) r27.a.a(ReadCvsInfoFrom.class, r100);
    }

    public ReadCvsInfoFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
