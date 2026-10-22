package nb1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lnb1/d;", "", "", "fontUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFontUrl", "(Ljava/lang/String;)V", "", "size", "I", "d", "()I", "setSize", "(I)V", "alignment", "getAlignment", "setAlignment", "Lnb1/l;", "border", "Lnb1/l;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnb1/l;", "setBorder", "(Lnb1/l;)V", "Ljava/util/ArrayList;", "Lnb1/m;", "Lkotlin/collections/ArrayList;", "colors", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "setColors", "(Ljava/util/ArrayList;)V", "style", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setStyle", "(Ljava/lang/Integer;)V", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("alignment")
    private int alignment;

    @SerializedName("border")
    private l border;

    @SerializedName("colors")
    private ArrayList<m> colors;

    @SerializedName("font_url")
    private String fontUrl;

    @SerializedName("size")
    private int size;

    @SerializedName("android_style")
    private Integer style;

    public d() {
    }

    public final l a() {
        return this.border;
    }

    public final ArrayList<m> b() {
        return this.colors;
    }

    public final String c() {
        return this.fontUrl;
    }

    public final int d() {
        return this.size;
    }

    public final Integer e() {
        return this.style;
    }
}
