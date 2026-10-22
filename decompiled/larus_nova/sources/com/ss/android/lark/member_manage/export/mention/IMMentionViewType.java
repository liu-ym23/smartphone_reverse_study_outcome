package com.ss.android.lark.member_manage.export.mention;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.ALL, "SECTION_TITLE", "SUPER_GROUP_TIPS", "LETTER", "AT_ALL", "CONTACT", "WIKI", "SIMPLE_TEXT", "INLINE_AI_ALL", "INLINE_AI_CONTRACT", "INLINE_AI_DOC", "AI_KNOWLEDGE_ALL", "AI_KNOWLEDGE_CONTRACT", "AI_KNOWLEDGE_DOC", "AI_KNOWLEDGE_GROUP", "AI_KNOWLEDGE_DEPARTMENT", "LOADING", "group-member-manage-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMMentionViewType extends Enum<IMMentionViewType> {
    public static final IMMentionViewType AI_KNOWLEDGE_ALL = null;
    public static final IMMentionViewType AI_KNOWLEDGE_CONTRACT = null;
    public static final IMMentionViewType AI_KNOWLEDGE_DEPARTMENT = null;
    public static final IMMentionViewType AI_KNOWLEDGE_DOC = null;
    public static final IMMentionViewType AI_KNOWLEDGE_GROUP = null;
    public static final IMMentionViewType ALL = null;
    public static final IMMentionViewType AT_ALL = null;
    public static final IMMentionViewType CONTACT = null;
    public static final IMMentionViewType INLINE_AI_ALL = null;
    public static final IMMentionViewType INLINE_AI_CONTRACT = null;
    public static final IMMentionViewType INLINE_AI_DOC = null;
    public static final IMMentionViewType LETTER = null;
    public static final IMMentionViewType LOADING = null;
    public static final IMMentionViewType SECTION_TITLE = null;
    public static final IMMentionViewType SIMPLE_TEXT = null;
    public static final IMMentionViewType SUPER_GROUP_TIPS = null;
    public static final IMMentionViewType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMMentionViewType[] f431658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431659b = null;

    public static EnumEntries<IMMentionViewType> getEntries() {
        return f431659b;
    }

    static {
        IMMentionViewType r100 = new IMMentionViewType(AccountType.ALL, 0);
        ALL = r100;
        IMMentionViewType r101 = new IMMentionViewType("SECTION_TITLE", 1);
        SECTION_TITLE = r101;
        IMMentionViewType r102 = new IMMentionViewType("SUPER_GROUP_TIPS", 2);
        SUPER_GROUP_TIPS = r102;
        IMMentionViewType r103 = new IMMentionViewType("LETTER", 3);
        LETTER = r103;
        IMMentionViewType r104 = new IMMentionViewType("AT_ALL", 4);
        AT_ALL = r104;
        IMMentionViewType r105 = new IMMentionViewType("CONTACT", 5);
        CONTACT = r105;
        IMMentionViewType r110 = new IMMentionViewType("WIKI", 6);
        WIKI = r110;
        IMMentionViewType r111 = new IMMentionViewType("SIMPLE_TEXT", 7);
        SIMPLE_TEXT = r111;
        IMMentionViewType r112 = new IMMentionViewType("INLINE_AI_ALL", 8);
        INLINE_AI_ALL = r112;
        IMMentionViewType r113 = new IMMentionViewType("INLINE_AI_CONTRACT", 9);
        INLINE_AI_CONTRACT = r113;
        IMMentionViewType r114 = new IMMentionViewType("INLINE_AI_DOC", 10);
        INLINE_AI_DOC = r114;
        IMMentionViewType r115 = new IMMentionViewType("AI_KNOWLEDGE_ALL", 11);
        AI_KNOWLEDGE_ALL = r115;
        IMMentionViewType r106 = new IMMentionViewType("AI_KNOWLEDGE_CONTRACT", 12);
        AI_KNOWLEDGE_CONTRACT = r106;
        IMMentionViewType r107 = new IMMentionViewType("AI_KNOWLEDGE_DOC", 13);
        AI_KNOWLEDGE_DOC = r107;
        IMMentionViewType r108 = new IMMentionViewType("AI_KNOWLEDGE_GROUP", 14);
        AI_KNOWLEDGE_GROUP = r108;
        IMMentionViewType r109 = new IMMentionViewType("AI_KNOWLEDGE_DEPARTMENT", 15);
        AI_KNOWLEDGE_DEPARTMENT = r109;
        IMMentionViewType r116 = new IMMentionViewType("LOADING", 16);
        LOADING = r116;
        IMMentionViewType[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        f431658a = r117;
        f431659b = EnumEntriesKt.enumEntries(r117);
    }

    public static IMMentionViewType[] values() {
        return (IMMentionViewType[]) f431658a.clone();
    }

    public static IMMentionViewType valueOf(String r100) {
        return (IMMentionViewType) a.a(IMMentionViewType.class, r100);
    }

    public IMMentionViewType(String r100, int r101) {
        super(r100, r101);
    }
}
