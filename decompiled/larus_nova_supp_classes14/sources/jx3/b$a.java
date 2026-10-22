package jx3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$a extends Handler {
    public final /* synthetic */ b a;

    @Override // android.os.Handler
    public final void handleMessage(Message r3) {
        if (r3.what != 0) goto L7;
        this.a.x(null, true);
        return;
    }

    public b$a(b r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
