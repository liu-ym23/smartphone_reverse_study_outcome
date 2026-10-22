package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/g;", "", "", "imageWidth", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setImageWidth", "(Ljava/lang/Integer;)V", "imageHeight", "d", "setImageHeight", "itemSpacing", "f", "setItemSpacing", "fontSize", "a", "setFontSize", "fontWeight", "b", "setFontWeight", "", "textColor", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setTextColor", "(Ljava/lang/String;)V", "imageColor", "c", "setImageColor", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("font_size")
    private Integer fontSize;

    @SerializedName("font_weight")
    private Integer fontWeight;

    @SerializedName("image_color")
    private String imageColor;

    @SerializedName("image_height")
    private Integer imageHeight;

    @SerializedName("image_width")
    private Integer imageWidth;

    @SerializedName("item_spacing")
    private Integer itemSpacing;

    @SerializedName("text_color")
    private String textColor;

    public g() {
    }

    public final Integer a() {
        return this.fontSize;
    }

    public final Integer b() {
        return this.fontWeight;
    }

    public final String c() {
        return this.imageColor;
    }

    public final Integer d() {
        return this.imageHeight;
    }

    public final Integer e() {
        return this.imageWidth;
    }

    public final Integer f() {
        return this.itemSpacing;
    }

    public final String g() {
        return this.textColor;
    }
}
