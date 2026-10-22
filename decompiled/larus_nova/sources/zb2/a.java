package zb2;

import android.os.HandlerThread;
import com.bytedance.android.live.liveinteract.f;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f571124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f571125b = 0;

    static {
        if (f.f72794b == false) goto L5;
        int r100 = 0;
    L6:
        f571125b = r100;
        return;
    L5:
        r100 = -2;
        goto L6
    }

    public static HandlerThread a() {
        PthreadHandlerThreadV2 r100 = f571124a;
        if (r100 != null) goto L5;
    L8:
        PthreadHandlerThreadV2 r101 = f571124a;
        if (r101 == null) goto L11;
        r101.quit();
    L11:
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("publicScreenRender", f571125b);
        f571124a = r102;
        ThreadMethodProxy.start(r102);
        PthreadHandlerThreadV2 r103 = f571124a;
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        if (ThreadMethodProxy.isAlive(r100) != true) goto L8;
        PthreadHandlerThreadV2 r104 = f571124a;
        Intrinsics.checkNotNull(r104);
        return r104;
    }
}
