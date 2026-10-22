package com.ss.android.lark.watermark.userscope;

import com.bytedance.lark.pb.passport.v1.GetGuaranteedWaterMarkConfigResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.watermark.dto.WatermarkData;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0<T, R> f445418a = null;

    static {
        f445418a = new a0();
    }

    public a0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        com.bytedance.lark.rustclient.api.x r100 = (com.bytedance.lark.rustclient.api.x) r110;
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = ((GetGuaranteedWaterMarkConfigResponse) r100.f253935c).content;
        ToolsV3Kt.c("scs_watermark_refactor", MapsKt.mapOf(TuplesKt.to("event", "fetch_guaranteed")), 0, 12);
        Log.i("watermarkV3", "fetchFallbackV2 fallback watermark text is " + r101);
        Intrinsics.checkNotNull(r101);
        return new WatermarkData(false, r101, false, null, 0, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 2040, null);
    }
}
