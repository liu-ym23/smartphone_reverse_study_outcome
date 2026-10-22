package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/n;", "", "", "mainTitle", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "headerIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "itemImgs", "Ljava/util/List;", "d", "()Ljava/util/List;", "subTitle", "g", "schema", "f", "", "bubbleType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "guideBubbleText", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("bubble_type")
    private final Integer bubbleType;

    @SerializedName("guide_bubble_text")
    private final String guideBubbleText;

    @SerializedName("header_icon")
    private final ECUrlModel headerIcon;

    @SerializedName("item_img")
    private final List<ECUrlModel> itemImgs;

    @SerializedName("main_title")
    private final String mainTitle;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("sub_title")
    private final String subTitle;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L20;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.mainTitle, r4.mainTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.headerIcon, r4.headerIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemImgs, r4.itemImgs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r4.subTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bubbleType, r4.bubbleType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.guideBubbleText, r4.guideBubbleText) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.mainTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.headerIcon;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<ECUrlModel> r7 = this.itemImgs;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.subTitle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.schema;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.bubbleType;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.guideBubbleText;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
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
        return "WindowBubbleDTO(mainTitle=" + this.mainTitle + ", headerIcon=" + this.headerIcon + ", itemImgs=" + this.itemImgs + ", subTitle=" + this.subTitle + ", schema=" + this.schema + ", bubbleType=" + this.bubbleType + ", guideBubbleText=" + this.guideBubbleText + ")";
    }

    public n() {
        this.mainTitle = null;
        this.headerIcon = null;
        this.itemImgs = null;
        this.subTitle = null;
        this.schema = null;
        this.bubbleType = null;
        this.guideBubbleText = null;
    }

    public final Integer a() {
        return this.bubbleType;
    }

    public final String b() {
        return this.guideBubbleText;
    }

    public final ECUrlModel c() {
        return this.headerIcon;
    }

    public final List<ECUrlModel> d() {
        return this.itemImgs;
    }

    public final String e() {
        return this.mainTitle;
    }

    public final String f() {
        return this.schema;
    }

    public final String g() {
        return this.subTitle;
    }
}
