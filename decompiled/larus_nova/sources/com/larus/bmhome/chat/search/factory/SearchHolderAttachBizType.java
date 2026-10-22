package com.larus.bmhome.chat.search.factory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/search/factory/SearchHolderAttachBizType;", "", "<init>", "(Ljava/lang/String;I)V", "RichVideoCardDoubleColumn", "Other", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchHolderAttachBizType extends Enum<SearchHolderAttachBizType> {
    public static final SearchHolderAttachBizType Other = null;
    public static final SearchHolderAttachBizType RichVideoCardDoubleColumn = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchHolderAttachBizType[] f308631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308632b = null;

    public static EnumEntries<SearchHolderAttachBizType> getEntries() {
        return f308632b;
    }

    static {
        SearchHolderAttachBizType r100 = new SearchHolderAttachBizType("RichVideoCardDoubleColumn", 0);
        RichVideoCardDoubleColumn = r100;
        SearchHolderAttachBizType r101 = new SearchHolderAttachBizType("Other", 1);
        Other = r101;
        SearchHolderAttachBizType[] r102 = {r100, r101};
        f308631a = r102;
        f308632b = EnumEntriesKt.enumEntries(r102);
    }

    public static SearchHolderAttachBizType[] values() {
        return (SearchHolderAttachBizType[]) f308631a.clone();
    }

    public static SearchHolderAttachBizType valueOf(String r100) {
        return (SearchHolderAttachBizType) a.a(SearchHolderAttachBizType.class, r100);
    }

    public SearchHolderAttachBizType(String r100, int r101) {
        super(r100, r101);
    }
}
