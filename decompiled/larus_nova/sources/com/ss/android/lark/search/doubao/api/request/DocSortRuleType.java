package com.ss.android.lark.search.doubao.api.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/search/doubao/api/request/DocSortRuleType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT_TYPE", "OPEN_TIME", "EDIT_TIME", "EDIT_TIME_ASC", "FILTER_OPEN", "FILTER_EDIT", "MSG_CREATE_TIME", "ENTITY_CREATE_TIME_ASC", "ENTITY_CREATE_TIME_DESC", "TAG_TIME_ASC", "TAG_TIME_DESC", "CREATE_TIME", "Companion", "search-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocSortRuleType extends Enum<DocSortRuleType> {
    public static final DocSortRuleType CREATE_TIME = null;
    public static final a Companion = null;
    public static final DocSortRuleType DEFAULT_TYPE = null;
    public static final DocSortRuleType EDIT_TIME = null;
    public static final DocSortRuleType EDIT_TIME_ASC = null;
    public static final DocSortRuleType ENTITY_CREATE_TIME_ASC = null;
    public static final DocSortRuleType ENTITY_CREATE_TIME_DESC = null;
    public static final DocSortRuleType FILTER_EDIT = null;
    public static final DocSortRuleType FILTER_OPEN = null;
    public static final DocSortRuleType MSG_CREATE_TIME = null;
    public static final DocSortRuleType OPEN_TIME = null;
    public static final DocSortRuleType TAG_TIME_ASC = null;
    public static final DocSortRuleType TAG_TIME_DESC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocSortRuleType[] f439942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439943b = null;
    private final int value;

    public static EnumEntries<DocSortRuleType> getEntries() {
        return f439943b;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.ss.android.lark.search.doubao.api.request.DocSortRuleType$a] */
    static {
        DocSortRuleType r100 = new DocSortRuleType("DEFAULT_TYPE", 0, 1);
        DEFAULT_TYPE = r100;
        DocSortRuleType r101 = new DocSortRuleType("OPEN_TIME", 1, 2);
        OPEN_TIME = r101;
        DocSortRuleType r102 = new DocSortRuleType("EDIT_TIME", 2, 4);
        EDIT_TIME = r102;
        DocSortRuleType r103 = new DocSortRuleType("EDIT_TIME_ASC", 3, 5);
        EDIT_TIME_ASC = r103;
        DocSortRuleType r104 = new DocSortRuleType("FILTER_OPEN", 4, 8);
        FILTER_OPEN = r104;
        DocSortRuleType r110 = new DocSortRuleType("FILTER_EDIT", 5, 16);
        FILTER_EDIT = r110;
        DocSortRuleType r111 = new DocSortRuleType("MSG_CREATE_TIME", 6, 32);
        MSG_CREATE_TIME = r111;
        DocSortRuleType r112 = new DocSortRuleType("ENTITY_CREATE_TIME_ASC", 7, 64);
        ENTITY_CREATE_TIME_ASC = r112;
        DocSortRuleType r105 = new DocSortRuleType("ENTITY_CREATE_TIME_DESC", 8, 65);
        ENTITY_CREATE_TIME_DESC = r105;
        DocSortRuleType r113 = new DocSortRuleType("TAG_TIME_ASC", 9, 128);
        TAG_TIME_ASC = r113;
        DocSortRuleType r106 = new DocSortRuleType("TAG_TIME_DESC", 10, 129);
        TAG_TIME_DESC = r106;
        DocSortRuleType r107 = new DocSortRuleType("CREATE_TIME", 11, 256);
        CREATE_TIME = r107;
        DocSortRuleType[] r108 = {r100, r101, r102, r103, r104, r110, r111, r112, r105, r113, r106, r107};
        f439942a = r108;
        f439943b = EnumEntriesKt.enumEntries(r108);
        Companion = new a();
    }

    public static DocSortRuleType[] values() {
        return (DocSortRuleType[]) f439942a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DocSortRuleType valueOf(String r100) {
        return (DocSortRuleType) r27.a.a(DocSortRuleType.class, r100);
    }

    public DocSortRuleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
