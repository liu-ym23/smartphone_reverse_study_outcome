package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u00016B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u00105\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010!R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "Ljava/io/Serializable;", ResourceData.KEY_TOKEN, "", "documentType", "isFolder", "", "tipText", "ownerName", "title", "canApply", "containerId", "", "backVisible", "subType", "fromVc", "isWiki", "module", "userPerm", "publicPerm", "isShareFolderV2", "ownerId", "viewPerceive", "permCode", "fromDocXInBase", "originalBearUrlToken", "applyPageType", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIZLjava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;)V", "getToken", "()Ljava/lang/String;", "getDocumentType", "()Z", "getTipText", "getOwnerName", "getTitle", "getCanApply", "getContainerId", "()I", "getBackVisible", "getSubType", "getFromVc", "getModule", "getUserPerm", "getPublicPerm", "getOwnerId", "getViewPerceive", "getPermCode", "getFromDocXInBase", "getOriginalBearUrlToken", "getApplyPageType", "()Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;", "toString", "Builder", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public NoPermission(String r14, String r15, boolean r16, String r17, String r18, String r19, boolean r20, int r21, boolean r22, String r23, boolean r24, boolean r25, String r26, String r27, String r28, boolean r29, String r30, boolean r31, int r32, boolean r33, String r34, ApplyPermissionPageType r35) {
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r15, "documentType");
        Intrinsics.checkNotNullParameter(r17, "tipText");
        Intrinsics.checkNotNullParameter(r18, "ownerName");
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter(r23, "subType");
        Intrinsics.checkNotNullParameter(r26, "module");
        Intrinsics.checkNotNullParameter(r27, "userPerm");
        Intrinsics.checkNotNullParameter(r28, "publicPerm");
        Intrinsics.checkNotNullParameter(r30, "ownerId");
        Intrinsics.checkNotNullParameter(r35, "applyPageType");
        this.token = r14;
        this.documentType = r15;
        this.isFolder = r16;
        this.tipText = r17;
        this.ownerName = r18;
        this.title = r19;
        this.canApply = r20;
        this.containerId = r21;
        this.backVisible = r22;
        this.subType = r23;
        this.fromVc = r24;
        this.isWiki = r25;
        this.module = r26;
        this.userPerm = r27;
        this.publicPerm = r28;
        this.isShareFolderV2 = r29;
        this.ownerId = r30;
        this.viewPerceive = r31;
        this.permCode = r32;
        this.fromDocXInBase = r33;
        this.originalBearUrlToken = r34;
        this.applyPageType = r35;
    }

    public /* synthetic */ NoPermission(String r25, String r26, boolean r27, String r28, String r29, String r30, boolean r31, int r32, boolean r33, String r34, boolean r35, boolean r36, String r37, String r38, String r39, boolean r40, String r41, boolean r42, int r43, boolean r44, String r45, ApplyPermissionPageType r46, int r47, DefaultConstructorMarker r48) {
        if ((r47 & 1048576) == 0) goto L5;
        String r22 = "";
    L7:
        if ((r47 & 2097152) == 0) goto L9;
        ApplyPermissionPageType r23 = ApplyPermissionPageType.NORMAL;
    L10:
        this(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r22, r23);
        return;
    L9:
        r23 = r46;
        goto L10
    L5:
        r22 = r45;
        goto L7
    }
}
