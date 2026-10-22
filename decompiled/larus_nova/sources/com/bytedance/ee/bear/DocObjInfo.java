package com.bytedance.ee.bear;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\rHÖ\u0001J\t\u0010.\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/DocObjInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "isPined", "", "isStared", "isSubscribed", "isSubscribeComment", "wikiInfo", "Lcom/bytedance/ee/bear/WikiNavInfo;", "logId", "", "crossTenantSubscribeType", "", "<init>", "(ZZZZLcom/bytedance/ee/bear/WikiNavInfo;Ljava/lang/String;I)V", "()Z", "setPined", "(Z)V", "setStared", "setSubscribed", "setSubscribeComment", "getWikiInfo", "()Lcom/bytedance/ee/bear/WikiNavInfo;", "setWikiInfo", "(Lcom/bytedance/ee/bear/WikiNavInfo;)V", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "getCrossTenantSubscribeType", "()I", "setCrossTenantSubscribeType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "contentmanager-space-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocObjInfo extends Result<Serializable> {
    private int crossTenantSubscribeType;
    private boolean isPined;
    private boolean isStared;
    private boolean isSubscribeComment;
    private boolean isSubscribed;
    private String logId;
    private WikiNavInfo wikiInfo;

    public DocObjInfo() {
        this(false, false, false, false, null, null, 0, 127, null);
    }

    public static /* synthetic */ DocObjInfo copy$default(DocObjInfo r100, boolean r101, boolean r102, boolean r103, boolean r104, WikiNavInfo r110, String r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.isPined;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.isStared;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.isSubscribed;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isSubscribeComment;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.wikiInfo;
    L17:
        WikiNavInfo r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.logId;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.crossTenantSubscribeType;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.isPined;
    }

    public final boolean component2() {
        return this.isStared;
    }

    public final boolean component3() {
        return this.isSubscribed;
    }

    public final boolean component4() {
        return this.isSubscribeComment;
    }

    public final WikiNavInfo component5() {
        return this.wikiInfo;
    }

    public final String component6() {
        return this.logId;
    }

    public final int component7() {
        return this.crossTenantSubscribeType;
    }

    public final DocObjInfo copy(boolean r110, boolean r111, boolean r112, boolean r113, WikiNavInfo r114, String r115, int r116) {
        Intrinsics.checkNotNullParameter(r114, "wikiInfo");
        Intrinsics.checkNotNullParameter(r115, "logId");
        return new DocObjInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocObjInfo) == true) goto L8;
        return false;
    L8:
        DocObjInfo r101 = (DocObjInfo) r100;
        if (this.isPined == r101.isPined) goto L12;
        return false;
    L12:
        if (this.isStared == r101.isStared) goto L15;
        return false;
    L15:
        if (this.isSubscribed == r101.isSubscribed) goto L18;
        return false;
    L18:
        if (this.isSubscribeComment == r101.isSubscribeComment) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.wikiInfo, r101.wikiInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L27;
        return false;
    L27:
        if (this.crossTenantSubscribeType == r101.crossTenantSubscribeType) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isPined == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isStared == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isSubscribed == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.isSubscribeComment == true) goto L19;
        r100 = 1237;
    L19:
        return ((((((r106 + r100) * 31) + this.wikiInfo.hashCode()) * 31) + this.logId.hashCode()) * 31) + this.crossTenantSubscribeType;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DocObjInfo(isPined=" + this.isPined + ", isStared=" + this.isStared + ", isSubscribed=" + this.isSubscribed + ", isSubscribeComment=" + this.isSubscribeComment + ", wikiInfo=" + this.wikiInfo + ", logId=" + this.logId + ", crossTenantSubscribeType=" + this.crossTenantSubscribeType + ')';
    }

    public final int getCrossTenantSubscribeType() {
        return this.crossTenantSubscribeType;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final WikiNavInfo getWikiInfo() {
        return this.wikiInfo;
    }

    public final boolean isPined() {
        return this.isPined;
    }

    public final boolean isStared() {
        return this.isStared;
    }

    public final boolean isSubscribeComment() {
        return this.isSubscribeComment;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setCrossTenantSubscribeType(int r100) {
        this.crossTenantSubscribeType = r100;
    }

    public final void setLogId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logId = r100;
    }

    public final void setPined(boolean r100) {
        this.isPined = r100;
    }

    public final void setStared(boolean r100) {
        this.isStared = r100;
    }

    public final void setSubscribeComment(boolean r100) {
        this.isSubscribeComment = r100;
    }

    public final void setSubscribed(boolean r100) {
        this.isSubscribed = r100;
    }

    public final void setWikiInfo(WikiNavInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.wikiInfo = r100;
    }

    public DocObjInfo(boolean r100, boolean r101, boolean r102, boolean r103, WikiNavInfo r104, String r105, int r106) {
        Intrinsics.checkNotNullParameter(r104, "wikiInfo");
        Intrinsics.checkNotNullParameter(r105, "logId");
        this.isPined = r100;
        this.isStared = r101;
        this.isSubscribed = r102;
        this.isSubscribeComment = r103;
        this.wikiInfo = r104;
        this.logId = r105;
        this.crossTenantSubscribeType = r106;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ DocObjInfo(boolean r100, boolean r101, boolean r102, boolean r110, WikiNavInfo r111, String r112, int r113, int r114, DefaultConstructorMarker r115) {
        boolean r103 = false;
        if ((r114 & 1) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r114 & 8) == 0) goto L17;
        boolean r106 = false;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r107 = null;
        r111 = new WikiNavInfo(r103, r107, 3, 0 == true ? 1 : 0);
    L21:
        WikiNavInfo r108 = r111;
        if ((r114 & 32) == 0) goto L24;
        r112 = "";
    L24:
        String r109 = r112;
        if ((r114 & 64) == 0) goto L27;
        int r117 = 0;
    L28:
        this(r116, r104, r105, r106, r108, r109, r117);
        return;
    L27:
        r117 = r113;
        goto L28
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
