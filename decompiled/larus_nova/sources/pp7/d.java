package pp7;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicInteger;
import qp7.i;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocalServerSocket f530216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f530217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f530218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final op7.b f530219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qp7.b f530220e;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final LocalSocket f530221v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ d f530222w;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            b r100 = new b(this.f530221v.getInputStream());     // Catch: Throwable -> L4 Exception -> L6
            e r101 = new e(this.f530221v, r100);     // Catch: Throwable -> L4 Exception -> L6
            this.f530222w.f530218c.a(r101);     // Catch: Throwable -> L4 Exception -> L6
        L16:
            return;
        L6:
            e = move-exception;
            e.getMessage();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public a(d r100, LocalSocket r101) {
            this.f530222w = r100;
            super("LocalSocketServer$WorkerThread");
            this.f530221v = r101;
        }
    }

    public final i a() {
        op7.b r100 = this.f530219d;
        qp7.b r101 = this.f530220e;
        r100.getClass();
        r101.a(new qp7.a("/json"), r100);
        r101.a(new qp7.a("/json/version"), r100);
        r101.a(new qp7.a("/json/list"), r100);
        return new i(this.f530220e);
    }

    public d() {
        this.f530217b = new AtomicInteger();
        this.f530220e = new qp7.b();
        this.f530219d = new op7.b();
    }
}
