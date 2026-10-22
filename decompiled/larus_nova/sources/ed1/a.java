package ed1;

import am2.x;
import by0.b;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import dw0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472185a = 0;

    static {
    }

    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (((Boolean) j.A.getValue(null, j.f90464a[24])).booleanValue() == false) goto L11;
        Map r102 = MapsKt.toMutableMap(r101);
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r102.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (b.a((String) r105.getValue()) == false) goto L6;
        r103.put(r105.getKey(), r105.getValue());
        goto L6
    L10:
        c.f470301b.c(r100, r103, CollectionsKt.emptyList());
        return;
    L11:
        HashMap<Class<?>, d<?>> r106 = f.f90457a;
        f.d(r100, r101, new Class[]{IRoom.class, x.class});
    }

    public static void b(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        HashMap<Class<?>, d<?>> r102 = f.f90457a;
        int r103 = 0;
        Class[] r104 = {IRoom.class, x.class};
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r104, "logClasses");
        LinkedHashMap r105 = new LinkedHashMap();
        LinkedHashSet r106 = new LinkedHashSet();
    L3:
        if (r103 >= 2) goto L5;
        f.a(r105, r106, r104[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        if (r101 == null) goto L7;
        r105.putAll(r101);
    L7:
        n r107 = new n();
        Map<String, String> r108 = r107.f516447a;
        Intrinsics.checkNotNullParameter(r108, "map");
        Intrinsics.checkNotNullParameter(r105, "map");
        r108.putAll(r105);
        m r109 = new m();
        Iterator r110 = r106.iterator();
    L9:
        if (r110.hasNext() == false) goto L11;
        r109.b((LogCommon) r110.next());
        goto L9
    L11:
        ((ArrayList) r107.f516448b).addAll(r109.f516446a);
        ((kr2.a) vh6.c.b(kr2.a.class)).Xj(r100, r107.f516447a, r107.f516448b);
    }
}
