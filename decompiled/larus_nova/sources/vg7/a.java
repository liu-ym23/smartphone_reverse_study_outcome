package vg7;

import com.bytedance.timon.foundation.impl.LocalTimonLogger;
import com.bytedance.timon.foundation.interfaces.IAppLog;
import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import com.bytedance.timon.foundation.interfaces.IExceptionMonitor;
import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILogger f554734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IStore f554735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IAppLog f554736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IEventMonitor f554737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IExceptionMonitor f554738e;

    static {
        new LocalTimonLogger();
    }

    public static IExceptionMonitor a() {
        IExceptionMonitor r100 = f554738e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        IExceptionMonitor r101 = (IExceptionMonitor) ServiceManager.get().getService(IExceptionMonitor.class);
        f554738e = r101;
        return r101;
    }

    public static IStore b() {
        IStore r100 = f554735b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        IStore r101 = (IStore) ServiceManager.get().getService(IStore.class);
        f554735b = r101;
        return r101;
    }

    public static ILogger c() {
        ILogger r100 = f554734a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ILogger r101 = (ILogger) ServiceManager.get().getService(ILogger.class);
        f554734a = r101;
        return r101;
    }
}
