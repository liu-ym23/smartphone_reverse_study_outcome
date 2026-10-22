package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001c\u0010(\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R\u001c\u0010*\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r¨\u0006,"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/d1;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "a", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "subIcon", "getSubIcon", "", "createTime", "Ljava/lang/Long;", "getCreateTime", "()Ljava/lang/Long;", "duration", "c", "", "subTitle", "Ljava/lang/String;", "getSubTitle", "()Ljava/lang/String;", "jumpUrl", "d", "videoId", "h", "", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "products", "Ljava/util/List;", "f", "()Ljava/util/List;", "descriptions", "b", "", "buyShareId", "Ljava/lang/Integer;", "getBuyShareId", "()Ljava/lang/Integer;", "title", "g", "content", "getContent", "jumpVideoId", "e", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 {

    @SerializedName("buy_share_id")
    private final Integer buyShareId;

    @SerializedName("content")
    private final String content;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("createTime")
    private final Long createTime;

    @SerializedName("description")
    private final List<String> descriptions;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("video_id")
    private final Long jumpVideoId;

    @SerializedName("products")
    private final List<WindowV2ProductItemDTO> products;

    @SerializedName("sub_icon")
    private final ECUrlModel subIcon;

    @SerializedName("sub_title")
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    @SerializedName("item_id")
    private final String videoId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d1) == false) goto L32;
        d1 r4 = (d1) r3;
        if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subIcon, r4.subIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.createTime, r4.createTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r4.duration) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.subTitle, r4.subTitle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoId, r4.videoId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.products, r4.products) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.descriptions, r4.descriptions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buyShareId, r4.buyShareId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.jumpVideoId, r4.jumpVideoId) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.cover;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.subIcon;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.createTime;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.duration;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.subTitle;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.jumpUrl;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.videoId;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        List<WindowV2ProductItemDTO> r22 = this.products;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.descriptions;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.buyShareId;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.title;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.content;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Long r37 = this.jumpVideoId;
        if (r37 == null) goto L54;
        r1 = r37.hashCode();
    L54:
        return r36 + r1;
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowVideoItemDTO(cover=" + this.cover + ", subIcon=" + this.subIcon + ", createTime=" + this.createTime + ", duration=" + this.duration + ", subTitle=" + this.subTitle + ", jumpUrl=" + this.jumpUrl + ", videoId=" + this.videoId + ", products=" + this.products + ", descriptions=" + this.descriptions + ", buyShareId=" + this.buyShareId + ", title=" + this.title + ", content=" + this.content + ", jumpVideoId=" + this.jumpVideoId + ")";
    }

    public d1() {
        this.cover = null;
        this.subIcon = null;
        this.createTime = null;
        this.duration = null;
        this.subTitle = null;
        this.jumpUrl = null;
        this.videoId = null;
        this.products = null;
        this.descriptions = null;
        this.buyShareId = null;
        this.title = null;
        this.content = null;
        this.jumpVideoId = null;
    }

    public final ECUrlModel a() {
        return this.cover;
    }

    public final List<String> b() {
        return this.descriptions;
    }

    public final Long c() {
        return this.duration;
    }

    public final String d() {
        return this.jumpUrl;
    }

    public final Long e() {
        return this.jumpVideoId;
    }

    public final List<WindowV2ProductItemDTO> f() {
        return this.products;
    }

    public final String g() {
        return this.title;
    }

    public final String h() {
        return this.videoId;
    }
}
