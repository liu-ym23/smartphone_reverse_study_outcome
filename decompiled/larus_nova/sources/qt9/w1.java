package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/ImageCommonOptConfig;", "", "optFetcher", "", "optHeif", "optPie", "optLazySize", "optScene", "", "<init>", "(ZZZZI)V", "getOptFetcher", "()Z", "getOptHeif", "getOptPie", "getOptLazySize", "getOptScene", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w1 {

    @SerializedName("opt_fetcher")
    private final boolean optFetcher;

    @SerializedName("opt_heif")
    private final boolean optHeif;

    @SerializedName("opt_lazysize")
    private final boolean optLazySize;

    @SerializedName("opt_pie")
    private final boolean optPie;

    @SerializedName("opt_scene")
    private final int optScene;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r101 = (w1) r100;
        if (this.optFetcher == r101.optFetcher) goto L12;
        return false;
    L12:
        if (this.optHeif == r101.optHeif) goto L15;
        return false;
    L15:
        if (this.optPie == r101.optPie) goto L18;
        return false;
    L18:
        if (this.optLazySize == r101.optLazySize) goto L21;
        return false;
    L21:
        if (this.optScene == r101.optScene) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.optFetcher == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.optHeif == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.optPie == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.optLazySize == true) goto L19;
        r100 = 1237;
    L19:
        return ((r106 + r100) * 31) + this.optScene;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageCommonOptConfig(optFetcher=" + this.optFetcher + ", optHeif=" + this.optHeif + ", optPie=" + this.optPie + ", optLazySize=" + this.optLazySize + ", optScene=" + this.optScene + ')';
    }

    public w1() {
        this.optFetcher = false;
        this.optHeif = false;
        this.optPie = false;
        this.optLazySize = false;
        this.optScene = 0;
    }
}
