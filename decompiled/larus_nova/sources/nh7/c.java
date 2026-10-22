package nh7;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Pair<Boolean, SoftReference<?>>> f519188a;

    public c() {
        this.f519188a = new ConcurrentHashMap();
    }

    @Override // nh7.a
    public final boolean a(String r100) {
        Pair<Boolean, SoftReference<?>> r101 = this.f519188a.get(r100);
        if (r101 == null) goto L10;
        boolean r102 = r101.component1().booleanValue();
        SoftReference<?> r103 = r101.component2();
        if (r102 == false) goto L7;
    L8:
        return true;
    L7:
        if (r103.get() != null) goto L8;
        return false;
    L10:
        return false;
    }

    @Override // nh7.a
    public final Object get(String r100) {
        Pair<Boolean, SoftReference<?>> r101 = this.f519188a.get(r100);
        if (r101 == null) goto L7;
        SoftReference<?> r102 = r101.getSecond();
        if (r102 == null) goto L7;
        return r102.get();
    L7:
        return null;
    }

    @Override // nh7.a
    public final void put(String r100, Object r101) {
        ConcurrentHashMap<String, Pair<Boolean, SoftReference<?>>> r102 = this.f519188a;
        if (r101 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.put(r100, new Pair(Boolean.valueOf(r103), new SoftReference(r101)));
        return;
    L5:
        r103 = false;
        goto L6
    }
}
