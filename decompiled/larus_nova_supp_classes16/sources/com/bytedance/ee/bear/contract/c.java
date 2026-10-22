package com.bytedance.ee.bear.contract;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c implements b {
    public final Handler a;

    public class a implements Runnable {
        public final /* synthetic */ AccountService$Account a;
        public final /* synthetic */ c b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.b(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r1, AccountService$Account r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public abstract void b(AccountService$Account r1);

    public c() {
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.ee.bear.contract.b
    public final void a(AccountService$Account r3) {
        this.a.post(new a(this, r3));
    }
}
