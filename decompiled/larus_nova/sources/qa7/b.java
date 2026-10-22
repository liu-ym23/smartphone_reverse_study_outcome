package qa7;

/* JADX INFO: loaded from: classes19.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f532269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f532270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f532271c;

    public interface a {
        void onCancel();
    }

    public void a() {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.f532269a == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L7:
        this.f532269a = true;     // Catch: Throwable -> L28
        this.f532271c = true;     // Catch: Throwable -> L28
        a r100 = this.f532270b;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r100 != null) goto L31;
    L21:
        monitor-enter(this);
        this.f532271c = false;     // Catch: Throwable -> L25
        notifyAll();     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L31:
        r100.onCancel();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        monitor-enter(this);
        this.f532271c = false;     // Catch: Throwable -> L18
        notifyAll();     // Catch: Throwable -> L18
        throw th;
    L18:
        th = move-exception;
        throw th;
    }

    public b() {
    }

    public final void b(a r100) {
        monitor-enter(this);
    L24:
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f532271c == false) goto L8;
        wait();     // Catch: InterruptedException -> L21 Throwable -> L18
        goto L24
    L8:
        if (this.f532270b != r100) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L11:
        this.f532270b = r100;     // Catch: Throwable -> L18
        if (this.f532269a == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L18
        r100.onCancel();
        return;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
    }
}
