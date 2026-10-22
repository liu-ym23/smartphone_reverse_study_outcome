package com.ss.android.ugc.aweme.search.common.setting.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/setting/bean/SearchBcm;", "", "", "bizKey", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "pageId", "c", "bcmKey", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchBcm {

    @SerializedName("bcm_key")
    private final String bcmKey;

    @SerializedName("biz_key")
    private final String bizKey;

    @SerializedName(a.KEY_PAGE_ID)
    private final String pageId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchBcm) == false) goto L12;
        SearchBcm r101 = (SearchBcm) r100;
        if (Intrinsics.areEqual(this.bizKey, r101.bizKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bcmKey, r101.bcmKey) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.bizKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bcmKey;
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
        return "SearchBcm(bizKey=" + this.bizKey + ", pageId=" + this.pageId + ", bcmKey=" + this.bcmKey + ")";
    }

    public SearchBcm() {
        this.bizKey = null;
        this.pageId = null;
        this.bcmKey = null;
    }

    public final String a() {
        return this.bcmKey;
    }

    public final String b() {
        return this.bizKey;
    }

    public final String c() {
        return this.pageId;
    }
}
