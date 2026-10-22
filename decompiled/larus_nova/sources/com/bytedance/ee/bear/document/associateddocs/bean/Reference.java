package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/Reference;", "Lcom/bytedance/ee/util/io/NonProguard;", "createTime", "", "creatorId", "previewToken", "", "previewInfo", "url", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()I", "getCreatorId", "getPreviewToken", "()Ljava/lang/String;", "getPreviewInfo", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Reference implements NonProguard {
    private final int createTime;
    private final int creatorId;
    private final String previewInfo;
    private final String previewToken;
    private final String url;

    public static /* synthetic */ Reference copy$default(Reference r100, int r101, int r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.createTime;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.creatorId;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.previewToken;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.previewInfo;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.url;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final Reference copy(@JSONField(name = "create_time") int r100, @JSONField(name = "creator_id") int r101, @JSONField(name = "preview_token") String r110, @JSONField(name = "preview_info") String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "previewToken");
        Intrinsics.checkNotNullParameter(r112, "url");
        return new Reference(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Reference) == true) goto L8;
        return false;
    L8:
        Reference r101 = (Reference) r100;
        if (this.createTime == r101.createTime) goto L12;
        return false;
    L12:
        if (this.creatorId == r101.creatorId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewToken, r101.previewToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewInfo, r101.previewInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.createTime * 31) + this.creatorId) * 31) + this.previewToken.hashCode()) * 31;
        String r101 = this.previewInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.url.hashCode();
    L5:
        r102 = r101.hashCode();
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

    public Reference(@JSONField(name = "create_time") int r100, @JSONField(name = "creator_id") int r101, @JSONField(name = "preview_token") String r102, @JSONField(name = "preview_info") String r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "previewToken");
        Intrinsics.checkNotNullParameter(r104, "url");
        this.createTime = r100;
        this.creatorId = r101;
        this.previewToken = r102;
        this.previewInfo = r103;
        this.url = r104;
    }

    public /* synthetic */ Reference(int r100, int r101, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r103 = "";
    L10:
        this(r100, r101, r102, r103, r112);
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r110;
        goto L7
    }
}
