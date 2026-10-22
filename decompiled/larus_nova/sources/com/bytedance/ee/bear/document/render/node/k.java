package com.bytedance.ee.bear.document.render.node;

import android.webkit.ValueCallback;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f221343a;

    public k(DocumentLoaderV3 r100) {
        this.f221343a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        final String r101 = (String) r100;
        tt5.a.h("RenderClientVarNode", this.f221343a.f() + "***reportOpenDoc*** ValueCallback value: " + r101);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.bitable.base.disable.performance_log") == true) goto L6;
        this.f221343a.c(new RenderClientVarNode$onCallJsRender$2$1(r101));
        return;
    }
}
