package com.larus.platform.service;

import com.larus.platform.api.SdkCalendarErrorCode;
import com.larus.platform.api.a5;
import com.larus.platform.api.b5;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class y implements com.larus.platform.api.v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f365859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365860b = null;

    public y() {
    }

    static {
        f365859a = new y();
        f365860b = LazyKt.lazy(new x());
    }

    @Override // com.larus.platform.api.v1
    public final b5 a(a5 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.platform.api.v1 r101 = (com.larus.platform.api.v1) f365860b.getValue();
        if (r101 == null) goto L7;
        b5 r102 = r101.a(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new b5("calendar service is null", SdkCalendarErrorCode.Unknown);
    }

    @Override // com.larus.platform.api.v1
    public final b5 remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
        com.larus.platform.api.v1 r101 = (com.larus.platform.api.v1) f365860b.getValue();
        if (r101 == null) goto L7;
        b5 r102 = r101.remove(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new b5("calendar service is null", SdkCalendarErrorCode.Unknown);
    }
}
