package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
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
        WikiSpaceFilter r100 = new WikiSpaceFilter("all", "all");
        NoFilter = r100;
        WikiSpaceFilterOption r101 = new WikiSpaceFilterOption(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        NoFilterOption = r101;
        NoFilterInfo = new WikiSpaceFilterInfo(r100, r101, false, 4, null);
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

    public final boolean isFilterOptionContainFilterWith(WikiSpaceFilterInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "filterInfo");
        WikiSpaceFilterOption r100 = this.filterOption;
        WikiSpaceFilter r111 = r110.filterValue;
        Object r101 = null;
        if (Intrinsics.areEqual(r111.getSpaceTypeId(), "all") == true) goto L14;
        Iterator<T> r102 = r100.getSpaceTypes().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((WikiSpaceType) r103).getSpaceTypeId(), r111.getSpaceTypeId()) == false) goto L6;
    L11:
        if (r103 != null) goto L14;
        boolean r104 = false;
    L16:
        if (Intrinsics.areEqual(r111.getSpaceClassId(), "all") == true) goto L26;
        Iterator<T> r105 = r100.getSpaceClassifications().iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((WikiSpaceClassification) r106).getSpaceClassId(), r111.getSpaceClassId()) == false) goto L19;
        r101 = r106;
    L23:
        if (r101 != null) goto L26;
        boolean r112 = false;
    L27:
        if (r104 == false) goto L37;
        if (r112 == false) goto L38;
        return true;
    L38:
        return false;
    L37:
        return false;
    L26:
        r112 = true;
        goto L27
    L10:
        r103 = null;
    L14:
        r104 = true;
        goto L16
    }

    public final boolean isSameFilterWith(WikiSpaceFilter r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        if (Intrinsics.areEqual(this.filterValue.getSpaceTypeId(), r100.getSpaceTypeId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.filterValue.getSpaceClassId(), r100.getSpaceClassId()) == false) goto L7;
        return true;
    }

    public final boolean isSameFilterWith(WikiSpaceFilterInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "filterInfo");
        return isSameFilterWith(r100.filterValue);
    }

    public WikiSpaceFilterInfo(WikiSpaceFilter r100, WikiSpaceFilterOption r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, FilterData.FilterSheetItem.Id.FILTER_VALUE);
        Intrinsics.checkNotNullParameter(r101, "filterOption");
        this.filterValue = r100;
        this.filterOption = r101;
        this.isLastFilterOptionEmpty = r102;
    }

    public /* synthetic */ WikiSpaceFilterInfo(WikiSpaceFilter r100, WikiSpaceFilterOption r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = true;
    L5:
        this(r100, r101, r102);
    }
}
