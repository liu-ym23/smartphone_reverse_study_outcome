package com.larus.office.permission;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import fo9.f;
import fo9.h;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\u0011H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/larus/office/permission/DocPermissionFullData;", "", "<init>", "()V", ComplianceResult.JsonKey.PERMISSIONS, "Lcom/larus/office/permission/DocPermissionData;", "getPermissions", "()Lcom/larus/office/permission/DocPermissionData;", "setPermissions", "(Lcom/larus/office/permission/DocPermissionData;)V", "visibilityStatus", "", "getVisibilityStatus", "()I", "setVisibilityStatus", "(I)V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "owner", "Lcom/larus/office/permission/OwnerInfo;", "getOwner", "()Lcom/larus/office/permission/OwnerInfo;", "setOwner", "(Lcom/larus/office/permission/OwnerInfo;)V", "publicPermissions", "Lcom/larus/office/permission/PublicPermissions;", "getPublicPermissions", "()Lcom/larus/office/permission/PublicPermissions;", "setPublicPermissions", "(Lcom/larus/office/permission/PublicPermissions;)V", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermissionFullData {
    private f owner;

    @SerializedName(ComplianceResult.JsonKey.PERMISSIONS)
    private DocPermissionData permissions;
    private h publicPermissions;

    @SerializedName("token")
    private String token;

    @SerializedName("visibilityStatus")
    private int visibilityStatus;

    public String toString() {
        return "DocPermissionFullData(permissions=" + this.permissions + ", visibilityStatus=" + this.visibilityStatus + ", token='" + this.token + "')";
    }

    public DocPermissionFullData() {
        this.permissions = new DocPermissionData();
        this.visibilityStatus = VisibilityStatus.BAN.getValue();
        this.token = "";
    }

    public final f getOwner() {
        return this.owner;
    }

    public final DocPermissionData getPermissions() {
        return this.permissions;
    }

    public final h getPublicPermissions() {
        return this.publicPermissions;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getVisibilityStatus() {
        return this.visibilityStatus;
    }

    public final void setOwner(f r100) {
        this.owner = r100;
    }

    public final void setPermissions(DocPermissionData r100) {
        this.permissions = r100;
    }

    public final void setPublicPermissions(h r100) {
        this.publicPermissions = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setVisibilityStatus(int r100) {
        this.visibilityStatus = r100;
    }
}
