package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g3 {
    public final AtomicReference<e3> a;

    public static class a {
        public static final g3 a = null;

        static {
            a = new g3();
        }
    }

    public g3() {
        this.a = new AtomicReference();
    }

    public final void a(e3 r2) {
        this.a.set(r2);
    }
}
