package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u008b\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fHÆ\u0001J\u0013\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010&\"\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010&\"\u0004\b0\u0010(¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/TransferApplyInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "type", "", "token", "", "ownerId", "title", "iconUrl", "icon", "ownerName", "isWiki", "", "showDocTile", "removeOldOwner", "oldOwnerPermission", "recursiveTransfer", "isShareFolder", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZIZZ)V", "getType", "()I", "setType", "(I)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getOwnerId", "setOwnerId", "getTitle", com.alipay.sdk.m.x.d.f25925o, "getIconUrl", "setIconUrl", "getIcon", "setIcon", "getOwnerName", "setOwnerName", "()Z", "setWiki", "(Z)V", "getShowDocTile", "getRemoveOldOwner", "setRemoveOldOwner", "getOldOwnerPermission", "setOldOwnerPermission", "getRecursiveTransfer", "setRecursiveTransfer", "setShareFolder", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferApplyInfo implements NonProguard {
    private int icon;
    private String iconUrl;
    private boolean isShareFolder;
    private boolean isWiki;
    private int oldOwnerPermission;
    private String ownerId;
    private String ownerName;
    private boolean recursiveTransfer;
    private boolean removeOldOwner;
    private final boolean showDocTile;
    private String title;
    private String token;
    private int type;

    public TransferApplyInfo() {
        this(0, null, null, null, null, 0, null, false, false, false, 0, false, false, 8191, null);
    }

    public static /* synthetic */ TransferApplyInfo copy$default(TransferApplyInfo r110, int r111, String r112, String r113, String r114, String r115, int r210, String r211, boolean r212, boolean r213, boolean r214, int r215, boolean r216, boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        int r100 = r110.type;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.token;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.ownerId;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.title;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.iconUrl;
    L23:
        if ((r218 & 32) == 0) goto L25;
        int r105 = r110.icon;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.ownerName;
    L31:
        if ((r218 & 128) == 0) goto L33;
        boolean r107 = r110.isWiki;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r116 = r110.showDocTile;
    L39:
        if ((r218 & 512) == 0) goto L41;
        boolean r117 = r110.removeOldOwner;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        int r118 = r110.oldOwnerPermission;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        boolean r119 = r110.recursiveTransfer;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        boolean r108 = r110.isShareFolder;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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
        return this.type;
    }

    public final boolean component10() {
        return this.removeOldOwner;
    }

    public final int component11() {
        return this.oldOwnerPermission;
    }

    public final boolean component12() {
        return this.recursiveTransfer;
    }

    public final boolean component13() {
        return this.isShareFolder;
    }

    public final String component2() {
        return this.token;
    }

    public final String component3() {
        return this.ownerId;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final int component6() {
        return this.icon;
    }

    public final String component7() {
        return this.ownerName;
    }

    public final boolean component8() {
        return this.isWiki;
    }

    public final boolean component9() {
        return this.showDocTile;
    }

    public final TransferApplyInfo copy(int r110, String r111, String r112, String r113, String r210, int r211, String r212, boolean r213, boolean r214, boolean r215, int r216, boolean r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r112, "ownerId");
        Intrinsics.checkNotNullParameter(r113, "title");
        Intrinsics.checkNotNullParameter(r210, "iconUrl");
        Intrinsics.checkNotNullParameter(r212, "ownerName");
        return new TransferApplyInfo(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TransferApplyInfo) == true) goto L8;
        return false;
    L8:
        TransferApplyInfo r101 = (TransferApplyInfo) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L24;
        return false;
    L24:
        if (this.icon == r101.icon) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L30;
        return false;
    L30:
        if (this.isWiki == r101.isWiki) goto L33;
        return false;
    L33:
        if (this.showDocTile == r101.showDocTile) goto L36;
        return false;
    L36:
        if (this.removeOldOwner == r101.removeOldOwner) goto L39;
        return false;
    L39:
        if (this.oldOwnerPermission == r101.oldOwnerPermission) goto L42;
        return false;
    L42:
        if (this.recursiveTransfer == r101.recursiveTransfer) goto L45;
        return false;
    L45:
        if (this.isShareFolder == r101.isShareFolder) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((this.type * 31) + this.token.hashCode()) * 31) + this.ownerId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.icon) * 31) + this.ownerName.hashCode()) * 31;
        int r101 = 1231;
        if (this.isWiki == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.showDocTile == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.removeOldOwner == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.oldOwnerPermission) * 31;
        if (this.recursiveTransfer == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.isShareFolder == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "TransferApplyInfo(type=" + this.type + ", token=" + this.token + ", ownerId=" + this.ownerId + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ", icon=" + this.icon + ", ownerName=" + this.ownerName + ", isWiki=" + this.isWiki + ", showDocTile=" + this.showDocTile + ", removeOldOwner=" + this.removeOldOwner + ", oldOwnerPermission=" + this.oldOwnerPermission + ", recursiveTransfer=" + this.recursiveTransfer + ", isShareFolder=" + this.isShareFolder + ')';
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getOldOwnerPermission() {
        return this.oldOwnerPermission;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final boolean getRecursiveTransfer() {
        return this.recursiveTransfer;
    }

    public final boolean getRemoveOldOwner() {
        return this.removeOldOwner;
    }

    public final boolean getShowDocTile() {
        return this.showDocTile;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isShareFolder() {
        return this.isShareFolder;
    }

    public final boolean isWiki() {
        return this.isWiki;
    }

    public final void setIcon(int r100) {
        this.icon = r100;
    }

    public final void setIconUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconUrl = r100;
    }

    public final void setOldOwnerPermission(int r100) {
        this.oldOwnerPermission = r100;
    }

    public final void setOwnerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerId = r100;
    }

    public final void setOwnerName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerName = r100;
    }

    public final void setRecursiveTransfer(boolean r100) {
        this.recursiveTransfer = r100;
    }

    public final void setRemoveOldOwner(boolean r100) {
        this.removeOldOwner = r100;
    }

    public final void setShareFolder(boolean r100) {
        this.isShareFolder = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.token = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setWiki(boolean r100) {
        this.isWiki = r100;
    }

    public TransferApplyInfo(int r100, String r101, String r102, String r103, String r104, int r105, String r106, boolean r107, boolean r110, boolean r111, int r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "ownerId");
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r104, "iconUrl");
        Intrinsics.checkNotNullParameter(r106, "ownerName");
        this.type = r100;
        this.token = r101;
        this.ownerId = r102;
        this.title = r103;
        this.iconUrl = r104;
        this.icon = r105;
        this.ownerName = r106;
        this.isWiki = r107;
        this.showDocTile = r110;
        this.removeOldOwner = r111;
        this.oldOwnerPermission = r112;
        this.recursiveTransfer = r113;
        this.isShareFolder = r114;
    }

    public TransferApplyInfo(int r110, String r111, String r112, String r113, String r114, int r210, String r211, boolean r212, boolean r213, boolean r214, int r215, boolean r216, boolean r217, int r218, DefaultConstructorMarker r219) {
        if ((r218 & 1) == 0) goto L5;
        int r100 = sbb.e.f541296g.f541317b;
    L6:
        String r101 = "";
        if ((r218 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r218 & 32) == 0) goto L25;
        int r106 = -1;
    L27:
        if ((r218 & 64) != 0) goto L30;
        r101 = r211;
    L30:
        boolean r107 = false;
        if ((r218 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r115 = true;
    L39:
        if ((r218 & 512) == 0) goto L41;
        boolean r116 = false;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        int r117 = 3;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        boolean r118 = false;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r107 = r217;
    L54:
        this(r100, r102, r103, r104, r105, r106, r101, r108, r115, r116, r117, r118, r107);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
