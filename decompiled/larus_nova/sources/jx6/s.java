package jx6;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Ljx6/s;", "", "Lcom/google/gson/JsonObject;", "buttonInfo", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "", "productName", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "currentPriceStr", "b", "discountText", "c", "originPriceStr", "d", "paySubText", "e", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("buttonInfo")
    private final JsonObject buttonInfo;

    @SerializedName("currentPriceStr")
    private final String currentPriceStr;

    @SerializedName("discountText")
    private final String discountText;

    @SerializedName("originPriceStr")
    private final String originPriceStr;

    @SerializedName("paySubText")
    private final String paySubText;

    @SerializedName("productName")
    private final String productName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.buttonInfo, r101.buttonInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productName, r101.productName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currentPriceStr, r101.currentPriceStr) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountText, r101.discountText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.originPriceStr, r101.originPriceStr) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.paySubText, r101.paySubText) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        JsonObject r100 = this.buttonInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.productName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currentPriceStr;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.discountText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.originPriceStr;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.paySubText;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "PreviewPayButtonData(buttonInfo=" + this.buttonInfo + ", productName=" + this.productName + ", currentPriceStr=" + this.currentPriceStr + ", discountText=" + this.discountText + ", originPriceStr=" + this.originPriceStr + ", paySubText=" + this.paySubText + ')';
    }

    public s() {
        this.buttonInfo = null;
        this.productName = null;
        this.currentPriceStr = null;
        this.discountText = null;
        this.originPriceStr = null;
        this.paySubText = null;
    }

    public final JsonObject a() {
        return this.buttonInfo;
    }

    public final String b() {
        return this.currentPriceStr;
    }

    public final String c() {
        return this.discountText;
    }

    public final String d() {
        return this.originPriceStr;
    }

    public final String e() {
        return this.paySubText;
    }

    public final String f() {
        return this.productName;
    }
}
