package qb4;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile s f532382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f532383e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f532384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Activity> f532385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f532386c;

    public static s b() {
        if (f532382d != null) goto L15;
        monitor-enter(s.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f532382d != null) goto L9;
        f532382d = new s();     // Catch: Throwable -> L11
    L9:
        monitor-exit(s.class);     // Catch: Throwable -> L11
    L15:
        return f532382d;
    }

    public s() {
        this.f532386c = new Object();
    }

    public static Application a(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if ((r100 instanceof Application) == false) goto L8;
        return (Application) r100;
    L8:
        if ((r100 instanceof Activity) == false) goto L12;
        return ((Activity) r100).getApplication();
    L12:
        if ((r100 instanceof ContextWrapper) == true) goto L14;
        return null;
    L14:
        return a(((ContextWrapper) r100).getBaseContext());
    }
}
