package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/a;", "", "", "verifyMode", "I", "getVerifyMode", "()I", "", "version", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/c;", "jsbAllowList", "Ljava/util/Map;", "getJsbAllowList", "()Ljava/util/Map;", "Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/b;", "paramLimitSetting", "getParamLimitSetting", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("jsb_allow_list")
    private final Map<String, c> jsbAllowList;

    @SerializedName("param_limit_setting")
    private final Map<String, b> paramLimitSetting;

    @SerializedName("verify_mode")
    private final int verifyMode;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (this.verifyMode == r4.verifyMode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.version, r4.version) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jsbAllowList, r4.jsbAllowList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.paramLimitSetting, r4.paramLimitSetting) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.verifyMode * 31;
        String r1 = this.version;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Map<String, c> r5 = this.jsbAllowList;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, b> r8 = this.paramLimitSetting;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ECStoreJsbPolicy(verifyMode=" + this.verifyMode + ", version=" + this.version + ", jsbAllowList=" + this.jsbAllowList + ", paramLimitSetting=" + this.paramLimitSetting + ")";
    }

    public a() {
        this.verifyMode = 0;
        this.version = null;
        this.jsbAllowList = null;
        this.paramLimitSetting = null;
    }

    public final String a() {
        return this.version;
    }
}
