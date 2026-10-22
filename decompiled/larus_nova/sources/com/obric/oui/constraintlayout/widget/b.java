package com.obric.oui.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, HashSet<WeakReference<a>>> f400584a;

    public interface a {
    }

    public b() {
        new SparseIntArray();
        this.f400584a = new HashMap();
    }

    public final void a(int r100, a r101) {
        HashSet<WeakReference<a>> r102 = this.f400584a.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        r102 = new HashSet();
        this.f400584a.put(Integer.valueOf(r100), r102);
    L5:
        r102.add(new WeakReference(r101));
    }
}
