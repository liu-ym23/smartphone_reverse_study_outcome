package com.bytedance.ee.bear.document.plugin.permission;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/permission/ApplyEditPermissionModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "type", "", "ownerId", "ownerName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getOwnerId", "setOwnerId", "getOwnerName", "setOwnerName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyEditPermissionModel implements NonProguard {
    private String ownerId;
    private String ownerName;
    private String token;
    private int type;

    public ApplyEditPermissionModel() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ ApplyEditPermissionModel copy$default(ApplyEditPermissionModel r100, String r101, int r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.ownerId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ownerName;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.token;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.ownerId;
    }

    public final String component4() {
        return this.ownerName;
    }

    public final ApplyEditPermissionModel copy(String r100, int r101, String r102, String r103) {
        return new ApplyEditPermissionModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApplyEditPermissionModel) == true) goto L8;
        return false;
    L8:
        ApplyEditPermissionModel r101 = (ApplyEditPermissionModel) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        String r104 = this.ownerId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ownerName;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ApplyEditPermissionModel(token=" + this.token + ", type=" + this.type + ", ownerId=" + this.ownerId + ", ownerName=" + this.ownerName + ')';
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public final void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public final void setOwnerName(String r100) {
        this.ownerName = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public ApplyEditPermissionModel(String r100, int r101, String r102, String r103) {
        this.token = r100;
        this.type = r101;
        this.ownerId = r102;
        this.ownerName = r103;
    }

    public /* synthetic */ ApplyEditPermissionModel(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
