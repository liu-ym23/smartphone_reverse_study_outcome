package fw4;

import android.content.Context;
import com.bytedance.ee.bear.connection.NetworkType;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public static final Object d = null;
    public final Map<b, Object> a;
    public Context b;
    public NetworkType c;

    /* JADX INFO: renamed from: fw4.a$a, reason: collision with other inner class name */
    public static final class C0230a {
    }

    static {
        d = new Object();
    }

    public a() {
        this.a = new ConcurrentHashMap();
        this.c = NetworkType.NETWORK_NO;
    }

    public final void a(NetworkType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "networkType");
        Intrinsics.checkNotNullParameter(r3, "source");
        tt5.a.h("BaseNetStateChangeService", r3 + " size = " + ((ConcurrentHashMap) this.a).size() + ", netWorkType = " + r2.name());
        if (r2 != NetworkType.NETWORK_NO) goto L8;
        Iterator r4 = ((ConcurrentHashMap) this.a).keySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L12;
        ((b) r4.next()).a();
        goto L6
    L12:
        return;
    L8:
        Iterator r5 = ((ConcurrentHashMap) this.a).keySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        ((b) r5.next()).b(r2);
        goto L10
    }
}
