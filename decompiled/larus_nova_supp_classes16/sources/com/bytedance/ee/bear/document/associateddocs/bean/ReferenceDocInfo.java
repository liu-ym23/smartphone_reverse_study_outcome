package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/ReferenceDocInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "createTime", "", "creatorId", "objToken", "", "objType", "permitted", "", "title", "url", "<init>", "(IILjava/lang/String;IZLjava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()I", "getCreatorId", "getObjToken", "()Ljava/lang/String;", "getObjType", "getPermitted", "()Z", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceDocInfo implements NonProguard {
    private final int createTime;
    private final int creatorId;
    private final String objToken;
    private final int objType;
    private final boolean permitted;
    private final String title;
    private final String url;

    public static /* synthetic */ ReferenceDocInfo copy$default(ReferenceDocInfo r5, int r6, int r7, String r8, int r9, boolean r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.createTime;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.creatorId;
    L8:
        int r16 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.objToken;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.objType;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.permitted;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.title;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.url;
    L23:
        int r17 = r6;
        return r5.copy(r17, r16, r0, r1, r2, r3, r12);
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

    public final ReferenceDocInfo copy(@JSONField(name = "create_time") int r10, @JSONField(name = "creator_id") int r11, @JSONField(name = "obj_token") String r12, @JSONField(name = "obj_type") int r13, boolean r14, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "objToken");
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "url");
        return new ReferenceDocInfo(r10, r11, r12, r13, r14, r16, r17);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReferenceDocInfo) == true) goto L8;
        return false;
    L8:
        ReferenceDocInfo r6 = (ReferenceDocInfo) r5;
        if (this.createTime == r6.createTime) goto L12;
        return false;
    L12:
        if (this.creatorId == r6.creatorId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objToken, r6.objToken) == true) goto L18;
        return false;
    L18:
        if (this.objType == r6.objType) goto L21;
        return false;
    L21:
        if (this.permitted == r6.permitted) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.createTime * 31) + this.creatorId) * 31) + this.objToken.hashCode()) * 31) + this.objType) * 31;
        if (this.permitted == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.title.hashCode()) * 31) + this.url.hashCode();
    L5:
        r1 = 1237;
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

    public ReferenceDocInfo(@JSONField(name = "create_time") int r2, @JSONField(name = "creator_id") int r3, @JSONField(name = "obj_token") String r4, @JSONField(name = "obj_type") int r5, boolean r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        Intrinsics.checkNotNullParameter(r7, "title");
        Intrinsics.checkNotNullParameter(r8, "url");
        this.createTime = r2;
        this.creatorId = r3;
        this.objToken = r4;
        this.objType = r5;
        this.permitted = r6;
        this.title = r7;
        this.url = r8;
    }
}
