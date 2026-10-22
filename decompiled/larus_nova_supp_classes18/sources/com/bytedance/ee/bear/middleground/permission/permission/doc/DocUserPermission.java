package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001VB1\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u000eH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u000eH\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\b\u00105\u001a\u00020\u000eH\u0016J$\u00106\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000507j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005`8H\u0016J\b\u00109\u001a\u00020\u000eH\u0016J\b\u0010:\u001a\u00020\u000eH\u0016J\b\u0010;\u001a\u00020\u000eH\u0016J\b\u0010<\u001a\u00020\u000eH\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020\nH\u0016J\b\u0010A\u001a\u00020\u000eH\u0016J\b\u0010B\u001a\u00020\u000eH\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J\b\u0010D\u001a\u00020\u000eH\u0016J\b\u0010E\u001a\u00020\u000eH\u0016J\b\u0010F\u001a\u00020\u000eH\u0016J\b\u0010G\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u00020\u000eH\u0016J\b\u0010I\u001a\u00020\u000eH\u0016J\b\u0010J\u001a\u00020\u000eH\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\t\u0010L\u001a\u00020\u0005HÂ\u0003J\t\u0010M\u001a\u00020\u0005HÂ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\bHÂ\u0003J\t\u0010O\u001a\u00020\nHÂ\u0003J3\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020\u0005HÖ\u0001J\t\u0010U\u001a\u00020\nHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/DocUserPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "permissionsV2", "", "permissionStatusCode", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "json", "", "<init>", "(IILcom/bytedance/ee/bear/share/export/OwnerInfo;Ljava/lang/String;)V", "canRead", "", "canPerceive", "canPreview", "canComment", "canEdit", "canShare", "canCopy", "canCreateCopy", "canExport", "isFullAccess", "isSinglePageFullAccess", "canManageCollaborator", "canApplyEmbed", "canManagePermissionMeta", "canCreateSubNode", "canUpload", "canDownload", "canOperateEntity", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canInviteSinglePageFullAccess", "canInviteSinglePageEdit", "canInviteSinglePageView", "canMoveThisNode", "canMoveSubNode", "canMoveToHere", "matchPerceiveControl", "isConditionAccessControl", "isControlByDLPInnerControl", "isCacViewControl", "canConditionExport", "isConditionAccessView", "isShareExternalDeniedByPublicPerm", "isShareExternalDeniedBySecret", "getShareExternal", "getSharePartnerTenant", "isShareExternalSelectPartnerTenantShare", "isSharePartnerTenantDeniedByPublicPerm", "isSharePartnerTenantDeniedBySecret", "getControlPointMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "canManageContainerCollaborator", "canManageContainerPermissionMeta", "canManageSinglePageCollaborator", "canManageSinglePagePermissionMeta", "getPermissionStatusCode", "getOwnerInfo", "getPermissions", "getReportJson", "canModifySecretLevel", "canVisitSecretLevel", "canRenameAndCreateEdition", "isCopyAuthByKp", "isCopyAuthByLeader", "isViewAuthByLeader", "isSecretFileView", "isSecretFileCopy", "isSecretFileEdit", "isSecretFileExport", "getErrorCode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocUserPermission extends Result<Serializable> implements IDocUserPermission {
    public static final a Companion = null;
    public static final int USER_PERCEIVE = 4096;
    public static final int USER_PERM_COMMENT = 2;
    public static final int USER_PERM_COPY = 16;
    public static final int USER_PERM_EDIT = 4;
    public static final int USER_PERM_EXPORT = 32;
    public static final int USER_PERM_FULL_ACCESS = 1024;
    public static final int USER_PERM_PRINT = 64;
    public static final int USER_PERM_READ = 1;
    public static final int USER_PERM_SHARE = 8;
    public static final int USER_PREVIEW = 2048;
    private final String json;
    private OwnerInfo ownerInfo;
    private final int permissionStatusCode;
    private int permissionsV2;

    public static final class a {
        @JvmStatic
        public static boolean a(int r0) {
            if ((r0 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocUserPermission() {
        this(0, 0, null, null, 15, null);
    }

    @JvmStatic
    public static final boolean canComment(int r1) {
        Companion.getClass();
        if ((r1 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canCopy(int r1) {
        Companion.getClass();
        if ((r1 & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canEdit(int r1) {
        Companion.getClass();
        if ((r1 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canExport(int r1) {
        Companion.getClass();
        if ((r1 & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canPerceive(int r1) {
        Companion.getClass();
        if ((r1 & USER_PERCEIVE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canPreview(int r1) {
        Companion.getClass();
        if ((r1 & USER_PREVIEW) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canPrint(int r1) {
        Companion.getClass();
        if ((r1 & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean canRead(int r1) {
        Companion.getClass();
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private final int component1() {
        return this.permissionsV2;
    }

    private final int component2() {
        return this.permissionStatusCode;
    }

    private final OwnerInfo component3() {
        return this.ownerInfo;
    }

    private final String component4() {
        return this.json;
    }

    public static /* synthetic */ DocUserPermission copy$default(DocUserPermission r0, int r1, int r2, OwnerInfo r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.permissionsV2;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.permissionStatusCode;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.ownerInfo;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.json;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final boolean isFullAccess(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canConditionExport() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canCreateCopy() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canRenameAndCreateEdition() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canViewCollaboratorInfo() {
        return false;
    }

    public final DocUserPermission copy(int r2, int r3, OwnerInfo r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        return new DocUserPermission(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocUserPermission) == true) goto L8;
        return false;
    L8:
        DocUserPermission r6 = (DocUserPermission) r5;
        if (this.permissionsV2 == r6.permissionsV2) goto L12;
        return false;
    L12:
        if (this.permissionStatusCode == r6.permissionStatusCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerInfo, r6.ownerInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.json, r6.json) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getErrorCode() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getShareExternal() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public int getSharePartnerTenant() {
        return 0;
    }

    public int hashCode() {
        int r0 = ((this.permissionsV2 * 31) + this.permissionStatusCode) * 31;
        OwnerInfo r1 = this.ownerInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.json.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isCacViewControl() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isConditionAccessControl() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isConditionAccessView() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isControlByDLPInnerControl() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isCopyAuthByKp() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isCopyAuthByLeader() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileCopy() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileExport() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSecretFileView() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isShareExternalDeniedByPublicPerm() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isShareExternalDeniedBySecret() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isShareExternalSelectPartnerTenantShare() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSharePartnerTenantDeniedByPublicPerm() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSharePartnerTenantDeniedBySecret() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isViewAuthByLeader() {
        return false;
    }

    public String toString() {
        return "DocUserPermission(permissionsV2=" + this.permissionsV2 + ", permissionStatusCode=" + this.permissionStatusCode + ", ownerInfo=" + this.ownerInfo + ", json=" + this.json + ')';
    }

    private final boolean canShare() {
        if ((this.permissionsV2 & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canComment() {
        if ((this.permissionsV2 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canCopy() {
        if ((this.permissionsV2 & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canEdit() {
        if ((this.permissionsV2 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canExport() {
        if ((this.permissionsV2 & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canPerceive() {
        if ((this.permissionsV2 & USER_PERCEIVE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canPreview() {
        if ((this.permissionsV2 & USER_PREVIEW) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canRead() {
        if ((this.permissionsV2 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public HashMap<String, Integer> getControlPointMap() {
        return new HashMap();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isFullAccess() {
        if ((this.permissionsV2 & USER_PERM_FULL_ACCESS) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean isSinglePageFullAccess() {
        if ((this.permissionsV2 & USER_PERM_FULL_ACCESS) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canApplyEmbed() {
        return canRead();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canCreateSubNode() {
        return canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canDownload() {
        return canExport();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteEdit() {
        return canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteFullAccess() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteSinglePageEdit() {
        return canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteSinglePageFullAccess() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteSinglePageView() {
        return canRead();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canInviteView() {
        return canRead();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageCollaborator() {
        return canShare();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageContainerCollaborator() {
        return canShare();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageContainerPermissionMeta() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManagePermissionMeta() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageSinglePageCollaborator() {
        return canShare();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canManageSinglePagePermissionMeta() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canModifySecretLevel() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canMoveSubNode() {
        return canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canMoveThisNode() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canMoveToHere() {
        return canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canOperateEntity() {
        return isFullAccess();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canUpload() {
        return canEdit();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean canVisitSecretLevel() {
        return canRead();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public boolean matchPerceiveControl() {
        if (canRead() == false) goto L5;
    L7:
        return false;
    L5:
        if (canPerceive() == false) goto L7;
        return true;
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
    public int getPermissions() {
        return this.permissionsV2;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission
    public String getReportJson() {
        return this.json;
    }

    public DocUserPermission(int r2, int r3, OwnerInfo r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        this.permissionsV2 = r2;
        this.permissionStatusCode = r3;
        this.ownerInfo = r4;
        this.json = r5;
    }

    public /* synthetic */ DocUserPermission(int r2, int r3, OwnerInfo r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
