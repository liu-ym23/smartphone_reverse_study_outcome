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

/* JADX INFO: loaded from: classes10.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f542448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f542449b = null;

    static {
        f542449b = new a();
        f542448a = CollectionsKt.listOf(new b[]{(b) k.f(LiveHybridMethodLiveHybridMiddlewareProvider.class), (b) k.f(LiveHybridMethodSoloKtvProvider.class)});
    }

    public a() {
    }

    @Override // sl2.b
    public final void provideStatefulMethods(Map<String, f.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Iterator<T> r101 = f542448a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        b r102 = (b) r101.next();
        if (r102 == null) goto L4;
        r102.provideStatefulMethods(r100);
        goto L4
    }
}
