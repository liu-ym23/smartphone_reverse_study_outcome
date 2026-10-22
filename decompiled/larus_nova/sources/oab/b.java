package oab;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public abstract class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f522587a;

    public abstract void a(View r100);

    public b() {
        this.f522587a = 0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f522587a) <= 1000) goto L6;
        a(r100);
        this.f522587a = r101;
        return;
    }
}
