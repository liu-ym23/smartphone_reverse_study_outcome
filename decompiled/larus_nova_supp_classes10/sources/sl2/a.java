package sl2;

import com.bytedance.android.livesdk.livehybrid.middleware.api.LiveHybridMethodLiveHybridMiddlewareProvider;
import com.bytedance.android.livesdk.livehybrid.middleware.api.LiveHybridMethodSoloKtvProvider;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends b {
    public static final List<b> a = null;
    public static final a b = null;

    static {
        b = new a();
        a = CollectionsKt.listOf(new b[]{(b) k.f(LiveHybridMethodLiveHybridMiddlewareProvider.class), (b) k.f(LiveHybridMethodSoloKtvProvider.class)});
    }

    public a() {
    }

    @Override // sl2.b
    public final void provideStatefulMethods(Map<String, f.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        b r1 = (b) r0.next();
        if (r1 == null) goto L4;
        r1.provideStatefulMethods(r3);
        goto L4
    }
}
