package kqb;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f505661a;

    public abstract void a();

    public a() {
        this.f505661a = 0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f505661a) <= 1000) goto L6;
        a();
        this.f505661a = r101;
        return;
    }
}
