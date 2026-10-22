package ut1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.livesdk.drawer.LiveMergeDrawerAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMergeDrawerAdapter f551616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f551617b;

    public p(LiveMergeDrawerAdapter r100, Integer r101) {
        this.f551616a = r100;
        this.f551617b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CenterScrollLayoutManager r100 = this.f551616a.f122361g;     // Catch: Throwable -> L4
        int r101 = this.f551617b.intValue();     // Catch: Throwable -> L4
        LiveMergeDrawerAdapter r102 = this.f551616a;     // Catch: Throwable -> L4
        r100.scrollToPositionWithOffset(r101, (r102.f122359e / 2) - (s1.f(r102.f122358d) / 2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
