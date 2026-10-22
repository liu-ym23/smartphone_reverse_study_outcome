package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t14.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003JE\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001a¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/AwemeHybridLabelModel;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "Lt14/a;", "component4", "component5", "backgroundColor", "text", "textColor", "imageUrl", "refUrl", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getText", "setText", "getTextColor", "setTextColor", "Lt14/a;", "getImageUrl", "()Lt14/a;", "setImageUrl", "(Lt14/a;)V", "getRefUrl", "setRefUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lt14/a;Ljava/lang/String;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class AwemeHybridLabelModel implements Serializable {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("image")
    private a imageUrl;

    @SerializedName("ref_url")
    private String refUrl;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    public static /* synthetic */ AwemeHybridLabelModel copy$default(AwemeHybridLabelModel r100, String r101, String r102, String r103, a r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.text;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.textColor;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.imageUrl;
    L14:
        a r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.refUrl;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.textColor;
    }

    public final a component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.refUrl;
    }

    public final AwemeHybridLabelModel copy(String r100, String r101, String r110, a r111, String r112) {
        return new AwemeHybridLabelModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AwemeHybridLabelModel) == true) goto L8;
        return false;
    L8:
        AwemeHybridLabelModel r101 = (AwemeHybridLabelModel) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refUrl, r101.refUrl) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.imageUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.refUrl;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public String toString() {
        return "AwemeHybridLabelModel(backgroundColor=" + this.backgroundColor + ", text=" + this.text + ", textColor=" + this.textColor + ", imageUrl=" + this.imageUrl + ", refUrl=" + this.refUrl + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final a getImageUrl() {
        return this.imageUrl;
    }

    public final String getRefUrl() {
        return this.refUrl;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setImageUrl(a r100) {
        this.imageUrl = r100;
    }

    public final void setRefUrl(String r100) {
        this.refUrl = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public AwemeHybridLabelModel(String r100, String r101, String r102, a r103, String r104) {
        this.backgroundColor = r100;
        this.text = r101;
        this.textColor = r102;
        this.imageUrl = r103;
        this.refUrl = r104;
    }
}
