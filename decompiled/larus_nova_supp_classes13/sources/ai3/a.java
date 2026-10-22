package ai3;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.ErrorMonitorType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final void a(j33.d r3, ErrorMonitorType r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$reportError");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "desc");
        r3.a("buynow_error_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", r4.getValue()), TuplesKt.to("desc", r5)}));
    }
}
