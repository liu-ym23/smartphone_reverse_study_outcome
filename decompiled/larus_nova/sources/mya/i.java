package mya;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends g>, List<g>> f516435a;

    public i() {
        this.f516435a = new ConcurrentHashMap();
    }

    @Override // mya.h
    public final Map<Class<? extends g>, List<g>> f() {
        return this.f516435a;
    }

    @Override // mya.h
    public final <T extends g> T b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        List<g> r101 = this.f516435a.get(r100);
        if (r101 != null) goto L5;
    L10:
        return null;
    L5:
        if (r101.isEmpty() == true) goto L10;
        Object r102 = ListProtector.get(r101, 0);
        if ((r102 instanceof g) == false) goto L10;
        return (T) r102;
    }

    @Override // mya.h
    public final <T extends g> List<T> c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        List<g> r101 = this.f516435a.get(r100);
        if (r101 == null) goto L16;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        g r104 = (g) r103.next();
        if ((r104 instanceof g) == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L6;
        r102.add(r104);
        goto L6
    L13:
        List<T> r105 = CollectionsKt.toMutableList(r102);
        if (r105 == null) goto L16;
        return r105;
    L16:
        return new ArrayList();
    }

    @Override // mya.h
    public final <T extends g> boolean d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        List<g> r101 = this.f516435a.get(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        return !r101.isEmpty();
    }

    @Override // mya.h
    public final void e(h r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Map<Class<? extends g>, List<g>> r101 = r100.f();
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Class<? extends g>, List<g>>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<Class<? extends g>, List<g>> r103 = r102.next();
        List<g> r104 = this.f516435a.get(r103.getKey());
        if (r104 == null) goto L10;
        r104.addAll(r103.getValue());
        goto L7
    L10:
        this.f516435a.put(r103.getKey(), r103.getValue());
        goto L7
    }

    @Override // mya.h
    public final <T extends g> void a(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        Intrinsics.checkNotNullParameter(r101, "handlerInstance");
        List<g> r102 = this.f516435a.get(r100);
        if (r102 != null) goto L5;
        r102 = new ArrayList();
        this.f516435a.put(r100, r102);
    L5:
        ListProtector.add(r102, 0, r101);
    }
}
