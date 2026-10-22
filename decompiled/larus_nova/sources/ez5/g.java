package ez5;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f474885a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f474886a = null;

        static {
            f474886a = new g();
        }
    }

    public g() {
    }

    public final synchronized void b(Context r100) {
        monitor-enter(this);
        if (r100 != null) goto L13;
    L11:
        monitor-exit(this);
        return;
    L13:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f474885a != null) goto L11;
        this.f474885a = r100.getSharedPreferences("sp_gecko", 0);     // Catch: Throwable -> L8
        goto L11
    }

    public void delete(Context r100, String r101) {
        b(r100);
        SharedPreferences r102 = this.f474885a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.edit().remove(r101).apply();
    }

    public final String a(Context r100, String r101, String r102) {
        b(r100);
        SharedPreferences r103 = this.f474885a;
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.getString(r101, r102);
    }

    public final void c(Context r100, String r101, String r102) {
        b(r100);
        SharedPreferences r103 = this.f474885a;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.edit().putString(r101, r102).apply();
    }
}
