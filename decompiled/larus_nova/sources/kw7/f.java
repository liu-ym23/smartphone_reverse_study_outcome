package kw7;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f506403c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f506404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lw7.c.a f506405b;

    static {
        f506403c = new f();
    }

    public f() {
        lw7.c r100 = lw7.c.f511037b;
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(lw7.c.f511038c, lw7.c.f511039d, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ice/tasks/q/g"));
        r101.allowCoreThreadTimeOut(true);
        this.f506404a = r101;
        this.f506405b = lw7.c.f511037b.f511040a;
    }
}
