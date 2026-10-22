package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/t;", "", "", "mainTitleDouble", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "subTitleDouble", "h", "mainTitleSingle", "f", "subTitleSingle", "i", "jumpUrl", "d", "Lcom/bytedance/android/window/shop/repository/dto/f;", "image0", "Lcom/bytedance/android/window/shop/repository/dto/f;", "a", "()Lcom/bytedance/android/window/shop/repository/dto/f;", "image1", "b", "image2", "c", "Lcom/bytedance/android/window/shop/repository/dto/j;", "video", "Lcom/bytedance/android/window/shop/repository/dto/j;", "j", "()Lcom/bytedance/android/window/shop/repository/dto/j;", "Lcom/bytedance/android/window/shop/repository/dto/s;", "product", "Lcom/bytedance/android/window/shop/repository/dto/s;", "g", "()Lcom/bytedance/android/window/shop/repository/dto/s;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("image0")
    private final f image0;

    @SerializedName("image1")
    private final f image1;

    @SerializedName("image2")
    private final f image2;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("sl_main_title")
    private final String mainTitleDouble;

    @SerializedName("dl_main_title")
    private final String mainTitleSingle;

    @SerializedName("product")
    private final s product;

    @SerializedName("sl_subtitle")
    private final String subTitleDouble;

    @SerializedName("dl_subtitle")
    private final String subTitleSingle;

    @SerializedName("video")
    private final j video;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t) == false) goto L26;
        t r4 = (t) r3;
        if (Intrinsics.areEqual(this.mainTitleDouble, r4.mainTitleDouble) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subTitleDouble, r4.subTitleDouble) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mainTitleSingle, r4.mainTitleSingle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitleSingle, r4.subTitleSingle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.image0, r4.image0) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.image1, r4.image1) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.image2, r4.image2) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.video, r4.video) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.product, r4.product) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r0 = this.mainTitleDouble;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.subTitleDouble;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mainTitleSingle;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.subTitleSingle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.jumpUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        f r16 = this.image0;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        f r19 = this.image1;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        f r22 = this.image2;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        j r25 = this.video;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        s r28 = this.product;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
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
        return "WindowExplainProductVideoDTO(mainTitleDouble=" + this.mainTitleDouble + ", subTitleDouble=" + this.subTitleDouble + ", mainTitleSingle=" + this.mainTitleSingle + ", subTitleSingle=" + this.subTitleSingle + ", jumpUrl=" + this.jumpUrl + ", image0=" + this.image0 + ", image1=" + this.image1 + ", image2=" + this.image2 + ", video=" + this.video + ", product=" + this.product + ")";
    }

    public final f a() {
        return this.image0;
    }

    public final f b() {
        return this.image1;
    }

    public final f c() {
        return this.image2;
    }

    public final String d() {
        return this.jumpUrl;
    }

    public final String e() {
        return this.mainTitleDouble;
    }

    public final String f() {
        return this.mainTitleSingle;
    }

    public final s g() {
        return this.product;
    }

    public final String h() {
        return this.subTitleDouble;
    }

    public final String i() {
        return this.subTitleSingle;
    }

    public final j j() {
        return this.video;
    }
}
