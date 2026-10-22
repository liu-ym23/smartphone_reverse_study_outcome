package f3;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Class<? extends AIBridgeMethod>> f475303a;

    public c() {
        this.f475303a = new ConcurrentHashMap();
    }

    public final void b(final Class<? extends AIBridgeMethod> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Map<Class<? extends AIBridgeMethod>, List<String>> r101 = m.f475322a;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Map<Class<? extends AIBridgeMethod>, List<String>> r103 = m.f475322a;     // Catch: Throwable -> L11
        Object r104 = ((ConcurrentHashMap) r103).get(r100);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        AIBridgeMethod r105 = r100.newInstance();     // Catch: Throwable -> L11
        LinkedHashSet r106 = new LinkedHashSet();     // Catch: Throwable -> L11
        r106.add(r105.getName());     // Catch: Throwable -> L11
        List<String> r107 = r105.getAltNames();     // Catch: Throwable -> L11
        if (r107 == null) goto L8;
        r106.addAll(r107);     // Catch: Throwable -> L11
    L8:
        r104 = CollectionsKt.toList(r106);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) r103).put(r100, r104);     // Catch: Throwable -> L11
    L9:
        Object r108 = Result.m9449constructorimpl((List) r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r108) == false) goto L16;
        r108 = null;
    L16:
        List r109 = (List) r108;
        if (r109 != null) goto L19;
        r109 = CollectionsKt.emptyList();
    L19:
        Iterator r110 = r109.iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        String r111 = (String) r110.next();
        this.f475303a.put(r111, r100);
        goto L21
    L23:
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, d> r112 = g.f475311a;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (g.f475311a.contains(r100) == true) goto L31;
        p2.c.c(new f(r100));
        return;
    L31:
        return;
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // f3.l
    public final AIBridgeMethod a(String r100, ContainerType r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "aiContainerType");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        return null;
    L9:
        Class<? extends AIBridgeMethod> r103 = this.f475303a.get(r100);
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.newInstance();
    L5:
        r102 = false;
        goto L7
    }
}
