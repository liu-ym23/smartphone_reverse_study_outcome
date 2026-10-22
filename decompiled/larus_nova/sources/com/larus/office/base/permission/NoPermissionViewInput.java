package com.larus.office.base.permission;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JW\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/larus/office/base/permission/NoPermissionViewInput;", "Ljava/io/Serializable;", "permissionStatus", "", "isApplying", "", "userName", "ownerName", "currentPage", "previousPage", "shouldJumpToNext", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getPermissionStatus", "()Ljava/lang/String;", "()Z", "getUserName", "getOwnerName", "getCurrentPage", "getPreviousPage", "getShouldJumpToNext", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermissionViewInput implements Serializable {
    private final String currentPage;
    private final boolean isApplying;
    private final String ownerName;
    private final String permissionStatus;
    private final String previousPage;
    private final boolean shouldJumpToNext;
    private final String userName;

    public static /* synthetic */ NoPermissionViewInput copy$default(NoPermissionViewInput r100, String r101, boolean r102, String r103, String r104, String r110, String r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.permissionStatus;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.isApplying;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.userName;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.ownerName;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.currentPage;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.previousPage;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.shouldJumpToNext;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.permissionStatus;
    }

    public final boolean component2() {
        return this.isApplying;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.ownerName;
    }

    public final String component5() {
        return this.currentPage;
    }

    public final String component6() {
        return this.previousPage;
    }

    public final boolean component7() {
        return this.shouldJumpToNext;
    }

    public final NoPermissionViewInput copy(String r110, boolean r111, String r112, String r113, String r114, String r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "permissionStatus");
        return new NoPermissionViewInput(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NoPermissionViewInput) == true) goto L8;
        return false;
    L8:
        NoPermissionViewInput r101 = (NoPermissionViewInput) r100;
        if (Intrinsics.areEqual(this.permissionStatus, r101.permissionStatus) == true) goto L12;
        return false;
    L12:
        if (this.isApplying == r101.isApplying) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L27;
        return false;
    L27:
        if (this.shouldJumpToNext == r101.shouldJumpToNext) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.permissionStatus.hashCode() * 31;
        int r101 = 1231;
        if (this.isApplying == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.userName;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.ownerName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.currentPage;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.previousPage;
        if (r114 == null) goto L22;
        r105 = r114.hashCode();
    L22:
        int r115 = (r113 + r105) * 31;
        if (this.shouldJumpToNext == true) goto L27;
        r101 = 1237;
    L27:
        return r115 + r101;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "NoPermissionViewInput(permissionStatus=" + this.permissionStatus + ", isApplying=" + this.isApplying + ", userName=" + this.userName + ", ownerName=" + this.ownerName + ", currentPage=" + this.currentPage + ", previousPage=" + this.previousPage + ", shouldJumpToNext=" + this.shouldJumpToNext + ')';
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getPermissionStatus() {
        return this.permissionStatus;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final boolean getShouldJumpToNext() {
        return this.shouldJumpToNext;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean isApplying() {
        return this.isApplying;
    }

    public NoPermissionViewInput(String r100, boolean r101, String r102, String r103, String r104, String r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "permissionStatus");
        this.permissionStatus = r100;
        this.isApplying = r101;
        this.userName = r102;
        this.ownerName = r103;
        this.currentPage = r104;
        this.previousPage = r105;
        this.shouldJumpToNext = r106;
    }

    public /* synthetic */ NoPermissionViewInput(String r100, boolean r101, String r110, String r111, String r112, String r113, boolean r114, int r115, DefaultConstructorMarker r116) {
        boolean r102 = false;
        if ((r115 & 2) == 0) goto L5;
        boolean r103 = false;
    L6:
        String r104 = null;
        if ((r115 & 4) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r115 & 8) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r115 & 16) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r115 & 32) != 0) goto L23;
        r104 = r113;
    L23:
        if ((r115 & 64) != 0) goto L26;
        r102 = r114;
    L26:
        this(r100, r103, r105, r106, r107, r104, r102);
        return;
    L17:
        r107 = r112;
        goto L19
    L13:
        r106 = r111;
        goto L15
    L9:
        r105 = r110;
        goto L11
    L5:
        r103 = r101;
        goto L6
    }
}
