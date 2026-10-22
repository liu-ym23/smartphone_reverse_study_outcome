package dr2;

import com.bytedance.android.livehostapi.platform.IHostWebView;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class c0 implements com.bytedance.android.scope.o, k {
    public c0() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.k
    public final Map<String, String> getHeaderMap(String r100) {
        return ((IHostWebView) jc1.k.n(IHostWebView.class)).getHeaderMap(r100);
    }
}
