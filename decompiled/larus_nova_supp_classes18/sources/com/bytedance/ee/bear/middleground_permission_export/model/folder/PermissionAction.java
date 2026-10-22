package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001[B\u009d\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u0006\u0010<\u001a\u000206J\u0006\u0010=\u001a\u000206J\u0006\u0010>\u001a\u000206J\u0006\u0010?\u001a\u000206J\u0006\u0010@\u001a\u000206J\u0006\u0010A\u001a\u000206J\u0006\u0010B\u001a\u000206J\u0006\u0010C\u001a\u000206J\u0006\u0010D\u001a\u000206J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0004HÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\u0004HÆ\u0003J\t\u0010N\u001a\u00020\u0004HÆ\u0003J\t\u0010O\u001a\u00020\u0004HÆ\u0003J\t\u0010P\u001a\u00020\u0004HÆ\u0003J\t\u0010Q\u001a\u00020\u0004HÆ\u0003J\t\u0010R\u001a\u00020\u0004HÆ\u0003J\t\u0010S\u001a\u00020\u0004HÆ\u0003J\u009f\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004HÆ\u0001J\u0013\u0010U\u001a\u0002062\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\u0004HÖ\u0001J\t\u0010Y\u001a\u00020ZHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018¨\u0006\\"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/PermissionAction;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "view", "", "edit", "manage_collaborator", "manage_meta", "create_sub_node", OperationName.OPERATION_DOWNLOAD, "collect", "operate_from_dusbin", "operate_entity", "invite_full_access", "invite_can_edit", "invite_can_view", "be_moved", "move_from", "move_to", "<init>", "(IIIIIIIIIIIIIII)V", "getView", "()I", "setView", "(I)V", "getEdit", "setEdit", "getManage_collaborator", "setManage_collaborator", "getManage_meta", "setManage_meta", "getCreate_sub_node", "setCreate_sub_node", "getDownload", "setDownload", "getCollect", "setCollect", "getOperate_from_dusbin", "setOperate_from_dusbin", "getOperate_entity", "setOperate_entity", "getInvite_full_access", "setInvite_full_access", "getInvite_can_edit", "setInvite_can_edit", "getInvite_can_view", "setInvite_can_view", "getBe_moved", "setBe_moved", "getMove_from", "setMove_from", "getMove_to", "setMove_to", "canEdit", "", "canView", "canManageCollaborator", "canManagePermissionMeta", "canCreate", "canUpload", "canDownload", "canCollect", "canOperateEntity", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canMoveThisNode", "canMoveSubNode", "canMoveToHere", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ PermissionAction copy$default(PermissionAction r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        int r2 = r16.view;
    L7:
        if ((r32 & 2) == 0) goto L9;
        int r3 = r16.edit;
    L11:
        if ((r32 & 4) == 0) goto L13;
        int r4 = r16.manage_collaborator;
    L15:
        if ((r32 & 8) == 0) goto L17;
        int r5 = r16.manage_meta;
    L19:
        if ((r32 & 16) == 0) goto L21;
        int r6 = r16.create_sub_node;
    L23:
        if ((r32 & 32) == 0) goto L25;
        int r7 = r16.download;
    L27:
        if ((r32 & 64) == 0) goto L29;
        int r8 = r16.collect;
    L31:
        if ((r32 & 128) == 0) goto L33;
        int r9 = r16.operate_from_dusbin;
    L35:
        if ((r32 & 256) == 0) goto L37;
        int r10 = r16.operate_entity;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r11 = r16.invite_full_access;
    L43:
        if ((r32 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        int r12 = r16.invite_can_edit;
    L47:
        if ((r32 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        int r13 = r16.invite_can_view;
    L51:
        if ((r32 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        int r14 = r16.be_moved;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        int r15 = r16.move_from;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        int r1 = r16.move_to;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
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

    public final PermissionAction copy(int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32) {
        return new PermissionAction(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PermissionAction) == true) goto L8;
        return false;
    L8:
        PermissionAction r6 = (PermissionAction) r5;
        if (this.view == r6.view) goto L12;
        return false;
    L12:
        if (this.edit == r6.edit) goto L15;
        return false;
    L15:
        if (this.manage_collaborator == r6.manage_collaborator) goto L18;
        return false;
    L18:
        if (this.manage_meta == r6.manage_meta) goto L21;
        return false;
    L21:
        if (this.create_sub_node == r6.create_sub_node) goto L24;
        return false;
    L24:
        if (this.download == r6.download) goto L27;
        return false;
    L27:
        if (this.collect == r6.collect) goto L30;
        return false;
    L30:
        if (this.operate_from_dusbin == r6.operate_from_dusbin) goto L33;
        return false;
    L33:
        if (this.operate_entity == r6.operate_entity) goto L36;
        return false;
    L36:
        if (this.invite_full_access == r6.invite_full_access) goto L39;
        return false;
    L39:
        if (this.invite_can_edit == r6.invite_can_edit) goto L42;
        return false;
    L42:
        if (this.invite_can_view == r6.invite_can_view) goto L45;
        return false;
    L45:
        if (this.be_moved == r6.be_moved) goto L48;
        return false;
    L48:
        if (this.move_from == r6.move_from) goto L51;
        return false;
    L51:
        if (this.move_to == r6.move_to) goto L53;
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

    public final void setBe_moved(int r1) {
        this.be_moved = r1;
    }

    public final void setCollect(int r1) {
        this.collect = r1;
    }

    public final void setCreate_sub_node(int r1) {
        this.create_sub_node = r1;
    }

    public final void setDownload(int r1) {
        this.download = r1;
    }

    public final void setEdit(int r1) {
        this.edit = r1;
    }

    public final void setInvite_can_edit(int r1) {
        this.invite_can_edit = r1;
    }

    public final void setInvite_can_view(int r1) {
        this.invite_can_view = r1;
    }

    public final void setInvite_full_access(int r1) {
        this.invite_full_access = r1;
    }

    public final void setManage_collaborator(int r1) {
        this.manage_collaborator = r1;
    }

    public final void setManage_meta(int r1) {
        this.manage_meta = r1;
    }

    public final void setMove_from(int r1) {
        this.move_from = r1;
    }

    public final void setMove_to(int r1) {
        this.move_to = r1;
    }

    public final void setOperate_entity(int r1) {
        this.operate_entity = r1;
    }

    public final void setOperate_from_dusbin(int r1) {
        this.operate_from_dusbin = r1;
    }

    public final void setView(int r1) {
        this.view = r1;
    }

    public PermissionAction(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        this.view = r1;
        this.edit = r2;
        this.manage_collaborator = r3;
        this.manage_meta = r4;
        this.create_sub_node = r5;
        this.download = r6;
        this.collect = r7;
        this.operate_from_dusbin = r8;
        this.operate_entity = r9;
        this.invite_full_access = r10;
        this.invite_can_edit = r11;
        this.invite_can_view = r12;
        this.be_moved = r13;
        this.move_from = r14;
        this.move_to = r15;
    }

    public /* synthetic */ PermissionAction(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, DefaultConstructorMarker r33) {
        int r2 = 0;
        if ((r32 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r32 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r32 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r32 & 8) == 0) goto L17;
        int r5 = 0;
    L19:
        if ((r32 & 16) == 0) goto L21;
        int r6 = 0;
    L23:
        if ((r32 & 32) == 0) goto L25;
        int r7 = 0;
    L27:
        if ((r32 & 64) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r32 & 128) == 0) goto L33;
        int r9 = 0;
    L35:
        if ((r32 & 256) == 0) goto L37;
        int r10 = 0;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r11 = 0;
    L43:
        if ((r32 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        int r12 = 0;
    L47:
        if ((r32 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        int r13 = 0;
    L51:
        if ((r32 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        int r14 = 0;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        int r15 = 0;
    L59:
        if ((r32 & 16384) != 0) goto L62;
        r2 = r31;
    L62:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2);
        return;
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
