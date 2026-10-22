package v52;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lv52/a;", "", "", EffectConfiguration.KEY_SEARCH_WORD, "Ljava/lang/String;", "getWord", "()Ljava/lang/String;", "", "scale", "D", "getScale", "()D", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("scale")
    private final double scale;

    @SerializedName(EffectConfiguration.KEY_SEARCH_WORD)
    private final String word;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.word, r101.word) == true) goto L8;
        return false;
    L8:
        if (Double.compare(this.scale, r101.scale) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.word;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = Double.doubleToLongBits(this.scale);
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "HotWord(word=" + this.word + ", scale=" + this.scale + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_SEARCH_WORD);
        this.word = r100;
        this.scale = 50.0d;
    }
}
