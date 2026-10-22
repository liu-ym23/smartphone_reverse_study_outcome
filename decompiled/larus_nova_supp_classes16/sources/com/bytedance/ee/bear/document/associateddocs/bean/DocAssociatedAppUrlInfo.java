package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public static /* synthetic */ DocAssociatedAppUrlInfo copy$default(DocAssociatedAppUrlInfo r11, String r12, long r13, long r16, String r17, boolean r18, boolean r19, boolean r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.url;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r3 = r11.createTime;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r5 = r11.creatorId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r7 = r11.previeToken;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r8 = r11.needLocalPreview;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r9 = r11.closeCardPreview;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r10 = r11.isLazyLoad;
    L31:
        if ((r22 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        String r1 = r11.urlMetaId;
    L35:
        return r11.copy(r2, r3, r5, r7, r8, r9, r10, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
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

    public final DocAssociatedAppUrlInfo copy(String r13, @JSONField(name = "create_time") long r14, @JSONField(name = "creator_id") long r16, @JSONField(name = "previe_token") String r18, @JSONField(name = "need_local_preview") boolean r19, @JSONField(name = "close_card_preview") boolean r20, @JSONField(name = "is_lazy_load") boolean r21, @JSONField(name = "url_meta_id") String r22) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r18, "previeToken");
        return new DocAssociatedAppUrlInfo(r13, r14, r16, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DocAssociatedAppUrlInfo) == true) goto L8;
        return false;
    L8:
        DocAssociatedAppUrlInfo r9 = (DocAssociatedAppUrlInfo) r8;
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r9.createTime) goto L15;
        return false;
    L15:
        if (this.creatorId == r9.creatorId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previeToken, r9.previeToken) == true) goto L21;
        return false;
    L21:
        if (this.needLocalPreview == r9.needLocalPreview) goto L24;
        return false;
    L24:
        if (this.closeCardPreview == r9.closeCardPreview) goto L27;
        return false;
    L27:
        if (this.isLazyLoad == r9.isLazyLoad) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.urlMetaId, r9.urlMetaId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.url.hashCode() * 31;
        long r1 = this.createTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.creatorId;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.previeToken.hashCode()) * 31;
        int r5 = 1231;
        if (this.needLocalPreview == false) goto L5;
        int r6 = 1231;
    L6:
        int r7 = (r4 + r6) * 31;
        if (this.closeCardPreview == false) goto L9;
        int r8 = 1231;
    L10:
        int r9 = (r7 + r8) * 31;
        if (this.isLazyLoad == true) goto L14;
        r5 = 1237;
    L14:
        int r10 = (r9 + r5) * 31;
        String r11 = this.urlMetaId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L19:
        return r10 + r12;
    L17:
        r12 = r11.hashCode();
        goto L19
    L9:
        r8 = 1237;
        goto L10
    L5:
        r6 = 1237;
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

    public DocAssociatedAppUrlInfo(String r2, @JSONField(name = "create_time") long r3, @JSONField(name = "creator_id") long r5, @JSONField(name = "previe_token") String r7, @JSONField(name = "need_local_preview") boolean r8, @JSONField(name = "close_card_preview") boolean r9, @JSONField(name = "is_lazy_load") boolean r10, @JSONField(name = "url_meta_id") String r11) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r7, "previeToken");
        this.url = r2;
        this.createTime = r3;
        this.creatorId = r5;
        this.previeToken = r7;
        this.needLocalPreview = r8;
        this.closeCardPreview = r9;
        this.isLazyLoad = r10;
        this.urlMetaId = r11;
    }

    public /* synthetic */ DocAssociatedAppUrlInfo(String r16, long r17, long r18, String r20, boolean r21, boolean r22, boolean r23, String r24, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 16) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r26 & 32) == 0) goto L9;
        boolean r11 = false;
    L11:
        if ((r26 & 64) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r26 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L17;
        String r13 = "";
    L18:
        this(r16, r17, r18, r20, r10, r11, r12, r13);
        return;
    L17:
        r13 = r24;
        goto L18
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r10 = r21;
        goto L7
    }
}
