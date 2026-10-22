package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020%H&J\n\u0010&\u001a\u0004\u0018\u00010'H&J\b\u0010(\u001a\u00020%H&J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0003H&J\b\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u0003H&J\b\u00104\u001a\u00020\u0003H&J\b\u00105\u001a\u00020\u0003H&J\b\u00106\u001a\u00020\u0003H&J\b\u00107\u001a\u00020%H&J\b\u00108\u001a\u00020\u0003H&J\b\u00109\u001a\u00020\u0003H&J\b\u0010:\u001a\u00020\u0003H&J\b\u0010;\u001a\u00020%H&J\b\u0010<\u001a\u00020%H&J\b\u0010=\u001a\u00020\u0003H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\b\u0010@\u001a\u00020\u0003H&J$\u0010A\u001a\u001e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020%0Bj\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020%`CH&¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "Lcom/bytedance/ee/util/io/NonProguard;", "canRead", "", "canPreview", "canPerceive", "canComment", "canEdit", "canCopy", "canCreateCopy", "canExport", "canManageCollaborator", "canManagePermissionMeta", "canCreateSubNode", "canUpload", "canDownload", "canOperateEntity", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canInviteSinglePageFullAccess", "canInviteSinglePageEdit", "canInviteSinglePageView", "canMoveThisNode", "canMoveSubNode", "canMoveToHere", "canApplyEmbed", "canManageContainerCollaborator", "canManageContainerPermissionMeta", "canManageSinglePageCollaborator", "canManageSinglePagePermissionMeta", "canVisitSecretLevel", "canModifySecretLevel", "isFullAccess", "isSinglePageFullAccess", "canViewCollaboratorInfo", "getPermissionStatusCode", "", "getOwnerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "getPermissions", "getReportJson", "", "matchPerceiveControl", "canRenameAndCreateEdition", "isCopyAuthByLeader", "isViewAuthByLeader", "isConditionAccessControl", "isControlByDLPInnerControl", "isCacViewControl", "canConditionExport", "isSecretFileView", "isSecretFileCopy", "isSecretFileEdit", "isSecretFileExport", "getErrorCode", "isConditionAccessView", "isShareExternalDeniedByPublicPerm", "isShareExternalDeniedBySecret", "getShareExternal", "getSharePartnerTenant", "isCopyAuthByKp", "isShareExternalSelectPartnerTenantShare", "isSharePartnerTenantDeniedByPublicPerm", "isSharePartnerTenantDeniedBySecret", "getControlPointMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocUserPermission extends NonProguard {
    boolean canApplyEmbed();

    boolean canComment();

    boolean canConditionExport();

    boolean canCopy();

    boolean canCreateCopy();

    boolean canCreateSubNode();

    boolean canDownload();

    boolean canEdit();

    boolean canExport();

    boolean canInviteEdit();

    boolean canInviteFullAccess();

    boolean canInviteSinglePageEdit();

    boolean canInviteSinglePageFullAccess();

    boolean canInviteSinglePageView();

    boolean canInviteView();

    boolean canManageCollaborator();

    boolean canManageContainerCollaborator();

    boolean canManageContainerPermissionMeta();

    boolean canManagePermissionMeta();

    boolean canManageSinglePageCollaborator();

    boolean canManageSinglePagePermissionMeta();

    boolean canModifySecretLevel();

    boolean canMoveSubNode();

    boolean canMoveThisNode();

    boolean canMoveToHere();

    boolean canOperateEntity();

    boolean canPerceive();

    boolean canPreview();

    @Deprecated(message = "PermissionSDK")
    boolean canRead();

    boolean canRenameAndCreateEdition();

    boolean canUpload();

    boolean canViewCollaboratorInfo();

    boolean canVisitSecretLevel();

    HashMap<String, Integer> getControlPointMap();

    int getErrorCode();

    OwnerInfo getOwnerInfo();

    int getPermissionStatusCode();

    int getPermissions();

    String getReportJson();

    int getShareExternal();

    int getSharePartnerTenant();

    boolean isCacViewControl();

    boolean isConditionAccessControl();

    boolean isConditionAccessView();

    boolean isControlByDLPInnerControl();

    boolean isCopyAuthByKp();

    boolean isCopyAuthByLeader();

    boolean isFullAccess();

    boolean isSecretFileCopy();

    boolean isSecretFileEdit();

    boolean isSecretFileExport();

    boolean isSecretFileView();

    boolean isShareExternalDeniedByPublicPerm();

    boolean isShareExternalDeniedBySecret();

    boolean isShareExternalSelectPartnerTenantShare();

    boolean isSharePartnerTenantDeniedByPublicPerm();

    boolean isSharePartnerTenantDeniedBySecret();

    boolean isSinglePageFullAccess();

    boolean isViewAuthByLeader();

    boolean matchPerceiveControl();
}
