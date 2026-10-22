package com.bytedance.jedi.ext.adapter.decorator.internal;

import android.util.SparseArray;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f250985a;

    public a() {
        this.f250985a = new SparseArray();
    }

    public final <T extends View> T a(int r100, View r101) {
        View r102 = this.f250985a.get(r100);
        if ((r102 instanceof View) == true) goto L5;
        r102 = null;
    L5:
        T r103 = (T) r102;
        if (r103 != null) goto L10;
        T r104 = (T) r101.findViewById(r100);
        this.f250985a.put(r100, r104);
        return r104;
    L10:
        return r103;
    }
}
