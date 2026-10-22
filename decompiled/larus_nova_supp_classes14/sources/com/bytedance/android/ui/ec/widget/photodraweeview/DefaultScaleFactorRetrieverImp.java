package com.bytedance.android.ui.ec.widget.photodraweeview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/DefaultScaleFactorRetrieverImp;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "zc", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;)V", "nextFactor", "", "currentFactor", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultScaleFactorRetrieverImp implements ScaleFactorRetriever {
    private final ZoomableControllerImp zc;

    public DefaultScaleFactorRetrieverImp(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zc");
        this.zc = r2;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ScaleFactorRetriever
    public float nextFactor(float r5) {
        float r0 = this.zc.getMaxScaleFactor();
        float r1 = this.zc.getMinScaleFactor();
        if (r5 >= ((r0 + r1) / 2)) goto L6;
        return r0;
    L6:
        return r1;
    }
}
