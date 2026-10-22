package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.lark.dependency.IMiraDependency;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.mira.UIGetPluginCallback;

/* JADX INFO: loaded from: classes36.dex */
class MiraDependencyImpl$1 extends UIGetPluginCallback<Object> {
    final /* synthetic */ l0 this$0;
    final /* synthetic */ IMiraDependency.UIGetPluginCallback val$uiGetPluginCallback;

    @Override // com.ss.android.lark.mira.UIGetPluginCallback
    public void onPluginLoading() {
        tt5.a.h("MiraDependencyImpl", "onPluginLoading()...");
        IMiraDependency.UIGetPluginCallback r100 = this.val$uiGetPluginCallback;
        if (r100 == null) goto L6;
        r100.onPluginLoading();
        return;
    }

    @Override // com.larksuite.framework.callback.UIGetDataCallback
    public void onErrored(ErrorResult r100) {
        super.onErrored(r100);
        tt5.a.h("MiraDependencyImpl", "onErrored()...error = " + r100);
        IMiraDependency.UIGetPluginCallback r101 = this.val$uiGetPluginCallback;
        if (r101 == null) goto L6;
        r101.onErrored(r100);
        return;
    }

    @Override // com.larksuite.framework.callback.UIGetDataCallback
    public void onSuccessed(Object r100) {
        super.onSuccessed(r100);
        tt5.a.h("MiraDependencyImpl", "onSuccessed()...plugin = " + r100);
        IMiraDependency.UIGetPluginCallback r101 = this.val$uiGetPluginCallback;
        if (r101 == null) goto L6;
        r101.onSuccessed(r100);
        return;
    }

    public MiraDependencyImpl$1(l0 r100, IMiraDependency.UIGetPluginCallback r101) {
        this.this$0 = r100;
        this.val$uiGetPluginCallback = r101;
    }
}
