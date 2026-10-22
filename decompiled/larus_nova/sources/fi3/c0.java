package fi3;

import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f477247e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f477249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f477250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> f477251d;

    public static final class a {
        public a() {
        }

        public static SlcCommonAction a(String r100, Map r101, List r102, int r103) {
            int r104 = c0.f477247e;
            if ((r103 & 8) == 0) goto L5;
            r102 = null;
        L5:
            Intrinsics.checkNotNullParameter(r101, "incomingData");
            return new SlcCommonAction("PDPSliceUpdate", MapsKt.mapOf(new Pair[]{TuplesKt.to("incoming_data", r101), TuplesKt.to(BaseSlice.KEY_SLICE_ID, r100), TuplesKt.to("slice_id_list", null), TuplesKt.to("pdp_all_slice", r102)}));
        }
    }

    static {
        new a();
    }

    public c0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L14;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f477248a, r101.f477248a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477249b, r101.f477249b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477250c, r101.f477250c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477251d, r101.f477251d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f477248a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f477249b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f477250c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r110 = this.f477251d;
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
        return "PDPSliceUpdateAction(sliceId=" + this.f477248a + ", sliceIdList=" + this.f477249b + ", incomingData=" + this.f477250c + ", componentVOS=" + this.f477251d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(String r100, List<String> r101, Map<String, ? extends Object> r102, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r103) {
        this.f477248a = r100;
        this.f477249b = r101;
        this.f477250c = r102;
        this.f477251d = r103;
    }
}
