package he3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R8\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/n0;", "", "", "", "sliceData", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "commonData", "c", "Lhe3/k0;", "naData", "Lhe3/k0;", "e", "()Lhe3/k0;", "linkMap", "d", "Lhe3/m0;", "trackData", "Lhe3/m0;", "g", "()Lhe3/m0;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {
    public z a;
    public Map<String, ? extends Object> b;
    public y c;

    @SerializedName("common_data")
    private final Map<String, Object> commonData;
    public com.bytedance.android.shopping.deepfeed.slice.c d;

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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n0) == false) goto L16;
        n0 r4 = (n0) r3;
        if (Intrinsics.areEqual(this.sliceData, r4.sliceData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commonData, r4.commonData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.naData, r4.naData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.linkMap, r4.linkMap) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trackData, r4.trackData) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Map<String, Map<String, Object>> r0 = this.sliceData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.commonData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        k0 r7 = this.naData;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.linkMap;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        m0 r13 = this.trackData;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public static n0 a(n0 r6, k0 r7) {
        return new n0(r6.sliceData, r6.commonData, r7, r6.linkMap, r6.trackData);
    }

    public final void b(Map<String, ? extends Object> r2, z r3) {
        this.a = r3;
        this.b = r2;
        Map<String, Object> r4 = this.commonData;
        y r5 = null;
        Object r6 = null;
        r5 = null;
        if (r4 == null) goto L8;
        String r7 = com.bytedance.android.shopping.store.utils.f.b(r4);
        if (r7 == null) goto L8;
        r6 = com.bytedance.android.ec.core.utils.u0.b(r7, y.class);     // Catch: Throwable -> L10
    L7:
        r5 = (y) r6;
    L8:
        this.c = r5;
    }

    public /* synthetic */ n0(Map r9, Map r10, k0 r11, Map r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        Map r3 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        Map r4 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        k0 r5 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Map r6 = null;
    L18:
        this(r3, r4, r5, r6, null);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public n0(Map<String, Map<String, Object>> r1, Map<String, Object> r2, k0 r3, Map<String, String> r4, m0 r5) {
        this.sliceData = r1;
        this.commonData = r2;
        this.naData = r3;
        this.linkMap = r4;
        this.trackData = r5;
    }
}
