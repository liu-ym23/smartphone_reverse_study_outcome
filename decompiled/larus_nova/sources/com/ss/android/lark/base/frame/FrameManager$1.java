package com.ss.android.lark.base.frame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
class FrameManager$1 implements IGetDataCallback<Bundle> {
    final /* synthetic */ a this$0;
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ b val$lastShowPage;
    final /* synthetic */ b val$nextShowPage;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.e("routePage", r100.toString());
        throw null;
    }

    public void onSuccess(Bundle r100) {
        if (r100 == null) goto L5;
        this.val$intent.putExtras(r100);
        Log.i("FrameManager", "routePage needRedirect: " + r100.getBoolean("key_need_redirect", true));
    L5:
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Bundle) r100);
    }

    public FrameManager$1(a r100, Intent r101, b r102, Activity r103, b r104) {
        this.val$intent = r101;
        this.val$nextShowPage = r102;
        this.val$activity = r103;
        this.val$lastShowPage = r104;
    }
}
