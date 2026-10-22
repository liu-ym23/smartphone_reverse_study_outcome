package e73;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u0017"}, d2 = {"Le73/e;", "", "", "", "detailImages", "Ljava/util/List;", "b", "()Ljava/util/List;", "commentPreloadData", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setCommentPreloadData", "(Ljava/lang/String;)V", "", "supermarketCartBarData", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setSupermarketCartBarData", "(Ljava/util/Map;)V", "mcpData", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("comment_preload_data")
    private String commentPreloadData;

    @SerializedName("detail_images")
    private final List<String> detailImages;

    @SerializedName("mcp_data")
    private final String mcpData;

    @SerializedName("supermarket_cart_bar_data")
    private Map<String, ? extends Object> supermarketCartBarData;

    public e() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.detailImages, r101.detailImages) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commentPreloadData, r101.commentPreloadData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supermarketCartBarData, r101.supermarketCartBarData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mcpData, r101.mcpData) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.detailImages;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.commentPreloadData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, ? extends Object> r107 = this.supermarketCartBarData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mcpData;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Global(detailImages=" + this.detailImages + ", commentPreloadData=" + this.commentPreloadData + ", supermarketCartBarData=" + this.supermarketCartBarData + ", mcpData=" + this.mcpData + ")";
    }

    public final String a() {
        return this.commentPreloadData;
    }

    public final List<String> b() {
        return this.detailImages;
    }

    public final String c() {
        return this.mcpData;
    }

    public final Map<String, Object> d() {
        return this.supermarketCartBarData;
    }

    public e(List<String> r100, String r101, Map<String, ? extends Object> r102, String r103) {
        this.detailImages = r100;
        this.commentPreloadData = r101;
        this.supermarketCartBarData = r102;
        this.mcpData = r103;
    }
}
