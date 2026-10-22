package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lyw6/r;", "", "", "close_button_url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "share_button_url", "e", "collect_button_url", "c", "search_button_url", "d", "background_color", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("background_color")
    private final String background_color;

    @SerializedName("close_button_url")
    private final String close_button_url;

    @SerializedName("collect_button_url")
    private final String collect_button_url;

    @SerializedName("search_button_url")
    private final String search_button_url;

    @SerializedName("share_button_url")
    private final String share_button_url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.close_button_url, r101.close_button_url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.share_button_url, r101.share_button_url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collect_button_url, r101.collect_button_url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.search_button_url, r101.search_button_url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.background_color, r101.background_color) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.close_button_url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.share_button_url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.collect_button_url;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.search_button_url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.background_color;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GoodsHeaderStateEntity(close_button_url=" + this.close_button_url + ", share_button_url=" + this.share_button_url + ", collect_button_url=" + this.collect_button_url + ", search_button_url=" + this.search_button_url + ", background_color=" + this.background_color + ')';
    }

    public r() {
        this.close_button_url = null;
        this.share_button_url = null;
        this.collect_button_url = null;
        this.search_button_url = null;
        this.background_color = null;
    }

    public final String a() {
        return this.background_color;
    }

    public final String b() {
        return this.close_button_url;
    }

    public final String c() {
        return this.collect_button_url;
    }

    public final String d() {
        return this.search_button_url;
    }

    public final String e() {
        return this.share_button_url;
    }
}
