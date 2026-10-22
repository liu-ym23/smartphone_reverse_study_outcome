package n57;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageQueue.IdleHandler f518041a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        String r100 = this.f518041a.getClass().getName();
        a.a(">>>>> Dispatching to IdleTask ".concat(r100));
        System.currentTimeMillis();
        this.f518041a.queueIdle();
        a.a("<<<<< Finished to IdleTask ".concat(r100));
        if (b.f518040a == null) goto L5;
    L14:
        b.f518040a.getClass();
        System.currentTimeMillis();
        throw null;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.f518040a != null) goto L9;
        b.f518040a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }

    public c(MessageQueue.IdleHandler r100) {
        this.f518041a = r100;
    }
}
