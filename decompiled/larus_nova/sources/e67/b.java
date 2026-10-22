package e67;

import com.bytedance.privacy.bridge.IEnvBridge;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f471147b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IEnvBridge f471148a;

    public b() {
    }

    public static b a() {
        if (f471147b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f471147b != null) goto L9;
        f471147b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f471147b;
    }

    public final boolean b() {
        IEnvBridge r100 = this.f471148a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.onIsBoeEnv();
    }

    static {
    }
}
