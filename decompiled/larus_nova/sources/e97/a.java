package e97;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f471512g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d97.d f471513f;

    /* JADX INFO: renamed from: e97.a$a, reason: collision with other inner class name */
    public class RunnableC5758a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d97.d f471514a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f471514a.f467633c.f22892l = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC5758a(d97.d r100) {
            this.f471514a = r100;
        }
    }

    public a(d97.d r100, String r101) {
        super(r100.f467634d.f467629b, "auto_fail_sync", 3, r101, new RunnableC5758a(r100));
        this.f471513f = r100;
    }
}
