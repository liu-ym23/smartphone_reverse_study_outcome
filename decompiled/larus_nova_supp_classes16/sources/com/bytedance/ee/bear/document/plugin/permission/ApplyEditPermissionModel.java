package com.bytedance.ee.bear.document.plugin.permission;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/permission/ApplyEditPermissionModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "token", "", "type", "", "ownerId", "ownerName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getOwnerId", "setOwnerId", "getOwnerName", "setOwnerName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyEditPermissionModel implements NonProguard {
    private String ownerId;
    private String ownerName;
    private String token;
    private int type;

    public ApplyEditPermissionModel() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ ApplyEditPermissionModel copy$default(ApplyEditPermissionModel r0, String r1, int r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.ownerId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.ownerName;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final ApplyEditPermissionModel copy(String r2, int r3, String r4, String r5) {
        return new ApplyEditPermissionModel(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ApplyEditPermissionModel) == true) goto L8;
        return false;
    L8:
        ApplyEditPermissionModel r6 = (ApplyEditPermissionModel) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerId, r6.ownerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ownerName, r6.ownerName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.token;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.type) * 31;
        String r4 = this.ownerId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.ownerName;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public final void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public final void setOwnerName(String r1) {
        this.ownerName = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public ApplyEditPermissionModel(String r1, int r2, String r3, String r4) {
        this.token = r1;
        this.type = r2;
        this.ownerId = r3;
        this.ownerName = r4;
    }

    public /* synthetic */ ApplyEditPermissionModel(String r2, int r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
