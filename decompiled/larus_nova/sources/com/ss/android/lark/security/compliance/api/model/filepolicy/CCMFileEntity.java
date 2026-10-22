package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006."}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CCMFileEntity;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "entityType", "", "entityDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "entityOperate", "operatorTenantId", "", "operatorUid", "fileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "token", "ownerUserId", "ownerTenantId", "tokenEntityType", "objectType", "", "scopedFileBizDomain", "scopedEntityOperate", "scopedEntityType", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;Ljava/lang/String;JJLcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/String;)V", "getFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getOwnerUserId", "()Ljava/lang/Long;", "setOwnerUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOwnerTenantId", "setOwnerTenantId", "getTokenEntityType", "setTokenEntityType", "getObjectType", "()Ljava/lang/Integer;", "setObjectType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getScopedFileBizDomain", "getScopedEntityOperate", "getScopedEntityType", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMFileEntity extends PolicyEntity {
    private final FileBizDomain fileBizDomain;
    private Integer objectType;
    private Long ownerTenantId;
    private Long ownerUserId;
    private final String scopedEntityOperate;
    private final String scopedEntityType;
    private final FileBizDomain scopedFileBizDomain;
    private String token;
    private String tokenEntityType;

    public final FileBizDomain getFileBizDomain() {
        return this.fileBizDomain;
    }

    public final Integer getObjectType() {
        return this.objectType;
    }

    public final Long getOwnerTenantId() {
        return this.ownerTenantId;
    }

    public final Long getOwnerUserId() {
        return this.ownerUserId;
    }

    public final String getScopedEntityOperate() {
        return this.scopedEntityOperate;
    }

    public final String getScopedEntityType() {
        return this.scopedEntityType;
    }

    public final FileBizDomain getScopedFileBizDomain() {
        return this.scopedFileBizDomain;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getTokenEntityType() {
        return this.tokenEntityType;
    }

    public final void setObjectType(Integer r100) {
        this.objectType = r100;
    }

    public final void setOwnerTenantId(Long r100) {
        this.ownerTenantId = r100;
    }

    public final void setOwnerUserId(Long r100) {
        this.ownerUserId = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setTokenEntityType(String r100) {
        this.tokenEntityType = r100;
    }

    public CCMFileEntity(@EntityType String r100, EntityDomain r101, @EntityOperate String r102, long r110, long r111, FileBizDomain r112, String r113, Long r114, Long r115, @EntityType String r116, Integer r117, FileBizDomain r210, String r211, @EntityType String r212) {
        Intrinsics.checkNotNullParameter(r100, "entityType");
        Intrinsics.checkNotNullParameter(r101, "entityDomain");
        Intrinsics.checkNotNullParameter(r102, "entityOperate");
        Intrinsics.checkNotNullParameter(r112, "fileBizDomain");
        super(r100, r101, r102, r110, r111);
        this.fileBizDomain = r112;
        this.token = r113;
        this.ownerUserId = r114;
        this.ownerTenantId = r115;
        this.tokenEntityType = r116;
        this.objectType = r117;
        this.scopedFileBizDomain = r210;
        this.scopedEntityOperate = r211;
        this.scopedEntityType = r212;
    }

    public /* synthetic */ CCMFileEntity(String r210, EntityDomain r211, String r212, long r213, long r214, FileBizDomain r215, String r216, Long r310, Long r311, String r312, Integer r313, FileBizDomain r314, String r315, String r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 64) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r317 & 128) == 0) goto L9;
        Long r111 = null;
    L11:
        if ((r317 & 256) == 0) goto L13;
        Long r112 = null;
    L15:
        if ((r317 & 512) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r317 & 1024) == 0) goto L21;
        Integer r114 = null;
    L23:
        if ((r317 & 2048) == 0) goto L25;
        FileBizDomain r115 = null;
    L27:
        if ((r317 & 4096) == 0) goto L29;
        String r116 = null;
    L31:
        if ((r317 & 8192) == 0) goto L33;
        String r117 = null;
    L34:
        this(r210, r211, r212, r213, r214, r215, r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L33:
        r117 = r316;
        goto L34
    L29:
        r116 = r315;
        goto L31
    L25:
        r115 = r314;
        goto L27
    L21:
        r114 = r313;
        goto L23
    L17:
        r113 = r312;
        goto L19
    L13:
        r112 = r311;
        goto L15
    L9:
        r111 = r310;
        goto L11
    L5:
        r110 = r216;
        goto L7
    }
}
