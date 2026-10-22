package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020,H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u00020,H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020\u0005H\u0016J\u0012\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010,H\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DefaultDocPublicPermission;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "<init>", "()V", "isLinkShareClose", "", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "isLinkShareAnyoneRead", "isLinkShareAnyoneEdit", "hasModifiedLinkShare", "()Ljava/lang/Boolean;", "isSearchableTenant", "isSearchableKnownLink", "isCommentWithRead", "isCommentWithEdit", "isShareOnlyMe", "isShareInternal", "isShareAnyone", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "canLeaderCopy", "isShowCollaboratorInfoRead", "isShowCollaboratorInfoEdit", "isShowCollaboratorInfoFA", "isOpenLinkWithRead", "isOpenLinkWithEdit", "isOpenLinkWithFA", "isOwner", "isSinglePageOwner", "isContainerOwner", "adminCanCross", "adminPartnerTenantCross", "externalAccess", "partnerTenantCross", "inviteExternal", "hasLinkPassword", "linkPassword", "", "anonymousVerify", "isLock", "canUnLock", "getReportJson", "setOwner", "", "setHasPassword", "hasPassword", "setPassword", "password", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "isShareExternalWithRead", "isShareExternalWithEdit", "isShareExternalWithFA", "isExternalAccessPermTypeSinglePage", "isLinkSharePermTypeSinglePage", "isPartnerTenant", "tenantId", "getConfigInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission$ConfigInfo;", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DefaultDocPublicPermission implements IDocPublicPermission {
    public DefaultDocPublicPermission() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean adminCanCross() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean adminPartnerTenantCross() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean anonymousVerify() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean canExternalAccessOpenEscape() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean canLeaderCopy() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean canUnLock() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean externalAccess() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public IDocPublicPermission.ConfigInfo getConfigInfo() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getExternalAccessCloseBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getExternalAccessOpenBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkShareAnyoneEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkShareAnyoneReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public Integer getLinkShareEntityV2() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkSharePartnerTenantEditBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkSharePartnerTenantReadBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getPartnerTenantAccessBlockValue() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public String getReportJson() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public Integer getVisibilityStatus() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean hasLinkPassword() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public Boolean hasModifiedLinkShare() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean inviteExternal() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCommentWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCommentWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isContainerOwner() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCopyWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCopyWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCopyWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isExternalAccessPermTypeSinglePage() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareAnyoneEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareAnyoneRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareClose() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareInternalEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareInternalRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkSharePartnerTenantEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkSharePartnerTenantRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkSharePermTypeSinglePage() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLock() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorAnyone() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorTenant() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOpenLinkWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOpenLinkWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOpenLinkWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOwner() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isPartnerTenant(String r100) {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSearchableKnownLink() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSearchableTenant() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSecurityWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSecurityWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSecurityWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareAnyone() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareExternalWithEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareExternalWithFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareExternalWithRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareInternal() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareOnlyMe() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShowCollaboratorInfoEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShowCollaboratorInfoFA() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShowCollaboratorInfoRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSinglePageOwner() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public String linkPassword() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean partnerTenantCross() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setHasPassword(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setOwner(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setPassword(String r100) {
        Intrinsics.checkNotNullParameter(r100, "password");
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public BlockOptions getBlockOptions() {
        return new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }
}
