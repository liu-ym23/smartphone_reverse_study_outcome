package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/s;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "text", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "setText", "(Lcom/bytedance/locallife/live/goodsshelves/bean/x;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "image", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "setImage", "(Lcom/bytedance/locallife/live/goodsshelves/bean/t;)V", "", "specialChar", "Ljava/lang/Integer;", "getSpecialChar", "()Ljava/lang/Integer;", "setSpecialChar", "(Ljava/lang/Integer;)V", "flexShrink", "getFlexShrink", "setFlexShrink", "Lcom/bytedance/locallife/live/goodsshelves/bean/h;", "clickInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/h;", "getClickInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/h;", "setClickInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/h;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("click_info")
    private h clickInfo;

    @SerializedName("flex_shrink")
    private Integer flexShrink;

    @SerializedName("image")
    private t image;

    @SerializedName("special_char")
    private Integer specialChar;

    @SerializedName("text")
    private x text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.specialChar, r101.specialChar) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flexShrink, r101.flexShrink) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickInfo, r101.clickInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        x r100 = this.text;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        t r103 = this.image;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        Integer r106 = this.specialChar;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Integer r109 = this.flexShrink;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        h r112 = this.clickInfo;
        if (r112 == null) goto L21;
        r112.hashCode();
        throw null;
    L21:
        return r111 + 0;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardMaterialInfo(text=" + this.text + ", image=" + this.image + ", specialChar=" + this.specialChar + ", flexShrink=" + this.flexShrink + ", clickInfo=" + this.clickInfo + ')';
    }

    public final t a() {
        return this.image;
    }

    public final x b() {
        return this.text;
    }
}
