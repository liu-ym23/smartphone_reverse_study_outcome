package com.ss.android.lark.watermark.userscope;

import androidx.lifecycle.Observer;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/ss/android/lark/watermark/userscope/WatermarkImplV3$generateDefaultDrawable$observer$1", "Landroidx/lifecycle/Observer;", "Lcom/ss/android/lark/watermark/v2/WatermarkState;", "onChanged", "", "state", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkImplV3$generateDefaultDrawable$observer$1 implements Observer<com.ss.android.lark.watermark.v2.v> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(com.ss.android.lark.watermark.v2.v r100) {
        com.ss.android.lark.watermark.v2.v r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.watermark_thread_opt_disabled.android") == true) goto L6;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new p(r101, this));
        return;
    L6:
        Log.i("watermarkV3", "fg watermark_thread_opt_disabled is enabled");
        new com.ss.android.lark.watermark.v2.u(r101, null);
        throw null;
    }
}
