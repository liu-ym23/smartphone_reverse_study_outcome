package g73;

import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lg73/a;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "integerFont", "Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "b", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "decimalFont", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "yuanFont", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("decimal_font")
    private final FontStyle decimalFont;

    @SerializedName("integer_font")
    private final FontStyle integerFont;

    @SerializedName("tag_font")
    private final FontStyle yuanFont;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.integerFont, r101.integerFont) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.decimalFont, r101.decimalFont) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.yuanFont, r101.yuanFont) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        FontStyle r100 = this.integerFont;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FontStyle r104 = this.decimalFont;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FontStyle r107 = this.yuanFont;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PriceFont(integerFont=" + this.integerFont + ", decimalFont=" + this.decimalFont + ", yuanFont=" + this.yuanFont + ")";
    }

    public a() {
        this.integerFont = null;
        this.decimalFont = null;
        this.yuanFont = null;
    }

    public final FontStyle a() {
        return this.decimalFont;
    }

    public final FontStyle b() {
        return this.integerFont;
    }

    public final FontStyle c() {
        return this.yuanFont;
    }
}
