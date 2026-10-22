package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/search/dto/info/KnowledgeSearchPosition;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHAT", "GENERAL", "DOC_TAB", "MESSAGE_TAB", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KnowledgeSearchPosition extends Enum<KnowledgeSearchPosition> {
    public static final KnowledgeSearchPosition CHAT = null;
    public static final KnowledgeSearchPosition DOC_TAB = null;
    public static final KnowledgeSearchPosition GENERAL = null;
    public static final KnowledgeSearchPosition MESSAGE_TAB = null;
    public static final KnowledgeSearchPosition UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KnowledgeSearchPosition[] f440156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440157b = null;

    public static EnumEntries<KnowledgeSearchPosition> getEntries() {
        return f440157b;
    }

    static {
        KnowledgeSearchPosition r100 = new KnowledgeSearchPosition("UNKNOWN", 0);
        UNKNOWN = r100;
        KnowledgeSearchPosition r101 = new KnowledgeSearchPosition("CHAT", 1);
        CHAT = r101;
        KnowledgeSearchPosition r102 = new KnowledgeSearchPosition("GENERAL", 2);
        GENERAL = r102;
        KnowledgeSearchPosition r103 = new KnowledgeSearchPosition("DOC_TAB", 3);
        DOC_TAB = r103;
        KnowledgeSearchPosition r104 = new KnowledgeSearchPosition("MESSAGE_TAB", 4);
        MESSAGE_TAB = r104;
        KnowledgeSearchPosition[] r105 = {r100, r101, r102, r103, r104};
        f440156a = r105;
        f440157b = EnumEntriesKt.enumEntries(r105);
    }

    public static KnowledgeSearchPosition[] values() {
        return (KnowledgeSearchPosition[]) f440156a.clone();
    }

    public static KnowledgeSearchPosition valueOf(String r100) {
        return (KnowledgeSearchPosition) r27.a.a(KnowledgeSearchPosition.class, r100);
    }

    public KnowledgeSearchPosition(String r100, int r101) {
        super(r100, r101);
    }
}
