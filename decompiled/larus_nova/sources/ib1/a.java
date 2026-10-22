package ib1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements IHostPlugin.Callback {
    public a() {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onCancel(String r100) {
        ALogger.e("IESVideClipLibPluginManager", "install canceled");
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onSuccess(String r100) {
        ALogger.i("IESVideClipLibPluginManager", "install success, thread=" + ThreadMethodProxy.currentThread().getName());
        if (NewPluginType.IESVideoClipLibPlugin.load() == false) goto L5;
        ALogger.i("IESVideClipLibPluginManager", "load success");
        b.a();
        b.b();
        b.c();
        return;
    L5:
        ALogger.e("IESVideClipLibPluginManager", "load fail");
    }
}
