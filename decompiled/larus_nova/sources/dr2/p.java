package dr2;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.IHostApp;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements com.bytedance.android.scope.o, c {
    public p() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.c
    public final long getAppStorageByMB() {
        return ((IHostApp) jc1.k.n(IHostApp.class)).getAppStorageByMB();
    }

    @Override // dr2.c
    public final String getSessionId() {
        return ((IHostApp) jc1.k.n(IHostApp.class)).getSessionId();
    }

    @Override // dr2.c
    public final long getTotalStorageByMB() {
        return ((IHostApp) jc1.k.n(IHostApp.class)).getTotalStorageByMB();
    }

    @Override // dr2.c
    public final void Sd(Activity r100) {
        ((IHostApp) jc1.k.n(IHostApp.class)).startBindMobileFullFragment(r100, "", "", new n());
    }

    @Override // dr2.c
    public final void B6(Activity r100, Bundle r101) {
        ((IHostApp) jc1.k.n(IHostApp.class)).startBindSafeMobileFullFragment(r100, "", "", r101, new o());
    }
}
