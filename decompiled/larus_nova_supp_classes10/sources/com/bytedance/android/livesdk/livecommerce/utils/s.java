package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s {
    public static final void c(final String r1, final EnumEntranceInfoScene r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$reportAPTDiff");
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        com.bytedance.android.ec.sdk.helper.l.a(new ECLiveEntranceInfoHelperKt$reportAPTDiff$1(r1, r2));
    }

    public static final void a(gl.a r2, JSONObject r3, Function2<? super String, ? super String, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r4, "condition");
        if (r3 != null) goto L5;
        return;
    L5:
        Map r5 = z1.j(r3);
        Intrinsics.checkNotNullParameter(r2, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r4, "condition");
        r2.f(MapsKt.toMap(r5), new ECLiveEntranceInfoHelperKt$putStringIf$1(r4));
    }

    public static final void b(gl.a r2, Pair<String, String>[] r3, Function2<? super String, ? super String, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r3, "entranceInfo");
        Intrinsics.checkNotNullParameter(r4, "condition");
        Map r5 = MapsKt.toMap(r3);
        Intrinsics.checkNotNullParameter(r2, "$this$putStringIf");
        Intrinsics.checkNotNullParameter(r4, "condition");
        if (r5 == null) goto L7;
        r2.f(MapsKt.toMap(r5), new ECLiveEntranceInfoHelperKt$putStringIf$1(r4));
        return;
    }

    public static final void d(String r1, EnumEntranceInfoScene r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$reportEntranceInfoDiff");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "inSchema");
        oh.a.c("entrance_info_diff", new r(r1, r2, r3));
    }
}
