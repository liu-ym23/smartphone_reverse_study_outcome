package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.resource.MessageRelatedInfo;
import com.bytedance.lark.pb.search.resource.ResourceMeta;

/* JADX INFO: loaded from: classes38.dex */
public class SearchResourceInfo extends SearchBaseInfo {
    private AuthAction authAction;
    private String fromId;
    private String fromTenantId;
    private boolean isDestroyed;
    private MessageRelatedInfo messageRelatedInfo;
    private ResourceMeta.ResourceContent resourceContent;
    private ResourceMeta.ResourceType resourceType;
    private int sceneId;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        ResourceMeta.ResourceType r100 = this.resourceType;
        if (r100 != ResourceMeta.ResourceType.IMAGE) goto L7;
        return "image";
    L7:
        if (r100 != ResourceMeta.ResourceType.VIDEO) goto L10;
        return "video";
    L10:
        return "none";
    }

    public boolean isDestroyed() {
        if (this.sceneId == 0) goto L5;
    L8:
        return true;
    L5:
        if (this.isDestroyed == true) goto L8;
        return false;
    }

    public SearchResourceInfo() {
        this.isDestroyed = false;
        this.sceneId = 0;
        this.authAction = new AuthAction();
    }

    public AuthAction getAuthAction() {
        return this.authAction;
    }

    public String getFromId() {
        return this.fromId;
    }

    public String getFromTenantId() {
        return this.fromTenantId;
    }

    public MessageRelatedInfo getMessageRelatedInfo() {
        return this.messageRelatedInfo;
    }

    public ResourceMeta.ResourceContent getResourceContent() {
        return this.resourceContent;
    }

    public ResourceMeta.ResourceType getResourceType() {
        return this.resourceType;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setAuthAction(AuthAction r100) {
        this.authAction = r100;
    }

    public void setDestroyed(boolean r100) {
        this.isDestroyed = r100;
    }

    public void setFromId(String r100) {
        this.fromId = r100;
    }

    public void setFromTenantId(String r100) {
        this.fromTenantId = r100;
    }

    public void setMessageRelatedInfo(MessageRelatedInfo r100) {
        this.messageRelatedInfo = r100;
    }

    public void setResourceContent(ResourceMeta.ResourceContent r100) {
        this.resourceContent = r100;
    }

    public void setResourceType(ResourceMeta.ResourceType r100) {
        this.resourceType = r100;
    }

    public void setSceneId(int r100) {
        this.sceneId = r100;
    }
}
