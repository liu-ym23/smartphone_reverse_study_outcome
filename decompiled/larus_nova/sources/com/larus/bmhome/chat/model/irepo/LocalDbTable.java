package com.larus.bmhome.chat.model.irepo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/model/irepo/LocalDbTable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TABLE_BOT", "TABLE_CHAT", "TABLE_CVS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocalDbTable extends Enum<LocalDbTable> {
    public static final LocalDbTable TABLE_BOT = null;
    public static final LocalDbTable TABLE_CHAT = null;
    public static final LocalDbTable TABLE_CVS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalDbTable[] f307514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307515b = null;
    private final String value;

    public static EnumEntries<LocalDbTable> getEntries() {
        return f307515b;
    }

    static {
        LocalDbTable r100 = new LocalDbTable("TABLE_BOT", 0, "bot");
        TABLE_BOT = r100;
        LocalDbTable r101 = new LocalDbTable("TABLE_CHAT", 1, "chat");
        TABLE_CHAT = r101;
        LocalDbTable r102 = new LocalDbTable("TABLE_CVS", 2, "conversation");
        TABLE_CVS = r102;
        LocalDbTable[] r103 = {r100, r101, r102};
        f307514a = r103;
        f307515b = EnumEntriesKt.enumEntries(r103);
    }

    public static LocalDbTable[] values() {
        return (LocalDbTable[]) f307514a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LocalDbTable valueOf(String r100) {
        return (LocalDbTable) a.a(LocalDbTable.class, r100);
    }

    public LocalDbTable(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
