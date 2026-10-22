package ji3;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public boolean a;
    public final Handler b;
    public final j c;
    public final ArrayList<a> d;
    public final long e;

    public interface a {
        void onTick();
    }

    public i() {
        this(0);
    }

    public i(int r3) {
        this.e = 1000;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new j(this);
        this.d = new ArrayList();
    }

    public final void a(long r3) {
        if (this.a == true) goto L6;
        return;
    L6:
        if (this.d.isEmpty() == false) goto L8;
        return;
    L8:
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, r3);
    }
}
