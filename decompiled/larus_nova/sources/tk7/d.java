package tk7;

import android.app.Activity;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements uo7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f546558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f546559b;

    public static final class a {
    }

    static {
    }

    @Override // uo7.a
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // uo7.a
    public final void onEnterActivityBackground(Activity r100) {
    }

    @Override // uo7.a
    public final void onEnterActivityForeground(Activity r100) {
    }

    @Override // uo7.b
    public final void onEnterForeground(Activity r100) {
    }

    public d() {
        this.f546558a = 1;
        this.f546559b = System.currentTimeMillis();
    }

    @Override // uo7.b
    public final void onEnterBackground(Activity r100) {
        if ((System.currentTimeMillis() - this.f546559b) <= 2000) goto L6;
        this.f546558a = 2;
        return;
    }
}
