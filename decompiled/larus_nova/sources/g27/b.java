package g27;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExecutorService f479736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f479737b;

    public b(c r100, ExecutorService r101) {
        this.f479737b = r100;
        this.f479736a = r101;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        Object r103 = r101.invoke(this.f479736a, r102);
        this.f479737b.getClass();
        return r103;
    }
}
