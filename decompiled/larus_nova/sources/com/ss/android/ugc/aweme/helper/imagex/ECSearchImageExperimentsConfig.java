package com.ss.android.ugc.aweme.helper.imagex;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageExperimentsConfig;", "", "", "enableTransform", "Ljava/lang/Integer;", "getEnableTransform", "()Ljava/lang/Integer;", "setEnableTransform", "(Ljava/lang/Integer;)V", "enableFresco", "getEnableFresco", "setEnableFresco", "Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformConfig;", "config", "Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformConfig;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformConfig;", "setConfig", "(Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformConfig;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchImageExperimentsConfig {

    @SerializedName("config")
    private ECSearchImageUrlTransformConfig config;

    @SerializedName("enable_fresco")
    private Integer enableFresco;

    @SerializedName("enable_transform")
    private Integer enableTransform;

    public ECSearchImageExperimentsConfig() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchImageExperimentsConfig) == false) goto L12;
        ECSearchImageExperimentsConfig r101 = (ECSearchImageExperimentsConfig) r100;
        if (Intrinsics.areEqual(this.enableTransform, r101.enableTransform) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enableFresco, r101.enableFresco) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.enableTransform;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.enableFresco;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECSearchImageUrlTransformConfig r107 = this.config;
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
        return "ECSearchImageExperimentsConfig(enableTransform=" + this.enableTransform + ", enableFresco=" + this.enableFresco + ", config=" + this.config + ")";
    }

    public final ECSearchImageUrlTransformConfig a() {
        return this.config;
    }

    public ECSearchImageExperimentsConfig(int r100) {
        ECSearchImageUrlTransformConfig r101 = new ECSearchImageUrlTransformConfig();
        this.enableTransform = 0;
        this.enableFresco = 0;
        this.config = r101;
    }
}
