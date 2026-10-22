package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B;\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\fJ\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J;\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0004HÖ\u0001J\t\u00107\u001a\u00020\fHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", ComplianceResult.JsonKey.PERMISSIONS, "", SlcCommonAction.KEY_ACTIONS, "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/PermissionAction;", "version", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "isRoot", "", "json", "", "<init>", "(ILcom/bytedance/ee/bear/middleground_permission_export/model/folder/PermissionAction;Lcom/bytedance/ee/bear/list/dto/FolderVersion;ZLjava/lang/String;)V", "getPermissions", "()I", "setPermissions", "(I)V", "getActions", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/PermissionAction;", "setActions", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/PermissionAction;)V", "getVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "()Z", "setRoot", "(Z)V", "getJson", "()Ljava/lang/String;", "canView", "canEdit", "canManagerCollaborator", "canManagePermissionMeta", "isOwner", "canInviteFullAccess", "canInviteEdit", "canInviteView", "canBeMoved", "canMoveToHere", "canMoveSubNode", "canCreateSubNode", "getReportJson", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderUserPermission extends Result<Serializable> {
    public static final a Companion = null;
    public static final int PERM_ROLE_EDIT = 2;
    public static final int PERM_ROLE_FULL_ACCESS = 3;
    public static final int PERM_ROLE_VIEW = 1;
    private PermissionAction actions;
    private boolean isRoot;
    private final String json;
    private int permissions;
    private FolderVersion version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShareFolderUserPermission() {
        this(0, null, null, false, null, 31, null);
    }

    public ShareFolderUserPermission(int r100) {
        this(r100, null, null, false, null, 30, null);
    }

    public ShareFolderUserPermission(int r110, PermissionAction r111) {
        Intrinsics.checkNotNullParameter(r111, SlcCommonAction.KEY_ACTIONS);
        this(r110, r111, null, false, null, 28, null);
    }

    public ShareFolderUserPermission(int r110, PermissionAction r111, FolderVersion r112) {
        Intrinsics.checkNotNullParameter(r111, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r112, "version");
        this(r110, r111, r112, false, null, 24, null);
    }

    public ShareFolderUserPermission(int r110, PermissionAction r111, FolderVersion r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r111, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r112, "version");
        this(r110, r111, r112, r113, null, 16, null);
    }

    public static /* synthetic */ ShareFolderUserPermission copy$default(ShareFolderUserPermission r100, int r101, PermissionAction r102, FolderVersion r103, boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.permissions;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.actions;
    L8:
        PermissionAction r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.version;
    L11:
        FolderVersion r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isRoot;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.json;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.permissions;
    }

    public final PermissionAction component2() {
        return this.actions;
    }

    public final FolderVersion component3() {
        return this.version;
    }

    public final boolean component4() {
        return this.isRoot;
    }

    public final String component5() {
        return this.json;
    }

    public final ShareFolderUserPermission copy(int r100, PermissionAction r101, FolderVersion r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r110, "version");
        Intrinsics.checkNotNullParameter(r112, "json");
        return new ShareFolderUserPermission(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareFolderUserPermission) == true) goto L8;
        return false;
    L8:
        ShareFolderUserPermission r101 = (ShareFolderUserPermission) r100;
        if (this.permissions == r101.permissions) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L18;
        return false;
    L18:
        if (this.isRoot == r101.isRoot) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.json, r101.json) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.permissions * 31) + this.actions.hashCode()) * 31) + this.version.hashCode()) * 31;
        if (this.isRoot == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.json.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "ShareFolderUserPermission(permissions=" + this.permissions + ", actions=" + this.actions + ", version=" + this.version + ", isRoot=" + this.isRoot + ", json=" + this.json + ')';
    }

    public final boolean canBeMoved() {
        if (this.version.isFolderV1() == false) goto L9;
        if (this.permissions != 2) goto L7;
        return true;
    L7:
        return false;
    L9:
        return this.actions.canMoveThisNode();
    }

    public final boolean canCreateSubNode() {
        if (this.version.isFolderV1() == false) goto L9;
        if (this.permissions != 2) goto L7;
        return true;
    L7:
        return false;
    L9:
        return this.actions.canCreate();
    }

    public final boolean canEdit() {
        if (this.version.isFolderV1() == false) goto L9;
        if (this.permissions != 2) goto L7;
        return true;
    L7:
        return false;
    L9:
        return this.actions.canEdit();
    }

    public final boolean canInviteEdit() {
        if (this.version.isFolderV1() == false) goto L9;
        if (this.permissions != 2) goto L7;
        return true;
    L7:
        return false;
    L9:
        return this.actions.canInviteEdit();
    }

    public final boolean canInviteFullAccess() {
        if (this.version.isFolderV1() == false) goto L6;
        return false;
    L6:
        return this.actions.canInviteFullAccess();
    }

    public final boolean canInviteView() {
        if (this.version.isFolderV1() == false) goto L11;
        int r100 = this.permissions;
        if (r100 != 1) goto L7;
        return true;
    L7:
        if (r100 == 2) goto L14;
        return false;
    L14:
        return true;
    L11:
        return this.actions.canInviteView();
    }

    public final boolean canManagerCollaborator() {
        if (this.version.isFolderV1() == false) goto L6;
        return this.isRoot;
    L6:
        return this.actions.canManageCollaborator();
    }

    public final boolean canMoveSubNode() {
        if (this.version.isFolderV1() == false) goto L9;
        if (this.permissions != 2) goto L7;
        return true;
    L7:
        return false;
    L9:
        return this.actions.canMoveSubNode();
    }

    public final boolean canMoveToHere() {
        if (this.version.isFolderV1() == false) goto L9;
        if (this.permissions != 2) goto L7;
        return true;
    L7:
        return false;
    L9:
        return this.actions.canMoveToHere();
    }

    public final boolean canView() {
        if (this.version.isFolderV1() == false) goto L11;
        int r100 = this.permissions;
        if (r100 != 1) goto L7;
        return true;
    L7:
        if (r100 == 2) goto L14;
        return false;
    L14:
        return true;
    L11:
        return this.actions.canView();
    }

    public final PermissionAction getActions() {
        return this.actions;
    }

    public final String getJson() {
        return this.json;
    }

    public final int getPermissions() {
        return this.permissions;
    }

    public final String getReportJson() {
        return this.json;
    }

    public final FolderVersion getVersion() {
        return this.version;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    public final boolean canManagePermissionMeta(boolean r100) {
        if (this.version.isFolderV1() == false) goto L6;
        return r100;
    L6:
        return this.actions.canManagePermissionMeta();
    }

    public final void setActions(PermissionAction r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actions = r100;
    }

    public final void setPermissions(int r100) {
        this.permissions = r100;
    }

    public final void setRoot(boolean r100) {
        this.isRoot = r100;
    }

    public final void setVersion(FolderVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.version = r100;
    }

    public ShareFolderUserPermission(int r100, PermissionAction r101, FolderVersion r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r104, "json");
        this.permissions = r100;
        this.actions = r101;
        this.version = r102;
        this.isRoot = r103;
        this.json = r104;
    }

    public /* synthetic */ ShareFolderUserPermission(int r210, PermissionAction r211, FolderVersion r212, boolean r213, String r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 1) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r215 & 2) == 0) goto L9;
        PermissionAction r101 = new PermissionAction(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
    L11:
        if ((r215 & 4) == 0) goto L13;
        FolderVersion r102 = new FolderVersion(0, 0, false, 7, null);
    L15:
        if ((r215 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r215 & 16) == 0) goto L21;
        String r104 = "";
    L22:
        this(r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r214;
        goto L22
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
