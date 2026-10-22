package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b!\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u000f\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/DefaultFolderPublicPermission;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "isOwner", "", "<init>", "(Z)V", "setOwner", "", "adminCanCross", "adminPartnerTenantCanCross", "hasLinkPassword", "setHasLinkPassword", "hasPassword", "linkPassword", "", "setLinkPassword", "password", "isShareFolder", "canUnLock", "lockState", "reportJson", "showLinkShare", "externalAccess", "partnerTenantAccess", "isShareExternalWithRead", "isShareExternalWithFA", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "hasModifiedLinkShare", "()Ljava/lang/Boolean;", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultFolderPublicPermission implements IFolderPublicPermission {
    private boolean isOwner;

    public DefaultFolderPublicPermission() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean adminCanCross() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean adminPartnerTenantCanCross() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean canUnLock() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean externalAccess() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCommentEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCommentReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCopyEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCopyFaBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCopyReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getExternalAccessCloseBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getExternalAccessOpenBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareAnyoneReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareCloseBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareInternalEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareInternalReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorFaBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String getOwnerTenantName() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getPartnerTenantAccessBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityFaBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareAnyoneBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareExternalFaBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareExternalReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareInternalBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public Integer getVisibilityStatus() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean hasLinkPassword() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public Boolean hasModifiedLinkShare() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCommentWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCommentWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCopyWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCopyWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCopyWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareAnyoneRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareClose() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareInternalEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareInternalRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkSharePartnerTenantEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkSharePartnerTenantRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorAnyone() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorTenant() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isSecurityWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isSecurityWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isSecurityWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isShareExternalWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isShareExternalWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isShareFolder() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String linkPassword() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean lockState() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean partnerTenantAccess() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String reportJson() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setHasLinkPassword(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setLinkPassword(String r2) {
        Intrinsics.checkNotNullParameter(r2, "password");
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean showLinkShare() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isOwner() {
        return this.isOwner;
    }

    public DefaultFolderPublicPermission(boolean r1) {
        this.isOwner = r1;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setOwner(boolean r1) {
        this.isOwner = r1;
    }

    public /* synthetic */ DefaultFolderPublicPermission(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
