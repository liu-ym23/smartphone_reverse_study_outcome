package vj3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lvj3/b;", "", "", "slicePageUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lvj3/a;", "sliceConfigs", "Lvj3/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lvj3/a;", "", "routerQuery", "Ljava/util/Map;", "getRouterQuery", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("router_query")
    private final Map<String, String> routerQuery;

    @SerializedName("slice_configs")
    private final a sliceConfigs;

    @SerializedName("slice_page_url")
    private final String slicePageUrl;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.slicePageUrl, r101.slicePageUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sliceConfigs, r101.sliceConfigs) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.routerQuery, r101.routerQuery) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.slicePageUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.sliceConfigs;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.routerQuery;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SliceConfigSettingData(slicePageUrl=" + this.slicePageUrl + ", sliceConfigs=" + this.sliceConfigs + ", routerQuery=" + this.routerQuery + ")";
    }

    public final a a() {
        return this.sliceConfigs;
    }

    public final String b() {
        return this.slicePageUrl;
    }

    public b(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_search_result_page/main.json";
    L6:
        if ((r101 & 2) == 0) goto L8;
        a r102 = new a(Float.valueOf(375.0f), Float.valueOf(1.1f), Float.valueOf(1.1f), 78);
    L9:
        this.slicePageUrl = r100;
        this.sliceConfigs = r102;
        this.routerQuery = null;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
