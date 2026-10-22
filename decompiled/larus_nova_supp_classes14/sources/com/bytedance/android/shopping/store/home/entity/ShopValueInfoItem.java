package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001)BC\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003JE\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItem;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component4", "component5", "numberText", "suffix", "desc", "icon", "url", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getNumberText", "()Ljava/lang/String;", "setNumberText", "(Ljava/lang/String;)V", "getSuffix", "setSuffix", "getDesc", "setDesc", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getUrl", "setUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopValueInfoItem implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 2;

    @SerializedName("desc")
    private String desc;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("number_text")
    private String numberText;

    @SerializedName("unit")
    private String suffix;

    @SerializedName("url")
    private String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShopValueInfoItem() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ShopValueInfoItem copy$default(ShopValueInfoItem r3, String r4, String r5, String r6, ECUrlModel r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.numberText;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.suffix;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.desc;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.icon;
    L14:
        ECUrlModel r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.url;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.numberText;
    }

    public final String component2() {
        return this.suffix;
    }

    public final String component3() {
        return this.desc;
    }

    public final ECUrlModel component4() {
        return this.icon;
    }

    public final String component5() {
        return this.url;
    }

    public final ShopValueInfoItem copy(String r8, String r9, String r10, ECUrlModel r11, String r12) {
        return new ShopValueInfoItem(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopValueInfoItem) == false) goto L16;
        ShopValueInfoItem r4 = (ShopValueInfoItem) r3;
        if (Intrinsics.areEqual(this.numberText, r4.numberText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.suffix, r4.suffix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.numberText;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.suffix;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.desc;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.icon;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.url;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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

    public String toString() {
        return "ShopValueInfoItem(numberText=" + this.numberText + ", suffix=" + this.suffix + ", desc=" + this.desc + ", icon=" + this.icon + ", url=" + this.url + ")";
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getNumberText() {
        return this.numberText;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setDesc(String r1) {
        this.desc = r1;
    }

    public final void setIcon(ECUrlModel r1) {
        this.icon = r1;
    }

    public final void setNumberText(String r1) {
        this.numberText = r1;
    }

    public final void setSuffix(String r1) {
        this.suffix = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public ShopValueInfoItem(String r1, String r2, String r3, ECUrlModel r4, String r5) {
        this.numberText = r1;
        this.suffix = r2;
        this.desc = r3;
        this.icon = r4;
        this.url = r5;
    }

    public /* synthetic */ ShopValueInfoItem(String r5, String r6, String r7, ECUrlModel r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        ECUrlModel r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
