package dr2;

import com.bytedance.android.livehostapi.business.IHostFeed;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class q implements com.bytedance.android.scope.o, d {
    public q() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.d
    public final Map<String, Object> getFeedTab(long r100) {
        return ((IHostFeed) jc1.k.n(IHostFeed.class)).getFeedTab(r100);
    }
}
