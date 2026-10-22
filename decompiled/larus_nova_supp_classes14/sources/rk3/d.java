package rk3;

import com.bytedance.android.shopping.store.tabkit.TabKitHybridTabFragment;
import com.bytedance.android.shopping.store.tabkit.view.TabKitMainContainerView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ TabKitMainContainerView a;

    public d(TabKitMainContainerView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference<TabKitHybridTabFragment> r0 = this.a.g;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        TabKitHybridTabFragment r1 = r0.get();     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.retrieveWebView();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
