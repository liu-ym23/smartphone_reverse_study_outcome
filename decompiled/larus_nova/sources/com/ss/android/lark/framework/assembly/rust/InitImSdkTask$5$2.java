package com.ss.android.lark.framework.assembly.rust;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
class InitImSdkTask$5$2 implements IGetDataCallback<Boolean> {
    final /* synthetic */ h this$1;
    final /* synthetic */ dzb.d val$callback;
    final /* synthetic */ boolean val$changed;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.i("InitImSdkTask", "onLoginEnvChanged failed changed = " + this.val$changed + "; userUnit=" + this.this$1.f425699a.j().getUserUnit(), null);
    }

    public void onSuccess(Boolean r100) {
        this.this$1.f425699a.f425675i.get().setAppLogUriRuntime();
        Log.i("InitImSdkTask", "setEnv end, onLoginEnvChanged success changed = " + this.val$changed + "; userUnit=" + this.this$1.f425699a.j().getUserUnit(), null);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }

    public InitImSdkTask$5$2(h r100, boolean r101, dzb.d r102) {
        this.this$1 = r100;
        this.val$changed = r101;
    }
}
