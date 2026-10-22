package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ECSearchBoxAndPhotoConfig;", "", "ecSearchSaasUseSearchBar", "", "(I)V", "getEcSearchSaasUseSearchBar", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBoxAndPhotoConfig {

    @SerializedName("ec_search_saas_use_search_bar")
    private final int ecSearchSaasUseSearchBar;

    public ECSearchBoxAndPhotoConfig() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ ECSearchBoxAndPhotoConfig copy$default(ECSearchBoxAndPhotoConfig r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.ecSearchSaasUseSearchBar;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.ecSearchSaasUseSearchBar;
    }

    public final ECSearchBoxAndPhotoConfig copy(int r100) {
        return new ECSearchBoxAndPhotoConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchBoxAndPhotoConfig) == true) goto L6;
        return false;
    L6:
        if (this.ecSearchSaasUseSearchBar == ((ECSearchBoxAndPhotoConfig) r100).ecSearchSaasUseSearchBar) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.ecSearchSaasUseSearchBar;
    }

    public String toString() {
        return "ECSearchBoxAndPhotoConfig(ecSearchSaasUseSearchBar=" + this.ecSearchSaasUseSearchBar + ")";
    }

    public final int getEcSearchSaasUseSearchBar() {
        return this.ecSearchSaasUseSearchBar;
    }

    public ECSearchBoxAndPhotoConfig(int r100) {
        this.ecSearchSaasUseSearchBar = r100;
    }

    public /* synthetic */ ECSearchBoxAndPhotoConfig(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
