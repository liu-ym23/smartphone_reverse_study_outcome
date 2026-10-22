package gh7;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements dh7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f481289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f481290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f481291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f481292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f481293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f481294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f481295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f481296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Map<String, ?>> f481297j;

    public final Map<String, ?> a() {
        Map<String, ?> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source", this.f481288a), TuplesKt.to("api_id", Integer.valueOf(this.f481289b)), TuplesKt.to("data_types", this.f481291d), TuplesKt.to("permission_type", this.f481290c), TuplesKt.to("is_pair_not_close", Boolean.valueOf(this.f481292e)), TuplesKt.to("is_pair_delay_close", Boolean.valueOf(this.f481293f))});
        String r101 = this.f481294g;
        if (r101 == null) goto L5;
        r100.put(LocationMonitorConst.CERT_TOKEN, r101);
    L5:
        String r102 = this.f481295h;
        if (r102 == null) goto L8;
        r100.put("context_page", r102);
    L8:
        return r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L26;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f481288a, r101.f481288a) == true) goto L8;
        return false;
    L8:
        if (this.f481289b == r101.f481289b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f481290c, r101.f481290c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481291d, r101.f481291d) == true) goto L14;
        return false;
    L14:
        if (this.f481292e == r101.f481292e) goto L16;
        return false;
    L16:
        if (this.f481293f == r101.f481293f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f481294g, r101.f481294g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f481295h, r101.f481295h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f481296i, r101.f481296i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f481297j, r101.f481297j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f481288a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f481289b) * 31;
        String r104 = this.f481290c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Set<String> r107 = this.f481291d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f481292e;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f481293f;
        if (r114 == true) goto L21;
        r111 = r114;
    L21:
        int r115 = (r113 + r111) * 31;
        String r116 = this.f481294g;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f481295h;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f481296i;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        Set<Map<String, ?>> r125 = this.f481297j;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
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
        return "RuleValidateParams(source=" + this.f481288a + ", apiId=" + this.f481289b + ", permissionType=" + this.f481290c + ", dataTypes=" + this.f481291d + ", isPairNotClose=" + this.f481292e + ", isPairDelayClose=" + this.f481293f + ", certToken=" + this.f481294g + ", contextPage=" + this.f481295h + ", returnType=" + this.f481296i + ", extraParams=" + this.f481297j + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r100, int r101, String r102, Set<String> r103, boolean r104, boolean r105, String r106, String r107, String r108, Set<? extends Map<String, ?>> r110) {
        this.f481288a = r100;
        this.f481289b = r101;
        this.f481290c = r102;
        this.f481291d = r103;
        this.f481292e = r104;
        this.f481293f = r105;
        this.f481294g = r106;
        this.f481295h = r107;
        this.f481296i = r108;
        this.f481297j = r110;
    }
}
