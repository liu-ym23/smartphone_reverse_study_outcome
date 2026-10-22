package com.bytedance.android.shopping.store.aggregate.classification;

import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0000R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR2\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;", "Ljava/io/Serializable;", "()V", "anchorSubCategoryId", "", "getAnchorSubCategoryId", "()Ljava/lang/String;", "setAnchorSubCategoryId", "(Ljava/lang/String;)V", "mainCategoryItem", "", "getMainCategoryItem", "()Ljava/util/Map;", "setMainCategoryItem", "(Ljava/util/Map;)V", "subCategoryList", "", "getSubCategoryList", "()Ljava/util/List;", "setSubCategoryList", "(Ljava/util/List;)V", "canClassificationPageShowFilterTab", "", "deepCopy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryInfo implements Serializable {

    @SerializedName("anchor_sub_category_id")
    private String anchorSubCategoryId;

    @SerializedName("main_category_item")
    private Map<String, String> mainCategoryItem;

    @SerializedName("sub_category_list")
    private List<? extends Map<String, String>> subCategoryList;

    public CategoryInfo() {
    }

    public final CategoryInfo deepCopy() {
        CategoryInfo r0 = new CategoryInfo();
        Map<String, String> r1 = this.mainCategoryItem;
        ArrayList r2 = null;
        if (r1 == null) goto L5;
        Map<String, String> r3 = MapsKt.toMap(r1);
    L6:
        r0.mainCategoryItem = r3;
        List<? extends Map<String, String>> r4 = this.subCategoryList;
        if (r4 == null) goto L12;
        List<? extends Map<String, String>> r5 = r4;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r2.add(MapsKt.toMap((Map) r6.next()));
    L12:
        r0.subCategoryList = r2;
        r0.anchorSubCategoryId = this.anchorSubCategoryId;
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean canClassificationPageShowFilterTab() {
        if (com.bytedance.android.shopping.store.settings.c.a() != 0) goto L5;
        return false;
    L5:
        List<? extends Map<String, String>> r0 = this.subCategoryList;
        if (r0 != null) goto L8;
    L11:
        return false;
    L8:
        if (k.f(Integer.valueOf(r0.size())) <= 1) goto L11;
        return true;
    }

    public final String getAnchorSubCategoryId() {
        return this.anchorSubCategoryId;
    }

    public final Map<String, String> getMainCategoryItem() {
        return this.mainCategoryItem;
    }

    public final List<Map<String, String>> getSubCategoryList() {
        return this.subCategoryList;
    }

    public final void setAnchorSubCategoryId(String r1) {
        this.anchorSubCategoryId = r1;
    }

    public final void setMainCategoryItem(Map<String, String> r1) {
        this.mainCategoryItem = r1;
    }

    public final void setSubCategoryList(List<? extends Map<String, String>> r1) {
        this.subCategoryList = r1;
    }
}
