package wt3;

import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends vt3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f561200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f561201c;

    public class a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ vt3.d f561202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f561203e;

        @Override // java.lang.Runnable
        public final void run() {
            this.f561203e.e("cool down task run, is back?: " + this.f561203e.f561201c);     // Catch: Throwable -> L10
            vt3.d r100 = this.f561202d;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            r100.a(r100.f557212l);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public a(c r100, long r101, vt3.d r102) {
            this.f561203e = r100;
            this.f561202d = r102;
            super(r101, 0);
        }
    }

    @Override // vt3.a, vt3.f
    public final void c() {
        super.c();
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f561200b);
    }

    @Override // vt3.f
    public final StateType b() {
        return StateType.COOL_DOWN;
    }

    public c(vt3.d r100) {
        super(r100);
        this.f561201c = false;
        if (this.f561201c == false) goto L5;
        long r101 = 1200000;
    L6:
        this.f561200b = new a(this, r101, r100);
        return;
    L5:
        r101 = 120000;
        goto L6
    }

    @Override // vt3.a, vt3.f
    public final void a(boolean r100) {
        super.a(r100);
        this.f561201c = r100;
    }

    @Override // vt3.a, vt3.f
    public final void d(ut3.c r100, boolean r101) {
        super.d(r100, r101);
        a r102 = this.f561200b;
        if (r102 != null) goto L5;
    L9:
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f561200b);
        return;
    L5:
        if (this.f561201c == false) goto L7;
        long r103 = 1200000;
    L8:
        r102.f465483a = r103;
        r102.f465485c = 0;
        goto L9
    L7:
        r103 = 120000;
        goto L8
    }
}
