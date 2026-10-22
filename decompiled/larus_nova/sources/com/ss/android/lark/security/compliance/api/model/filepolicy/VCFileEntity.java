package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/VCFileEntity;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "entityType", "", "entityDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "entityOperate", "operatorTenantId", "", "operatorUid", "fileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "token", "ownerTenantId", "ownerUserId", "objectType", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;Ljava/lang/String;JJLcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;I)V", "getFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "getToken", "()Ljava/lang/String;", "getOwnerTenantId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOwnerUserId", "getObjectType", "()I", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VCFileEntity extends PolicyEntity {
    private final FileBizDomain fileBizDomain;
    private final int objectType;
    private final Long ownerTenantId;
    private final Long ownerUserId;
    private final String token;

    public final FileBizDomain getFileBizDomain() {
        return this.fileBizDomain;
    }

    public final int getObjectType() {
        return this.objectType;
    }

    public final Long getOwnerTenantId() {
        return this.ownerTenantId;
    }

    public final Long getOwnerUserId() {
        return this.ownerUserId;
    }

    public final String getToken() {
        return this.token;
    }

    public VCFileEntity(@EntityType String r100, EntityDomain r101, @EntityOperate String r102, long r103, long r104, FileBizDomain r105, String r110, Long r111, Long r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "entityType");
        Intrinsics.checkNotNullParameter(r101, "entityDomain");
        Intrinsics.checkNotNullParameter(r102, "entityOperate");
        Intrinsics.checkNotNullParameter(r105, "fileBizDomain");
        super(r100, r101, r102, r103, r104);
        this.fileBizDomain = r105;
        this.token = r110;
        this.ownerTenantId = r111;
        this.ownerUserId = r112;
        this.objectType = r113;
    }

    public /* synthetic */ VCFileEntity(String r110, EntityDomain r111, String r112, long r210, long r211, FileBizDomain r212, String r213, Long r214, Long r215, int r216, int r217, DefaultConstructorMarker r310) {
        if ((r217 & 64) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r217 & 128) == 0) goto L9;
        Long r114 = null;
    L11:
        if ((r217 & 256) == 0) goto L13;
        Long r115 = null;
    L15:
        if ((r217 & 512) == 0) goto L17;
        int r116 = 28;
    L18:
        this(r110, r111, r112, r210, r211, r212, r113, r114, r115, r116);
        return;
    L17:
        r116 = r216;
        goto L18
    L13:
        r115 = r215;
        goto L15
    L9:
        r114 = r214;
        goto L11
    L5:
        r113 = r213;
        goto L7
    }
}
