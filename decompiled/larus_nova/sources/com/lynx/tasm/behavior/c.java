package com.lynx.tasm.behavior;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f381998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, a> f381999b;

    public c() {
        this.f381999b = null;
        this.f381998a = new HashMap();
    }

    public c(Map<String, a> r100) {
        this.f381999b = null;
        if (r100 != null) goto L5;
        this.f381998a = new HashMap();
        return;
    L5:
        this.f381998a = new HashMap(r100);
    }

    public final void a(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getName();
        a r102 = this.f381998a.get(r101);
        if (r102 == null) goto L7;
        r102.toString();
    L7:
        this.f381998a.put(r101, r100);
    }

    public final void b(List<a> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<a> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        a(r101.next());
        goto L6
    }

    public final a c(String r100) {
        Map<String, a> r101 = this.f381999b;
        if (r101 == null) goto L5;
        a r102 = r101.get(r100);
    L6:
        if (r102 != null) goto L8;
        r102 = this.f381998a.get(r100);
    L8:
        if (r102 == null) goto L11;
        return r102;
    L11:
        throw new RuntimeException("No BehaviorController defined for class " + r100);
    L5:
        r102 = null;
        goto L6
    }
}
