package zm7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lzm7/o;", "", "", "top", "I", "d", "()I", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "left", "b", "right", "c", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class o {

    @SerializedName("bottom")
    private final int bottom;

    @SerializedName("left")
    private final int left;

    @SerializedName("right")
    private final int right;

    @SerializedName("top")
    private final int top;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L28:
        return true;
    L5:
        if ((r100 instanceof o) == false) goto L27;
        o r101 = (o) r100;
        if (this.top != r101.top) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        if (this.bottom != r101.bottom) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L27;
        if (this.left != r101.left) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L27;
        if (this.right != r101.right) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L27;
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L27:
        return false;
    }

    public final int hashCode() {
        return (((((this.top * 31) + this.bottom) * 31) + this.left) * 31) + this.right;
    }

    public final String toString() {
        return "Position(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ")";
    }

    public o() {
        this.top = -1;
        this.bottom = -1;
        this.left = -1;
        this.right = -1;
    }

    public final int a() {
        return this.bottom;
    }

    public final int b() {
        return this.left;
    }

    public final int c() {
        return this.right;
    }

    public final int d() {
        return this.top;
    }
}
