package com.bytedance.ee.bear.document.render.node;

import android.webkit.ValueCallback;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T> implements ValueCallback {
    public final /* synthetic */ e a;

    public k(DocumentLoaderV3 r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r3) {
        final String r4 = (String) r3;
        tt5.a.h("RenderClientVarNode", this.a.f() + "***reportOpenDoc*** ValueCallback value: " + r4);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.bitable.base.disable.performance_log") == true) goto L6;
        this.a.c(new RenderClientVarNode$onCallJsRender$2$1(r4));
        return;
    }
}
