package com.ss.android.lark.security.compliance.api.model.filepolicy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/AuthEntity;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/IParams;", "permType", "", "entityType", "entityId", "", "<init>", "(IILjava/lang/String;)V", "getPermType", "()I", "setPermType", "(I)V", "getEntityType", "setEntityType", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "toString", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AuthEntity implements e {
    private String entityId;
    private int entityType;
    private int permType;

    public String toString() {
        return com.ss.android.lark.security.compliance.infra.util.f.c(this);
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final int getPermType() {
        return this.permType;
    }

    public final void setEntityId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entityId = r100;
    }

    public final void setEntityType(int r100) {
        this.entityType = r100;
    }

    public final void setPermType(int r100) {
        this.permType = r100;
    }

    public AuthEntity(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "entityId");
        this.permType = r100;
        this.entityType = r101;
        this.entityId = r102;
    }

    public /* synthetic */ AuthEntity(int r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 1;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "";
    L8:
        this(r100, r101, r102);
    }
}
