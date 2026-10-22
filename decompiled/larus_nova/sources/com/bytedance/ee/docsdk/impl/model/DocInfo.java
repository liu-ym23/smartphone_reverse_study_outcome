package com.bytedance.ee.docsdk.impl.model;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010Jx\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017¨\u00069"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/model/DocInfo;", "", "urlType", "", "urlToken", "revision", "", "title", "creator", "creatorID", "ownerID", "createTime", "", "serverTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCreator", "()Ljava/lang/String;", "setCreator", "(Ljava/lang/String;)V", "getCreatorID", "setCreatorID", "getOwnerID", "setOwnerID", "getRevision", "()Ljava/lang/Integer;", "setRevision", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getServerTime", "setServerTime", "getTitle", d.f25925o, "getUrlToken", "setUrlToken", "getUrlType", "setUrlType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/ee/docsdk/impl/model/DocInfo;", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DocInfo {
    private Long createTime;
    private String creator;
    private String creatorID;
    private String ownerID;
    private Integer revision;
    private Long serverTime;
    private String title;
    private String urlToken;
    private String urlType;

    public DocInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ DocInfo copy$default(DocInfo r110, String r111, String r112, Integer r113, String r114, String r115, String r116, String r117, Long r118, Long r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.urlType;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.urlToken;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.revision;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.title;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.creator;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.creatorID;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.ownerID;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r107 = r110.createTime;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Long r108 = r110.serverTime;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    public final String component1() {
        return this.urlType;
    }

    public final String component2() {
        return this.urlToken;
    }

    public final Integer component3() {
        return this.revision;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.creator;
    }

    public final String component6() {
        return this.creatorID;
    }

    public final String component7() {
        return this.ownerID;
    }

    public final Long component8() {
        return this.createTime;
    }

    public final Long component9() {
        return this.serverTime;
    }

    public final DocInfo copy(String r110, String r111, Integer r112, String r113, String r114, String r115, String r116, Long r117, Long r210) {
        Intrinsics.checkNotNullParameter(r110, "urlType");
        return new DocInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocInfo) == true) goto L8;
        return false;
    L8:
        DocInfo r101 = (DocInfo) r100;
        if (Intrinsics.areEqual(this.urlType, r101.urlType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlToken, r101.urlToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.revision, r101.revision) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creator, r101.creator) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.creatorID, r101.creatorID) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ownerID, r101.ownerID) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.serverTime, r101.serverTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = this.urlType.hashCode() * 31;
        String r101 = this.urlToken;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.revision;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.title;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.creator;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.creatorID;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.ownerID;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.createTime;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Long r123 = this.serverTime;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "DocInfo(urlType=" + this.urlType + ", urlToken=" + this.urlToken + ", revision=" + this.revision + ", title=" + this.title + ", creator=" + this.creator + ", creatorID=" + this.creatorID + ", ownerID=" + this.ownerID + ", createTime=" + this.createTime + ", serverTime=" + this.serverTime + ')';
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getCreator() {
        return this.creator;
    }

    public final String getCreatorID() {
        return this.creatorID;
    }

    public final String getOwnerID() {
        return this.ownerID;
    }

    public final Integer getRevision() {
        return this.revision;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrlToken() {
        return this.urlToken;
    }

    public final String getUrlType() {
        return this.urlType;
    }

    public final void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public final void setCreator(String r100) {
        this.creator = r100;
    }

    public final void setCreatorID(String r100) {
        this.creatorID = r100;
    }

    public final void setOwnerID(String r100) {
        this.ownerID = r100;
    }

    public final void setRevision(Integer r100) {
        this.revision = r100;
    }

    public final void setServerTime(Long r100) {
        this.serverTime = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrlToken(String r100) {
        this.urlToken = r100;
    }

    public final void setUrlType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.urlType = r100;
    }

    public DocInfo(String r100, String r101, Integer r102, String r103, String r104, String r105, String r106, Long r107, Long r110) {
        Intrinsics.checkNotNullParameter(r100, "urlType");
        this.urlType = r100;
        this.urlToken = r101;
        this.revision = r102;
        this.title = r103;
        this.creator = r104;
        this.creatorID = r105;
        this.ownerID = r106;
        this.createTime = r107;
        this.serverTime = r110;
    }

    public /* synthetic */ DocInfo(String r110, String r111, Integer r112, String r113, String r114, String r115, String r116, Long r117, Long r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "unknown";
    L6:
        Long r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r101 = r118;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
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
