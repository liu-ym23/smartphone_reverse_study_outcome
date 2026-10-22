package com.bytedance.locallife.dito.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/dito/data/h;", "", "", "backupApiPath", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "backupH5Url", "b", "backupStaticTitle", "d", "backupStaticDescription", "c", "", "enableExtErrorCode", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("dito_recovery_backup_api_path")
    private final String backupApiPath;

    @SerializedName("dito_recovery_backup_h5_url")
    private final String backupH5Url;

    @SerializedName("dito_recovery_backup_static_description")
    private final String backupStaticDescription;

    @SerializedName("dito_recovery_backup_static_title")
    private final String backupStaticTitle;

    @SerializedName("dito_recovery_enable_ext_error_code")
    private final Boolean enableExtErrorCode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.backupApiPath, r101.backupApiPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backupH5Url, r101.backupH5Url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backupStaticTitle, r101.backupStaticTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backupStaticDescription, r101.backupStaticDescription) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enableExtErrorCode, r101.enableExtErrorCode) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.backupApiPath;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.backupH5Url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.backupStaticTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.backupStaticDescription;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.enableExtErrorCode;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoRecoveryConfig(backupApiPath=" + this.backupApiPath + ", backupH5Url=" + this.backupH5Url + ", backupStaticTitle=" + this.backupStaticTitle + ", backupStaticDescription=" + this.backupStaticDescription + ", enableExtErrorCode=" + this.enableExtErrorCode + ')';
    }

    public h() {
        this.backupApiPath = null;
        this.backupH5Url = null;
        this.backupStaticTitle = null;
        this.backupStaticDescription = null;
        this.enableExtErrorCode = null;
    }

    public final String a() {
        return this.backupApiPath;
    }

    public final String b() {
        return this.backupH5Url;
    }

    public final String c() {
        return this.backupStaticDescription;
    }

    public final String d() {
        return this.backupStaticTitle;
    }

    public final Boolean e() {
        return this.enableExtErrorCode;
    }
}
