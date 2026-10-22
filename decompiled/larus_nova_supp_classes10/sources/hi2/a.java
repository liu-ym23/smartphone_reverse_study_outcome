package hi2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lhi2/a;", "", "", "fontSize", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "fontWeight", "b", "", "lineSpacingExtra", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName("font_weight")
    private final Integer fontWeight;

    @SerializedName("line_spacing_extra")
    private final Float lineSpacingExtra;

    public a() {
        Integer r0 = null;
        this(r0, r0, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.fontSize, r4.fontSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fontWeight, r4.fontWeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lineSpacingExtra, r4.lineSpacingExtra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.fontSize;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.fontWeight;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.lineSpacingExtra;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public /* synthetic */ a(Integer r3, Integer r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this(r3, r4, null);
    }

    public a(Integer r1, Integer r2, Float r3) {
        this.fontSize = r1;
        this.fontWeight = r2;
        this.lineSpacingExtra = r3;
    }
}
