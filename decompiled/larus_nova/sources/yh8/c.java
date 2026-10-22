package yh8;

import com.larus.im.bean.message.Message;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements yh8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f567618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Message f567619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f567620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<a> f567621d = null;

    public interface a {
        void a();
    }

    public c() {
    }

    @Override // yh8.a
    public final synchronized void a() {
        monitor-enter(this);
        f567619b = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        f567618a = new c();
        f567620c = "";
        f567621d = new ArrayList();
    }

    @Override // yh8.a
    public final Message b() {
        return f567619b;
    }
}
