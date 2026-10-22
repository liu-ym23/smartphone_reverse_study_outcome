package hi2;

import androidx.core.provider.FontsContractCompat;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lhi2/a;", "", "", "fontSize", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "fontWeight", "b", "", "lineSpacingExtra", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final Integer fontWeight;

    @SerializedName("line_spacing_extra")
    private final Float lineSpacingExtra;

    public a() {
        Integer r100 = null;
        this(r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lineSpacingExtra, r101.lineSpacingExtra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.fontSize;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.fontWeight;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.lineSpacingExtra;
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
        return "TextLargeModeConfig(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", lineSpacingExtra=" + this.lineSpacingExtra + ")";
    }

    public final Integer a() {
        return this.fontSize;
    }

    public final Integer b() {
        return this.fontWeight;
    }

    public final Float c() {
        return this.lineSpacingExtra;
    }

    public /* synthetic */ a(Integer r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null);
    }

    public a(Integer r100, Integer r101, Float r102) {
        this.fontSize = r100;
        this.fontWeight = r101;
        this.lineSpacingExtra = r102;
    }
}
