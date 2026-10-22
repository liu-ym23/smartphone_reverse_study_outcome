package com.bytedance.ee.bear.document.onboarding;

import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<Class, tk5.d> f220701a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.onboarding.a$a, reason: collision with other inner class name */
    public static class C3144a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f220702a = null;

        static {
            f220702a = new a();
        }
    }

    public a() {
        this.f220701a = new ArrayMap(2);
    }

    public final void a(tk5.d r100) {
        tt5.a.h("DelayShowOnBoardingManager", "put ".concat(r100.getClass().getSimpleName()));
        this.f220701a.put(r100.getClass(), r100);
    }

    public final tk5.d b(Class r100) {
        tk5.d r101 = this.f220701a.remove(r100);
        if (r101 == null) goto L5;
        tt5.a.h("DelayShowOnBoardingManager", "remove success ".concat(r100.getSimpleName()));
    L6:
        return r101;
    L5:
        tt5.a.b("DelayShowOnBoardingManager", "has no element ".concat(r100.getSimpleName()));
        goto L6
    }
}
