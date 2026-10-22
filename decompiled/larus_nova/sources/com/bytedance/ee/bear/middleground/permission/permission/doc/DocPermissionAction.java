package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ee.bear.contract.Result;
import com.larus.bmhome.share.panel.ShareChannel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\bf\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u009b\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u009b\u0001Bù\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0004\b)\u0010*J\u0006\u0010j\u001a\u00020kJ\u0006\u0010l\u001a\u00020kJ\u0006\u0010m\u001a\u00020kJ\u0006\u0010n\u001a\u00020kJ\u0006\u0010o\u001a\u00020kJ\u0006\u0010p\u001a\u00020kJ\u0006\u0010q\u001a\u00020kJ\u0006\u0010r\u001a\u00020kJ\u0006\u0010s\u001a\u00020kJ\u0006\u0010t\u001a\u00020kJ\u0006\u0010u\u001a\u00020kJ\u0006\u0010v\u001a\u00020kJ\u0006\u0010w\u001a\u00020kJ\u0006\u0010x\u001a\u00020kJ\u0006\u0010y\u001a\u00020kJ\u0006\u0010z\u001a\u00020kJ\u0006\u0010{\u001a\u00020kJ\u0006\u0010|\u001a\u00020kJ\u0006\u0010}\u001a\u00020kJ\u0006\u0010~\u001a\u00020kJ\u0006\u0010\u007f\u001a\u00020kJ\u0007\u0010\u0080\u0001\u001a\u00020kJ\u0007\u0010\u0081\u0001\u001a\u00020kJ\u0007\u0010\u0082\u0001\u001a\u00020kJ\u0007\u0010\u0083\u0001\u001a\u00020kJ\u0007\u0010\u0084\u0001\u001a\u00020kJ\u0007\u0010\u0085\u0001\u001a\u00020kJ\u0007\u0010\u0086\u0001\u001a\u00020kJ\u0007\u0010\u0087\u0001\u001a\u00020kJ\u0007\u0010\u0088\u0001\u001a\u00020kJ\u0007\u0010\u0089\u0001\u001a\u00020kJ\u0007\u0010\u008a\u0001\u001a\u00020kJ\u0007\u0010\u008b\u0001\u001a\u00020kJ\u0007\u0010\u008c\u0001\u001a\u00020kJ\u0007\u0010\u008d\u0001\u001a\u00020kJ\u0007\u0010\u008e\u0001\u001a\u00020kJ\u0007\u0010\u008f\u0001\u001a\u00020kJ\u0007\u0010\u0090\u0001\u001a\u00020kJ\u0007\u0010\u0091\u0001\u001a\u00020kJ\u0007\u0010\u0092\u0001\u001a\u00020kJ\u0007\u0010\u0093\u0001\u001a\u00020kJ\u0007\u0010\u0094\u0001\u001a\u00020kJ\u0007\u0010\u0095\u0001\u001a\u00020kJ\u0007\u0010\u0096\u0001\u001a\u00020kJ\u0007\u0010\u0097\u0001\u001a\u00020kJ\u0007\u0010\u0098\u0001\u001a\u00020kJ\n\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010,\"\u0004\bD\u0010.R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010,\"\u0004\bL\u0010.R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010,\"\u0004\bP\u0010.R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010,\"\u0004\bR\u0010.R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010,\"\u0004\bT\u0010.R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010,\"\u0004\bV\u0010.R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010,\"\u0004\bX\u0010.R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010,\"\u0004\bZ\u0010.R\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010,\"\u0004\b\\\u0010.R\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010,\"\u0004\b^\u0010.R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010,R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010,R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010,R\u0011\u0010 \u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010,R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010,R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010,R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010,R\u0011\u0010$\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010,R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010,\"\u0004\bf\u0010.R\u0011\u0010&\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010,R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010,R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010,¨\u0006\u009c\u0001"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/DocPermissionAction;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "view", "", "edit", "comment", "copy", "duplicate", "export", "manage_collaborator", "manage_meta", "create_sub_node", "download", "operate_from_dusbin", "operate_entity", "manage_single_page_collaborator", "manage_single_page_meta", "invite_full_access", "invite_can_edit", "invite_can_view", "invite_single_page_full_access", "invite_single_page_can_edit", "invite_single_page_can_view", "be_moved", "move_from", "move_to", "manage_history_record", "print", ShareChannel.COLLECT, "applyEmbed", "visit_secret_level", "modify_secret_level", "is_full_access", "is_single_page_full_access", "show_collaborator_info", "preview", "perceive", "manageVersion", "shareExternal", "sharePartnerTenant", "<init>", "(IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII)V", "getView", "()I", "setView", "(I)V", "getEdit", "setEdit", "getComment", "setComment", "getCopy", "setCopy", "getDuplicate", "setDuplicate", "getExport", "setExport", "getManage_collaborator", "setManage_collaborator", "getManage_meta", "setManage_meta", "getCreate_sub_node", "setCreate_sub_node", "getDownload", "setDownload", "getOperate_from_dusbin", "setOperate_from_dusbin", "getOperate_entity", "setOperate_entity", "getManage_single_page_collaborator", "setManage_single_page_collaborator", "getManage_single_page_meta", "setManage_single_page_meta", "getInvite_full_access", "setInvite_full_access", "getInvite_can_edit", "setInvite_can_edit", "getInvite_can_view", "setInvite_can_view", "getInvite_single_page_full_access", "setInvite_single_page_full_access", "getInvite_single_page_can_edit", "setInvite_single_page_can_edit", "getInvite_single_page_can_view", "setInvite_single_page_can_view", "getBe_moved", "setBe_moved", "getMove_from", "setMove_from", "getMove_to", "setMove_to", "getManage_history_record", "setManage_history_record", "getPrint", "setPrint", "getCollect", "getApplyEmbed", "getVisit_secret_level", "getModify_secret_level", "getShow_collaborator_info", "getPreview", "getPerceive", "setPerceive", "getManageVersion", "getShareExternal", "getSharePartnerTenant", "isExportCac", "", "canEdit", "canView", "isSecretFileView", "isSecretFileCopy", "isSecretFileCreateCopy", "isSecretFileEdit", "isSecretFileExport", "canPreview", "canPerceive", "isViewCac", "isPerceiveCac", "isViewDlpInnerControl", "canRenameAndCreateEdition", "canComment", "canCopy", "canCreateCopy", "canExport", "canManageContainerCollaborator", "canManageContainerPermissionMeta", "canCreate", "canUpload", "canDownload", "canApplyEmbed", "canOperateEntity", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canInviteSinglePageFullAccess", "canInviteSinglePageEdit", "canInviteSinglePageView", "canMoveThisNode", "canMoveSubNode", "canMoveToHere", "canManageSinglePageCollaborator", "canManageSinglePagePermissionMeta", "canVisitSecretLevel", "canModifySecretLevel", "isFullAccess", "isSinglePageFullAccess", "canViewCollaboratorInfo", "isShareExternalDeniedByPublicPerm", "isShareExternalDeniedBySecret", "isShareExternalSelectPartnerTenant", "isSharePartnerTenantDeniedByPublicPerm", "isSharePartnerTenantDeniedBySecret", "toString", "", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocPermissionAction extends Result<Serializable> {
    public static final int ACTION_ALLOW = 1;
    public static final int ACTION_CONDITION_DENY = 2002;
    public static final int ACTION_DENY = 2;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_PARTNER_TENANT_SHARE = 132;
    public static final int ACTION_PUBLIC_PERM_DENY = 133;
    public static final int ACTION_SECRET = 2301;
    public static final int ACTION_SECRET_DENY = 432;
    public static final a Companion = null;
    public static final int ERROR_DLP_INNER_SHARE_DETECTED_CODE = 2005;
    private final int applyEmbed;
    private int be_moved;
    private final int collect;
    private int comment;
    private int copy;
    private int create_sub_node;
    private int download;
    private int duplicate;
    private int edit;
    private int export;
    private int invite_can_edit;
    private int invite_can_view;
    private int invite_full_access;
    private int invite_single_page_can_edit;
    private int invite_single_page_can_view;
    private int invite_single_page_full_access;
    private final int is_full_access;
    private final int is_single_page_full_access;
    private final int manageVersion;
    private int manage_collaborator;
    private int manage_history_record;
    private int manage_meta;
    private int manage_single_page_collaborator;
    private int manage_single_page_meta;
    private final int modify_secret_level;
    private int move_from;
    private int move_to;
    private int operate_entity;
    private int operate_from_dusbin;
    private int perceive;
    private final int preview;
    private int print;
    private final int shareExternal;
    private final int sharePartnerTenant;
    private final int show_collaborator_info;
    private int view;
    private final int visit_secret_level;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocPermissionAction() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 31, null);
    }

    public final boolean canApplyEmbed() {
        if (this.applyEmbed == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canComment() {
        if (this.comment == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canCopy() {
        if (this.copy == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canCreate() {
        if (this.create_sub_node == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canCreateCopy() {
        if (this.duplicate == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canDownload() {
        if (this.download == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canEdit() {
        if (this.edit == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canExport() {
        if (this.export == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canInviteEdit() {
        if (this.invite_can_edit == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canInviteFullAccess() {
        if (this.invite_full_access == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canInviteSinglePageEdit() {
        if (this.invite_single_page_can_edit == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canInviteSinglePageFullAccess() {
        if (this.invite_single_page_full_access == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canInviteSinglePageView() {
        if (this.invite_single_page_can_view == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canInviteView() {
        if (this.invite_can_view == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canManageContainerCollaborator() {
        if (this.manage_collaborator == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canManageContainerPermissionMeta() {
        if (this.manage_meta == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canManageSinglePageCollaborator() {
        if (this.manage_single_page_collaborator == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canManageSinglePagePermissionMeta() {
        if (this.manage_single_page_meta == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canModifySecretLevel() {
        if (this.modify_secret_level == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canMoveSubNode() {
        if (this.move_from == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canMoveThisNode() {
        if (this.be_moved == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canMoveToHere() {
        if (this.move_to == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canOperateEntity() {
        if (this.operate_entity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canPerceive() {
        if (this.perceive == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canPreview() {
        if (this.preview == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canRenameAndCreateEdition() {
        if (this.manageVersion == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canUpload() {
        if (this.create_sub_node == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canView() {
        if (this.view == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canViewCollaboratorInfo() {
        if (this.show_collaborator_info == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canVisitSecretLevel() {
        if (this.visit_secret_level == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isExportCac() {
        if (this.export != 2002) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFullAccess() {
        if (this.manage_meta == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isPerceiveCac() {
        if (this.perceive != 2002) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecretFileCopy() {
        if (this.copy != 2301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecretFileCreateCopy() {
        if (this.duplicate != 2301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecretFileEdit() {
        if (this.edit != 2301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecretFileExport() {
        if (this.export != 2301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecretFileView() {
        if (this.view != 2301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isShareExternalDeniedByPublicPerm() {
        if (this.shareExternal != 133) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isShareExternalDeniedBySecret() {
        if (this.shareExternal != 432) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isShareExternalSelectPartnerTenant() {
        if (this.shareExternal != 132) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSharePartnerTenantDeniedByPublicPerm() {
        if (this.sharePartnerTenant != 133) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSharePartnerTenantDeniedBySecret() {
        if (this.sharePartnerTenant != 432) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSinglePageFullAccess() {
        if (this.manage_single_page_meta == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isViewCac() {
        if (this.view != 2002) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isViewDlpInnerControl() {
        if (this.view != 2005) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "DocPermissionAction(view=" + this.view + ", edit=" + this.edit + ", comment=" + this.comment + ", copy=" + this.copy + ", duplicate=" + this.duplicate + ", export=" + this.export + ", manage_collaborator=" + this.manage_collaborator + ", manage_meta=" + this.manage_meta + ", create_sub_node=" + this.create_sub_node + ", download=" + this.download + ", operate_from_dusbin=" + this.operate_from_dusbin + ", operate_entity=" + this.operate_entity + ", manage_single_page_collaborator=" + this.manage_single_page_collaborator + ", manage_single_page_meta=" + this.manage_single_page_meta + ", invite_full_access=" + this.invite_full_access + ", invite_can_edit=" + this.invite_can_edit + ", invite_can_view=" + this.invite_can_view + ", invite_single_page_full_access=" + this.invite_single_page_full_access + ", invite_single_page_can_edit=" + this.invite_single_page_can_edit + ", invite_single_page_can_view=" + this.invite_single_page_can_view + ", be_moved=" + this.be_moved + ", move_from=" + this.move_from + ", move_to=" + this.move_to + ", manage_history_record=" + this.manage_history_record + ", print=" + this.print + ", collect=" + this.collect + ", applyEmbed=" + this.applyEmbed + ", visit_secret_level=" + this.visit_secret_level + ", modify_secret_level=" + this.modify_secret_level + ", is_full_access=" + this.is_full_access + ", is_single_page_full_access=" + this.is_single_page_full_access + ", show_collaborator_info=" + this.show_collaborator_info + ", preview=" + this.preview + ", perceive=" + this.perceive + ", manageVersion=" + this.manageVersion + ", shareExternal=" + this.shareExternal + ", sharePartnerTenant=" + this.sharePartnerTenant + ')';
    }

    public final int getApplyEmbed() {
        return this.applyEmbed;
    }

    public final int getBe_moved() {
        return this.be_moved;
    }

    public final int getCollect() {
        return this.collect;
    }

    public final int getComment() {
        return this.comment;
    }

    public final int getCopy() {
        return this.copy;
    }

    public final int getCreate_sub_node() {
        return this.create_sub_node;
    }

    public final int getDownload() {
        return this.download;
    }

    public final int getDuplicate() {
        return this.duplicate;
    }

    public final int getEdit() {
        return this.edit;
    }

    public final int getExport() {
        return this.export;
    }

    public final int getInvite_can_edit() {
        return this.invite_can_edit;
    }

    public final int getInvite_can_view() {
        return this.invite_can_view;
    }

    public final int getInvite_full_access() {
        return this.invite_full_access;
    }

    public final int getInvite_single_page_can_edit() {
        return this.invite_single_page_can_edit;
    }

    public final int getInvite_single_page_can_view() {
        return this.invite_single_page_can_view;
    }

    public final int getInvite_single_page_full_access() {
        return this.invite_single_page_full_access;
    }

    public final int getManageVersion() {
        return this.manageVersion;
    }

    public final int getManage_collaborator() {
        return this.manage_collaborator;
    }

    public final int getManage_history_record() {
        return this.manage_history_record;
    }

    public final int getManage_meta() {
        return this.manage_meta;
    }

    public final int getManage_single_page_collaborator() {
        return this.manage_single_page_collaborator;
    }

    public final int getManage_single_page_meta() {
        return this.manage_single_page_meta;
    }

    public final int getModify_secret_level() {
        return this.modify_secret_level;
    }

    public final int getMove_from() {
        return this.move_from;
    }

    public final int getMove_to() {
        return this.move_to;
    }

    public final int getOperate_entity() {
        return this.operate_entity;
    }

    public final int getOperate_from_dusbin() {
        return this.operate_from_dusbin;
    }

    public final int getPerceive() {
        return this.perceive;
    }

    public final int getPreview() {
        return this.preview;
    }

    public final int getPrint() {
        return this.print;
    }

    public final int getShareExternal() {
        return this.shareExternal;
    }

    public final int getSharePartnerTenant() {
        return this.sharePartnerTenant;
    }

    public final int getShow_collaborator_info() {
        return this.show_collaborator_info;
    }

    public final int getView() {
        return this.view;
    }

    public final int getVisit_secret_level() {
        return this.visit_secret_level;
    }

    public final int is_full_access() {
        return this.is_full_access;
    }

    public final int is_single_page_full_access() {
        return this.is_single_page_full_access;
    }

    public final void setBe_moved(int r100) {
        this.be_moved = r100;
    }

    public final void setComment(int r100) {
        this.comment = r100;
    }

    public final void setCopy(int r100) {
        this.copy = r100;
    }

    public final void setCreate_sub_node(int r100) {
        this.create_sub_node = r100;
    }

    public final void setDownload(int r100) {
        this.download = r100;
    }

    public final void setDuplicate(int r100) {
        this.duplicate = r100;
    }

    public final void setEdit(int r100) {
        this.edit = r100;
    }

    public final void setExport(int r100) {
        this.export = r100;
    }

    public final void setInvite_can_edit(int r100) {
        this.invite_can_edit = r100;
    }

    public final void setInvite_can_view(int r100) {
        this.invite_can_view = r100;
    }

    public final void setInvite_full_access(int r100) {
        this.invite_full_access = r100;
    }

    public final void setInvite_single_page_can_edit(int r100) {
        this.invite_single_page_can_edit = r100;
    }

    public final void setInvite_single_page_can_view(int r100) {
        this.invite_single_page_can_view = r100;
    }

    public final void setInvite_single_page_full_access(int r100) {
        this.invite_single_page_full_access = r100;
    }

    public final void setManage_collaborator(int r100) {
        this.manage_collaborator = r100;
    }

    public final void setManage_history_record(int r100) {
        this.manage_history_record = r100;
    }

    public final void setManage_meta(int r100) {
        this.manage_meta = r100;
    }

    public final void setManage_single_page_collaborator(int r100) {
        this.manage_single_page_collaborator = r100;
    }

    public final void setManage_single_page_meta(int r100) {
        this.manage_single_page_meta = r100;
    }

    public final void setMove_from(int r100) {
        this.move_from = r100;
    }

    public final void setMove_to(int r100) {
        this.move_to = r100;
    }

    public final void setOperate_entity(int r100) {
        this.operate_entity = r100;
    }

    public final void setOperate_from_dusbin(int r100) {
        this.operate_from_dusbin = r100;
    }

    public final void setPerceive(int r100) {
        this.perceive = r100;
    }

    public final void setPrint(int r100) {
        this.print = r100;
    }

    public final void setView(int r100) {
        this.view = r100;
    }

    public DocPermissionAction(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, int r318, int r319) {
        this.view = r100;
        this.edit = r101;
        this.comment = r102;
        this.copy = r103;
        this.duplicate = r104;
        this.export = r105;
        this.manage_collaborator = r106;
        this.manage_meta = r110;
        this.create_sub_node = r111;
        this.download = r112;
        this.operate_from_dusbin = r113;
        this.operate_entity = r114;
        this.manage_single_page_collaborator = r115;
        this.manage_single_page_meta = r116;
        this.invite_full_access = r117;
        this.invite_can_edit = r118;
        this.invite_can_view = r119;
        this.invite_single_page_full_access = r210;
        this.invite_single_page_can_edit = r211;
        this.invite_single_page_can_view = r212;
        this.be_moved = r213;
        this.move_from = r214;
        this.move_to = r215;
        this.manage_history_record = r216;
        this.print = r217;
        this.collect = r218;
        this.applyEmbed = r219;
        this.visit_secret_level = r310;
        this.modify_secret_level = r311;
        this.is_full_access = r312;
        this.is_single_page_full_access = r313;
        this.show_collaborator_info = r314;
        this.preview = r315;
        this.perceive = r316;
        this.manageVersion = r317;
        this.shareExternal = r318;
        this.sharePartnerTenant = r319;
    }

    public /* synthetic */ DocPermissionAction(int r310, int r311, int r410, int r411, int r412, int r413, int r414, int r415, int r416, int r417, int r418, int r419, int r510, int r511, int r512, int r513, int r514, int r515, int r516, int r517, int r518, int r519, int r610, int r611, int r612, int r613, int r614, int r615, int r616, int r617, int r618, int r619, int r710, int r711, int r712, int r713, int r714, int r715, int r716, DefaultConstructorMarker r717) {
        if ((r715 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r715 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r715 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r715 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r715 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r715 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r715 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r715 & 128) == 0) goto L33;
        int r107 = 0;
    L35:
        if ((r715 & 256) == 0) goto L37;
        int r110 = 0;
    L39:
        if ((r715 & 512) == 0) goto L41;
        int r111 = 0;
    L43:
        if ((r715 & 1024) == 0) goto L45;
        int r112 = 0;
    L47:
        if ((r715 & 2048) == 0) goto L49;
        int r113 = 0;
    L51:
        if ((r715 & 4096) == 0) goto L53;
        int r114 = 0;
    L55:
        if ((r715 & 8192) == 0) goto L57;
        int r115 = 0;
    L59:
        if ((r715 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r715 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r715 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r715 & 131072) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r715 & 262144) == 0) goto L77;
        int r119 = 0;
    L79:
        if ((r715 & 524288) == 0) goto L81;
        int r210 = 0;
    L83:
        if ((r715 & 1048576) == 0) goto L85;
        int r211 = 0;
    L87:
        if ((r715 & 2097152) == 0) goto L89;
        int r212 = 0;
    L91:
        if ((r715 & 4194304) == 0) goto L93;
        int r213 = 0;
    L95:
        if ((r715 & 8388608) == 0) goto L97;
        int r214 = 0;
    L99:
        if ((r715 & 16777216) == 0) goto L101;
        int r215 = 0;
    L103:
        if ((r715 & 33554432) == 0) goto L105;
        int r216 = 0;
    L107:
        if ((r715 & 67108864) == 0) goto L109;
        int r217 = 0;
    L111:
        if ((r715 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r218 = 0;
    L115:
        if ((r715 & 268435456) == 0) goto L117;
        int r219 = 0;
    L119:
        if ((r715 & 536870912) == 0) goto L121;
        int r312 = 0;
    L123:
        if ((r715 & 1073741824) == 0) goto L125;
        int r313 = 0;
    L127:
        if ((r715 & Integer.MIN_VALUE) == 0) goto L129;
        int r109 = 0;
    L131:
        if ((r716 & 1) == 0) goto L133;
        int r314 = 0;
    L135:
        if ((r716 & 2) == 0) goto L137;
        int r315 = 0;
    L139:
        if ((r716 & 4) == 0) goto L141;
        int r316 = 0;
    L143:
        if ((r716 & 8) == 0) goto L145;
        int r317 = 0;
    L147:
        if ((r716 & 16) == 0) goto L149;
        int r318 = 0;
    L150:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313, r109, r314, r315, r316, r317, r318);
        return;
    L149:
        r318 = r714;
        goto L150
    L145:
        r317 = r713;
        goto L147
    L141:
        r316 = r712;
        goto L143
    L137:
        r315 = r711;
        goto L139
    L133:
        r314 = r710;
        goto L135
    L129:
        r109 = r619;
        goto L131
    L125:
        r313 = r618;
        goto L127
    L121:
        r312 = r617;
        goto L123
    L117:
        r219 = r616;
        goto L119
    L113:
        r218 = r615;
        goto L115
    L109:
        r217 = r614;
        goto L111
    L105:
        r216 = r613;
        goto L107
    L101:
        r215 = r612;
        goto L103
    L97:
        r214 = r611;
        goto L99
    L93:
        r213 = r610;
        goto L95
    L89:
        r212 = r519;
        goto L91
    L85:
        r211 = r518;
        goto L87
    L81:
        r210 = r517;
        goto L83
    L77:
        r119 = r516;
        goto L79
    L73:
        r118 = r515;
        goto L75
    L69:
        r117 = r514;
        goto L71
    L65:
        r116 = r513;
        goto L67
    L61:
        r108 = r512;
        goto L63
    L57:
        r115 = r511;
        goto L59
    L53:
        r114 = r510;
        goto L55
    L49:
        r113 = r419;
        goto L51
    L45:
        r112 = r418;
        goto L47
    L41:
        r111 = r417;
        goto L43
    L37:
        r110 = r416;
        goto L39
    L33:
        r107 = r415;
        goto L35
    L29:
        r106 = r414;
        goto L31
    L25:
        r105 = r413;
        goto L27
    L21:
        r104 = r412;
        goto L23
    L17:
        r103 = r411;
        goto L19
    L13:
        r102 = r410;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
