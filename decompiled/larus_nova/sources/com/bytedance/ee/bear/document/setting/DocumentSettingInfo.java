package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentSettingInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "permissionType", "", "getPermissionType", "()Ljava/lang/Integer;", "setPermissionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentSettingInfo extends Result<Serializable> implements NonProguard {

    @SerializedName("permission_type")
    private Integer permissionType;

    public DocumentSettingInfo() {
    }

    public final Integer getPermissionType() {
        return this.permissionType;
    }

    public final void setPermissionType(Integer r100) {
        this.permissionType = r100;
    }
}
