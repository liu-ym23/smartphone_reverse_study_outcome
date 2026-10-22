package l7a;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f507878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f507879b;

    public final boolean a() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f507878a == false) goto L10;
        LLog.e("LynxResourceLoader", "Illegal callback invocation from native. The loaded callback can only be invoked once! The url is " + this.f507879b);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return false;
    L10:
        this.f507878a = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return true;
    }

    public c(String r100) {
        this.f507878a = false;
        this.f507879b = r100;
    }
}
