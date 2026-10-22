package com.bytedance.android.shopping.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/i;", "", "", "enter_type", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "mallSearchPitayaBusinessName", "Ljava/lang/String;", "getMallSearchPitayaBusinessName", "()Ljava/lang/String;", "mallSearchPitayaRuleName", "getMallSearchPitayaRuleName", "", "pageNameList", "Ljava/util/List;", "b", "()Ljava/util/List;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("enter_type")
    private final Integer enter_type;

    @SerializedName("business_name")
    private final String mallSearchPitayaBusinessName;

    @SerializedName("rule_name")
    private final String mallSearchPitayaRuleName;

    @SerializedName("page_name_list")
    private final List<String> pageNameList;

    public static final class a {
    }

    static {
    }

    public i() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L14;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.enter_type, r4.enter_type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mallSearchPitayaBusinessName, r4.mallSearchPitayaBusinessName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mallSearchPitayaRuleName, r4.mallSearchPitayaRuleName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageNameList, r4.pageNameList) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.enter_type;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.mallSearchPitayaBusinessName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mallSearchPitayaRuleName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.pageNameList;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSearchPitayaRefreshConfig(enter_type=" + this.enter_type + ", mallSearchPitayaBusinessName=" + this.mallSearchPitayaBusinessName + ", mallSearchPitayaRuleName=" + this.mallSearchPitayaRuleName + ", pageNameList=" + this.pageNameList + ")";
    }

    public final Integer a() {
        return this.enter_type;
    }

    public final List<String> b() {
        return this.pageNameList;
    }

    public i(Object r1) {
        this.enter_type = 0;
        this.mallSearchPitayaBusinessName = "";
        this.mallSearchPitayaRuleName = "";
        this.pageNameList = null;
    }
}
