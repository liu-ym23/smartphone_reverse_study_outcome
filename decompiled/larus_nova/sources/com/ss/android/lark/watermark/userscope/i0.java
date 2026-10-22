package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.watermark.dto.WatermarkData;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0<T, R> f445447a = null;

    static {
        f445447a = new i0();
    }

    public i0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        Log.e("watermarkV3", "fetch file watermark error: " + r101.getMessage());
        return WatermarkData.Companion.getEMPTY();
    }
}
