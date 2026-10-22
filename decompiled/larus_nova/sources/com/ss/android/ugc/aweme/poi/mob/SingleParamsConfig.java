package com.ss.android.ugc.aweme.poi.mob;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/SingleParamsConfig;", "", "", "paramName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setParamName", "(Ljava/lang/String;)V", "", "disableParams", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setDisableParams", "(Z)V", "", "dynamicPoolPriority", "I", "b", "()I", "setDynamicPoolPriority", "(I)V", "sessionPriority", "d", "setSessionPriority", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class SingleParamsConfig {

    @SerializedName("disable_params")
    private boolean disableParams;

    @SerializedName("dynamic_pool_priority")
    private int dynamicPoolPriority;

    @SerializedName("param_name")
    private String paramName;

    @SerializedName("session_priority")
    private int sessionPriority;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SingleParamsConfig) == true) goto L8;
        return false;
    L8:
        SingleParamsConfig r101 = (SingleParamsConfig) r100;
        if (Intrinsics.areEqual(this.paramName, r101.paramName) == true) goto L12;
        return false;
    L12:
        if (this.disableParams == r101.disableParams) goto L15;
        return false;
    L15:
        if (this.dynamicPoolPriority == r101.dynamicPoolPriority) goto L18;
        return false;
    L18:
        if (this.sessionPriority == r101.sessionPriority) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.paramName;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.disableParams == false) goto L9;
        int r103 = 1231;
    L11:
        return ((((r102 + r103) * 31) + this.dynamicPoolPriority) * 31) + this.sessionPriority;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SingleParamsConfig(paramName=" + this.paramName + ", disableParams=" + this.disableParams + ", dynamicPoolPriority=" + this.dynamicPoolPriority + ", sessionPriority=" + this.sessionPriority + ')';
    }

    public SingleParamsConfig() {
        this("", false, 0, 0);
    }

    public final boolean a() {
        return this.disableParams;
    }

    public final int b() {
        return this.dynamicPoolPriority;
    }

    public final String c() {
        return this.paramName;
    }

    public final int d() {
        return this.sessionPriority;
    }

    public SingleParamsConfig(String r100, boolean r101, int r102, int r103) {
        this.paramName = r100;
        this.disableParams = r101;
        this.dynamicPoolPriority = r102;
        this.sessionPriority = r103;
    }
}
