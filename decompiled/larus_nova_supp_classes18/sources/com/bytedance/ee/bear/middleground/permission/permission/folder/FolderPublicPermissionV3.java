package com.bytedance.ee.bear.middleground.permission.permission.folder;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b7\u0018\u0000 Y2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001YBÝ\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0012H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020\u0005H\u0016J\b\u0010A\u001a\u00020\u0005H\u0016J\b\u0010B\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020\u0012H\u0016J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020\bH\u0016J\b\u0010G\u001a\u00020\bH\u0016J\b\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\bH\u0016J\b\u0010J\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020\bH\u0016J\b\u0010L\u001a\u00020\bH\u0016J\b\u0010M\u001a\u00020\bH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020\bH\u0016J\b\u0010P\u001a\u00020\bH\u0016J\b\u0010Q\u001a\u00020\bH\u0016J\b\u0010R\u001a\u00020\bH\u0016J\b\u0010S\u001a\u00020\bH\u0016J\b\u0010T\u001a\u00020\bH\u0016J\b\u0010U\u001a\u00020\bH\u0016J\b\u0010V\u001a\u00020\bH\u0016J\u000f\u0010W\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010XR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010!¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/folder/FolderPublicPermissionV3;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "isOwner", "", "adminCanCross", "adminExternalCross", "", "canUnlock", "isShareFolder", "shareEntity", "manageCollaboratorEntity", "securityEntity", "commentEntity", "linkShareEntityV2", "hasLinkPassword", "linkPassword", "", "externalAccessEntity", "shareExternalEntity", "lockState", "tenantName", "blockOptions", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;", "blockOptionsV2", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2;", "reportJson", "hasModifiedLinkShare", "visibilityStatus", "<init>", "(ZZIZZIIIIIZLjava/lang/String;IIZLjava/lang/String;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "setOwner", "", "adminPartnerTenantCanCross", "setHasLinkPassword", "hasPassword", "setLinkPassword", "password", "canUnLock", "showLinkShare", "externalAccess", "partnerTenantAccess", "isShareExternalWithRead", "isShareExternalWithFA", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "()Ljava/lang/Boolean;", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "getOwnerTenantName", "getManageCollaboratorReadBlockValue", "getManageCollaboratorEditBlockValue", "getManageCollaboratorFaBlockValue", "getShareInternalBlockValue", "getShareAnyoneBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "getPartnerTenantAccessBlockValue", "getShareExternalFaBlockValue", "getShareExternalReadBlockValue", "getSecurityReadBlockValue", "getSecurityEditBlockValue", "getSecurityFaBlockValue", "getCommentReadBlockValue", "getCommentEditBlockValue", "getLinkShareCloseBlockValue", "getLinkShareInternalReadBlockValue", "getLinkShareInternalEditBlockValue", "getLinkShareAnyoneReadBlockValue", "getVisibilityStatus", "()Ljava/lang/Integer;", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderPublicPermissionV3 extends Result<Serializable> implements IFolderPublicPermission {
    public static final a Companion = null;
    public static final int EXTERNAL_ACCESS_CLOSE = 2;
    public static final int EXTERNAL_ACCESS_OPEN = 1;
    public static final int EXTERNAL_ACCESS_PARTNER_TENANT = 3;
    public static final int LINK_SHARE_ANYONE_READ = 4;
    public static final int LINK_SHARE_CLOSE = 1;
    public static final int LINK_SHARE_INTERNAL_EDIT = 3;
    public static final int LINK_SHARE_INTERNAL_READ = 2;
    public static final int LINK_SHARE_PARTNER_TENANT_EDIT = 7;
    public static final int LINK_SHARE_PARTNER_TENANT_READ = 6;
    public static final int MANAGER_COLLABORATOR_ANYONE = 2;
    public static final int MANAGER_COLLABORATOR_TENANT = 1;
    private boolean adminCanCross;
    private int adminExternalCross;
    private BlockOptions blockOptions;
    private BlockOptionsV2 blockOptionsV2;
    private boolean canUnlock;
    private int commentEntity;
    private int externalAccessEntity;
    private boolean hasLinkPassword;
    private Boolean hasModifiedLinkShare;
    private boolean isOwner;
    private boolean isShareFolder;
    private String linkPassword;
    private int linkShareEntityV2;
    private boolean lockState;
    private int manageCollaboratorEntity;
    private String reportJson;
    private int securityEntity;
    private int shareEntity;
    private int shareExternalEntity;
    private String tenantName;
    private Integer visibilityStatus;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FolderPublicPermissionV3() {
        this(false, false, 0, false, false, 0, 0, 0, 0, 0, false, null, 0, 0, false, null, null, null, null, null, null, 2097151, null);
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
    public boolean showLinkShare() {
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean adminCanCross() {
        if (this.adminExternalCross == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean adminPartnerTenantCanCross() {
        if (this.adminExternalCross != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean externalAccess() {
        if (this.externalAccessEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCommentEditBlockValue() {
        Integer r0 = this.blockOptions.getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCommentReadBlockValue() {
        Integer r0 = this.blockOptions.getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getExternalAccessCloseBlockValue() {
        Integer r0 = this.blockOptions.getExternalAccessMap().get(2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getExternalAccessOpenBlockValue() {
        Integer r0 = this.blockOptions.getExternalAccessMap().get(1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareAnyoneReadBlockValue() {
        Integer r0 = this.blockOptions.getLinkShareMap().get(4);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareCloseBlockValue() {
        Integer r0 = this.blockOptions.getLinkShareMap().get(1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareInternalEditBlockValue() {
        Integer r0 = this.blockOptions.getLinkShareMap().get(3);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareInternalReadBlockValue() {
        Integer r0 = this.blockOptions.getLinkShareMap().get(2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorEditBlockValue() {
        Integer r0 = this.blockOptions.getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorFaBlockValue() {
        Integer r0 = this.blockOptions.getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorReadBlockValue() {
        Integer r0 = this.blockOptions.getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getPartnerTenantAccessBlockValue() {
        Integer r0 = this.blockOptions.getExternalAccessMap().get(3);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityEditBlockValue() {
        Integer r0 = this.blockOptions.getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityFaBlockValue() {
        Integer r0 = this.blockOptions.getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityReadBlockValue() {
        Integer r0 = this.blockOptions.getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareAnyoneBlockValue() {
        Integer r0 = this.blockOptions.getShareMap().get(2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareExternalFaBlockValue() {
        Integer r0 = this.blockOptions.getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareExternalReadBlockValue() {
        Integer r0 = this.blockOptions.getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareInternalBlockValue() {
        Integer r0 = this.blockOptions.getShareMap().get(1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCommentWithEdit() {
        if (this.commentEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isCommentWithRead() {
        if (this.commentEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareAnyoneRead() {
        if (this.linkShareEntityV2 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareClose() {
        if (this.linkShareEntityV2 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareInternalEdit() {
        if (this.linkShareEntityV2 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareInternalRead() {
        if (this.linkShareEntityV2 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkSharePartnerTenantEdit() {
        if (this.linkShareEntityV2 != 7) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkSharePartnerTenantRead() {
        if (this.linkShareEntityV2 != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorAnyone() {
        if (this.shareEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorTenant() {
        if (this.shareEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorWithEdit() {
        if (this.manageCollaboratorEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorWithFA() {
        if (this.manageCollaboratorEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isManagerCollaboratorWithRead() {
        if (this.manageCollaboratorEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isSecurityWithEdit() {
        if (this.securityEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isSecurityWithFA() {
        if (this.securityEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isSecurityWithRead() {
        if (this.securityEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isShareExternalWithFA() {
        if (this.shareExternalEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isShareExternalWithRead() {
        if (this.shareExternalEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean partnerTenantAccess() {
        if (this.externalAccessEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean canUnLock() {
        return this.canUnlock;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String getOwnerTenantName() {
        return this.tenantName;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public Integer getVisibilityStatus() {
        return this.visibilityStatus;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean hasLinkPassword() {
        return this.hasLinkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public Boolean hasModifiedLinkShare() {
        return this.hasModifiedLinkShare;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isOwner() {
        return this.isOwner;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isShareFolder() {
        return this.isShareFolder;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String linkPassword() {
        return this.linkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean lockState() {
        return this.lockState;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String reportJson() {
        return this.reportJson;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setHasLinkPassword(boolean r1) {
        this.hasLinkPassword = this.hasLinkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setLinkPassword(String r2) {
        Intrinsics.checkNotNullParameter(r2, "password");
        this.linkPassword = r2;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setOwner(boolean r1) {
        this.isOwner = r1;
    }

    public FolderPublicPermissionV3(boolean r8, boolean r9, int r10, boolean r11, boolean r12, int r13, int r14, int r15, int r16, int r17, boolean r18, String r19, int r20, int r21, boolean r22, String r23, BlockOptions r24, BlockOptionsV2 r25, String r26, Boolean r27, Integer r28) {
        Intrinsics.checkNotNullParameter(r19, "linkPassword");
        Intrinsics.checkNotNullParameter(r23, "tenantName");
        Intrinsics.checkNotNullParameter(r24, "blockOptions");
        Intrinsics.checkNotNullParameter(r25, "blockOptionsV2");
        Intrinsics.checkNotNullParameter(r26, "reportJson");
        this.isOwner = r8;
        this.adminCanCross = r9;
        this.adminExternalCross = r10;
        this.canUnlock = r11;
        this.isShareFolder = r12;
        this.shareEntity = r13;
        this.manageCollaboratorEntity = r14;
        this.securityEntity = r15;
        this.commentEntity = r16;
        this.linkShareEntityV2 = r17;
        this.hasLinkPassword = r18;
        this.linkPassword = r19;
        this.externalAccessEntity = r20;
        this.shareExternalEntity = r21;
        this.lockState = r22;
        this.tenantName = r23;
        this.blockOptions = r24;
        this.blockOptionsV2 = r25;
        this.reportJson = r26;
        this.hasModifiedLinkShare = r27;
        this.visibilityStatus = r28;
    }

    public /* synthetic */ FolderPublicPermissionV3(boolean r32, boolean r33, int r34, boolean r35, boolean r36, int r37, int r38, int r39, int r40, int r41, boolean r42, String r43, int r44, int r45, boolean r46, String r47, BlockOptions r48, BlockOptionsV2 r49, String r50, Boolean r51, Integer r52, int r53, DefaultConstructorMarker r54) {
        if ((r53 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r53 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r53 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r53 & 8) == 0) goto L17;
        boolean r5 = false;
    L18:
        int r7 = 1;
        if ((r53 & 16) == 0) goto L21;
        boolean r6 = true;
    L23:
        if ((r53 & 32) == 0) goto L25;
        int r8 = 0;
    L27:
        if ((r53 & 64) == 0) goto L29;
        int r9 = 0;
    L31:
        if ((r53 & 128) == 0) goto L33;
        int r10 = 0;
    L35:
        if ((r53 & 256) == 0) goto L37;
        int r11 = 0;
    L39:
        if ((r53 & 512) != 0) goto L43;
        r7 = r41;
    L43:
        if ((r53 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        boolean r12 = false;
    L47:
        if ((r53 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r13 = "";
    L51:
        if ((r53 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        int r15 = 0;
    L55:
        if ((r53 & 8192) == 0) goto L57;
        int r2 = 0;
    L59:
        if ((r53 & 16384) == 0) goto L61;
        boolean r14 = false;
    L63:
        if ((r53 & 32768) == 0) goto L65;
        String r16 = "";
    L67:
        if ((r53 & 65536) == 0) goto L69;
        BlockOptions r17 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L71:
        if ((r53 & 131072) == 0) goto L73;
        BlockOptionsV2 r18 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L75:
        if ((r53 & 262144) == 0) goto L77;
        String r19 = "";
    L78:
        Integer r21 = null;
        if ((r53 & 524288) == 0) goto L81;
        Boolean r20 = null;
    L83:
        if ((r53 & 1048576) != 0) goto L86;
        r21 = r52;
    L86:
        this(r1, r3, r4, r5, r6, r8, r9, r10, r11, r7, r12, r13, r15, r2, r14, r16, r17, r18, r19, r20, r21);
        return;
    L81:
        r20 = r51;
        goto L83
    L77:
        r19 = r50;
        goto L78
    L73:
        r18 = r49;
        goto L75
    L69:
        r17 = r48;
        goto L71
    L65:
        r16 = r47;
        goto L67
    L61:
        r14 = r46;
        goto L63
    L57:
        r2 = r45;
        goto L59
    L53:
        r15 = r44;
        goto L55
    L49:
        r13 = r43;
        goto L51
    L45:
        r12 = r42;
        goto L47
    L37:
        r11 = r40;
        goto L39
    L33:
        r10 = r39;
        goto L35
    L29:
        r9 = r38;
        goto L31
    L25:
        r8 = r37;
        goto L27
    L21:
        r6 = r36;
        goto L23
    L17:
        r5 = r35;
        goto L18
    L13:
        r4 = r34;
        goto L15
    L9:
        r3 = r33;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }
}
