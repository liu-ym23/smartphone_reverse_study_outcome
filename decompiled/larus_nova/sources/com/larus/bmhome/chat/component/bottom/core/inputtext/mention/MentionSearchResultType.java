package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchResultType;", "", "protocolValue", "", "domain", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;", "<init>", "(Ljava/lang/String;IILcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;)V", "getProtocolValue", "()I", "getDomain", "()Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;", "UNKNOWN", "DRIVE", "CONTACT", "CONVERSATION", "GROUP", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum MentionSearchResultType extends Enum<MentionSearchResultType> {
    public static final MentionSearchResultType CONTACT = null;
    public static final MentionSearchResultType CONVERSATION = null;
    public static final a Companion = null;
    public static final MentionSearchResultType DRIVE = null;
    public static final MentionSearchResultType GROUP = null;
    public static final MentionSearchResultType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionSearchResultType[] f298890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298891b = null;
    private final MentionSearchDomain domain;
    private final int protocolValue;

    public static final class a {
        public a() {
        }

        public static MentionSearchResultType a(int r100) {
            MentionSearchResultType[] r101 = MentionSearchResultType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            MentionSearchResultType r104 = r101[r103];
            if (r104.getProtocolValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return MentionSearchResultType.UNKNOWN;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<MentionSearchResultType> getEntries() {
        return f298891b;
    }

    static {
        MentionSearchResultType r100 = new MentionSearchResultType("UNKNOWN", 0, 0, null);
        UNKNOWN = r100;
        MentionSearchResultType r101 = new MentionSearchResultType("DRIVE", 1, 2, MentionSearchDomain.DRIVE);
        DRIVE = r101;
        MentionSearchResultType r102 = new MentionSearchResultType("CONTACT", 2, 4, MentionSearchDomain.CONTACT);
        CONTACT = r102;
        MentionSearchResultType r103 = new MentionSearchResultType("CONVERSATION", 3, 5, MentionSearchDomain.CONVERSATION);
        CONVERSATION = r103;
        MentionSearchResultType r104 = new MentionSearchResultType("GROUP", 4, 6, MentionSearchDomain.GROUP);
        GROUP = r104;
        MentionSearchResultType[] r105 = {r100, r101, r102, r103, r104};
        f298890a = r105;
        f298891b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MentionSearchResultType[] values() {
        return (MentionSearchResultType[]) f298890a.clone();
    }

    public final MentionSearchDomain getDomain() {
        return this.domain;
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static MentionSearchResultType valueOf(String r100) {
        return (MentionSearchResultType) r27.a.a(MentionSearchResultType.class, r100);
    }

    public MentionSearchResultType(String r100, int r101, int r102, MentionSearchDomain r103) {
        super(r100, r101);
        this.protocolValue = r102;
        this.domain = r103;
    }
}
