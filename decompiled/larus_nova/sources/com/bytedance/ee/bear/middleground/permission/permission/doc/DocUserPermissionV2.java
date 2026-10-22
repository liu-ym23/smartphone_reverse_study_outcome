package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BW\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J$\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070Aj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007`BH\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0007H\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J\b\u0010H\u001a\u00020\u000fH\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\b\u0010N\u001a\u00020\u0005H\u0016J\b\u0010O\u001a\u00020\u0005H\u0016J\b\u0010P\u001a\u00020\u0005H\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J\t\u0010R\u001a\u00020\u0005HÂ\u0003J\t\u0010S\u001a\u00020\u0007HÂ\u0003J\t\u0010T\u001a\u00020\tHÂ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\t\u0010V\u001a\u00020\rHÂ\u0003J\t\u0010W\u001a\u00020\u000fHÂ\u0003J\t\u0010X\u001a\u00020\u0007HÂ\u0003J\t\u0010Y\u001a\u00020\u0005HÂ\u0003J[\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u0010[\u001a\u00020\u00052\b\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0007HÖ\u0001J\t\u0010_\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/DocUserPermissionV2;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "isOwner", "", "permissionStatusCode", "", SlcCommonAction.KEY_ACTIONS, "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/DocPermissionAction;", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "authReason", "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/AuthReason;", "json", "", "errorCode", "canFileServerEncrypt", "<init>", "(ZILcom/bytedance/ee/bear/middleground/permission/permission/doc/DocPermissionAction;Lcom/bytedance/ee/bear/share/export/OwnerInfo;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/AuthReason;Ljava/lang/String;IZ)V", "canRead", "canPreview", "canPerceive", "canComment", "canEdit", "canCopy", "canCreateCopy", "canExport", "canManageCollaborator", "canManagePermissionMeta", "canCreateSubNode", "canUpload", "canDownload", "canOperateEntity", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canApplyEmbed", "canInviteSinglePageFullAccess", "canInviteSinglePageEdit", "canInviteSinglePageView", "canMoveThisNode", "canMoveSubNode", "canMoveToHere", "canManageContainerCollaborator", "canManageContainerPermissionMeta", "canManageSinglePageCollaborator", "canManageSinglePagePermissionMeta", "canModifySecretLevel", "canViewCollaboratorInfo", "canVisitSecretLevel", "isFullAccess", "isSinglePageFullAccess", "matchPerceiveControl", "isConditionAccessControl", "isControlByDLPInnerControl", "isCacViewControl", "canConditionExport", "isConditionAccessView", "isShareExternalDeniedByPublicPerm", "isShareExternalDeniedBySecret", "getShareExternal", "getSharePartnerTenant", "isShareExternalSelectPartnerTenantShare", "getControlPointMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isSharePartnerTenantDeniedByPublicPerm", "isSharePartnerTenantDeniedBySecret", "getPermissionStatusCode", "getOwnerInfo", "getPermissions", "getReportJson", "canRenameAndCreateEdition", "isCopyAuthByLeader", "isCopyAuthByKp", "isViewAuthByLeader", "isSecretFileView", "isSecretFileCopy", "isSecretFileEdit", "isSecretFileExport", "getErrorCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocUserPermissionV2 extends Result<Serializable> implements IDocUserPermission {
    private final DocPermissionAction actions;
    private AuthReason authReason;
    private final boolean canFileServerEncrypt;
    private final int errorCode;
    private final boolean isOwner;
    private final String json;
    private OwnerInfo ownerInfo;
    private final int permissionStatusCode;

    private final boolean component1() {
        return this.isOwner;
    }

    private final int component2() {
        return this.permissionStatusCode;
    }

    private final DocPermissionAction component3() {
        return this.actions;
    }

    private final OwnerInfo component4() {
        return this.ownerInfo;
    }

    private final AuthReason component5() {
        return this.authReason;
    }

    private final String component6() {
        return this.json;
    }

    private final int component7() {
        return this.errorCode;
    }

    private final boolean component8() {
        return this.canFileServerEncrypt;
    }

    public static /* synthetic */ DocUserPermissionV2 copy$default(DocUserPermissionV2 r100, boolean r110, int r111, DocPermissionAction r112, OwnerInfo r113, AuthReason r114, String r115, int r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.isOwner;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.permissionStatusCode;
    L11:
        if ((r118 & 4) == 0) goto L13;
        DocPermissionAction r103 = r100.actions;
    L15:
        if ((r118 & 8) == 0) goto L17;
        OwnerInfo r104 = r100.ownerInfo;
    L19:
        if ((r118 & 16) == 0) goto L21;
        AuthReason r105 = r100.authReason;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.json;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.errorCode;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.canFileServerEncrypt;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final DocUserPermissionV2 copy(boolean r110, int r111, DocPermissionAction r112, OwnerInfo r113, AuthReason r114, String r115, int r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r112, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r114, "authReason");
        Intrinsics.checkNotNullParameter(r115, "json");
        return new DocUserPermissionV2(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocUserPermissionV2) == true) goto L8;
        return false;
    L8:
        DocUserPermissionV2 r101 = (DocUserPermissionV2) r100;
        if (this.isOwner == r101.isOwner) goto L12;
        return false;
    L12:
        if (this.permissionStatusCode == r101.permissionStatusCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ownerInfo, r101.ownerInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authReason, r101.authReason) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.json, r101.json) == true) goto L27;
        return false;
    L27:
        if (this.errorCode == r101.errorCode) goto L30;
        return false;
    L30:
        if (this.canFileServerEncrypt == r101.canFileServerEncrypt) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getPermissions() {
        return 0;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isOwner == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.permissionStatusCode) * 31) + this.actions.hashCode()) * 31;
        OwnerInfo r103 = this.ownerInfo;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((((((r102 + r104) * 31) + this.authReason.hashCode()) * 31) + this.json.hashCode()) * 31) + this.errorCode) * 31;
        if (this.canFileServerEncrypt == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DocUserPermissionV2(isOwner=" + this.isOwner + ", permissionStatusCode=" + this.permissionStatusCode + ", actions=" + this.actions + ", ownerInfo=" + this.ownerInfo + ", authReason=" + this.authReason + ", json=" + this.json + ", errorCode=" + this.errorCode + ", canFileServerEncrypt=" + this.canFileServerEncrypt + ')';
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canApplyEmbed() {
        return this.actions.canApplyEmbed();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canComment() {
        return this.actions.canComment();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canConditionExport() {
        return this.actions.isExportCac();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canCopy() {
        return this.actions.canCopy();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canCreateCopy() {
        return this.actions.canCreateCopy();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canCreateSubNode() {
        return this.actions.canCreate();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canDownload() {
        return this.actions.canDownload();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canEdit() {
        return this.actions.canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canExport() {
        return this.actions.canExport();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteEdit() {
        return this.actions.canInviteEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteFullAccess() {
        return this.actions.canInviteFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteSinglePageEdit() {
        return this.actions.canInviteSinglePageEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteSinglePageFullAccess() {
        return this.actions.canInviteSinglePageFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteSinglePageView() {
        return this.actions.canInviteSinglePageView();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteView() {
        return this.actions.canInviteView();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageContainerCollaborator() {
        return this.actions.canManageContainerCollaborator();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageContainerPermissionMeta() {
        return this.actions.canManageContainerPermissionMeta();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageSinglePageCollaborator() {
        return this.actions.canManageSinglePageCollaborator();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageSinglePagePermissionMeta() {
        return this.actions.canManageSinglePagePermissionMeta();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canModifySecretLevel() {
        return this.actions.canModifySecretLevel();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canMoveSubNode() {
        return this.actions.canMoveSubNode();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canMoveThisNode() {
        return this.actions.canMoveThisNode();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canMoveToHere() {
        return this.actions.canMoveToHere();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canOperateEntity() {
        return this.actions.canOperateEntity();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canPerceive() {
        return this.actions.canPerceive();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canPreview() {
        return this.actions.canPreview();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canRead() {
        return this.actions.canView();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canRenameAndCreateEdition() {
        return this.actions.canRenameAndCreateEdition();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canUpload() {
        return this.actions.canUpload();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canViewCollaboratorInfo() {
        return this.actions.canViewCollaboratorInfo();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canVisitSecretLevel() {
        return this.actions.canVisitSecretLevel();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public HashMap<String, Integer> getControlPointMap() {
        HashMap<String, Integer> r100 = new HashMap();
        r100.put("view", Integer.valueOf(this.actions.getView()));
        r100.put("download", Integer.valueOf(this.actions.getDownload()));
        r100.put("export", Integer.valueOf(this.actions.getExport()));
        r100.put("content_copy", Integer.valueOf(this.actions.getCopy()));
        r100.put("create_copy", Integer.valueOf(this.actions.getDuplicate()));
        r100.put("comment", Integer.valueOf(this.actions.getComment()));
        r100.put("edit", Integer.valueOf(this.actions.getEdit()));
        return r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getShareExternal() {
        return this.actions.getShareExternal();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getSharePartnerTenant() {
        return this.actions.getSharePartnerTenant();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isCacViewControl() {
        if (this.actions.canPerceive() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.actions.isViewCac() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isConditionAccessControl() {
        if (this.actions.isPerceiveCac() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.actions.isViewCac() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isConditionAccessView() {
        return this.actions.isViewCac();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isControlByDLPInnerControl() {
        return this.actions.isViewDlpInnerControl();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isCopyAuthByKp() {
        return this.authReason.isCopyAuthByKp();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isCopyAuthByLeader() {
        return this.authReason.isCopyAuthByLeader();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isFullAccess() {
        return this.actions.isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileCopy() {
        if (this.canFileServerEncrypt == true) goto L7;
        return false;
    L7:
        return this.actions.isSecretFileCopy();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileEdit() {
        if (this.canFileServerEncrypt == true) goto L7;
        return false;
    L7:
        return this.actions.isSecretFileEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileExport() {
        if (this.canFileServerEncrypt == true) goto L7;
        return false;
    L7:
        return this.actions.isSecretFileExport();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileView() {
        if (this.canFileServerEncrypt == true) goto L7;
        return false;
    L7:
        return this.actions.isSecretFileView();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isShareExternalDeniedByPublicPerm() {
        return this.actions.isShareExternalDeniedByPublicPerm();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isShareExternalDeniedBySecret() {
        return this.actions.isShareExternalDeniedBySecret();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isShareExternalSelectPartnerTenantShare() {
        return this.actions.isShareExternalSelectPartnerTenant();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSharePartnerTenantDeniedByPublicPerm() {
        return this.actions.isSharePartnerTenantDeniedByPublicPerm();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSharePartnerTenantDeniedBySecret() {
        return this.actions.isSharePartnerTenantDeniedBySecret();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSinglePageFullAccess() {
        return this.actions.isSinglePageFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isViewAuthByLeader() {
        return this.authReason.isViewAuthByLeader();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean matchPerceiveControl() {
        if (this.actions.canView() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.actions.canPerceive() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageCollaborator() {
        if (canManageContainerCollaborator() == false) goto L5;
    L8:
        return true;
    L5:
        if (canManageSinglePageCollaborator() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManagePermissionMeta() {
        if (canManageContainerPermissionMeta() == false) goto L5;
    L8:
        return true;
    L5:
        if (canManageSinglePagePermissionMeta() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public OwnerInfo getOwnerInfo() {
        return this.ownerInfo;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getPermissionStatusCode() {
        return this.permissionStatusCode;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public String getReportJson() {
        return this.json;
    }

    public DocUserPermissionV2(boolean r100, int r101, DocPermissionAction r102, OwnerInfo r103, AuthReason r104, String r105, int r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r104, "authReason");
        Intrinsics.checkNotNullParameter(r105, "json");
        this.isOwner = r100;
        this.permissionStatusCode = r101;
        this.actions = r102;
        this.ownerInfo = r103;
        this.authReason = r104;
        this.json = r105;
        this.errorCode = r106;
        this.canFileServerEncrypt = r107;
    }

    public /* synthetic */ DocUserPermissionV2(boolean r410, int r411, DocPermissionAction r412, OwnerInfo r510, AuthReason r511, String r512, int r513, boolean r514, int r515, DefaultConstructorMarker r516) {
        if ((r515 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r515 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r515 & 4) == 0) goto L13;
        DocPermissionAction r102 = new DocPermissionAction(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 31, null);
    L15:
        if ((r515 & 8) == 0) goto L17;
        OwnerInfo r103 = null;
    L19:
        if ((r515 & 16) == 0) goto L21;
        AuthReason r104 = new AuthReason(0, 0, 3, null);
    L23:
        if ((r515 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r515 & 64) == 0) goto L29;
        int r106 = 0;
    L30:
        this(r100, r101, r102, r103, r104, r105, r106, r514);
        return;
    L29:
        r106 = r513;
        goto L30
    L25:
        r105 = r512;
        goto L27
    L21:
        r104 = r511;
        goto L23
    L17:
        r103 = r510;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
