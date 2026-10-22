package y60;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f566319a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f566320a;

        public a(e r100) {
            this.f566320a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a(this.f566320a.f566319a);     // Catch: Throwable -> L4
            return;
        }
    }

    public e(Context r100) {
        this.f566319a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f566319a.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_flags", 0).getBoolean("need_update_for_mini_process", false) == false) goto L9;
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "SpRewriterKt$copySettingsForMiniProcessIfNeed$1"));     // Catch: Throwable -> L6
        return;
    }
}
