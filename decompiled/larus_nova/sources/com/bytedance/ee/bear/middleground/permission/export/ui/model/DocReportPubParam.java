package com.bytedance.ee.bear.middleground.permission.export.ui.model;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001BY\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/DocReportPubParam;", "", "fileId", "", "fileType", "", "appForm", EventConstant.Key.MODULE, "subModule", "creatorId", "ownerId", "creatorTenantId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "setFileId", "(Ljava/lang/String;)V", "getFileType", "()Ljava/lang/Integer;", "setFileType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAppForm", "setAppForm", "getModule", "setModule", "getSubModule", "setSubModule", "getCreatorId", "setCreatorId", "getOwnerId", "setOwnerId", "getCreatorTenantId", "setCreatorTenantId", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public final void setAppForm(String r100) {
        this.appForm = r100;
    }

    public final void setCreatorId(String r100) {
        this.creatorId = r100;
    }

    public final void setCreatorTenantId(String r100) {
        this.creatorTenantId = r100;
    }

    public final void setFileId(String r100) {
        this.fileId = r100;
    }

    public final void setFileType(Integer r100) {
        this.fileType = r100;
    }

    public final void setModule(String r100) {
        this.module = r100;
    }

    public final void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public final void setSubModule(String r100) {
        this.subModule = r100;
    }

    public DocReportPubParam(String r100, Integer r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.fileId = r100;
        this.fileType = r101;
        this.appForm = r102;
        this.module = r103;
        this.subModule = r104;
        this.creatorId = r105;
        this.ownerId = r106;
        this.creatorTenantId = r107;
    }
}
