package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0019\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020.H\u0016J\b\u00101\u001a\u00020.H\u0016J\b\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u00020.H\u0016J\b\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020.H\u0016J\b\u00106\u001a\u00020.H\u0016J\b\u00107\u001a\u00020.H\u0016J\b\u00108\u001a\u00020.H\u0016J\b\u00109\u001a\u00020.H\u0016J\b\u0010:\u001a\u00020.H\u0016J\b\u0010;\u001a\u00020.H\u0016J\b\u0010<\u001a\u00020.H\u0016J\b\u0010=\u001a\u00020.H\u0016J\b\u0010>\u001a\u00020.H\u0016J\b\u0010?\u001a\u00020.H\u0016J\b\u0010@\u001a\u00020.H\u0016J\b\u0010A\u001a\u00020.H\u0016J\b\u0010B\u001a\u00020.H\u0016J\b\u0010C\u001a\u00020.H\u0016J\b\u0010D\u001a\u00020\fH\u0016J\u000f\u0010E\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u0010F¨\u0006G"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "Ljava/io/Serializable;", "isOwner", "", "setOwner", "", "adminCanCross", "adminPartnerTenantCanCross", "hasLinkPassword", "setHasLinkPassword", "hasPassword", "linkPassword", "", "setLinkPassword", "password", "isShareFolder", "canUnLock", "lockState", "reportJson", "showLinkShare", "externalAccess", "partnerTenantAccess", "isShareExternalWithRead", "isShareExternalWithFA", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "hasModifiedLinkShare", "()Ljava/lang/Boolean;", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "getManageCollaboratorReadBlockValue", "", "getManageCollaboratorEditBlockValue", "getManageCollaboratorFaBlockValue", "getShareInternalBlockValue", "getShareAnyoneBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "getPartnerTenantAccessBlockValue", "getShareExternalFaBlockValue", "getShareExternalReadBlockValue", "getSecurityReadBlockValue", "getSecurityEditBlockValue", "getSecurityFaBlockValue", "getCopyReadBlockValue", "getCopyEditBlockValue", "getCopyFaBlockValue", "getCommentReadBlockValue", "getCommentEditBlockValue", "getLinkShareCloseBlockValue", "getLinkShareInternalReadBlockValue", "getLinkShareInternalEditBlockValue", "getLinkShareAnyoneReadBlockValue", "getOwnerTenantName", "getVisibilityStatus", "()Ljava/lang/Integer;", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFolderPublicPermission extends Serializable {
    boolean adminCanCross();

    boolean adminPartnerTenantCanCross();

    boolean canUnLock();

    boolean externalAccess();

    int getCommentEditBlockValue();

    int getCommentReadBlockValue();

    int getCopyEditBlockValue();

    int getCopyFaBlockValue();

    int getCopyReadBlockValue();

    int getExternalAccessCloseBlockValue();

    int getExternalAccessOpenBlockValue();

    int getLinkShareAnyoneReadBlockValue();

    int getLinkShareCloseBlockValue();

    int getLinkShareInternalEditBlockValue();

    int getLinkShareInternalReadBlockValue();

    int getManageCollaboratorEditBlockValue();

    int getManageCollaboratorFaBlockValue();

    int getManageCollaboratorReadBlockValue();

    String getOwnerTenantName();

    int getPartnerTenantAccessBlockValue();

    int getSecurityEditBlockValue();

    int getSecurityFaBlockValue();

    int getSecurityReadBlockValue();

    int getShareAnyoneBlockValue();

    int getShareExternalFaBlockValue();

    int getShareExternalReadBlockValue();

    int getShareInternalBlockValue();

    Integer getVisibilityStatus();

    boolean hasLinkPassword();

    Boolean hasModifiedLinkShare();

    boolean isCommentWithEdit();

    boolean isCommentWithRead();

    boolean isCopyWithEdit();

    boolean isCopyWithFA();

    boolean isCopyWithRead();

    boolean isLinkShareAnyoneRead();

    boolean isLinkShareClose();

    boolean isLinkShareInternalEdit();

    boolean isLinkShareInternalRead();

    boolean isLinkSharePartnerTenantEdit();

    boolean isLinkSharePartnerTenantRead();

    boolean isManagerCollaboratorAnyone();

    boolean isManagerCollaboratorTenant();

    boolean isManagerCollaboratorWithEdit();

    boolean isManagerCollaboratorWithFA();

    boolean isManagerCollaboratorWithRead();

    boolean isOwner();

    boolean isSecurityWithEdit();

    boolean isSecurityWithFA();

    boolean isSecurityWithRead();

    boolean isShareExternalWithFA();

    boolean isShareExternalWithRead();

    boolean isShareFolder();

    String linkPassword();

    boolean lockState();

    boolean partnerTenantAccess();

    String reportJson();

    void setHasLinkPassword(boolean r100);

    void setLinkPassword(String r100);

    void setOwner(boolean r100);

    boolean showLinkShare();
}
