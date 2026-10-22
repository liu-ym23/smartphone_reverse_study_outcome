package com.bytedance.ee.bear.sheet.filter;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterItemEnum;", "", WidgetService.PARAM_FRAGMENT, "Ljava/lang/Class;", "<init>", "(Ljava/lang/String;ILjava/lang/Class;)V", "getFragment", "()Ljava/lang/Class;", "setFragment", "(Ljava/lang/Class;)V", FilterData.FilterSheetItem.Id.FILTER_VALUE, FilterData.FilterSheetItem.Id.FILTER_COLOR, FilterData.FilterSheetItem.Id.FILTER_CONDITION, "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilterItemEnum extends Enum<FilterItemEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterItemEnum[] f237693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f237694b = null;
    public static final FilterItemEnum filterColor = null;
    public static final FilterItemEnum filterCondition = null;
    public static final FilterItemEnum filterValue = null;
    private Class<?> fragment;

    public static EnumEntries<FilterItemEnum> getEntries() {
        return f237694b;
    }

    static {
        FilterItemEnum r100 = new FilterItemEnum(FilterData.FilterSheetItem.Id.FILTER_VALUE, 0, SubFilterValueFragment.class);
        filterValue = r100;
        FilterItemEnum r101 = new FilterItemEnum(FilterData.FilterSheetItem.Id.FILTER_COLOR, 1, SubFilterColorFragment.class);
        filterColor = r101;
        FilterItemEnum r102 = new FilterItemEnum(FilterData.FilterSheetItem.Id.FILTER_CONDITION, 2, SubFilterConditionFragment.class);
        filterCondition = r102;
        FilterItemEnum[] r103 = {r100, r101, r102};
        f237693a = r103;
        f237694b = EnumEntriesKt.enumEntries(r103);
    }

    public static FilterItemEnum[] values() {
        return (FilterItemEnum[]) f237693a.clone();
    }

    public final Class<?> getFragment() {
        return this.fragment;
    }

    public static FilterItemEnum valueOf(String r100) {
        return (FilterItemEnum) r27.a.a(FilterItemEnum.class, r100);
    }

    public final void setFragment(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fragment = r100;
    }

    public FilterItemEnum(String r100, int r101, Class r102) {
        super(r100, r101);
        this.fragment = r102;
    }
}
