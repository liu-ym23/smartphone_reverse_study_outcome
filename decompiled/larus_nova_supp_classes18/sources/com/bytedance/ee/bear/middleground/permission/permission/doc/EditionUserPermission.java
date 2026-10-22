package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B;\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\t\u0010\u0018\u001a\u00020\rHÂ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionUserPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;", "isOwner", "", "permissionStatusCode", "", "actions", "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionPermissionAction;", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "json", "", "<init>", "(ZILcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionPermissionAction;Lcom/bytedance/ee/bear/share/export/OwnerInfo;Ljava/lang/String;)V", "canRenameAndCreateEdition", "canOperateEntity", "getOwnerInfo", "getPermissionStatusCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ EditionUserPermission copy$default(EditionUserPermission r3, boolean r4, int r5, EditionPermissionAction r6, OwnerInfo r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.isOwner;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.permissionStatusCode;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.actions;
    L11:
        EditionPermissionAction r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.ownerInfo;
    L14:
        OwnerInfo r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.json;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final EditionUserPermission copy(boolean r8, int r9, EditionPermissionAction r10, OwnerInfo r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "actions");
        Intrinsics.checkNotNullParameter(r12, "json");
        return new EditionUserPermission(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EditionUserPermission) == true) goto L8;
        return false;
    L8:
        EditionUserPermission r6 = (EditionUserPermission) r5;
        if (this.isOwner == r6.isOwner) goto L12;
        return false;
    L12:
        if (this.permissionStatusCode == r6.permissionStatusCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ownerInfo, r6.ownerInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.json, r6.json) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isOwner == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.permissionStatusCode) * 31) + this.actions.hashCode()) * 31;
        OwnerInfo r2 = this.ownerInfo;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return ((r1 + r3) * 31) + this.json.hashCode();
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
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

    public EditionUserPermission(boolean r2, int r3, EditionPermissionAction r4, OwnerInfo r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "actions");
        Intrinsics.checkNotNullParameter(r6, "json");
        this.isOwner = r2;
        this.permissionStatusCode = r3;
        this.actions = r4;
        this.ownerInfo = r5;
        this.json = r6;
    }

    public /* synthetic */ EditionUserPermission(boolean r4, int r5, EditionPermissionAction r6, OwnerInfo r7, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r9 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r9 & 4) == 0) goto L13;
        r6 = new EditionPermissionAction(0, 0, 3, null);
    L13:
        EditionPermissionAction r0 = r6;
        if ((r9 & 8) == 0) goto L16;
        OwnerInfo r2 = null;
    L18:
        if ((r9 & 16) == 0) goto L20;
        r8 = "";
    L20:
        this(r11, r1, r0, r2, r8);
        return;
    L16:
        r2 = r7;
        goto L18
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
