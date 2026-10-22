package dl4;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PthreadHandlerThreadV2 f469113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f469114b = null;

    static {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("dora#wifi");
        f469113a = r100;
        ThreadMethodProxy.start(r100);
        f469114b = new Handler(r100.getLooper());
    }

    public static void a(Runnable r100) {
        f469114b.post(r100);
    }
}
