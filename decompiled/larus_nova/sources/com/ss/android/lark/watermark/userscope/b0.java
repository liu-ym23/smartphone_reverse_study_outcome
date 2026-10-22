package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0<T> f445420a = null;

    static {
        f445420a = new b0();
    }

    public b0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("watermarkV3", "fetchFallbackV2 fetch fallback watermark error");
        ToolsV3Kt.b("scs_watermark_refactor", MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "fetch_guaranteed"), TuplesKt.to("error_msg", String.valueOf(((Throwable) r100).getMessage()))}), null, null, 1);
    }
}
