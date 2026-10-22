package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/dto/info/KnowledgeUserClickType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "DEFAULT_BACK_UP", "REFRENCE", "SECTION_TITLE", "LOADING_STATE", "GO_TO_MAIN", "UNFOLD", "FOLD", "ANSWER_CONTENT", "CHAT_JUMP", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KnowledgeUserClickType extends Enum<KnowledgeUserClickType> {
    public static final KnowledgeUserClickType ANSWER_CONTENT = null;
    public static final KnowledgeUserClickType CHAT_JUMP = null;
    public static final KnowledgeUserClickType DEFAULT_BACK_UP = null;
    public static final KnowledgeUserClickType FOLD = null;
    public static final KnowledgeUserClickType GO_TO_MAIN = null;
    public static final KnowledgeUserClickType LOADING_STATE = null;
    public static final KnowledgeUserClickType REFRENCE = null;
    public static final KnowledgeUserClickType SECTION_TITLE = null;
    public static final KnowledgeUserClickType UNFOLD = null;
    public static final KnowledgeUserClickType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KnowledgeUserClickType[] f440158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440159b = null;

    public static EnumEntries<KnowledgeUserClickType> getEntries() {
        return f440159b;
    }

    static {
        KnowledgeUserClickType r100 = new KnowledgeUserClickType("UNKNOWN", 0);
        UNKNOWN = r100;
        KnowledgeUserClickType r101 = new KnowledgeUserClickType("DEFAULT_BACK_UP", 1);
        DEFAULT_BACK_UP = r101;
        KnowledgeUserClickType r102 = new KnowledgeUserClickType("REFRENCE", 2);
        REFRENCE = r102;
        KnowledgeUserClickType r103 = new KnowledgeUserClickType("SECTION_TITLE", 3);
        SECTION_TITLE = r103;
        KnowledgeUserClickType r104 = new KnowledgeUserClickType("LOADING_STATE", 4);
        LOADING_STATE = r104;
        KnowledgeUserClickType r105 = new KnowledgeUserClickType("GO_TO_MAIN", 5);
        GO_TO_MAIN = r105;
        KnowledgeUserClickType r110 = new KnowledgeUserClickType("UNFOLD", 6);
        UNFOLD = r110;
        KnowledgeUserClickType r111 = new KnowledgeUserClickType("FOLD", 7);
        FOLD = r111;
        KnowledgeUserClickType r112 = new KnowledgeUserClickType("ANSWER_CONTENT", 8);
        ANSWER_CONTENT = r112;
        KnowledgeUserClickType r113 = new KnowledgeUserClickType("CHAT_JUMP", 9);
        CHAT_JUMP = r113;
        KnowledgeUserClickType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f440158a = r114;
        f440159b = EnumEntriesKt.enumEntries(r114);
    }

    public static KnowledgeUserClickType[] values() {
        return (KnowledgeUserClickType[]) f440158a.clone();
    }

    public static KnowledgeUserClickType valueOf(String r100) {
        return (KnowledgeUserClickType) r27.a.a(KnowledgeUserClickType.class, r100);
    }

    public KnowledgeUserClickType(String r100, int r101) {
        super(r100, r101);
    }
}
