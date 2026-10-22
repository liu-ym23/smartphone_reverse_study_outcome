package com.bytedance.ee.bear.quoto;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        HashMap<String, Long> r0 = this.suiteToFileSizeLimit;
        long r1 = 0;
        if (r0 == null) goto L19;
        if (r0.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, Long>> r2 = this.suiteToFileSizeLimit.entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        Long r3 = r2.next().getValue();
        if (r3 == null) goto L9;
        if (r1 >= r3.longValue()) goto L9;
        r1 = r3.longValue();
        goto L9
    L17:
        return Long.valueOf(r1);
    L19:
        return 0L;
    }

    public boolean hasSupportSuite() {
        Iterator<Map.Entry<String, Long>> r0 = this.suiteToFileSizeLimit.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next().getKey();
        if (CollectionsKt.contains(k0.a, r1) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public boolean isNotSupportLarkSuite() {
        Iterator<Map.Entry<String, Long>> r0 = this.suiteToFileSizeLimit.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next().getKey();
        if (CollectionsKt.contains(k0.b, r1) == false) goto L4;
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
