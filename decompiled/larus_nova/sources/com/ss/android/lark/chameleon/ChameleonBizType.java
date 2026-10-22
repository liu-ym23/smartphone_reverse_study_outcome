package com.ss.android.lark.chameleon;

import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonBizType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "BIZ_DOCS", "BIZ_SLIDES", "BIZ_SPACE", "BIZ_WORKSPACE", "BIZ_WORKSPACE_V2", "BIZ_WORKSPACE_V2_PRE", "BIZ_WORKSPACE_V2_SUBPAGE", "BIZ_AI_PERMISSION", "BIZ_PROFILE", "BIZ_PROFILE_SUBPAGE", "BIZ_MAIL_BIND_PERSONAL_PAGE", "BIZ_KNOWLEDGE_AI", "BIZ_TODO_TAB", "BIZ_TODO_PAGE", "BIZ_CHAT", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChameleonBizType extends Enum<ChameleonBizType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ChameleonBizType[] $VALUES = null;
    public static final ChameleonBizType BIZ_AI_PERMISSION = null;
    public static final ChameleonBizType BIZ_CHAT = null;
    public static final ChameleonBizType BIZ_DOCS = null;
    public static final ChameleonBizType BIZ_KNOWLEDGE_AI = null;
    public static final ChameleonBizType BIZ_MAIL_BIND_PERSONAL_PAGE = null;
    public static final ChameleonBizType BIZ_PROFILE = null;
    public static final ChameleonBizType BIZ_PROFILE_SUBPAGE = null;
    public static final ChameleonBizType BIZ_SLIDES = null;
    public static final ChameleonBizType BIZ_SPACE = null;
    public static final ChameleonBizType BIZ_TODO_PAGE = null;
    public static final ChameleonBizType BIZ_TODO_TAB = null;
    public static final ChameleonBizType BIZ_WORKSPACE = null;
    public static final ChameleonBizType BIZ_WORKSPACE_V2 = null;
    public static final ChameleonBizType BIZ_WORKSPACE_V2_PRE = null;
    public static final ChameleonBizType BIZ_WORKSPACE_V2_SUBPAGE = null;
    private final String type;

    private static final /* synthetic */ ChameleonBizType[] $values() {
        return new ChameleonBizType[]{BIZ_DOCS, BIZ_SLIDES, BIZ_SPACE, BIZ_WORKSPACE, BIZ_WORKSPACE_V2, BIZ_WORKSPACE_V2_PRE, BIZ_WORKSPACE_V2_SUBPAGE, BIZ_AI_PERMISSION, BIZ_PROFILE, BIZ_PROFILE_SUBPAGE, BIZ_MAIL_BIND_PERSONAL_PAGE, BIZ_KNOWLEDGE_AI, BIZ_TODO_TAB, BIZ_TODO_PAGE, BIZ_CHAT};
    }

    public static EnumEntries<ChameleonBizType> getEntries() {
        return $ENTRIES;
    }

    static {
        BIZ_DOCS = new ChameleonBizType("BIZ_DOCS", 0, "document");
        BIZ_SLIDES = new ChameleonBizType("BIZ_SLIDES", 1, "slides");
        BIZ_SPACE = new ChameleonBizType("BIZ_SPACE", 2, "space");
        BIZ_WORKSPACE = new ChameleonBizType("BIZ_WORKSPACE", 3, "workspace");
        BIZ_WORKSPACE_V2 = new ChameleonBizType("BIZ_WORKSPACE_V2", 4, "bytedanceH5V2");
        BIZ_WORKSPACE_V2_PRE = new ChameleonBizType("BIZ_WORKSPACE_V2_PRE", 5, "bytedanceH5V2_pre");
        BIZ_WORKSPACE_V2_SUBPAGE = new ChameleonBizType("BIZ_WORKSPACE_V2_SUBPAGE", 6, "bytedanceH5V2_subpage");
        BIZ_AI_PERMISSION = new ChameleonBizType("BIZ_AI_PERMISSION", 7, "aipermission");
        BIZ_PROFILE = new ChameleonBizType("BIZ_PROFILE", 8, "profile");
        BIZ_PROFILE_SUBPAGE = new ChameleonBizType("BIZ_PROFILE_SUBPAGE", 9, "profile_subpage");
        BIZ_MAIL_BIND_PERSONAL_PAGE = new ChameleonBizType("BIZ_MAIL_BIND_PERSONAL_PAGE", 10, "mail_bind_personal_page");
        BIZ_KNOWLEDGE_AI = new ChameleonBizType("BIZ_KNOWLEDGE_AI", 11, IDomainConfigService.DomainAlias.KNOWLEDGE_AI);
        BIZ_TODO_TAB = new ChameleonBizType("BIZ_TODO_TAB", 12, "biz_todo_tab");
        BIZ_TODO_PAGE = new ChameleonBizType("BIZ_TODO_PAGE", 13, "biz_todo_page");
        BIZ_CHAT = new ChameleonBizType("BIZ_CHAT", 14, "biz_chat");
        ChameleonBizType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ChameleonBizType[] values() {
        return (ChameleonBizType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ChameleonBizType valueOf(String r100) {
        return (ChameleonBizType) a.a(ChameleonBizType.class, r100);
    }

    private ChameleonBizType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
