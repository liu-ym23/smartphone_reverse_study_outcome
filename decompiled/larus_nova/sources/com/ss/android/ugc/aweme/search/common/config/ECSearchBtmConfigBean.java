package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ECSearchBtmConfigBean;", "", "", "middleBtm", "Ljava/lang/String;", "getMiddleBtm", "()Ljava/lang/String;", "sugBtm", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/search/common/config/ECSearchResultBtmConfig;", "result", "Lcom/ss/android/ugc/aweme/search/common/config/ECSearchResultBtmConfig;", "getResult", "()Lcom/ss/android/ugc/aweme/search/common/config/ECSearchResultBtmConfig;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBtmConfigBean {

    @SerializedName("middle")
    private final String middleBtm;

    @SerializedName("result")
    private final ECSearchResultBtmConfig result;

    @SerializedName("sug")
    private final String sugBtm;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchBtmConfigBean) == false) goto L12;
        ECSearchBtmConfigBean r101 = (ECSearchBtmConfigBean) r100;
        if (Intrinsics.areEqual(this.middleBtm, r101.middleBtm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sugBtm, r101.sugBtm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.result, r101.result) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.middleBtm;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.sugBtm;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECSearchResultBtmConfig r107 = this.result;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECSearchBtmConfigBean(middleBtm=" + this.middleBtm + ", sugBtm=" + this.sugBtm + ", result=" + this.result + ")";
    }

    public ECSearchBtmConfigBean() {
        this.middleBtm = null;
        this.sugBtm = null;
        this.result = null;
    }

    public final String a() {
        return this.sugBtm;
    }
}
