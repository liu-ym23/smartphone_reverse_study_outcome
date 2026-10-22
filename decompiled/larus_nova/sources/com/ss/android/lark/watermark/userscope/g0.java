package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.watermark.dto.WatermarkData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0<T> f445441a = null;

    static {
        f445441a = new g0();
    }

    public g0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        WatermarkData r101 = (WatermarkData) r100;
        StringBuilder r102 = new StringBuilder("fetch file bright and dark watermark data success, data is: ");
        if (r101 == null) goto L5;
        String r103 = r101.getInfo();
    L6:
        r102.append(r103);
        Log.i("watermarkV3", r102.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }
}
