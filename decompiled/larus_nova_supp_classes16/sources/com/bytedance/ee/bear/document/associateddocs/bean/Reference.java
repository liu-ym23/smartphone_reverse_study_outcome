package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/Reference;", "Lcom/bytedance/ee/util/io/NonProguard;", "createTime", "", "creatorId", "previewToken", "", "previewInfo", "url", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()I", "getCreatorId", "getPreviewToken", "()Ljava/lang/String;", "getPreviewInfo", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Reference implements NonProguard {
    private final int createTime;
    private final int creatorId;
    private final String previewInfo;
    private final String previewToken;
    private final String url;

    public static /* synthetic */ Reference copy$default(Reference r3, int r4, int r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.createTime;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.creatorId;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.previewToken;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.previewInfo;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.url;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.createTime;
    }

    public final int component2() {
        return this.creatorId;
    }

    public final String component3() {
        return this.previewToken;
    }

    public final String component4() {
        return this.previewInfo;
    }

    public final String component5() {
        return this.url;
    }

    public final Reference copy(@JSONField(name = "create_time") int r8, @JSONField(name = "creator_id") int r9, @JSONField(name = "preview_token") String r10, @JSONField(name = "preview_info") String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "previewToken");
        Intrinsics.checkNotNullParameter(r12, "url");
        return new Reference(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Reference) == true) goto L8;
        return false;
    L8:
        Reference r6 = (Reference) r5;
        if (this.createTime == r6.createTime) goto L12;
        return false;
    L12:
        if (this.creatorId == r6.creatorId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewToken, r6.previewToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewInfo, r6.previewInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.createTime * 31) + this.creatorId) * 31) + this.previewToken.hashCode()) * 31;
        String r1 = this.previewInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.url.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Reference(createTime=" + this.createTime + ", creatorId=" + this.creatorId + ", previewToken=" + this.previewToken + ", previewInfo=" + this.previewInfo + ", url=" + this.url + ')';
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final int getCreatorId() {
        return this.creatorId;
    }

    public final String getPreviewInfo() {
        return this.previewInfo;
    }

    public final String getPreviewToken() {
        return this.previewToken;
    }

    public final String getUrl() {
        return this.url;
    }

    public Reference(@JSONField(name = "create_time") int r2, @JSONField(name = "creator_id") int r3, @JSONField(name = "preview_token") String r4, @JSONField(name = "preview_info") String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "previewToken");
        Intrinsics.checkNotNullParameter(r6, "url");
        this.createTime = r2;
        this.creatorId = r3;
        this.previewToken = r4;
        this.previewInfo = r5;
        this.url = r6;
    }

    public /* synthetic */ Reference(int r8, int r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r5 = "";
    L10:
        this(r8, r9, r4, r5, r12);
        return;
    L9:
        r5 = r11;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }
}
