package uwc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f551961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<org.nanohttpd.protocols.http.a> f551962b;

    public a() {
        this.f551962b = Collections.synchronizedList(new ArrayList());
    }

    public final void a(org.nanohttpd.protocols.http.a r100) {
        this.f551962b.remove(r100);
    }

    public final void b(org.nanohttpd.protocols.http.a r100) {
        this.f551961a++;
        this.f551962b.add(r100);
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "DefaultAsyncRunner");
        r101.setDaemon(true);
        ThreadMethodProxy.setName(r101, "NanoHttpd Request Processor (#" + this.f551961a + ")");
        ThreadMethodProxy.start(r101);
    }
}
