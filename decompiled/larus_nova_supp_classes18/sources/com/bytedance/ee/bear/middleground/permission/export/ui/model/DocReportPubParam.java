package com.bytedance.ee.bear.middleground.permission.export.ui.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001BY\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/DocReportPubParam;", "", "fileId", "", "fileType", "", "appForm", "module", "subModule", "creatorId", "ownerId", "creatorTenantId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "setFileId", "(Ljava/lang/String;)V", "getFileType", "()Ljava/lang/Integer;", "setFileType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAppForm", "setAppForm", "getModule", "setModule", "getSubModule", "setSubModule", "getCreatorId", "setCreatorId", "getOwnerId", "setOwnerId", "getCreatorTenantId", "setCreatorTenantId", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocReportPubParam {
    private String appForm;
    private String creatorId;
    private String creatorTenantId;
    private String fileId;
    private Integer fileType;
    private String module;
    private String ownerId;
    private String subModule;

    public final String getAppForm() {
        return this.appForm;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final Integer getFileType() {
        return this.fileType;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getSubModule() {
        return this.subModule;
    }

    public final void setAppForm(String r1) {
        this.appForm = r1;
    }

    public final void setCreatorId(String r1) {
        this.creatorId = r1;
    }

    public final void setCreatorTenantId(String r1) {
        this.creatorTenantId = r1;
    }

    public final void setFileId(String r1) {
        this.fileId = r1;
    }

    public final void setFileType(Integer r1) {
        this.fileType = r1;
    }

    public final void setModule(String r1) {
        this.module = r1;
    }

    public final void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public final void setSubModule(String r1) {
        this.subModule = r1;
    }

    public DocReportPubParam(String r1, Integer r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        this.fileId = r1;
        this.fileType = r2;
        this.appForm = r3;
        this.module = r4;
        this.subModule = r5;
        this.creatorId = r6;
        this.ownerId = r7;
        this.creatorTenantId = r8;
    }
}
