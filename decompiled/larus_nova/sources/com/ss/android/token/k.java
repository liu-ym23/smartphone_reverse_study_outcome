package com.ss.android.token;

import com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements TicketGuardBootFinishManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f449762a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f449763a;

        public a(k r100) {
            this.f449763a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SecTimeUpdater.a(SecTimeUpdater.f449642k, this.f449763a.f449762a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager.a
    public final void a() {
        SecTimeUpdater.f449641j.set(false);
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime,scene: " + this.f449762a + ", boot finish, update");
        SecTimeUpdater.f449640i.submit(new a(this));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        tb7.a.f("SecTimeUpdater", "onBootFinish: task rejected", e);
    }

    public k(String r100) {
        this.f449762a = r100;
    }
}
