package com.bytedance.ee.bear.contract;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f216914a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountService$Account f216915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f216916b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f216916b.b(this.f216915a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, AccountService$Account r101) {
            this.f216916b = r100;
            this.f216915a = r101;
        }
    }

    public abstract void b(AccountService$Account r100);

    public c() {
        this.f216914a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.ee.bear.contract.b
    public final void a(AccountService$Account r100) {
        this.f216914a.post(new a(this, r100));
    }
}
