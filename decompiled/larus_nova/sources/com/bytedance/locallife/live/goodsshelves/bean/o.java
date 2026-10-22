package com.bytedance.locallife.live.goodsshelves.bean;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/o;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "headImage", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "", "", GXTemplateKey.FLEXBOX_MARGIN, "Ljava/util/List;", "getMargin", "()Ljava/util/List;", "tagImage", "e", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "maskText", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "d", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "", "isGray", "Ljava/lang/Boolean;", ce.f26391f, "()Ljava/lang/Boolean;", "indexText", "c", "tagImageType", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "borderImage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("border_image")
    private final t borderImage;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("head_image")
    private final t headImage;

    @SerializedName("index_text")
    private final x indexText;

    @SerializedName("is_gray")
    private final Boolean isGray;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final List<Integer> margin;

    @SerializedName("mask_text")
    private final x maskText;

    @SerializedName("tag_image")
    private final t tagImage;

    @SerializedName("tag_image_type")
    private final Integer tagImageType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.headImage, r101.headImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagImage, r101.tagImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maskText, r101.maskText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isGray, r101.isGray) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.indexText, r101.indexText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tagImageType, r101.tagImageType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.borderImage, r101.borderImage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        t r100 = this.headImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.margin;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        t r107 = this.tagImage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        x r110 = this.maskText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isGray;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        x r116 = this.indexText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.tagImageType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        t r122 = this.borderImage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extra;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardImageInfo(headImage=" + this.headImage + ", margin=" + this.margin + ", tagImage=" + this.tagImage + ", maskText=" + this.maskText + ", isGray=" + this.isGray + ", indexText=" + this.indexText + ", tagImageType=" + this.tagImageType + ", borderImage=" + this.borderImage + ", extra=" + this.extra + ')';
    }

    public final t a() {
        return this.borderImage;
    }

    public final t b() {
        return this.headImage;
    }

    public final x c() {
        return this.indexText;
    }

    public final x d() {
        return this.maskText;
    }

    public final t e() {
        return this.tagImage;
    }

    public final Integer f() {
        return this.tagImageType;
    }

    public final Boolean g() {
        return this.isGray;
    }
}
