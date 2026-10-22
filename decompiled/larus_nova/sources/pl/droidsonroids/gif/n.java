package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class n extends o {
    @Override // pl.droidsonroids.gif.o
    public final void a() {
        d r100 = this.f529747a;
        long r101 = r100.f529714g.t(r100.f529713f);
        if (r101 < 0) goto L22;
        this.f529747a.f529710c = SystemClock.uptimeMillis() + r101;
        if (this.f529747a.isVisible() == false) goto L12;
        if (this.f529747a.f529709b == false) goto L12;
        d r102 = this.f529747a;
        if (r102.f529719l == true) goto L12;
        r102.f529708a.remove(this);
        d r103 = this.f529747a;
        r103.f529723p = r103.f529708a.schedule(this, r101, TimeUnit.MILLISECONDS);
    L12:
        if (this.f529747a.f529715h.isEmpty() == true) goto L24;
        if (this.f529747a.f529714g.c() != (this.f529747a.f529714g.k() - 1)) goto L24;
        d r104 = this.f529747a;
        k r105 = r104.f529720m;
        int r106 = r104.f529714g.d();
        if (r106 != 0) goto L18;
    L21:
        r105.sendEmptyMessageAtTime(r106, this.f529747a.f529710c);
        goto L24
    L18:
        if (r106 < r104.f529714g.h()) goto L21;
        r106 = r106 - 1;
    L24:
        if (this.f529747a.isVisible() == true) goto L26;
        return;
    L26:
        if (this.f529747a.f529720m.hasMessages(-1) == true) goto L30;
        this.f529747a.f529720m.sendEmptyMessageAtTime(-1, 0);
        return;
    L30:
        return;
    L22:
        d r107 = this.f529747a;
        r107.f529710c = Long.MIN_VALUE;
        r107.f529709b = false;
        goto L24
    }

    public n(d r100) {
        super(r100);
    }
}
