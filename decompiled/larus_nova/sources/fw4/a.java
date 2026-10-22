package fw4;

import android.content.Context;
import com.bytedance.ee.bear.connection.NetworkType;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f479002d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<b, Object> f479003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f479004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NetworkType f479005c;

    /* JADX INFO: renamed from: fw4.a$a, reason: collision with other inner class name */
    public static final class C5955a {
    }

    static {
        f479002d = new Object();
    }

    public a() {
        this.f479003a = new ConcurrentHashMap();
        this.f479005c = NetworkType.NETWORK_NO;
    }

    public final void a(NetworkType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "networkType");
        Intrinsics.checkNotNullParameter(r101, "source");
        tt5.a.h("BaseNetStateChangeService", r101 + " size = " + ((ConcurrentHashMap) this.f479003a).size() + ", netWorkType = " + r100.name());
        if (r100 != NetworkType.NETWORK_NO) goto L8;
        Iterator r102 = ((ConcurrentHashMap) this.f479003a).keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        ((b) r102.next()).a();
        goto L6
    L12:
        return;
    L8:
        Iterator r103 = ((ConcurrentHashMap) this.f479003a).keySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        ((b) r103.next()).b(r100);
        goto L10
    }
}
