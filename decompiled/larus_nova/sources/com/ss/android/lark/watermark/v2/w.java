package com.ss.android.lark.watermark.v2;

import android.graphics.Bitmap;
import com.ss.android.lark.watermark.userscope.ToolsV3Kt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class w extends io.reactivex.observers.d<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WatermarkStateMediatorLiveData f445564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f445565c;

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        ToolsV3Kt.c("scs_watermark_refactor", MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "fetch_image"), TuplesKt.to("error_code", ""), TuplesKt.to("error_msg", r100.getMessage())}), 1, 12);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        this.f445564b.a(v.a(this.f445565c, null, r101, 253));
        ToolsV3Kt.b("scs_watermark_view_load_image", MapsKt.mapOf(TuplesKt.to("is_success", "true")), null, null, 0);
        ToolsV3Kt.c("scs_watermark_refactor", MapsKt.mapOf(TuplesKt.to("event", "fetch_image")), 0, 12);
    }

    public w(WatermarkStateMediatorLiveData r100, v r101) {
        this.f445564b = r100;
        this.f445565c = r101;
    }
}
