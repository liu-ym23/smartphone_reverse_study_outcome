package com.ss.android.ugc.aweme.shortvideo.beauty;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautifyUesTabInfo;", "", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "categoryName", "getCategoryName", "", "categoryDiy", "Z", "getCategoryDiy", "()Z", "", "parentNameList", "Ljava/util/List;", "getParentNameList", "()Ljava/util/List;", "", "parentValueList", "getParentValueList", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class BeautifyUesTabInfo {

    @SerializedName("category_diy")
    private final boolean categoryDiy;

    @SerializedName("category_name")
    private final String categoryName;

    @SerializedName("name_array")
    private final List<String> parentNameList;

    @SerializedName("value_array")
    private final List<Integer> parentValueList;

    @SerializedName(a.KEY_TAB_NAME)
    private final String tabName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BeautifyUesTabInfo) == false) goto L16;
        BeautifyUesTabInfo r101 = (BeautifyUesTabInfo) r100;
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.categoryName, r101.categoryName) == true) goto L10;
        return false;
    L10:
        if (this.categoryDiy == r101.categoryDiy) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentNameList, r101.parentNameList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.parentValueList, r101.parentValueList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        String r100 = this.tabName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.categoryName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.categoryDiy;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.parentNameList;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = this.parentValueList;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BeautifyUesTabInfo(tabName=" + this.tabName + ", categoryName=" + this.categoryName + ", categoryDiy=" + this.categoryDiy + ", parentNameList=" + this.parentNameList + ", parentValueList=" + this.parentValueList + ")";
    }

    public BeautifyUesTabInfo() {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Intrinsics.checkNotNullParameter("", "tabName");
        Intrinsics.checkNotNullParameter("", "categoryName");
        Intrinsics.checkNotNullParameter(r100, "parentNameList");
        Intrinsics.checkNotNullParameter(r101, "parentValueList");
        this.tabName = "";
        this.categoryName = "";
        this.categoryDiy = false;
        this.parentNameList = r100;
        this.parentValueList = r101;
    }
}
