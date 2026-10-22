package com.bytedance.ee.bear.sheet.filter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/OfficeFilterItemEnum;", "", "fragment", "Ljava/lang/Class;", "<init>", "(Ljava/lang/String;ILjava/lang/Class;)V", "getFragment", "()Ljava/lang/Class;", "setFragment", "(Ljava/lang/Class;)V", FilterData.FilterSheetItem.Id.FILTER_VALUE, FilterData.FilterSheetItem.Id.FILTER_COLOR, FilterData.FilterSheetItem.Id.FILTER_CONDITION, "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeFilterItemEnum extends Enum<OfficeFilterItemEnum> {
    public static final /* synthetic */ OfficeFilterItemEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final OfficeFilterItemEnum filterColor = null;
    public static final OfficeFilterItemEnum filterCondition = null;
    public static final OfficeFilterItemEnum filterValue = null;
    private Class<?> fragment;

    public static EnumEntries<OfficeFilterItemEnum> getEntries() {
        return b;
    }

    static {
        OfficeFilterItemEnum r0 = new OfficeFilterItemEnum(FilterData.FilterSheetItem.Id.FILTER_VALUE, 0, OfficeSubFilterValueFragment.class);
        filterValue = r0;
        OfficeFilterItemEnum r1 = new OfficeFilterItemEnum(FilterData.FilterSheetItem.Id.FILTER_COLOR, 1, OfficeSubFilterColorFragment.class);
        filterColor = r1;
        OfficeFilterItemEnum r2 = new OfficeFilterItemEnum(FilterData.FilterSheetItem.Id.FILTER_CONDITION, 2, OfficeSubFilterConditionFragment.class);
        filterCondition = r2;
        OfficeFilterItemEnum[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static OfficeFilterItemEnum[] values() {
        return (OfficeFilterItemEnum[]) a.clone();
    }

    public final Class<?> getFragment() {
        return this.fragment;
    }

    public static OfficeFilterItemEnum valueOf(String r1) {
        return (OfficeFilterItemEnum) r27.a.a(OfficeFilterItemEnum.class, r1);
    }

    public final void setFragment(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fragment = r2;
    }

    public OfficeFilterItemEnum(String r1, int r2, Class r3) {
        super(r1, r2);
        this.fragment = r3;
    }
}
