package com.bytedance.env.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/env/api/d;", "", "Lcom/bytedance/env/api/AccessKeyType;", "accessKeyType", "Lcom/bytedance/env/api/AccessKeyType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/env/api/AccessKeyType;", "setAccessKeyType", "(Lcom/bytedance/env/api/AccessKeyType;)V", "", "envLane", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEnvLane", "(Ljava/lang/String;)V", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("accessKeyType")
    private AccessKeyType accessKeyType;

    @SerializedName("envLane")
    private String envLane;

    public d() {
        this(0);
    }

    public final String toString() {
        return "GeckoConfig(accessKeyType=" + this.accessKeyType + ", envLane=" + this.envLane + ")";
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final AccessKeyType a() {
        return this.accessKeyType;
    }

    public final String b() {
        return this.envLane;
    }

    public d(int r100) {
        this.accessKeyType = AccessKeyType.INHOUSE;
        this.envLane = "";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof d) == true) goto L5;
        Object r101 = null;
    L6:
        d r102 = (d) r101;
        if (r102 == null) goto L15;
        if (this.accessKeyType == r102.accessKeyType) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.envLane, r102.envLane) == false) goto L13;
        return true;
    L15:
        return super.equals(r100);
    L5:
        r101 = r100;
        goto L6
    }
}
