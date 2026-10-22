package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B;\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\t\u0010\u0018\u001a\u00020\rHÂ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionUserPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;", "isOwner", "", "permissionStatusCode", "", SlcCommonAction.KEY_ACTIONS, "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionPermissionAction;", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "json", "", "<init>", "(ZILcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionPermissionAction;Lcom/bytedance/ee/bear/share/export/OwnerInfo;Ljava/lang/String;)V", "canRenameAndCreateEdition", "canOperateEntity", "getOwnerInfo", "getPermissionStatusCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditionUserPermission extends Result<Serializable> implements IEditionUserPermission {
    private final EditionPermissionAction actions;
    private final boolean isOwner;
    private final String json;
    private OwnerInfo ownerInfo;
    private final int permissionStatusCode;

    public EditionUserPermission() {
        this(false, 0, null, null, null, 31, null);
    }

    private final boolean component1() {
        return this.isOwner;
    }

    private final int component2() {
        return this.permissionStatusCode;
    }

    private final EditionPermissionAction component3() {
        return this.actions;
    }

    private final OwnerInfo component4() {
        return this.ownerInfo;
    }

    private final String component5() {
        return this.json;
    }

    public static /* synthetic */ EditionUserPermission copy$default(EditionUserPermission r100, boolean r101, int r102, EditionPermissionAction r103, OwnerInfo r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.isOwner;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.permissionStatusCode;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.actions;
    L11:
        EditionPermissionAction r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.ownerInfo;
    L14:
        OwnerInfo r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.json;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final EditionUserPermission copy(boolean r100, int r101, EditionPermissionAction r110, OwnerInfo r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r112, "json");
        return new EditionUserPermission(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EditionUserPermission) == true) goto L8;
        return false;
    L8:
        EditionUserPermission r101 = (EditionUserPermission) r100;
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
        if (Intrinsics.areEqual(this.json, r101.json) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isOwner == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.permissionStatusCode) * 31) + this.actions.hashCode()) * 31;
        OwnerInfo r102 = this.ownerInfo;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((r101 + r103) * 31) + this.json.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "EditionUserPermission(isOwner=" + this.isOwner + ", permissionStatusCode=" + this.permissionStatusCode + ", actions=" + this.actions + ", ownerInfo=" + this.ownerInfo + ", json=" + this.json + ')';
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public boolean canOperateEntity() {
        return this.actions.canOperateEntity();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public boolean canRenameAndCreateEdition() {
        return this.actions.canRenameAndCreateEdition();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public OwnerInfo getOwnerInfo() {
        return this.ownerInfo;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public int getPermissionStatusCode() {
        return this.permissionStatusCode;
    }

    public EditionUserPermission(boolean r100, int r101, EditionPermissionAction r102, OwnerInfo r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r104, "json");
        this.isOwner = r100;
        this.permissionStatusCode = r101;
        this.actions = r102;
        this.ownerInfo = r103;
        this.json = r104;
    }

    public /* synthetic */ EditionUserPermission(boolean r100, int r101, EditionPermissionAction r102, OwnerInfo r103, String r104, int r105, DefaultConstructorMarker r110) {
        int r106 = 0;
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = false;
    L7:
        if ((r105 & 2) == 0) goto L9;
        int r107 = 0;
    L10:
        DefaultConstructorMarker r108 = null;
        if ((r105 & 4) == 0) goto L13;
        r102 = new EditionPermissionAction(r106, r106, 3, r108);
    L13:
        EditionPermissionAction r109 = r102;
        if ((r105 & 8) == 0) goto L16;
        OwnerInfo r112 = null;
    L18:
        if ((r105 & 16) == 0) goto L20;
        r104 = "";
    L20:
        this(r111, r107, r109, r112, r104);
        return;
    L16:
        r112 = r103;
        goto L18
    L9:
        r107 = r101;
        goto L10
    L5:
        r111 = r100;
        goto L7
    }
}
