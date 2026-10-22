package com.ss.android.lark.larkconfig.userconfig;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
class ABVersionCacheManager$1 implements IGetDataCallback<Map<String, String>> {
    final /* synthetic */ a this$0;
    final /* synthetic */ f.a val$initCallback;

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(Map<String, String> r100) {
        ((ConcurrentHashMap) this.this$0.f431151a).putAll(r100);
        throw null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Map) r100);
    }

    public ABVersionCacheManager$1(a r100, f.a r101) {
        this.this$0 = r100;
    }
}
