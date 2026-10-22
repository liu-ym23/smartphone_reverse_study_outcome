package sg1;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.r2;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePlayerClient f541766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f541767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RunnableC7606a f541768c;

    /* JADX INFO: renamed from: sg1.a$a, reason: collision with other inner class name */
    public class RunnableC7606a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f541769a;

        @Override // java.lang.Runnable
        public final void run() {
            ILivePlayerClient r100 = this.f541769a.f541766a;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isSrUsed() == false) goto L16;
            this.f541769a.f541766a.setDsr(false);     // Catch: Throwable -> L9
            this.f541769a.f541767b = true;     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public RunnableC7606a(a r100) {
            this.f541769a = r100;
        }
    }

    public a() {
        this.f541767b = false;
        this.f541768c = new RunnableC7606a(this);
    }

    public final void a(boolean r100) {
        i0.c().removeCallbacks(this.f541768c);
        if (this.f541766a != null) goto L5;
    L10:
        this.f541767b = false;
        this.f541766a = null;
        return;
    L5:
        if (this.f541767b == false) goto L10;
        if (r100 == false) goto L10;
        if (r2.f121099a.getValue().mExitRestore == false) goto L10;
        this.f541766a.setDsr(true);
        goto L10
    }
}
