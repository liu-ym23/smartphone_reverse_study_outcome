package lx3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends Handler {
    public final /* synthetic */ f a;

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        super.handleMessage(r5);
        boolean r1 = true;
        if (r5.what != 1) goto L21;
        k r0 = this.a.e;
        if (r0 == null) goto L19;
        Object r6 = r5.obj;
        if ((r6 instanceof String) == false) goto L19;
        String r7 = (String) r6;
        boolean r2 = Objects.equals(r7, r0.b);
        f r3 = this.a;
        if (r3.c == true) goto L12;
    L14:
        r1 = false;
    L15:
        if (r2 == false) goto L19;
        if (r1 == false) goto L19;
        k r4 = this.a.e;
        r4.h = System.currentTimeMillis();
        f r8 = this.a;
        r8.g.d(r8.e);
        f.a(this.a, r7);
        this.a.getClass();
        return;
    L12:
        if (r3.b == false) goto L14;
    L19:
        this.a.g.a();
        this.a.getClass();
        return;
    }

    public e(f r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
