package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.watermark.dto.WatermarkData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class o0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0<T> f445479a = null;

    static {
        f445479a = new o0();
    }

    public o0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        WatermarkData r101 = (WatermarkData) r100;
        StringBuilder r102 = new StringBuilder("push file data success, data is ");
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
