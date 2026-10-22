package com.larus.im.internal.core.conversation.converter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/core/conversation/converter/WriteCvsInfo2EntityFrom;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "RECENT_CHAIN", "BATCH_GET", "GET_Write_CVS_INFO", "GET_BOT_BY_Write_CVS", "RECENT_CHAIN_MAIN", "CREATE_CONVERSATION", "CREATE_BOT_TASK", "CMD_CREATE", "CMD_UPDATE", "UPDATE_LOCAL", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WriteCvsInfo2EntityFrom extends Enum<WriteCvsInfo2EntityFrom> {
    public static final WriteCvsInfo2EntityFrom BATCH_GET = null;
    public static final WriteCvsInfo2EntityFrom CMD_CREATE = null;
    public static final WriteCvsInfo2EntityFrom CMD_UPDATE = null;
    public static final WriteCvsInfo2EntityFrom CREATE_BOT_TASK = null;
    public static final WriteCvsInfo2EntityFrom CREATE_CONVERSATION = null;
    public static final WriteCvsInfo2EntityFrom GET_BOT_BY_Write_CVS = null;
    public static final WriteCvsInfo2EntityFrom GET_Write_CVS_INFO = null;
    public static final WriteCvsInfo2EntityFrom RECENT_CHAIN = null;
    public static final WriteCvsInfo2EntityFrom RECENT_CHAIN_MAIN = null;
    public static final WriteCvsInfo2EntityFrom UNKNOWN = null;
    public static final WriteCvsInfo2EntityFrom UPDATE_LOCAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WriteCvsInfo2EntityFrom[] f347578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347579b = null;
    private final int value;

    public static EnumEntries<WriteCvsInfo2EntityFrom> getEntries() {
        return f347579b;
    }

    static {
        WriteCvsInfo2EntityFrom r100 = new WriteCvsInfo2EntityFrom("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        WriteCvsInfo2EntityFrom r101 = new WriteCvsInfo2EntityFrom("RECENT_CHAIN", 1, 0);
        RECENT_CHAIN = r101;
        WriteCvsInfo2EntityFrom r102 = new WriteCvsInfo2EntityFrom("BATCH_GET", 2, 1);
        BATCH_GET = r102;
        WriteCvsInfo2EntityFrom r103 = new WriteCvsInfo2EntityFrom("GET_Write_CVS_INFO", 3, 3);
        GET_Write_CVS_INFO = r103;
        WriteCvsInfo2EntityFrom r104 = new WriteCvsInfo2EntityFrom("GET_BOT_BY_Write_CVS", 4, 4);
        GET_BOT_BY_Write_CVS = r104;
        WriteCvsInfo2EntityFrom r105 = new WriteCvsInfo2EntityFrom("RECENT_CHAIN_MAIN", 5, 5);
        RECENT_CHAIN_MAIN = r105;
        WriteCvsInfo2EntityFrom r110 = new WriteCvsInfo2EntityFrom("CREATE_CONVERSATION", 6, 6);
        CREATE_CONVERSATION = r110;
        WriteCvsInfo2EntityFrom r111 = new WriteCvsInfo2EntityFrom("CREATE_BOT_TASK", 7, 7);
        CREATE_BOT_TASK = r111;
        WriteCvsInfo2EntityFrom r112 = new WriteCvsInfo2EntityFrom("CMD_CREATE", 8, 8);
        CMD_CREATE = r112;
        WriteCvsInfo2EntityFrom r113 = new WriteCvsInfo2EntityFrom("CMD_UPDATE", 9, 9);
        CMD_UPDATE = r113;
        WriteCvsInfo2EntityFrom r114 = new WriteCvsInfo2EntityFrom("UPDATE_LOCAL", 10, 10);
        UPDATE_LOCAL = r114;
        WriteCvsInfo2EntityFrom[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f347578a = r115;
        f347579b = EnumEntriesKt.enumEntries(r115);
    }

    public static WriteCvsInfo2EntityFrom[] values() {
        return (WriteCvsInfo2EntityFrom[]) f347578a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WriteCvsInfo2EntityFrom valueOf(String r100) {
        return (WriteCvsInfo2EntityFrom) r27.a.a(WriteCvsInfo2EntityFrom.class, r100);
    }

    public WriteCvsInfo2EntityFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
