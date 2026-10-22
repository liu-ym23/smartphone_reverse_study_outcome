package com.bytedance.android.shopping.hybrid.bridges;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ ECOpenVideoPreviewPanelMethod a;

    public g(ECOpenVideoPreviewPanelMethod r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        ECOpenVideoPreviewPanelMethod.e(this.a, -1, "发布失败", 4);
        ECExceptionMonitor.e((Throwable) r5);
    }
}
