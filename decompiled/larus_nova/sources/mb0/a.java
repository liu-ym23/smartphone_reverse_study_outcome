package mb0;

import com.bytedance.android.live.core.log.ALogger;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Long, LinkedList<g<T>>> f512757a;

    /* JADX INFO: renamed from: mb0.a$a, reason: collision with other inner class name */
    public static final class C6791a {
    }

    static {
    }

    public abstract long c(T r100);

    public abstract void d(String r100, T r101);

    public a() {
        this.f512757a = new HashMap();
    }

    public final LinkedList<g<T>> b(long r100) {
        LinkedList<g<T>> r101 = this.f512757a.get(Long.valueOf(r100));
        if (r101 != null) goto L6;
        LinkedList<g<T>> r102 = new LinkedList();
        String r103 = "new queue:" + r100;
        Intrinsics.checkNotNullParameter(r103, "content");
        ALogger.i("AbsChainMonitorQueue", r103);
        this.f512757a.put(Long.valueOf(r100), r102);
        return r102;
    L6:
        return r101;
    }

    public final void a(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        long r102 = c(r101);
        LinkedList<g<T>> r103 = b(r102);
        r103.add(new g(r100, r101));
        String r104 = "finish node,path：" + r100 + ", param:" + r101;
        Intrinsics.checkNotNullParameter(r104, "content");
        ALogger.w("AbsChainMonitorQueue", r104);
        g<T> r105 = r103.pollFirst();
    L3:
        if (r105 == null) goto L5;
        d(r105.f512761a, r105.f512762b);
        r105 = r103.pollFirst();
        goto L3
    L5:
        this.f512757a.remove(Long.valueOf(r102));
    }
}
