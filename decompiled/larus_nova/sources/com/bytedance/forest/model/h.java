package com.bytedance.forest.model;

import com.bytedance.forest.model.h.a;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes19.dex */
public final class h<E extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f244337a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<a> f244338a;

        public a() {
            this.f244338a = new AtomicReference(null);
        }
    }

    public h() {
        this.f244337a = new a();
    }

    public final void a(HttpResponseCache r100) {
        r100.f244338a.set(null);
    L3:
        a r101 = this.f244337a.f244338a.get();
        r100.f244338a.set(r101);
        AtomicReference<a> r102 = this.f244337a.f244338a;
    L5:
        if (r102.compareAndSet(r101, r100) == true) goto L6;
        if (r102.get() == r101) goto L5;
        boolean r103 = false;
    L10:
        if (r103 == false) goto L3;
        return;
    L6:
        r103 = true;
        goto L10
    }
}
