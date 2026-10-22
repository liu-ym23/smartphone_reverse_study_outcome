package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.ee.bear.contract.Result;
import com.larus.bmhome.share.panel.ShareChannel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001[B\u009d\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u0006\u0010<\u001a\u000206J\u0006\u0010=\u001a\u000206J\u0006\u0010>\u001a\u000206J\u0006\u0010?\u001a\u000206J\u0006\u0010@\u001a\u000206J\u0006\u0010A\u001a\u000206J\u0006\u0010B\u001a\u000206J\u0006\u0010C\u001a\u000206J\u0006\u0010D\u001a\u000206J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0004HÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\u0004HÆ\u0003J\t\u0010N\u001a\u00020\u0004HÆ\u0003J\t\u0010O\u001a\u00020\u0004HÆ\u0003J\t\u0010P\u001a\u00020\u0004HÆ\u0003J\t\u0010Q\u001a\u00020\u0004HÆ\u0003J\t\u0010R\u001a\u00020\u0004HÆ\u0003J\t\u0010S\u001a\u00020\u0004HÆ\u0003J\u009f\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004HÆ\u0001J\u0013\u0010U\u001a\u0002062\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\u0004HÖ\u0001J\t\u0010Y\u001a\u00020ZHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018¨\u0006\\"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/PermissionAction;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "view", "", "edit", "manage_collaborator", "manage_meta", "create_sub_node", "download", ShareChannel.COLLECT, "operate_from_dusbin", "operate_entity", "invite_full_access", "invite_can_edit", "invite_can_view", "be_moved", "move_from", "move_to", "<init>", "(IIIIIIIIIIIIIII)V", "getView", "()I", "setView", "(I)V", "getEdit", "setEdit", "getManage_collaborator", "setManage_collaborator", "getManage_meta", "setManage_meta", "getCreate_sub_node", "setCreate_sub_node", "getDownload", "setDownload", "getCollect", "setCollect", "getOperate_from_dusbin", "setOperate_from_dusbin", "getOperate_entity", "setOperate_entity", "getInvite_full_access", "setInvite_full_access", "getInvite_can_edit", "setInvite_can_edit", "getInvite_can_view", "setInvite_can_view", "getBe_moved", "setBe_moved", "getMove_from", "setMove_from", "getMove_to", "setMove_to", "canEdit", "", "canView", "canManageCollaborator", "canManagePermissionMeta", "canCreate", "canUpload", "canDownload", "canCollect", "canOperateEntity", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canMoveThisNode", "canMoveSubNode", "canMoveToHere", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionAction extends Result<Serializable> {
    public static final int ACTION_ALLOW = 1;
    public static final int ACTION_DENY = 2;
    public static final int ACTION_NONE = 0;
    public static final a Companion = null;
    private int be_moved;
    private int collect;
    private int create_sub_node;
    private int download;
    private int edit;
    private int invite_can_edit;
    private int invite_can_view;
    private int invite_full_access;
    private int manage_collaborator;
    private int manage_meta;
    private int move_from;
    private int move_to;
    private int operate_entity;
    private int operate_from_dusbin;
    private int view;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PermissionAction() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
    }

    public static /* synthetic */ PermissionAction copy$default(PermissionAction r110, int r111, int r112, int r113, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        int r100 = r110.view;
    L7:
        if ((r312 & 2) == 0) goto L9;
        int r101 = r110.edit;
    L11:
        if ((r312 & 4) == 0) goto L13;
        int r102 = r110.manage_collaborator;
    L15:
        if ((r312 & 8) == 0) goto L17;
        int r103 = r110.manage_meta;
    L19:
        if ((r312 & 16) == 0) goto L21;
        int r104 = r110.create_sub_node;
    L23:
        if ((r312 & 32) == 0) goto L25;
        int r105 = r110.download;
    L27:
        if ((r312 & 64) == 0) goto L29;
        int r106 = r110.collect;
    L31:
        if ((r312 & 128) == 0) goto L33;
        int r107 = r110.operate_from_dusbin;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r114 = r110.operate_entity;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r115 = r110.invite_full_access;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        int r116 = r110.invite_can_edit;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        int r117 = r110.invite_can_view;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        int r118 = r110.be_moved;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        int r119 = r110.move_from;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        int r108 = r110.move_to;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.view;
    }

    public final int component10() {
        return this.invite_full_access;
    }

    public final int component11() {
        return this.invite_can_edit;
    }

    public final int component12() {
        return this.invite_can_view;
    }

    public final int component13() {
        return this.be_moved;
    }

    public final int component14() {
        return this.move_from;
    }

    public final int component15() {
        return this.move_to;
    }

    public final int component2() {
        return this.edit;
    }

    public final int component3() {
        return this.manage_collaborator;
    }

    public final int component4() {
        return this.manage_meta;
    }

    public final int component5() {
        return this.create_sub_node;
    }

    public final int component6() {
        return this.download;
    }

    public final int component7() {
        return this.collect;
    }

    public final int component8() {
        return this.operate_from_dusbin;
    }

    public final int component9() {
        return this.operate_entity;
    }

    public final PermissionAction copy(int r110, int r111, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312) {
        return new PermissionAction(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PermissionAction) == true) goto L8;
        return false;
    L8:
        PermissionAction r101 = (PermissionAction) r100;
        if (this.view == r101.view) goto L12;
        return false;
    L12:
        if (this.edit == r101.edit) goto L15;
        return false;
    L15:
        if (this.manage_collaborator == r101.manage_collaborator) goto L18;
        return false;
    L18:
        if (this.manage_meta == r101.manage_meta) goto L21;
        return false;
    L21:
        if (this.create_sub_node == r101.create_sub_node) goto L24;
        return false;
    L24:
        if (this.download == r101.download) goto L27;
        return false;
    L27:
        if (this.collect == r101.collect) goto L30;
        return false;
    L30:
        if (this.operate_from_dusbin == r101.operate_from_dusbin) goto L33;
        return false;
    L33:
        if (this.operate_entity == r101.operate_entity) goto L36;
        return false;
    L36:
        if (this.invite_full_access == r101.invite_full_access) goto L39;
        return false;
    L39:
        if (this.invite_can_edit == r101.invite_can_edit) goto L42;
        return false;
    L42:
        if (this.invite_can_view == r101.invite_can_view) goto L45;
        return false;
    L45:
        if (this.be_moved == r101.be_moved) goto L48;
        return false;
    L48:
        if (this.move_from == r101.move_from) goto L51;
        return false;
    L51:
        if (this.move_to == r101.move_to) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.view * 31) + this.edit) * 31) + this.manage_collaborator) * 31) + this.manage_meta) * 31) + this.create_sub_node) * 31) + this.download) * 31) + this.collect) * 31) + this.operate_from_dusbin) * 31) + this.operate_entity) * 31) + this.invite_full_access) * 31) + this.invite_can_edit) * 31) + this.invite_can_view) * 31) + this.be_moved) * 31) + this.move_from) * 31) + this.move_to;
    }

    public String toString() {
        return "PermissionAction(view=" + this.view + ", edit=" + this.edit + ", manage_collaborator=" + this.manage_collaborator + ", manage_meta=" + this.manage_meta + ", create_sub_node=" + this.create_sub_node + ", download=" + this.download + ", collect=" + this.collect + ", operate_from_dusbin=" + this.operate_from_dusbin + ", operate_entity=" + this.operate_entity + ", invite_full_access=" + this.invite_full_access + ", invite_can_edit=" + this.invite_can_edit + ", invite_can_view=" + this.invite_can_view + ", be_moved=" + this.be_moved + ", move_from=" + this.move_from + ", move_to=" + this.move_to + ')';
    }

    public final boolean canCollect() {
        if (this.collect == 1) goto L7;
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

    public final boolean canInviteView() {
        if (this.invite_can_view == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canManageCollaborator() {
        if (this.manage_collaborator == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canManagePermissionMeta() {
        if (this.manage_meta == 1) goto L7;
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

    public final int getBe_moved() {
        return this.be_moved;
    }

    public final int getCollect() {
        return this.collect;
    }

    public final int getCreate_sub_node() {
        return this.create_sub_node;
    }

    public final int getDownload() {
        return this.download;
    }

    public final int getEdit() {
        return this.edit;
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

    public final int getManage_collaborator() {
        return this.manage_collaborator;
    }

    public final int getManage_meta() {
        return this.manage_meta;
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

    public final int getView() {
        return this.view;
    }

    public final void setBe_moved(int r100) {
        this.be_moved = r100;
    }

    public final void setCollect(int r100) {
        this.collect = r100;
    }

    public final void setCreate_sub_node(int r100) {
        this.create_sub_node = r100;
    }

    public final void setDownload(int r100) {
        this.download = r100;
    }

    public final void setEdit(int r100) {
        this.edit = r100;
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

    public final void setManage_collaborator(int r100) {
        this.manage_collaborator = r100;
    }

    public final void setManage_meta(int r100) {
        this.manage_meta = r100;
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

    public final void setView(int r100) {
        this.view = r100;
    }

    public PermissionAction(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, int r113, int r114, int r115) {
        this.view = r100;
        this.edit = r101;
        this.manage_collaborator = r102;
        this.manage_meta = r103;
        this.create_sub_node = r104;
        this.download = r105;
        this.collect = r106;
        this.operate_from_dusbin = r107;
        this.operate_entity = r108;
        this.invite_full_access = r110;
        this.invite_can_edit = r111;
        this.invite_can_view = r112;
        this.be_moved = r113;
        this.move_from = r114;
        this.move_to = r115;
    }

    public /* synthetic */ PermissionAction(int r110, int r111, int r112, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, DefaultConstructorMarker r313) {
        int r100 = 0;
        if ((r312 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r312 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r312 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r312 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r312 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r312 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r312 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r312 & 128) == 0) goto L33;
        int r108 = 0;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r113 = 0;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r114 = 0;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        int r115 = 0;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        int r116 = 0;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        int r117 = 0;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        int r118 = 0;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r100 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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
}
