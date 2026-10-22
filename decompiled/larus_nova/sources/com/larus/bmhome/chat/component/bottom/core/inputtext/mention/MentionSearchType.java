package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchType;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;II)V", "getProtocolValue", "()I", "MENTION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum MentionSearchType extends Enum<MentionSearchType> {
    public static final MentionSearchType MENTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionSearchType[] f298892a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298893b = null;
    private final int protocolValue;

    public static EnumEntries<MentionSearchType> getEntries() {
        return f298893b;
    }

    static {
        MentionSearchType r100 = new MentionSearchType();
        MENTION = r100;
        MentionSearchType[] r101 = {r100};
        f298892a = r101;
        f298893b = EnumEntriesKt.enumEntries(r101);
    }

    public MentionSearchType() {
        super("MENTION", 0);
        this.protocolValue = 3;
    }

    public static MentionSearchType[] values() {
        return (MentionSearchType[]) f298892a.clone();
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static MentionSearchType valueOf(String r100) {
        return (MentionSearchType) r27.a.a(MentionSearchType.class, r100);
    }
}
