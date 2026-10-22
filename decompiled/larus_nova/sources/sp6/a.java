package sp6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lsp6/a;", "", "", "skeletonY", "I", "f", "()I", "skeletonCorner", "d", "", "", "skeletonBgColor", "Ljava/util/List;", "c", "()Ljava/util/List;", "itemCorner", "b", "itemBgColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lsp6/e;", "skeletonItemModels", "e", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("item_color")
    private final List<String> itemBgColor;

    @SerializedName("item_corner")
    private final int itemCorner;

    @SerializedName("skeleton_background_color")
    private final List<String> skeletonBgColor;

    @SerializedName("skeleton_corner")
    private final int skeletonCorner;

    @SerializedName("items")
    private final List<e> skeletonItemModels;

    @SerializedName("skeleton_y")
    private final int skeletonY;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.skeletonY == r101.skeletonY) goto L12;
        return false;
    L12:
        if (this.skeletonCorner == r101.skeletonCorner) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.skeletonBgColor, r101.skeletonBgColor) == true) goto L18;
        return false;
    L18:
        if (this.itemCorner == r101.itemCorner) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.itemBgColor, r101.itemBgColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.skeletonItemModels, r101.skeletonItemModels) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.skeletonY * 31) + this.skeletonCorner) * 31;
        List<String> r101 = this.skeletonBgColor;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.itemCorner) * 31;
        List<String> r105 = this.itemBgColor;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<e> r108 = this.skeletonItemModels;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiSkeletonModel(skeletonY=" + this.skeletonY + ", skeletonCorner=" + this.skeletonCorner + ", skeletonBgColor=" + this.skeletonBgColor + ", itemCorner=" + this.itemCorner + ", itemBgColor=" + this.itemBgColor + ", skeletonItemModels=" + this.skeletonItemModels + ')';
    }

    public a() {
        this.skeletonY = 0;
        this.skeletonCorner = 0;
        this.skeletonBgColor = null;
        this.itemCorner = 0;
        this.itemBgColor = null;
        this.skeletonItemModels = null;
    }

    public final List<String> a() {
        return this.itemBgColor;
    }

    public final int b() {
        return this.itemCorner;
    }

    public final List<String> c() {
        return this.skeletonBgColor;
    }

    public final int d() {
        return this.skeletonCorner;
    }

    public final List<e> e() {
        return this.skeletonItemModels;
    }

    public final int f() {
        return this.skeletonY;
    }
}
