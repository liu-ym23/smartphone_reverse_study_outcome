package ak2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public final long a;
    public final Object b;

    public final void b() {
        Object r0 = this.b;
        if ((r0 instanceof fe.c) == false) goto L6;
        ((fe.c) r0).release();
        return;
    L6:
        if ((r0 instanceof vlc.d) == false) goto L10;
        ((vlc.d) r0).release();
        return;
    }

    public final void c() {
        Object r0 = this.b;
        if ((r0 instanceof fe.c) == false) goto L6;
        ((fe.c) r0).startMessage();
        return;
    L6:
        if ((r0 instanceof vlc.d) == false) goto L10;
        ((vlc.d) r0).startMessage();
        return;
    }

    public final void a(com.bytedance.android.livesdk.livecommerce.messagev2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.b;
        if ((r0 instanceof fe.c) == false) goto L6;
        ((fe.c) r0).a();
        return;
    L6:
        if ((r0 instanceof vlc.d) == false) goto L10;
        ((vlc.d) r0).addMessageListener(1003, new k(this, r3));
        return;
    }

    public l(long r1, vlc.d r3) {
        this.a = r1;
        this.b = r3;
    }
}
