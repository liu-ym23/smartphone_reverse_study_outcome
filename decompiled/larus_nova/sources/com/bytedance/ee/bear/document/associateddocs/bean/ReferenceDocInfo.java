package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/ReferenceDocInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "createTime", "", "creatorId", "objToken", "", "objType", "permitted", "", "title", "url", "<init>", "(IILjava/lang/String;IZLjava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()I", "getCreatorId", "getObjToken", "()Ljava/lang/String;", "getObjType", "getPermitted", "()Z", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceDocInfo implements NonProguard {
    private final int createTime;
    private final int creatorId;
    private final String objToken;
    private final int objType;
    private final boolean permitted;
    private final String title;
    private final String url;

    public static /* synthetic */ ReferenceDocInfo copy$default(ReferenceDocInfo r100, int r101, int r102, String r103, int r104, boolean r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.createTime;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.creatorId;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.objToken;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.objType;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.permitted;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.title;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.url;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.createTime;
    }

    public final int component2() {
        return this.creatorId;
    }

    public final String component3() {
        return this.objToken;
    }

    public final int component4() {
        return this.objType;
    }

    public final boolean component5() {
        return this.permitted;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.url;
    }

    public final ReferenceDocInfo copy(@JSONField(name = "create_time") int r110, @JSONField(name = "creator_id") int r111, @JSONField(name = "obj_token") String r112, @JSONField(name = "obj_type") int r113, boolean r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r112, "objToken");
        Intrinsics.checkNotNullParameter(r115, "title");
        Intrinsics.checkNotNullParameter(r116, "url");
        return new ReferenceDocInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReferenceDocInfo) == true) goto L8;
        return false;
    L8:
        ReferenceDocInfo r101 = (ReferenceDocInfo) r100;
        if (this.createTime == r101.createTime) goto L12;
        return false;
    L12:
        if (this.creatorId == r101.creatorId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L18;
        return false;
    L18:
        if (this.objType == r101.objType) goto L21;
        return false;
    L21:
        if (this.permitted == r101.permitted) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.createTime * 31) + this.creatorId) * 31) + this.objToken.hashCode()) * 31) + this.objType) * 31;
        if (this.permitted == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.title.hashCode()) * 31) + this.url.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "ReferenceDocInfo(createTime=" + this.createTime + ", creatorId=" + this.creatorId + ", objToken=" + this.objToken + ", objType=" + this.objType + ", permitted=" + this.permitted + ", title=" + this.title + ", url=" + this.url + ')';
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final int getCreatorId() {
        return this.creatorId;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final boolean getPermitted() {
        return this.permitted;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public ReferenceDocInfo(@JSONField(name = "create_time") int r100, @JSONField(name = "creator_id") int r101, @JSONField(name = "obj_token") String r102, @JSONField(name = "obj_type") int r103, boolean r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r102, "objToken");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r106, "url");
        this.createTime = r100;
        this.creatorId = r101;
        this.objToken = r102;
        this.objType = r103;
        this.permitted = r104;
        this.title = r105;
        this.url = r106;
    }
}
