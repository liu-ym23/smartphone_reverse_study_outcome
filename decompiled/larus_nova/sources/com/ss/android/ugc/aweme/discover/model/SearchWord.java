package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchWord;", "Ljava/io/Serializable;", "commonProp", "Lcom/ss/android/ugc/aweme/discover/model/CommonProp;", "elementList", "", "Lcom/ss/android/ugc/aweme/discover/model/Element;", "(Lcom/ss/android/ugc/aweme/discover/model/CommonProp;Ljava/util/List;)V", "getCommonProp", "()Lcom/ss/android/ugc/aweme/discover/model/CommonProp;", "getElementList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchWord implements Serializable {

    @SerializedName("common_prop")
    private final CommonProp commonProp;

    @SerializedName("element_list")
    private final List<Element> elementList;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchWord() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchWord copy$default(SearchWord r100, CommonProp r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.commonProp;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.elementList;
    L9:
        return r100.copy(r101, r102);
    }

    public final CommonProp component1() {
        return this.commonProp;
    }

    public final List<Element> component2() {
        return this.elementList;
    }

    public final SearchWord copy(CommonProp r100, List<Element> r101) {
        return new SearchWord(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchWord) == false) goto L10;
        SearchWord r101 = (SearchWord) r100;
        if (Intrinsics.areEqual(this.commonProp, r101.commonProp) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.elementList, r101.elementList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        CommonProp r100 = this.commonProp;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Element> r104 = this.elementList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SearchWord(commonProp=" + this.commonProp + ", elementList=" + this.elementList + ")";
    }

    public final CommonProp getCommonProp() {
        return this.commonProp;
    }

    public final List<Element> getElementList() {
        return this.elementList;
    }

    public SearchWord(CommonProp r100, List<Element> r101) {
        this.commonProp = r100;
        this.elementList = r101;
    }

    public /* synthetic */ SearchWord(CommonProp r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
