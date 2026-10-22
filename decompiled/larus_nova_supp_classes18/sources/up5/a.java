package up5;

import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable$atomicInit$2;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final AtomicBoolean a;
    public final ReentrantLock b;
    public final InterfaceC0319a c;

    /* JADX INFO: renamed from: up5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0319a {
        void a();
    }

    public a() {
        WikiRouteTable$atomicInit$2.a r0 = WikiRouteTable$atomicInit$2.a.a;
        this.a = new AtomicBoolean(false);
        this.b = new ReentrantLock();
        this.c = r0;
    }
}
