package f17;

import com.bytedance.lynx.webview.bean.LoadInfo;
import com.bytedance.lynx.webview.bean.LoadType;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<InterfaceC5847a> f475072d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadType f475073c;

    /* JADX INFO: renamed from: f17.a$a, reason: collision with other inner class name */
    public interface InterfaceC5847a {
        void onLoadResultChanged(a r100);
    }

    public final synchronized void i() {
        monitor-enter(this);
        this.f475074a = "0620010001";     // Catch: Throwable -> L6
        this.f475075b = "";     // Catch: Throwable -> L6
        this.f475073c = LoadType.SYSTEMWEBVIEW;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f475072d = new ConcurrentLinkedQueue();
    }

    public final boolean f() {
        if (this.f475073c != LoadType.SYSTEMWEBVIEW) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g() {
        if (this.f475073c != LoadType.TTWEBVIEW) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        monitor-enter(a.class);
        Iterator<InterfaceC5847a> r100 = f475072d.iterator();     // Catch: Throwable -> L10
    L6:
        if (r100.hasNext() == false) goto L8;
        r100.next().onLoadResultChanged(this);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // f17.b
    public final String toString() {
        return "LoadResult{mLoadType=" + this.f475073c + ", mCoreVersion=" + this.f475074a + ", mCoreMd5='" + this.f475075b + '}';
    }

    public a() {
        this.f475073c = LoadType.SYSTEMWEBVIEW;
    }

    public final synchronized void j(LoadInfo r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r100.e() == false) goto L6;
        this.f475073c = LoadType.SYSTEMWEBVIEW;     // Catch: Throwable -> L10
    L7:
        this.f475074a = r100.f475074a;     // Catch: Throwable -> L10
        this.f475075b = r100.f475075b;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        this.f475073c = LoadType.TTWEBVIEW;     // Catch: Throwable -> L10
        goto L7
    }
}
