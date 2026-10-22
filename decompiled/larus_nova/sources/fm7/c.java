package fm7;

import android.app.Activity;
import zm7.h;
import zm7.j;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends uo7.c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f477829a;

    @Override // zm7.h
    public final boolean b() {
        return !this.f477829a;
    }

    public c() {
        to7.c.d(this);
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        super.onEnterBackground(r100);
        this.f477829a = true;
        j r101 = (j) wm7.g.a(j.class);
        if (r101 == null) goto L6;
        r101.e("background");
        return;
    }

    @Override // uo7.c, uo7.b
    public final void onEnterForeground(Activity r100) {
        super.onEnterForeground(r100);
        this.f477829a = false;
        j r101 = (j) wm7.g.a(j.class);
        if (r101 == null) goto L6;
        r101.c("background");
        return;
    }
}
