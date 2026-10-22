package tqa;

import android.content.Context;
import com.bytedance.common.support.PushCommonSupport;
import com.ss.alive.monitor.services.impl.AssociationStartMonitorEventServiceImpl;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f547231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile rqa.a f547232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile AssociationStartMonitorEventServiceImpl f547233d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f547234a;

    public static b c() {
        if (f547231b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f547231b != null) goto L9;
        f547231b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f547231b;
    }

    public final sqa.a a() {
        if (f547233d != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (f547233d != null) goto L12;
        Context r100 = this.f547234a;     // Catch: Throwable -> L14
        if (r100 != null) goto L11;
        r100 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication;     // Catch: Throwable -> L14
    L11:
        f547233d = new AssociationStartMonitorEventServiceImpl(r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L18:
        return f547233d;
    }

    public a() {
    }

    public final sqa.b b(Context r100) {
        this.f547234a = r100;
        if (f547232c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (f547232c != null) goto L8;
        f547232c = new rqa.a(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return f547232c;
    }
}
