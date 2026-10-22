package up5;

import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable$atomicInit$2;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f551044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f551045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC7912a f551046c;

    /* JADX INFO: renamed from: up5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7912a {
        void a();
    }

    public a() {
        WikiRouteTable$atomicInit$2.a r100 = WikiRouteTable$atomicInit$2.a.f241042a;
        this.f551044a = new AtomicBoolean(false);
        this.f551045b = new ReentrantLock();
        this.f551046c = r100;
    }
}
