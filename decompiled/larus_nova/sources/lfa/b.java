package lfa;

import android.os.IBinder;
import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f509098a;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        ILogDepend.f384986a.w("CaeMultipathClient", "Service binder died, reconnecting...");
        c r100 = this.f509098a;
        r100.f509100a = null;
        r100.f509102c.sendEmptyMessage(1);
    }

    public b(c r100) {
        this.f509098a = r100;
    }
}
