package l3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f507201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f507202b = null;

    static {
        f507201a = LazyKt.lazy(new b());
        f507202b = LazyKt.lazy(new c());
    }

    public static ConcurrentHashMap a() {
        return (ConcurrentHashMap) f507202b.getValue();
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) a().get(r100);
        d(r101);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r101.isEmpty()) != true) goto L7;
        return true;
    }

    public static void c(a r110) {
        Intrinsics.checkNotNullParameter(r110, "aiBridgeEvent");
        if (r110.f507196a.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        long r101 = System.currentTimeMillis();
        ConcurrentSkipListSet r102 = new ConcurrentSkipListSet();
        Iterator r103 = ((CopyOnWriteArrayList) f507201a.getValue()).iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        a r104 = (a) r103.next();
        if (Math.abs(r101 - r104.f507198c) <= 10000) goto L10;
        r102.add(r104);
        goto L10
    L14:
        Iterator r105 = r102.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        a r106 = (a) r105.next();
        ((CopyOnWriteArrayList) f507201a.getValue()).remove(r106);
        goto L16
    L18:
        ((CopyOnWriteArrayList) f507201a.getValue()).add(r110);
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) a().get(r110.f507196a);
        d(r107);
        if (r107 == null) goto L24;
        Iterator r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L32;
        ((e) r108.next()).a(r110);
        goto L22
    L32:
        return;
    L24:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void d(CopyOnWriteArrayList r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L5:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L14;
        Object r104 = r102.next();
        if (((e) r104).f507207e.get() == null) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L5;
        r101.add(r104);
        goto L5
    L14:
        if ((!r101.isEmpty()) == false) goto L22;
        r100.removeAll(CollectionsKt.toSet(r101));
        return;
    }

    public static void e(e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) a().get(r101);
        if (r102 != null) goto L6;
        r102 = new CopyOnWriteArrayList();
        a().put(r101, r102);
    L21:
        d(r102);
        r102.add(r100);
        a().put(r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) f507201a.getValue()).iterator();
    L23:
        if (r103.hasNext() == false) goto L29;
        a r104 = (a) r103.next();
        if (Intrinsics.areEqual(r104.f507196a, r101) == false) goto L23;
        if (r100.f507205c >= r104.f507198c) goto L23;
        Intrinsics.checkNotNull(r104);
        r100.a(r104);
        goto L23
    L29:
        return;
    L6:
        if (r102.contains(r100) == false) goto L21;
        Iterator r105 = r102.iterator();
    L8:
        String r106 = null;
        if (r105.hasNext() == false) goto L13;
        Object r107 = r105.next();
        if (Intrinsics.areEqual(((e) r107).f507203a, r100.f507203a) == false) goto L8;
    L14:
        e r108 = (e) r107;
        if (r108 == null) goto L18;
        r106 = r108.f507206d;
    L18:
        if (Intrinsics.areEqual(r106, r100.f507206d) == true) goto L20;
        com.bytedance.ai.applet.base.log.a.c("AIBridgeEventCenter", "tag is different. remove old subscriber");
        r102.remove(r108);
        goto L21
    L20:
        return;
    L13:
        r107 = null;
        goto L14
    }
}
