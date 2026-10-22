package com.bytedance.ee.bear.quoto;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public class BusinessInfoRequester$BusinessInfoResult implements NonProguard {

    @SerializedName("admins")
    public List<BusinessInfoRequester$BusinessAdminInfo> admins;

    @SerializedName("is_admin")
    public Boolean isAdmin;

    @SerializedName("suite_to_file_size_limit")
    public HashMap<String, Long> suiteToFileSizeLimit;

    @SerializedName("suite_type")
    public String suiteType;

    public BusinessInfoRequester$BusinessInfoResult() {
    }

    public Long getMaxSize() {
        HashMap<String, Long> r100 = this.suiteToFileSizeLimit;
        long r101 = 0;
        if (r100 == null) goto L19;
        if (r100.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, Long>> r102 = this.suiteToFileSizeLimit.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        Long r103 = r102.next().getValue();
        if (r103 == null) goto L9;
        if (r101 >= r103.longValue()) goto L9;
        r101 = r103.longValue();
        goto L9
    L17:
        return Long.valueOf(r101);
    L19:
        return 0L;
    }

    public boolean hasSupportSuite() {
        Iterator<Map.Entry<String, Long>> r100 = this.suiteToFileSizeLimit.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next().getKey();
        if (CollectionsKt.contains(k0.f236413a, r101) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public boolean isNotSupportLarkSuite() {
        Iterator<Map.Entry<String, Long>> r100 = this.suiteToFileSizeLimit.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next().getKey();
        if (CollectionsKt.contains(k0.f236414b, r101) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public String toString() {
        return "BusinessInfoResult{suiteType='" + this.suiteType + "', suiteToFileSizeLimit='" + this.suiteToFileSizeLimit + "', isAdmin=" + this.isAdmin + '}';
    }

    public Map<String, Long> getSuiteToFileSizeLimitMap() {
        return this.suiteToFileSizeLimit;
    }
}
