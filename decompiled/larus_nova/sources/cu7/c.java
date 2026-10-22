package cu7;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f465433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ScheduledExecutorService f465434b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<d> f465435c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f465436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f465437e = null;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [cu7.b] */
    static {
        f465433a = new c();
        f465434b = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new a());
        f465435c = new ArrayList();
        f465437e = new b();
    }

    private final Context getContext() {
        return AppHost.f326268a.getApplication();
    }

    public final synchronized void a(boolean r100, long r101) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f465436d == true) goto L10;
        if (r100 == false) goto L10;
        f465436d = true;     // Catch: Throwable -> L12
        f465434b.scheduleAtFixedRate(f465437e, r101, r101, TimeUnit.SECONDS);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
    }
}
