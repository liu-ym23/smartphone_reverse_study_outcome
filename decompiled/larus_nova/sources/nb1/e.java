package nb1;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lnb1/e;", "Lnb1/b;", "", "style", "I", "f", "()I", "setStyle", "(I)V", "rows", "e", "setRows", "Lnb1/m;", "focusBgColor", "Lnb1/m;", "d", "()Lnb1/m;", "setFocusBgColor", "(Lnb1/m;)V", "unFocusBgColor", ce.f26391f, "setUnFocusBgColor", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e extends b {

    @SerializedName("focus_bg_color")
    private m focusBgColor;

    @SerializedName("rows")
    private int rows;

    @SerializedName("style")
    private int style;

    @SerializedName("unfocus_color")
    private m unFocusBgColor;

    public e() {
        this.rows = 2;
    }

    public final m d() {
        return this.focusBgColor;
    }

    public final int e() {
        return this.rows;
    }

    public final int f() {
        return this.style;
    }

    public final m g() {
        return this.unFocusBgColor;
    }
}
