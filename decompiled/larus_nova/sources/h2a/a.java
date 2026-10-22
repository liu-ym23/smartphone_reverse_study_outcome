package h2a;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, String> f483633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f483634b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        this.f483633a = r100;
        this.f483634b = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Thread r101 = this.f483634b.newThread(r100);
        ThreadMethodProxy.setName(r101, this.f483633a.invoke(r101.getName()));
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
