package com.ss.android.ugc.aweme.discover.tab;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/tab/SelectedData;", "", "", "selectedTab", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setSelectedTab", "(Ljava/lang/String;)V", "passParams", "getPassParams", "setPassParams", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedData {

    @SerializedName("pass_through_params")
    private String passParams;

    @SerializedName("tab_type")
    private String selectedTab;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SelectedData) == false) goto L10;
        SelectedData r101 = (SelectedData) r100;
        if (Intrinsics.areEqual(this.selectedTab, r101.selectedTab) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.passParams, r101.passParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.selectedTab;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.passParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SelectedData(selectedTab=" + this.selectedTab + ", passParams=" + this.passParams + ")";
    }

    public SelectedData() {
        this.selectedTab = "";
        this.passParams = "";
    }

    public final String a() {
        return this.selectedTab;
    }
}
