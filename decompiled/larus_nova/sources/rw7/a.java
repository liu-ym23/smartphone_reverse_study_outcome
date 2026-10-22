package rw7;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import exc.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f539725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f539726d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f539727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HonorAccount f539728b;

    static {
        f539726d = new Object();
    }

    public a(Context r100) {
        new HashMap();
        this.f539727a = r100;
    }

    public static a a(Context r100) {
        Object r101 = f539726d;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f539725c != null) goto L7;
        f539725c = new a(r100.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        a r102 = f539725c;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    }

    public final void b(HonorAccount r100) {
        e.c("HnIDMemCache", "saveHnAccountToCache");
        if (ow7.a.b(r100) == false) goto L5;
        this.f539728b = r100;
        return;
    L5:
        e.b("HnIDMemCache", "save honorAccount is null");
        this.f539728b = null;
    }
}
