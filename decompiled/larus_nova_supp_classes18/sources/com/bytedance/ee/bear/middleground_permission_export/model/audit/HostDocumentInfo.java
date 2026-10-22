package com.bytedance.ee.bear.middleground_permission_export.model.audit;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u001a\u0010'\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R\u001c\u0010*\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u001c\u0010-\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\u001c\u00100\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R\u001c\u00103\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R\u001c\u00106\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R\u001e\u00109\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019¨\u0006<"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/HostDocumentInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "Ljava/io/Serializable;", "<init>", "()V", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "getDocMetaInfo", "()Lcom/bytedance/ee/bear/DocMetaInfo;", "setDocMetaInfo", "(Lcom/bytedance/ee/bear/DocMetaInfo;)V", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "docToken", "getDocToken", "setDocToken", ResourceData.KEY_TYPE, "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "spaceId", "getSpaceId", "setSpaceId", "wikiInfo", "Lcom/bytedance/ee/bear/WikiNavInfo;", "getWikiInfo", "()Lcom/bytedance/ee/bear/WikiNavInfo;", "setWikiInfo", "(Lcom/bytedance/ee/bear/WikiNavInfo;)V", "title", "getTitle", "setTitle", "creatorTenantId", "getCreatorTenantId", "setCreatorTenantId", WikiFolderPushPlugin.WIKI_TOKEN, "getWikiToken", "setWikiToken", "tenantID", "getTenantID", "setTenantID", "folderID", "getFolderID", "setFolderID", "folderName", "getFolderName", "setFolderName", "ownerUid", "getOwnerUid", "setOwnerUid", "entityType", "getEntityType", "setEntityType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostDocumentInfo implements NonProguard, Serializable {
    private String creatorTenantId;
    private DocMetaInfo docMetaInfo;
    private String docToken;
    private Integer entityType;
    private String folderID;
    private String folderName;
    private String objToken;
    private String ownerUid;
    private String spaceId;
    private String tenantID;
    private String title;
    private Integer type;
    private WikiNavInfo wikiInfo;
    private String wikiToken;

    public HostDocumentInfo() {
        this.objToken = "";
        this.spaceId = "";
        this.wikiInfo = new WikiNavInfo(false, null, 3, null);
        this.creatorTenantId = "";
        this.ownerUid = "";
    }

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final DocMetaInfo getDocMetaInfo() {
        return this.docMetaInfo;
    }

    public final String getDocToken() {
        return this.docToken;
    }

    public final Integer getEntityType() {
        return this.entityType;
    }

    public final String getFolderID() {
        return this.folderID;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final String getOwnerUid() {
        return this.ownerUid;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getTenantID() {
        return this.tenantID;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final WikiNavInfo getWikiInfo() {
        return this.wikiInfo;
    }

    public final String getWikiToken() {
        return this.wikiToken;
    }

    public final void setCreatorTenantId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.creatorTenantId = r2;
    }

    public final void setDocMetaInfo(DocMetaInfo r1) {
        this.docMetaInfo = r1;
    }

    public final void setDocToken(String r1) {
        this.docToken = r1;
    }

    public final void setEntityType(Integer r1) {
        this.entityType = r1;
    }

    public final void setFolderID(String r1) {
        this.folderID = r1;
    }

    public final void setFolderName(String r1) {
        this.folderName = r1;
    }

    public final void setObjToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.objToken = r2;
    }

    public final void setOwnerUid(String r1) {
        this.ownerUid = r1;
    }

    public final void setSpaceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spaceId = r2;
    }

    public final void setTenantID(String r1) {
        this.tenantID = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }

    public final void setWikiInfo(WikiNavInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.wikiInfo = r2;
    }

    public final void setWikiToken(String r1) {
        this.wikiToken = r1;
    }
}
