package vq0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class c extends a {
    public c(MiniAppContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniAppContext");
        super(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public Bundle onEvent(Bundle r100) {
        this.f556755a.notifyMiniAppLifecycleChange(OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnStop);
        this.f556755a.tryClearMiniAppInstance(MiniAppContext.StopType.ON_MINI_APP_STOP);
        return null;
    }
}
