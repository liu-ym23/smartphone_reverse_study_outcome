package com.larus.im.bean.conversation;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/conversation/ConversationArchiveFilter;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.ALL, "INCLUDE", "EXCLUDE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationArchiveFilter extends Enum<ConversationArchiveFilter> {
    public static final ConversationArchiveFilter ALL = null;
    public static final ConversationArchiveFilter EXCLUDE = null;
    public static final ConversationArchiveFilter INCLUDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationArchiveFilter[] f346524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346525b = null;
    private final int value;

    public static EnumEntries<ConversationArchiveFilter> getEntries() {
        return f346525b;
    }

    static {
        ConversationArchiveFilter r100 = new ConversationArchiveFilter(AccountType.ALL, 0, 0);
        ALL = r100;
        ConversationArchiveFilter r101 = new ConversationArchiveFilter("INCLUDE", 1, 1);
        INCLUDE = r101;
        ConversationArchiveFilter r102 = new ConversationArchiveFilter("EXCLUDE", 2, 2);
        EXCLUDE = r102;
        ConversationArchiveFilter[] r103 = {r100, r101, r102};
        f346524a = r103;
        f346525b = EnumEntriesKt.enumEntries(r103);
    }

    public static ConversationArchiveFilter[] values() {
        return (ConversationArchiveFilter[]) f346524a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConversationArchiveFilter valueOf(String r100) {
        return (ConversationArchiveFilter) a.a(ConversationArchiveFilter.class, r100);
    }

    public ConversationArchiveFilter(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
