package km9;

import com.bytedance.ttnet.priority.ModePriorityManagement;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ModePriorityManagement> f504109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f504110b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f504111c = null;

    static {
        f504109a = new ConcurrentHashMap();
        f504110b = LazyKt.lazy(new a());
        f504111c = LazyKt.lazy(new b());
    }

    public static void a(String r110, HashMap r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r110, "key");
        if (r111 != null) goto L5;
        return;
    L5:
        if (r112 == null) goto L20;
        r112.intValue();
        if (r111.isEmpty() == false) goto L9;
        return;
    L9:
        if (r112.intValue() <= 0) goto L22;
        ConcurrentHashMap<String, ModePriorityManagement> r100 = f504109a;
        ModePriorityManagement r101 = r100.get(r110);
        if (r101 != null) goto L18;
        r101 = new ModePriorityManagement();
        r101.setStateName(r110);
        r101.setDelayDisableTimeMs(r112.intValue());
        Map<String, Integer> r102 = MapsKt.toMutableMap(r111);
        if (r102 != null) goto L17;
        r102 = MapsKt.emptyMap();
    L17:
        r101.initRequestSpeedController(r102, SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), -1, -1, -1, -1);
        r100.put(r110, r101);
    L18:
        TTHttpCallPriorityControl.getInstance().startAppStateFromCustom(r101);
        return;
    L22:
        return;
    }
}
