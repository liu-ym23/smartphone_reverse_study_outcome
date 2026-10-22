package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B1\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", "", "token", "", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()Lcom/ss/android/lark/docs/icon/util/DocumentType;", "setType", "(Lcom/ss/android/lark/docs/icon/util/DocumentType;)V", "getDomain", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "setDomain", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;)V", "getCreatorTenantId", "setCreatorTenantId", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseEntity {
    private String creatorTenantId;
    private BizDomain domain;
    private String token;
    private e type;

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final BizDomain getDomain() {
        return this.domain;
    }

    public final String getToken() {
        return this.token;
    }

    public final e getType() {
        return this.type;
    }

    public final void setCreatorTenantId(String r100) {
        this.creatorTenantId = r100;
    }

    public final void setDomain(BizDomain r100) {
        this.domain = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setType(e r100) {
        this.type = r100;
    }

    public BaseEntity(String r100, e r101, BizDomain r102, String r103) {
        this.type = e.f541294e;
        BizDomain r104 = BizDomain.FileBizDomainCCM;
        this.domain = r104;
        this.creatorTenantId = "";
        this.token = r100;
        this.type = r101;
        if (r102 == null) goto L5;
        this.domain = r102;
    L6:
        if (r103 == null) goto L9;
        this.creatorTenantId = r103;
        return;
    L9:
        return;
    L5:
        this.domain = r104;
        goto L6
    }
}
