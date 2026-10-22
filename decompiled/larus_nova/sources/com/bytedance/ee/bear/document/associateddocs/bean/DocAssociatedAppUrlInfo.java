package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\t\u0012\b\b\u0003\u0010\u000b\u001a\u00020\t\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/DocAssociatedAppUrlInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "url", "", "createTime", "", "creatorId", "previeToken", "needLocalPreview", "", "closeCardPreview", "isLazyLoad", "urlMetaId", "<init>", "(Ljava/lang/String;JJLjava/lang/String;ZZZLjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getCreateTime", "()J", "getCreatorId", "getPrevieToken", "getNeedLocalPreview", "()Z", "getCloseCardPreview", "getUrlMetaId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAssociatedAppUrlInfo implements NonProguard {
    private final boolean closeCardPreview;
    private final long createTime;
    private final long creatorId;
    private final boolean isLazyLoad;
    private final boolean needLocalPreview;
    private final String previeToken;
    private final String url;
    private final String urlMetaId;

    public static /* synthetic */ DocAssociatedAppUrlInfo copy$default(DocAssociatedAppUrlInfo r110, String r111, long r112, long r113, String r114, boolean r115, boolean r116, boolean r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.url;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = r110.createTime;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.creatorId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.previeToken;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.needLocalPreview;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.closeCardPreview;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r117 = r110.isLazyLoad;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r106 = r110.urlMetaId;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r117, r106);
    L33:
        r106 = r211;
        goto L35
    L29:
        r117 = r210;
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
        return this.url;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.creatorId;
    }

    public final String component4() {
        return this.previeToken;
    }

    public final boolean component5() {
        return this.needLocalPreview;
    }

    public final boolean component6() {
        return this.closeCardPreview;
    }

    public final boolean component7() {
        return this.isLazyLoad;
    }

    public final String component8() {
        return this.urlMetaId;
    }

    public final DocAssociatedAppUrlInfo copy(String r110, @JSONField(name = "create_time") long r111, @JSONField(name = "creator_id") long r112, @JSONField(name = "previe_token") String r113, @JSONField(name = "need_local_preview") boolean r114, @JSONField(name = "close_card_preview") boolean r210, @JSONField(name = "is_lazy_load") boolean r211, @JSONField(name = "url_meta_id") String r212) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r113, "previeToken");
        return new DocAssociatedAppUrlInfo(r110, r111, r112, r113, r114, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocAssociatedAppUrlInfo) == true) goto L8;
        return false;
    L8:
        DocAssociatedAppUrlInfo r101 = (DocAssociatedAppUrlInfo) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r101.createTime) goto L15;
        return false;
    L15:
        if (this.creatorId == r101.creatorId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previeToken, r101.previeToken) == true) goto L21;
        return false;
    L21:
        if (this.needLocalPreview == r101.needLocalPreview) goto L24;
        return false;
    L24:
        if (this.closeCardPreview == r101.closeCardPreview) goto L27;
        return false;
    L27:
        if (this.isLazyLoad == r101.isLazyLoad) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.urlMetaId, r101.urlMetaId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.url.hashCode() * 31;
        long r101 = this.createTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.creatorId;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.previeToken.hashCode()) * 31;
        int r105 = 1231;
        if (this.needLocalPreview == false) goto L5;
        int r106 = 1231;
    L6:
        int r107 = (r104 + r106) * 31;
        if (this.closeCardPreview == false) goto L9;
        int r108 = 1231;
    L10:
        int r109 = (r107 + r108) * 31;
        if (this.isLazyLoad == true) goto L14;
        r105 = 1237;
    L14:
        int r110 = (r109 + r105) * 31;
        String r111 = this.urlMetaId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L19:
        return r110 + r112;
    L17:
        r112 = r111.hashCode();
        goto L19
    L9:
        r108 = 1237;
        goto L10
    L5:
        r106 = 1237;
        goto L6
    }

    public String toString() {
        return "DocAssociatedAppUrlInfo(url=" + this.url + ", createTime=" + this.createTime + ", creatorId=" + this.creatorId + ", previeToken=" + this.previeToken + ", needLocalPreview=" + this.needLocalPreview + ", closeCardPreview=" + this.closeCardPreview + ", isLazyLoad=" + this.isLazyLoad + ", urlMetaId=" + this.urlMetaId + ')';
    }

    public final boolean getCloseCardPreview() {
        return this.closeCardPreview;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getCreatorId() {
        return this.creatorId;
    }

    public final boolean getNeedLocalPreview() {
        return this.needLocalPreview;
    }

    public final String getPrevieToken() {
        return this.previeToken;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlMetaId() {
        return this.urlMetaId;
    }

    public final boolean isLazyLoad() {
        return this.isLazyLoad;
    }

    public DocAssociatedAppUrlInfo(String r100, @JSONField(name = "create_time") long r101, @JSONField(name = "creator_id") long r102, @JSONField(name = "previe_token") String r103, @JSONField(name = "need_local_preview") boolean r104, @JSONField(name = "close_card_preview") boolean r105, @JSONField(name = "is_lazy_load") boolean r110, @JSONField(name = "url_meta_id") String r111) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "previeToken");
        this.url = r100;
        this.createTime = r101;
        this.creatorId = r102;
        this.previeToken = r103;
        this.needLocalPreview = r104;
        this.closeCardPreview = r105;
        this.isLazyLoad = r110;
        this.urlMetaId = r111;
    }

    public /* synthetic */ DocAssociatedAppUrlInfo(String r110, long r111, long r112, String r210, boolean r211, boolean r212, boolean r213, String r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 16) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r215 & 32) == 0) goto L9;
        boolean r114 = false;
    L11:
        if ((r215 & 64) == 0) goto L13;
        boolean r115 = false;
    L15:
        if ((r215 & 128) == 0) goto L17;
        String r116 = "";
    L18:
        this(r110, r111, r112, r210, r113, r114, r115, r116);
        return;
    L17:
        r116 = r214;
        goto L18
    L13:
        r115 = r213;
        goto L15
    L9:
        r114 = r212;
        goto L11
    L5:
        r113 = r211;
        goto L7
    }
}
