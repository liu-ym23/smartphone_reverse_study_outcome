package com.bytedance.ee.bear.bitable.common.query;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/query/EQueryType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GET_FILTER_INFO", "GET_FILTER_OPTIONS", "GET_FILTER_DURATIONS", "GET_FIELD_USER_OPTIONS", "GET_FIELD_LINK_OPTIONS", "GET_SORT_DATA", "GET_TABLE_LAYOUT_SETTING", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EQueryType extends Enum<EQueryType> {
    public static final EQueryType GET_FIELD_LINK_OPTIONS = null;
    public static final EQueryType GET_FIELD_USER_OPTIONS = null;
    public static final EQueryType GET_FILTER_DURATIONS = null;
    public static final EQueryType GET_FILTER_INFO = null;
    public static final EQueryType GET_FILTER_OPTIONS = null;
    public static final EQueryType GET_SORT_DATA = null;
    public static final EQueryType GET_TABLE_LAYOUT_SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EQueryType[] f209864a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209865b = null;
    private final String value;

    public static EnumEntries<EQueryType> getEntries() {
        return f209865b;
    }

    static {
        EQueryType r100 = new EQueryType("GET_FILTER_INFO", 0, "getFilterInfo");
        GET_FILTER_INFO = r100;
        EQueryType r101 = new EQueryType("GET_FILTER_OPTIONS", 1, "getFilterOptions");
        GET_FILTER_OPTIONS = r101;
        EQueryType r102 = new EQueryType("GET_FILTER_DURATIONS", 2, "getFilterDurations");
        GET_FILTER_DURATIONS = r102;
        EQueryType r103 = new EQueryType("GET_FIELD_USER_OPTIONS", 3, "getFieldUserOptions");
        GET_FIELD_USER_OPTIONS = r103;
        EQueryType r104 = new EQueryType("GET_FIELD_LINK_OPTIONS", 4, "getFieldLinkOptions");
        GET_FIELD_LINK_OPTIONS = r104;
        EQueryType r105 = new EQueryType("GET_SORT_DATA", 5, "getSortData");
        GET_SORT_DATA = r105;
        EQueryType r110 = new EQueryType("GET_TABLE_LAYOUT_SETTING", 6, "getTableLayoutSetting");
        GET_TABLE_LAYOUT_SETTING = r110;
        EQueryType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f209864a = r111;
        f209865b = EnumEntriesKt.enumEntries(r111);
    }

    public static EQueryType[] values() {
        return (EQueryType[]) f209864a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EQueryType valueOf(String r100) {
        return (EQueryType) a.a(EQueryType.class, r100);
    }

    public EQueryType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
