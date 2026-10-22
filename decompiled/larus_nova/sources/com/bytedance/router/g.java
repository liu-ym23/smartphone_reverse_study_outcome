package com.bytedance.router;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f267547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f267548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f267549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Class<? extends t97.b>> f267550d;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("scheme:");
        r100.append(this.f267547a);
        r100.append("\nother schemes: ");
        String[] r101 = this.f267548b;
        if (r101 != null) goto L5;
    L10:
        Map<String, Class<? extends t97.b>> r102 = this.f267550d;
        if (r102 == null) goto L13;
        int r103 = r102.size();
    L14:
        r100.append(String.format("other supported routes: %s routes\n", new Object[]{Integer.valueOf(r103)}));
        if (r103 <= 0) goto L21;
        Iterator<Map.Entry<String, Class<? extends t97.b>>> r104 = this.f267550d.entrySet().iterator();
    L18:
        if (r104.hasNext() == false) goto L21;
        Map.Entry<String, Class<? extends t97.b>> r105 = r104.next();
        r100.append("\t");
        r100.append(r105.getKey());
        r100.append(":");
        r100.append(r105.getValue().getName());
        r100.append('\n');
    L21:
        return r100.toString();
    L13:
        r103 = 0;
        goto L14
    L5:
        if (r101.length <= 0) goto L10;
        int r106 = r101.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r100.append(r101[r107]);
        r100.append(',');
        r107 = r107 + 1;
        goto L7
    L9:
        r100.append("\n");
        goto L10
    }

    public g(String r100) {
        this.f267550d = null;
        this.f267547a = r100;
        HashMap r101 = new HashMap();
        this.f267550d = r101;
        r101.put("bt.service", t97.e.class);
        this.f267550d.put("bt.broadcast", t97.c.class);
    }

    public final boolean a(String r100) {
        if (r100 != null) goto L5;
    L17:
        return true;
    L5:
        if (r100.length() == 0) goto L17;
        if (r100.equals(this.f267547a) == false) goto L10;
        return true;
    L10:
        Set<String> r101 = this.f267549c;
        if (r101 != null) goto L13;
        return false;
    L13:
        if (((HashSet) r101).contains(r100) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final void b(String[] r100) {
        this.f267548b = r100;
        if (r100.length != 0) goto L5;
        this.f267549c = null;
        return;
    L5:
        Set<String> r101 = this.f267549c;
        if (r101 == null) goto L8;
        ((HashSet) r101).clear();
    L9:
        this.f267549c.addAll(Arrays.asList(r100));
        return;
    L8:
        this.f267549c = new HashSet();
        goto L9
    }
}
