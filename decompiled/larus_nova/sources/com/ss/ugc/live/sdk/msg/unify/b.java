package com.ss.ugc.live.sdk.msg.unify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements kmc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, c> f458317a;

    public final List<c> b() {
        Collection<c> r100 = this.f458317a.values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((!Intrinsics.areEqual(((c) r103).h(), c.d.b.f458372a)) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    public final boolean d() {
        Collection<c> r100 = this.f458317a.values();
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L26;
        c r102 = (c) r101.next();
        if (Intrinsics.areEqual(r102.h(), c.d.C5493c.f458373a) == false) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L9;
        return true;
    L13:
        if (Intrinsics.areEqual(r102.h(), c.d.a.f458371a) == true) goto L16;
        r103 = false;
        goto L17
    L26:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    public b() {
        this.f458317a = new ConcurrentHashMap();
    }

    @Override // kmc.a
    public final imc.e a(long r100) {
        c r101 = c(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f458361f.c();
    }

    public final c c(long r100) {
        return this.f458317a.get(Long.valueOf(r100));
    }
}
