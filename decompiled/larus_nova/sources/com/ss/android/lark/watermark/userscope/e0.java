package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.watermark.dto.WatermarkData;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes38.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<WatermarkData, Unit> f445433a;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(Function1<? super WatermarkData, Unit> r100) {
        this.f445433a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1<WatermarkData, Unit> r101 = this.f445433a;
        r101.invoke((WatermarkData) r100);
    }
}
