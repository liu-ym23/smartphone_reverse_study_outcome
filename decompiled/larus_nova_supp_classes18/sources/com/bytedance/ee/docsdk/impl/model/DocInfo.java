package com.bytedance.ee.docsdk.impl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010Jx\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017¨\u00069"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/model/DocInfo;", "", "urlType", "", "urlToken", "revision", "", "title", "creator", "creatorID", "ownerID", "createTime", "", "serverTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCreator", "()Ljava/lang/String;", "setCreator", "(Ljava/lang/String;)V", "getCreatorID", "setCreatorID", "getOwnerID", "setOwnerID", "getRevision", "()Ljava/lang/Integer;", "setRevision", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getServerTime", "setServerTime", "getTitle", "setTitle", "getUrlToken", "setUrlToken", "getUrlType", "setUrlType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/ee/docsdk/impl/model/DocInfo;", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public static /* synthetic */ DocInfo copy$default(DocInfo r10, String r11, String r12, Integer r13, String r14, String r15, String r16, String r17, Long r18, Long r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.urlType;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.urlToken;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r4 = r10.revision;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.title;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.creator;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.creatorID;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.ownerID;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r9 = r10.createTime;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Long r1 = r10.serverTime;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final DocInfo copy(String r12, String r13, Integer r14, String r15, String r16, String r17, String r18, Long r19, Long r20) {
        Intrinsics.checkNotNullParameter(r12, "urlType");
        return new DocInfo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocInfo) == true) goto L8;
        return false;
    L8:
        DocInfo r6 = (DocInfo) r5;
        if (Intrinsics.areEqual(this.urlType, r6.urlType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlToken, r6.urlToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.revision, r6.revision) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creator, r6.creator) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.creatorID, r6.creatorID) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ownerID, r6.ownerID) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.serverTime, r6.serverTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = this.urlType.hashCode() * 31;
        String r1 = this.urlToken;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.revision;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.title;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.creator;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.creatorID;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.ownerID;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.createTime;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.serverTime;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
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

    public final void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public final void setCreator(String r1) {
        this.creator = r1;
    }

    public final void setCreatorID(String r1) {
        this.creatorID = r1;
    }

    public final void setOwnerID(String r1) {
        this.ownerID = r1;
    }

    public final void setRevision(Integer r1) {
        this.revision = r1;
    }

    public final void setServerTime(Long r1) {
        this.serverTime = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setUrlToken(String r1) {
        this.urlToken = r1;
    }

    public final void setUrlType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.urlType = r2;
    }

    public DocInfo(String r2, String r3, Integer r4, String r5, String r6, String r7, String r8, Long r9, Long r10) {
        Intrinsics.checkNotNullParameter(r2, "urlType");
        this.urlType = r2;
        this.urlToken = r3;
        this.revision = r4;
        this.title = r5;
        this.creator = r6;
        this.creatorID = r7;
        this.ownerID = r8;
        this.createTime = r9;
        this.serverTime = r10;
    }

    public /* synthetic */ DocInfo(String r11, String r12, Integer r13, String r14, String r15, String r16, String r17, Long r18, Long r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = "unknown";
    L6:
        Long r3 = null;
        if ((r20 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r3 = r19;
    L38:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r3);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
