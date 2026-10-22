package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0000J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilterInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", FilterData.FilterSheetItem.Id.FILTER_VALUE, "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilter;", "filterOption", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilterOption;", "isLastFilterOptionEmpty", "", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilter;Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilterOption;Z)V", "getFilterValue", "()Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilter;", "getFilterOption", "()Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilterOption;", "()Z", "isEmptyFilter", "isEmptyFilterOption", "isSameFilterWith", "filterInfo", "filter", "isFilterOptionContainFilterWith", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceFilterInfo implements NonProguard {
    public static final a Companion = null;
    private static final WikiSpaceFilter NoFilter = null;
    private static final WikiSpaceFilterInfo NoFilterInfo = null;
    private static final WikiSpaceFilterOption NoFilterOption = null;
    private final WikiSpaceFilterOption filterOption;
    private final WikiSpaceFilter filterValue;
    private final boolean isLastFilterOptionEmpty;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        WikiSpaceFilter r2 = new WikiSpaceFilter("all", "all");
        NoFilter = r2;
        WikiSpaceFilterOption r3 = new WikiSpaceFilterOption(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        NoFilterOption = r3;
        NoFilterInfo = new WikiSpaceFilterInfo(r2, r3, false, 4, null);
    }

    public final boolean isEmptyFilter() {
        return this.filterValue.isEmptyFilter();
    }

    public final boolean isEmptyFilterOption() {
        if (this.filterOption.getSpaceTypes().isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.filterOption.getSpaceClassifications().isEmpty() == false) goto L7;
        return true;
    }

    public static final /* synthetic */ WikiSpaceFilter access$getNoFilter$cp() {
        return NoFilter;
    }

    public static final /* synthetic */ WikiSpaceFilterInfo access$getNoFilterInfo$cp() {
        return NoFilterInfo;
    }

    public static final /* synthetic */ WikiSpaceFilterOption access$getNoFilterOption$cp() {
        return NoFilterOption;
    }

    public final WikiSpaceFilterOption getFilterOption() {
        return this.filterOption;
    }

    public final WikiSpaceFilter getFilterValue() {
        return this.filterValue;
    }

    public final boolean isLastFilterOptionEmpty() {
        return this.isLastFilterOptionEmpty;
    }

    public final boolean isFilterOptionContainFilterWith(WikiSpaceFilterInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "filterInfo");
        WikiSpaceFilterOption r0 = this.filterOption;
        WikiSpaceFilter r11 = r10.filterValue;
        Object r3 = null;
        if (Intrinsics.areEqual(r11.getSpaceTypeId(), "all") == true) goto L14;
        Iterator<T> r1 = r0.getSpaceTypes().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r6 = r1.next();
        if (Intrinsics.areEqual(((WikiSpaceType) r6).getSpaceTypeId(), r11.getSpaceTypeId()) == false) goto L6;
    L11:
        if (r6 != null) goto L14;
        boolean r2 = false;
    L16:
        if (Intrinsics.areEqual(r11.getSpaceClassId(), "all") == true) goto L26;
        Iterator<T> r4 = r0.getSpaceClassifications().iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((WikiSpaceClassification) r5).getSpaceClassId(), r11.getSpaceClassId()) == false) goto L19;
        r3 = r5;
    L23:
        if (r3 != null) goto L26;
        boolean r12 = false;
    L27:
        if (r2 == false) goto L37;
        if (r12 == false) goto L38;
        return true;
    L38:
        return false;
    L37:
        return false;
    L26:
        r12 = true;
        goto L27
    L10:
        r6 = null;
    L14:
        r2 = true;
        goto L16
    }

    public final boolean isSameFilterWith(WikiSpaceFilter r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        if (Intrinsics.areEqual(this.filterValue.getSpaceTypeId(), r3.getSpaceTypeId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.filterValue.getSpaceClassId(), r3.getSpaceClassId()) == false) goto L7;
        return true;
    }

    public final boolean isSameFilterWith(WikiSpaceFilterInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "filterInfo");
        return isSameFilterWith(r2.filterValue);
    }

    public WikiSpaceFilterInfo(WikiSpaceFilter r2, WikiSpaceFilterOption r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, FilterData.FilterSheetItem.Id.FILTER_VALUE);
        Intrinsics.checkNotNullParameter(r3, "filterOption");
        this.filterValue = r2;
        this.filterOption = r3;
        this.isLastFilterOptionEmpty = r4;
    }

    public /* synthetic */ WikiSpaceFilterInfo(WikiSpaceFilter r1, WikiSpaceFilterOption r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        this(r1, r2, r3);
    }
}
