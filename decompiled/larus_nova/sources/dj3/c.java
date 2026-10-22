package dj3;

import com.bytedance.android.shopping.store.repository.vo.ShopRemoteStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldj3/c;", "", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "textColor", "f", "", "fontSize", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "fontWidth", "c", "backgroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/store/repository/vo/ShopRemoteStruct;", "freqCtrl", "Lcom/bytedance/android/shopping/store/repository/vo/ShopRemoteStruct;", "d", "()Lcom/bytedance/android/shopping/store/repository/vo/ShopRemoteStruct;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("bg_color")
    private final String backgroundColor;

    @SerializedName("font_size")
    private final Long fontSize;

    @SerializedName("font_width")
    private final Long fontWidth;

    @SerializedName("freq_ctrl")
    private final ShopRemoteStruct freqCtrl;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontWidth, r101.fontWidth) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.freqCtrl, r101.freqCtrl) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.fontSize;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.fontWidth;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.backgroundColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ShopRemoteStruct r116 = this.freqCtrl;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BubbleConfig(text=" + this.text + ", textColor=" + this.textColor + ", fontSize=" + this.fontSize + ", fontWidth=" + this.fontWidth + ", backgroundColor=" + this.backgroundColor + ", freqCtrl=" + this.freqCtrl + ")";
    }

    public c() {
        this.text = null;
        this.textColor = null;
        this.fontSize = null;
        this.fontWidth = null;
        this.backgroundColor = null;
        this.freqCtrl = null;
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final Long b() {
        return this.fontSize;
    }

    public final Long c() {
        return this.fontWidth;
    }

    public final ShopRemoteStruct d() {
        return this.freqCtrl;
    }

    public final String e() {
        return this.text;
    }

    public final String f() {
        return this.textColor;
    }
}
