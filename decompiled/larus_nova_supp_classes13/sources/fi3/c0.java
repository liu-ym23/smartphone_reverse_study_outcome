package fi3;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final List<String> b;
    public final Map<String, Object> c;
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> d;

    public static final class a {
        public a() {
        }

        public static SlcCommonAction a(String r3, Map r4, List r5, int r6) {
            int r0 = c0.e;
            if ((r6 & 8) == 0) goto L5;
            r5 = null;
        L5:
            Intrinsics.checkNotNullParameter(r4, "incomingData");
            return new SlcCommonAction("PDPSliceUpdate", MapsKt.mapOf(new Pair[]{TuplesKt.to("incoming_data", r4), TuplesKt.to("slice_id", r3), TuplesKt.to("slice_id_list", null), TuplesKt.to("pdp_all_slice", r5)}));
        }
    }

    static {
        new a();
    }

    public c0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c0) == false) goto L14;
        c0 r4 = (c0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "PDPSliceUpdateAction(sliceId=" + this.a + ", sliceIdList=" + this.b + ", incomingData=" + this.c + ", componentVOS=" + this.d + ")";
    }

    public c0(String r1, List<String> r2, Map<String, ? extends Object> r3, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
