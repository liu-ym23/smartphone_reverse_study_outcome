package com.ss.android.ugc.aweme.search.common.setting.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/setting/bean/SearchBcmBean;", "", "", "enterFrom", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/ss/android/ugc/aweme/search/common/setting/bean/SearchBcm;", "info", "Lcom/ss/android/ugc/aweme/search/common/setting/bean/SearchBcm;", "b", "()Lcom/ss/android/ugc/aweme/search/common/setting/bean/SearchBcm;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchBcmBean {

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("info")
    private final SearchBcm info;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchBcmBean) == false) goto L10;
        SearchBcmBean r101 = (SearchBcmBean) r100;
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.info, r101.info) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.enterFrom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SearchBcm r104 = this.info;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SearchBcmBean(enterFrom=" + this.enterFrom + ", info=" + this.info + ")";
    }

    public SearchBcmBean() {
        this.enterFrom = null;
        this.info = null;
    }

    public final String a() {
        return this.enterFrom;
    }

    public final SearchBcm b() {
        return this.info;
    }
}
