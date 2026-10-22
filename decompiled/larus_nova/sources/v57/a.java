package v57;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.platform.thread.b;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f553274a = 0;

    static {
        Iterator<Map.Entry<String, HandlerThread>> r100 = b.f266629a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if (ThreadMethodProxy.isAlive(r100.next().getValue()) == true) goto L4;
        r100.remove();
        goto L4
    L8:
        HashMap<String, HandlerThread> r101 = b.f266629a;
        HandlerThread r102 = r101.get("pool-monitor");
        if (r102 != null) goto L11;
        r102 = new b.a();
        ThreadMethodProxy.start(r102);
        r101.put("pool-monitor", r102);
    L11:
        new Handler(r102.getLooper());
    }
}
