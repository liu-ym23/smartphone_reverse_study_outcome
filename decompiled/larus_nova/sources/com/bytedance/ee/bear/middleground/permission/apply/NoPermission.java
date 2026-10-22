package com.bytedance.ee.bear.middleground.permission.apply;

import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u00016B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u00105\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010!R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "Ljava/io/Serializable;", "token", "", "documentType", "isFolder", "", "tipText", "ownerName", "title", "canApply", "containerId", "", "backVisible", "subType", "fromVc", "isWiki", EventConstant.Key.MODULE, "userPerm", "publicPerm", "isShareFolderV2", "ownerId", "viewPerceive", "permCode", "fromDocXInBase", "originalBearUrlToken", "applyPageType", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIZLjava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;)V", "getToken", "()Ljava/lang/String;", "getDocumentType", "()Z", "getTipText", "getOwnerName", "getTitle", "getCanApply", "getContainerId", "()I", "getBackVisible", "getSubType", "getFromVc", "getModule", "getUserPerm", "getPublicPerm", "getOwnerId", "getViewPerceive", "getPermCode", "getFromDocXInBase", "getOriginalBearUrlToken", "getApplyPageType", "()Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;", "toString", "Builder", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermission implements Serializable {
    private final ApplyPermissionPageType applyPageType;
    private final boolean backVisible;
    private final boolean canApply;
    private final int containerId;
    private final String documentType;
    private final boolean fromDocXInBase;
    private final boolean fromVc;
    private final boolean isFolder;
    private final boolean isShareFolderV2;
    private final boolean isWiki;
    private final String module;
    private final String originalBearUrlToken;
    private final String ownerId;
    private final String ownerName;
    private final int permCode;
    private final String publicPerm;
    private final String subType;
    private final String tipText;
    private final String title;
    private final String token;
    private final String userPerm;
    private final boolean viewPerceive;

    public String toString() {
        return "NoPermission(token='" + this.token + "', documentType='" + this.documentType + "', isFolder=" + this.isFolder + ", tipText='" + this.tipText + "', ownerName='" + this.ownerName + "', title='" + this.title + "', canApply=" + this.canApply + ", containerId=" + this.containerId + ", backVisible=" + this.backVisible + ')';
    }

    public final ApplyPermissionPageType getApplyPageType() {
        return this.applyPageType;
    }

    public final boolean getBackVisible() {
        return this.backVisible;
    }

    public final boolean getCanApply() {
        return this.canApply;
    }

    public final int getContainerId() {
        return this.containerId;
    }

    public final String getDocumentType() {
        return this.documentType;
    }

    public final boolean getFromDocXInBase() {
        return this.fromDocXInBase;
    }

    public final boolean getFromVc() {
        return this.fromVc;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getOriginalBearUrlToken() {
        return this.originalBearUrlToken;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final int getPermCode() {
        return this.permCode;
    }

    public final String getPublicPerm() {
        return this.publicPerm;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserPerm() {
        return this.userPerm;
    }

    public final boolean getViewPerceive() {
        return this.viewPerceive;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public final boolean isShareFolderV2() {
        return this.isShareFolderV2;
    }

    public final boolean isWiki() {
        return this.isWiki;
    }

    public NoPermission(String r110, String r111, boolean r112, String r113, String r114, String r115, boolean r210, int r211, boolean r212, String r213, boolean r214, boolean r215, String r216, String r217, String r218, boolean r219, String r310, boolean r311, int r312, boolean r313, String r314, ApplyPermissionPageType r315) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r111, "documentType");
        Intrinsics.checkNotNullParameter(r113, "tipText");
        Intrinsics.checkNotNullParameter(r114, "ownerName");
        Intrinsics.checkNotNullParameter(r115, "title");
        Intrinsics.checkNotNullParameter(r213, "subType");
        Intrinsics.checkNotNullParameter(r216, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r217, "userPerm");
        Intrinsics.checkNotNullParameter(r218, "publicPerm");
        Intrinsics.checkNotNullParameter(r310, "ownerId");
        Intrinsics.checkNotNullParameter(r315, "applyPageType");
        this.token = r110;
        this.documentType = r111;
        this.isFolder = r112;
        this.tipText = r113;
        this.ownerName = r114;
        this.title = r115;
        this.canApply = r210;
        this.containerId = r211;
        this.backVisible = r212;
        this.subType = r213;
        this.fromVc = r214;
        this.isWiki = r215;
        this.module = r216;
        this.userPerm = r217;
        this.publicPerm = r218;
        this.isShareFolderV2 = r219;
        this.ownerId = r310;
        this.viewPerceive = r311;
        this.permCode = r312;
        this.fromDocXInBase = r313;
        this.originalBearUrlToken = r314;
        this.applyPageType = r315;
    }

    public /* synthetic */ NoPermission(String r210, String r211, boolean r212, String r213, String r214, String r310, boolean r311, int r312, boolean r313, String r314, boolean r315, boolean r316, String r317, String r318, String r319, boolean r410, String r411, boolean r412, int r413, boolean r414, String r415, ApplyPermissionPageType r416, int r417, DefaultConstructorMarker r418) {
        if ((r417 & 1048576) == 0) goto L5;
        String r215 = "";
    L7:
        if ((r417 & 2097152) == 0) goto L9;
        ApplyPermissionPageType r216 = ApplyPermissionPageType.NORMAL;
    L10:
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r215, r216);
        return;
    L9:
        r216 = r416;
        goto L10
    L5:
        r215 = r415;
        goto L7
    }
}
