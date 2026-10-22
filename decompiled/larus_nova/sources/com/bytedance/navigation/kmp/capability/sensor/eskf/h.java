package com.bytedance.navigation.kmp.capability.sensor.eskf;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements bv5.d {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // bv5.d
    public final void onEvent(String r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "data");
        d37.i.f466749a.h("EskfHeading", r110 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + CollectionsKt.joinToString$default(r111.entrySet(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, new g(), 30, null));
    }
}
