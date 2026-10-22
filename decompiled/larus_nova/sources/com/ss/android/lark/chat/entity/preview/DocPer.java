package com.ss.android.lark.chat.entity.preview;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/DocPer;", "Ljava/io/Serializable;", "docTitle", "", "docType", "Lcom/ss/android/lark/chat/entity/preview/DocType;", "ownerName", "docUrl", ComplianceResult.JsonKey.PERMISSIONS, "", "Lcom/ss/android/lark/chat/entity/preview/DocPermission;", "messageIds", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/preview/DocType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDocTitle", "()Ljava/lang/String;", "getDocType", "()Lcom/ss/android/lark/chat/entity/preview/DocType;", "getOwnerName", "getDocUrl", "getPermissions", "()Ljava/util/List;", "getMessageIds", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPer implements Serializable {
    private final String docTitle;
    private final DocType docType;
    private final String docUrl;
    private final List<String> messageIds;
    private final String ownerName;
    private final List<DocPermission> permissions;

    public DocPer() {
        this(null, null, null, null, null, null, 63, null);
    }

    public int hashCode() {
        String r100 = this.docTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + this.docType.hashCode()) * 31) + this.ownerName.hashCode()) * 31) + this.docUrl.hashCode()) * 31;
        List<DocPermission> r104 = this.permissions;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.messageIds;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String getDocTitle() {
        return this.docTitle;
    }

    public final DocType getDocType() {
        return this.docType;
    }

    public final String getDocUrl() {
        return this.docUrl;
    }

    public final List<String> getMessageIds() {
        return this.messageIds;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final List<DocPermission> getPermissions() {
        return this.permissions;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocPer) == true) goto L8;
        return false;
    L8:
        DocPer r101 = (DocPer) r100;
        if (Intrinsics.areEqual(this.docTitle, r101.docTitle) == true) goto L12;
        return false;
    L12:
        if (this.docType == r101.docType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.docUrl, r101.docUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.permissions, r101.permissions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageIds, r101.messageIds) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public DocPer(String r100, DocType r101, String r102, String r103, List<DocPermission> r104, List<String> r105) {
        Intrinsics.checkNotNullParameter(r101, "docType");
        Intrinsics.checkNotNullParameter(r102, "ownerName");
        Intrinsics.checkNotNullParameter(r103, "docUrl");
        this.docTitle = r100;
        this.docType = r101;
        this.ownerName = r102;
        this.docUrl = r103;
        this.permissions = r104;
        this.messageIds = r105;
    }

    public /* synthetic */ DocPer(String r100, DocType r101, String r102, String r103, List r104, List r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = DocType.UNKNOWN;
    L9:
        DocType r106 = r101;
        if ((r111 & 4) == 0) goto L12;
        String r107 = "";
    L14:
        if ((r111 & 8) != 0) goto L18;
        r105 = r103;
    L18:
        if ((r111 & 16) == 0) goto L20;
        List r108 = null;
    L22:
        if ((r111 & 32) == 0) goto L24;
        List r114 = null;
    L25:
        this(r113, r106, r107, r105, r108, r114);
        return;
    L24:
        r114 = r110;
        goto L25
    L20:
        r108 = r104;
        goto L22
    L12:
        r107 = r102;
        goto L14
    L5:
        r113 = r100;
        goto L7
    }
}
