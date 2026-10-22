package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "CONTACT", "GROUP", "DRIVE", "CONVERSATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MentionSearchDomain extends Enum<MentionSearchDomain> {
    public static final MentionSearchDomain CONTACT = null;
    public static final MentionSearchDomain CONVERSATION = null;
    public static final MentionSearchDomain DRIVE = null;
    public static final MentionSearchDomain GROUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionSearchDomain[] f298885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298886b = null;
    private final String key;

    public static EnumEntries<MentionSearchDomain> getEntries() {
        return f298886b;
    }

    static {
        MentionSearchDomain r100 = new MentionSearchDomain("CONTACT", 0, "contact");
        CONTACT = r100;
        MentionSearchDomain r101 = new MentionSearchDomain("GROUP", 1, "group");
        GROUP = r101;
        MentionSearchDomain r102 = new MentionSearchDomain("DRIVE", 2, "drive");
        DRIVE = r102;
        MentionSearchDomain r103 = new MentionSearchDomain("CONVERSATION", 3, "conversation");
        CONVERSATION = r103;
        MentionSearchDomain[] r104 = {r100, r101, r102, r103};
        f298885a = r104;
        f298886b = EnumEntriesKt.enumEntries(r104);
    }

    public static MentionSearchDomain[] values() {
        return (MentionSearchDomain[]) f298885a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static MentionSearchDomain valueOf(String r100) {
        return (MentionSearchDomain) r27.a.a(MentionSearchDomain.class, r100);
    }

    public MentionSearchDomain(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
