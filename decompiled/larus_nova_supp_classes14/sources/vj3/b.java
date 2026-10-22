package vj3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lvj3/b;", "", "", "slicePageUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lvj3/a;", "sliceConfigs", "Lvj3/a;", "a", "()Lvj3/a;", "", "routerQuery", "Ljava/util/Map;", "getRouterQuery", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.slicePageUrl, r4.slicePageUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sliceConfigs, r4.sliceConfigs) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.routerQuery, r4.routerQuery) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.slicePageUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        a r4 = this.sliceConfigs;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.routerQuery;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public b(String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r6 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_search_result_page/main.json";
    L6:
        if ((r7 & 2) == 0) goto L8;
        a r8 = new a(Float.valueOf(375.0f), Float.valueOf(1.1f), Float.valueOf(1.1f), 78);
    L9:
        this.slicePageUrl = r6;
        this.sliceConfigs = r8;
        this.routerQuery = null;
        return;
    L8:
        r8 = null;
        goto L9
    }
}
