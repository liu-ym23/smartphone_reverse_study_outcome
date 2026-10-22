package com.bytedance.applog.priority;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f192584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f192585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f192586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, b> f192587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f192588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Integer> f192589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f192590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f192591h;

    public final boolean a() {
        if (this.f192584a >= 0) goto L5;
        return false;
    L5:
        if (this.f192585b <= 0) goto L25;
        Map<Integer, b> r100 = this.f192587d;
        if (r100 != null) goto L10;
        return false;
    L10:
        if (r100.isEmpty() == false) goto L13;
        return false;
    L13:
        if (r100.containsKey(-1) == true) goto L15;
        return false;
    L15:
        b r101 = r100.get(-1);
        if (r101 != null) goto L18;
        return false;
    L18:
        if (r101.f192594c <= 0) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public a() {
        this.f192584a = 0;
        this.f192585b = 5;
        this.f192586c = -1;
        this.f192588e = new HashSet();
        this.f192591h = false;
    }

    public final void b(Map<Integer, b> r100) {
        this.f192587d = r100;
        ((HashSet) this.f192588e).clear();
        Map<Integer, b> r101 = this.f192587d;
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, b>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L24;
        Map.Entry<Integer, b> r103 = r102.next();
        if ((-1) == r103.getKey().intValue()) goto L7;
        b r104 = r103.getValue();
        if (r104 == null) goto L7;
        Map<String, List<Set<String>>> r105 = r104.f192596e;
        if (r105 != null) goto L17;
    L19:
        Map<String, List<Map<String, Object>>> r106 = r104.f192597f;
        if (r106 == null) goto L7;
        if (((HashMap) r106).isEmpty() == true) goto L7;
        this.f192588e.addAll(((HashMap) r104.f192597f).keySet());
        goto L7
    L17:
        if (((HashMap) r105).isEmpty() == true) goto L19;
        this.f192588e.addAll(((HashMap) r104.f192596e).keySet());
        goto L19
    }
}
