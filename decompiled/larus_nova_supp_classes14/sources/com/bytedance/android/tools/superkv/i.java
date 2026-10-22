package com.bytedance.android.tools.superkv;

import android.util.LruCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final a a = null;
    public static transient boolean b;

    public static final class a {
        public final C0027a a;
        public String b;
        public int c;

        /* JADX INFO: renamed from: com.bytedance.android.tools.superkv.i$a$a, reason: collision with other inner class name */
        public class C0027a extends LruCache<String, d> {
            public C0027a() {
                super(8);
            }

            @Override // android.util.LruCache
            public final void entryRemoved(boolean r1, String r2, d r3, d r4) {
                r3.b.release();
            }
        }

        public a() {
            this.a = new C0027a();
        }
    }

    static {
        a = new a();
        b = false;
    }
}
