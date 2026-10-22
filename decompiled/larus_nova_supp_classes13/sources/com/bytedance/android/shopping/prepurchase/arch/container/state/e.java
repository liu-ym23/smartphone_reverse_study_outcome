package com.bytedance.android.shopping.prepurchase.arch.container.state;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface e<T> extends c<T> {

    public static final class a {
        public static void a(e r2, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r3, g r4) {
            com.bytedance.android.shopping.prepurchase.arch.container.state.a r0 = j.a;
            i<T> r1 = new i();
            r1.c = true;
            r2.b(r3, r1, r4);
        }
    }

    void b(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r1, i<T> r2, g<T> r3);
}
