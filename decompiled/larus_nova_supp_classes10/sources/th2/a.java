package th2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lth2/a;", "", "", "animStyle", "I", "getAnimStyle", "()I", "hotAnimStyle", "getHotAnimStyle", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("anim_style")
    private final int animStyle;

    @SerializedName("hot_anim_style")
    private final int hotAnimStyle;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (this.animStyle == r4.animStyle) goto L8;
        return false;
    L8:
        if (this.hotAnimStyle == r4.hotAnimStyle) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.animStyle * 31) + this.hotAnimStyle;
    }

    public final String toString() {
        return "ECIntroCardAnimOptSetting(animStyle=" + this.animStyle + ", hotAnimStyle=" + this.hotAnimStyle + ")";
    }

    public final boolean a() {
        if (this.animStyle != 1) goto L5;
        return true;
    L5:
        if (c() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean b() {
        if (this.hotAnimStyle == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean c() {
        if (this.animStyle != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public a(int r1) {
        this.animStyle = 0;
        this.hotAnimStyle = 0;
    }
}
