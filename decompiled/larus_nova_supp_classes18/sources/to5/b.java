package to5;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b {
    public long a;
    public long b;
    public boolean c;

    public final void a() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.b = SystemClock.elapsedRealtime();
        this.c = true;
    }

    public b() {
        SystemClock.elapsedRealtime();
    }
}
