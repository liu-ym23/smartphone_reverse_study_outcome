package he3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R8\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/n0;", "", "", "", "sliceData", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "commonData", "c", "Lhe3/k0;", "naData", "Lhe3/k0;", "e", "()Lhe3/k0;", "linkMap", "d", "Lhe3/m0;", "trackData", "Lhe3/m0;", ce.f26391f, "()Lhe3/m0;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f484833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f484834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f484835c;

    @SerializedName("common_data")
    private final Map<String, Object> commonData;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.deepfeed.slice.c f484836d;

    @SerializedName("link_map")
    private final Map<String, String> linkMap;

    @SerializedName("na_data")
    private final k0 naData;

    @SerializedName("slice_data")
    private final Map<String, Map<String, Object>> sliceData;

    @SerializedName("track_data")
    private final m0 trackData;

    public n0() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L16;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.sliceData, r101.sliceData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commonData, r101.commonData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.naData, r101.naData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.linkMap, r101.linkMap) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trackData, r101.trackData) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Map<String, Map<String, Object>> r100 = this.sliceData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.commonData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k0 r107 = this.naData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.linkMap;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        m0 r113 = this.trackData;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "DeepFeedSliceCard(sliceData=" + this.sliceData + ", commonData=" + this.commonData + ", naData=" + this.naData + ", linkMap=" + this.linkMap + ", trackData=" + this.trackData + ")";
    }

    public final Map<String, Object> c() {
        return this.commonData;
    }

    public final Map<String, String> d() {
        return this.linkMap;
    }

    public final k0 e() {
        return this.naData;
    }

    public final Map<String, Map<String, Object>> f() {
        return this.sliceData;
    }

    public final m0 g() {
        return this.trackData;
    }

    public static n0 a(n0 r100, k0 r101) {
        return new n0(r100.sliceData, r100.commonData, r101, r100.linkMap, r100.trackData);
    }

    public final void b(Map<String, ? extends Object> r100, z r101) {
        this.f484833a = r101;
        this.f484834b = r100;
        Map<String, Object> r102 = this.commonData;
        y r103 = null;
        Object r104 = null;
        r103 = null;
        if (r102 == null) goto L8;
        String r105 = com.bytedance.android.shopping.store.utils.f.b(r102);
        if (r105 == null) goto L8;
        r104 = com.bytedance.android.ec.core.utils.u0.b(r105, y.class);     // Catch: Throwable -> L10
    L7:
        r103 = (y) r104;
    L8:
        this.f484835c = r103;
    }

    public /* synthetic */ n0(Map r100, Map r110, k0 r111, Map r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        Map r101 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Map r102 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        k0 r103 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Map r104 = null;
    L18:
        this(r101, r102, r103, r104, null);
        return;
    L17:
        r104 = r112;
        goto L18
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public n0(Map<String, Map<String, Object>> r100, Map<String, Object> r101, k0 r102, Map<String, String> r103, m0 r104) {
        this.sliceData = r100;
        this.commonData = r101;
        this.naData = r102;
        this.linkMap = r103;
        this.trackData = r104;
    }
}
