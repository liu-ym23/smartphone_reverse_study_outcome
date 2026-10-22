package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntityWithBizDomain;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "entityType", "", "entityDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "entityOperate", "operatorTenantId", "", "operatorUid", "fileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;Ljava/lang/String;JJLcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;)V", "getFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "setFileBizDomain", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;)V", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PolicyEntityWithBizDomain extends PolicyEntity {
    private FileBizDomain fileBizDomain;

    public final FileBizDomain getFileBizDomain() {
        return this.fileBizDomain;
    }

    public final void setFileBizDomain(FileBizDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileBizDomain = r100;
    }

    public PolicyEntityWithBizDomain(String r100, EntityDomain r101, String r102, long r103, long r104, FileBizDomain r105) {
        Intrinsics.checkNotNullParameter(r100, "entityType");
        Intrinsics.checkNotNullParameter(r101, "entityDomain");
        Intrinsics.checkNotNullParameter(r102, "entityOperate");
        Intrinsics.checkNotNullParameter(r105, "fileBizDomain");
        super(r100, r101, r102, r103, r104);
        this.fileBizDomain = r105;
    }
}
