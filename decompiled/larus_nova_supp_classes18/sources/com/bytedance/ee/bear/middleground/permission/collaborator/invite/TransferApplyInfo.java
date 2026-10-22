package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u008b\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fHÆ\u0001J\u0013\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010&\"\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010&\"\u0004\b0\u0010(¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/TransferApplyInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "", "ownerId", "title", "iconUrl", "icon", "ownerName", "isWiki", "", "showDocTile", "removeOldOwner", "oldOwnerPermission", "recursiveTransfer", "isShareFolder", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZIZZ)V", "getType", "()I", "setType", "(I)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getOwnerId", "setOwnerId", "getTitle", "setTitle", "getIconUrl", "setIconUrl", "getIcon", "setIcon", "getOwnerName", "setOwnerName", "()Z", "setWiki", "(Z)V", "getShowDocTile", "getRemoveOldOwner", "setRemoveOldOwner", "getOldOwnerPermission", "setOldOwnerPermission", "getRecursiveTransfer", "setRecursiveTransfer", "setShareFolder", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ TransferApplyInfo copy$default(TransferApplyInfo r14, int r15, String r16, String r17, String r18, String r19, int r20, String r21, boolean r22, boolean r23, boolean r24, int r25, boolean r26, boolean r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        int r2 = r14.type;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.token;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.ownerId;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.title;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r6 = r14.iconUrl;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r7 = r14.icon;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r8 = r14.ownerName;
    L31:
        if ((r28 & 128) == 0) goto L33;
        boolean r9 = r14.isWiki;
    L35:
        if ((r28 & 256) == 0) goto L37;
        boolean r10 = r14.showDocTile;
    L39:
        if ((r28 & 512) == 0) goto L41;
        boolean r11 = r14.removeOldOwner;
    L43:
        if ((r28 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        int r12 = r14.oldOwnerPermission;
    L47:
        if ((r28 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        boolean r13 = r14.recursiveTransfer;
    L51:
        if ((r28 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        boolean r1 = r14.isShareFolder;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
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

    public final TransferApplyInfo copy(int r16, String r17, String r18, String r19, String r20, int r21, String r22, boolean r23, boolean r24, boolean r25, int r26, boolean r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "ownerId");
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter(r20, "iconUrl");
        Intrinsics.checkNotNullParameter(r22, "ownerName");
        return new TransferApplyInfo(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TransferApplyInfo) == true) goto L8;
        return false;
    L8:
        TransferApplyInfo r6 = (TransferApplyInfo) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerId, r6.ownerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L24;
        return false;
    L24:
        if (this.icon == r6.icon) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ownerName, r6.ownerName) == true) goto L30;
        return false;
    L30:
        if (this.isWiki == r6.isWiki) goto L33;
        return false;
    L33:
        if (this.showDocTile == r6.showDocTile) goto L36;
        return false;
    L36:
        if (this.removeOldOwner == r6.removeOldOwner) goto L39;
        return false;
    L39:
        if (this.oldOwnerPermission == r6.oldOwnerPermission) goto L42;
        return false;
    L42:
        if (this.recursiveTransfer == r6.recursiveTransfer) goto L45;
        return false;
    L45:
        if (this.isShareFolder == r6.isShareFolder) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.type * 31) + this.token.hashCode()) * 31) + this.ownerId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.icon) * 31) + this.ownerName.hashCode()) * 31;
        int r2 = 1231;
        if (this.isWiki == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.showDocTile == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.removeOldOwner == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((r5 + r6) * 31) + this.oldOwnerPermission) * 31;
        if (this.recursiveTransfer == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.isShareFolder == true) goto L23;
        r2 = 1237;
    L23:
        return r9 + r2;
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
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

    public final void setIcon(int r1) {
        this.icon = r1;
    }

    public final void setIconUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconUrl = r2;
    }

    public final void setOldOwnerPermission(int r1) {
        this.oldOwnerPermission = r1;
    }

    public final void setOwnerId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerId = r2;
    }

    public final void setOwnerName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerName = r2;
    }

    public final void setRecursiveTransfer(boolean r1) {
        this.recursiveTransfer = r1;
    }

    public final void setRemoveOldOwner(boolean r1) {
        this.removeOldOwner = r1;
    }

    public final void setShareFolder(boolean r1) {
        this.isShareFolder = r1;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public final void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final void setWiki(boolean r1) {
        this.isWiki = r1;
    }

    public TransferApplyInfo(int r2, String r3, String r4, String r5, String r6, int r7, String r8, boolean r9, boolean r10, boolean r11, int r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "ownerId");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "iconUrl");
        Intrinsics.checkNotNullParameter(r8, "ownerName");
        this.type = r2;
        this.token = r3;
        this.ownerId = r4;
        this.title = r5;
        this.iconUrl = r6;
        this.icon = r7;
        this.ownerName = r8;
        this.isWiki = r9;
        this.showDocTile = r10;
        this.removeOldOwner = r11;
        this.oldOwnerPermission = r12;
        this.recursiveTransfer = r13;
        this.isShareFolder = r14;
    }

    public TransferApplyInfo(int r15, String r16, String r17, String r18, String r19, int r20, String r21, boolean r22, boolean r23, boolean r24, int r25, boolean r26, boolean r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 1) == 0) goto L5;
        int r1 = sbb.e.g.b;
    L6:
        String r3 = "";
        if ((r28 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r7 = -1;
    L27:
        if ((r28 & 64) != 0) goto L30;
        r3 = r21;
    L30:
        boolean r9 = false;
        if ((r28 & 128) == 0) goto L33;
        boolean r8 = false;
    L35:
        if ((r28 & 256) == 0) goto L37;
        boolean r10 = true;
    L39:
        if ((r28 & 512) == 0) goto L41;
        boolean r11 = false;
    L43:
        if ((r28 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        int r12 = 3;
    L47:
        if ((r28 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        boolean r13 = false;
    L51:
        if ((r28 & DocUserPermission.USER_PERCEIVE) != 0) goto L54;
        r9 = r27;
    L54:
        this(r1, r2, r4, r5, r6, r7, r3, r8, r10, r11, r12, r13, r9);
        return;
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r8 = r22;
        goto L35
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L6
    }
}
