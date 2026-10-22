package com.bytedance.ee.bear.document.onboarding;

import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final ArrayMap<Class, tk5.d> a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.onboarding.a$a, reason: collision with other inner class name */
    public static class C0088a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new ArrayMap(2);
    }

    public final void a(tk5.d r3) {
        tt5.a.h("DelayShowOnBoardingManager", "put ".concat(r3.getClass().getSimpleName()));
        this.a.put(r3.getClass(), r3);
    }

    public final tk5.d b(Class r4) {
        tk5.d r0 = (tk5.d) this.a.remove(r4);
        if (r0 == null) goto L5;
        tt5.a.h("DelayShowOnBoardingManager", "remove success ".concat(r4.getSimpleName()));
    L6:
        return r0;
    L5:
        tt5.a.b("DelayShowOnBoardingManager", "has no element ".concat(r4.getSimpleName()));
        goto L6
    }
}
