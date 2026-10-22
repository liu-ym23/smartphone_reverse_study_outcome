package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CalendarFileEntity;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "entityType", "", "entityDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "entityOperate", "operatorTenantId", "", "operatorUid", "fileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "token", "tokenEntityType", "objectType", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;Ljava/lang/String;JJLcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "getToken", "()Ljava/lang/String;", "getTokenEntityType", "getObjectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarFileEntity extends PolicyEntity {
    private final FileBizDomain fileBizDomain;
    private final Integer objectType;
    private final String token;
    private final String tokenEntityType;

    public final FileBizDomain getFileBizDomain() {
        return this.fileBizDomain;
    }

    public final Integer getObjectType() {
        return this.objectType;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getTokenEntityType() {
        return this.tokenEntityType;
    }

    public CalendarFileEntity(@EntityType String r100, EntityDomain r101, @EntityOperate String r102, long r103, long r104, FileBizDomain r105, String r110, @EntityType String r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r100, "entityType");
        Intrinsics.checkNotNullParameter(r101, "entityDomain");
        Intrinsics.checkNotNullParameter(r102, "entityOperate");
        Intrinsics.checkNotNullParameter(r105, "fileBizDomain");
        super(r100, r101, r102, r103, r104);
        this.fileBizDomain = r105;
        this.token = r110;
        this.tokenEntityType = r111;
        this.objectType = r112;
    }

    public /* synthetic */ CalendarFileEntity(String r110, EntityDomain r111, String r112, long r113, long r210, FileBizDomain r211, String r212, String r213, Integer r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 64) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r215 & 128) == 0) goto L9;
        String r115 = null;
    L11:
        if ((r215 & 256) == 0) goto L13;
        Integer r116 = null;
    L14:
        this(r110, r111, r112, r113, r210, r211, r114, r115, r116);
        return;
    L13:
        r116 = r214;
        goto L14
    L9:
        r115 = r213;
        goto L11
    L5:
        r114 = r212;
        goto L7
    }
}
