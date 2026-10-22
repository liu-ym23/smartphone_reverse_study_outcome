package com.bytedance.ee.bear.wikiv2.wikitreev2.notification;

import com.baidu.platform.comapi.map.MapController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends g>, CopyOnWriteArrayList<WeakReference<g>>> f241627a;

    public static final class a {
    }

    static {
    }

    public h() {
        this.f241627a = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(b.class, new CopyOnWriteArrayList()), TuplesKt.to(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new CopyOnWriteArrayList()), TuplesKt.to(f.class, new CopyOnWriteArrayList()), TuplesKt.to(d.class, new CopyOnWriteArrayList()), TuplesKt.to(e.class, new CopyOnWriteArrayList()), TuplesKt.to(c.class, new CopyOnWriteArrayList())});
    }

    public final <T extends g> void a(Class<? extends T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        CopyOnWriteArrayList<WeakReference<g>> r102 = this.f241627a.get(r100);
        if ((r102 instanceof CopyOnWriteArrayList) == false) goto L5;
        CopyOnWriteArrayList<WeakReference<g>> r103 = r102;
    L6:
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L23;
        WeakReference r105 = (WeakReference) r104.next();
        if (r105 == null) goto L9;
        g r106 = (g) r105.get();
        if (r106 == null) goto L9;
        r101.invoke(r106);
        goto L9
    L23:
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
