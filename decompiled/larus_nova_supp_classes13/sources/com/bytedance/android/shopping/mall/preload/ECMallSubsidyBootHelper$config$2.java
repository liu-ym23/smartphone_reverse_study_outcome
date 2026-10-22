package com.bytedance.android.shopping.mall.preload;

import com.bytedance.android.ec.core.hybrid.model.TabKitDeeplinkPrefetchConfig;
import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ec/core/hybrid/model/TabKitDeeplinkPrefetchConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallSubsidyBootHelper$config$2 extends Lambda implements Function0<TabKitDeeplinkPrefetchConfig> {
    public static final ECMallSubsidyBootHelper$config$2 INSTANCE = null;

    static {
        INSTANCE = new ECMallSubsidyBootHelper$config$2();
    }

    public ECMallSubsidyBootHelper$config$2() {
        super(0);
    }

    public final TabKitDeeplinkPrefetchConfig invoke() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JsonObject r1 = hk3.a.c();     // Catch: Throwable -> L4
        int r2 = t0.a;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl((TabKitDeeplinkPrefetchConfig) t0.a.a.fromJson(r1, TabKitDeeplinkPrefetchConfig.class));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L9;
        r3 = null;
    L9:
        TabKitDeeplinkPrefetchConfig r4 = (TabKitDeeplinkPrefetchConfig) r3;
        if (r4 == null) goto L12;
        return r4;
    L12:
        return new TabKitDeeplinkPrefetchConfig(false, false, null, null, 15, null);
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1493invoke() {
        return invoke();
    }
}
