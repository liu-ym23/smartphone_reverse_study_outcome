package com.larus.home.impl.main.side_bar.view.group.policy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationArchiveFilter;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Active", "Archived", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationArchiveFilter extends Enum<ConversationArchiveFilter> {
    public static final ConversationArchiveFilter Active = null;
    public static final ConversationArchiveFilter Archived = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationArchiveFilter[] f345567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345568b = null;
    private final int value;

    public static EnumEntries<ConversationArchiveFilter> getEntries() {
        return f345568b;
    }

    static {
        ConversationArchiveFilter r100 = new ConversationArchiveFilter("Active", 0, 0);
        Active = r100;
        ConversationArchiveFilter r101 = new ConversationArchiveFilter("Archived", 1, 1);
        Archived = r101;
        ConversationArchiveFilter[] r102 = {r100, r101};
        f345567a = r102;
        f345568b = EnumEntriesKt.enumEntries(r102);
    }

    public static ConversationArchiveFilter[] values() {
        return (ConversationArchiveFilter[]) f345567a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConversationArchiveFilter valueOf(String r100) {
        return (ConversationArchiveFilter) r27.a.a(ConversationArchiveFilter.class, r100);
    }

    public ConversationArchiveFilter(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
