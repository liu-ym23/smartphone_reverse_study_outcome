package com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure;

import android.view.View;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f251876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<View, ba6.d> f251877b;

    public d(com.bytedance.kmp.ec.yata.view.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f251876a = r100;
        this.f251877b = new WeakHashMap();
    }

    public final void a(ba6.d r100, View r101) {
        this.f251877b.remove(r101);
        com.bytedance.kmp.ec.yata.view.render.delegate.g r102 = this.f251876a.d();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "view");
        Iterator<T> r103 = r102.f252017a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.kmp.ec.yata.view.render.delegate.e) r103.next()).b(r100, r101);
        goto L4
    }
}
