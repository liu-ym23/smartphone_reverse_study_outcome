package com.bytedance.ee.bear.middleground.permission.permission.folder;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b#\u0018\u0000 32\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013BM\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/folder/FolderPublicPermissionV1;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "isOwner", "", "adminCanCross", "externalAccess", "hasLinkPassword", "linkPassword", "", "linkShareEntity", "", "reportJson", "<init>", "(ZZZZLjava/lang/String;ILjava/lang/String;)V", "setOwner", "", "adminPartnerTenantCanCross", "setHasLinkPassword", "hasPassword", "setLinkPassword", "password", "isShareFolder", "canUnLock", "lockState", "showLinkShare", "partnerTenantAccess", "isShareExternalWithRead", "isShareExternalWithFA", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "hasModifiedLinkShare", "()Ljava/lang/Boolean;", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderPublicPermissionV1 extends Result<Serializable> implements IFolderPublicPermission {
    public static final a Companion = null;
    public static final int LINK_SHARE_ANYONE_READ = 4;
    public static final int LINK_SHARE_CLOSE = 0;
    public static final int LINK_SHARE_INTERNAL_EDIT = 2;
    public static final int LINK_SHARE_INTERNAL_READ = 1;
    private boolean adminCanCross;
    private boolean externalAccess;
    private boolean hasLinkPassword;
    private boolean isOwner;
    private String linkPassword;
    private int linkShareEntity;
    private final String reportJson;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FolderPublicPermissionV1() {
        this(false, false, false, false, null, 0, null, 127, null);
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
        return true;
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
    public boolean showLinkShare() {
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareAnyoneRead() {
        if (this.linkShareEntity != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareClose() {
        if (this.linkShareEntity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareInternalEdit() {
        if (this.linkShareEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isLinkShareInternalRead() {
        if (this.linkShareEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean adminCanCross() {
        return this.adminCanCross;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean externalAccess() {
        return this.externalAccess;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean hasLinkPassword() {
        return this.hasLinkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public boolean isOwner() {
        return this.isOwner;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission
    public String linkPassword() {
        return this.linkPassword;
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

    public FolderPublicPermissionV1(boolean r100, boolean r101, boolean r102, boolean r103, String r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r104, "linkPassword");
        Intrinsics.checkNotNullParameter(r106, "reportJson");
        this.isOwner = r100;
        this.adminCanCross = r101;
        this.externalAccess = r102;
        this.hasLinkPassword = r103;
        this.linkPassword = r104;
        this.linkShareEntity = r105;
        this.reportJson = r106;
    }

    public /* synthetic */ FolderPublicPermissionV1(boolean r100, boolean r101, boolean r102, boolean r103, String r110, int r111, String r112, int r113, DefaultConstructorMarker r114) {
        int r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        boolean r115 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r113 & 4) == 0) goto L13;
        boolean r106 = false;
    L15:
        if ((r113 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r108 = "";
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        String r116 = "";
    L30:
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
