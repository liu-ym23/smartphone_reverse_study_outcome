package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/IPolicyEntity;", "entityType", "", "entityDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "entityOperate", "operatorTenantId", "", "operatorUid", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;Ljava/lang/String;JJ)V", "getEntityType", "()Ljava/lang/String;", "setEntityType", "(Ljava/lang/String;)V", "getEntityDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "getEntityOperate", "setEntityOperate", "getOperatorTenantId", "()J", "setOperatorTenantId", "(J)V", "getOperatorUid", "setOperatorUid", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PolicyEntity {
    private final EntityDomain entityDomain;
    private String entityOperate;
    private String entityType;
    private long operatorTenantId;
    private long operatorUid;

    public final EntityDomain getEntityDomain() {
        return this.entityDomain;
    }

    public final String getEntityOperate() {
        return this.entityOperate;
    }

    public final String getEntityType() {
        return this.entityType;
    }

    public final long getOperatorTenantId() {
        return this.operatorTenantId;
    }

    public final long getOperatorUid() {
        return this.operatorUid;
    }

    public final void setEntityOperate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entityOperate = r100;
    }

    public final void setEntityType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entityType = r100;
    }

    public final void setOperatorTenantId(long r100) {
        this.operatorTenantId = r100;
    }

    public final void setOperatorUid(long r100) {
        this.operatorUid = r100;
    }

    public PolicyEntity(@EntityType String r100, EntityDomain r101, @EntityOperate String r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "entityType");
        Intrinsics.checkNotNullParameter(r101, "entityDomain");
        Intrinsics.checkNotNullParameter(r102, "entityOperate");
        this.entityType = r100;
        this.entityDomain = r101;
        this.entityOperate = r102;
        this.operatorTenantId = r103;
        this.operatorUid = r104;
    }
}
