package com.bytedance.ies.ezresult;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f248608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Integer, Intent>> f248609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Function2<Integer, Intent, Unit>> f248610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f248611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String> f248612e;

    /* JADX INFO: renamed from: com.bytedance.ies.ezresult.a$a, reason: collision with other inner class name */
    public static final class C3553a {
    }

    static {
    }

    public a() {
        this.f248608a = true;
        this.f248609b = new ConcurrentHashMap();
        this.f248610c = new ConcurrentHashMap();
        this.f248611d = new ConcurrentHashMap();
        this.f248612e = new ConcurrentHashMap();
    }

    public final void a(String r100) {
        Integer r101 = this.f248611d.get(r100);
        this.f248610c.remove(r100);
        this.f248611d.remove(r100);
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        this.f248609b.remove(Integer.valueOf(r102));
        this.f248612e.remove(Integer.valueOf(r102));
        return;
    }

    public final void c(Bundle r100) {
        int r101 = 0;
        if (r100 == null) goto L12;
        ArrayList<Integer> r102 = r100.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS_EZ");
        ArrayList<String> r103 = r100.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS_EZ");
        if (r103 == null) goto L11;
        if (r102 == null) goto L15;
        int r104 = r103.size();
    L9:
        if (r101 >= r104) goto L16;
        ConcurrentHashMap<Integer, String> r105 = this.f248612e;
        Object r106 = ListProtector.get(r102, r101);
        r105.put((Integer) r106, (String) ListProtector.get(r103, r101));
        ConcurrentHashMap<String, Integer> r107 = this.f248611d;
        Object r108 = ListProtector.get(r103, r101);
        r107.put((String) r108, (Integer) ListProtector.get(r102, r101));
        r101 = r101 + 1;
        goto L9
    L16:
        return;
    L15:
        return;
    L11:
        return;
    L12:
        this.f248608a = false;
    }

    public final void d(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        r100.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS_EZ", new ArrayList(this.f248612e.keySet()));
        r100.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS_EZ", new ArrayList(this.f248612e.values()));
    }

    public final void b(int r100, int r101, Intent r102) {
        if (this.f248608a == true) goto L5;
        return;
    L5:
        String r103 = this.f248612e.get(Integer.valueOf(r100));
        if (r103 == null) goto L15;
        Function2<Integer, Intent, Unit> r104 = this.f248610c.remove(r103);
        if (r104 == null) goto L12;
        Unit r105 = r104.invoke(Integer.valueOf(r101), r102);
        if (r105 == null) goto L12;
        a(r103);
    L13:
        if (r105 == null) goto L15;
        return;
    L12:
        r105 = null;
    L15:
        this.f248609b.put(Integer.valueOf(r100), new Pair(Integer.valueOf(r101), r102));
        Unit r106 = Unit.INSTANCE;
    }
}
