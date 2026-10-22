package com.bytedance.ee.bear.middleground.permission.permission.folder;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
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
        Integer r100 = this.blockOptions.getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getCommentReadBlockValue() {
        Integer r100 = this.blockOptions.getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getExternalAccessCloseBlockValue() {
        Integer r100 = this.blockOptions.getExternalAccessMap().get(2);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getExternalAccessOpenBlockValue() {
        Integer r100 = this.blockOptions.getExternalAccessMap().get(1);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareAnyoneReadBlockValue() {
        Integer r100 = this.blockOptions.getLinkShareMap().get(4);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareCloseBlockValue() {
        Integer r100 = this.blockOptions.getLinkShareMap().get(1);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareInternalEditBlockValue() {
        Integer r100 = this.blockOptions.getLinkShareMap().get(3);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getLinkShareInternalReadBlockValue() {
        Integer r100 = this.blockOptions.getLinkShareMap().get(2);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorEditBlockValue() {
        Integer r100 = this.blockOptions.getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorFaBlockValue() {
        Integer r100 = this.blockOptions.getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getManageCollaboratorReadBlockValue() {
        Integer r100 = this.blockOptions.getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getPartnerTenantAccessBlockValue() {
        Integer r100 = this.blockOptions.getExternalAccessMap().get(3);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityEditBlockValue() {
        Integer r100 = this.blockOptions.getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityFaBlockValue() {
        Integer r100 = this.blockOptions.getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getSecurityReadBlockValue() {
        Integer r100 = this.blockOptions.getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareAnyoneBlockValue() {
        Integer r100 = this.blockOptions.getShareMap().get(2);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareExternalFaBlockValue() {
        Integer r100 = this.blockOptions.getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareExternalReadBlockValue() {
        Integer r100 = this.blockOptions.getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public int getShareInternalBlockValue() {
        Integer r100 = this.blockOptions.getShareMap().get(1);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
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
    public void setHasLinkPassword(boolean r100) {
        this.hasLinkPassword = this.hasLinkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setLinkPassword(String r100) {
        Intrinsics.checkNotNullParameter(r100, "password");
        this.linkPassword = r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    public FolderPublicPermissionV3(boolean r100, boolean r101, int r110, boolean r111, boolean r112, int r113, int r114, int r115, int r116, int r117, boolean r118, String r119, int r210, int r211, boolean r212, String r213, BlockOptions r214, BlockOptionsV2 r215, String r216, Boolean r217, Integer r218) {
        Intrinsics.checkNotNullParameter(r119, "linkPassword");
        Intrinsics.checkNotNullParameter(r213, "tenantName");
        Intrinsics.checkNotNullParameter(r214, "blockOptions");
        Intrinsics.checkNotNullParameter(r215, "blockOptionsV2");
        Intrinsics.checkNotNullParameter(r216, "reportJson");
        this.isOwner = r100;
        this.adminCanCross = r101;
        this.adminExternalCross = r110;
        this.canUnlock = r111;
        this.isShareFolder = r112;
        this.shareEntity = r113;
        this.manageCollaboratorEntity = r114;
        this.securityEntity = r115;
        this.commentEntity = r116;
        this.linkShareEntityV2 = r117;
        this.hasLinkPassword = r118;
        this.linkPassword = r119;
        this.externalAccessEntity = r210;
        this.shareExternalEntity = r211;
        this.lockState = r212;
        this.tenantName = r213;
        this.blockOptions = r214;
        this.blockOptionsV2 = r215;
        this.reportJson = r216;
        this.hasModifiedLinkShare = r217;
        this.visibilityStatus = r218;
    }

    public /* synthetic */ FolderPublicPermissionV3(boolean r310, boolean r311, int r312, boolean r313, boolean r314, int r315, int r316, int r317, int r410, int r411, boolean r412, String r413, int r414, int r415, boolean r416, String r417, BlockOptions r418, BlockOptionsV2 r419, String r510, Boolean r511, Integer r512, int r513, DefaultConstructorMarker r514) {
        if ((r513 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r513 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r513 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r513 & 8) == 0) goto L17;
        boolean r103 = false;
    L18:
        int r104 = 1;
        if ((r513 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r513 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r513 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r513 & 128) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r513 & 256) == 0) goto L37;
        int r111 = 0;
    L39:
        if ((r513 & 512) != 0) goto L43;
        r104 = r411;
    L43:
        if ((r513 & 1024) == 0) goto L45;
        boolean r112 = false;
    L47:
        if ((r513 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r513 & 4096) == 0) goto L53;
        int r114 = 0;
    L55:
        if ((r513 & 8192) == 0) goto L57;
        int r108 = 0;
    L59:
        if ((r513 & 16384) == 0) goto L61;
        boolean r115 = false;
    L63:
        if ((r513 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r513 & 65536) == 0) goto L69;
        BlockOptions r117 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L71:
        if ((r513 & 131072) == 0) goto L73;
        BlockOptionsV2 r118 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L75:
        if ((r513 & 262144) == 0) goto L77;
        String r119 = "";
    L78:
        Integer r210 = null;
        if ((r513 & 524288) == 0) goto L81;
        Boolean r211 = null;
    L83:
        if ((r513 & 1048576) != 0) goto L86;
        r210 = r512;
    L86:
        this(r100, r101, r102, r103, r105, r106, r107, r110, r111, r104, r112, r113, r114, r108, r115, r116, r117, r118, r119, r211, r210);
        return;
    L81:
        r211 = r511;
        goto L83
    L77:
        r119 = r510;
        goto L78
    L73:
        r118 = r419;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r115 = r416;
        goto L63
    L57:
        r108 = r415;
        goto L59
    L53:
        r114 = r414;
        goto L55
    L49:
        r113 = r413;
        goto L51
    L45:
        r112 = r412;
        goto L47
    L37:
        r111 = r410;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r107 = r316;
        goto L31
    L25:
        r106 = r315;
        goto L27
    L21:
        r105 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L18
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
