package ls0;

import com.bytedance.android.live.portrait.PortraitShareAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitShareAdapter f510492a;

    public b(PortraitShareAdapter r100) {
        this.f510492a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f510492a.notifyDataSetChanged();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
